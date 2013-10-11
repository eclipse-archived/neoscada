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
package org.eclipse.scada.da.client.test.views.realtime;

import org.eclipse.scada.da.ui.widgets.realtime.DoubleClickShowDetailsHandler;
import org.eclipse.scada.da.ui.widgets.realtime.RealTimeListViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

public class RealTimeList extends ViewPart
{

    public static final String VIEW_ID = "org.eclipse.scada.da.test.views.RealTimeList";

    private final RealTimeListViewer viewer;

    public RealTimeList ()
    {
        this.viewer = new RealTimeListViewer ();
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.viewer.createControl ( parent );
        this.viewer.contribueTo ( getViewSite () );
        this.viewer.addDoubleClickListener ( new DoubleClickShowDetailsHandler () );
    }

    @Override
    public void dispose ()
    {
        this.viewer.dispose ();
        super.dispose ();
    }

    @Override
    public void setFocus ()
    {
        this.viewer.setFocus ();
    }

    @Override
    public void saveState ( final IMemento memento )
    {
        super.saveState ( memento );
        this.viewer.saveTo ( memento );
    }

    @Override
    public void init ( final IViewSite site, final IMemento memento ) throws PartInitException
    {
        super.init ( site, memento );
        this.viewer.loadFrom ( memento );
    }
}
