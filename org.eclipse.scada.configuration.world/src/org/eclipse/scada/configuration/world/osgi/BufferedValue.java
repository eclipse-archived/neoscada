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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.core.Variant;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffered Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getRange <em>Range</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getTriggerOnly <em>Trigger Only</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getPersistence <em>Persistence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBufferedValue()
 * @model
 * @generated
 */
public interface BufferedValue extends NamedDocumentable
{
    /**
     * Returns the value of the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item</em>' containment reference.
     * @see #setItem(ItemReference)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBufferedValue_Item()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    ItemReference getItem ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getItem <em>Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Item</em>' containment reference.
     * @see #getItem()
     * @generated
     */
    void setItem ( ItemReference value );

    /**
     * Returns the value of the '<em><b>Initial Value</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initial Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initial Value</em>' attribute.
     * @see #setInitialValue(Variant)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBufferedValue_InitialValue()
     * @model default="" dataType="org.eclipse.scada.configuration.world.osgi.Variant"
     * @generated
     */
    Variant getInitialValue ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getInitialValue <em>Initial Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initial Value</em>' attribute.
     * @see #getInitialValue()
     * @generated
     */
    void setInitialValue ( Variant value );

    /**
     * Returns the value of the '<em><b>Range</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The number of seconds the average will be calculated for.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Range</em>' attribute.
     * @see #setRange(long)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBufferedValue_Range()
     * @model required="true"
     * @generated
     */
    long getRange ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getRange <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Range</em>' attribute.
     * @see #getRange()
     * @generated
     */
    void setRange ( long value );

    /**
     * Returns the value of the '<em><b>Trigger</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A period time in seconds when the average will be updated although no value has changed.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Trigger</em>' attribute.
     * @see #setTrigger(long)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBufferedValue_Trigger()
     * @model default="1" required="true"
     * @generated
     */
    long getTrigger ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getTrigger <em>Trigger</em>}' attribute.
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
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A flag which decides if the average is only updated by time (true) or also by value change (false).
     * <!-- end-model-doc -->
     * @return the value of the '<em>Trigger Only</em>' attribute.
     * @see #setTriggerOnly(Boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBufferedValue_TriggerOnly()
     * @model default="false"
     * @generated
     */
    Boolean getTriggerOnly ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getTriggerOnly <em>Trigger Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Trigger Only</em>' attribute.
     * @see #getTriggerOnly()
     * @generated
     */
    void setTriggerOnly ( Boolean value );

    /**
     * Returns the value of the '<em><b>Persistence</b></em>' attribute.
     * The default value is <code>"NONE"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.osgi.Persistence}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Persistence</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Persistence</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.Persistence
     * @see #setPersistence(Persistence)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBufferedValue_Persistence()
     * @model default="NONE"
     * @generated
     */
    Persistence getPersistence ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.BufferedValue#getPersistence <em>Persistence</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Persistence</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.Persistence
     * @see #getPersistence()
     * @generated
     */
    void setPersistence ( Persistence value );

} // BufferedValue
