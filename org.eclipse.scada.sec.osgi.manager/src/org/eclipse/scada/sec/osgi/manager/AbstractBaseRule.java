/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.osgi.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.AuthorizationResult;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.sec.authz.AuthorizationRule;
import org.eclipse.scada.utils.concurrent.InstantErrorFuture;
import org.eclipse.scada.utils.concurrent.InstantFuture;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public abstract class AbstractBaseRule implements AuthorizationRule
{

    private static final InstantFuture<AuthorizationResult> ABSTAIN_FUTURE = new InstantFuture<AuthorizationResult> ( null );

    private final static Logger logger = LoggerFactory.getLogger ( AbstractBaseRule.class );

    private Pattern objectId;

    private Pattern objectType;

    private Pattern action;

    private final ScriptEngineManager engineManager;

    private ScriptExecutor scriptFilter;

    public AbstractBaseRule ()
    {
        this.engineManager = new ScriptEngineManager ( AbstractBaseRule.class.getClassLoader () );
    }

    @Override
    public void dispose ()
    {
        // no-op
    }

    public void setPreFilter ( final Map<String, String> properties ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );

        if ( properties != null )
        {
            setPreFilter ( properties.get ( "for.id" ), properties.get ( "for.type" ), properties.get ( "for.action" ) );
        }

        final String script = properties.get ( "filter.script" );
        if ( script != null && !script.isEmpty () )
        {
            this.scriptFilter = new ScriptExecutor ( this.engineManager, cfg.getString ( "filter.script.engine", "JavaScript" ), script, AbstractBaseRule.class.getClassLoader () );
        }
    }

    protected void setPreFilter ( final String idFilter, final String typeFilter, final String actionFilter )
    {
        if ( idFilter != null )
        {
            this.objectId = Pattern.compile ( idFilter );
        }
        else
        {
            this.objectId = null;
        }

        if ( typeFilter != null )
        {
            this.objectType = Pattern.compile ( typeFilter );
        }
        else
        {
            this.objectType = null;
        }

        if ( actionFilter != null )
        {
            this.action = Pattern.compile ( actionFilter );
        }
        else
        {
            this.action = null;
        }
    }

    @Override
    public NotifyFuture<AuthorizationResult> authorize ( final AuthorizationContext context )
    {
        final AuthorizationRequest request = context.getRequest ();

        logger.debug ( "Checking authentication - objectType: {}, objectId: {}, action: {}, user: {}, context: {}", new Object[] { request.getObjectType (), request.getObjectId (), request.getAction (), request.getUserInformation (), request.getContext () } ); //$NON-NLS-1$
        logger.debug ( "Pre-Filter - objectType: {}, objectId: {}, action: {}", new Object[] { this.objectType, this.objectId, this.action } ); //$NON-NLS-1$

        if ( request != null && request.getObjectId () != null && this.objectId != null && !this.objectId.matcher ( request.getObjectId () ).matches () )
        {
            return ABSTAIN_FUTURE;
        }

        if ( request != null && request.getObjectType () != null && this.objectType != null && !this.objectType.matcher ( request.getObjectType () ).matches () )
        {
            return ABSTAIN_FUTURE;
        }

        if ( request != null && request.getAction () != null && this.action != null && !this.action.matcher ( request.getAction () ).matches () )
        {
            return ABSTAIN_FUTURE;
        }

        try
        {
            if ( this.scriptFilter != null && matchesScriptFilter ( context ) )
            {
                return ABSTAIN_FUTURE;
            }
        }
        catch ( final Exception e )
        {
            return new InstantErrorFuture<AuthorizationResult> ( e );
        }

        return procesAuthorize ( context );
    }

    private boolean matchesScriptFilter ( final AuthorizationContext context ) throws Exception
    {
        logger.debug ( "Running script filter for request: {}", context );

        final ScriptContext ctx = new SimpleScriptContext ();

        final Map<String, Object> bindings = new HashMap<String, Object> ();

        bindings.put ( "authorizationContext", context ); //$NON-NLS-1$
        bindings.put ( "request", context.getRequest () ); //$NON-NLS-1$

        return processResult ( this.scriptFilter.execute ( ctx, bindings ) );
    }

    private boolean processResult ( final Object execute )
    {
        logger.debug ( "Processing filter result: {}", execute );

        if ( execute == null )
        {
            return false;
        }
        if ( execute instanceof Boolean )
        {
            return (Boolean)execute;
        }
        if ( execute instanceof Number )
        {
            return ( (Number)execute ).intValue () != 0;
        }

        return Boolean.parseBoolean ( execute.toString () );
    }

    protected abstract NotifyFuture<AuthorizationResult> procesAuthorize ( AuthorizationContext context );

    public Pattern getActionFilter ()
    {
        return this.action;
    }

    public Pattern getIdFilter ()
    {
        return this.objectId;
    }

    public Pattern getTypeFilter ()
    {
        return this.objectType;
    }

    public ScriptExecutor getScriptFilter ()
    {
        return this.scriptFilter;
    }
}
