/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ecore.ui;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.DiagnosticDecorator;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.emf.edit.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertySheetEntry;

public class ExtendedSortedPropertySheetPage extends ExtendedPropertySheetPage
{
    public ExtendedSortedPropertySheetPage ( final AdapterFactoryEditingDomain editingDomain, final Decoration decoration, final IDialogSettings dialogSettings )
    {
        super ( editingDomain, decoration, dialogSettings );
        setSorter ();
    }

    public ExtendedSortedPropertySheetPage ( final AdapterFactoryEditingDomain editingDomain, final Decoration decoration )
    {
        super ( editingDomain, decoration );
        setSorter ();
    }

    public ExtendedSortedPropertySheetPage ( final AdapterFactoryEditingDomain editingDomain )
    {
        super ( editingDomain );
        setSorter ();
    }

    private void setSorter ()
    {
        setSorter ( new ExtendedPropertiesSheetSorter () );
    }

    @Override
    public void createControl ( final Composite parent )
    {
        super.createControl ( parent );
        if ( this.diagnosticDecorator != null )
        {
            class DecoratingPropertySheetEntry extends PropertySheetEntry implements ISortedPropertyDescriptor
            {
                @Override
                protected PropertySheetEntry createChildEntry ()
                {
                    return new DecoratingPropertySheetEntry ();
                }

                @Override
                public int getSortKey ()
                {
                    if ( getDescriptor () instanceof ISortedPropertyDescriptor )
                    {
                        return ( (ISortedPropertyDescriptor)getDescriptor () ).getSortKey ();
                    }
                    else
                    {
                        return 0;
                    }
                }

                @Override
                public Image getImage ()
                {
                    Image image = super.getImage ();
                    if ( image == null )
                    {
                        image = ExtendedImageRegistry.INSTANCE.getImage ( ItemPropertyDescriptor.GENERIC_VALUE_IMAGE );
                    }
                    final Diagnostic featureDiagnostic = findDiagnostic ();
                    return featureDiagnostic != null ? ExtendedSortedPropertySheetPage.this.diagnosticDecorator.decorate ( image, featureDiagnostic ) : image;
                }

                protected Diagnostic findDiagnostic ()
                {
                    final IPropertyDescriptor descriptor = getDescriptor ();
                    if ( descriptor instanceof PropertyDescriptor )
                    {
                        final Object feature = ( (PropertyDescriptor)descriptor ).getFeature ();
                        final Map<Object, ? extends Diagnostic> decorations = ExtendedSortedPropertySheetPage.this.diagnosticDecorator.getDecorations ();
                        if ( !decorations.isEmpty () && feature != null )
                        {
                            for ( final Diagnostic diagnostic : decorations.values () )
                            {
                                final Diagnostic featureDiagnostic = find ( diagnostic, feature );
                                if ( featureDiagnostic != null )
                                {
                                    return featureDiagnostic;
                                }
                            }
                        }
                    }
                    return null;
                }

                protected Diagnostic find ( final Diagnostic diagnostic, final Object feature )
                {
                    // Gather them all...
                    //
                    if ( diagnostic.getData ().contains ( feature ) )
                    {
                        return diagnostic;
                    }
                    for ( final Diagnostic child : diagnostic.getChildren () )
                    {
                        final Diagnostic result = find ( child, feature );
                        if ( result != null )
                        {
                            return result;
                        }
                    }
                    return null;
                }

                @Override
                public String getDescription ()
                {
                    final String description = super.getDescription ();
                    final Diagnostic featureDiagnostic = findDiagnostic ();
                    if ( featureDiagnostic != null )
                    {
                        return description + " - " + DiagnosticDecorator.strip ( featureDiagnostic.getMessage () );
                    }
                    else
                    {
                        return description;
                    }
                }
            }

            final DecoratingPropertySheetEntry decoratingPropertySheetEntry = new DecoratingPropertySheetEntry ();
            decoratingPropertySheetEntry.setPropertySourceProvider ( this.propertySourceProvider );
            setRootEntry ( decoratingPropertySheetEntry );
        }
    }
}
