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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.vi.details.model.AndTransformer;
import org.eclipse.scada.vi.details.model.BoolLEDComponent;
import org.eclipse.scada.vi.details.model.ButtonComponent;
import org.eclipse.scada.vi.details.model.CheckComponent;
import org.eclipse.scada.vi.details.model.Component;
import org.eclipse.scada.vi.details.model.CompositeComponent;
import org.eclipse.scada.vi.details.model.CompositeTransformer;
import org.eclipse.scada.vi.details.model.DetailViewFactory;
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
import org.eclipse.scada.vi.details.model.TabStyle;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DetailViewPackageImpl extends EPackageImpl implements DetailViewPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass viewEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass componentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass groupEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass labelComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass compositeComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fillLayoutComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass buttonComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass boolLEDComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueSourceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemValueSourceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass notTransformerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genericComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass registrationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass simpleGridComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass groupGridComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass groupGridEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueSetComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass compositeTransformerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass andTransformerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass orTransformerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textInputComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass writeableComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass readableComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass textInputMultiComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass checkComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass linkComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass urlImageComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass progressComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass hiddenComponentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass visibilityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptVisibilityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass permissionVisibilityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass invisibleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass testVisibilityEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptModuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum tabStyleEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package
     * package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private DetailViewPackageImpl ()
    {
        super ( eNS_URI, DetailViewFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link DetailViewPackage#eINSTANCE}
     * when that field is accessed. Clients should not invoke it directly.
     * Instead, they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static DetailViewPackage init ()
    {
        if ( isInited )
            return (DetailViewPackage)EPackage.Registry.INSTANCE.getEPackage ( DetailViewPackage.eNS_URI );

        // Obtain or create and register package
        DetailViewPackageImpl theDetailViewPackage = (DetailViewPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof DetailViewPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new DetailViewPackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theDetailViewPackage.createPackageContents ();

        // Initialize created meta-data
        theDetailViewPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theDetailViewPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( DetailViewPackage.eNS_URI, theDetailViewPackage );
        return theDetailViewPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getView ()
    {
        return viewEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getView_HeaderComponent ()
    {
        return (EReference)viewEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getView_Groups ()
    {
        return (EReference)viewEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getView_HiddenComponent ()
    {
        return (EReference)viewEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getView_ScriptModule ()
    {
        return (EReference)viewEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getView_TabStyle ()
    {
        return (EAttribute)viewEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComponent ()
    {
        return componentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponent_Visibility ()
    {
        return (EReference)componentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGroupEntry ()
    {
        return groupEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroupEntry_Component ()
    {
        return (EReference)groupEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupEntry_Label ()
    {
        return (EAttribute)groupEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupEntry_Permission ()
    {
        return (EAttribute)groupEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroupEntry_Visibility ()
    {
        return (EReference)groupEntryEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLabelComponent ()
    {
        return labelComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLabelComponent_Format ()
    {
        return (EAttribute)labelComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLabelComponent_Descriptor ()
    {
        return (EAttribute)labelComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCompositeComponent ()
    {
        return compositeComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositeComponent_Children ()
    {
        return (EReference)compositeComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFillLayoutComponent ()
    {
        return fillLayoutComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getButtonComponent ()
    {
        return buttonComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_Format ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_Value ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_ReadDescriptor ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_WriteDescriptor ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getButtonComponent_Active ()
    {
        return (EReference)buttonComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_Attribute ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getButtonComponent_TextHeight ()
    {
        return (EAttribute)buttonComponentEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBoolLEDComponent ()
    {
        return boolLEDComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_Format ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_Descriptor ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_Alarm ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_Attribute ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_ExpectedValue ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBoolLEDComponent_OnOff ()
    {
        return (EAttribute)boolLEDComponentEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValueSource ()
    {
        return valueSourceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItemValueSource ()
    {
        return itemValueSourceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItemValueSource_ValueKey ()
    {
        return (EAttribute)itemValueSourceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNotTransformer ()
    {
        return notTransformerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getNotTransformer_Value ()
    {
        return (EReference)notTransformerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenericComponent ()
    {
        return genericComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGenericComponent_Registrations ()
    {
        return (EReference)genericComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRegistration ()
    {
        return registrationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRegistration_Key ()
    {
        return (EAttribute)registrationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRegistration_Descriptor ()
    {
        return (EAttribute)registrationEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRegistration_AggregateState ()
    {
        return (EAttribute)registrationEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSimpleGridComponent ()
    {
        return simpleGridComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleGridComponent_Equally ()
    {
        return (EAttribute)simpleGridComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleGridComponent_Cols ()
    {
        return (EAttribute)simpleGridComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGroupGridComponent ()
    {
        return groupGridComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroupGridComponent_Groups ()
    {
        return (EReference)groupGridComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupGridComponent_Equally ()
    {
        return (EAttribute)groupGridComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupGridComponent_Cols ()
    {
        return (EAttribute)groupGridComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGroupGridEntry ()
    {
        return groupGridEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupGridEntry_Label ()
    {
        return (EAttribute)groupGridEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroupGridEntry_Components ()
    {
        return (EReference)groupGridEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGroupGridEntry_Permission ()
    {
        return (EAttribute)groupGridEntryEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getGroupGridEntry_Visibility ()
    {
        return (EReference)groupGridEntryEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValueSetComponent ()
    {
        return valueSetComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueSetComponent_ValueDescriptor ()
    {
        return (EAttribute)valueSetComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueSetComponent_SetDescriptor ()
    {
        return (EAttribute)valueSetComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueSetComponent_ResetDescriptor ()
    {
        return (EAttribute)valueSetComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValueComponent ()
    {
        return valueComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueComponent_Descriptor ()
    {
        return (EAttribute)valueComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getValueComponent_Date ()
    {
        return (EAttribute)valueComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCompositeTransformer ()
    {
        return compositeTransformerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositeTransformer_Values ()
    {
        return (EReference)compositeTransformerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAndTransformer ()
    {
        return andTransformerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOrTransformer ()
    {
        return orTransformerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextInputComponent ()
    {
        return textInputComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextInputComponent_Descriptor ()
    {
        return (EAttribute)textInputComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextInputComponent_ReadDescriptor ()
    {
        return (EAttribute)textInputComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextInputComponent_Width ()
    {
        return (EAttribute)textInputComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getWriteableComponent ()
    {
        return writeableComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWriteableComponent_Ceil ()
    {
        return (EAttribute)writeableComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getWriteableComponent_Floor ()
    {
        return (EAttribute)writeableComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getReadableComponent ()
    {
        return readableComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_Format ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_Decimal ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_Attribute ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_HdConnectionId ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_HdItemId ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_HdQueryString ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getReadableComponent_IsText ()
    {
        return (EAttribute)readableComponentEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextComponent ()
    {
        return textComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_Descriptor ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_Width ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_Height ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_Date ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_TextHeight ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextComponent_TextMap ()
    {
        return (EAttribute)textComponentEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTextInputMultiComponent ()
    {
        return textInputMultiComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTextInputMultiComponent_Descriptor ()
    {
        return (EAttribute)textInputMultiComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCheckComponent ()
    {
        return checkComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCheckComponent_Format ()
    {
        return (EAttribute)checkComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCheckComponent_Descriptor ()
    {
        return (EAttribute)checkComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCheckComponent_Attribute ()
    {
        return (EAttribute)checkComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCheckComponent_ReadDescriptor ()
    {
        return (EAttribute)checkComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLinkComponent ()
    {
        return linkComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLinkComponent_Format ()
    {
        return (EAttribute)linkComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getURLImageComponent ()
    {
        return urlImageComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_Descriptor ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_ImageUrl ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_FallbackImageUrl ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_Width ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getURLImageComponent_Height ()
    {
        return (EAttribute)urlImageComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProgressComponent ()
    {
        return progressComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Descriptor ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Factor ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Max ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Min ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProgressComponent_Width ()
    {
        return (EAttribute)progressComponentEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getHiddenComponent ()
    {
        return hiddenComponentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getHiddenComponent_Descriptor ()
    {
        return (EAttribute)hiddenComponentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getVisibility ()
    {
        return visibilityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScriptVisibility ()
    {
        return scriptVisibilityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScriptVisibility_Script ()
    {
        return (EAttribute)scriptVisibilityEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScriptVisibility_ScriptLanguage ()
    {
        return (EAttribute)scriptVisibilityEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPermissionVisibility ()
    {
        return permissionVisibilityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPermissionVisibility_RequiredPermission ()
    {
        return (EAttribute)permissionVisibilityEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInvisible ()
    {
        return invisibleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTestVisibility ()
    {
        return testVisibilityEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTestVisibility_Id ()
    {
        return (EAttribute)testVisibilityEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScriptModule ()
    {
        return scriptModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScriptModule_ScriptLanguage ()
    {
        return (EAttribute)scriptModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScriptModule_Code ()
    {
        return (EAttribute)scriptModuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScriptModule_CodeUri ()
    {
        return (EAttribute)scriptModuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getTabStyle ()
    {
        return tabStyleEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DetailViewFactory getDetailViewFactory ()
    {
        return (DetailViewFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents ()
    {
        if ( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        viewEClass = createEClass ( VIEW );
        createEReference ( viewEClass, VIEW__HEADER_COMPONENT );
        createEReference ( viewEClass, VIEW__GROUPS );
        createEReference ( viewEClass, VIEW__HIDDEN_COMPONENT );
        createEReference ( viewEClass, VIEW__SCRIPT_MODULE );
        createEAttribute ( viewEClass, VIEW__TAB_STYLE );

        componentEClass = createEClass ( COMPONENT );
        createEReference ( componentEClass, COMPONENT__VISIBILITY );

        groupEntryEClass = createEClass ( GROUP_ENTRY );
        createEReference ( groupEntryEClass, GROUP_ENTRY__COMPONENT );
        createEAttribute ( groupEntryEClass, GROUP_ENTRY__LABEL );
        createEAttribute ( groupEntryEClass, GROUP_ENTRY__PERMISSION );
        createEReference ( groupEntryEClass, GROUP_ENTRY__VISIBILITY );

        labelComponentEClass = createEClass ( LABEL_COMPONENT );
        createEAttribute ( labelComponentEClass, LABEL_COMPONENT__FORMAT );
        createEAttribute ( labelComponentEClass, LABEL_COMPONENT__DESCRIPTOR );

        compositeComponentEClass = createEClass ( COMPOSITE_COMPONENT );
        createEReference ( compositeComponentEClass, COMPOSITE_COMPONENT__CHILDREN );

        fillLayoutComponentEClass = createEClass ( FILL_LAYOUT_COMPONENT );

        buttonComponentEClass = createEClass ( BUTTON_COMPONENT );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__FORMAT );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__VALUE );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__READ_DESCRIPTOR );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__WRITE_DESCRIPTOR );
        createEReference ( buttonComponentEClass, BUTTON_COMPONENT__ACTIVE );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__ATTRIBUTE );
        createEAttribute ( buttonComponentEClass, BUTTON_COMPONENT__TEXT_HEIGHT );

        boolLEDComponentEClass = createEClass ( BOOL_LED_COMPONENT );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__FORMAT );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__DESCRIPTOR );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__ALARM );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__ATTRIBUTE );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__EXPECTED_VALUE );
        createEAttribute ( boolLEDComponentEClass, BOOL_LED_COMPONENT__ON_OFF );

        valueSourceEClass = createEClass ( VALUE_SOURCE );

        itemValueSourceEClass = createEClass ( ITEM_VALUE_SOURCE );
        createEAttribute ( itemValueSourceEClass, ITEM_VALUE_SOURCE__VALUE_KEY );

        notTransformerEClass = createEClass ( NOT_TRANSFORMER );
        createEReference ( notTransformerEClass, NOT_TRANSFORMER__VALUE );

        genericComponentEClass = createEClass ( GENERIC_COMPONENT );
        createEReference ( genericComponentEClass, GENERIC_COMPONENT__REGISTRATIONS );

        registrationEClass = createEClass ( REGISTRATION );
        createEAttribute ( registrationEClass, REGISTRATION__KEY );
        createEAttribute ( registrationEClass, REGISTRATION__DESCRIPTOR );
        createEAttribute ( registrationEClass, REGISTRATION__AGGREGATE_STATE );

        simpleGridComponentEClass = createEClass ( SIMPLE_GRID_COMPONENT );
        createEAttribute ( simpleGridComponentEClass, SIMPLE_GRID_COMPONENT__EQUALLY );
        createEAttribute ( simpleGridComponentEClass, SIMPLE_GRID_COMPONENT__COLS );

        groupGridComponentEClass = createEClass ( GROUP_GRID_COMPONENT );
        createEReference ( groupGridComponentEClass, GROUP_GRID_COMPONENT__GROUPS );
        createEAttribute ( groupGridComponentEClass, GROUP_GRID_COMPONENT__EQUALLY );
        createEAttribute ( groupGridComponentEClass, GROUP_GRID_COMPONENT__COLS );

        groupGridEntryEClass = createEClass ( GROUP_GRID_ENTRY );
        createEAttribute ( groupGridEntryEClass, GROUP_GRID_ENTRY__LABEL );
        createEReference ( groupGridEntryEClass, GROUP_GRID_ENTRY__COMPONENTS );
        createEAttribute ( groupGridEntryEClass, GROUP_GRID_ENTRY__PERMISSION );
        createEReference ( groupGridEntryEClass, GROUP_GRID_ENTRY__VISIBILITY );

        valueSetComponentEClass = createEClass ( VALUE_SET_COMPONENT );
        createEAttribute ( valueSetComponentEClass, VALUE_SET_COMPONENT__VALUE_DESCRIPTOR );
        createEAttribute ( valueSetComponentEClass, VALUE_SET_COMPONENT__SET_DESCRIPTOR );
        createEAttribute ( valueSetComponentEClass, VALUE_SET_COMPONENT__RESET_DESCRIPTOR );

        valueComponentEClass = createEClass ( VALUE_COMPONENT );
        createEAttribute ( valueComponentEClass, VALUE_COMPONENT__DESCRIPTOR );
        createEAttribute ( valueComponentEClass, VALUE_COMPONENT__DATE );

        compositeTransformerEClass = createEClass ( COMPOSITE_TRANSFORMER );
        createEReference ( compositeTransformerEClass, COMPOSITE_TRANSFORMER__VALUES );

        andTransformerEClass = createEClass ( AND_TRANSFORMER );

        orTransformerEClass = createEClass ( OR_TRANSFORMER );

        textInputComponentEClass = createEClass ( TEXT_INPUT_COMPONENT );
        createEAttribute ( textInputComponentEClass, TEXT_INPUT_COMPONENT__DESCRIPTOR );
        createEAttribute ( textInputComponentEClass, TEXT_INPUT_COMPONENT__READ_DESCRIPTOR );
        createEAttribute ( textInputComponentEClass, TEXT_INPUT_COMPONENT__WIDTH );

        writeableComponentEClass = createEClass ( WRITEABLE_COMPONENT );
        createEAttribute ( writeableComponentEClass, WRITEABLE_COMPONENT__CEIL );
        createEAttribute ( writeableComponentEClass, WRITEABLE_COMPONENT__FLOOR );

        readableComponentEClass = createEClass ( READABLE_COMPONENT );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__FORMAT );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__DECIMAL );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__ATTRIBUTE );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__HD_CONNECTION_ID );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__HD_ITEM_ID );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__HD_QUERY_STRING );
        createEAttribute ( readableComponentEClass, READABLE_COMPONENT__IS_TEXT );

        textComponentEClass = createEClass ( TEXT_COMPONENT );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__DESCRIPTOR );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__WIDTH );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__HEIGHT );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__DATE );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__TEXT_HEIGHT );
        createEAttribute ( textComponentEClass, TEXT_COMPONENT__TEXT_MAP );

        textInputMultiComponentEClass = createEClass ( TEXT_INPUT_MULTI_COMPONENT );
        createEAttribute ( textInputMultiComponentEClass, TEXT_INPUT_MULTI_COMPONENT__DESCRIPTOR );

        checkComponentEClass = createEClass ( CHECK_COMPONENT );
        createEAttribute ( checkComponentEClass, CHECK_COMPONENT__FORMAT );
        createEAttribute ( checkComponentEClass, CHECK_COMPONENT__DESCRIPTOR );
        createEAttribute ( checkComponentEClass, CHECK_COMPONENT__ATTRIBUTE );
        createEAttribute ( checkComponentEClass, CHECK_COMPONENT__READ_DESCRIPTOR );

        linkComponentEClass = createEClass ( LINK_COMPONENT );
        createEAttribute ( linkComponentEClass, LINK_COMPONENT__FORMAT );

        urlImageComponentEClass = createEClass ( URL_IMAGE_COMPONENT );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__DESCRIPTOR );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__IMAGE_URL );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__FALLBACK_IMAGE_URL );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__WIDTH );
        createEAttribute ( urlImageComponentEClass, URL_IMAGE_COMPONENT__HEIGHT );

        progressComponentEClass = createEClass ( PROGRESS_COMPONENT );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__DESCRIPTOR );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__FACTOR );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__MAX );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__MIN );
        createEAttribute ( progressComponentEClass, PROGRESS_COMPONENT__WIDTH );

        hiddenComponentEClass = createEClass ( HIDDEN_COMPONENT );
        createEAttribute ( hiddenComponentEClass, HIDDEN_COMPONENT__DESCRIPTOR );

        visibilityEClass = createEClass ( VISIBILITY );

        scriptVisibilityEClass = createEClass ( SCRIPT_VISIBILITY );
        createEAttribute ( scriptVisibilityEClass, SCRIPT_VISIBILITY__SCRIPT );
        createEAttribute ( scriptVisibilityEClass, SCRIPT_VISIBILITY__SCRIPT_LANGUAGE );

        permissionVisibilityEClass = createEClass ( PERMISSION_VISIBILITY );
        createEAttribute ( permissionVisibilityEClass, PERMISSION_VISIBILITY__REQUIRED_PERMISSION );

        invisibleEClass = createEClass ( INVISIBLE );

        testVisibilityEClass = createEClass ( TEST_VISIBILITY );
        createEAttribute ( testVisibilityEClass, TEST_VISIBILITY__ID );

        scriptModuleEClass = createEClass ( SCRIPT_MODULE );
        createEAttribute ( scriptModuleEClass, SCRIPT_MODULE__SCRIPT_LANGUAGE );
        createEAttribute ( scriptModuleEClass, SCRIPT_MODULE__CODE );
        createEAttribute ( scriptModuleEClass, SCRIPT_MODULE__CODE_URI );

        // Create enums
        tabStyleEEnum = createEEnum ( TAB_STYLE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        labelComponentEClass.getESuperTypes ().add ( this.getComponent () );
        compositeComponentEClass.getESuperTypes ().add ( this.getComponent () );
        fillLayoutComponentEClass.getESuperTypes ().add ( this.getCompositeComponent () );
        buttonComponentEClass.getESuperTypes ().add ( this.getGenericComponent () );
        boolLEDComponentEClass.getESuperTypes ().add ( this.getComponent () );
        itemValueSourceEClass.getESuperTypes ().add ( this.getValueSource () );
        notTransformerEClass.getESuperTypes ().add ( this.getValueSource () );
        genericComponentEClass.getESuperTypes ().add ( this.getComponent () );
        simpleGridComponentEClass.getESuperTypes ().add ( this.getCompositeComponent () );
        groupGridComponentEClass.getESuperTypes ().add ( this.getComponent () );
        valueSetComponentEClass.getESuperTypes ().add ( this.getWriteableComponent () );
        valueComponentEClass.getESuperTypes ().add ( this.getReadableComponent () );
        compositeTransformerEClass.getESuperTypes ().add ( this.getValueSource () );
        andTransformerEClass.getESuperTypes ().add ( this.getCompositeTransformer () );
        orTransformerEClass.getESuperTypes ().add ( this.getCompositeTransformer () );
        textInputComponentEClass.getESuperTypes ().add ( this.getWriteableComponent () );
        writeableComponentEClass.getESuperTypes ().add ( this.getReadableComponent () );
        readableComponentEClass.getESuperTypes ().add ( this.getComponent () );
        textComponentEClass.getESuperTypes ().add ( this.getReadableComponent () );
        textInputMultiComponentEClass.getESuperTypes ().add ( this.getWriteableComponent () );
        checkComponentEClass.getESuperTypes ().add ( this.getComponent () );
        linkComponentEClass.getESuperTypes ().add ( this.getComponent () );
        urlImageComponentEClass.getESuperTypes ().add ( this.getComponent () );
        progressComponentEClass.getESuperTypes ().add ( this.getReadableComponent () );
        scriptVisibilityEClass.getESuperTypes ().add ( this.getVisibility () );
        permissionVisibilityEClass.getESuperTypes ().add ( this.getVisibility () );
        invisibleEClass.getESuperTypes ().add ( this.getVisibility () );
        testVisibilityEClass.getESuperTypes ().add ( this.getVisibility () );

        // Initialize classes and features; add operations and parameters
        initEClass ( viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getView_HeaderComponent (), this.getComponent (), null, "headerComponent", null, 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getView_Groups (), this.getGroupEntry (), null, "groups", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getView_HiddenComponent (), this.getHiddenComponent (), null, "hiddenComponent", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getView_ScriptModule (), this.getScriptModule (), null, "scriptModule", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getView_TabStyle (), this.getTabStyle (), "tabStyle", null, 0, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getComponent_Visibility (), this.getVisibility (), null, "visibility", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( groupEntryEClass, GroupEntry.class, "GroupEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getGroupEntry_Component (), this.getComponent (), null, "component", null, 1, 1, GroupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getGroupEntry_Label (), ecorePackage.getEString (), "label", null, 0, 1, GroupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getGroupEntry_Permission (), ecorePackage.getEString (), "permission", null, 0, 1, GroupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGroupEntry_Visibility (), this.getVisibility (), null, "visibility", null, 0, 1, GroupEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( labelComponentEClass, LabelComponent.class, "LabelComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getLabelComponent_Format (), ecorePackage.getEString (), "format", "%s", 0, 1, LabelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getLabelComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, LabelComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( compositeComponentEClass, CompositeComponent.class, "CompositeComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCompositeComponent_Children (), this.getComponent (), null, "children", null, 0, -1, CompositeComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( fillLayoutComponentEClass, FillLayoutComponent.class, "FillLayoutComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( buttonComponentEClass, ButtonComponent.class, "ButtonComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getButtonComponent_Format (), ecorePackage.getEString (), "format", null, 1, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getButtonComponent_Value (), ecorePackage.getEString (), "value", null, 1, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getButtonComponent_ReadDescriptor (), ecorePackage.getEString (), "readDescriptor", null, 0, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getButtonComponent_WriteDescriptor (), ecorePackage.getEString (), "writeDescriptor", null, 1, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getButtonComponent_Active (), this.getValueSource (), null, "active", null, 0, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getButtonComponent_Attribute (), ecorePackage.getEString (), "attribute", null, 0, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getButtonComponent_TextHeight (), ecorePackage.getEInt (), "textHeight", null, 0, 1, ButtonComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( boolLEDComponentEClass, BoolLEDComponent.class, "BoolLEDComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getBoolLEDComponent_Format (), ecorePackage.getEString (), "format", null, 0, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBoolLEDComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBoolLEDComponent_Alarm (), ecorePackage.getEBoolean (), "alarm", null, 0, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBoolLEDComponent_Attribute (), ecorePackage.getEString (), "attribute", null, 0, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBoolLEDComponent_ExpectedValue (), ecorePackage.getEBoolean (), "expectedValue", "false", 0, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getBoolLEDComponent_OnOff (), ecorePackage.getEBoolean (), "onOff", "false", 0, 1, BoolLEDComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( valueSourceEClass, ValueSource.class, "ValueSource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( itemValueSourceEClass, ItemValueSource.class, "ItemValueSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItemValueSource_ValueKey (), ecorePackage.getEString (), "valueKey", null, 1, 1, ItemValueSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( notTransformerEClass, NotTransformer.class, "NotTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getNotTransformer_Value (), this.getValueSource (), null, "value", null, 1, 1, NotTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( genericComponentEClass, GenericComponent.class, "GenericComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getGenericComponent_Registrations (), this.getRegistration (), null, "registrations", null, 0, -1, GenericComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( registrationEClass, Registration.class, "Registration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getRegistration_Key (), ecorePackage.getEString (), "key", null, 1, 1, Registration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRegistration_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, Registration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRegistration_AggregateState (), ecorePackage.getEBoolean (), "aggregateState", "true", 0, 1, Registration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( simpleGridComponentEClass, SimpleGridComponent.class, "SimpleGridComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSimpleGridComponent_Equally (), ecorePackage.getEBoolean (), "equally", "true", 0, 1, SimpleGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getSimpleGridComponent_Cols (), ecorePackage.getEInt (), "cols", "2", 0, 1, SimpleGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( groupGridComponentEClass, GroupGridComponent.class, "GroupGridComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getGroupGridComponent_Groups (), this.getGroupGridEntry (), null, "groups", null, 0, -1, GroupGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getGroupGridComponent_Equally (), ecorePackage.getEBoolean (), "equally", "false", 1, 1, GroupGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGroupGridComponent_Cols (), ecorePackage.getEInt (), "cols", "2", 1, 1, GroupGridComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( groupGridEntryEClass, GroupGridEntry.class, "GroupGridEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getGroupGridEntry_Label (), ecorePackage.getEString (), "label", null, 1, 1, GroupGridEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGroupGridEntry_Components (), this.getComponent (), null, "components", null, 0, -1, GroupGridEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getGroupGridEntry_Permission (), ecorePackage.getEString (), "permission", null, 0, 1, GroupGridEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getGroupGridEntry_Visibility (), this.getVisibility (), null, "visibility", null, 0, 1, GroupGridEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( valueSetComponentEClass, ValueSetComponent.class, "ValueSetComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getValueSetComponent_ValueDescriptor (), ecorePackage.getEString (), "valueDescriptor", null, 1, 1, ValueSetComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getValueSetComponent_SetDescriptor (), ecorePackage.getEString (), "setDescriptor", null, 0, 1, ValueSetComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getValueSetComponent_ResetDescriptor (), ecorePackage.getEString (), "resetDescriptor", null, 0, 1, ValueSetComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( valueComponentEClass, ValueComponent.class, "ValueComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getValueComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, ValueComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getValueComponent_Date (), ecorePackage.getEBooleanObject (), "date", null, 0, 1, ValueComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( compositeTransformerEClass, CompositeTransformer.class, "CompositeTransformer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCompositeTransformer_Values (), this.getValueSource (), null, "values", null, 0, -1, CompositeTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( andTransformerEClass, AndTransformer.class, "AndTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( orTransformerEClass, OrTransformer.class, "OrTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( textInputComponentEClass, TextInputComponent.class, "TextInputComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTextInputComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, TextInputComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTextInputComponent_ReadDescriptor (), ecorePackage.getEString (), "readDescriptor", null, 0, 1, TextInputComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTextInputComponent_Width (), ecorePackage.getEInt (), "width", null, 0, 1, TextInputComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( writeableComponentEClass, WriteableComponent.class, "WriteableComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getWriteableComponent_Ceil (), ecorePackage.getEDoubleObject (), "ceil", null, 0, 1, WriteableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getWriteableComponent_Floor (), ecorePackage.getEDouble (), "floor", null, 0, 1, WriteableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( readableComponentEClass, ReadableComponent.class, "ReadableComponent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getReadableComponent_Format (), ecorePackage.getEString (), "format", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getReadableComponent_Decimal (), ecorePackage.getEString (), "decimal", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getReadableComponent_Attribute (), ecorePackage.getEString (), "attribute", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getReadableComponent_HdConnectionId (), ecorePackage.getEString (), "hdConnectionId", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getReadableComponent_HdItemId (), ecorePackage.getEString (), "hdItemId", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getReadableComponent_HdQueryString (), ecorePackage.getEString (), "hdQueryString", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getReadableComponent_IsText (), ecorePackage.getEBoolean (), "isText", null, 0, 1, ReadableComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( textComponentEClass, TextComponent.class, "TextComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTextComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTextComponent_Width (), ecorePackage.getEInt (), "width", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTextComponent_Height (), ecorePackage.getEInt (), "height", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTextComponent_Date (), ecorePackage.getEBoolean (), "date", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTextComponent_TextHeight (), ecorePackage.getEInt (), "textHeight", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTextComponent_TextMap (), ecorePackage.getEString (), "textMap", null, 0, 1, TextComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( textInputMultiComponentEClass, TextInputMultiComponent.class, "TextInputMultiComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTextInputMultiComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, TextInputMultiComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( checkComponentEClass, CheckComponent.class, "CheckComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCheckComponent_Format (), ecorePackage.getEString (), "format", null, 0, 1, CheckComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCheckComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, CheckComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCheckComponent_Attribute (), ecorePackage.getEString (), "attribute", null, 0, 1, CheckComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCheckComponent_ReadDescriptor (), ecorePackage.getEString (), "readDescriptor", null, 0, 1, CheckComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( linkComponentEClass, LinkComponent.class, "LinkComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getLinkComponent_Format (), ecorePackage.getEString (), "format", null, 0, 1, LinkComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( urlImageComponentEClass, URLImageComponent.class, "URLImageComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getURLImageComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getURLImageComponent_ImageUrl (), ecorePackage.getEString (), "imageUrl", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getURLImageComponent_FallbackImageUrl (), ecorePackage.getEString (), "fallbackImageUrl", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getURLImageComponent_Width (), ecorePackage.getEIntegerObject (), "width", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getURLImageComponent_Height (), ecorePackage.getEIntegerObject (), "height", null, 0, 1, URLImageComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( progressComponentEClass, ProgressComponent.class, "ProgressComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getProgressComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProgressComponent_Factor (), ecorePackage.getEDouble (), "factor", null, 0, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProgressComponent_Max (), ecorePackage.getEDouble (), "max", null, 0, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProgressComponent_Min (), ecorePackage.getEDouble (), "min", null, 0, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProgressComponent_Width (), ecorePackage.getEInt (), "width", null, 0, 1, ProgressComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( hiddenComponentEClass, HiddenComponent.class, "HiddenComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getHiddenComponent_Descriptor (), ecorePackage.getEString (), "descriptor", null, 1, 1, HiddenComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( visibilityEClass, Visibility.class, "Visibility", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( scriptVisibilityEClass, ScriptVisibility.class, "ScriptVisibility", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScriptVisibility_Script (), ecorePackage.getEString (), "script", null, 1, 1, ScriptVisibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptVisibility_ScriptLanguage (), ecorePackage.getEString (), "scriptLanguage", null, 0, 1, ScriptVisibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( permissionVisibilityEClass, PermissionVisibility.class, "PermissionVisibility", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPermissionVisibility_RequiredPermission (), ecorePackage.getEString (), "requiredPermission", null, 1, 1, PermissionVisibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( invisibleEClass, Invisible.class, "Invisible", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( testVisibilityEClass, TestVisibility.class, "TestVisibility", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTestVisibility_Id (), ecorePackage.getEString (), "id", null, 1, 1, TestVisibility.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( scriptModuleEClass, ScriptModule.class, "ScriptModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScriptModule_ScriptLanguage (), ecorePackage.getEString (), "scriptLanguage", null, 0, 1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptModule_Code (), ecorePackage.getEString (), "code", null, 0, 1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptModule_CodeUri (), ecorePackage.getEString (), "codeUri", null, 0, 1, ScriptModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( tabStyleEEnum, TabStyle.class, "TabStyle" ); //$NON-NLS-1$
        addEEnumLiteral ( tabStyleEEnum, TabStyle.DEFAULT );
        addEEnumLiteral ( tabStyleEEnum, TabStyle.NATIVE );
        addEEnumLiteral ( tabStyleEEnum, TabStyle.ENHANCED );

        // Create resource
        createResource ( eNS_URI );
    }

} //DetailViewPackageImpl
