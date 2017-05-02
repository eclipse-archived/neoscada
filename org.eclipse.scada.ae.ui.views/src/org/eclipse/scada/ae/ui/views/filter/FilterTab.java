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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public interface FilterTab
{
    public String getName ();

    public Control createControl ( Composite parent, FilterChangedListener filterChangedListener, int style, String filter );
}
