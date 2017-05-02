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
package org.eclipse.scada.configuration.utils;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelWriter
{

    private final static Logger logger = LoggerFactory.getLogger ( ModelWriter.class );

    private final EObject content;

    public ModelWriter ( final EObject content )
    {
        this.content = content;
    }

    public void store ( final URI uri ) throws IOException
    {
        logger.debug ( "Storing model to: {}", uri );

        final ResourceSet rs = new ResourceSetImpl ();
        final Resource r = rs.createResource ( uri );
        r.getContents ().add ( this.content );
        r.save ( null );
    }
}
