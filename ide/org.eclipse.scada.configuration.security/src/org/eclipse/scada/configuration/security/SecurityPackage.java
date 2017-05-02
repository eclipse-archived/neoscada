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
package org.eclipse.scada.configuration.security;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.security.SecurityFactory
 * @model kind="package"
 * @generated
 */
public interface SecurityPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "security";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Security";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "security";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SecurityPackage eINSTANCE = org.eclipse.scada.configuration.security.impl.SecurityPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.RuleImpl <em>Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.RuleImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getRule()
     * @generated
     */
    int RULE = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RULE__ID = 0;

    /**
     * The feature id for the '<em><b>Id Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RULE__ID_FILTER = 1;

    /**
     * The feature id for the '<em><b>Action Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RULE__ACTION_FILTER = 2;

    /**
     * The feature id for the '<em><b>Type Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RULE__TYPE_FILTER = 3;

    /**
     * The feature id for the '<em><b>Filter Script</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RULE__FILTER_SCRIPT = 4;

    /**
     * The number of structural features of the '<em>Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RULE_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.ScriptRuleImpl <em>Script Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.ScriptRuleImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getScriptRule()
     * @generated
     */
    int SCRIPT_RULE = 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_RULE__ID = RULE__ID;

    /**
     * The feature id for the '<em><b>Id Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_RULE__ID_FILTER = RULE__ID_FILTER;

    /**
     * The feature id for the '<em><b>Action Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_RULE__ACTION_FILTER = RULE__ACTION_FILTER;

    /**
     * The feature id for the '<em><b>Type Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_RULE__TYPE_FILTER = RULE__TYPE_FILTER;

    /**
     * The feature id for the '<em><b>Filter Script</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_RULE__FILTER_SCRIPT = RULE__FILTER_SCRIPT;

    /**
     * The feature id for the '<em><b>Script</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_RULE__SCRIPT = RULE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Callback Script</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_RULE__CALLBACK_SCRIPT = RULE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Script Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.LogonRuleImpl <em>Logon Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.LogonRuleImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getLogonRule()
     * @generated
     */
    int LOGON_RULE = 2;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOGON_RULE__ID = RULE__ID;

    /**
     * The feature id for the '<em><b>Id Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOGON_RULE__ID_FILTER = RULE__ID_FILTER;

    /**
     * The feature id for the '<em><b>Action Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOGON_RULE__ACTION_FILTER = RULE__ACTION_FILTER;

    /**
     * The feature id for the '<em><b>Type Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOGON_RULE__TYPE_FILTER = RULE__TYPE_FILTER;

    /**
     * The feature id for the '<em><b>Filter Script</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOGON_RULE__FILTER_SCRIPT = RULE__FILTER_SCRIPT;

    /**
     * The number of structural features of the '<em>Logon Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOGON_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.SignatureRuleImpl <em>Signature Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.SignatureRuleImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getSignatureRule()
     * @generated
     */
    int SIGNATURE_RULE = 3;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE__ID = RULE__ID;

    /**
     * The feature id for the '<em><b>Id Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE__ID_FILTER = RULE__ID_FILTER;

    /**
     * The feature id for the '<em><b>Action Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE__ACTION_FILTER = RULE__ACTION_FILTER;

    /**
     * The feature id for the '<em><b>Type Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE__TYPE_FILTER = RULE__TYPE_FILTER;

    /**
     * The feature id for the '<em><b>Filter Script</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE__FILTER_SCRIPT = RULE__FILTER_SCRIPT;

    /**
     * The feature id for the '<em><b>Trusted Certification Authority</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE__TRUSTED_CERTIFICATION_AUTHORITY = RULE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Indent Xml</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE__INDENT_XML = RULE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Post Processor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE__POST_PROCESSOR = RULE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Reload Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE__RELOAD_PERIOD = RULE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Signature Rule</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SIGNATURE_RULE_FEATURE_COUNT = RULE_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.ScriptImpl <em>Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.ScriptImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getScript()
     * @generated
     */
    int SCRIPT = 4;

    /**
     * The feature id for the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT__SOURCE = 0;

    /**
     * The number of structural features of the '<em>Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.JavaScriptImpl <em>Java Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.JavaScriptImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getJavaScript()
     * @generated
     */
    int JAVA_SCRIPT = 5;

    /**
     * The feature id for the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT__SOURCE = SCRIPT__SOURCE;

    /**
     * The number of structural features of the '<em>Java Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int JAVA_SCRIPT_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.GenericScriptImpl <em>Generic Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.GenericScriptImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getGenericScript()
     * @generated
     */
    int GENERIC_SCRIPT = 6;

    /**
     * The feature id for the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SCRIPT__SOURCE = SCRIPT__SOURCE;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SCRIPT__TYPE = SCRIPT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Generic Script</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GENERIC_SCRIPT_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.RulesImpl <em>Rules</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.RulesImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getRules()
     * @generated
     */
    int RULES = 8;

    /**
     * The feature id for the '<em><b>Rules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RULES__RULES = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RULES__NAME = 1;

    /**
     * The number of structural features of the '<em>Rules</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RULES_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.ConfigurationImpl <em>Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.ConfigurationImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getConfiguration()
     * @generated
     */
    int CONFIGURATION = 7;

    /**
     * The feature id for the '<em><b>Rules</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION__RULES = RULES__RULES;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION__NAME = RULES__NAME;

    /**
     * The feature id for the '<em><b>Scripts</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION__SCRIPTS = RULES_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONFIGURATION_FEATURE_COUNT = RULES_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.security.impl.CAImpl <em>CA</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.security.impl.CAImpl
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getCA()
     * @generated
     */
    int CA = 9;

    /**
     * The feature id for the '<em><b>Certificate Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CA__CERTIFICATE_URL = 0;

    /**
     * The feature id for the '<em><b>Crl Url</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CA__CRL_URL = 1;

    /**
     * The number of structural features of the '<em>CA</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CA_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '<em>Pattern</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.regex.Pattern
     * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getPattern()
     * @generated
     */
    int PATTERN = 10;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.Rule <em>Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rule</em>'.
     * @see org.eclipse.scada.configuration.security.Rule
     * @generated
     */
    EClass getRule ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.Rule#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.configuration.security.Rule#getId()
     * @see #getRule()
     * @generated
     */
    EAttribute getRule_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.Rule#getIdFilter <em>Id Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id Filter</em>'.
     * @see org.eclipse.scada.configuration.security.Rule#getIdFilter()
     * @see #getRule()
     * @generated
     */
    EAttribute getRule_IdFilter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.Rule#getActionFilter <em>Action Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Action Filter</em>'.
     * @see org.eclipse.scada.configuration.security.Rule#getActionFilter()
     * @see #getRule()
     * @generated
     */
    EAttribute getRule_ActionFilter ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.Rule#getTypeFilter <em>Type Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type Filter</em>'.
     * @see org.eclipse.scada.configuration.security.Rule#getTypeFilter()
     * @see #getRule()
     * @generated
     */
    EAttribute getRule_TypeFilter ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.security.Rule#getFilterScript <em>Filter Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Filter Script</em>'.
     * @see org.eclipse.scada.configuration.security.Rule#getFilterScript()
     * @see #getRule()
     * @generated
     */
    EReference getRule_FilterScript ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.ScriptRule <em>Script Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script Rule</em>'.
     * @see org.eclipse.scada.configuration.security.ScriptRule
     * @generated
     */
    EClass getScriptRule ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.security.ScriptRule#getScript <em>Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Script</em>'.
     * @see org.eclipse.scada.configuration.security.ScriptRule#getScript()
     * @see #getScriptRule()
     * @generated
     */
    EReference getScriptRule_Script ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.security.ScriptRule#getCallbackScript <em>Callback Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Callback Script</em>'.
     * @see org.eclipse.scada.configuration.security.ScriptRule#getCallbackScript()
     * @see #getScriptRule()
     * @generated
     */
    EReference getScriptRule_CallbackScript ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.LogonRule <em>Logon Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Logon Rule</em>'.
     * @see org.eclipse.scada.configuration.security.LogonRule
     * @generated
     */
    EClass getLogonRule ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.SignatureRule <em>Signature Rule</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Signature Rule</em>'.
     * @see org.eclipse.scada.configuration.security.SignatureRule
     * @generated
     */
    EClass getSignatureRule ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.security.SignatureRule#getTrustedCertificationAuthority <em>Trusted Certification Authority</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Trusted Certification Authority</em>'.
     * @see org.eclipse.scada.configuration.security.SignatureRule#getTrustedCertificationAuthority()
     * @see #getSignatureRule()
     * @generated
     */
    EReference getSignatureRule_TrustedCertificationAuthority ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.SignatureRule#isIndentXml <em>Indent Xml</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Indent Xml</em>'.
     * @see org.eclipse.scada.configuration.security.SignatureRule#isIndentXml()
     * @see #getSignatureRule()
     * @generated
     */
    EAttribute getSignatureRule_IndentXml ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.security.SignatureRule#getPostProcessor <em>Post Processor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Post Processor</em>'.
     * @see org.eclipse.scada.configuration.security.SignatureRule#getPostProcessor()
     * @see #getSignatureRule()
     * @generated
     */
    EReference getSignatureRule_PostProcessor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.SignatureRule#getReloadPeriod <em>Reload Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Reload Period</em>'.
     * @see org.eclipse.scada.configuration.security.SignatureRule#getReloadPeriod()
     * @see #getSignatureRule()
     * @generated
     */
    EAttribute getSignatureRule_ReloadPeriod ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.Script <em>Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script</em>'.
     * @see org.eclipse.scada.configuration.security.Script
     * @generated
     */
    EClass getScript ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.Script#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Source</em>'.
     * @see org.eclipse.scada.configuration.security.Script#getSource()
     * @see #getScript()
     * @generated
     */
    EAttribute getScript_Source ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.JavaScript <em>Java Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Java Script</em>'.
     * @see org.eclipse.scada.configuration.security.JavaScript
     * @generated
     */
    EClass getJavaScript ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.GenericScript <em>Generic Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Generic Script</em>'.
     * @see org.eclipse.scada.configuration.security.GenericScript
     * @generated
     */
    EClass getGenericScript ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.GenericScript#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.scada.configuration.security.GenericScript#getType()
     * @see #getGenericScript()
     * @generated
     */
    EAttribute getGenericScript_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.Configuration <em>Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Configuration</em>'.
     * @see org.eclipse.scada.configuration.security.Configuration
     * @generated
     */
    EClass getConfiguration ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.security.Configuration#getScripts <em>Scripts</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Scripts</em>'.
     * @see org.eclipse.scada.configuration.security.Configuration#getScripts()
     * @see #getConfiguration()
     * @generated
     */
    EReference getConfiguration_Scripts ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.Rules <em>Rules</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rules</em>'.
     * @see org.eclipse.scada.configuration.security.Rules
     * @generated
     */
    EClass getRules ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.security.Rules#getRules <em>Rules</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Rules</em>'.
     * @see org.eclipse.scada.configuration.security.Rules#getRules()
     * @see #getRules()
     * @generated
     */
    EReference getRules_Rules ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.Rules#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.security.Rules#getName()
     * @see #getRules()
     * @generated
     */
    EAttribute getRules_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.security.CA <em>CA</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>CA</em>'.
     * @see org.eclipse.scada.configuration.security.CA
     * @generated
     */
    EClass getCA ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.security.CA#getCertificateUrl <em>Certificate Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Certificate Url</em>'.
     * @see org.eclipse.scada.configuration.security.CA#getCertificateUrl()
     * @see #getCA()
     * @generated
     */
    EAttribute getCA_CertificateUrl ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.security.CA#getCrlUrl <em>Crl Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Crl Url</em>'.
     * @see org.eclipse.scada.configuration.security.CA#getCrlUrl()
     * @see #getCA()
     * @generated
     */
    EAttribute getCA_CrlUrl ();

    /**
     * Returns the meta object for data type '{@link java.util.regex.Pattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Pattern</em>'.
     * @see java.util.regex.Pattern
     * @model instanceClass="java.util.regex.Pattern"
     * @generated
     */
    EDataType getPattern ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    SecurityFactory getSecurityFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.RuleImpl <em>Rule</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.RuleImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getRule()
         * @generated
         */
        EClass RULE = eINSTANCE.getRule ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RULE__ID = eINSTANCE.getRule_Id ();

        /**
         * The meta object literal for the '<em><b>Id Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RULE__ID_FILTER = eINSTANCE.getRule_IdFilter ();

        /**
         * The meta object literal for the '<em><b>Action Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RULE__ACTION_FILTER = eINSTANCE.getRule_ActionFilter ();

        /**
         * The meta object literal for the '<em><b>Type Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RULE__TYPE_FILTER = eINSTANCE.getRule_TypeFilter ();

        /**
         * The meta object literal for the '<em><b>Filter Script</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RULE__FILTER_SCRIPT = eINSTANCE.getRule_FilterScript ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.ScriptRuleImpl <em>Script Rule</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.ScriptRuleImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getScriptRule()
         * @generated
         */
        EClass SCRIPT_RULE = eINSTANCE.getScriptRule ();

        /**
         * The meta object literal for the '<em><b>Script</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_RULE__SCRIPT = eINSTANCE.getScriptRule_Script ();

        /**
         * The meta object literal for the '<em><b>Callback Script</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_RULE__CALLBACK_SCRIPT = eINSTANCE.getScriptRule_CallbackScript ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.LogonRuleImpl <em>Logon Rule</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.LogonRuleImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getLogonRule()
         * @generated
         */
        EClass LOGON_RULE = eINSTANCE.getLogonRule ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.SignatureRuleImpl <em>Signature Rule</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.SignatureRuleImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getSignatureRule()
         * @generated
         */
        EClass SIGNATURE_RULE = eINSTANCE.getSignatureRule ();

        /**
         * The meta object literal for the '<em><b>Trusted Certification Authority</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIGNATURE_RULE__TRUSTED_CERTIFICATION_AUTHORITY = eINSTANCE.getSignatureRule_TrustedCertificationAuthority ();

        /**
         * The meta object literal for the '<em><b>Indent Xml</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIGNATURE_RULE__INDENT_XML = eINSTANCE.getSignatureRule_IndentXml ();

        /**
         * The meta object literal for the '<em><b>Post Processor</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SIGNATURE_RULE__POST_PROCESSOR = eINSTANCE.getSignatureRule_PostProcessor ();

        /**
         * The meta object literal for the '<em><b>Reload Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SIGNATURE_RULE__RELOAD_PERIOD = eINSTANCE.getSignatureRule_ReloadPeriod ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.ScriptImpl <em>Script</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.ScriptImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getScript()
         * @generated
         */
        EClass SCRIPT = eINSTANCE.getScript ();

        /**
         * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCRIPT__SOURCE = eINSTANCE.getScript_Source ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.JavaScriptImpl <em>Java Script</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.JavaScriptImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getJavaScript()
         * @generated
         */
        EClass JAVA_SCRIPT = eINSTANCE.getJavaScript ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.GenericScriptImpl <em>Generic Script</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.GenericScriptImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getGenericScript()
         * @generated
         */
        EClass GENERIC_SCRIPT = eINSTANCE.getGenericScript ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GENERIC_SCRIPT__TYPE = eINSTANCE.getGenericScript_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.ConfigurationImpl <em>Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.ConfigurationImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getConfiguration()
         * @generated
         */
        EClass CONFIGURATION = eINSTANCE.getConfiguration ();

        /**
         * The meta object literal for the '<em><b>Scripts</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONFIGURATION__SCRIPTS = eINSTANCE.getConfiguration_Scripts ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.RulesImpl <em>Rules</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.RulesImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getRules()
         * @generated
         */
        EClass RULES = eINSTANCE.getRules ();

        /**
         * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RULES__RULES = eINSTANCE.getRules_Rules ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RULES__NAME = eINSTANCE.getRules_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.security.impl.CAImpl <em>CA</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.security.impl.CAImpl
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getCA()
         * @generated
         */
        EClass CA = eINSTANCE.getCA ();

        /**
         * The meta object literal for the '<em><b>Certificate Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CA__CERTIFICATE_URL = eINSTANCE.getCA_CertificateUrl ();

        /**
         * The meta object literal for the '<em><b>Crl Url</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CA__CRL_URL = eINSTANCE.getCA_CrlUrl ();

        /**
         * The meta object literal for the '<em>Pattern</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.util.regex.Pattern
         * @see org.eclipse.scada.configuration.security.impl.SecurityPackageImpl#getPattern()
         * @generated
         */
        EDataType PATTERN = eINSTANCE.getPattern ();

    }

} //SecurityPackage
