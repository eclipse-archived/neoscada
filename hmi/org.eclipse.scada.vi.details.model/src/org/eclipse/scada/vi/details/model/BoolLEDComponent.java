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
 * A representation of the model object '<em><b>Bool LED Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#isAlarm <em>Alarm</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#isExpectedValue <em>Expected Value</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#isOnOff <em>On Off</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBoolLEDComponent()
 * @model
 * @generated
 */
public interface BoolLEDComponent extends Component
{
    /**
     * Returns the value of the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Format</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Format</em>' attribute.
     * @see #setFormat(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBoolLEDComponent_Format()
     * @model
     * @generated
     */
    String getFormat ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#getFormat <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Format</em>' attribute.
     * @see #getFormat()
     * @generated
     */
    void setFormat ( String value );

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
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBoolLEDComponent_Descriptor()
     * @model required="true"
     * @generated
     */
    String getDescriptor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#getDescriptor <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Descriptor</em>' attribute.
     * @see #getDescriptor()
     * @generated
     */
    void setDescriptor ( String value );

    /**
     * Returns the value of the '<em><b>Alarm</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Alarm</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Alarm</em>' attribute.
     * @see #setAlarm(boolean)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBoolLEDComponent_Alarm()
     * @model
     * @generated
     */
    boolean isAlarm ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#isAlarm <em>Alarm</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alarm</em>' attribute.
     * @see #isAlarm()
     * @generated
     */
    void setAlarm ( boolean value );

    /**
     * Returns the value of the '<em><b>Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Attribute</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Attribute</em>' attribute.
     * @see #setAttribute(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBoolLEDComponent_Attribute()
     * @model
     * @generated
     */
    String getAttribute ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#getAttribute <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Attribute</em>' attribute.
     * @see #getAttribute()
     * @generated
     */
    void setAttribute ( String value );

    /**
     * Returns the value of the '<em><b>Expected Value</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Expected Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Expected Value</em>' attribute.
     * @see #setExpectedValue(boolean)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBoolLEDComponent_ExpectedValue()
     * @model default="false"
     * @generated
     */
    boolean isExpectedValue ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#isExpectedValue <em>Expected Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expected Value</em>' attribute.
     * @see #isExpectedValue()
     * @generated
     */
    void setExpectedValue ( boolean value );

    /**
     * Returns the value of the '<em><b>On Off</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Off</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Off</em>' attribute.
     * @see #setOnOff(boolean)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBoolLEDComponent_OnOff()
     * @model default="false"
     * @generated
     */
    boolean isOnOff ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BoolLEDComponent#isOnOff <em>On Off</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Off</em>' attribute.
     * @see #isOnOff()
     * @generated
     */
    void setOnOff ( boolean value );

} // BoolLEDComponent
