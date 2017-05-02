/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.views;

public class ColumnProperties
{
    private int no;

    private int width;

    public ColumnProperties ()
    {
    }

    public ColumnProperties ( final int no, final int width )
    {
        this.no = no;
        this.width = width;
    }

    public int getNo ()
    {
        return this.no;
    }

    public void setNo ( final int no )
    {
        this.no = no;
    }

    public int getWidth ()
    {
        return this.width;
    }

    public void setWidth ( final int width )
    {
        this.width = width;
    }
}
