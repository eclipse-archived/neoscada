/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.lib;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IRegistryEventListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.configuration.component.DanglingItemReference;
import org.eclipse.scada.configuration.generator.GeneratorContext;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ForwardingDanglingReferenceResolver implements DanglingReferenceResolver, IRegistryEventListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ForwardingDanglingReferenceResolver.class );

    private static final String ATTR_CLASS = "class"; //$NON-NLS-1$

    private static final String EXPT_DANGLING_RESOLVER = "org.eclipse.scada.configuration.component.lib.generation"; //$NON-NLS-1$

    private static final Object ELE_RESOLVER = "resolver"; //$NON-NLS-1$

    private final Set<DanglingReferenceResolver> cache = new HashSet<> ();

    public ForwardingDanglingReferenceResolver ()
    {
        Platform.getExtensionRegistry ().addListener ( this, EXPT_DANGLING_RESOLVER );
        buildCache ();
    }

    private void buildCache ()
    {
        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXPT_DANGLING_RESOLVER ) )
        {
            if ( !ele.getName ().equals ( ELE_RESOLVER ) )
            {
                continue;
            }
            try
            {
                final DanglingReferenceResolver resolver = (DanglingReferenceResolver)ele.createExecutableExtension ( ATTR_CLASS );
                logger.debug ( "Adding resolver: {}", resolver ); //$NON-NLS-1$
                this.cache.add ( resolver );
            }
            catch ( final Exception e )
            {
                Activator.getDefault ().getLog ().log ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "Failed to create resolver instance", e ) );
            }
        }
    }

    public void dispose ()
    {
        Platform.getExtensionRegistry ().removeListener ( this );
    }

    @Override
    public Item resolveReference ( final GeneratorContext ctx, final MasterServer master, final DanglingItemReference ref )
    {
        for ( final DanglingReferenceResolver resolver : this.cache )
        {
            final Item result = resolver.resolveReference ( ctx, master, ref );
            if ( result != null )
            {
                return result;
            }
        }
        return null;
    }

    @Override
    public void added ( final IExtension[] extensions )
    {
        buildCache ();
    }

    @Override
    public void removed ( final IExtension[] extensions )
    {
        buildCache ();
    }

    @Override
    public void added ( final IExtensionPoint[] extensionPoints )
    {
        buildCache ();
    }

    @Override
    public void removed ( final IExtensionPoint[] extensionPoints )
    {
        buildCache ();
    }

}
