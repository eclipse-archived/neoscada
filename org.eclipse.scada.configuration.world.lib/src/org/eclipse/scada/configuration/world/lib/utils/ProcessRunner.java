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
package org.eclipse.scada.configuration.world.lib.utils;

import java.lang.ProcessBuilder.Redirect;

public class ProcessRunner
{
    private final ProcessBuilder processBuilder;

    public ProcessRunner ( final ProcessBuilder processBuilder )
    {
        this.processBuilder = processBuilder;
        processBuilder.redirectError ( Redirect.INHERIT );
        processBuilder.redirectOutput ( Redirect.INHERIT );
        processBuilder.redirectInput ( Redirect.INHERIT );
    }

    public int run () throws Exception
    {
        final Process process = this.processBuilder.start ();
        return process.waitFor ();
    }
}
