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
package org.eclipse.scada.configuration.world.osgi;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Independent Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This is a marker interface for standalone configuration elements that can be used directly in the infrastructure model.
 * 
 * Modules which can be configured without the reference to any other world model object can use this interface. This allows the direct use of this model without the need to provide a transformation from the Component/Infrastructure model to the World model.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getIndependentConfiguration()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IndependentConfiguration extends ApplicationConfiguration
{
} // IndependentConfiguration
