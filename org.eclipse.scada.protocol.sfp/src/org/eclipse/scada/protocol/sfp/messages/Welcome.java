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
package org.eclipse.scada.protocol.sfp.messages;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Welcome
{
    public static enum Features
    {
        USE_TLS,
        LITTLE_ENDIAN
    }

    private final Set<Features> features;

    private final Map<String, String> properties;

    public Welcome ( final Set<Features> features, final Map<String, String> properties )
    {
        this.features = Collections.unmodifiableSet ( new HashSet<Features> ( features ) );
        this.properties = Collections.unmodifiableMap ( new HashMap<String, String> ( properties ) );
    }

    public Set<Features> getFeatures ()
    {
        return this.features;
    }

    public Map<String, String> getProperties ()
    {
        return this.properties;
    }

}
