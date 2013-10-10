/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.da.exec.configuration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage
 * @generated
 */
public class ConfigurationSwitch<T> extends Switch<T>
{
    //$NON-NLS-1$

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ConfigurationPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ConfigurationPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch ( int classifierID, EObject theEObject )
    {
        switch ( classifierID )
        {
            case ConfigurationPackage.COMMAND_TYPE:
            {
                CommandType commandType = (CommandType)theEObject;
                T result = caseCommandType ( commandType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.CONTINUOUS_COMMAND_TYPE:
            {
                ContinuousCommandType continuousCommandType = (ContinuousCommandType)theEObject;
                T result = caseContinuousCommandType ( continuousCommandType );
                if ( result == null )
                    result = caseCommandType ( continuousCommandType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE:
            {
                CustomExtractorType customExtractorType = (CustomExtractorType)theEObject;
                T result = caseCustomExtractorType ( customExtractorType );
                if ( result == null )
                    result = caseExtractorType ( customExtractorType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.DOCUMENT_ROOT:
            {
                DocumentRoot documentRoot = (DocumentRoot)theEObject;
                T result = caseDocumentRoot ( documentRoot );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.ENV_ENTRY_TYPE:
            {
                EnvEntryType envEntryType = (EnvEntryType)theEObject;
                T result = caseEnvEntryType ( envEntryType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.EXTRACTOR_TYPE:
            {
                ExtractorType extractorType = (ExtractorType)theEObject;
                T result = caseExtractorType ( extractorType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.FIELD_EXTRACTOR_TYPE:
            {
                FieldExtractorType fieldExtractorType = (FieldExtractorType)theEObject;
                T result = caseFieldExtractorType ( fieldExtractorType );
                if ( result == null )
                    result = caseExtractorType ( fieldExtractorType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.FIELD_TYPE:
            {
                FieldType fieldType = (FieldType)theEObject;
                T result = caseFieldType ( fieldType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.HIVE_PROCESS_COMMAND_TYPE:
            {
                HiveProcessCommandType hiveProcessCommandType = (HiveProcessCommandType)theEObject;
                T result = caseHiveProcessCommandType ( hiveProcessCommandType );
                if ( result == null )
                    result = caseContinuousCommandType ( hiveProcessCommandType );
                if ( result == null )
                    result = caseCommandType ( hiveProcessCommandType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.NAGIOS_RETURN_CODE_EXTRACTOR_TYPE:
            {
                NagiosReturnCodeExtractorType nagiosReturnCodeExtractorType = (NagiosReturnCodeExtractorType)theEObject;
                T result = caseNagiosReturnCodeExtractorType ( nagiosReturnCodeExtractorType );
                if ( result == null )
                    result = caseExtractorType ( nagiosReturnCodeExtractorType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.PLAIN_STREAM_EXTRACTOR_TYPE:
            {
                PlainStreamExtractorType plainStreamExtractorType = (PlainStreamExtractorType)theEObject;
                T result = casePlainStreamExtractorType ( plainStreamExtractorType );
                if ( result == null )
                    result = caseExtractorType ( plainStreamExtractorType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.PROCESS_TYPE:
            {
                ProcessType processType = (ProcessType)theEObject;
                T result = caseProcessType ( processType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.QUEUE_TYPE:
            {
                QueueType queueType = (QueueType)theEObject;
                T result = caseQueueType ( queueType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE:
            {
                RegExExtractorType regExExtractorType = (RegExExtractorType)theEObject;
                T result = caseRegExExtractorType ( regExExtractorType );
                if ( result == null )
                    result = caseFieldExtractorType ( regExExtractorType );
                if ( result == null )
                    result = caseExtractorType ( regExExtractorType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.RETURN_CODE_EXTRACTOR_TYPE:
            {
                ReturnCodeExtractorType returnCodeExtractorType = (ReturnCodeExtractorType)theEObject;
                T result = caseReturnCodeExtractorType ( returnCodeExtractorType );
                if ( result == null )
                    result = caseExtractorType ( returnCodeExtractorType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.ROOT_TYPE:
            {
                RootType rootType = (RootType)theEObject;
                T result = caseRootType ( rootType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.SIMPLE_EXTRACTOR_TYPE:
            {
                SimpleExtractorType simpleExtractorType = (SimpleExtractorType)theEObject;
                T result = caseSimpleExtractorType ( simpleExtractorType );
                if ( result == null )
                    result = caseExtractorType ( simpleExtractorType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.SINGLE_COMMAND_TYPE:
            {
                SingleCommandType singleCommandType = (SingleCommandType)theEObject;
                T result = caseSingleCommandType ( singleCommandType );
                if ( result == null )
                    result = caseCommandType ( singleCommandType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.SPLIT_CONTINUOUS_COMMAND_TYPE:
            {
                SplitContinuousCommandType splitContinuousCommandType = (SplitContinuousCommandType)theEObject;
                T result = caseSplitContinuousCommandType ( splitContinuousCommandType );
                if ( result == null )
                    result = caseContinuousCommandType ( splitContinuousCommandType );
                if ( result == null )
                    result = caseCommandType ( splitContinuousCommandType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.SPLITTER_EXTRACTOR_TYPE:
            {
                SplitterExtractorType splitterExtractorType = (SplitterExtractorType)theEObject;
                T result = caseSplitterExtractorType ( splitterExtractorType );
                if ( result == null )
                    result = caseFieldExtractorType ( splitterExtractorType );
                if ( result == null )
                    result = caseExtractorType ( splitterExtractorType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.SPLITTER_TYPE:
            {
                SplitterType splitterType = (SplitterType)theEObject;
                T result = caseSplitterType ( splitterType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.TRIGGER_COMMAND_TYPE:
            {
                TriggerCommandType triggerCommandType = (TriggerCommandType)theEObject;
                T result = caseTriggerCommandType ( triggerCommandType );
                if ( result == null )
                    result = caseCommandType ( triggerCommandType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Command Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Command Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCommandType ( CommandType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Continuous Command Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Continuous Command Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseContinuousCommandType ( ContinuousCommandType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Custom Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Custom Extractor Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCustomExtractorType ( CustomExtractorType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentRoot ( DocumentRoot object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Env Entry Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Env Entry Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEnvEntryType ( EnvEntryType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Extractor Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExtractorType ( ExtractorType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Field Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Field Extractor Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFieldExtractorType ( FieldExtractorType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Field Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Field Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFieldType ( FieldType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Hive Process Command Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Hive Process Command Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHiveProcessCommandType ( HiveProcessCommandType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Nagios Return Code Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Nagios Return Code Extractor Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNagiosReturnCodeExtractorType ( NagiosReturnCodeExtractorType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Plain Stream Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Plain Stream Extractor Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePlainStreamExtractorType ( PlainStreamExtractorType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Process Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Process Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProcessType ( ProcessType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Queue Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Queue Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQueueType ( QueueType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Reg Ex Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Reg Ex Extractor Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRegExExtractorType ( RegExExtractorType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Return Code Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Return Code Extractor Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReturnCodeExtractorType ( ReturnCodeExtractorType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Root Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Root Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRootType ( RootType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simple Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Extractor Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimpleExtractorType ( SimpleExtractorType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Single Command Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Single Command Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSingleCommandType ( SingleCommandType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Split Continuous Command Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Split Continuous Command Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSplitContinuousCommandType ( SplitContinuousCommandType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Splitter Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Splitter Extractor Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSplitterExtractorType ( SplitterExtractorType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Splitter Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Splitter Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSplitterType ( SplitterType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Trigger Command Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Trigger Command Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTriggerCommandType ( TriggerCommandType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( EObject object )
    {
        return null;
    }

} //ConfigurationSwitch
