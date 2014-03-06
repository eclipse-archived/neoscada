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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Msi Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getUpgradeCode <em>Upgrade Code</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getManufacturer <em>Manufacturer</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getSharedPlatform <em>Shared Platform</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getLocalPlatform <em>Local Platform</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#isEnableFirewall <em>Enable Firewall</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#isEnableUserInterface <em>Enable User Interface</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getLicenseFile <em>License File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism()
 * @model
 * @generated
 */
public interface MsiDeploymentMechanism extends DeploymentMechanism
{
    /**
     * Returns the value of the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Version</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' attribute.
     * @see #setVersion(String)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism_Version()
     * @model required="true"
     * @generated
     */
    String getVersion ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see #getVersion()
     * @generated
     */
    void setVersion ( String value );

    /**
     * Returns the value of the '<em><b>Upgrade Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Upgrade Code</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Upgrade Code</em>' attribute.
     * @see #setUpgradeCode(String)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism_UpgradeCode()
     * @model required="true"
     * @generated
     */
    String getUpgradeCode ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getUpgradeCode <em>Upgrade Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Upgrade Code</em>' attribute.
     * @see #getUpgradeCode()
     * @generated
     */
    void setUpgradeCode ( String value );

    /**
     * Returns the value of the '<em><b>Manufacturer</b></em>' attribute.
     * The default value is <code>"Eclipse SCADA"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Manufacturer</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Manufacturer</em>' attribute.
     * @see #setManufacturer(String)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism_Manufacturer()
     * @model default="Eclipse SCADA" required="true"
     * @generated
     */
    String getManufacturer ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getManufacturer <em>Manufacturer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Manufacturer</em>' attribute.
     * @see #getManufacturer()
     * @generated
     */
    void setManufacturer ( String value );

    /**
     * Returns the value of the '<em><b>Shared Platform</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Shared Platform</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Shared Platform</em>' reference.
     * @see #setSharedPlatform(P2Platform)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism_SharedPlatform()
     * @model
     * @generated
     */
    P2Platform getSharedPlatform ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getSharedPlatform <em>Shared Platform</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Shared Platform</em>' reference.
     * @see #getSharedPlatform()
     * @generated
     */
    void setSharedPlatform ( P2Platform value );

    /**
     * Returns the value of the '<em><b>Local Platform</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Platform</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Platform</em>' containment reference.
     * @see #setLocalPlatform(P2Platform)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism_LocalPlatform()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    P2Platform getLocalPlatform ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getLocalPlatform <em>Local Platform</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Platform</em>' containment reference.
     * @see #getLocalPlatform()
     * @generated
     */
    void setLocalPlatform ( P2Platform value );

    /**
     * Returns the value of the '<em><b>Architecture</b></em>' attribute.
     * The default value is <code>"i386"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.deployment.Architecture}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Architecture</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Architecture</em>' attribute.
     * @see org.eclipse.scada.configuration.world.deployment.Architecture
     * @see #setArchitecture(Architecture)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism_Architecture()
     * @model default="i386" required="true"
     * @generated
     */
    Architecture getArchitecture ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getArchitecture <em>Architecture</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Architecture</em>' attribute.
     * @see org.eclipse.scada.configuration.world.deployment.Architecture
     * @see #getArchitecture()
     * @generated
     */
    void setArchitecture ( Architecture value );

    /**
     * Returns the value of the '<em><b>Enable Firewall</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enable Firewall</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enable Firewall</em>' attribute.
     * @see #setEnableFirewall(boolean)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism_EnableFirewall()
     * @model default="true" required="true"
     * @generated
     */
    boolean isEnableFirewall ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#isEnableFirewall <em>Enable Firewall</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enable Firewall</em>' attribute.
     * @see #isEnableFirewall()
     * @generated
     */
    void setEnableFirewall ( boolean value );

    /**
     * Returns the value of the '<em><b>Enable User Interface</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enable User Interface</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enable User Interface</em>' attribute.
     * @see #setEnableUserInterface(boolean)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism_EnableUserInterface()
     * @model default="true" required="true"
     * @generated
     */
    boolean isEnableUserInterface ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#isEnableUserInterface <em>Enable User Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enable User Interface</em>' attribute.
     * @see #isEnableUserInterface()
     * @generated
     */
    void setEnableUserInterface ( boolean value );

    /**
     * Returns the value of the '<em><b>License File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>License File</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>License File</em>' attribute.
     * @see #setLicenseFile(String)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getMsiDeploymentMechanism_LicenseFile()
     * @model
     * @generated
     */
    String getLicenseFile ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism#getLicenseFile <em>License File</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>License File</em>' attribute.
     * @see #getLicenseFile()
     * @generated
     */
    void setLicenseFile ( String value );

} // MsiDeploymentMechanism
