package org.eclipse.scada.configuration.component.generator.calc;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.configuration.component.generator.DataComponentGenerator;
import org.eclipse.scada.configuration.component.lib.Items;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.BufferedValue;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.Persistence;

public class BufferedValueGenerator extends DataComponentGenerator
{
    private final org.eclipse.scada.configuration.component.BufferedValue bufferedValue;

    private final Map<MasterServer, BufferedValue> danglingBufferedValues = new HashMap<> ();

    public BufferedValueGenerator ( final org.eclipse.scada.configuration.component.BufferedValue bufferedValue )
    {
        super ( bufferedValue );
        this.bufferedValue = bufferedValue;
    }

    @Override
    protected void generateForMaster ( GenerationContext context, MasterContext master )
    {
        BufferedValue bufferedValueGenerated = OsgiFactory.eINSTANCE.createBufferedValue ();

        bufferedValueGenerated.setName ( this.bufferedValue.getName () );
        if ( this.bufferedValue.getInput () != null )
        {
            final ItemReference ref = OsgiFactory.eINSTANCE.createItemReference ();
            ref.setName ( this.bufferedValue.getInput ().getName () );
            ref.setItem ( this.bufferedValue.getInput ().createReference () );
            bufferedValueGenerated.setItem ( ref );

            bufferedValueGenerated.setShortDescription ( String.format ( "buffers item '%s' for %ss and is triggered every %ss", this.bufferedValue.getInput ().getName (), this.bufferedValue.getRange () / 1000, this.bufferedValue.getTrigger () ) );
        }
        if ( this.bufferedValue.getInitialValue () != null )
        {
            bufferedValueGenerated.setInitialValue ( this.bufferedValue.getInitialValue () );
        }
        bufferedValueGenerated.setPersistence ( Persistence.getByName ( this.bufferedValue.getPersistence ().getName () ) );
        bufferedValueGenerated.setRange ( this.bufferedValue.getRange () );
        bufferedValueGenerated.setTrigger ( this.bufferedValue.getTrigger () );
        bufferedValueGenerated.setTriggerOnly ( this.bufferedValue.isTriggerOnly () );

        master.getImplementation ().getBufferedValues ().add ( bufferedValueGenerated );
        danglingBufferedValues.put ( master.getImplementation (), bufferedValueGenerated );
        super.generateForMaster ( context, master );
    }

    @Override
    public void createItems ( ItemCreator itemCreator )
    {
        // we don't have actual items
    }

    @Override
    protected void finishForMaster ( FinishContext context, MasterContext master )
    {
        final BufferedValue bufferedValue = this.danglingBufferedValues.get ( master.getImplementation () );
        bufferedValue.getItem ().setItem ( Items.replaceDanglingReference ( this.context, master.getImplementation (), bufferedValue.getItem ().getItem () ) );
    }
}
