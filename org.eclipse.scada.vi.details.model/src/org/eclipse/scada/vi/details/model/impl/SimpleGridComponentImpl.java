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
import org.eclipse.scada.vi.details.model.SimpleGridComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Grid Component</b></em>
 * '.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.SimpleGridComponentImpl#isEqually <em>Equally</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.SimpleGridComponentImpl#getCols <em>Cols</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleGridComponentImpl extends CompositeComponentImpl implements SimpleGridComponent
{
    /**
     * The default value of the '{@link #isEqually() <em>Equally</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEqually()
     * @generated
     * @ordered
     */
    protected static final boolean EQUALLY_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEqually() <em>Equally</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEqually()
     * @generated
     * @ordered
     */
    protected boolean equally = EQUALLY_EDEFAULT;

    /**
     * The default value of the '{@link #getCols() <em>Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCols()
     * @generated
     * @ordered
     */
    protected static final int COLS_EDEFAULT = 2;

    /**
     * The cached value of the '{@link #getCols() <em>Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCols()
     * @generated
     * @ordered
     */
    protected int cols = COLS_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SimpleGridComponentImpl ()
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
        return DetailViewPackage.Literals.SIMPLE_GRID_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEqually ()
    {
        return equally;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEqually ( boolean newEqually )
    {
        boolean oldEqually = equally;
        equally = newEqually;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.SIMPLE_GRID_COMPONENT__EQUALLY, oldEqually, equally ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getCols ()
    {
        return cols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCols ( int newCols )
    {
        int oldCols = cols;
        cols = newCols;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.SIMPLE_GRID_COMPONENT__COLS, oldCols, cols ) );
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
            case DetailViewPackage.SIMPLE_GRID_COMPONENT__EQUALLY:
                return isEqually ();
            case DetailViewPackage.SIMPLE_GRID_COMPONENT__COLS:
                return getCols ();
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
            case DetailViewPackage.SIMPLE_GRID_COMPONENT__EQUALLY:
                setEqually ( (Boolean)newValue );
                return;
            case DetailViewPackage.SIMPLE_GRID_COMPONENT__COLS:
                setCols ( (Integer)newValue );
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
            case DetailViewPackage.SIMPLE_GRID_COMPONENT__EQUALLY:
                setEqually ( EQUALLY_EDEFAULT );
                return;
            case DetailViewPackage.SIMPLE_GRID_COMPONENT__COLS:
                setCols ( COLS_EDEFAULT );
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
            case DetailViewPackage.SIMPLE_GRID_COMPONENT__EQUALLY:
                return equally != EQUALLY_EDEFAULT;
            case DetailViewPackage.SIMPLE_GRID_COMPONENT__COLS:
                return cols != COLS_EDEFAULT;
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
        result.append ( " (equally: " ); //$NON-NLS-1$
        result.append ( equally );
        result.append ( ", cols: " ); //$NON-NLS-1$
        result.append ( cols );
        result.append ( ')' );
        return result.toString ();
    }

} //SimpleGridComponentImpl
