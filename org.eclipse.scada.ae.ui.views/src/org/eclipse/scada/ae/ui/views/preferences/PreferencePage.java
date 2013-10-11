/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.scada.ae.ui.views.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{

    private BooleanFieldEditor bellActivatedEditor;

    private IntegerFieldEditor numOfEventsEditor;

    private IntegerFieldEditor cutListAllSecondsEditor;

    public PreferencePage ()
    {
        super ( GRID );
        setPreferenceStore ( Activator.getDefault ().getPreferenceStore () );
        setDescription ( Messages.PreferencePage_title );
    }

    /**
     * Creates the field editors. Field editors are abstractions of
     * the common GUI blocks needed to manipulate various types
     * of preferences. Each field editor knows how to save and
     * restore itself.
     */
    @Override
    public void createFieldEditors ()
    {
        this.bellActivatedEditor = new BooleanFieldEditor ( PreferenceConstants.BELL_ACTIVATED_KEY, Messages.PreferencePage_activateBell, getFieldEditorParent () );
        this.numOfEventsEditor = new IntegerFieldEditor ( PreferenceConstants.NUMBER_OF_EVENTS_KEY, Messages.PreferencePage_numberOfEvents, getFieldEditorParent () );
        this.cutListAllSecondsEditor = new IntegerFieldEditor ( PreferenceConstants.CUT_LIST_ALL_SECONDS_KEY, Messages.PreferencePage_cutListEveryXSeconds, getFieldEditorParent () );
        addField ( this.bellActivatedEditor );
        addField ( this.numOfEventsEditor );
        addField ( this.cutListAllSecondsEditor );
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
    }
}