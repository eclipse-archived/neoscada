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
package org.eclipse.scada.configuration.component.generator.calc;

import org.eclipse.scada.configuration.component.ChangeCounter;
import org.eclipse.scada.configuration.component.generator.simple.AbstractSingleValueGenerator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;

public class ChangeCounterGenerator  extends AbstractSingleValueGenerator
{
    private ChangeCounter changeCounter;

    public ChangeCounterGenerator ( ChangeCounter changeCounter )
    {
        super ( changeCounter );
        this.changeCounter = changeCounter;
    }

    @Override
    protected CreationRequest<?> createRequest ( ItemCreator itemCreator )
    {
        return null;
    }
}
