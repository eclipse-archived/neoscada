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
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.Credentials;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Master Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getImportedMaster <em>Imported Master</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getCredentials <em>Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getMaster <em>Master</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterImport()
 * @model
 * @generated
 */
public interface MasterImport extends EObject
{
    /**
     * Returns the value of the '<em><b>Imported Master</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Imported Master</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The master server that is imported
     * <!-- end-model-doc -->
     * @return the value of the '<em>Imported Master</em>' reference.
     * @see #setImportedMaster(MasterServer)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterImport_ImportedMaster()
     * @model
     * @generated
     */
    MasterServer getImportedMaster ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getImportedMaster <em>Imported Master</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Imported Master</em>' reference.
     * @see #getImportedMaster()
     * @generated
     */
    void setImportedMaster ( MasterServer value );

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterImport_Id()
     * @model required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Credentials</em>' containment reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Credentials</em>' containment reference.
     * @see #setCredentials(Credentials)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterImport_Credentials()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Credentials getCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getCredentials <em>Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Credentials</em>' containment reference.
     * @see #getCredentials()
     * @generated
     */
    void setCredentials ( Credentials value );

    /**
     * Returns the value of the '<em><b>Master</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getImportMaster <em>Import Master</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Master</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Master</em>' container reference.
     * @see #setMaster(MasterServer)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterImport_Master()
     * @see org.eclipse.scada.configuration.infrastructure.MasterServer#getImportMaster
     * @model opposite="importMaster" required="true" transient="false"
     * @generated
     */
    MasterServer getMaster ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getMaster <em>Master</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Master</em>' container reference.
     * @see #getMaster()
     * @generated
     */
    void setMaster ( MasterServer value );

} // MasterImport
