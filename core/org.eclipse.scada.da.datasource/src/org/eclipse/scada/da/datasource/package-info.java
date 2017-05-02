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
/**
 * A source of data in the OSGi based <q>master server</q>.
 * <br/>
 * The concept of {@link org.eclipse.scada.da.datasource.DataSource} is used in the
 * OSGi based master server, where data items are connected in service pipelines to process
 * data. Each node in this pipeline is a datasource.
 * <br/>
 * The concept should not be used outside the master server or comparable services.
 */
package org.eclipse.scada.da.datasource;