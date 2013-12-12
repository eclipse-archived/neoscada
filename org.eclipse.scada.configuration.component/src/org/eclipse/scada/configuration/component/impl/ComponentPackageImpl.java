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
package org.eclipse.scada.configuration.component.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.component.AbsoluteDanglingReference;
import org.eclipse.scada.configuration.component.AverageModule;
import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentDanglingReference;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.component.Configuration;
import org.eclipse.scada.configuration.component.ConstantValue;
import org.eclipse.scada.configuration.component.DanglingItemReference;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.DataMapperAnalyzer;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.component.DriverConnectionAnalyzer;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.FormulaModule;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.ItemReferenceInputDefinition;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.component.MappedSourceValue;
import org.eclipse.scada.configuration.component.MarkerConfiguration;
import org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.component.PersistentValue;
import org.eclipse.scada.configuration.component.RestInterceptor;
import org.eclipse.scada.configuration.component.Script;
import org.eclipse.scada.configuration.component.ScriptModule;
import org.eclipse.scada.configuration.component.Service;
import org.eclipse.scada.configuration.component.SingleValue;
import org.eclipse.scada.configuration.component.SummariesConfiguration;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.item.ItemPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentPackageImpl extends EPackageImpl implements ComponentPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass componentWorldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass levelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass componentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass configurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass constantValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass markerConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass serviceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass persistentValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass driverConnectionAnalyzerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass masterImportConnectionAnalyzerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass singleValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataMapperAnalyzerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataMapperServiceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mappedSourceValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass calculationComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass calculationModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass inputSpecificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass outputSpecificationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass outputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemReferenceInputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass inputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass componentReferenceInputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass formulaModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass averageModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass danglingItemReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass absoluteDanglingReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass componentDanglingReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass externalValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass summariesConfigurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemInterceptorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass containerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass restInterceptorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass globalizeComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType notificationEDataType = null;

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
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link ComponentPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ComponentPackage init ()
    {
        if ( isInited )
            return (ComponentPackage)EPackage.Registry.INSTANCE.getEPackage ( ComponentPackage.eNS_URI );

        // Obtain or create and register package
        ComponentPackageImpl theComponentPackage = (ComponentPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ComponentPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ComponentPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        InfrastructurePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theComponentPackage.createPackageContents ();

        // Initialize created meta-data
        theComponentPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theComponentPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ComponentPackage.eNS_URI, theComponentPackage );
        return theComponentPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComponentWorld ()
    {
        return componentWorldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponentWorld_Levels ()
    {
        return (EReference)componentWorldEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponentWorld_Configurations ()
    {
        return (EReference)componentWorldEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponentWorld_Services ()
    {
        return (EReference)componentWorldEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponentWorld_Infrastructure ()
    {
        return (EReference)componentWorldEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponentWorld_DefaultCustomizationPipeline ()
    {
        return (EReference)componentWorldEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponentWorld_DefaultArchiveSelector ()
    {
        return (EReference)componentWorldEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLevel ()
    {
        return levelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLevel_Components ()
    {
        return (EReference)levelEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLevel_Name ()
    {
        return (EAttribute)levelEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLevel_Levels ()
    {
        return (EReference)levelEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLevel_Parent ()
    {
        return (EReference)levelEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLevel_CustomizationPipeline ()
    {
        return (EReference)levelEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLevel_ArchiveSelector ()
    {
        return (EReference)levelEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComponent ()
    {
        return componentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponent_Level ()
    {
        return (EReference)componentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponent_CustomizationPipeline ()
    {
        return (EReference)componentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponent_ArchiveSelector ()
    {
        return (EReference)componentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataComponent ()
    {
        return dataComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataComponent_MasterOn ()
    {
        return (EReference)dataComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConfiguration ()
    {
        return configurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConstantValue ()
    {
        return constantValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConstantValue_Value ()
    {
        return (EAttribute)constantValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMarkerConfiguration ()
    {
        return markerConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMarkerConfiguration_Markers ()
    {
        return (EReference)markerConfigurationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getService ()
    {
        return serviceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPersistentValue ()
    {
        return persistentValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDriverConnectionAnalyzer ()
    {
        return driverConnectionAnalyzerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDriverConnectionAnalyzer_Connection ()
    {
        return (EReference)driverConnectionAnalyzerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMasterImportConnectionAnalyzer ()
    {
        return masterImportConnectionAnalyzerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMasterImportConnectionAnalyzer_Connection ()
    {
        return (EReference)masterImportConnectionAnalyzerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSingleValue ()
    {
        return singleValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSingleValue_Name ()
    {
        return (EAttribute)singleValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSingleValue_DataType ()
    {
        return (EAttribute)singleValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSingleValue_CustomizationTags ()
    {
        return (EAttribute)singleValueEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataMapperAnalyzer ()
    {
        return dataMapperAnalyzerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataMapperAnalyzer_DataMapper ()
    {
        return (EReference)dataMapperAnalyzerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataMapperService ()
    {
        return dataMapperServiceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataMapperService_DataMapper ()
    {
        return (EReference)dataMapperServiceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataMapperService_MasterOn ()
    {
        return (EReference)dataMapperServiceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMappedSourceValue ()
    {
        return mappedSourceValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappedSourceValue_Mapper ()
    {
        return (EReference)mappedSourceValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMappedSourceValue_Input ()
    {
        return (EReference)mappedSourceValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCalculationComponent ()
    {
        return calculationComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCalculationComponent_Implementation ()
    {
        return (EReference)calculationComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCalculationComponent_Outputs ()
    {
        return (EReference)calculationComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCalculationComponent_Inputs ()
    {
        return (EReference)calculationComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCalculationModule ()
    {
        return calculationModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCalculationModule_KnownInputs ()
    {
        return (EReference)calculationModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCalculationModule_KnownOutputs ()
    {
        return (EReference)calculationModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInputSpecification ()
    {
        return inputSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInputSpecification_Name ()
    {
        return (EAttribute)inputSpecificationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOutputSpecification ()
    {
        return outputSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOutputSpecification_Name ()
    {
        return (EAttribute)outputSpecificationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOutputSpecification_DataType ()
    {
        return (EAttribute)outputSpecificationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOutputDefinition ()
    {
        return outputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOutputDefinition_Name ()
    {
        return (EAttribute)outputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOutputDefinition_LocalTag ()
    {
        return (EAttribute)outputDefinitionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItemReferenceInputDefinition ()
    {
        return itemReferenceInputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItemReferenceInputDefinition_ItemId ()
    {
        return (EAttribute)itemReferenceInputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getItemReferenceInputDefinition__CreateReference ()
    {
        return itemReferenceInputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInputDefinition ()
    {
        return inputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInputDefinition_Name ()
    {
        return (EAttribute)inputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getInputDefinition__CreateReference ()
    {
        return inputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComponentReferenceInputDefinition ()
    {
        return componentReferenceInputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponentReferenceInputDefinition_Component ()
    {
        return (EReference)componentReferenceInputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getComponentReferenceInputDefinition_LocalTag ()
    {
        return (EAttribute)componentReferenceInputDefinitionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getComponentReferenceInputDefinition__CreateReference ()
    {
        return componentReferenceInputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFormulaModule ()
    {
        return formulaModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFormulaModule_Inputs ()
    {
        return (EReference)formulaModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFormulaModule_Update ()
    {
        return (EReference)formulaModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFormulaModule_ScriptEngine ()
    {
        return (EAttribute)formulaModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getFormulaModule_Init ()
    {
        return (EReference)formulaModuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getFormulaModule__GetKnownInputs ()
    {
        return formulaModuleEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getFormulaModule__CustomENotify__Notification ()
    {
        return formulaModuleEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAverageModule ()
    {
        return averageModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAverageModule_ValidSourcesRequired ()
    {
        return (EAttribute)averageModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDanglingItemReference ()
    {
        return danglingItemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScriptModule ()
    {
        return scriptModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScriptModule_Inputs ()
    {
        return (EReference)scriptModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScriptModule_Outputs ()
    {
        return (EReference)scriptModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScriptModule_ScriptEngine ()
    {
        return (EAttribute)scriptModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getScriptModule__GetKnownInputs ()
    {
        return scriptModuleEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getScriptModule__CustomENotify__Notification ()
    {
        return scriptModuleEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getScriptModule__GetKnownOutputs ()
    {
        return scriptModuleEClass.getEOperations ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScript ()
    {
        return scriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScript_Code ()
    {
        return (EAttribute)scriptEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbsoluteDanglingReference ()
    {
        return absoluteDanglingReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComponentDanglingReference ()
    {
        return componentDanglingReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getComponentDanglingReference_LocalTag ()
    {
        return (EAttribute)componentDanglingReferenceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponentDanglingReference_Component ()
    {
        return (EReference)componentDanglingReferenceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExternalValue ()
    {
        return externalValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExternalValue_Connection ()
    {
        return (EReference)externalValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExternalValue_SourceName ()
    {
        return (EAttribute)externalValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSummariesConfiguration ()
    {
        return summariesConfigurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSummariesConfiguration_ItemThreshold ()
    {
        return (EAttribute)summariesConfigurationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItemInterceptor ()
    {
        return itemInterceptorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getItemInterceptor_MasterOn ()
    {
        return (EReference)itemInterceptorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getContainer ()
    {
        return containerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getContainer_ItemInterceptors ()
    {
        return (EReference)containerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRestInterceptor ()
    {
        return restInterceptorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRestInterceptor_Selector ()
    {
        return (EReference)restInterceptorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRestInterceptor_Definition ()
    {
        return (EReference)restInterceptorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGlobalizeComponent ()
    {
        return globalizeComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobalizeComponent_Components ()
    {
        return (EReference)globalizeComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGlobalizeComponent_SourceMaster ()
    {
        return (EReference)globalizeComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getNotification ()
    {
        return notificationEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentFactory getComponentFactory ()
    {
        return (ComponentFactory)getEFactoryInstance ();
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
        componentWorldEClass = createEClass ( COMPONENT_WORLD );
        createEReference ( componentWorldEClass, COMPONENT_WORLD__LEVELS );
        createEReference ( componentWorldEClass, COMPONENT_WORLD__CONFIGURATIONS );
        createEReference ( componentWorldEClass, COMPONENT_WORLD__SERVICES );
        createEReference ( componentWorldEClass, COMPONENT_WORLD__INFRASTRUCTURE );
        createEReference ( componentWorldEClass, COMPONENT_WORLD__DEFAULT_CUSTOMIZATION_PIPELINE );
        createEReference ( componentWorldEClass, COMPONENT_WORLD__DEFAULT_ARCHIVE_SELECTOR );

        levelEClass = createEClass ( LEVEL );
        createEReference ( levelEClass, LEVEL__COMPONENTS );
        createEReference ( levelEClass, LEVEL__LEVELS );
        createEReference ( levelEClass, LEVEL__PARENT );
        createEReference ( levelEClass, LEVEL__CUSTOMIZATION_PIPELINE );
        createEReference ( levelEClass, LEVEL__ARCHIVE_SELECTOR );
        createEAttribute ( levelEClass, LEVEL__NAME );

        componentEClass = createEClass ( COMPONENT );
        createEReference ( componentEClass, COMPONENT__LEVEL );
        createEReference ( componentEClass, COMPONENT__CUSTOMIZATION_PIPELINE );
        createEReference ( componentEClass, COMPONENT__ARCHIVE_SELECTOR );

        dataComponentEClass = createEClass ( DATA_COMPONENT );
        createEReference ( dataComponentEClass, DATA_COMPONENT__MASTER_ON );

        configurationEClass = createEClass ( CONFIGURATION );

        constantValueEClass = createEClass ( CONSTANT_VALUE );
        createEAttribute ( constantValueEClass, CONSTANT_VALUE__VALUE );

        markerConfigurationEClass = createEClass ( MARKER_CONFIGURATION );
        createEReference ( markerConfigurationEClass, MARKER_CONFIGURATION__MARKERS );

        serviceEClass = createEClass ( SERVICE );

        persistentValueEClass = createEClass ( PERSISTENT_VALUE );

        driverConnectionAnalyzerEClass = createEClass ( DRIVER_CONNECTION_ANALYZER );
        createEReference ( driverConnectionAnalyzerEClass, DRIVER_CONNECTION_ANALYZER__CONNECTION );

        masterImportConnectionAnalyzerEClass = createEClass ( MASTER_IMPORT_CONNECTION_ANALYZER );
        createEReference ( masterImportConnectionAnalyzerEClass, MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION );

        singleValueEClass = createEClass ( SINGLE_VALUE );
        createEAttribute ( singleValueEClass, SINGLE_VALUE__NAME );
        createEAttribute ( singleValueEClass, SINGLE_VALUE__DATA_TYPE );
        createEAttribute ( singleValueEClass, SINGLE_VALUE__CUSTOMIZATION_TAGS );

        dataMapperAnalyzerEClass = createEClass ( DATA_MAPPER_ANALYZER );
        createEReference ( dataMapperAnalyzerEClass, DATA_MAPPER_ANALYZER__DATA_MAPPER );

        dataMapperServiceEClass = createEClass ( DATA_MAPPER_SERVICE );
        createEReference ( dataMapperServiceEClass, DATA_MAPPER_SERVICE__DATA_MAPPER );
        createEReference ( dataMapperServiceEClass, DATA_MAPPER_SERVICE__MASTER_ON );

        mappedSourceValueEClass = createEClass ( MAPPED_SOURCE_VALUE );
        createEReference ( mappedSourceValueEClass, MAPPED_SOURCE_VALUE__MAPPER );
        createEReference ( mappedSourceValueEClass, MAPPED_SOURCE_VALUE__INPUT );

        calculationComponentEClass = createEClass ( CALCULATION_COMPONENT );
        createEReference ( calculationComponentEClass, CALCULATION_COMPONENT__IMPLEMENTATION );
        createEReference ( calculationComponentEClass, CALCULATION_COMPONENT__OUTPUTS );
        createEReference ( calculationComponentEClass, CALCULATION_COMPONENT__INPUTS );

        calculationModuleEClass = createEClass ( CALCULATION_MODULE );
        createEReference ( calculationModuleEClass, CALCULATION_MODULE__KNOWN_INPUTS );
        createEReference ( calculationModuleEClass, CALCULATION_MODULE__KNOWN_OUTPUTS );

        inputSpecificationEClass = createEClass ( INPUT_SPECIFICATION );
        createEAttribute ( inputSpecificationEClass, INPUT_SPECIFICATION__NAME );

        outputSpecificationEClass = createEClass ( OUTPUT_SPECIFICATION );
        createEAttribute ( outputSpecificationEClass, OUTPUT_SPECIFICATION__NAME );
        createEAttribute ( outputSpecificationEClass, OUTPUT_SPECIFICATION__DATA_TYPE );

        outputDefinitionEClass = createEClass ( OUTPUT_DEFINITION );
        createEAttribute ( outputDefinitionEClass, OUTPUT_DEFINITION__NAME );
        createEAttribute ( outputDefinitionEClass, OUTPUT_DEFINITION__LOCAL_TAG );

        itemReferenceInputDefinitionEClass = createEClass ( ITEM_REFERENCE_INPUT_DEFINITION );
        createEAttribute ( itemReferenceInputDefinitionEClass, ITEM_REFERENCE_INPUT_DEFINITION__ITEM_ID );
        createEOperation ( itemReferenceInputDefinitionEClass, ITEM_REFERENCE_INPUT_DEFINITION___CREATE_REFERENCE );

        inputDefinitionEClass = createEClass ( INPUT_DEFINITION );
        createEAttribute ( inputDefinitionEClass, INPUT_DEFINITION__NAME );
        createEOperation ( inputDefinitionEClass, INPUT_DEFINITION___CREATE_REFERENCE );

        componentReferenceInputDefinitionEClass = createEClass ( COMPONENT_REFERENCE_INPUT_DEFINITION );
        createEReference ( componentReferenceInputDefinitionEClass, COMPONENT_REFERENCE_INPUT_DEFINITION__COMPONENT );
        createEAttribute ( componentReferenceInputDefinitionEClass, COMPONENT_REFERENCE_INPUT_DEFINITION__LOCAL_TAG );
        createEOperation ( componentReferenceInputDefinitionEClass, COMPONENT_REFERENCE_INPUT_DEFINITION___CREATE_REFERENCE );

        formulaModuleEClass = createEClass ( FORMULA_MODULE );
        createEReference ( formulaModuleEClass, FORMULA_MODULE__INPUTS );
        createEReference ( formulaModuleEClass, FORMULA_MODULE__UPDATE );
        createEAttribute ( formulaModuleEClass, FORMULA_MODULE__SCRIPT_ENGINE );
        createEReference ( formulaModuleEClass, FORMULA_MODULE__INIT );
        createEOperation ( formulaModuleEClass, FORMULA_MODULE___GET_KNOWN_INPUTS );
        createEOperation ( formulaModuleEClass, FORMULA_MODULE___CUSTOM_ENOTIFY__NOTIFICATION );

        averageModuleEClass = createEClass ( AVERAGE_MODULE );
        createEAttribute ( averageModuleEClass, AVERAGE_MODULE__VALID_SOURCES_REQUIRED );

        danglingItemReferenceEClass = createEClass ( DANGLING_ITEM_REFERENCE );

        scriptModuleEClass = createEClass ( SCRIPT_MODULE );
        createEReference ( scriptModuleEClass, SCRIPT_MODULE__INPUTS );
        createEReference ( scriptModuleEClass, SCRIPT_MODULE__OUTPUTS );
        createEAttribute ( scriptModuleEClass, SCRIPT_MODULE__SCRIPT_ENGINE );
        createEOperation ( scriptModuleEClass, SCRIPT_MODULE___GET_KNOWN_INPUTS );
        createEOperation ( scriptModuleEClass, SCRIPT_MODULE___CUSTOM_ENOTIFY__NOTIFICATION );
        createEOperation ( scriptModuleEClass, SCRIPT_MODULE___GET_KNOWN_OUTPUTS );

        scriptEClass = createEClass ( SCRIPT );
        createEAttribute ( scriptEClass, SCRIPT__CODE );

        absoluteDanglingReferenceEClass = createEClass ( ABSOLUTE_DANGLING_REFERENCE );

        componentDanglingReferenceEClass = createEClass ( COMPONENT_DANGLING_REFERENCE );
        createEAttribute ( componentDanglingReferenceEClass, COMPONENT_DANGLING_REFERENCE__LOCAL_TAG );
        createEReference ( componentDanglingReferenceEClass, COMPONENT_DANGLING_REFERENCE__COMPONENT );

        externalValueEClass = createEClass ( EXTERNAL_VALUE );
        createEReference ( externalValueEClass, EXTERNAL_VALUE__CONNECTION );
        createEAttribute ( externalValueEClass, EXTERNAL_VALUE__SOURCE_NAME );

        summariesConfigurationEClass = createEClass ( SUMMARIES_CONFIGURATION );
        createEAttribute ( summariesConfigurationEClass, SUMMARIES_CONFIGURATION__ITEM_THRESHOLD );

        itemInterceptorEClass = createEClass ( ITEM_INTERCEPTOR );
        createEReference ( itemInterceptorEClass, ITEM_INTERCEPTOR__MASTER_ON );

        containerEClass = createEClass ( CONTAINER );
        createEReference ( containerEClass, CONTAINER__ITEM_INTERCEPTORS );

        restInterceptorEClass = createEClass ( REST_INTERCEPTOR );
        createEReference ( restInterceptorEClass, REST_INTERCEPTOR__SELECTOR );
        createEReference ( restInterceptorEClass, REST_INTERCEPTOR__DEFINITION );

        globalizeComponentEClass = createEClass ( GLOBALIZE_COMPONENT );
        createEReference ( globalizeComponentEClass, GLOBALIZE_COMPONENT__COMPONENTS );
        createEReference ( globalizeComponentEClass, GLOBALIZE_COMPONENT__SOURCE_MASTER );

        // Create data types
        notificationEDataType = createEDataType ( NOTIFICATION );
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
        InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage)EPackage.Registry.INSTANCE.getEPackage ( InfrastructurePackage.eNS_URI );
        ItemPackage theItemPackage = (ItemPackage)EPackage.Registry.INSTANCE.getEPackage ( ItemPackage.eNS_URI );
        OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE.getEPackage ( WorldPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        componentWorldEClass.getESuperTypes ().add ( this.getContainer () );
        levelEClass.getESuperTypes ().add ( this.getContainer () );
        dataComponentEClass.getESuperTypes ().add ( this.getComponent () );
        constantValueEClass.getESuperTypes ().add ( this.getSingleValue () );
        markerConfigurationEClass.getESuperTypes ().add ( this.getConfiguration () );
        persistentValueEClass.getESuperTypes ().add ( this.getSingleValue () );
        driverConnectionAnalyzerEClass.getESuperTypes ().add ( this.getDataComponent () );
        masterImportConnectionAnalyzerEClass.getESuperTypes ().add ( this.getDataComponent () );
        singleValueEClass.getESuperTypes ().add ( this.getDataComponent () );
        dataMapperAnalyzerEClass.getESuperTypes ().add ( this.getDataComponent () );
        dataMapperServiceEClass.getESuperTypes ().add ( this.getService () );
        mappedSourceValueEClass.getESuperTypes ().add ( this.getDataComponent () );
        mappedSourceValueEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        calculationComponentEClass.getESuperTypes ().add ( this.getDataComponent () );
        calculationComponentEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        calculationModuleEClass.getESuperTypes ().add ( this.getService () );
        itemReferenceInputDefinitionEClass.getESuperTypes ().add ( this.getInputDefinition () );
        componentReferenceInputDefinitionEClass.getESuperTypes ().add ( this.getInputDefinition () );
        formulaModuleEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        formulaModuleEClass.getESuperTypes ().add ( this.getCalculationModule () );
        averageModuleEClass.getESuperTypes ().add ( this.getCalculationModule () );
        danglingItemReferenceEClass.getESuperTypes ().add ( theOsgiPackage.getItem () );
        scriptModuleEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );
        scriptModuleEClass.getESuperTypes ().add ( this.getCalculationModule () );
        absoluteDanglingReferenceEClass.getESuperTypes ().add ( this.getDanglingItemReference () );
        componentDanglingReferenceEClass.getESuperTypes ().add ( this.getDanglingItemReference () );
        externalValueEClass.getESuperTypes ().add ( this.getSingleValue () );
        summariesConfigurationEClass.getESuperTypes ().add ( this.getConfiguration () );
        restInterceptorEClass.getESuperTypes ().add ( this.getItemInterceptor () );
        globalizeComponentEClass.getESuperTypes ().add ( this.getComponent () );
        globalizeComponentEClass.getESuperTypes ().add ( theWorldPackage.getDocumentable () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( componentWorldEClass, ComponentWorld.class, "ComponentWorld", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getComponentWorld_Levels (), this.getLevel (), null, "levels", null, 0, -1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_Configurations (), this.getConfiguration (), null, "configurations", null, 0, -1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_Services (), this.getService (), null, "services", null, 0, -1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_Infrastructure (), theInfrastructurePackage.getWorld (), null, "infrastructure", null, 1, 1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_DefaultCustomizationPipeline (), theItemPackage.getCustomizationPipeline (), null, "defaultCustomizationPipeline", null, 0, 1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentWorld_DefaultArchiveSelector (), theItemPackage.getSelector (), null, "defaultArchiveSelector", null, 0, 1, ComponentWorld.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( levelEClass, Level.class, "Level", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getLevel_Components (), this.getComponent (), this.getComponent_Level (), "components", null, 0, -1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLevel_Levels (), this.getLevel (), this.getLevel_Parent (), "levels", null, 0, -1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLevel_Parent (), this.getLevel (), this.getLevel_Levels (), "parent", null, 0, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLevel_CustomizationPipeline (), theItemPackage.getCustomizationPipeline (), null, "customizationPipeline", null, 0, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getLevel_ArchiveSelector (), theItemPackage.getSelector (), null, "archiveSelector", null, 0, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getLevel_Name (), ecorePackage.getEString (), "name", null, 1, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getComponent_Level (), this.getLevel (), this.getLevel_Components (), "level", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponent_CustomizationPipeline (), theItemPackage.getCustomizationPipeline (), null, "customizationPipeline", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponent_ArchiveSelector (), theItemPackage.getSelector (), null, "archiveSelector", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( dataComponentEClass, DataComponent.class, "DataComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDataComponent_MasterOn (), theInfrastructurePackage.getMasterServer (), null, "masterOn", null, 0, -1, DataComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( configurationEClass, Configuration.class, "Configuration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( constantValueEClass, ConstantValue.class, "ConstantValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getConstantValue_Value (), ecorePackage.getEString (), "value", null, 0, 1, ConstantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( markerConfigurationEClass, MarkerConfiguration.class, "MarkerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMarkerConfiguration_Markers (), theOsgiPackage.getMarkerEntry (), null, "markers", null, 0, -1, MarkerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( serviceEClass, Service.class, "Service", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( persistentValueEClass, PersistentValue.class, "PersistentValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( driverConnectionAnalyzerEClass, DriverConnectionAnalyzer.class, "DriverConnectionAnalyzer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDriverConnectionAnalyzer_Connection (), theInfrastructurePackage.getDriver (), null, "connection", null, 1, 1, DriverConnectionAnalyzer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( masterImportConnectionAnalyzerEClass, MasterImportConnectionAnalyzer.class, "MasterImportConnectionAnalyzer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMasterImportConnectionAnalyzer_Connection (), theInfrastructurePackage.getMasterImport (), null, "connection", null, 1, 1, MasterImportConnectionAnalyzer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( singleValueEClass, SingleValue.class, "SingleValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSingleValue_Name (), ecorePackage.getEString (), "name", null, 1, 1, SingleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSingleValue_DataType (), theOsgiPackage.getDataType (), "dataType", null, 0, 1, SingleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSingleValue_CustomizationTags (), ecorePackage.getEString (), "customizationTags", null, 0, -1, SingleValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( dataMapperAnalyzerEClass, DataMapperAnalyzer.class, "DataMapperAnalyzer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDataMapperAnalyzer_DataMapper (), this.getDataMapperService (), null, "dataMapper", null, 1, 1, DataMapperAnalyzer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( dataMapperServiceEClass, DataMapperService.class, "DataMapperService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDataMapperService_DataMapper (), theOsgiPackage.getDataMapper (), null, "dataMapper", null, 1, 1, DataMapperService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDataMapperService_MasterOn (), theInfrastructurePackage.getMasterServer (), null, "masterOn", null, 0, -1, DataMapperService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( mappedSourceValueEClass, MappedSourceValue.class, "MappedSourceValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMappedSourceValue_Mapper (), this.getDataMapperService (), null, "mapper", null, 1, 1, MappedSourceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMappedSourceValue_Input (), this.getInputDefinition (), null, "input", null, 1, 1, MappedSourceValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( calculationComponentEClass, CalculationComponent.class, "CalculationComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCalculationComponent_Implementation (), this.getCalculationModule (), null, "implementation", null, 1, 1, CalculationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCalculationComponent_Outputs (), this.getOutputDefinition (), null, "outputs", null, 0, -1, CalculationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCalculationComponent_Inputs (), this.getInputDefinition (), null, "inputs", null, 0, -1, CalculationComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( calculationModuleEClass, CalculationModule.class, "CalculationModule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCalculationModule_KnownInputs (), this.getInputSpecification (), null, "knownInputs", null, 0, -1, CalculationModule.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCalculationModule_KnownOutputs (), this.getOutputSpecification (), null, "knownOutputs", null, 0, -1, CalculationModule.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( inputSpecificationEClass, InputSpecification.class, "InputSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getInputSpecification_Name (), ecorePackage.getEString (), "name", null, 1, 1, InputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( outputSpecificationEClass, OutputSpecification.class, "OutputSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOutputSpecification_Name (), ecorePackage.getEString (), "name", null, 1, 1, OutputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getOutputSpecification_DataType (), theOsgiPackage.getDataType (), "dataType", "VARIANT", 1, 1, OutputSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( outputDefinitionEClass, OutputDefinition.class, "OutputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOutputDefinition_Name (), ecorePackage.getEString (), "name", null, 1, 1, OutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getOutputDefinition_LocalTag (), ecorePackage.getEString (), "localTag", null, 1, -1, OutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemReferenceInputDefinitionEClass, ItemReferenceInputDefinition.class, "ItemReferenceInputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemReferenceInputDefinition_ItemId (), ecorePackage.getEString (), "itemId", null, 1, 1, ItemReferenceInputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getItemReferenceInputDefinition__CreateReference (), this.getDanglingItemReference (), "createReference", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( inputDefinitionEClass, InputDefinition.class, "InputDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getInputDefinition_Name (), ecorePackage.getEString (), "name", null, 1, 1, InputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getInputDefinition__CreateReference (), this.getDanglingItemReference (), "createReference", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( componentReferenceInputDefinitionEClass, ComponentReferenceInputDefinition.class, "ComponentReferenceInputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getComponentReferenceInputDefinition_Component (), this.getComponent (), null, "component", null, 1, 1, ComponentReferenceInputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getComponentReferenceInputDefinition_LocalTag (), ecorePackage.getEString (), "localTag", null, 1, -1, ComponentReferenceInputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getComponentReferenceInputDefinition__CreateReference (), this.getDanglingItemReference (), "createReference", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( formulaModuleEClass, FormulaModule.class, "FormulaModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getFormulaModule_Inputs (), this.getInputSpecification (), null, "inputs", null, 0, -1, FormulaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFormulaModule_Update (), this.getScript (), null, "update", null, 0, 1, FormulaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFormulaModule_ScriptEngine (), ecorePackage.getEString (), "scriptEngine", "JavaScript", 1, 1, FormulaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getFormulaModule_Init (), this.getScript (), null, "init", null, 0, -1, FormulaModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getFormulaModule__GetKnownInputs (), this.getInputSpecification (), "getKnownInputs", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        EOperation op = initEOperation ( getFormulaModule__CustomENotify__Notification (), null, "customENotify", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getNotification (), "notification", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( averageModuleEClass, AverageModule.class, "AverageModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAverageModule_ValidSourcesRequired (), ecorePackage.getEString (), "validSourcesRequired", null, 1, 1, AverageModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( danglingItemReferenceEClass, DanglingItemReference.class, "DanglingItemReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( scriptModuleEClass, ScriptModule.class, "ScriptModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScriptModule_Inputs (), this.getInputSpecification (), null, "inputs", null, 0, -1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptModule_Outputs (), this.getOutputSpecification (), null, "outputs", null, 0, -1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptModule_ScriptEngine (), ecorePackage.getEString (), "scriptEngine", "JavaScript", 1, 1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEOperation ( getScriptModule__GetKnownInputs (), this.getInputSpecification (), "getKnownInputs", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getScriptModule__CustomENotify__Notification (), null, "customENotify", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getNotification (), "notification", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getScriptModule__GetKnownOutputs (), this.getOutputSpecification (), "getKnownOutputs", 0, -1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( scriptEClass, Script.class, "Script", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScript_Code (), ecorePackage.getEString (), "code", null, 1, 1, Script.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( absoluteDanglingReferenceEClass, AbsoluteDanglingReference.class, "AbsoluteDanglingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( componentDanglingReferenceEClass, ComponentDanglingReference.class, "ComponentDanglingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getComponentDanglingReference_LocalTag (), ecorePackage.getEString (), "localTag", null, 1, -1, ComponentDanglingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponentDanglingReference_Component (), this.getComponent (), null, "component", null, 1, 1, ComponentDanglingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( externalValueEClass, ExternalValue.class, "ExternalValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getExternalValue_Connection (), theInfrastructurePackage.getDriver (), null, "connection", null, 1, 1, ExternalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getExternalValue_SourceName (), ecorePackage.getEString (), "sourceName", null, 1, 1, ExternalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( summariesConfigurationEClass, SummariesConfiguration.class, "SummariesConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSummariesConfiguration_ItemThreshold (), ecorePackage.getEIntegerObject (), "itemThreshold", null, 0, 1, SummariesConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemInterceptorEClass, ItemInterceptor.class, "ItemInterceptor", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getItemInterceptor_MasterOn (), theInfrastructurePackage.getMasterServer (), null, "masterOn", null, 0, -1, ItemInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( containerEClass, org.eclipse.scada.configuration.component.Container.class, "Container", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getContainer_ItemInterceptors (), this.getItemInterceptor (), null, "itemInterceptors", null, 0, -1, org.eclipse.scada.configuration.component.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( restInterceptorEClass, RestInterceptor.class, "RestInterceptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getRestInterceptor_Selector (), theItemPackage.getSelector (), null, "selector", null, 0, 1, RestInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getRestInterceptor_Definition (), theInfrastructurePackage.getRestExporterModule (), null, "definition", null, 1, 1, RestInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( globalizeComponentEClass, GlobalizeComponent.class, "GlobalizeComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getGlobalizeComponent_Components (), this.getDataComponent (), null, "components", null, 0, -1, GlobalizeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGlobalizeComponent_SourceMaster (), theInfrastructurePackage.getMasterImport (), null, "sourceMaster", null, 1, 1, GlobalizeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize data types
        initEDataType ( notificationEDataType, Notification.class, "Notification", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ComponentPackageImpl
