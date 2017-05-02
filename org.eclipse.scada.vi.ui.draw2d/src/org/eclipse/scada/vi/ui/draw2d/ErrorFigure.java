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
package org.eclipse.scada.vi.ui.draw2d;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.draw2d.Label;

public class ErrorFigure extends Label
{

    public ErrorFigure ()
    {
        setOpaque ( true );
    }

    public void setException ( final Throwable e )
    {
        setText ( String.format ( "%s", e ) );
        setToolTip ( new Label ( formatException ( e ) ) );
    }

    private static String formatException ( final Throwable e )
    {
        final StringWriter sw = new StringWriter ();
        final PrintWriter pw = new PrintWriter ( sw );

        e.printStackTrace ( pw );
        pw.close ();
        return sw.toString ();
    }

}
