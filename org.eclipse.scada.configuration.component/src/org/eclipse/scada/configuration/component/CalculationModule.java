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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calculation Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.CalculationModule#getKnownInputs <em>Known Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.CalculationModule#getKnownOutputs <em>Known Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getCalculationModule()
 * @model abstract="true"
 * @generated
 */
public interface CalculationModule extends Service
{
    /**
     * Returns the value of the '<em><b>Known Inputs</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.InputSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Known Inputs</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Known Inputs</em>' reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getCalculationModule_KnownInputs()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    EList<InputSpecification> getKnownInputs ();

    /**
     * Returns the value of the '<em><b>Known Outputs</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.OutputSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Known Outputs</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Known Outputs</em>' reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getCalculationModule_KnownOutputs()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    EList<OutputSpecification> getKnownOutputs ();

} // CalculationModule
