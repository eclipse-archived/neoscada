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

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mail Event Handler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getSessionProperties <em>Session Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getTo <em>To</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getUsername <em>Username</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getQueueId <em>Queue Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMailEventHandler()
 * @model
 * @generated
 */
public interface MailEventHandler extends EventHandler
{

    /**
     * Returns the value of the '<em><b>Session Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Session Properties</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Session Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMailEventHandler_SessionProperties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getSessionProperties ();

    /**
     * Returns the value of the '<em><b>From</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From</em>' attribute.
     * @see #setFrom(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMailEventHandler_From()
     * @model
     * @generated
     */
    String getFrom ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getFrom <em>From</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>From</em>' attribute.
     * @see #getFrom()
     * @generated
     */
    void setFrom ( String value );

    /**
     * Returns the value of the '<em><b>To</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To</em>' attribute list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMailEventHandler_To()
     * @model required="true"
     * @generated
     */
    EList<String> getTo ();

    /**
     * Returns the value of the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Username</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Username</em>' attribute.
     * @see #setUsername(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMailEventHandler_Username()
     * @model
     * @generated
     */
    String getUsername ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getUsername <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Username</em>' attribute.
     * @see #getUsername()
     * @generated
     */
    void setUsername ( String value );

    /**
     * Returns the value of the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Password</em>' attribute.
     * @see #setPassword(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMailEventHandler_Password()
     * @model
     * @generated
     */
    String getPassword ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getPassword <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password</em>' attribute.
     * @see #getPassword()
     * @generated
     */
    void setPassword ( String value );

    /**
     * Returns the value of the '<em><b>Queue Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Queue Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Queue Id</em>' attribute.
     * @see #setQueueId(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMailEventHandler_QueueId()
     * @model id="true"
     * @generated
     */
    String getQueueId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.MailEventHandler#getQueueId <em>Queue Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Queue Id</em>' attribute.
     * @see #getQueueId()
     * @generated
     */
    void setQueueId ( String value );
} // MailEventHandler
