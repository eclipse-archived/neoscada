/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi.impl;

import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.utils.DerivedAttributeAdapter;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.PasswordCredentials;
import org.eclipse.scada.configuration.world.UsernamePasswordCredentials;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.Connection;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl#getEndpointLabel <em>Endpoint Label</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl#getCredentials <em>Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ConnectionImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConnectionImpl extends MinimalEObjectImpl.Container implements Connection
{
    /**
     * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getEndpoint() <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpoint()
     * @generated
     * @ordered
     */
    protected Endpoint endpoint;

    /**
     * The default value of the '{@link #getEndpointLabel() <em>Endpoint Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpointLabel()
     * @generated
     * @ordered
     */
    protected static final String ENDPOINT_LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCredentials() <em>Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCredentials()
     * @generated
     * @ordered
     */
    protected Credentials credentials;

    /**
     * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected static final Integer TIMEOUT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected Integer timeout = TIMEOUT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected ConnectionImpl ()
    {
        super ();
        final DerivedAttributeAdapter adapter = new DerivedAttributeAdapter ( this, OsgiPackage.Literals.CONNECTION__ENDPOINT_LABEL );
        adapter.addNavigatedDependency ( OsgiPackage.Literals.CONNECTION__ENDPOINT, WorldPackage.Literals.ENDPOINT__PORT_NUMBER, WorldPackage.Literals.NAMED_DOCUMENTABLE__NAME );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return OsgiPackage.Literals.CONNECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getShortDescription ()
    {
        return shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setShortDescription ( String newShortDescription )
    {
        String oldShortDescription = shortDescription;
        shortDescription = newShortDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.CONNECTION__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.CONNECTION__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Endpoint getEndpoint ()
    {
        if ( endpoint != null && endpoint.eIsProxy () )
        {
            InternalEObject oldEndpoint = (InternalEObject)endpoint;
            endpoint = (Endpoint)eResolveProxy ( oldEndpoint );
            if ( endpoint != oldEndpoint )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.CONNECTION__ENDPOINT, oldEndpoint, endpoint ) );
            }
        }
        return endpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Endpoint basicGetEndpoint ()
    {
        return endpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEndpoint ( Endpoint newEndpoint )
    {
        Endpoint oldEndpoint = endpoint;
        endpoint = newEndpoint;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.CONNECTION__ENDPOINT, oldEndpoint, endpoint ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public String getEndpointLabel ()
    {
        final Endpoint ep = getEndpoint ();
        if ( ep == null )
        {
            return null;
        }
        else
        {
            return String.format ( "%s - Port: %s", ep.getName (), ep.getPortNumber () );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Credentials getCredentials ()
    {
        if ( credentials != null && credentials.eIsProxy () )
        {
            InternalEObject oldCredentials = (InternalEObject)credentials;
            credentials = (Credentials)eResolveProxy ( oldCredentials );
            if ( credentials != oldCredentials )
            {
                InternalEObject newCredentials = (InternalEObject)credentials;
                NotificationChain msgs = oldCredentials.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.CONNECTION__CREDENTIALS, null, null );
                if ( newCredentials.eInternalContainer () == null )
                {
                    msgs = newCredentials.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.CONNECTION__CREDENTIALS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.CONNECTION__CREDENTIALS, oldCredentials, credentials ) );
            }
        }
        return credentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials basicGetCredentials ()
    {
        return credentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCredentials ( Credentials newCredentials, NotificationChain msgs )
    {
        Credentials oldCredentials = credentials;
        credentials = newCredentials;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, OsgiPackage.CONNECTION__CREDENTIALS, oldCredentials, newCredentials );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setCredentials ( Credentials newCredentials )
    {
        if ( newCredentials != credentials )
        {
            NotificationChain msgs = null;
            if ( credentials != null )
                msgs = ( (InternalEObject)credentials ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.CONNECTION__CREDENTIALS, null, msgs );
            if ( newCredentials != null )
                msgs = ( (InternalEObject)newCredentials ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.CONNECTION__CREDENTIALS, null, msgs );
            msgs = basicSetCredentials ( newCredentials, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.CONNECTION__CREDENTIALS, newCredentials, newCredentials ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Integer getTimeout ()
    {
        return timeout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTimeout ( Integer newTimeout )
    {
        Integer oldTimeout = timeout;
        timeout = newTimeout;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.CONNECTION__TIMEOUT, oldTimeout, timeout ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getTypeTag ()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Endpoint> getPossibleEndpoints ( Exporter exporter )
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String makeUri ( boolean localhost )
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case OsgiPackage.CONNECTION__CREDENTIALS:
                return basicSetCredentials ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case OsgiPackage.CONNECTION__SHORT_DESCRIPTION:
                return getShortDescription ();
            case OsgiPackage.CONNECTION__NAME:
                return getName ();
            case OsgiPackage.CONNECTION__ENDPOINT:
                if ( resolve )
                    return getEndpoint ();
                return basicGetEndpoint ();
            case OsgiPackage.CONNECTION__ENDPOINT_LABEL:
                return getEndpointLabel ();
            case OsgiPackage.CONNECTION__CREDENTIALS:
                if ( resolve )
                    return getCredentials ();
                return basicGetCredentials ();
            case OsgiPackage.CONNECTION__TIMEOUT:
                return getTimeout ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case OsgiPackage.CONNECTION__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case OsgiPackage.CONNECTION__NAME:
                setName ( (String)newValue );
                return;
            case OsgiPackage.CONNECTION__ENDPOINT:
                setEndpoint ( (Endpoint)newValue );
                return;
            case OsgiPackage.CONNECTION__CREDENTIALS:
                setCredentials ( (Credentials)newValue );
                return;
            case OsgiPackage.CONNECTION__TIMEOUT:
                setTimeout ( (Integer)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case OsgiPackage.CONNECTION__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case OsgiPackage.CONNECTION__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case OsgiPackage.CONNECTION__ENDPOINT:
                setEndpoint ( (Endpoint)null );
                return;
            case OsgiPackage.CONNECTION__CREDENTIALS:
                setCredentials ( (Credentials)null );
                return;
            case OsgiPackage.CONNECTION__TIMEOUT:
                setTimeout ( TIMEOUT_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case OsgiPackage.CONNECTION__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case OsgiPackage.CONNECTION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case OsgiPackage.CONNECTION__ENDPOINT:
                return endpoint != null;
            case OsgiPackage.CONNECTION__ENDPOINT_LABEL:
                return ENDPOINT_LABEL_EDEFAULT == null ? getEndpointLabel () != null : !ENDPOINT_LABEL_EDEFAULT.equals ( getEndpointLabel () );
            case OsgiPackage.CONNECTION__CREDENTIALS:
                return credentials != null;
            case OsgiPackage.CONNECTION__TIMEOUT:
                return TIMEOUT_EDEFAULT == null ? timeout != null : !TIMEOUT_EDEFAULT.equals ( timeout );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case OsgiPackage.CONNECTION___GET_TYPE_TAG:
                return getTypeTag ();
            case OsgiPackage.CONNECTION___GET_POSSIBLE_ENDPOINTS__EXPORTER:
                return getPossibleEndpoints ( (Exporter)arguments.get ( 0 ) );
            case OsgiPackage.CONNECTION___MAKE_URI__BOOLEAN:
                return makeUri ( (Boolean)arguments.get ( 0 ) );
            case OsgiPackage.CONNECTION___GET_MATCHING_ENDPOINT__EXPORTER:
                return getMatchingEndpoint ( (Exporter)arguments.get ( 0 ) );
            case OsgiPackage.CONNECTION___GET_FACTORY_ID:
                return getFactoryId ();
        }
        return super.eInvoke ( operationID, arguments );
    }

    @Override
    public Endpoint getMatchingEndpoint ( final Exporter exporter )
    {
        final EList<Endpoint> result = getPossibleEndpoints ( exporter );
        if ( result.contains ( getEndpoint () ) )
        {
            return getEndpoint ();
        }
        else
        {
            return null;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFactoryId ()
    {
        return getTypeTag () + ".connection";
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (shortDescription: " ); //$NON-NLS-1$
        result.append ( shortDescription );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", timeout: " ); //$NON-NLS-1$
        result.append ( timeout );
        result.append ( ')' );
        return result.toString ();
    }

    protected String makeBasicUri ( final boolean localhost, final String type, final String proto )
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( type );
        sb.append ( ':' );
        sb.append ( proto );
        sb.append ( "://" );

        String username = null;
        String password = null;

        if ( this.credentials instanceof PasswordCredentials )
        {
            password = ( (PasswordCredentials)this.credentials ).getPassword ();
        }
        else if ( this.credentials instanceof UsernamePasswordCredentials )
        {
            username = ( (UsernamePasswordCredentials)this.credentials ).getUsername ();
            password = ( (UsernamePasswordCredentials)this.credentials ).getPassword ();
        }

        boolean hasCreds = false;
        try
        {
            if ( username != null && !username.isEmpty () )
            {
                hasCreds = true;
                sb.append ( URLEncoder.encode ( username, "UTF-8" ) );
            }
            if ( password != null && !password.isEmpty () )
            {
                hasCreds = true;
                sb.append ( ':' );
                sb.append ( URLEncoder.encode ( password, "UTF-8" ) );
            }

            if ( hasCreds )
            {
                sb.append ( '@' );
            }

            if ( localhost )
            {
                sb.append ( "localhost" );
            }
            else
            {
                sb.append ( this.endpoint.getNode ().getHostName () );
            }

            sb.append ( ':' );
            sb.append ( this.endpoint.getPortNumber () );

            final Map<String, String> properties = new HashMap<String, String> ();

            if ( this.timeout != null )
            {
                properties.put ( "timeout", this.timeout.toString () );
            }

            if ( !properties.isEmpty () )
            {
                sb.append ( "?" );
                for ( final Map.Entry<String, String> entry : properties.entrySet () )
                {
                    sb.append ( URLEncoder.encode ( entry.getKey (), "UTF-8" ) );
                    if ( entry.getValue () != null )
                    {
                        sb.append ( '=' );
                        sb.append ( URLEncoder.encode ( entry.getValue (), "UTF-8" ) );
                    }
                }
            }

        }
        catch ( final Throwable e )
        {
            throw new RuntimeException ( e );
        }

        return sb.toString ();
    }

} //ConnectionImpl
