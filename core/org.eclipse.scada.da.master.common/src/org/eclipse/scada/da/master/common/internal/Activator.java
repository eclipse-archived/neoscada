/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.master.common.internal;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;

import org.eclipse.scada.ae.event.EventProcessor;
import org.eclipse.scada.ca.ConfigurationAdministrator;
import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.master.MasterItem;
import org.eclipse.scada.da.master.common.block.BlockHandlerFactoryImpl;
import org.eclipse.scada.da.master.common.manual.ManualHandlerFactoryImpl;
import org.eclipse.scada.da.master.common.marker.MarkerHandlerFactoryImpl;
import org.eclipse.scada.da.master.common.negate.NegateHandlerFactoryImpl;
import org.eclipse.scada.da.master.common.round.RoundHandlerFactoryImpl;
import org.eclipse.scada.da.master.common.scale.ScaleHandlerFactoryImpl;
import org.eclipse.scada.da.master.common.sum.CommonSumHandlerFactoryImpl;
import org.eclipse.scada.utils.interner.InternerHelper;
import org.eclipse.scada.utils.osgi.pool.ObjectPoolTracker;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.util.tracker.ServiceTracker;

import com.google.common.collect.Interner;

public class Activator implements BundleActivator
{

    private static Activator instance;

    private EventProcessor eventProcessor;

    private ObjectPoolTracker<MasterItem> poolTracker;

    private ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> caTracker;

    private final Collection<AbstractServiceConfigurationFactory<?>> factories = new LinkedList<AbstractServiceConfigurationFactory<?>> ();

    private Interner<String> stringInterner;

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        Activator.instance = this;

        this.stringInterner = InternerHelper.makeInterner ( "org.eclipse.scada.da.master.common.stringInterner", "java" ); //$NON-NLS-1$ //$NON-NLS-2$

        this.eventProcessor = new EventProcessor ( context );
        this.eventProcessor.open ();

        this.poolTracker = new ObjectPoolTracker<MasterItem> ( context, MasterItem.class );
        this.poolTracker.open ();

        this.caTracker = new ServiceTracker<ConfigurationAdministrator, ConfigurationAdministrator> ( context, ConfigurationAdministrator.class, null );
        this.caTracker.open ();

        {
            final CommonSumHandlerFactoryImpl factory = new CommonSumHandlerFactoryImpl ( context, this.poolTracker );
            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "An attribute sum handler" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, "da.master.handler.sum" );
            context.registerService ( ConfigurationFactory.class, factory, properties );
            this.factories.add ( factory );
        }
        {
            final ScaleHandlerFactoryImpl factory = new ScaleHandlerFactoryImpl ( context, this.poolTracker, this.caTracker, 500 );
            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "A local scaling master handler" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, ScaleHandlerFactoryImpl.FACTORY_ID );
            context.registerService ( ConfigurationFactory.class, factory, properties );
            this.factories.add ( factory );
        }

        {
            final NegateHandlerFactoryImpl factory = new NegateHandlerFactoryImpl ( context, this.poolTracker, this.caTracker, 501 );
            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "A local negate master handler" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, NegateHandlerFactoryImpl.FACTORY_ID );
            context.registerService ( ConfigurationFactory.class, factory, properties );
            this.factories.add ( factory );
        }

        {
            final ManualHandlerFactoryImpl factory = new ManualHandlerFactoryImpl ( context, this.eventProcessor, this.poolTracker, this.caTracker, 1000 );
            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "A local manual override master handler" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, ManualHandlerFactoryImpl.FACTORY_ID );
            context.registerService ( ConfigurationFactory.class, factory, properties );
            this.factories.add ( factory );
        }

        {
            final BlockHandlerFactoryImpl factory = new BlockHandlerFactoryImpl ( context, this.eventProcessor, this.poolTracker, this.caTracker, Integer.MIN_VALUE );
            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "A blocking operation handler" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, BlockHandlerFactoryImpl.FACTORY_ID );
            context.registerService ( ConfigurationFactory.class, factory, properties );
            this.factories.add ( factory );
        }

        {
            final RoundHandlerFactoryImpl factory = new RoundHandlerFactoryImpl ( context, this.poolTracker, this.caTracker, 502 );
            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "A rounding operation handler" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, RoundHandlerFactoryImpl.FACTORY_ID );
            context.registerService ( ConfigurationFactory.class, factory, properties );
            this.factories.add ( factory );
        }

        {
            final MarkerHandlerFactoryImpl factory = new MarkerHandlerFactoryImpl ( context, this.eventProcessor, this.poolTracker, this.caTracker, 100 );
            final Dictionary<String, String> properties = new Hashtable<String, String> ();
            properties.put ( Constants.SERVICE_DESCRIPTION, "A handler which allows to injects a marker" );
            properties.put ( Constants.SERVICE_VENDOR, "Eclipse SCADA Project" );
            properties.put ( ConfigurationAdministrator.FACTORY_ID, MarkerHandlerFactoryImpl.FACTORY_ID );
            context.registerService ( ConfigurationFactory.class, factory, properties );
            this.factories.add ( factory );
        }

    }

    public static Interner<String> getStringInterner ()
    {
        return instance.stringInterner;
    }

    /*
     * (non-Javadoc)
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        for ( final AbstractServiceConfigurationFactory<?> factory : this.factories )
        {
            factory.dispose ();
        }

        this.poolTracker.close ();
        this.poolTracker = null;

        this.caTracker.close ();
        this.caTracker = null;

        this.eventProcessor.close ();
        this.eventProcessor = null;

        Activator.instance = null;
    }

}
