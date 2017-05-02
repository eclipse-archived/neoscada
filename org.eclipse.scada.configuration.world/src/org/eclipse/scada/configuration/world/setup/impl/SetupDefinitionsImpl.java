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
package org.eclipse.scada.configuration.world.setup.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupDefinitions;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;
import org.eclipse.scada.configuration.world.setup.SetupPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.impl.SetupDefinitionsImpl#getContainers <em>Containers</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.impl.SetupDefinitionsImpl#getOperationSystemDefinitions <em>Operation System Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetupDefinitionsImpl extends MinimalEObjectImpl.Container implements SetupDefinitions
{
    /**
     * The cached value of the '{@link #getContainers() <em>Containers</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContainers()
     * @generated
     * @ordered
     */
    protected EList<SetupModuleContainer> containers;

    /**
     * The cached value of the '{@link #getOperationSystemDefinitions() <em>Operation System Definitions</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationSystemDefinitions()
     * @generated
     * @ordered
     */
    protected EList<OperatingSystemDescriptor> operationSystemDefinitions;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SetupDefinitionsImpl ()
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
        return SetupPackage.Literals.SETUP_DEFINITIONS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SetupModuleContainer> getContainers ()
    {
        if ( containers == null )
        {
            containers = new EObjectContainmentEList.Resolving<SetupModuleContainer> ( SetupModuleContainer.class, this, SetupPackage.SETUP_DEFINITIONS__CONTAINERS );
        }
        return containers;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OperatingSystemDescriptor> getOperationSystemDefinitions ()
    {
        if ( operationSystemDefinitions == null )
        {
            operationSystemDefinitions = new EObjectContainmentEList.Resolving<OperatingSystemDescriptor> ( OperatingSystemDescriptor.class, this, SetupPackage.SETUP_DEFINITIONS__OPERATION_SYSTEM_DEFINITIONS );
        }
        return operationSystemDefinitions;
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
            case SetupPackage.SETUP_DEFINITIONS__CONTAINERS:
                return ( (InternalEList<?>)getContainers () ).basicRemove ( otherEnd, msgs );
            case SetupPackage.SETUP_DEFINITIONS__OPERATION_SYSTEM_DEFINITIONS:
                return ( (InternalEList<?>)getOperationSystemDefinitions () ).basicRemove ( otherEnd, msgs );
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
            case SetupPackage.SETUP_DEFINITIONS__CONTAINERS:
                return getContainers ();
            case SetupPackage.SETUP_DEFINITIONS__OPERATION_SYSTEM_DEFINITIONS:
                return getOperationSystemDefinitions ();
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
            case SetupPackage.SETUP_DEFINITIONS__CONTAINERS:
                getContainers ().clear ();
                getContainers ().addAll ( (Collection<? extends SetupModuleContainer>)newValue );
                return;
            case SetupPackage.SETUP_DEFINITIONS__OPERATION_SYSTEM_DEFINITIONS:
                getOperationSystemDefinitions ().clear ();
                getOperationSystemDefinitions ().addAll ( (Collection<? extends OperatingSystemDescriptor>)newValue );
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
            case SetupPackage.SETUP_DEFINITIONS__CONTAINERS:
                getContainers ().clear ();
                return;
            case SetupPackage.SETUP_DEFINITIONS__OPERATION_SYSTEM_DEFINITIONS:
                getOperationSystemDefinitions ().clear ();
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
            case SetupPackage.SETUP_DEFINITIONS__CONTAINERS:
                return containers != null && !containers.isEmpty ();
            case SetupPackage.SETUP_DEFINITIONS__OPERATION_SYSTEM_DEFINITIONS:
                return operationSystemDefinitions != null && !operationSystemDefinitions.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //SetupDefinitionsImpl
