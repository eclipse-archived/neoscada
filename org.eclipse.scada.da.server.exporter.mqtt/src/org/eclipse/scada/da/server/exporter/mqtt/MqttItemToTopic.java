/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.da.server.exporter.mqtt;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.scada.ca.ConfigurationDataHelper;

public class MqttItemToTopic implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String itemId;

    private String readTopic;

    private String writeValueTopic;

    private boolean isReadable = true;

    private boolean isWritable = false;

    public synchronized void update ( final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        this.itemId = cfg.getStringChecked ( "item.id", "'item.id' has to be set" );
        this.readTopic = cfg.getString ( "readTopic" );
        this.writeValueTopic = cfg.getString ( "writeValueTopic" );
        this.isReadable = cfg.getBoolean ( "readable", true );
        this.isWritable = cfg.getBoolean ( "writable", false );
    }

    public String getItemId ()
    {
        return this.itemId;
    }

    public String getReadTopic ()
    {
        return this.readTopic;
    }

    public String getWriteValueTopic ()
    {
        return this.writeValueTopic;
    }

    public boolean isReadable ()
    {
        return this.isReadable;
    }

    public boolean isWritable ()
    {
        return this.isWritable;
    }

    @Override
    public String toString ()
    {
        return "MqttItemToTopic [itemId=" + this.itemId + ", readTopic=" + this.readTopic + ", writeTopic=" + this.writeValueTopic + ", isReadable=" + this.isReadable + ", isWritable=" + this.isWritable + "]";
    }
}
