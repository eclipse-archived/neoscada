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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.sec.utils.password.PasswordEncoding;
import org.eclipse.scada.utils.str.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since 1.1
 */
public class PasswordCallback extends LabelCallback
{

    private final static Logger logger = LoggerFactory.getLogger ( PasswordCallback.class );

    private static final String REQUESTED_TYPES_PREFIX = "password.requestedTypes.";

    public static final String TYPE = "password";

    private List<List<PasswordEncoding>> requestedTypes = new LinkedList<List<PasswordEncoding>> ();

    private final Map<PasswordEncoding, String> passwords = new HashMap<PasswordEncoding, String> ();

    private static final String PASSWORD_PREFIX = "password.";

    public PasswordCallback ( final String label, final int order )
    {
        super ( label, order );
    }

    public PasswordCallback ( final String label, final int order, final PasswordEncoding... types )
    {
        super ( label, order );
        this.requestedTypes.add ( Arrays.asList ( types ) );
    }

    public PasswordCallback ( final String label, final int order, final List<PasswordEncoding> types )
    {
        super ( label, order );
        this.requestedTypes.add ( new ArrayList<PasswordEncoding> ( types ) );
    }

    public PasswordCallback ()
    {
    }

    @Override
    public String getType ()
    {
        return TYPE;
    }

    public void setRequestedTypes ( final List<List<PasswordEncoding>> passwordEncodings )
    {
        this.requestedTypes = new ArrayList<List<PasswordEncoding>> ( passwordEncodings );
    }

    public List<List<PasswordEncoding>> getRequestedTypes ()
    {
        return Collections.unmodifiableList ( this.requestedTypes );
    }

    public void addRequestedTypes ( final PasswordEncoding... types )
    {
        this.requestedTypes.add ( Arrays.asList ( types ) );
    }

    public void addRequestedTypes ( final List<PasswordEncoding> types )
    {
        this.requestedTypes.add ( types );
    }

    public void setPassword ( final String password )
    {
        this.passwords.clear ();

        for ( final List<PasswordEncoding> group : this.requestedTypes )
        {
            if ( !group.isEmpty () )
            {
                final PasswordEncoding encoding = group.get ( 0 );
                try
                {
                    // we encode only the first known type ... since this is best
                    this.passwords.put ( encoding, encoding.encodeToHexString ( password ) );
                }
                catch ( final Exception e )
                {
                    logger.debug ( "Failed to encode type: " + encoding, e );
                }
            }
        }
    }

    /**
     * Get an unmodifiable map of passwords by type
     * 
     * @return the password map
     */
    public Map<PasswordEncoding, String> getPasswords ()
    {
        return Collections.unmodifiableMap ( this.passwords );
    }

    public String getPassword ( final PasswordEncoding type )
    {
        return this.passwords.get ( type );
    }

    public String getPlainPassword ()
    {
        return getPassword ( PasswordEncoding.PLAIN );
    }

    @Override
    protected void injectRequestAttributes ( final Map<String, String> request )
    {
        super.injectRequestAttributes ( request );

        int i = 0;
        for ( final List<PasswordEncoding> group : this.requestedTypes )
        {
            request.put ( REQUESTED_TYPES_PREFIX + i, StringHelper.join ( group, ", " ) );
            i++;
        }
    }

    @Override
    public void parseRequestAttributes ( final Map<String, String> attributes )
    {
        super.parseRequestAttributes ( attributes );
        this.requestedTypes.clear ();

        for ( final Map.Entry<String, String> entry : attributes.entrySet () )
        {
            if ( entry.getKey ().startsWith ( REQUESTED_TYPES_PREFIX ) )
            {
                final String str = entry.getValue ();

                if ( str != null )
                {
                    final List<PasswordEncoding> encodings = new LinkedList<PasswordEncoding> ();
                    for ( final String tok : Arrays.asList ( str.split ( "\\s*,\\s*" ) ) )
                    {
                        try
                        {
                            encodings.add ( PasswordEncoding.valueOf ( tok ) );
                        }
                        catch ( final Exception e )
                        {
                            logger.debug ( "Failed to parse requested encoding: " + tok, e );
                        }
                    }
                    this.requestedTypes.add ( encodings );
                }
            }
        }

    }

    @Override
    public void parseResponseAttributes ( final Map<String, String> attributes )
    {
        super.parseResponseAttributes ( attributes );

        this.passwords.clear ();

        for ( final Map.Entry<String, String> entry : attributes.entrySet () )
        {
            if ( entry.getKey ().startsWith ( PASSWORD_PREFIX ) )
            {
                final String type = entry.getKey ().substring ( PASSWORD_PREFIX.length () );

                try
                {
                    this.passwords.put ( PasswordEncoding.valueOf ( type ), entry.getValue () );
                }
                catch ( final Exception e )
                {
                    logger.debug ( "Failed to decode password encoding: " + type, e );
                }

            }
        }
    }

    @Override
    protected void injectResponseAttributes ( final Map<String, String> result )
    {
        super.injectResponseAttributes ( result );

        for ( final Map.Entry<PasswordEncoding, String> entry : this.passwords.entrySet () )
        {
            result.put ( PASSWORD_PREFIX + entry.getKey (), entry.getValue () );
        }
    }

}
