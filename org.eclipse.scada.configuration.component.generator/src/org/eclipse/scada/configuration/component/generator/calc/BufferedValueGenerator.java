package org.eclipse.scada.configuration.component.generator.calc;

import org.eclipse.scada.configuration.component.BufferedValue;
import org.eclipse.scada.configuration.component.generator.DataComponentGenerator;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;

public class BufferedValueGenerator extends DataComponentGenerator
{
    private final BufferedValue bufferedValue;

    public BufferedValueGenerator ( final BufferedValue bufferedValue )
    {
        super ( bufferedValue );
        this.bufferedValue = bufferedValue;
    }

    @Override
    public void createItems ( ItemCreator itemCreator )
    {

    }
}
