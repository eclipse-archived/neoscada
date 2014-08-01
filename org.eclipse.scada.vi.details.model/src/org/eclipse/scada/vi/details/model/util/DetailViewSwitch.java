/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add browser component
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.vi.details.model.AndTransformer;
import org.eclipse.scada.vi.details.model.BoolLEDComponent;
import org.eclipse.scada.vi.details.model.BrowserComponent;
import org.eclipse.scada.vi.details.model.ButtonComponent;
import org.eclipse.scada.vi.details.model.CheckComponent;
import org.eclipse.scada.vi.details.model.Component;
import org.eclipse.scada.vi.details.model.CompositeComponent;
import org.eclipse.scada.vi.details.model.CompositeTransformer;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.FillLayoutComponent;
import org.eclipse.scada.vi.details.model.GenericComponent;
import org.eclipse.scada.vi.details.model.GroupEntry;
import org.eclipse.scada.vi.details.model.GroupGridComponent;
import org.eclipse.scada.vi.details.model.GroupGridEntry;
import org.eclipse.scada.vi.details.model.HiddenComponent;
import org.eclipse.scada.vi.details.model.Invisible;
import org.eclipse.scada.vi.details.model.ItemValueSource;
import org.eclipse.scada.vi.details.model.LabelComponent;
import org.eclipse.scada.vi.details.model.LinkComponent;
import org.eclipse.scada.vi.details.model.NotTransformer;
import org.eclipse.scada.vi.details.model.OrTransformer;
import org.eclipse.scada.vi.details.model.PermissionVisibility;
import org.eclipse.scada.vi.details.model.ProgressComponent;
import org.eclipse.scada.vi.details.model.ReadableComponent;
import org.eclipse.scada.vi.details.model.Registration;
import org.eclipse.scada.vi.details.model.ScriptModule;
import org.eclipse.scada.vi.details.model.ScriptVisibility;
import org.eclipse.scada.vi.details.model.SimpleGridComponent;
import org.eclipse.scada.vi.details.model.TestVisibility;
import org.eclipse.scada.vi.details.model.TextComponent;
import org.eclipse.scada.vi.details.model.TextInputComponent;
import org.eclipse.scada.vi.details.model.TextInputMultiComponent;
import org.eclipse.scada.vi.details.model.URLImageComponent;
import org.eclipse.scada.vi.details.model.ValueComponent;
import org.eclipse.scada.vi.details.model.ValueSetComponent;
import org.eclipse.scada.vi.details.model.ValueSource;
import org.eclipse.scada.vi.details.model.View;
import org.eclipse.scada.vi.details.model.Visibility;
import org.eclipse.scada.vi.details.model.WriteableComponent;

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
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage
 * @generated
 */
