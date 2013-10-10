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
package org.eclipse.scada.da.proxy.configuration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.da.proxy.configuration.ConfigurationPackage;
import org.eclipse.scada.da.proxy.configuration.FolderType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Folder Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.impl.FolderTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.impl.FolderTypeImpl#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FolderTypeImpl extends MinimalEObjectImpl.Container implements FolderType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getGroup()
     * @generated
     * @ordered
     */
    protected FeatureMap group;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FolderTypeImpl ()
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
        return ConfigurationPackage.Literals.FOLDER_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getGroup ()
    {
        if ( group == null )
        {
            group = new BasicFeatureMap ( this, ConfigurationPackage.FOLDER_TYPE__GROUP );
        }
        return group;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getLocation ()
    {
        return getGroup ().list ( ConfigurationPackage.Literals.FOLDER_TYPE__LOCATION );
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
            case ConfigurationPackage.FOLDER_TYPE__GROUP:
                return ( (InternalEList<?>)getGroup () ).basicRemove ( otherEnd, msgs );
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
            case ConfigurationPackage.FOLDER_TYPE__GROUP:
                if ( coreType )
                    return getGroup ();
                return ( (FeatureMap.Internal)getGroup () ).getWrapper ();
            case ConfigurationPackage.FOLDER_TYPE__LOCATION:
                return getLocation ();
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
            case ConfigurationPackage.FOLDER_TYPE__GROUP:
                ( (FeatureMap.Internal)getGroup () ).set ( newValue );
                return;
            case ConfigurationPackage.FOLDER_TYPE__LOCATION:
                getLocation ().clear ();
                getLocation ().addAll ( (Collection<? extends String>)newValue );
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
            case ConfigurationPackage.FOLDER_TYPE__GROUP:
                getGroup ().clear ();
                return;
            case ConfigurationPackage.FOLDER_TYPE__LOCATION:
                getLocation ().clear ();
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
            case ConfigurationPackage.FOLDER_TYPE__GROUP:
                return group != null && !group.isEmpty ();
            case ConfigurationPackage.FOLDER_TYPE__LOCATION:
                return !getLocation ().isEmpty ();
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
        result.append ( " (group: " ); //$NON-NLS-1$
        result.append ( group );
        result.append ( ')' );
        return result.toString ();
    }

} //FolderTypeImpl
