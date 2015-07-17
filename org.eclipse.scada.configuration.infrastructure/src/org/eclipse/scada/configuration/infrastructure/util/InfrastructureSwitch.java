/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver;
import org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.AbstractFactoryDriver;
import org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration;
import org.eclipse.scada.configuration.infrastructure.CommonDriver;
import org.eclipse.scada.configuration.infrastructure.ConfigurationAdminFileBackend;
import org.eclipse.scada.configuration.infrastructure.Configurations;
import org.eclipse.scada.configuration.infrastructure.DSFileBackend;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.EquinoxApplication;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.EquinoxModule;
import org.eclipse.scada.configuration.infrastructure.EventInjectorHttp;
import org.eclipse.scada.configuration.infrastructure.EventInjectorSyslog;
import org.eclipse.scada.configuration.infrastructure.ExternalDriver;
import org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder;
import org.eclipse.scada.configuration.infrastructure.ExternalNode;
import org.eclipse.scada.configuration.infrastructure.GenericVMSettings;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.JMXSettings;
import org.eclipse.scada.configuration.infrastructure.JavaModule;
import org.eclipse.scada.configuration.infrastructure.JdbcUserService;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.Module;
import org.eclipse.scada.configuration.infrastructure.NamedApplication;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.OracleVMSettings;
import org.eclipse.scada.configuration.infrastructure.RestExporterModule;
import org.eclipse.scada.configuration.infrastructure.SystemNode;
import org.eclipse.scada.configuration.infrastructure.SystemPropertyUserService;
import org.eclipse.scada.configuration.infrastructure.UserEntry;
import org.eclipse.scada.configuration.infrastructure.UserService;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave;
import org.eclipse.scada.configuration.infrastructure.WebAdminConsole;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.NamedDocumentable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage
 * @generated
 */
