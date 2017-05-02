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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.item.CompositePipeline;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.item.ItemPackage;
import org.eclipse.scada.configuration.item.Step;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.item.impl.StepImpl#getContainingPipeline <em>Containing Pipeline</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StepImpl extends MinimalEObjectImpl.Container implements Step
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected StepImpl ()
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
        return ItemPackage.Literals.STEP;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositePipeline getContainingPipeline ()
    {
        if ( eContainerFeatureID () != ItemPackage.STEP__CONTAINING_PIPELINE )
            return null;
        return (CompositePipeline)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositePipeline basicGetContainingPipeline ()
    {
        if ( eContainerFeatureID () != ItemPackage.STEP__CONTAINING_PIPELINE )
            return null;
        return (CompositePipeline)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetContainingPipeline ( CompositePipeline newContainingPipeline, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newContainingPipeline, ItemPackage.STEP__CONTAINING_PIPELINE, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainingPipeline ( CompositePipeline newContainingPipeline )
    {
        if ( newContainingPipeline != eInternalContainer () || ( eContainerFeatureID () != ItemPackage.STEP__CONTAINING_PIPELINE && newContainingPipeline != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newContainingPipeline ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newContainingPipeline != null )
                msgs = ( (InternalEObject)newContainingPipeline ).eInverseAdd ( this, ItemPackage.COMPOSITE_PIPELINE__STEPS, CompositePipeline.class, msgs );
            msgs = basicSetContainingPipeline ( newContainingPipeline, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ItemPackage.STEP__CONTAINING_PIPELINE, newContainingPipeline, newContainingPipeline ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void execute ( CustomizationRequest request )
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ItemPackage.STEP__CONTAINING_PIPELINE:
                if ( eInternalContainer () != null )
                    msgs = eBasicRemoveFromContainer ( msgs );
                return basicSetContainingPipeline ( (CompositePipeline)otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
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
            case ItemPackage.STEP__CONTAINING_PIPELINE:
                return basicSetContainingPipeline ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature ( NotificationChain msgs )
    {
        switch ( eContainerFeatureID () )
        {
            case ItemPackage.STEP__CONTAINING_PIPELINE:
                return eInternalContainer ().eInverseRemove ( this, ItemPackage.COMPOSITE_PIPELINE__STEPS, CompositePipeline.class, msgs );
        }
        return super.eBasicRemoveFromContainerFeature ( msgs );
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
            case ItemPackage.STEP__CONTAINING_PIPELINE:
                if ( resolve )
                    return getContainingPipeline ();
                return basicGetContainingPipeline ();
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
            case ItemPackage.STEP__CONTAINING_PIPELINE:
                setContainingPipeline ( (CompositePipeline)newValue );
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
            case ItemPackage.STEP__CONTAINING_PIPELINE:
                setContainingPipeline ( (CompositePipeline)null );
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
            case ItemPackage.STEP__CONTAINING_PIPELINE:
                return basicGetContainingPipeline () != null;
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
            case ItemPackage.STEP___EXECUTE__CUSTOMIZATIONREQUEST:
                execute ( (CustomizationRequest)arguments.get ( 0 ) );
                return null;
        }
        return super.eInvoke ( operationID, arguments );
    }

} //StepImpl
