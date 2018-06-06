/**
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add new mouse events
 */
package org.eclipse.scada.vi.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Figure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getOnClick <em>On Click</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getOnDoubleClick <em>On Double Click</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getCursor <em>Cursor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getBorder <em>Border</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getOpaque <em>Opaque</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getToolTip <em>Tool Tip</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getOnMouseIn <em>On Mouse In</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getOnMouseOut <em>On Mouse Out</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getOnMouseMove <em>On Mouse Move</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getOnMouseHover <em>On Mouse Hover</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Figure#getOnMouseDrag <em>On Mouse Drag</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure()
 * @model abstract="true"
 * @generated
 */
public interface Figure extends Primitive
{
    /**
     * Returns the value of the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Foreground Color</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Foreground Color</em>' attribute.
     * @see #setForegroundColor(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_ForegroundColor()
     * @model
     * @generated
     */
    String getForegroundColor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getForegroundColor <em>Foreground Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Foreground Color</em>' attribute.
     * @see #getForegroundColor()
     * @generated
     */
    void setForegroundColor ( String value );

    /**
     * Returns the value of the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Background Color</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Background Color</em>' attribute.
     * @see #setBackgroundColor(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_BackgroundColor()
     * @model
     * @generated
     */
    String getBackgroundColor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getBackgroundColor <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Background Color</em>' attribute.
     * @see #getBackgroundColor()
     * @generated
     */
    void setBackgroundColor ( String value );

    /**
     * Returns the value of the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Size</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Size</em>' containment reference.
     * @see #setSize(Dimension)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_Size()
     * @model containment="true"
     * @generated
     */
    Dimension getSize ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getSize <em>Size</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Size</em>' containment reference.
     * @see #getSize()
     * @generated
     */
    void setSize ( Dimension value );

    /**
     * Returns the value of the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Click</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Click</em>' attribute.
     * @see #setOnClick(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_OnClick()
     * @model
     * @generated
     */
    String getOnClick ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getOnClick <em>On Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Click</em>' attribute.
     * @see #getOnClick()
     * @generated
     */
    void setOnClick ( String value );

    /**
     * Returns the value of the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Double Click</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Double Click</em>' attribute.
     * @see #setOnDoubleClick(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_OnDoubleClick()
     * @model
     * @generated
     */
    String getOnDoubleClick ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getOnDoubleClick <em>On Double Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Double Click</em>' attribute.
     * @see #getOnDoubleClick()
     * @generated
     */
    void setOnDoubleClick ( String value );

    /**
     * Returns the value of the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cursor</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cursor</em>' reference.
     * @see #setCursor(Cursor)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_Cursor()
     * @model
     * @generated
     */
    Cursor getCursor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getCursor <em>Cursor</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cursor</em>' reference.
     * @see #getCursor()
     * @generated
     */
    void setCursor ( Cursor value );

    /**
     * Returns the value of the '<em><b>Visible</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Visible</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visible</em>' attribute.
     * @see #setVisible(boolean)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_Visible()
     * @model default="true" required="true"
     * @generated
     */
    boolean isVisible ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#isVisible <em>Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visible</em>' attribute.
     * @see #isVisible()
     * @generated
     */
    void setVisible ( boolean value );

    /**
     * Returns the value of the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Border</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Border</em>' attribute.
     * @see #setBorder(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_Border()
     * @model
     * @generated
     */
    String getBorder ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getBorder <em>Border</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Border</em>' attribute.
     * @see #getBorder()
     * @generated
     */
    void setBorder ( String value );

    /**
     * Returns the value of the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Opaque</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Opaque</em>' attribute.
     * @see #setOpaque(Boolean)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_Opaque()
     * @model
     * @generated
     */
    Boolean getOpaque ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getOpaque <em>Opaque</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Opaque</em>' attribute.
     * @see #getOpaque()
     * @generated
     */
    void setOpaque ( Boolean value );

    /**
     * Returns the value of the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tool Tip</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tool Tip</em>' attribute.
     * @see #setToolTip(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_ToolTip()
     * @model
     * @generated
     */
    String getToolTip ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getToolTip <em>Tool Tip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tool Tip</em>' attribute.
     * @see #getToolTip()
     * @generated
     */
    void setToolTip ( String value );

    /**
     * Returns the value of the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Mouse In</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Mouse In</em>' attribute.
     * @see #setOnMouseIn(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_OnMouseIn()
     * @model
     * @generated
     */
    String getOnMouseIn ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getOnMouseIn <em>On Mouse In</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Mouse In</em>' attribute.
     * @see #getOnMouseIn()
     * @generated
     */
    void setOnMouseIn ( String value );

    /**
     * Returns the value of the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Mouse Out</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Mouse Out</em>' attribute.
     * @see #setOnMouseOut(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_OnMouseOut()
     * @model
     * @generated
     */
    String getOnMouseOut ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getOnMouseOut <em>On Mouse Out</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Mouse Out</em>' attribute.
     * @see #getOnMouseOut()
     * @generated
     */
    void setOnMouseOut ( String value );

    /**
     * Returns the value of the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Mouse Move</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Mouse Move</em>' attribute.
     * @see #setOnMouseMove(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_OnMouseMove()
     * @model
     * @generated
     */
    String getOnMouseMove ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getOnMouseMove <em>On Mouse Move</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Mouse Move</em>' attribute.
     * @see #getOnMouseMove()
     * @generated
     */
    void setOnMouseMove ( String value );

    /**
     * Returns the value of the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Mouse Hover</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Mouse Hover</em>' attribute.
     * @see #setOnMouseHover(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_OnMouseHover()
     * @model
     * @generated
     */
    String getOnMouseHover ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getOnMouseHover <em>On Mouse Hover</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Mouse Hover</em>' attribute.
     * @see #getOnMouseHover()
     * @generated
     */
    void setOnMouseHover ( String value );

    /**
     * Returns the value of the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Mouse Drag</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Mouse Drag</em>' attribute.
     * @see #setOnMouseDrag(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getFigure_OnMouseDrag()
     * @model
     * @generated
     */
    String getOnMouseDrag ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Figure#getOnMouseDrag <em>On Mouse Drag</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Mouse Drag</em>' attribute.
     * @see #getOnMouseDrag()
     * @generated
     */
    void setOnMouseDrag ( String value );

} // Figure
