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

import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.FormulaModule;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.component.Script;
import org.eclipse.scada.configuration.component.lib.Items;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.FormulaItem;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.TypedItemReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormulaModuleGenerator extends CalculationComponentGenerator<FormulaModule>
{

    final static Logger logger = LoggerFactory.getLogger ( FormulaModuleGenerator.class );

    private final Map<MasterServer, FormulaItem> danglingMap = new HashMap<> ();

    public FormulaModuleGenerator ( final CalculationComponent calculationComponent )
    {
        super ( calculationComponent, FormulaModule.class );
    }

    public CreationRequest<FormulaItem> createFormulaItem ( final ItemCreator creator )
    {
        final FormulaItem formulaItem = OsgiFactory.eINSTANCE.createFormulaItem ();
        return creator.addItem ( formulaItem );
    }

    @Override
    protected void createItems ( final ItemCreator creator, final FormulaModule implementation )
    {
        final OutputDefinition output = Calculations.findSingleByName ( this.calculationComponent.getOutputs (), "output" );
        final OutputSpecification outputSpec = Calculations.findSpecification ( implementation, output );

        // create the item
        final CreationRequest<FormulaItem> c = createFormulaItem ( creator );
        c.dataType ( outputSpec.getDataType () );
        c.customizationTags ( "input" ); //$NON-NLS-1$ // the output of a calculation module is an input for the system
        c.localTags ( output.getLocalTag () );

        c.addMasterListener ( new MasterListener<FormulaItem> () {

            @Override
            public void setMaster ( final FormulaItem item, final MasterServer master )
            {
                FormulaModuleGenerator.this.danglingMap.put ( master, item );
            }
        } );

        final FormulaItem item = c.create ();

        item.setScriptEngine ( implementation.getScriptEngine () );
        item.setInbound ( OsgiFactory.eINSTANCE.createFormulaItemInbound () );

        for ( final Script script : implementation.getInit () )
        {
            final CodeFragment code = OsgiFactory.eINSTANCE.createCodeFragment ();
            code.setCode ( script.getCode () );
            item.getInitScripts ().add ( code );
        }

        if ( implementation.getUpdate () != null )
        {
            item.getInbound ().setInputFormula ( implementation.getUpdate ().getCode () );
        }

        // FIXME: add write command

        for ( final InputDefinition input : this.calculationComponent.getInputs () )
        {
            final TypedItemReference typedRef = OsgiFactory.eINSTANCE.createTypedItemReference ();
            typedRef.setItem ( input.createReference () );
            typedRef.setName ( input.getName () );
            typedRef.setType ( DataType.VARIANT ); // FIXME: this should be configurable

            item.getInbound ().getInputs ().add ( typedRef );
        }
    }

    @Override
    protected void generateForMaster ( final GenerationContext context, final MasterContext master, final FormulaModule implementation )
    {
    }

    @Override
    public void finish ( final FinishContext context )
    {
        super.finish ( context );
        for ( final Map.Entry<MasterServer, FormulaItem> entry : this.danglingMap.entrySet () )
        {
            final MasterServer master = entry.getKey ();
            final FormulaItem formulaItem = entry.getValue ();

            if ( formulaItem.getInbound () != null )
            {
                for ( final TypedItemReference in : formulaItem.getInbound ().getInputs () )
                {
                    in.setItem ( Items.replaceDanglingReference ( this.context, master, in.getItem () ) );
                }
            } // if - inbound
        }
    }
}
