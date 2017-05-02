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

import java.security.cert.Certificate;

public interface Key extends Locked
{
    public boolean isPrivate ();

    public java.security.Key getKey ();

    public Certificate getCertificate ();

    public String getName ();

    public void dispose ();
}
