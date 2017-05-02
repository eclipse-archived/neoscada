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
package org.eclipse.scada.vi.details;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DetailViewManager
{

    private static final Logger logger = LoggerFactory.getLogger ( DetailViewManager.class );

    private static final String EXTP_DETAIL_VIEW = "org.eclipse.scada.vi.details.detailView"; //$NON-NLS-1$

    public static DetailView openView ( final String id, final Map<String, String> properties ) throws CoreException
    {
        logger.info ( "Searching view: {}", id ); //$NON-NLS-1$

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_DETAIL_VIEW ) )
        {
            final String cfgId = ele.getAttribute ( "id" ); //$NON-NLS-1$

            logger.debug ( "Checking: {}", cfgId ); //$NON-NLS-1$

            if ( cfgId != null && cfgId.equals ( id ) )
            {
                return createDetailView ( id, ele, properties );
            }
        }
        return null;
    }

    private static DetailView createDetailView ( final String id, final IConfigurationElement ele, final Map<String, String> properties ) throws CoreException
    {
        final Object o = ele.createExecutableExtension ( "class" ); //$NON-NLS-1$
        if ( o instanceof DetailView )
        {
            final DetailView view = (DetailView)o;
            return view;
        }
        else
        {
            logger.warn ( "View created object of type: " + o ); //$NON-NLS-1$
            return null;
        }
    }
}
