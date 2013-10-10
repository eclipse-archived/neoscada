/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.server.storage.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.utils.filter.Filter;

public interface StorageDao
{

    public void storeEvent ( Event event ) throws Exception;

    public void updateComment ( UUID id, String comment ) throws Exception;

    public Event loadEvent ( UUID id ) throws SQLException;

    public ResultSet queryEvents ( Filter filter ) throws SQLException, NotSupportedException;

    public boolean toEventList ( ResultSet rs, Collection<Event> events, boolean isBeforeFirst, long count ) throws SQLException;

    public void dispose ();

    public void cleanupArchive ();

}