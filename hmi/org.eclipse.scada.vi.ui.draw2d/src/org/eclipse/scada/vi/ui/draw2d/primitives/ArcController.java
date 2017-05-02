/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import org.eclipse.draw2d.Shape;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.model.Arc;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;

public class ArcController extends ShapeController
{
    private final ArcShape figure;

    public ArcController ( final SymbolController controller, final Arc element, final ResourceManager manager )
    {
        super ( controller, manager );

        this.figure = new ArcShape () {
            @Override
            public void addNotify ()
            {
                super.addNotify ();
                start ();
            }

            @Override
            public void removeNotify ()
            {
                stop ();
                super.removeNotify ();
            }
        };

        this.figure.setArc ( element.getStart (), element.getLength () );

        controller.addElement ( element, this );

        applyCommon ( element );
    }

    @Override
    public void setAntialias ( final Boolean value )
    {
        setAntialias ( value, true );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, true );
    }

    @Override
    protected Shape getPropertyFigure ()
    {
        return this.figure;
    }
}
