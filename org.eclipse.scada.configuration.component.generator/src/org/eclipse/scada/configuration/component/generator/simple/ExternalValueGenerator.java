/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator.simple;

import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;

public class ExternalValueGenerator extends AbstractSingleValueGenerator
{
    private final ExternalValue externalValue;

    public ExternalValueGenerator ( final ExternalValue externalValue )
    {
        super ( externalValue );
        this.externalValue = externalValue;
    }

    @Override
    protected CreationRequest<?> createRequest ( final ItemCreator itemCreator )
    {
        return itemCreator.createSourceItem ( this.externalValue.getConnection (), this.externalValue.getSourceName () );
    }
}
