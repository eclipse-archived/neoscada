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
package org.eclipse.scada.sec.audit.log.slf4j;

import org.eclipse.scada.sec.AuthorizationReply;
import org.eclipse.scada.sec.AuthorizationRequest;
import org.eclipse.scada.sec.audit.AuditLogService;
import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

/**
 * @since 1.1
 */
public class LogServiceImpl implements AuditLogService
{

    private final static Logger logger = LoggerFactory.getLogger ( LogServiceImpl.class );

    @Override
    public void info ( final String message, final Object... arguments )
    {
        logger.info ( message, arguments );
    }

    @Override
    public void debug ( final String message, final Object... arguments )
    {
        logger.debug ( message, arguments );
    }

    @Override
    public void info ( final String message, final Throwable e, final Object... arguments )
    {
        logger.info ( MessageFormatter.arrayFormat ( message, arguments ).getMessage (), e );
    }

    @Override
    public void debug ( final String message, final Throwable e, final Object... arguments )
    {
        logger.debug ( MessageFormatter.arrayFormat ( message, arguments ).getMessage (), e );
    }

    @Override
    public void authorizationRequested ( final AuthorizationRequest request )
    {
        logger.info ( "Authorization requested - {}", request );
    }

    @Override
    public void authorizationFailed ( final AuthorizationContext context, final AuthorizationRequest request, final Throwable error )
    {
        logger.warn ( String.format ( "Authorization failed - %s", request ), error );
    }

    @Override
    public void authorizationDone ( final AuthorizationContext context, final AuthorizationRequest request, final AuthorizationReply reply )
    {
        if ( reply.isGranted () )
        {
            logger.info ( "Authorization granted - {} -> {}", request, reply );
        }
        else
        {
            logger.warn ( "Authorization rejected - {} -> {}", request, reply );
        }
    }
}
