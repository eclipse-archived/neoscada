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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Splitter Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.SplitterExtractorType#getSplitExpression <em>Split Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSplitterExtractorType()
 * @model extendedMetaData="name='SplitterExtractorType' kind='elementOnly'"
 * @generated
 */
public interface SplitterExtractorType extends FieldExtractorType
{

    /**
     * Returns the value of the '<em><b>Split Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Split Expression</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Split Expression</em>' attribute.
     * @see #setSplitExpression(String)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSplitterExtractorType_SplitExpression()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='splitExpression'"
     * @generated
     */
    String getSplitExpression ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.SplitterExtractorType#getSplitExpression <em>Split Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Split Expression</em>' attribute.
     * @see #getSplitExpression()
     * @generated
     */
    void setSplitExpression ( String value );

} // SplitterExtractorType
