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
import org.eclipse.scada.configuration.item.parser.wizard.SelectPipelineTypeWizardPage.Type;

public class JavaScriptPipelineWizard extends AbstractNewFileWizard
{
    private SelectPipelineTypeWizardPage page;

    public JavaScriptPipelineWizard ()
    {
        super ( "My", "isel_js" );
    }

    @Override
    public void addPages ()
    {
        super.addPages ();
        this.page = new SelectPipelineTypeWizardPage ( "type", "Select Type", null );
        addPage ( this.page );
    }

    @Override
    protected InputStream createInputSource () throws Exception
    {
        Type type = this.page.getTypeSelection ();
        if ( type == null )
        {
            type = Type.EMPTY;
        }
        return FileLocator.openStream ( Activator.getDefault ().getBundle (), new Path ( String.format ( "templates/%s", type.getResourceName () ) ), true );
    }

}
