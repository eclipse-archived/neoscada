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
package org.eclipse.scada.ae.ui.views.dialog;

import org.eclipse.scada.ae.ui.views.Messages;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.filter.FilterParseException;
import org.eclipse.scada.utils.filter.FilterParser;
import org.eclipse.scada.utils.lang.Pair;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilterFreeFormComposite extends Composite
{

    private static final Logger logger = LoggerFactory.getLogger ( FilterFreeFormComposite.class );

    private final FilterChangedListener filterChangedListener;

    private final String filter;

    public FilterFreeFormComposite ( final FilterChangedListener filterChangedListener, final Composite parent, final int style, final String filter )
    {
        super ( parent, style );
        if ( filter == null )
        {
            throw new IllegalArgumentException ( Messages.filter_must_not_be_null );
        }
        this.filterChangedListener = filterChangedListener;
        this.filter = filter;

        createComponents ();
    }

    private void createComponents ()
    {
        final FillLayout layout = new FillLayout ( SWT.VERTICAL );
        layout.marginHeight = 12;
        layout.marginWidth = 12;
        setLayout ( layout );

        final Text filterTextField = new Text ( this, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL );
        filterTextField.setText ( this.filter );
        filterTextField.addKeyListener ( new KeyAdapter () {
            @Override
            public void keyReleased ( final KeyEvent e )
            {
                verifyFilter ( filterTextField.getText () );
            }
        } );
    }

    public boolean verifyFilter ( final String filter )
    {
        try
        {
            final Filter parsedFilter = new FilterParser ( filter ).getFilter ();
            this.filterChangedListener.onFilterChanged ( new Pair<SearchType, String> ( SearchType.FREEFORM, parsedFilter.toString () ) );
        }
        catch ( final FilterParseException e )
        {
            this.filterChangedListener.onFilterParseError ( new Pair<SearchType, String> ( SearchType.FREEFORM, "" + e.getMessage () ) ); //$NON-NLS-1$
            return false;
        }
        catch ( final Exception e )
        {
            logger.info ( "Failed to parse", e );
        }
        this.filterChangedListener.onFilterParseError ( new Pair<SearchType, String> ( SearchType.FREEFORM, null ) );
        return true;
    }
}
