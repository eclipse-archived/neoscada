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
import org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Archive Quality Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.CompositeArchiveQualitySeriesImpl#getThreshold <em>Threshold</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeArchiveQualitySeriesImpl extends DataSeriesImpl implements
        CompositeArchiveQualitySeries
{
    /**
     * The default value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getThreshold()
     * @generated
     * @ordered
     */
    protected static final double THRESHOLD_EDEFAULT = 0.8;

    /**
     * The cached value of the '{@link #getThreshold() <em>Threshold</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getThreshold()
     * @generated
     * @ordered
     */
    protected double threshold = THRESHOLD_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CompositeArchiveQualitySeriesImpl ()
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
        return ChartPackage.Literals.COMPOSITE_ARCHIVE_QUALITY_SERIES;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getThreshold ()
    {
        return threshold;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setThreshold ( double newThreshold )
    {
        double oldThreshold = threshold;
        threshold = newThreshold;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.COMPOSITE_ARCHIVE_QUALITY_SERIES__THRESHOLD, oldThreshold, threshold ) );
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
            case ChartPackage.COMPOSITE_ARCHIVE_QUALITY_SERIES__THRESHOLD:
                return getThreshold ();
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
            case ChartPackage.COMPOSITE_ARCHIVE_QUALITY_SERIES__THRESHOLD:
                setThreshold ( (Double)newValue );
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
            case ChartPackage.COMPOSITE_ARCHIVE_QUALITY_SERIES__THRESHOLD:
                setThreshold ( THRESHOLD_EDEFAULT );
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
            case ChartPackage.COMPOSITE_ARCHIVE_QUALITY_SERIES__THRESHOLD:
                return threshold != THRESHOLD_EDEFAULT;
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
        result.append ( " (threshold: " ); //$NON-NLS-1$
        result.append ( threshold );
        result.append ( ')' );
        return result.toString ();
    }

} //CompositeArchiveQualitySeriesImpl
