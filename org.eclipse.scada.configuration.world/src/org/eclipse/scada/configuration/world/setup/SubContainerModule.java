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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Container Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.SubContainerModule#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getSubContainerModule()
 * @model
 * @generated
 */
public interface SubContainerModule extends SetupModule
{
    /**
     * Returns the value of the '<em><b>Container</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container</em>' reference.
     * @see #setContainer(SetupModuleContainer)
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getSubContainerModule_Container()
     * @model
     * @generated
     */
    SetupModuleContainer getContainer ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.setup.SubContainerModule#getContainer <em>Container</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container</em>' reference.
     * @see #getContainer()
     * @generated
     */
    void setContainer ( SetupModuleContainer value );

} // SubContainerModule
