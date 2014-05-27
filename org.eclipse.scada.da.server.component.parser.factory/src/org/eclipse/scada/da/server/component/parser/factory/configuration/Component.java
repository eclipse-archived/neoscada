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
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getExtractors <em>Extractors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends EObject
{
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getComponent_Id()
     * @model id="true" required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Input</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input</em>' containment reference.
     * @see #setInput(InputDefinition)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getComponent_Input()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    InputDefinition getInput ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getInput <em>Input</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input</em>' containment reference.
     * @see #getInput()
     * @generated
     */
    void setInput ( InputDefinition value );

    /**
     * Returns the value of the '<em><b>Extractors</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Extractors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Extractors</em>' containment reference list.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getComponent_Extractors()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ExtractorDefinition> getExtractors ();

} // Component
