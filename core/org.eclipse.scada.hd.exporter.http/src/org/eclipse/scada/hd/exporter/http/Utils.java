/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.exporter.http;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Utils
{
    public static final String isoDatePatterrn = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final DateFormat isoDateFormat = new SimpleDateFormat ( isoDatePatterrn );

    public static final Gson gson = new GsonBuilder ().setDateFormat ( DateFormat.FULL ).setDateFormat ( isoDatePatterrn ).serializeNulls ().serializeSpecialFloatingPointValues ().create ();

    public static String toJson ( final List<DataPoint> items )
    {
        return gson.toJson ( items );
    }

    public static List<DataPoint> fromJson ( final String json )
    {
        final Type dataPointListType = new TypeToken<List<DataPoint>> () {}.getType ();
        return gson.fromJson ( json, dataPointListType );
    }
}
