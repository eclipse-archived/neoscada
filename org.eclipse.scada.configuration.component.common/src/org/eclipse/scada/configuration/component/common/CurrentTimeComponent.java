/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.common;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.component.MasterComponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Current Time Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getUpdatePeriod <em>Update Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getDateFormat <em>Date Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.common.CommonPackage#getCurrentTimeComponent()
 * @model
 * @generated
 */
public interface CurrentTimeComponent extends MasterComponent
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute list.
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getCurrentTimeComponent_Name()
     * @model default="TIME" required="true"
     * @generated
     */
    EList<String> getName ();

    /**
     * Returns the value of the '<em><b>Update Period</b></em>' attribute.
     * The default value is <code>"100"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Update Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Update Period</em>' attribute.
     * @see #setUpdatePeriod(long)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getCurrentTimeComponent_UpdatePeriod()
     * @model default="100" required="true"
     * @generated
     */
    long getUpdatePeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getUpdatePeriod <em>Update Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Update Period</em>' attribute.
     * @see #getUpdatePeriod()
     * @generated
     */
    void setUpdatePeriod ( long value );

    /**
     * Returns the value of the '<em><b>Date Format</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Date Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Date Format</em>' attribute.
     * @see #setDateFormat(DateFormat)
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#getCurrentTimeComponent_DateFormat()
     * @model default="" dataType="org.eclipse.scada.configuration.component.common.DateFormat"
     * @generated
     */
    DateFormat getDateFormat ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent#getDateFormat <em>Date Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Date Format</em>' attribute.
     * @see #getDateFormat()
     * @generated
     */
    void setDateFormat ( DateFormat value );

} // CurrentTimeComponent
