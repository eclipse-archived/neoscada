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

import org.eclipse.scada.core.Variant;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffered Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.BufferedValue#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.BufferedValue#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.BufferedValue#getRange <em>Range</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.BufferedValue#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.BufferedValue#getPersistence <em>Persistence</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.BufferedValue#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.BufferedValue#isTriggerOnly <em>Trigger Only</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getBufferedValue()
 * @model
 * @generated
 */
public interface BufferedValue extends MasterComponent
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getBufferedValue_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.BufferedValue#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Input</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input</em>' containment reference.
     * @see #setInput(InputDefinition)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getBufferedValue_Input()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    InputDefinition getInput ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.BufferedValue#getInput <em>Input</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input</em>' containment reference.
     * @see #getInput()
     * @generated
     */
    void setInput ( InputDefinition value );

    /**
     * Returns the value of the '<em><b>Range</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Range</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Range</em>' attribute.
     * @see #setRange(long)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getBufferedValue_Range()
     * @model required="true"
     * @generated
     */
    long getRange ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.BufferedValue#getRange <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Range</em>' attribute.
     * @see #getRange()
     * @generated
     */
    void setRange ( long value );

    /**
     * Returns the value of the '<em><b>Initial Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initial Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initial Value</em>' attribute.
     * @see #setInitialValue(Variant)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getBufferedValue_InitialValue()
     * @model dataType="org.eclipse.scada.configuration.world.osgi.Variant"
     * @generated
     */
    Variant getInitialValue ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.BufferedValue#getInitialValue <em>Initial Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initial Value</em>' attribute.
     * @see #getInitialValue()
     * @generated
     */
    void setInitialValue ( Variant value );

    /**
     * Returns the value of the '<em><b>Persistence</b></em>' attribute.
     * The default value is <code>"NONE"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.component.Persistence}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Persistence</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Persistence</em>' attribute.
     * @see org.eclipse.scada.configuration.component.Persistence
     * @see #setPersistence(Persistence)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getBufferedValue_Persistence()
     * @model default="NONE" required="true"
     * @generated
     */
    Persistence getPersistence ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.BufferedValue#getPersistence <em>Persistence</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Persistence</em>' attribute.
     * @see org.eclipse.scada.configuration.component.Persistence
     * @see #getPersistence()
     * @generated
     */
    void setPersistence ( Persistence value );

    /**
     * Returns the value of the '<em><b>Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Trigger</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Trigger</em>' attribute.
     * @see #setTrigger(long)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getBufferedValue_Trigger()
     * @model required="true"
     * @generated
     */
    long getTrigger ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.BufferedValue#getTrigger <em>Trigger</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Trigger</em>' attribute.
     * @see #getTrigger()
     * @generated
     */
    void setTrigger ( long value );

    /**
     * Returns the value of the '<em><b>Trigger Only</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Trigger Only</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Trigger Only</em>' attribute.
     * @see #setTriggerOnly(boolean)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getBufferedValue_TriggerOnly()
     * @model default="false"
     * @generated
     */
    boolean isTriggerOnly ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.BufferedValue#isTriggerOnly <em>Trigger Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Trigger Only</em>' attribute.
     * @see #isTriggerOnly()
     * @generated
     */
    void setTriggerOnly ( boolean value );

} // BufferedValue
