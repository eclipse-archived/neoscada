/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grid Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.GridContainer#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridContainer#isEqualWidth <em>Equal Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridContainer#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridContainer#getHorizontalSpacing <em>Horizontal Spacing</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridContainer#getVerticalSpacing <em>Vertical Spacing</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridContainer#getMarginWidth <em>Margin Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridContainer#getMarginHeight <em>Margin Height</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridContainer()
 * @model
 * @generated
 */
public interface GridContainer extends Container
{
    /**
     * Returns the value of the '<em><b>Columns</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Columns</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Columns</em>' attribute.
     * @see #setColumns(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridContainer_Columns()
     * @model default="1"
     * @generated
     */
    int getColumns ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridContainer#getColumns <em>Columns</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Columns</em>' attribute.
     * @see #getColumns()
     * @generated
     */
    void setColumns ( int value );

    /**
     * Returns the value of the '<em><b>Equal Width</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Equal Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Equal Width</em>' attribute.
     * @see #setEqualWidth(boolean)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridContainer_EqualWidth()
     * @model default="false"
     * @generated
     */
    boolean isEqualWidth ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridContainer#isEqualWidth <em>Equal Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Equal Width</em>' attribute.
     * @see #isEqualWidth()
     * @generated
     */
    void setEqualWidth ( boolean value );

    /**
     * Returns the value of the '<em><b>Children</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.vi.model.GridChild}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Children</em>' containment reference list.
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridContainer_Children()
     * @model containment="true"
     * @generated
     */
    EList<GridChild> getChildren ();

    /**
     * Returns the value of the '<em><b>Horizontal Spacing</b></em>' attribute.
     * The default value is <code>"5"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Horizontal Spacing</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Horizontal Spacing</em>' attribute.
     * @see #setHorizontalSpacing(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridContainer_HorizontalSpacing()
     * @model default="5" required="true"
     * @generated
     */
    int getHorizontalSpacing ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridContainer#getHorizontalSpacing <em>Horizontal Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Horizontal Spacing</em>' attribute.
     * @see #getHorizontalSpacing()
     * @generated
     */
    void setHorizontalSpacing ( int value );

    /**
     * Returns the value of the '<em><b>Vertical Spacing</b></em>' attribute.
     * The default value is <code>"5"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Vertical Spacing</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Vertical Spacing</em>' attribute.
     * @see #setVerticalSpacing(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridContainer_VerticalSpacing()
     * @model default="5" required="true"
     * @generated
     */
    int getVerticalSpacing ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridContainer#getVerticalSpacing <em>Vertical Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Vertical Spacing</em>' attribute.
     * @see #getVerticalSpacing()
     * @generated
     */
    void setVerticalSpacing ( int value );

    /**
     * Returns the value of the '<em><b>Margin Width</b></em>' attribute.
     * The default value is <code>"5"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Margin Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Margin Width</em>' attribute.
     * @see #setMarginWidth(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridContainer_MarginWidth()
     * @model default="5" required="true"
     * @generated
     */
    int getMarginWidth ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridContainer#getMarginWidth <em>Margin Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Margin Width</em>' attribute.
     * @see #getMarginWidth()
     * @generated
     */
    void setMarginWidth ( int value );

    /**
     * Returns the value of the '<em><b>Margin Height</b></em>' attribute.
     * The default value is <code>"5"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Margin Height</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Margin Height</em>' attribute.
     * @see #setMarginHeight(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridContainer_MarginHeight()
     * @model default="5" required="true"
     * @generated
     */
    int getMarginHeight ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridContainer#getMarginHeight <em>Margin Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Margin Height</em>' attribute.
     * @see #getMarginHeight()
     * @generated
     */
    void setMarginHeight ( int value );

} // GridContainer
