/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.filter;

import org.eclipse.scada.ae.ui.views.dialog.FilterChangedListener;
import org.eclipse.scada.ae.ui.views.dialog.FilterFreeFormComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class FreeFormTab implements FilterTab
{

    @Override
    public String getName ()
    {
        return Messages.FreeFormTab_Name;
    }

    @Override
    public Control createControl ( final Composite parent, final FilterChangedListener filterChangedListener, final int style, final String filter )
    {
        return new FilterFreeFormComposite ( filterChangedListener, parent, style, filter );
    }

}
