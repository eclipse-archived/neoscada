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
package org.eclipse.scada.ca.ui.editor.factory;

import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.ca.ui.data.ConfigurationDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

final class FactoryCellLabelProvider extends StyledCellLabelProvider
{

    @Override
    public void update ( final ViewerCell cell )
    {
        final ConfigurationDescriptor cfg = (ConfigurationDescriptor)cell.getElement ();
        switch ( cell.getColumnIndex () )
        {
        case 0:
            cell.setText ( cfg.getConfigurationInformation ().getId () );
            break;
        case 1:
            cell.setText ( "" + cfg.getConfigurationInformation ().getState () );
            break;
        }

        if ( cfg.getConfigurationInformation ().getErrorInformation () != null )
        {
            cell.setBackground ( Display.getCurrent ().getSystemColor ( SWT.COLOR_RED ) );
        }
        else
        {
            cell.setBackground ( null );
        }

        super.update ( cell );
    }

    @Override
    public String getToolTipText ( final Object element )
    {
        final ConfigurationDescriptor cfg = (ConfigurationDescriptor)element;
        return cfg.getConfigurationInformation ().getErrorInformation ();
    }
}