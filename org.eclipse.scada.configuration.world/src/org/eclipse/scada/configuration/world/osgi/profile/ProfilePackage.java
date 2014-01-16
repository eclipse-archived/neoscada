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
package org.eclipse.scada.configuration.world.osgi.profile;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory
 * @model kind="package"
 * @generated
 */
public interface ProfilePackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "profile"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/World/OSGi/Profile"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "profile"; //$NON-NLS-1$

    /**
     * The package content type ID.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eCONTENT_TYPE = "org.eclipse.scada.configuration.world.osgi.profile"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ProfilePackage eINSTANCE = org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl <em>Profile</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getProfile()
     * @generated
     */
    int PROFILE = 0;

    /**
     * The feature id for the '<em><b>Installation Units</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__INSTALLATION_UNITS = 0;

    /**
     * The feature id for the '<em><b>Jvm Argument</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__JVM_ARGUMENT = 1;

    /**
     * The feature id for the '<em><b>Start</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__START = 2;

    /**
     * The feature id for the '<em><b>Setbsl</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__SETBSL = 3;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__PROPERTY = 4;

    /**
     * The feature id for the '<em><b>Notes</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__NOTES = 5;

    /**
     * The feature id for the '<em><b>Profile</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__PROFILE = 6;

    /**
     * The feature id for the '<em><b>Includes</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__INCLUDES = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__NAME = 8;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__DESCRIPTION = 9;

    /**
     * The number of structural features of the '<em>Profile</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE_FEATURE_COUNT = 10;

    /**
     * The number of operations of the '<em>Profile</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.StartBundleImpl <em>Start Bundle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.StartBundleImpl
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getStartBundle()
     * @generated
     */
    int START_BUNDLE = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_BUNDLE__NAME = 0;

    /**
     * The number of structural features of the '<em>Start Bundle</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_BUNDLE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Start Bundle</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int START_BUNDLE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.SystemPropertyImpl <em>System Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.SystemPropertyImpl
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getSystemProperty()
     * @generated
     */
    int SYSTEM_PROPERTY = 2;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_PROPERTY__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_PROPERTY__VALUE = 1;

    /**
     * The feature id for the '<em><b>Eval</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_PROPERTY__EVAL = 2;

    /**
     * The number of structural features of the '<em>System Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_PROPERTY_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>System Property</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_PROPERTY_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.SubProfileImpl <em>Sub Profile</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.SubProfileImpl
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getSubProfile()
     * @generated
     */
    int SUB_PROFILE = 3;

    /**
     * The feature id for the '<em><b>Property</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROFILE__PROPERTY = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROFILE__NAME = 1;

    /**
     * The number of structural features of the '<em>Sub Profile</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROFILE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Sub Profile</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SUB_PROFILE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.BundleStartLevelImpl <em>Bundle Start Level</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.BundleStartLevelImpl
     * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getBundleStartLevel()
     * @generated
     */
    int BUNDLE_START_LEVEL = 4;

    /**
     * The feature id for the '<em><b>Level</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUNDLE_START_LEVEL__LEVEL = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUNDLE_START_LEVEL__NAME = 1;

    /**
     * The number of structural features of the '<em>Bundle Start Level</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUNDLE_START_LEVEL_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>Bundle Start Level</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BUNDLE_START_LEVEL_OPERATION_COUNT = 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile <em>Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Profile</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile
     * @generated
     */
    EClass getProfile ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getProfile <em>Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Profile</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getProfile()
     * @see #getProfile()
     * @generated
     */
    EReference getProfile_Profile ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getIncludes <em>Includes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Includes</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getIncludes()
     * @see #getProfile()
     * @generated
     */
    EReference getProfile_Includes ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getName()
     * @see #getProfile()
     * @generated
     */
    EAttribute getProfile_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getDescription()
     * @see #getProfile()
     * @generated
     */
    EAttribute getProfile_Description ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getStart <em>Start</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Start</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getStart()
     * @see #getProfile()
     * @generated
     */
    EReference getProfile_Start ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getProperty <em>Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Property</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getProperty()
     * @see #getProfile()
     * @generated
     */
    EReference getProfile_Property ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getSetbsl <em>Setbsl</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Setbsl</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getSetbsl()
     * @see #getProfile()
     * @generated
     */
    EReference getProfile_Setbsl ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getNotes <em>Notes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Notes</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getNotes()
     * @see #getProfile()
     * @generated
     */
    EAttribute getProfile_Notes ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getInstallationUnits <em>Installation Units</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Installation Units</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getInstallationUnits()
     * @see #getProfile()
     * @generated
     */
    EAttribute getProfile_InstallationUnits ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.osgi.profile.Profile#getJvmArgument <em>Jvm Argument</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Jvm Argument</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.Profile#getJvmArgument()
     * @see #getProfile()
     * @generated
     */
    EAttribute getProfile_JvmArgument ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.profile.StartBundle <em>Start Bundle</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Start Bundle</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.StartBundle
     * @generated
     */
    EClass getStartBundle ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.profile.StartBundle#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.StartBundle#getName()
     * @see #getStartBundle()
     * @generated
     */
    EAttribute getStartBundle_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.profile.SystemProperty <em>System Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>System Property</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.SystemProperty
     * @generated
     */
    EClass getSystemProperty ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.profile.SystemProperty#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.SystemProperty#getKey()
     * @see #getSystemProperty()
     * @generated
     */
    EAttribute getSystemProperty_Key ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.profile.SystemProperty#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.SystemProperty#getValue()
     * @see #getSystemProperty()
     * @generated
     */
    EAttribute getSystemProperty_Value ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.profile.SystemProperty#isEval <em>Eval</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Eval</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.SystemProperty#isEval()
     * @see #getSystemProperty()
     * @generated
     */
    EAttribute getSystemProperty_Eval ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.profile.SubProfile <em>Sub Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Sub Profile</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.SubProfile
     * @generated
     */
    EClass getSubProfile ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.osgi.profile.SubProfile#getProperty <em>Property</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Property</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.SubProfile#getProperty()
     * @see #getSubProfile()
     * @generated
     */
    EReference getSubProfile_Property ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.profile.SubProfile#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.SubProfile#getName()
     * @see #getSubProfile()
     * @generated
     */
    EAttribute getSubProfile_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel <em>Bundle Start Level</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Bundle Start Level</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel
     * @generated
     */
    EClass getBundleStartLevel ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel#getLevel <em>Level</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Level</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel#getLevel()
     * @see #getBundleStartLevel()
     * @generated
     */
    EAttribute getBundleStartLevel_Level ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel#getName()
     * @see #getBundleStartLevel()
     * @generated
     */
    EAttribute getBundleStartLevel_Name ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ProfileFactory getProfileFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl <em>Profile</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getProfile()
         * @generated
         */
        EClass PROFILE = eINSTANCE.getProfile ();

        /**
         * The meta object literal for the '<em><b>Profile</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROFILE__PROFILE = eINSTANCE.getProfile_Profile ();

        /**
         * The meta object literal for the '<em><b>Includes</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROFILE__INCLUDES = eINSTANCE.getProfile_Includes ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROFILE__NAME = eINSTANCE.getProfile_Name ();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROFILE__DESCRIPTION = eINSTANCE.getProfile_Description ();

        /**
         * The meta object literal for the '<em><b>Start</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROFILE__START = eINSTANCE.getProfile_Start ();

        /**
         * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROFILE__PROPERTY = eINSTANCE.getProfile_Property ();

        /**
         * The meta object literal for the '<em><b>Setbsl</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROFILE__SETBSL = eINSTANCE.getProfile_Setbsl ();

        /**
         * The meta object literal for the '<em><b>Notes</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROFILE__NOTES = eINSTANCE.getProfile_Notes ();

        /**
         * The meta object literal for the '<em><b>Installation Units</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROFILE__INSTALLATION_UNITS = eINSTANCE.getProfile_InstallationUnits ();

        /**
         * The meta object literal for the '<em><b>Jvm Argument</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROFILE__JVM_ARGUMENT = eINSTANCE.getProfile_JvmArgument ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.StartBundleImpl <em>Start Bundle</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.StartBundleImpl
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getStartBundle()
         * @generated
         */
        EClass START_BUNDLE = eINSTANCE.getStartBundle ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute START_BUNDLE__NAME = eINSTANCE.getStartBundle_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.SystemPropertyImpl <em>System Property</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.SystemPropertyImpl
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getSystemProperty()
         * @generated
         */
        EClass SYSTEM_PROPERTY = eINSTANCE.getSystemProperty ();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYSTEM_PROPERTY__KEY = eINSTANCE.getSystemProperty_Key ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYSTEM_PROPERTY__VALUE = eINSTANCE.getSystemProperty_Value ();

        /**
         * The meta object literal for the '<em><b>Eval</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYSTEM_PROPERTY__EVAL = eINSTANCE.getSystemProperty_Eval ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.SubProfileImpl <em>Sub Profile</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.SubProfileImpl
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getSubProfile()
         * @generated
         */
        EClass SUB_PROFILE = eINSTANCE.getSubProfile ();

        /**
         * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SUB_PROFILE__PROPERTY = eINSTANCE.getSubProfile_Property ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SUB_PROFILE__NAME = eINSTANCE.getSubProfile_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.world.osgi.profile.impl.BundleStartLevelImpl <em>Bundle Start Level</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.BundleStartLevelImpl
         * @see org.eclipse.scada.configuration.world.osgi.profile.impl.ProfilePackageImpl#getBundleStartLevel()
         * @generated
         */
        EClass BUNDLE_START_LEVEL = eINSTANCE.getBundleStartLevel ();

        /**
         * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUNDLE_START_LEVEL__LEVEL = eINSTANCE.getBundleStartLevel_Level ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BUNDLE_START_LEVEL__NAME = eINSTANCE.getBundleStartLevel_Name ();

    }

} //ProfilePackage
