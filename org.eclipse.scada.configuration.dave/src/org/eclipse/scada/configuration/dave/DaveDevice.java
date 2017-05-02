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
package org.eclipse.scada.configuration.dave;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.memory.TypeSystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveDevice#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveDevice#getRack <em>Rack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveDevice#getSlot <em>Slot</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveDevice#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveDevice#getTypeSystem <em>Type System</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveDevice#getReadTimeout <em>Read Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveDevice()
 * @model
 * @generated
 */
public interface DaveDevice extends Device
{

    /**
     * Returns the value of the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Port</em>' attribute.
     * @see #setPort(int)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveDevice_Port()
     * @model required="true"
     * @generated
     */
    int getPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveDevice#getPort <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port</em>' attribute.
     * @see #getPort()
     * @generated
     */
    void setPort ( int value );

    /**
     * Returns the value of the '<em><b>Rack</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rack</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rack</em>' attribute.
     * @see #setRack(short)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveDevice_Rack()
     * @model required="true"
     * @generated
     */
    short getRack ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveDevice#getRack <em>Rack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rack</em>' attribute.
     * @see #getRack()
     * @generated
     */
    void setRack ( short value );

    /**
     * Returns the value of the '<em><b>Slot</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Slot</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Slot</em>' attribute.
     * @see #setSlot(short)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveDevice_Slot()
     * @model required="true"
     * @generated
     */
    short getSlot ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveDevice#getSlot <em>Slot</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Slot</em>' attribute.
     * @see #getSlot()
     * @generated
     */
    void setSlot ( short value );

    /**
     * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.dave.DaveBlockDefinition}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getDevice <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Blocks</em>' containment reference list.
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveDevice_Blocks()
     * @see org.eclipse.scada.configuration.dave.DaveBlockDefinition#getDevice
     * @model opposite="device" containment="true" resolveProxies="true"
     * @generated
     */
    EList<DaveBlockDefinition> getBlocks ();

    /**
     * Returns the value of the '<em><b>Type System</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type System</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type System</em>' reference.
     * @see #setTypeSystem(TypeSystem)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveDevice_TypeSystem()
     * @model required="true"
     * @generated
     */
    TypeSystem getTypeSystem ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveDevice#getTypeSystem <em>Type System</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type System</em>' reference.
     * @see #getTypeSystem()
     * @generated
     */
    void setTypeSystem ( TypeSystem value );

    /**
     * Returns the value of the '<em><b>Read Timeout</b></em>' attribute.
     * The default value is <code>"5000"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The read timeout in milliseconds.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Read Timeout</em>' attribute.
     * @see #setReadTimeout(int)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveDevice_ReadTimeout()
     * @model default="5000" required="true"
     * @generated
     */
    int getReadTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveDevice#getReadTimeout <em>Read Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Read Timeout</em>' attribute.
     * @see #getReadTimeout()
     * @generated
     */
    void setReadTimeout ( int value );
} // DaveDevice
