/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.deployment.impl;

import java.util.UUID;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.world.deployment.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeploymentFactoryImpl extends EFactoryImpl implements DeploymentFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DeploymentFactory init ()
    {
        try
        {
            DeploymentFactory theDeploymentFactory = (DeploymentFactory)EPackage.Registry.INSTANCE.getEFactory ( DeploymentPackage.eNS_URI );
            if ( theDeploymentFactory != null )
            {
                return theDeploymentFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new DeploymentFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeploymentFactoryImpl ()
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
            case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM:
                return createDebianDeploymentMechanism ();
            case DeploymentPackage.AUTHOR:
                return createAuthor ();
            case DeploymentPackage.REDHAT_DEPLOYMENT_MECHANISM:
                return createRedhatDeploymentMechanism ();
            case DeploymentPackage.DEPLOYMENT_INFORMATION:
                return createDeploymentInformation ();
            case DeploymentPackage.CHANGE_ENTRY:
                return createChangeEntry ();
            case DeploymentPackage.NODE_MAPPINGS:
                return createNodeMappings ();
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY:
                return createExpressionNodeMappingEntry ();
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY:
                return createSimpleNodeMappingEntry ();
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM:
                return createMsiDeploymentMechanism ();
            case DeploymentPackage.P2_PLATFORM:
                return createP2Platform ();
            case DeploymentPackage.MAPPINGS:
                return createMappings ();
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
            case DeploymentPackage.FALLBACK_MAPPING_MODE:
                return createFallbackMappingModeFromString ( eDataType, initialValue );
            case DeploymentPackage.ARCHITECTURE:
                return createArchitectureFromString ( eDataType, initialValue );
            case DeploymentPackage.STARTUP_MECHANISM:
                return createStartupMechanismFromString ( eDataType, initialValue );
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
            case DeploymentPackage.FALLBACK_MAPPING_MODE:
                return convertFallbackMappingModeToString ( eDataType, instanceValue );
            case DeploymentPackage.ARCHITECTURE:
                return convertArchitectureToString ( eDataType, instanceValue );
            case DeploymentPackage.STARTUP_MECHANISM:
                return convertStartupMechanismToString ( eDataType, instanceValue );
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
    public DebianDeploymentMechanism createDebianDeploymentMechanism ()
    {
        DebianDeploymentMechanismImpl debianDeploymentMechanism = new DebianDeploymentMechanismImpl ();
        return debianDeploymentMechanism;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Author createAuthor ()
    {
        AuthorImpl author = new AuthorImpl ();
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public RedhatDeploymentMechanism createRedhatDeploymentMechanism ()
    {
        RedhatDeploymentMechanismImpl redhatDeploymentMechanism = new RedhatDeploymentMechanismImpl ();
        return redhatDeploymentMechanism;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DeploymentInformation createDeploymentInformation ()
    {
        DeploymentInformationImpl deploymentInformation = new DeploymentInformationImpl ();
        return deploymentInformation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public ChangeEntry createChangeEntry ()
    {
        final ChangeEntryImpl changeEntry = new ChangeEntryImpl ();
        changeEntry.setDate ( new java.util.Date () );
        return changeEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NodeMappings createNodeMappings ()
    {
        NodeMappingsImpl nodeMappings = new NodeMappingsImpl ();
        return nodeMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ExpressionNodeMappingEntry createExpressionNodeMappingEntry ()
    {
        ExpressionNodeMappingEntryImpl expressionNodeMappingEntry = new ExpressionNodeMappingEntryImpl ();
        return expressionNodeMappingEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public SimpleNodeMappingEntry createSimpleNodeMappingEntry ()
    {
        SimpleNodeMappingEntryImpl simpleNodeMappingEntry = new SimpleNodeMappingEntryImpl ();
        return simpleNodeMappingEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public MsiDeploymentMechanism createMsiDeploymentMechanism ()
    {
        final MsiDeploymentMechanismImpl msiDeploymentMechanism = new MsiDeploymentMechanismImpl ();

        // we initialize this with a random UUID
        msiDeploymentMechanism.setUpgradeCode ( UUID.randomUUID ().toString () );

        return msiDeploymentMechanism;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public P2Platform createP2Platform ()
    {
        P2PlatformImpl p2Platform = new P2PlatformImpl ();
        return p2Platform;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Mappings createMappings ()
    {
        MappingsImpl mappings = new MappingsImpl ();
        return mappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FallbackMappingMode createFallbackMappingModeFromString ( EDataType eDataType, String initialValue )
    {
        FallbackMappingMode result = FallbackMappingMode.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertFallbackMappingModeToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Architecture createArchitectureFromString ( EDataType eDataType, String initialValue )
    {
        Architecture result = Architecture.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertArchitectureToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StartupMechanism createStartupMechanismFromString ( EDataType eDataType, String initialValue )
    {
        StartupMechanism result = StartupMechanism.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertStartupMechanismToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DeploymentPackage getDeploymentPackage ()
    {
        return (DeploymentPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DeploymentPackage getPackage ()
    {
        return DeploymentPackage.eINSTANCE;
    }

} //DeploymentFactoryImpl
