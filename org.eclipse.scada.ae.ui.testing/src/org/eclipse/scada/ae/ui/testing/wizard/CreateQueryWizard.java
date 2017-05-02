/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.ae.ui.testing.navigator.QueryListWrapper;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class CreateQueryWizard extends Wizard implements INewWizard
{

    private QueryListWrapper wrapper;

    private QueryStringWizardPage page;

    public CreateQueryWizard ()
    {
    }

    @Override
    public boolean performFinish ()
    {
        if ( this.wrapper == null )
        {
            return false;
        }

        this.wrapper.createQuery ( this.page.getFilterType (), this.page.getFilterData () );
        return true;
    }

    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        final Object o = selection.getFirstElement ();
        if ( o instanceof QueryListWrapper )
        {
            this.wrapper = (QueryListWrapper)o;
        }
    }

    @Override
    public void addPages ()
    {
        addPage ( this.page = new QueryStringWizardPage () );
    }

}
