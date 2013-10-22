/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.Credentials;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equinox Driver</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getUserService <em>User Service</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getInstanceNumber <em>Instance Number</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getAccessCredentials <em>Access Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getSecurityConfiguration <em>Security Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxDriver()
 * @model
 * @generated
 */
public interface EquinoxDriver extends AbstractFactoryDriver
{
    /**
     * Returns the value of the '<em><b>User Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>User Service</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>User Service</em>' containment reference.
     * @see #setUserService(UserService)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxDriver_UserService()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    UserService getUserService ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getUserService <em>User Service</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>User Service</em>' containment reference.
     * @see #getUserService()
     * @generated
     */
    void setUserService ( UserService value );

    /**
     * Returns the value of the '<em><b>Instance Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance Number</em>' attribute.
     * @see #setInstanceNumber(int)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxDriver_InstanceNumber()
     * @model required="true"
     * @generated
     */
    int getInstanceNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getInstanceNumber <em>Instance Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance Number</em>' attribute.
     * @see #getInstanceNumber()
     * @generated
     */
    void setInstanceNumber ( int value );

    /**
     * Returns the value of the '<em><b>Access Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Access Credentials</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Access Credentials</em>' containment reference.
     * @see #setAccessCredentials(Credentials)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxDriver_AccessCredentials()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Credentials getAccessCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getAccessCredentials <em>Access Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Access Credentials</em>' containment reference.
     * @see #getAccessCredentials()
     * @generated
     */
    void setAccessCredentials ( Credentials value );

    /**
     * Returns the value of the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Security Configuration</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Security Configuration</em>' reference.
     * @see #setSecurityConfiguration(Configuration)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxDriver_SecurityConfiguration()
     * @model
     * @generated
     */
    Configuration getSecurityConfiguration ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver#getSecurityConfiguration <em>Security Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Security Configuration</em>' reference.
     * @see #getSecurityConfiguration()
     * @generated
     */
    void setSecurityConfiguration ( Configuration value );

} // EquinoxDriver
