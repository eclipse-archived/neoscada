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
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.osgi.IndependentConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equinox Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getInstanceNumber <em>Instance Number</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getLocalCredentials <em>Local Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getSecurityConfiguration <em>Security Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getModules <em>Modules</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication()
 * @model abstract="true"
 * @generated
 */
public interface EquinoxApplication extends EObject
{
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
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Instance Number</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Instance Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Instance Number</em>' attribute.
     * @see #setInstanceNumber(int)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication_InstanceNumber()
     * @model default="1" required="true"
     * @generated
     */
    int getInstanceNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getInstanceNumber <em>Instance Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance Number</em>' attribute.
     * @see #getInstanceNumber()
     * @generated
     */
    void setInstanceNumber ( int value );

    /**
     * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.IndependentConfiguration}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configurations</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configurations</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication_Configurations()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<IndependentConfiguration> getConfigurations ();

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
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication_Configuration()
     * @model
     * @generated
     */
    ApplicationConfiguration getConfiguration ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getConfiguration <em>Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration</em>' reference.
     * @see #getConfiguration()
     * @generated
     */
    void setConfiguration ( ApplicationConfiguration value );

    /**
     * Returns the value of the '<em><b>Local Credentials</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Credentials</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Credentials</em>' reference.
     * @see #setLocalCredentials(Credentials)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication_LocalCredentials()
     * @model
     * @generated
     */
    Credentials getLocalCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getLocalCredentials <em>Local Credentials</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Credentials</em>' reference.
     * @see #getLocalCredentials()
     * @generated
     */
    void setLocalCredentials ( Credentials value );

    /**
     * Returns the value of the '<em><b>Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Security Configuration</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Security Configuration</em>' reference.
     * @see #setSecurityConfiguration(Configuration)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication_SecurityConfiguration()
     * @model
     * @generated
     */
    Configuration getSecurityConfiguration ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EquinoxApplication#getSecurityConfiguration <em>Security Configuration</em>}' reference.
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
     * If the meaning of the '<em>Modules</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Modules</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEquinoxApplication_Modules()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Module> getModules ();

} // EquinoxApplication
