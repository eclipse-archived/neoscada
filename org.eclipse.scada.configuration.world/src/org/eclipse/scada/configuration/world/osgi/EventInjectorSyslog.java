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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.scada.configuration.world.Endpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Injector Syslog</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjectorSyslog#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjectorSyslog#getBindAddress <em>Bind Address</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjectorSyslog()
 * @model
 * @generated
 */
public interface EventInjectorSyslog extends ApplicationConfiguration
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
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjectorSyslog_Endpoint()
     * @model required="true"
     * @generated
     */
    Endpoint getEndpoint ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjectorSyslog#getEndpoint <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint</em>' reference.
     * @see #getEndpoint()
     * @generated
     */
    void setEndpoint ( Endpoint value );

    /**
     * Returns the value of the '<em><b>Bind Address</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Bind Address</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Bind Address</em>' attribute.
     * @see #setBindAddress(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjectorSyslog_BindAddress()
     * @model
     * @generated
     */
    String getBindAddress ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjectorSyslog#getBindAddress <em>Bind Address</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Bind Address</em>' attribute.
     * @see #getBindAddress()
     * @generated
     */
    void setBindAddress ( String value );

} // EventInjectorSyslog
