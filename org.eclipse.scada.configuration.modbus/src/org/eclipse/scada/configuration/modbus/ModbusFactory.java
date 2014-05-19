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
package org.eclipse.scada.configuration.modbus;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.modbus.ModbusPackage
 * @generated
 */
public interface ModbusFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModbusFactory eINSTANCE = org.eclipse.scada.configuration.modbus.impl.ModbusFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Device</em>'.
     * @generated
     */
    ModbusDevice createModbusDevice ();

    /**
     * Returns a new object of class '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Driver</em>'.
     * @generated
     */
    ModbusDriver createModbusDriver ();

    /**
     * Returns a new object of class '<em>Slave</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Slave</em>'.
     * @generated
     */
    ModbusSlave createModbusSlave ();

    /**
     * Returns a new object of class '<em>Master</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Master</em>'.
     * @generated
     */
    ModbusMaster createModbusMaster ();

    /**
     * Returns a new object of class '<em>Block</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Block</em>'.
     * @generated
     */
    ModbusBlock createModbusBlock ();

    /**
     * Returns a new object of class '<em>Exporter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exporter</em>'.
     * @generated
     */
    ModbusExporter createModbusExporter ();

    /**
     * Returns a new object of class '<em>Exporter Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exporter Device</em>'.
     * @generated
     */
    ModbusExporterDevice createModbusExporterDevice ();

    /**
     * Returns a new object of class '<em>Exporter Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exporter Item</em>'.
     * @generated
     */
    ModbusExporterItem createModbusExporterItem ();

    /**
     * Returns a new object of class '<em>Double</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Double</em>'.
     * @generated
     */
    ModbusDouble createModbusDouble ();

    /**
     * Returns a new object of class '<em>SInt16</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>SInt16</em>'.
     * @generated
     */
    ModbusSInt16 createModbusSInt16 ();

    /**
     * Returns a new object of class '<em>SInt32</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>SInt32</em>'.
     * @generated
     */
    ModbusSInt32 createModbusSInt32 ();

    /**
     * Returns a new object of class '<em>UInt16</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>UInt16</em>'.
     * @generated
     */
    ModbusUInt16 createModbusUInt16 ();

    /**
     * Returns a new object of class '<em>UInt32</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>UInt32</em>'.
     * @generated
     */
    ModbusUInt32 createModbusUInt32 ();

    /**
     * Returns a new object of class '<em>Exporter Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exporter Module</em>'.
     * @generated
     */
    ModbusExporterModule createModbusExporterModule ();

    /**
     * Returns a new object of class '<em>Exporter Interceptor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exporter Interceptor</em>'.
     * @generated
     */
    ModbusExporterInterceptor createModbusExporterInterceptor ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ModbusPackage getModbusPackage ();

} //ModbusFactory
