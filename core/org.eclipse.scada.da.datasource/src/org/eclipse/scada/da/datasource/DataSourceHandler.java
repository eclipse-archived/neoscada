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
package org.eclipse.scada.da.datasource;

import org.eclipse.scada.core.VariantType;
import org.eclipse.scada.da.client.DataItemValue;

public interface DataSourceHandler
{

    public abstract void dispose ();

    public abstract DataItemValue getValue ();

    public abstract VariantType getType ();

}