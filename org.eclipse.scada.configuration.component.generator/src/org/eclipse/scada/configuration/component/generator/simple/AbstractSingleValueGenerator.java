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

import org.eclipse.scada.configuration.component.SingleValue;
import org.eclipse.scada.configuration.component.generator.DataComponentGenerator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;

public abstract class AbstractSingleValueGenerator extends DataComponentGenerator
{
    private final SingleValue singleValue;

    public AbstractSingleValueGenerator ( final SingleValue singleValue )
    {
        super ( singleValue );
        this.singleValue = singleValue;
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        final CreationRequest<?> request = createRequest ( itemCreator );
        request.localTags ( this.singleValue.getName () );
        request.dataType ( this.singleValue.getDataType () );
        request.customizationTags ( this.singleValue.getCustomizationTags () );
        request.create ();
    }

    protected abstract CreationRequest<?> createRequest ( ItemCreator itemCreator );
}