/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ui.databinding.item;

import org.eclipse.scada.da.client.DataItemValue;

/**
 * Policy that defined what happens with invalid values
 * 
 * @author Jens Reimann
 * @since 1.0.0
 */
public interface InvalidValuePolicy
{
    /**
     * Checks if a value is considered invalid
     * 
     * @param value
     *            the value to check
     * @return <code>true</code> if the value is considered invalid,
     *         <code>false</code> false otherwise
     */
    public boolean isInvalid ( DataItemValue value );

    /**
     * Process the invalid value
     * 
     * @param value
     *            the input value, may be <code>null</code>
     * @return the output value, may be <code>null</code>
     */
    public DataItemValue processInvalid ( DataItemValue value );
}
