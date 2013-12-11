/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Globalize Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.GlobalizeComponent#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getGlobalizeComponent()
 * @model
 * @generated
 */
public interface GlobalizeComponent extends DataComponent
{
    /**
     * Returns the value of the '<em><b>Components</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.DataComponent}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Components</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Components</em>' reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getGlobalizeComponent_Components()
     * @model
     * @generated
     */
    EList<DataComponent> getComponents ();

} // GlobalizeComponent
