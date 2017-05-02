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
package org.eclipse.scada.core.ui.connection.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.scada.core.ui.connection.Activator;

public class ConnectionView extends CommonNavigator
{

    @Override
    protected CommonViewer createCommonViewerObject ( final Composite aParent )
    {
        // quick fix to automatically expand some content
        final CommonViewer result = super.createCommonViewerObject ( aParent );
        result.setAutoExpandLevel ( 2 );
        return result;
    }

    @Override
    protected Object getInitialInput ()
    {
        return Activator.ROOT;
    }
}
