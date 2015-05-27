/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.memory.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.memory.FixedLengthStringType;
import org.eclipse.scada.configuration.memory.MemoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Fixed Length String Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.memory.impl.FixedLengthStringTypeImpl#getMaxLength
 * <em>Max Length</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.memory.impl.FixedLengthStringTypeImpl#getCharset
 * <em>Charset</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FixedLengthStringTypeImpl extends BaseScalarTypeImpl implements FixedLengthStringType
{
    /**
     * The default value of the '{@link #getMaxLength() <em>Max Length</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getMaxLength()
     * @generated
     * @ordered
     */
    protected static final int MAX_LENGTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaxLength() <em>Max Length</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getMaxLength()
     * @generated
     * @ordered
     */
    protected int maxLength = MAX_LENGTH_EDEFAULT;

    /**
     * The default value of the '{@link #getCharset() <em>Charset</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getCharset()
     * @generated
     * @ordered
     */
    protected static final String CHARSET_EDEFAULT = "UTF-8"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getCharset() <em>Charset</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getCharset()
     * @generated
     * @ordered
     */
    protected String charset = CHARSET_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected FixedLengthStringTypeImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return MemoryPackage.Literals.FIXED_LENGTH_STRING_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getMaxLength ()
    {
        return this.maxLength;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMaxLength ( final int newMaxLength )
    {
        final int oldMaxLength = this.maxLength;
        this.maxLength = newMaxLength;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryPackage.FIXED_LENGTH_STRING_TYPE__MAX_LENGTH, oldMaxLength, this.maxLength ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getCharset ()
    {
        return this.charset;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setCharset ( final String newCharset )
    {
        final String oldCharset = this.charset;
        this.charset = newCharset;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, MemoryPackage.FIXED_LENGTH_STRING_TYPE__CHARSET, oldCharset, this.charset ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
    {
        switch ( featureID )
        {
            case MemoryPackage.FIXED_LENGTH_STRING_TYPE__MAX_LENGTH:
                return getMaxLength ();
            case MemoryPackage.FIXED_LENGTH_STRING_TYPE__CHARSET:
                return getCharset ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet ( final int featureID, final Object newValue )
    {
        switch ( featureID )
        {
            case MemoryPackage.FIXED_LENGTH_STRING_TYPE__MAX_LENGTH:
                setMaxLength ( (Integer)newValue );
                return;
            case MemoryPackage.FIXED_LENGTH_STRING_TYPE__CHARSET:
                setCharset ( (String)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
    {
        switch ( featureID )
        {
            case MemoryPackage.FIXED_LENGTH_STRING_TYPE__MAX_LENGTH:
                setMaxLength ( MAX_LENGTH_EDEFAULT );
                return;
            case MemoryPackage.FIXED_LENGTH_STRING_TYPE__CHARSET:
                setCharset ( CHARSET_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case MemoryPackage.FIXED_LENGTH_STRING_TYPE__MAX_LENGTH:
                return this.maxLength != MAX_LENGTH_EDEFAULT;
            case MemoryPackage.FIXED_LENGTH_STRING_TYPE__CHARSET:
                return CHARSET_EDEFAULT == null ? this.charset != null : !CHARSET_EDEFAULT.equals ( this.charset );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
        {
            return super.toString ();
        }

        final StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (maxLength: " );
        result.append ( this.maxLength );
        result.append ( ", charset: " );
        result.append ( this.charset );
        result.append ( ')' );
        return result.toString ();
    }

    @Override
    public int getLength ()
    {
        return this.maxLength;
    }

    @Override
    public String encode ()
    {
        return String.format ( "STRING:%s:0:%s:%s", this.index, this.maxLength, this.charset );
    }

} //FixedLengthStringTypeImpl
