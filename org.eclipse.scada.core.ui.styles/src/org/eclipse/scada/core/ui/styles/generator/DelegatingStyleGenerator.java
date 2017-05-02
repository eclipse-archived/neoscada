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
package org.eclipse.scada.core.ui.styles.generator;

import org.eclipse.scada.core.ui.styles.StateInformation;
import org.eclipse.scada.core.ui.styles.StyleGenerator;
import org.eclipse.scada.core.ui.styles.StyleHandler.Style;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A style generator which forwards requests to another style generator.
 * <p>
 * Also will it listen to {@link GeneratorListener} events and fire them as
 * events.
 * </p>
 * <p>
 * Note that calling dispose on this instance will NOT dispose the currently
 * referenced style generator.
 * </p>
 * 
 * @author Jens Reimann
 */
public class DelegatingStyleGenerator extends AbstractStyleGenerator
{

    private final static Logger logger = LoggerFactory.getLogger ( DelegatingStyleGenerator.class );

    private StyleGenerator generator;

    private final GeneratorListener listener = new GeneratorListener () {

        @Override
        public void configurationChanged ()
        {
            handleConfigurationChanged ();
        }
    };

    protected void setStyleGenerator ( final StyleGenerator generator )
    {
        logger.debug ( "Set style generator to {}", generator ); //$NON-NLS-1$

        if ( this.generator != null )
        {
            this.generator.removeListener ( this.listener );
            this.generator = null;
        }

        this.generator = generator;

        if ( this.generator != null )
        {
            this.generator.addListener ( this.listener );
        }

        // the generator itself has changed, fire change
        fireConfigurationChanged ();
    }

    protected void handleConfigurationChanged ()
    {
        // forward change event
        fireConfigurationChanged ();
    }

    @Override
    public Style generateStyle ( final StateInformation state )
    {
        if ( this.generator == null )
        {
            return null;
        }
        else
        {
            return this.generator.generateStyle ( state );
        }
    }

    @Override
    public void dispose ()
    {
    }
}
