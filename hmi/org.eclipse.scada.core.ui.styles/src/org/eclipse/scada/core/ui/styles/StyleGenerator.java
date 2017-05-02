/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - document
 *******************************************************************************/
package org.eclipse.scada.core.ui.styles;

/**
 * A generator for style information based in state information <br/>
 * The main purpose of a style generator is to create style information
 * based on a current state. The main method for this is
 * {@link #generateStyle(StateInformation)}. <br/>
 * Style generators only provide the information about the styles to use, but do
 * not apply them. You can either do this on your own or use a class like
 * {@link StyleHandler}.
 */
public interface StyleGenerator
{
    public interface GeneratorListener
    {
        public void configurationChanged ();
    }

    public StyleHandler.Style generateStyle ( final StateInformation state );

    public void addListener ( GeneratorListener listener );

    public void removeListener ( GeneratorListener listener );

    public void dispose ();
}
