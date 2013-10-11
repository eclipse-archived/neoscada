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
package org.eclipse.scada.ui.chart.view.command;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.IParameterValues;

public class ItemTypeParameters implements IParameterValues
{

    @Override
    public Map<String, String> getParameterValues ()
    {
        final Map<String, String> result = new HashMap<String, String> ();

        result.put ( Messages.ItemTypeParameters_da_item_label, "da" ); //$NON-NLS-2$
        result.put ( Messages.ItemTypeParameters_hd_item_label, "hd" ); //$NON-NLS-2$

        return result;
    }

}
