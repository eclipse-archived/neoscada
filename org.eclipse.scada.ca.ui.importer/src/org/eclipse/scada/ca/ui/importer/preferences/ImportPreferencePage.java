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
package org.eclipse.scada.ca.ui.importer.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IntegerFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.scada.ca.ui.importer.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that is contributed to the Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we can use the field support built into JFace that
 * allows us to create a page that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the preference store that belongs to the main plug-in class. That way, preferences can be accessed directly via the preference
 * store.
 */

public class ImportPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{

    public ImportPreferencePage ()
    {
        super ( GRID );
        setPreferenceStore ( Activator.getDefault ().getPreferenceStore () );
        setDescription ( "Preferences for CA import operations" );
    }

    /**
     * Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various types of preferences. Each field editor knows how to save and restore itself.
     */
    @Override
    public void createFieldEditors ()
    {
        final IntegerFieldEditor fieldEditor = new IntegerFieldEditor ( PreferenceConstants.P_DEFAULT_CHUNK_SIZE, "&Default chunk size:", getFieldEditorParent () );
        fieldEditor.setEmptyStringAllowed ( false );
        fieldEditor.setValidRange ( 1, Integer.MAX_VALUE );
        fieldEditor.setValidateStrategy ( StringFieldEditor.VALIDATE_ON_KEY_STROKE );

        addField ( fieldEditor );
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    @Override
    public void init ( final IWorkbench workbench )
    {
    }

}