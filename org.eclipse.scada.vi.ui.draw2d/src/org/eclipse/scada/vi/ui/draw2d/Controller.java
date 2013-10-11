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
package org.eclipse.scada.vi.ui.draw2d;

import org.eclipse.draw2d.IFigure;

public interface Controller
{
    /**
     * Return the figure that should be added to the parent
     * 
     * @return the figure to use for visualization
     */
    public IFigure getFigure ();

}
