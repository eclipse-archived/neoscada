/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.scada.vi.model.Dimension;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.DimensionImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.DimensionImpl#getHeight <em>Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DimensionImpl extends EObjectImpl implements Dimension
{
    /**
     * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected static final double WIDTH_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected double width = WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected static final double HEIGHT_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected double height = HEIGHT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DimensionImpl ()
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
        return VisualInterfacePackage.Literals.DIMENSION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getWidth ()
    {
        return width;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWidth ( double newWidth )
    {
        double oldWidth = width;
        width = newWidth;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.DIMENSION__WIDTH, oldWidth, width ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public double getHeight ()
    {
        return height;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHeight ( double newHeight )
    {
        double oldHeight = height;
        height = newHeight;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.DIMENSION__HEIGHT, oldHeight, height ) );
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
            case VisualInterfacePackage.DIMENSION__WIDTH:
                return getWidth ();
            case VisualInterfacePackage.DIMENSION__HEIGHT:
                return getHeight ();
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
            case VisualInterfacePackage.DIMENSION__WIDTH:
                setWidth ( (Double)newValue );
                return;
            case VisualInterfacePackage.DIMENSION__HEIGHT:
                setHeight ( (Double)newValue );
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
            case VisualInterfacePackage.DIMENSION__WIDTH:
                setWidth ( WIDTH_EDEFAULT );
                return;
            case VisualInterfacePackage.DIMENSION__HEIGHT:
                setHeight ( HEIGHT_EDEFAULT );
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
            case VisualInterfacePackage.DIMENSION__WIDTH:
                return width != WIDTH_EDEFAULT;
            case VisualInterfacePackage.DIMENSION__HEIGHT:
                return height != HEIGHT_EDEFAULT;
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
        result.append ( " (width: " ); //$NON-NLS-1$
        result.append ( width );
        result.append ( ", height: " ); //$NON-NLS-1$
        result.append ( height );
        result.append ( ')' );
        return result.toString ();
    }

} //DimensionImpl
