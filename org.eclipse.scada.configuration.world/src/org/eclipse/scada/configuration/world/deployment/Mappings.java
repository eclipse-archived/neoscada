/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
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
 * A representation of the model object '<em><b>Mappings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.Mappings#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.Mappings#getFallbackMode <em>Fallback Mode</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMappings()
 * @model
 * @generated
 */
public interface Mappings extends EObject
{
    /**
     * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.deployment.MappingEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entries</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMappings_Entries()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<MappingEntry> getEntries ();

    /**
     * Returns the value of the '<em><b>Fallback Mode</b></em>' attribute.
     * The default value is <code>"FAIL"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.deployment.FallbackMappingMode}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fallback Mode</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fallback Mode</em>' attribute.
     * @see org.eclipse.scada.configuration.world.deployment.FallbackMappingMode
     * @see #setFallbackMode(FallbackMappingMode)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMappings_FallbackMode()
     * @model default="FAIL" required="true"
     * @generated
     */
    FallbackMappingMode getFallbackMode ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.Mappings#getFallbackMode <em>Fallback Mode</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fallback Mode</em>' attribute.
     * @see org.eclipse.scada.configuration.world.deployment.FallbackMappingMode
     * @see #getFallbackMode()
     * @generated
     */
    void setFallbackMode ( FallbackMappingMode value );

} // Mappings
