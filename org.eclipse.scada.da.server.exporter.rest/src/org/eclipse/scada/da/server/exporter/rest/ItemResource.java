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
package org.eclipse.scada.da.server.exporter.rest;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;

@Path ( "/org.eclipse.scada/da" )
public interface ItemResource
{
    @GET
    @Path ( "/{contextId}/item/{itemId}" )
    public DataItemValue read (
            @PathParam ( "contextId" )
            final String contextId,
            @PathParam ( "itemId" )
            final String itemId );

    @POST
    @Path ( "/{contextId}/item/value/{itemId}" )
    public WriteResult write (
            @PathParam ( "contextId" )
            final String contextId,
            @PathParam ( "itemId" )
            final String itemId,
            Variant value
            );

    @POST
    @Path ( "/{contextId}/item/attributes/{itemId}" )
    public Map<String, WriteResult> writeAttribute (
            @PathParam ( "contextId" )
            final String contextId,
            @PathParam ( "itemId" )
            final String itemId,
            Map<String, Variant> attributes
            );
}
