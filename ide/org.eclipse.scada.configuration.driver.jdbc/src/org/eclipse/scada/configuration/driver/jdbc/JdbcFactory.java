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
package org.eclipse.scada.configuration.driver.jdbc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage
 * @generated
 */
public interface JdbcFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    JdbcFactory eINSTANCE = org.eclipse.scada.configuration.driver.jdbc.impl.JdbcFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Driver Instance</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Driver Instance</em>'.
     * @generated
     */
    JdbcDriverInstance createJdbcDriverInstance ();

    /**
     * Returns a new object of class '<em>Update Command</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Update Command</em>'.
     * @generated
     */
    UpdateCommand createUpdateCommand ();

    /**
     * Returns a new object of class '<em>Query Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Query Component</em>'.
     * @generated
     */
    QueryComponent createQueryComponent ();

    /**
     * Returns a new object of class '<em>Update Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Update Mapping</em>'.
     * @generated
     */
    UpdateMapping createUpdateMapping ();

    /**
     * Returns a new object of class '<em>Column Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Column Mapping</em>'.
     * @generated
     */
    ColumnMapping createColumnMapping ();

    /**
     * Returns a new object of class '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Driver</em>'.
     * @generated
     */
    JdbcDriver createJdbcDriver ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    JdbcPackage getJdbcPackage ();

} //JdbcFactory
