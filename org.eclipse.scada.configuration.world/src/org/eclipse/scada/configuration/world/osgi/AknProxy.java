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

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Akn Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AknProxy#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AknProxy#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AknProxy#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AknProxy#isAuthorative <em>Authorative</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAknProxy()
 * @model
 * @generated
 */
public interface AknProxy extends EObject
{
    /**
     * Returns the value of the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pattern</em>' attribute.
     * @see #setPattern(Pattern)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAknProxy_Pattern()
     * @model dataType="org.eclipse.scada.configuration.world.Pattern" required="true"
     * @generated
     */
    Pattern getPattern ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AknProxy#getPattern <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pattern</em>' attribute.
     * @see #getPattern()
     * @generated
     */
    void setPattern ( Pattern value );

    /**
     * Returns the value of the '<em><b>Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection</em>' reference.
     * @see #setConnection(AlarmsEventsConnection)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAknProxy_Connection()
     * @model required="true"
     * @generated
     */
    AlarmsEventsConnection getConnection ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AknProxy#getConnection <em>Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection</em>' reference.
     * @see #getConnection()
     * @generated
     */
    void setConnection ( AlarmsEventsConnection value );

    /**
     * Returns the value of the '<em><b>Priority</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Priority</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Priority</em>' attribute.
     * @see #setPriority(int)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAknProxy_Priority()
     * @model required="true"
     * @generated
     */
    int getPriority ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AknProxy#getPriority <em>Priority</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Priority</em>' attribute.
     * @see #getPriority()
     * @generated
     */
    void setPriority ( int value );

    /**
     * Returns the value of the '<em><b>Authorative</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Authorative</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Authorative</em>' attribute.
     * @see #setAuthorative(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAknProxy_Authorative()
     * @model default="true" required="true"
     * @generated
     */
    boolean isAuthorative ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AknProxy#isAuthorative <em>Authorative</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Authorative</em>' attribute.
     * @see #isAuthorative()
     * @generated
     */
    void setAuthorative ( boolean value );

} // AknProxy
