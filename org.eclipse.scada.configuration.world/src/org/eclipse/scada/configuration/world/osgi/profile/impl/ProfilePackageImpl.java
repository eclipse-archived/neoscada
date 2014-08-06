/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi.profile.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl;
import org.eclipse.scada.configuration.world.impl.WorldPackageImpl;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.impl.OsgiPackageImpl;
import org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.StartBundle;
import org.eclipse.scada.configuration.world.osgi.profile.SubProfile;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;
import org.eclipse.scada.configuration.world.setup.SetupPackage;
import org.eclipse.scada.configuration.world.setup.impl.SetupPackageImpl;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProfilePackageImpl extends EPackageImpl implements ProfilePackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass profileEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass startBundleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass systemPropertyEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass subProfileEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass bundleStartLevelEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ProfilePackageImpl ()
    {
        super ( eNS_URI, ProfileFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link ProfilePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ProfilePackage init ()
    {
        if ( isInited )
            return (ProfilePackage)EPackage.Registry.INSTANCE.getEPackage ( ProfilePackage.eNS_URI );

        // Obtain or create and register package
        ProfilePackageImpl theProfilePackage = (ProfilePackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ProfilePackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ProfilePackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass ();
        ConfigurationPackage.eINSTANCE.eClass ();
        SecurityPackage.eINSTANCE.eClass ();

        // Obtain or create and register interdependencies
        WorldPackageImpl theWorldPackage = (WorldPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) instanceof WorldPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI ) : WorldPackage.eINSTANCE );
        OsgiPackageImpl theOsgiPackage = (OsgiPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) instanceof OsgiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI ) : OsgiPackage.eINSTANCE );
        DeploymentPackageImpl theDeploymentPackage = (DeploymentPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) instanceof DeploymentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( DeploymentPackage.eNS_URI ) : DeploymentPackage.eINSTANCE );
        SetupPackageImpl theSetupPackage = (SetupPackageImpl) ( EPackage.Registry.INSTANCE.getEPackage ( SetupPackage.eNS_URI ) instanceof SetupPackageImpl ? EPackage.Registry.INSTANCE.getEPackage ( SetupPackage.eNS_URI ) : SetupPackage.eINSTANCE );

        // Create package meta-data objects
        theProfilePackage.createPackageContents ();
        theWorldPackage.createPackageContents ();
        theOsgiPackage.createPackageContents ();
        theDeploymentPackage.createPackageContents ();
        theSetupPackage.createPackageContents ();

        // Initialize created meta-data
        theProfilePackage.initializePackageContents ();
        theWorldPackage.initializePackageContents ();
        theOsgiPackage.initializePackageContents ();
        theDeploymentPackage.initializePackageContents ();
        theSetupPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theProfilePackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ProfilePackage.eNS_URI, theProfilePackage );
        return theProfilePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProfile ()
    {
        return profileEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProfile_Profile ()
    {
        return (EReference)profileEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProfile_Includes ()
    {
        return (EReference)profileEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProfile_Name ()
    {
        return (EAttribute)profileEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProfile_Description ()
    {
        return (EAttribute)profileEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProfile_Arguments ()
    {
        return (EAttribute)profileEClass.getEStructuralFeatures ().get ( 10 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProfile_Start ()
    {
        return (EReference)profileEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProfile_Property ()
    {
        return (EReference)profileEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProfile_Setbsl ()
    {
        return (EReference)profileEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProfile_Notes ()
    {
        return (EAttribute)profileEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProfile_InstallationUnits ()
    {
        return (EAttribute)profileEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProfile_JvmArguments ()
    {
        return (EAttribute)profileEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStartBundle ()
    {
        return startBundleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStartBundle_Name ()
    {
        return (EAttribute)startBundleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSystemProperty ()
    {
        return systemPropertyEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSystemProperty_Key ()
    {
        return (EAttribute)systemPropertyEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSystemProperty_Value ()
    {
        return (EAttribute)systemPropertyEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSystemProperty_Eval ()
    {
        return (EAttribute)systemPropertyEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSubProfile ()
    {
        return subProfileEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSubProfile_Property ()
    {
        return (EReference)subProfileEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSubProfile_Name ()
    {
        return (EAttribute)subProfileEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBundleStartLevel ()
    {
        return bundleStartLevelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBundleStartLevel_Level ()
    {
        return (EAttribute)bundleStartLevelEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBundleStartLevel_Name ()
    {
        return (EAttribute)bundleStartLevelEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProfileFactory getProfileFactory ()
    {
        return (ProfileFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents ()
    {
        if ( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        profileEClass = createEClass ( PROFILE );
        createEAttribute ( profileEClass, PROFILE__INSTALLATION_UNITS );
        createEAttribute ( profileEClass, PROFILE__JVM_ARGUMENTS );
        createEReference ( profileEClass, PROFILE__START );
        createEReference ( profileEClass, PROFILE__SETBSL );
        createEReference ( profileEClass, PROFILE__PROPERTY );
        createEAttribute ( profileEClass, PROFILE__NOTES );
        createEReference ( profileEClass, PROFILE__PROFILE );
        createEReference ( profileEClass, PROFILE__INCLUDES );
        createEAttribute ( profileEClass, PROFILE__NAME );
        createEAttribute ( profileEClass, PROFILE__DESCRIPTION );
        createEAttribute ( profileEClass, PROFILE__ARGUMENTS );

        startBundleEClass = createEClass ( START_BUNDLE );
        createEAttribute ( startBundleEClass, START_BUNDLE__NAME );

        systemPropertyEClass = createEClass ( SYSTEM_PROPERTY );
        createEAttribute ( systemPropertyEClass, SYSTEM_PROPERTY__KEY );
        createEAttribute ( systemPropertyEClass, SYSTEM_PROPERTY__VALUE );
        createEAttribute ( systemPropertyEClass, SYSTEM_PROPERTY__EVAL );

        subProfileEClass = createEClass ( SUB_PROFILE );
        createEReference ( subProfileEClass, SUB_PROFILE__PROPERTY );
        createEAttribute ( subProfileEClass, SUB_PROFILE__NAME );

        bundleStartLevelEClass = createEClass ( BUNDLE_START_LEVEL );
        createEAttribute ( bundleStartLevelEClass, BUNDLE_START_LEVEL__LEVEL );
        createEAttribute ( bundleStartLevelEClass, BUNDLE_START_LEVEL__NAME );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes, features, and operations; add parameters
        initEClass ( profileEClass, Profile.class, "Profile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getProfile_InstallationUnits (), ecorePackage.getEString (), "installationUnits", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProfile_JvmArguments (), ecorePackage.getEString (), "jvmArguments", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProfile_Start (), this.getStartBundle (), null, "start", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getProfile_Start ().getEKeys ().add ( this.getStartBundle_Name () );
        initEReference ( getProfile_Setbsl (), this.getBundleStartLevel (), null, "setbsl", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProfile_Property (), this.getSystemProperty (), null, "property", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProfile_Notes (), ecorePackage.getEString (), "notes", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProfile_Profile (), this.getSubProfile (), null, "profile", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProfile_Includes (), this.getProfile (), null, "includes", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProfile_Name (), ecorePackage.getEString (), "name", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProfile_Description (), ecorePackage.getEString (), "description", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProfile_Arguments (), ecorePackage.getEString (), "arguments", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( startBundleEClass, StartBundle.class, "StartBundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getStartBundle_Name (), ecorePackage.getEString (), "name", null, 1, 1, StartBundle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( systemPropertyEClass, SystemProperty.class, "SystemProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSystemProperty_Key (), ecorePackage.getEString (), "key", null, 1, 1, SystemProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSystemProperty_Value (), ecorePackage.getEString (), "value", null, 0, 1, SystemProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSystemProperty_Eval (), ecorePackage.getEBoolean (), "eval", "false", 0, 1, SystemProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( subProfileEClass, SubProfile.class, "SubProfile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSubProfile_Property (), this.getSystemProperty (), null, "property", null, 0, -1, SubProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSubProfile_Name (), ecorePackage.getEString (), "name", null, 1, 1, SubProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( bundleStartLevelEClass, BundleStartLevel.class, "BundleStartLevel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getBundleStartLevel_Level (), ecorePackage.getEInt (), "level", null, 1, 1, BundleStartLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBundleStartLevel_Name (), ecorePackage.getEString (), "name", null, 1, 1, BundleStartLevel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$	
        addAnnotation ( profileEClass,
                source,
                new String[]
                {       "name", "profile" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getProfile_InstallationUnits (),
                source,
                new String[]
                {       "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "feature" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getProfile_JvmArguments (),
                source,
                new String[]
                {       "name", "argument", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "element" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getProfile_Setbsl (),
                source,
                new String[]
                {       "kind", "element" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getProfile_Notes (),
                source,
                new String[]
                {       "name", "note", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "element" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getProfile_Name (),
                source,
                new String[]
                {       "kind", "attribute" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getProfile_Arguments (),
                source,
                new String[]
                {       "name", "arg", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "element" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( startBundleEClass,
                source,
                new String[]
                {       "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getStartBundle_Name (),
                source,
                new String[]
                {       "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( systemPropertyEClass,
                source,
                new String[]
                {       "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getSystemProperty_Key (),
                source,
                new String[]
                {       "kind", "attribute" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getSystemProperty_Value (),
                source,
                new String[]
                {       "kind", "simple", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", ":0" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getSystemProperty_Eval (),
                source,
                new String[]
                {       "kind", "attribute" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( bundleStartLevelEClass,
                source,
                new String[]
                {       "name", "BundleStartLevel", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getBundleStartLevel_Level (),
                source,
                new String[]
                {       "kind", "attribute" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getBundleStartLevel_Name (),
                source,
                new String[]
                {       "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
    }

} //ProfilePackageImpl
