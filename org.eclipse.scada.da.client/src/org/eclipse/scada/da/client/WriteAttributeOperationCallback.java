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
package org.eclipse.scada.da.client;

import org.eclipse.scada.da.core.WriteAttributeResults;

public interface WriteAttributeOperationCallback
{
    public abstract void complete ( WriteAttributeResults result );

    public abstract void failed ( String error );

    public abstract void error ( Throwable e );
}
