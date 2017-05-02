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
import java.util.Map;

public interface PasswordValidator
{
    /**
     * Get the list of supported password encodings in order of preference
     * 
     * @return the list of supported password encodings
     */
    public List<PasswordEncoding> getSupportedInputEncodings ();

    public boolean validatePassword ( Map<PasswordEncoding, String> passwords, String password ) throws Exception;
}
