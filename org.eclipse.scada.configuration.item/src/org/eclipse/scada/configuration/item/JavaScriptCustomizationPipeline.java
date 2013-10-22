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
package org.eclipse.scada.configuration.item;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Script Customization Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.scada.configuration.item.ItemPackage#getJavaScriptCustomizationPipeline()
 * @model
 * @generated
 */
public interface JavaScriptCustomizationPipeline extends ScriptCustomizationPipeline
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return \"JavaScript\";'"
     * @generated
     */
    String getScriptEngine ();

} // JavaScriptCustomizationPipeline
