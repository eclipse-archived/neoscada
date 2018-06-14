/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.infrastructure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Archive Slave</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave#getStoragePath <em>Storage Path</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave#getStorageLayout <em>Storage Layout</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getValueArchiveSlave()
 * @model
 * @generated
 */
public interface ValueArchiveSlave extends EquinoxApplication
{

    /**
     * Returns the value of the '<em><b>Storage Path</b></em>' attribute.
     * The default value is <code>"/var/lib/neoscada/hds.slave"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Storage Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Storage Path</em>' attribute.
     * @see #setStoragePath(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getValueArchiveSlave_StoragePath()
     * @model default="/var/lib/neoscada/hds.slave" required="true"
     * @generated
     */
    String getStoragePath ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave#getStoragePath <em>Storage Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Storage Path</em>' attribute.
     * @see #getStoragePath()
     * @generated
     */
    void setStoragePath ( String value );

    /**
     * Returns the value of the '<em><b>Storage Layout</b></em>' attribute.
     * The default value is <code>"MULTI"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Storage Layout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Storage Layout</em>' attribute.
     * @see org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout
     * @see #setStorageLayout(SlaveStorageLayout)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getValueArchiveSlave_StorageLayout()
     * @model default="MULTI" required="true"
     * @generated
     */
    SlaveStorageLayout getStorageLayout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave#getStorageLayout <em>Storage Layout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Storage Layout</em>' attribute.
     * @see org.eclipse.scada.configuration.infrastructure.SlaveStorageLayout
     * @see #getStorageLayout()
     * @generated
     */
    void setStorageLayout ( SlaveStorageLayout value );
} // ValueArchiveSlave
