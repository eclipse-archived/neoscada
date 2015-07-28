/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Read Only Single Value</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getReadOnlySingleValue()
 * @model abstract="true"
 * @generated
 */
public interface ReadOnlySingleValue extends SingleValue
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return false;'"
     * @generated
     */
    boolean isWritable ();

} // ReadOnlySingleValue
