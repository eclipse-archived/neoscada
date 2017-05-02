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
package org.eclipse.scada.configuration.ui.component;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.configuration.ui.component.Helper.ItemEntry;
import org.eclipse.scada.configuration.ui.component.Helper.Master;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ComponentOutputObservableFactory implements IObservableFactory
{
    private final static Logger logger = LoggerFactory.getLogger ( ComponentOutputObservableFactory.class );

    @Override
    public IObservable createObservable ( final Object target )
    {
        logger.debug ( "Getting observable for: {}", target );
        if ( target instanceof IObservableSet )
        {
            return Observables.proxyObservableSet ( (IObservableSet)target );
        }
        else if ( target instanceof Master )
        {
            return Observables.proxyObservableSet ( ( (Master)target ).getEntries () );
        }
        else if ( target instanceof ItemEntry )
        {
            final ItemEntry itemEntry = (ItemEntry)target;
            if ( itemEntry.getCustomizationRequest () != null && itemEntry.getCustomizationRequest ().getComponent () != null )
            {
                final WritableSet result = new WritableSet ();
                result.add ( new ClassInformationProvider ( itemEntry.getCustomizationRequest ().getComponent ().getClass () ) );
                return result;
            }
        }
        else if ( target instanceof ClassInformationProvider )
        {
            return ( (ClassInformationProvider)target ).createSuper ( null );
        }
        return null;
    }
}