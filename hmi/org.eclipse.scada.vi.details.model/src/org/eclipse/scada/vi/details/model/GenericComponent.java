/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.GenericComponent#getRegistrations <em>Registrations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGenericComponent()
 * @model abstract="true"
 * @generated
 */
public interface GenericComponent extends Component
{
    /**
     * Returns the value of the '<em><b>Registrations</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.vi.details.model.Registration}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Registrations</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Registrations</em>' containment reference list.
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getGenericComponent_Registrations()
     * @model containment="true"
     * @generated
     */
    EList<Registration> getRegistrations ();

} // GenericComponent
