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

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector;
import org.eclipse.scada.configuration.component.generator.AbstractDanglingGenerator;
import org.eclipse.scada.configuration.component.lib.Activator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;
import org.eclipse.scada.configuration.world.osgi.ScriptTimer;

import com.google.common.io.Resources;

public class ChangeHeartbeatDetectorGenerator extends AbstractDanglingGenerator
{

    private final ChangeHeartbeatDetector detector;

    private final String updateCodeString;

    private final String timerCodeString;

    public ChangeHeartbeatDetectorGenerator ( final ChangeHeartbeatDetector detector )
    {
        super ( detector );
        this.detector = detector;

        this.updateCodeString = loadResource ( "detect.update.js" );
        this.timerCodeString = loadResource ( "detect.timer.js" );
    }

    private static String loadResource ( final String resourceName )
    {
        final URL updateUrl = Resources.getResource ( ChangeHeartbeatDetectorGenerator.class, resourceName );
        try
        {
            return Resources.toString ( updateUrl, Charset.forName ( "UTF-8" ) );
        }
        catch ( final IOException e )
        {
            throw new RuntimeException ( String.format ( "Unable to load '%s'", resourceName ), e );
        }
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        if ( this.detector.getSourceItem () == null )
        {
            itemCreator.createMarker ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, "Source item is not set" ) );
            return;
        }

        final ScriptItem item = OsgiFactory.eINSTANCE.createScriptItem ();

        final CodeFragment initCode = OsgiFactory.eINSTANCE.createCodeFragment ();
        initCode.setCode ( String.format ( "heartbeatTimeout = %s;", this.detector.getTimeout () ) );

        final CodeFragment timerCode = OsgiFactory.eINSTANCE.createCodeFragment ();
        timerCode.setCode ( this.timerCodeString );

        final CodeFragment updateCode = OsgiFactory.eINSTANCE.createCodeFragment ();
        updateCode.setCode ( this.updateCodeString );

        final ItemReference ref = OsgiFactory.eINSTANCE.createItemReference ();
        ref.setName ( "A" );
        ref.setItem ( this.detector.getSourceItem ().createReference () );
        item.getInputs ().add ( ref );

        final ScriptTimer timer = OsgiFactory.eINSTANCE.createScriptTimer ();
        timer.setPeriod ( this.detector.getCheckPeriod () );
        timer.setScript ( timerCode );
        item.setTimer ( timer );

        item.setInitScript ( initCode );
        item.setUpdateScript ( updateCode );

        final CreationRequest<ScriptItem> req = itemCreator.addItem ( item );
        req.localTags ( "STATE" );
        req.dataType ( DataType.BOOLEAN );
        req.customizationTags ( "input" );
        req.information ( "Detector state", null, null );
        createScriptItem ( req );
    }
}
