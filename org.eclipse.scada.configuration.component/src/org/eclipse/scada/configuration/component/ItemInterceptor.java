/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.infrastructure.MasterServer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Item Interceptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.ItemInterceptor#getMasterOn <em>Master On</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getItemInterceptor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ItemInterceptor extends EObject
{

    /**
     * Returns the value of the '<em><b>Master On</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.MasterServer}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Master On</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Master On</em>' reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getItemInterceptor_MasterOn()
     * @model
     * @generated
     */
    EList<MasterServer> getMasterOn ();
} // ItemInterceptor
