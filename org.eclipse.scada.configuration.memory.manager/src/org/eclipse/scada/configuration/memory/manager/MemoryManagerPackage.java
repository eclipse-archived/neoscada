/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.memory.manager;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.memory.manager.MemoryManagerFactory
 * @model kind="package"
 * @generated
 */
public interface MemoryManagerPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "manager"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Memory/Manager"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "memoryManager"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    MemoryManagerPackage eINSTANCE = org.eclipse.scada.configuration.memory.manager.impl.MemoryManagerPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.memory.manager.impl.MemoryManagerModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.memory.manager.impl.MemoryManagerModuleImpl
     * @see org.eclipse.scada.configuration.memory.manager.impl.MemoryManagerPackageImpl#getMemoryManagerModule()
     * @generated
     */
    int MEMORY_MANAGER_MODULE = 0;

    /**
     * The feature id for the '<em><b>Type System</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MEMORY_MANAGER_MODULE__TYPE_SYSTEM = OsgiPackage.APPLICATION_CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MEMORY_MANAGER_MODULE_FEATURE_COUNT = OsgiPackage.APPLICATION_CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MEMORY_MANAGER_MODULE_OPERATION_COUNT = OsgiPackage.APPLICATION_CONFIGURATION_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.memory.manager.MemoryManagerModule <em>Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module</em>'.
     * @see org.eclipse.scada.configuration.memory.manager.MemoryManagerModule
     * @generated
     */
    EClass getMemoryManagerModule ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.memory.manager.MemoryManagerModule#getTypeSystem <em>Type System</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Type System</em>'.
     * @see org.eclipse.scada.configuration.memory.manager.MemoryManagerModule#getTypeSystem()
     * @see #getMemoryManagerModule()
     * @generated
     */
    EReference getMemoryManagerModule_TypeSystem ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    MemoryManagerFactory getMemoryManagerFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.memory.manager.impl.MemoryManagerModuleImpl <em>Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.memory.manager.impl.MemoryManagerModuleImpl
         * @see org.eclipse.scada.configuration.memory.manager.impl.MemoryManagerPackageImpl#getMemoryManagerModule()
         * @generated
         */
        EClass MEMORY_MANAGER_MODULE = eINSTANCE.getMemoryManagerModule ();

        /**
         * The meta object literal for the '<em><b>Type System</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MEMORY_MANAGER_MODULE__TYPE_SYSTEM = eINSTANCE.getMemoryManagerModule_TypeSystem ();

    }

} //MemoryManagerPackage
