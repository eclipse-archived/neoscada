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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.SetupDefinitions#getContainers <em>Containers</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.SetupDefinitions#getOperationSystemDefinitions <em>Operation System Definitions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getSetupDefinitions()
 * @model
 * @generated
 */
public interface SetupDefinitions extends EObject
{
    /**
     * Returns the value of the '<em><b>Containers</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Containers</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Containers</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getSetupDefinitions_Containers()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<SetupModuleContainer> getContainers ();

    /**
     * Returns the value of the '<em><b>Operation System Definitions</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation System Definitions</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation System Definitions</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getSetupDefinitions_OperationSystemDefinitions()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<OperatingSystemDescriptor> getOperationSystemDefinitions ();

} // SetupDefinitions
