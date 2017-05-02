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
package org.eclipse.scada.utils.osgi.daemon;

public class Daemon
{
    private final static Starter starter = new Starter ();

    public static void main ( final String[] args ) throws Exception
    {
        start ( args );
    }

    public static void start ( final String[] args ) throws Exception
    {
        starter.start ( args );
    }

    public static void stop ( final String[] args ) throws Exception
    {
        starter.stop ();
    }
}
