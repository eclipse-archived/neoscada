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
import org.eclipse.scada.vi.details.model.WriteableComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Writeable Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.WriteableComponentImpl#getCeil <em>Ceil</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.WriteableComponentImpl#getFloor <em>Floor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WriteableComponentImpl extends ReadableComponentImpl implements WriteableComponent
{
    /**
     * The default value of the '{@link #getCeil() <em>Ceil</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCeil()
     * @generated
     * @ordered
     */
    protected static final Double CEIL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCeil() <em>Ceil</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCeil()
     * @generated
     * @ordered
     */
    protected Double ceil = CEIL_EDEFAULT;

    /**
     * The default value of the '{@link #getFloor() <em>Floor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFloor()
     * @generated
     * @ordered
     */
    protected static final double FLOOR_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getFloor() <em>Floor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFloor()
     * @generated
     * @ordered
     */
    protected double floor = FLOOR_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WriteableComponentImpl ()
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
        return DetailViewPackage.Literals.WRITEABLE_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Double getCeil ()
    {
        return ceil;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCeil ( Double newCeil )
    {
        Double oldCeil = ceil;
        ceil = newCeil;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.WRITEABLE_COMPONENT__CEIL, oldCeil, ceil ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getFloor ()
    {
        return floor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFloor ( double newFloor )
    {
        double oldFloor = floor;
        floor = newFloor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.WRITEABLE_COMPONENT__FLOOR, oldFloor, floor ) );
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
            case DetailViewPackage.WRITEABLE_COMPONENT__CEIL:
                return getCeil ();
            case DetailViewPackage.WRITEABLE_COMPONENT__FLOOR:
                return getFloor ();
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
            case DetailViewPackage.WRITEABLE_COMPONENT__CEIL:
                setCeil ( (Double)newValue );
                return;
            case DetailViewPackage.WRITEABLE_COMPONENT__FLOOR:
                setFloor ( (Double)newValue );
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
            case DetailViewPackage.WRITEABLE_COMPONENT__CEIL:
                setCeil ( CEIL_EDEFAULT );
                return;
            case DetailViewPackage.WRITEABLE_COMPONENT__FLOOR:
                setFloor ( FLOOR_EDEFAULT );
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
            case DetailViewPackage.WRITEABLE_COMPONENT__CEIL:
                return CEIL_EDEFAULT == null ? ceil != null : !CEIL_EDEFAULT.equals ( ceil );
            case DetailViewPackage.WRITEABLE_COMPONENT__FLOOR:
                return floor != FLOOR_EDEFAULT;
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
        result.append ( " (ceil: " ); //$NON-NLS-1$
        result.append ( ceil );
        result.append ( ", floor: " ); //$NON-NLS-1$
        result.append ( floor );
        result.append ( ')' );
        return result.toString ();
    }

} //WriteableComponentImpl
