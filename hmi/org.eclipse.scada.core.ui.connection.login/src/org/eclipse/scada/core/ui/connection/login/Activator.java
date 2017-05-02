/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.scada.core.ui.connection.login.internal.SessionManagerImpl;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "org.eclipse.scada.core.ui.connection.login"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    private SessionManager sessionManager;

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
        this.sessionManager = new SessionManagerImpl ( SWTObservables.getRealm ( getWorkbench ().getDisplay () ) );
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

        this.sessionManager.getRealm ().exec ( new Runnable () {

            @Override
            public void run ()
            {
                Activator.this.sessionManager.dispose ();
                Activator.this.sessionManager = null;
            }
        } );

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

    public LoginContext[] getContextList ()
    {
        final List<LoginContext> result = new LinkedList<LoginContext> ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( "org.eclipse.scada.core.ui.connection.login.context" ) ) //$NON-NLS-1$
        {
            if ( !"context".equals ( ele.getName () ) ) //$NON-NLS-1$
            {
                continue;
            }

            final String name = ele.getAttribute ( "label" ); //$NON-NLS-1$
            final String id = ele.getAttribute ( "id" ); //$NON-NLS-1$

            // get properties
            final Map<String, String> properties = new HashMap<String, String> ();
            for ( final IConfigurationElement child : ele.getChildren ( "property" ) )//$NON-NLS-1$
            {
                final String key = child.getAttribute ( "key" );//$NON-NLS-1$
                final String value = child.getAttribute ( "value" );//$NON-NLS-1$
                if ( key != null && value != null )
                {
                    properties.put ( key, value );
                }
            }

            final Collection<LoginFactory> factories = new LinkedList<LoginFactory> ();
            fillFactories ( factories, ele );

            if ( id != null && name != null && !factories.isEmpty () )
            {
                result.add ( new LoginContext ( id, name, factories, properties ) );
            }

        }

        return result.toArray ( new LoginContext[result.size ()] );
    }

    private void fillFactories ( final Collection<LoginFactory> factories, final IConfigurationElement ele )
    {
        for ( final IConfigurationElement child : ele.getChildren ( "factory" ) ) //$NON-NLS-1$
        {
            try
            {
                final LoginFactory factory = (LoginFactory)child.createExecutableExtension ( "class" );//$NON-NLS-1$
                if ( factory != null )
                {
                    factories.add ( factory );
                }
            }
            catch ( final Exception e )
            {
                getLog ().log ( new Status ( IStatus.WARNING, PLUGIN_ID, Messages.Activator_ErrorParse, e ) );
            }
        }
    }

    public synchronized void setLoginSession ( final LoginSession session )
    {
        this.sessionManager.setSession ( session );
    }

    public void setLoginSession ( final String username, final String password, final LoginContext loginContext, final Collection<LoginHandler> handler )
    {
        setLoginSession ( new LoginSession ( getBundle ().getBundleContext (), username, password, loginContext, handler ) );
    }

    public SessionManager getSessionManager ()
    {
        return this.sessionManager;
    }

}
