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
package org.eclipse.scada.da.proxy.configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.FolderType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.FolderType#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getFolderType()
 * @model extendedMetaData="name='FolderType' kind='elementOnly'"
 * @generated
 */
public interface FolderType extends EObject
{

    /**
     * Returns the value of the '<em><b>Group</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Group</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Group</em>' attribute list.
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getFolderType_Group()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='group' name='group:0'"
     * @generated
     */
    FeatureMap getGroup ();

    /**
     * Returns the value of the '<em><b>Location</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Location</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Location</em>' attribute list.
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getFolderType_Location()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='location' namespace='##targetNamespace' group='#group:0'"
     * @generated
     */
    EList<String> getLocation ();

} // FolderType
