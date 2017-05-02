/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.oscar.sec;

import java.util.Map;

import org.eclipse.scada.configuration.security.CA;
import org.eclipse.scada.configuration.security.SignatureRule;

public class SigatureRuleEncoder extends RuleEncoder
{

    private final SignatureRule rule;

    public SigatureRuleEncoder ( final SignatureRule rule )
    {
        super ( rule );
        this.rule = rule;
    }

    @Override
    protected void putData ( final Map<String, String> data )
    {
        super.putData ( data );

        data.put ( "properties.reloadPeriod", "" + this.rule.getReloadPeriod () );

        int i = 0;
        for ( final CA ca : this.rule.getTrustedCertificationAuthority () )
        {
            if ( ca.getCertificateUrl () != null )
            {
                data.put ( String.format ( "properties.ca.%s.cert", i ), ca.getCertificateUrl () );
            }

            int j = 0;
            for ( final String url : ca.getCrlUrl () )
            {
                data.put ( String.format ( "properties.ca.%s.crl.%s", i, j ), url );
                j++;
            }
            i++;
        }

        putScript ( data, "properties.postProcessor", this.rule.getPostProcessor () );
    }
}
