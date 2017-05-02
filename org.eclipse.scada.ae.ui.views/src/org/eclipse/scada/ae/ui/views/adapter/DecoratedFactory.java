/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new adapter helper
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.adapter;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.ae.ui.views.handler.AckInformation;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;

public class DecoratedFactory implements IAdapterFactory
{

    @SuppressWarnings ( { "rawtypes", "unchecked" } )
    @Override
    public Object getAdapter ( final Object adaptableObject, final Class adapterType )
    {
        return AdapterHelper.adapt ( adaptableObject, adapterType );
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class<?>[] { AckInformation.class };
    }

}
