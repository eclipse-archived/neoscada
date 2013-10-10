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
 * A representation of the model object '<em><b>Reg Ex Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType#isRequireFullMatch <em>Require Full Match</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRegExExtractorType()
 * @model extendedMetaData="name='RegExExtractorType' kind='elementOnly'"
 * @generated
 */
public interface RegExExtractorType extends FieldExtractorType
{

    /**
     * Returns the value of the '<em><b>Expression</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expression</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' attribute.
     * @see #setExpression(String)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRegExExtractorType_Expression()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='element' name='expression' namespace='##targetNamespace'"
     * @generated
     */
    String getExpression ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType#getExpression <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' attribute.
     * @see #getExpression()
     * @generated
     */
    void setExpression ( String value );

    /**
     * Returns the value of the '<em><b>Require Full Match</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Require Full Match</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Require Full Match</em>' attribute.
     * @see #isSetRequireFullMatch()
     * @see #unsetRequireFullMatch()
     * @see #setRequireFullMatch(boolean)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRegExExtractorType_RequireFullMatch()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
     *        extendedMetaData="kind='attribute' name='requireFullMatch'"
     * @generated
     */
    boolean isRequireFullMatch ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType#isRequireFullMatch <em>Require Full Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Require Full Match</em>' attribute.
     * @see #isSetRequireFullMatch()
     * @see #unsetRequireFullMatch()
     * @see #isRequireFullMatch()
     * @generated
     */
    void setRequireFullMatch ( boolean value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType#isRequireFullMatch <em>Require Full Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetRequireFullMatch()
     * @see #isRequireFullMatch()
     * @see #setRequireFullMatch(boolean)
     * @generated
     */
    void unsetRequireFullMatch ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType#isRequireFullMatch <em>Require Full Match</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Require Full Match</em>' attribute is set.
     * @see #unsetRequireFullMatch()
     * @see #isRequireFullMatch()
     * @see #setRequireFullMatch(boolean)
     * @generated
     */
    boolean isSetRequireFullMatch ();

} // RegExExtractorType
