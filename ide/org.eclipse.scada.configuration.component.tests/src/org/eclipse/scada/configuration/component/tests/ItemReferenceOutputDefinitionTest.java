/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ItemReferenceOutputDefinition;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Item Reference Output Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.ItemReferenceOutputDefinition#createReference() <em>Create Reference</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ItemReferenceOutputDefinitionTest extends OutputDefinitionTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ItemReferenceOutputDefinitionTest.class );
    }

    /**
     * Constructs a new Item Reference Output Definition test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemReferenceOutputDefinitionTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Item Reference Output Definition test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected ItemReferenceOutputDefinition getFixture ()
    {
        return (ItemReferenceOutputDefinition)fixture;
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
        setFixture ( ComponentFactory.eINSTANCE.createItemReferenceOutputDefinition () );
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
     * Tests the '{@link org.eclipse.scada.configuration.component.ItemReferenceOutputDefinition#createReference() <em>Create Reference</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.ItemReferenceOutputDefinition#createReference()
     * @generated
     */
    public void testCreateReference ()
    {
        // TODO: implement this operation test method
        // Ensure that you remove @generated or mark it @generated NOT
        fail ();
    }

} //ItemReferenceOutputDefinitionTest
