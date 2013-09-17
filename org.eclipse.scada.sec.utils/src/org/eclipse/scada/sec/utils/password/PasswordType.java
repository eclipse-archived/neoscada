/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.sec.utils.password;

import java.util.List;

public enum PasswordType
{
    PLAIN
    {
        @Override
        public PasswordEncoding getEncoding () throws Exception
        {
            return PasswordEncoding.PLAIN;
        }

        @Override
        public PasswordValidator createValdiator ()
        {
            return new PlainValidator ( false );
        }

        @Override
        public PasswordEncoder createEncoder () throws Exception
        {
            return getEncoding ().getEncoder ( "UTF-8", new HexCodec () );
        }
    },
    PLAIN_IGNORE_CASE
    {
        @Override
        public PasswordEncoding getEncoding () throws Exception
        {
            return PasswordEncoding.PLAIN;
        }

        @Override
        public PasswordValidator createValdiator ()
        {
            return new PlainValidator ( true );
        }

        @Override
        public PasswordEncoder createEncoder () throws Exception
        {
            return getEncoding ().getEncoder ( "UTF-8", new HexCodec () );
        }
    },
    MD5_HEX
    {
        @Override
        public PasswordEncoding getEncoding () throws Exception
        {
            return PasswordEncoding.MD5;
        }

        @Override
        public PasswordValidator createValdiator ()
        {
            return new DigestValidator ( PasswordEncoding.MD5, "UTF-8", new HexCodec () );
        }

        @Override
        public PasswordEncoder createEncoder () throws Exception
        {
            return getEncoding ().getEncoder ( "UTF-8", new HexCodec () );
        }
    },
    SHA1_HEX
    {
        @Override
        public PasswordEncoding getEncoding () throws Exception
        {
            return PasswordEncoding.SHA1;
        }

        @Override
        public PasswordValidator createValdiator ()
        {
            return new DigestValidator ( PasswordEncoding.SHA1, "UTF-8", new HexCodec () );
        }

        @Override
        public PasswordEncoder createEncoder () throws Exception
        {
            return getEncoding ().getEncoder ( "UTF-8", new HexCodec () );
        }
    };

    public abstract PasswordEncoding getEncoding () throws Exception;

    public abstract PasswordValidator createValdiator ();

    public abstract PasswordEncoder createEncoder () throws Exception;

    /**
     * @see PasswordValidator#getSupportedInputEncodings()
     */
    public List<PasswordEncoding> getSupportedInputEncodings ()
    {
        return createValdiator ().getSupportedInputEncodings ();
    }

}