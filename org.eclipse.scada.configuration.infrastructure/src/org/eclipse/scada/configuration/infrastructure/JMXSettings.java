/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JMX Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getInstancePortOffset <em>Instance Port Offset</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getLocalOnly <em>Local Only</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getAuthenticated <em>Authenticated</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getSsl <em>Ssl</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#isAssignNodeHostname <em>Assign Node Hostname</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getJMXSettings()
 * @model
 * @generated
 */
public interface JMXSettings extends Module
{
    /**
     * Returns the value of the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The specific port number to use. If this is empty then the instance port number will be tried next.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Port</em>' attribute.
     * @see #setPort(Integer)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getJMXSettings_Port()
     * @model
     * @generated
     */
    Integer getPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getPort <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port</em>' attribute.
     * @see #getPort()
     * @generated
     */
    void setPort ( Integer value );

    /**
     * Returns the value of the '<em><b>Instance Port Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * An offset which will be applied to the instance number and used as port. If it is empty and the specific port number is also not set then the JMX port will not be set.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Instance Port Offset</em>' attribute.
     * @see #setInstancePortOffset(Integer)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getJMXSettings_InstancePortOffset()
     * @model
     * @generated
     */
    Integer getInstancePortOffset ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getInstancePortOffset <em>Instance Port Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Instance Port Offset</em>' attribute.
     * @see #getInstancePortOffset()
     * @generated
     */
    void setInstancePortOffset ( Integer value );

    /**
     * Returns the value of the '<em><b>Local Only</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Only</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Only</em>' attribute.
     * @see #setLocalOnly(Boolean)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getJMXSettings_LocalOnly()
     * @model
     * @generated
     */
    Boolean getLocalOnly ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getLocalOnly <em>Local Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Only</em>' attribute.
     * @see #getLocalOnly()
     * @generated
     */
    void setLocalOnly ( Boolean value );

    /**
     * Returns the value of the '<em><b>Authenticated</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Authenticated</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Authenticated</em>' attribute.
     * @see #setAuthenticated(Boolean)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getJMXSettings_Authenticated()
     * @model
     * @generated
     */
    Boolean getAuthenticated ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getAuthenticated <em>Authenticated</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Authenticated</em>' attribute.
     * @see #getAuthenticated()
     * @generated
     */
    void setAuthenticated ( Boolean value );

    /**
     * Returns the value of the '<em><b>Ssl</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ssl</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ssl</em>' attribute.
     * @see #setSsl(Boolean)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getJMXSettings_Ssl()
     * @model
     * @generated
     */
    Boolean getSsl ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#getSsl <em>Ssl</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ssl</em>' attribute.
     * @see #getSsl()
     * @generated
     */
    void setSsl ( Boolean value );

    /**
     * Returns the value of the '<em><b>Assign Node Hostname</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Assign Node Hostname</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Assign Node Hostname</em>' attribute.
     * @see #setAssignNodeHostname(boolean)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getJMXSettings_AssignNodeHostname()
     * @model default="false"
     * @generated
     */
    boolean isAssignNodeHostname ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.JMXSettings#isAssignNodeHostname <em>Assign Node Hostname</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Assign Node Hostname</em>' attribute.
     * @see #isAssignNodeHostname()
     * @generated
     */
    void setAssignNodeHostname ( boolean value );

} // JMXSettings
