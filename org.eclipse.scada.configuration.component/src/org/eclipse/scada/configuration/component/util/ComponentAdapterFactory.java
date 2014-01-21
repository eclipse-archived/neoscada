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
package org.eclipse.scada.configuration.component.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.component.AbsoluteDanglingReference;
import org.eclipse.scada.configuration.component.AverageModule;
import org.eclipse.scada.configuration.component.BufferedValue;
import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.ChangeCounter;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentDanglingReference;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.component.Configuration;
import org.eclipse.scada.configuration.component.ConstantValue;
import org.eclipse.scada.configuration.component.Container;
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
import org.eclipse.scada.configuration.component.MasterComponent;
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
import org.eclipse.scada.configuration.component.TransientValue;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.osgi.Item;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.scada.configuration.component.ComponentPackage
 * @generated
 */
public class ComponentAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ComponentPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ComponentAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ComponentPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the
     * model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( final Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ComponentSwitch<Adapter> modelSwitch = new ComponentSwitch<Adapter> ()
    {
        @Override
        public Adapter caseComponentWorld ( final ComponentWorld object )
        {
            return createComponentWorldAdapter ();
        }

        @Override
        public Adapter caseLevel ( final Level object )
        {
            return createLevelAdapter ();
        }

        @Override
        public Adapter caseComponent ( final Component object )
        {
            return createComponentAdapter ();
        }

        @Override
        public Adapter caseDataComponent ( final DataComponent object )
        {
            return createDataComponentAdapter ();
        }

        @Override
        public Adapter caseConfiguration ( final Configuration object )
        {
            return createConfigurationAdapter ();
        }

        @Override
        public Adapter caseConstantValue ( final ConstantValue object )
        {
            return createConstantValueAdapter ();
        }

        @Override
        public Adapter caseMarkerConfiguration ( final MarkerConfiguration object )
        {
            return createMarkerConfigurationAdapter ();
        }

        @Override
        public Adapter caseService ( final Service object )
        {
            return createServiceAdapter ();
        }

        @Override
        public Adapter casePersistentValue ( final PersistentValue object )
        {
            return createPersistentValueAdapter ();
        }

        @Override
        public Adapter caseDriverConnectionAnalyzer ( final DriverConnectionAnalyzer object )
        {
            return createDriverConnectionAnalyzerAdapter ();
        }

        @Override
        public Adapter caseMasterImportConnectionAnalyzer ( final MasterImportConnectionAnalyzer object )
        {
            return createMasterImportConnectionAnalyzerAdapter ();
        }

        @Override
        public Adapter caseSingleValue ( final SingleValue object )
        {
            return createSingleValueAdapter ();
        }

        @Override
        public Adapter caseDataMapperAnalyzer ( final DataMapperAnalyzer object )
        {
            return createDataMapperAnalyzerAdapter ();
        }

        @Override
        public Adapter caseDataMapperService ( final DataMapperService object )
        {
            return createDataMapperServiceAdapter ();
        }

        @Override
        public Adapter caseMappedSourceValue ( final MappedSourceValue object )
        {
            return createMappedSourceValueAdapter ();
        }

        @Override
        public Adapter caseCalculationComponent ( final CalculationComponent object )
        {
            return createCalculationComponentAdapter ();
        }

        @Override
        public Adapter caseCalculationModule ( final CalculationModule object )
        {
            return createCalculationModuleAdapter ();
        }

        @Override
        public Adapter caseInputSpecification ( final InputSpecification object )
        {
            return createInputSpecificationAdapter ();
        }

        @Override
        public Adapter caseOutputSpecification ( final OutputSpecification object )
        {
            return createOutputSpecificationAdapter ();
        }

        @Override
        public Adapter caseOutputDefinition ( final OutputDefinition object )
        {
            return createOutputDefinitionAdapter ();
        }

        @Override
        public Adapter caseItemReferenceInputDefinition ( final ItemReferenceInputDefinition object )
        {
            return createItemReferenceInputDefinitionAdapter ();
        }

        @Override
        public Adapter caseInputDefinition ( final InputDefinition object )
        {
            return createInputDefinitionAdapter ();
        }

        @Override
        public Adapter caseComponentReferenceInputDefinition ( final ComponentReferenceInputDefinition object )
        {
            return createComponentReferenceInputDefinitionAdapter ();
        }

        @Override
        public Adapter caseFormulaModule ( final FormulaModule object )
        {
            return createFormulaModuleAdapter ();
        }

        @Override
        public Adapter caseAverageModule ( final AverageModule object )
        {
            return createAverageModuleAdapter ();
        }

        @Override
        public Adapter caseDanglingItemReference ( final DanglingItemReference object )
        {
            return createDanglingItemReferenceAdapter ();
        }

        @Override
        public Adapter caseScriptModule ( final ScriptModule object )
        {
            return createScriptModuleAdapter ();
        }

        @Override
        public Adapter caseScript ( final Script object )
        {
            return createScriptAdapter ();
        }

        @Override
        public Adapter caseAbsoluteDanglingReference ( final AbsoluteDanglingReference object )
        {
            return createAbsoluteDanglingReferenceAdapter ();
        }

        @Override
        public Adapter caseComponentDanglingReference ( final ComponentDanglingReference object )
        {
            return createComponentDanglingReferenceAdapter ();
        }

        @Override
        public Adapter caseExternalValue ( final ExternalValue object )
        {
            return createExternalValueAdapter ();
        }

        @Override
        public Adapter caseSummariesConfiguration ( final SummariesConfiguration object )
        {
            return createSummariesConfigurationAdapter ();
        }

        @Override
        public Adapter caseItemInterceptor ( final ItemInterceptor object )
        {
            return createItemInterceptorAdapter ();
        }

        @Override
        public Adapter caseContainer ( final Container object )
        {
            return createContainerAdapter ();
        }

        @Override
        public Adapter caseRestInterceptor ( final RestInterceptor object )
        {
            return createRestInterceptorAdapter ();
        }

        @Override
        public Adapter caseGlobalizeComponent ( final GlobalizeComponent object )
        {
            return createGlobalizeComponentAdapter ();
        }

        @Override
        public Adapter caseTransientValue ( final TransientValue object )
        {
            return createTransientValueAdapter ();
        }

        @Override
        public Adapter caseMasterComponent ( final MasterComponent object )
        {
            return createMasterComponentAdapter ();
        }

        @Override
        public Adapter caseBufferedValue ( final BufferedValue object )
        {
            return createBufferedValueAdapter ();
        }

        @Override
        public Adapter caseChangeCounter ( final ChangeCounter object )
        {
            return createChangeCounterAdapter ();
        }

        @Override
        public Adapter caseDocumentable ( final Documentable object )
        {
            return createDocumentableAdapter ();
        }

        @Override
        public Adapter caseNamedDocumentable ( final NamedDocumentable object )
        {
            return createNamedDocumentableAdapter ();
        }

        @Override
        public Adapter caseItem ( final Item object )
        {
            return createItemAdapter ();
        }

        @Override
        public Adapter defaultCase ( final EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( final Notifier target )
    {
        return this.modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.ComponentWorld
     * <em>World</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ComponentWorld
     * @generated
     */
    public Adapter createComponentWorldAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.Level <em>Level</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.Level
     * @generated
     */
    public Adapter createLevelAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.Component
     * <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.Component
     * @generated
     */
    public Adapter createComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.DataComponent
     * <em>Data Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.DataComponent
     * @generated
     */
    public Adapter createDataComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.Configuration
     * <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.Configuration
     * @generated
     */
    public Adapter createConfigurationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.ConstantValue
     * <em>Constant Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ConstantValue
     * @generated
     */
    public Adapter createConstantValueAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.MarkerConfiguration
     * <em>Marker Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.MarkerConfiguration
     * @generated
     */
    public Adapter createMarkerConfigurationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.Service
     * <em>Service</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.Service
     * @generated
     */
    public Adapter createServiceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.PersistentValue
     * <em>Persistent Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.PersistentValue
     * @generated
     */
    public Adapter createPersistentValueAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.DriverConnectionAnalyzer
     * <em>Driver Connection Analyzer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.DriverConnectionAnalyzer
     * @generated
     */
    public Adapter createDriverConnectionAnalyzerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer
     * <em>Master Import Connection Analyzer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer
     * @generated
     */
    public Adapter createMasterImportConnectionAnalyzerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.SingleValue
     * <em>Single Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.SingleValue
     * @generated
     */
    public Adapter createSingleValueAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.DataMapperAnalyzer
     * <em>Data Mapper Analyzer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.DataMapperAnalyzer
     * @generated
     */
    public Adapter createDataMapperAnalyzerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.DataMapperService
     * <em>Data Mapper Service</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.DataMapperService
     * @generated
     */
    public Adapter createDataMapperServiceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.MappedSourceValue
     * <em>Mapped Source Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.MappedSourceValue
     * @generated
     */
    public Adapter createMappedSourceValueAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.CalculationComponent
     * <em>Calculation Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.CalculationComponent
     * @generated
     */
    public Adapter createCalculationComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.CalculationModule
     * <em>Calculation Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.CalculationModule
     * @generated
     */
    public Adapter createCalculationModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.InputSpecification
     * <em>Input Specification</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.InputSpecification
     * @generated
     */
    public Adapter createInputSpecificationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.OutputSpecification
     * <em>Output Specification</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.OutputSpecification
     * @generated
     */
    public Adapter createOutputSpecificationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.OutputDefinition
     * <em>Output Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.OutputDefinition
     * @generated
     */
    public Adapter createOutputDefinitionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.ItemReferenceInputDefinition
     * <em>Item Reference Input Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ItemReferenceInputDefinition
     * @generated
     */
    public Adapter createItemReferenceInputDefinitionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.InputDefinition
     * <em>Input Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.InputDefinition
     * @generated
     */
    public Adapter createInputDefinitionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition
     * <em>Reference Input Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition
     * @generated
     */
    public Adapter createComponentReferenceInputDefinitionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.FormulaModule
     * <em>Formula Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.FormulaModule
     * @generated
     */
    public Adapter createFormulaModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.AverageModule
     * <em>Average Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.AverageModule
     * @generated
     */
    public Adapter createAverageModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.DanglingItemReference
     * <em>Dangling Item Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.DanglingItemReference
     * @generated
     */
    public Adapter createDanglingItemReferenceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.ScriptModule
     * <em>Script Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ScriptModule
     * @generated
     */
    public Adapter createScriptModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.Script <em>Script</em>}
     * '.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.Script
     * @generated
     */
    public Adapter createScriptAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.AbsoluteDanglingReference
     * <em>Absolute Dangling Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.AbsoluteDanglingReference
     * @generated
     */
    public Adapter createAbsoluteDanglingReferenceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.ComponentDanglingReference
     * <em>Dangling Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ComponentDanglingReference
     * @generated
     */
    public Adapter createComponentDanglingReferenceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.ExternalValue
     * <em>External Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ExternalValue
     * @generated
     */
    public Adapter createExternalValueAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.SummariesConfiguration
     * <em>Summaries Configuration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.SummariesConfiguration
     * @generated
     */
    public Adapter createSummariesConfigurationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.ItemInterceptor
     * <em>Item Interceptor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ItemInterceptor
     * @generated
     */
    public Adapter createItemInterceptorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.Container
     * <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.Container
     * @generated
     */
    public Adapter createContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.RestInterceptor
     * <em>Rest Interceptor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.RestInterceptor
     * @generated
     */
    public Adapter createRestInterceptorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.GlobalizeComponent
     * <em>Globalize Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.GlobalizeComponent
     * @generated
     */
    public Adapter createGlobalizeComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.TransientValue
     * <em>Transient Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.TransientValue
     * @generated
     */
    public Adapter createTransientValueAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.MasterComponent
     * <em>Master Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.MasterComponent
     * @generated
     */
    public Adapter createMasterComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.BufferedValue
     * <em>Buffered Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.BufferedValue
     * @generated
     */
    public Adapter createBufferedValueAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.component.ChangeCounter
     * <em>Change Counter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ChangeCounter
     * @generated
     */
    public Adapter createChangeCounterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.world.Documentable
     * <em>Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Documentable
     * @generated
     */
    public Adapter createDocumentableAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.world.NamedDocumentable
     * <em>Named Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.NamedDocumentable
     * @generated
     */
    public Adapter createNamedDocumentableAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.configuration.world.osgi.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.Item
     * @generated
     */
    public Adapter createItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //ComponentAdapterFactory
