/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.connection.provider.info;

import java.util.Collection;

import org.eclipse.scada.core.info.StatisticEntry;

public interface ConnectionInformationProvider
{

    public String getLabel ();

    public Collection<StatisticEntry> getStatistics ();

}
