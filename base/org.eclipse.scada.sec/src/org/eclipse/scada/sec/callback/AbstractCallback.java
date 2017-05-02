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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @since 1.1
 */
public abstract class AbstractCallback implements Callback
{

    private boolean canceled;

    private int order;

    public AbstractCallback ()
    {
    }

    public AbstractCallback ( final int order )
    {
        this.order = order;
    }

    @Override
    public int getOrder ()
    {
        return this.order;
    }

    @Override
    public void cancel ()
    {
        this.canceled = true;
    }

    @Override
    public boolean isCanceled ()
    {
        return this.canceled;
    }

    /**
     * Build the request attribute map
     * <p>
     * Only non-null values and keys may be inserted!
     * </p>
     */
    @Override
    public Map<String, String> buildRequestAttributes ()
    {
        final Map<String, String> result = new HashMap<String, String> ();

        injectRequestAttributes ( result );

        return result;
    }

    /**
     * Build the response attribute map
     * <p>
     * Only non-null values and keys may be inserted!
     * </p>
     */
    @Override
    public Map<String, String> buildResponseAttributes ()
    {
        if ( isCanceled () )
        {
            return Collections.emptyMap ();
        }
        else
        {
            final Map<String, String> result = new HashMap<String, String> ();
            injectResponseAttributes ( result );
            return result;
        }
    }

    protected void injectRequestAttributes ( final Map<String, String> request )
    {
        request.put ( "order", ( (Integer)this.order ).toString () );
    }

    /**
     * Inject values for the response message
     * <p>
     * Only non-null values and keys may be inserted!
     * </p>
     * 
     * @param response
     *            the result map which should be filled
     */
    protected void injectResponseAttributes ( final Map<String, String> response )
    {
    }

    @Override
    public void parseRequestAttributes ( final Map<String, String> attributes )
    {
        this.order = parseInteger ( attributes, "order", null );
    }

    @Override
    public void parseResponseAttributes ( final Map<String, String> attributes )
    {
    }

    /**
     * Return an integer from the attributes
     * 
     * @param attributes
     * @param key
     * @param defaultValue
     * @return if the key was not set, the default value, otherwise the parse
     *         value
     * @throws Exception
     *             in case the value was set but could not be parsed
     */
    protected Integer parseInteger ( final Map<String, String> attributes, final String key, final Integer defaultValue )
    {
        final String value = attributes.get ( key );
        if ( value == null )
        {
            return defaultValue;
        }

        return Integer.parseInt ( value );
    }
}