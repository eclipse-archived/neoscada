/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.config;

import java.net.URL;

import org.eclipse.core.commands.ParameterizedCommand;

public class AlarmNotifierConfiguration
{
    private final String connectionId;

    private final String prefix;

    private final URL soundFile;

    private final ParameterizedCommand ackAlarmsAvailableCommand;

    private final ParameterizedCommand alarmsAvailableCommand;

    public AlarmNotifierConfiguration ( final String connectionId, final String prefix, final URL soundFile, final ParameterizedCommand ackAlarmsAvailableCommand, final ParameterizedCommand alarmsAvailableCommand )
    {
        this.connectionId = connectionId;
        this.prefix = prefix;
        this.soundFile = soundFile;
        this.ackAlarmsAvailableCommand = ackAlarmsAvailableCommand;
        this.alarmsAvailableCommand = alarmsAvailableCommand;
    }

    public String getConnectionId ()
    {
        return this.connectionId;
    }

    public String getPrefix ()
    {
        return this.prefix;
    }

    public URL getSoundFile ()
    {
        return this.soundFile;
    }

    public ParameterizedCommand getAckAlarmsAvailableCommand ()
    {
        return this.ackAlarmsAvailableCommand;
    }

    public ParameterizedCommand getAlarmsAvailableCommand ()
    {
        return this.alarmsAvailableCommand;
    }
}
