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
package org.eclipse.scada.core.subscription;

import java.util.Collection;

import org.eclipse.scada.core.subscription.SubscriptionInformation;
import org.eclipse.scada.core.subscription.SubscriptionSource;

public class SubscriptionSourceTestImpl implements SubscriptionSource
{

    @Override
    public void addListener ( final Collection<SubscriptionInformation> listeners )
    {
        for ( final SubscriptionInformation information : listeners )
        {
            final SubscriptionRecorder recorder = (SubscriptionRecorder)information.getListener ();
            recorder.added ( this );
        }
    }

    @Override
    public void removeListener ( final Collection<SubscriptionInformation> listeners )
    {
        for ( final SubscriptionInformation information : listeners )
        {
            final SubscriptionRecorder recorder = (SubscriptionRecorder)information.getListener ();
            recorder.removed ( this );
        }
    }

    @Override
    public boolean supportsListener ( final SubscriptionInformation information )
    {
        return information.getListener () instanceof SubscriptionRecorder;
    }

}
