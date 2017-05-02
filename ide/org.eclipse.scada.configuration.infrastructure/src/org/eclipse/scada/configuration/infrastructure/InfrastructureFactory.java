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
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage
 * @generated
 */
public interface InfrastructureFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    InfrastructureFactory eINSTANCE = org.eclipse.scada.configuration.infrastructure.impl.InfrastructureFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>World</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>World</em>'.
     * @generated
     */
    World createWorld ();

    /**
     * Returns a new object of class '<em>Master Server</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Master Server</em>'.
     * @generated
     */
    MasterServer createMasterServer ();

    /**
     * Returns a new object of class '<em>Master Import</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Master Import</em>'.
     * @generated
     */
    MasterImport createMasterImport ();

    /**
     * Returns a new object of class '<em>Options</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Options</em>'.
     * @generated
     */
    Options createOptions ();

    /**
     * Returns a new object of class '<em>Common Driver</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Common Driver</em>'.
     * @generated
     */
    CommonDriver createCommonDriver ();

    /**
     * Returns a new object of class '<em>External Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>External Node</em>'.
     * @generated
     */
    ExternalNode createExternalNode ();

    /**
     * Returns a new object of class '<em>System Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>System Node</em>'.
     * @generated
     */
    SystemNode createSystemNode ();

    /**
     * Returns a new object of class '<em>System Property User Service</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>System Property User Service</em>'.
     * @generated
     */
    SystemPropertyUserService createSystemPropertyUserService ();

    /**
     * Returns a new object of class '<em>User Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>User Entry</em>'.
     * @generated
     */
    UserEntry createUserEntry ();

    /**
     * Returns a new object of class '<em>Jdbc User Service</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Jdbc User Service</em>'.
     * @generated
     */
    JdbcUserService createJdbcUserService ();

    /**
     * Returns a new object of class '<em>Value Archive Server</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Archive Server</em>'.
     * @generated
     */
    ValueArchiveServer createValueArchiveServer ();

    /**
     * Returns a new object of class '<em>Equinox Driver</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Equinox Driver</em>'.
     * @generated
     */
    EquinoxDriver createEquinoxDriver ();

    /**
     * Returns a new object of class '<em>External Driver</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>External Driver</em>'.
     * @generated
     */
    ExternalDriver createExternalDriver ();

    /**
     * Returns a new object of class '<em>External Driver Placeholder</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>External Driver Placeholder</em>'.
     * @generated
     */
    ExternalDriverPlaceholder createExternalDriverPlaceholder ();

    /**
     * Returns a new object of class '<em>Application Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Application Configuration</em>'.
     * @generated
     */
    ApplicationConfiguration createApplicationConfiguration ();

    /**
     * Returns a new object of class '<em>Configurations</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Configurations</em>'.
     * @generated
     */
    Configurations createConfigurations ();

    /**
     * Returns a new object of class '<em>Http Service Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Http Service Module</em>'.
     * @generated
     */
    HttpServiceModule createHttpServiceModule ();

    /**
     * Returns a new object of class '<em>Rest Exporter Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Rest Exporter Module</em>'.
     * @generated
     */
    RestExporterModule createRestExporterModule ();

    /**
     * Returns a new object of class '<em>Value Archive Slave</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Archive Slave</em>'.
     * @generated
     */
    ValueArchiveSlave createValueArchiveSlave ();

    /**
     * Returns a new object of class '<em>Web Admin Console</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Web Admin Console</em>'.
     * @generated
     */
    WebAdminConsole createWebAdminConsole ();

    /**
     * Returns a new object of class '<em>Oracle VM Settings</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Oracle VM Settings</em>'.
     * @generated
     */
    OracleVMSettings createOracleVMSettings ();

    /**
     * Returns a new object of class '<em>Generic VM Settings</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Generic VM Settings</em>'.
     * @generated
     */
    GenericVMSettings createGenericVMSettings ();

    /**
     * Returns a new object of class '<em>Event Injector Http</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Injector Http</em>'.
     * @generated
     */
    EventInjectorHttp createEventInjectorHttp ();

    /**
     * Returns a new object of class '<em>Event Injector Syslog</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Injector Syslog</em>'.
     * @generated
     */
    EventInjectorSyslog createEventInjectorSyslog ();

    /**
     * Returns a new object of class '<em>JMX Settings</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>JMX Settings</em>'.
     * @generated
     */
    JMXSettings createJMXSettings ();

    /**
     * Returns a new object of class '<em>Configuration Admin File Backend</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Configuration Admin File Backend</em>'.
     * @generated
     */
    ConfigurationAdminFileBackend createConfigurationAdminFileBackend ();

    /**
     * Returns a new object of class '<em>DS File Backend</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>DS File Backend</em>'.
     * @generated
     */
    DSFileBackend createDSFileBackend ();

    /**
     * Returns a new object of class '<em>Configuration Admin Settings</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Configuration Admin Settings</em>'.
     * @generated
     */
    ConfigurationAdminSettings createConfigurationAdminSettings ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    InfrastructurePackage getInfrastructurePackage ();

} //InfrastructureFactory
