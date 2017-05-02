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
package org.eclipse.scada.ca.common.factory;

import java.util.Map;

import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.lang.Disposable;

public interface Service extends Disposable
{
    public void update ( UserInformation userInformation, Map<String, String> properties ) throws Exception;
}
