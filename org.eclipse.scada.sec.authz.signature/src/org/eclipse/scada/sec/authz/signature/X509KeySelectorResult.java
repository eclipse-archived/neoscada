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
package org.eclipse.scada.sec.authz.signature;

import java.security.Key;
import java.security.cert.X509Certificate;

import javax.xml.crypto.KeySelectorResult;

/**
 * @since 1.1
 */
public class X509KeySelectorResult implements KeySelectorResult
{

    private final X509Certificate certificate;

    public X509KeySelectorResult ( final X509Certificate certificate )
    {
        this.certificate = certificate;
    }

    @Override
    public Key getKey ()
    {
        return this.certificate.getPublicKey ();
    }

    public X509Certificate getCertificate ()
    {
        return this.certificate;
    }

}
