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

import javax.inject.Inject;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.utils.inject.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoreModel
{
    private final static Logger logger = LoggerFactory.getLogger ( StoreModel.class );

    @Inject
    private EObject model;

    @Inject
    @Optional
    private String documentRoot;

    @Inject
    @Optional
    private IContainer output;

    @Inject
    private String uri;

    @Inject
    @Optional
    private IProgressMonitor monitor;

    public void store () throws IOException, CoreException
    {
        logger.debug ( "Store model - documentRoot: {}, uri: {}", this.documentRoot, this.uri );

        URI uri = URI.createURI ( this.uri );
        if ( this.output != null )
        {
            final URI base = URI.createURI ( this.output.getLocationURI ().toString () + "/" );
            uri = uri.resolve ( base );
            logger.debug ( "Resolved URI: {} using container ({})", uri, this.output.getLocationURI () );
        }
        else if ( this.documentRoot != null )
        {
            final URI base = URI.createURI ( this.documentRoot );
            uri = uri.resolve ( base );
            logger.debug ( "Resolved URI: {}", uri );
        }

        final ModelWriter writer = new ModelWriter ( this.model );
        writer.store ( uri );

        if ( this.output != null )
        {
            this.output.refreshLocal ( 1, this.monitor != null ? this.monitor : new NullProgressMonitor () );
        }
    }
}
