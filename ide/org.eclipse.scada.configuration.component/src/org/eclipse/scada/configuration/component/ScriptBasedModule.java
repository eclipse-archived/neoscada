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

import org.eclipse.emf.common.util.EList;

import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Based Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.ScriptBasedModule#getInitProperties <em>Init Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getScriptBasedModule()
 * @model abstract="true"
 * @generated
 */
public interface ScriptBasedModule extends CalculationModule
{
    /**
     * Returns the value of the '<em><b>Init Properties</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Init Properties</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Init Properties</em>' reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getScriptBasedModule_InitProperties()
     * @model
     * @generated
     */
    EList<PropertyEntry> getInitProperties ();

} // ScriptBasedModule
