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

import org.eclipse.scada.core.ui.styles.StyleGenerator.GeneratorListener;

/**
 * The state styler combines all parts of the state to visual style
 * transformation
 * <p>
 * Instead of choosing a {@link StyleGenerator} and forwarding the resulting
 * styles to a {@link StyleHandler} everything is done in one place.
 * </p>
 * 
 * @author Jens Reimann
 */
public class StateStyler
{
    private final StyleGenerator generator;

    private StateInformation currentState;

    private final StyleHandler handler;

    private final GeneratorListener listener = new GeneratorListener () {

        @Override
        public void configurationChanged ()
        {
            refresh ();
        }
    };

    public StateStyler ( final StyleHandler handler )
    {
        this.generator = Activator.getDefaultStyleGenerator ();
        this.handler = handler;

        this.generator.addListener ( this.listener );
    }

    protected void refresh ()
    {
        this.handler.setStyle ( this.generator.generateStyle ( this.currentState ) );
    }

    public void style ( final StateInformation state )
    {
        this.currentState = state;
        this.handler.setStyle ( this.generator.generateStyle ( state ) );
    }

    public void dispose ()
    {
        this.generator.removeListener ( this.listener );
        this.generator.dispose ();
    }
}
