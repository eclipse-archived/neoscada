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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Timer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptTimer#getScript <em>Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptTimer#getPeriod <em>Period</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptTimer()
 * @model
 * @generated
 */
public interface ScriptTimer extends EObject
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
     * @see #setScript(CodeFragment)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptTimer_Script()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    CodeFragment getScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ScriptTimer#getScript <em>Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' containment reference.
     * @see #getScript()
     * @generated
     */
    void setScript ( CodeFragment value );

    /**
     * Returns the value of the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Period</em>' attribute.
     * @see #setPeriod(long)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptTimer_Period()
     * @model required="true"
     * @generated
     */
    long getPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ScriptTimer#getPeriod <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Period</em>' attribute.
     * @see #getPeriod()
     * @generated
     */
    void setPeriod ( long value );

} // ScriptTimer
