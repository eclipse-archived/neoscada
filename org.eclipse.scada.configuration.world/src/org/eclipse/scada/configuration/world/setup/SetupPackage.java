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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.scada.configuration.world.setup.SetupFactory
 * @model kind="package"
 * @generated
 */
public interface SetupPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "setup"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/World/Setup"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "setup"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SetupPackage eINSTANCE = org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.setup.impl.OperatingSystemDescriptorImpl <em>Operating System Descriptor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.setup.impl.OperatingSystemDescriptorImpl
     * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getOperatingSystemDescriptor()
     * @generated
     */
    int OPERATING_SYSTEM_DESCRIPTOR = 0;

    /**
     * The feature id for the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATING_SYSTEM_DESCRIPTOR__PARENT = 0;

    /**
     * The feature id for the '<em><b>Properties</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATING_SYSTEM_DESCRIPTOR__PROPERTIES = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATING_SYSTEM_DESCRIPTOR__ID = 2;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATING_SYSTEM_DESCRIPTOR__LABEL = 3;

    /**
     * The number of structural features of the '<em>Operating System Descriptor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATING_SYSTEM_DESCRIPTOR_FEATURE_COUNT = 4;

    /**
     * The number of operations of the '<em>Operating System Descriptor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OPERATING_SYSTEM_DESCRIPTOR_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.setup.impl.SetupModuleContainerImpl <em>Module Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.setup.impl.SetupModuleContainerImpl
     * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getSetupModuleContainer()
     * @generated
     */
    int SETUP_MODULE_CONTAINER = 1;

    /**
     * The feature id for the '<em><b>Modules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_MODULE_CONTAINER__MODULES = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_MODULE_CONTAINER__ID = 1;

    /**
     * The number of structural features of the '<em>Module Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_MODULE_CONTAINER_FEATURE_COUNT = 2;

    /**
     * The operation id for the '<em>Validate Operating System</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_MODULE_CONTAINER___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT = 0;

    /**
     * The number of operations of the '<em>Module Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_MODULE_CONTAINER_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.setup.SetupModule <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.setup.SetupModule
     * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getSetupModule()
     * @generated
     */
    int SETUP_MODULE = 2;

    /**
     * The number of structural features of the '<em>Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_MODULE_FEATURE_COUNT = 0;

    /**
     * The operation id for the '<em>Validate Operating System</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT = 0;

    /**
     * The number of operations of the '<em>Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_MODULE_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.setup.impl.SubContainerModuleImpl <em>Sub Container Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.setup.impl.SubContainerModuleImpl
     * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getSubContainerModule()
     * @generated
     */
    int SUB_CONTAINER_MODULE = 3;

    /**
     * The feature id for the '<em><b>Container</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_CONTAINER_MODULE__CONTAINER = SETUP_MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Sub Container Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_CONTAINER_MODULE_FEATURE_COUNT = SETUP_MODULE_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Validate Operating System</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_CONTAINER_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT = SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT;

    /**
     * The number of operations of the '<em>Sub Container Module</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_CONTAINER_MODULE_OPERATION_COUNT = SETUP_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.setup.impl.SetupDefinitionsImpl <em>Definitions</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.setup.impl.SetupDefinitionsImpl
     * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getSetupDefinitions()
     * @generated
     */
    int SETUP_DEFINITIONS = 4;

    /**
     * The feature id for the '<em><b>Containers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_DEFINITIONS__CONTAINERS = 0;

    /**
     * The feature id for the '<em><b>Operation System Definitions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_DEFINITIONS__OPERATION_SYSTEM_DEFINITIONS = 1;

    /**
     * The number of structural features of the '<em>Definitions</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_DEFINITIONS_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Definitions</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SETUP_DEFINITIONS_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '<em>Status</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.core.runtime.IStatus
     * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getStatus()
     * @generated
     */
    int STATUS = 5;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor <em>Operating System Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Operating System Descriptor</em>'.
     * @see org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor
     * @generated
     */
    EClass getOperatingSystemDescriptor ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Parent</em>'.
     * @see org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getParent()
     * @see #getOperatingSystemDescriptor()
     * @generated
     */
    EReference getOperatingSystemDescriptor_Parent ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Properties</em>'.
     * @see org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getProperties()
     * @see #getOperatingSystemDescriptor()
     * @generated
     */
    EReference getOperatingSystemDescriptor_Properties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getId()
     * @see #getOperatingSystemDescriptor()
     * @generated
     */
    EAttribute getOperatingSystemDescriptor_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getLabel()
     * @see #getOperatingSystemDescriptor()
     * @generated
     */
    EAttribute getOperatingSystemDescriptor_Label ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer <em>Module Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module Container</em>'.
     * @see org.eclipse.scada.configuration.world.setup.SetupModuleContainer
     * @generated
     */
    EClass getSetupModuleContainer ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer#getModules <em>Modules</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Modules</em>'.
     * @see org.eclipse.scada.configuration.world.setup.SetupModuleContainer#getModules()
     * @see #getSetupModuleContainer()
     * @generated
     */
    EReference getSetupModuleContainer_Modules ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.world.setup.SetupModuleContainer#getId()
     * @see #getSetupModuleContainer()
     * @generated
     */
    EAttribute getSetupModuleContainer_Id ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor, org.eclipse.scada.utils.ecore.validation.ValidationContext) <em>Validate Operating System</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Validate Operating System</em>' operation.
     * @see org.eclipse.scada.configuration.world.setup.SetupModuleContainer#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor, org.eclipse.scada.utils.ecore.validation.ValidationContext)
     * @generated
     */
    EOperation getSetupModuleContainer__ValidateOperatingSystem__OperatingSystemDescriptor_ValidationContext ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.setup.SetupModule <em>Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Module</em>'.
     * @see org.eclipse.scada.configuration.world.setup.SetupModule
     * @generated
     */
    EClass getSetupModule ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.setup.SetupModule#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor, org.eclipse.scada.utils.ecore.validation.ValidationContext) <em>Validate Operating System</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Validate Operating System</em>' operation.
     * @see org.eclipse.scada.configuration.world.setup.SetupModule#validateOperatingSystem(org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor, org.eclipse.scada.utils.ecore.validation.ValidationContext)
     * @generated
     */
    EOperation getSetupModule__ValidateOperatingSystem__OperatingSystemDescriptor_ValidationContext ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.setup.SubContainerModule <em>Sub Container Module</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sub Container Module</em>'.
     * @see org.eclipse.scada.configuration.world.setup.SubContainerModule
     * @generated
     */
    EClass getSubContainerModule ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.setup.SubContainerModule#getContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Container</em>'.
     * @see org.eclipse.scada.configuration.world.setup.SubContainerModule#getContainer()
     * @see #getSubContainerModule()
     * @generated
     */
    EReference getSubContainerModule_Container ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.setup.SetupDefinitions <em>Definitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Definitions</em>'.
     * @see org.eclipse.scada.configuration.world.setup.SetupDefinitions
     * @generated
     */
    EClass getSetupDefinitions ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.setup.SetupDefinitions#getContainers <em>Containers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Containers</em>'.
     * @see org.eclipse.scada.configuration.world.setup.SetupDefinitions#getContainers()
     * @see #getSetupDefinitions()
     * @generated
     */
    EReference getSetupDefinitions_Containers ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.setup.SetupDefinitions#getOperationSystemDefinitions <em>Operation System Definitions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Operation System Definitions</em>'.
     * @see org.eclipse.scada.configuration.world.setup.SetupDefinitions#getOperationSystemDefinitions()
     * @see #getSetupDefinitions()
     * @generated
     */
    EReference getSetupDefinitions_OperationSystemDefinitions ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.core.runtime.IStatus <em>Status</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Status</em>'.
     * @see org.eclipse.core.runtime.IStatus
     * @model instanceClass="org.eclipse.core.runtime.IStatus" serializeable="false"
     * @generated
     */
    EDataType getStatus ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SetupFactory getSetupFactory ();

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
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.setup.impl.OperatingSystemDescriptorImpl <em>Operating System Descriptor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.setup.impl.OperatingSystemDescriptorImpl
         * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getOperatingSystemDescriptor()
         * @generated
         */
        EClass OPERATING_SYSTEM_DESCRIPTOR = eINSTANCE.getOperatingSystemDescriptor ();

        /**
         * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPERATING_SYSTEM_DESCRIPTOR__PARENT = eINSTANCE.getOperatingSystemDescriptor_Parent ();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OPERATING_SYSTEM_DESCRIPTOR__PROPERTIES = eINSTANCE.getOperatingSystemDescriptor_Properties ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPERATING_SYSTEM_DESCRIPTOR__ID = eINSTANCE.getOperatingSystemDescriptor_Id ();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute OPERATING_SYSTEM_DESCRIPTOR__LABEL = eINSTANCE.getOperatingSystemDescriptor_Label ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.setup.impl.SetupModuleContainerImpl <em>Module Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.setup.impl.SetupModuleContainerImpl
         * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getSetupModuleContainer()
         * @generated
         */
        EClass SETUP_MODULE_CONTAINER = eINSTANCE.getSetupModuleContainer ();

        /**
         * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SETUP_MODULE_CONTAINER__MODULES = eINSTANCE.getSetupModuleContainer_Modules ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SETUP_MODULE_CONTAINER__ID = eINSTANCE.getSetupModuleContainer_Id ();

        /**
         * The meta object literal for the '<em><b>Validate Operating System</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SETUP_MODULE_CONTAINER___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT = eINSTANCE.getSetupModuleContainer__ValidateOperatingSystem__OperatingSystemDescriptor_ValidationContext ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.setup.SetupModule <em>Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.setup.SetupModule
         * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getSetupModule()
         * @generated
         */
        EClass SETUP_MODULE = eINSTANCE.getSetupModule ();

        /**
         * The meta object literal for the '<em><b>Validate Operating System</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation SETUP_MODULE___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_VALIDATIONCONTEXT = eINSTANCE.getSetupModule__ValidateOperatingSystem__OperatingSystemDescriptor_ValidationContext ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.setup.impl.SubContainerModuleImpl <em>Sub Container Module</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.setup.impl.SubContainerModuleImpl
         * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getSubContainerModule()
         * @generated
         */
        EClass SUB_CONTAINER_MODULE = eINSTANCE.getSubContainerModule ();

        /**
         * The meta object literal for the '<em><b>Container</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SUB_CONTAINER_MODULE__CONTAINER = eINSTANCE.getSubContainerModule_Container ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.setup.impl.SetupDefinitionsImpl <em>Definitions</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.setup.impl.SetupDefinitionsImpl
         * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getSetupDefinitions()
         * @generated
         */
        EClass SETUP_DEFINITIONS = eINSTANCE.getSetupDefinitions ();

        /**
         * The meta object literal for the '<em><b>Containers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SETUP_DEFINITIONS__CONTAINERS = eINSTANCE.getSetupDefinitions_Containers ();

        /**
         * The meta object literal for the '<em><b>Operation System Definitions</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SETUP_DEFINITIONS__OPERATION_SYSTEM_DEFINITIONS = eINSTANCE.getSetupDefinitions_OperationSystemDefinitions ();

        /**
         * The meta object literal for the '<em>Status</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.core.runtime.IStatus
         * @see org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl#getStatus()
         * @generated
         */
        EDataType STATUS = eINSTANCE.getStatus ();

    }

} //SetupPackage
