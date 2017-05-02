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
package org.eclipse.scada.configuration.setup.common;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.setup.common.CommonPackage
 * @generated
 */
public interface CommonFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CommonFactory eINSTANCE = org.eclipse.scada.configuration.setup.common.impl.CommonFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Postgres Setup Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Postgres Setup Module</em>'.
     * @generated
     */
    PostgresSetupModule createPostgresSetupModule ();

    /**
     * Returns a new object of class '<em>Serial To Network Setup Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Serial To Network Setup Module</em>'.
     * @generated
     */
    SerialToNetworkSetupModule createSerialToNetworkSetupModule ();

    /**
     * Returns a new object of class '<em>Serial To Network Mapping</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Serial To Network Mapping</em>'.
     * @generated
     */
    SerialToNetworkMapping createSerialToNetworkMapping ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    CommonPackage getCommonPackage ();

} //CommonFactory
