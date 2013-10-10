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
package org.eclipse.scada.da.server.common.chain.item;

/**
 * A chain item that sums up error attributes and generates an error state
 * 
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 */
public class SumErrorChainItem extends SumPatternAttributesChainItem
{
    public SumErrorChainItem ()
    {
        super ( "error", ".*\\.error$" );
    }
}
