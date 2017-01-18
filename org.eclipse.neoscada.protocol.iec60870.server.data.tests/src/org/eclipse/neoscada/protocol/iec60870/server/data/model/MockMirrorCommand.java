/*******************************************************************************
 * Copyright (c) 2016, 2017 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import org.eclipse.neoscada.protocol.iec60870.io.MirrorCommand;

public final class MockMirrorCommand implements MirrorCommand
{
    private int positive;

    private int negative;

    private int termination;

    @Override
    public synchronized void sendActivationTermination ()
    {
        this.termination++;
    }

    @Override
    public synchronized void sendActivationConfirm ( final boolean positive )
    {
        if ( positive )
        {
            this.positive++;
        }
        else
        {
            this.negative++;
        }
    }

    public synchronized int getPositive ()
    {
        return this.positive;
    }

    public synchronized int getNegative ()
    {
        return this.negative;
    }

    public synchronized int getTermination ()
    {
        return this.termination;
    }
}
