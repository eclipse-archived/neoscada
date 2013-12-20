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
package org.eclipse.scada.configuration.component.common.lib;

import org.eclipse.scada.configuration.component.common.TimerAction;
import org.eclipse.scada.configuration.component.generator.AbstractDanglingGenerator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;
import org.eclipse.scada.configuration.world.osgi.ScriptTimer;

public class TimerActionGenerator extends AbstractDanglingGenerator
{

    private final TimerAction timerAction;

    public TimerActionGenerator ( final TimerAction timerAction )
    {
        super ( timerAction );
        this.timerAction = timerAction;

    }

    @Override
    public void createItems ( ItemCreator itemCreator )
    {
        final ScriptItem item = OsgiFactory.eINSTANCE.createScriptItem ();

        final CodeFragment initCode = OsgiFactory.eINSTANCE.createCodeFragment ();
        // FIXME: implement correct javascript quoting
        initCode.setCode ( "var value = '" + this.timerAction.getValue ().toString ().replace ( "'", "\\'" ) + "';" );

        final CodeFragment timerCode = OsgiFactory.eINSTANCE.createCodeFragment ();
        timerCode.setCode ( "writer.writeAsText(\"A\", value ); value;" );

        final ItemReference ref = OsgiFactory.eINSTANCE.createItemReference ();
        ref.setName ( "A" );
        ref.setItem ( this.timerAction.getTargetItem ().createReference () );
        item.getCommands ().add ( ref );

        final ScriptTimer timer = OsgiFactory.eINSTANCE.createScriptTimer ();
        timer.setPeriod ( this.timerAction.getPeriod () );
        timer.setScript ( timerCode );

        item.setInitScript ( initCode );
        item.setTimer ( timer );

        final CreationRequest<ScriptItem> req = itemCreator.addItem (
                item );
        req.localTags ( "$TIMER_ACTION" );

        if ( this.timerAction.getValue ().getType ().name ().equals ( "DOUBLE" ) )
        {
            req.dataType ( DataType.FLOAT );
        }
        else
        {
            req.dataType ( DataType.getByName ( this.timerAction.getValue ().getType ().name () ) );
        }
        req.customizationTags ( "input" );
        req.information ( "timer action value", null, null );
        createScriptItem ( req );

    }

}
