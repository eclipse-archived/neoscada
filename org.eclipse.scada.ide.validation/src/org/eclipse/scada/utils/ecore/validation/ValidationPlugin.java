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
package org.eclipse.scada.utils.ecore.validation;

import java.util.Map;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.BundleContext;

public class ValidationPlugin extends Plugin
{
    private static ValidationPlugin INSTANCE;

    @Override
    public void start ( final BundleContext context ) throws Exception
    {
        super.start ( context );
        INSTANCE = this;
    }

    @Override
    public void stop ( final BundleContext context ) throws Exception
    {
        INSTANCE = null;
        super.stop ( context );
    }

    public static ValidationPlugin getDefault ()
    {
        return INSTANCE;
    }

    public static void runValidation ( final EObject target, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        new ValidationRunner ().run ( target, diagnostics, context );
    }
}
