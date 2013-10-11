/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.part;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.dataitem.details.VisibilityController;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class AbstractBaseDetailsPart implements DetailsPart
{
    protected Display display;

    protected DataItemHolder item;

    protected DataItemValue value;

    protected Shell shell;

    private boolean disposed;

    protected void setShell ( final Shell shell )
    {
        this.shell = shell;
        this.display = shell.getDisplay ();
    }

    @Override
    public void createPart ( final Composite parent )
    {
        setShell ( parent.getShell () );
    }

    @Override
    public void setDataItem ( final DataItemHolder item )
    {
        this.item = item;
    }

    @Override
    public void dispose ()
    {
        this.disposed = true;
    }

    @Override
    public void updateData ( final DataItemValue value )
    {
        this.value = value;
        if ( !this.disposed )
        {
            update ();
        }
    }

    /**
     * Internal data was updated.
     * <p>
     * This method is called inside the display thread.
     * </p>
     */
    protected abstract void update ();

    /**
     * Return if the value is unsafe
     * 
     * @return <code>true</code> if the value part is unsafe, <code>false</code>
     *         otherwise
     */
    protected boolean isUnsafe ()
    {
        return this.value.isError () || !this.value.isConnected ();
    }

    protected boolean isError ()
    {
        return this.value.isError ();
    }

    protected boolean isAlarm ()
    {
        return this.value.isAlarm ();
    }

    protected boolean isManual ()
    {
        return this.value.isManual ();
    }

    protected boolean isForceActive ()
    {
        return Boolean.getBoolean ( "org.eclipse.scada.da.client.dataitem.details.extra.forceActive" ); //$NON-NLS-1$
    }

    protected boolean getBooleanAttribute ( final String name )
    {
        if ( this.value.getAttributes ().containsKey ( name ) )
        {
            return this.value.getAttributes ().get ( name ).asBoolean ();
        }
        return false;
    }

    protected DataItemValue getValue ()
    {
        return this.value;
    }

    protected Number getNumberAttribute ( final String name, final Number defaultValue )
    {
        final Variant value = this.value.getAttributes ().get ( name );

        if ( value == null )
        {
            return defaultValue;
        }
        if ( value.isNull () )
        {
            return defaultValue;
        }

        try
        {
            if ( value.isDouble () )
            {
                return value.asDouble ();
            }
            if ( value.isInteger () )
            {
                return value.asInteger ();
            }
            if ( value.isLong () )
            {
                return value.asLong ();
            }
            if ( value.isBoolean () )
            {
                return value.asBoolean () ? 1 : 0;
            }
            return Double.parseDouble ( value.asString () );
        }
        catch ( final Throwable e )
        {
        }

        return defaultValue;
    }

    /**
     * Checks if the current value has the attribute set
     * 
     * @param attributeName
     *            the attribute name to check
     * @return <code>true</code> if the current value is available and the
     *         attribute is set
     */
    protected boolean hasAttribute ( final String attributeName )
    {
        final DataItemValue value = this.value;
        if ( value == null )
        {
            return false;
        }
        if ( value.getAttributes () == null )
        {
            return false;
        }
        return value.getAttributes ().containsKey ( attributeName );
    }

    @Override
    public void setVisibilityController ( final VisibilityController visibilityController )
    {
        visibilityController.show ();
    }

}