/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.iec60870.asdu;

public final class DumperHelper
{
    private DumperHelper ()
    {
    }

    public static StringBuilder dump ( final Dumpable object )
    {
        final StringBuilder sb = new StringBuilder ();
        dump ( object, new Dumper ( sb ) );
        return sb;
    }

    public static void dump ( final Dumpable object, final Dumper dumper )
    {
        dumper.start ( object );
        object.dump ( dumper );
        dumper.end ();
    }
}
