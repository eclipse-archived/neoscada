/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.common.chain;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.core.WriteAttributeResults;

/**
 * A chain element
 * <p>
 * An instance of chain element may only be added to one data item
 * 
 * @author Jens Reimann
 */
public interface ChainItem
{
    /**
     * Request to set attributes
     * 
     * @param attributes
     *            the attributes update set
     * @return result for processed attributes
     */
    public abstract WriteAttributeResults setAttributes ( Map<String, Variant> attributes );

    /**
     * Process the chain item
     * 
     * @return the new result or <code>null</code> if the chain item does not
     *         change the input value
     * @param value
     *            the value to process or <code>null</code> if a output item
     *            changed only the attributes
     * @param attributes
     *            The current primary attributes
     */
    public abstract Variant process ( Variant value, Map<String, Variant> attributes );

}