public class InfrastructureSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static InfrastructurePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public InfrastructureSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = InfrastructurePackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( final EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code>
     *         call.
     * @generated
     */
    @Override
    protected T doSwitch ( final int classifierID, final EObject theEObject )
    {
        switch ( classifierID )
        {
            case InfrastructurePackage.WORLD:
            {
                final World world = (World)theEObject;
                T result = caseWorld ( world );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.NODE:
            {
                final Node node = (Node)theEObject;
                T result = caseNode ( node );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( node );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( node );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.MASTER_SERVER:
            {
                final MasterServer masterServer = (MasterServer)theEObject;
                T result = caseMasterServer ( masterServer );
                if ( result == null )
                {
                    result = caseEquinoxApplication ( masterServer );
                }
                if ( result == null )
                {
                    result = caseEquinoxBase ( masterServer );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( masterServer );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.MASTER_IMPORT:
            {
                final MasterImport masterImport = (MasterImport)theEObject;
                T result = caseMasterImport ( masterImport );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.OPTIONS:
            {
                final Options options = (Options)theEObject;
                T result = caseOptions ( options );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.EQUINOX_APPLICATION:
            {
                final EquinoxApplication equinoxApplication = (EquinoxApplication)theEObject;
                T result = caseEquinoxApplication ( equinoxApplication );
                if ( result == null )
                {
                    result = caseEquinoxBase ( equinoxApplication );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( equinoxApplication );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.COMMON_DRIVER:
            {
                final CommonDriver commonDriver = (CommonDriver)theEObject;
                T result = caseCommonDriver ( commonDriver );
                if ( result == null )
                {
                    result = caseAbstractFactoryDriver ( commonDriver );
                }
                if ( result == null )
                {
                    result = caseDriver ( commonDriver );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( commonDriver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.EXTERNAL_NODE:
            {
                final ExternalNode externalNode = (ExternalNode)theEObject;
                T result = caseExternalNode ( externalNode );
                if ( result == null )
                {
                    result = caseNode ( externalNode );
                }
                if ( result == null )
                {
                    result = caseNamedDocumentable ( externalNode );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( externalNode );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.SYSTEM_NODE:
            {
                final SystemNode systemNode = (SystemNode)theEObject;
                T result = caseSystemNode ( systemNode );
                if ( result == null )
                {
                    result = caseNode ( systemNode );
                }
                if ( result == null )
                {
                    result = caseNamedDocumentable ( systemNode );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( systemNode );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.SYSTEM_PROPERTY_USER_SERVICE:
            {
                final SystemPropertyUserService systemPropertyUserService = (SystemPropertyUserService)theEObject;
                T result = caseSystemPropertyUserService ( systemPropertyUserService );
                if ( result == null )
                {
                    result = caseUserService ( systemPropertyUserService );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.USER_ENTRY:
            {
                final UserEntry userEntry = (UserEntry)theEObject;
                T result = caseUserEntry ( userEntry );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.USER_SERVICE:
            {
                final UserService userService = (UserService)theEObject;
                T result = caseUserService ( userService );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.JDBC_USER_SERVICE:
            {
                final JdbcUserService jdbcUserService = (JdbcUserService)theEObject;
                T result = caseJdbcUserService ( jdbcUserService );
                if ( result == null )
                {
                    result = caseUserService ( jdbcUserService );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.VALUE_ARCHIVE_SERVER:
            {
                final ValueArchiveServer valueArchiveServer = (ValueArchiveServer)theEObject;
                T result = caseValueArchiveServer ( valueArchiveServer );
                if ( result == null )
                {
                    result = caseEquinoxApplication ( valueArchiveServer );
                }
                if ( result == null )
                {
                    result = caseEquinoxBase ( valueArchiveServer );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( valueArchiveServer );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.ABSTRACT_FACTORY_DRIVER:
            {
                final AbstractFactoryDriver abstractFactoryDriver = (AbstractFactoryDriver)theEObject;
                T result = caseAbstractFactoryDriver ( abstractFactoryDriver );
                if ( result == null )
                {
                    result = caseDriver ( abstractFactoryDriver );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( abstractFactoryDriver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.DEVICE:
            {
                final Device device = (Device)theEObject;
                T result = caseDevice ( device );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( device );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( device );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.EQUINOX_DRIVER:
            {
                final EquinoxDriver equinoxDriver = (EquinoxDriver)theEObject;
                T result = caseEquinoxDriver ( equinoxDriver );
                if ( result == null )
                {
                    result = caseAbstractFactoryDriver ( equinoxDriver );
                }
                if ( result == null )
                {
                    result = caseEquinoxBase ( equinoxDriver );
                }
                if ( result == null )
                {
                    result = caseDriver ( equinoxDriver );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( equinoxDriver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.EXTERNAL_DRIVER:
            {
                final ExternalDriver externalDriver = (ExternalDriver)theEObject;
                T result = caseExternalDriver ( externalDriver );
                if ( result == null )
                {
                    result = caseDriver ( externalDriver );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( externalDriver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.DRIVER:
            {
                final Driver driver = (Driver)theEObject;
                T result = caseDriver ( driver );
                if ( result == null )
                {
                    result = caseNamedApplication ( driver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.EXTERNAL_DRIVER_PLACEHOLDER:
            {
                final ExternalDriverPlaceholder externalDriverPlaceholder = (ExternalDriverPlaceholder)theEObject;
                T result = caseExternalDriverPlaceholder ( externalDriverPlaceholder );
                if ( result == null )
                {
                    result = caseWorld_Driver ( externalDriverPlaceholder );
                }
                if ( result == null )
                {
                    result = caseApplication ( externalDriverPlaceholder );
                }
                if ( result == null )
                {
                    result = caseNamedDocumentable ( externalDriverPlaceholder );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( externalDriverPlaceholder );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.APPLICATION_CONFIGURATION:
            {
                final ApplicationConfiguration applicationConfiguration = (ApplicationConfiguration)theEObject;
                T result = caseApplicationConfiguration ( applicationConfiguration );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( applicationConfiguration );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( applicationConfiguration );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.CONFIGURATIONS:
            {
                final Configurations configurations = (Configurations)theEObject;
                T result = caseConfigurations ( configurations );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.MODULE:
            {
                final Module module = (Module)theEObject;
                T result = caseModule ( module );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.HTTP_SERVICE_MODULE:
            {
                final HttpServiceModule httpServiceModule = (HttpServiceModule)theEObject;
                T result = caseHttpServiceModule ( httpServiceModule );
                if ( result == null )
                {
                    result = caseEquinoxModule ( httpServiceModule );
                }
                if ( result == null )
                {
                    result = caseModule ( httpServiceModule );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.REST_EXPORTER_MODULE:
            {
                final RestExporterModule restExporterModule = (RestExporterModule)theEObject;
                T result = caseRestExporterModule ( restExporterModule );
                if ( result == null )
                {
                    result = caseModule ( restExporterModule );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.VALUE_ARCHIVE_SLAVE:
            {
                final ValueArchiveSlave valueArchiveSlave = (ValueArchiveSlave)theEObject;
                T result = caseValueArchiveSlave ( valueArchiveSlave );
                if ( result == null )
                {
                    result = caseEquinoxApplication ( valueArchiveSlave );
                }
                if ( result == null )
                {
                    result = caseEquinoxBase ( valueArchiveSlave );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( valueArchiveSlave );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.WEB_ADMIN_CONSOLE:
            {
                final WebAdminConsole webAdminConsole = (WebAdminConsole)theEObject;
                T result = caseWebAdminConsole ( webAdminConsole );
                if ( result == null )
                {
                    result = caseEquinoxModule ( webAdminConsole );
                }
                if ( result == null )
                {
                    result = caseModule ( webAdminConsole );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.ORACLE_VM_SETTINGS:
            {
                final OracleVMSettings oracleVMSettings = (OracleVMSettings)theEObject;
                T result = caseOracleVMSettings ( oracleVMSettings );
                if ( result == null )
                {
                    result = caseJavaModule ( oracleVMSettings );
                }
                if ( result == null )
                {
                    result = caseModule ( oracleVMSettings );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.GENERIC_VM_SETTINGS:
            {
                final GenericVMSettings genericVMSettings = (GenericVMSettings)theEObject;
                T result = caseGenericVMSettings ( genericVMSettings );
                if ( result == null )
                {
                    result = caseJavaModule ( genericVMSettings );
                }
                if ( result == null )
                {
                    result = caseModule ( genericVMSettings );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.ABSTRACT_EQUINOX_DRIVER:
            {
                final AbstractEquinoxDriver abstractEquinoxDriver = (AbstractEquinoxDriver)theEObject;
                T result = caseAbstractEquinoxDriver ( abstractEquinoxDriver );
                if ( result == null )
                {
                    result = caseDriver ( abstractEquinoxDriver );
                }
                if ( result == null )
                {
                    result = caseEquinoxBase ( abstractEquinoxDriver );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( abstractEquinoxDriver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.EQUINOX_BASE:
            {
                final EquinoxBase equinoxBase = (EquinoxBase)theEObject;
                T result = caseEquinoxBase ( equinoxBase );
                if ( result == null )
                {
                    result = caseNamedApplication ( equinoxBase );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.ABSTRACT_COMMON_DRIVER:
            {
                final AbstractCommonDriver abstractCommonDriver = (AbstractCommonDriver)theEObject;
                T result = caseAbstractCommonDriver ( abstractCommonDriver );
                if ( result == null )
                {
                    result = caseDriver ( abstractCommonDriver );
                }
                if ( result == null )
                {
                    result = caseNamedApplication ( abstractCommonDriver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.EVENT_INJECTOR_HTTP:
            {
                final EventInjectorHttp eventInjectorHttp = (EventInjectorHttp)theEObject;
                T result = caseEventInjectorHttp ( eventInjectorHttp );
                if ( result == null )
                {
                    result = caseModule ( eventInjectorHttp );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.EVENT_INJECTOR_SYSLOG:
            {
                final EventInjectorSyslog eventInjectorSyslog = (EventInjectorSyslog)theEObject;
                T result = caseEventInjectorSyslog ( eventInjectorSyslog );
                if ( result == null )
                {
                    result = caseModule ( eventInjectorSyslog );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.JMX_SETTINGS:
            {
                final JMXSettings jmxSettings = (JMXSettings)theEObject;
                T result = caseJMXSettings ( jmxSettings );
                if ( result == null )
                {
                    result = caseJavaModule ( jmxSettings );
                }
                if ( result == null )
                {
                    result = caseModule ( jmxSettings );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.NAMED_APPLICATION:
            {
                final NamedApplication namedApplication = (NamedApplication)theEObject;
                T result = caseNamedApplication ( namedApplication );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.CONFIGURATION_ADMIN_FILE_BACKEND:
            {
                final ConfigurationAdminFileBackend configurationAdminFileBackend = (ConfigurationAdminFileBackend)theEObject;
                T result = caseConfigurationAdminFileBackend ( configurationAdminFileBackend );
                if ( result == null )
                {
                    result = caseEquinoxModule ( configurationAdminFileBackend );
                }
                if ( result == null )
                {
                    result = caseModule ( configurationAdminFileBackend );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.EQUINOX_MODULE:
            {
                final EquinoxModule equinoxModule = (EquinoxModule)theEObject;
                T result = caseEquinoxModule ( equinoxModule );
                if ( result == null )
                {
                    result = caseModule ( equinoxModule );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.JAVA_MODULE:
            {
                final JavaModule javaModule = (JavaModule)theEObject;
                T result = caseJavaModule ( javaModule );
                if ( result == null )
                {
                    result = caseModule ( javaModule );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case InfrastructurePackage.DS_FILE_BACKEND:
            {
                final DSFileBackend dsFileBackend = (DSFileBackend)theEObject;
                T result = caseDSFileBackend ( dsFileBackend );
                if ( result == null )
                {
                    result = caseEquinoxModule ( dsFileBackend );
                }
                if ( result == null )
                {
                    result = caseModule ( dsFileBackend );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>World</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>World</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWorld ( final World object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNode ( final Node object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Master Server</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Master Server</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMasterServer ( final MasterServer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Master Import</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Master Import</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMasterImport ( final MasterImport object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Options</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Options</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOptions ( final Options object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Equinox Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Equinox Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEquinoxApplication ( final EquinoxApplication object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Common Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Common Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCommonDriver ( final CommonDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>External Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>External Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalNode ( final ExternalNode object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>System Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>System Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSystemNode ( final SystemNode object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>System Property User Service</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>System Property User Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSystemPropertyUserService ( final SystemPropertyUserService object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>User Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>User Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUserEntry ( final UserEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>User Service</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>User Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUserService ( final UserService object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Jdbc User Service</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Jdbc User Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJdbcUserService ( final JdbcUserService object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Value Archive Server</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Value Archive Server</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueArchiveServer ( final ValueArchiveServer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Factory Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Factory Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractFactoryDriver ( final AbstractFactoryDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Device</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Device</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDevice ( final Device object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Equinox Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Equinox Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEquinoxDriver ( final EquinoxDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>External Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>External Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalDriver ( final ExternalDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDriver ( final Driver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>External Driver Placeholder</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>External Driver Placeholder</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalDriverPlaceholder ( final ExternalDriverPlaceholder object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Application Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Application Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplicationConfiguration ( final ApplicationConfiguration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Configurations</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Configurations</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConfigurations ( final Configurations object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseModule ( final Module object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Http Service Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Http Service Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHttpServiceModule ( final HttpServiceModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Rest Exporter Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Rest Exporter Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRestExporterModule ( final RestExporterModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Value Archive Slave</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Value Archive Slave</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueArchiveSlave ( final ValueArchiveSlave object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Web Admin Console</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Web Admin Console</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWebAdminConsole ( final WebAdminConsole object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Oracle VM Settings</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Oracle VM Settings</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOracleVMSettings ( final OracleVMSettings object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Generic VM Settings</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Generic VM Settings</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGenericVMSettings ( final GenericVMSettings object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Equinox Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Equinox Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractEquinoxDriver ( final AbstractEquinoxDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Equinox Base</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Equinox Base</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEquinoxBase ( final EquinoxBase object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Common Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Common Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractCommonDriver ( final AbstractCommonDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Event Injector Http</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Event Injector Http</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventInjectorHttp ( final EventInjectorHttp object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Event Injector Syslog</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Event Injector Syslog</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventInjectorSyslog ( final EventInjectorSyslog object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>JMX Settings</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>JMX Settings</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJMXSettings ( final JMXSettings object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Named Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Named Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedApplication ( final NamedApplication object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Configuration Admin File Backend</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Configuration Admin File Backend</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConfigurationAdminFileBackend ( final ConfigurationAdminFileBackend object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Equinox Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Equinox Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEquinoxModule ( final EquinoxModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Java Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Java Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJavaModule ( final JavaModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>DS File Backend</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>DS File Backend</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDSFileBackend ( final DSFileBackend object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentable ( final Documentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Named Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Named Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedDocumentable ( final NamedDocumentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplication ( final Application object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWorld_Driver ( final org.eclipse.scada.configuration.world.Driver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( final EObject object )
    {
        return null;
    }

} //InfrastructureSwitch
