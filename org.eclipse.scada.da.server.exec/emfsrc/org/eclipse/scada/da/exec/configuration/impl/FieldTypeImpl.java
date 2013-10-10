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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.FieldType;
import org.eclipse.scada.da.exec.configuration.VariantTypeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.FieldTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.FieldTypeImpl#getVariantType <em>Variant Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FieldTypeImpl extends MinimalEObjectImpl.Container implements FieldType
{
    //$NON-NLS-1$

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getVariantType() <em>Variant Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVariantType()
     * @generated
     * @ordered
     */
    protected static final VariantTypeType VARIANT_TYPE_EDEFAULT = VariantTypeType.STRING;

    /**
     * The cached value of the '{@link #getVariantType() <em>Variant Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVariantType()
     * @generated
     * @ordered
     */
    protected VariantTypeType variantType = VARIANT_TYPE_EDEFAULT;

    /**
     * This is true if the Variant Type attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean variantTypeESet;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FieldTypeImpl ()
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
        return ConfigurationPackage.Literals.FIELD_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.FIELD_TYPE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantTypeType getVariantType ()
    {
        return variantType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVariantType ( VariantTypeType newVariantType )
    {
        VariantTypeType oldVariantType = variantType;
        variantType = newVariantType == null ? VARIANT_TYPE_EDEFAULT : newVariantType;
        boolean oldVariantTypeESet = variantTypeESet;
        variantTypeESet = true;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.FIELD_TYPE__VARIANT_TYPE, oldVariantType, variantType, !oldVariantTypeESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetVariantType ()
    {
        VariantTypeType oldVariantType = variantType;
        boolean oldVariantTypeESet = variantTypeESet;
        variantType = VARIANT_TYPE_EDEFAULT;
        variantTypeESet = false;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.UNSET, ConfigurationPackage.FIELD_TYPE__VARIANT_TYPE, oldVariantType, VARIANT_TYPE_EDEFAULT, oldVariantTypeESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetVariantType ()
    {
        return variantTypeESet;
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
            case ConfigurationPackage.FIELD_TYPE__NAME:
                return getName ();
            case ConfigurationPackage.FIELD_TYPE__VARIANT_TYPE:
                return getVariantType ();
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
            case ConfigurationPackage.FIELD_TYPE__NAME:
                setName ( (String)newValue );
                return;
            case ConfigurationPackage.FIELD_TYPE__VARIANT_TYPE:
                setVariantType ( (VariantTypeType)newValue );
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
            case ConfigurationPackage.FIELD_TYPE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ConfigurationPackage.FIELD_TYPE__VARIANT_TYPE:
                unsetVariantType ();
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
            case ConfigurationPackage.FIELD_TYPE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ConfigurationPackage.FIELD_TYPE__VARIANT_TYPE:
                return isSetVariantType ();
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", variantType: " ); //$NON-NLS-1$
        if ( variantTypeESet )
            result.append ( variantType );
        else
            result.append ( "<unset>" ); //$NON-NLS-1$
        result.append ( ')' );
        return result.toString ();
    }

} //FieldTypeImpl
