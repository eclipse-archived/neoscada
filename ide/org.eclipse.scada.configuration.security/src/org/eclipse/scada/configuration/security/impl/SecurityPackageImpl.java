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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.security.GenericScript;
import org.eclipse.scada.configuration.security.JavaScript;
import org.eclipse.scada.configuration.security.LogonRule;
import org.eclipse.scada.configuration.security.Rule;
import org.eclipse.scada.configuration.security.Rules;
import org.eclipse.scada.configuration.security.Script;
import org.eclipse.scada.configuration.security.ScriptRule;
import org.eclipse.scada.configuration.security.SecurityFactory;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.security.SignatureRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SecurityPackageImpl extends EPackageImpl implements SecurityPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass ruleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass logonRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass signatureRuleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass javaScriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genericScriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass configurationEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rulesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass caEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType patternEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.configuration.security.SecurityPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SecurityPackageImpl ()
    {
        super ( eNS_URI, SecurityFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link SecurityPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SecurityPackage init ()
    {
        if ( isInited )
            return (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage ( SecurityPackage.eNS_URI );

        // Obtain or create and register package
        SecurityPackageImpl theSecurityPackage = (SecurityPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof SecurityPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new SecurityPackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theSecurityPackage.createPackageContents ();

        // Initialize created meta-data
        theSecurityPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theSecurityPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( SecurityPackage.eNS_URI, theSecurityPackage );
        return theSecurityPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRule ()
    {
        return ruleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRule_Id ()
    {
        return (EAttribute)ruleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRule_IdFilter ()
    {
        return (EAttribute)ruleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRule_ActionFilter ()
    {
        return (EAttribute)ruleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRule_TypeFilter ()
    {
        return (EAttribute)ruleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRule_FilterScript ()
    {
        return (EReference)ruleEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScriptRule ()
    {
        return scriptRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScriptRule_Script ()
    {
        return (EReference)scriptRuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScriptRule_CallbackScript ()
    {
        return (EReference)scriptRuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLogonRule ()
    {
        return logonRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSignatureRule ()
    {
        return signatureRuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSignatureRule_TrustedCertificationAuthority ()
    {
        return (EReference)signatureRuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSignatureRule_IndentXml ()
    {
        return (EAttribute)signatureRuleEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSignatureRule_PostProcessor ()
    {
        return (EReference)signatureRuleEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSignatureRule_ReloadPeriod ()
    {
        return (EAttribute)signatureRuleEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScript ()
    {
        return scriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScript_Source ()
    {
        return (EAttribute)scriptEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJavaScript ()
    {
        return javaScriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenericScript ()
    {
        return genericScriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenericScript_Type ()
    {
        return (EAttribute)genericScriptEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConfiguration ()
    {
        return configurationEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConfiguration_Scripts ()
    {
        return (EReference)configurationEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRules ()
    {
        return rulesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRules_Rules ()
    {
        return (EReference)rulesEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRules_Name ()
    {
        return (EAttribute)rulesEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCA ()
    {
        return caEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCA_CertificateUrl ()
    {
        return (EAttribute)caEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCA_CrlUrl ()
    {
        return (EAttribute)caEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getPattern ()
    {
        return patternEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SecurityFactory getSecurityFactory ()
    {
        return (SecurityFactory)getEFactoryInstance ();
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
        ruleEClass = createEClass ( RULE );
        createEAttribute ( ruleEClass, RULE__ID );
        createEAttribute ( ruleEClass, RULE__ID_FILTER );
        createEAttribute ( ruleEClass, RULE__ACTION_FILTER );
        createEAttribute ( ruleEClass, RULE__TYPE_FILTER );
        createEReference ( ruleEClass, RULE__FILTER_SCRIPT );

        scriptRuleEClass = createEClass ( SCRIPT_RULE );
        createEReference ( scriptRuleEClass, SCRIPT_RULE__SCRIPT );
        createEReference ( scriptRuleEClass, SCRIPT_RULE__CALLBACK_SCRIPT );

        logonRuleEClass = createEClass ( LOGON_RULE );

        signatureRuleEClass = createEClass ( SIGNATURE_RULE );
        createEReference ( signatureRuleEClass, SIGNATURE_RULE__TRUSTED_CERTIFICATION_AUTHORITY );
        createEAttribute ( signatureRuleEClass, SIGNATURE_RULE__INDENT_XML );
        createEReference ( signatureRuleEClass, SIGNATURE_RULE__POST_PROCESSOR );
        createEAttribute ( signatureRuleEClass, SIGNATURE_RULE__RELOAD_PERIOD );

        scriptEClass = createEClass ( SCRIPT );
        createEAttribute ( scriptEClass, SCRIPT__SOURCE );

        javaScriptEClass = createEClass ( JAVA_SCRIPT );

        genericScriptEClass = createEClass ( GENERIC_SCRIPT );
        createEAttribute ( genericScriptEClass, GENERIC_SCRIPT__TYPE );

        configurationEClass = createEClass ( CONFIGURATION );
        createEReference ( configurationEClass, CONFIGURATION__SCRIPTS );

        rulesEClass = createEClass ( RULES );
        createEReference ( rulesEClass, RULES__RULES );
        createEAttribute ( rulesEClass, RULES__NAME );

        caEClass = createEClass ( CA );
        createEAttribute ( caEClass, CA__CERTIFICATE_URL );
        createEAttribute ( caEClass, CA__CRL_URL );

        // Create data types
        patternEDataType = createEDataType ( PATTERN );
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
        scriptRuleEClass.getESuperTypes ().add ( this.getRule () );
        logonRuleEClass.getESuperTypes ().add ( this.getRule () );
        signatureRuleEClass.getESuperTypes ().add ( this.getRule () );
        javaScriptEClass.getESuperTypes ().add ( this.getScript () );
        genericScriptEClass.getESuperTypes ().add ( this.getScript () );
        configurationEClass.getESuperTypes ().add ( this.getRules () );

        // Initialize classes and features; add operations and parameters
        initEClass ( ruleEClass, Rule.class, "Rule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getRule_Id (), ecorePackage.getEString (), "id", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRule_IdFilter (), this.getPattern (), "idFilter", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRule_ActionFilter (), this.getPattern (), "actionFilter", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRule_TypeFilter (), this.getPattern (), "typeFilter", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getRule_FilterScript (), this.getScript (), null, "filterScript", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        addEOperation ( ruleEClass, ecorePackage.getEString (), "getRuleType", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( scriptRuleEClass, ScriptRule.class, "ScriptRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScriptRule_Script (), this.getScript (), null, "script", null, 0, 1, ScriptRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getScriptRule_CallbackScript (), this.getScript (), null, "callbackScript", null, 0, 1, ScriptRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( logonRuleEClass, LogonRule.class, "LogonRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( signatureRuleEClass, SignatureRule.class, "SignatureRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSignatureRule_TrustedCertificationAuthority (), this.getCA (), null, "trustedCertificationAuthority", null, 0, -1, SignatureRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSignatureRule_IndentXml (), ecorePackage.getEBoolean (), "indentXml", "false", 1, 1, SignatureRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getSignatureRule_PostProcessor (), this.getScript (), null, "postProcessor", null, 0, 1, SignatureRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSignatureRule_ReloadPeriod (), ecorePackage.getEInt (), "reloadPeriod", "0", 1, 1, SignatureRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( scriptEClass, Script.class, "Script", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScript_Source (), ecorePackage.getEString (), "source", null, 1, 1, Script.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        addEOperation ( scriptEClass, ecorePackage.getEString (), "getType", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( javaScriptEClass, JavaScript.class, "JavaScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( genericScriptEClass, GenericScript.class, "GenericScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getGenericScript_Type (), ecorePackage.getEString (), "type", "JavaScript", 1, 1, GenericScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getConfiguration_Scripts (), this.getScript (), null, "scripts", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( rulesEClass, Rules.class, "Rules", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getRules_Rules (), this.getRule (), null, "rules", null, 0, -1, Rules.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRules_Name (), ecorePackage.getEString (), "name", null, 0, 1, Rules.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( caEClass, org.eclipse.scada.configuration.security.CA.class, "CA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCA_CertificateUrl (), ecorePackage.getEString (), "certificateUrl", null, 1, 1, org.eclipse.scada.configuration.security.CA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCA_CrlUrl (), ecorePackage.getEString (), "crlUrl", null, 0, -1, org.eclipse.scada.configuration.security.CA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize data types
        initEDataType ( patternEDataType, Pattern.class, "Pattern", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //SecurityPackageImpl
