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
package org.eclipse.scada.core.ui.styles.preferences;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.scada.core.ui.styles.Activator;
import org.eclipse.scada.core.ui.styles.StyleGeneratorInformation;
import org.eclipse.scada.core.ui.styles.preferences.ComboFieldEditor2.Callback;

public class StylePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{

    private Text descriptionArea;

    private HashMap<String, String> descriptionMap;

    public StylePreferencePage ()
    {
        super ( GRID );
        setPreferenceStore ( Activator.getDefault ().getPreferenceStore () );
        setDescription ( Messages.StylePreferencePage_Description );
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
        final String[][] entryNamesAndValues = makeNamesAndValues ();
        final ComboFieldEditor2 generatorEditor = new ComboFieldEditor2 ( PreferenceConstants.PREF_STYLE_GENERATOR_ID, Messages.StylePreferencePage_Label, entryNamesAndValues, getFieldEditorParent () );

        generatorEditor.setCallback ( new Callback () {
            @Override
            public void valueChange ( final Object value )
            {
                if ( value instanceof String )
                {
                    setGeneratorDescription ( (String)value );
                }
            }
        } );

        addField ( generatorEditor );
    }

    @Override
    public void createControl ( final Composite parent )
    {
        super.createControl ( parent );
        refresh ();
    }

    @Override
    protected void performDefaults ()
    {
        super.performDefaults ();
        refresh ();
    }

    private void refresh ()
    {
        setGeneratorDescription ( getPreferenceStore ().getString ( PreferenceConstants.PREF_STYLE_GENERATOR_ID ) );
    }

    private void setGeneratorDescription ( final String generatorId )
    {
        final String description = this.descriptionMap.get ( generatorId );
        if ( description != null )
        {
            this.descriptionArea.setText ( description );
        }
        else
        {
            this.descriptionArea.setText ( "" ); //$NON-NLS-1$
        }
    }

    @Override
    protected Control createContents ( final Composite parent )
    {
        final Composite wrapper = new Composite ( parent, SWT.NONE );

        wrapper.setLayout ( new GridLayout ( 1, false ) );

        final Control control = super.createContents ( wrapper );
        control.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );

        createDescription ( wrapper );

        return wrapper;
    }

    private void createDescription ( final Composite parent )
    {
        final Label label = new Label ( parent, SWT.NONE );
        label.setText ( Messages.StylePreferencePage_Description_Label );
        this.descriptionArea = new Text ( parent, SWT.MULTI | SWT.READ_ONLY | SWT.BORDER | SWT.WRAP );
        final GridData gd = new GridData ( SWT.FILL, SWT.FILL, true, true );
        gd.widthHint = 300; // a bit hacky
        this.descriptionArea.setLayoutData ( gd );
    }

    private String[][] makeNamesAndValues ()
    {
        this.descriptionMap = new HashMap<String, String> ();
        final List<String[]> names = new LinkedList<String[]> ();

        for ( final StyleGeneratorInformation info : StyleGeneratorInformation.list () )
        {
            names.add ( new String[] { info.getName (), info.getId () } );
            this.descriptionMap.put ( info.getId (), info.getDescription () );
        }

        return names.toArray ( new String[names.size ()][] );
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    @Override
    public void init ( final IWorkbench workbench )
    {
    }

}