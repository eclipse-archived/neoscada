/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.handler.mail;

import java.io.Serializable;

public class MailRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    private final String subject;

    private final String text;

    public MailRequest ( final String subject, final String text )
    {
        super ();
        this.subject = subject;
        this.text = text;
    }

    public String getSubject ()
    {
        return this.subject;
    }

    public String getText ()
    {
        return this.text;
    }

}
