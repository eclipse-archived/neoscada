/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.TimeTrigger#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.TimeTrigger#getOnTrigger <em>On Trigger</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getTimeTrigger()
 * @model
 * @generated
 */
public interface TimeTrigger extends EObject
{
    /**
     * Returns the value of the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Period</em>' attribute.
     * @see #setPeriod(long)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getTimeTrigger_Period()
     * @model required="true"
     * @generated
     */
    long getPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.TimeTrigger#getPeriod <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Period</em>' attribute.
     * @see #getPeriod()
     * @generated
     */
    void setPeriod ( long value );

    /**
     * Returns the value of the '<em><b>On Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Trigger</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Trigger</em>' attribute.
     * @see #setOnTrigger(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getTimeTrigger_OnTrigger()
     * @model required="true"
     * @generated
     */
    String getOnTrigger ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.TimeTrigger#getOnTrigger <em>On Trigger</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Trigger</em>' attribute.
     * @see #getOnTrigger()
     * @generated
     */
    void setOnTrigger ( String value );

} // TimeTrigger
