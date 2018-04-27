/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.Endpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Client Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getProtocolOptions <em>Protocol Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getDataModuleOptions <em>Data Module Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getItemTypes <em>Item Types</em>}</li>
 * </ul>
 *
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getClientDevice()
 * @model
 * @generated
 */
public interface ClientDevice extends EObject
{
    /**
     * Returns the value of the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint</em>' reference.
     * @see #setEndpoint(Endpoint)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getClientDevice_Endpoint()
     * @model required="true"
     * @generated
     */
    Endpoint getEndpoint ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getEndpoint <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint</em>' reference.
     * @see #getEndpoint()
     * @generated
     */
    void setEndpoint ( Endpoint value );

    /**
     * Returns the value of the '<em><b>Protocol Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol Options</em>' containment reference
     * isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol Options</em>' containment reference.
     * @see #setProtocolOptions(ProtocolOptions)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getClientDevice_ProtocolOptions()
     * @model containment="true"
     * @generated
     */
    ProtocolOptions getProtocolOptions ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getProtocolOptions <em>Protocol Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol Options</em>' containment reference.
     * @see #getProtocolOptions()
     * @generated
     */
    void setProtocolOptions ( ProtocolOptions value );

    /**
     * Returns the value of the '<em><b>Data Module Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Module Options</em>' containment
     * reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Module Options</em>' containment reference.
     * @see #setDataModuleOptions(ClientDataModuleOptions)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getClientDevice_DataModuleOptions()
     * @model containment="true"
     * @generated
     */
    ClientDataModuleOptions getDataModuleOptions ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getDataModuleOptions <em>Data Module Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Module Options</em>' containment reference.
     * @see #getDataModuleOptions()
     * @generated
     */
    void setDataModuleOptions ( ClientDataModuleOptions value );

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getClientDevice_Id()
     * @model required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ClientDevice#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Item Types</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.neoscada.configuration.iec60870.ItemType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item Types</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item Types</em>' containment reference list.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getClientDevice_ItemTypes()
     * @model containment="true"
     * @generated
     */
    EList<ItemType> getItemTypes ();

} // ClientDevice
