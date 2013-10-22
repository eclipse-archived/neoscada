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
 * A representation of the model object '<em><b>Data Access Connection</b></em>
 * '.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getDataAccessConnection()
 * @model
 * @generated
 */
public interface DataAccessConnection extends Connection
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return \"da\";'"
     * @generated
     */
    String getTypeTag ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return super.makeBasicUri ( localhost, \"da\", \"ngp\" );'"
     * @generated
     */
    String makeUri ( boolean localhost );

} // DataAccessConnection
