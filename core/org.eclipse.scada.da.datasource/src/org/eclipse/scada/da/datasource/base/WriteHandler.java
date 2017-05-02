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
package org.eclipse.scada.da.datasource.base;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.sec.UserInformation;

public interface WriteHandler
{
    /**
     * Handle the write call
     * <p>
     * e.g. performs a write call to a subsystem
     * @param userInformation the user information of the write call.
     * May also be <code>null<code> if there is no user information.
     * @param value the value to write
     * @throws Exception if anything goes wrong
     */
    public abstract void handleWrite ( UserInformation userInformation, Variant value ) throws Exception;
}
