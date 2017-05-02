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

import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.script.Script;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exporter Interceptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor#getSettings <em>Settings</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor#getScript <em>Script</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterInterceptor()
 * @model
 * @generated
 */
public interface ModbusExporterInterceptor extends ItemInterceptor
{
    /**
     * Returns the value of the '<em><b>Settings</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Settings</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Settings</em>' reference.
     * @see #setSettings(ModbusExporterModule)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterInterceptor_Settings()
     * @model required="true"
     * @generated
     */
    ModbusExporterModule getSettings ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor#getSettings <em>Settings</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Settings</em>' reference.
     * @see #getSettings()
     * @generated
     */
    void setSettings ( ModbusExporterModule value );

    /**
     * Returns the value of the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script</em>' containment reference.
     * @see #setScript(Script)
     * @see org.eclipse.scada.configuration.modbus.ModbusPackage#getModbusExporterInterceptor_Script()
     * @model containment="true" required="true"
     * @generated
     */
    Script getScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor#getScript <em>Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' containment reference.
     * @see #getScript()
     * @generated
     */
    void setScript ( Script value );

} // ModbusExporterInterceptor
