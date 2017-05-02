/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - refactoring for a generic memory driver system
 *******************************************************************************/

package org.eclipse.scada.protocol.dave;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.apache.mina.core.buffer.IoBuffer;

public class DaveReadResult extends DaveMessage
{
    private final Collection<Result> result;

    public DaveReadResult ( final Collection<Result> result )
    {
        this.result = new ArrayList<Result> ( result );
    }

    public Collection<Result> getResult ()
    {
        return Collections.unmodifiableCollection ( this.result );
    }

    public static class Result
    {
        private final Short error;

        private final IoBuffer data;

        public Result ( final short error )
        {
            this.error = error;
            this.data = null;
        }

        public Result ( final IoBuffer data )
        {
            this.error = null;
            this.data = data;
        }

        public IoBuffer getData ()
        {
            return this.data;
        }

        public boolean isError ()
        {
            return this.error != null;
        }

        public Short getError ()
        {
            return this.error;
        }

        @Override
        public String toString ()
        {
            return String.format ( isError () ? "E:" + this.error : "D:" + this.data );
        }
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( "Result: " );
        sb.append ( this.result.size () );
        sb.append ( "@" );

        int i = 0;
        for ( final Result result : this.result )
        {
            sb.append ( "[" );

            sb.append ( i + ": " );
            sb.append ( result );
            sb.append ( " " );

            sb.append ( "]" );

            i++;
        }

        return sb.toString ();
    }
}
