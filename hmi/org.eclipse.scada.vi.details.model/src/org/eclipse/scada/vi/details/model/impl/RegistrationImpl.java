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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.Registration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Registration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.RegistrationImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.RegistrationImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.RegistrationImpl#isAggregateState <em>Aggregate State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegistrationImpl extends EObjectImpl implements Registration
{
    /**
     * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected static final String KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected String key = KEY_EDEFAULT;

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
     * The default value of the '{@link #isAggregateState() <em>Aggregate State</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAggregateState()
     * @generated
     * @ordered
     */
    protected static final boolean AGGREGATE_STATE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isAggregateState() <em>Aggregate State</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAggregateState()
     * @generated
     * @ordered
     */
    protected boolean aggregateState = AGGREGATE_STATE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RegistrationImpl ()
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
        return DetailViewPackage.Literals.REGISTRATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getKey ()
    {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKey ( String newKey )
    {
        String oldKey = key;
        key = newKey;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.REGISTRATION__KEY, oldKey, key ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.REGISTRATION__DESCRIPTOR, oldDescriptor, descriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAggregateState ()
    {
        return aggregateState;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAggregateState ( boolean newAggregateState )
    {
        boolean oldAggregateState = aggregateState;
        aggregateState = newAggregateState;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.REGISTRATION__AGGREGATE_STATE, oldAggregateState, aggregateState ) );
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
            case DetailViewPackage.REGISTRATION__KEY:
                return getKey ();
            case DetailViewPackage.REGISTRATION__DESCRIPTOR:
                return getDescriptor ();
            case DetailViewPackage.REGISTRATION__AGGREGATE_STATE:
                return isAggregateState ();
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
            case DetailViewPackage.REGISTRATION__KEY:
                setKey ( (String)newValue );
                return;
            case DetailViewPackage.REGISTRATION__DESCRIPTOR:
                setDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.REGISTRATION__AGGREGATE_STATE:
                setAggregateState ( (Boolean)newValue );
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
            case DetailViewPackage.REGISTRATION__KEY:
                setKey ( KEY_EDEFAULT );
                return;
            case DetailViewPackage.REGISTRATION__DESCRIPTOR:
                setDescriptor ( DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.REGISTRATION__AGGREGATE_STATE:
                setAggregateState ( AGGREGATE_STATE_EDEFAULT );
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
            case DetailViewPackage.REGISTRATION__KEY:
                return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals ( key );
            case DetailViewPackage.REGISTRATION__DESCRIPTOR:
                return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals ( descriptor );
            case DetailViewPackage.REGISTRATION__AGGREGATE_STATE:
                return aggregateState != AGGREGATE_STATE_EDEFAULT;
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
        result.append ( " (key: " ); //$NON-NLS-1$
        result.append ( key );
        result.append ( ", descriptor: " ); //$NON-NLS-1$
        result.append ( descriptor );
        result.append ( ", aggregateState: " ); //$NON-NLS-1$
        result.append ( aggregateState );
        result.append ( ')' );
        return result.toString ();
    }

} //RegistrationImpl
