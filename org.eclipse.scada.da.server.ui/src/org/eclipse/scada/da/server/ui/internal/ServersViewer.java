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
package org.eclipse.scada.da.server.ui.internal;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.databinding.viewers.ObservableSetTreeContentProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.scada.da.server.ui.HivesPlugin;
import org.eclipse.scada.da.server.ui.ServerDescriptor;
import org.eclipse.scada.da.server.ui.ServerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPartSite;

public class ServersViewer
{
    private static final class ObservableFactoryImpl implements IObservableFactory
    {
        @Override
        public IObservable createObservable ( final Object target )
        {
            if ( target instanceof ServerManager )
            {
                return Observables.proxyObservableSet ( ( (ServerManager)target ).getServers () );
            }
            else if ( target instanceof ServerDescriptor )
            {
                return Observables.proxyObservableSet ( ( (ServerDescriptor)target ).getEndpoints () );
            }
            return null;
        }
    }

    private final TreeViewer viewer;

    private final ObservableSetTreeContentProvider contentProvider;

    private final ServerLabelProvider labelProvider;

    public ServersViewer ( final Composite parent )
    {
        parent.setLayout ( new FillLayout () );
        this.viewer = new TreeViewer ( parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL );

        this.contentProvider = new ObservableSetTreeContentProvider ( new ObservableFactoryImpl (), null );
        this.viewer.setContentProvider ( this.contentProvider );
        this.labelProvider = new ServerLabelProvider ( this.contentProvider.getKnownElements () );
        this.viewer.setLabelProvider ( this.labelProvider );

        this.viewer.setInput ( HivesPlugin.getDefault ().getServerManager () );
        this.viewer.getControl ().addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );

        ColumnViewerToolTipSupport.enableFor ( this.viewer );
    }

    protected void handleDispose ()
    {
        this.contentProvider.dispose ();
        this.labelProvider.dispose ();
    }

    public void setFocus ()
    {
        this.viewer.getControl ().setFocus ();
    }

    public void contributeTo ( final IWorkbenchPartSite site )
    {
        site.setSelectionProvider ( this.viewer );
        hookContextMenu ( site );
    }

    private void hookContextMenu ( final IWorkbenchPartSite site )
    {
        final MenuManager menuMgr = new MenuManager ( "#PopupMenu" ); //$NON-NLS-1$
        menuMgr.setRemoveAllWhenShown ( true );
        menuMgr.addMenuListener ( new IMenuListener () {
            @Override
            public void menuAboutToShow ( final IMenuManager manager )
            {
                fillContextMenu ( manager );
            }
        } );
        final Menu menu = menuMgr.createContextMenu ( this.viewer.getControl () );
        this.viewer.getControl ().setMenu ( menu );
        site.registerContextMenu ( menuMgr, this.viewer );
    }

    private void fillContextMenu ( final IMenuManager manager )
    {
        manager.add ( new Separator ( IWorkbenchActionConstants.MB_ADDITIONS ) );
    }
}
