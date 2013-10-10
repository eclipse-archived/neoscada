/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.common.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeUtil;
import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;
import org.eclipse.scada.common.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.common.CommonPackage
 * @generated
 */
public class CommonValidator extends EObjectValidator
{
   

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final CommonValidator INSTANCE = new CommonValidator ();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.scada.common";

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * The cached base package validator.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected XMLTypeValidator xmlTypeValidator;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommonValidator ()
    {
        super ();
        xmlTypeValidator = XMLTypeValidator.INSTANCE;
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage ()
    {
        return CommonPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate ( int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        switch ( classifierID )
        {
            case CommonPackage.ATTRIBUTES_TYPE:
                return validateAttributesType ( (AttributesType)value, diagnostics, context );
            case CommonPackage.ATTRIBUTE_TYPE:
                return validateAttributeType ( (AttributeType)value, diagnostics, context );
            case CommonPackage.VARIANT_BOOLEAN_TYPE:
                return validateVariantBooleanType ( (VariantBooleanType)value, diagnostics, context );
            case CommonPackage.VARIANT_DOUBLE_TYPE:
                return validateVariantDoubleType ( (VariantDoubleType)value, diagnostics, context );
            case CommonPackage.VARIANT_INT32_TYPE:
                return validateVariantInt32Type ( (VariantInt32Type)value, diagnostics, context );
            case CommonPackage.VARIANT_INT64_TYPE:
                return validateVariantInt64Type ( (VariantInt64Type)value, diagnostics, context );
            case CommonPackage.VARIANT_NULL_TYPE:
                return validateVariantNullType ( (VariantNullType)value, diagnostics, context );
            case CommonPackage.VARIANT_TYPE:
                return validateVariantType ( (VariantType)value, diagnostics, context );
            case CommonPackage.CLASS_TYPE:
                return validateClassType ( (String)value, diagnostics, context );
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAttributesType ( AttributesType attributesType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( attributesType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAttributeType ( AttributeType attributeType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( attributeType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariantBooleanType ( VariantBooleanType variantBooleanType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( variantBooleanType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariantDoubleType ( VariantDoubleType variantDoubleType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( variantDoubleType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariantInt32Type ( VariantInt32Type variantInt32Type, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( variantInt32Type, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariantInt64Type ( VariantInt64Type variantInt64Type, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( variantInt64Type, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariantNullType ( VariantNullType variantNullType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( variantNullType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateVariantType ( VariantType variantType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( variantType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateClassType ( String classType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        boolean result = validateClassType_Pattern ( classType, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @see #validateClassType_Pattern
     */
    public static final PatternMatcher[][] CLASS_TYPE__PATTERN__VALUES = new PatternMatcher[][] { new PatternMatcher[] { XMLTypeUtil.createPatternMatcher ( "[a-zA-Z]+(\\.[a-zA-Z0-9]+)*" ) } };

    /**
     * Validates the Pattern constraint of '<em>Class Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateClassType_Pattern ( String classType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validatePattern ( CommonPackage.Literals.CLASS_TYPE, classType, CLASS_TYPE__PATTERN__VALUES, diagnostics, context );
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator ();
    }

} //CommonValidator
