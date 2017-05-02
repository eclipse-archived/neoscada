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
package org.eclipse.scada.ca.ui.editor.config;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.EditorPart;

public abstract class AbstractConfigurationEditor extends EditorPart
{

    private IObservableValue dirtyValue;

    private final boolean nested;

    public AbstractConfigurationEditor ( final boolean nested )
    {
        this.nested = nested;
    }

    @Override
    public boolean isSaveAsAllowed ()
    {
        return false;
    }

    @Override
    public void doSave ( final IProgressMonitor monitor )
    {
        final ConfigurationEditorInput input = getEditorInput ();
        input.performSave ( monitor );
    }

    @Override
    public void doSaveAs ()
    {
    }

    @Override
    public boolean isDirty ()
    {
        if ( this.dirtyValue == null )
        {
            return false;
        }

        final Object value = this.dirtyValue.getValue ();
        if ( ! ( value instanceof Boolean ) )
        {
            return false;
        }

        return (Boolean)value;
    }

    @Override
    protected void setInput ( final IEditorInput input )
    {
        final ConfigurationEditorInput configurationInput = (ConfigurationEditorInput)input;

        if ( !this.nested )
        {
            configurationInput.performLoad ( new NullProgressMonitor () );
        }

        this.dirtyValue = configurationInput.getDirtyValue ();
        this.dirtyValue.addValueChangeListener ( new IValueChangeListener () {

            @Override
            public void handleValueChange ( final ValueChangeEvent event )
            {
                firePropertyChange ( IEditorPart.PROP_DIRTY );
            }
        } );

        super.setInput ( input );
    }

    @Override
    public ConfigurationEditorInput getEditorInput ()
    {
        return (ConfigurationEditorInput)super.getEditorInput ();
    }

    public void updateEntry ( final String oldKey, final String key, final String value )
    {
        getEditorInput ().updateEntry ( oldKey, key, value );
    }

    public void insertEntry ( final String key, final String value )
    {
        getEditorInput ().insertEntry ( key, value );
    }

    public void deleteEntry ( final String key )
    {
        getEditorInput ().deleteEntry ( key );
    }

}