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
import org.eclipse.scada.configuration.world.World;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Globalization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Globalization#getWorld <em>World</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Globalization#getDefaultLogonCredentials <em>Default Logon Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.Globalization#getGlobals <em>Globals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobalization()
 * @model
 * @generated
 */
public interface Globalization extends EObject
{
    /**
     * Returns the value of the '<em><b>World</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>World</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>World</em>' reference.
     * @see #setWorld(World)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobalization_World()
     * @model required="true"
     * @generated
     */
    World getWorld ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Globalization#getWorld <em>World</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>World</em>' reference.
     * @see #getWorld()
     * @generated
     */
    void setWorld ( World value );

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
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobalization_DefaultLogonCredentials()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Credentials getDefaultLogonCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.Globalization#getDefaultLogonCredentials <em>Default Logon Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Logon Credentials</em>' containment reference.
     * @see #getDefaultLogonCredentials()
     * @generated
     */
    void setDefaultLogonCredentials ( Credentials value );

    /**
     * Returns the value of the '<em><b>Globals</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.globalization.Global}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Globals</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Globals</em>' containment reference list.
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getGlobalization_Globals()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Global> getGlobals ();

} // Globalization
