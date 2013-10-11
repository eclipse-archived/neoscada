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
import org.eclipse.scada.vi.details.model.ValueSetComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Set Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ValueSetComponentImpl#getValueDescriptor <em>Value Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ValueSetComponentImpl#getSetDescriptor <em>Set Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ValueSetComponentImpl#getResetDescriptor <em>Reset Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueSetComponentImpl extends WriteableComponentImpl implements ValueSetComponent
{
    /**
     * The default value of the '{@link #getValueDescriptor() <em>Value Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueDescriptor()
     * @generated
     * @ordered
     */
    protected static final String VALUE_DESCRIPTOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValueDescriptor() <em>Value Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueDescriptor()
     * @generated
     * @ordered
     */
    protected String valueDescriptor = VALUE_DESCRIPTOR_EDEFAULT;

    /**
     * The default value of the '{@link #getSetDescriptor() <em>Set Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSetDescriptor()
     * @generated
     * @ordered
     */
    protected static final String SET_DESCRIPTOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSetDescriptor() <em>Set Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSetDescriptor()
     * @generated
     * @ordered
     */
    protected String setDescriptor = SET_DESCRIPTOR_EDEFAULT;

    /**
     * The default value of the '{@link #getResetDescriptor() <em>Reset Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResetDescriptor()
     * @generated
     * @ordered
     */
    protected static final String RESET_DESCRIPTOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getResetDescriptor() <em>Reset Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getResetDescriptor()
     * @generated
     * @ordered
     */
    protected String resetDescriptor = RESET_DESCRIPTOR_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValueSetComponentImpl ()
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
        return DetailViewPackage.Literals.VALUE_SET_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValueDescriptor ()
    {
        return valueDescriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValueDescriptor ( String newValueDescriptor )
    {
        String oldValueDescriptor = valueDescriptor;
        valueDescriptor = newValueDescriptor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.VALUE_SET_COMPONENT__VALUE_DESCRIPTOR, oldValueDescriptor, valueDescriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSetDescriptor ()
    {
        return setDescriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSetDescriptor ( String newSetDescriptor )
    {
        String oldSetDescriptor = setDescriptor;
        setDescriptor = newSetDescriptor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.VALUE_SET_COMPONENT__SET_DESCRIPTOR, oldSetDescriptor, setDescriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getResetDescriptor ()
    {
        return resetDescriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setResetDescriptor ( String newResetDescriptor )
    {
        String oldResetDescriptor = resetDescriptor;
        resetDescriptor = newResetDescriptor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.VALUE_SET_COMPONENT__RESET_DESCRIPTOR, oldResetDescriptor, resetDescriptor ) );
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
            case DetailViewPackage.VALUE_SET_COMPONENT__VALUE_DESCRIPTOR:
                return getValueDescriptor ();
            case DetailViewPackage.VALUE_SET_COMPONENT__SET_DESCRIPTOR:
                return getSetDescriptor ();
            case DetailViewPackage.VALUE_SET_COMPONENT__RESET_DESCRIPTOR:
                return getResetDescriptor ();
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
            case DetailViewPackage.VALUE_SET_COMPONENT__VALUE_DESCRIPTOR:
                setValueDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.VALUE_SET_COMPONENT__SET_DESCRIPTOR:
                setSetDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.VALUE_SET_COMPONENT__RESET_DESCRIPTOR:
                setResetDescriptor ( (String)newValue );
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
            case DetailViewPackage.VALUE_SET_COMPONENT__VALUE_DESCRIPTOR:
                setValueDescriptor ( VALUE_DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.VALUE_SET_COMPONENT__SET_DESCRIPTOR:
                setSetDescriptor ( SET_DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.VALUE_SET_COMPONENT__RESET_DESCRIPTOR:
                setResetDescriptor ( RESET_DESCRIPTOR_EDEFAULT );
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
            case DetailViewPackage.VALUE_SET_COMPONENT__VALUE_DESCRIPTOR:
                return VALUE_DESCRIPTOR_EDEFAULT == null ? valueDescriptor != null : !VALUE_DESCRIPTOR_EDEFAULT.equals ( valueDescriptor );
            case DetailViewPackage.VALUE_SET_COMPONENT__SET_DESCRIPTOR:
                return SET_DESCRIPTOR_EDEFAULT == null ? setDescriptor != null : !SET_DESCRIPTOR_EDEFAULT.equals ( setDescriptor );
            case DetailViewPackage.VALUE_SET_COMPONENT__RESET_DESCRIPTOR:
                return RESET_DESCRIPTOR_EDEFAULT == null ? resetDescriptor != null : !RESET_DESCRIPTOR_EDEFAULT.equals ( resetDescriptor );
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
        result.append ( " (valueDescriptor: " ); //$NON-NLS-1$
        result.append ( valueDescriptor );
        result.append ( ", setDescriptor: " ); //$NON-NLS-1$
        result.append ( setDescriptor );
        result.append ( ", resetDescriptor: " ); //$NON-NLS-1$
        result.append ( resetDescriptor );
        result.append ( ')' );
        return result.toString ();
    }

} //ValueSetComponentImpl
