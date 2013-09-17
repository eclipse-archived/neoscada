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

import java.util.Map;

/**
 * @since 1.1
 */
public class XMLSignatureCallback extends AbstractCallback
{

    public static final String TYPE = "xmlsignature";

    public static final String PROP_DOCUMENT = "document";

    public static final String PROP_SIGNED_DOCUMENT = "signedDocument";

    public static final String PROP_MAXIMUM_REMEMBER_PERIOD = "maximumRememberPeriod";

    private String document;

    private String signedDocument;

    private int maximumRememberPeriod = Integer.getInteger ( "org.eclipse.scada.sec.callback.XMLSignatureCallback.maxKeepKeyOpenTimeout", 5 * 60 * 1000 /*5 minutes*/);

    public XMLSignatureCallback ()
    {
    }

    public XMLSignatureCallback ( final String document )
    {
        this.document = document;
    }

    public String getDocument ()
    {
        return this.document;
    }

    public String getSignedDocument ()
    {
        return this.signedDocument;
    }

    public void setSignedDocument ( final String signedDocument )
    {
        this.signedDocument = signedDocument;
    }

    public void setDocument ( final String document )
    {
        this.document = document;
    }

    @Override
    protected void injectRequestAttributes ( final Map<String, String> request )
    {
        super.injectRequestAttributes ( request );
        request.put ( PROP_DOCUMENT, this.document );
        request.put ( PROP_MAXIMUM_REMEMBER_PERIOD, "" + this.maximumRememberPeriod );
    }

    @Override
    public void parseRequestAttributes ( final Map<String, String> attributes )
    {
        super.parseRequestAttributes ( attributes );
        this.document = attributes.get ( PROP_DOCUMENT );
        this.maximumRememberPeriod = parseInteger ( attributes, PROP_MAXIMUM_REMEMBER_PERIOD, 5 * 1000 * 60 /* 5 minutes */);
    }

    @Override
    protected void injectResponseAttributes ( final Map<String, String> response )
    {
        super.injectResponseAttributes ( response );
        if ( this.signedDocument != null )
        {
            response.put ( PROP_SIGNED_DOCUMENT, this.signedDocument );
        }
    }

    @Override
    public void parseResponseAttributes ( final Map<String, String> attributes )
    {
        super.parseResponseAttributes ( attributes );
        this.signedDocument = attributes.get ( PROP_SIGNED_DOCUMENT );
    }

    @Override
    public String getType ()
    {
        return TYPE;
    }

    public void setMaximumRememberPeriod ( final int maximumRememberPeriod )
    {
        this.maximumRememberPeriod = maximumRememberPeriod;
    }

    public int getMaximumRememberPeriod ()
    {
        return this.maximumRememberPeriod;
    }

}
