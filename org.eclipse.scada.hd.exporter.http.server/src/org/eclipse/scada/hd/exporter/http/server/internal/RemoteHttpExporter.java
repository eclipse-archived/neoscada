/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.exporter.http.server.internal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.scada.hd.exporter.http.DataPoint;
import org.eclipse.scada.hd.exporter.http.HttpExporter;

public class RemoteHttpExporter implements HttpExporter
{
    public List<DataPoint> getData ( final String item, final String type, final Date from, final Date to, final Integer number )
    {
        return null;
    }

    public List<String> getItems ()
    {
        return new ArrayList<String> ();
    }

    public List<String> getSeries ( final String itemId )
    {
        return new ArrayList<String> ();
    }
}
