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
package org.eclipse.scada.ui.databinding.cell;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ViewerCell;

public class DefaultEditingSupport extends ObservableValueEditingSupport
{
    private final IValueProperty cellEditorProperty;

    private final CellEditor cellEditor;

    private final IValueProperty elementProperty;

    private final DataBindingContext dbc;

    public DefaultEditingSupport ( final ColumnViewer viewer, final DataBindingContext dbc, final IValueProperty cellEditorProperty, final CellEditor cellEditor, final IValueProperty elementProperty )
    {
        super ( viewer, dbc );
        this.cellEditorProperty = cellEditorProperty;
        this.cellEditor = cellEditor;
        this.elementProperty = elementProperty;
        this.dbc = dbc;
    }

    @Override
    protected IObservableValue doCreateCellEditorObservable ( final CellEditor cellEditor )
    {
        return this.cellEditorProperty.observe ( cellEditor );
    }

    @Override
    protected IObservableValue doCreateElementObservable ( final Object element, final ViewerCell cell )
    {
        return this.elementProperty.observe ( element );
    }

    @Override
    protected Binding createBinding ( final IObservableValue target, final IObservableValue model )
    {
        return this.dbc.bindValue ( target, model, createTargetToModelStrategy (), createModelToTargetStrategy () );
    }

    protected UpdateValueStrategy createTargetToModelStrategy ()
    {
        return new UpdateValueStrategy ( UpdateValueStrategy.POLICY_CONVERT );
    }

    protected UpdateValueStrategy createModelToTargetStrategy ()
    {
        return null;
    }

    @Override
    protected CellEditor getCellEditor ( final Object element )
    {
        return this.cellEditor;
    }
}