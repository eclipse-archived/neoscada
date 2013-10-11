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
import org.eclipse.scada.vi.details.model.BoolLEDComponent;
import org.eclipse.scada.vi.details.model.DetailViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bool LED Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.BoolLEDComponentImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.BoolLEDComponentImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.BoolLEDComponentImpl#isAlarm <em>Alarm</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.BoolLEDComponentImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.BoolLEDComponentImpl#isExpectedValue <em>Expected Value</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.BoolLEDComponentImpl#isOnOff <em>On Off</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoolLEDComponentImpl extends ComponentImpl implements BoolLEDComponent
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
     * The default value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescriptor()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescriptor()
     * @generated
     * @ordered
     */
    protected String descriptor = DESCRIPTOR_EDEFAULT;

    /**
     * The default value of the '{@link #isAlarm() <em>Alarm</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAlarm()
     * @generated
     * @ordered
     */
    protected static final boolean ALARM_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAlarm() <em>Alarm</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAlarm()
     * @generated
     * @ordered
     */
    protected boolean alarm = ALARM_EDEFAULT;

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
     * The default value of the '{@link #isExpectedValue() <em>Expected Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isExpectedValue()
     * @generated
     * @ordered
     */
    protected static final boolean EXPECTED_VALUE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isExpectedValue() <em>Expected Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isExpectedValue()
     * @generated
     * @ordered
     */
    protected boolean expectedValue = EXPECTED_VALUE_EDEFAULT;

    /**
     * The default value of the '{@link #isOnOff() <em>On Off</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOnOff()
     * @generated
     * @ordered
     */
    protected static final boolean ON_OFF_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isOnOff() <em>On Off</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOnOff()
     * @generated
     * @ordered
     */
    protected boolean onOff = ON_OFF_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BoolLEDComponentImpl ()
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
        return DetailViewPackage.Literals.BOOL_LED_COMPONENT;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BOOL_LED_COMPONENT__FORMAT, oldFormat, format ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescriptor ()
    {
        return descriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescriptor ( String newDescriptor )
    {
        String oldDescriptor = descriptor;
        descriptor = newDescriptor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BOOL_LED_COMPONENT__DESCRIPTOR, oldDescriptor, descriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAlarm ()
    {
        return alarm;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAlarm ( boolean newAlarm )
    {
        boolean oldAlarm = alarm;
        alarm = newAlarm;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BOOL_LED_COMPONENT__ALARM, oldAlarm, alarm ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BOOL_LED_COMPONENT__ATTRIBUTE, oldAttribute, attribute ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isExpectedValue ()
    {
        return expectedValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpectedValue ( boolean newExpectedValue )
    {
        boolean oldExpectedValue = expectedValue;
        expectedValue = newExpectedValue;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BOOL_LED_COMPONENT__EXPECTED_VALUE, oldExpectedValue, expectedValue ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isOnOff ()
    {
        return onOff;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnOff ( boolean newOnOff )
    {
        boolean oldOnOff = onOff;
        onOff = newOnOff;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BOOL_LED_COMPONENT__ON_OFF, oldOnOff, onOff ) );
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
            case DetailViewPackage.BOOL_LED_COMPONENT__FORMAT:
                return getFormat ();
            case DetailViewPackage.BOOL_LED_COMPONENT__DESCRIPTOR:
                return getDescriptor ();
            case DetailViewPackage.BOOL_LED_COMPONENT__ALARM:
                return isAlarm ();
            case DetailViewPackage.BOOL_LED_COMPONENT__ATTRIBUTE:
                return getAttribute ();
            case DetailViewPackage.BOOL_LED_COMPONENT__EXPECTED_VALUE:
                return isExpectedValue ();
            case DetailViewPackage.BOOL_LED_COMPONENT__ON_OFF:
                return isOnOff ();
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
            case DetailViewPackage.BOOL_LED_COMPONENT__FORMAT:
                setFormat ( (String)newValue );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__DESCRIPTOR:
                setDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__ALARM:
                setAlarm ( (Boolean)newValue );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__ATTRIBUTE:
                setAttribute ( (String)newValue );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__EXPECTED_VALUE:
                setExpectedValue ( (Boolean)newValue );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__ON_OFF:
                setOnOff ( (Boolean)newValue );
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
            case DetailViewPackage.BOOL_LED_COMPONENT__FORMAT:
                setFormat ( FORMAT_EDEFAULT );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__DESCRIPTOR:
                setDescriptor ( DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__ALARM:
                setAlarm ( ALARM_EDEFAULT );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__ATTRIBUTE:
                setAttribute ( ATTRIBUTE_EDEFAULT );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__EXPECTED_VALUE:
                setExpectedValue ( EXPECTED_VALUE_EDEFAULT );
                return;
            case DetailViewPackage.BOOL_LED_COMPONENT__ON_OFF:
                setOnOff ( ON_OFF_EDEFAULT );
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
            case DetailViewPackage.BOOL_LED_COMPONENT__FORMAT:
                return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals ( format );
            case DetailViewPackage.BOOL_LED_COMPONENT__DESCRIPTOR:
                return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals ( descriptor );
            case DetailViewPackage.BOOL_LED_COMPONENT__ALARM:
                return alarm != ALARM_EDEFAULT;
            case DetailViewPackage.BOOL_LED_COMPONENT__ATTRIBUTE:
                return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals ( attribute );
            case DetailViewPackage.BOOL_LED_COMPONENT__EXPECTED_VALUE:
                return expectedValue != EXPECTED_VALUE_EDEFAULT;
            case DetailViewPackage.BOOL_LED_COMPONENT__ON_OFF:
                return onOff != ON_OFF_EDEFAULT;
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
        result.append ( ", descriptor: " ); //$NON-NLS-1$
        result.append ( descriptor );
        result.append ( ", alarm: " ); //$NON-NLS-1$
        result.append ( alarm );
        result.append ( ", attribute: " ); //$NON-NLS-1$
        result.append ( attribute );
        result.append ( ", expectedValue: " ); //$NON-NLS-1$
        result.append ( expectedValue );
        result.append ( ", onOff: " ); //$NON-NLS-1$
        result.append ( onOff );
        result.append ( ')' );
        return result.toString ();
    }

} //BoolLEDComponentImpl
