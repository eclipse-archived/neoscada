/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.ui.connection.data;

import java.util.Date;
import java.util.Map;

import org.eclipse.scada.ae.connection.provider.ConnectionService;
import org.eclipse.scada.ae.data.MonitorStatus;
import org.eclipse.scada.ae.data.MonitorStatusInformation;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A bean holding the monitor status information for the viewer
 * 
 * @author Jens Reimann
 */
public class MonitorStatusBean extends AbstractPropertyChange
{

    private final static Logger logger = LoggerFactory.getLogger ( MonitorStatusBean.class );

    public static final String PROP_STATUS = "status";

    public static final String PROP_STATUS_TIMESTAMP = "statusTimestamp";

    public static final String PROP_VALUE = "value";

    public static final String PROP_LAST_AKN_USER = "lastAknUser";

    public static final String PROP_LAST_AKN_TIMESTAMP = "lastAknTimestamp";

    public static final String PROP_LAST_FAIL_TIMESTAMP = "lastFailTimestamp";

    public static final String PROP_ATTRIBUTES = "attributes";

    private final ConnectionService connection;

    private final String id;

    private MonitorStatus status;

    private Date statusTimestamp;

    private Variant value;

    private String lastAknUser;

    private Date lastAknTimestamp;

    private Date lastFailTimestamp;

    private Map<String, Variant> attributes;

    public MonitorStatusBean ( final ConnectionService connection, final String id )
    {
        this.connection = connection;
        this.id = id;
    }

    public MonitorStatusBean ( final ConnectionService connection, final MonitorStatusInformation information )
    {
        this ( connection, information.getId () );
        this.status = information.getStatus ();
        this.statusTimestamp = new Date ( information.getStatusTimestamp () );
        this.value = information.getValue ();
        this.lastAknUser = information.getLastAknUser ();
        this.lastAknTimestamp = makeDate ( information.getLastAknTimestamp () );
        this.lastFailTimestamp = makeDate ( information.getLastFailTimestamp () );
        this.attributes = information.getAttributes ();
    }

    private static Date makeDate ( final Long timestamp )
    {
        if ( timestamp == null )
        {
            return null;
        }
        else
        {
            return new Date ( timestamp );
        }
    }

    public String getId ()
    {
        return this.id;
    }

    public ConnectionService getConnection ()
    {
        return this.connection;
    }

    public MonitorStatus getStatus ()
    {
        return this.status;
    }

    public void setStatus ( final MonitorStatus status )
    {
        firePropertyChange ( PROP_STATUS, this.status, this.status = status );
    }

    public void update ( final MonitorStatusInformation info )
    {
        setStatus ( info.getStatus () );
        setStatusTimestamp ( new Date ( info.getStatusTimestamp () ) );
        setValue ( info.getValue () );
        setLastAknTimestamp ( makeDate ( info.getLastAknTimestamp () ) );
        setLastAknUser ( info.getLastAknUser () );
    }

    public Date getStatusTimestamp ()
    {
        return this.statusTimestamp;
    }

    public void setStatusTimestamp ( final Date statusTimestamp )
    {
        firePropertyChange ( PROP_STATUS_TIMESTAMP, this.statusTimestamp, this.statusTimestamp = statusTimestamp );
    }

    public Variant getValue ()
    {
        return this.value;
    }

    public void setValue ( final Variant value )
    {
        firePropertyChange ( PROP_VALUE, this.value, this.value = value );
    }

    public String getLastAknUser ()
    {
        return this.lastAknUser;
    }

    public void setLastAknUser ( final String lastAknUser )
    {
        firePropertyChange ( PROP_LAST_AKN_USER, this.lastAknUser, this.lastAknUser = lastAknUser );
    }

    public Date getLastAknTimestamp ()
    {
        return this.lastAknTimestamp;
    }

    public void setLastAknTimestamp ( final Date lastAknTimestamp )
    {
        firePropertyChange ( PROP_LAST_AKN_TIMESTAMP, this.lastAknTimestamp, this.lastAknTimestamp = lastAknTimestamp );
    }

    public void akn ()
    {
        logger.debug ( "Request ACK: {}", this.id );
        this.connection.getConnection ().acknowledge ( this.id, new Date (), null, null );
    }

    public Date getLastFailTimestamp ()
    {
        return this.lastFailTimestamp;
    }

    public void setLastFailTimestamp ( final Date lastFailTimestamp )
    {
        firePropertyChange ( PROP_LAST_FAIL_TIMESTAMP, this.lastFailTimestamp, this.lastFailTimestamp = lastFailTimestamp );
    }

    public Map<String, Variant> getAttributes ()
    {
        return this.attributes;
    }

    public void setAttributes ( final Map<String, Variant> attributes )
    {
        firePropertyChange ( PROP_ATTRIBUTES, this.attributes, this.attributes = attributes );
    }
}
