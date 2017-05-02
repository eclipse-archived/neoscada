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

import java.util.regex.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern#isFullMatch <em>Full Match</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSinglePattern()
 * @model
 * @generated
 */
public interface SinglePattern extends ExtractorDefinition
{
    /**
     * Returns the value of the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pattern</em>' attribute.
     * @see #setPattern(Pattern)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSinglePattern_Pattern()
     * @model dataType="org.eclipse.scada.da.server.component.parser.factory.configuration.Pattern" required="true"
     * @generated
     */
    Pattern getPattern ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern#getPattern <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pattern</em>' attribute.
     * @see #getPattern()
     * @generated
     */
    void setPattern ( Pattern value );

    /**
     * Returns the value of the '<em><b>Full Match</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Full Match</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Full Match</em>' attribute.
     * @see #setFullMatch(boolean)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSinglePattern_FullMatch()
     * @model required="true"
     * @generated
     */
    boolean isFullMatch ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern#isFullMatch <em>Full Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Full Match</em>' attribute.
     * @see #isFullMatch()
     * @generated
     */
    void setFullMatch ( boolean value );

    /**
     * Returns the value of the '<em><b>Value</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' containment reference.
     * @see #setValue(ValueDescriptor)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSinglePattern_Value()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    ValueDescriptor getValue ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern#getValue <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' containment reference.
     * @see #getValue()
     * @generated
     */
    void setValue ( ValueDescriptor value );

} // SinglePattern
