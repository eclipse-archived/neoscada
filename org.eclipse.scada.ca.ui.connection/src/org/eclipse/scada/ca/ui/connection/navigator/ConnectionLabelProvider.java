/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.connection.navigator;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.scada.ca.ui.connection.data.ConfigurationInformationBean;
import org.eclipse.scada.ca.ui.connection.data.FactoryInformationBean;
import org.eclipse.scada.ca.ui.connection.data.FactoryInformationBean.State;
import org.eclipse.scada.ui.databinding.CommonListeningLabelProvider;
import org.eclipse.scada.ui.databinding.StyledViewerLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionLabelProvider extends CommonListeningLabelProvider implements PropertyChangeListener
{

    private final static Logger logger = LoggerFactory.getLogger ( ConnectionLabelProvider.class );

    private final ResourceManager resource = new LocalResourceManager ( JFaceResources.getResources () );

    public ConnectionLabelProvider ()
    {
        super ( "org.eclipse.scada.ca.ui.connection.provider" );
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
        logger.debug ( "Update label: {}", element );

        if ( element instanceof FactoryInformationBean )
        {
            final FactoryInformationBean entry = (FactoryInformationBean)element;
            final StyledString string = new StyledString ( entry.getFactoryInformation ().getId () );

            string.append ( String.format ( " [%s]", entry.getFactoryInformation ().getState () ), StyledString.DECORATIONS_STYLER );

            if ( entry.getConfigurations () != null && entry.getState () == State.COMPLETE )
            {
                string.append ( String.format ( " (%s)", entry.getConfigurations ().size () ), StyledString.COUNTER_STYLER );
            }

            label.setStyledText ( string );
        }
        else if ( element instanceof ConfigurationInformationBean )
        {
            final ConfigurationInformationBean entry = (ConfigurationInformationBean)element;

            final StyledString string = new StyledString ( entry.getConfigurationInformation ().getId () );

            string.append ( String.format ( " [%s]", entry.getConfigurationInformation ().getState () ), StyledString.DECORATIONS_STYLER );

            label.setStyledText ( string );
        }
        else
        {
            super.updateLabel ( label, element );
        }
    }

    @Override
    public String getDescription ( final Object element )
    {
        if ( element instanceof FactoryInformationBean )
        {
            return ( (FactoryInformationBean)element ).getFactoryInformation ().getDescription ();
        }
        else
        {
            return super.getDescription ( element );
        }
    }

    @Override
    protected void addListenerTo ( final Object next )
    {
        super.addListenerTo ( next );
        if ( next instanceof FactoryInformationBean )
        {
            ( (FactoryInformationBean)next ).addPropertyChangeListener ( this );
        }
    }

    @Override
    protected void removeListenerFrom ( final Object next )
    {
        if ( next instanceof FactoryInformationBean )
        {
            ( (FactoryInformationBean)next ).removePropertyChangeListener ( this );
        }

        super.removeListenerFrom ( next );
    }

    @Override
    public void propertyChange ( final PropertyChangeEvent evt )
    {
        fireChangeEvent ( Arrays.asList ( evt.getSource () ) );
    }

}
