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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.configuration.world.Endpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getRack <em>Rack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getSlot <em>Slot</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getReadTimeout <em>Read Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveCommunicationProcessor()
 * @model
 * @generated
 */
public interface DaveCommunicationProcessor extends EObject
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
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveCommunicationProcessor_Endpoint()
     * @model required="true"
     * @generated
     */
    Endpoint getEndpoint ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getEndpoint <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint</em>' reference.
     * @see #getEndpoint()
     * @generated
     */
    void setEndpoint ( Endpoint value );

    /**
     * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.dave.DaveRequestBlock}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.dave.DaveRequestBlock#getDevice <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Blocks</em>' containment reference list.
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveCommunicationProcessor_Blocks()
     * @see org.eclipse.scada.configuration.dave.DaveRequestBlock#getDevice
     * @model opposite="device" containment="true" resolveProxies="true"
     * @generated
     */
    EList<DaveRequestBlock> getBlocks ();

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
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveCommunicationProcessor_Id()
     * @model id="true" required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Rack</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rack</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rack</em>' attribute.
     * @see #setRack(int)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveCommunicationProcessor_Rack()
     * @model required="true"
     * @generated
     */
    int getRack ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getRack <em>Rack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rack</em>' attribute.
     * @see #getRack()
     * @generated
     */
    void setRack ( int value );

    /**
     * Returns the value of the '<em><b>Slot</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Slot</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Slot</em>' attribute.
     * @see #setSlot(int)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveCommunicationProcessor_Slot()
     * @model required="true"
     * @generated
     */
    int getSlot ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getSlot <em>Slot</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Slot</em>' attribute.
     * @see #getSlot()
     * @generated
     */
    void setSlot ( int value );

    /**
     * Returns the value of the '<em><b>Read Timeout</b></em>' attribute.
     * The default value is <code>"5000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Read Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Read Timeout</em>' attribute.
     * @see #setReadTimeout(int)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveCommunicationProcessor_ReadTimeout()
     * @model default="5000" required="true"
     * @generated
     */
    int getReadTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveCommunicationProcessor#getReadTimeout <em>Read Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Read Timeout</em>' attribute.
     * @see #getReadTimeout()
     * @generated
     */
    void setReadTimeout ( int value );

} // DaveCommunicationProcessor
