/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.vi.details.model.*;

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
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage
 * @generated
 */
public class DetailViewSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static DetailViewPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DetailViewSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = DetailViewPackage.eINSTANCE;
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
            case DetailViewPackage.VIEW:
            {
                View view = (View)theEObject;
                T result = caseView ( view );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.COMPONENT:
            {
                Component component = (Component)theEObject;
                T result = caseComponent ( component );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.GROUP_ENTRY:
            {
                GroupEntry groupEntry = (GroupEntry)theEObject;
                T result = caseGroupEntry ( groupEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.LABEL_COMPONENT:
            {
                LabelComponent labelComponent = (LabelComponent)theEObject;
                T result = caseLabelComponent ( labelComponent );
                if ( result == null )
                    result = caseComponent ( labelComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.COMPOSITE_COMPONENT:
            {
                CompositeComponent compositeComponent = (CompositeComponent)theEObject;
                T result = caseCompositeComponent ( compositeComponent );
                if ( result == null )
                    result = caseComponent ( compositeComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.FILL_LAYOUT_COMPONENT:
            {
                FillLayoutComponent fillLayoutComponent = (FillLayoutComponent)theEObject;
                T result = caseFillLayoutComponent ( fillLayoutComponent );
                if ( result == null )
                    result = caseCompositeComponent ( fillLayoutComponent );
                if ( result == null )
                    result = caseComponent ( fillLayoutComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.BUTTON_COMPONENT:
            {
                ButtonComponent buttonComponent = (ButtonComponent)theEObject;
                T result = caseButtonComponent ( buttonComponent );
                if ( result == null )
                    result = caseGenericComponent ( buttonComponent );
                if ( result == null )
                    result = caseComponent ( buttonComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.BOOL_LED_COMPONENT:
            {
                BoolLEDComponent boolLEDComponent = (BoolLEDComponent)theEObject;
                T result = caseBoolLEDComponent ( boolLEDComponent );
                if ( result == null )
                    result = caseComponent ( boolLEDComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.VALUE_SOURCE:
            {
                ValueSource valueSource = (ValueSource)theEObject;
                T result = caseValueSource ( valueSource );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.ITEM_VALUE_SOURCE:
            {
                ItemValueSource itemValueSource = (ItemValueSource)theEObject;
                T result = caseItemValueSource ( itemValueSource );
                if ( result == null )
                    result = caseValueSource ( itemValueSource );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.NOT_TRANSFORMER:
            {
                NotTransformer notTransformer = (NotTransformer)theEObject;
                T result = caseNotTransformer ( notTransformer );
                if ( result == null )
                    result = caseValueSource ( notTransformer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.GENERIC_COMPONENT:
            {
                GenericComponent genericComponent = (GenericComponent)theEObject;
                T result = caseGenericComponent ( genericComponent );
                if ( result == null )
                    result = caseComponent ( genericComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.REGISTRATION:
            {
                Registration registration = (Registration)theEObject;
                T result = caseRegistration ( registration );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.SIMPLE_GRID_COMPONENT:
            {
                SimpleGridComponent simpleGridComponent = (SimpleGridComponent)theEObject;
                T result = caseSimpleGridComponent ( simpleGridComponent );
                if ( result == null )
                    result = caseCompositeComponent ( simpleGridComponent );
                if ( result == null )
                    result = caseComponent ( simpleGridComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.GROUP_GRID_COMPONENT:
            {
                GroupGridComponent groupGridComponent = (GroupGridComponent)theEObject;
                T result = caseGroupGridComponent ( groupGridComponent );
                if ( result == null )
                    result = caseComponent ( groupGridComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.GROUP_GRID_ENTRY:
            {
                GroupGridEntry groupGridEntry = (GroupGridEntry)theEObject;
                T result = caseGroupGridEntry ( groupGridEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.VALUE_SET_COMPONENT:
            {
                ValueSetComponent valueSetComponent = (ValueSetComponent)theEObject;
                T result = caseValueSetComponent ( valueSetComponent );
                if ( result == null )
                    result = caseWriteableComponent ( valueSetComponent );
                if ( result == null )
                    result = caseReadableComponent ( valueSetComponent );
                if ( result == null )
                    result = caseComponent ( valueSetComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.VALUE_COMPONENT:
            {
                ValueComponent valueComponent = (ValueComponent)theEObject;
                T result = caseValueComponent ( valueComponent );
                if ( result == null )
                    result = caseReadableComponent ( valueComponent );
                if ( result == null )
                    result = caseComponent ( valueComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.COMPOSITE_TRANSFORMER:
            {
                CompositeTransformer compositeTransformer = (CompositeTransformer)theEObject;
                T result = caseCompositeTransformer ( compositeTransformer );
                if ( result == null )
                    result = caseValueSource ( compositeTransformer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.AND_TRANSFORMER:
            {
                AndTransformer andTransformer = (AndTransformer)theEObject;
                T result = caseAndTransformer ( andTransformer );
                if ( result == null )
                    result = caseCompositeTransformer ( andTransformer );
                if ( result == null )
                    result = caseValueSource ( andTransformer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.OR_TRANSFORMER:
            {
                OrTransformer orTransformer = (OrTransformer)theEObject;
                T result = caseOrTransformer ( orTransformer );
                if ( result == null )
                    result = caseCompositeTransformer ( orTransformer );
                if ( result == null )
                    result = caseValueSource ( orTransformer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.TEXT_INPUT_COMPONENT:
            {
                TextInputComponent textInputComponent = (TextInputComponent)theEObject;
                T result = caseTextInputComponent ( textInputComponent );
                if ( result == null )
                    result = caseWriteableComponent ( textInputComponent );
                if ( result == null )
                    result = caseReadableComponent ( textInputComponent );
                if ( result == null )
                    result = caseComponent ( textInputComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.WRITEABLE_COMPONENT:
            {
                WriteableComponent writeableComponent = (WriteableComponent)theEObject;
                T result = caseWriteableComponent ( writeableComponent );
                if ( result == null )
                    result = caseReadableComponent ( writeableComponent );
                if ( result == null )
                    result = caseComponent ( writeableComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.READABLE_COMPONENT:
            {
                ReadableComponent readableComponent = (ReadableComponent)theEObject;
                T result = caseReadableComponent ( readableComponent );
                if ( result == null )
                    result = caseComponent ( readableComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.TEXT_COMPONENT:
            {
                TextComponent textComponent = (TextComponent)theEObject;
                T result = caseTextComponent ( textComponent );
                if ( result == null )
                    result = caseReadableComponent ( textComponent );
                if ( result == null )
                    result = caseComponent ( textComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.TEXT_INPUT_MULTI_COMPONENT:
            {
                TextInputMultiComponent textInputMultiComponent = (TextInputMultiComponent)theEObject;
                T result = caseTextInputMultiComponent ( textInputMultiComponent );
                if ( result == null )
                    result = caseWriteableComponent ( textInputMultiComponent );
                if ( result == null )
                    result = caseReadableComponent ( textInputMultiComponent );
                if ( result == null )
                    result = caseComponent ( textInputMultiComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.CHECK_COMPONENT:
            {
                CheckComponent checkComponent = (CheckComponent)theEObject;
                T result = caseCheckComponent ( checkComponent );
                if ( result == null )
                    result = caseComponent ( checkComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.LINK_COMPONENT:
            {
                LinkComponent linkComponent = (LinkComponent)theEObject;
                T result = caseLinkComponent ( linkComponent );
                if ( result == null )
                    result = caseComponent ( linkComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.URL_IMAGE_COMPONENT:
            {
                URLImageComponent urlImageComponent = (URLImageComponent)theEObject;
                T result = caseURLImageComponent ( urlImageComponent );
                if ( result == null )
                    result = caseComponent ( urlImageComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.PROGRESS_COMPONENT:
            {
                ProgressComponent progressComponent = (ProgressComponent)theEObject;
                T result = caseProgressComponent ( progressComponent );
                if ( result == null )
                    result = caseReadableComponent ( progressComponent );
                if ( result == null )
                    result = caseComponent ( progressComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.HIDDEN_COMPONENT:
            {
                HiddenComponent hiddenComponent = (HiddenComponent)theEObject;
                T result = caseHiddenComponent ( hiddenComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.VISIBILITY:
            {
                Visibility visibility = (Visibility)theEObject;
                T result = caseVisibility ( visibility );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.SCRIPT_VISIBILITY:
            {
                ScriptVisibility scriptVisibility = (ScriptVisibility)theEObject;
                T result = caseScriptVisibility ( scriptVisibility );
                if ( result == null )
                    result = caseVisibility ( scriptVisibility );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.PERMISSION_VISIBILITY:
            {
                PermissionVisibility permissionVisibility = (PermissionVisibility)theEObject;
                T result = casePermissionVisibility ( permissionVisibility );
                if ( result == null )
                    result = caseVisibility ( permissionVisibility );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.INVISIBLE:
            {
                Invisible invisible = (Invisible)theEObject;
                T result = caseInvisible ( invisible );
                if ( result == null )
                    result = caseVisibility ( invisible );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.TEST_VISIBILITY:
            {
                TestVisibility testVisibility = (TestVisibility)theEObject;
                T result = caseTestVisibility ( testVisibility );
                if ( result == null )
                    result = caseVisibility ( testVisibility );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DetailViewPackage.SCRIPT_MODULE:
            {
                ScriptModule scriptModule = (ScriptModule)theEObject;
                T result = caseScriptModule ( scriptModule );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>View</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>View</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseView ( View object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponent ( Component object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Group Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Group Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGroupEntry ( GroupEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Label Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Label Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLabelComponent ( LabelComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Composite Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Composite Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompositeComponent ( CompositeComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Fill Layout Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Fill Layout Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFillLayoutComponent ( FillLayoutComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Button Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Button Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseButtonComponent ( ButtonComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Bool LED Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Bool LED Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBoolLEDComponent ( BoolLEDComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Value Source</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Source</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueSource ( ValueSource object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Value Source</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Value Source</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemValueSource ( ItemValueSource object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Not Transformer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Not Transformer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNotTransformer ( NotTransformer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Generic Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Generic Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGenericComponent ( GenericComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Registration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Registration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRegistration ( Registration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simple Grid Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Grid Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimpleGridComponent ( SimpleGridComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Group Grid Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Group Grid Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGroupGridComponent ( GroupGridComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Group Grid Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Group Grid Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGroupGridEntry ( GroupGridEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Value Set Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Set Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueSetComponent ( ValueSetComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Value Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueComponent ( ValueComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Composite Transformer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Composite Transformer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompositeTransformer ( CompositeTransformer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>And Transformer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>And Transformer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAndTransformer ( AndTransformer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Or Transformer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Or Transformer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOrTransformer ( OrTransformer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Text Input Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Text Input Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextInputComponent ( TextInputComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Writeable Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Writeable Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWriteableComponent ( WriteableComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Readable Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Readable Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReadableComponent ( ReadableComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Text Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Text Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextComponent ( TextComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Text Input Multi Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Text Input Multi Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextInputMultiComponent ( TextInputMultiComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Check Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Check Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCheckComponent ( CheckComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Link Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Link Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLinkComponent ( LinkComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>URL Image Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>URL Image Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseURLImageComponent ( URLImageComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Progress Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Progress Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProgressComponent ( ProgressComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Hidden Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Hidden Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHiddenComponent ( HiddenComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Visibility</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Visibility</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVisibility ( Visibility object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Script Visibility</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Script Visibility</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptVisibility ( ScriptVisibility object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Permission Visibility</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Permission Visibility</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePermissionVisibility ( PermissionVisibility object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Invisible</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Invisible</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInvisible ( Invisible object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Test Visibility</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Test Visibility</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTestVisibility ( TestVisibility object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Script Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Script Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptModule ( ScriptModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
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

} //DetailViewSwitch
