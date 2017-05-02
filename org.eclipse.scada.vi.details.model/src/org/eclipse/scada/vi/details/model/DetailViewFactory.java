/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage
 * @generated
 */
public interface DetailViewFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    DetailViewFactory eINSTANCE = org.eclipse.scada.vi.details.model.impl.DetailViewFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>View</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>View</em>'.
     * @generated
     */
    View createView ();

    /**
     * Returns a new object of class '<em>Group Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Group Entry</em>'.
     * @generated
     */
    GroupEntry createGroupEntry ();

    /**
     * Returns a new object of class '<em>Label Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Label Component</em>'.
     * @generated
     */
    LabelComponent createLabelComponent ();

    /**
     * Returns a new object of class '<em>Fill Layout Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Fill Layout Component</em>'.
     * @generated
     */
    FillLayoutComponent createFillLayoutComponent ();

    /**
     * Returns a new object of class '<em>Button Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Button Component</em>'.
     * @generated
     */
    ButtonComponent createButtonComponent ();

    /**
     * Returns a new object of class '<em>Bool LED Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Bool LED Component</em>'.
     * @generated
     */
    BoolLEDComponent createBoolLEDComponent ();

    /**
     * Returns a new object of class '<em>Item Value Source</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Item Value Source</em>'.
     * @generated
     */
    ItemValueSource createItemValueSource ();

    /**
     * Returns a new object of class '<em>Not Transformer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Not Transformer</em>'.
     * @generated
     */
    NotTransformer createNotTransformer ();

    /**
     * Returns a new object of class '<em>Registration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Registration</em>'.
     * @generated
     */
    Registration createRegistration ();

    /**
     * Returns a new object of class '<em>Simple Grid Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple Grid Component</em>'.
     * @generated
     */
    SimpleGridComponent createSimpleGridComponent ();

    /**
     * Returns a new object of class '<em>Group Grid Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Group Grid Component</em>'.
     * @generated
     */
    GroupGridComponent createGroupGridComponent ();

    /**
     * Returns a new object of class '<em>Group Grid Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Group Grid Entry</em>'.
     * @generated
     */
    GroupGridEntry createGroupGridEntry ();

    /**
     * Returns a new object of class '<em>Value Set Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Set Component</em>'.
     * @generated
     */
    ValueSetComponent createValueSetComponent ();

    /**
     * Returns a new object of class '<em>Value Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Component</em>'.
     * @generated
     */
    ValueComponent createValueComponent ();

    /**
     * Returns a new object of class '<em>And Transformer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>And Transformer</em>'.
     * @generated
     */
    AndTransformer createAndTransformer ();

    /**
     * Returns a new object of class '<em>Or Transformer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Or Transformer</em>'.
     * @generated
     */
    OrTransformer createOrTransformer ();

    /**
     * Returns a new object of class '<em>Text Input Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Text Input Component</em>'.
     * @generated
     */
    TextInputComponent createTextInputComponent ();

    /**
     * Returns a new object of class '<em>Text Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Text Component</em>'.
     * @generated
     */
    TextComponent createTextComponent ();

    /**
     * Returns a new object of class '<em>Text Input Multi Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Text Input Multi Component</em>'.
     * @generated
     */
    TextInputMultiComponent createTextInputMultiComponent ();

    /**
     * Returns a new object of class '<em>Check Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Check Component</em>'.
     * @generated
     */
    CheckComponent createCheckComponent ();

    /**
     * Returns a new object of class '<em>Link Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Link Component</em>'.
     * @generated
     */
    LinkComponent createLinkComponent ();

    /**
     * Returns a new object of class '<em>URL Image Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>URL Image Component</em>'.
     * @generated
     */
    URLImageComponent createURLImageComponent ();

    /**
     * Returns a new object of class '<em>Progress Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Progress Component</em>'.
     * @generated
     */
    ProgressComponent createProgressComponent ();

    /**
     * Returns a new object of class '<em>Hidden Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Hidden Component</em>'.
     * @generated
     */
    HiddenComponent createHiddenComponent ();

    /**
     * Returns a new object of class '<em>Script Visibility</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script Visibility</em>'.
     * @generated
     */
    ScriptVisibility createScriptVisibility ();

    /**
     * Returns a new object of class '<em>Permission Visibility</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Permission Visibility</em>'.
     * @generated
     */
    PermissionVisibility createPermissionVisibility ();

    /**
     * Returns a new object of class '<em>Invisible</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Invisible</em>'.
     * @generated
     */
    Invisible createInvisible ();

    /**
     * Returns a new object of class '<em>Test Visibility</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Test Visibility</em>'.
     * @generated
     */
    TestVisibility createTestVisibility ();

    /**
     * Returns a new object of class '<em>Script Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script Module</em>'.
     * @generated
     */
    ScriptModule createScriptModule ();

    /**
     * Returns a new object of class '<em>Browser Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Browser Component</em>'.
     * @generated
     */
    BrowserComponent createBrowserComponent ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    DetailViewPackage getDetailViewPackage ();

} //DetailViewFactory
