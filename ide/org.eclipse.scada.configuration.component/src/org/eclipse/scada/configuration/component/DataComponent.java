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
package org.eclipse.scada.configuration.component;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.infrastructure.MasterServer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Component</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getDataComponent()
 * @model abstract="true"
 * @generated
 */
public interface DataComponent extends Component
{
    /**
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Master On</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    EList<MasterServer> getMasterOn ();

} // DataComponent
