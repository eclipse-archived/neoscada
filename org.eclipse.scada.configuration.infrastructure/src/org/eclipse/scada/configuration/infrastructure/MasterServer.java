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

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.globalization.Authorative;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Master Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getAuthoratives <em>Authoratives</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getImportMaster <em>Import Master</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getDriver <em>Driver</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getArchiveTo <em>Archive To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterServer()
 * @model
 * @generated
 */
public interface MasterServer extends EquinoxApplication
{
    /**
     * Returns the value of the '<em><b>Authoratives</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.globalization.Authorative}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Authoratives</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Authoratives</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterServer_Authoratives()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Authorative> getAuthoratives ();

    /**
     * Returns the value of the '<em><b>Import Master</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.MasterImport}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.infrastructure.MasterImport#getMaster <em>Master</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import Master</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A master import definition
     * <!-- end-model-doc -->
     * @return the value of the '<em>Import Master</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterServer_ImportMaster()
     * @see org.eclipse.scada.configuration.infrastructure.MasterImport#getMaster
     * @model opposite="master" containment="true" resolveProxies="true"
     * @generated
     */
    EList<MasterImport> getImportMaster ();

    /**
     * Returns the value of the '<em><b>Driver</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.Driver}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Driver</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Driver</em>' reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterServer_Driver()
     * @model
     * @generated
     */
    EList<Driver> getDriver ();

    /**
     * Returns the value of the '<em><b>Archive To</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Archive To</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Archive To</em>' reference.
     * @see #setArchiveTo(ValueArchiveServer)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getMasterServer_ArchiveTo()
     * @model
     * @generated
     */
    ValueArchiveServer getArchiveTo ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.MasterServer#getArchiveTo <em>Archive To</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Archive To</em>' reference.
     * @see #getArchiveTo()
     * @generated
     */
    void setArchiveTo ( ValueArchiveServer value );

} // MasterServer
