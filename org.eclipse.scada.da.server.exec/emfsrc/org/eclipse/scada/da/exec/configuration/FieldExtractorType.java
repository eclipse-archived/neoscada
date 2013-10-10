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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.FieldExtractorType#getField <em>Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getFieldExtractorType()
 * @model abstract="true"
 *        extendedMetaData="name='FieldExtractorType' kind='elementOnly'"
 * @generated
 */
public interface FieldExtractorType extends ExtractorType
{

    /**
     * Returns the value of the '<em><b>Field</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.exec.configuration.FieldType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * 
     *     							Each regular expression group must be
     *     							named. The name will be the data item
     *     							name. If a regular expression group is
     *     							not named it will not be extracted.
     *     						
     * <!-- end-model-doc -->
     * @return the value of the '<em>Field</em>' containment reference list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getFieldExtractorType_Field()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='field' namespace='##targetNamespace'"
     * @generated
     */
    EList<FieldType> getField ();

} // FieldExtractorType
