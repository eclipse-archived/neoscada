/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.jdbc.task;

import java.sql.Connection;

public abstract class CommonConnectionTask<R> implements ConnectionTask<R>
{

    public static class ConnectionContextImplementation extends CommonConnectionContext
    {
        private final Connection connection;

        private ConnectionContextImplementation ( final Connection connection )
        {
            this.connection = connection;
        }

        @Override
        public Connection getConnection ()
        {
            return this.connection;
        }
    }

    @Override
    public R performTask ( final Connection connection ) throws Exception
    {
        return performTask ( new ConnectionContextImplementation ( connection ) );
    }

    protected abstract R performTask ( ConnectionContext connectionContext ) throws Exception;

}
