/**
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution
 */
package org.eclipse.scada.ui.chart.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.CurrentTimeController;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Current Time Controller</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.CurrentTimeControllerImpl#getDiff <em>Diff</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.CurrentTimeControllerImpl#getAlignDateFormat <em>Align Date Format</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.CurrentTimeControllerImpl#getTimespan <em>Timespan</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CurrentTimeControllerImpl extends XAxisControllerImpl implements
        CurrentTimeController
{
    /**
     * The default value of the '{@link #getDiff() <em>Diff</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDiff()
     * @generated
     * @ordered
     */
    protected static final long DIFF_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getDiff() <em>Diff</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDiff()
     * @generated
     * @ordered
     */
    protected long diff = DIFF_EDEFAULT;

    /**
     * The default value of the '{@link #getAlignDateFormat() <em>Align Date Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlignDateFormat()
     * @generated
     * @ordered
     */
    protected static final String ALIGN_DATE_FORMAT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAlignDateFormat() <em>Align Date Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlignDateFormat()
     * @generated
     * @ordered
     */
    protected String alignDateFormat = ALIGN_DATE_FORMAT_EDEFAULT;

    /**
     * The default value of the '{@link #getTimespan() <em>Timespan</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimespan()
     * @generated
     * @ordered
     */
    protected static final Long TIMESPAN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTimespan() <em>Timespan</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimespan()
     * @generated
     * @ordered
     */
    protected Long timespan = TIMESPAN_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CurrentTimeControllerImpl ()
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
        return ChartPackage.Literals.CURRENT_TIME_CONTROLLER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getDiff ()
    {
        return diff;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDiff ( long newDiff )
    {
        long oldDiff = diff;
        diff = newDiff;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CURRENT_TIME_CONTROLLER__DIFF, oldDiff, diff ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAlignDateFormat ()
    {
        return alignDateFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAlignDateFormat ( String newAlignDateFormat )
    {
        String oldAlignDateFormat = alignDateFormat;
        alignDateFormat = newAlignDateFormat;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CURRENT_TIME_CONTROLLER__ALIGN_DATE_FORMAT, oldAlignDateFormat, alignDateFormat ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Long getTimespan ()
    {
        return timespan;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimespan ( Long newTimespan )
    {
        Long oldTimespan = timespan;
        timespan = newTimespan;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CURRENT_TIME_CONTROLLER__TIMESPAN, oldTimespan, timespan ) );
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
            case ChartPackage.CURRENT_TIME_CONTROLLER__DIFF:
                return getDiff ();
            case ChartPackage.CURRENT_TIME_CONTROLLER__ALIGN_DATE_FORMAT:
                return getAlignDateFormat ();
            case ChartPackage.CURRENT_TIME_CONTROLLER__TIMESPAN:
                return getTimespan ();
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
            case ChartPackage.CURRENT_TIME_CONTROLLER__DIFF:
                setDiff ( (Long)newValue );
                return;
            case ChartPackage.CURRENT_TIME_CONTROLLER__ALIGN_DATE_FORMAT:
                setAlignDateFormat ( (String)newValue );
                return;
            case ChartPackage.CURRENT_TIME_CONTROLLER__TIMESPAN:
                setTimespan ( (Long)newValue );
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
            case ChartPackage.CURRENT_TIME_CONTROLLER__DIFF:
                setDiff ( DIFF_EDEFAULT );
                return;
            case ChartPackage.CURRENT_TIME_CONTROLLER__ALIGN_DATE_FORMAT:
                setAlignDateFormat ( ALIGN_DATE_FORMAT_EDEFAULT );
                return;
            case ChartPackage.CURRENT_TIME_CONTROLLER__TIMESPAN:
                setTimespan ( TIMESPAN_EDEFAULT );
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
            case ChartPackage.CURRENT_TIME_CONTROLLER__DIFF:
                return diff != DIFF_EDEFAULT;
            case ChartPackage.CURRENT_TIME_CONTROLLER__ALIGN_DATE_FORMAT:
                return ALIGN_DATE_FORMAT_EDEFAULT == null ? alignDateFormat != null : !ALIGN_DATE_FORMAT_EDEFAULT.equals ( alignDateFormat );
            case ChartPackage.CURRENT_TIME_CONTROLLER__TIMESPAN:
                return TIMESPAN_EDEFAULT == null ? timespan != null : !TIMESPAN_EDEFAULT.equals ( timespan );
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
        result.append ( " (diff: " ); //$NON-NLS-1$
        result.append ( diff );
        result.append ( ", alignDateFormat: " ); //$NON-NLS-1$
        result.append ( alignDateFormat );
        result.append ( ", timespan: " ); //$NON-NLS-1$
        result.append ( timespan );
        result.append ( ')' );
        return result.toString ();
    }

} //CurrentTimeControllerImpl
