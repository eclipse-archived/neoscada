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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage
 * @generated
 */
public class DetailViewAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static DetailViewPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DetailViewAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = DetailViewPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the
     * model's package or is an instance object of the model.
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
    protected DetailViewSwitch<Adapter> modelSwitch = new DetailViewSwitch<Adapter> ()
    {
        @Override
        public Adapter caseView ( View object )
        {
            return createViewAdapter ();
        }

        @Override
        public Adapter caseComponent ( Component object )
        {
            return createComponentAdapter ();
        }

        @Override
        public Adapter caseGroupEntry ( GroupEntry object )
        {
            return createGroupEntryAdapter ();
        }

        @Override
        public Adapter caseLabelComponent ( LabelComponent object )
        {
            return createLabelComponentAdapter ();
        }

        @Override
        public Adapter caseCompositeComponent ( CompositeComponent object )
        {
            return createCompositeComponentAdapter ();
        }

        @Override
        public Adapter caseFillLayoutComponent ( FillLayoutComponent object )
        {
            return createFillLayoutComponentAdapter ();
        }

        @Override
        public Adapter caseButtonComponent ( ButtonComponent object )
        {
            return createButtonComponentAdapter ();
        }

        @Override
        public Adapter caseBoolLEDComponent ( BoolLEDComponent object )
        {
            return createBoolLEDComponentAdapter ();
        }

        @Override
        public Adapter caseValueSource ( ValueSource object )
        {
            return createValueSourceAdapter ();
        }

        @Override
        public Adapter caseItemValueSource ( ItemValueSource object )
        {
            return createItemValueSourceAdapter ();
        }

        @Override
        public Adapter caseNotTransformer ( NotTransformer object )
        {
            return createNotTransformerAdapter ();
        }

        @Override
        public Adapter caseGenericComponent ( GenericComponent object )
        {
            return createGenericComponentAdapter ();
        }

        @Override
        public Adapter caseRegistration ( Registration object )
        {
            return createRegistrationAdapter ();
        }

        @Override
        public Adapter caseSimpleGridComponent ( SimpleGridComponent object )
        {
            return createSimpleGridComponentAdapter ();
        }

        @Override
        public Adapter caseGroupGridComponent ( GroupGridComponent object )
        {
            return createGroupGridComponentAdapter ();
        }

        @Override
        public Adapter caseGroupGridEntry ( GroupGridEntry object )
        {
            return createGroupGridEntryAdapter ();
        }

        @Override
        public Adapter caseValueSetComponent ( ValueSetComponent object )
        {
            return createValueSetComponentAdapter ();
        }

        @Override
        public Adapter caseValueComponent ( ValueComponent object )
        {
            return createValueComponentAdapter ();
        }

        @Override
        public Adapter caseCompositeTransformer ( CompositeTransformer object )
        {
            return createCompositeTransformerAdapter ();
        }

        @Override
        public Adapter caseAndTransformer ( AndTransformer object )
        {
            return createAndTransformerAdapter ();
        }

        @Override
        public Adapter caseOrTransformer ( OrTransformer object )
        {
            return createOrTransformerAdapter ();
        }

        @Override
        public Adapter caseTextInputComponent ( TextInputComponent object )
        {
            return createTextInputComponentAdapter ();
        }

        @Override
        public Adapter caseWriteableComponent ( WriteableComponent object )
        {
            return createWriteableComponentAdapter ();
        }

        @Override
        public Adapter caseReadableComponent ( ReadableComponent object )
        {
            return createReadableComponentAdapter ();
        }

        @Override
        public Adapter caseTextComponent ( TextComponent object )
        {
            return createTextComponentAdapter ();
        }

        @Override
        public Adapter caseTextInputMultiComponent ( TextInputMultiComponent object )
        {
            return createTextInputMultiComponentAdapter ();
        }

        @Override
        public Adapter caseCheckComponent ( CheckComponent object )
        {
            return createCheckComponentAdapter ();
        }

        @Override
        public Adapter caseLinkComponent ( LinkComponent object )
        {
            return createLinkComponentAdapter ();
        }

        @Override
        public Adapter caseURLImageComponent ( URLImageComponent object )
        {
            return createURLImageComponentAdapter ();
        }

        @Override
        public Adapter caseProgressComponent ( ProgressComponent object )
        {
            return createProgressComponentAdapter ();
        }

        @Override
        public Adapter caseHiddenComponent ( HiddenComponent object )
        {
            return createHiddenComponentAdapter ();
        }

        @Override
        public Adapter caseVisibility ( Visibility object )
        {
            return createVisibilityAdapter ();
        }

        @Override
        public Adapter caseScriptVisibility ( ScriptVisibility object )
        {
            return createScriptVisibilityAdapter ();
        }

        @Override
        public Adapter casePermissionVisibility ( PermissionVisibility object )
        {
            return createPermissionVisibilityAdapter ();
        }

        @Override
        public Adapter caseInvisible ( Invisible object )
        {
            return createInvisibleAdapter ();
        }

        @Override
        public Adapter caseTestVisibility ( TestVisibility object )
        {
            return createTestVisibilityAdapter ();
        }

        @Override
        public Adapter caseScriptModule ( ScriptModule object )
        {
            return createScriptModuleAdapter ();
        }

        @Override
        public Adapter caseBrowserComponent ( BrowserComponent object )
        {
            return createBrowserComponentAdapter ();
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
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.View <em>View</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.View
     * @generated
     */
    public Adapter createViewAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.Component <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.Component
     * @generated
     */
    public Adapter createComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.GroupEntry <em>Group Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.GroupEntry
     * @generated
     */
    public Adapter createGroupEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.LabelComponent <em>Label Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.LabelComponent
     * @generated
     */
    public Adapter createLabelComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.CompositeComponent <em>Composite Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.CompositeComponent
     * @generated
     */
    public Adapter createCompositeComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.FillLayoutComponent <em>Fill Layout Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.FillLayoutComponent
     * @generated
     */
    public Adapter createFillLayoutComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.ButtonComponent <em>Button Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.ButtonComponent
     * @generated
     */
    public Adapter createButtonComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.BoolLEDComponent <em>Bool LED Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.BoolLEDComponent
     * @generated
     */
    public Adapter createBoolLEDComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.ValueSource <em>Value Source</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.ValueSource
     * @generated
     */
    public Adapter createValueSourceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.ItemValueSource <em>Item Value Source</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.ItemValueSource
     * @generated
     */
    public Adapter createItemValueSourceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.NotTransformer <em>Not Transformer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.NotTransformer
     * @generated
     */
    public Adapter createNotTransformerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.GenericComponent <em>Generic Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.GenericComponent
     * @generated
     */
    public Adapter createGenericComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.Registration <em>Registration</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.Registration
     * @generated
     */
    public Adapter createRegistrationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.SimpleGridComponent <em>Simple Grid Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.SimpleGridComponent
     * @generated
     */
    public Adapter createSimpleGridComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.GroupGridComponent <em>Group Grid Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.GroupGridComponent
     * @generated
     */
    public Adapter createGroupGridComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.GroupGridEntry <em>Group Grid Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.GroupGridEntry
     * @generated
     */
    public Adapter createGroupGridEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.ValueSetComponent <em>Value Set Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.ValueSetComponent
     * @generated
     */
    public Adapter createValueSetComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.ValueComponent <em>Value Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.ValueComponent
     * @generated
     */
    public Adapter createValueComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.CompositeTransformer <em>Composite Transformer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.CompositeTransformer
     * @generated
     */
    public Adapter createCompositeTransformerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.AndTransformer <em>And Transformer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.AndTransformer
     * @generated
     */
    public Adapter createAndTransformerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.OrTransformer <em>Or Transformer</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.OrTransformer
     * @generated
     */
    public Adapter createOrTransformerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.TextInputComponent <em>Text Input Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.TextInputComponent
     * @generated
     */
    public Adapter createTextInputComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.WriteableComponent <em>Writeable Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.WriteableComponent
     * @generated
     */
    public Adapter createWriteableComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.ReadableComponent <em>Readable Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.ReadableComponent
     * @generated
     */
    public Adapter createReadableComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.TextComponent <em>Text Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.TextComponent
     * @generated
     */
    public Adapter createTextComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.TextInputMultiComponent <em>Text Input Multi Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.TextInputMultiComponent
     * @generated
     */
    public Adapter createTextInputMultiComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.CheckComponent <em>Check Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.CheckComponent
     * @generated
     */
    public Adapter createCheckComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.LinkComponent <em>Link Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.LinkComponent
     * @generated
     */
    public Adapter createLinkComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.URLImageComponent <em>URL Image Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.URLImageComponent
     * @generated
     */
    public Adapter createURLImageComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.ProgressComponent <em>Progress Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.ProgressComponent
     * @generated
     */
    public Adapter createProgressComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.HiddenComponent <em>Hidden Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.HiddenComponent
     * @generated
     */
    public Adapter createHiddenComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.Visibility <em>Visibility</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.Visibility
     * @generated
     */
    public Adapter createVisibilityAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.ScriptVisibility <em>Script Visibility</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.ScriptVisibility
     * @generated
     */
    public Adapter createScriptVisibilityAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.PermissionVisibility <em>Permission Visibility</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.PermissionVisibility
     * @generated
     */
    public Adapter createPermissionVisibilityAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.Invisible <em>Invisible</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.Invisible
     * @generated
     */
    public Adapter createInvisibleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.TestVisibility <em>Test Visibility</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.TestVisibility
     * @generated
     */
    public Adapter createTestVisibilityAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.ScriptModule <em>Script Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.ScriptModule
     * @generated
     */
    public Adapter createScriptModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.details.model.BrowserComponent <em>Browser Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.details.model.BrowserComponent
     * @generated
     */
    public Adapter createBrowserComponentAdapter ()
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

} //DetailViewAdapterFactory
