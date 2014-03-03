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
import org.eclipse.scada.configuration.world.deployment.Architecture;
import org.eclipse.scada.configuration.world.deployment.Author;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentFactory;
import org.eclipse.scada.configuration.world.deployment.DeploymentInformation;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry;
import org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode;
import org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.NodeMappings;
import org.eclipse.scada.configuration.world.deployment.P2Platform;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DeploymentFactoryImpl extends EFactoryImpl implements
        DeploymentFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static DeploymentFactory init ()
    {
        try
        {
            final DeploymentFactory theDeploymentFactory = (DeploymentFactory)EPackage.Registry.INSTANCE.getEFactory ( DeploymentPackage.eNS_URI );
            if ( theDeploymentFactory != null )
            {
                return theDeploymentFactory;
            }
        }
        catch ( final Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new DeploymentFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public DeploymentFactoryImpl ()
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
    public EObject create ( final EClass eClass )
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
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object createFromString ( final EDataType eDataType, final String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case DeploymentPackage.FALLBACK_NODE_MAPPING_MODE:
                return createFallbackNodeMappingModeFromString ( eDataType, initialValue );
            case DeploymentPackage.ARCHITECTURE:
                return createArchitectureFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String convertToString ( final EDataType eDataType, final Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case DeploymentPackage.FALLBACK_NODE_MAPPING_MODE:
                return convertFallbackNodeMappingModeToString ( eDataType, instanceValue );
            case DeploymentPackage.ARCHITECTURE:
                return convertArchitectureToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DebianDeploymentMechanism createDebianDeploymentMechanism ()
    {
        final DebianDeploymentMechanismImpl debianDeploymentMechanism = new DebianDeploymentMechanismImpl ();
        return debianDeploymentMechanism;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Author createAuthor ()
    {
        final AuthorImpl author = new AuthorImpl ();
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RedhatDeploymentMechanism createRedhatDeploymentMechanism ()
    {
        final RedhatDeploymentMechanismImpl redhatDeploymentMechanism = new RedhatDeploymentMechanismImpl ();
        return redhatDeploymentMechanism;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DeploymentInformation createDeploymentInformation ()
    {
        final DeploymentInformationImpl deploymentInformation = new DeploymentInformationImpl ();
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
     * 
     * @generated
     */
    @Override
    public NodeMappings createNodeMappings ()
    {
        final NodeMappingsImpl nodeMappings = new NodeMappingsImpl ();
        return nodeMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ExpressionNodeMappingEntry createExpressionNodeMappingEntry ()
    {
        final ExpressionNodeMappingEntryImpl expressionNodeMappingEntry = new ExpressionNodeMappingEntryImpl ();
        return expressionNodeMappingEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SimpleNodeMappingEntry createSimpleNodeMappingEntry ()
    {
        final SimpleNodeMappingEntryImpl simpleNodeMappingEntry = new SimpleNodeMappingEntryImpl ();
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
     * 
     * @generated
     */
    @Override
    public P2Platform createP2Platform ()
    {
        final P2PlatformImpl p2Platform = new P2PlatformImpl ();
        return p2Platform;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public FallbackNodeMappingMode createFallbackNodeMappingModeFromString (
            final EDataType eDataType, final String initialValue )
    {
        final FallbackNodeMappingMode result = FallbackNodeMappingMode.get ( initialValue );
        if ( result == null )
        {
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertFallbackNodeMappingModeToString ( final EDataType eDataType, final Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Architecture createArchitectureFromString ( final EDataType eDataType, final String initialValue )
    {
        final Architecture result = Architecture.get ( initialValue );
        if ( result == null )
        {
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertArchitectureToString ( final EDataType eDataType, final Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DeploymentPackage getPackage ()
    {
        return DeploymentPackage.eINSTANCE;
    }

} //DeploymentFactoryImpl
