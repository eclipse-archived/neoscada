/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers;

import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.scada.sec.ui.providers.internal.FactoryImpl;
import org.eclipse.scada.sec.ui.providers.internal.LabelProviderImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class KeyTreeViewer
{

    private final TreeViewer viewer;

    private final ObservableListTreeContentProvider contentProvider;

    private LabelProviderImpl labelProvider;

    private final LocalResourceManager resourceManager;

    public KeyTreeViewer ( final Composite parent )
    {
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources ( parent.getDisplay () ), parent );

        this.viewer = new TreeViewer ( parent );
        this.viewer.getControl ().setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        this.viewer.setAutoExpandLevel ( AbstractTreeViewer.ALL_LEVELS );

        this.contentProvider = new ObservableListTreeContentProvider ( new FactoryImpl (), null );
        this.viewer.setContentProvider ( this.contentProvider );
        this.viewer.setLabelProvider ( this.labelProvider = new LabelProviderImpl ( this.resourceManager, this.contentProvider.getRealizedElements () ) );
    }

    public void setInput ( final KeyFactoryManager manager )
    {
        this.viewer.setInput ( manager.getList () );
    }

    public void setInput ( final KeyProviderFactory factory )
    {
        this.viewer.setInput ( factory );
    }

    public void dispose ()
    {
        this.labelProvider.dispose ();
        this.contentProvider.dispose ();
        this.viewer.getControl ().dispose ();
    }

    public Control getControl ()
    {
        return this.viewer.getControl ();
    }

    public TreeViewer getTreeViewer ()
    {
        return this.viewer;
    }

}
