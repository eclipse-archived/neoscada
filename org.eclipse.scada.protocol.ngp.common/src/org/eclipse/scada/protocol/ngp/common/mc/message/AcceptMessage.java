/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common.mc.message;

import java.util.Map;

public class AcceptMessage extends PropertiesMessage
{

    public AcceptMessage ( final Map<String, String> properties )
    {
        super ( properties );
    }

    @Override
    public String toString ()
    {
        return String.format ( "[Accepted - %s]", this.properties );
    }

}
