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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Injector Syslog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EventInjectorSyslog#getHost <em>Host</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.EventInjectorSyslog#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEventInjectorSyslog()
 * @model
 * @generated
 */
public interface EventInjectorSyslog extends Module
{

    /**
     * Returns the value of the '<em><b>Host</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Host</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Host</em>' attribute.
     * @see #setHost(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEventInjectorSyslog_Host()
     * @model
     * @generated
     */
    String getHost ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EventInjectorSyslog#getHost <em>Host</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Host</em>' attribute.
     * @see #getHost()
     * @generated
     */
    void setHost ( String value );

    /**
     * Returns the value of the '<em><b>Port</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Port</em>' attribute.
     * @see #setPort(int)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getEventInjectorSyslog_Port()
     * @model required="true"
     * @generated
     */
    int getPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.EventInjectorSyslog#getPort <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port</em>' attribute.
     * @see #getPort()
     * @generated
     */
    void setPort ( int value );
} // EventInjectorSyslog
