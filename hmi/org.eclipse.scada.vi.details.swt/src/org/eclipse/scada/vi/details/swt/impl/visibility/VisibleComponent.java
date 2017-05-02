/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.visibility;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.scada.vi.data.SummaryProvider;

public interface VisibleComponent
{
    public void show ();

    public void hide ();

    public void create ();

    public void dispose ();

    public IObservableSet getDescriptors ();

    public SummaryProvider getSummaryProvider ();

    public void start ();

    public void stop ();
}
