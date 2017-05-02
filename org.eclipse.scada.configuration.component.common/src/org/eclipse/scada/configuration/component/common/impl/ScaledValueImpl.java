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
package org.eclipse.scada.configuration.component.common.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.configuration.component.InputDefinition;

import org.eclipse.scada.configuration.component.common.CommonPackage;
import org.eclipse.scada.configuration.component.common.ScaledValue;

import org.eclipse.scada.configuration.component.impl.SingleValueImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scaled Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl#getSourceItem <em>Source Item</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl#getInputMinimum <em>Input Minimum</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl#getInputMaximum <em>Input Maximum</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl#getOutputMinimum <em>Output Minimum</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl#getOutputMaximum <em>Output Maximum</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.ScaledValueImpl#isValidateRange <em>Validate Range</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScaledValueImpl extends SingleValueImpl implements ScaledValue
{
    /**
     * The cached value of the '{@link #getSourceItem() <em>Source Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceItem()
     * @generated
     * @ordered
     */
    protected InputDefinition sourceItem;

    /**
     * The default value of the '{@link #getInputMinimum() <em>Input Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputMinimum()
     * @generated
     * @ordered
     */
    protected static final double INPUT_MINIMUM_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getInputMinimum() <em>Input Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputMinimum()
     * @generated
     * @ordered
     */
    protected double inputMinimum = INPUT_MINIMUM_EDEFAULT;

    /**
     * The default value of the '{@link #getInputMaximum() <em>Input Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputMaximum()
     * @generated
     * @ordered
     */
    protected static final double INPUT_MAXIMUM_EDEFAULT = 100.0;

    /**
     * The cached value of the '{@link #getInputMaximum() <em>Input Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputMaximum()
     * @generated
     * @ordered
     */
    protected double inputMaximum = INPUT_MAXIMUM_EDEFAULT;

    /**
     * The default value of the '{@link #getOutputMinimum() <em>Output Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputMinimum()
     * @generated
     * @ordered
     */
    protected static final double OUTPUT_MINIMUM_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getOutputMinimum() <em>Output Minimum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputMinimum()
     * @generated
     * @ordered
     */
    protected double outputMinimum = OUTPUT_MINIMUM_EDEFAULT;

    /**
     * The default value of the '{@link #getOutputMaximum() <em>Output Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputMaximum()
     * @generated
     * @ordered
     */
    protected static final double OUTPUT_MAXIMUM_EDEFAULT = 1000.0;

    /**
     * The cached value of the '{@link #getOutputMaximum() <em>Output Maximum</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputMaximum()
     * @generated
     * @ordered
     */
    protected double outputMaximum = OUTPUT_MAXIMUM_EDEFAULT;

    /**
     * The default value of the '{@link #isValidateRange() <em>Validate Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isValidateRange()
     * @generated
     * @ordered
     */
    protected static final boolean VALIDATE_RANGE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isValidateRange() <em>Validate Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isValidateRange()
     * @generated
     * @ordered
     */
    protected boolean validateRange = VALIDATE_RANGE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ScaledValueImpl ()
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
        return CommonPackage.Literals.SCALED_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition getSourceItem ()
    {
        return sourceItem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSourceItem ( InputDefinition newSourceItem, NotificationChain msgs )
    {
        InputDefinition oldSourceItem = sourceItem;
        sourceItem = newSourceItem;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, CommonPackage.SCALED_VALUE__SOURCE_ITEM, oldSourceItem, newSourceItem );
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
    public void setSourceItem ( InputDefinition newSourceItem )
    {
        if ( newSourceItem != sourceItem )
        {
            NotificationChain msgs = null;
            if ( sourceItem != null )
                msgs = ( (InternalEObject)sourceItem ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.SCALED_VALUE__SOURCE_ITEM, null, msgs );
            if ( newSourceItem != null )
                msgs = ( (InternalEObject)newSourceItem ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - CommonPackage.SCALED_VALUE__SOURCE_ITEM, null, msgs );
            msgs = basicSetSourceItem ( newSourceItem, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SCALED_VALUE__SOURCE_ITEM, newSourceItem, newSourceItem ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getInputMinimum ()
    {
        return inputMinimum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputMinimum ( double newInputMinimum )
    {
        double oldInputMinimum = inputMinimum;
        inputMinimum = newInputMinimum;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SCALED_VALUE__INPUT_MINIMUM, oldInputMinimum, inputMinimum ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getInputMaximum ()
    {
        return inputMaximum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputMaximum ( double newInputMaximum )
    {
        double oldInputMaximum = inputMaximum;
        inputMaximum = newInputMaximum;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SCALED_VALUE__INPUT_MAXIMUM, oldInputMaximum, inputMaximum ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getOutputMinimum ()
    {
        return outputMinimum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputMinimum ( double newOutputMinimum )
    {
        double oldOutputMinimum = outputMinimum;
        outputMinimum = newOutputMinimum;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SCALED_VALUE__OUTPUT_MINIMUM, oldOutputMinimum, outputMinimum ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getOutputMaximum ()
    {
        return outputMaximum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputMaximum ( double newOutputMaximum )
    {
        double oldOutputMaximum = outputMaximum;
        outputMaximum = newOutputMaximum;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SCALED_VALUE__OUTPUT_MAXIMUM, oldOutputMaximum, outputMaximum ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isValidateRange ()
    {
        return validateRange;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValidateRange ( boolean newValidateRange )
    {
        boolean oldValidateRange = validateRange;
        validateRange = newValidateRange;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SCALED_VALUE__VALIDATE_RANGE, oldValidateRange, validateRange ) );
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
            case CommonPackage.SCALED_VALUE__SOURCE_ITEM:
                return basicSetSourceItem ( null, msgs );
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
            case CommonPackage.SCALED_VALUE__SOURCE_ITEM:
                return getSourceItem ();
            case CommonPackage.SCALED_VALUE__INPUT_MINIMUM:
                return getInputMinimum ();
            case CommonPackage.SCALED_VALUE__INPUT_MAXIMUM:
                return getInputMaximum ();
            case CommonPackage.SCALED_VALUE__OUTPUT_MINIMUM:
                return getOutputMinimum ();
            case CommonPackage.SCALED_VALUE__OUTPUT_MAXIMUM:
                return getOutputMaximum ();
            case CommonPackage.SCALED_VALUE__VALIDATE_RANGE:
                return isValidateRange ();
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
            case CommonPackage.SCALED_VALUE__SOURCE_ITEM:
                setSourceItem ( (InputDefinition)newValue );
                return;
            case CommonPackage.SCALED_VALUE__INPUT_MINIMUM:
                setInputMinimum ( (Double)newValue );
                return;
            case CommonPackage.SCALED_VALUE__INPUT_MAXIMUM:
                setInputMaximum ( (Double)newValue );
                return;
            case CommonPackage.SCALED_VALUE__OUTPUT_MINIMUM:
                setOutputMinimum ( (Double)newValue );
                return;
            case CommonPackage.SCALED_VALUE__OUTPUT_MAXIMUM:
                setOutputMaximum ( (Double)newValue );
                return;
            case CommonPackage.SCALED_VALUE__VALIDATE_RANGE:
                setValidateRange ( (Boolean)newValue );
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
            case CommonPackage.SCALED_VALUE__SOURCE_ITEM:
                setSourceItem ( (InputDefinition)null );
                return;
            case CommonPackage.SCALED_VALUE__INPUT_MINIMUM:
                setInputMinimum ( INPUT_MINIMUM_EDEFAULT );
                return;
            case CommonPackage.SCALED_VALUE__INPUT_MAXIMUM:
                setInputMaximum ( INPUT_MAXIMUM_EDEFAULT );
                return;
            case CommonPackage.SCALED_VALUE__OUTPUT_MINIMUM:
                setOutputMinimum ( OUTPUT_MINIMUM_EDEFAULT );
                return;
            case CommonPackage.SCALED_VALUE__OUTPUT_MAXIMUM:
                setOutputMaximum ( OUTPUT_MAXIMUM_EDEFAULT );
                return;
            case CommonPackage.SCALED_VALUE__VALIDATE_RANGE:
                setValidateRange ( VALIDATE_RANGE_EDEFAULT );
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
            case CommonPackage.SCALED_VALUE__SOURCE_ITEM:
                return sourceItem != null;
            case CommonPackage.SCALED_VALUE__INPUT_MINIMUM:
                return inputMinimum != INPUT_MINIMUM_EDEFAULT;
            case CommonPackage.SCALED_VALUE__INPUT_MAXIMUM:
                return inputMaximum != INPUT_MAXIMUM_EDEFAULT;
            case CommonPackage.SCALED_VALUE__OUTPUT_MINIMUM:
                return outputMinimum != OUTPUT_MINIMUM_EDEFAULT;
            case CommonPackage.SCALED_VALUE__OUTPUT_MAXIMUM:
                return outputMaximum != OUTPUT_MAXIMUM_EDEFAULT;
            case CommonPackage.SCALED_VALUE__VALIDATE_RANGE:
                return validateRange != VALIDATE_RANGE_EDEFAULT;
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
        result.append ( " (inputMinimum: " ); //$NON-NLS-1$
        result.append ( inputMinimum );
        result.append ( ", inputMaximum: " ); //$NON-NLS-1$
        result.append ( inputMaximum );
        result.append ( ", outputMinimum: " ); //$NON-NLS-1$
        result.append ( outputMinimum );
        result.append ( ", outputMaximum: " ); //$NON-NLS-1$
        result.append ( outputMaximum );
        result.append ( ", validateRange: " ); //$NON-NLS-1$
        result.append ( validateRange );
        result.append ( ')' );
        return result.toString ();
    }

} //ScaledValueImpl
