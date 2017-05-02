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
package org.eclipse.scada.configuration.world;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Database Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.GenericDatabaseSettings#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.GenericDatabaseSettings#getDriverName <em>Driver Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.GenericDatabaseSettings#getBundles <em>Bundles</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.WorldPackage#getGenericDatabaseSettings()
 * @model
 * @generated
 */
public interface GenericDatabaseSettings extends AbstractGenericDatabaseSettings
{
    /**
     * Returns the value of the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Url</em>' attribute.
     * @see #setUrl(String)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getGenericDatabaseSettings_Url()
     * @model required="true"
     * @generated
     */
    String getUrl ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.GenericDatabaseSettings#getUrl <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Url</em>' attribute.
     * @see #getUrl()
     * @generated
     */
    void setUrl ( String value );

    /**
     * Returns the value of the '<em><b>Driver Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Driver Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Driver Name</em>' attribute.
     * @see #setDriverName(String)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getGenericDatabaseSettings_DriverName()
     * @model required="true"
     * @generated
     */
    String getDriverName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.GenericDatabaseSettings#getDriverName <em>Driver Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Driver Name</em>' attribute.
     * @see #getDriverName()
     * @generated
     */
    void setDriverName ( String value );

    /**
     * Returns the value of the '<em><b>Bundles</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Bundles</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Bundles</em>' attribute list.
     * @see org.eclipse.scada.configuration.world.WorldPackage#getGenericDatabaseSettings_Bundles()
     * @model
     * @generated
     */
    EList<String> getBundles ();

} // GenericDatabaseSettings
