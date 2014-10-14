/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator.calc;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.generator.Generator;
import org.eclipse.scada.configuration.generator.GeneratorFactory;

public class CommonCalculationsFactory implements GeneratorFactory
{

    @Override
    public Collection<Generator> createGenerators ( final Object element )
    {
        if ( ! ( element instanceof CalculationComponent ) )
        {
            return null;
        }

        final Collection<Generator> result = new LinkedList<> ();

        result.add ( new MovingAverageModuleGenerator ( (CalculationComponent)element ) );
        result.add ( new AverageModuleGenerator ( (CalculationComponent)element ) );
        result.add ( new FormulaModuleGenerator ( (CalculationComponent)element ) );
        result.add ( new ScriptModuleGenerator ( (CalculationComponent)element ) );

        return result;
    }

}
