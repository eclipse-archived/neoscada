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
package org.eclipse.scada.vi.details.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.vi.details.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DetailViewFactoryImpl extends EFactoryImpl implements DetailViewFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DetailViewFactory init ()
    {
        try
        {
            DetailViewFactory theDetailViewFactory = (DetailViewFactory)EPackage.Registry.INSTANCE.getEFactory ( DetailViewPackage.eNS_URI );
            if ( theDetailViewFactory != null )
            {
                return theDetailViewFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new DetailViewFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DetailViewFactoryImpl ()
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
            case DetailViewPackage.VIEW:
                return createView ();
            case DetailViewPackage.GROUP_ENTRY:
                return createGroupEntry ();
            case DetailViewPackage.LABEL_COMPONENT:
                return createLabelComponent ();
            case DetailViewPackage.FILL_LAYOUT_COMPONENT:
                return createFillLayoutComponent ();
            case DetailViewPackage.BUTTON_COMPONENT:
                return createButtonComponent ();
            case DetailViewPackage.BOOL_LED_COMPONENT:
                return createBoolLEDComponent ();
            case DetailViewPackage.ITEM_VALUE_SOURCE:
                return createItemValueSource ();
            case DetailViewPackage.NOT_TRANSFORMER:
                return createNotTransformer ();
            case DetailViewPackage.REGISTRATION:
                return createRegistration ();
            case DetailViewPackage.SIMPLE_GRID_COMPONENT:
                return createSimpleGridComponent ();
            case DetailViewPackage.GROUP_GRID_COMPONENT:
                return createGroupGridComponent ();
            case DetailViewPackage.GROUP_GRID_ENTRY:
                return createGroupGridEntry ();
            case DetailViewPackage.VALUE_SET_COMPONENT:
                return createValueSetComponent ();
            case DetailViewPackage.VALUE_COMPONENT:
                return createValueComponent ();
            case DetailViewPackage.AND_TRANSFORMER:
                return createAndTransformer ();
            case DetailViewPackage.OR_TRANSFORMER:
                return createOrTransformer ();
            case DetailViewPackage.TEXT_INPUT_COMPONENT:
                return createTextInputComponent ();
            case DetailViewPackage.TEXT_COMPONENT:
                return createTextComponent ();
            case DetailViewPackage.TEXT_INPUT_MULTI_COMPONENT:
                return createTextInputMultiComponent ();
            case DetailViewPackage.CHECK_COMPONENT:
                return createCheckComponent ();
            case DetailViewPackage.LINK_COMPONENT:
                return createLinkComponent ();
            case DetailViewPackage.URL_IMAGE_COMPONENT:
                return createURLImageComponent ();
            case DetailViewPackage.PROGRESS_COMPONENT:
                return createProgressComponent ();
            case DetailViewPackage.HIDDEN_COMPONENT:
                return createHiddenComponent ();
            case DetailViewPackage.SCRIPT_VISIBILITY:
                return createScriptVisibility ();
            case DetailViewPackage.PERMISSION_VISIBILITY:
                return createPermissionVisibility ();
            case DetailViewPackage.INVISIBLE:
                return createInvisible ();
            case DetailViewPackage.TEST_VISIBILITY:
                return createTestVisibility ();
            case DetailViewPackage.SCRIPT_MODULE:
                return createScriptModule ();
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
            case DetailViewPackage.TAB_STYLE:
                return createTabStyleFromString ( eDataType, initialValue );
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
            case DetailViewPackage.TAB_STYLE:
                return convertTabStyleToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public View createView ()
    {
        ViewImpl view = new ViewImpl ();
        return view;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupEntry createGroupEntry ()
    {
        GroupEntryImpl groupEntry = new GroupEntryImpl ();
        return groupEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LabelComponent createLabelComponent ()
    {
        LabelComponentImpl labelComponent = new LabelComponentImpl ();
        return labelComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FillLayoutComponent createFillLayoutComponent ()
    {
        FillLayoutComponentImpl fillLayoutComponent = new FillLayoutComponentImpl ();
        return fillLayoutComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ButtonComponent createButtonComponent ()
    {
        ButtonComponentImpl buttonComponent = new ButtonComponentImpl ();
        return buttonComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BoolLEDComponent createBoolLEDComponent ()
    {
        BoolLEDComponentImpl boolLEDComponent = new BoolLEDComponentImpl ();
        return boolLEDComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemValueSource createItemValueSource ()
    {
        ItemValueSourceImpl itemValueSource = new ItemValueSourceImpl ();
        return itemValueSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotTransformer createNotTransformer ()
    {
        NotTransformerImpl notTransformer = new NotTransformerImpl ();
        return notTransformer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Registration createRegistration ()
    {
        RegistrationImpl registration = new RegistrationImpl ();
        return registration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SimpleGridComponent createSimpleGridComponent ()
    {
        SimpleGridComponentImpl simpleGridComponent = new SimpleGridComponentImpl ();
        return simpleGridComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupGridComponent createGroupGridComponent ()
    {
        GroupGridComponentImpl groupGridComponent = new GroupGridComponentImpl ();
        return groupGridComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GroupGridEntry createGroupGridEntry ()
    {
        GroupGridEntryImpl groupGridEntry = new GroupGridEntryImpl ();
        return groupGridEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueSetComponent createValueSetComponent ()
    {
        ValueSetComponentImpl valueSetComponent = new ValueSetComponentImpl ();
        return valueSetComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueComponent createValueComponent ()
    {
        ValueComponentImpl valueComponent = new ValueComponentImpl ();
        return valueComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AndTransformer createAndTransformer ()
    {
        AndTransformerImpl andTransformer = new AndTransformerImpl ();
        return andTransformer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OrTransformer createOrTransformer ()
    {
        OrTransformerImpl orTransformer = new OrTransformerImpl ();
        return orTransformer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextInputComponent createTextInputComponent ()
    {
        TextInputComponentImpl textInputComponent = new TextInputComponentImpl ();
        return textInputComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextComponent createTextComponent ()
    {
        TextComponentImpl textComponent = new TextComponentImpl ();
        return textComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TextInputMultiComponent createTextInputMultiComponent ()
    {
        TextInputMultiComponentImpl textInputMultiComponent = new TextInputMultiComponentImpl ();
        return textInputMultiComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CheckComponent createCheckComponent ()
    {
        CheckComponentImpl checkComponent = new CheckComponentImpl ();
        return checkComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LinkComponent createLinkComponent ()
    {
        LinkComponentImpl linkComponent = new LinkComponentImpl ();
        return linkComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public URLImageComponent createURLImageComponent ()
    {
        URLImageComponentImpl urlImageComponent = new URLImageComponentImpl ();
        return urlImageComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProgressComponent createProgressComponent ()
    {
        ProgressComponentImpl progressComponent = new ProgressComponentImpl ();
        return progressComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HiddenComponent createHiddenComponent ()
    {
        HiddenComponentImpl hiddenComponent = new HiddenComponentImpl ();
        return hiddenComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScriptVisibility createScriptVisibility ()
    {
        ScriptVisibilityImpl scriptVisibility = new ScriptVisibilityImpl ();
        return scriptVisibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PermissionVisibility createPermissionVisibility ()
    {
        PermissionVisibilityImpl permissionVisibility = new PermissionVisibilityImpl ();
        return permissionVisibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Invisible createInvisible ()
    {
        InvisibleImpl invisible = new InvisibleImpl ();
        return invisible;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TestVisibility createTestVisibility ()
    {
        TestVisibilityImpl testVisibility = new TestVisibilityImpl ();
        return testVisibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScriptModule createScriptModule ()
    {
        ScriptModuleImpl scriptModule = new ScriptModuleImpl ();
        return scriptModule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TabStyle createTabStyleFromString ( EDataType eDataType, String initialValue )
    {
        TabStyle result = TabStyle.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertTabStyleToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DetailViewPackage getDetailViewPackage ()
    {
        return (DetailViewPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DetailViewPackage getPackage ()
    {
        return DetailViewPackage.eINSTANCE;
    }

} //DetailViewFactoryImpl
