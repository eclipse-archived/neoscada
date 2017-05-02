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

import org.eclipse.scada.configuration.component.PersistentValue;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;

public class PersistentValueGenerator extends AbstractSingleValueGenerator
{
    private final PersistentValue persistentValue;

    public PersistentValueGenerator ( final PersistentValue persistentValue )
    {
        super ( persistentValue );
        this.persistentValue = persistentValue;
    }

    @Override
    protected CreationRequest<?> createRequest ( final ItemCreator itemCreator )
    {
        return itemCreator.createPersistentItem ().localTags ( this.persistentValue.getName () );
    }
}
