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
package org.eclipse.scada.vi.ui.user.viewer;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPartSite;

public interface ViewInstanceFactory
{
    public ViewInstance createViewInstance ( final ViewManager viewManager, final ViewManagerContext viewManagerContext, ViewInstanceDescriptor descriptor, Composite viewHolder, ResourceManager manager, IWorkbenchPartSite site );
}
