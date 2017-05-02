/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.scada.core.connection.provider.info.ConnectionInformationProvider;
import org.eclipse.scada.ui.databinding.ListeningStyledCellLabelProvider;

public class LabelProvider extends ListeningStyledCellLabelProvider implements PropertyChangeListener
{
    public LabelProvider ( final IObservableSet itemsThatNeedLabels )
    {
        super ( itemsThatNeedLabels );
    }

    @Override
    public void update ( final ViewerCell cell )
    {
        if ( cell.getElement () instanceof ConnectionInformationProvider )
        {
            final ConnectionInformationProvider provider = (ConnectionInformationProvider)cell.getElement ();
            switch ( cell.getColumnIndex () )
            {
                case 0:
                    cell.setText ( provider.getLabel () );
                    break;
            }
        }
        else if ( cell.getElement () instanceof InformationBean )
        {
            final InformationBean bean = (InformationBean)cell.getElement ();
            switch ( cell.getColumnIndex () )
            {
                case 0:
                    cell.setText ( bean.getLabel () );
                    break;
                case 1:
                    cell.setText ( format ( bean.getValue () ) );
                    break;
                case 2:
                    cell.setText ( format ( bean.getMin () ) );
                    break;
                case 3:
                    cell.setText ( format ( bean.getMax () ) );
                    break;
            }
        }
        super.update ( cell );
    }

    private String format ( final Number number )
    {
        if ( number == null )
        {
            return Messages.LabelProvider_Text_NA;
        }
        return NumberFormat.getNumberInstance ().format ( number.doubleValue () );
    }

    @Override
    public void propertyChange ( final PropertyChangeEvent evt )
    {
        fireLabelProviderChanged ( new LabelProviderChangedEvent ( this, evt.getSource () ) );
    }

    @Override
    protected void removeListenerFrom ( final Object next )
    {
        if ( next instanceof InformationBean )
        {
            ( (InformationBean)next ).removePropertyChangeListener ( this );
        }
    }

    @Override
    protected void addListenerTo ( final Object next )
    {
        if ( next instanceof InformationBean )
        {
            ( (InformationBean)next ).addPropertyChangeListener ( this );
        }
    }
}
