/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
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
 * A representation of the model object '<em><b>Configuration Admin Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.ConfigurationAdminSettings#isAutomaticMerge <em>Automatic Merge</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.ConfigurationAdminSettings#getSettleTimeout <em>Settle Timeout</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getConfigurationAdminSettings()
 * @model
 * @generated
 */
public interface ConfigurationAdminSettings extends EquinoxModule
{
    /**
     * Returns the value of the '<em><b>Automatic Merge</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Set to "true" if configurations should be merged automatically into the running system.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Automatic Merge</em>' attribute.
     * @see #setAutomaticMerge(boolean)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getConfigurationAdminSettings_AutomaticMerge()
     * @model default="false" required="true"
     * @generated
     */
    boolean isAutomaticMerge ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.ConfigurationAdminSettings#isAutomaticMerge <em>Automatic Merge</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Automatic Merge</em>' attribute.
     * @see #isAutomaticMerge()
     * @generated
     */
    void setAutomaticMerge ( boolean value );

    /**
     * Returns the value of the '<em><b>Settle Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The number of milliseconds to wait until changes have been settled.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Settle Timeout</em>' attribute.
     * @see #setSettleTimeout(Long)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getConfigurationAdminSettings_SettleTimeout()
     * @model
     * @generated
     */
    Long getSettleTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.ConfigurationAdminSettings#getSettleTimeout <em>Settle Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Settle Timeout</em>' attribute.
     * @see #getSettleTimeout()
     * @generated
     */
    void setSettleTimeout ( Long value );

} // ConfigurationAdminSettings
