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
package org.eclipse.scada.ca;

import org.eclipse.scada.ca.data.FactoryState;
import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class FactoryEvent
{

    public static enum Type
    {
        STATE,
        ADDED,
        REMOVED,
    }

    private final Factory factory;

    private final Type type;

    private final FactoryState state;

    public FactoryEvent ( final Type type, final Factory factory, final FactoryState state )
    {
        this.type = type;
        this.factory = factory;
        this.state = state;
    }

    public FactoryState getState ()
    {
        return this.state;
    }

    public Factory getFactory ()
    {
        return this.factory;
    }

    public Type getType ()
    {
        return this.type;
    }

    @Override
    public String toString ()
    {
        switch ( this.type )
        {
            case STATE:
                return String.format ( "%s -> %s : %s", this.factory.getId (), this.type, this.state );
            default:
                return String.format ( "%s -> %s", this.factory.getId (), this.type );
        }

    }
}
