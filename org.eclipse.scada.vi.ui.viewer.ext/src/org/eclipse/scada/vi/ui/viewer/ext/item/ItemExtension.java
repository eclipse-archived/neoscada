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
package org.eclipse.scada.vi.ui.viewer.ext.item;

import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.scada.vi.ui.user.viewer.ext.ViewerExtension;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ItemExtension extends AbstractItemExtension implements ViewerExtension
{

    @Override
    public Control create ( final Composite composite, final ViewManager viewManager, final boolean horizontal )
    {
        return new PlainDataItemLabel ( composite, this.connectionId, this.itemId ).getControl ();
    }

}
