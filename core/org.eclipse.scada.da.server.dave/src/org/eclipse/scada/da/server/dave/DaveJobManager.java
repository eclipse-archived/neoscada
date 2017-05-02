/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
 *******************************************************************************/
package org.eclipse.scada.da.server.dave;

import org.eclipse.scada.da.server.common.io.JobManager;

public class DaveJobManager extends JobManager
{
    public DaveJobManager ( final DaveDevice device )
    {
        super ( "DaveJobManager/" + device.getId () );
    }

}
