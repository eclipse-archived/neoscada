package org.eclipse.scada.configuration.component.generator.calc;

import org.eclipse.scada.configuration.component.generator.DataComponentGenerator;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.BufferedValue;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.Persistence;

public class BufferedValueGenerator extends DataComponentGenerator
{
    private final org.eclipse.scada.configuration.component.BufferedValue bufferedValue;

    public BufferedValueGenerator ( final org.eclipse.scada.configuration.component.BufferedValue bufferedValue )
    {
        super ( bufferedValue );
        this.bufferedValue = bufferedValue;
    }

    @Override
    public void createItems ( ItemCreator itemCreator )
    {
    }

    @Override
    protected void generateForMaster ( GenerationContext context, MasterContext master )
    {
        // do my own stuff
        BufferedValue b = OsgiFactory.eINSTANCE.createBufferedValue ();
        b.setInitialValue ( this.bufferedValue.getInitialValue () );
        b.setPersistence ( Persistence.getByName ( this.bufferedValue.getPersistence ().getName () ) );
        master.getImplementation ().getBufferedValues ().add ( b );
        super.generateForMaster ( context, master );
    }
}
