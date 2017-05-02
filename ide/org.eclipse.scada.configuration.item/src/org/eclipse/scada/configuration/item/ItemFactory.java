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
package org.eclipse.scada.configuration.item;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.item.ItemPackage
 * @generated
 */
public interface ItemFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ItemFactory eINSTANCE = org.eclipse.scada.configuration.item.impl.ItemFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Composite Pipeline</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Composite Pipeline</em>'.
     * @generated
     */
    CompositePipeline createCompositePipeline ();

    /**
     * Returns a new object of class '<em>Call</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Call</em>'.
     * @generated
     */
    Call createCall ();

    /**
     * Returns a new object of class '<em>Call Super</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Call Super</em>'.
     * @generated
     */
    CallSuper createCallSuper ();

    /**
     * Returns a new object of class '<em>Java Script Customization Pipeline</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Java Script Customization Pipeline</em>'.
     * @generated
     */
    JavaScriptCustomizationPipeline createJavaScriptCustomizationPipeline ();

    /**
     * Returns a new object of class '<em>Custom Script Customization Pipeline</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Custom Script Customization Pipeline</em>'.
     * @generated
     */
    CustomScriptCustomizationPipeline createCustomScriptCustomizationPipeline ();

    /**
     * Returns a new object of class '<em>Java Script Selector</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Java Script Selector</em>'.
     * @generated
     */
    JavaScriptSelector createJavaScriptSelector ();

    /**
     * Returns a new object of class '<em>Custom Script Selector</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Custom Script Selector</em>'.
     * @generated
     */
    CustomScriptSelector createCustomScriptSelector ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ItemPackage getItemPackage ();

} //ItemFactory
