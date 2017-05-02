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
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.item.CompositePipeline;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.item.ItemPackage;
import org.eclipse.scada.configuration.item.Step;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.item.impl.CompositePipelineImpl#getSteps <em>Steps</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.item.impl.CompositePipelineImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.item.impl.CompositePipelineImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositePipelineImpl extends MinimalEObjectImpl.Container implements CompositePipeline
{
    /**
     * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSteps()
     * @generated
     * @ordered
     */
    protected EList<Step> steps;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParent()
     * @generated
     * @ordered
     */
    protected CompositePipeline parent;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CompositePipelineImpl ()
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
        return ItemPackage.Literals.COMPOSITE_PIPELINE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Step> getSteps ()
    {
        if ( steps == null )
        {
            steps = new EObjectContainmentWithInverseEList.Resolving<Step> ( Step.class, this, ItemPackage.COMPOSITE_PIPELINE__STEPS, ItemPackage.STEP__CONTAINING_PIPELINE );
        }
        return steps;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ItemPackage.COMPOSITE_PIPELINE__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositePipeline getParent ()
    {
        if ( parent != null && parent.eIsProxy () )
        {
            InternalEObject oldParent = (InternalEObject)parent;
            parent = (CompositePipeline)eResolveProxy ( oldParent );
            if ( parent != oldParent )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ItemPackage.COMPOSITE_PIPELINE__PARENT, oldParent, parent ) );
            }
        }
        return parent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositePipeline basicGetParent ()
    {
        return parent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParent ( CompositePipeline newParent )
    {
        CompositePipeline oldParent = parent;
        parent = newParent;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ItemPackage.COMPOSITE_PIPELINE__PARENT, oldParent, parent ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void customize ( final CustomizationRequest request )
    {
        for ( Step step : getSteps () )
        {
            step.execute ( request );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ItemPackage.COMPOSITE_PIPELINE__STEPS:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getSteps () ).basicAdd ( otherEnd, msgs );
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
            case ItemPackage.COMPOSITE_PIPELINE__STEPS:
                return ( (InternalEList<?>)getSteps () ).basicRemove ( otherEnd, msgs );
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
            case ItemPackage.COMPOSITE_PIPELINE__STEPS:
                return getSteps ();
            case ItemPackage.COMPOSITE_PIPELINE__ID:
                return getId ();
            case ItemPackage.COMPOSITE_PIPELINE__PARENT:
                if ( resolve )
                    return getParent ();
                return basicGetParent ();
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
            case ItemPackage.COMPOSITE_PIPELINE__STEPS:
                getSteps ().clear ();
                getSteps ().addAll ( (Collection<? extends Step>)newValue );
                return;
            case ItemPackage.COMPOSITE_PIPELINE__ID:
                setId ( (String)newValue );
                return;
            case ItemPackage.COMPOSITE_PIPELINE__PARENT:
                setParent ( (CompositePipeline)newValue );
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
            case ItemPackage.COMPOSITE_PIPELINE__STEPS:
                getSteps ().clear ();
                return;
            case ItemPackage.COMPOSITE_PIPELINE__ID:
                setId ( ID_EDEFAULT );
                return;
            case ItemPackage.COMPOSITE_PIPELINE__PARENT:
                setParent ( (CompositePipeline)null );
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
            case ItemPackage.COMPOSITE_PIPELINE__STEPS:
                return steps != null && !steps.isEmpty ();
            case ItemPackage.COMPOSITE_PIPELINE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case ItemPackage.COMPOSITE_PIPELINE__PARENT:
                return parent != null;
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
            case ItemPackage.COMPOSITE_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST:
                customize ( (CustomizationRequest)arguments.get ( 0 ) );
                return null;
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ')' );
        return result.toString ();
    }

} //CompositePipelineImpl
