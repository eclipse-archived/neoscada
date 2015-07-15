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

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getInitScript <em>Init Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getUpdateScript <em>Update Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getTimer <em>Timer</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getScriptEngine <em>Script Engine</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getCommands <em>Commands</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getWriteCommandScript <em>Write Command Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getInitProperties <em>Init Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptItem()
 * @model
 * @generated
 */
public interface ScriptItem extends Item
{
    /**
     * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.ItemReference}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inputs</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inputs</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptItem_Inputs()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ItemReference> getInputs ();

    /**
     * Returns the value of the '<em><b>Init Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Init Script</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Init Script</em>' containment reference.
     * @see #setInitScript(CodeFragment)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptItem_InitScript()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    CodeFragment getInitScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getInitScript <em>Init Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Init Script</em>' containment reference.
     * @see #getInitScript()
     * @generated
     */
    void setInitScript ( CodeFragment value );

    /**
     * Returns the value of the '<em><b>Update Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Update Script</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Update Script</em>' containment reference.
     * @see #setUpdateScript(CodeFragment)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptItem_UpdateScript()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    CodeFragment getUpdateScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getUpdateScript <em>Update Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Update Script</em>' containment reference.
     * @see #getUpdateScript()
     * @generated
     */
    void setUpdateScript ( CodeFragment value );

    /**
     * Returns the value of the '<em><b>Timer</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timer</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timer</em>' containment reference.
     * @see #setTimer(ScriptTimer)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptItem_Timer()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    ScriptTimer getTimer ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getTimer <em>Timer</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timer</em>' containment reference.
     * @see #getTimer()
     * @generated
     */
    void setTimer ( ScriptTimer value );

    /**
     * Returns the value of the '<em><b>Script Engine</b></em>' attribute.
     * The default value is <code>"JavaScript"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script Engine</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script Engine</em>' attribute.
     * @see #setScriptEngine(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptItem_ScriptEngine()
     * @model default="JavaScript" required="true"
     * @generated
     */
    String getScriptEngine ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getScriptEngine <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script Engine</em>' attribute.
     * @see #getScriptEngine()
     * @generated
     */
    void setScriptEngine ( String value );

    /**
     * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.ItemReference}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Commands</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Commands</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptItem_Commands()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ItemReference> getCommands ();

    /**
     * Returns the value of the '<em><b>Write Command Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Write Command Script</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Write Command Script</em>' containment reference.
     * @see #setWriteCommandScript(CodeFragment)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptItem_WriteCommandScript()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    CodeFragment getWriteCommandScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ScriptItem#getWriteCommandScript <em>Write Command Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Write Command Script</em>' containment reference.
     * @see #getWriteCommandScript()
     * @generated
     */
    void setWriteCommandScript ( CodeFragment value );

    /**
     * Returns the value of the '<em><b>Init Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Init Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Init Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScriptItem_InitProperties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getInitProperties ();

} // ScriptItem
