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
package org.eclipse.scada.da.exec.configuration;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.CustomExtractorType#getAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.CustomExtractorType#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getCustomExtractorType()
 * @model extendedMetaData="name='CustomExtractorType' kind='elementOnly'"
 * @generated
 */
public interface CustomExtractorType extends ExtractorType
{

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
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getCustomExtractorType_Any()
     * @model dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="false"
     *        extendedMetaData="kind='elementWildcard' wildcards='##any' name=':1' processing='lax'"
     * @generated
     */
    FeatureMap getAny ();

    /**
     * Returns the value of the '<em><b>Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Class</em>' attribute.
     * @see #setClass(String)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getCustomExtractorType_Class()
     * @model dataType="org.eclipse.scada.da.exec.configuration.ClassType"
     *        extendedMetaData="kind='attribute' name='class'"
     * @generated
     */
    String getClass_ ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.CustomExtractorType#getClass_ <em>Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Class</em>' attribute.
     * @see #getClass_()
     * @generated
     */
    void setClass ( String value );

} // CustomExtractorType
