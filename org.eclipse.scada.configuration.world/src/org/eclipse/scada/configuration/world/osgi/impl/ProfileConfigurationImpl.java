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
package org.eclipse.scada.configuration.world.osgi.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.configuration.world.PropertyEntry;

import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.ProfileConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ProfileConfigurationImpl#getStartBundles <em>Start Bundles</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ProfileConfigurationImpl#getInstallBundles <em>Install Bundles</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ProfileConfigurationImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProfileConfigurationImpl extends MinimalEObjectImpl.Container implements ProfileConfiguration
{
    /**
     * The cached value of the '{@link #getStartBundles() <em>Start Bundles</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStartBundles()
     * @generated
     * @ordered
     */
    protected EList<String> startBundles;

    /**
     * The cached value of the '{@link #getInstallBundles() <em>Install Bundles</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstallBundles()
     * @generated
     * @ordered
     */
    protected EList<String> installBundles;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> properties;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProfileConfigurationImpl ()
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
        return OsgiPackage.Literals.PROFILE_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getStartBundles ()
    {
        if ( startBundles == null )
        {
            startBundles = new EDataTypeUniqueEList<String> ( String.class, this, OsgiPackage.PROFILE_CONFIGURATION__START_BUNDLES );
        }
        return startBundles;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getInstallBundles ()
    {
        if ( installBundles == null )
        {
            installBundles = new EDataTypeUniqueEList<String> ( String.class, this, OsgiPackage.PROFILE_CONFIGURATION__INSTALL_BUNDLES );
        }
        return installBundles;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, OsgiPackage.PROFILE_CONFIGURATION__PROPERTIES );
        }
        return properties;
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
            case OsgiPackage.PROFILE_CONFIGURATION__PROPERTIES:
                return ( (InternalEList<?>)getProperties () ).basicRemove ( otherEnd, msgs );
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
            case OsgiPackage.PROFILE_CONFIGURATION__START_BUNDLES:
                return getStartBundles ();
            case OsgiPackage.PROFILE_CONFIGURATION__INSTALL_BUNDLES:
                return getInstallBundles ();
            case OsgiPackage.PROFILE_CONFIGURATION__PROPERTIES:
                return getProperties ();
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
            case OsgiPackage.PROFILE_CONFIGURATION__START_BUNDLES:
                getStartBundles ().clear ();
                getStartBundles ().addAll ( (Collection<? extends String>)newValue );
                return;
            case OsgiPackage.PROFILE_CONFIGURATION__INSTALL_BUNDLES:
                getInstallBundles ().clear ();
                getInstallBundles ().addAll ( (Collection<? extends String>)newValue );
                return;
            case OsgiPackage.PROFILE_CONFIGURATION__PROPERTIES:
                getProperties ().clear ();
                getProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
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
            case OsgiPackage.PROFILE_CONFIGURATION__START_BUNDLES:
                getStartBundles ().clear ();
                return;
            case OsgiPackage.PROFILE_CONFIGURATION__INSTALL_BUNDLES:
                getInstallBundles ().clear ();
                return;
            case OsgiPackage.PROFILE_CONFIGURATION__PROPERTIES:
                getProperties ().clear ();
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
            case OsgiPackage.PROFILE_CONFIGURATION__START_BUNDLES:
                return startBundles != null && !startBundles.isEmpty ();
            case OsgiPackage.PROFILE_CONFIGURATION__INSTALL_BUNDLES:
                return installBundles != null && !installBundles.isEmpty ();
            case OsgiPackage.PROFILE_CONFIGURATION__PROPERTIES:
                return properties != null && !properties.isEmpty ();
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
        result.append ( " (startBundles: " ); //$NON-NLS-1$
        result.append ( startBundles );
        result.append ( ", installBundles: " ); //$NON-NLS-1$
        result.append ( installBundles );
        result.append ( ')' );
        return result.toString ();
    }

} //ProfileConfigurationImpl
