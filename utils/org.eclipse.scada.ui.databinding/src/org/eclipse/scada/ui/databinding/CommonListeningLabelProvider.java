/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.databinding;

import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableSetTreeContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonListeningLabelProvider extends ListeningLabelProvider implements ICommonLabelProvider, IDescriptionProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( CommonListeningLabelProvider.class );

    private final String contentExtensionId;

    public CommonListeningLabelProvider ( final String contentExtensionId )
    {
        this.contentExtensionId = contentExtensionId;
    }

    @Override
    public void init ( final ICommonContentExtensionSite config )
    {
        final ITreeContentProvider contentProvider = config.getService ().getContentExtensionById ( this.contentExtensionId ).getContentProvider ();
        if ( contentProvider instanceof ObservableSetTreeContentProvider )
        {
            addSource ( ( (ObservableSetTreeContentProvider)contentProvider ).getKnownElements () );
        }
        else if ( contentProvider instanceof ObservableSetContentProvider )
        {
            addSource ( ( (ObservableSetContentProvider)contentProvider ).getKnownElements () );
        }
        else if ( contentProvider instanceof ObservableListContentProvider )
        {
            addSource ( ( (ObservableListContentProvider)contentProvider ).getKnownElements () );
        }
        else if ( contentProvider instanceof ObservableListTreeContentProvider )
        {
            addSource ( ( (ObservableListTreeContentProvider)contentProvider ).getKnownElements () );
        }
    }

    @Override
    public void restoreState ( final IMemento aMemento )
    {
    }

    @Override
    public void saveState ( final IMemento aMemento )
    {
    }

    /**
     * Empty implementation of getDescription
     */
    @Override
    public String getDescription ( final Object anElement )
    {
        logger.debug ( "getDescription: {}", anElement );
        return null;
    }

}
