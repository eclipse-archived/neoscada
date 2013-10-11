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

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.vi.model.Alignment;
import org.eclipse.scada.vi.model.Orientation;
import org.eclipse.scada.vi.model.Text;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class TextController extends FigureController
{
    private final Label figure;

    private final FigureCanvas canvas;

    public TextController ( final FigureCanvas canvas, final SymbolController controller, final Text element, final ResourceManager manager )
    {
        super ( controller, manager );
        this.canvas = canvas;
        this.figure = new Label ( element.getText () ) {
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
        controller.addElement ( element, this );

        applyCommon ( element );
    }

    @Override
    public void setOpaque ( final Boolean flag )
    {
        setOpaque ( flag, false );
    }

    protected void applyCommon ( final Text element )
    {
        super.applyCommon ( element );
        this.figure.setTextAlignment ( convertAlignment ( element.getTextAlignment (), PositionConstants.CENTER ) );
        this.figure.setLabelAlignment ( convertAlignment ( element.getLabelAlignment (), PositionConstants.CENTER ) );
        this.figure.setIconAlignment ( convertAlignment ( element.getIconAlignment (), PositionConstants.CENTER ) );
        this.figure.setTextPlacement ( convertOrientation ( element.getTextPlacement (), PositionConstants.EAST ) );

        setFontFull ( element.getFontName (), element.getFontSize (), element.isFontBold (), element.isFontItalic () );
    }

    public void setFontBold ( final boolean bold )
    {
        setFontFull ( null, null, bold, null );
    }

    public void setFontItalic ( final boolean italic )
    {
        setFontFull ( null, null, null, italic );
    }

    public void setFont ( final String fontName, final Integer fontSize )
    {
        setFontFull ( fontName, fontSize, false, false );
    }

    public void setFontFull ( final String fontName, final Integer fontSize, final Boolean bold, final Boolean italic )
    {
        this.figure.setFont ( convertFont ( fontName, fontSize, bold, italic ) );
    }

    private Font convertFont ( final String fontName, final Integer fontSize, final Boolean bold, final Boolean italic )
    {
        if ( fontName == null && fontSize == null && bold == null && italic == null )
        {
            return null;
        }

        FontData[] fontData;
        Font font = this.figure.getFont ();

        if ( font == null )
        {
            font = this.canvas.getFont ();
        }
        if ( font == null )
        {
            font = Display.getDefault ().getSystemFont ();
        }
        fontData = FontDescriptor.copy ( font.getFontData () );

        if ( fontName != null )
        {
            if ( fontSize != null && fontSize > 0 )
            {
                fontData = FontDescriptor.createFrom ( fontName, fontSize, SWT.NORMAL ).getFontData ();
            }
            else
            {
                // we need to get the original font size and change the font only
                int origFontSize = 0;
                for ( final FontData fd : fontData )
                {
                    origFontSize = fd.getHeight ();
                }
                fontData = FontDescriptor.createFrom ( fontName, origFontSize, SWT.NORMAL ).getFontData ();
            }
        }

        for ( final FontData fd : fontData )
        {
            if ( fontName != null )
            {
                fd.setName ( fontName );
            }
            if ( fontSize != null && fontSize > 0 )
            {
                fd.setHeight ( fontSize );
            }

            int style = fd.getStyle ();

            if ( bold != null )
            {
                if ( bold )
                {
                    style = style | SWT.BOLD;
                }
                else
                {
                    style = style & ~SWT.BOLD;
                }
            }
            if ( italic != null )
            {
                if ( italic )
                {
                    style = style | SWT.ITALIC;
                }
                else
                {
                    style = style & ~SWT.ITALIC;
                }
            }

            fd.setStyle ( style );
        }
        return this.manager.createFont ( FontDescriptor.createFrom ( fontData ) );

    }

    private int convertOrientation ( final Orientation orientation, final int defaultValue )
    {
        if ( orientation == null )
        {
            return defaultValue;
        }
        else
        {
            return convertPosition ( orientation.getName (), defaultValue );
        }
    }

    private int convertAlignment ( final Alignment alignment, final int defaultValue )
    {
        if ( alignment == null )
        {
            return defaultValue;
        }
        else
        {
            return convertPosition ( alignment.getName (), defaultValue );
        }
    }

    protected int convertPosition ( final String position, final int defaultValue )
    {
        if ( "CENTER".equals ( position ) )
        {
            return PositionConstants.CENTER;
        }
        else if ( "LEFT".equals ( position ) )
        {
            return PositionConstants.LEFT;
        }
        else if ( "RIGHT".equals ( position ) )
        {
            return PositionConstants.RIGHT;
        }
        else if ( "TOP".equals ( position ) )
        {
            return PositionConstants.TOP;
        }
        else if ( "BOTTOM".equals ( position ) )
        {
            return PositionConstants.BOTTOM;
        }
        else if ( "EAST".equals ( position ) )
        {
            return PositionConstants.EAST;
        }
        else if ( "WEST".equals ( position ) )
        {
            return PositionConstants.WEST;
        }
        else if ( "NORTH".equals ( position ) )
        {
            return PositionConstants.NORTH;
        }
        else if ( "SOUTH".equals ( position ) )
        {
            return PositionConstants.SOUTH;
        }

        return defaultValue;
    }

    @Override
    public IFigure getPropertyFigure ()
    {
        return this.figure;
    }

    public void setText ( final String text )
    {
        this.figure.setText ( text );
    }
}
