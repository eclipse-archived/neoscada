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
package org.eclipse.scada.vi.ui.user;

import org.eclipse.scada.vi.ui.user.viewer.ViewInstance;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

public class ErrorView implements ViewInstance
{

    private final Label label;

    private final ViewInstanceDescriptor descriptor;

    public ErrorView ( final Composite parent, final ViewInstanceDescriptor descriptor )
    {
        this.descriptor = descriptor;

        this.label = new Label ( parent, SWT.NONE );
        this.label.setText ( "Error" );
    }

    @Override
    public void reload ()
    {
    }

    @Override
    public void deactivate ()
    {
    }

    @Override
    public void activate ()
    {
    }

    @Override
    public void setFocus ()
    {
        this.label.setFocus ();
    }

    @Override
    public Control getControl ()
    {
        return this.label;
    }

    @Override
    public boolean isDefaultInstance ()
    {
        return false;
    }

    @Override
    public ViewInstanceDescriptor getDescriptor ()
    {
        return this.descriptor;
    }

    @Override
    public boolean isActive ()
    {
        return true;
    }

    @Override
    public boolean isLazy ()
    {
        return false;
    }

}
