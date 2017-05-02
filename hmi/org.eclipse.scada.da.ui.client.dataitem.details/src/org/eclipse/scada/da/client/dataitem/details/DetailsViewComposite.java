/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - create generic header label
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.dataitem.details.part.DetailsPart;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.scada.da.ui.connection.data.DataSourceListener;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.widgets.DataItemHeaderLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class DetailsViewComposite extends Composite
{

    private final Collection<DetailsPart> detailParts = new LinkedList<DetailsPart> ();

    private DataItemHolder dataItem;

    private CTabFolder tabFolder;

    private final LocalResourceManager resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

    private final Display display;

    private DataItemHeaderLabel header;

    public DetailsViewComposite ( final Composite parent, final int style )
    {
        super ( parent, style );
        this.display = parent.getDisplay ();
        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );

        createControls ( parent );
    }

    private void createControls ( final Composite parent )
    {
        final GridLayout layout = new GridLayout ( 1, false );
        layout.marginHeight = layout.marginWidth = 0;
        setLayout ( layout );

        createHeader ( this );

        this.tabFolder = new CTabFolder ( this, SWT.BOTTOM | SWT.FLAT );
        this.tabFolder.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        try
        {
            for ( final DetailsPartInformation info : getPartInformation () )
            {
                final CTabVisibilityController controller = new CTabVisibilityController ( this.tabFolder, info.getLabel () ) {

                    @Override
                    protected Control createPart ( final Composite parent )
                    {
                        final Composite parentComposite = new Composite ( parent, SWT.NONE );
                        parentComposite.setLayout ( new FillLayout () );
                        try
                        {
                            info.getDetailsPart ().createPart ( parentComposite );
                        }
                        catch ( final Exception e )
                        {
                            final Text text = new Text ( parentComposite, SWT.MULTI | SWT.READ_ONLY );
                            final StringWriter sw = new StringWriter ();
                            e.printStackTrace ( new PrintWriter ( sw ) );
                            text.setText ( sw.toString () );
                        }
                        return parentComposite;
                    }
                };
                controller.create ();
                info.getDetailsPart ().setVisibilityController ( controller );
                this.detailParts.add ( info.getDetailsPart () );
            }
        }
        catch ( final CoreException e )
        {
            Activator.getDefault ().getLog ().log ( e.getStatus () );
        }
        if ( !this.detailParts.isEmpty () )
        {
            this.tabFolder.setSelection ( 0 );
        }

    }

    private Collection<DetailsPartInformation> getPartInformation () throws CoreException
    {
        final List<DetailsPartInformation> result = new LinkedList<DetailsPartInformation> ();

        for ( final IConfigurationElement element : Platform.getExtensionRegistry ().getConfigurationElementsFor ( Activator.EXTP_DETAILS_PART ) )
        {
            if ( !"detailsPart".equals ( element.getName () ) ) //$NON-NLS-1$
            {
                continue;
            }
            final Object o = element.createExecutableExtension ( "class" ); //$NON-NLS-1$

            if ( ! ( o instanceof DetailsPart ) )
            {
                throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "DetailsPart is not of type 'DetailsPart'" ) ); //$NON-NLS-1$
            }

            final DetailsPartInformation info = new DetailsPartInformation ();
            info.setDetailsPart ( (DetailsPart)o );
            info.setLabel ( element.getAttribute ( "name" ) ); //$NON-NLS-1$
            info.setSortKey ( element.getAttribute ( "sortKey" ) ); //$NON-NLS-1$
            result.add ( info );
        }

        Collections.sort ( result, new Comparator<DetailsPartInformation> () {

            @Override
            public int compare ( final DetailsPartInformation arg0, final DetailsPartInformation arg1 )
            {
                String key1 = arg0.getSortKey ();
                String key2 = arg1.getSortKey ();
                if ( key1 == null )
                {
                    key1 = ""; //$NON-NLS-1$
                }
                if ( key2 == null )
                {
                    key2 = ""; //$NON-NLS-1$
                }

                return key1.compareTo ( key2 );
            }
        } );

        return result;
    }

    private void createHeader ( final Composite parent )
    {
        this.header = new DataItemHeaderLabel ( parent );
        this.header.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );
    }

    private void handleDispose ()
    {
        for ( final DetailsPart part : this.detailParts )
        {
            part.dispose ();
        }
        disposeDataItem ();

        this.resourceManager.dispose ();
    }

    /**
     * set the current data item
     * 
     * @param item
     *            data item or <code>null</code> if none should be selected
     */
    public void setDataItem ( final Item item )
    {
        disposeDataItem ();

        if ( item != null )
        {
            this.header.subscribe ( Activator.getDefault ().getBundle ().getBundleContext (), item );

            this.dataItem = new DataItemHolder ( Activator.getDefault ().getBundle ().getBundleContext (), item, new DataSourceListener () {

                @Override
                public void updateData ( final DataItemValue value )
                {
                    DetailsViewComposite.this.updateData ( value );
                }
            } );

            for ( final DetailsPart part : this.detailParts )
            {
                part.setDataItem ( this.dataItem );
            }
        }
        else
        {
            this.header.unsubscribe ();

            // clear
            for ( final DetailsPart part : this.detailParts )
            {
                part.setDataItem ( null );
            }
        }
    }

    protected void updateData ( final DataItemValue value )
    {
        this.display.asyncExec ( new Runnable () {
            @Override
            public void run ()
            {
                for ( final DetailsPart part : DetailsViewComposite.this.detailParts )
                {
                    part.updateData ( value );
                }
            }
        } );

    }

    private void disposeDataItem ()
    {
        if ( this.dataItem != null )
        {
            this.dataItem.dispose ();
            this.dataItem = null;
        }
    }

}
