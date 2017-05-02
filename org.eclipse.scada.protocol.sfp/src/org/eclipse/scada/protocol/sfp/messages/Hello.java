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
import java.util.HashSet;
import java.util.Set;

public class Hello
{
    public static enum Features
    {
        SUPPORTS_TLS
    }

    private final short nodeId;

    private final Set<Features> features;

    public Hello ( final short nodeId, final Set<Features> features )
    {
        this.nodeId = nodeId;
        this.features = Collections.unmodifiableSet ( new HashSet<Hello.Features> ( features ) );
    }

    public short getNodeId ()
    {
        return this.nodeId;
    }

    public Set<Features> getFeatures ()
    {
        return this.features;
    }
}
