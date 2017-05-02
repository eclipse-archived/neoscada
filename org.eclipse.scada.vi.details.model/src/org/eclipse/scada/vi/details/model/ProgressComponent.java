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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Progress Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.ProgressComponent#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ProgressComponent#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ProgressComponent#getMax <em>Max</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ProgressComponent#getMin <em>Min</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ProgressComponent#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getProgressComponent()
 * @model
 * @generated
 */
public interface ProgressComponent extends ReadableComponent
{
    /**
     * Returns the value of the '<em><b>Descriptor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Descriptor</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Descriptor</em>' attribute.
     * @see #setDescriptor(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getProgressComponent_Descriptor()
     * @model required="true"
     * @generated
     */
    String getDescriptor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ProgressComponent#getDescriptor <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptor</em>' attribute.
     * @see #getDescriptor()
     * @generated
     */
    void setDescriptor ( String value );

    /**
     * Returns the value of the '<em><b>Factor</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Factor</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Factor</em>' attribute.
     * @see #setFactor(double)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getProgressComponent_Factor()
     * @model
     * @generated
     */
    double getFactor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ProgressComponent#getFactor <em>Factor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Factor</em>' attribute.
     * @see #getFactor()
     * @generated
     */
    void setFactor ( double value );

    /**
     * Returns the value of the '<em><b>Max</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max</em>' attribute.
     * @see #setMax(double)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getProgressComponent_Max()
     * @model
     * @generated
     */
    double getMax ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ProgressComponent#getMax <em>Max</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max</em>' attribute.
     * @see #getMax()
     * @generated
     */
    void setMax ( double value );

    /**
     * Returns the value of the '<em><b>Min</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Min</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Min</em>' attribute.
     * @see #setMin(double)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getProgressComponent_Min()
     * @model
     * @generated
     */
    double getMin ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ProgressComponent#getMin <em>Min</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Min</em>' attribute.
     * @see #getMin()
     * @generated
     */
    void setMin ( double value );

    /**
     * Returns the value of the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(int)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getProgressComponent_Width()
     * @model
     * @generated
     */
    int getWidth ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ProgressComponent#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth ( int value );

} // ProgressComponent
