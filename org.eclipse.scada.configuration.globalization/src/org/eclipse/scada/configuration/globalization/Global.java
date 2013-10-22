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
package org.eclipse.scada.configuration.globalization;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.osgi.MasterServer;
import org.eclipse.scada.configuration.world.osgi.PullEvents;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Global#getGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Global#getDefaultLogonCredentials <em>Default Logon Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Global#getLocals <em>Locals</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Global#getEventPoolImports <em>Event Pool Imports</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Global#getMonitorPoolImports <em>Monitor Pool Imports</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Global#getLocalPull <em>Local Pull</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Global#getFilters <em>Filters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobal()
 * @model
 * @generated
 */
public interface Global extends EObject
{
    /**
     * Returns the value of the '<em><b>Global</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Global</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Global</em>' reference.
     * @see #setGlobal(MasterServer)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobal_Global()
     * @model required="true"
     * @generated
     */
    MasterServer getGlobal ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Global#getGlobal <em>Global</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Global</em>' reference.
     * @see #getGlobal()
     * @generated
     */
    void setGlobal ( MasterServer value );

    /**
     * Returns the value of the '<em><b>Default Logon Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Logon Credentials</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Logon Credentials</em>' containment reference.
     * @see #setDefaultLogonCredentials(Credentials)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobal_DefaultLogonCredentials()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Credentials getDefaultLogonCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Global#getDefaultLogonCredentials <em>Default Logon Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Logon Credentials</em>' containment reference.
     * @see #getDefaultLogonCredentials()
     * @generated
     */
    void setDefaultLogonCredentials ( Credentials value );

    /**
     * Returns the value of the '<em><b>Locals</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.globalization.Local}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.globalization.Local#getGlobal <em>Global</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Locals</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Locals</em>' containment reference list.
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobal_Locals()
     * @see org.eclipse.scada.configuration.globalization.Local#getGlobal
     * @model opposite="global" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Local> getLocals ();

    /**
     * Returns the value of the '<em><b>Event Pool Imports</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.globalization.EventPoolImport}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Pool Imports</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event Pool Imports</em>' containment reference list.
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobal_EventPoolImports()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<EventPoolImport> getEventPoolImports ();

    /**
     * Returns the value of the '<em><b>Monitor Pool Imports</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.globalization.MonitorPoolImport}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Monitor Pool Imports</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Monitor Pool Imports</em>' containment reference list.
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobal_MonitorPoolImports()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<MonitorPoolImport> getMonitorPoolImports ();

    /**
     * Returns the value of the '<em><b>Local Pull</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Pull</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Pull</em>' containment reference.
     * @see #setLocalPull(PullEvents)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobal_LocalPull()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    PullEvents getLocalPull ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Global#getLocalPull <em>Local Pull</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Pull</em>' containment reference.
     * @see #getLocalPull()
     * @generated
     */
    void setLocalPull ( PullEvents value );

    /**
     * Returns the value of the '<em><b>Filters</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.globalization.Filter}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filters</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Filters</em>' containment reference list.
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobal_Filters()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Filter> getFilters ();

} // Global
