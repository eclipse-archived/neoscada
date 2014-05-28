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
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.configuration.security.Configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equinox Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getInstanceNumber <em>Instance Number</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getUserService <em>User Service</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getSecurityConfiguration <em>Security Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxBase()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EquinoxBase extends EObject
{
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
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxBase_InstanceNumber()
     * @model required="true"
     * @generated
     */
    int getInstanceNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getInstanceNumber <em>Instance Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance Number</em>' attribute.
     * @see #getInstanceNumber()
     * @generated
     */
    void setInstanceNumber ( int value );

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
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxBase_UserService()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    UserService getUserService ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getUserService <em>User Service</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>User Service</em>' containment reference.
     * @see #getUserService()
     * @generated
     */
    void setUserService ( UserService value );

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
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxBase_SecurityConfiguration()
     * @model
     * @generated
     */
    Configuration getSecurityConfiguration ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getSecurityConfiguration <em>Security Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Security Configuration</em>' reference.
     * @see #getSecurityConfiguration()
     * @generated
     */
    void setSecurityConfiguration ( Configuration value );

} // EquinoxBase
