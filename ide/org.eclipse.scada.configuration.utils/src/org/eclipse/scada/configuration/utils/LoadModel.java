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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.recipe.lib.Output;
import org.eclipse.scada.utils.inject.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadModel
{

    private final static Logger logger = LoggerFactory.getLogger ( LoadModel.class );

    @Output
    private Object model;

    @Inject
    @Optional
    private Class<?> modelClazz;

    @Inject
    @Optional
    private String documentRoot;

    @Inject
    private String uri;

    public void load () throws IOException
    {
        logger.debug ( "Loading model - documentRoot: {}, modelClazz: {}", this.documentRoot, this.uri, this.modelClazz );

        URI uri = URI.createURI ( this.uri );
        if ( this.documentRoot != null )
        {
            final URI base = URI.createURI ( this.documentRoot );
            uri = uri.resolve ( base );
            logger.debug ( "Resolved URI: {}", uri );
        }
        final ModelLoader<?> loader = new ModelLoader<Object> ( this.modelClazz == null ? EObject.class : this.modelClazz );
        this.model = loader.load ( uri );
    }

    /*
     * A getter is not necessary, but kills the warning and it will be preferred when
     * getting the output value
     */
    public Object getModel ()
    {
        return this.model;
    }
}
