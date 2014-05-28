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
package org.eclipse.scada.configuration.driver.parser.lib;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.scada.configuration.driver.parser.ParserDriver;
import org.eclipse.scada.configuration.world.lib.oscar.EquinoxApplicationProcessor;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;

public class ParserDriverProcessor extends EquinoxApplicationProcessor
{
    private final ParserDriver driver;

    public ParserDriverProcessor ( final ParserDriver driver )
    {
        super ( driver );
        this.driver = driver;
    }

    @Override
    protected void processForContext ( final OscarContext ctx, final IFolder output, final IProgressMonitor monitor ) throws Exception
    {
        for ( final Component device : this.driver.getComponents () )
        {
            createComponent ( ctx, device );
        }
    }

    private void createComponent ( final OscarContext ctx, final Component component ) throws IOException
    {
        final Map<String, String> data = new HashMap<> ();

        final String id = component.getId ();
        final String xml = makeXml ( component );

        data.put ( "configuration", xml );

        // FIXME: replace with Constants entry
        ctx.addData ( "org.eclipse.scada.da.server.component.parser.factory", id, data );
    }

    private String makeXml ( final Component component ) throws IOException
    {
        final XMIResourceImpl xmi = new XMIResourceImpl ();
        xmi.getContents ().add ( component );

        final StringWriter writer = new StringWriter ();
        xmi.save ( writer, null );
        return writer.toString ();
    }

}
