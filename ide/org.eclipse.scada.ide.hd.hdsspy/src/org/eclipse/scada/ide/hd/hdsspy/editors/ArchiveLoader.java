/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide.hd.hdsspy.editors;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.runtime.CoreException;

public interface ArchiveLoader
{
    public void performLoad ( WritableList list ) throws CoreException;
}
