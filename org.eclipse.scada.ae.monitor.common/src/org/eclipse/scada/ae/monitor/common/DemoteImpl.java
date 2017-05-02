/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.common;

import java.util.Map;

import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.sec.UserInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoteImpl
{

    private final static Logger logger = LoggerFactory.getLogger ( DemoteImpl.class );

    private static final String CONTEXT_KEY_DEMOTE_TO_SEVERITY_SUFFIX = "severity";

    private static final String CONTEXT_KEY_DEMOTE_TO_OK_SUFFIX = "ok";

    private static final String CONTEXT_KEY_DEMOTE_TO_INFORMATION_SUFFIX = "information";

    private static final String CONTEXT_KEY_DEMOTE_TO_WARNING_SUFFIX = "warning";

    private static final String CONTEXT_KEY_DEMOTE_TO_ALARM_SUFFIX = "alarm";

    private static final String CONTEXT_KEY_DEMOTE_TO_ACK_SUFFIX = "ack";

    private Severity severityLimit;

    private String demotePrefix;

    private boolean demoteAck;

    public void handleDataUpdate ( final Map<String, Object> context, final DataItemValue.Builder value )
    {
        this.severityLimit = extractSeverity ( context );
        this.demoteAck = false;

        if ( this.demotePrefix != null )
        {
            if ( isKey ( CONTEXT_KEY_DEMOTE_TO_OK_SUFFIX, context ) )
            {
                this.severityLimit = null;
            }
            else if ( isKey ( CONTEXT_KEY_DEMOTE_TO_INFORMATION_SUFFIX, context ) )
            {
                this.severityLimit = Severity.INFORMATION;
            }
            else if ( isKey ( CONTEXT_KEY_DEMOTE_TO_WARNING_SUFFIX, context ) )
            {
                this.severityLimit = Severity.WARNING;
            }
            else if ( isKey ( CONTEXT_KEY_DEMOTE_TO_ALARM_SUFFIX, context ) )
            {
                this.severityLimit = Severity.ALARM;
            }
            if ( isKey ( CONTEXT_KEY_DEMOTE_TO_ACK_SUFFIX, context ) )
            {
                this.demoteAck = true;
            }
        }
    }

    public void update ( final UserInformation userInformation, final Map<String, String> properties ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( properties );
        this.demotePrefix = cfg.getString ( "demote.prefix", null );
    }

    protected Severity extractSeverity ( final Map<String, Object> context )
    {
        if ( this.demotePrefix == null )
        {
            return Severity.ERROR;
        }

        final Object value = context.get ( this.demotePrefix + "." + CONTEXT_KEY_DEMOTE_TO_SEVERITY_SUFFIX );
        if ( value == null )
        {
            return Severity.ERROR;
        }

        try
        {
            return Severity.valueOf ( value.toString () );
        }
        catch ( final Exception e )
        {
            return Severity.ERROR;
        }
    }

    protected boolean isKey ( final String suffix, final Map<String, Object> context )
    {
        final Object value = context.get ( this.demotePrefix + "." + suffix );
        if ( value == null )
        {
            return false;
        }
        return true;
    }

    public boolean demoteAck ( final boolean requireAck )
    {
        if ( this.demotePrefix == null )
        {
            return requireAck;
        }

        if ( this.demoteAck )
        {
            return false;
        }
        return requireAck;
    }

    public Severity demoteSeverity ( final Severity severity )
    {
        if ( this.demotePrefix == null || severity == null )
        {
            // we are not active
            return severity;
        }

        if ( this.severityLimit == null )
        {
            return null;
        }

        final int ordinal = Math.min ( this.severityLimit.ordinal (), severity.ordinal () );

        logger.debug ( "Demoted severity from {} to {}", severity.ordinal (), ordinal );

        return Severity.values ()[ordinal];
    }

}