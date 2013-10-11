/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.signalgenerator.page;

import org.eclipse.scada.da.client.signalgenerator.SimulationTarget;
import org.eclipse.swt.widgets.Composite;

public interface GeneratorPage
{
    public void createPage ( Composite parent );

    public void dispose ();

    public void setTarget ( SimulationTarget target );

    public void start ();

    public void stop ();
}
