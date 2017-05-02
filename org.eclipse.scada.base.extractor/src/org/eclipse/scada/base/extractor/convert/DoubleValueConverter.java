/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.base.extractor.convert;

import org.eclipse.scada.core.Variant;

public class DoubleValueConverter implements ValueConverter
{

    @Override
    public Variant convert ( final String input )
    {
        return Variant.valueOf ( Double.parseDouble ( input ) );
    }

}
