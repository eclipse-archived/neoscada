package org.eclipse.scada.configuration.dave;

public final class DaveHelper
{
    private DaveHelper ()
    {
    }

    public static String makeBlockName ( final DaveBlockDefinition block )
    {
        if ( block.getName () != null && !block.getName ().isEmpty () )
        {
            return block.getName ();
        }
        else
        {
            return String.format ( "DB%s", block.getBlock () );
        }
    }
}
