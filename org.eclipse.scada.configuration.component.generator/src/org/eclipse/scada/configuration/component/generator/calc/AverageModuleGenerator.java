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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.component.AverageModule;
import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.component.lib.Items;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.Average;
import org.eclipse.scada.configuration.world.osgi.AverageItem;
import org.eclipse.scada.configuration.world.osgi.AverageReferenceType;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.utils.str.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AverageModuleGenerator extends CalculationComponentGenerator<AverageModule>
{

    final static Logger logger = LoggerFactory.getLogger ( AverageModuleGenerator.class );

    private final Map<MasterServer, Average> danglingMap = new HashMap<> ();

    public AverageModuleGenerator ( final CalculationComponent calculationComponent )
    {
        super ( calculationComponent, AverageModule.class );
    }

    public CreationRequest<AverageItem> createAverageItem ( final ItemCreator creator, final AverageReferenceType type )
    {
        final AverageItem averageItem = OsgiFactory.eINSTANCE.createAverageItem ();
        averageItem.setType ( type );

        return creator.addItem ( averageItem );
    }

    private final Map<MasterServer, Average> map = new HashMap<> ();

    @Override
    public void createItems ( final ItemCreator creator, final AverageModule implementation )
    {
        for ( final OutputDefinition output : this.calculationComponent.getOutputs () )
        {
            final OutputSpecification outputSpec = Calculations.findSpecification ( implementation, output );

            final AverageReferenceType type = AverageReferenceType.get ( output.getName () );
            if ( type == null )
            {
                throw new IllegalStateException ( String.format ( "Average reference type %s is unknown. Use any of: %s.", output.getName (), StringHelper.join ( AverageReferenceType.values (), ", " ) ) );
            }
            final CreationRequest<AverageItem> c = createAverageItem ( creator, type );
            c.localTags ( output.getLocalTag () );
            c.customizationTags ( output.getCustomizationTags () );// the output of a calculation module is an input for the system
            c.dataType ( outputSpec.getDataType () );

            c.addMasterListener ( new MasterListener<AverageItem> () {
                @Override
                public void setMaster ( final AverageItem item, final MasterContext master )
                {
                    final Average average = AverageModuleGenerator.this.map.get ( master.getImplementation () );

                    item.setSource ( average );
                }
            } );

            c.create ();
        }
    }

    @Override
    protected void generateForMaster ( final GenerationContext context, final MasterContext master, final AverageModule implementation )
    {
        final Average average = OsgiFactory.eINSTANCE.createAverage ();
        average.setName ( makeId () );
        master.getImplementation ().getAverages ().add ( average );

        average.setSourcesRequired ( implementation.getValidSourcesRequired () );

        this.map.put ( master.getImplementation (), average );

        this.danglingMap.put ( master.getImplementation (), average );

        for ( final InputDefinition input : Calculations.findByName ( this.calculationComponent.getInputs (), "input" ) )
        {
            average.getItems ().add ( input.createReference () );
        }

        if ( average.getItems ().isEmpty () )
        {
            throw new IllegalStateException ( "Average must contain more than at least one item" );
        }
    }

    @Override
    public void finish ( final FinishContext context )
    {
        for ( final Map.Entry<MasterServer, Average> entry : this.danglingMap.entrySet () )
        {
            Items.replaceDanglingReferences ( this.context, entry.getKey (), entry.getValue ().getItems () );
        }
        super.finish ( context );
    }
}
