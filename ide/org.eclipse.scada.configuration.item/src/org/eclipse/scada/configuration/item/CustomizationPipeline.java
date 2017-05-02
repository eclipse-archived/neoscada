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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.item.CustomizationRequest;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customization Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.scada.configuration.item.ItemPackage#getCustomizationPipeline()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CustomizationPipeline extends EObject
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model requestDataType="org.eclipse.scada.configuration.item.CustomizationRequest"
     * @generated
     */
    void customize ( CustomizationRequest request );
} // CustomizationPipeline
