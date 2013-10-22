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
package org.eclipse.scada.configuration.component;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.world.osgi.DataMapper;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Mapper Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.DataMapperService#getDataMapper <em>Data Mapper</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.DataMapperService#getMasterOn <em>Master On</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getDataMapperService()
 * @model
 * @generated
 */
public interface DataMapperService extends Service
{
    /**
     * Returns the value of the '<em><b>Data Mapper</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Mapper</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Mapper</em>' containment reference.
     * @see #setDataMapper(DataMapper)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getDataMapperService_DataMapper()
     * @model containment="true" required="true"
     * @generated
     */
    DataMapper getDataMapper ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.DataMapperService#getDataMapper <em>Data Mapper</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Mapper</em>' containment reference.
     * @see #getDataMapper()
     * @generated
     */
    void setDataMapper ( DataMapper value );

    /**
     * Returns the value of the '<em><b>Master On</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.MasterServer}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Master On</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Master On</em>' reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getDataMapperService_MasterOn()
     * @model
     * @generated
     */
    EList<MasterServer> getMasterOn ();

} // DataMapperService
