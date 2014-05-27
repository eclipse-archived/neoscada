/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.MappedSourceValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Source Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getMapper <em>Mapper</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappedSourceValueImpl extends SingleValueImpl implements MappedSourceValue
{
    /**
     * The cached value of the '{@link #getMapper() <em>Mapper</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMapper()
     * @generated
     * @ordered
     */
    protected DataMapperService mapper;

    /**
     * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInput()
     * @generated
     * @ordered
     */
    protected InputDefinition input;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MappedSourceValueImpl ()
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
        return ComponentPackage.Literals.MAPPED_SOURCE_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperService getMapper ()
    {
        if ( mapper != null && mapper.eIsProxy () )
        {
            InternalEObject oldMapper = (InternalEObject)mapper;
            mapper = (DataMapperService)eResolveProxy ( oldMapper );
            if ( mapper != oldMapper )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER, oldMapper, mapper ) );
            }
        }
        return mapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperService basicGetMapper ()
    {
        return mapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMapper ( DataMapperService newMapper )
    {
        DataMapperService oldMapper = mapper;
        mapper = newMapper;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER, oldMapper, mapper ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition getInput ()
    {
        if ( input != null && input.eIsProxy () )
        {
            InternalEObject oldInput = (InternalEObject)input;
            input = (InputDefinition)eResolveProxy ( oldInput );
            if ( input != oldInput )
            {
                InternalEObject newInput = (InternalEObject)input;
                NotificationChain msgs = oldInput.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, null );
                if ( newInput.eInternalContainer () == null )
                {
                    msgs = newInput.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, oldInput, input ) );
            }
        }
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition basicGetInput ()
    {
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInput ( InputDefinition newInput, NotificationChain msgs )
    {
        InputDefinition oldInput = input;
        input = newInput;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, oldInput, newInput );
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
    public void setInput ( InputDefinition newInput )
    {
        if ( newInput != input )
        {
            NotificationChain msgs = null;
            if ( input != null )
                msgs = ( (InternalEObject)input ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, msgs );
            if ( newInput != null )
                msgs = ( (InternalEObject)newInput ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, msgs );
            msgs = basicSetInput ( newInput, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, newInput, newInput ) );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                return basicSetInput ( null, msgs );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                if ( resolve )
                    return getMapper ();
                return basicGetMapper ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                if ( resolve )
                    return getInput ();
                return basicGetInput ();
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                setMapper ( (DataMapperService)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                setInput ( (InputDefinition)newValue );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                setMapper ( (DataMapperService)null );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                setInput ( (InputDefinition)null );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                return mapper != null;
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                return input != null;
        }
        return super.eIsSet ( featureID );
    }

} //MappedSourceValueImpl
