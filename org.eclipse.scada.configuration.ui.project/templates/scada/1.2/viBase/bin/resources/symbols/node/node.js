/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
function makeHeaderProperties() {
	properties.put("detailsId", "org.eclipse.scada.details.node");
	// properties.put("maintenancePrefix", maintenancePrefix());
	properties.put("sumItem", prefixed("SUM.V"));
}