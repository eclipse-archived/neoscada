/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator.calc;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.MovingAverageModule;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.component.lib.Items;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.MovingAverage;
import org.eclipse.scada.configuration.world.osgi.MovingAverageItem;
import org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.utils.str.StringHelper;

public class MovingAverageModuleGenerator extends CalculationComponentGenerator<MovingAverageModule>
{
    private final Map<MasterServer, MovingAverage> danglingMap = new HashMap<> ();

    private final Map<MasterServer, MovingAverage> map = new HashMap<> ();

    public MovingAverageModuleGenerator ( final CalculationComponent calculationComponent )
    {
        super ( calculationComponent, MovingAverageModule.class );
    }

    public CreationRequest<MovingAverageItem> createAverageItem ( final ItemCreator creator, final MovingAverageReferenceType type )
    {
        final MovingAverageItem averageItem = OsgiFactory.eINSTANCE.createMovingAverageItem ();
        averageItem.setType ( type );

        return creator.addItem ( averageItem );
    }

    @Override
    public void createItems ( final ItemCreator creator, final MovingAverageModule implementation )
    {
        for ( final OutputDefinition output : this.calculationComponent.getOutputs () )
        {
            final OutputSpecification outputSpec = Calculations.findSpecification ( implementation, output );

            final MovingAverageReferenceType type = MovingAverageReferenceType.get ( output.getName () );
            if ( type == null )
            {
                throw new IllegalStateException ( String.format ( "Moving average reference type %s is unknown. Use any of: %s.", output.getName (), StringHelper.join ( MovingAverageReferenceType.values (), ", " ) ) );
            }

            final CreationRequest<MovingAverageItem> c = createAverageItem ( creator, type );
            c.localTags ( output.getLocalTag () );
            c.customizationTags ( output.getCustomizationTags () );// the output of a calculation module is an input for the system
            c.dataType ( outputSpec.getDataType () );

            c.addMasterListener ( new MasterListener<MovingAverageItem> () {
                @Override
                public void setMaster ( final MovingAverageItem item, final MasterContext master )
                {
                    final MovingAverage average = MovingAverageModuleGenerator.this.map.get ( master.getImplementation () );

                    item.setSource ( average );
                }
            } );

            c.create ();
        }
    }

    @Override
    protected void generateForMaster ( final GenerationContext context, final MasterContext master, final MovingAverageModule implementation )
    {
        final MovingAverage average = OsgiFactory.eINSTANCE.createMovingAverage ();
        average.setName ( makeId () );
        master.getImplementation ().getMovingAverages ().add ( average );

        average.setNullRange ( implementation.getNullRange () );
        average.setRange ( implementation.getRange () );
        average.setTrigger ( implementation.getTrigger () );
        average.setTriggerOnly ( implementation.isTriggerOnly () );

        this.map.put ( master.getImplementation (), average );
        this.danglingMap.put ( master.getImplementation (), average );

        final InputDefinition input = Calculations.findSingleInputByName ( this.calculationComponent.getInputs (), "input" );
        if ( input == null )
        {
            throw new IllegalStateException ( "Moving average must contain have an input item set" );
        }

        average.setItem ( input.createReference () );
    }

    @Override
    public void finish ( final FinishContext context )
    {
        for ( final Map.Entry<MasterServer, MovingAverage> entry : this.danglingMap.entrySet () )
        {
            entry.getValue ().setItem ( Items.replaceDanglingReference ( this.context, entry.getKey (), entry.getValue ().getItem () ) );
        }
        super.finish ( context );
    }
}
