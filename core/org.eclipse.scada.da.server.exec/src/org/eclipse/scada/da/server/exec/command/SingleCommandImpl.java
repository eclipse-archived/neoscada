/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exec.command;

import java.util.Collection;

import org.eclipse.scada.da.server.exec.extractor.Extractor;

public class SingleCommandImpl extends AbstractSingleCommand implements SingleCommand
{

    public SingleCommandImpl ( final String id, final ProcessConfiguration processConfiguration, final Collection<Extractor> extractors )
    {
        super ( id, processConfiguration, extractors );
    }

    public void execute ()
    {
        execute ( this.processConfiguration.asProcessBuilder (), null );
    }

}
