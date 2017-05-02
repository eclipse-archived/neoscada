/*******************************************************************************
 * Copyright (c) 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server.storage.hds;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.eclipse.scada.hds.DataFilePool;
import org.eclipse.scada.hds.DataStoreAccesor;

public class StorageHelper
{

    public static void create ( final String id, final File file, final StorageConfiguration configuration, final DataFilePool pool ) throws Exception
    {
        file.mkdir ();

        final Properties p = new Properties ();
        p.put ( "id", id );
        p.storeToXML ( new FileOutputStream ( new File ( file, "settings.xml" ) ), "Eclipse SCADA HD HDS Storage Settings" );

        DataStoreAccesor.create ( new File ( file, "native" ), configuration.getTimeSlice (), TimeUnit.MILLISECONDS, configuration.getCount (), pool );
    }

}
