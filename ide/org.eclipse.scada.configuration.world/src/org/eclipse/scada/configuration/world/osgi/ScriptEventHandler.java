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

import org.eclipse.scada.configuration.script.JavaScript;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Event Handler</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptEventHandler#getScript <em>Script</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptEventHandler()
 * @model
 * @generated
 */
public interface ScriptEventHandler extends EventHandler
{

    /**
     * Returns the value of the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script</em>' containment reference.
     * @see #setScript(JavaScript)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptEventHandler_Script()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    JavaScript getScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ScriptEventHandler#getScript <em>Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' containment reference.
     * @see #getScript()
     * @generated
     */
    void setScript ( JavaScript value );
} // ScriptEventHandler
