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
package org.eclipse.scada.configuration.component.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DeltaValue;
import org.eclipse.scada.configuration.component.InputDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delta Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.DeltaValueImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeltaValueImpl extends SingleValueImpl implements DeltaValue
{
    /**
     * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
    protected InputDefinition source;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DeltaValueImpl ()
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
        return ComponentPackage.Literals.DELTA_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition getSource ()
    {
        if ( source != null && source.eIsProxy () )
        {
            InternalEObject oldSource = (InternalEObject)source;
            source = (InputDefinition)eResolveProxy ( oldSource );
            if ( source != oldSource )
            {
                InternalEObject newSource = (InternalEObject)source;
                NotificationChain msgs = oldSource.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.DELTA_VALUE__SOURCE, null, null );
                if ( newSource.eInternalContainer () == null )
                {
                    msgs = newSource.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.DELTA_VALUE__SOURCE, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.DELTA_VALUE__SOURCE, oldSource, source ) );
            }
        }
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition basicGetSource ()
    {
        return source;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSource ( InputDefinition newSource, NotificationChain msgs )
    {
        InputDefinition oldSource = source;
        source = newSource;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.DELTA_VALUE__SOURCE, oldSource, newSource );
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
    public void setSource ( InputDefinition newSource )
    {
        if ( newSource != source )
        {
            NotificationChain msgs = null;
            if ( source != null )
                msgs = ( (InternalEObject)source ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.DELTA_VALUE__SOURCE, null, msgs );
            if ( newSource != null )
                msgs = ( (InternalEObject)newSource ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.DELTA_VALUE__SOURCE, null, msgs );
            msgs = basicSetSource ( newSource, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.DELTA_VALUE__SOURCE, newSource, newSource ) );
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
            case ComponentPackage.DELTA_VALUE__SOURCE:
                return basicSetSource ( null, msgs );
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
            case ComponentPackage.DELTA_VALUE__SOURCE:
                if ( resolve )
                    return getSource ();
                return basicGetSource ();
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
            case ComponentPackage.DELTA_VALUE__SOURCE:
                setSource ( (InputDefinition)newValue );
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
            case ComponentPackage.DELTA_VALUE__SOURCE:
                setSource ( (InputDefinition)null );
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
            case ComponentPackage.DELTA_VALUE__SOURCE:
                return source != null;
        }
        return super.eIsSet ( featureID );
    }

} //DeltaValueImpl
