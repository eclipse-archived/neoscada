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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.security.SignatureRule#getTrustedCertificationAuthority <em>Trusted Certification Authority</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.SignatureRule#isIndentXml <em>Indent Xml</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.SignatureRule#getPostProcessor <em>Post Processor</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.SignatureRule#getReloadPeriod <em>Reload Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.security.SecurityPackage#getSignatureRule()
 * @model
 * @generated
 */
public interface SignatureRule extends Rule
{

    /**
     * Returns the value of the '<em><b>Trusted Certification Authority</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.security.CA}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Trusted Certification Authority</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Trusted Certification Authority</em>' containment reference list.
     * @see org.eclipse.scada.configuration.security.SecurityPackage#getSignatureRule_TrustedCertificationAuthority()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<CA> getTrustedCertificationAuthority ();

    /**
     * Returns the value of the '<em><b>Indent Xml</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Indent Xml</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Indent Xml</em>' attribute.
     * @see #setIndentXml(boolean)
     * @see org.eclipse.scada.configuration.security.SecurityPackage#getSignatureRule_IndentXml()
     * @model default="false" required="true"
     * @generated
     */
    boolean isIndentXml ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.security.SignatureRule#isIndentXml <em>Indent Xml</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Indent Xml</em>' attribute.
     * @see #isIndentXml()
     * @generated
     */
    void setIndentXml ( boolean value );

    /**
     * Returns the value of the '<em><b>Post Processor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Post Processor</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Post Processor</em>' reference.
     * @see #setPostProcessor(Script)
     * @see org.eclipse.scada.configuration.security.SecurityPackage#getSignatureRule_PostProcessor()
     * @model
     * @generated
     */
    Script getPostProcessor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.security.SignatureRule#getPostProcessor <em>Post Processor</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Post Processor</em>' reference.
     * @see #getPostProcessor()
     * @generated
     */
    void setPostProcessor ( Script value );

    /**
     * Returns the value of the '<em><b>Reload Period</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The period (milliseconds) in which all CAs will be reloaded.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Reload Period</em>' attribute.
     * @see #setReloadPeriod(int)
     * @see org.eclipse.scada.configuration.security.SecurityPackage#getSignatureRule_ReloadPeriod()
     * @model default="0" required="true"
     * @generated
     */
    int getReloadPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.security.SignatureRule#getReloadPeriod <em>Reload Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reload Period</em>' attribute.
     * @see #getReloadPeriod()
     * @generated
     */
    void setReloadPeriod ( int value );
} // SignatureRule
