/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.styles;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;

public interface StyleHandler
{
    public static class RGBInformation
    {
        private final RGB rgb;

        public RGBInformation ( final RGB rgb )
        {
            this.rgb = rgb;
        }

        public String toHex ()
        {
            return String.format ( "#%02x%02x%02x", rgb.red, rgb.green, rgb.blue ); //$NON-NLS-1$
        }

        @Override
        public String toString ()
        {
            return toHex ();
        }
    }

    public static class Style
    {
        public Image[] images;

        public Color[] foregroundColor;

        public Color[] backgroundColor;

        public Font[] font;

        public Style ()
        {
        }

        public Style ( final Image[] images, final Color[] foregroundColor, final Color[] backgroundColor, final Font[] font )
        {
            this.images = images;
            this.foregroundColor = foregroundColor;
            this.backgroundColor = backgroundColor;
            this.font = font;
        }

        public Color[] getBackgroundColor ()
        {
            return this.backgroundColor;
        }

        public List<RGBInformation> getBackgroundColorAsList ()
        {
            return convertColors ( this.backgroundColor );
        }

        public List<RGBInformation> getForegroundColorAsList ()
        {
            return convertColors ( this.foregroundColor );
        }

        private static List<RGBInformation> convertColors ( final Color[] colors )
        {
            final List<RGBInformation> result = new ArrayList<StyleHandler.RGBInformation> ( colors.length );
            for ( final Color color : colors )
            {
                if ( color != null )
                {
                    result.add ( new RGBInformation ( color.getRGB () ) );
                }
                else
                {
                    result.add ( null );
                }
            }
            return result;
        }
    }

    public void setStyle ( Style style );
}
