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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Mapper Analyzer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.DataMapperAnalyzer#getDataMapper <em>Data Mapper</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getDataMapperAnalyzer()
 * @model
 * @generated
 */
public interface DataMapperAnalyzer extends MasterComponent
{
    /**
     * Returns the value of the '<em><b>Data Mapper</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Mapper</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Mapper</em>' reference.
     * @see #setDataMapper(DataMapperService)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getDataMapperAnalyzer_DataMapper()
     * @model required="true"
     * @generated
     */
    DataMapperService getDataMapper ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.DataMapperAnalyzer#getDataMapper <em>Data Mapper</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Mapper</em>' reference.
     * @see #getDataMapper()
     * @generated
     */
    void setDataMapper ( DataMapperService value );

} // DataMapperAnalyzer
