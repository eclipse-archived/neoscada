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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.item.*;

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
 * @see org.eclipse.scada.configuration.item.ItemPackage
 * @generated
 */
public class ItemSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ItemPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ItemPackage.eINSTANCE;
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
            case ItemPackage.CUSTOMIZATION_PIPELINE:
            {
                CustomizationPipeline customizationPipeline = (CustomizationPipeline)theEObject;
                T result = caseCustomizationPipeline ( customizationPipeline );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.SCRIPT_CUSTOMIZATION_PIPELINE:
            {
                ScriptCustomizationPipeline scriptCustomizationPipeline = (ScriptCustomizationPipeline)theEObject;
                T result = caseScriptCustomizationPipeline ( scriptCustomizationPipeline );
                if ( result == null )
                    result = caseCustomizationPipeline ( scriptCustomizationPipeline );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.COMPOSITE_PIPELINE:
            {
                CompositePipeline compositePipeline = (CompositePipeline)theEObject;
                T result = caseCompositePipeline ( compositePipeline );
                if ( result == null )
                    result = caseCustomizationPipeline ( compositePipeline );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.CALL:
            {
                Call call = (Call)theEObject;
                T result = caseCall ( call );
                if ( result == null )
                    result = caseStep ( call );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.STEP:
            {
                Step step = (Step)theEObject;
                T result = caseStep ( step );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.CALL_SUPER:
            {
                CallSuper callSuper = (CallSuper)theEObject;
                T result = caseCallSuper ( callSuper );
                if ( result == null )
                    result = caseStep ( callSuper );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.SELECTOR:
            {
                Selector selector = (Selector)theEObject;
                T result = caseSelector ( selector );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.SCRIPT_SELECTOR:
            {
                ScriptSelector scriptSelector = (ScriptSelector)theEObject;
                T result = caseScriptSelector ( scriptSelector );
                if ( result == null )
                    result = caseSelector ( scriptSelector );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.JAVA_SCRIPT_CUSTOMIZATION_PIPELINE:
            {
                JavaScriptCustomizationPipeline javaScriptCustomizationPipeline = (JavaScriptCustomizationPipeline)theEObject;
                T result = caseJavaScriptCustomizationPipeline ( javaScriptCustomizationPipeline );
                if ( result == null )
                    result = caseScriptCustomizationPipeline ( javaScriptCustomizationPipeline );
                if ( result == null )
                    result = caseCustomizationPipeline ( javaScriptCustomizationPipeline );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE:
            {
                CustomScriptCustomizationPipeline customScriptCustomizationPipeline = (CustomScriptCustomizationPipeline)theEObject;
                T result = caseCustomScriptCustomizationPipeline ( customScriptCustomizationPipeline );
                if ( result == null )
                    result = caseScriptCustomizationPipeline ( customScriptCustomizationPipeline );
                if ( result == null )
                    result = caseCustomizationPipeline ( customScriptCustomizationPipeline );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.JAVA_SCRIPT_SELECTOR:
            {
                JavaScriptSelector javaScriptSelector = (JavaScriptSelector)theEObject;
                T result = caseJavaScriptSelector ( javaScriptSelector );
                if ( result == null )
                    result = caseScriptSelector ( javaScriptSelector );
                if ( result == null )
                    result = caseSelector ( javaScriptSelector );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ItemPackage.CUSTOM_SCRIPT_SELECTOR:
            {
                CustomScriptSelector customScriptSelector = (CustomScriptSelector)theEObject;
                T result = caseCustomScriptSelector ( customScriptSelector );
                if ( result == null )
                    result = caseScriptSelector ( customScriptSelector );
                if ( result == null )
                    result = caseSelector ( customScriptSelector );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Customization Pipeline</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Customization Pipeline</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCustomizationPipeline ( CustomizationPipeline object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Script Customization Pipeline</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Script Customization Pipeline</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptCustomizationPipeline ( ScriptCustomizationPipeline object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Composite Pipeline</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Composite Pipeline</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompositePipeline ( CompositePipeline object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCall ( Call object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Step</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Step</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStep ( Step object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call Super</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Super</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCallSuper ( CallSuper object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Selector</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Selector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSelector ( Selector object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Script Selector</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Script Selector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptSelector ( ScriptSelector object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Java Script Customization Pipeline</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Java Script Customization Pipeline</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJavaScriptCustomizationPipeline ( JavaScriptCustomizationPipeline object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Custom Script Customization Pipeline</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Custom Script Customization Pipeline</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCustomScriptCustomizationPipeline ( CustomScriptCustomizationPipeline object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Java Script Selector</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Java Script Selector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJavaScriptSelector ( JavaScriptSelector object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Custom Script Selector</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Custom Script Selector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCustomScriptSelector ( CustomScriptSelector object )
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

} //ItemSwitch
