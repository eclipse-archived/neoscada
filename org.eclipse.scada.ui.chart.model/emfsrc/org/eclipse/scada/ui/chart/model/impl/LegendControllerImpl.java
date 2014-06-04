/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.ui.chart.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.LegendController;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Legend Controller</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.LegendControllerImpl#getTimestampFormat <em>Timestamp Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LegendControllerImpl extends ControllerImpl implements LegendController
{
    /**
     * The default value of the '{@link #getTimestampFormat() <em>Timestamp Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimestampFormat()
     * @generated
     * @ordered
     */
    protected static final String TIMESTAMP_FORMAT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTimestampFormat() <em>Timestamp Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimestampFormat()
     * @generated
     * @ordered
     */
    protected String timestampFormat = TIMESTAMP_FORMAT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LegendControllerImpl ()
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
        return ChartPackage.Literals.LEGEND_CONTROLLER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getTimestampFormat ()
    {
        return timestampFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTimestampFormat ( String newTimestampFormat )
    {
        String oldTimestampFormat = timestampFormat;
        timestampFormat = newTimestampFormat;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.LEGEND_CONTROLLER__TIMESTAMP_FORMAT, oldTimestampFormat, timestampFormat ) );
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
            case ChartPackage.LEGEND_CONTROLLER__TIMESTAMP_FORMAT:
                return getTimestampFormat ();
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
            case ChartPackage.LEGEND_CONTROLLER__TIMESTAMP_FORMAT:
                setTimestampFormat ( (String)newValue );
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
            case ChartPackage.LEGEND_CONTROLLER__TIMESTAMP_FORMAT:
                setTimestampFormat ( TIMESTAMP_FORMAT_EDEFAULT );
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
            case ChartPackage.LEGEND_CONTROLLER__TIMESTAMP_FORMAT:
                return TIMESTAMP_FORMAT_EDEFAULT == null ? timestampFormat != null : !TIMESTAMP_FORMAT_EDEFAULT.equals ( timestampFormat );
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
        result.append ( " (timestampFormat: " ); //$NON-NLS-1$
        result.append ( timestampFormat );
        result.append ( ')' );
        return result.toString ();
    }

} //LegendControllerImpl
