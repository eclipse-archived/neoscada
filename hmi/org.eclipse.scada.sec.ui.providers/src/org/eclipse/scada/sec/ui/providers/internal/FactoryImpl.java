/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers.internal;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.scada.sec.ui.providers.KeyProvider;
import org.eclipse.scada.sec.ui.providers.KeyProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryImpl implements IObservableFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( FactoryImpl.class );

    @Override
    public IObservable createObservable ( final Object target )
    {
        logger.debug ( "createObservable - {}", target );

        if ( target instanceof IObservableList )
        {
            return Observables.proxyObservableList ( (IObservableList)target );
        }
        else if ( target instanceof KeyProviderFactory )
        {
            return Observables.proxyObservableList ( ( (KeyProviderFactory)target ).getKeyProviders () );
        }
        else if ( target instanceof KeyProvider )
        {
            return Observables.proxyObservableList ( ( (KeyProvider)target ).getKeys () );
        }
        return null;
    }
}
