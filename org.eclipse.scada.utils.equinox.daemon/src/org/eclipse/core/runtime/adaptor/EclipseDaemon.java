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
package org.eclipse.core.runtime.adaptor;

/**
 * This is a simple wrapper class for the {@link EclipseStarter} <br/>
 * The problem is that the "prunsrv.exe" of Apache Commons Daemon expects the
 * stop method to also accept arguments of type String[].
 * <p>
 * Also see https://issues.apache.org/jira/browse/DAEMON-315
 * </p>
 * 
 * @author Jens Reimann
 */
public class EclipseDaemon
{
    public static void main ( final String[] args ) throws Exception
    {
        EclipseStarter.main ( args );
    }

    public static void start ( final String[] args ) throws Exception
    {
        EclipseStarter.main ( args );
    }

    public static void stop ( final String[] args ) throws Exception
    {
        EclipseStarter.shutdown ();
    }

    public static void stop () throws Exception
    {
        EclipseStarter.shutdown ();
    }
}
