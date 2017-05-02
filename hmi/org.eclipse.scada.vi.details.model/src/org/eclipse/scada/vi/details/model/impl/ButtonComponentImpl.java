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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.vi.details.model.ButtonComponent;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.ValueSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Button Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ButtonComponentImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ButtonComponentImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ButtonComponentImpl#getReadDescriptor <em>Read Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ButtonComponentImpl#getWriteDescriptor <em>Write Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ButtonComponentImpl#getActive <em>Active</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ButtonComponentImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ButtonComponentImpl#getTextHeight <em>Text Height</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ButtonComponentImpl extends GenericComponentImpl implements ButtonComponent
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
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #getReadDescriptor() <em>Read Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReadDescriptor()
     * @generated
     * @ordered
     */
    protected static final String READ_DESCRIPTOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getReadDescriptor() <em>Read Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReadDescriptor()
     * @generated
     * @ordered
     */
    protected String readDescriptor = READ_DESCRIPTOR_EDEFAULT;

    /**
     * The default value of the '{@link #getWriteDescriptor() <em>Write Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWriteDescriptor()
     * @generated
     * @ordered
     */
    protected static final String WRITE_DESCRIPTOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWriteDescriptor() <em>Write Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWriteDescriptor()
     * @generated
     * @ordered
     */
    protected String writeDescriptor = WRITE_DESCRIPTOR_EDEFAULT;

    /**
     * The cached value of the '{@link #getActive() <em>Active</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActive()
     * @generated
     * @ordered
     */
    protected ValueSource active;

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
     * The default value of the '{@link #getTextHeight() <em>Text Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextHeight()
     * @generated
     * @ordered
     */
    protected static final int TEXT_HEIGHT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getTextHeight() <em>Text Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextHeight()
     * @generated
     * @ordered
     */
    protected int textHeight = TEXT_HEIGHT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ButtonComponentImpl ()
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
        return DetailViewPackage.Literals.BUTTON_COMPONENT;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BUTTON_COMPONENT__FORMAT, oldFormat, format ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValue ()
    {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue ( String newValue )
    {
        String oldValue = value;
        value = newValue;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BUTTON_COMPONENT__VALUE, oldValue, value ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getReadDescriptor ()
    {
        return readDescriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReadDescriptor ( String newReadDescriptor )
    {
        String oldReadDescriptor = readDescriptor;
        readDescriptor = newReadDescriptor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BUTTON_COMPONENT__READ_DESCRIPTOR, oldReadDescriptor, readDescriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getWriteDescriptor ()
    {
        return writeDescriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWriteDescriptor ( String newWriteDescriptor )
    {
        String oldWriteDescriptor = writeDescriptor;
        writeDescriptor = newWriteDescriptor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BUTTON_COMPONENT__WRITE_DESCRIPTOR, oldWriteDescriptor, writeDescriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueSource getActive ()
    {
        return active;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetActive ( ValueSource newActive, NotificationChain msgs )
    {
        ValueSource oldActive = active;
        active = newActive;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BUTTON_COMPONENT__ACTIVE, oldActive, newActive );
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
    public void setActive ( ValueSource newActive )
    {
        if ( newActive != active )
        {
            NotificationChain msgs = null;
            if ( active != null )
                msgs = ( (InternalEObject)active ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - DetailViewPackage.BUTTON_COMPONENT__ACTIVE, null, msgs );
            if ( newActive != null )
                msgs = ( (InternalEObject)newActive ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - DetailViewPackage.BUTTON_COMPONENT__ACTIVE, null, msgs );
            msgs = basicSetActive ( newActive, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BUTTON_COMPONENT__ACTIVE, newActive, newActive ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BUTTON_COMPONENT__ATTRIBUTE, oldAttribute, attribute ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTextHeight ()
    {
        return textHeight;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTextHeight ( int newTextHeight )
    {
        int oldTextHeight = textHeight;
        textHeight = newTextHeight;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BUTTON_COMPONENT__TEXT_HEIGHT, oldTextHeight, textHeight ) );
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
            case DetailViewPackage.BUTTON_COMPONENT__ACTIVE:
                return basicSetActive ( null, msgs );
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
            case DetailViewPackage.BUTTON_COMPONENT__FORMAT:
                return getFormat ();
            case DetailViewPackage.BUTTON_COMPONENT__VALUE:
                return getValue ();
            case DetailViewPackage.BUTTON_COMPONENT__READ_DESCRIPTOR:
                return getReadDescriptor ();
            case DetailViewPackage.BUTTON_COMPONENT__WRITE_DESCRIPTOR:
                return getWriteDescriptor ();
            case DetailViewPackage.BUTTON_COMPONENT__ACTIVE:
                return getActive ();
            case DetailViewPackage.BUTTON_COMPONENT__ATTRIBUTE:
                return getAttribute ();
            case DetailViewPackage.BUTTON_COMPONENT__TEXT_HEIGHT:
                return getTextHeight ();
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
            case DetailViewPackage.BUTTON_COMPONENT__FORMAT:
                setFormat ( (String)newValue );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__VALUE:
                setValue ( (String)newValue );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__READ_DESCRIPTOR:
                setReadDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__WRITE_DESCRIPTOR:
                setWriteDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__ACTIVE:
                setActive ( (ValueSource)newValue );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__ATTRIBUTE:
                setAttribute ( (String)newValue );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__TEXT_HEIGHT:
                setTextHeight ( (Integer)newValue );
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
            case DetailViewPackage.BUTTON_COMPONENT__FORMAT:
                setFormat ( FORMAT_EDEFAULT );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__VALUE:
                setValue ( VALUE_EDEFAULT );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__READ_DESCRIPTOR:
                setReadDescriptor ( READ_DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__WRITE_DESCRIPTOR:
                setWriteDescriptor ( WRITE_DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__ACTIVE:
                setActive ( (ValueSource)null );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__ATTRIBUTE:
                setAttribute ( ATTRIBUTE_EDEFAULT );
                return;
            case DetailViewPackage.BUTTON_COMPONENT__TEXT_HEIGHT:
                setTextHeight ( TEXT_HEIGHT_EDEFAULT );
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
            case DetailViewPackage.BUTTON_COMPONENT__FORMAT:
                return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals ( format );
            case DetailViewPackage.BUTTON_COMPONENT__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals ( value );
            case DetailViewPackage.BUTTON_COMPONENT__READ_DESCRIPTOR:
                return READ_DESCRIPTOR_EDEFAULT == null ? readDescriptor != null : !READ_DESCRIPTOR_EDEFAULT.equals ( readDescriptor );
            case DetailViewPackage.BUTTON_COMPONENT__WRITE_DESCRIPTOR:
                return WRITE_DESCRIPTOR_EDEFAULT == null ? writeDescriptor != null : !WRITE_DESCRIPTOR_EDEFAULT.equals ( writeDescriptor );
            case DetailViewPackage.BUTTON_COMPONENT__ACTIVE:
                return active != null;
            case DetailViewPackage.BUTTON_COMPONENT__ATTRIBUTE:
                return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals ( attribute );
            case DetailViewPackage.BUTTON_COMPONENT__TEXT_HEIGHT:
                return textHeight != TEXT_HEIGHT_EDEFAULT;
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
        result.append ( ", value: " ); //$NON-NLS-1$
        result.append ( value );
        result.append ( ", readDescriptor: " ); //$NON-NLS-1$
        result.append ( readDescriptor );
        result.append ( ", writeDescriptor: " ); //$NON-NLS-1$
        result.append ( writeDescriptor );
        result.append ( ", attribute: " ); //$NON-NLS-1$
        result.append ( attribute );
        result.append ( ", textHeight: " ); //$NON-NLS-1$
        result.append ( textHeight );
        result.append ( ')' );
        return result.toString ();
    }

} //ButtonComponentImpl
