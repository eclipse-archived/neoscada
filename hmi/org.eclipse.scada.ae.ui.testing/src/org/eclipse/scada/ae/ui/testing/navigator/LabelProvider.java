/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.testing.navigator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.scada.ui.databinding.CommonListeningLabelProvider;
import org.eclipse.scada.ui.databinding.StyledViewerLabel;

public class LabelProvider extends CommonListeningLabelProvider implements PropertyChangeListener
{
    private final ResourceManager resource = new LocalResourceManager ( JFaceResources.getResources () );

    public LabelProvider ()
    {
        super ( "org.eclipse.scada.ae.ui.testing.query.contentExtension" );
    }

    @Override
    public void dispose ()
    {
        this.resource.dispose ();
        super.dispose ();
    }

    @Override
    public void updateLabel ( final StyledViewerLabel label, final Object element )
    {
        if ( element instanceof QueryListWrapper )
        {
            label.setText ( "Test Queries" );
        }
        else if ( element instanceof QueryBean )
        {
            final QueryBean query = (QueryBean)element;
            final StyledString text = new StyledString ();
            text.append ( String.format ( "%.20s:%.40s", query.getFilterType (), query.getFilterData () ) );
            text.append ( " " );
            text.append ( String.format ( "%s", query.getCount () ), StyledString.COUNTER_STYLER );
            text.append ( " " );
            text.append ( String.format ( "[%s]", query.getState () ), StyledString.DECORATIONS_STYLER );
            label.setStyledText ( text );
            label.setTooltipText ( String.format ( "%s%n%s", query.getFilterType (), query.getFilterData () ) );
        }
        else
        {
            super.updateLabel ( label, element );
        }
    }

    @Override
    protected void addListenerTo ( final Object next )
    {
        super.addListenerTo ( next );
        if ( next instanceof QueryBean )
        {
            ( (QueryBean)next ).addPropertyChangeListener ( this );
        }
    }

    @Override
    protected void removeListenerFrom ( final Object next )
    {
        if ( next instanceof QueryBean )
        {
            ( (QueryBean)next ).removePropertyChangeListener ( this );
        }
        super.removeListenerFrom ( next );
    }

    public void propertyChange ( final PropertyChangeEvent evt )
    {
        fireChangeEvent ( Arrays.asList ( evt.getSource () ) );
    }

}
