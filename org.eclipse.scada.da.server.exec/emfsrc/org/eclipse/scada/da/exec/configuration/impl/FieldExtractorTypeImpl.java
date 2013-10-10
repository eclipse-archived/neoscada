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
package org.eclipse.scada.da.exec.configuration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.FieldExtractorType;
import org.eclipse.scada.da.exec.configuration.FieldType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.FieldExtractorTypeImpl#getField <em>Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FieldExtractorTypeImpl extends ExtractorTypeImpl implements FieldExtractorType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getField() <em>Field</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getField()
     * @generated
     * @ordered
     */
    protected EList<FieldType> field;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FieldExtractorTypeImpl ()
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
        return ConfigurationPackage.Literals.FIELD_EXTRACTOR_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<FieldType> getField ()
    {
        if ( field == null )
        {
            field = new EObjectContainmentEList<FieldType> ( FieldType.class, this, ConfigurationPackage.FIELD_EXTRACTOR_TYPE__FIELD );
        }
        return field;
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
            case ConfigurationPackage.FIELD_EXTRACTOR_TYPE__FIELD:
                return ( (InternalEList<?>)getField () ).basicRemove ( otherEnd, msgs );
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
            case ConfigurationPackage.FIELD_EXTRACTOR_TYPE__FIELD:
                return getField ();
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
            case ConfigurationPackage.FIELD_EXTRACTOR_TYPE__FIELD:
                getField ().clear ();
                getField ().addAll ( (Collection<? extends FieldType>)newValue );
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
            case ConfigurationPackage.FIELD_EXTRACTOR_TYPE__FIELD:
                getField ().clear ();
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
            case ConfigurationPackage.FIELD_EXTRACTOR_TYPE__FIELD:
                return field != null && !field.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //FieldExtractorTypeImpl
