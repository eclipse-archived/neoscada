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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ValueDescriptor#getPrimaryValue <em>Primary Value</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ValueDescriptor#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getValueDescriptor()
 * @model
 * @generated
 */
public interface ValueDescriptor extends EObject
{
    /**
     * Returns the value of the '<em><b>Primary Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Primary Value</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Primary Value</em>' containment reference.
     * @see #setPrimaryValue(Field)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getValueDescriptor_PrimaryValue()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Field getPrimaryValue ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ValueDescriptor#getPrimaryValue <em>Primary Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Primary Value</em>' containment reference.
     * @see #getPrimaryValue()
     * @generated
     */
    void setPrimaryValue ( Field value );

    /**
     * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.server.component.parser.factory.configuration.AttributeValue}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attributes</em>' containment reference list.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getValueDescriptor_Attributes()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<AttributeValue> getAttributes ();

} // ValueDescriptor
