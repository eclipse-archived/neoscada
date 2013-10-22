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
package org.eclipse.scada.configuration.globalization;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Authorative</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Authorative#getHierarchy <em>Hierarchy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getAuthorative()
 * @model
 * @generated
 */
public interface Authorative extends EObject
{
    /**
     * Returns the value of the '<em><b>Hierarchy</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hierarchy</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hierarchy</em>' attribute list.
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getAuthorative_Hierarchy()
     * @model required="true"
     * @generated
     */
    EList<String> getHierarchy ();

} // Authorative
