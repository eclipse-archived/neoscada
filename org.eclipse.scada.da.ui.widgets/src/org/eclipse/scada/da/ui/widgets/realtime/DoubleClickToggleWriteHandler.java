/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.ui.widgets.realtime;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.ui.databinding.SelectionHelper;

public class DoubleClickToggleWriteHandler implements IDoubleClickListener
{

    @Override
    public void doubleClick ( final DoubleClickEvent event )
    {
        for ( final ListEntry entry : SelectionHelper.iterable ( event.getSelection (), ListEntry.class ) )
        {
            final Variant value = entry.getValue ();
            if ( value == null )
            {
                return;
            }

            Variant writeValue;

            if ( value.isBoolean () )
            {
                writeValue = Variant.valueOf ( !value.asBoolean () );
            }
            else if ( value.isNull () )
            {
                writeValue = Variant.TRUE;
            }
            else
            {
                writeValue = null;
            }

            if ( writeValue != null )
            {
                entry.getDataItem ().write ( writeValue, null, new DisplayCallbackHandler ( event.getViewer ().getControl ().getShell (), "Write Data", "Confirmation of write request required" ) );
            }
        }
    }
}
