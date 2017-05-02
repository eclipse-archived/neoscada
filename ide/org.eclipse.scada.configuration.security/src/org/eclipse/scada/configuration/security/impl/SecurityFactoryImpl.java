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
package org.eclipse.scada.configuration.security.impl;

import java.util.regex.Pattern;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.security.CA;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.security.GenericScript;
import org.eclipse.scada.configuration.security.JavaScript;
import org.eclipse.scada.configuration.security.LogonRule;
import org.eclipse.scada.configuration.security.Rules;
import org.eclipse.scada.configuration.security.ScriptRule;
import org.eclipse.scada.configuration.security.SecurityFactory;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.security.SignatureRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecurityFactoryImpl extends EFactoryImpl implements SecurityFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static SecurityFactory init ()
    {
        try
        {
            SecurityFactory theSecurityFactory = (SecurityFactory)EPackage.Registry.INSTANCE.getEFactory ( SecurityPackage.eNS_URI );
            if ( theSecurityFactory != null )
            {
                return theSecurityFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new SecurityFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SecurityFactoryImpl ()
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
            case SecurityPackage.SCRIPT_RULE:
                return createScriptRule ();
            case SecurityPackage.LOGON_RULE:
                return createLogonRule ();
            case SecurityPackage.SIGNATURE_RULE:
                return createSignatureRule ();
            case SecurityPackage.JAVA_SCRIPT:
                return createJavaScript ();
            case SecurityPackage.GENERIC_SCRIPT:
                return createGenericScript ();
            case SecurityPackage.CONFIGURATION:
                return createConfiguration ();
            case SecurityPackage.RULES:
                return createRules ();
            case SecurityPackage.CA:
                return createCA ();
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
            case SecurityPackage.PATTERN:
                return createPatternFromString ( eDataType, initialValue );
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
            case SecurityPackage.PATTERN:
                return convertPatternToString ( eDataType, instanceValue );
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
    public ScriptRule createScriptRule ()
    {
        ScriptRuleImpl scriptRule = new ScriptRuleImpl ();
        return scriptRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public LogonRule createLogonRule ()
    {
        LogonRuleImpl logonRule = new LogonRuleImpl ();
        return logonRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public SignatureRule createSignatureRule ()
    {
        SignatureRuleImpl signatureRule = new SignatureRuleImpl ();
        return signatureRule;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaScript createJavaScript ()
    {
        JavaScriptImpl javaScript = new JavaScriptImpl ();
        return javaScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GenericScript createGenericScript ()
    {
        GenericScriptImpl genericScript = new GenericScriptImpl ();
        return genericScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Configuration createConfiguration ()
    {
        ConfigurationImpl configuration = new ConfigurationImpl ();
        return configuration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Rules createRules ()
    {
        RulesImpl rules = new RulesImpl ();
        return rules;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CA createCA ()
    {
        CAImpl ca = new CAImpl ();
        return ca;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Pattern createPatternFromString ( final EDataType eDataType, final String initialValue )
    {
        return Pattern.compile ( initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPatternToString ( EDataType eDataType, Object instanceValue )
    {
        return super.convertToString ( eDataType, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public SecurityPackage getSecurityPackage ()
    {
        return (SecurityPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SecurityPackage getPackage ()
    {
        return SecurityPackage.eINSTANCE;
    }

} //SecurityFactoryImpl
