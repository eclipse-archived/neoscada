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
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.DataSeries;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.DataSeriesImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.DataSeriesImpl#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.DataSeriesImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.DataSeriesImpl#isVisible <em>Visible</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DataSeriesImpl extends EObjectImpl implements DataSeries
{
    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The cached value of the '{@link #getX() <em>X</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getX()
     * @generated
     * @ordered
     */
    protected XAxis x;

    /**
     * The cached value of the '{@link #getY() <em>Y</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getY()
     * @generated
     * @ordered
     */
    protected YAxis y;

    /**
     * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected static final boolean VISIBLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected boolean visible = VISIBLE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataSeriesImpl ()
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
        return ChartPackage.Literals.DATA_SERIES;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLabel ()
    {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel ( String newLabel )
    {
        String oldLabel = label;
        label = newLabel;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.DATA_SERIES__LABEL, oldLabel, label ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XAxis getX ()
    {
        if ( x != null && x.eIsProxy () )
        {
            InternalEObject oldX = (InternalEObject)x;
            x = (XAxis)eResolveProxy ( oldX );
            if ( x != oldX )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ChartPackage.DATA_SERIES__X, oldX, x ) );
            }
        }
        return x;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XAxis basicGetX ()
    {
        return x;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setX ( XAxis newX )
    {
        XAxis oldX = x;
        x = newX;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.DATA_SERIES__X, oldX, x ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public YAxis getY ()
    {
        if ( y != null && y.eIsProxy () )
        {
            InternalEObject oldY = (InternalEObject)y;
            y = (YAxis)eResolveProxy ( oldY );
            if ( y != oldY )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ChartPackage.DATA_SERIES__Y, oldY, y ) );
            }
        }
        return y;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public YAxis basicGetY ()
    {
        return y;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setY ( YAxis newY )
    {
        YAxis oldY = y;
        y = newY;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.DATA_SERIES__Y, oldY, y ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isVisible ()
    {
        return visible;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVisible ( boolean newVisible )
    {
        boolean oldVisible = visible;
        visible = newVisible;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.DATA_SERIES__VISIBLE, oldVisible, visible ) );
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
            case ChartPackage.DATA_SERIES__LABEL:
                return getLabel ();
            case ChartPackage.DATA_SERIES__X:
                if ( resolve )
                    return getX ();
                return basicGetX ();
            case ChartPackage.DATA_SERIES__Y:
                if ( resolve )
                    return getY ();
                return basicGetY ();
            case ChartPackage.DATA_SERIES__VISIBLE:
                return isVisible ();
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
            case ChartPackage.DATA_SERIES__LABEL:
                setLabel ( (String)newValue );
                return;
            case ChartPackage.DATA_SERIES__X:
                setX ( (XAxis)newValue );
                return;
            case ChartPackage.DATA_SERIES__Y:
                setY ( (YAxis)newValue );
                return;
            case ChartPackage.DATA_SERIES__VISIBLE:
                setVisible ( (Boolean)newValue );
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
            case ChartPackage.DATA_SERIES__LABEL:
                setLabel ( LABEL_EDEFAULT );
                return;
            case ChartPackage.DATA_SERIES__X:
                setX ( (XAxis)null );
                return;
            case ChartPackage.DATA_SERIES__Y:
                setY ( (YAxis)null );
                return;
            case ChartPackage.DATA_SERIES__VISIBLE:
                setVisible ( VISIBLE_EDEFAULT );
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
            case ChartPackage.DATA_SERIES__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals ( label );
            case ChartPackage.DATA_SERIES__X:
                return x != null;
            case ChartPackage.DATA_SERIES__Y:
                return y != null;
            case ChartPackage.DATA_SERIES__VISIBLE:
                return visible != VISIBLE_EDEFAULT;
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
        result.append ( " (label: " ); //$NON-NLS-1$
        result.append ( label );
        result.append ( ", visible: " ); //$NON-NLS-1$
        result.append ( visible );
        result.append ( ')' );
        return result.toString ();
    }

} //DataSeriesImpl
