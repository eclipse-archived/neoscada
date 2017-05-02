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

import org.eclipse.scada.base.extractor.input.Input;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition#getTransformers <em>Transformers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getInputDefinition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface InputDefinition extends EObject
{
    /**
     * Returns the value of the '<em><b>Transformers</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.server.component.parser.factory.configuration.TransformerDefinition}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Transformers</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Transformers</em>' containment reference list.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getInputDefinition_Transformers()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<TransformerDefinition> getTransformers ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dataType="org.eclipse.scada.da.server.component.parser.factory.configuration.Input" required="true" creationContextDataType="org.eclipse.scada.da.server.component.parser.factory.configuration.CreationContext"
     * @generated
     */
    Input createInput ( CreationContext creationContext );

} // InputDefinition
