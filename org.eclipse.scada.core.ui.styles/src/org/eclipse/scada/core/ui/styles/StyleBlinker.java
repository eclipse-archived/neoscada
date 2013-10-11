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
package org.eclipse.scada.core.ui.styles;

import org.eclipse.scada.ui.blink.AbstractBlinker;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public abstract class StyleBlinker extends AbstractBlinker implements StyleHandler
{

    public static class CurrentStyle
    {
        public static final CurrentStyle EMPTY = new CurrentStyle ();

        private CurrentStyle ()
        {
            this.image = null;
            this.foreground = null;
            this.background = null;
            this.font = null;
        }

        public CurrentStyle ( final Image image, final Color foreground, final Color background, final Font font )
        {
            this.image = image;
            this.foreground = foreground;
            this.background = background;
            this.font = font;
        }

        public final Image image;

        public final Color foreground;

        public final Color background;

        public final Font font;
    }

    private int counter;

    private Style style;

    @Override
    public void setStyle ( final Style style )
    {
        final Display display = Display.getDefault ();
        if ( display.isDisposed () )
        {
            return;
        }

        Display.getDefault ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                if ( display.isDisposed () )
                {
                    return;
                }
                performSetStyle ( style );
            }
        } );
    }

    private void performSetStyle ( final Style style )
    {
        this.style = style;
        applyState ();

        if ( needBlink ( style ) )
        {
            enableBlinking ( true );
        }
        else
        {
            enableBlinking ( false );
        }
    }

    protected boolean needBlink ( final Style style )
    {
        if ( style == null )
        {
            return false;
        }

        if ( style.backgroundColor != null && style.backgroundColor.length > 1 )
        {
            return true;
        }

        if ( style.images != null && style.images.length > 1 )
        {
            return true;
        }

        if ( style.foregroundColor != null && style.foregroundColor.length > 1 )
        {
            return true;
        }

        if ( style.font != null && style.font.length > 1 )
        {
            return true;
        }

        return false;
    }

    @Override
    public void toggle ( final int globalCounter )
    {
        this.counter = globalCounter;
        applyState ();
    }

    private void applyState ()
    {
        if ( this.style == null )
        {
            update ( CurrentStyle.EMPTY );
            return;
        }

        Image image;
        if ( this.style.images == null || this.style.images.length == 0 )
        {
            image = null;
        }
        else
        {
            image = this.style.images[this.counter % this.style.images.length];
        }

        Color foreground;
        if ( this.style.foregroundColor == null || this.style.foregroundColor.length == 0 )
        {
            foreground = null;
        }
        else
        {
            foreground = this.style.foregroundColor[this.counter % this.style.foregroundColor.length];
        }

        Color background;
        if ( this.style.backgroundColor == null || this.style.backgroundColor.length == 0 )
        {
            background = null;
        }
        else
        {
            background = this.style.backgroundColor[this.counter % this.style.backgroundColor.length];
        }

        Font font;
        if ( this.style.font == null || this.style.font.length == 0 )
        {
            font = null;
        }
        else
        {
            font = this.style.font[this.counter % this.style.font.length];
        }

        update ( new CurrentStyle ( image, foreground, background, font ) );
    }

    public abstract void update ( CurrentStyle currentStyle );

}
