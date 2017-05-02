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

import org.eclipse.core.runtime.adaptor.EclipseStarter;

/**
 * This is a simple wrapper class for the {@link EclipseStarter} <br/>
 * The problem is that the "prunsrv.exe" of Apache Commons Daemon expects the
 * stop method to also accept arguments of type String[].
 * <p>
 * Also see
 * <ul>
 * <li>https://issues.apache.org/jira/browse/DAEMON-315</li>
 * <li>https://bugs.eclipse.org/bugs/show_bug.cgi?id=429293</li>
 * </ul>
 * </p>
 * 
 * @author Jens Reimann
 */
@SuppressWarnings ( "restriction" )
public class EclipseDaemon
{
    /**
     * This method starts OSGi container, but does not return as long as the
     * container is active
     * 
     * @param args
     *            arguments for the starter
     * @throws Exception
     *             if anything goes wrong
     */
    public static void main ( final String[] args ) throws Exception
    {
        EclipseStarter.main ( args );
    }

    /**
     * This method starts OSGi container, and returns immediately
     * <p>
     * The method will actually fork a thread and run the started method from
     * inside the thread. If the framework fails the method checks
     * {@link #isExitOnError()} on how to proceed. If {@link #isExitOnError()}
     * returns <code>true</code> then the method will call
     * {@link System#exit(int)} with a negative return value (-1). Otherwise
     * only the thread starting the framework will shut down.
     * </p>
     * 
     * @param args
     *            arguments for the starter
     * @throws Exception
     *             if anything goes wrong
     */
    public static void start ( final String[] args ) throws Exception
    {
        final Thread runner = new Thread ( "EclipseStarter" ) { //$NON-NLS-1$
            @Override
            public void run ()
            {
                try
                {
                    EclipseStarter.main ( args );
                }
                catch ( final Exception e )
                {
                    if ( isExitOnError () )
                    {
                        System.exit ( -1 );
                    }
                }
            };
        };

        runner.start ();
    }

    /**
     * Check if the starter should exit the VM in case the
     * {@link #start(String[])} method failed to start the framework
     * <p>
     * The method checks the system property
     * <code>org.eclipse.scada.utils.osgi.daemon.exitOnError</code>. If it is
     * not set the method will return <code>true</code>.
     * </p>
     * <p>
     * Otherwise the evaluate the value of the system property using
     * {@link Boolean#parseBoolean(String)}.
     * </p>
     * 
     * @return
     */
    protected static boolean isExitOnError ()
    {
        final String value = System.getProperty ( "org.eclipse.scada.utils.osgi.daemon.exitOnError" ); //$NON-NLS-1$
        if ( value == null || value.isEmpty () )
        {
            return true;
        }

        return Boolean.parseBoolean ( value );
    }

    /**
     * Stop the framework
     * 
     * @see #stop()
     * @param args
     * @throws Exception
     */

    public static void stop ( final String[] args ) throws Exception
    {
        EclipseStarter.shutdown ();
    }

    /**
     * The method shuts down the framework
     * <p>
     * The framework could have been started by {@link #start(String[])} or
     * {@link #main(String[])}.
     * </p>
     * 
     * @throws Exception
     *             if anything goes wrong
     */
    public static void stop () throws Exception
    {
        EclipseStarter.shutdown ();
    }
}
