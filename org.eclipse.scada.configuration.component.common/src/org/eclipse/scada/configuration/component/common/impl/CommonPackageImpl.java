/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.component.common.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector;
import org.eclipse.scada.configuration.component.common.CommonFactory;
import org.eclipse.scada.configuration.component.common.CommonPackage;
import org.eclipse.scada.configuration.component.common.CurrentTimeComponent;
import org.eclipse.scada.configuration.component.common.DateFormat;
import org.eclipse.scada.configuration.component.common.HeartbeatDetector;
import org.eclipse.scada.configuration.component.common.HeartbeatGenerator;
import org.eclipse.scada.configuration.component.common.ScaledValue;
import org.eclipse.scada.configuration.component.common.TimerAction;
import org.eclipse.scada.configuration.component.common.ToggleHeartbeatGenerator;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.utils.ecore.validation.ExtensibleValidationDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass heartbeatGeneratorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass toggleHeartbeatGeneratorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass heartbeatDetectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass changeHeartbeatDetectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass timerActionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass currentTimeComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass scaledValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EDataType dateFormatEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package
     * package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.configuration.component.common.CommonPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CommonPackageImpl ()
    {
        super ( eNS_URI, CommonFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link CommonPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated NOT
     */
    public static CommonPackage init ()
    {
        if ( isInited )
        {
            return (CommonPackage)EPackage.Registry.INSTANCE.getEPackage ( CommonPackage.eNS_URI );
        }

        // Obtain or create and register package
        final CommonPackageImpl theCommonPackage = (CommonPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new CommonPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        ComponentPackage.eINSTANCE.eClass ();
        EcorePackage.eINSTANCE.eClass ();
        XMLTypePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theCommonPackage.createPackageContents ();

        // Initialize created meta-data
        theCommonPackage.initializePackageContents ();

        // register validation
        registerPackageValidator ( theCommonPackage );

        // Mark meta-data to indicate it can't be changed
        theCommonPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( CommonPackage.eNS_URI, theCommonPackage );
        return theCommonPackage;
    }

    protected static void registerPackageValidator ( final CommonPackageImpl theCommonPackage )
    {
        EValidator.Registry.INSTANCE.put ( theCommonPackage, new ExtensibleValidationDescriptor () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getHeartbeatGenerator ()
    {
        return this.heartbeatGeneratorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getHeartbeatGenerator_Period ()
    {
        return (EAttribute)this.heartbeatGeneratorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getHeartbeatGenerator_TargetItem ()
    {
        return (EReference)this.heartbeatGeneratorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getHeartbeatGenerator_ActiveInput ()
    {
        return (EReference)this.heartbeatGeneratorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getToggleHeartbeatGenerator ()
    {
        return this.toggleHeartbeatGeneratorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getHeartbeatDetector ()
    {
        return this.heartbeatDetectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getChangeHeartbeatDetector ()
    {
        return this.changeHeartbeatDetectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getChangeHeartbeatDetector_Timeout ()
    {
        return (EAttribute)this.changeHeartbeatDetectorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getChangeHeartbeatDetector_CheckPeriod ()
    {
        return (EAttribute)this.changeHeartbeatDetectorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getChangeHeartbeatDetector_SourceItem ()
    {
        return (EReference)this.changeHeartbeatDetectorEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTimerAction ()
    {
        return this.timerActionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTimerAction_Period ()
    {
        return (EAttribute)this.timerActionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getTimerAction_TargetItem ()
    {
        return (EReference)this.timerActionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTimerAction_Value ()
    {
        return (EAttribute)this.timerActionEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTimerAction_Name ()
    {
        return (EAttribute)this.timerActionEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCurrentTimeComponent ()
    {
        return this.currentTimeComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getCurrentTimeComponent_Name ()
    {
        return (EAttribute)this.currentTimeComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getCurrentTimeComponent_UpdatePeriod ()
    {
        return (EAttribute)this.currentTimeComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getCurrentTimeComponent_DateFormat ()
    {
        return (EAttribute)this.currentTimeComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getScaledValue ()
    {
        return this.scaledValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getScaledValue_SourceItem ()
    {
        return (EReference)this.scaledValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getScaledValue_InputMinimum ()
    {
        return (EAttribute)this.scaledValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getScaledValue_InputMaximum ()
    {
        return (EAttribute)this.scaledValueEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getScaledValue_OutputMinimum ()
    {
        return (EAttribute)this.scaledValueEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getScaledValue_OutputMaximum ()
    {
        return (EAttribute)this.scaledValueEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getScaledValue_ValidateRange ()
    {
        return (EAttribute)this.scaledValueEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EDataType getDateFormat ()
    {
        return this.dateFormatEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public CommonFactory getCommonFactory ()
    {
        return (CommonFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void createPackageContents ()
    {
        if ( this.isCreated )
        {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.heartbeatGeneratorEClass = createEClass ( HEARTBEAT_GENERATOR );
        createEAttribute ( this.heartbeatGeneratorEClass, HEARTBEAT_GENERATOR__PERIOD );
        createEReference ( this.heartbeatGeneratorEClass, HEARTBEAT_GENERATOR__TARGET_ITEM );
        createEReference ( this.heartbeatGeneratorEClass, HEARTBEAT_GENERATOR__ACTIVE_INPUT );

        this.toggleHeartbeatGeneratorEClass = createEClass ( TOGGLE_HEARTBEAT_GENERATOR );

        this.heartbeatDetectorEClass = createEClass ( HEARTBEAT_DETECTOR );

        this.changeHeartbeatDetectorEClass = createEClass ( CHANGE_HEARTBEAT_DETECTOR );
        createEAttribute ( this.changeHeartbeatDetectorEClass, CHANGE_HEARTBEAT_DETECTOR__TIMEOUT );
        createEAttribute ( this.changeHeartbeatDetectorEClass, CHANGE_HEARTBEAT_DETECTOR__CHECK_PERIOD );
        createEReference ( this.changeHeartbeatDetectorEClass, CHANGE_HEARTBEAT_DETECTOR__SOURCE_ITEM );

        this.timerActionEClass = createEClass ( TIMER_ACTION );
        createEAttribute ( this.timerActionEClass, TIMER_ACTION__PERIOD );
        createEReference ( this.timerActionEClass, TIMER_ACTION__TARGET_ITEM );
        createEAttribute ( this.timerActionEClass, TIMER_ACTION__VALUE );
        createEAttribute ( this.timerActionEClass, TIMER_ACTION__NAME );

        this.currentTimeComponentEClass = createEClass ( CURRENT_TIME_COMPONENT );
        createEAttribute ( this.currentTimeComponentEClass, CURRENT_TIME_COMPONENT__NAME );
        createEAttribute ( this.currentTimeComponentEClass, CURRENT_TIME_COMPONENT__UPDATE_PERIOD );
        createEAttribute ( this.currentTimeComponentEClass, CURRENT_TIME_COMPONENT__DATE_FORMAT );

        this.scaledValueEClass = createEClass ( SCALED_VALUE );
        createEReference ( this.scaledValueEClass, SCALED_VALUE__SOURCE_ITEM );
        createEAttribute ( this.scaledValueEClass, SCALED_VALUE__INPUT_MINIMUM );
        createEAttribute ( this.scaledValueEClass, SCALED_VALUE__INPUT_MAXIMUM );
        createEAttribute ( this.scaledValueEClass, SCALED_VALUE__OUTPUT_MINIMUM );
        createEAttribute ( this.scaledValueEClass, SCALED_VALUE__OUTPUT_MAXIMUM );
        createEAttribute ( this.scaledValueEClass, SCALED_VALUE__VALIDATE_RANGE );

        // Create data types
        this.dateFormatEDataType = createEDataType ( DATE_FORMAT );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( this.isInitialized )
        {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Obtain other dependent packages
        final ComponentPackage theComponentPackage = (ComponentPackage)EPackage.Registry.INSTANCE.getEPackage ( ComponentPackage.eNS_URI );
        final OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        final XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage ( XMLTypePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.heartbeatGeneratorEClass.getESuperTypes ().add ( theComponentPackage.getMasterComponent () );
        this.toggleHeartbeatGeneratorEClass.getESuperTypes ().add ( getHeartbeatGenerator () );
        this.heartbeatDetectorEClass.getESuperTypes ().add ( theComponentPackage.getMasterComponent () );
        this.changeHeartbeatDetectorEClass.getESuperTypes ().add ( getHeartbeatDetector () );
        this.timerActionEClass.getESuperTypes ().add ( theComponentPackage.getMasterComponent () );
        this.currentTimeComponentEClass.getESuperTypes ().add ( theComponentPackage.getMasterComponent () );
        this.scaledValueEClass.getESuperTypes ().add ( theComponentPackage.getSingleValue () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.heartbeatGeneratorEClass, HeartbeatGenerator.class, "HeartbeatGenerator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getHeartbeatGenerator_Period (), this.ecorePackage.getELong (), "period", "1000", 1, 1, HeartbeatGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getHeartbeatGenerator_TargetItem (), theComponentPackage.getInputDefinition (), null, "targetItem", null, 0, 1, HeartbeatGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getHeartbeatGenerator_ActiveInput (), theComponentPackage.getInputDefinition (), null, "activeInput", null, 0, 1, HeartbeatGenerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.toggleHeartbeatGeneratorEClass, ToggleHeartbeatGenerator.class, "ToggleHeartbeatGenerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.heartbeatDetectorEClass, HeartbeatDetector.class, "HeartbeatDetector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.changeHeartbeatDetectorEClass, ChangeHeartbeatDetector.class, "ChangeHeartbeatDetector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getChangeHeartbeatDetector_Timeout (), this.ecorePackage.getELong (), "timeout", "10000", 1, 1, ChangeHeartbeatDetector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getChangeHeartbeatDetector_CheckPeriod (), this.ecorePackage.getELong (), "checkPeriod", "1000", 1, 1, ChangeHeartbeatDetector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getChangeHeartbeatDetector_SourceItem (), theComponentPackage.getInputDefinition (), null, "sourceItem", null, 1, 1, ChangeHeartbeatDetector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.timerActionEClass, TimerAction.class, "TimerAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTimerAction_Period (), this.ecorePackage.getELong (), "period", "1000", 1, 1, TimerAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getTimerAction_TargetItem (), theComponentPackage.getInputDefinition (), null, "targetItem", null, 1, 1, TimerAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTimerAction_Value (), theOsgiPackage.getVariant (), "value", null, 1, 1, TimerAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTimerAction_Name (), theXMLTypePackage.getString (), "name", "$TIMER_ACTION", 1, 1, TimerAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.currentTimeComponentEClass, CurrentTimeComponent.class, "CurrentTimeComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCurrentTimeComponent_Name (), this.ecorePackage.getEString (), "name", "TIME", 1, -1, CurrentTimeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getCurrentTimeComponent_UpdatePeriod (), this.ecorePackage.getELong (), "updatePeriod", "100", 1, 1, CurrentTimeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getCurrentTimeComponent_DateFormat (), getDateFormat (), "dateFormat", "", 0, 1, CurrentTimeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.scaledValueEClass, ScaledValue.class, "ScaledValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScaledValue_SourceItem (), theComponentPackage.getInputDefinition (), null, "sourceItem", null, 1, 1, ScaledValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScaledValue_InputMinimum (), this.ecorePackage.getEDouble (), "inputMinimum", "0", 1, 1, ScaledValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getScaledValue_InputMaximum (), this.ecorePackage.getEDouble (), "inputMaximum", "100", 1, 1, ScaledValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getScaledValue_OutputMinimum (), this.ecorePackage.getEDouble (), "outputMinimum", "0", 1, 1, ScaledValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getScaledValue_OutputMaximum (), this.ecorePackage.getEDouble (), "outputMaximum", "1000", 1, 1, ScaledValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getScaledValue_ValidateRange (), this.ecorePackage.getEBoolean (), "validateRange", "true", 1, 1, ScaledValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        // Initialize data types
        initEDataType ( this.dateFormatEDataType, DateFormat.class, "DateFormat", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //CommonPackageImpl
