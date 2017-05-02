/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.localization.timezone;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.scada.ui.localization.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class TimeZonePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{
    public TimeZonePreferencePage ()
    {
        super ( GRID );
        setPreferenceStore ( Activator.getDefault ().getPreferenceStore () );
    }

    @Override
    protected void createFieldEditors ()
    {
        final List<String> tzs = Arrays.asList ( TimeZone.getAvailableIDs () );
        Collections.sort ( tzs );
        final String[][] entries = new String[tzs.size ()][2];
        int i = 0;
        for ( final String id : tzs )
        {
            entries[i][0] = id;
            entries[i][1] = id;
            i += 1;
        }
        final FieldEditor field = new ComboFieldEditor ( "timeZone", Messages.TimeZonePreferencePage_TimeZone_Label, entries, getFieldEditorParent () ); //$NON-NLS-1$
        addField ( field );
    }

    public void init ( final IWorkbench workbench )
    {
        setPreferenceStore ( Activator.getDefault ().getPreferenceStore () );
        setDescription ( Messages.TimeZonePreferencePage_TimeZone_Description );
    }
}
