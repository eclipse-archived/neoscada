/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator.internal;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.component.BufferedValue;
import org.eclipse.scada.configuration.component.ChangeCounter;
import org.eclipse.scada.configuration.component.ConstantValue;
import org.eclipse.scada.configuration.component.DataMapperAnalyzer;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.component.DeltaValue;
import org.eclipse.scada.configuration.component.DriverConnectionAnalyzer;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.component.MappedSourceValue;
import org.eclipse.scada.configuration.component.PersistentValue;
import org.eclipse.scada.configuration.component.TransientValue;
import org.eclipse.scada.configuration.component.generator.calc.BufferedValueGenerator;
import org.eclipse.scada.configuration.component.generator.calc.ChangeCounterGenerator;
import org.eclipse.scada.configuration.component.generator.connection.DriverConnectionAnalyzerGenerator;
import org.eclipse.scada.configuration.component.generator.global.GlobalizeGenerator;
import org.eclipse.scada.configuration.component.generator.mapper.DataMapperAnalyzerGenerator;
import org.eclipse.scada.configuration.component.generator.mapper.DataMapperServiceGenerator;
import org.eclipse.scada.configuration.component.generator.mapper.MappedSourceValueGenerator;
import org.eclipse.scada.configuration.component.generator.simple.ConstantValueGenerator;
import org.eclipse.scada.configuration.component.generator.simple.DeltaValueGenerator;
import org.eclipse.scada.configuration.component.generator.simple.ExternalValueGenerator;
import org.eclipse.scada.configuration.component.generator.simple.PersistentValueGenerator;
import org.eclipse.scada.configuration.component.generator.simple.TransientValueGenerator;
import org.eclipse.scada.configuration.generator.Generator;

public class GeneratorAdapterFactory implements IAdapterFactory
{

    @SuppressWarnings ( { "unchecked" } )
    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( !Generator.class.equals ( adapterType ) )
        {
            return null;
        }
        if ( adaptableObject instanceof ConstantValue )
        {
            return (T)new ConstantValueGenerator ( (ConstantValue)adaptableObject );
        }
        else if ( adaptableObject instanceof PersistentValue )
        {
            return (T)new PersistentValueGenerator ( (PersistentValue)adaptableObject );
        }
        else if ( adaptableObject instanceof TransientValue )
        {
            return (T)new TransientValueGenerator ( (TransientValue)adaptableObject );
        }
        else if ( adaptableObject instanceof ExternalValue )
        {
            return (T)new ExternalValueGenerator ( (ExternalValue)adaptableObject );
        }
        else if ( adaptableObject instanceof DriverConnectionAnalyzer )
        {
            return (T)new DriverConnectionAnalyzerGenerator ( (DriverConnectionAnalyzer)adaptableObject );
        }
        else if ( adaptableObject instanceof DataMapperAnalyzer )
        {
            return (T)new DataMapperAnalyzerGenerator ( (DataMapperAnalyzer)adaptableObject );
        }
        else if ( adaptableObject instanceof DataMapperService )
        {
            return (T)new DataMapperServiceGenerator ( (DataMapperService)adaptableObject );
        }
        else if ( adaptableObject instanceof MappedSourceValue )
        {
            return (T)new MappedSourceValueGenerator ( (MappedSourceValue)adaptableObject );
        }
        else if ( adaptableObject instanceof BufferedValue )
        {
            return (T)new BufferedValueGenerator ( (BufferedValue)adaptableObject );
        }
        else if ( adaptableObject instanceof ChangeCounter )
        {
            return (T)new ChangeCounterGenerator ( (ChangeCounter)adaptableObject );
        }
        else if ( adaptableObject instanceof GlobalizeComponent )
        {
            return (T)new GlobalizeGenerator ( (GlobalizeComponent)adaptableObject );
        }
        else if ( adaptableObject instanceof DeltaValue )
        {
            return (T)new DeltaValueGenerator ( (DeltaValue)adaptableObject );
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class<?>[] { Generator.class };
    }

}
