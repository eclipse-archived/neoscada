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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getSetupModuleContainer()
 * @model
 * @generated
 */
public interface SetupModuleContainer extends EObject
{
    /**
     * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.setup.SetupModule}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Modules</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getSetupModuleContainer_Modules()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<SetupModule> getModules ();

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getSetupModuleContainer_Id()
     * @model id="true" required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.setup.SetupModuleContainer#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dataType="org.eclipse.scada.configuration.world.setup.Status" contextDataType="org.eclipse.scada.configuration.world.setup.ValidationContext"
     * @generated
     */
    IStatus validateOperatingSystem ( OperatingSystemDescriptor descriptor, IValidationContext context );

} // SetupModuleContainer
