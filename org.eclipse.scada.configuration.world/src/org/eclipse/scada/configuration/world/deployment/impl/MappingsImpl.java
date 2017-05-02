/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.deployment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.FallbackMappingMode;
import org.eclipse.scada.configuration.world.deployment.MappingEntry;
import org.eclipse.scada.configuration.world.deployment.Mappings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mappings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MappingsImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MappingsImpl#getFallbackMode <em>Fallback Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingsImpl extends MinimalEObjectImpl.Container implements Mappings
{
    /**
     * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntries()
     * @generated
     * @ordered
     */
    protected EList<MappingEntry> entries;

    /**
     * The default value of the '{@link #getFallbackMode() <em>Fallback Mode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFallbackMode()
     * @generated
     * @ordered
     */
    protected static final FallbackMappingMode FALLBACK_MODE_EDEFAULT = FallbackMappingMode.FAIL;

    /**
     * The cached value of the '{@link #getFallbackMode() <em>Fallback Mode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFallbackMode()
     * @generated
     * @ordered
     */
    protected FallbackMappingMode fallbackMode = FALLBACK_MODE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MappingsImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return DeploymentPackage.Literals.MAPPINGS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MappingEntry> getEntries ()
    {
        if ( entries == null )
        {
            entries = new EObjectContainmentEList.Resolving<MappingEntry> ( MappingEntry.class, this, DeploymentPackage.MAPPINGS__ENTRIES );
        }
        return entries;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FallbackMappingMode getFallbackMode ()
    {
        return fallbackMode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFallbackMode ( FallbackMappingMode newFallbackMode )
    {
        FallbackMappingMode oldFallbackMode = fallbackMode;
        fallbackMode = newFallbackMode == null ? FALLBACK_MODE_EDEFAULT : newFallbackMode;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MAPPINGS__FALLBACK_MODE, oldFallbackMode, fallbackMode ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case DeploymentPackage.MAPPINGS__ENTRIES:
                return ( (InternalEList<?>)getEntries () ).basicRemove ( otherEnd, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case DeploymentPackage.MAPPINGS__ENTRIES:
                return getEntries ();
            case DeploymentPackage.MAPPINGS__FALLBACK_MODE:
                return getFallbackMode ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case DeploymentPackage.MAPPINGS__ENTRIES:
                getEntries ().clear ();
                getEntries ().addAll ( (Collection<? extends MappingEntry>)newValue );
                return;
            case DeploymentPackage.MAPPINGS__FALLBACK_MODE:
                setFallbackMode ( (FallbackMappingMode)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case DeploymentPackage.MAPPINGS__ENTRIES:
                getEntries ().clear ();
                return;
            case DeploymentPackage.MAPPINGS__FALLBACK_MODE:
                setFallbackMode ( FALLBACK_MODE_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case DeploymentPackage.MAPPINGS__ENTRIES:
                return entries != null && !entries.isEmpty ();
            case DeploymentPackage.MAPPINGS__FALLBACK_MODE:
                return fallbackMode != FALLBACK_MODE_EDEFAULT;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (fallbackMode: " ); //$NON-NLS-1$
        result.append ( fallbackMode );
        result.append ( ')' );
        return result.toString ();
    }

} //MappingsImpl
