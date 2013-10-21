/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.Protocol;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getMessages <em>Messages</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getStructures <em>Structures</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getPackagePrefix <em>Package Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getIncludedProtocols <em>Included Protocols</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getLicenseHeader <em>License Header</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getEnums <em>Enums</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol()
 * @model
 * @generated
 */
public interface Protocol extends DocumentedElement
{
    /**
     * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.protocol.ngp.model.Protocol.Message}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Message#getProtocol <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Messages</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Messages</em>' containment reference list.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol_Messages()
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Message#getProtocol
     * @model opposite="protocol" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Message> getMessages ();

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Included Protocols</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Included Protocols</em>' reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Included Protocols</em>' reference list.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol_IncludedProtocols()
     * @model
     * @generated
     */
    EList<Protocol> getIncludedProtocols ();

    /**
     * Returns the value of the '<em><b>License Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>License Header</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>License Header</em>' attribute.
     * @see #setLicenseHeader(String)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol_LicenseHeader()
     * @model
     * @generated
     */
    String getLicenseHeader ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getLicenseHeader <em>License Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>License Header</em>' attribute.
     * @see #getLicenseHeader()
     * @generated
     */
    void setLicenseHeader ( String value );

    /**
     * Returns the value of the '<em><b>Enums</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getProtocol <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enums</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enums</em>' containment reference list.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol_Enums()
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getProtocol
     * @model opposite="protocol" containment="true" resolveProxies="true"
     * @generated
     */
    EList<org.eclipse.scada.protocol.ngp.model.Protocol.Enum> getEnums ();

    /**
     * Returns the value of the '<em><b>Interfaces</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.protocol.ngp.model.Protocol.Interface}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Interface#getProtocol <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interfaces</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interfaces</em>' containment reference list.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol_Interfaces()
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Interface#getProtocol
     * @model opposite="protocol" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Interface> getInterfaces ();

    /**
     * Returns the value of the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(short)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol_Version()
     * @model required="true"
     * @generated
     */
    short getVersion ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion ( short value );

    /**
     * Returns the value of the '<em><b>Structures</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.protocol.ngp.model.Protocol.Structure}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Structure#getProtocol <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Structures</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Structures</em>' containment reference list.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol_Structures()
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Structure#getProtocol
     * @model opposite="protocol" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Structure> getStructures ();

    /**
     * Returns the value of the '<em><b>Package Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Package Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Package Prefix</em>' attribute.
     * @see #setPackagePrefix(String)
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#getProtocol_PackagePrefix()
     * @model required="true"
     * @generated
     */
    String getPackagePrefix ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getPackagePrefix <em>Package Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Package Prefix</em>' attribute.
     * @see #getPackagePrefix()
     * @generated
     */
    void setPackagePrefix ( String value );

} // Protocol
