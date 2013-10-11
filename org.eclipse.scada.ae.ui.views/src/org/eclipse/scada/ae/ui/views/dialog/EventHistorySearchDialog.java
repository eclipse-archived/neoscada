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
package org.eclipse.scada.ae.ui.views.dialog;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.ae.ui.views.Messages;
import org.eclipse.scada.ae.ui.views.filter.FilterTab;
import org.eclipse.scada.ae.ui.views.filter.FreeFormTab;
import org.eclipse.scada.ae.ui.views.filter.QueryByExampleTab;
import org.eclipse.scada.utils.lang.Pair;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.statushandlers.StatusManager;

public class EventHistorySearchDialog extends TitleAreaDialog implements FilterChangedListener
{
    private static final String EXTP_FILTER_TAB = "org.eclipse.scada.ae.ui.views.filterTab";

    private final Pair<SearchType, String> initialFilter;

    private Pair<SearchType, String> filter;

    private EventHistorySearchDialog ( final Shell parentShell, final Pair<SearchType, String> filter )
    {
        super ( parentShell );
        this.initialFilter = filter;
        this.filter = null;
    }

    protected List<FilterTab> getFilterTabs ()
    {
        final List<FilterTab> result = new LinkedList<FilterTab> ();

        result.add ( new QueryByExampleTab () );
        result.add ( new FreeFormTab () );

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_FILTER_TAB ) )
        {
            if ( !"filterTab".equals ( ele.getName () ) )
            {
                continue;
            }

            try
            {
                result.add ( (FilterTab)ele.createExecutableExtension ( "class" ) );
            }
            catch ( final CoreException e )
            {
                StatusManager.getManager ().handle ( e.getStatus () );
            }
        }

        return result;
    }

    @Override
    protected Control createDialogArea ( final Composite parent )
    {
        // initialize header area
        setTitle ( Messages.search_for_events );
        setMessage ( Messages.search_for_events_description );
        // setHelpAvailable ( true );

        // initialize content
        final Composite rootComposite = (Composite)super.createDialogArea ( parent );

        String filterString = ""; //$NON-NLS-1$
        if ( this.initialFilter != null && this.initialFilter.second != null )
        {
            filterString = this.initialFilter.second;
        }

        final TabFolder tabFolder = new TabFolder ( rootComposite, SWT.NONE );

        // create tabs
        for ( final FilterTab tab : getFilterTabs () )
        {
            final TabItem tabItem = new TabItem ( tabFolder, SWT.NONE );
            tabItem.setText ( tab.getName () );
            tabItem.setControl ( tab.createControl ( tabFolder, this, SWT.NONE, filterString ) );
        }

        final GridData layoutData = new GridData ();
        layoutData.horizontalAlignment = GridData.FILL;
        layoutData.grabExcessHorizontalSpace = true;
        layoutData.verticalAlignment = GridData.FILL;
        layoutData.grabExcessVerticalSpace = true;
        tabFolder.setLayoutData ( layoutData );

        selectInitialFilterPage ( tabFolder );

        return rootComposite;
    }

    private void selectInitialFilterPage ( final TabFolder tabFolder )
    {
        if ( this.initialFilter == null )
        {
            return;
        }

        switch ( this.initialFilter.first )
        {
            case SIMPLE:
                tabFolder.setSelection ( 0 );
                break;
            case FREEFORM:
                tabFolder.setSelection ( 1 );
                break;
            case ADVANCED:
                break;
        }
    }

    @Override
    public boolean close ()
    {
        if ( getReturnCode () != Window.OK )
        {
            this.filter = null;
        }
        return super.close ();
    }

    public Pair<SearchType, String> getFilter ()
    {
        return this.filter;
    }

    public static Pair<SearchType, String> open ( final Shell parentShell, final Pair<SearchType, String> filter )
    {
        final EventHistorySearchDialog dialog = new EventHistorySearchDialog ( parentShell, filter );
        dialog.open ();
        return dialog.getFilter ();
    }

    @Override
    public void onFilterChanged ( final Pair<SearchType, String> filter )
    {
        this.filter = filter;
    }

    @Override
    public void onFilterParseError ( final Pair<SearchType, String> error )
    {
        setErrorMessage ( error.second );
    }
}
