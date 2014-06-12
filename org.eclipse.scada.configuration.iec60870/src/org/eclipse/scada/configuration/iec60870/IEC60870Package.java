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
package org.eclipse.scada.configuration.iec60870;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.iec60870.IEC60870Factory
 * @model kind="package"
 * @generated
 */
public interface IEC60870Package extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "iec60870"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/IEC60870"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "iec60870"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    IEC60870Package eINSTANCE = org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.iec60870.impl.ExporterImpl <em>Exporter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.iec60870.impl.ExporterImpl
     * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getExporter()
     * @generated
     */
    int EXPORTER = 0;

    /**
     * The feature id for the '<em><b>Devices</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER__DEVICES = OsgiPackage.APPLICATION_MODULE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_FEATURE_COUNT = OsgiPackage.APPLICATION_MODULE_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Exporter</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXPORTER_OPERATION_COUNT = OsgiPackage.APPLICATION_MODULE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.iec60870.impl.DeviceImpl <em>Device</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.iec60870.impl.DeviceImpl
     * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getDevice()
     * @generated
     */
    int DEVICE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__ID = 0;

    /**
     * The feature id for the '<em><b>Items</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE__ITEMS = 1;

    /**
     * The number of structural features of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Device</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEVICE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.iec60870.impl.ItemImpl <em>Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.iec60870.impl.ItemImpl
     * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getItem()
     * @generated
     */
    int ITEM = 2;

    /**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__SOURCE = 0;

    /**
     * The feature id for the '<em><b>Address</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__ADDRESS = 1;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__TYPE = 2;

    /**
     * The number of structural features of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.iec60870.DataType <em>Data Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.iec60870.DataType
     * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getDataType()
     * @generated
     */
    int DATA_TYPE = 3;

    /**
     * The meta object id for the '<em>Address</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.iec60870.AddressInformation
     * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getAddress()
     * @generated
     */
    int ADDRESS = 4;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.iec60870.Exporter <em>Exporter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exporter</em>'.
     * @see org.eclipse.scada.configuration.iec60870.Exporter
     * @generated
     */
    EClass getExporter ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.iec60870.Exporter#getDevices <em>Devices</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Devices</em>'.
     * @see org.eclipse.scada.configuration.iec60870.Exporter#getDevices()
     * @see #getExporter()
     * @generated
     */
    EReference getExporter_Devices ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.iec60870.Device <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Device</em>'.
     * @see org.eclipse.scada.configuration.iec60870.Device
     * @generated
     */
    EClass getDevice ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.iec60870.Device#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.iec60870.Device#getId()
     * @see #getDevice()
     * @generated
     */
    EAttribute getDevice_Id ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.iec60870.Device#getItems <em>Items</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Items</em>'.
     * @see org.eclipse.scada.configuration.iec60870.Device#getItems()
     * @see #getDevice()
     * @generated
     */
    EReference getDevice_Items ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.iec60870.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item</em>'.
     * @see org.eclipse.scada.configuration.iec60870.Item
     * @generated
     */
    EClass getItem ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.iec60870.Item#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see org.eclipse.scada.configuration.iec60870.Item#getSource()
     * @see #getItem()
     * @generated
     */
    EReference getItem_Source ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.iec60870.Item#getAddress <em>Address</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Address</em>'.
     * @see org.eclipse.scada.configuration.iec60870.Item#getAddress()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Address ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.iec60870.Item#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.iec60870.Item#getType()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_Type ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.configuration.iec60870.DataType <em>Data Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Data Type</em>'.
     * @see org.eclipse.scada.configuration.iec60870.DataType
     * @generated
     */
    EEnum getDataType ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.configuration.iec60870.AddressInformation <em>Address</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Address</em>'.
     * @see org.eclipse.scada.configuration.iec60870.AddressInformation
     * @model instanceClass="org.eclipse.scada.configuration.iec60870.AddressInformation"
     * @generated
     */
    EDataType getAddress ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    IEC60870Factory getIEC60870Factory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.iec60870.impl.ExporterImpl <em>Exporter</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.iec60870.impl.ExporterImpl
         * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getExporter()
         * @generated
         */
        EClass EXPORTER = eINSTANCE.getExporter ();

        /**
         * The meta object literal for the '<em><b>Devices</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXPORTER__DEVICES = eINSTANCE.getExporter_Devices ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.iec60870.impl.DeviceImpl <em>Device</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.iec60870.impl.DeviceImpl
         * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getDevice()
         * @generated
         */
        EClass DEVICE = eINSTANCE.getDevice ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEVICE__ID = eINSTANCE.getDevice_Id ();

        /**
         * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEVICE__ITEMS = eINSTANCE.getDevice_Items ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.iec60870.impl.ItemImpl <em>Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.iec60870.impl.ItemImpl
         * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getItem()
         * @generated
         */
        EClass ITEM = eINSTANCE.getItem ();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM__SOURCE = eINSTANCE.getItem_Source ();

        /**
         * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__ADDRESS = eINSTANCE.getItem_Address ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__TYPE = eINSTANCE.getItem_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.iec60870.DataType <em>Data Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.iec60870.DataType
         * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getDataType()
         * @generated
         */
        EEnum DATA_TYPE = eINSTANCE.getDataType ();

        /**
         * The meta object literal for the '<em>Address</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.iec60870.AddressInformation
         * @see org.eclipse.scada.configuration.iec60870.impl.IEC60870PackageImpl#getAddress()
         * @generated
         */
        EDataType ADDRESS = eINSTANCE.getAddress ();

    }

} //IEC60870Package
