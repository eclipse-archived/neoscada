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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.component.*;
import org.eclipse.scada.configuration.component.AbsoluteDanglingReference;
import org.eclipse.scada.configuration.component.AverageModule;
import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.ComponentDanglingReference;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition;
import org.eclipse.scada.configuration.component.ConstantValue;
import org.eclipse.scada.configuration.component.DataMapperAnalyzer;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.component.DriverConnectionAnalyzer;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.FormulaModule;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.component.InputSpecification;
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
import org.eclipse.scada.configuration.component.SummariesConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentFactoryImpl extends EFactoryImpl implements ComponentFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ComponentFactory init ()
    {
        try
        {
            ComponentFactory theComponentFactory = (ComponentFactory)EPackage.Registry.INSTANCE.getEFactory ( ComponentPackage.eNS_URI );
            if ( theComponentFactory != null )
            {
                return theComponentFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ComponentFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case ComponentPackage.COMPONENT_WORLD:
                return createComponentWorld ();
            case ComponentPackage.LEVEL:
                return createLevel ();
            case ComponentPackage.CONSTANT_VALUE:
                return createConstantValue ();
            case ComponentPackage.MARKER_CONFIGURATION:
                return createMarkerConfiguration ();
            case ComponentPackage.PERSISTENT_VALUE:
                return createPersistentValue ();
            case ComponentPackage.DRIVER_CONNECTION_ANALYZER:
                return createDriverConnectionAnalyzer ();
            case ComponentPackage.MASTER_IMPORT_CONNECTION_ANALYZER:
                return createMasterImportConnectionAnalyzer ();
            case ComponentPackage.DATA_MAPPER_ANALYZER:
                return createDataMapperAnalyzer ();
            case ComponentPackage.DATA_MAPPER_SERVICE:
                return createDataMapperService ();
            case ComponentPackage.MAPPED_SOURCE_VALUE:
                return createMappedSourceValue ();
            case ComponentPackage.CALCULATION_COMPONENT:
                return createCalculationComponent ();
            case ComponentPackage.INPUT_SPECIFICATION:
                return createInputSpecification ();
            case ComponentPackage.OUTPUT_SPECIFICATION:
                return createOutputSpecification ();
            case ComponentPackage.OUTPUT_DEFINITION:
                return createOutputDefinition ();
            case ComponentPackage.ITEM_REFERENCE_INPUT_DEFINITION:
                return createItemReferenceInputDefinition ();
            case ComponentPackage.COMPONENT_REFERENCE_INPUT_DEFINITION:
                return createComponentReferenceInputDefinition ();
            case ComponentPackage.FORMULA_MODULE:
                return createFormulaModule ();
            case ComponentPackage.AVERAGE_MODULE:
                return createAverageModule ();
            case ComponentPackage.SCRIPT_MODULE:
                return createScriptModule ();
            case ComponentPackage.SCRIPT:
                return createScript ();
            case ComponentPackage.ABSOLUTE_DANGLING_REFERENCE:
                return createAbsoluteDanglingReference ();
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE:
                return createComponentDanglingReference ();
            case ComponentPackage.EXTERNAL_VALUE:
                return createExternalValue ();
            case ComponentPackage.SUMMARIES_CONFIGURATION:
                return createSummariesConfiguration ();
            case ComponentPackage.REST_INTERCEPTOR:
                return createRestInterceptor ();
            case ComponentPackage.GLOBALIZE_COMPONENT:
                return createGlobalizeComponent ();
            case ComponentPackage.TRANSIENT_VALUE:
                return createTransientValue ();
            case ComponentPackage.MASTER_COMPONENT:
                return createMasterComponent ();
            case ComponentPackage.BUFFERED_VALUE:
                return createBufferedValue ();
            case ComponentPackage.CHANGE_COUNTER:
                return createChangeCounter ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ComponentPackage.PERSISTENCE:
                return createPersistenceFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ComponentPackage.PERSISTENCE:
                return convertPersistenceToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentWorld createComponentWorld ()
    {
        ComponentWorldImpl componentWorld = new ComponentWorldImpl ();
        return componentWorld;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Level createLevel ()
    {
        LevelImpl level = new LevelImpl ();
        return level;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConstantValue createConstantValue ()
    {
        ConstantValueImpl constantValue = new ConstantValueImpl ();
        return constantValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MarkerConfiguration createMarkerConfiguration ()
    {
        MarkerConfigurationImpl markerConfiguration = new MarkerConfigurationImpl ();
        return markerConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PersistentValue createPersistentValue ()
    {
        PersistentValueImpl persistentValue = new PersistentValueImpl ();
        return persistentValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DriverConnectionAnalyzer createDriverConnectionAnalyzer ()
    {
        DriverConnectionAnalyzerImpl driverConnectionAnalyzer = new DriverConnectionAnalyzerImpl ();
        return driverConnectionAnalyzer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterImportConnectionAnalyzer createMasterImportConnectionAnalyzer ()
    {
        MasterImportConnectionAnalyzerImpl masterImportConnectionAnalyzer = new MasterImportConnectionAnalyzerImpl ();
        return masterImportConnectionAnalyzer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperAnalyzer createDataMapperAnalyzer ()
    {
        DataMapperAnalyzerImpl dataMapperAnalyzer = new DataMapperAnalyzerImpl ();
        return dataMapperAnalyzer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperService createDataMapperService ()
    {
        DataMapperServiceImpl dataMapperService = new DataMapperServiceImpl ();
        return dataMapperService;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappedSourceValue createMappedSourceValue ()
    {
        MappedSourceValueImpl mappedSourceValue = new MappedSourceValueImpl ();
        return mappedSourceValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CalculationComponent createCalculationComponent ()
    {
        CalculationComponentImpl calculationComponent = new CalculationComponentImpl ();
        return calculationComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputSpecification createInputSpecification ()
    {
        InputSpecificationImpl inputSpecification = new InputSpecificationImpl ();
        return inputSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OutputSpecification createOutputSpecification ()
    {
        OutputSpecificationImpl outputSpecification = new OutputSpecificationImpl ();
        return outputSpecification;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OutputDefinition createOutputDefinition ()
    {
        OutputDefinitionImpl outputDefinition = new OutputDefinitionImpl ();
        return outputDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemReferenceInputDefinition createItemReferenceInputDefinition ()
    {
        ItemReferenceInputDefinitionImpl itemReferenceInputDefinition = new ItemReferenceInputDefinitionImpl ();
        return itemReferenceInputDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentReferenceInputDefinition createComponentReferenceInputDefinition ()
    {
        ComponentReferenceInputDefinitionImpl componentReferenceInputDefinition = new ComponentReferenceInputDefinitionImpl ();
        return componentReferenceInputDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FormulaModule createFormulaModule ()
    {
        FormulaModuleImpl formulaModule = new FormulaModuleImpl ();
        return formulaModule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AverageModule createAverageModule ()
    {
        AverageModuleImpl averageModule = new AverageModuleImpl ();
        return averageModule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScriptModule createScriptModule ()
    {
        ScriptModuleImpl scriptModule = new ScriptModuleImpl ();
        return scriptModule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script createScript ()
    {
        ScriptImpl script = new ScriptImpl ();
        return script;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbsoluteDanglingReference createAbsoluteDanglingReference ()
    {
        AbsoluteDanglingReferenceImpl absoluteDanglingReference = new AbsoluteDanglingReferenceImpl ();
        return absoluteDanglingReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentDanglingReference createComponentDanglingReference ()
    {
        ComponentDanglingReferenceImpl componentDanglingReference = new ComponentDanglingReferenceImpl ();
        return componentDanglingReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExternalValue createExternalValue ()
    {
        ExternalValueImpl externalValue = new ExternalValueImpl ();
        return externalValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SummariesConfiguration createSummariesConfiguration ()
    {
        SummariesConfigurationImpl summariesConfiguration = new SummariesConfigurationImpl ();
        return summariesConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RestInterceptor createRestInterceptor ()
    {
        RestInterceptorImpl restInterceptor = new RestInterceptorImpl ();
        return restInterceptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GlobalizeComponent createGlobalizeComponent ()
    {
        GlobalizeComponentImpl globalizeComponent = new GlobalizeComponentImpl ();
        return globalizeComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TransientValue createTransientValue ()
    {
        TransientValueImpl transientValue = new TransientValueImpl ();
        return transientValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterComponent createMasterComponent ()
    {
        MasterComponentImpl masterComponent = new MasterComponentImpl ();
        return masterComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BufferedValue createBufferedValue ()
    {
        BufferedValueImpl bufferedValue = new BufferedValueImpl ();
        return bufferedValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChangeCounter createChangeCounter ()
    {
        ChangeCounterImpl changeCounter = new ChangeCounterImpl ();
        return changeCounter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Persistence createPersistenceFromString ( EDataType eDataType, String initialValue )
    {
        Persistence result = Persistence.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPersistenceToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentPackage getComponentPackage ()
    {
        return (ComponentPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ComponentPackage getPackage ()
    {
        return ComponentPackage.eINSTANCE;
    }

} //ComponentFactoryImpl
