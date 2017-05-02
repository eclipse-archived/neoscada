/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.connection.information;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

public class InformationBeanComparator extends ViewerComparator
{
    @Override
    public int compare ( final Viewer viewer, final Object e1, final Object e2 )
    {
        if ( e1 instanceof InformationBean && e2 instanceof InformationBean )
        {
            return ( (InformationBean)e1 ).compareTo ( (InformationBean)e2 );
        }
        return super.compare ( viewer, e1, e2 );
    }
}