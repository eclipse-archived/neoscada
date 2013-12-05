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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.Documentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.ScriptModule#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.ScriptModule#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.ScriptModule#getScriptEngine <em>Script Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getScriptModule()
 * @model
 * @generated
 */
public interface ScriptModule extends Documentable, CalculationModule
{
    /**
     * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.InputSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inputs</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getScriptModule_Inputs()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<InputSpecification> getInputs ();

    /**
     * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.OutputSpecification}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outputs</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getScriptModule_Outputs()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<OutputSpecification> getOutputs ();

    /**
     * Returns the value of the '<em><b>Script Engine</b></em>' attribute.
     * The default value is <code>"JavaScript"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script Engine</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script Engine</em>' attribute.
     * @see #setScriptEngine(String)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getScriptModule_ScriptEngine()
     * @model default="JavaScript" required="true"
     * @generated
     */
    String getScriptEngine ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.ScriptModule#getScriptEngine <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script Engine</em>' attribute.
     * @see #getScriptEngine()
     * @generated
     */
    void setScriptEngine ( String value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getInputs ();'"
     * @generated
     */
    EList<InputSpecification> getKnownInputs ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model notificationDataType="org.eclipse.scada.configuration.component.Notification"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='\tif ( notification.getFeature ().equals ( ComponentPackage.Literals.SCRIPT_MODULE__INPUTS ) )\n        {\n            super.eNotify ( new org.eclipse.emf.ecore.impl.ENotificationImpl ( this, notification.getEventType (), ComponentPackage.CALCULATION_MODULE__KNOWN_INPUTS, notification.getOldValue (), notification.getNewValue () ) );\n        }\n\tif ( notification.getFeature ().equals ( ComponentPackage.Literals.SCRIPT_MODULE__OUTPUTS ) )\n        {\n            super.eNotify ( new org.eclipse.emf.ecore.impl.ENotificationImpl ( this, notification.getEventType (), ComponentPackage.CALCULATION_MODULE__KNOWN_OUTPUTS, notification.getOldValue (), notification.getNewValue () ) );\n        }\n        super.eNotify ( notification );'"
     * @generated
     */
    void customENotify ( Notification notification );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getOutputs();'"
     * @generated
     */
    EList<OutputSpecification> getKnownOutputs ();

} // ScriptModule
