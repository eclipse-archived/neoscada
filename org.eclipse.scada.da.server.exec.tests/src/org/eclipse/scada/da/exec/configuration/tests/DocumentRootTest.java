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
package org.eclipse.scada.da.exec.configuration.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.scada.da.exec.configuration.ConfigurationFactory;
import org.eclipse.scada.da.exec.configuration.DocumentRoot;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.DocumentRoot#getRoot() <em>Root</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class DocumentRootTest extends TestCase
{

    //$NON-NLS-1$

    /**
     * The fixture for this Document Root test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DocumentRoot fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( DocumentRootTest.class );
    }

    /**
     * Constructs a new Document Root test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentRootTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Document Root test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( DocumentRoot fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Document Root test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DocumentRoot getFixture ()
    {
        return fixture;
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
        setFixture ( ConfigurationFactory.eINSTANCE.createDocumentRoot () );
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

    /**
     * Tests the '{@link org.eclipse.scada.da.exec.configuration.DocumentRoot#getRoot() <em>Root</em>}' feature getter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.DocumentRoot#getRoot()
     * @generated
     */
    public void testGetRoot ()
    {
        // TODO: implement this feature getter test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

    /**
     * Tests the '{@link org.eclipse.scada.da.exec.configuration.DocumentRoot#setRoot(org.eclipse.scada.da.exec.configuration.RootType) <em>Root</em>}' feature setter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.exec.configuration.DocumentRoot#setRoot(org.eclipse.scada.da.exec.configuration.RootType)
     * @generated
     */
    public void testSetRoot ()
    {
        // TODO: implement this feature setter test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //DocumentRootTest
