/*******************************************************************************
 * Copyright (c) 2010, 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.styles.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.scada.core.ui.styles.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer
{

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    @Override
    public void initializeDefaultPreferences ()
    {
        final IPreferenceStore store = Activator.getDefault ().getPreferenceStore ();
        store.setDefault ( PreferenceConstants.PREF_STYLE_GENERATOR_ID, "org.eclipse.scada.core.ui.styles.defaultStyleGenerator" ); //$NON-NLS-1$
    }

}
