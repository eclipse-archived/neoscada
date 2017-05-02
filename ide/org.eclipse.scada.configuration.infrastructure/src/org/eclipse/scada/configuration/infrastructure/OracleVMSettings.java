/**
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.infrastructure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Oracle VM Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.OracleVMSettings#getInitialHeapSize <em>Initial Heap Size</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.OracleVMSettings#getMaximumHeapSize <em>Maximum Heap Size</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOracleVMSettings()
 * @model annotation="http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup groupId='oracle.vm.settings'"
 * @generated
 */
public interface OracleVMSettings extends JavaModule
{
    /**
     * Returns the value of the '<em><b>Initial Heap Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Initial Heap Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Initial Heap Size</em>' attribute.
     * @see #setInitialHeapSize(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOracleVMSettings_InitialHeapSize()
     * @model
     * @generated
     */
    String getInitialHeapSize ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.OracleVMSettings#getInitialHeapSize <em>Initial Heap Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Initial Heap Size</em>' attribute.
     * @see #getInitialHeapSize()
     * @generated
     */
    void setInitialHeapSize ( String value );

    /**
     * Returns the value of the '<em><b>Maximum Heap Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Maximum Heap Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Maximum Heap Size</em>' attribute.
     * @see #setMaximumHeapSize(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOracleVMSettings_MaximumHeapSize()
     * @model
     * @generated
     */
    String getMaximumHeapSize ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.OracleVMSettings#getMaximumHeapSize <em>Maximum Heap Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Maximum Heap Size</em>' attribute.
     * @see #getMaximumHeapSize()
     * @generated
     */
    void setMaximumHeapSize ( String value );

} // OracleVMSettings
