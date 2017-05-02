/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.chart.swt;

public interface ChartMouseListener
{
    public static class MouseState
    {
        public int button;

        public int state;

        public int x, y;
    };

    public void onMouseDown ( MouseState state );

    public void onMouseUp ( MouseState state );

    public void onMouseDoubleClick ( MouseState state );
}
