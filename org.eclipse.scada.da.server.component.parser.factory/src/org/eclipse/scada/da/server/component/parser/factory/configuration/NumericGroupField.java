/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numeric Group Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.NumericGroupField#getGroupNumber <em>Group Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getNumericGroupField()
 * @model
 * @generated
 */
public interface NumericGroupField extends Field
{

    /**
     * Returns the value of the '<em><b>Group Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Group Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Group Number</em>' attribute.
     * @see #setGroupNumber(int)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getNumericGroupField_GroupNumber()
     * @model required="true"
     * @generated
     */
    int getGroupNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.NumericGroupField#getGroupNumber <em>Group Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Group Number</em>' attribute.
     * @see #getGroupNumber()
     * @generated
     */
    void setGroupNumber ( int value );
} // NumericGroupField
