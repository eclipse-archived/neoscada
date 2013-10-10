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
package org.eclipse.scada.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.common.CommonPackage;
import org.eclipse.scada.common.VariantBooleanType;
import org.eclipse.scada.common.VariantDoubleType;
import org.eclipse.scada.common.VariantInt32Type;
import org.eclipse.scada.common.VariantInt64Type;
import org.eclipse.scada.common.VariantNullType;
import org.eclipse.scada.common.VariantType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variant Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.common.impl.VariantTypeImpl#getNull <em>Null</em>}</li>
 *   <li>{@link org.eclipse.scada.common.impl.VariantTypeImpl#getString <em>String</em>}</li>
 *   <li>{@link org.eclipse.scada.common.impl.VariantTypeImpl#getInt32 <em>Int32</em>}</li>
 *   <li>{@link org.eclipse.scada.common.impl.VariantTypeImpl#getDouble <em>Double</em>}</li>
 *   <li>{@link org.eclipse.scada.common.impl.VariantTypeImpl#getBoolean <em>Boolean</em>}</li>
 *   <li>{@link org.eclipse.scada.common.impl.VariantTypeImpl#getInt64 <em>Int64</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariantTypeImpl extends MinimalEObjectImpl.Container implements VariantType
{
   

    /**
     * The cached value of the '{@link #getNull() <em>Null</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNull()
     * @generated
     * @ordered
     */
    protected VariantNullType null_;

    /**
     * The default value of the '{@link #getString() <em>String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getString()
     * @generated
     * @ordered
     */
    protected static final String STRING_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getString() <em>String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getString()
     * @generated
     * @ordered
     */
    protected String string = STRING_EDEFAULT;

    /**
     * The cached value of the '{@link #getInt32() <em>Int32</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInt32()
     * @generated
     * @ordered
     */
    protected VariantInt32Type int32;

    /**
     * The cached value of the '{@link #getDouble() <em>Double</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDouble()
     * @generated
     * @ordered
     */
    protected VariantDoubleType double_;

    /**
     * The cached value of the '{@link #getBoolean() <em>Boolean</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBoolean()
     * @generated
     * @ordered
     */
    protected VariantBooleanType boolean_;

    /**
     * The cached value of the '{@link #getInt64() <em>Int64</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInt64()
     * @generated
     * @ordered
     */
    protected VariantInt64Type int64;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariantTypeImpl ()
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
        return CommonPackage.Literals.VARIANT_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantNullType getNull ()
    {
        return null_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetNull ( VariantNullType newNull, NotificationChain msgs )
    {
        VariantNullType oldNull = null_;
        null_ = newNull;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__NULL, oldNull, newNull );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNull ( VariantNullType newNull )
    {
        if ( newNull != null_ )
        {
            NotificationChain msgs = null;
            if ( null_ != null )
                msgs = ( (InternalEObject)null_ ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__NULL, null, msgs );
            if ( newNull != null )
                msgs = ( (InternalEObject)newNull ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__NULL, null, msgs );
            msgs = basicSetNull ( newNull, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__NULL, newNull, newNull ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getString ()
    {
        return string;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setString ( String newString )
    {
        String oldString = string;
        string = newString;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__STRING, oldString, string ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantInt32Type getInt32 ()
    {
        return int32;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInt32 ( VariantInt32Type newInt32, NotificationChain msgs )
    {
        VariantInt32Type oldInt32 = int32;
        int32 = newInt32;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__INT32, oldInt32, newInt32 );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInt32 ( VariantInt32Type newInt32 )
    {
        if ( newInt32 != int32 )
        {
            NotificationChain msgs = null;
            if ( int32 != null )
                msgs = ( (InternalEObject)int32 ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__INT32, null, msgs );
            if ( newInt32 != null )
                msgs = ( (InternalEObject)newInt32 ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__INT32, null, msgs );
            msgs = basicSetInt32 ( newInt32, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__INT32, newInt32, newInt32 ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantDoubleType getDouble ()
    {
        return double_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDouble ( VariantDoubleType newDouble, NotificationChain msgs )
    {
        VariantDoubleType oldDouble = double_;
        double_ = newDouble;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__DOUBLE, oldDouble, newDouble );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDouble ( VariantDoubleType newDouble )
    {
        if ( newDouble != double_ )
        {
            NotificationChain msgs = null;
            if ( double_ != null )
                msgs = ( (InternalEObject)double_ ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__DOUBLE, null, msgs );
            if ( newDouble != null )
                msgs = ( (InternalEObject)newDouble ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__DOUBLE, null, msgs );
            msgs = basicSetDouble ( newDouble, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__DOUBLE, newDouble, newDouble ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantBooleanType getBoolean ()
    {
        return boolean_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetBoolean ( VariantBooleanType newBoolean, NotificationChain msgs )
    {
        VariantBooleanType oldBoolean = boolean_;
        boolean_ = newBoolean;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__BOOLEAN, oldBoolean, newBoolean );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBoolean ( VariantBooleanType newBoolean )
    {
        if ( newBoolean != boolean_ )
        {
            NotificationChain msgs = null;
            if ( boolean_ != null )
                msgs = ( (InternalEObject)boolean_ ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__BOOLEAN, null, msgs );
            if ( newBoolean != null )
                msgs = ( (InternalEObject)newBoolean ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__BOOLEAN, null, msgs );
            msgs = basicSetBoolean ( newBoolean, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__BOOLEAN, newBoolean, newBoolean ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantInt64Type getInt64 ()
    {
        return int64;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInt64 ( VariantInt64Type newInt64, NotificationChain msgs )
    {
        VariantInt64Type oldInt64 = int64;
        int64 = newInt64;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__INT64, oldInt64, newInt64 );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInt64 ( VariantInt64Type newInt64 )
    {
        if ( newInt64 != int64 )
        {
            NotificationChain msgs = null;
            if ( int64 != null )
                msgs = ( (InternalEObject)int64 ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__INT64, null, msgs );
            if ( newInt64 != null )
                msgs = ( (InternalEObject)newInt64 ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.VARIANT_TYPE__INT64, null, msgs );
            msgs = basicSetInt64 ( newInt64, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.VARIANT_TYPE__INT64, newInt64, newInt64 ) );
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
            case CommonPackage.VARIANT_TYPE__NULL:
                return basicSetNull ( null, msgs );
            case CommonPackage.VARIANT_TYPE__INT32:
                return basicSetInt32 ( null, msgs );
            case CommonPackage.VARIANT_TYPE__DOUBLE:
                return basicSetDouble ( null, msgs );
            case CommonPackage.VARIANT_TYPE__BOOLEAN:
                return basicSetBoolean ( null, msgs );
            case CommonPackage.VARIANT_TYPE__INT64:
                return basicSetInt64 ( null, msgs );
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
            case CommonPackage.VARIANT_TYPE__NULL:
                return getNull ();
            case CommonPackage.VARIANT_TYPE__STRING:
                return getString ();
            case CommonPackage.VARIANT_TYPE__INT32:
                return getInt32 ();
            case CommonPackage.VARIANT_TYPE__DOUBLE:
                return getDouble ();
            case CommonPackage.VARIANT_TYPE__BOOLEAN:
                return getBoolean ();
            case CommonPackage.VARIANT_TYPE__INT64:
                return getInt64 ();
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
            case CommonPackage.VARIANT_TYPE__NULL:
                setNull ( (VariantNullType)newValue );
                return;
            case CommonPackage.VARIANT_TYPE__STRING:
                setString ( (String)newValue );
                return;
            case CommonPackage.VARIANT_TYPE__INT32:
                setInt32 ( (VariantInt32Type)newValue );
                return;
            case CommonPackage.VARIANT_TYPE__DOUBLE:
                setDouble ( (VariantDoubleType)newValue );
                return;
            case CommonPackage.VARIANT_TYPE__BOOLEAN:
                setBoolean ( (VariantBooleanType)newValue );
                return;
            case CommonPackage.VARIANT_TYPE__INT64:
                setInt64 ( (VariantInt64Type)newValue );
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
            case CommonPackage.VARIANT_TYPE__NULL:
                setNull ( (VariantNullType)null );
                return;
            case CommonPackage.VARIANT_TYPE__STRING:
                setString ( STRING_EDEFAULT );
                return;
            case CommonPackage.VARIANT_TYPE__INT32:
                setInt32 ( (VariantInt32Type)null );
                return;
            case CommonPackage.VARIANT_TYPE__DOUBLE:
                setDouble ( (VariantDoubleType)null );
                return;
            case CommonPackage.VARIANT_TYPE__BOOLEAN:
                setBoolean ( (VariantBooleanType)null );
                return;
            case CommonPackage.VARIANT_TYPE__INT64:
                setInt64 ( (VariantInt64Type)null );
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
            case CommonPackage.VARIANT_TYPE__NULL:
                return null_ != null;
            case CommonPackage.VARIANT_TYPE__STRING:
                return STRING_EDEFAULT == null ? string != null : !STRING_EDEFAULT.equals ( string );
            case CommonPackage.VARIANT_TYPE__INT32:
                return int32 != null;
            case CommonPackage.VARIANT_TYPE__DOUBLE:
                return double_ != null;
            case CommonPackage.VARIANT_TYPE__BOOLEAN:
                return boolean_ != null;
            case CommonPackage.VARIANT_TYPE__INT64:
                return int64 != null;
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
        result.append ( " (string: " );
        result.append ( string );
        result.append ( ')' );
        return result.toString ();
    }

} //VariantTypeImpl
