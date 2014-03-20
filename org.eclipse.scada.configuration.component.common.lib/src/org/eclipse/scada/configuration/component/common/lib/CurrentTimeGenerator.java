package org.eclipse.scada.configuration.component.common.lib;

import org.eclipse.scada.configuration.component.common.CurrentTimeComponent;
import org.eclipse.scada.configuration.component.generator.AbstractDanglingGenerator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;
import org.eclipse.scada.configuration.world.osgi.ScriptTimer;

public class CurrentTimeGenerator extends AbstractDanglingGenerator
{

    private final CurrentTimeComponent currentTime;

    public CurrentTimeGenerator ( final CurrentTimeComponent currentTime )
    {
        super ( currentTime );
        this.currentTime = currentTime;
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        final ScriptItem item = OsgiFactory.eINSTANCE.createScriptItem ();

        final CodeFragment initCode = OsgiFactory.eINSTANCE.createCodeFragment ();
        initCode.setCode ( makeInit () );

        item.setInitScript ( initCode );

        final CodeFragment timerCode = OsgiFactory.eINSTANCE.createCodeFragment ();
        timerCode.setCode ( "DF.format ( new java.util.Date() );" );

        final ScriptTimer timer = OsgiFactory.eINSTANCE.createScriptTimer ();
        timer.setPeriod ( this.currentTime.getUpdatePeriod () );
        timer.setScript ( timerCode );
        item.setTimer ( timer );

        final CreationRequest<ScriptItem> req = itemCreator.addItem ( item );
        req.localTags ( this.currentTime.getName () );
        req.dataType ( DataType.STRING );
        req.customizationTags ( "input" );
        req.information ( "Current time", null, "SCADA" );
        createScriptItem ( req );
    }

    private String makeInit ()
    {
        if ( this.currentTime.getDateFormat () == null || this.currentTime.getDateFormat ().toString ().isEmpty () )
        {
            return "var DF = new java.text.SimpleDateFormat ();";
        }
        else
        {
            return "var DF = new java.text.SimpleDateFormat (\"" + escape ( this.currentTime.getDateFormat ().toString () ) + "\");";
        }
    }

    private String escape ( String string )
    {
        string = string.replace ( "\\", "\\\\" );
        string = string.replace ( "\"", "\\\"" );
        return string;
    }
}
