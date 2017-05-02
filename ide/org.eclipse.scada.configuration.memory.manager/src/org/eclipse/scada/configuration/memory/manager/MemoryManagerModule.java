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

import org.eclipse.scada.configuration.memory.TypeSystem;
import org.eclipse.scada.configuration.world.osgi.ApplicationConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.memory.manager.MemoryManagerModule#getTypeSystem <em>Type System</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.memory.manager.MemoryManagerPackage#getMemoryManagerModule()
 * @model annotation="http://eclipse.org/SCADA/Configuration/ExclusiveGroup groupId='memory.manager'"
 * @generated
 */
public interface MemoryManagerModule extends ApplicationConfiguration
{
    /**
     * Returns the value of the '<em><b>Type System</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type System</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type System</em>' reference.
     * @see #setTypeSystem(TypeSystem)
     * @see org.eclipse.scada.configuration.memory.manager.MemoryManagerPackage#getMemoryManagerModule_TypeSystem()
     * @model required="true"
     * @generated
     */
    TypeSystem getTypeSystem ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.memory.manager.MemoryManagerModule#getTypeSystem <em>Type System</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type System</em>' reference.
     * @see #getTypeSystem()
     * @generated
     */
    void setTypeSystem ( TypeSystem value );

} // MemoryManagerModule
