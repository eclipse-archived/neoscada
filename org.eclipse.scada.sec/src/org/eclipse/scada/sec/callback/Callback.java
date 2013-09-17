/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.callback;

import java.util.Comparator;
import java.util.Map;

/**
 * @since 1.1
 */
public interface Callback
{
    public static Comparator<Callback> ORDER_COMPARATOR = new Comparator<Callback> () {
        @Override
        public int compare ( final Callback o1, final Callback o2 )
        {
            if ( o1 == o2 )
            {
                return 0;
            }

            if ( o2 == null )
            {
                return -1;
            }

            // both are non-null now

            return Integer.valueOf ( o1.getOrder () ).compareTo ( o2.getOrder () );
        };
    };

    public static long DEFAULT_TIMEOUT = Integer.getInteger ( "org.eclipse.scada.sec.callback.defaultTimeout", 20 * 1000 );

    public void cancel ();

    boolean isCanceled ();

    public int getOrder ();

    public Map<String, String> buildRequestAttributes ();

    public void parseResponseAttributes ( Map<String, String> attributes );

    public Map<String, String> buildResponseAttributes ();

    public void parseRequestAttributes ( Map<String, String> attributes );

    public String getType ();
}
