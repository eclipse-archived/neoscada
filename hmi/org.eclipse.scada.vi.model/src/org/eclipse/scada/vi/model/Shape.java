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
 * A representation of the model object '<em><b>Shape</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.Shape#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Shape#getAntialias <em>Antialias</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Shape#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Shape#isFill <em>Fill</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.Shape#isOutline <em>Outline</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getShape()
 * @model abstract="true"
 * @generated
 */
public interface Shape extends Figure
{
    /**
     * Returns the value of the '<em><b>Line Width</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Width</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Line Width</em>' attribute.
     * @see #setLineWidth(float)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getShape_LineWidth()
     * @model default="1" required="true"
     * @generated
     */
    float getLineWidth ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Shape#getLineWidth <em>Line Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Line Width</em>' attribute.
     * @see #getLineWidth()
     * @generated
     */
    void setLineWidth ( float value );

    /**
     * Returns the value of the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Antialias</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Antialias</em>' attribute.
     * @see #setAntialias(Boolean)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getShape_Antialias()
     * @model
     * @generated
     */
    Boolean getAntialias ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Shape#getAntialias <em>Antialias</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Antialias</em>' attribute.
     * @see #getAntialias()
     * @generated
     */
    void setAntialias ( Boolean value );

    /**
     * Returns the value of the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Alpha</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Alpha</em>' attribute.
     * @see #setAlpha(Double)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getShape_Alpha()
     * @model
     * @generated
     */
    Double getAlpha ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Shape#getAlpha <em>Alpha</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alpha</em>' attribute.
     * @see #getAlpha()
     * @generated
     */
    void setAlpha ( Double value );

    /**
     * Returns the value of the '<em><b>Fill</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Fill</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Fill</em>' attribute.
     * @see #setFill(boolean)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getShape_Fill()
     * @model default="true" required="true"
     * @generated
     */
    boolean isFill ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Shape#isFill <em>Fill</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Fill</em>' attribute.
     * @see #isFill()
     * @generated
     */
    void setFill ( boolean value );

    /**
     * Returns the value of the '<em><b>Outline</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Outline</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Outline</em>' attribute.
     * @see #setOutline(boolean)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getShape_Outline()
     * @model default="true" required="true"
     * @generated
     */
    boolean isOutline ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.Shape#isOutline <em>Outline</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Outline</em>' attribute.
     * @see #isOutline()
     * @generated
     */
    void setOutline ( boolean value );

} // Shape
