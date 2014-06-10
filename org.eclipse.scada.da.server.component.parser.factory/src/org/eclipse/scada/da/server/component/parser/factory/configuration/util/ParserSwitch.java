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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.scada.da.server.component.parser.factory.configuration.*;

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
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage
 * @generated
 */
public class ParserSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ParserPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ParserSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ParserPackage.eINSTANCE;
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
            case ParserPackage.COMPONENT:
            {
                Component component = (Component)theEObject;
                T result = caseComponent ( component );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.INPUT_DEFINITION:
            {
                InputDefinition inputDefinition = (InputDefinition)theEObject;
                T result = caseInputDefinition ( inputDefinition );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.FILE_INPUT:
            {
                FileInput fileInput = (FileInput)theEObject;
                T result = caseFileInput ( fileInput );
                if ( result == null )
                    result = caseAbstractPeriodInput ( fileInput );
                if ( result == null )
                    result = caseInputDefinition ( fileInput );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.EXTRACTOR_DEFINITION:
            {
                ExtractorDefinition extractorDefinition = (ExtractorDefinition)theEObject;
                T result = caseExtractorDefinition ( extractorDefinition );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.PLAIN_TEXT:
            {
                PlainText plainText = (PlainText)theEObject;
                T result = casePlainText ( plainText );
                if ( result == null )
                    result = caseExtractorDefinition ( plainText );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.ABSTRACT_PERIOD_INPUT:
            {
                AbstractPeriodInput abstractPeriodInput = (AbstractPeriodInput)theEObject;
                T result = caseAbstractPeriodInput ( abstractPeriodInput );
                if ( result == null )
                    result = caseInputDefinition ( abstractPeriodInput );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.URL_INPUT:
            {
                UrlInput urlInput = (UrlInput)theEObject;
                T result = caseUrlInput ( urlInput );
                if ( result == null )
                    result = caseAbstractPeriodInput ( urlInput );
                if ( result == null )
                    result = caseInputDefinition ( urlInput );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.SINGLE_PATTERN:
            {
                SinglePattern singlePattern = (SinglePattern)theEObject;
                T result = caseSinglePattern ( singlePattern );
                if ( result == null )
                    result = caseExtractorDefinition ( singlePattern );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.VALUE_DESCRIPTOR:
            {
                ValueDescriptor valueDescriptor = (ValueDescriptor)theEObject;
                T result = caseValueDescriptor ( valueDescriptor );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.FIELD:
            {
                Field field = (Field)theEObject;
                T result = caseField ( field );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.ATTRIBUTE_VALUE:
            {
                AttributeValue attributeValue = (AttributeValue)theEObject;
                T result = caseAttributeValue ( attributeValue );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.MAIN_GROUP_FIELD:
            {
                MainGroupField mainGroupField = (MainGroupField)theEObject;
                T result = caseMainGroupField ( mainGroupField );
                if ( result == null )
                    result = caseField ( mainGroupField );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.STRING_GROUP_FIELD:
            {
                StringGroupField stringGroupField = (StringGroupField)theEObject;
                T result = caseStringGroupField ( stringGroupField );
                if ( result == null )
                    result = caseField ( stringGroupField );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.NUMERIC_GROUP_FIELD:
            {
                NumericGroupField numericGroupField = (NumericGroupField)theEObject;
                T result = caseNumericGroupField ( numericGroupField );
                if ( result == null )
                    result = caseField ( numericGroupField );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ParserPackage.SPLIT_TABLE:
            {
                SplitTable splitTable = (SplitTable)theEObject;
                T result = caseSplitTable ( splitTable );
                if ( result == null )
                    result = caseExtractorDefinition ( splitTable );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
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
     * Returns the result of interpreting the object as an instance of '<em>Input Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Input Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInputDefinition ( InputDefinition object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>File Input</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>File Input</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFileInput ( FileInput object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Extractor Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Extractor Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExtractorDefinition ( ExtractorDefinition object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Plain Text</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Plain Text</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePlainText ( PlainText object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Period Input</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Period Input</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractPeriodInput ( AbstractPeriodInput object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Url Input</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Url Input</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUrlInput ( UrlInput object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Single Pattern</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Single Pattern</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSinglePattern ( SinglePattern object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Value Descriptor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Descriptor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseValueDescriptor ( ValueDescriptor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseField ( Field object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttributeValue ( AttributeValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Main Group Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Main Group Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMainGroupField ( MainGroupField object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String Group Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String Group Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStringGroupField ( StringGroupField object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Numeric Group Field</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Numeric Group Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNumericGroupField ( NumericGroupField object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Split Table</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Split Table</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSplitTable ( SplitTable object )
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

} //ParserSwitch
