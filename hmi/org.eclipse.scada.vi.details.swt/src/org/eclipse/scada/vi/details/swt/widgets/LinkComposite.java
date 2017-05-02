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
package org.eclipse.scada.vi.details.swt.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkComposite extends Composite
{
    private static final Logger logger = LoggerFactory.getLogger ( LinkComposite.class );

    private final Link textLabel;

    public LinkComposite ( final Composite parent, final int style, final String format )
    {
        super ( parent, style );

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 7;
        layout.pack = true;
        setLayout ( layout );

        this.textLabel = new Link ( this, SWT.NONE );
        this.textLabel.setText ( format );

        this.textLabel.addSelectionListener ( new SelectionAdapter () {

            @Override
            public void widgetSelected ( final SelectionEvent event )
            {
                logger.info ( "LinkComponent selected: {}", event.text ); //$NON-NLS-1$
                Program.launch ( event.text );
            }
        } );
    }

}
