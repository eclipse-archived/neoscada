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

import org.eclipse.emf.common.util.EList;

import org.eclipse.scada.configuration.world.setup.SetupModule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Serial To Network Setup Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkSetupModule#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkSetupModule()
 * @model
 * @generated
 */
public interface SerialToNetworkSetupModule extends SetupModule
{
    /**
     * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mappings</em>' containment reference list.
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkSetupModule_Mappings()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<SerialToNetworkMapping> getMappings ();

} // SerialToNetworkSetupModule
