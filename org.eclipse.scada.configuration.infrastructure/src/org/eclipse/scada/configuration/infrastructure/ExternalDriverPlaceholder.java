/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.Endpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '
 * <em><b>External Driver Placeholder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.ExternalDriverPlaceholder#getEndpoints <em>Endpoints</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getExternalDriverPlaceholder()
 * @model
 * @generated
 */
public interface ExternalDriverPlaceholder extends Driver
{
    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.Endpoint}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getExternalDriverPlaceholder_Endpoints()
     * @model
     * @generated
     */
    EList<Endpoint> getEndpoints ();

} // ExternalDriverPlaceholder