public class DetailViewSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected static DetailViewPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
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
            case DetailViewPackage.VIEW:
            {
                final View view = (View)theEObject;
                T result = caseView ( view );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.COMPONENT:
            {
                final Component component = (Component)theEObject;
                T result = caseComponent ( component );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.GROUP_ENTRY:
            {
                final GroupEntry groupEntry = (GroupEntry)theEObject;
                T result = caseGroupEntry ( groupEntry );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.LABEL_COMPONENT:
            {
                final LabelComponent labelComponent = (LabelComponent)theEObject;
                T result = caseLabelComponent ( labelComponent );
                if ( result == null )
                {
                    result = caseComponent ( labelComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.COMPOSITE_COMPONENT:
            {
                final CompositeComponent compositeComponent = (CompositeComponent)theEObject;
                T result = caseCompositeComponent ( compositeComponent );
                if ( result == null )
                {
                    result = caseComponent ( compositeComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.FILL_LAYOUT_COMPONENT:
            {
                final FillLayoutComponent fillLayoutComponent = (FillLayoutComponent)theEObject;
                T result = caseFillLayoutComponent ( fillLayoutComponent );
                if ( result == null )
                {
                    result = caseCompositeComponent ( fillLayoutComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( fillLayoutComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.BUTTON_COMPONENT:
            {
                final ButtonComponent buttonComponent = (ButtonComponent)theEObject;
                T result = caseButtonComponent ( buttonComponent );
                if ( result == null )
                {
                    result = caseGenericComponent ( buttonComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( buttonComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.BOOL_LED_COMPONENT:
            {
                final BoolLEDComponent boolLEDComponent = (BoolLEDComponent)theEObject;
                T result = caseBoolLEDComponent ( boolLEDComponent );
                if ( result == null )
                {
                    result = caseComponent ( boolLEDComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.VALUE_SOURCE:
            {
                final ValueSource valueSource = (ValueSource)theEObject;
                T result = caseValueSource ( valueSource );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.ITEM_VALUE_SOURCE:
            {
                final ItemValueSource itemValueSource = (ItemValueSource)theEObject;
                T result = caseItemValueSource ( itemValueSource );
                if ( result == null )
                {
                    result = caseValueSource ( itemValueSource );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.NOT_TRANSFORMER:
            {
                final NotTransformer notTransformer = (NotTransformer)theEObject;
                T result = caseNotTransformer ( notTransformer );
                if ( result == null )
                {
                    result = caseValueSource ( notTransformer );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.GENERIC_COMPONENT:
            {
                final GenericComponent genericComponent = (GenericComponent)theEObject;
                T result = caseGenericComponent ( genericComponent );
                if ( result == null )
                {
                    result = caseComponent ( genericComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.REGISTRATION:
            {
                final Registration registration = (Registration)theEObject;
                T result = caseRegistration ( registration );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.SIMPLE_GRID_COMPONENT:
            {
                final SimpleGridComponent simpleGridComponent = (SimpleGridComponent)theEObject;
                T result = caseSimpleGridComponent ( simpleGridComponent );
                if ( result == null )
                {
                    result = caseCompositeComponent ( simpleGridComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( simpleGridComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.GROUP_GRID_COMPONENT:
            {
                final GroupGridComponent groupGridComponent = (GroupGridComponent)theEObject;
                T result = caseGroupGridComponent ( groupGridComponent );
                if ( result == null )
                {
                    result = caseComponent ( groupGridComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.GROUP_GRID_ENTRY:
            {
                final GroupGridEntry groupGridEntry = (GroupGridEntry)theEObject;
                T result = caseGroupGridEntry ( groupGridEntry );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.VALUE_SET_COMPONENT:
            {
                final ValueSetComponent valueSetComponent = (ValueSetComponent)theEObject;
                T result = caseValueSetComponent ( valueSetComponent );
                if ( result == null )
                {
                    result = caseWriteableComponent ( valueSetComponent );
                }
                if ( result == null )
                {
                    result = caseReadableComponent ( valueSetComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( valueSetComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.VALUE_COMPONENT:
            {
                final ValueComponent valueComponent = (ValueComponent)theEObject;
                T result = caseValueComponent ( valueComponent );
                if ( result == null )
                {
                    result = caseReadableComponent ( valueComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( valueComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.COMPOSITE_TRANSFORMER:
            {
                final CompositeTransformer compositeTransformer = (CompositeTransformer)theEObject;
                T result = caseCompositeTransformer ( compositeTransformer );
                if ( result == null )
                {
                    result = caseValueSource ( compositeTransformer );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.AND_TRANSFORMER:
            {
                final AndTransformer andTransformer = (AndTransformer)theEObject;
                T result = caseAndTransformer ( andTransformer );
                if ( result == null )
                {
                    result = caseCompositeTransformer ( andTransformer );
                }
                if ( result == null )
                {
                    result = caseValueSource ( andTransformer );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.OR_TRANSFORMER:
            {
                final OrTransformer orTransformer = (OrTransformer)theEObject;
                T result = caseOrTransformer ( orTransformer );
                if ( result == null )
                {
                    result = caseCompositeTransformer ( orTransformer );
                }
                if ( result == null )
                {
                    result = caseValueSource ( orTransformer );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.TEXT_INPUT_COMPONENT:
            {
                final TextInputComponent textInputComponent = (TextInputComponent)theEObject;
                T result = caseTextInputComponent ( textInputComponent );
                if ( result == null )
                {
                    result = caseWriteableComponent ( textInputComponent );
                }
                if ( result == null )
                {
                    result = caseReadableComponent ( textInputComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( textInputComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.WRITEABLE_COMPONENT:
            {
                final WriteableComponent writeableComponent = (WriteableComponent)theEObject;
                T result = caseWriteableComponent ( writeableComponent );
                if ( result == null )
                {
                    result = caseReadableComponent ( writeableComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( writeableComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.READABLE_COMPONENT:
            {
                final ReadableComponent readableComponent = (ReadableComponent)theEObject;
                T result = caseReadableComponent ( readableComponent );
                if ( result == null )
                {
                    result = caseComponent ( readableComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.TEXT_COMPONENT:
            {
                final TextComponent textComponent = (TextComponent)theEObject;
                T result = caseTextComponent ( textComponent );
                if ( result == null )
                {
                    result = caseReadableComponent ( textComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( textComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.TEXT_INPUT_MULTI_COMPONENT:
            {
                final TextInputMultiComponent textInputMultiComponent = (TextInputMultiComponent)theEObject;
                T result = caseTextInputMultiComponent ( textInputMultiComponent );
                if ( result == null )
                {
                    result = caseWriteableComponent ( textInputMultiComponent );
                }
                if ( result == null )
                {
                    result = caseReadableComponent ( textInputMultiComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( textInputMultiComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.CHECK_COMPONENT:
            {
                final CheckComponent checkComponent = (CheckComponent)theEObject;
                T result = caseCheckComponent ( checkComponent );
                if ( result == null )
                {
                    result = caseComponent ( checkComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.LINK_COMPONENT:
            {
                final LinkComponent linkComponent = (LinkComponent)theEObject;
                T result = caseLinkComponent ( linkComponent );
                if ( result == null )
                {
                    result = caseComponent ( linkComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.URL_IMAGE_COMPONENT:
            {
                final URLImageComponent urlImageComponent = (URLImageComponent)theEObject;
                T result = caseURLImageComponent ( urlImageComponent );
                if ( result == null )
                {
                    result = caseComponent ( urlImageComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.PROGRESS_COMPONENT:
            {
                final ProgressComponent progressComponent = (ProgressComponent)theEObject;
                T result = caseProgressComponent ( progressComponent );
                if ( result == null )
                {
                    result = caseReadableComponent ( progressComponent );
                }
                if ( result == null )
                {
                    result = caseComponent ( progressComponent );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.HIDDEN_COMPONENT:
            {
                final HiddenComponent hiddenComponent = (HiddenComponent)theEObject;
                T result = caseHiddenComponent ( hiddenComponent );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.VISIBILITY:
            {
                final Visibility visibility = (Visibility)theEObject;
                T result = caseVisibility ( visibility );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.SCRIPT_VISIBILITY:
            {
                final ScriptVisibility scriptVisibility = (ScriptVisibility)theEObject;
                T result = caseScriptVisibility ( scriptVisibility );
                if ( result == null )
                {
                    result = caseVisibility ( scriptVisibility );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.PERMISSION_VISIBILITY:
            {
                final PermissionVisibility permissionVisibility = (PermissionVisibility)theEObject;
                T result = casePermissionVisibility ( permissionVisibility );
                if ( result == null )
                {
                    result = caseVisibility ( permissionVisibility );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.INVISIBLE:
            {
                final Invisible invisible = (Invisible)theEObject;
                T result = caseInvisible ( invisible );
                if ( result == null )
                {
                    result = caseVisibility ( invisible );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.TEST_VISIBILITY:
            {
                final TestVisibility testVisibility = (TestVisibility)theEObject;
                T result = caseTestVisibility ( testVisibility );
                if ( result == null )
                {
                    result = caseVisibility ( testVisibility );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.SCRIPT_MODULE:
            {
                final ScriptModule scriptModule = (ScriptModule)theEObject;
                T result = caseScriptModule ( scriptModule );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case DetailViewPackage.BROWSER_COMPONENT:
            {
                final BrowserComponent browserComponent = (BrowserComponent)theEObject;
                T result = caseBrowserComponent ( browserComponent );
                if ( result == null )
                {
                    result = caseComponent ( browserComponent );
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
     * <em>View</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>View</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseView ( final View object )
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
     * <em>Group Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Group Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGroupEntry ( final GroupEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Label Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Label Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLabelComponent ( final LabelComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Composite Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Composite Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompositeComponent ( final CompositeComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Fill Layout Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Fill Layout Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFillLayoutComponent ( final FillLayoutComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Button Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Button Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseButtonComponent ( final ButtonComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Bool LED Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Bool LED Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBoolLEDComponent ( final BoolLEDComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Value Source</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Value Source</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueSource ( final ValueSource object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Item Value Source</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Item Value Source</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemValueSource ( final ItemValueSource object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Not Transformer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Not Transformer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNotTransformer ( final NotTransformer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Generic Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Generic Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGenericComponent ( final GenericComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Registration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Registration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRegistration ( final Registration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Simple Grid Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Simple Grid Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimpleGridComponent ( final SimpleGridComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Group Grid Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Group Grid Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGroupGridComponent ( final GroupGridComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Group Grid Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Group Grid Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGroupGridEntry ( final GroupGridEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Value Set Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Value Set Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueSetComponent ( final ValueSetComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Value Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Value Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueComponent ( final ValueComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Composite Transformer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Composite Transformer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompositeTransformer ( final CompositeTransformer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>And Transformer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>And Transformer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAndTransformer ( final AndTransformer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Or Transformer</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Or Transformer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOrTransformer ( final OrTransformer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Text Input Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Text Input Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextInputComponent ( final TextInputComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Writeable Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Writeable Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWriteableComponent ( final WriteableComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Readable Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Readable Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReadableComponent ( final ReadableComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Text Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Text Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextComponent ( final TextComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Text Input Multi Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Text Input Multi Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTextInputMultiComponent ( final TextInputMultiComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Check Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Check Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCheckComponent ( final CheckComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Link Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Link Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLinkComponent ( final LinkComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>URL Image Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>URL Image Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseURLImageComponent ( final URLImageComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Progress Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Progress Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProgressComponent ( final ProgressComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Hidden Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Hidden Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHiddenComponent ( final HiddenComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Visibility</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Visibility</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVisibility ( final Visibility object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Script Visibility</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Script Visibility</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptVisibility ( final ScriptVisibility object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Permission Visibility</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Permission Visibility</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePermissionVisibility ( final PermissionVisibility object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Invisible</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Invisible</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInvisible ( final Invisible object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Test Visibility</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Test Visibility</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTestVisibility ( final TestVisibility object )
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
     * <em>Browser Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Browser Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBrowserComponent ( final BrowserComponent object )
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

} //DetailViewSwitch
