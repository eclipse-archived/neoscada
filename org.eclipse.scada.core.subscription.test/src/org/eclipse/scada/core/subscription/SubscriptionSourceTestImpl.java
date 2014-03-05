/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - generic subscription manager
 *******************************************************************************/
package org.eclipse.scada.core.subscription;

import java.util.Collection;

public class SubscriptionSourceTestImpl<T> implements SubscriptionSource<T>
{

    @Override
    public void addListener ( final Collection<SubscriptionInformation<T>> listeners )
    {
        for ( final SubscriptionInformation<T> information : listeners )
        {
            final SubscriptionRecorder<T> recorder = (SubscriptionRecorder<T>)information.getListener ();
            recorder.added ( this );
        }
    }

    @Override
    public void removeListener ( final Collection<SubscriptionInformation<T>> listeners )
    {
        for ( final SubscriptionInformation<T> information : listeners )
        {
            final SubscriptionRecorder<T> recorder = (SubscriptionRecorder<T>)information.getListener ();
            recorder.removed ( this );
        }
    }

    @Override
    public boolean supportsListener ( final SubscriptionInformation<T> information )
    {
        return information.getListener () instanceof SubscriptionRecorder;
    }

}
