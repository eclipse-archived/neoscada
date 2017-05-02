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
package org.eclipse.scada.vi.details.swt.impl;

import java.util.Map;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.details.model.Visibility;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.impl.visibility.VisibilityProviderFactory;
import org.eclipse.swt.widgets.Composite;

public interface GroupTab
{
    public void dispose ();

    public String getLabel ();

    public void init ( final VisibilityProviderFactory factory, final Composite parent, final Map<String, String> properties );

    /**
     * get descriptors
     * 
     * @return an observable set of {@link DataItemDescriptor}s
     */
    public IObservableSet getDescriptors ();

    public Visibility getVisibility ();

    public SummaryProvider getSummaryProvider ();

    public void start ();

    public void stop ();
}