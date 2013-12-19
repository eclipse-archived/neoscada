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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.SourceItem#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.SourceItem#getSourceName <em>Source Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getSourceItem()
 * @model
 * @generated
 */
public interface SourceItem extends Item
{
    /**
     * Returns the value of the '<em><b>Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection</em>' reference.
     * @see #setConnection(DataAccessConnection)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getSourceItem_Connection()
     * @model required="true"
     * @generated
     */
    DataAccessConnection getConnection ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.SourceItem#getConnection <em>Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection</em>' reference.
     * @see #getConnection()
     * @generated
     */
    void setConnection ( DataAccessConnection value );

    /**
     * Returns the value of the '<em><b>Source Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Name</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Name</em>' attribute.
     * @see #setSourceName(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getSourceItem_SourceName()
     * @model required="true"
     * @generated
     */
    String getSourceName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.SourceItem#getSourceName <em>Source Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Name</em>' attribute.
     * @see #getSourceName()
     * @generated
     */
    void setSourceName ( String value );

} // SourceItem
