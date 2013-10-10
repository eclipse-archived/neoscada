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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.da.exec.configuration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage
 * @generated
 */
public class ConfigurationAdapterFactory extends AdapterFactoryImpl
{
    //$NON-NLS-1$

    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ConfigurationPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ConfigurationPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
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
     * @generated
     */
    protected ConfigurationSwitch<Adapter> modelSwitch = new ConfigurationSwitch<Adapter> () {
        @Override
        public Adapter caseCommandType ( CommandType object )
        {
            return createCommandTypeAdapter ();
        }

        @Override
        public Adapter caseContinuousCommandType ( ContinuousCommandType object )
        {
            return createContinuousCommandTypeAdapter ();
        }

        @Override
        public Adapter caseCustomExtractorType ( CustomExtractorType object )
        {
            return createCustomExtractorTypeAdapter ();
        }

        @Override
        public Adapter caseDocumentRoot ( DocumentRoot object )
        {
            return createDocumentRootAdapter ();
        }

        @Override
        public Adapter caseEnvEntryType ( EnvEntryType object )
        {
            return createEnvEntryTypeAdapter ();
        }

        @Override
        public Adapter caseExtractorType ( ExtractorType object )
        {
            return createExtractorTypeAdapter ();
        }

        @Override
        public Adapter caseFieldExtractorType ( FieldExtractorType object )
        {
            return createFieldExtractorTypeAdapter ();
        }

        @Override
        public Adapter caseFieldType ( FieldType object )
        {
            return createFieldTypeAdapter ();
        }

        @Override
        public Adapter caseHiveProcessCommandType ( HiveProcessCommandType object )
        {
            return createHiveProcessCommandTypeAdapter ();
        }

        @Override
        public Adapter caseNagiosReturnCodeExtractorType ( NagiosReturnCodeExtractorType object )
        {
            return createNagiosReturnCodeExtractorTypeAdapter ();
        }

        @Override
        public Adapter casePlainStreamExtractorType ( PlainStreamExtractorType object )
        {
            return createPlainStreamExtractorTypeAdapter ();
        }

        @Override
        public Adapter caseProcessType ( ProcessType object )
        {
            return createProcessTypeAdapter ();
        }

        @Override
        public Adapter caseQueueType ( QueueType object )
        {
            return createQueueTypeAdapter ();
        }

        @Override
        public Adapter caseRegExExtractorType ( RegExExtractorType object )
        {
            return createRegExExtractorTypeAdapter ();
        }

        @Override
        public Adapter caseReturnCodeExtractorType ( ReturnCodeExtractorType object )
        {
            return createReturnCodeExtractorTypeAdapter ();
        }

        @Override
        public Adapter caseRootType ( RootType object )
        {
            return createRootTypeAdapter ();
        }

        @Override
        public Adapter caseSimpleExtractorType ( SimpleExtractorType object )
        {
            return createSimpleExtractorTypeAdapter ();
        }

        @Override
        public Adapter caseSingleCommandType ( SingleCommandType object )
        {
            return createSingleCommandTypeAdapter ();
        }

        @Override
        public Adapter caseSplitContinuousCommandType ( SplitContinuousCommandType object )
        {
            return createSplitContinuousCommandTypeAdapter ();
        }

        @Override
        public Adapter caseSplitterExtractorType ( SplitterExtractorType object )
        {
            return createSplitterExtractorTypeAdapter ();
        }

        @Override
        public Adapter caseSplitterType ( SplitterType object )
        {
            return createSplitterTypeAdapter ();
        }

        @Override
        public Adapter caseTriggerCommandType ( TriggerCommandType object )
        {
            return createTriggerCommandTypeAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.CommandType <em>Command Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.CommandType
     * @generated
     */
    public Adapter createCommandTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.ContinuousCommandType <em>Continuous Command Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.ContinuousCommandType
     * @generated
     */
    public Adapter createContinuousCommandTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.CustomExtractorType <em>Custom Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.CustomExtractorType
     * @generated
     */
    public Adapter createCustomExtractorTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.DocumentRoot
     * @generated
     */
    public Adapter createDocumentRootAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.EnvEntryType <em>Env Entry Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.EnvEntryType
     * @generated
     */
    public Adapter createEnvEntryTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.ExtractorType <em>Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.ExtractorType
     * @generated
     */
    public Adapter createExtractorTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.FieldExtractorType <em>Field Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.FieldExtractorType
     * @generated
     */
    public Adapter createFieldExtractorTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.FieldType <em>Field Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.FieldType
     * @generated
     */
    public Adapter createFieldTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.HiveProcessCommandType <em>Hive Process Command Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.HiveProcessCommandType
     * @generated
     */
    public Adapter createHiveProcessCommandTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.NagiosReturnCodeExtractorType <em>Nagios Return Code Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.NagiosReturnCodeExtractorType
     * @generated
     */
    public Adapter createNagiosReturnCodeExtractorTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.PlainStreamExtractorType <em>Plain Stream Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.PlainStreamExtractorType
     * @generated
     */
    public Adapter createPlainStreamExtractorTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.ProcessType <em>Process Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.ProcessType
     * @generated
     */
    public Adapter createProcessTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.QueueType <em>Queue Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.QueueType
     * @generated
     */
    public Adapter createQueueTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.RegExExtractorType <em>Reg Ex Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.RegExExtractorType
     * @generated
     */
    public Adapter createRegExExtractorTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.ReturnCodeExtractorType <em>Return Code Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.ReturnCodeExtractorType
     * @generated
     */
    public Adapter createReturnCodeExtractorTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.RootType <em>Root Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.RootType
     * @generated
     */
    public Adapter createRootTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.SimpleExtractorType <em>Simple Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.SimpleExtractorType
     * @generated
     */
    public Adapter createSimpleExtractorTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.SingleCommandType <em>Single Command Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.SingleCommandType
     * @generated
     */
    public Adapter createSingleCommandTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType <em>Split Continuous Command Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType
     * @generated
     */
    public Adapter createSplitContinuousCommandTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.SplitterExtractorType <em>Splitter Extractor Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.SplitterExtractorType
     * @generated
     */
    public Adapter createSplitterExtractorTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.SplitterType <em>Splitter Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.SplitterType
     * @generated
     */
    public Adapter createSplitterTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.exec.configuration.TriggerCommandType <em>Trigger Command Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.exec.configuration.TriggerCommandType
     * @generated
     */
    public Adapter createTriggerCommandTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //ConfigurationAdapterFactory
