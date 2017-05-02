/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.user;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstanceFactory;
import org.eclipse.scada.vi.ui.user.viewer.ext.ExtensionDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{
    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.vi.ui.user"; //$NON-NLS-1$

    public static final String EXTP_VIEW = PLUGIN_ID + ".view"; //$NON-NLS-1$

    public static final String EXTP_VIEWER = PLUGIN_ID + ".viewer"; //$NON-NLS-1$

    private static final String ELE_VIEW_INSTANCE = "viewInstance"; //$NON-NLS-1$

    private static final String ELE_PROPERTY = "property"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    private List<ViewInstanceDescriptor> descriptors;

    /**
     * The constructor
     */
    public Activator ()
    {
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        plugin = null;
        super.stop ( context );
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static Activator getDefault ()
    {
        return plugin;
    }

    public static List<ExtensionDescriptor> getExtensionDescriptors ()
    {
        final List<ExtensionDescriptor> result = new LinkedList<ExtensionDescriptor> ();

        for ( final IConfigurationElement element : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_VIEWER ) )
        {
            if ( !"viewerExtension".equals ( element.getName () ) )
            {
                continue;
            }

            result.add ( new ExtensionDescriptor ( element ) );
        }

        return result;
    }

    protected List<ViewInstanceDescriptor> internalGetDescriptors ()
    {
        if ( this.descriptors == null )
        {
            this.descriptors = loadDescriptors ();
        }
        return this.descriptors;
    }

    public static List<ViewInstanceDescriptor> getDescriptors ()
    {
        return getDefault ().internalGetDescriptors ();
    }

    protected static List<ViewInstanceDescriptor> loadDescriptors ()
    {
        final List<ViewInstanceDescriptor> result = new LinkedList<ViewInstanceDescriptor> ();
        for ( final IConfigurationElement element : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_VIEW ) )
        {
            if ( !ELE_VIEW_INSTANCE.equals ( element.getName () ) )
            {
                continue;
            }

            final ViewInstanceDescriptor descriptor = convert ( element );
            if ( descriptor != null )
            {
                result.add ( descriptor );
            }
        }
        return result;
    }

    private static ViewInstanceDescriptor convert ( final IConfigurationElement element )
    {
        try
        {
            final String id = element.getAttribute ( "id" );
            final String name = element.getAttribute ( "name" );
            final String parentId = element.getAttribute ( "parent" );

            final ViewInstanceFactory factory = (ViewInstanceFactory)element.createExecutableExtension ( "factoryClass" );

            final URI uri = makeUri ( element.getContributor ().getName (), element.getAttribute ( "resource" ), element.getAttribute ( "uri" ) );

            final Map<String, String> properties = new LinkedHashMap<String, String> ( 0 );

            for ( final IConfigurationElement child : element.getChildren ( ELE_PROPERTY ) )
            {
                properties.put ( child.getAttribute ( "key" ), child.getAttribute ( "value" ) );
            }

            int order = 0;
            try
            {
                order = Integer.parseInt ( element.getAttribute ( "order" ) );
            }
            catch ( final Exception e )
            {
            }

            final boolean defaultInstance = element.getAttribute ( "defaultInstance" ) == null ? false : Boolean.parseBoolean ( element.getAttribute ( "defaultInstance" ) );
            final boolean mainView = element.getAttribute ( "mainView" ) == null ? false : Boolean.parseBoolean ( element.getAttribute ( "mainView" ) );

            final Boolean zooming = element.getAttribute ( "zooming" ) == null ? null : Boolean.parseBoolean ( element.getAttribute ( "zooming" ) );

            // parse summaryItem - if available
            String summaryConnectionId = null;
            String summaryItemId = null;
            final String summaryItem = element.getAttribute ( "summaryItem" );
            if ( summaryItem != null && summaryItem.contains ( "#" ) )
            {
                final String tok[] = summaryItem.split ( "\\#", 2 );
                summaryConnectionId = tok[0];
                summaryItemId = tok[1];
            }

            Expression lazyExpression = null;
            Expression visibleExpression = null;
            Expression defaultInstanceExpression = null;
            for ( final IConfigurationElement child : element.getChildren () )
            {
                final IConfigurationElement[] childs = child.getChildren ();
                if ( childs == null || childs.length <= 0 )
                {
                    continue;
                }

                if ( "laziness".equals ( child.getName () ) )
                {
                    lazyExpression = ExpressionConverter.getDefault ().perform ( child.getChildren ()[0] );
                }
                else if ( "visibility".equals ( child.getName () ) )
                {
                    visibleExpression = ExpressionConverter.getDefault ().perform ( child.getChildren ()[0] );
                }
                else if ( "defaultInstance".equals ( child.getName () ) )
                {
                    defaultInstanceExpression = ExpressionConverter.getDefault ().perform ( child.getChildren ()[0] );
                }
            }

            return new ViewInstanceDescriptor ( id, parentId, factory, uri, name, order, defaultInstance, zooming, lazyExpression, visibleExpression, defaultInstanceExpression, summaryConnectionId, summaryItemId, mainView, properties );
        }
        catch ( final Throwable e )
        {
            plugin.getLog ().log ( StatusHelper.convertStatus ( PLUGIN_ID, e ) );
            return null;
        }
    }

    private static URI makeUri ( final String contributerId, final String resource, final String uri ) throws URISyntaxException
    {
        if ( uri != null && !uri.isEmpty () )
        {
            return new URI ( uri );
        }
        final Bundle bundle = Platform.getBundle ( contributerId );
        return FileLocator.find ( bundle, new Path ( resource ), new HashMap<String, String> () ).toURI ();
    }

    public static ViewInstanceDescriptor findParent ( final ViewInstanceDescriptor descriptor )
    {
        return getDefault ().findParentDescriptor ( descriptor );
    }

    protected ViewInstanceDescriptor findParentDescriptor ( final ViewInstanceDescriptor childDescriptor )
    {
        if ( childDescriptor.getParentId () == null || childDescriptor.getParentId ().isEmpty () )
        {
            return null;
        }

        for ( final ViewInstanceDescriptor descriptor : this.descriptors )
        {
            if ( descriptor.getId () == null )
            {
                continue;
            }
            if ( descriptor.getId ().equals ( childDescriptor.getParentId () ) )
            {
                return descriptor;
            }
        }
        return null;
    }
}
