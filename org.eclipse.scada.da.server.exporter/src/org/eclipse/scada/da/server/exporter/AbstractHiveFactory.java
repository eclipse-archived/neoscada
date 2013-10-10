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
package org.eclipse.scada.da.server.exporter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.scada.da.server.exporter.HiveConfigurationType;

public abstract class AbstractHiveFactory implements HiveFactory
{
    protected Object getConfigurationData ( final HiveConfigurationType configuration )
    {
        for ( FeatureMap.Entry entry : configuration.getAny () )
        {
            if ( entry.getValue () instanceof EObject )
            {
                return entry.getValue ();
            }
            else if ( FeatureMapUtil.isText ( entry ) )
            {
                return entry.getValue ();
            }
            else if ( FeatureMapUtil.isCDATA ( entry ) )
            {
                return entry.getValue ();
            }
        }
        return null;
    }

}
