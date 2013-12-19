/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.recipe.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.scada.configuration.recipe.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecipeFactoryImpl extends EFactoryImpl implements RecipeFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static RecipeFactory init ()
    {
        try
        {
            RecipeFactory theRecipeFactory = (RecipeFactory)EPackage.Registry.INSTANCE.getEFactory ( RecipePackage.eNS_URI );
            if ( theRecipeFactory != null )
            {
                return theRecipeFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new RecipeFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RecipeFactoryImpl ()
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
            case RecipePackage.DEFINITION:
                return createDefinition ();
            case RecipePackage.TASK:
                return createTask ();
            case RecipePackage.EXECUTE:
                return createExecute ();
            case RecipePackage.MAP_INPUT:
                return createMapInput ();
            case RecipePackage.STRING_INPUT_VALUE:
                return createStringInputValue ();
            case RecipePackage.CAPTURE_OUTPUT:
                return createCaptureOutput ();
            case RecipePackage.INPUT_REFERENCE:
                return createInputReference ();
            case RecipePackage.PROPERTY_ENTRY:
                return createPropertyEntry ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Definition createDefinition ()
    {
        DefinitionImpl definition = new DefinitionImpl ();
        return definition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Task createTask ()
    {
        TaskImpl task = new TaskImpl ();
        return task;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Execute createExecute ()
    {
        ExecuteImpl execute = new ExecuteImpl ();
        return execute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MapInput createMapInput ()
    {
        MapInputImpl mapInput = new MapInputImpl ();
        return mapInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StringInputValue createStringInputValue ()
    {
        StringInputValueImpl stringInputValue = new StringInputValueImpl ();
        return stringInputValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CaptureOutput createCaptureOutput ()
    {
        CaptureOutputImpl captureOutput = new CaptureOutputImpl ();
        return captureOutput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputReference createInputReference ()
    {
        InputReferenceImpl inputReference = new InputReferenceImpl ();
        return inputReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PropertyEntry createPropertyEntry ()
    {
        PropertyEntryImpl propertyEntry = new PropertyEntryImpl ();
        return propertyEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RecipePackage getRecipePackage ()
    {
        return (RecipePackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static RecipePackage getPackage ()
    {
        return RecipePackage.eINSTANCE;
    }

} //RecipeFactoryImpl
