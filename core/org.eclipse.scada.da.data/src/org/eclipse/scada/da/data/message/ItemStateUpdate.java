/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.da.data.message;

public class ItemStateUpdate implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;

    public ItemStateUpdate ( final String itemId, final org.eclipse.scada.core.data.SubscriptionState subscriptionState, final org.eclipse.scada.core.data.ErrorInformation errorInformation )
    {
        this.itemId = itemId;
        this.subscriptionState = subscriptionState;
        this.errorInformation = errorInformation;
    }

    private final String itemId;

    public String getItemId ()
    {
        return this.itemId;
    }

    private final org.eclipse.scada.core.data.SubscriptionState subscriptionState;

    public org.eclipse.scada.core.data.SubscriptionState getSubscriptionState ()
    {
        return this.subscriptionState;
    }

    private final org.eclipse.scada.core.data.ErrorInformation errorInformation;

    public org.eclipse.scada.core.data.ErrorInformation getErrorInformation ()
    {
        return this.errorInformation;
    }

    @Override
    public String toString ()
    {
        return "[ItemStateUpdate - " + "itemId: " + this.itemId + ", " + "subscriptionState: " + this.subscriptionState + ", " + "errorInformation: " + this.errorInformation + "]";
    }
}
