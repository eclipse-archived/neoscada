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
package org.eclipse.scada.vi.details.swt.impl.visibility;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.details.swt.impl.GroupTab;
import org.eclipse.scada.vi.details.swt.impl.tab.TabProvider.Folder;
import org.eclipse.swt.widgets.Control;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A visibility component for TabFolders
 * <p>
 * The provided control will be disposed when this component is disposed.
 * </p>
 * 
 * @author Jens Reimann
 */
public class TabVisibleComponent implements VisibleComponent
{

    private final static Logger logger = LoggerFactory.getLogger ( TabVisibleComponent.class );

    private final Folder folder;

    private final Control control;

    private final GroupTab groupTab;

    public TabVisibleComponent ( final Folder folder, final int index, final GroupTab groupTab, final Control control )
    {
        this.folder = folder;
        this.control = control;
        this.groupTab = groupTab;
    }

    @Override
    public void show ()
    {
        logger.debug ( "Showing tab ... " );

        this.folder.setVisible ( true );
    }

    @Override
    public void hide ()
    {
        this.folder.setVisible ( false );
    }

    @Override
    public void create ()
    {
        show ();
    }

    @Override
    public void dispose ()
    {
        hide ();
        this.folder.dispose ();
        this.control.dispose ();
    }

    @Override
    public IObservableSet getDescriptors ()
    {
        return this.groupTab.getDescriptors ();
    }

    @Override
    public void start ()
    {
        this.groupTab.start ();
    }

    @Override
    public void stop ()
    {
        this.groupTab.stop ();
    }

    @Override
    public SummaryProvider getSummaryProvider ()
    {
        return this.groupTab.getSummaryProvider ();
    }
}
