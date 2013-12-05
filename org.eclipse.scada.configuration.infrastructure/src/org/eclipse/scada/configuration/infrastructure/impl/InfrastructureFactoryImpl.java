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
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration;
import org.eclipse.scada.configuration.infrastructure.CommonDriver;
import org.eclipse.scada.configuration.infrastructure.Configurations;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder;
import org.eclipse.scada.configuration.infrastructure.ExternalNode;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.JdbcUserService;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.SystemNode;
import org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService;
import org.eclipse.scada.configuration.infrastructure.UserEntry;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;
import org.eclipse.scada.configuration.infrastructure.World;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class InfrastructureFactoryImpl extends EFactoryImpl implements InfrastructureFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static InfrastructureFactory init ()
    {
        try
        {
            final InfrastructureFactory theInfrastructureFactory = (InfrastructureFactory)EPackage.Registry.INSTANCE.getEFactory ( InfrastructurePackage.eNS_URI );
            if ( theInfrastructureFactory != null )
            {
                return theInfrastructureFactory;
            }
        }
        catch ( final Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new InfrastructureFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureFactoryImpl ()
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
            case InfrastructurePackage.WORLD:
                return createWorld ();
            case InfrastructurePackage.MASTER_SERVER:
                return createMasterServer ();
            case InfrastructurePackage.MASTER_IMPORT:
                return createMasterImport ();
            case InfrastructurePackage.OPTIONS:
                return createOptions ();
            case InfrastructurePackage.COMMON_DRIVER:
                return createCommonDriver ();
            case InfrastructurePackage.EXTERNAL_NODE:
                return createExternalNode ();
            case InfrastructurePackage.SYSTEM_NODE:
                return createSystemNode ();
            case InfrastructurePackage.SYSTEM_PROPERTY_USER_SERVICE:
                return createSystemPropertyUserService ();
            case InfrastructurePackage.USER_ENTRY:
                return createUserEntry ();
            case InfrastructurePackage.JDBC_USER_SERVICE:
                return createJdbcUserService ();
            case InfrastructurePackage.VALUE_ARCHIVE_SERVER:
                return createValueArchiveServer ();
            case InfrastructurePackage.EQUINOX_DRIVER:
                return createEquinoxDriver ();
            case InfrastructurePackage.EXTERNAL_DRIVER:
                return createExternalDriver ();
            case InfrastructurePackage.EXTERNAL_DRIVER_PLACEHOLDER:
                return createExternalDriverPlaceholder ();
            case InfrastructurePackage.APPLICATION_CONFIGURATION:
                return createApplicationConfiguration ();
            case InfrastructurePackage.CONFIGURATIONS:
                return createConfigurations ();
            case InfrastructurePackage.HTTP_SERVICE_MODULE:
                return createHttpServiceModule ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public World createWorld ()
    {
        final WorldImpl world = new WorldImpl ();
        world.setConfigurations ( InfrastructureFactory.eINSTANCE.createConfigurations () );
        return world;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MasterServer createMasterServer ()
    {
        final MasterServerImpl masterServer = new MasterServerImpl ();
        return masterServer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MasterImport createMasterImport ()
    {
        final MasterImportImpl masterImport = new MasterImportImpl ();
        return masterImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Options createOptions ()
    {
        final OptionsImpl options = new OptionsImpl ();
        return options;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CommonDriver createCommonDriver ()
    {
        final CommonDriverImpl commonDriver = new CommonDriverImpl ();
        return commonDriver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ExternalNode createExternalNode ()
    {
        final ExternalNodeImpl externalNode = new ExternalNodeImpl ();
        return externalNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SystemNode createSystemNode ()
    {
        final SystemNodeImpl systemNode = new SystemNodeImpl ();
        return systemNode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SystemPropertyUserService createSystemPropertyUserService ()
    {
        final SystemPropertyUserServiceImpl systemPropertyUserService = new SystemPropertyUserServiceImpl ();
        return systemPropertyUserService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public UserEntry createUserEntry ()
    {
        final UserEntryImpl userEntry = new UserEntryImpl ();
        return userEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public JdbcUserService createJdbcUserService ()
    {
        final JdbcUserServiceImpl jdbcUserService = new JdbcUserServiceImpl ();
        return jdbcUserService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ValueArchiveServer createValueArchiveServer ()
    {
        final ValueArchiveServerImpl valueArchiveServer = new ValueArchiveServerImpl ();
        return valueArchiveServer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EquinoxDriver createEquinoxDriver ()
    {
        final EquinoxDriverImpl equinoxDriver = new EquinoxDriverImpl ();
        return equinoxDriver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ExternalDriver createExternalDriver ()
    {
        final ExternalDriverImpl externalDriver = new ExternalDriverImpl ();
        return externalDriver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ExternalDriverPlaceholder createExternalDriverPlaceholder ()
    {
        final ExternalDriverPlaceholderImpl externalDriverPlaceholder = new ExternalDriverPlaceholderImpl ();
        return externalDriverPlaceholder;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ApplicationConfiguration createApplicationConfiguration ()
    {
        final ApplicationConfigurationImpl applicationConfiguration = new ApplicationConfigurationImpl ();
        return applicationConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Configurations createConfigurations ()
    {
        final ConfigurationsImpl configurations = new ConfigurationsImpl ();
        return configurations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public HttpServiceModule createHttpServiceModule ()
    {
        final HttpServiceModuleImpl httpServiceModule = new HttpServiceModuleImpl ();
        return httpServiceModule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructurePackage getInfrastructurePackage ()
    {
        return (InfrastructurePackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static InfrastructurePackage getPackage ()
    {
        return InfrastructurePackage.eINSTANCE;
    }

} //InfrastructureFactoryImpl
