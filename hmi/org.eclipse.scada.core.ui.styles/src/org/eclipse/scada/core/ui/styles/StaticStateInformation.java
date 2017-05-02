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

import java.util.EnumSet;

public class StaticStateInformation extends AbstractStateInformation
{
    public static final StaticStateInformation EMPTY;

    static
    {
        EMPTY = new StaticStateInformation ( EnumSet.noneOf ( State.class ) );
    }

    public StaticStateInformation ( final State state )
    {
        super ( EnumSet.of ( state ) );
    }

    public StaticStateInformation ( final EnumSet<State> states )
    {
        super ( EnumSet.copyOf ( states ) );
    }
}
