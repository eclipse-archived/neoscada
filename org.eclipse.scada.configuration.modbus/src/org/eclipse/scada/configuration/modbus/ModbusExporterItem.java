/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.modbus;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.osgi.Item;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exporter Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterItem()
 * @model
 * @generated
 */
public interface ModbusExporterItem extends EObject
{
    /**
     * Returns the value of the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' reference.
     * @see #setSource(Item)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterItem_Source()
     * @model required="true"
     * @generated
     */
    Item getSource ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem#getSource <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' reference.
     * @see #getSource()
     * @generated
     */
    void setSource ( Item value );

    /**
     * Returns the value of the '<em><b>Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Offset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Offset</em>' attribute.
     * @see #setOffset(int)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterItem_Offset()
     * @model required="true"
     * @generated
     */
    int getOffset ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem#getOffset <em>Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Offset</em>' attribute.
     * @see #getOffset()
     * @generated
     */
    void setOffset ( int value );

    /**
     * Returns the value of the '<em><b>Type</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' containment reference.
     * @see #setType(ModbusDataType)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterItem_Type()
     * @model containment="true" required="true"
     * @generated
     */
    ModbusDataType getType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusExporterItem#getType <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' containment reference.
     * @see #getType()
     * @generated
     */
    void setType ( ModbusDataType value );

} // ModbusExporterItem
