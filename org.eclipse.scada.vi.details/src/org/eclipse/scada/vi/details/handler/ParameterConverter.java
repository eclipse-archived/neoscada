/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.handler;

import java.util.Map;

import org.eclipse.core.commands.AbstractParameterValueConverter;
import org.eclipse.core.commands.ParameterValueConversionException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ParameterConverter extends AbstractParameterValueConverter
{

    private final GsonBuilder builder;

    public ParameterConverter ()
    {
        this.builder = new GsonBuilder ();
        this.builder.serializeNulls ();
        this.builder.setDateFormat ( "yyyy-MM-dd hh:mm:ss.SSS" ); //$NON-NLS-1$
    }

    @Override
    public Object convertToObject ( final String parameterValue ) throws ParameterValueConversionException
    {
        final Gson gson = this.builder.create ();
        return gson.fromJson ( parameterValue, new TypeToken<Map<String, String>> () {}.getType () );
    }

    @Override
    public String convertToString ( final Object parameterValue ) throws ParameterValueConversionException
    {
        if ( parameterValue instanceof Map )
        {
            final Gson gson = this.builder.create ();
            return gson.toJson ( parameterValue );
        }
        throw new ParameterValueConversionException ( "Unable to convert type " + parameterValue.getClass () );
    }

}
