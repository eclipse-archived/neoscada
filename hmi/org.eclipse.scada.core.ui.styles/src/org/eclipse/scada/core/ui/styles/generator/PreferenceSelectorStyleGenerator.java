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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.scada.core.ui.styles.Activator;
import org.eclipse.scada.core.ui.styles.StyleGenerator;
import org.eclipse.scada.core.ui.styles.StyleGeneratorInformation;
import org.eclipse.scada.core.ui.styles.preferences.PreferenceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PreferenceSelectorStyleGenerator extends DelegatingStyleGenerator
{
    private final static Logger logger = LoggerFactory.getLogger ( PreferenceSelectorStyleGenerator.class );

    private final IPreferenceStore preferenceStore;

    private StyleGenerator currentGenerator;

    public PreferenceSelectorStyleGenerator ( final IPreferenceStore preferenceStore )
    {
        this.preferenceStore = preferenceStore;
        this.preferenceStore.addPropertyChangeListener ( new IPropertyChangeListener () {

            @Override
            public void propertyChange ( final PropertyChangeEvent event )
            {
                logger.trace ( "Property change - name: {}, newValue: {}", event.getProperty (), event.getNewValue () ); //$NON-NLS-1$
                if ( PreferenceConstants.PREF_STYLE_GENERATOR_ID.equals ( event.getProperty () ) )
                {
                    logger.info ( "Change of style generator: {}", event.getNewValue () ); //$NON-NLS-1$
                    handleChange ( event.getNewValue () );
                }
            }
        } );

        setInitial ();
    }

    protected void setInitial ()
    {
        setById ( this.preferenceStore.getString ( PreferenceConstants.PREF_STYLE_GENERATOR_ID ) );
    }

    protected void setById ( final String generatorId )
    {
        if ( this.currentGenerator != null )
        {
            // we need to clean up what we created
            this.currentGenerator.dispose ();
            this.currentGenerator = null;
        }

        final IConfigurationElement ele = StyleGeneratorInformation.getConfiguration ( generatorId );

        this.currentGenerator = create ( ele );

        setStyleGenerator ( this.currentGenerator );
    }

    protected void handleChange ( final Object newValue )
    {
        if ( newValue instanceof String )
        {
            setById ( (String)newValue );
        }
        else
        {
            setStyleGenerator ( null );
        }
    }

    private StyleGenerator create ( final IConfigurationElement ele )
    {
        if ( ele == null )
        {
            return null;
        }

        try
        {
            final Object o = ele.createExecutableExtension ( Messages.PreferenceSelectorStyleGenerator_2 );
            if ( o instanceof StyleGenerator )
            {
                return (StyleGenerator)o;
            }
            logger.warn ( "Class referenced in 'generatorClass' did not implement {}", StyleGenerator.class ); //$NON-NLS-1$
            return null;
        }
        catch ( final CoreException e )
        {
            StatusManager.getManager ().handle ( e, Activator.PLUGIN_ID );
            return null;
        }
    }
}
