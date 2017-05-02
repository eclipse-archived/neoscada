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
package org.eclipse.scada.da.server.component.parser.factory.internal;

import java.io.StringReader;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.da.server.component.ComponentFactory;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.concurrent.ScheduledExportedExecutorService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.xml.sax.InputSource;

public class FactoryImpl extends AbstractServiceConfigurationFactory<ComponentFactory>
{

    private final ScheduledExportedExecutorService executor;

    public FactoryImpl ( final BundleContext context )
    {
        super ( context, true );
        this.executor = new ScheduledExportedExecutorService ( "org.eclipse.scada.da.server.component.parser.factory", 1 );
    }

    @Override
    public synchronized void dispose ()
    {
        super.dispose ();
        this.executor.shutdown ();
    }

    @Override
    protected Entry<ComponentFactory> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        final String xml = cfg.getStringNonEmpty ( "configuration" );

        final XMIResource xmi = new XMIResourceImpl ();
        final Map<?, ?> options = new HashMap<Object, Object> ();
        final InputSource is = new InputSource ( new StringReader ( xml ) );
        xmi.load ( is, options );

        final Object c = EcoreUtil.getObjectByType ( xmi.getContents (), ParserPackage.Literals.COMPONENT );
        if ( ! ( c instanceof Component ) )
        {
            throw new RuntimeException ( String.format ( "Configuration did not contain an object of type %s", Component.class.getName () ) );
        }

        final ComponentFactoryWrapper wrapper = new ComponentFactoryWrapper ( this.executor, (Component)c );

        final Dictionary<String, ?> properties = new Hashtable<> ();
        final ServiceRegistration<ComponentFactory> handle = context.registerService ( ComponentFactory.class, wrapper, properties );

        return new Entry<ComponentFactory> ( configurationId, wrapper, handle );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final ComponentFactory service )
    {
        // nothing to do ... unregistration is automatic
    }

    @Override
    protected Entry<ComponentFactory> updateService ( final UserInformation userInformation, final String configurationId, final Entry<ComponentFactory> entry, final Map<String, String> parameters ) throws Exception
    {
        // will never be called since we are "create only"
        return null;
    }

}
