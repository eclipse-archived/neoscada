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
package org.eclipse.scada.configuration.security.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.security.SecurityFactory;
import org.eclipse.scada.configuration.security.SignatureRule;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Signature Rule</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SignatureRuleTest extends RuleTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( SignatureRuleTest.class );
    }

    /**
     * Constructs a new Signature Rule test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignatureRuleTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Signature Rule test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected SignatureRule getFixture ()
    {
        return (SignatureRule)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp () throws Exception
    {
        setFixture ( SecurityFactory.eINSTANCE.createSignatureRule () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown () throws Exception
    {
        setFixture ( null );
    }

} //SignatureRuleTest
