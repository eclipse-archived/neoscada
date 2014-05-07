/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.ui.server.internal.app;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.rap.rwt.service.ServerPushSession;
import org.eclipse.scada.utils.ui.server.internal.FactoryImpl;
import org.eclipse.scada.utils.ui.server.internal.PageManager;
import org.eclipse.scada.utils.ui.server.internal.TreeNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osgi.framework.FrameworkUtil;

public class MainEntryPoint extends AbstractEntryPoint
{
    private final static class LabelProviderImpl extends ObservableMapLabelProvider implements IFontProvider
    {
        private static final long serialVersionUID = 1L;

        private final TreeViewer viewer;

        private final Font font;

        private final Font defaultFont;

        public LabelProviderImpl ( final TreeViewer viewer, final IObservableMap... attributeMaps )
        {
            super ( attributeMaps );
            this.viewer = viewer;

            this.defaultFont = viewer.getControl ().getFont ();

            final FontData[] fds = this.viewer.getControl ().getFont ().getFontData ();
            for ( final FontData fd : fds )
            {
                fd.setStyle ( SWT.ITALIC );
            }
            this.font = new Font ( this.viewer.getControl ().getDisplay (), fds );
        }

        @Override
        public Font getFont ( final Object element )
        {
            final TreeNode node = (TreeNode)element;
            if ( node.isProviderSet () )
            {
                return this.defaultFont;
            }
            else
            {
                return this.font;
            }
        }

        @Override
        public String getText ( final Object element )
        {
            final TreeNode node = (TreeNode)element;
            return node.getName ();
        }

        @Override
        public void dispose ()
        {
            super.dispose ();
            this.font.dispose ();
        }

    }

    private ObservableListTreeContentProvider treeContentProvider;

    private final DisposeListener disposeListener = new DisposeListener () {

        private static final long serialVersionUID = 1L;

        @Override
        public void widgetDisposed ( final DisposeEvent event )
        {
            handleDispose ();
        }
    };

    private PageManager manager;

    private ServerPushSession session;

    private Label headerLabel;

    private DataBindingContext dbc;

    private TreeViewer viewer;

    private boolean handlingEvent;

    @SuppressWarnings ( "unused" )
    @Override
    protected void createContents ( final Composite parent )
    {
        this.dbc = new DataBindingContext ( SWTObservables.getRealm ( parent.getDisplay () ) );

        this.session = new ServerPushSession ();
        this.session.start ();

        this.manager = new PageManager ( SWTObservables.getRealm ( parent.getDisplay () ), FrameworkUtil.getBundle ( MainEntryPoint.class ).getBundleContext () );

        final FormLayout layout = new FormLayout ();
        parent.setLayout ( layout );

        final Composite header = createHeader ( parent );

        final Composite footer = createFooter ( parent );

        final SashForm sash = new SashForm ( parent, SWT.HORIZONTAL );
        final Composite menu = createMenu ( sash );
        final Composite main = createMain ( sash );
        sash.setWeights ( new int[] { 10, 90 } );

        {
            final FormData fd = new FormData ();
            fd.left = new FormAttachment ( 0 );
            fd.right = new FormAttachment ( 100 );
            fd.top = new FormAttachment ( header );
            fd.bottom = new FormAttachment ( footer );
            fd.width = 200;
            sash.setLayoutData ( fd );
        }

        {
            final FormData fd = new FormData ();
            fd.left = new FormAttachment ( 0 );
            fd.right = new FormAttachment ( 100 );
            fd.height = 75;
            fd.top = new FormAttachment ( 0 );
            header.setLayoutData ( fd );
        }

        {
            final FormData fd = new FormData ();
            fd.left = new FormAttachment ( 0 );
            fd.right = new FormAttachment ( 100 );
            fd.bottom = new FormAttachment ( 100 );
            footer.setLayoutData ( fd );
        }

        this.manager.setMainArea ( main );

        parent.addDisposeListener ( this.disposeListener );
    }

    private Composite createMain ( final Composite parent )
    {
        final Composite main = new Composite ( parent, SWT.NONE );
        return main;
    }

    protected void handleDispose ()
    {
        if ( this.session != null )
        {
            this.session.stop ();
            this.session = null;
        }
        if ( this.manager != null )
        {
            this.manager.dispose ();
            this.manager = null;
        }
    }

    private Composite createMenu ( final Composite parent )
    {
        final Composite menu = new Composite ( parent, SWT.NONE );

        menu.setLayout ( new FillLayout () );

        this.viewer = new TreeViewer ( menu, SWT.FULL_SELECTION );

        this.treeContentProvider = new ObservableListTreeContentProvider ( new FactoryImpl (), null );
        this.viewer.setContentProvider ( this.treeContentProvider );

        this.viewer.setLabelProvider ( new LabelProviderImpl ( this.viewer,
                BeansObservables.observeMap ( this.treeContentProvider.getRealizedElements (), TreeNode.PROP_NAME ),
                BeansObservables.observeMap ( this.treeContentProvider.getRealizedElements (), TreeNode.PROP_PROVIDER_SET )
                ) );

        this.viewer.setInput ( this.manager.getRootNode () );

        this.viewer.addSelectionChangedListener ( new ISelectionChangedListener () {

            @Override
            public void selectionChanged ( final SelectionChangedEvent event )
            {
                handleSelectionChanged ( event );
            }
        } );

        this.viewer.setAutoExpandLevel ( 2 );

        return menu;
    }

    protected void handleSelectionChanged ( final SelectionChangedEvent event )
    {
        if ( this.handlingEvent )
        {
            return;
        }

        final TreeNode node = (TreeNode) ( (IStructuredSelection)event.getSelection () ).getFirstElement ();
        final TreeNode nodeShown = this.manager.showPage ( node );

        try
        {
            this.handlingEvent = true;
            // select the node, could also be the old one
            this.viewer.setSelection ( new StructuredSelection ( nodeShown ), true );
        }
        finally
        {
            this.handlingEvent = false;
        }
    }

    private Composite createHeader ( final Composite parent )
    {
        final Composite header = new Composite ( parent, SWT.NONE );

        header.setLayout ( new GridLayout () );

        header.setData ( RWT.CUSTOM_VARIANT, "header" );
        header.setBackgroundMode ( SWT.INHERIT_DEFAULT );

        this.headerLabel = new Label ( header, SWT.NONE );
        this.headerLabel.setLayoutData ( new GridData ( SWT.FILL, SWT.CENTER, true, true ) );
        this.headerLabel.setData ( RWT.CUSTOM_VARIANT, "headerLabel" );

        this.dbc.bindValue ( SWTObservables.observeText ( this.headerLabel ), this.manager.getPageName () );

        return header;
    }

    private Composite createFooter ( final Composite parent )
    {
        final Composite footer = new Composite ( parent, SWT.NONE );

        footer.setLayout ( new RowLayout () );

        footer.setData ( RWT.CUSTOM_VARIANT, "footer" );
        footer.setBackgroundMode ( SWT.INHERIT_DEFAULT );

        final Label label = new Label ( footer, SWT.NONE );
        label.setText ( "Hello World" );

        return footer;
    }

}
