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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hive Configuration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.exporter.HiveConfigurationType#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.exporter.HiveConfigurationType#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.exporter.ExporterPackage#getHiveConfigurationType()
 * @model extendedMetaData="name='HiveConfigurationType' kind='mixed'"
 * @generated
 */
public interface HiveConfigurationType extends EObject
{

    /**
     * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mixed</em>' attribute list.
     * @see org.eclipse.scada.da.server.exporter.ExporterPackage#getHiveConfigurationType_Mixed()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='elementWildcard' name=':mixed'"
     * @generated
     */
    FeatureMap getMixed ();

    /**
     * Returns the value of the '<em><b>Any</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Any</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Any</em>' attribute list.
     * @see org.eclipse.scada.da.server.exporter.ExporterPackage#getHiveConfigurationType_Any()
     * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='elementWildcard' wildcards='##any' name=':1' processing='lax'"
     * @generated
     */
    FeatureMap getAny ();

} // HiveConfigurationType
