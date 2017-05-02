/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.login.factory.internal;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class LoginConnection
{

    public static enum Mode
    {
        NORMAL,
        OPTIONAL,
        LAZY;
    }

    private final ConnectionInformation connectionInformation;

    private final Set<String> servicePids;

    private final Integer autoReconnectDelay;

    private final Integer priority;

    private final Mode mode;

    private final boolean useCallbacks;

    public LoginConnection ( final ConnectionInformation connectionInformation, final Set<String> servicePids, final Integer autoReconnectDelay, final Integer priority, final Mode mode, final boolean useCallbacks )
    {
        this.connectionInformation = connectionInformation.clone ();
        this.servicePids = servicePids != null ? new HashSet<String> ( servicePids ) : Collections.<String> emptySet ();
        this.autoReconnectDelay = autoReconnectDelay;
        this.priority = priority;
        this.mode = mode;
        this.useCallbacks = useCallbacks;
    }

    public boolean isUseCallbacks ()
    {
        return this.useCallbacks;
    }

    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation.clone ();
    }

    public Integer getAutoReconnectDelay ()
    {
        return this.autoReconnectDelay;
    }

    public Integer getPriority ()
    {
        return this.priority;
    }

    public Set<String> getServicePids ()
    {
        return this.servicePids;
    }

    public Mode getMode ()
    {
        return this.mode;
    }
}
