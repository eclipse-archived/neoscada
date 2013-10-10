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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Splitter Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.SplitterType#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.SplitterType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSplitterType()
 * @model extendedMetaData="name='SplitterType' kind='empty'"
 * @generated
 */
public interface SplitterType extends EObject
{

    /**
     * Returns the value of the '<em><b>Parameter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parameter</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parameter</em>' attribute.
     * @see #setParameter(String)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSplitterType_Parameter()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='parameter'"
     * @generated
     */
    String getParameter ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.SplitterType#getParameter <em>Parameter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parameter</em>' attribute.
     * @see #getParameter()
     * @generated
     */
    void setParameter ( String value );

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getSplitterType_Type()
     * @model dataType="org.eclipse.scada.da.exec.configuration.TypeType" required="true"
     *        extendedMetaData="kind='attribute' name='type'"
     * @generated
     */
    String getType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.SplitterType#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType ( String value );

} // SplitterType
