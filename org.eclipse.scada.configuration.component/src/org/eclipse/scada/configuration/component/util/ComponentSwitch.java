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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.scada.configuration.component.ComponentPackage
 * @generated
 */
public class ComponentSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ComponentPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ComponentSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ComponentPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( final EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code>
     *         call.
     * @generated
     */
    @Override
    protected T doSwitch ( final int classifierID, final EObject theEObject )
    {
        switch ( classifierID )
        {
            case ComponentPackage.COMPONENT_WORLD:
            {
                final ComponentWorld componentWorld = (ComponentWorld)theEObject;
                T result = caseComponentWorld ( componentWorld );
                if ( result == null )
                {
                    result = caseContainer ( componentWorld );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.LEVEL:
            {
                final Level level = (Level)theEObject;
                T result = caseLevel ( level );
                if ( result == null )
                {
                    result = caseContainer ( level );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.COMPONENT:
            {
                final Component component = (Component)theEObject;
                T result = caseComponent ( component );
                if ( result == null )
                {
                    result = caseDocumentable ( component );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.DATA_COMPONENT:
            {
                final DataComponent dataComponent = (DataComponent)theEObject;
                T result = caseDataComponent ( dataComponent );
                if ( result == null )
                {
                    result = caseComponent ( dataComponent );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( dataComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.CONFIGURATION:
            {
                final Configuration configuration = (Configuration)theEObject;
                T result = caseConfiguration ( configuration );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.CONSTANT_VALUE:
            {
                final ConstantValue constantValue = (ConstantValue)theEObject;
                T result = caseConstantValue ( constantValue );
                if ( result == null )
                {
                    result = caseSingleValue ( constantValue );
                }
                if ( result == null )
                {
                    result = caseMasterComponent ( constantValue );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( constantValue );
                }
                if ( result == null )
                {
                    result = caseComponent ( constantValue );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( constantValue );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.MARKER_CONFIGURATION:
            {
                final MarkerConfiguration markerConfiguration = (MarkerConfiguration)theEObject;
                T result = caseMarkerConfiguration ( markerConfiguration );
                if ( result == null )
                {
                    result = caseConfiguration ( markerConfiguration );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.SERVICE:
            {
                final Service service = (Service)theEObject;
                T result = caseService ( service );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.PERSISTENT_VALUE:
            {
                final PersistentValue persistentValue = (PersistentValue)theEObject;
                T result = casePersistentValue ( persistentValue );
                if ( result == null )
                {
                    result = caseSingleValue ( persistentValue );
                }
                if ( result == null )
                {
                    result = caseMasterComponent ( persistentValue );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( persistentValue );
                }
                if ( result == null )
                {
                    result = caseComponent ( persistentValue );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( persistentValue );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.DRIVER_CONNECTION_ANALYZER:
            {
                final DriverConnectionAnalyzer driverConnectionAnalyzer = (DriverConnectionAnalyzer)theEObject;
                T result = caseDriverConnectionAnalyzer ( driverConnectionAnalyzer );
                if ( result == null )
                {
                    result = caseMasterComponent ( driverConnectionAnalyzer );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( driverConnectionAnalyzer );
                }
                if ( result == null )
                {
                    result = caseComponent ( driverConnectionAnalyzer );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( driverConnectionAnalyzer );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.MASTER_IMPORT_CONNECTION_ANALYZER:
            {
                final MasterImportConnectionAnalyzer masterImportConnectionAnalyzer = (MasterImportConnectionAnalyzer)theEObject;
                T result = caseMasterImportConnectionAnalyzer ( masterImportConnectionAnalyzer );
                if ( result == null )
                {
                    result = caseMasterComponent ( masterImportConnectionAnalyzer );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( masterImportConnectionAnalyzer );
                }
                if ( result == null )
                {
                    result = caseComponent ( masterImportConnectionAnalyzer );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( masterImportConnectionAnalyzer );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.SINGLE_VALUE:
            {
                final SingleValue singleValue = (SingleValue)theEObject;
                T result = caseSingleValue ( singleValue );
                if ( result == null )
                {
                    result = caseMasterComponent ( singleValue );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( singleValue );
                }
                if ( result == null )
                {
                    result = caseComponent ( singleValue );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( singleValue );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.DATA_MAPPER_ANALYZER:
            {
                final DataMapperAnalyzer dataMapperAnalyzer = (DataMapperAnalyzer)theEObject;
                T result = caseDataMapperAnalyzer ( dataMapperAnalyzer );
                if ( result == null )
                {
                    result = caseMasterComponent ( dataMapperAnalyzer );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( dataMapperAnalyzer );
                }
                if ( result == null )
                {
                    result = caseComponent ( dataMapperAnalyzer );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( dataMapperAnalyzer );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.DATA_MAPPER_SERVICE:
            {
                final DataMapperService dataMapperService = (DataMapperService)theEObject;
                T result = caseDataMapperService ( dataMapperService );
                if ( result == null )
                {
                    result = caseService ( dataMapperService );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.MAPPED_SOURCE_VALUE:
            {
                final MappedSourceValue mappedSourceValue = (MappedSourceValue)theEObject;
                T result = caseMappedSourceValue ( mappedSourceValue );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( mappedSourceValue );
                }
                if ( result == null )
                {
                    result = caseMasterComponent ( mappedSourceValue );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( mappedSourceValue );
                }
                if ( result == null )
                {
                    result = caseComponent ( mappedSourceValue );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( mappedSourceValue );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.CALCULATION_COMPONENT:
            {
                final CalculationComponent calculationComponent = (CalculationComponent)theEObject;
                T result = caseCalculationComponent ( calculationComponent );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( calculationComponent );
                }
                if ( result == null )
                {
                    result = caseMasterComponent ( calculationComponent );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( calculationComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( calculationComponent );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( calculationComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.CALCULATION_MODULE:
            {
                final CalculationModule calculationModule = (CalculationModule)theEObject;
                T result = caseCalculationModule ( calculationModule );
                if ( result == null )
                {
                    result = caseService ( calculationModule );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.INPUT_SPECIFICATION:
            {
                final InputSpecification inputSpecification = (InputSpecification)theEObject;
                T result = caseInputSpecification ( inputSpecification );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.OUTPUT_SPECIFICATION:
            {
                final OutputSpecification outputSpecification = (OutputSpecification)theEObject;
                T result = caseOutputSpecification ( outputSpecification );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.OUTPUT_DEFINITION:
            {
                final OutputDefinition outputDefinition = (OutputDefinition)theEObject;
                T result = caseOutputDefinition ( outputDefinition );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.ITEM_REFERENCE_INPUT_DEFINITION:
            {
                final ItemReferenceInputDefinition itemReferenceInputDefinition = (ItemReferenceInputDefinition)theEObject;
                T result = caseItemReferenceInputDefinition ( itemReferenceInputDefinition );
                if ( result == null )
                {
                    result = caseInputDefinition ( itemReferenceInputDefinition );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.INPUT_DEFINITION:
            {
                final InputDefinition inputDefinition = (InputDefinition)theEObject;
                T result = caseInputDefinition ( inputDefinition );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.COMPONENT_REFERENCE_INPUT_DEFINITION:
            {
                final ComponentReferenceInputDefinition componentReferenceInputDefinition = (ComponentReferenceInputDefinition)theEObject;
                T result = caseComponentReferenceInputDefinition ( componentReferenceInputDefinition );
                if ( result == null )
                {
                    result = caseInputDefinition ( componentReferenceInputDefinition );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.FORMULA_MODULE:
            {
                final FormulaModule formulaModule = (FormulaModule)theEObject;
                T result = caseFormulaModule ( formulaModule );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( formulaModule );
                }
                if ( result == null )
                {
                    result = caseCalculationModule ( formulaModule );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( formulaModule );
                }
                if ( result == null )
                {
                    result = caseService ( formulaModule );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.AVERAGE_MODULE:
            {
                final AverageModule averageModule = (AverageModule)theEObject;
                T result = caseAverageModule ( averageModule );
                if ( result == null )
                {
                    result = caseCalculationModule ( averageModule );
                }
                if ( result == null )
                {
                    result = caseService ( averageModule );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.DANGLING_ITEM_REFERENCE:
            {
                final DanglingItemReference danglingItemReference = (DanglingItemReference)theEObject;
                T result = caseDanglingItemReference ( danglingItemReference );
                if ( result == null )
                {
                    result = caseItem ( danglingItemReference );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.SCRIPT_MODULE:
            {
                final ScriptModule scriptModule = (ScriptModule)theEObject;
                T result = caseScriptModule ( scriptModule );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( scriptModule );
                }
                if ( result == null )
                {
                    result = caseCalculationModule ( scriptModule );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( scriptModule );
                }
                if ( result == null )
                {
                    result = caseService ( scriptModule );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.SCRIPT:
            {
                final Script script = (Script)theEObject;
                T result = caseScript ( script );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.ABSOLUTE_DANGLING_REFERENCE:
            {
                final AbsoluteDanglingReference absoluteDanglingReference = (AbsoluteDanglingReference)theEObject;
                T result = caseAbsoluteDanglingReference ( absoluteDanglingReference );
                if ( result == null )
                {
                    result = caseDanglingItemReference ( absoluteDanglingReference );
                }
                if ( result == null )
                {
                    result = caseItem ( absoluteDanglingReference );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE:
            {
                final ComponentDanglingReference componentDanglingReference = (ComponentDanglingReference)theEObject;
                T result = caseComponentDanglingReference ( componentDanglingReference );
                if ( result == null )
                {
                    result = caseDanglingItemReference ( componentDanglingReference );
                }
                if ( result == null )
                {
                    result = caseItem ( componentDanglingReference );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.EXTERNAL_VALUE:
            {
                final ExternalValue externalValue = (ExternalValue)theEObject;
                T result = caseExternalValue ( externalValue );
                if ( result == null )
                {
                    result = caseSingleValue ( externalValue );
                }
                if ( result == null )
                {
                    result = caseMasterComponent ( externalValue );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( externalValue );
                }
                if ( result == null )
                {
                    result = caseComponent ( externalValue );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( externalValue );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.SUMMARIES_CONFIGURATION:
            {
                final SummariesConfiguration summariesConfiguration = (SummariesConfiguration)theEObject;
                T result = caseSummariesConfiguration ( summariesConfiguration );
                if ( result == null )
                {
                    result = caseConfiguration ( summariesConfiguration );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.ITEM_INTERCEPTOR:
            {
                final ItemInterceptor itemInterceptor = (ItemInterceptor)theEObject;
                T result = caseItemInterceptor ( itemInterceptor );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.CONTAINER:
            {
                final Container container = (Container)theEObject;
                T result = caseContainer ( container );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.REST_INTERCEPTOR:
            {
                final RestInterceptor restInterceptor = (RestInterceptor)theEObject;
                T result = caseRestInterceptor ( restInterceptor );
                if ( result == null )
                {
                    result = caseItemInterceptor ( restInterceptor );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.GLOBALIZE_COMPONENT:
            {
                final GlobalizeComponent globalizeComponent = (GlobalizeComponent)theEObject;
                T result = caseGlobalizeComponent ( globalizeComponent );
                if ( result == null )
                {
                    result = caseDataComponent ( globalizeComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( globalizeComponent );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( globalizeComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.TRANSIENT_VALUE:
            {
                final TransientValue transientValue = (TransientValue)theEObject;
                T result = caseTransientValue ( transientValue );
                if ( result == null )
                {
                    result = caseSingleValue ( transientValue );
                }
                if ( result == null )
                {
                    result = caseMasterComponent ( transientValue );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( transientValue );
                }
                if ( result == null )
                {
                    result = caseComponent ( transientValue );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( transientValue );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.MASTER_COMPONENT:
            {
                final MasterComponent masterComponent = (MasterComponent)theEObject;
                T result = caseMasterComponent ( masterComponent );
                if ( result == null )
                {
                    result = caseDataComponent ( masterComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( masterComponent );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( masterComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.BUFFERED_VALUE:
            {
                final BufferedValue bufferedValue = (BufferedValue)theEObject;
                T result = caseBufferedValue ( bufferedValue );
                if ( result == null )
                {
                    result = caseMasterComponent ( bufferedValue );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( bufferedValue );
                }
                if ( result == null )
                {
                    result = caseComponent ( bufferedValue );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( bufferedValue );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ComponentPackage.CHANGE_COUNTER:
            {
                final ChangeCounter changeCounter = (ChangeCounter)theEObject;
                T result = caseChangeCounter ( changeCounter );
                if ( result == null )
                {
                    result = caseSingleValue ( changeCounter );
                }
                if ( result == null )
                {
                    result = caseMasterComponent ( changeCounter );
                }
                if ( result == null )
                {
                    result = caseDataComponent ( changeCounter );
                }
                if ( result == null )
                {
                    result = caseComponent ( changeCounter );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( changeCounter );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>World</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>World</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponentWorld ( final ComponentWorld object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Level</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Level</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLevel ( final Level object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponent ( final Component object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Data Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Data Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataComponent ( final DataComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConfiguration ( final Configuration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Constant Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Constant Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConstantValue ( final ConstantValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Marker Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Marker Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMarkerConfiguration ( final MarkerConfiguration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Service</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseService ( final Service object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Persistent Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Persistent Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePersistentValue ( final PersistentValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Driver Connection Analyzer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Driver Connection Analyzer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDriverConnectionAnalyzer ( final DriverConnectionAnalyzer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Master Import Connection Analyzer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Master Import Connection Analyzer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMasterImportConnectionAnalyzer ( final MasterImportConnectionAnalyzer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Single Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Single Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSingleValue ( final SingleValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Data Mapper Analyzer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Data Mapper Analyzer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataMapperAnalyzer ( final DataMapperAnalyzer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Data Mapper Service</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Data Mapper Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataMapperService ( final DataMapperService object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Mapped Source Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Mapped Source Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMappedSourceValue ( final MappedSourceValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Calculation Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Calculation Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCalculationComponent ( final CalculationComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Calculation Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Calculation Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCalculationModule ( final CalculationModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Input Specification</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Input Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInputSpecification ( final InputSpecification object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Output Specification</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Output Specification</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOutputSpecification ( final OutputSpecification object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Output Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Output Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOutputDefinition ( final OutputDefinition object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Item Reference Input Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Item Reference Input Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemReferenceInputDefinition ( final ItemReferenceInputDefinition object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Input Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Input Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInputDefinition ( final InputDefinition object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Reference Input Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Reference Input Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponentReferenceInputDefinition ( final ComponentReferenceInputDefinition object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Formula Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Formula Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFormulaModule ( final FormulaModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Average Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Average Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAverageModule ( final AverageModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Dangling Item Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Dangling Item Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDanglingItemReference ( final DanglingItemReference object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Script Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Script Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptModule ( final ScriptModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Script</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Script</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScript ( final Script object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Absolute Dangling Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Absolute Dangling Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbsoluteDanglingReference ( final AbsoluteDanglingReference object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Dangling Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Dangling Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponentDanglingReference ( final ComponentDanglingReference object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>External Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>External Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalValue ( final ExternalValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Summaries Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Summaries Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSummariesConfiguration ( final SummariesConfiguration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Item Interceptor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Item Interceptor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemInterceptor ( final ItemInterceptor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseContainer ( final Container object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Rest Interceptor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Rest Interceptor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRestInterceptor ( final RestInterceptor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Globalize Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Globalize Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGlobalizeComponent ( final GlobalizeComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Transient Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Transient Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTransientValue ( final TransientValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Master Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Master Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMasterComponent ( final MasterComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Buffered Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Buffered Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBufferedValue ( final BufferedValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Change Counter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Change Counter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChangeCounter ( final ChangeCounter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentable ( final Documentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Named Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Named Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedDocumentable ( final NamedDocumentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItem ( final Item object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( final EObject object )
    {
        return null;
    }

} //ComponentSwitch
