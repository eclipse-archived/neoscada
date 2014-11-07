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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.scada.configuration.setup.common.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonFactoryImpl extends EFactoryImpl implements CommonFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CommonFactory init ()
    {
        try
        {
            CommonFactory theCommonFactory = (CommonFactory)EPackage.Registry.INSTANCE.getEFactory ( CommonPackage.eNS_URI );
            if ( theCommonFactory != null )
            {
                return theCommonFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new CommonFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommonFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case CommonPackage.POSTGRES_SETUP_MODULE:
                return createPostgresSetupModule ();
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE:
                return createSerialToNetworkSetupModule ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING:
                return createSerialToNetworkMapping ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case CommonPackage.PARITY:
                return createParityFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case CommonPackage.PARITY:
                return convertParityToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PostgresSetupModule createPostgresSetupModule ()
    {
        PostgresSetupModuleImpl postgresSetupModule = new PostgresSetupModuleImpl ();
        return postgresSetupModule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SerialToNetworkSetupModule createSerialToNetworkSetupModule ()
    {
        SerialToNetworkSetupModuleImpl serialToNetworkSetupModule = new SerialToNetworkSetupModuleImpl ();
        return serialToNetworkSetupModule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SerialToNetworkMapping createSerialToNetworkMapping ()
    {
        SerialToNetworkMappingImpl serialToNetworkMapping = new SerialToNetworkMappingImpl ();
        return serialToNetworkMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parity createParityFromString ( EDataType eDataType, String initialValue )
    {
        Parity result = Parity.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertParityToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public CommonPackage getCommonPackage ()
    {
        return (CommonPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CommonPackage getPackage ()
    {
        return CommonPackage.eINSTANCE;
    }

} //CommonFactoryImpl
