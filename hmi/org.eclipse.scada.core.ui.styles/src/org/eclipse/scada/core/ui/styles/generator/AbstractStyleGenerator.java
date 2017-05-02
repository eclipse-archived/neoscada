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

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.scada.core.ui.styles.StyleGenerator;

/**
 * An abstract base for StyleGenerator
 * 
 * @author Jens Reimann
 */
public abstract class AbstractStyleGenerator implements StyleGenerator
{

    private final Set<GeneratorListener> listeners = new CopyOnWriteArraySet<StyleGenerator.GeneratorListener> ();

    public AbstractStyleGenerator ()
    {
        super ();
    }

    protected void fireConfigurationChanged ()
    {
        for ( final GeneratorListener listener : this.listeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.configurationChanged ();
                }
            } );
        }
    }

    @Override
    public void addListener ( final GeneratorListener listener )
    {
        this.listeners.add ( listener );
    }

    @Override
    public void removeListener ( final GeneratorListener listener )
    {
        this.listeners.remove ( listener );
    }

}