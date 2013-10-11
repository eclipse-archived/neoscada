/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.chart.draw2d;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartPackage;

public class ChartHelper
{

    public static Chart loadConfiguraton ( final String configurationUri )
    {
        if ( configurationUri == null || configurationUri.isEmpty () )
        {
            return null;
        }

        // load
        ChartPackage.eINSTANCE.eClass ();

        final ResourceSet resourceSet = new ResourceSetImpl ();

        resourceSet.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "*", new XMIResourceFactoryImpl () ); //$NON-NLS-1$

        final Resource resource = resourceSet.getResource ( URI.createURI ( configurationUri ), true );

        for ( final EObject o : resource.getContents () )
        {
            if ( o instanceof Chart )
            {
                return (Chart)o;
            }
        }
        return null;
    }

}
