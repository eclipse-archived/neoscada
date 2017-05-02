/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.swt.widgets.Composite;

public interface CallbackWidgetFactory
{
    /**
     * Create controls inside a 2 column grid
     * 
     * @param dbc
     *            the data binding context
     * @param composite
     *            the 2 column grid composite
     */
    public void createGridWidgets ( DataBindingContext dbc, Composite composite );

    /**
     * Complete the data entry
     * <p>
     * This can be used as the last point where the callback data can be updated
     * before it is sent to the requester
     * </p>
     */
    public void complete ();

    public boolean tryInstantComplete ();
}
