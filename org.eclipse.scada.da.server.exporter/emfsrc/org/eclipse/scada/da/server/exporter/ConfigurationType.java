/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.exporter.ConfigurationType#getHive <em>Hive</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.exporter.ConfigurationType#getAnnouncer <em>Announcer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.exporter.ExporterPackage#getConfigurationType()
 * @model extendedMetaData="name='ConfigurationType' kind='elementOnly'"
 * @generated
 */
public interface ConfigurationType extends EObject
{

    /**
     * Returns the value of the '<em><b>Hive</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.server.exporter.HiveType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hive</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hive</em>' containment reference list.
     * @see org.eclipse.scada.da.server.exporter.ExporterPackage#getConfigurationType_Hive()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='hive' namespace='##targetNamespace'"
     * @generated
     */
    EList<HiveType> getHive ();

    /**
     * Returns the value of the '<em><b>Announcer</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.server.exporter.AnnouncerType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Announcer</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Announcer</em>' containment reference list.
     * @see org.eclipse.scada.da.server.exporter.ExporterPackage#getConfigurationType_Announcer()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='announcer' namespace='##targetNamespace'"
     * @generated
     */
    EList<AnnouncerType> getAnnouncer ();

} // ConfigurationType
