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
import org.eclipse.scada.configuration.infrastructure.*;
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
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage
 * @generated
 */
public class InfrastructureValidator extends EObjectValidator
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final InfrastructureValidator INSTANCE = new InfrastructureValidator ();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.scada.configuration.infrastructure"; //$NON-NLS-1$

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * @generated
     */
    @Override
    protected EPackage getEPackage ()
    {
        return InfrastructurePackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate ( int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context )
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
            case InfrastructurePackage.ORACLE_VM_SETTINGS:
                return validateOracleVMSettings ( (OracleVMSettings)value, diagnostics, context );
            case InfrastructurePackage.GENERIC_VM_SETTINGS:
                return validateGenericVMSettings ( (GenericVMSettings)value, diagnostics, context );
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER:
                return validateAbstractEquinoxDriver ( (AbstractEquinoxDriver)value, diagnostics, context );
            case InfrastructurePackage.EQUINOX_BASE:
                return validateEquinoxBase ( (EquinoxBase)value, diagnostics, context );
            case InfrastructurePackage.ABSTRACT_COMMON_DRIVER:
                return validateAbstractCommonDriver ( (AbstractCommonDriver)value, diagnostics, context );
            case InfrastructurePackage.EVENT_INJECTOR_HTTP:
                return validateEventInjectorHttp ( (EventInjectorHttp)value, diagnostics, context );
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG:
                return validateEventInjectorSyslog ( (EventInjectorSyslog)value, diagnostics, context );
            case InfrastructurePackage.SLAVE_STORAGE_LAYOUT:
                return validateSlaveStorageLayout ( (SlaveStorageLayout)value, diagnostics, context );
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateWorld ( World world, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( world, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateNode ( Node node, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( node, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMasterServer ( MasterServer masterServer, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( masterServer, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateMasterImport ( MasterImport masterImport, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( masterImport, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOptions ( Options options, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( options, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEquinoxApplication ( EquinoxApplication equinoxApplication, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( equinoxApplication, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateCommonDriver ( CommonDriver commonDriver, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( commonDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExternalNode ( ExternalNode externalNode, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( externalNode, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSystemNode ( SystemNode systemNode, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( systemNode, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSystemPropertyUserService ( SystemPropertyUserService systemPropertyUserService, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( systemPropertyUserService, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUserEntry ( UserEntry userEntry, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( userEntry, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateUserService ( UserService userService, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( userService, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateJdbcUserService ( JdbcUserService jdbcUserService, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( jdbcUserService, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateValueArchiveServer ( ValueArchiveServer valueArchiveServer, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( valueArchiveServer, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAbstractFactoryDriver ( AbstractFactoryDriver abstractFactoryDriver, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( abstractFactoryDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDevice ( Device device, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( device, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEquinoxDriver ( EquinoxDriver equinoxDriver, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( equinoxDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExternalDriver ( ExternalDriver externalDriver, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( externalDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDriver ( Driver driver, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( driver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExternalDriverPlaceholder ( ExternalDriverPlaceholder externalDriverPlaceholder, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( externalDriverPlaceholder, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateApplicationConfiguration ( ApplicationConfiguration applicationConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( applicationConfiguration, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateConfigurations ( Configurations configurations, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( configurations, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateModule ( Module module, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( module, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateHttpServiceModule ( HttpServiceModule httpServiceModule, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( httpServiceModule, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateRestExporterModule ( RestExporterModule restExporterModule, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( restExporterModule, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateValueArchiveSlave ( ValueArchiveSlave valueArchiveSlave, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( valueArchiveSlave, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateWebAdminConsole ( WebAdminConsole webAdminConsole, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( webAdminConsole, diagnostics, context ) )
            return false;
        boolean result = validate_EveryMultiplicityConforms ( webAdminConsole, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryDataValueConforms ( webAdminConsole, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryReferenceIsContained ( webAdminConsole, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryBidirectionalReferenceIsPaired ( webAdminConsole, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryProxyResolves ( webAdminConsole, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_UniqueID ( webAdminConsole, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryKeyUnique ( webAdminConsole, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryMapEntryUnique ( webAdminConsole, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validateWebAdminConsole_httpService ( webAdminConsole, diagnostics, context );
        return result;
    }

    /**
     * Validates the httpService constraint of '<em>Web Admin Console</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateWebAdminConsole_httpService ( WebAdminConsole webAdminConsole, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if ( false )
        {
            if ( diagnostics != null )
            {
                diagnostics.add ( createDiagnostic ( Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] { "httpService", getObjectLabel ( webAdminConsole, context ) }, //$NON-NLS-1$
                        new Object[] { webAdminConsole }, context ) );
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateOracleVMSettings ( OracleVMSettings oracleVMSettings, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( oracleVMSettings, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateGenericVMSettings ( GenericVMSettings genericVMSettings, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( genericVMSettings, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAbstractEquinoxDriver ( AbstractEquinoxDriver abstractEquinoxDriver, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( abstractEquinoxDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEquinoxBase ( EquinoxBase equinoxBase, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( equinoxBase, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAbstractCommonDriver ( AbstractCommonDriver abstractCommonDriver, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( abstractCommonDriver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEventInjectorHttp ( EventInjectorHttp eventInjectorHttp, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( eventInjectorHttp, diagnostics, context ) )
            return false;
        boolean result = validate_EveryMultiplicityConforms ( eventInjectorHttp, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryDataValueConforms ( eventInjectorHttp, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryReferenceIsContained ( eventInjectorHttp, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryBidirectionalReferenceIsPaired ( eventInjectorHttp, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryProxyResolves ( eventInjectorHttp, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_UniqueID ( eventInjectorHttp, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryKeyUnique ( eventInjectorHttp, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryMapEntryUnique ( eventInjectorHttp, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validateEventInjectorHttp_httpService ( eventInjectorHttp, diagnostics, context );
        return result;
    }

    /**
     * Validates the httpService constraint of '<em>Event Injector Http</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEventInjectorHttp_httpService ( EventInjectorHttp eventInjectorHttp, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        // TODO implement the constraint
        // -> specify the condition that violates the constraint
        // -> verify the diagnostic details, including severity, code, and message
        // Ensure that you remove @generated or mark it @generated NOT
        if ( false )
        {
            if ( diagnostics != null )
            {
                diagnostics.add ( createDiagnostic ( Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0, "_UI_GenericConstraint_diagnostic", //$NON-NLS-1$
                        new Object[] { "httpService", getObjectLabel ( eventInjectorHttp, context ) }, //$NON-NLS-1$
                        new Object[] { eventInjectorHttp }, context ) );
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateEventInjectorSyslog ( EventInjectorSyslog eventInjectorSyslog, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( eventInjectorSyslog, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSlaveStorageLayout ( SlaveStorageLayout slaveStorageLayout, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return true;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
