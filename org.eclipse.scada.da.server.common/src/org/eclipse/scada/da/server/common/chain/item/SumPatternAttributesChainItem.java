/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
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

import java.util.regex.Pattern;

import org.eclipse.scada.core.Variant;

/**
 * A chain item that summarizes based on a pattern.
 * 
 * @author Jens Reimann &lt;jens.reimann@th4-systems.com&gt;
 */
public class SumPatternAttributesChainItem extends SummarizeChainItem
{
    private final Pattern pattern;

    public SumPatternAttributesChainItem ( final String baseName, final String pattern )
    {
        this ( baseName, Pattern.compile ( pattern ) );
    }

    public SumPatternAttributesChainItem ( final String baseName, final Pattern pattern )
    {
        super ( baseName );

        this.pattern = pattern;
    }

    @Override
    protected boolean matches ( final Variant value, final String attributeName, final Variant attributeValue )
    {
        return this.pattern.matcher ( attributeName ).matches ();
    }

}
