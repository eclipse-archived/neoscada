/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.part;

import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.da.client.dataitem.details.VisibilityController;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.services.IDisposable;

public interface DetailsPart extends IDisposable
{
    /**
     * create the details area
     * 
     * @param parent
     *            the parent composite
     */
    public void createPart ( Composite parent );

    /**
     * set to update the item instance
     * 
     * @param item
     *            the data item
     */
    public void setDataItem ( DataItemHolder item );

    /**
     * Update data from the data item
     * <p>
     * Will be called in the display thread
     * </p>
     * 
     * @param value
     *            the current value or <code>null</code> if the data item is not connected
     */
    public void updateData ( DataItemValue value );

    public void setVisibilityController ( VisibilityController visibilityController );
}
