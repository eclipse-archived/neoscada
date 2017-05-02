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
package org.eclipse.scada.configuration.item.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.item.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ItemFactoryImpl extends EFactoryImpl implements ItemFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ItemFactory init ()
    {
        try
        {
            ItemFactory theItemFactory = (ItemFactory)EPackage.Registry.INSTANCE.getEFactory ( ItemPackage.eNS_URI );
            if ( theItemFactory != null )
            {
                return theItemFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ItemFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemFactoryImpl ()
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
            case ItemPackage.COMPOSITE_PIPELINE:
                return createCompositePipeline ();
            case ItemPackage.CALL:
                return createCall ();
            case ItemPackage.CALL_SUPER:
                return createCallSuper ();
            case ItemPackage.JAVA_SCRIPT_CUSTOMIZATION_PIPELINE:
                return createJavaScriptCustomizationPipeline ();
            case ItemPackage.CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE:
                return createCustomScriptCustomizationPipeline ();
            case ItemPackage.JAVA_SCRIPT_SELECTOR:
                return createJavaScriptSelector ();
            case ItemPackage.CUSTOM_SCRIPT_SELECTOR:
                return createCustomScriptSelector ();
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
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositePipeline createCompositePipeline ()
    {
        CompositePipelineImpl compositePipeline = new CompositePipelineImpl ();
        return compositePipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Call createCall ()
    {
        CallImpl call = new CallImpl ();
        return call;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CallSuper createCallSuper ()
    {
        CallSuperImpl callSuper = new CallSuperImpl ();
        return callSuper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaScriptCustomizationPipeline createJavaScriptCustomizationPipeline ()
    {
        JavaScriptCustomizationPipelineImpl javaScriptCustomizationPipeline = new JavaScriptCustomizationPipelineImpl ();
        return javaScriptCustomizationPipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomScriptCustomizationPipeline createCustomScriptCustomizationPipeline ()
    {
        CustomScriptCustomizationPipelineImpl customScriptCustomizationPipeline = new CustomScriptCustomizationPipelineImpl ();
        return customScriptCustomizationPipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaScriptSelector createJavaScriptSelector ()
    {
        JavaScriptSelectorImpl javaScriptSelector = new JavaScriptSelectorImpl ();
        return javaScriptSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomScriptSelector createCustomScriptSelector ()
    {
        CustomScriptSelectorImpl customScriptSelector = new CustomScriptSelectorImpl ();
        return customScriptSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemPackage getItemPackage ()
    {
        return (ItemPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ItemPackage getPackage ()
    {
        return ItemPackage.eINSTANCE;
    }

} //ItemFactoryImpl
