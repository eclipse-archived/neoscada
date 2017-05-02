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
package org.eclipse.scada.configuration.item.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.item.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.item.ItemPackage
 * @generated
 */
public class ItemAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ItemPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ItemPackage.eINSTANCE;
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
    protected ItemSwitch<Adapter> modelSwitch = new ItemSwitch<Adapter> ()
    {
        @Override
        public Adapter caseCustomizationPipeline ( CustomizationPipeline object )
        {
            return createCustomizationPipelineAdapter ();
        }

        @Override
        public Adapter caseScriptCustomizationPipeline ( ScriptCustomizationPipeline object )
        {
            return createScriptCustomizationPipelineAdapter ();
        }

        @Override
        public Adapter caseCompositePipeline ( CompositePipeline object )
        {
            return createCompositePipelineAdapter ();
        }

        @Override
        public Adapter caseCall ( Call object )
        {
            return createCallAdapter ();
        }

        @Override
        public Adapter caseStep ( Step object )
        {
            return createStepAdapter ();
        }

        @Override
        public Adapter caseCallSuper ( CallSuper object )
        {
            return createCallSuperAdapter ();
        }

        @Override
        public Adapter caseSelector ( Selector object )
        {
            return createSelectorAdapter ();
        }

        @Override
        public Adapter caseScriptSelector ( ScriptSelector object )
        {
            return createScriptSelectorAdapter ();
        }

        @Override
        public Adapter caseJavaScriptCustomizationPipeline ( JavaScriptCustomizationPipeline object )
        {
            return createJavaScriptCustomizationPipelineAdapter ();
        }

        @Override
        public Adapter caseCustomScriptCustomizationPipeline ( CustomScriptCustomizationPipeline object )
        {
            return createCustomScriptCustomizationPipelineAdapter ();
        }

        @Override
        public Adapter caseJavaScriptSelector ( JavaScriptSelector object )
        {
            return createJavaScriptSelectorAdapter ();
        }

        @Override
        public Adapter caseCustomScriptSelector ( CustomScriptSelector object )
        {
            return createCustomScriptSelectorAdapter ();
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
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.CustomizationPipeline <em>Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.CustomizationPipeline
     * @generated
     */
    public Adapter createCustomizationPipelineAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.ScriptCustomizationPipeline <em>Script Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.ScriptCustomizationPipeline
     * @generated
     */
    public Adapter createScriptCustomizationPipelineAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.CompositePipeline <em>Composite Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.CompositePipeline
     * @generated
     */
    public Adapter createCompositePipelineAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.Call <em>Call</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.Call
     * @generated
     */
    public Adapter createCallAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.Step <em>Step</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.Step
     * @generated
     */
    public Adapter createStepAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.CallSuper <em>Call Super</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.CallSuper
     * @generated
     */
    public Adapter createCallSuperAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.Selector <em>Selector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.Selector
     * @generated
     */
    public Adapter createSelectorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.ScriptSelector <em>Script Selector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.ScriptSelector
     * @generated
     */
    public Adapter createScriptSelectorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.JavaScriptCustomizationPipeline <em>Java Script Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.JavaScriptCustomizationPipeline
     * @generated
     */
    public Adapter createJavaScriptCustomizationPipelineAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.CustomScriptCustomizationPipeline <em>Custom Script Customization Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.CustomScriptCustomizationPipeline
     * @generated
     */
    public Adapter createCustomScriptCustomizationPipelineAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.JavaScriptSelector <em>Java Script Selector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.JavaScriptSelector
     * @generated
     */
    public Adapter createJavaScriptSelectorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.item.CustomScriptSelector <em>Custom Script Selector</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.item.CustomScriptSelector
     * @generated
     */
    public Adapter createCustomScriptSelectorAdapter ()
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

} //ItemAdapterFactory
