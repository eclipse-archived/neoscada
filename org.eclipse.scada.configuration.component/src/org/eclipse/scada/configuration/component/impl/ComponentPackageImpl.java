/*******************************************************************************
 * Copyright (c) 2013, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.impl;

import static org.eclipse.scada.configuration.component.ComponentPackage.CONTAINER;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.component.AbsoluteDanglingReference;
import org.eclipse.scada.configuration.component.AverageModule;
import org.eclipse.scada.configuration.component.BufferedValue;
import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.ChangeCounter;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentDanglingReference;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition;
import org.eclipse.scada.configuration.component.ComponentReferenceOutputDefinition;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.component.Configuration;
import org.eclipse.scada.configuration.component.ConstantValue;
import org.eclipse.scada.configuration.component.DanglingItemReference;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.DataMapperAnalyzer;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.component.DeltaValue;
import org.eclipse.scada.configuration.component.DriverConnectionAnalyzer;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.FormulaModule;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.ItemReferenceInputDefinition;
import org.eclipse.scada.configuration.component.ItemReferenceOutputDefinition;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.component.MappedSourceValue;
import org.eclipse.scada.configuration.component.MarkerConfiguration;
import org.eclipse.scada.configuration.component.MasterAssigned;
import org.eclipse.scada.configuration.component.MasterComponent;
import org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer;
import org.eclipse.scada.configuration.component.MovingAverageModule;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.component.PersistentValue;
import org.eclipse.scada.configuration.component.RestInterceptor;
import org.eclipse.scada.configuration.component.Script;
import org.eclipse.scada.configuration.component.ScriptModule;
import org.eclipse.scada.configuration.component.Service;
import org.eclipse.scada.configuration.component.SingleValue;
import org.eclipse.scada.configuration.component.SummariesConfiguration;
import org.eclipse.scada.configuration.component.TimerScript;
import org.eclipse.scada.configuration.component.TransientValue;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.item.ItemPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.utils.ecore.validation.ExtensibleValidationDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ComponentPackageImpl extends EPackageImpl implements ComponentPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass componentWorldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass levelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass componentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass dataComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass configurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass constantValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass markerConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass serviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass persistentValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass driverConnectionAnalyzerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass masterImportConnectionAnalyzerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass singleValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass dataMapperAnalyzerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass dataMapperServiceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass mappedSourceValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass calculationComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass calculationModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass inputSpecificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass outputSpecificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass outputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass itemReferenceInputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass itemReferenceOutputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass inputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass componentReferenceInputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass formulaModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass averageModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass danglingItemReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass scriptModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass scriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass timerScriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass absoluteDanglingReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass componentDanglingReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass externalValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass summariesConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass itemInterceptorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass containerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass restInterceptorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass globalizeComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass transientValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass masterComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass bufferedValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass changeCounterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass movingAverageModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass deltaValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass masterAssignedEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass componentReferenceOutputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private EDataType notificationEDataType = null;

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
     * @see org.eclipse.scada.configuration.component.ComponentPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ComponentPackageImpl ()
    {
        super ( eNS_URI, ComponentFactory.eINSTANCE );
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
     * This method is used to initialize {@link ComponentPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated NOT
     */
    public static ComponentPackage init ()
    {
        if ( isInited )
        {
            return (ComponentPackage)EPackage.Registry.INSTANCE.getEPackage ( ComponentPackage.eNS_URI );
        }

        // Obtain or create and register package
        final ComponentPackageImpl theComponentPackage = (ComponentPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ComponentPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ComponentPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        InfrastructurePackage.eINSTANCE.eClass ();
        ItemPackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theComponentPackage.createPackageContents ();

        // Initialize created meta-data
        theComponentPackage.initializePackageContents ();

        // Register package validator
        registerPackageValidator ( theComponentPackage );

        // Mark meta-data to indicate it can't be changed
        theComponentPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ComponentPackage.eNS_URI, theComponentPackage );
        return theComponentPackage;
    }

    protected static void registerPackageValidator ( final ComponentPackageImpl theComponentPackage )
    {
        EValidator.Registry.INSTANCE.put ( theComponentPackage, new ExtensibleValidationDescriptor () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getComponentWorld ()
    {
        return this.componentWorldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentWorld_Levels ()
    {
        return (EReference)this.componentWorldEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentWorld_Configurations ()
    {
        return (EReference)this.componentWorldEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentWorld_Services ()
    {
        return (EReference)this.componentWorldEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentWorld_Infrastructure ()
    {
        return (EReference)this.componentWorldEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentWorld_DefaultCustomizationPipeline ()
    {
        return (EReference)this.componentWorldEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentWorld_DefaultArchiveSelector ()
    {
        return (EReference)this.componentWorldEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getLevel ()
    {
        return this.levelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getLevel_Components ()
    {
        return (EReference)this.levelEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getLevel_Name ()
    {
        return (EAttribute)this.levelEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getLevel_Description ()
    {
        return (EAttribute)this.levelEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getLevel_Levels ()
    {
        return (EReference)this.levelEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getLevel_Parent ()
    {
        return (EReference)this.levelEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getLevel_CustomizationPipeline ()
    {
        return (EReference)this.levelEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getLevel_ArchiveSelector ()
    {
        return (EReference)this.levelEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getComponent ()
    {
        return this.componentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponent_Level ()
    {
        return (EReference)this.componentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponent_CustomizationPipeline ()
    {
        return (EReference)this.componentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponent_ArchiveSelector ()
    {
        return (EReference)this.componentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponent_Properties ()
    {
        return (EReference)this.componentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDataComponent ()
    {
        return this.dataComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getDataComponent__GetMasterOn ()
    {
        return this.dataComponentEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getConfiguration ()
    {
        return this.configurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getConstantValue ()
    {
        return this.constantValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getConstantValue_Value ()
    {
        return (EAttribute)this.constantValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getMarkerConfiguration ()
    {
        return this.markerConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getMarkerConfiguration_Markers ()
    {
        return (EReference)this.markerConfigurationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getService ()
    {
        return this.serviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPersistentValue ()
    {
        return this.persistentValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDriverConnectionAnalyzer ()
    {
        return this.driverConnectionAnalyzerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getDriverConnectionAnalyzer_Driver ()
    {
        return (EReference)this.driverConnectionAnalyzerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getMasterImportConnectionAnalyzer ()
    {
        return this.masterImportConnectionAnalyzerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getMasterImportConnectionAnalyzer_Connection ()
    {
        return (EReference)this.masterImportConnectionAnalyzerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getSingleValue ()
    {
        return this.singleValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getSingleValue_Name ()
    {
        return (EAttribute)this.singleValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getSingleValue_DataType ()
    {
        return (EAttribute)this.singleValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getSingleValue_CustomizationTags ()
    {
        return (EAttribute)this.singleValueEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDataMapperAnalyzer ()
    {
        return this.dataMapperAnalyzerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getDataMapperAnalyzer_DataMapper ()
    {
        return (EReference)this.dataMapperAnalyzerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDataMapperService ()
    {
        return this.dataMapperServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getDataMapperService_DataMapper ()
    {
        return (EReference)this.dataMapperServiceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getDataMapperService_MasterOn ()
    {
        return (EReference)this.dataMapperServiceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getMappedSourceValue ()
    {
        return this.mappedSourceValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getMappedSourceValue_Mapper ()
    {
        return (EReference)this.mappedSourceValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getMappedSourceValue_Input ()
    {
        return (EReference)this.mappedSourceValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCalculationComponent ()
    {
        return this.calculationComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCalculationComponent_Implementation ()
    {
        return (EReference)this.calculationComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCalculationComponent_Outputs ()
    {
        return (EReference)this.calculationComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCalculationComponent_Inputs ()
    {
        return (EReference)this.calculationComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCalculationComponent_InitProperties ()
    {
        return (EReference)this.calculationComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getCalculationModule ()
    {
        return this.calculationModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCalculationModule_KnownInputs ()
    {
        return (EReference)this.calculationModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getCalculationModule_KnownOutputs ()
    {
        return (EReference)this.calculationModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getInputSpecification ()
    {
        return this.inputSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getInputSpecification_Name ()
    {
        return (EAttribute)this.inputSpecificationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getOutputSpecification ()
    {
        return this.outputSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getOutputSpecification_Name ()
    {
        return (EAttribute)this.outputSpecificationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getOutputSpecification_DataType ()
    {
        return (EAttribute)this.outputSpecificationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getOutputDefinition ()
    {
        return this.outputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getOutputDefinition_Name ()
    {
        return (EAttribute)this.outputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getOutputDefinition_LocalTag ()
    {
        return (EAttribute)this.outputDefinitionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getOutputDefinition_CustomizationTags ()
    {
        return (EAttribute)this.outputDefinitionEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getOutputDefinition__CreateReference ()
    {
        return this.outputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getItemReferenceInputDefinition ()
    {
        return this.itemReferenceInputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getItemReferenceInputDefinition_ItemId ()
    {
        return (EAttribute)this.itemReferenceInputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getItemReferenceInputDefinition__CreateReference ()
    {
        return this.itemReferenceInputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getItemReferenceOutputDefinition ()
    {
        return this.itemReferenceOutputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getItemReferenceOutputDefinition_ItemId ()
    {
        return (EAttribute)this.itemReferenceOutputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getItemReferenceOutputDefinition__CreateReference ()
    {
        return this.itemReferenceOutputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getInputDefinition ()
    {
        return this.inputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getInputDefinition_Name ()
    {
        return (EAttribute)this.inputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getInputDefinition__CreateReference ()
    {
        return this.inputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getComponentReferenceInputDefinition ()
    {
        return this.componentReferenceInputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentReferenceInputDefinition_Component ()
    {
        return (EReference)this.componentReferenceInputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getComponentReferenceInputDefinition_LocalTag ()
    {
        return (EAttribute)this.componentReferenceInputDefinitionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getComponentReferenceInputDefinition__CreateReference ()
    {
        return this.componentReferenceInputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getFormulaModule ()
    {
        return this.formulaModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getFormulaModule_Inputs ()
    {
        return (EReference)this.formulaModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getFormulaModule_Update ()
    {
        return (EReference)this.formulaModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getFormulaModule_ScriptEngine ()
    {
        return (EAttribute)this.formulaModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getFormulaModule_Init ()
    {
        return (EReference)this.formulaModuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getFormulaModule__GetKnownInputs ()
    {
        return this.formulaModuleEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getFormulaModule__CustomENotify__Notification ()
    {
        return this.formulaModuleEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAverageModule ()
    {
        return this.averageModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getAverageModule_ValidSourcesRequired ()
    {
        return (EAttribute)this.averageModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDanglingItemReference ()
    {
        return this.danglingItemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getScriptModule ()
    {
        return this.scriptModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getScriptModule_Inputs ()
    {
        return (EReference)this.scriptModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getScriptModule_Outputs ()
    {
        return (EReference)this.scriptModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getScriptModule_ScriptEngine ()
    {
        return (EAttribute)this.scriptModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getScriptModule_InitScript ()
    {
        return (EReference)this.scriptModuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getScriptModule_UpdateScript ()
    {
        return (EReference)this.scriptModuleEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getScriptModule_WriteCommandScript ()
    {
        return (EReference)this.scriptModuleEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getScriptModule_TimerScript ()
    {
        return (EReference)this.scriptModuleEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getScriptModule__GetKnownInputs ()
    {
        return this.scriptModuleEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getScriptModule__GetKnownOutputs ()
    {
        return this.scriptModuleEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getScript ()
    {
        return this.scriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getScript_Code ()
    {
        return (EAttribute)this.scriptEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTimerScript ()
    {
        return this.timerScriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTimerScript_Period ()
    {
        return (EAttribute)this.timerScriptEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getTimerScript_Code ()
    {
        return (EAttribute)this.timerScriptEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAbsoluteDanglingReference ()
    {
        return this.absoluteDanglingReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getComponentDanglingReference ()
    {
        return this.componentDanglingReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getComponentDanglingReference_LocalTag ()
    {
        return (EAttribute)this.componentDanglingReferenceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentDanglingReference_Component ()
    {
        return (EReference)this.componentDanglingReferenceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getExternalValue ()
    {
        return this.externalValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getExternalValue_Connection ()
    {
        return (EReference)this.externalValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getExternalValue_SourceName ()
    {
        return (EAttribute)this.externalValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getSummariesConfiguration ()
    {
        return this.summariesConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getSummariesConfiguration_ItemThreshold ()
    {
        return (EAttribute)this.summariesConfigurationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getItemInterceptor ()
    {
        return this.itemInterceptorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getItemInterceptor_Properties ()
    {
        return (EReference)this.itemInterceptorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getContainer ()
    {
        return this.containerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getContainer_ItemInterceptors ()
    {
        return (EReference)this.containerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getContainer_Properties ()
    {
        return (EReference)this.containerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getRestInterceptor ()
    {
        return this.restInterceptorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRestInterceptor_Selector ()
    {
        return (EReference)this.restInterceptorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getRestInterceptor_Definition ()
    {
        return (EReference)this.restInterceptorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getGlobalizeComponent ()
    {
        return this.globalizeComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getGlobalizeComponent_Components ()
    {
        return (EReference)this.globalizeComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getGlobalizeComponent_SourceMaster ()
    {
        return (EReference)this.globalizeComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getGlobalizeComponent_MasterOn ()
    {
        return (EReference)this.globalizeComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getTransientValue ()
    {
        return this.transientValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getMasterComponent ()
    {
        return this.masterComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getBufferedValue ()
    {
        return this.bufferedValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getBufferedValue_Name ()
    {
        return (EAttribute)this.bufferedValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getBufferedValue_Input ()
    {
        return (EReference)this.bufferedValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getBufferedValue_Range ()
    {
        return (EAttribute)this.bufferedValueEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getBufferedValue_InitialValue ()
    {
        return (EAttribute)this.bufferedValueEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getBufferedValue_Persistence ()
    {
        return (EAttribute)this.bufferedValueEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getBufferedValue_Trigger ()
    {
        return (EAttribute)this.bufferedValueEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getBufferedValue_TriggerOnly ()
    {
        return (EAttribute)this.bufferedValueEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getChangeCounter ()
    {
        return this.changeCounterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getChangeCounter_Buffer ()
    {
        return (EReference)this.changeCounterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getChangeCounter_Type ()
    {
        return (EAttribute)this.changeCounterEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getChangeCounter_Values ()
    {
        return (EAttribute)this.changeCounterEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getChangeCounter_OnError ()
    {
        return (EAttribute)this.changeCounterEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getMovingAverageModule ()
    {
        return this.movingAverageModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getMovingAverageModule_NullRange ()
    {
        return (EAttribute)this.movingAverageModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getMovingAverageModule_Range ()
    {
        return (EAttribute)this.movingAverageModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getMovingAverageModule_Trigger ()
    {
        return (EAttribute)this.movingAverageModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getMovingAverageModule_TriggerOnly ()
    {
        return (EAttribute)this.movingAverageModuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getDeltaValue ()
    {
        return this.deltaValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getDeltaValue_Source ()
    {
        return (EReference)this.deltaValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getMasterAssigned ()
    {
        return this.masterAssignedEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getMasterAssigned_MasterOn ()
    {
        return (EReference)this.masterAssignedEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getComponentReferenceOutputDefinition ()
    {
        return this.componentReferenceOutputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getComponentReferenceOutputDefinition_Component ()
    {
        return (EReference)this.componentReferenceOutputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EOperation getComponentReferenceOutputDefinition__CreateReference ()
    {
        return this.componentReferenceOutputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EDataType getNotification ()
    {
        return this.notificationEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ComponentFactory getComponentFactory ()
    {
        return (ComponentFactory)getEFactoryInstance ();
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
        this.componentWorldEClass = createEClass ( COMPONENT_WORLD );
        createEReference ( this.componentWorldEClass, COMPONENT_WORLD__LEVELS );
        createEReference ( this.componentWorldEClass, COMPONENT_WORLD__CONFIGURATIONS );
        createEReference ( this.componentWorldEClass, COMPONENT_WORLD__SERVICES );
        createEReference ( this.componentWorldEClass, COMPONENT_WORLD__INFRASTRUCTURE );
        createEReference ( this.componentWorldEClass, COMPONENT_WORLD__DEFAULT_CUSTOMIZATION_PIPELINE );
        createEReference ( this.componentWorldEClass, COMPONENT_WORLD__DEFAULT_ARCHIVE_SELECTOR );

        this.levelEClass = createEClass ( LEVEL );
        createEReference ( this.levelEClass, LEVEL__COMPONENTS );
        createEReference ( this.levelEClass, LEVEL__LEVELS );
        createEReference ( this.levelEClass, LEVEL__PARENT );
        createEReference ( this.levelEClass, LEVEL__CUSTOMIZATION_PIPELINE );
        createEReference ( this.levelEClass, LEVEL__ARCHIVE_SELECTOR );
        createEAttribute ( this.levelEClass, LEVEL__NAME );
        createEAttribute ( this.levelEClass, LEVEL__DESCRIPTION );

        this.componentEClass = createEClass ( COMPONENT );
        createEReference ( this.componentEClass, COMPONENT__LEVEL );
        createEReference ( this.componentEClass, COMPONENT__CUSTOMIZATION_PIPELINE );
        createEReference ( this.componentEClass, COMPONENT__ARCHIVE_SELECTOR );
        createEReference ( this.componentEClass, COMPONENT__PROPERTIES );

        this.dataComponentEClass = createEClass ( DATA_COMPONENT );
        createEOperation ( this.dataComponentEClass, DATA_COMPONENT___GET_MASTER_ON );

        this.configurationEClass = createEClass ( CONFIGURATION );

        this.constantValueEClass = createEClass ( CONSTANT_VALUE );
        createEAttribute ( this.constantValueEClass, CONSTANT_VALUE__VALUE );

        this.markerConfigurationEClass = createEClass ( MARKER_CONFIGURATION );
        createEReference ( this.markerConfigurationEClass, MARKER_CONFIGURATION__MARKERS );

        this.serviceEClass = createEClass ( SERVICE );

        this.persistentValueEClass = createEClass ( PERSISTENT_VALUE );

        this.driverConnectionAnalyzerEClass = createEClass ( DRIVER_CONNECTION_ANALYZER );
        createEReference ( this.driverConnectionAnalyzerEClass, DRIVER_CONNECTION_ANALYZER__DRIVER );

        this.masterImportConnectionAnalyzerEClass = createEClass ( MASTER_IMPORT_CONNECTION_ANALYZER );
        createEReference ( this.masterImportConnectionAnalyzerEClass, MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION );

        this.singleValueEClass = createEClass ( SINGLE_VALUE );
        createEAttribute ( this.singleValueEClass, SINGLE_VALUE__NAME );
        createEAttribute ( this.singleValueEClass, SINGLE_VALUE__DATA_TYPE );
        createEAttribute ( this.singleValueEClass, SINGLE_VALUE__CUSTOMIZATION_TAGS );

        this.dataMapperAnalyzerEClass = createEClass ( DATA_MAPPER_ANALYZER );
        createEReference ( this.dataMapperAnalyzerEClass, DATA_MAPPER_ANALYZER__DATA_MAPPER );

        this.dataMapperServiceEClass = createEClass ( DATA_MAPPER_SERVICE );
        createEReference ( this.dataMapperServiceEClass, DATA_MAPPER_SERVICE__DATA_MAPPER );
        createEReference ( this.dataMapperServiceEClass, DATA_MAPPER_SERVICE__MASTER_ON );

        this.mappedSourceValueEClass = createEClass ( MAPPED_SOURCE_VALUE );
        createEReference ( this.mappedSourceValueEClass, MAPPED_SOURCE_VALUE__MAPPER );
        createEReference ( this.mappedSourceValueEClass, MAPPED_SOURCE_VALUE__INPUT );

        this.calculationComponentEClass = createEClass ( CALCULATION_COMPONENT );
        createEReference ( this.calculationComponentEClass, CALCULATION_COMPONENT__IMPLEMENTATION );
        createEReference ( this.calculationComponentEClass, CALCULATION_COMPONENT__OUTPUTS );
        createEReference ( this.calculationComponentEClass, CALCULATION_COMPONENT__INPUTS );
        createEReference ( this.calculationComponentEClass, CALCULATION_COMPONENT__INIT_PROPERTIES );

        this.calculationModuleEClass = createEClass ( CALCULATION_MODULE );
        createEReference ( this.calculationModuleEClass, CALCULATION_MODULE__KNOWN_INPUTS );
        createEReference ( this.calculationModuleEClass, CALCULATION_MODULE__KNOWN_OUTPUTS );

        this.inputSpecificationEClass = createEClass ( INPUT_SPECIFICATION );
        createEAttribute ( this.inputSpecificationEClass, INPUT_SPECIFICATION__NAME );

        this.outputSpecificationEClass = createEClass ( OUTPUT_SPECIFICATION );
        createEAttribute ( this.outputSpecificationEClass, OUTPUT_SPECIFICATION__NAME );
        createEAttribute ( this.outputSpecificationEClass, OUTPUT_SPECIFICATION__DATA_TYPE );

        this.outputDefinitionEClass = createEClass ( OUTPUT_DEFINITION );
        createEAttribute ( this.outputDefinitionEClass, OUTPUT_DEFINITION__NAME );
        createEAttribute ( this.outputDefinitionEClass, OUTPUT_DEFINITION__LOCAL_TAG );
        createEAttribute ( this.outputDefinitionEClass, OUTPUT_DEFINITION__CUSTOMIZATION_TAGS );
        createEOperation ( this.outputDefinitionEClass, OUTPUT_DEFINITION___CREATE_REFERENCE );

        this.itemReferenceInputDefinitionEClass = createEClass ( ITEM_REFERENCE_INPUT_DEFINITION );
        createEAttribute ( this.itemReferenceInputDefinitionEClass, ITEM_REFERENCE_INPUT_DEFINITION__ITEM_ID );
        createEOperation ( this.itemReferenceInputDefinitionEClass, ITEM_REFERENCE_INPUT_DEFINITION___CREATE_REFERENCE );

        this.itemReferenceOutputDefinitionEClass = createEClass ( ITEM_REFERENCE_OUTPUT_DEFINITION );
        createEAttribute ( this.itemReferenceOutputDefinitionEClass, ITEM_REFERENCE_OUTPUT_DEFINITION__ITEM_ID );
        createEOperation ( this.itemReferenceOutputDefinitionEClass, ITEM_REFERENCE_OUTPUT_DEFINITION___CREATE_REFERENCE );

        this.inputDefinitionEClass = createEClass ( INPUT_DEFINITION );
        createEAttribute ( this.inputDefinitionEClass, INPUT_DEFINITION__NAME );
        createEOperation ( this.inputDefinitionEClass, INPUT_DEFINITION___CREATE_REFERENCE );

        this.componentReferenceInputDefinitionEClass = createEClass ( COMPONENT_REFERENCE_INPUT_DEFINITION );
        createEReference ( this.componentReferenceInputDefinitionEClass, COMPONENT_REFERENCE_INPUT_DEFINITION__COMPONENT );
        createEAttribute ( this.componentReferenceInputDefinitionEClass, COMPONENT_REFERENCE_INPUT_DEFINITION__LOCAL_TAG );
        createEOperation ( this.componentReferenceInputDefinitionEClass, COMPONENT_REFERENCE_INPUT_DEFINITION___CREATE_REFERENCE );

        this.formulaModuleEClass = createEClass ( FORMULA_MODULE );
        createEReference ( this.formulaModuleEClass, FORMULA_MODULE__INPUTS );
        createEReference ( this.formulaModuleEClass, FORMULA_MODULE__UPDATE );
        createEAttribute ( this.formulaModuleEClass, FORMULA_MODULE__SCRIPT_ENGINE );
        createEReference ( this.formulaModuleEClass, FORMULA_MODULE__INIT );
        createEOperation ( this.formulaModuleEClass, FORMULA_MODULE___GET_KNOWN_INPUTS );
        createEOperation ( this.formulaModuleEClass, FORMULA_MODULE___CUSTOM_ENOTIFY__NOTIFICATION );

        this.averageModuleEClass = createEClass ( AVERAGE_MODULE );
        createEAttribute ( this.averageModuleEClass, AVERAGE_MODULE__VALID_SOURCES_REQUIRED );

        this.danglingItemReferenceEClass = createEClass ( DANGLING_ITEM_REFERENCE );

        this.scriptModuleEClass = createEClass ( SCRIPT_MODULE );
        createEReference ( this.scriptModuleEClass, SCRIPT_MODULE__INPUTS );
        createEReference ( this.scriptModuleEClass, SCRIPT_MODULE__OUTPUTS );
        createEAttribute ( this.scriptModuleEClass, SCRIPT_MODULE__SCRIPT_ENGINE );
        createEReference ( this.scriptModuleEClass, SCRIPT_MODULE__INIT_SCRIPT );
        createEReference ( this.scriptModuleEClass, SCRIPT_MODULE__UPDATE_SCRIPT );
        createEReference ( this.scriptModuleEClass, SCRIPT_MODULE__WRITE_COMMAND_SCRIPT );
        createEReference ( this.scriptModuleEClass, SCRIPT_MODULE__TIMER_SCRIPT );
        createEOperation ( this.scriptModuleEClass, SCRIPT_MODULE___GET_KNOWN_INPUTS );
        createEOperation ( this.scriptModuleEClass, SCRIPT_MODULE___GET_KNOWN_OUTPUTS );

        this.scriptEClass = createEClass ( SCRIPT );
        createEAttribute ( this.scriptEClass, SCRIPT__CODE );

        this.timerScriptEClass = createEClass ( TIMER_SCRIPT );
        createEAttribute ( this.timerScriptEClass, TIMER_SCRIPT__PERIOD );
        createEAttribute ( this.timerScriptEClass, TIMER_SCRIPT__CODE );

        this.absoluteDanglingReferenceEClass = createEClass ( ABSOLUTE_DANGLING_REFERENCE );

        this.componentDanglingReferenceEClass = createEClass ( COMPONENT_DANGLING_REFERENCE );
        createEAttribute ( this.componentDanglingReferenceEClass, COMPONENT_DANGLING_REFERENCE__LOCAL_TAG );
        createEReference ( this.componentDanglingReferenceEClass, COMPONENT_DANGLING_REFERENCE__COMPONENT );

        this.externalValueEClass = createEClass ( EXTERNAL_VALUE );
        createEReference ( this.externalValueEClass, EXTERNAL_VALUE__CONNECTION );
        createEAttribute ( this.externalValueEClass, EXTERNAL_VALUE__SOURCE_NAME );

        this.summariesConfigurationEClass = createEClass ( SUMMARIES_CONFIGURATION );
        createEAttribute ( this.summariesConfigurationEClass, SUMMARIES_CONFIGURATION__ITEM_THRESHOLD );

        this.itemInterceptorEClass = createEClass ( ITEM_INTERCEPTOR );
        createEReference ( this.itemInterceptorEClass, ITEM_INTERCEPTOR__PROPERTIES );

        this.containerEClass = createEClass ( CONTAINER );
        createEReference ( this.containerEClass, CONTAINER__ITEM_INTERCEPTORS );
        createEReference ( this.containerEClass, CONTAINER__PROPERTIES );

        this.restInterceptorEClass = createEClass ( REST_INTERCEPTOR );
        createEReference ( this.restInterceptorEClass, REST_INTERCEPTOR__SELECTOR );
        createEReference ( this.restInterceptorEClass, REST_INTERCEPTOR__DEFINITION );

        this.globalizeComponentEClass = createEClass ( GLOBALIZE_COMPONENT );
        createEReference ( this.globalizeComponentEClass, GLOBALIZE_COMPONENT__COMPONENTS );
        createEReference ( this.globalizeComponentEClass, GLOBALIZE_COMPONENT__SOURCE_MASTER );
        createEReference ( this.globalizeComponentEClass, GLOBALIZE_COMPONENT__MASTER_ON );

        this.transientValueEClass = createEClass ( TRANSIENT_VALUE );

        this.masterComponentEClass = createEClass ( MASTER_COMPONENT );

        this.bufferedValueEClass = createEClass ( BUFFERED_VALUE );
        createEAttribute ( this.bufferedValueEClass, BUFFERED_VALUE__NAME );
        createEReference ( this.bufferedValueEClass, BUFFERED_VALUE__INPUT );
        createEAttribute ( this.bufferedValueEClass, BUFFERED_VALUE__RANGE );
        createEAttribute ( this.bufferedValueEClass, BUFFERED_VALUE__INITIAL_VALUE );
        createEAttribute ( this.bufferedValueEClass, BUFFERED_VALUE__PERSISTENCE );
        createEAttribute ( this.bufferedValueEClass, BUFFERED_VALUE__TRIGGER );
        createEAttribute ( this.bufferedValueEClass, BUFFERED_VALUE__TRIGGER_ONLY );

        this.changeCounterEClass = createEClass ( CHANGE_COUNTER );
        createEReference ( this.changeCounterEClass, CHANGE_COUNTER__BUFFER );
        createEAttribute ( this.changeCounterEClass, CHANGE_COUNTER__TYPE );
        createEAttribute ( this.changeCounterEClass, CHANGE_COUNTER__VALUES );
        createEAttribute ( this.changeCounterEClass, CHANGE_COUNTER__ON_ERROR );

        this.movingAverageModuleEClass = createEClass ( MOVING_AVERAGE_MODULE );
        createEAttribute ( this.movingAverageModuleEClass, MOVING_AVERAGE_MODULE__NULL_RANGE );
        createEAttribute ( this.movingAverageModuleEClass, MOVING_AVERAGE_MODULE__RANGE );
        createEAttribute ( this.movingAverageModuleEClass, MOVING_AVERAGE_MODULE__TRIGGER );
        createEAttribute ( this.movingAverageModuleEClass, MOVING_AVERAGE_MODULE__TRIGGER_ONLY );

        this.deltaValueEClass = createEClass ( DELTA_VALUE );
        createEReference ( this.deltaValueEClass, DELTA_VALUE__SOURCE );

        this.masterAssignedEClass = createEClass ( MASTER_ASSIGNED );
        createEReference ( this.masterAssignedEClass, MASTER_ASSIGNED__MASTER_ON );

        this.componentReferenceOutputDefinitionEClass = createEClass ( COMPONENT_REFERENCE_OUTPUT_DEFINITION );
        createEReference ( this.componentReferenceOutputDefinitionEClass, COMPONENT_REFERENCE_OUTPUT_DEFINITION__COMPONENT );
        createEOperation ( this.componentReferenceOutputDefinitionEClass, COMPONENT_REFERENCE_OUTPUT_DEFINITION___CREATE_REFERENCE );

        // Create data types
        this.notificationEDataType = createEDataType ( NOTIFICATION );
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
        final InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );
        final ItemPackage theItemPackage = (ItemPackage)EPackage.Registry.INSTANCE.getEPackage ( ItemPackage.eNS_URI );
        final WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );
        final OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.componentWorldEClass.getESuperTypes ().add ( getContainer () );
        this.levelEClass.getESuperTypes ().add ( getContainer () );
        this.componentEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        this.dataComponentEClass.getESuperTypes ().add ( getComponent () );
        this.constantValueEClass.getESuperTypes ().add ( getSingleValue () );
        this.markerConfigurationEClass.getESuperTypes ().add ( getConfiguration () );
        this.persistentValueEClass.getESuperTypes ().add ( getSingleValue () );
        this.driverConnectionAnalyzerEClass.getESuperTypes ().add ( getMasterComponent () );
        this.masterImportConnectionAnalyzerEClass.getESuperTypes ().add ( getMasterComponent () );
        this.singleValueEClass.getESuperTypes ().add ( getMasterComponent () );
        this.dataMapperAnalyzerEClass.getESuperTypes ().add ( getMasterComponent () );
        this.dataMapperServiceEClass.getESuperTypes ().add ( getService () );
        this.mappedSourceValueEClass.getESuperTypes ().add ( getSingleValue () );
        this.calculationComponentEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        this.calculationComponentEClass.getESuperTypes ().add ( getMasterComponent () );
        this.calculationModuleEClass.getESuperTypes ().add ( getService () );
        this.itemReferenceInputDefinitionEClass.getESuperTypes ().add ( getInputDefinition () );
        this.itemReferenceOutputDefinitionEClass.getESuperTypes ().add ( getOutputDefinition () );
        this.componentReferenceInputDefinitionEClass.getESuperTypes ().add ( getInputDefinition () );
        this.formulaModuleEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        this.formulaModuleEClass.getESuperTypes ().add ( getCalculationModule () );
        this.averageModuleEClass.getESuperTypes ().add ( getCalculationModule () );
        this.danglingItemReferenceEClass.getESuperTypes ().add ( theOsgiPackage.getItem () );
        this.scriptModuleEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        this.scriptModuleEClass.getESuperTypes ().add ( getCalculationModule () );
        this.absoluteDanglingReferenceEClass.getESuperTypes ().add ( getDanglingItemReference () );
        this.componentDanglingReferenceEClass.getESuperTypes ().add ( getDanglingItemReference () );
        this.externalValueEClass.getESuperTypes ().add ( getSingleValue () );
        this.summariesConfigurationEClass.getESuperTypes ().add ( getConfiguration () );
        this.itemInterceptorEClass.getESuperTypes ().add ( getMasterAssigned () );
        this.restInterceptorEClass.getESuperTypes ().add ( getItemInterceptor () );
        this.globalizeComponentEClass.getESuperTypes ().add ( getDataComponent () );
        this.globalizeComponentEClass.getESuperTypes ().add ( theWorldPackage.getNamedDocumentable () );
        this.transientValueEClass.getESuperTypes ().add ( getSingleValue () );
        this.masterComponentEClass.getESuperTypes ().add ( getDataComponent () );
        this.masterComponentEClass.getESuperTypes ().add ( getMasterAssigned () );
        this.bufferedValueEClass.getESuperTypes ().add ( getMasterComponent () );
        this.changeCounterEClass.getESuperTypes ().add ( getSingleValue () );
        this.movingAverageModuleEClass.getESuperTypes ().add ( getCalculationModule () );
        this.deltaValueEClass.getESuperTypes ().add ( getSingleValue () );
        this.componentReferenceOutputDefinitionEClass.getESuperTypes ().add ( getOutputDefinition () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.componentWorldEClass, ComponentWorld.class, "ComponentWorld", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getComponentWorld_Levels (), getLevel (), null, "levels", null, 0, -1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_Configurations (), getConfiguration (), null, "configurations", null, 0, -1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_Services (), getService (), null, "services", null, 0, -1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_Infrastructure (), theInfrastructurePackage.getWorld (), null, "infrastructure", null, 1, 1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_DefaultCustomizationPipeline (), theItemPackage.getCustomizationPipeline (), null, "defaultCustomizationPipeline", null, 0, 1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_DefaultArchiveSelector (), theItemPackage.getSelector (), null, "defaultArchiveSelector", null, 0, 1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.levelEClass, Level.class, "Level", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getLevel_Components (), getComponent (), getComponent_Level (), "components", null, 0, -1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLevel_Levels (), getLevel (), getLevel_Parent (), "levels", null, 0, -1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLevel_Parent (), getLevel (), getLevel_Levels (), "parent", null, 0, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLevel_CustomizationPipeline (), theItemPackage.getCustomizationPipeline (), null, "customizationPipeline", null, 0, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLevel_ArchiveSelector (), theItemPackage.getSelector (), null, "archiveSelector", null, 0, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevel_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevel_Description (), this.ecorePackage.getEString (), "description", null, 0, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getComponent_Level (), getLevel (), getLevel_Components (), "level", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponent_CustomizationPipeline (), theItemPackage.getCustomizationPipeline (), null, "customizationPipeline", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponent_ArchiveSelector (), theItemPackage.getSelector (), null, "archiveSelector", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponent_Properties (), theWorldPackage.getPropertyEntry (), null, "properties", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.dataComponentEClass, DataComponent.class, "DataComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getDataComponent__GetMasterOn (), theInfrastructurePackage.getMasterServer (), "getMasterOn", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.configurationEClass, Configuration.class, "Configuration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.constantValueEClass, ConstantValue.class, "ConstantValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getConstantValue_Value (), this.ecorePackage.getEString (), "value", null, 0, 1, ConstantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.markerConfigurationEClass, MarkerConfiguration.class, "MarkerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMarkerConfiguration_Markers (), theOsgiPackage.getMarkerEntry (), null, "markers", null, 0, -1, MarkerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.serviceEClass, Service.class, "Service", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.persistentValueEClass, PersistentValue.class, "PersistentValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.driverConnectionAnalyzerEClass, DriverConnectionAnalyzer.class, "DriverConnectionAnalyzer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDriverConnectionAnalyzer_Driver (), theInfrastructurePackage.getDriver (), null, "driver", null, 1, 1, DriverConnectionAnalyzer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.masterImportConnectionAnalyzerEClass, MasterImportConnectionAnalyzer.class, "MasterImportConnectionAnalyzer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterImportConnectionAnalyzer_Connection (), theInfrastructurePackage.getMasterImport (), null, "connection", null, 1, 1, MasterImportConnectionAnalyzer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.singleValueEClass, SingleValue.class, "SingleValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSingleValue_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, SingleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSingleValue_DataType (), theOsgiPackage.getDataType (), "dataType", null, 0, 1, SingleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSingleValue_CustomizationTags (), this.ecorePackage.getEString (), "customizationTags", null, 0, -1, SingleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.dataMapperAnalyzerEClass, DataMapperAnalyzer.class, "DataMapperAnalyzer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDataMapperAnalyzer_DataMapper (), getDataMapperService (), null, "dataMapper", null, 1, 1, DataMapperAnalyzer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.dataMapperServiceEClass, DataMapperService.class, "DataMapperService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDataMapperService_DataMapper (), theOsgiPackage.getDataMapper (), null, "dataMapper", null, 1, 1, DataMapperService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDataMapperService_MasterOn (), theInfrastructurePackage.getMasterServer (), null, "masterOn", null, 0, -1, DataMapperService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.mappedSourceValueEClass, MappedSourceValue.class, "MappedSourceValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMappedSourceValue_Mapper (), getDataMapperService (), null, "mapper", null, 1, 1, MappedSourceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMappedSourceValue_Input (), getInputDefinition (), null, "input", null, 1, 1, MappedSourceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.calculationComponentEClass, CalculationComponent.class, "CalculationComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCalculationComponent_Implementation (), getCalculationModule (), null, "implementation", null, 1, 1, CalculationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCalculationComponent_Outputs (), getOutputDefinition (), null, "outputs", null, 0, -1, CalculationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCalculationComponent_Inputs (), getInputDefinition (), null, "inputs", null, 0, -1, CalculationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCalculationComponent_InitProperties (), theWorldPackage.getPropertyEntry (), null, "initProperties", null, 0, -1, CalculationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.calculationModuleEClass, CalculationModule.class, "CalculationModule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCalculationModule_KnownInputs (), getInputSpecification (), null, "knownInputs", null, 0, -1, CalculationModule.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCalculationModule_KnownOutputs (), getOutputSpecification (), null, "knownOutputs", null, 0, -1, CalculationModule.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.inputSpecificationEClass, InputSpecification.class, "InputSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getInputSpecification_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, InputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.outputSpecificationEClass, OutputSpecification.class, "OutputSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOutputSpecification_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, OutputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getOutputSpecification_DataType (), theOsgiPackage.getDataType (), "dataType", "VARIANT", 1, 1, OutputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.outputDefinitionEClass, OutputDefinition.class, "OutputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOutputDefinition_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, OutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getOutputDefinition_LocalTag (), this.ecorePackage.getEString (), "localTag", null, 1, -1, OutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getOutputDefinition_CustomizationTags (), this.ecorePackage.getEString (), "customizationTags", null, 0, -1, OutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getOutputDefinition__CreateReference (), getDanglingItemReference (), "createReference", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.itemReferenceInputDefinitionEClass, ItemReferenceInputDefinition.class, "ItemReferenceInputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemReferenceInputDefinition_ItemId (), this.ecorePackage.getEString (), "itemId", null, 1, 1, ItemReferenceInputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getItemReferenceInputDefinition__CreateReference (), getDanglingItemReference (), "createReference", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.itemReferenceOutputDefinitionEClass, ItemReferenceOutputDefinition.class, "ItemReferenceOutputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemReferenceOutputDefinition_ItemId (), this.ecorePackage.getEString (), "itemId", null, 1, 1, ItemReferenceOutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getItemReferenceOutputDefinition__CreateReference (), getDanglingItemReference (), "createReference", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.inputDefinitionEClass, InputDefinition.class, "InputDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getInputDefinition_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, InputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getInputDefinition__CreateReference (), getDanglingItemReference (), "createReference", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.componentReferenceInputDefinitionEClass, ComponentReferenceInputDefinition.class, "ComponentReferenceInputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getComponentReferenceInputDefinition_Component (), getComponent (), null, "component", null, 1, 1, ComponentReferenceInputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getComponentReferenceInputDefinition_LocalTag (), this.ecorePackage.getEString (), "localTag", null, 1, -1, ComponentReferenceInputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getComponentReferenceInputDefinition__CreateReference (), getDanglingItemReference (), "createReference", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.formulaModuleEClass, FormulaModule.class, "FormulaModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getFormulaModule_Inputs (), getInputSpecification (), null, "inputs", null, 0, -1, FormulaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFormulaModule_Update (), getScript (), null, "update", null, 0, 1, FormulaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFormulaModule_ScriptEngine (), this.ecorePackage.getEString (), "scriptEngine", "JavaScript", 1, 1, FormulaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getFormulaModule_Init (), getScript (), null, "init", null, 0, -1, FormulaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getFormulaModule__GetKnownInputs (), getInputSpecification (), "getKnownInputs", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        final EOperation op = initEOperation ( getFormulaModule__CustomENotify__Notification (), null, "customENotify", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, getNotification (), "notification", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.averageModuleEClass, AverageModule.class, "AverageModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAverageModule_ValidSourcesRequired (), this.ecorePackage.getEString (), "validSourcesRequired", null, 1, 1, AverageModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.danglingItemReferenceEClass, DanglingItemReference.class, "DanglingItemReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.scriptModuleEClass, ScriptModule.class, "ScriptModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScriptModule_Inputs (), getInputSpecification (), null, "inputs", null, 0, -1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptModule_Outputs (), getOutputSpecification (), null, "outputs", null, 0, -1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptModule_ScriptEngine (), this.ecorePackage.getEString (), "scriptEngine", "JavaScript", 1, 1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getScriptModule_InitScript (), getScript (), null, "initScript", null, 0, 1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptModule_UpdateScript (), getScript (), null, "updateScript", null, 0, 1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptModule_WriteCommandScript (), getScript (), null, "writeCommandScript", null, 0, 1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptModule_TimerScript (), getTimerScript (), null, "timerScript", null, 0, 1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getScriptModule__GetKnownInputs (), getInputSpecification (), "getKnownInputs", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getScriptModule__GetKnownOutputs (), getOutputSpecification (), "getKnownOutputs", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.scriptEClass, Script.class, "Script", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScript_Code (), this.ecorePackage.getEString (), "code", null, 1, 1, Script.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.timerScriptEClass, TimerScript.class, "TimerScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTimerScript_Period (), this.ecorePackage.getELong (), "period", "0", 1, 1, TimerScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getTimerScript_Code (), this.ecorePackage.getEString (), "code", null, 1, 1, TimerScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.absoluteDanglingReferenceEClass, AbsoluteDanglingReference.class, "AbsoluteDanglingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.componentDanglingReferenceEClass, ComponentDanglingReference.class, "ComponentDanglingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getComponentDanglingReference_LocalTag (), this.ecorePackage.getEString (), "localTag", null, 1, -1, ComponentDanglingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentDanglingReference_Component (), getComponent (), null, "component", null, 1, 1, ComponentDanglingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.externalValueEClass, ExternalValue.class, "ExternalValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExternalValue_Connection (), theInfrastructurePackage.getDriver (), null, "connection", null, 1, 1, ExternalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExternalValue_SourceName (), this.ecorePackage.getEString (), "sourceName", null, 1, 1, ExternalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.summariesConfigurationEClass, SummariesConfiguration.class, "SummariesConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSummariesConfiguration_ItemThreshold (), this.ecorePackage.getEIntegerObject (), "itemThreshold", null, 0, 1, SummariesConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.itemInterceptorEClass, ItemInterceptor.class, "ItemInterceptor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getItemInterceptor_Properties (), theWorldPackage.getPropertyEntry (), null, "properties", null, 0, -1, ItemInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.containerEClass, org.eclipse.scada.configuration.component.Container.class, "Container", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getContainer_ItemInterceptors (), getItemInterceptor (), null, "itemInterceptors", null, 0, -1, org.eclipse.scada.configuration.component.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getContainer_Properties (), theWorldPackage.getPropertyEntry (), null, "properties", null, 0, -1, org.eclipse.scada.configuration.component.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.restInterceptorEClass, RestInterceptor.class, "RestInterceptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getRestInterceptor_Selector (), theItemPackage.getSelector (), null, "selector", null, 0, 1, RestInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getRestInterceptor_Definition (), theInfrastructurePackage.getRestExporterModule (), null, "definition", null, 1, 1, RestInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.globalizeComponentEClass, GlobalizeComponent.class, "GlobalizeComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getGlobalizeComponent_Components (), getDataComponent (), null, "components", null, 0, -1, GlobalizeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobalizeComponent_SourceMaster (), theInfrastructurePackage.getMasterImport (), null, "sourceMaster", null, 1, 1, GlobalizeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobalizeComponent_MasterOn (), theInfrastructurePackage.getMasterServer (), null, "masterOn", null, 0, -1, GlobalizeComponent.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.transientValueEClass, TransientValue.class, "TransientValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.masterComponentEClass, MasterComponent.class, "MasterComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.bufferedValueEClass, BufferedValue.class, "BufferedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getBufferedValue_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getBufferedValue_Input (), getInputDefinition (), null, "input", null, 0, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBufferedValue_Range (), this.ecorePackage.getELong (), "range", null, 1, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBufferedValue_InitialValue (), theOsgiPackage.getVariant (), "initialValue", null, 0, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBufferedValue_Persistence (), theOsgiPackage.getPersistence (), "persistence", "NONE", 1, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getBufferedValue_Trigger (), this.ecorePackage.getELong (), "trigger", null, 1, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBufferedValue_TriggerOnly (), this.ecorePackage.getEBoolean (), "triggerOnly", "false", 0, 1, BufferedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.changeCounterEClass, ChangeCounter.class, "ChangeCounter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getChangeCounter_Buffer (), getBufferedValue (), null, "buffer", null, 0, 1, ChangeCounter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChangeCounter_Type (), theOsgiPackage.getChangeType (), "type", null, 0, 1, ChangeCounter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChangeCounter_Values (), theOsgiPackage.getVariant (), "values", null, 0, -1, ChangeCounter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChangeCounter_OnError (), theOsgiPackage.getErrorHandling (), "onError", null, 0, 1, ChangeCounter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.movingAverageModuleEClass, MovingAverageModule.class, "MovingAverageModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMovingAverageModule_NullRange (), this.ecorePackage.getELong (), "nullRange", "30", 1, 1, MovingAverageModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getMovingAverageModule_Range (), this.ecorePackage.getELong (), "range", "60", 1, 1, MovingAverageModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getMovingAverageModule_Trigger (), this.ecorePackage.getELong (), "trigger", "1", 1, 1, MovingAverageModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getMovingAverageModule_TriggerOnly (), this.ecorePackage.getEBoolean (), "triggerOnly", "false", 1, 1, MovingAverageModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.deltaValueEClass, DeltaValue.class, "DeltaValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDeltaValue_Source (), getInputDefinition (), null, "source", null, 1, 1, DeltaValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.masterAssignedEClass, MasterAssigned.class, "MasterAssigned", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterAssigned_MasterOn (), theInfrastructurePackage.getMasterServer (), null, "masterOn", null, 0, -1, MasterAssigned.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.componentReferenceOutputDefinitionEClass, ComponentReferenceOutputDefinition.class, "ComponentReferenceOutputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getComponentReferenceOutputDefinition_Component (), getComponent (), null, "component", null, 1, 1, ComponentReferenceOutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getComponentReferenceOutputDefinition__CreateReference (), getDanglingItemReference (), "createReference", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        // Initialize data types
        initEDataType ( this.notificationEDataType, Notification.class, "Notification", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
    }

    /**
     * Initializes the annotations for
     * <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        final String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$
        addAnnotation ( getGlobalizeComponent_Components (), source, new String[] { "kind", "element" //$NON-NLS-1$ //$NON-NLS-2$
        } );
    }

} //ComponentPackageImpl
