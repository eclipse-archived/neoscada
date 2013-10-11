/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
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
package org.eclipse.scada.ui.chart.viewer;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinePropertiesBinder
{

    private final static Logger logger = LoggerFactory.getLogger ( LinePropertiesBinder.class );

    public static Collection<Binding> bind ( final Realm realm, final DataBindingContext dbc, final IObservableValue lineInputObservable, final IObservableValue linePropertiesObservable )
    {
        final Collection<Binding> result = new LinkedList<Binding> ();

        try
        {
            result.add ( dbc.bindValue ( PojoObservables.observeDetailValue ( lineInputObservable, "lineWidth", null ), EMFObservables.observeDetailValue ( realm, linePropertiesObservable, ChartPackage.Literals.LINE_PROPERTIES__WIDTH ) ) ); //$NON-NLS-1$
            result.add ( dbc.bindValue ( PojoObservables.observeDetailValue ( lineInputObservable, "lineColor", null ), EMFObservables.observeDetailValue ( realm, linePropertiesObservable, ChartPackage.Literals.LINE_PROPERTIES__COLOR ) ) ); //$NON-NLS-1$
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to bind line properties", e ); //$NON-NLS-1$
        }

        return result;
    }
}
