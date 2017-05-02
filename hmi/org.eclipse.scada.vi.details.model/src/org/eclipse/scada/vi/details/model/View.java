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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.View#getHeaderComponent <em>Header Component</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.View#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.View#getHiddenComponent <em>Hidden Component</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.View#getScriptModule <em>Script Module</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.View#getTabStyle <em>Tab Style</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.View#isWriteDialogEnabled <em>Write Dialog Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getView()
 * @model
 * @generated
 */
public interface View extends EObject
{
    /**
     * Returns the value of the '<em><b>Header Component</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Header Component</em>' containment reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Header Component</em>' containment reference.
     * @see #setHeaderComponent(Component)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getView_HeaderComponent()
     * @model containment="true"
     * @generated
     */
    Component getHeaderComponent ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.View#getHeaderComponent <em>Header Component</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Header Component</em>' containment reference.
     * @see #getHeaderComponent()
     * @generated
     */
    void setHeaderComponent ( Component value );

    /**
     * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.vi.details.model.GroupEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Groups</em>' containment reference list.
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getView_Groups()
     * @model containment="true"
     * @generated
     */
    EList<GroupEntry> getGroups ();

    /**
     * Returns the value of the '<em><b>Hidden Component</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.vi.details.model.HiddenComponent}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hidden Component</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hidden Component</em>' containment reference list.
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getView_HiddenComponent()
     * @model containment="true"
     * @generated
     */
    EList<HiddenComponent> getHiddenComponent ();

    /**
     * Returns the value of the '<em><b>Script Module</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.vi.details.model.ScriptModule}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script Module</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script Module</em>' containment reference list.
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getView_ScriptModule()
     * @model containment="true"
     * @generated
     */
    EList<ScriptModule> getScriptModule ();

    /**
     * Returns the value of the '<em><b>Tab Style</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.scada.vi.details.model.TabStyle}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tab Style</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tab Style</em>' attribute.
     * @see org.eclipse.scada.vi.details.model.TabStyle
     * @see #setTabStyle(TabStyle)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getView_TabStyle()
     * @model
     * @generated
     */
    TabStyle getTabStyle ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.View#getTabStyle <em>Tab Style</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tab Style</em>' attribute.
     * @see org.eclipse.scada.vi.details.model.TabStyle
     * @see #getTabStyle()
     * @generated
     */
    void setTabStyle ( TabStyle value );

    /**
     * Returns the value of the '<em><b>Write Dialog Enabled</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Write Dialog Enabled</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Write Dialog Enabled</em>' attribute.
     * @see #setWriteDialogEnabled(boolean)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getView_WriteDialogEnabled()
     * @model default="true"
     * @generated
     */
    boolean isWriteDialogEnabled ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.View#isWriteDialogEnabled <em>Write Dialog Enabled</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Write Dialog Enabled</em>' attribute.
     * @see #isWriteDialogEnabled()
     * @generated
     */
    void setWriteDialogEnabled ( boolean value );

} // View
