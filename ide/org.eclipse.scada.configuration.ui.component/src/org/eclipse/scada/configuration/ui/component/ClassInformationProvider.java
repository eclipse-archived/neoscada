/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ui.component;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.Documentable;

public class ClassInformationProvider
{
    private final Class<? extends Object> classInformation;

    public ClassInformationProvider ( final Class<?> classInformation )
    {
        this.classInformation = classInformation;
    }

    public IObservableSet createSuper ( final Realm realm )
    {
        final WritableSet result = new WritableSet ( realm != null ? realm : Realm.getDefault () );
        if ( this.classInformation != null )
        {
            add ( result, this.classInformation.getSuperclass () );
            for ( final Class<?> iface : this.classInformation.getInterfaces () )
            {
                add ( result, iface );
            }
        }
        return result;
    }

    private void add ( final WritableSet result, final Class<?> clazz )
    {
        if ( clazz == null || clazz.equals ( Object.class ) || clazz.equals ( EObject.class ) || clazz.equals ( Documentable.class ) )
        {
            return;
        }
        result.add ( new ClassInformationProvider ( clazz ) );
    }

    public Class<? extends Object> getClassInformation ()
    {
        return this.classInformation;
    }

    public String getSimpleName ()
    {
        if ( this.classInformation == null )
        {
            return null;
        }
        return this.classInformation.getSimpleName ();
    }

    public String getName ()
    {
        if ( this.classInformation == null )
        {
            return null;
        }
        return this.classInformation.getName ();
    }

    public String getPackageName ()
    {
        if ( this.classInformation != null && this.classInformation.getPackage () != null )
        {
            return this.classInformation.getPackage ().getName ();
        }
        else
        {
            return null;
        }
    }

}
