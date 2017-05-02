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

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.da.server.exporter.AnnouncerType;
import org.eclipse.scada.da.server.exporter.ConfigurationType;
import org.eclipse.scada.da.server.exporter.ExporterPackage;
import org.eclipse.scada.da.server.exporter.HiveType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.exporter.impl.ConfigurationTypeImpl#getHive <em>Hive</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.exporter.impl.ConfigurationTypeImpl#getAnnouncer <em>Announcer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationTypeImpl extends MinimalEObjectImpl.Container implements ConfigurationType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getHive() <em>Hive</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHive()
     * @generated
     * @ordered
     */
    protected EList<HiveType> hive;

    /**
     * The cached value of the '{@link #getAnnouncer() <em>Announcer</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAnnouncer()
     * @generated
     * @ordered
     */
    protected EList<AnnouncerType> announcer;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConfigurationTypeImpl ()
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
        return ExporterPackage.Literals.CONFIGURATION_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<HiveType> getHive ()
    {
        if ( hive == null )
        {
            hive = new EObjectContainmentEList<HiveType> ( HiveType.class, this, ExporterPackage.CONFIGURATION_TYPE__HIVE );
        }
        return hive;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AnnouncerType> getAnnouncer ()
    {
        if ( announcer == null )
        {
            announcer = new EObjectContainmentEList<AnnouncerType> ( AnnouncerType.class, this, ExporterPackage.CONFIGURATION_TYPE__ANNOUNCER );
        }
        return announcer;
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
            case ExporterPackage.CONFIGURATION_TYPE__HIVE:
                return ( (InternalEList<?>)getHive () ).basicRemove ( otherEnd, msgs );
            case ExporterPackage.CONFIGURATION_TYPE__ANNOUNCER:
                return ( (InternalEList<?>)getAnnouncer () ).basicRemove ( otherEnd, msgs );
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
            case ExporterPackage.CONFIGURATION_TYPE__HIVE:
                return getHive ();
            case ExporterPackage.CONFIGURATION_TYPE__ANNOUNCER:
                return getAnnouncer ();
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
            case ExporterPackage.CONFIGURATION_TYPE__HIVE:
                getHive ().clear ();
                getHive ().addAll ( (Collection<? extends HiveType>)newValue );
                return;
            case ExporterPackage.CONFIGURATION_TYPE__ANNOUNCER:
                getAnnouncer ().clear ();
                getAnnouncer ().addAll ( (Collection<? extends AnnouncerType>)newValue );
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
            case ExporterPackage.CONFIGURATION_TYPE__HIVE:
                getHive ().clear ();
                return;
            case ExporterPackage.CONFIGURATION_TYPE__ANNOUNCER:
                getAnnouncer ().clear ();
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
            case ExporterPackage.CONFIGURATION_TYPE__HIVE:
                return hive != null && !hive.isEmpty ();
            case ExporterPackage.CONFIGURATION_TYPE__ANNOUNCER:
                return announcer != null && !announcer.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //ConfigurationTypeImpl
