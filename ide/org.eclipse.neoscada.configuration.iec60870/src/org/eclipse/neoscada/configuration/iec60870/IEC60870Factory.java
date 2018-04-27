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
package org.eclipse.neoscada.configuration.iec60870;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package
 * @generated
 */
public interface IEC60870Factory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    IEC60870Factory eINSTANCE = org.eclipse.neoscada.configuration.iec60870.impl.IEC60870FactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Exporter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exporter</em>'.
     * @generated
     */
    Exporter createExporter ();

    /**
     * Returns a new object of class '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Device</em>'.
     * @generated
     */
    Device createDevice ();

    /**
     * Returns a new object of class '<em>Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Item</em>'.
     * @generated
     */
    Item createItem ();

    /**
     * Returns a new object of class '<em>Exporter Item Interceptor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exporter Item Interceptor</em>'.
     * @generated
     */
    ExporterItemInterceptor createExporterItemInterceptor ();

    /**
     * Returns a new object of class '<em>Protocol Options</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Protocol Options</em>'.
     * @generated
     */
    ProtocolOptions createProtocolOptions ();

    /**
     * Returns a new object of class '<em>Data Module Options</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Module Options</em>'.
     * @generated
     */
    DataModuleOptions createDataModuleOptions ();

    /**
     * Returns a new object of class '<em>Client Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Client Device</em>'.
     * @generated
     */
    ClientDevice createClientDevice ();

    /**
     * Returns a new object of class '<em>Driver Application</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Driver Application</em>'.
     * @generated
     */
    DriverApplication createDriverApplication ();

    /**
     * Returns a new object of class '<em>Client Data Module Options</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Client Data Module Options</em>'.
     * @generated
     */
    ClientDataModuleOptions createClientDataModuleOptions ();

    /**
     * Returns a new object of class '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Driver</em>'.
     * @generated
     */
    IEC60870Driver createIEC60870Driver ();

    /**
     * Returns a new object of class '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Device</em>'.
     * @generated
     */
    IEC60870Device createIEC60870Device ();

    /**
     * Returns a new object of class '<em>Item Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Item Type</em>'.
     * @generated
     */
    ItemType createItemType ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    IEC60870Package getIEC60870Package ();

} //IEC60870Factory
