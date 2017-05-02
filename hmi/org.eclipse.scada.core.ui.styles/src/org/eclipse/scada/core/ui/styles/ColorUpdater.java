/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.styles;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;

public class ColorUpdater implements IPropertyChangeListener
{

    private final String name;

    private final ResourceManager manager;

    private final ColorDescriptor defaultColor;

    private ColorDescriptor activeColor;

    private Color color;

    public ColorUpdater ( final String name, final ResourceManager manager, final ColorDescriptor defaultColor )
    {
        this.name = name;
        this.manager = manager;
        this.defaultColor = defaultColor;
        JFaceResources.getColorRegistry ().addListener ( this );
        refresh ();
    }

    public void dispose ()
    {
        JFaceResources.getColorRegistry ().removeListener ( this );
    }

    @Override
    public void propertyChange ( final PropertyChangeEvent event )
    {
        if ( this.name != null && this.name.equals ( event.getProperty () ) )
        {
            refresh ();
        }
    }

    private void refresh ()
    {
        if ( this.color != null )
        {
            // we may not dispose, the manager has to do that
            this.color = null;
        }
        if ( this.activeColor != null )
        {
            this.manager.destroyColor ( this.activeColor );
            this.activeColor = null;
        }

        this.activeColor = JFaceResources.getColorRegistry ().getColorDescriptor ( this.name, this.defaultColor );
        if ( this.activeColor != null )
        {
            this.color = this.manager.createColor ( this.activeColor );
        }
    }

    public Color getColor ()
    {
        return this.color;
    }
}
