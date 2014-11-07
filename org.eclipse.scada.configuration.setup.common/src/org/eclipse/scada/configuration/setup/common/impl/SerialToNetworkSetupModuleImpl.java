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
package org.eclipse.scada.configuration.setup.common.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.validation.IValidationContext;

import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule;

import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serial To Network Setup Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkSetupModuleImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SerialToNetworkSetupModuleImpl extends MinimalEObjectImpl.Container implements SerialToNetworkSetupModule
{
    /**
     * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMappings()
     * @generated
     * @ordered
     */
    protected EList<SerialToNetworkMapping> mappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SerialToNetworkSetupModuleImpl ()
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
        return CommonPackage.Literals.SERIAL_TO_NETWORK_SETUP_MODULE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SerialToNetworkMapping> getMappings ()
    {
        if ( mappings == null )
        {
            mappings = new EObjectContainmentEList.Resolving<SerialToNetworkMapping> ( SerialToNetworkMapping.class, this, CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS );
        }
        return mappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IStatus validateOperatingSystem ( OperatingSystemDescriptor descriptor, IValidationContext context )
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
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS:
                return ( (InternalEList<?>)getMappings () ).basicRemove ( otherEnd, msgs );
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
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS:
                return getMappings ();
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
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS:
                getMappings ().clear ();
                getMappings ().addAll ( (Collection<? extends SerialToNetworkMapping>)newValue );
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
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS:
                getMappings ().clear ();
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
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS:
                return mappings != null && !mappings.isEmpty ();
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
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_IVALIDATIONCONTEXT_1:
                return validateOperatingSystem ( (OperatingSystemDescriptor)arguments.get ( 0 ), (IValidationContext)arguments.get ( 1 ) );
        }
        return super.eInvoke ( operationID, arguments );
    }

} //SerialToNetworkSetupModuleImpl
