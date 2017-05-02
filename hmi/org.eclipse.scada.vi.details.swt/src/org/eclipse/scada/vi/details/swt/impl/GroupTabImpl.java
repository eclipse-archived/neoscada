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
import org.eclipse.scada.vi.details.swt.DetailComponent;
import org.eclipse.scada.vi.details.swt.impl.visibility.VisibilityProviderFactory;
import org.eclipse.swt.widgets.Composite;

class GroupTabImpl implements GroupTab
{
    private final DetailComponent component;

    private final String label;

    private final Visibility visibility;

    public GroupTabImpl ( final String label, final DetailComponent component, final Visibility visibility )
    {
        this.label = label;
        this.component = component;
        this.visibility = visibility;
    }

    @Override
    public void dispose ()
    {
        this.component.dispose ();
    }

    @Override
    public void init ( final VisibilityProviderFactory factory, final Composite parent, final Map<String, String> properties )
    {
        this.component.init ( factory, parent, properties );
    }

    @Override
    public String getLabel ()
    {
        return this.label;
    }

    @Override
    public IObservableSet getDescriptors ()
    {
        return this.component.getDescriptors ();
    }

    @Override
    public Visibility getVisibility ()
    {
        return this.visibility;
    }

    @Override
    public void start ()
    {
        this.component.start ();
    }

    @Override
    public void stop ()
    {
        this.component.stop ();
    }

    @Override
    public SummaryProvider getSummaryProvider ()
    {
        return this.component.getSummaryProvider ();
    }
}