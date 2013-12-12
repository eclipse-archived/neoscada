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
package org.eclipse.scada.configuration.component.exec.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.exec.ExecComponentsFactory;
import org.eclipse.scada.configuration.component.exec.ExecComponentsPackage;
import org.eclipse.scada.configuration.component.exec.ExecJob;
import org.eclipse.scada.configuration.component.exec.LoadAverage;
import org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration;
import org.eclipse.scada.configuration.component.exec.PingCheck;
import org.eclipse.scada.configuration.component.exec.PingCheckConfiguration;
import org.eclipse.scada.configuration.component.exec.SystemInformationVMStat;
import org.eclipse.scada.configuration.component.exec.util.ExecComponentsValidator;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecComponentsPackageImpl extends EPackageImpl implements ExecComponentsPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass execJobEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass loadAverageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass loadAverageConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pingCheckEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass pingCheckConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass systemInformationVMStatEClass = null;

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
     * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ExecComponentsPackageImpl ()
    {
        super ( eNS_URI, ExecComponentsFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link ExecComponentsPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ExecComponentsPackage init ()
    {
        if ( isInited )
            return (ExecComponentsPackage)EPackage.Registry.INSTANCE.getEPackage ( ExecComponentsPackage.eNS_URI );

        // Obtain or create and register package
        ExecComponentsPackageImpl theExecComponentsPackage = (ExecComponentsPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ExecComponentsPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ExecComponentsPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ComponentPackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theExecComponentsPackage.createPackageContents ();

        // Initialize created meta-data
        theExecComponentsPackage.initializePackageContents ();

        // Register package validator
        EValidator.Registry.INSTANCE.put
                ( theExecComponentsPackage,
                        new EValidator.Descriptor ()
                        {
                            public EValidator getEValidator ()
                            {
                                return ExecComponentsValidator.INSTANCE;
                            }
                        } );

        // Mark meta-data to indicate it can't be changed
        theExecComponentsPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ExecComponentsPackage.eNS_URI, theExecComponentsPackage );
        return theExecComponentsPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecJob ()
    {
        return execJobEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecJob_RunsOn ()
    {
        return (EReference)execJobEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecJob_Name ()
    {
        return (EAttribute)execJobEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getExecJob__HasExecDriver__DiagnosticChain_Map ()
    {
        return execJobEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLoadAverage ()
    {
        return loadAverageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLoadAverageConfiguration ()
    {
        return loadAverageConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLoadAverageConfiguration_Period ()
    {
        return (EAttribute)loadAverageConfigurationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLoadAverageConfiguration_Pattern ()
    {
        return (EAttribute)loadAverageConfigurationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPingCheck ()
    {
        return pingCheckEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPingCheck_Node ()
    {
        return (EReference)pingCheckEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPingCheckConfiguration ()
    {
        return pingCheckConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPingCheckConfiguration_PingDelay ()
    {
        return (EAttribute)pingCheckConfigurationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSystemInformationVMStat ()
    {
        return systemInformationVMStatEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecComponentsFactory getExecComponentsFactory ()
    {
        return (ExecComponentsFactory)getEFactoryInstance ();
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
        execJobEClass = createEClass ( EXEC_JOB );
        createEReference ( execJobEClass, EXEC_JOB__RUNS_ON );
        createEAttribute ( execJobEClass, EXEC_JOB__NAME );
        createEOperation ( execJobEClass, EXEC_JOB___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP );

        loadAverageEClass = createEClass ( LOAD_AVERAGE );

        loadAverageConfigurationEClass = createEClass ( LOAD_AVERAGE_CONFIGURATION );
        createEAttribute ( loadAverageConfigurationEClass, LOAD_AVERAGE_CONFIGURATION__PERIOD );
        createEAttribute ( loadAverageConfigurationEClass, LOAD_AVERAGE_CONFIGURATION__PATTERN );

        pingCheckEClass = createEClass ( PING_CHECK );
        createEReference ( pingCheckEClass, PING_CHECK__NODE );

        pingCheckConfigurationEClass = createEClass ( PING_CHECK_CONFIGURATION );
        createEAttribute ( pingCheckConfigurationEClass, PING_CHECK_CONFIGURATION__PING_DELAY );

        systemInformationVMStatEClass = createEClass ( SYSTEM_INFORMATION_VM_STAT );
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

        // Obtain other dependent packages
        ComponentPackage theComponentPackage = (ComponentPackage)EPackage.Registry.INSTANCE.getEPackage ( ComponentPackage.eNS_URI );
        InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );
        SecurityPackage theSecurityPackage = (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage ( SecurityPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        execJobEClass.getESuperTypes ().add ( theComponentPackage.getMasterComponent () );
        loadAverageEClass.getESuperTypes ().add ( this.getExecJob () );
        loadAverageConfigurationEClass.getESuperTypes ().add ( theComponentPackage.getConfiguration () );
        pingCheckEClass.getESuperTypes ().add ( this.getExecJob () );
        pingCheckConfigurationEClass.getESuperTypes ().add ( theComponentPackage.getConfiguration () );
        systemInformationVMStatEClass.getESuperTypes ().add ( this.getExecJob () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( execJobEClass, ExecJob.class, "ExecJob", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExecJob_RunsOn (), theInfrastructurePackage.getDriver (), null, "runsOn", null, 1, 1, ExecJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExecJob_Name (), ecorePackage.getEString (), "name", null, 1, 1, ExecJob.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        EOperation op = initEOperation ( getExecJob__HasExecDriver__DiagnosticChain_Map (), ecorePackage.getEBoolean (), "hasExecDriver", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, ecorePackage.getEDiagnosticChain (), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        EGenericType g1 = createEGenericType ( ecorePackage.getEMap () );
        EGenericType g2 = createEGenericType ( ecorePackage.getEJavaObject () );
        g1.getETypeArguments ().add ( g2 );
        g2 = createEGenericType ( ecorePackage.getEJavaObject () );
        g1.getETypeArguments ().add ( g2 );
        addEParameter ( op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( loadAverageEClass, LoadAverage.class, "LoadAverage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( loadAverageConfigurationEClass, LoadAverageConfiguration.class, "LoadAverageConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getLoadAverageConfiguration_Period (), ecorePackage.getEInt (), "period", "1000", 1, 1, LoadAverageConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getLoadAverageConfiguration_Pattern (), theSecurityPackage.getPattern (), "pattern", "([0-9]+) users?.*averages?: +([0-9]+[,\\\\.][0-9]*),? +([0-9]+[,\\\\.][0-9]*),? +([0-9]+[,\\\\.][0-9]*)", 1, 1, LoadAverageConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( pingCheckEClass, PingCheck.class, "PingCheck", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getPingCheck_Node (), theInfrastructurePackage.getNode (), null, "node", null, 1, 1, PingCheck.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( pingCheckConfigurationEClass, PingCheckConfiguration.class, "PingCheckConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPingCheckConfiguration_PingDelay (), ecorePackage.getEIntegerObject (), "pingDelay", null, 0, 1, PingCheckConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( systemInformationVMStatEClass, SystemInformationVMStat.class, "SystemInformationVMStat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ExecComponentsPackageImpl
