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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.component.Script;
import org.eclipse.scada.configuration.component.ScriptModule;
import org.eclipse.scada.configuration.component.lib.Items;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptModuleGenerator extends CalculationComponentGenerator<ScriptModule>
{

    final static Logger logger = LoggerFactory.getLogger ( ScriptModuleGenerator.class );

    private final Map<MasterServer, ScriptItem> danglingMap = new HashMap<> ();

    public ScriptModuleGenerator ( final CalculationComponent calculationComponent )
    {
        super ( calculationComponent, ScriptModule.class );
    }

    public CreationRequest<ScriptItem> createScriptItem ( final ItemCreator creator )
    {
        final ScriptItem item = OsgiFactory.eINSTANCE.createScriptItem ();
        return creator.addItem ( item );
    }

    @Override
    protected void createItems ( final ItemCreator creator, final ScriptModule implementation )
    {
        final OutputDefinition output = Calculations.findSingleByName ( this.calculationComponent.getOutputs (), "output" );
        final OutputSpecification outputSpec = Calculations.findSpecification ( implementation, output );

        // create the item
        final CreationRequest<ScriptItem> c = createScriptItem ( creator );
        c.localTags ( output.getLocalTag () );
        c.customizationTags ( output.getCustomizationTags () ); // the output of a calculation module is an input for the system
        c.dataType ( outputSpec.getDataType () );

        c.addMasterListener ( new MasterListener<ScriptItem> () {

            @Override
            public void setMaster ( final ScriptItem item, final MasterContext master )
            {
                ScriptModuleGenerator.this.danglingMap.put ( master.getImplementation (), item );
            }
        } );

        final ScriptItem item = c.create ();

        item.setScriptEngine ( implementation.getScriptEngine () );

        // set actual scripts
        item.setInitScript ( toCodeFragment ( implementation.getInitScript () ) );
        item.setUpdateScript ( toCodeFragment ( implementation.getUpdateScript () ) );
        item.setWriteCommandScript ( toCodeFragment ( implementation.getWriteCommandScript () ) );
        if ( implementation.getTimerScript () != null )
        {
            item.setTimer ( OsgiFactory.eINSTANCE.createScriptTimer () );
            item.getTimer ().setScript ( OsgiFactory.eINSTANCE.createCodeFragment () );
            item.getTimer ().getScript ().setCode ( implementation.getTimerScript ().getCode () );
            item.getTimer ().setPeriod ( implementation.getTimerScript ().getPeriod () );
        }

        for ( final InputDefinition input : this.calculationComponent.getInputs () )
        {
            final ItemReference itemRef = OsgiFactory.eINSTANCE.createItemReference ();
            itemRef.setItem ( input.createReference () );
            itemRef.setName ( input.getName () );

            item.getInputs ().add ( itemRef );
        }
    }

    private CodeFragment toCodeFragment ( final Script initScript )
    {
        if ( initScript == null )
        {
            return null;
        }
        final CodeFragment codeFragment = OsgiFactory.eINSTANCE.createCodeFragment ();
        codeFragment.setCode ( initScript.getCode () );
        return codeFragment;
    }

    @Override
    protected void generateForMaster ( final GenerationContext context, final MasterContext master, final ScriptModule implementation )
    {
    }

    @Override
    public void finish ( final FinishContext context )
    {
        super.finish ( context );
        for ( final Map.Entry<MasterServer, ScriptItem> entry : this.danglingMap.entrySet () )
        {
            final MasterServer master = entry.getKey ();
            final ScriptItem item = entry.getValue ();

            for ( final ItemReference input : item.getInputs () )
            {
                input.setItem ( Items.replaceDanglingReference ( this.context, master, input.getItem () ) );
            }

            for ( final ItemReference command : item.getCommands () )
            {
                command.setItem ( Items.replaceDanglingReference ( this.context, master, command.getItem () ) );
            }
        }
    }
}
