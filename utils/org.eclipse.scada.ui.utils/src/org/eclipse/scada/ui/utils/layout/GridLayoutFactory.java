/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.utils.layout;

import org.eclipse.swt.layout.GridLayout;

public class GridLayoutFactory
{
    public static GridLayout slim ( final int numColumns, final boolean makeColumnsEqualWidth )
    {
        final GridLayout layout = new GridLayout ( numColumns, makeColumnsEqualWidth );

        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.verticalSpacing = 0;
        layout.horizontalSpacing = 0;

        return layout;
    }

    public static GridLayout slimStack ()
    {
        return slim ( 1, true );
    }
}
