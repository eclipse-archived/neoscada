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
package org.eclipse.scada.ca;

import java.util.Map;

import org.eclipse.scada.ca.data.ConfigurationState;

public interface Configuration
{
    public String getFactoryId ();

    public String getId ();

    public ConfigurationState getState ();

    public Throwable getErrorInformation ();

    public Map<String, String> getData ();
}
