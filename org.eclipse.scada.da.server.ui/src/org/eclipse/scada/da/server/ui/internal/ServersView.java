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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ServersView extends ViewPart
{
    public static final String VIEW_ID = "org.eclipse.scada.da.server.ui.ServersView";

    private ServersViewer viewer;

    public ServersView ()
    {
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        this.viewer = new ServersViewer ( parent );
        this.viewer.contributeTo ( getSite () );
    }

    @Override
    public void setFocus ()
    {
        this.viewer.setFocus ();
    }

}
