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
package org.eclipse.scada.configuration.component;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Calculation Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.CalculationComponent#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.CalculationComponent#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.CalculationComponent#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.CalculationComponent#getInitProperties <em>Init Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getCalculationComponent()
 * @model
 * @generated
 */
public interface CalculationComponent extends NamedDocumentable, MasterComponent
{
    /**
     * Returns the value of the '<em><b>Implementation</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Implementation</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Implementation</em>' reference.
     * @see #setImplementation(CalculationModule)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getCalculationComponent_Implementation()
     * @model required="true"
     * @generated
     */
    CalculationModule getImplementation ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.CalculationComponent#getImplementation <em>Implementation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Implementation</em>' reference.
     * @see #getImplementation()
     * @generated
     */
    void setImplementation ( CalculationModule value );

    /**
     * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.OutputDefinition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outputs</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outputs</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getCalculationComponent_Outputs()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<OutputDefinition> getOutputs ();

    /**
     * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.InputDefinition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inputs</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inputs</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getCalculationComponent_Inputs()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<InputDefinition> getInputs ();

    /**
     * Returns the value of the '<em><b>Init Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Init Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Init Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getCalculationComponent_InitProperties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getInitProperties ();

} // CalculationComponent
