/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.exec;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.exec.configuration.RootType;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.impl.HiveCommon;
import org.eclipse.scada.da.server.exec.command.CommandQueue;
import org.eclipse.scada.da.server.exec.command.ContinuousCommand;
import org.eclipse.scada.da.server.exec.command.TriggerCommand;
import org.eclipse.scada.da.server.exec.configuration.ConfigurationException;
import org.eclipse.scada.da.server.exec.configuration.XmlConfigurator;
import org.eclipse.scada.utils.collection.MapBuilder;

public class Hive extends HiveCommon
{
    private static final String TRIGGER_FOLDER_NAME = "triggers";

    /**
     * Root folder of the Hive
     */
    private final FolderCommon rootFolder = new FolderCommon ();

    private final Collection<CommandQueue> queues = new LinkedList<CommandQueue> ();

    private final Collection<ContinuousCommand> continuousCommands = new LinkedList<ContinuousCommand> ();

    private final Collection<TriggerCommand> triggers = new LinkedList<TriggerCommand> ();

    private final FolderCommon triggerFolder;

    /**
     * Default Constructor
     * 
     * @throws XmlException
     * @throws IOException
     * @throws ConfigurationException
     */
    public Hive () throws IOException, ConfigurationException
    {
        this ( new XmlConfigurator ( URI.createFileURI ( "configuration.xml" ) ) );
    }

    public Hive ( final String uri ) throws ConfigurationException
    {
        this ( new XmlConfigurator ( URI.createURI ( uri ) ) );
    }

    public Hive ( final RootType root ) throws ConfigurationException
    {
        this ( new XmlConfigurator ( root ) );
    }

    protected Hive ( final XmlConfigurator configurator ) throws ConfigurationException
    {
        setRootFolder ( this.rootFolder );
        this.triggerFolder = new FolderCommon ();
        this.rootFolder.add ( TRIGGER_FOLDER_NAME, this.triggerFolder, new MapBuilder<String, Variant> ().put ( "description", Variant.valueOf ( "Contains all triggers" ) ).getMap () );

        configurator.configure ( this );
    }

    @Override
    public String getHiveId ()
    {
        return "org.eclipse.scada.da.server.exec";
    }

    /**
     * Initializes all configured command queues and executes them in threads
     */
    protected void startQueues ()
    {
        for ( final CommandQueue queue : this.queues )
        {
            queue.start ( this, this.rootFolder );
        }
        for ( final ContinuousCommand command : this.continuousCommands )
        {
            command.start ( this, this.rootFolder );
        }
        for ( final TriggerCommand command : this.triggers )
        {
            command.register ( this, this.triggerFolder );
        }
    }

    @Override
    protected void performStart () throws Exception
    {
        super.performStart ();
        startQueues ();
    }

    @Override
    protected void performStop () throws Exception
    {
        stopQueues ();
        super.performStop ();
    }

    protected void stopQueues ()
    {
        for ( final CommandQueue queue : this.queues )
        {
            queue.stop ();
        }
        for ( final ContinuousCommand command : this.continuousCommands )
        {
            command.stop ();
        }
        for ( final TriggerCommand command : this.triggers )
        {
            command.unregister ();
        }
    }

    public void addQueue ( final CommandQueue queue )
    {
        this.queues.add ( queue );
    }

    public void addContinuousCommand ( final ContinuousCommand command )
    {
        this.continuousCommands.add ( command );
    }

    /**
     * Add a new trigger command
     * 
     * @param command
     *            the new trigger command
     */
    public void addTrigger ( final TriggerCommand command )
    {
        this.triggers.add ( command );
    }
}
