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
package org.eclipse.scada.configuration.world.impl;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.world.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorldFactoryImpl extends EFactoryImpl implements WorldFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static WorldFactory init ()
    {
        try
        {
            WorldFactory theWorldFactory = (WorldFactory)EPackage.Registry.INSTANCE.getEFactory ( WorldPackage.eNS_URI );
            if ( theWorldFactory != null )
            {
                return theWorldFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new WorldFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorldFactoryImpl ()
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
            case WorldPackage.WORLD:
                return createWorld ();
            case WorldPackage.APPLICATION_NODE:
                return createApplicationNode ();
            case WorldPackage.ENDPOINT:
                return createEndpoint ();
            case WorldPackage.EXEC_DRIVER:
                return createExecDriver ();
            case WorldPackage.HANDLER_PRIORITY_RULE:
                return createHandlerPriorityRule ();
            case WorldPackage.MASTER_HANDLER_PRIORITIES:
                return createMasterHandlerPriorities ();
            case WorldPackage.OPTIONS:
                return createOptions ();
            case WorldPackage.USERNAME_PASSWORD_CREDENTIALS:
                return createUsernamePasswordCredentials ();
            case WorldPackage.PASSWORD_CREDENTIALS:
                return createPasswordCredentials ();
            case WorldPackage.EXTERNAL_NODE:
                return createExternalNode ();
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
            case WorldPackage.PATTERN:
                return createPatternFromString ( eDataType, initialValue );
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
            case WorldPackage.PATTERN:
                return convertPatternToString ( eDataType, instanceValue );
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
    public World createWorld ()
    {
        WorldImpl world = new WorldImpl ();
        return world;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ApplicationNode createApplicationNode ()
    {
        ApplicationNodeImpl applicationNode = new ApplicationNodeImpl ();
        return applicationNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Endpoint createEndpoint ()
    {
        EndpointImpl endpoint = new EndpointImpl ();
        return endpoint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ExecDriver createExecDriver ()
    {
        ExecDriverImpl execDriver = new ExecDriverImpl ();
        return execDriver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public HandlerPriorityRule createHandlerPriorityRule ()
    {
        HandlerPriorityRuleImpl handlerPriorityRule = new HandlerPriorityRuleImpl ();
        return handlerPriorityRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MasterHandlerPriorities createMasterHandlerPriorities ()
    {
        MasterHandlerPrioritiesImpl masterHandlerPriorities = new MasterHandlerPrioritiesImpl ();
        return masterHandlerPriorities;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Options createOptions ()
    {
        OptionsImpl options = new OptionsImpl ();
        return options;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UsernamePasswordCredentials createUsernamePasswordCredentials ()
    {
        UsernamePasswordCredentialsImpl usernamePasswordCredentials = new UsernamePasswordCredentialsImpl ();
        return usernamePasswordCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PasswordCredentials createPasswordCredentials ()
    {
        PasswordCredentialsImpl passwordCredentials = new PasswordCredentialsImpl ();
        return passwordCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExternalNode createExternalNode ()
    {
        ExternalNodeImpl externalNode = new ExternalNodeImpl ();
        return externalNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Pattern createPatternFromString ( final EDataType eDataType,
            final String initialValue )
    {
        return Pattern.compile ( initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPatternToString ( EDataType eDataType,
            Object instanceValue )
    {
        return super.convertToString ( eDataType, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorldPackage getWorldPackage ()
    {
        return (WorldPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static WorldPackage getPackage ()
    {
        return WorldPackage.eINSTANCE;
    }

} //ConfigurationFactoryImpl
