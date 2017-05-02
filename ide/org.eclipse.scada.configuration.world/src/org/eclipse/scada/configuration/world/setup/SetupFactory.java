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
package org.eclipse.scada.configuration.world.setup;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.setup.SetupPackage
 * @generated
 */
public interface SetupFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SetupFactory eINSTANCE = org.eclipse.scada.configuration.world.setup.impl.SetupFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Operating System Descriptor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Operating System Descriptor</em>'.
     * @generated
     */
    OperatingSystemDescriptor createOperatingSystemDescriptor ();

    /**
     * Returns a new object of class '<em>Module Container</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Module Container</em>'.
     * @generated
     */
    SetupModuleContainer createSetupModuleContainer ();

    /**
     * Returns a new object of class '<em>Sub Container Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Sub Container Module</em>'.
     * @generated
     */
    SubContainerModule createSubContainerModule ();

    /**
     * Returns a new object of class '<em>Definitions</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Definitions</em>'.
     * @generated
     */
    SetupDefinitions createSetupDefinitions ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    SetupPackage getSetupPackage ();

} //SetupFactory
