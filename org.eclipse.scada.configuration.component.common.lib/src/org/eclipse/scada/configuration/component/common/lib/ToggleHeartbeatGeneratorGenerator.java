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
    private final HeartbeatGenerator item;

    public ToggleHeartbeatGeneratorGenerator ( final HeartbeatGenerator item )
    {
        super ( item );
        this.item = item;
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        final ScriptItem item = OsgiFactory.eINSTANCE.createScriptItem ();

        final CodeFragment initCode = OsgiFactory.eINSTANCE.createCodeFragment ();
        initCode.setCode ( "var state = true;" );

        final CodeFragment timerCode = OsgiFactory.eINSTANCE.createCodeFragment ();
        timerCode.setCode ( "state = !state; writer.write(\"A\", state ); state;" );

        final ItemReference ref = OsgiFactory.eINSTANCE.createItemReference ();
        ref.setName ( "A" );
        ref.setItem ( this.item.getTargetItem ().createReference () );
        item.getCommands ().add ( ref );

        final ScriptTimer timer = OsgiFactory.eINSTANCE.createScriptTimer ();
        timer.setPeriod ( this.item.getPeriod () );
        timer.setScript ( timerCode );

        item.setInitScript ( initCode );
        item.setTimer ( timer );

        final CreationRequest<ScriptItem> req = itemCreator.addItem ( item );
        req.localTags ( "STATE" );
        req.dataType ( DataType.BOOLEAN );
        req.customizationTags ( "input" );
        req.information ( "Heartbeat state", null, null );
        createScriptItem ( req );
    }
}
