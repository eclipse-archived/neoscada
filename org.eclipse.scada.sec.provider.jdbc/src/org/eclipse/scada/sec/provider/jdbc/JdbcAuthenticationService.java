/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.sec.provider.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.sec.AuthenticationException;
import org.eclipse.scada.sec.AuthenticationService;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.sec.UserManagerService;
import org.eclipse.scada.sec.authn.CredentialsRequest;
import org.eclipse.scada.sec.utils.password.PasswordEncoder;
import org.eclipse.scada.sec.utils.password.PasswordEncoding;
import org.eclipse.scada.sec.utils.password.PasswordType;
import org.eclipse.scada.sec.utils.password.PasswordValidator;
import org.eclipse.scada.utils.collection.MapBuilder;
import org.eclipse.scada.utils.osgi.SingleServiceListener;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceConnectionAccessor;
import org.eclipse.scada.utils.osgi.jdbc.DataSourceFactoryTracker;
import org.eclipse.scada.utils.osgi.jdbc.data.RowMapperAdapter;
import org.eclipse.scada.utils.osgi.jdbc.data.RowMapperMappingException;
import org.eclipse.scada.utils.osgi.jdbc.task.CommonConnectionTask;
import org.eclipse.scada.utils.osgi.jdbc.task.ConnectionContext;
import org.eclipse.scada.utils.osgi.jdbc.task.RowCallback;
import org.eclipse.scada.utils.statuscodes.SeverityLevel;
import org.eclipse.scada.utils.statuscodes.StatusCode;
import org.eclipse.scada.utils.str.StringHelper;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jdbc.DataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcAuthenticationService implements AuthenticationService, UserManagerService
{

    private static final StatusCode NO_ACCESSOR = new StatusCode ( "OSSEC", "JDBC", 0x0001, SeverityLevel.ERROR );

    private static final StatusCode INTERNAL_ERROR = new StatusCode ( "OSSEC", "JDBC", 0x0002, SeverityLevel.ERROR );

    private final static Logger logger = LoggerFactory.getLogger ( JdbcAuthenticationService.class );;

    private final String id;

    private final BundleContext context;

    private String driver;

    private DataSourceFactoryTracker tracker;

    private Properties connectionProperties;

    private DataSourceConnectionAccessor accessor;

    private final ReadWriteLock accessorLock = new ReentrantReadWriteLock ();

    private final Lock readLock = this.accessorLock.readLock ();

    private final Lock writeLock = this.accessorLock.writeLock ();

    public class PasswordCheckRowCallback implements RowCallback
    {
        private boolean result;

        private final Map<PasswordEncoding, String> passwords;

        private final String userIdColumnName;

        private String userId;

        private final String passwordColumnName;

        public PasswordCheckRowCallback ( final Map<PasswordEncoding, String> passwords, final String passwordColumnName, final String userIdColumnName )
        {
            this.passwords = passwords;
            this.userIdColumnName = userIdColumnName;
            this.passwordColumnName = passwordColumnName;
        }

        public boolean isResult ()
        {
            return this.result;
        }

        public String getUserId ()
        {
            return this.userId;
        }

        @Override
        public void processRow ( final ResultSet resultSet ) throws SQLException
        {
            final String storedPassword = resultSet.getString ( this.passwordColumnName );

            if ( storedPassword == null || storedPassword.isEmpty () )
            {
                return;
            }

            if ( validatePassword ( this.passwords, storedPassword ) )
            {
                if ( this.userIdColumnName != null )
                {
                    this.userId = resultSet.getString ( this.userIdColumnName );
                }
                this.result = true;
            }
        }
    }

    /**
     * Mark this service as authoritative.
     */
    private boolean authoritative;

    private PasswordValidator passwordValidator;

    private String findUserSql;

    private String findRolesForUserSql;

    private String updatePasswordSql;

    private PasswordEncoder passwordEncoder;

    private String userIdColumnName;

    private String passwordColumnName;

    public JdbcAuthenticationService ( final BundleContext context, final String id )
    {
        this.context = context;
        this.id = id;
    }

    @Override
    public void joinRequest ( final CredentialsRequest request )
    {
        request.askUsername ();
        request.askPassword ( this.passwordValidator.getSupportedInputEncodings () );
    }

    @Override
    public UserInformation authenticate ( final CredentialsRequest request ) throws AuthenticationException
    {
        final String username = request.getUserName ();

        try
        {
            this.readLock.lock ();
            if ( this.accessor == null )
            {
                logger.info ( "We don't have any accessor" );
                return failure ( "No connection to database", NO_ACCESSOR );
            }

            try
            {
                return this.accessor.doWithConnection ( new CommonConnectionTask<UserInformation> () {
                    @Override
                    public UserInformation performTask ( final ConnectionContext connection ) throws Exception
                    {
                        return performAuthentication ( connection, username, request.getPasswords () );
                    }
                } );
            }
            catch ( final Exception e )
            {
                if ( e.getCause () instanceof AuthenticationException )
                {
                    logger.info ( "Task throw exception. Rethrowing cause...", e );
                    throw (AuthenticationException)e.getCause ();
                }
                else
                {
                    logger.warn ( "Failed to perform login", e );
                    throw new AuthenticationException ( INTERNAL_ERROR, e );
                }
            }
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    protected UserInformation performAuthentication ( final ConnectionContext connection, final String username, final Map<PasswordEncoding, String> passwords ) throws AuthenticationException, SQLException
    {
        final PasswordCheckRowCallback callback = new PasswordCheckRowCallback ( passwords, this.passwordColumnName, this.userIdColumnName );
        connection.query ( callback, this.findUserSql, new MapBuilder<String, Object> ().put ( "USER_ID", username ).getMap () );

        if ( !callback.isResult () )
        {
            // no user found ... abstain
            return null;
        }

        final String userId = this.userIdColumnName != null ? callback.getUserId () : username;
        logger.trace ( "Using user id: {}", userId );

        final List<String> roles;

        if ( this.findRolesForUserSql != null && !this.findRolesForUserSql.isEmpty () )
        {
            roles = connection.queryForList ( String.class, this.findRolesForUserSql, new MapBuilder<String, Object> ().put ( "USER_ID", userId ).getMap () );
        }
        else
        {
            roles = null;
        }

        logger.trace ( "Found roles for user: {}", roles );

        return new UserInformation ( username, roles );
    }

    protected boolean validatePassword ( final Map<PasswordEncoding, String> providedPasswords, final String storedPassword )
    {
        try
        {
            return this.passwordValidator.validatePassword ( providedPasswords, storedPassword );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to validate password", e );
            return false;
        }
    }

    private UserInformation failure ( final String message, final StatusCode statusCode ) throws AuthenticationException
    {
        if ( this.authoritative )
        {
            throw new AuthenticationException ( statusCode, message );
        }

        logger.warn ( "Failed to authenticate non-authoritative with error: {}", statusCode );
        return null;
    }

    public void dispose ()
    {
        detach ();
    }

    @Override
    public UserInformation getUser ( final String username )
    {
        this.readLock.lock ();
        try
        {
            if ( this.accessor == null )
            {
                logger.info ( "We don't have any accessor" );
                return null;
            }

            try
            {
                return this.accessor.doWithConnection ( new CommonConnectionTask<UserInformation> () {
                    @Override
                    public UserInformation performTask ( final ConnectionContext connection ) throws Exception
                    {
                        return performLookup ( connection, username );
                    }
                } );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to perform lookup", e );
                return null;
            }
        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    protected UserInformation performLookup ( final ConnectionContext connection, final String username ) throws SQLException
    {
        /*
         * We use the same query as for the password here. Only that we dump the whole checking and simple return the user entry if one was found.
         */
        final List<String> entries = connection.query ( new RowMapperAdapter<String> () {
            @Override
            public String mapRow ( final ResultSet resultSet ) throws SQLException, RowMapperMappingException
            {
                if ( JdbcAuthenticationService.this.userIdColumnName == null )
                {
                    return ""; // no username from SQL
                }
                else
                {
                    return resultSet.getString ( JdbcAuthenticationService.this.userIdColumnName );
                }
            }
        }, this.findUserSql, new MapBuilder<String, Object> ().put ( "USER_ID", username ).getMap () );

        if ( entries.isEmpty () )
        {
            return null;
        }

        final String userId = this.userIdColumnName != null ? entries.get ( 0 ) : username;
        logger.trace ( "Using '{0}' as user id", userId );

        final List<String> roles;

        if ( this.findRolesForUserSql != null && !this.findRolesForUserSql.isEmpty () )
        {
            roles = connection.queryForList ( String.class, this.findRolesForUserSql, new MapBuilder<String, Object> ().put ( "USER_ID", userId ).getMap () );
        }
        else
        {
            roles = null;
        }

        logger.trace ( "Found roles for user: {}", roles );

        return new UserInformation ( userId, roles );
    }

    public void update ( final Map<String, String> parameters ) throws Exception
    {
        logger.debug ( "Updating configuration" );

        // detach first

        detach ();

        // setup

        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        this.driver = cfg.getStringChecked ( "driver", "Need database driver name in 'driver'" );
        this.connectionProperties = new Properties ();
        this.connectionProperties.putAll ( cfg.getPrefixed ( "jdbc.properties." ) );
        final PasswordType passwordType = cfg.getEnumChecked ( "passwordType", PasswordType.class, String.format ( "Need 'passwordType' to be one of (%s)", StringHelper.join ( PasswordType.values (), ", " ) ) );
        this.passwordValidator = passwordType.createValdiator ();
        this.passwordEncoder = passwordType.createEncoder ();
        this.authoritative = cfg.getBoolean ( "authoritative", true );
        this.findUserSql = cfg.getStringChecked ( "findUserSql", "Need 'findUserSql' to be set" );
        this.findRolesForUserSql = cfg.getString ( "findRolesForUserSql" );
        this.updatePasswordSql = cfg.getString ( "updatePasswordSql" );
        this.userIdColumnName = cfg.getString ( "userIdColumnName" );
        this.passwordColumnName = cfg.getString ( "passwordColumnName", "password" );

        // now attach

        attach ();
    }

    private void attach () throws InvalidSyntaxException
    {
        logger.debug ( "Creating data source tracker: {}", this.driver );
        this.tracker = new DataSourceFactoryTracker ( this.context, this.driver, new SingleServiceListener<DataSourceFactory> () {

            @Override
            public void serviceChange ( final ServiceReference<DataSourceFactory> reference, final DataSourceFactory service )
            {
                setDataSource ( service );
            }
        } );
        this.tracker.open ();
    }

    private void detach ()
    {
        if ( this.tracker != null )
        {
            this.tracker.close ();
            this.tracker = null;
        }
    }

    protected void setDataSource ( final DataSourceFactory service )
    {
        logger.debug ( "Setting data source: {}", service );
        try
        {
            this.writeLock.lock ();

            if ( this.accessor != null )
            {
                this.accessor.dispose ();
                this.accessor = null;
            }

            try
            {
                if ( service != null )
                {
                    this.accessor = new DataSourceConnectionAccessor ( service, this.connectionProperties );
                }
            }
            catch ( final SQLException e )
            {
                logger.error ( "Failed to create datasource for " + this.id, e );
            }
        }
        finally
        {
            this.writeLock.unlock ();
        }
    }

    public boolean isUserManager ()
    {
        return this.updatePasswordSql != null && !this.updatePasswordSql.isEmpty ();
    }

    @Override
    public void setPassword ( final String user, final String password )
    {

        try
        {
            this.readLock.lock ();

            if ( this.accessor == null )
            {
                logger.info ( "We don't have any accessor" );
                throw new IllegalStateException ( "User manager does not have a database connection" );
            }

            this.accessor.doWithConnection ( new CommonConnectionTask<Void> () {

                @Override
                protected Void performTask ( final ConnectionContext connection ) throws Exception
                {
                    connection.setAutoCommit ( false );
                    handleSetPassword ( connection, user, password );
                    connection.commit ();
                    return null;
                }
            } );

        }
        finally
        {
            this.readLock.unlock ();
        }
    }

    protected void handleSetPassword ( final ConnectionContext connection, final String user, final String password ) throws Exception
    {
        final String encodedPassword = this.passwordEncoder.encodePassword ( password );

        final Map<String, String> parameters = new HashMap<String, String> ();
        parameters.put ( "USER_NAME", user );
        parameters.put ( "PASSWORD", encodedPassword );

        final int count = connection.update ( this.updatePasswordSql, parameters );
        logger.info ( "Updated password for user {} => {}", user, count );
        if ( count != 1 )
        {
            throw new IllegalStateException ( count < 1 ? String.format ( "User '%s' was not found", user ) : "Too many entries" );
        }
    }
}
