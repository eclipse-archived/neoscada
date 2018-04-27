/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import java.util.concurrent.CompletableFuture;

public final class MockChangeDataModel extends ChangeDataModel
{
    private final class MockWriteModel implements WriteModel
    {
        @Override
        public Action prepareWriteValue ( Request<?> request )
        {
            return () -> CompletableFuture.completedFuture ( null );
        }
    }

    private final MockWriteModel writeModel;

    private final Integer flushDelay;

    public MockChangeDataModel ( final Integer flushDelay )
    {
        super ( "MockChangeDataModel" );
        this.flushDelay = flushDelay;
        this.writeModel = new MockWriteModel ();
    }

    @Override
    protected WriteModel createWriteModel ()
    {
        return this.writeModel;
    }

    @Override
    protected ChangeModel createChangeModel ()
    {
        return this.flushDelay == null ? makeInstantChangeModel () : makeBufferingChangeModel ( this.flushDelay );
    }

    @Override
    protected BackgroundModel createBackgroundModel ()
    {
        return makeDefaultBackgroundModel ();
    }
}
