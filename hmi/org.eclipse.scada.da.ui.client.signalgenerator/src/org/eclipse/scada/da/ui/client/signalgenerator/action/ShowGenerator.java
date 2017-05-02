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
package org.eclipse.scada.da.ui.client.signalgenerator.action;

import org.eclipse.scada.da.ui.client.signalgenerator.GeneratorView;
import org.eclipse.scada.da.ui.common.AbstractItemAction;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

public class ShowGenerator extends AbstractItemAction
{

    public ShowGenerator ()
    {
        super ( Messages.getString ( "ShowGenerator.actionName" ) ); //$NON-NLS-1$
    }

    @Override
    protected void processItem ( final Item item ) throws PartInitException
    {
        final GeneratorView view = (GeneratorView)this.page.showView ( GeneratorView.VIEW_ID, asSecondardId ( item ), IWorkbenchPage.VIEW_ACTIVATE );
        view.setDataItem ( item );
    }
}
