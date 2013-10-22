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
package org.eclipse.scada.da.server.ui;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.scada.da.core.server.Hive;

public interface ServerDescriptor extends ServerLifecycle
{
    public String getLabel ();

    public String getAdditionalLabe ();

    public ImageDescriptor getImageDescriptor ();

    public IObservableSet getEndpoints ();

    public Hive getHive ();

    public boolean hasManagementInterface ();

    public void createManagementInterface ( Composite parent );
}
