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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Local#getLocal <em>Local</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Local#getLogonCredentials <em>Logon Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Local#getFilters <em>Filters</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Local#isDefaultInclude <em>Default Include</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Local#getGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Local#getAuthoratives <em>Authoratives</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Local#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getLocal()
 * @model
 * @generated
 */
public interface Local extends EObject
{
    /**
     * Returns the value of the '<em><b>Local</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local</em>' reference.
     * @see #setLocal(MasterServer)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getLocal_Local()
     * @model required="true"
     * @generated
     */
    MasterServer getLocal ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Local#getLocal <em>Local</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local</em>' reference.
     * @see #getLocal()
     * @generated
     */
    void setLocal ( MasterServer value );

    /**
     * Returns the value of the '<em><b>Logon Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Logon Credentials</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Logon Credentials</em>' containment reference.
     * @see #setLogonCredentials(Credentials)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getLocal_LogonCredentials()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Credentials getLogonCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Local#getLogonCredentials <em>Logon Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Logon Credentials</em>' containment reference.
     * @see #getLogonCredentials()
     * @generated
     */
    void setLogonCredentials ( Credentials value );

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
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getLocal_Filters()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Filter> getFilters ();

    /**
     * Returns the value of the '<em><b>Default Include</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Include</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Include</em>' attribute.
     * @see #setDefaultInclude(boolean)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getLocal_DefaultInclude()
     * @model default="false" required="true"
     * @generated
     */
    boolean isDefaultInclude ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Local#isDefaultInclude <em>Default Include</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Include</em>' attribute.
     * @see #isDefaultInclude()
     * @generated
     */
    void setDefaultInclude ( boolean value );

    /**
     * Returns the value of the '<em><b>Global</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.globalization.Global#getLocals <em>Locals</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Global</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Global</em>' container reference.
     * @see #setGlobal(Global)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getLocal_Global()
     * @see org.eclipse.scada.configuration.globalization.Global#getLocals
     * @model opposite="locals" required="true" transient="false"
     * @generated
     */
    Global getGlobal ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Local#getGlobal <em>Global</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Global</em>' container reference.
     * @see #getGlobal()
     * @generated
     */
    void setGlobal ( Global value );

    /**
     * Returns the value of the '<em><b>Authoratives</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.globalization.Authorative}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Authoratives</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Authoratives</em>' containment reference list.
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getLocal_Authoratives()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Authorative> getAuthoratives ();

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getLocal_Id()
     * @model required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Local#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

} // Local
