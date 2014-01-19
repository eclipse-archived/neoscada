/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
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
import org.eclipse.scada.configuration.world.osgi.ChangeType;
import org.eclipse.scada.configuration.world.osgi.ErrorHandling;
import org.eclipse.scada.core.Variant;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Counter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.ChangeCounter#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.ChangeCounter#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.ChangeCounter#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.ChangeCounter#getOnError <em>On Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getChangeCounter()
 * @model
 * @generated
 */
public interface ChangeCounter extends SingleValue
{
    /**
     * Returns the value of the '<em><b>Buffer</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Buffer</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Buffer</em>' reference.
     * @see #setBuffer(BufferedValue)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getChangeCounter_Buffer()
     * @model
     * @generated
     */
    BufferedValue getBuffer ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.ChangeCounter#getBuffer <em>Buffer</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Buffer</em>' reference.
     * @see #getBuffer()
     * @generated
     */
    void setBuffer ( BufferedValue value );

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.osgi.ChangeType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.ChangeType
     * @see #setType(ChangeType)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getChangeCounter_Type()
     * @model
     * @generated
     */
    ChangeType getType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.ChangeCounter#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.ChangeType
     * @see #getType()
     * @generated
     */
    void setType ( ChangeType value );

    /**
     * Returns the value of the '<em><b>Values</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.scada.core.Variant}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Values</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Values</em>' attribute list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getChangeCounter_Values()
     * @model dataType="org.eclipse.scada.configuration.world.osgi.Variant" required="true"
     * @generated
     */
    EList<Variant> getValues ();

    /**
     * Returns the value of the '<em><b>On Error</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.osgi.ErrorHandling}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Error</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Error</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.ErrorHandling
     * @see #setOnError(ErrorHandling)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getChangeCounter_OnError()
     * @model
     * @generated
     */
    ErrorHandling getOnError ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.ChangeCounter#getOnError <em>On Error</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Error</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.ErrorHandling
     * @see #getOnError()
     * @generated
     */
    void setOnError ( ErrorHandling value );

} // ChangeCounter
