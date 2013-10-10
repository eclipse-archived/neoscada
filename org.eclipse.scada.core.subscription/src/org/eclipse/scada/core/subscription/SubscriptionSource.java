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

/**
 * A event source which can be used with the subscription manager.
 * @author Jens Reimann
 *
 */
public interface SubscriptionSource
{
    /**
     * Validate if the provided subcription information can bind to this subscription source
     * @param information The information to check
     * @return <code>true</code> if the listener can bind to this event source. In this case the {@link #addListener(Collection)}
     * method may not reject the listener.
     */
    public abstract boolean supportsListener ( SubscriptionInformation information );

    public abstract void addListener ( Collection<SubscriptionInformation> listeners );

    public abstract void removeListener ( Collection<SubscriptionInformation> listeners );
}
