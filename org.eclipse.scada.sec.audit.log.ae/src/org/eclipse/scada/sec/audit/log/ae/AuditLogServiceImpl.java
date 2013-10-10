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
package org.eclipse.scada.sec.audit.log.ae;

import java.util.Date;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ae.event.EventService;
import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.audit.AuditLogService;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.statuscodes.CodedExceptionBase;
import org.eclipse.scada.utils.statuscodes.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

public class AuditLogServiceImpl implements AuditLogService
{

    private final static Logger logger = LoggerFactory.getLogger ( AuditLogServiceImpl.class );

    private static final String PROP_ENABLE_DEBUG = "org.eclipse.scada.sec.audit.log.ae.debug";

    private static final String PROP_LOG_ALL = "org.eclipse.scada.sec.audit.log.ae.logAll";

    private EventService eventService;

    public void setEventService ( final EventService eventService )
    {
        this.eventService = eventService;
    }

    protected void log ( final Severity severity, final AuthorizationContext context, final String message, final AuthorizationRequest request, final AuthorizationReply reply, final String value, final Throwable error )
    {
        final EventBuilder evt = Event.create ();

        final Date now = new Date ();

        evt.entryTimestamp ( now );
        evt.sourceTimestamp ( now );

        evt.attribute ( Event.Fields.MESSAGE, message );
        if ( request != null )
        {
            evt.attribute ( Event.Fields.ACTOR_TYPE, request.getObjectType () );
            evt.attribute ( Event.Fields.ACTOR_NAME, request.getObjectId () );
            evt.attribute ( Event.Fields.ITEM, request.getAction () );

            evt.attribute ( Event.Fields.EVENT_TYPE, "SEC" );
            evt.attribute ( Event.Fields.MONITOR_TYPE, "AUDIT" );
        }

        if ( value != null )
        {
            evt.attribute ( Event.Fields.VALUE, value );
        }

        if ( error != null )
        {
            evt.attribute ( "errorInformation", ExceptionHelper.formatted ( error ) );
        }

        if ( context != null )
        {
            evt.attribute ( "signature", context.getContext ().get ( "signature" ) );
            evt.attribute ( "failedSignature", context.getContext ().get ( "failedSignature" ) );
        }

        final Event event = evt.build ();

        logger.debug ( "Publishing event: {}", event );

        this.eventService.publishEvent ( event );
    }

    protected void log ( final Severity severity, final String message, final Throwable error )
    {
        log ( severity, null, message, null, null, getStatusCode ( error ), error );
    }

    @Override
    public void info ( final String message, final Object... arguments )
    {
        log ( Severity.INFORMATION, MessageFormatter.arrayFormat ( message, arguments ).getMessage (), null );
    }

    @Override
    public void debug ( final String message, final Object... arguments )
    {
        if ( Boolean.getBoolean ( PROP_ENABLE_DEBUG ) )
        {
            log ( Severity.INFORMATION, MessageFormatter.arrayFormat ( message, arguments ).getMessage (), null );
        }
    }

    @Override
    public void info ( final String message, final Throwable e, final Object... arguments )
    {
        log ( Severity.INFORMATION, MessageFormatter.arrayFormat ( message, arguments ).getMessage (), e );
    }

    @Override
    public void debug ( final String message, final Throwable e, final Object... arguments )
    {
        if ( Boolean.getBoolean ( PROP_ENABLE_DEBUG ) )
        {
            log ( Severity.INFORMATION, MessageFormatter.arrayFormat ( message, arguments ).getMessage (), e );
        }
    }

    @Override
    public void authorizationRequested ( final AuthorizationRequest request )
    {
        if ( Boolean.getBoolean ( PROP_LOG_ALL ) )
        {
            log ( Severity.INFORMATION, "Authorization requested", null );
        }
    }

    @Override
    public void authorizationFailed ( final AuthorizationContext context, final AuthorizationRequest request, final Throwable error )
    {
        log ( Severity.ERROR, context, "Authorization failed", request, null, getStatusCode ( error ), error );
    }

    protected String getStatusCode ( final Throwable error )
    {
        if ( error == null )
        {
            return null;
        }

        final Throwable root = ExceptionHelper.getRootCause ( error );
        if ( root instanceof CodedExceptionBase )
        {
            final StatusCode statusCode = ( (CodedExceptionBase)root ).getStatus ();
            if ( statusCode != null )
            {
                return statusCode.toString ();
            }
        }
        return null;
    }

    @Override
    public void authorizationDone ( final AuthorizationContext context, final AuthorizationRequest request, final AuthorizationReply reply )
    {
        if ( reply.isGranted () && Boolean.getBoolean ( PROP_LOG_ALL ) )
        {
            log ( Severity.INFORMATION, context, "Authorization granted", request, reply, null, null );
        }
        else if ( !reply.isGranted () )
        {
            log ( Severity.WARNING, context, "Authorization rejected", request, reply, null, null );
        }
    }

}
