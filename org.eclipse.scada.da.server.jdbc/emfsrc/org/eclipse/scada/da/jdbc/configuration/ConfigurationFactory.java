/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.jdbc.configuration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage
 * @generated
 */
public interface ConfigurationFactory extends EFactory
{

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ConfigurationFactory eINSTANCE = org.eclipse.scada.da.jdbc.configuration.impl.ConfigurationFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Column Mapping Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Column Mapping Type</em>'.
     * @generated
     */
    ColumnMappingType createColumnMappingType ();

    /**
     * Returns a new object of class '<em>Commands Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Commands Type</em>'.
     * @generated
     */
    CommandsType createCommandsType ();

    /**
     * Returns a new object of class '<em>Connection Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Connection Type</em>'.
     * @generated
     */
    ConnectionType createConnectionType ();

    /**
     * Returns a new object of class '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Document Root</em>'.
     * @generated
     */
    DocumentRoot createDocumentRoot ();

    /**
     * Returns a new object of class '<em>Query Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Query Type</em>'.
     * @generated
     */
    QueryType createQueryType ();

    /**
     * Returns a new object of class '<em>Root Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Root Type</em>'.
     * @generated
     */
    RootType createRootType ();

    /**
     * Returns a new object of class '<em>Tabular Query Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Tabular Query Type</em>'.
     * @generated
     */
    TabularQueryType createTabularQueryType ();

    /**
     * Returns a new object of class '<em>Update Columns Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Update Columns Type</em>'.
     * @generated
     */
    UpdateColumnsType createUpdateColumnsType ();

    /**
     * Returns a new object of class '<em>Update Mapping Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Update Mapping Type</em>'.
     * @generated
     */
    UpdateMappingType createUpdateMappingType ();

    /**
     * Returns a new object of class '<em>Update Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Update Type</em>'.
     * @generated
     */
    UpdateType createUpdateType ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ConfigurationPackage getConfigurationPackage ();

} //ConfigurationFactory
