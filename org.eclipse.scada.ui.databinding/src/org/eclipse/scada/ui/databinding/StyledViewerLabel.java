/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.databinding;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;

public class StyledViewerLabel extends ViewerLabel
{

    private StyledString styledText;

    public StyledViewerLabel ( final String initialText, final Image initialImage )
    {
        super ( initialText, initialImage );
    }

    public void setStyledText ( final StyledString styledString )
    {
        this.styledText = styledString;
    }

    public StyledString getStyledText ()
    {
        if ( this.styledText != null )
        {
            return this.styledText;
        }
        final String text = getText ();
        if ( text != null )
        {
            return new StyledString ( text );
        }
        return null;
    }

}
