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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node Mappings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.NodeMappings#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.NodeMappings#getFallbackMode <em>Fallback Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getNodeMappings()
 * @model
 * @generated
 */
public interface NodeMappings extends EObject
{
    /**
     * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.deployment.NodeMappingEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entries</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getNodeMappings_Entries()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<NodeMappingEntry> getEntries ();

    /**
     * Returns the value of the '<em><b>Fallback Mode</b></em>' attribute.
     * The default value is <code>"FAIL"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fallback Mode</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fallback Mode</em>' attribute.
     * @see org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode
     * @see #setFallbackMode(FallbackNodeMappingMode)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getNodeMappings_FallbackMode()
     * @model default="FAIL" required="true"
     * @generated
     */
    FallbackNodeMappingMode getFallbackMode ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.NodeMappings#getFallbackMode <em>Fallback Mode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fallback Mode</em>' attribute.
     * @see org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode
     * @see #getFallbackMode()
     * @generated
     */
    void setFallbackMode ( FallbackNodeMappingMode value );

} // NodeMappings
