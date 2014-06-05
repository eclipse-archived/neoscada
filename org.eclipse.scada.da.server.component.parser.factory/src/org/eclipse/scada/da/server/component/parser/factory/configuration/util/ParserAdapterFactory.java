/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.da.server.component.parser.factory.configuration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage
 * @generated
 */
public class ParserAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ParserPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ParserAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ParserPackage.eINSTANCE;
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
    protected ParserSwitch<Adapter> modelSwitch =
            new ParserSwitch<Adapter> ()
            {
                @Override
                public Adapter caseComponent ( Component object )
                {
                    return createComponentAdapter ();
                }

                @Override
                public Adapter caseInputDefinition ( InputDefinition object )
                {
                    return createInputDefinitionAdapter ();
                }

                @Override
                public Adapter caseFileInput ( FileInput object )
                {
                    return createFileInputAdapter ();
                }

                @Override
                public Adapter caseExtractorDefinition ( ExtractorDefinition object )
                {
                    return createExtractorDefinitionAdapter ();
                }

                @Override
                public Adapter casePlainText ( PlainText object )
                {
                    return createPlainTextAdapter ();
                }

                @Override
                public Adapter caseAbstractPeriodInput ( AbstractPeriodInput object )
                {
                    return createAbstractPeriodInputAdapter ();
                }

                @Override
                public Adapter caseUrlInput ( UrlInput object )
                {
                    return createUrlInputAdapter ();
                }

                @Override
                public Adapter caseSinglePattern ( SinglePattern object )
                {
                    return createSinglePatternAdapter ();
                }

                @Override
                public Adapter caseValueDescriptor ( ValueDescriptor object )
                {
                    return createValueDescriptorAdapter ();
                }

                @Override
                public Adapter caseField ( Field object )
                {
                    return createFieldAdapter ();
                }

                @Override
                public Adapter caseAttributeValue ( AttributeValue object )
                {
                    return createAttributeValueAdapter ();
                }

                @Override
                public Adapter caseMainGroupField ( MainGroupField object )
                {
                    return createMainGroupFieldAdapter ();
                }

                @Override
                public Adapter caseStringGroupField ( StringGroupField object )
                {
                    return createStringGroupFieldAdapter ();
                }

                @Override
                public Adapter caseNumericGroupField ( NumericGroupField object )
                {
                    return createNumericGroupFieldAdapter ();
                }

                @Override
                public Adapter caseSplitTable ( SplitTable object )
                {
                    return createSplitTableAdapter ();
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
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.Component
     * @generated
     */
    public Adapter createComponentAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition <em>Input Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition
     * @generated
     */
    public Adapter createInputDefinitionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.FileInput <em>File Input</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.FileInput
     * @generated
     */
    public Adapter createFileInputAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition <em>Extractor Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition
     * @generated
     */
    public Adapter createExtractorDefinitionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText <em>Plain Text</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText
     * @generated
     */
    public Adapter createPlainTextAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractPeriodInput <em>Abstract Period Input</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractPeriodInput
     * @generated
     */
    public Adapter createAbstractPeriodInputAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput <em>Url Input</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput
     * @generated
     */
    public Adapter createUrlInputAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern <em>Single Pattern</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern
     * @generated
     */
    public Adapter createSinglePatternAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ValueDescriptor <em>Value Descriptor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ValueDescriptor
     * @generated
     */
    public Adapter createValueDescriptorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Field <em>Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.Field
     * @generated
     */
    public Adapter createFieldAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.AttributeValue <em>Attribute Value</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.AttributeValue
     * @generated
     */
    public Adapter createAttributeValueAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.MainGroupField <em>Main Group Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.MainGroupField
     * @generated
     */
    public Adapter createMainGroupFieldAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.StringGroupField <em>String Group Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.StringGroupField
     * @generated
     */
    public Adapter createStringGroupFieldAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.NumericGroupField <em>Numeric Group Field</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.NumericGroupField
     * @generated
     */
    public Adapter createNumericGroupFieldAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable <em>Split Table</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable
     * @generated
     */
    public Adapter createSplitTableAdapter ()
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

} //ParserAdapterFactory
