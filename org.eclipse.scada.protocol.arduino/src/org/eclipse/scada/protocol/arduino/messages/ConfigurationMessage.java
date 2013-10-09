/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.arduino.messages;

import java.util.Map;

import org.eclipse.scada.protocol.arduino.CommandCode;

public class ConfigurationMessage extends CommonMessage
{
    private final Map<Integer, Object>[] parameters;

    public ConfigurationMessage ( final int sequence, final CommandCode commandCode, final Map<Integer, Object>[] parameters )
    {
        super ( sequence, commandCode );
        this.parameters = parameters;
    }

    public Map<Integer, Object>[] getParameters ()
    {
        return this.parameters;
    }
}
