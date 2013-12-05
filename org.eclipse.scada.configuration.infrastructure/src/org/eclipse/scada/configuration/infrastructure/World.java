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
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.PasswordCredentials;
import org.eclipse.scada.configuration.world.osgi.IndependentConfiguration;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getOptions <em>Options</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultSecurityConfiguration <em>Default Security Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultMasterHandlerPriorities <em>Default Master Handler Priorities</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultCredentials <em>Default Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultMasterCustomizationProfile <em>Default Master Customization Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultValueArchiveCustomizationProfile <em>Default Value Archive Customization Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultDriverPassword <em>Default Driver Password</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getApplicationConfigurations <em>Application Configurations</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultDriverAccessCredentials <em>Default Driver Access Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.World#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld()
 * @model
 * @generated
 */
public interface World extends EObject
{
    /**
     * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.infrastructure.Node}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nodes</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_Nodes()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Node> getNodes ();

    /**
     * Returns the value of the '<em><b>Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Options</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Options</em>' containment reference.
     * @see #setOptions(Options)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_Options()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    Options getOptions ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.World#getOptions <em>Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Options</em>' containment reference.
     * @see #getOptions()
     * @generated
     */
    void setOptions ( Options value );

    /**
     * Returns the value of the '<em><b>Default Security Configuration</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Security Configuration</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Security Configuration</em>' reference.
     * @see #setDefaultSecurityConfiguration(Configuration)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_DefaultSecurityConfiguration()
     * @model required="true"
     * @generated
     */
    Configuration getDefaultSecurityConfiguration ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultSecurityConfiguration <em>Default Security Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Security Configuration</em>' reference.
     * @see #getDefaultSecurityConfiguration()
     * @generated
     */
    void setDefaultSecurityConfiguration ( Configuration value );

    /**
     * Returns the value of the '<em><b>Default Master Handler Priorities</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Master Handler Priorities</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Master Handler Priorities</em>' reference.
     * @see #setDefaultMasterHandlerPriorities(MasterHandlerPriorities)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_DefaultMasterHandlerPriorities()
     * @model required="true"
     * @generated
     */
    MasterHandlerPriorities getDefaultMasterHandlerPriorities ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultMasterHandlerPriorities <em>Default Master Handler Priorities</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Master Handler Priorities</em>' reference.
     * @see #getDefaultMasterHandlerPriorities()
     * @generated
     */
    void setDefaultMasterHandlerPriorities ( MasterHandlerPriorities value );

    /**
     * Returns the value of the '<em><b>Default Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Credentials</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Credentials</em>' containment reference.
     * @see #setDefaultCredentials(Credentials)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_DefaultCredentials()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Credentials getDefaultCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultCredentials <em>Default Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Credentials</em>' containment reference.
     * @see #getDefaultCredentials()
     * @generated
     */
    void setDefaultCredentials ( Credentials value );

    /**
     * Returns the value of the '<em><b>Default Master Customization Profile</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Master Customization Profile</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Master Customization Profile</em>' reference.
     * @see #setDefaultMasterCustomizationProfile(Profile)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_DefaultMasterCustomizationProfile()
     * @model
     * @generated
     */
    Profile getDefaultMasterCustomizationProfile ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultMasterCustomizationProfile <em>Default Master Customization Profile</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Master Customization Profile</em>' reference.
     * @see #getDefaultMasterCustomizationProfile()
     * @generated
     */
    void setDefaultMasterCustomizationProfile ( Profile value );

    /**
     * Returns the value of the '<em><b>Default Value Archive Customization Profile</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Value Archive Customization Profile</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Value Archive Customization Profile</em>' reference.
     * @see #setDefaultValueArchiveCustomizationProfile(Profile)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_DefaultValueArchiveCustomizationProfile()
     * @model
     * @generated
     */
    Profile getDefaultValueArchiveCustomizationProfile ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultValueArchiveCustomizationProfile <em>Default Value Archive Customization Profile</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Value Archive Customization Profile</em>' reference.
     * @see #getDefaultValueArchiveCustomizationProfile()
     * @generated
     */
    void setDefaultValueArchiveCustomizationProfile ( Profile value );

    /**
     * Returns the value of the '<em><b>Default Driver Password</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Driver Password</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Driver Password</em>' containment reference.
     * @see #setDefaultDriverPassword(PasswordCredentials)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_DefaultDriverPassword()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    PasswordCredentials getDefaultDriverPassword ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultDriverPassword <em>Default Driver Password</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Driver Password</em>' containment reference.
     * @see #getDefaultDriverPassword()
     * @generated
     */
    void setDefaultDriverPassword ( PasswordCredentials value );

    /**
     * Returns the value of the '<em><b>Application Configurations</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.IndependentConfiguration}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Application Configurations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Application Configurations</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_ApplicationConfigurations()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<IndependentConfiguration> getApplicationConfigurations ();

    /**
     * Returns the value of the '<em><b>Default Driver Access Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Driver Access Credentials</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Driver Access Credentials</em>' containment reference.
     * @see #setDefaultDriverAccessCredentials(Credentials)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_DefaultDriverAccessCredentials()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Credentials getDefaultDriverAccessCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.World#getDefaultDriverAccessCredentials <em>Default Driver Access Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Driver Access Credentials</em>' containment reference.
     * @see #getDefaultDriverAccessCredentials()
     * @generated
     */
    void setDefaultDriverAccessCredentials ( Credentials value );

    /**
     * Returns the value of the '<em><b>Configurations</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configurations</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configurations</em>' containment reference.
     * @see #setConfigurations(Configurations)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getWorld_Configurations()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Configurations getConfigurations ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.World#getConfigurations <em>Configurations</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configurations</em>' containment reference.
     * @see #getConfigurations()
     * @generated
     */
    void setConfigurations ( Configurations value );

} // World
