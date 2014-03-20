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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.component.common.CommonFactory;
import org.eclipse.scada.configuration.component.common.CommonPackage;
import org.eclipse.scada.configuration.component.common.CurrentTimeComponent;
import org.eclipse.scada.configuration.component.common.DateFormat;
import org.eclipse.scada.configuration.component.impl.MasterComponentImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Current Time Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.CurrentTimeComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.CurrentTimeComponentImpl#getUpdatePeriod <em>Update Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.impl.CurrentTimeComponentImpl#getDateFormat <em>Date Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CurrentTimeComponentImpl extends MasterComponentImpl implements CurrentTimeComponent
{
    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected EList<String> name;

    /**
     * The default value of the '{@link #getUpdatePeriod() <em>Update Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpdatePeriod()
     * @generated
     * @ordered
     */
    protected static final long UPDATE_PERIOD_EDEFAULT = 100L;

    /**
     * The cached value of the '{@link #getUpdatePeriod() <em>Update Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpdatePeriod()
     * @generated
     * @ordered
     */
    protected long updatePeriod = UPDATE_PERIOD_EDEFAULT;

    /**
     * The default value of the '{@link #getDateFormat() <em>Date Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDateFormat()
     * @generated
     * @ordered
     */
    protected static final DateFormat DATE_FORMAT_EDEFAULT = (DateFormat)CommonFactory.eINSTANCE.createFromString ( CommonPackage.eINSTANCE.getDateFormat (), "" );

    /**
     * The cached value of the '{@link #getDateFormat() <em>Date Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDateFormat()
     * @generated
     * @ordered
     */
    protected DateFormat dateFormat = DATE_FORMAT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CurrentTimeComponentImpl ()
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
        return CommonPackage.Literals.CURRENT_TIME_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getName ()
    {
        if ( name == null )
        {
            name = new EDataTypeUniqueEList<String> ( String.class, this, CommonPackage.CURRENT_TIME_COMPONENT__NAME );
        }
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getUpdatePeriod ()
    {
        return updatePeriod;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUpdatePeriod ( long newUpdatePeriod )
    {
        long oldUpdatePeriod = updatePeriod;
        updatePeriod = newUpdatePeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.CURRENT_TIME_COMPONENT__UPDATE_PERIOD, oldUpdatePeriod, updatePeriod ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DateFormat getDateFormat ()
    {
        return dateFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDateFormat ( DateFormat newDateFormat )
    {
        DateFormat oldDateFormat = dateFormat;
        dateFormat = newDateFormat;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.CURRENT_TIME_COMPONENT__DATE_FORMAT, oldDateFormat, dateFormat ) );
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
            case CommonPackage.CURRENT_TIME_COMPONENT__NAME:
                return getName ();
            case CommonPackage.CURRENT_TIME_COMPONENT__UPDATE_PERIOD:
                return getUpdatePeriod ();
            case CommonPackage.CURRENT_TIME_COMPONENT__DATE_FORMAT:
                return getDateFormat ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case CommonPackage.CURRENT_TIME_COMPONENT__NAME:
                getName ().clear ();
                getName ().addAll ( (Collection<? extends String>)newValue );
                return;
            case CommonPackage.CURRENT_TIME_COMPONENT__UPDATE_PERIOD:
                setUpdatePeriod ( (Long)newValue );
                return;
            case CommonPackage.CURRENT_TIME_COMPONENT__DATE_FORMAT:
                setDateFormat ( (DateFormat)newValue );
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
            case CommonPackage.CURRENT_TIME_COMPONENT__NAME:
                getName ().clear ();
                return;
            case CommonPackage.CURRENT_TIME_COMPONENT__UPDATE_PERIOD:
                setUpdatePeriod ( UPDATE_PERIOD_EDEFAULT );
                return;
            case CommonPackage.CURRENT_TIME_COMPONENT__DATE_FORMAT:
                setDateFormat ( DATE_FORMAT_EDEFAULT );
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
            case CommonPackage.CURRENT_TIME_COMPONENT__NAME:
                return name != null && !name.isEmpty ();
            case CommonPackage.CURRENT_TIME_COMPONENT__UPDATE_PERIOD:
                return updatePeriod != UPDATE_PERIOD_EDEFAULT;
            case CommonPackage.CURRENT_TIME_COMPONENT__DATE_FORMAT:
                return DATE_FORMAT_EDEFAULT == null ? dateFormat != null : !DATE_FORMAT_EDEFAULT.equals ( dateFormat );
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
        result.append ( ", updatePeriod: " ); //$NON-NLS-1$
        result.append ( updatePeriod );
        result.append ( ", dateFormat: " ); //$NON-NLS-1$
        result.append ( dateFormat );
        result.append ( ')' );
        return result.toString ();
    }

} //CurrentTimeComponentImpl
