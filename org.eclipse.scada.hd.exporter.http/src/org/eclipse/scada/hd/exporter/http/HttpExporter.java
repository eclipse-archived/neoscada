/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.exporter.http;

import java.util.Date;
import java.util.List;

public interface HttpExporter
{
    List<String> getItems () throws Exception;

    List<String> getSeries ( String itemId ) throws Exception;

    List<DataPoint> getData ( String item, String type, Date from, Date to, Integer number ) throws Exception;
}
