/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
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

public class AbstractStateInformation implements StateInformation
{
    private final Set<State> states;

    public AbstractStateInformation ( final Set<State> states )
    {
        this.states = states;
    }

    @Override
    public Set<State> getStates ()
    {
        return this.states;
    }

    @Override
    public String toString ()
    {
        return "" + this.states; //$NON-NLS-1$
    }
}
