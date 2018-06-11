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
package org.eclipse.neoscada.configuration.iec62541;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hive Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec62541.HiveDevice#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec62541.HiveDevice#getServerUrl <em>Server Url</em>}</li>
 * </ul>
 *
 * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Package#getHiveDevice()
 * @model
 * @generated
 */
public interface HiveDevice extends EObject
{
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
     * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Package#getHiveDevice_Id()
     * @model required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec62541.HiveDevice#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Server Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Server Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Server Url</em>' attribute.
     * @see #setServerUrl(String)
     * @see org.eclipse.neoscada.configuration.iec62541.IEC62541Package#getHiveDevice_ServerUrl()
     * @model required="true"
     * @generated
     */
    String getServerUrl ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec62541.HiveDevice#getServerUrl <em>Server Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Server Url</em>' attribute.
     * @see #getServerUrl()
     * @generated
     */
    void setServerUrl ( String value );

} // HiveDevice
