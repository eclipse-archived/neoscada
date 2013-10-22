/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.configuration.generator.world.validator.handler;

import java.util.Arrays;

public class AverageHandler extends ExpandHandler
{
    public AverageHandler ()
    {
        super ( "datasource", Arrays.asList ( "min", "max", "mean", "median", "deviation", "sum" ) );
    }

}
