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
package org.eclipse.scada.configuration.component.common.lib;

import static org.eclipse.scada.configuration.component.common.lib.Helper.loadResource;

import org.eclipse.scada.configuration.component.common.HeartbeatGenerator;
import org.eclipse.scada.configuration.component.generator.AbstractDanglingGenerator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;
import org.eclipse.scada.configuration.world.osgi.ScriptTimer;

public class ToggleHeartbeatGeneratorGenerator extends AbstractDanglingGenerator
{
    private final HeartbeatGenerator generator;

    public ToggleHeartbeatGeneratorGenerator ( final HeartbeatGenerator generator )
    {
        super ( generator );
        this.generator = generator;
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        final ScriptItem item = OsgiFactory.eINSTANCE.createScriptItem ();

        final CodeFragment initCode = makeInitCode ();
        final CodeFragment timerCode = makeTimerCode ();
        final CodeFragment updateCode = makeUpdateCode ();

        // create the target reference
        if ( this.generator.getTargetItem () != null )
        {
            final ItemReference ref = OsgiFactory.eINSTANCE.createItemReference ();
            ref.setName ( "A" );
            ref.setItem ( this.generator.getTargetItem ().createReference () );
            item.getCommands ().add ( ref );
        }

        // create the active indicator
        if ( this.generator.getActiveInput () != null )
        {
            final ItemReference activeRef = OsgiFactory.eINSTANCE.createItemReference ();
            activeRef.setName ( "INPUT" );
            activeRef.setItem ( this.generator.getActiveInput ().createReference () );
            item.getInputs ().add ( activeRef );
        }

        final ScriptTimer timer = OsgiFactory.eINSTANCE.createScriptTimer ();
        timer.setPeriod ( this.generator.getPeriod () );
        timer.setScript ( timerCode );

        item.setInitScript ( initCode );
        item.setUpdateScript ( updateCode );
        item.setTimer ( timer );

        final CreationRequest<ScriptItem> req = itemCreator.addItem ( item );
        req.localTags ( "STATE" );
        req.dataType ( DataType.BOOLEAN );
        req.customizationTags ( "input" );
        req.information ( "Heartbeat state", null, null );
        createScriptItem ( req );
    }

    private CodeFragment makeCode ( final StringBuilder sb )
    {
        if ( sb == null )
        {
            return null;
        }

        final CodeFragment code = OsgiFactory.eINSTANCE.createCodeFragment ();
        code.setCode ( sb.toString () );
        return code;
    }

    private CodeFragment makeUpdateCode ()
    {
        if ( this.generator.getActiveInput () == null )
        {
            return null;
        }

        final String codeString = loadResource ( "toggle.generator.active.update.js" );
        final CodeFragment code = OsgiFactory.eINSTANCE.createCodeFragment ();
        code.setCode ( codeString );
        return code;
    }

    private CodeFragment makeTimerCode ()
    {
        final StringBuilder sb = new StringBuilder ();

        if ( this.generator.getActiveInput () != null )
        {
            sb.append ( "if ( active ) { state = !state; write(); }" );

            // if we are active the state is the internal state
            // otherwise it is "null"
            sb.append ( "currentState();" );
        }
        else
        {
            sb.append ( "state = !state; write(); state;" );
        }

        return makeCode ( sb );
    }

    private CodeFragment makeInitCode ()
    {
        final StringBuilder sb = new StringBuilder ();

        if ( this.generator.getTargetItem () != null )
        {
            sb.append ( "function write () { writer.write(\"A\", state ); }" );
        }
        else
        {
            sb.append ( "function write () {}" );
        }

        if ( this.generator.getActiveInput () != null )
        {
            sb.append ( loadResource ( "toggle.generator.active.init.js" ) );
        }

        sb.append ( "var state = true;" );

        return makeCode ( sb );
    }
}
