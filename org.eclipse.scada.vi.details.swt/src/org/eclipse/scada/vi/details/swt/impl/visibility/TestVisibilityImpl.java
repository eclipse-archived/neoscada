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
package org.eclipse.scada.vi.details.swt.impl.visibility;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;

public class TestVisibilityImpl extends AbstractVisibilityProvider
{
    private final Button button;

    public TestVisibilityImpl ( final String id )
    {
        this.button = VisibilityTester.INSTANCE.createTester ( id );
        this.button.setSelection ( true );
        this.button.addSelectionListener ( new SelectionListener () {

            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                fireChange ( TestVisibilityImpl.this.button.getSelection () );
            }

            @Override
            public void widgetDefaultSelected ( final SelectionEvent e )
            {
            }
        } );
        fireChange ( this.button.getSelection () );
    }

    @Override
    public void dispose ()
    {
        VisibilityTester.INSTANCE.removeTester ( this.button );
    }

}
