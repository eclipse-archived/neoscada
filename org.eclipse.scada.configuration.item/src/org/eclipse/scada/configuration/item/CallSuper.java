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

import org.eclipse.scada.configuration.item.CustomizationRequest;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Super</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.scada.configuration.item.ItemPackage#getCallSuper()
 * @model
 * @generated
 */
public interface CallSuper extends Step
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model requestDataType="org.eclipse.scada.configuration.item.CustomizationRequest"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='getContainingPipeline().getParent().customize ( request );'"
     * @generated
     */
    void execute ( CustomizationRequest request );
} // CallSuper
