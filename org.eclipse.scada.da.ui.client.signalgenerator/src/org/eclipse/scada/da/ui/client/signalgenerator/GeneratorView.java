/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.client.signalgenerator;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.ui.client.signalgenerator.page.GeneratorPage;
import org.eclipse.scada.da.ui.connection.data.DataSourceListener;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

public class GeneratorView extends ViewPart implements SimulationTarget
{
    public static final String VIEW_ID = "org.eclipse.scada.da.client.signalGenerator.GeneratorView"; //$NON-NLS-1$

    private CTabFolder tabFolder;

    private final List<GeneratorPageInformation> pages = new LinkedList<GeneratorPageInformation> ();

    private GeneratorPageInformation activePage;

    private org.eclipse.scada.da.ui.connection.data.DataItemHolder item;

    private Composite header;

    private Button startButton;

    private Label errorLabel;

    public GeneratorView ()
    {
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        createPages ();
        applyParentLayout ( parent );
        createHeader ( parent );
        createTabFolder ( parent );

        updateState ();
    }

    private void createTabFolder ( final Composite parent )
    {
        this.tabFolder = new CTabFolder ( parent, SWT.BOTTOM );
        this.tabFolder.setLayoutData ( new GridData ( GridData.FILL, GridData.FILL, true, true ) );

        for ( final GeneratorPageInformation page : this.pages )
        {
            final CTabItem tabItem = new CTabItem ( this.tabFolder, SWT.NONE );
            final Composite tabComposite = new Composite ( this.tabFolder, SWT.NONE );
            tabComposite.setLayout ( new FillLayout () );
            page.getGeneratorPage ().createPage ( tabComposite );
            tabItem.setText ( page.getLabel () );
            tabItem.setControl ( tabComposite );
            page.getGeneratorPage ().setTarget ( this );
        }

        this.tabFolder.setSelection ( 0 );
    }

    private void applyParentLayout ( final Composite parent )
    {
        final GridLayout layout = new GridLayout ( 1, false );
        layout.horizontalSpacing = layout.verticalSpacing = 0;
        layout.marginWidth = layout.marginHeight = 0;
        parent.setLayout ( layout );
    }

