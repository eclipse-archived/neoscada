/**
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH.
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.osgi.IndependentConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equinox Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getInstanceNumber <em>Instance Number</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getUserService <em>User Service</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getSecurityConfiguration <em>Security Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxBase()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EquinoxBase extends NamedApplication
{
    /**
     * Returns the value of the '<em><b>Instance Number</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance Number</em>' attribute.
     * @see #setInstanceNumber(int)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxBase_InstanceNumber()
     * @model default="-1" required="true"
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
     * If the meaning of the '<em>User Service</em>' containment reference isn't
     * clear,
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
     * If the meaning of the '<em>Security Configuration</em>' reference isn't
     * clear,
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

    /**
     * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.Module}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Modules</em>' containment reference list isn't
     * clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Modules</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxBase_Modules()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Module> getModules ();

    /**
     * Returns the value of the '<em><b>Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configuration</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configuration</em>' reference.
     * @see #setConfiguration(ApplicationConfiguration)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxBase_Configuration()
     * @model
     * @generated
     */
    ApplicationConfiguration getConfiguration ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxBase#getConfiguration <em>Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration</em>' reference.
     * @see #getConfiguration()
     * @generated
     */
    void setConfiguration ( ApplicationConfiguration value );

    /**
     * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.IndependentConfiguration}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configurations</em>' containment reference
     * list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configurations</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxBase_Configurations()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<IndependentConfiguration> getConfigurations ();

} // EquinoxBase
