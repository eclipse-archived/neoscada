/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentReferenceOutputDefinition;
import org.eclipse.scada.configuration.component.DanglingItemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Reference Output Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ComponentReferenceOutputDefinitionImpl#getComponent <em>Component</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentReferenceOutputDefinitionImpl extends OutputDefinitionImpl implements ComponentReferenceOutputDefinition
{
    /**
     * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComponent()
     * @generated
     * @ordered
     */
    protected Component component;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComponentReferenceOutputDefinitionImpl ()
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
        return ComponentPackage.Literals.COMPONENT_REFERENCE_OUTPUT_DEFINITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Component getComponent ()
    {
        if ( component != null && component.eIsProxy () )
        {
            InternalEObject oldComponent = (InternalEObject)component;
            component = (Component)eResolveProxy ( oldComponent );
            if ( component != oldComponent )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.COMPONENT_REFERENCE_OUTPUT_DEFINITION__COMPONENT, oldComponent, component ) );
            }
        }
        return component;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Component basicGetComponent ()
    {
        return component;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setComponent ( Component newComponent )
    {
        Component oldComponent = component;
        component = newComponent;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.COMPONENT_REFERENCE_OUTPUT_DEFINITION__COMPONENT, oldComponent, component ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DanglingItemReference createReference ()
    {
        final org.eclipse.scada.configuration.component.ComponentDanglingReference danglingRef = org.eclipse.scada.configuration.component.ComponentFactory.eINSTANCE.createComponentDanglingReference ();
        danglingRef.getLocalTag ().addAll ( getLocalTag () );
        danglingRef.setComponent ( getComponent () );
        return danglingRef;
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
            case ComponentPackage.COMPONENT_REFERENCE_OUTPUT_DEFINITION__COMPONENT:
                if ( resolve )
                    return getComponent ();
                return basicGetComponent ();
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
            case ComponentPackage.COMPONENT_REFERENCE_OUTPUT_DEFINITION__COMPONENT:
                setComponent ( (Component)newValue );
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
            case ComponentPackage.COMPONENT_REFERENCE_OUTPUT_DEFINITION__COMPONENT:
                setComponent ( (Component)null );
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
            case ComponentPackage.COMPONENT_REFERENCE_OUTPUT_DEFINITION__COMPONENT:
                return component != null;
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
            case ComponentPackage.COMPONENT_REFERENCE_OUTPUT_DEFINITION___CREATE_REFERENCE:
                return createReference ();
        }
        return super.eInvoke ( operationID, arguments );
    }

} //ComponentReferenceOutputDefinitionImpl
