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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PropertiesMessage
{
    protected final Map<String, String> properties;

    public PropertiesMessage ( final Map<String, String> properties )
    {
        this.properties = new LinkedHashMap<String, String> ( properties );
    }

    public Map<String, String> getProperties ()
    {
        return Collections.unmodifiableMap ( this.properties );
    }
}
