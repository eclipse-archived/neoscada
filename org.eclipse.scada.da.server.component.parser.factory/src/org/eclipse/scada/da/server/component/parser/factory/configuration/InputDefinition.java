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

import org.eclipse.scada.base.extractor.input.Input;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getInputDefinition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface InputDefinition extends EObject
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dataType="org.eclipse.scada.da.server.component.parser.factory.configuration.Input" required="true" creationContextDataType="org.eclipse.scada.da.server.component.parser.factory.configuration.CreationContext"
     * @generated
     */
    Input createInput ( CreationContext creationContext );

} // InputDefinition
