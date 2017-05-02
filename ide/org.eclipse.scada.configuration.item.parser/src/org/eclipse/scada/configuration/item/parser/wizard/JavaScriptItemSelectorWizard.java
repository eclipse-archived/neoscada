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
package org.eclipse.scada.configuration.item.parser.wizard;

import java.io.InputStream;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.scada.configuration.item.parser.Activator;

public class JavaScriptItemSelectorWizard extends AbstractNewFileWizard
{
    public JavaScriptItemSelectorWizard ()
    {
        super ( "My", "icm_js" );
    }

    @Override
    protected InputStream createInputSource () throws Exception
    {
        return FileLocator.openStream ( Activator.getDefault ().getBundle (), new Path ( "templates/empty.icm_js" ), true );
    }

}
