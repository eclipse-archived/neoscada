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

import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.Components;
import org.eclipse.scada.configuration.component.generator.DataComponentGenerator;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.lib.Names;

public abstract class CalculationComponentGenerator<Impl extends CalculationModule> extends DataComponentGenerator
{
    protected final CalculationComponent calculationComponent;

    private final Class<Impl> implementationClazz;

    public CalculationComponentGenerator ( final CalculationComponent calculationComponent, final Class<Impl> implementationClazz )
    {
        super ( calculationComponent );
        this.calculationComponent = calculationComponent;
        this.implementationClazz = implementationClazz;
    }

    @Override
    protected void generateForMaster ( final GenerationContext context, final MasterContext master )
    {
        if ( this.implementationClazz.isAssignableFrom ( this.calculationComponent.getImplementation ().getClass () ) )
        {
            generateForMaster ( context, master, this.implementationClazz.cast ( this.calculationComponent.getImplementation () ) );
        }
        super.generateForMaster ( context, master );
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        if ( this.implementationClazz.isAssignableFrom ( this.calculationComponent.getImplementation ().getClass () ) )
        {
            createItems ( itemCreator, this.implementationClazz.cast ( this.calculationComponent.getImplementation () ) );
        }
    }

    protected String makeId ()
    {
        return Components.makeFullQualified ( this.calculationComponent, Names.makeName ( this.calculationComponent ) );
    }

    protected abstract void createItems ( ItemCreator creator, Impl implementation );

    protected abstract void generateForMaster ( GenerationContext context, MasterContext master, Impl implementation );

}
