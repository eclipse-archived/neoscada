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
package org.eclipse.scada.configuration.world.deployment;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Mapping Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getNodeMappingEntry()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface NodeMappingEntry extends EObject
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    String mapNode ( String hostname );

} // NodeMappingEntry
