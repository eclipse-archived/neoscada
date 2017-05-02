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
package org.eclipse.scada.configuration.item.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.item.Call;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.item.ItemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.item.impl.CallImpl#getPipeline <em>Pipeline</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallImpl extends StepImpl implements Call
{
    /**
     * The cached value of the '{@link #getPipeline() <em>Pipeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPipeline()
     * @generated
     * @ordered
     */
    protected CustomizationPipeline pipeline;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CallImpl ()
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
        return ItemPackage.Literals.CALL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomizationPipeline getPipeline ()
    {
        if ( pipeline != null && pipeline.eIsProxy () )
        {
            InternalEObject oldPipeline = (InternalEObject)pipeline;
            pipeline = (CustomizationPipeline)eResolveProxy ( oldPipeline );
            if ( pipeline != oldPipeline )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ItemPackage.CALL__PIPELINE, oldPipeline, pipeline ) );
            }
        }
        return pipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomizationPipeline basicGetPipeline ()
    {
        return pipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPipeline ( CustomizationPipeline newPipeline )
    {
        CustomizationPipeline oldPipeline = pipeline;
        pipeline = newPipeline;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ItemPackage.CALL__PIPELINE, oldPipeline, pipeline ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void execute ( final CustomizationRequest request )
    {
        getPipeline ().customize ( request );
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
            case ItemPackage.CALL__PIPELINE:
                if ( resolve )
                    return getPipeline ();
                return basicGetPipeline ();
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
            case ItemPackage.CALL__PIPELINE:
                setPipeline ( (CustomizationPipeline)newValue );
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
            case ItemPackage.CALL__PIPELINE:
                setPipeline ( (CustomizationPipeline)null );
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
            case ItemPackage.CALL__PIPELINE:
                return pipeline != null;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case ItemPackage.CALL___EXECUTE__CUSTOMIZATIONREQUEST:
                execute ( (CustomizationRequest)arguments.get ( 0 ) );
                return null;
        }
        return super.eInvoke ( operationID, arguments );
    }

} //CallImpl
