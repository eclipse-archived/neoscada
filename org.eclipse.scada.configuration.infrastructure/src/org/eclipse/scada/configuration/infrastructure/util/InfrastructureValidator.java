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
package org.eclipse.scada.configuration.infrastructure.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration;
import org.eclipse.scada.configuration.infrastructure.CommonDriver;
import org.eclipse.scada.configuration.infrastructure.Configurations;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.EquinoxApplication;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder;
import org.eclipse.scada.configuration.infrastructure.ExternalNode;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.JdbcUserService;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.RestExporterModule;
import org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout;
import org.eclipse.scada.configuration.infrastructure.SystemNode;
import org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService;
import org.eclipse.scada.configuration.infrastructure.UserEntry;
import org.eclipse.scada.configuration.infrastructure.UserService;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave;
import org.eclipse.scada.configuration.infrastructure.WebAdminConsole;
import org.eclipse.scada.configuration.infrastructure.World;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage
 * @generated
 */
public class InfrastructureValidator extends EObjectValidator
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public static final InfrastructureValidator INSTANCE = new InfrastructureValidator ();

    /**
     * A constant for the
     * {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
     * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes}
     * from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.scada.configuration.infrastructure"; //$NON-NLS-1$

    /**
     * A constant with a fixed name that can be used as the base value for
     * additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for
     * additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public InfrastructureValidator ()
    {
        super ();
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EPackage getEPackage ()
    {
        return InfrastructurePackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the
     * model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected boolean validate ( final int classifierID, final Object value, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        switch ( classifierID )
        {
            case InfrastructurePackage.WORLD:
                return validateWorld ( (World)value, diagnostics, context );
            case InfrastructurePackage.NODE:
                return validateNode ( (Node)value, diagnostics, context );
            case InfrastructurePackage.MASTER_SERVER:
                return validateMasterServer ( (MasterServer)value, diagnostics, context );
            case InfrastructurePackage.MASTER_IMPORT:
                return validateMasterImport ( (MasterImport)value, diagnostics, context );
            case InfrastructurePackage.OPTIONS:
                return validateOptions ( (Options)value, diagnostics, context );
            case InfrastructurePackage.EQUINOX_APPLICATION:
                return validateEquinoxApplication ( (EquinoxApplication)value, diagnostics, context );
            case InfrastructurePackage.COMMON_DRIVER:
                return validateCommonDriver ( (CommonDriver)value, diagnostics, context );
            case InfrastructurePackage.EXTERNAL_NODE:
                return validateExternalNode ( (ExternalNode)value, diagnostics, context );
            case InfrastructurePackage.SYSTEM_NODE:
                return validateSystemNode ( (SystemNode)value, diagnostics, context );
            case InfrastructurePackage.SYSTEM_PROPERTY_USER_SERVICE:
                return validateSystemPropertyUserService ( (SystemPropertyUserService)value, diagnostics, context );
            case InfrastructurePackage.USER_ENTRY:
                return validateUserEntry ( (UserEntry)value, diagnostics, context );
            case InfrastructurePackage.USER_SERVICE:
                return validateUserService ( (UserService)value, diagnostics, context );
            case InfrastructurePackage.JDBC_USER_SERVICE:
                return validateJdbcUserService ( (JdbcUserService)value, diagnostics, context );
            case InfrastructurePackage.VALUE_ARCHIVE_SERVER:
                return validateValueArchiveServer ( (ValueArchiveServer)value, diagnostics, context );
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER:
                return validateAbstractFactoryDriver ( (AbstractFactoryDriver)value, diagnostics, context );
            case InfrastructurePackage.DEVICE:
                return validateDevice ( (Device)value, diagnostics, context );
            case InfrastructurePackage.EQUINOX_DRIVER:
                return validateEquinoxDriver ( (EquinoxDriver)value, diagnostics, context );
            case InfrastructurePackage.EXTERNAL_DRIVER:
                return validateExternalDriver ( (ExternalDriver)value, diagnostics, context );
            case InfrastructurePackage.DRIVER:
                return validateDriver ( (Driver)value, diagnostics, context );
            case InfrastructurePackage.EXTERNAL_DRIVER_PLACEHOLDER:
                return validateExternalDriverPlaceholder ( (ExternalDriverPlaceholder)value, diagnostics, context );
            case InfrastructurePackage.APPLICATION_CONFIGURATION:
                return validateApplicationConfiguration ( (ApplicationConfiguration)value, diagnostics, context );
            case InfrastructurePackage.CONFIGURATIONS:
                return validateConfigurations ( (Configurations)value, diagnostics, context );
            case InfrastructurePackage.MODULE:
                return validateModule ( (Module)value, diagnostics, context );
            case InfrastructurePackage.HTTP_SERVICE_MODULE:
                return validateHttpServiceModule ( (HttpServiceModule)value, diagnostics, context );
            case InfrastructurePackage.REST_EXPORTER_MODULE:
                return validateRestExporterModule ( (RestExporterModule)value, diagnostics, context );
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE:
                return validateValueArchiveSlave ( (ValueArchiveSlave)value, diagnostics, context );
            case InfrastructurePackage.WEB_ADMIN_CONSOLE:
                return validateWebAdminConsole ( (WebAdminConsole)value, diagnostics, context );
            case InfrastructurePackage.SLAVE_STORAGE_LAYOUT:
                return validateSlaveStorageLayout ( (SlaveStorageLayout)value, diagnostics, context );
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateWorld ( final World world, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( world, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateNode ( final Node node, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( node, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateMasterServer ( final MasterServer masterServer, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( masterServer, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateMasterImport ( final MasterImport masterImport, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( masterImport, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateOptions ( final Options options, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( options, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateEquinoxApplication ( final EquinoxApplication equinoxApplication, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( equinoxApplication, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateCommonDriver ( final CommonDriver commonDriver, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( commonDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateExternalNode ( final ExternalNode externalNode, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( externalNode, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateSystemNode ( final SystemNode systemNode, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( systemNode, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateSystemPropertyUserService ( final SystemPropertyUserService systemPropertyUserService, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( systemPropertyUserService, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateUserEntry ( final UserEntry userEntry, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( userEntry, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateUserService ( final UserService userService, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( userService, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateJdbcUserService ( final JdbcUserService jdbcUserService, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( jdbcUserService, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateValueArchiveServer ( final ValueArchiveServer valueArchiveServer, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( valueArchiveServer, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateAbstractFactoryDriver ( final AbstractFactoryDriver abstractFactoryDriver, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( abstractFactoryDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateDevice ( final Device device, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( device, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateEquinoxDriver ( final EquinoxDriver equinoxDriver, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( equinoxDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateExternalDriver ( final ExternalDriver externalDriver, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( externalDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateDriver ( final Driver driver, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( driver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateExternalDriverPlaceholder ( final ExternalDriverPlaceholder externalDriverPlaceholder, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( externalDriverPlaceholder, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateApplicationConfiguration ( final ApplicationConfiguration applicationConfiguration, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( applicationConfiguration, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateConfigurations ( final Configurations configurations, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( configurations, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateModule ( final Module module, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( module, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateHttpServiceModule ( final HttpServiceModule httpServiceModule, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( httpServiceModule, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateRestExporterModule ( final RestExporterModule restExporterModule, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( restExporterModule, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateValueArchiveSlave ( final ValueArchiveSlave valueArchiveSlave, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( valueArchiveSlave, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateWebAdminConsole ( final WebAdminConsole webAdminConsole, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( webAdminConsole, diagnostics, context ) )
        {
            return false;
        }
        boolean result = validate_EveryMultiplicityConforms ( webAdminConsole, diagnostics, context );
        if ( result || diagnostics != null )
        {
            result &= validate_EveryDataValueConforms ( webAdminConsole, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryReferenceIsContained ( webAdminConsole, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryBidirectionalReferenceIsPaired ( webAdminConsole, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryProxyResolves ( webAdminConsole, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_UniqueID ( webAdminConsole, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryKeyUnique ( webAdminConsole, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryMapEntryUnique ( webAdminConsole, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validateWebAdminConsole_SameParent ( webAdminConsole, diagnostics, context );
        }
        return result;
    }

    /**
     * The cached validation expression for the SameParent constraint of '
     * <em>Web Admin Console</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected static final String WEB_ADMIN_CONSOLE__SAME_PARENT__EEXPRESSION = "httpService.oclContainer() = oclContainer()"; //$NON-NLS-1$

    /**
     * Validates the SameParent constraint of '<em>Web Admin Console</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateWebAdminConsole_SameParent ( final WebAdminConsole webAdminConsole, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return validate ( InfrastructurePackage.Literals.WEB_ADMIN_CONSOLE,
                webAdminConsole,
                diagnostics,
                context, "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$
                "SameParent", //$NON-NLS-1$
                WEB_ADMIN_CONSOLE__SAME_PARENT__EEXPRESSION,
                Diagnostic.ERROR,
                DIAGNOSTIC_SOURCE,
                0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validateSlaveStorageLayout ( final SlaveStorageLayout slaveStorageLayout, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return true;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this
     * validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator ();
    }

} //InfrastructureValidator
