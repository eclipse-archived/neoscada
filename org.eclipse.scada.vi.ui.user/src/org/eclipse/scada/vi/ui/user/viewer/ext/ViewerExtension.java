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
package org.eclipse.scada.vi.ui.user.viewer.ext;

import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public interface ViewerExtension
{

    public Control create ( Composite parent, final ViewManager viewManager, boolean horizontal );

}
