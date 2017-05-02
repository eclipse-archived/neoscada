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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.base.extractor.extract.Extractor;

import org.eclipse.scada.da.server.component.parser.factory.CreationContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extractor Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition#getPrefix <em>Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getExtractorDefinition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ExtractorDefinition extends EObject
{
    /**
     * Returns the value of the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Prefix</em>' attribute.
     * @see #setPrefix(String)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getExtractorDefinition_Prefix()
     * @model
     * @generated
     */
    String getPrefix ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition#getPrefix <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix ( String value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dataType="org.eclipse.scada.da.server.component.parser.factory.configuration.Extractor" required="true" creationContextDataType="org.eclipse.scada.da.server.component.parser.factory.configuration.CreationContext"
     * @generated
     */
    Extractor createExtractor ( CreationContext creationContext );

} // ExtractorDefinition
