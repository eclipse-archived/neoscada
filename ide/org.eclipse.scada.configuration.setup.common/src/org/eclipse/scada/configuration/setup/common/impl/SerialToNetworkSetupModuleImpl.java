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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.SerialToNetwork;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.utils.ExceptionHelper;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Serial To Network Setup Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkSetupModuleImpl#getMappings
 * <em>Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SerialToNetworkSetupModuleImpl extends MinimalEObjectImpl.Container implements SerialToNetworkSetupModule
{
    /**
     * The cached value of the '{@link #getMappings() <em>Mappings</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMappings()
     * @generated
     * @ordered
     */
    protected EList<SerialToNetworkMapping> mappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SerialToNetworkSetupModuleImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
     * 
     * @generated
     */
    @Override
    public EList<SerialToNetworkMapping> getMappings ()
    {
        if ( this.mappings == null )
        {
            this.mappings = new EObjectContainmentEList.Resolving<SerialToNetworkMapping> ( SerialToNetworkMapping.class, this, CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS );
        }
        return this.mappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public void validateOperatingSystem ( final OperatingSystemDescriptor descriptor, final ValidationContext context )
    {
        try
        {
            SerialToNetwork.validate ( this, descriptor );
        }
        catch ( final Exception e )
        {
            context.add ( ExceptionHelper.getMessage ( e ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( final InternalEObject otherEnd, final int featureID, final NotificationChain msgs )
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
     * 
     * @generated
     */
    @Override
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
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
     * 
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( final int featureID, final Object newValue )
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
     * 
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
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
     * 
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE__MAPPINGS:
                return this.mappings != null && !this.mappings.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eInvoke ( final int operationID, final EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT:
                validateOperatingSystem ( (OperatingSystemDescriptor)arguments.get ( 0 ), (ValidationContext)arguments.get ( 1 ) );
                return null;
        }
        return super.eInvoke ( operationID, arguments );
    }

} //SerialToNetworkSetupModuleImpl
