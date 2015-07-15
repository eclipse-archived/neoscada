/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.deployment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Node Mapping Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Replace a hostname by matching it against the fromHostName field and replacing it with the toHostName field if it matches. It is compared case insensitive.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#getFromHostName <em>From Host Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#getToHostName <em>To Host Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#isIgnoreCase <em>Ignore Case</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getSimpleNodeMappingEntry()
 * @model
 * @generated
 */
public interface SimpleNodeMappingEntry extends MappingEntry
{
    /**
     * Returns the value of the '<em><b>From Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>From Host Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>From Host Name</em>' attribute.
     * @see #setFromHostName(String)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getSimpleNodeMappingEntry_FromHostName()
     * @model required="true"
     * @generated
     */
    String getFromHostName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#getFromHostName <em>From Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>From Host Name</em>' attribute.
     * @see #getFromHostName()
     * @generated
     */
    void setFromHostName ( String value );

    /**
     * Returns the value of the '<em><b>To Host Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To Host Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To Host Name</em>' attribute.
     * @see #setToHostName(String)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getSimpleNodeMappingEntry_ToHostName()
     * @model required="true"
     * @generated
     */
    String getToHostName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#getToHostName <em>To Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>To Host Name</em>' attribute.
     * @see #getToHostName()
     * @generated
     */
    void setToHostName ( String value );

    /**
     * Returns the value of the '<em><b>Ignore Case</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ignore Case</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ignore Case</em>' attribute.
     * @see #setIgnoreCase(boolean)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getSimpleNodeMappingEntry_IgnoreCase()
     * @model default="true" required="true"
     * @generated
     */
    boolean isIgnoreCase ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#isIgnoreCase <em>Ignore Case</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ignore Case</em>' attribute.
     * @see #isIgnoreCase()
     * @generated
     */
    void setIgnoreCase ( boolean value );

} // SimpleNodeMappingEntry
