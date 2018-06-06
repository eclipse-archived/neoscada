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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.vi.model.Dimension;
import org.eclipse.scada.vi.model.Position;
import org.eclipse.scada.vi.model.VisualInterfacePackage;
import org.eclipse.scada.vi.model.XYChild;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XY Child</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.XYChildImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.XYChildImpl#getDimension <em>Dimension</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XYChildImpl extends ChildImpl implements XYChild
{
    /**
     * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPosition()
     * @generated
     * @ordered
     */
    protected Position position;

    /**
     * The cached value of the '{@link #getDimension() <em>Dimension</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDimension()
     * @generated
     * @ordered
     */
    protected Dimension dimension;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected XYChildImpl ()
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
        return VisualInterfacePackage.Literals.XY_CHILD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Position getPosition ()
    {
        return position;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPosition ( Position newPosition, NotificationChain msgs )
    {
        Position oldPosition = position;
        position = newPosition;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.XY_CHILD__POSITION, oldPosition, newPosition );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPosition ( Position newPosition )
    {
        if ( newPosition != position )
        {
            NotificationChain msgs = null;
            if ( position != null )
                msgs = ( (InternalEObject)position ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.XY_CHILD__POSITION, null, msgs );
            if ( newPosition != null )
                msgs = ( (InternalEObject)newPosition ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.XY_CHILD__POSITION, null, msgs );
            msgs = basicSetPosition ( newPosition, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.XY_CHILD__POSITION, newPosition, newPosition ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Dimension getDimension ()
    {
        return dimension;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDimension ( Dimension newDimension, NotificationChain msgs )
    {
        Dimension oldDimension = dimension;
        dimension = newDimension;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.XY_CHILD__DIMENSION, oldDimension, newDimension );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDimension ( Dimension newDimension )
    {
        if ( newDimension != dimension )
        {
            NotificationChain msgs = null;
            if ( dimension != null )
                msgs = ( (InternalEObject)dimension ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.XY_CHILD__DIMENSION, null, msgs );
            if ( newDimension != null )
                msgs = ( (InternalEObject)newDimension ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.XY_CHILD__DIMENSION, null, msgs );
            msgs = basicSetDimension ( newDimension, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.XY_CHILD__DIMENSION, newDimension, newDimension ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.XY_CHILD__POSITION:
                return basicSetPosition ( null, msgs );
            case VisualInterfacePackage.XY_CHILD__DIMENSION:
                return basicSetDimension ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
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
            case VisualInterfacePackage.XY_CHILD__POSITION:
                return getPosition ();
            case VisualInterfacePackage.XY_CHILD__DIMENSION:
                return getDimension ();
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
            case VisualInterfacePackage.XY_CHILD__POSITION:
                setPosition ( (Position)newValue );
                return;
            case VisualInterfacePackage.XY_CHILD__DIMENSION:
                setDimension ( (Dimension)newValue );
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
            case VisualInterfacePackage.XY_CHILD__POSITION:
                setPosition ( (Position)null );
                return;
            case VisualInterfacePackage.XY_CHILD__DIMENSION:
                setDimension ( (Dimension)null );
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
            case VisualInterfacePackage.XY_CHILD__POSITION:
                return position != null;
            case VisualInterfacePackage.XY_CHILD__DIMENSION:
                return dimension != null;
        }
        return super.eIsSet ( featureID );
    }

} //XYChildImpl
