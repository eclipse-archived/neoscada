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
package org.eclipse.scada.sec.ui.providers;

import java.security.Key;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;

public class KeyInformation
{
    private final Key key;

    private final Certificate certificate;

    private final String alias;

    public KeyInformation ( final String alias, final Key key, final Certificate certificate )
    {
        this.alias = alias;
        this.key = key;
        this.certificate = certificate;
    }

    public String getAlias ()
    {
        return this.alias;
    }

    public Certificate getCertificate ()
    {
        return this.certificate;
    }

    public Key getKey ()
    {
        return this.key;
    }

    @Override
    public String toString ()
    {
        if ( this.certificate instanceof X509Certificate )
        {
            final X500Principal subject = ( (X509Certificate)this.certificate ).getSubjectX500Principal ();
            if ( subject != null )
            {
                return subject.toString ();
            }
        }
        if ( this.key != null )
        {
            return this.key.toString ();
        }
        else
        {
            return null;
        }
    }
}
