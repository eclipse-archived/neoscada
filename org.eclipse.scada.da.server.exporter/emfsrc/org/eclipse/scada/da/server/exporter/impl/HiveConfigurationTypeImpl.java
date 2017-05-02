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
package org.eclipse.scada.da.server.exporter.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.da.server.exporter.ExporterPackage;
import org.eclipse.scada.da.server.exporter.HiveConfigurationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hive Configuration Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.exporter.impl.HiveConfigurationTypeImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.exporter.impl.HiveConfigurationTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HiveConfigurationTypeImpl extends MinimalEObjectImpl.Container implements HiveConfigurationType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMixed()
     * @generated
     * @ordered
     */
    protected FeatureMap mixed;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HiveConfigurationTypeImpl ()
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
        return ExporterPackage.Literals.HIVE_CONFIGURATION_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getMixed ()
    {
        if ( mixed == null )
        {
            mixed = new BasicFeatureMap ( this, ExporterPackage.HIVE_CONFIGURATION_TYPE__MIXED );
        }
        return mixed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getAny ()
    {
        return (FeatureMap)getMixed ().<FeatureMap.Entry> list ( ExporterPackage.Literals.HIVE_CONFIGURATION_TYPE__ANY );
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
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__MIXED:
                return ( (InternalEList<?>)getMixed () ).basicRemove ( otherEnd, msgs );
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__ANY:
                return ( (InternalEList<?>)getAny () ).basicRemove ( otherEnd, msgs );
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
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__MIXED:
                if ( coreType )
                    return getMixed ();
                return ( (FeatureMap.Internal)getMixed () ).getWrapper ();
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__ANY:
                if ( coreType )
                    return getAny ();
                return ( (FeatureMap.Internal)getAny () ).getWrapper ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__MIXED:
                ( (FeatureMap.Internal)getMixed () ).set ( newValue );
                return;
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__ANY:
                ( (FeatureMap.Internal)getAny () ).set ( newValue );
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
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__MIXED:
                getMixed ().clear ();
                return;
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__ANY:
                getAny ().clear ();
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
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__MIXED:
                return mixed != null && !mixed.isEmpty ();
            case ExporterPackage.HIVE_CONFIGURATION_TYPE__ANY:
                return !getAny ().isEmpty ();
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
        result.append ( " (mixed: " ); //$NON-NLS-1$
        result.append ( mixed );
        result.append ( ')' );
        return result.toString ();
    }

} //HiveConfigurationTypeImpl
