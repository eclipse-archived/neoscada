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
package org.eclipse.scada.core.ui.connection.views.tree;

import org.eclipse.core.databinding.observable.set.IObservableSet;

public interface TreeNode
{

    public abstract void dispose ();

    public abstract IObservableSet getChildren ();

    public abstract IObservableSet getConnections ();

    public abstract String getName ();

    public abstract TreeNode getParentNode ();

}