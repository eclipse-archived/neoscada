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
package org.eclipse.scada.core.ui.styles;

import java.util.Set;

public interface StateInformation
{
    public static enum State
    {
        BLOCK,
        MANUAL,
        WARNING,
        ALARM,
        ERROR,
        DISCONNECTED,
        WARNING_ACK,
        ALARM_ACK,
        ERROR_ACK
    }

    public Set<State> getStates ();
}
