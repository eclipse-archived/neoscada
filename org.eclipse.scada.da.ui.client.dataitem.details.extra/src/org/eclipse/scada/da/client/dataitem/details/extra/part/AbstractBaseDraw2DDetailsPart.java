/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.extra.part;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.scada.da.client.dataitem.details.VisibilityController;
import org.eclipse.scada.da.client.dataitem.details.part.AbstractBaseDetailsPart;
import org.eclipse.swt.widgets.Composite;

public abstract class AbstractBaseDraw2DDetailsPart extends AbstractBaseDetailsPart
{
    private FigureCanvas canvas;

    private IFigure rootFigure;

    private IFigure naFigure;

    private VisibilityController visibilityController;

    @Override
    public void createPart ( final Composite parent )
    {
        super.createPart ( parent );

        this.canvas = new FigureCanvas ( parent );

        this.canvas.setContents ( createRoot () );
    }

    @Override
    public void dispose ()
    {
        this.canvas.dispose ();
        this.canvas = null;

        super.dispose ();
    }

    protected abstract IFigure createMain ();

    /**
     * Check if the functionality of this tab is available or not
     * 
     * @return <code>true</code> if the functionality can be provided,
     *         <code>false</code> otherwise
     */
    protected abstract boolean isAvailable ();

    protected IFigure createRoot ()
    {
        this.rootFigure = createMain ();
        this.naFigure = createNaPanel ();

        final Figure baseFigure = new LayeredPane ();

        baseFigure.add ( this.rootFigure );
        baseFigure.add ( this.naFigure );

        return baseFigure;
    }

    private IFigure createNaPanel ()
    {
        final Figure naPanel = new Figure ();

        final BorderLayout layout = new BorderLayout ();
        naPanel.setLayoutManager ( layout );

        final Label label = new Label ();
        label.setText ( Messages.AbstractBaseDraw2DDetailsPart_Label_NotAvail_Text );
        naPanel.add ( label, BorderLayout.CENTER );

        return naPanel;
    }

    @Override
    protected void update ()
    {
        if ( isForceActive () || isAvailable () )
        {
            this.visibilityController.show ();

            this.rootFigure.setVisible ( true );
            this.naFigure.setVisible ( false );
        }
        else
        {
            this.rootFigure.setVisible ( false );
            this.naFigure.setVisible ( true );

            this.visibilityController.hide ();
        }
    }

    @Override
    public void setVisibilityController ( final VisibilityController visibilityController )
    {
        this.visibilityController = visibilityController;
    }

}
