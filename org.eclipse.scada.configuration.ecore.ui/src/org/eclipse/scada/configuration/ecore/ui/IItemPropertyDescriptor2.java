/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ecore.ui;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;

public interface IItemPropertyDescriptor2 extends IItemPropertyDescriptor
{
    /**
     * Create a custom cell editor for the property entry
     *
     * @param composite
     *            the composite for the cell editor
     * @param object
     *            the object to create the cell editor for
     * @return a new instance of {@link CellEditor} or <code>null</code> if the
     *         default cell editor should be used
     */
    public CellEditor createPropertyEditor ( Composite composite, Object object );
}
