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
package org.eclipse.scada.configuration.world;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.WorldPackage
 * @generated
 */
public interface WorldFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    WorldFactory eINSTANCE = org.eclipse.scada.configuration.world.impl.WorldFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>World</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>World</em>'.
     * @generated
     */
    World createWorld ();

    /**
     * Returns a new object of class '<em>Application Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Application Node</em>'.
     * @generated
     */
    ApplicationNode createApplicationNode ();

    /**
     * Returns a new object of class '<em>Endpoint</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Endpoint</em>'.
     * @generated
     */
    Endpoint createEndpoint ();

    /**
     * Returns a new object of class '<em>Exec Driver</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exec Driver</em>'.
     * @generated
     */
    ExecDriver createExecDriver ();

    /**
     * Returns a new object of class '<em>Handler Priority Rule</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Handler Priority Rule</em>'.
     * @generated
     */
    HandlerPriorityRule createHandlerPriorityRule ();

    /**
     * Returns a new object of class '<em>Master Handler Priorities</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Master Handler Priorities</em>'.
     * @generated
     */
    MasterHandlerPriorities createMasterHandlerPriorities ();

    /**
     * Returns a new object of class '<em>Options</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Options</em>'.
     * @generated
     */
    Options createOptions ();

    /**
     * Returns a new object of class '<em>Username Password Credentials</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Username Password Credentials</em>'.
     * @generated
     */
    UsernamePasswordCredentials createUsernamePasswordCredentials ();

    /**
     * Returns a new object of class '<em>Password Credentials</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Password Credentials</em>'.
     * @generated
     */
    PasswordCredentials createPasswordCredentials ();

    /**
     * Returns a new object of class '<em>External Node</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>External Node</em>'.
     * @generated
     */
    ExternalNode createExternalNode ();

    /**
     * Returns a new object of class '<em>Property Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Property Entry</em>'.
     * @generated
     */
    PropertyEntry createPropertyEntry ();

    /**
     * Returns a new object of class '<em>Contained Service Binding</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Contained Service Binding</em>'.
     * @generated
     */
    ContainedServiceBinding createContainedServiceBinding ();

    /**
     * Returns a new object of class '<em>Referenced Service Binding</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Referenced Service Binding</em>'.
     * @generated
     */
    ReferencedServiceBinding createReferencedServiceBinding ();

    /**
     * Returns a new object of class '<em>Generic Settings Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Generic Settings Container</em>'.
     * @generated
     */
    GenericSettingsContainer createGenericSettingsContainer ();

    /**
     * Returns a new object of class '<em>Generic Database Settings</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Generic Database Settings</em>'.
     * @generated
     */
    GenericDatabaseSettings createGenericDatabaseSettings ();

    /**
     * Returns a new object of class '<em>Postgres Database Settings</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Postgres Database Settings</em>'.
     * @generated
     */
    PostgresDatabaseSettings createPostgresDatabaseSettings ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    WorldPackage getWorldPackage ();

} //ConfigurationFactory