    private void createHeader ( final Composite parent )
    {
        this.header = new Composite ( parent, SWT.NONE );
        this.header.setLayoutData ( new GridData ( GridData.BEGINNING, GridData.BEGINNING, true, false ) );

        this.header.setLayout ( new RowLayout () );

        this.startButton = new Button ( this.header, SWT.TOGGLE );
        this.startButton.setText ( Messages.getString ( "GeneratorView.ButtonGo" ) );
        this.startButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                GeneratorView.this.toggleButton ( GeneratorView.this.startButton.getSelection () );
            }
        } );

        this.errorLabel = new Label ( this.header, SWT.NONE );
    }

    protected void toggleButton ( final boolean selection )
    {
        if ( selection )
        {
            handleStart ();
        }
        else
        {
            handleStop ();
        }
    }

    protected GeneratorPageInformation getSelection ()
    {
        try
        {
            return this.pages.get ( this.tabFolder.getSelectionIndex () );
        }
        catch ( final Throwable e )
        {
            return null;
        }
    }

    private void handleStop ()
    {
        if ( this.activePage != null )
        {
            this.activePage.getGeneratorPage ().stop ();
            this.activePage = null;
            updateState ();
        }
    }

    private void handleStart ()
    {
        handleStop ();
        this.activePage = getSelection ();
        if ( this.activePage != null )
        {
            this.activePage.getGeneratorPage ().start ();
        }
        updateState ();

    }

    private void updateState ()
    {
        final boolean state = this.activePage == null;

        if ( this.startButton != null )
        {
            this.startButton.setEnabled ( this.item != null );
            this.startButton.setSelection ( !state );
            this.tabFolder.setEnabled ( state );
        }
    }

    private void createPages ()
    {
        try
        {
            for ( final GeneratorPageInformation info : getPageInformation () )
            {
                this.pages.add ( info );
            }
        }
        catch ( final CoreException e )
        {
            ErrorDialog.openError ( this.getSite ().getShell (), Messages.getString ( "GeneratorView.createPages.error" ), Messages.getString ( "GeneratorView.createPages.errorMessage" ), e.getStatus () );
        }
    }

    @Override
    public void dispose ()
    {
        for ( final GeneratorPageInformation page : this.pages )
        {
            page.getGeneratorPage ().dispose ();
        }
        this.pages.clear ();
        super.dispose ();
    }

    @Override
    public void setFocus ()
    {
        this.tabFolder.setFocus ();
    }

    public void setDataItem ( final Item item )
    {
        if ( item != null )
        {
            this.item = new org.eclipse.scada.da.ui.connection.data.DataItemHolder ( Activator.getDefault ().getBundle ().getBundleContext (), item, new DataSourceListener () {

                public void updateData ( final DataItemValue value )
                {
                    GeneratorView.this.updateData ();
                }
            } );

            setPartName ( String.format ( Messages.getString ( "GeneratorView.partName" ), item.getId (), item.getConnectionString () ) );
        }
        else
        {
            setPartName ( Messages.getString ( "GeneratorView.emptyPartName" ) );
        }
        updateState ();
    }

    protected void updateData ()
    {
        // TODO Auto-generated method stub
    }

    private Collection<GeneratorPageInformation> getPageInformation () throws CoreException
    {
        final List<GeneratorPageInformation> result = new LinkedList<GeneratorPageInformation> ();

        for ( final IConfigurationElement element : Platform.getExtensionRegistry ().getConfigurationElementsFor ( Activator.EXTP_GENERATOR_PAGE ) )
        {
            if ( !"generatorPage".equals ( element.getName () ) )
            {
                continue;
            }
            Object o;
            o = element.createExecutableExtension ( "class" );

            if ( ! ( o instanceof GeneratorPage ) )
            {
                throw new CoreException ( new Status ( Status.ERROR, Activator.PLUGIN_ID, Messages.getString ( "GeneratorView.classTypeMismatchError" ) ) );
            }

            final GeneratorPageInformation info = new GeneratorPageInformation ();
            info.setGeneratorPage ( (GeneratorPage)o );
            info.setLabel ( element.getAttribute ( "label" ) ); //$NON-NLS-1$
            info.setSortKey ( element.getAttribute ( "sortKey" ) );
            result.add ( info );
        }

        Collections.sort ( result, new Comparator<GeneratorPageInformation> () {

            public int compare ( final GeneratorPageInformation arg0, final GeneratorPageInformation arg1 )
            {
                String key1 = arg0.getSortKey ();
                String key2 = arg1.getSortKey ();
                if ( key1 == null )
                {
                    key1 = "";
                }
                if ( key2 == null )
                {
                    key2 = "";
                }

                return key1.compareTo ( key2 );
            }
        } );

        return result;
    }

    @Override
    public void init ( final IViewSite site, final IMemento memento ) throws PartInitException
    {
        super.init ( site, memento );
        setDataItem ( Item.loadFrom ( memento ) );
    }

    @Override
    public void saveState ( final IMemento memento )
    {
        super.saveState ( memento );
        if ( this.item != null )
        {
            this.item.getItem ().saveTo ( memento );
        }
    }

    public void writeValue ( final Variant value )
    {
        final org.eclipse.scada.da.ui.connection.data.DataItemHolder item = this.item;
        if ( item != null )
        {
            item.write ( value );
        }
    }

    protected void setFailure ( final String reason )
    {
        if ( reason != null )
        {
            triggerErrorLabel ( reason );
        }
        else
        {
            triggerErrorLabel ( "" );
        }
    }

    private void triggerErrorLabel ( final String string )
    {
        final Display d = this.errorLabel.getDisplay ();
        if ( !d.isDisposed () )
        {
            d.asyncExec ( new Runnable () {

                public void run ()
                {
                    if ( !GeneratorView.this.errorLabel.isDisposed () )
                    {
                        GeneratorView.this.errorLabel.setText ( string );
                    }
                }
            } );
        }
    }

}
