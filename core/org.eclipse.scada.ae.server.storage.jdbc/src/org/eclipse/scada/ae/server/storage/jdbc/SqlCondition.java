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
package org.eclipse.scada.ae.server.storage.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SqlCondition
{

    public String condition = "";

    public List<String> joins = new ArrayList<String> ();

    public List<String> joinParameters = new ArrayList<String> ();

    public List<Serializable> parameters = new ArrayList<Serializable> ();

    @Override
    public String toString ()
    {
        return this.condition + " (params = " + this.parameters + ")";
    }

}
