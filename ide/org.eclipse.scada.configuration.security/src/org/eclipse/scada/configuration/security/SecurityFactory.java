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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.security.SecurityPackage
 * @generated
 */
public interface SecurityFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    SecurityFactory eINSTANCE = org.eclipse.scada.configuration.security.impl.SecurityFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Script Rule</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script Rule</em>'.
     * @generated
     */
    ScriptRule createScriptRule ();

    /**
     * Returns a new object of class '<em>Logon Rule</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Logon Rule</em>'.
     * @generated
     */
    LogonRule createLogonRule ();

    /**
     * Returns a new object of class '<em>Signature Rule</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Signature Rule</em>'.
     * @generated
     */
    SignatureRule createSignatureRule ();

    /**
     * Returns a new object of class '<em>Java Script</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Java Script</em>'.
     * @generated
     */
    JavaScript createJavaScript ();

    /**
     * Returns a new object of class '<em>Generic Script</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Generic Script</em>'.
     * @generated
     */
    GenericScript createGenericScript ();

    /**
     * Returns a new object of class '<em>Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Configuration</em>'.
     * @generated
     */
    Configuration createConfiguration ();

    /**
     * Returns a new object of class '<em>Rules</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Rules</em>'.
     * @generated
     */
    Rules createRules ();

    /**
     * Returns a new object of class '<em>CA</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>CA</em>'.
     * @generated
     */
    CA createCA ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    SecurityPackage getSecurityPackage ();

} //SecurityFactory
