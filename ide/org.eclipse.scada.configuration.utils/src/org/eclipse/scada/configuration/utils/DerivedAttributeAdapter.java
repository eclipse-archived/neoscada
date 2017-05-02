/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class DerivedAttributeAdapter extends AdapterImpl
{
    private final InternalEObject source;

    private final EStructuralFeature derivedFeature;

    private final List<EStructuralFeature> localFeatures = new ArrayList<EStructuralFeature> ();

    private final Set<EStructuralFeature> dependantFeatures = new HashSet<> ();

    private EStructuralFeature navigationFeature;

    private final AdapterImpl dependantAdapter = new AdapterImpl () {

        @Override
        public void notifyChanged ( final Notification msg )
        {
            if ( msg.getEventType () != Notification.SET )
            {
                return;
            }
            if ( DerivedAttributeAdapter.this.dependantFeatures.contains ( msg.getFeature () ) )
            {
                notifyDerivedAttributeChange ();
            }
        }
    };

    /*
     * Convenience constructor for a local and navigated dependency
     */
    public DerivedAttributeAdapter ( final EObject source, final EStructuralFeature derivedFeature, final EStructuralFeature navigationFeature, final EStructuralFeature dependantFeature, final EStructuralFeature localFeature )
    {
        this ( source, derivedFeature );
        addNavigatedDependency ( navigationFeature, dependantFeature );
        addLocalDependency ( localFeature );
    }

    /*
     * Convenience constructor for a navigated dependency
     */
    public DerivedAttributeAdapter ( final EObject source, final EStructuralFeature derivedFeature, final EStructuralFeature navigationFeature, final EStructuralFeature dependantFeature )
    {
        this ( source, derivedFeature );
        addNavigatedDependency ( navigationFeature, dependantFeature );
    }

    /*
     * Convenience constructor for a local dependency
     */
    public DerivedAttributeAdapter ( final EObject source, final EStructuralFeature derivedFeature, final EStructuralFeature localFeature )
    {
        this ( source, derivedFeature );
        addLocalDependency ( localFeature );
    }

    public DerivedAttributeAdapter ( final EObject source, final EStructuralFeature derivedFeature )
    {
        super ();
        this.source = (InternalEObject)source;
        this.derivedFeature = derivedFeature;
        source.eAdapters ().add ( this );
    }

    public void addNavigatedDependency ( final EStructuralFeature navigationFeature, final EStructuralFeature... dependantFeatures )
    {
        this.dependantFeatures.addAll ( Arrays.asList ( dependantFeatures ) );
        this.navigationFeature = navigationFeature;
    }

    public void addLocalDependency ( final EStructuralFeature localFeature )
    {
        this.localFeatures.add ( localFeature );
    }

    @Override
    public void notifyChanged ( final Notification notification )
    {
        if ( notification.getFeature () == null )
        {
            return;
        }

        if ( notification.getFeature ().equals ( this.navigationFeature ) )
        {
            switch ( notification.getEventType () )
            {
            // TODO support ADD_MANY/REMOVE_MANY?
                case Notification.ADD:
                    final EObject added = (EObject)notification.getNewValue ();
                    added.eAdapters ().add ( this.dependantAdapter );
                    break;
                case Notification.SET:
                    final EObject newValue = (EObject)notification.getNewValue ();
                    final EObject oldValue = (EObject)notification.getOldValue ();
                    if ( oldValue != null )
                    {
                        oldValue.eAdapters ().remove ( this.dependantAdapter );
                    }
                    if ( newValue != null )
                    {
                        newValue.eAdapters ().add ( this.dependantAdapter );
                    }
                    break;
                case Notification.REMOVE:
                    final EObject removed = (EObject)notification.getOldValue ();
                    removed.eAdapters ().remove ( this.dependantAdapter );
                    break;
                default:
                    return; // No notification
            }
            notifyDerivedAttributeChange ();
        }
        else if ( this.localFeatures.contains ( notification.getFeature () ) )
        {
            notifyDerivedAttributeChange ();
        }
    }

    private void notifyDerivedAttributeChange ()
    {
        if ( this.source.eNotificationRequired () )
        {
            this.source.eNotify ( new ENotificationImpl ( this.source, Notification.SET, this.derivedFeature, null, this.source.eGet ( this.derivedFeature, true, true ) ) );
        }
    }
}