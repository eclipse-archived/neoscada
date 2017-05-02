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
package org.eclipse.scada.vi.ui.draw2d.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.scada.vi.ui.draw2d.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{

    private BooleanFieldEditor defaultZoomingEditor;

    public PreferencePage ()
    {
        super ( GRID );
        setPreferenceStore ( Activator.getDefault ().getPreferenceStore () );
    }

    /** Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various types of preferences. Each field editor knows how to save and restore itself. */
    @Override
    public void createFieldEditors ()
    {
        this.defaultZoomingEditor = new BooleanFieldEditor ( PreferenceConstants.P_DEFAULT_ZOOMING, Messages.PreferencePage_activateZooming, getFieldEditorParent () );
        addField ( this.defaultZoomingEditor );
    }

    @Override
    protected void performDefaults ()
    {
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    @Override
    public void init ( final IWorkbench workbench )
    {
        setPreferenceStore ( Activator.getDefault ().getPreferenceStore () );
        setDescription ( Messages.PreferencePage_title );
    }
}