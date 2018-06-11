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
package org.eclipse.neoscada.configuration.iec62541;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Package
 * @generated
 */
public interface IEC62541Factory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    IEC62541Factory eINSTANCE = org.eclipse.neoscada.configuration.iec62541.impl.IEC62541FactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Driver</em>'.
     * @generated
     */
    IEC62541Driver createIEC62541Driver ();

    /**
     * Returns a new object of class '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Device</em>'.
     * @generated
     */
    IEC62541Device createIEC62541Device ();

    /**
     * Returns a new object of class '<em>Driver Application</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Driver Application</em>'.
     * @generated
     */
    DriverApplication createDriverApplication ();

    /**
     * Returns a new object of class '<em>Hive Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Hive Device</em>'.
     * @generated
     */
    HiveDevice createHiveDevice ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    IEC62541Package getIEC62541Package ();

} //IEC62541Factory
