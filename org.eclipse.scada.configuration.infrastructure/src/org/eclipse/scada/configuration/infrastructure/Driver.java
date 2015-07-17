/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.scada.configuration.infrastructure.Driver#getNode
 * <em>Node</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.infrastructure.Driver#getProtocolTypeTag
 * <em>Protocol Type Tag</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getDriver()
 * @model abstract="true"
 * @generated
 */
public interface Driver extends NamedApplication
{
    /**
     * Returns the value of the '<em><b>Node</b></em>' container reference.
     * It is bidirectional and its opposite is '
     * {@link org.eclipse.scada.configuration.infrastructure.SystemNode#getDrivers
     * <em>Drivers</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Node</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Node</em>' container reference.
     * @see #setNode(SystemNode)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getDriver_Node()
     * @see org.eclipse.scada.configuration.infrastructure.SystemNode#getDrivers
     * @model opposite="drivers" required="true" transient="false"
     * @generated
     */
    SystemNode getNode ();

    /**
     * Sets the value of the '
     * {@link org.eclipse.scada.configuration.infrastructure.Driver#getNode
     * <em>Node</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Node</em>' container reference.
     * @see #getNode()
     * @generated
     */
    void setNode ( SystemNode value );

    /**
     * Returns the value of the '<em><b>Protocol Type Tag</b></em>' attribute.
     * The default value is <code>"ngp"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol Type Tag</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Protocol Type Tag</em>' attribute.
     * @see #setProtocolTypeTag(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getDriver_ProtocolTypeTag()
     * @model default="ngp"
     * @generated
     */
    String getProtocolTypeTag ();

    /**
     * Sets the value of the '
     * {@link org.eclipse.scada.configuration.infrastructure.Driver#getProtocolTypeTag
     * <em>Protocol Type Tag</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Protocol Type Tag</em>' attribute.
     * @see #getProtocolTypeTag()
     * @generated
     */
    void setProtocolTypeTag ( String value );

} // Driver
