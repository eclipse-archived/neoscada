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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grid Child</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.GridChild#getHorizontalAlignment <em>Horizontal Alignment</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridChild#getVerticalAlignment <em>Vertical Alignment</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridChild#isGrabHorizontalSpace <em>Grab Horizontal Space</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridChild#isGrabVerticalSpace <em>Grab Vertical Space</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridChild#getSpanCols <em>Span Cols</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridChild#getSpanRows <em>Span Rows</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridChild#getWidthHint <em>Width Hint</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.GridChild#getHeightHint <em>Height Hint</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridChild()
 * @model
 * @generated
 */
public interface GridChild extends Child
{
    /**
     * Returns the value of the '<em><b>Horizontal Alignment</b></em>' attribute.
     * The default value is <code>"BEGINNING"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.vi.model.GridAlignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Horizontal Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Horizontal Alignment</em>' attribute.
     * @see org.eclipse.scada.vi.model.GridAlignment
     * @see #setHorizontalAlignment(GridAlignment)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridChild_HorizontalAlignment()
     * @model default="BEGINNING" required="true"
     * @generated
     */
    GridAlignment getHorizontalAlignment ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridChild#getHorizontalAlignment <em>Horizontal Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Horizontal Alignment</em>' attribute.
     * @see org.eclipse.scada.vi.model.GridAlignment
     * @see #getHorizontalAlignment()
     * @generated
     */
    void setHorizontalAlignment ( GridAlignment value );

    /**
     * Returns the value of the '<em><b>Vertical Alignment</b></em>' attribute.
     * The default value is <code>"BEGINNING"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.vi.model.GridAlignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Vertical Alignment</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Vertical Alignment</em>' attribute.
     * @see org.eclipse.scada.vi.model.GridAlignment
     * @see #setVerticalAlignment(GridAlignment)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridChild_VerticalAlignment()
     * @model default="BEGINNING" required="true"
     * @generated
     */
    GridAlignment getVerticalAlignment ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridChild#getVerticalAlignment <em>Vertical Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Vertical Alignment</em>' attribute.
     * @see org.eclipse.scada.vi.model.GridAlignment
     * @see #getVerticalAlignment()
     * @generated
     */
    void setVerticalAlignment ( GridAlignment value );

    /**
     * Returns the value of the '<em><b>Grab Horizontal Space</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Grab Horizontal Space</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Grab Horizontal Space</em>' attribute.
     * @see #setGrabHorizontalSpace(boolean)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridChild_GrabHorizontalSpace()
     * @model default="false" required="true"
     * @generated
     */
    boolean isGrabHorizontalSpace ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridChild#isGrabHorizontalSpace <em>Grab Horizontal Space</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Grab Horizontal Space</em>' attribute.
     * @see #isGrabHorizontalSpace()
     * @generated
     */
    void setGrabHorizontalSpace ( boolean value );

    /**
     * Returns the value of the '<em><b>Grab Vertical Space</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Grab Vertical Space</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Grab Vertical Space</em>' attribute.
     * @see #setGrabVerticalSpace(boolean)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridChild_GrabVerticalSpace()
     * @model default="false" required="true"
     * @generated
     */
    boolean isGrabVerticalSpace ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridChild#isGrabVerticalSpace <em>Grab Vertical Space</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Grab Vertical Space</em>' attribute.
     * @see #isGrabVerticalSpace()
     * @generated
     */
    void setGrabVerticalSpace ( boolean value );

    /**
     * Returns the value of the '<em><b>Span Cols</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Span Cols</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Span Cols</em>' attribute.
     * @see #setSpanCols(int)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridChild_SpanCols()
     * @model default="0" required="true"
     * @generated
     */
    int getSpanCols ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridChild#getSpanCols <em>Span Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Span Cols</em>' attribute.
     * @see #getSpanCols()
     * @generated
     */
    void setSpanCols ( int value );

    /**
     * Returns the value of the '<em><b>Span Rows</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Span Rows</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Span Rows</em>' attribute.
     * @see #setSpanRows(Integer)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridChild_SpanRows()
     * @model default="0"
     * @generated
     */
    Integer getSpanRows ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridChild#getSpanRows <em>Span Rows</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Span Rows</em>' attribute.
     * @see #getSpanRows()
     * @generated
     */
    void setSpanRows ( Integer value );

    /**
     * Returns the value of the '<em><b>Width Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width Hint</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Width Hint</em>' attribute.
     * @see #setWidthHint(Integer)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridChild_WidthHint()
     * @model
     * @generated
     */
    Integer getWidthHint ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridChild#getWidthHint <em>Width Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width Hint</em>' attribute.
     * @see #getWidthHint()
     * @generated
     */
    void setWidthHint ( Integer value );

    /**
     * Returns the value of the '<em><b>Height Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Height Hint</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Height Hint</em>' attribute.
     * @see #setHeightHint(Integer)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getGridChild_HeightHint()
     * @model required="true"
     * @generated
     */
    Integer getHeightHint ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.GridChild#getHeightHint <em>Height Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height Hint</em>' attribute.
     * @see #getHeightHint()
     * @generated
     */
    void setHeightHint ( Integer value );

} // GridChild
