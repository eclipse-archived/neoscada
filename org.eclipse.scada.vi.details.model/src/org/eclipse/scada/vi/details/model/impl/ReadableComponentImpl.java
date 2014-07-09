/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.ReadableComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Readable Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ReadableComponentImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ReadableComponentImpl#getDecimal <em>Decimal</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ReadableComponentImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ReadableComponentImpl#getHdConnectionId <em>Hd Connection Id</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ReadableComponentImpl#getHdItemId <em>Hd Item Id</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ReadableComponentImpl#getHdQueryString <em>Hd Query String</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ReadableComponentImpl#isIsText <em>Is Text</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ReadableComponentImpl#getNullReplacementValue <em>Null Replacement Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ReadableComponentImpl extends ComponentImpl implements ReadableComponent
{
    /**
     * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFormat()
     * @generated
     * @ordered
     */
    protected static final String FORMAT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFormat()
     * @generated
     * @ordered
     */
    protected String format = FORMAT_EDEFAULT;

    /**
     * The default value of the '{@link #getDecimal() <em>Decimal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDecimal()
     * @generated
     * @ordered
     */
    protected static final String DECIMAL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDecimal() <em>Decimal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDecimal()
     * @generated
     * @ordered
     */
    protected String decimal = DECIMAL_EDEFAULT;

    /**
     * The default value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttribute()
     * @generated
     * @ordered
     */
    protected static final String ATTRIBUTE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttribute()
     * @generated
     * @ordered
     */
    protected String attribute = ATTRIBUTE_EDEFAULT;

    /**
     * The default value of the '{@link #getHdConnectionId() <em>Hd Connection Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdConnectionId()
     * @generated
     * @ordered
     */
    protected static final String HD_CONNECTION_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHdConnectionId() <em>Hd Connection Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdConnectionId()
     * @generated
     * @ordered
     */
    protected String hdConnectionId = HD_CONNECTION_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getHdItemId() <em>Hd Item Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdItemId()
     * @generated
     * @ordered
     */
    protected static final String HD_ITEM_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHdItemId() <em>Hd Item Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdItemId()
     * @generated
     * @ordered
     */
    protected String hdItemId = HD_ITEM_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getHdQueryString() <em>Hd Query String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdQueryString()
     * @generated
     * @ordered
     */
    protected static final String HD_QUERY_STRING_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHdQueryString() <em>Hd Query String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHdQueryString()
     * @generated
     * @ordered
     */
    protected String hdQueryString = HD_QUERY_STRING_EDEFAULT;

    /**
     * The default value of the '{@link #isIsText() <em>Is Text</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsText()
     * @generated
     * @ordered
     */
    protected static final boolean IS_TEXT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsText() <em>Is Text</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsText()
     * @generated
     * @ordered
     */
    protected boolean isText = IS_TEXT_EDEFAULT;

    /**
     * The default value of the '{@link #getNullReplacementValue() <em>Null Replacement Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNullReplacementValue()
     * @generated
     * @ordered
     */
    protected static final String NULL_REPLACEMENT_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNullReplacementValue() <em>Null Replacement Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNullReplacementValue()
     * @generated
     * @ordered
     */
    protected String nullReplacementValue = NULL_REPLACEMENT_VALUE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReadableComponentImpl ()
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
        return DetailViewPackage.Literals.READABLE_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFormat ()
    {
        return format;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFormat ( String newFormat )
    {
        String oldFormat = format;
        format = newFormat;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__FORMAT, oldFormat, format ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDecimal ()
    {
        return decimal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDecimal ( String newDecimal )
    {
        String oldDecimal = decimal;
        decimal = newDecimal;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__DECIMAL, oldDecimal, decimal ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAttribute ()
    {
        return attribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttribute ( String newAttribute )
    {
        String oldAttribute = attribute;
        attribute = newAttribute;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE, oldAttribute, attribute ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHdConnectionId ()
    {
        return hdConnectionId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHdConnectionId ( String newHdConnectionId )
    {
        String oldHdConnectionId = hdConnectionId;
        hdConnectionId = newHdConnectionId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__HD_CONNECTION_ID, oldHdConnectionId, hdConnectionId ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHdItemId ()
    {
        return hdItemId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHdItemId ( String newHdItemId )
    {
        String oldHdItemId = hdItemId;
        hdItemId = newHdItemId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID, oldHdItemId, hdItemId ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getHdQueryString ()
    {
        return hdQueryString;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHdQueryString ( String newHdQueryString )
    {
        String oldHdQueryString = hdQueryString;
        hdQueryString = newHdQueryString;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__HD_QUERY_STRING, oldHdQueryString, hdQueryString ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsText ()
    {
        return isText;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsText ( boolean newIsText )
    {
        boolean oldIsText = isText;
        isText = newIsText;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__IS_TEXT, oldIsText, isText ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getNullReplacementValue ()
    {
        return nullReplacementValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNullReplacementValue ( String newNullReplacementValue )
    {
        String oldNullReplacementValue = nullReplacementValue;
        nullReplacementValue = newNullReplacementValue;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.READABLE_COMPONENT__NULL_REPLACEMENT_VALUE, oldNullReplacementValue, nullReplacementValue ) );
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
            case DetailViewPackage.READABLE_COMPONENT__FORMAT:
                return getFormat ();
            case DetailViewPackage.READABLE_COMPONENT__DECIMAL:
                return getDecimal ();
            case DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE:
                return getAttribute ();
            case DetailViewPackage.READABLE_COMPONENT__HD_CONNECTION_ID:
                return getHdConnectionId ();
            case DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID:
                return getHdItemId ();
            case DetailViewPackage.READABLE_COMPONENT__HD_QUERY_STRING:
                return getHdQueryString ();
            case DetailViewPackage.READABLE_COMPONENT__IS_TEXT:
                return isIsText ();
            case DetailViewPackage.READABLE_COMPONENT__NULL_REPLACEMENT_VALUE:
                return getNullReplacementValue ();
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
            case DetailViewPackage.READABLE_COMPONENT__FORMAT:
                setFormat ( (String)newValue );
                return;
            case DetailViewPackage.READABLE_COMPONENT__DECIMAL:
                setDecimal ( (String)newValue );
                return;
            case DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE:
                setAttribute ( (String)newValue );
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_CONNECTION_ID:
                setHdConnectionId ( (String)newValue );
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID:
                setHdItemId ( (String)newValue );
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_QUERY_STRING:
                setHdQueryString ( (String)newValue );
                return;
            case DetailViewPackage.READABLE_COMPONENT__IS_TEXT:
                setIsText ( (Boolean)newValue );
                return;
            case DetailViewPackage.READABLE_COMPONENT__NULL_REPLACEMENT_VALUE:
                setNullReplacementValue ( (String)newValue );
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
            case DetailViewPackage.READABLE_COMPONENT__FORMAT:
                setFormat ( FORMAT_EDEFAULT );
                return;
            case DetailViewPackage.READABLE_COMPONENT__DECIMAL:
                setDecimal ( DECIMAL_EDEFAULT );
                return;
            case DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE:
                setAttribute ( ATTRIBUTE_EDEFAULT );
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_CONNECTION_ID:
                setHdConnectionId ( HD_CONNECTION_ID_EDEFAULT );
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID:
                setHdItemId ( HD_ITEM_ID_EDEFAULT );
                return;
            case DetailViewPackage.READABLE_COMPONENT__HD_QUERY_STRING:
                setHdQueryString ( HD_QUERY_STRING_EDEFAULT );
                return;
            case DetailViewPackage.READABLE_COMPONENT__IS_TEXT:
                setIsText ( IS_TEXT_EDEFAULT );
                return;
            case DetailViewPackage.READABLE_COMPONENT__NULL_REPLACEMENT_VALUE:
                setNullReplacementValue ( NULL_REPLACEMENT_VALUE_EDEFAULT );
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
            case DetailViewPackage.READABLE_COMPONENT__FORMAT:
                return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals ( format );
            case DetailViewPackage.READABLE_COMPONENT__DECIMAL:
                return DECIMAL_EDEFAULT == null ? decimal != null : !DECIMAL_EDEFAULT.equals ( decimal );
            case DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE:
                return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals ( attribute );
            case DetailViewPackage.READABLE_COMPONENT__HD_CONNECTION_ID:
                return HD_CONNECTION_ID_EDEFAULT == null ? hdConnectionId != null : !HD_CONNECTION_ID_EDEFAULT.equals ( hdConnectionId );
            case DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID:
                return HD_ITEM_ID_EDEFAULT == null ? hdItemId != null : !HD_ITEM_ID_EDEFAULT.equals ( hdItemId );
            case DetailViewPackage.READABLE_COMPONENT__HD_QUERY_STRING:
                return HD_QUERY_STRING_EDEFAULT == null ? hdQueryString != null : !HD_QUERY_STRING_EDEFAULT.equals ( hdQueryString );
            case DetailViewPackage.READABLE_COMPONENT__IS_TEXT:
                return isText != IS_TEXT_EDEFAULT;
            case DetailViewPackage.READABLE_COMPONENT__NULL_REPLACEMENT_VALUE:
                return NULL_REPLACEMENT_VALUE_EDEFAULT == null ? nullReplacementValue != null : !NULL_REPLACEMENT_VALUE_EDEFAULT.equals ( nullReplacementValue );
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
        result.append ( " (format: " ); //$NON-NLS-1$
        result.append ( format );
        result.append ( ", decimal: " ); //$NON-NLS-1$
        result.append ( decimal );
        result.append ( ", attribute: " ); //$NON-NLS-1$
        result.append ( attribute );
        result.append ( ", hdConnectionId: " ); //$NON-NLS-1$
        result.append ( hdConnectionId );
        result.append ( ", hdItemId: " ); //$NON-NLS-1$
        result.append ( hdItemId );
        result.append ( ", hdQueryString: " ); //$NON-NLS-1$
        result.append ( hdQueryString );
        result.append ( ", isText: " ); //$NON-NLS-1$
        result.append ( isText );
        result.append ( ", nullReplacementValue: " ); //$NON-NLS-1$
        result.append ( nullReplacementValue );
        result.append ( ')' );
        return result.toString ();
    }

} //ReadableComponentImpl
