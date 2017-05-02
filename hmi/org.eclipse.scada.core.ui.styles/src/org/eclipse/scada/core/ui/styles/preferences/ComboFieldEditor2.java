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
package org.eclipse.scada.core.ui.styles.preferences;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.widgets.Composite;

/**
 * This is a dirty hack
 */
class ComboFieldEditor2 extends ComboFieldEditor
{

    public ComboFieldEditor2 ( final String name, final String labelText, final String[][] entryNamesAndValues, final Composite parent )
    {
        super ( name, labelText, entryNamesAndValues, parent );
    }

    interface Callback
    {
        void valueChange ( Object value );
    }

    private Callback callback;

    public void setCallback ( final Callback callback )
    {
        this.callback = callback;
    }

    @Override
    protected void fireValueChanged ( final String property, final Object oldValue, final Object newValue )
    {
        if ( VALUE.equals ( property ) )
        {
            if ( this.callback != null )
            {
                SafeRunner.run ( new SafeRunnable () {

                    @Override
                    public void run () throws Exception
                    {
                        ComboFieldEditor2.this.callback.valueChange ( newValue );
                    }
                } );
            }
        }
        super.fireValueChanged ( property, oldValue, newValue );
    }

}
