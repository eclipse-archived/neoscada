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
package org.eclipse.scada.configuration.component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Moving Average Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.MovingAverageModule#getNullRange <em>Null Range</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.MovingAverageModule#getRange <em>Range</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.MovingAverageModule#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.MovingAverageModule#isTriggerOnly <em>Trigger Only</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getMovingAverageModule()
 * @model
 * @generated
 */
public interface MovingAverageModule extends CalculationModule
{

    /**
     * Returns the value of the '<em><b>Null Range</b></em>' attribute.
     * The default value is <code>"30"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Null Range</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The amount of time (seconds) that is required to be valid to produce a valid output value.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Null Range</em>' attribute.
     * @see #setNullRange(long)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getMovingAverageModule_NullRange()
     * @model default="30" required="true"
     * @generated
     */
    long getNullRange ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.MovingAverageModule#getNullRange <em>Null Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Null Range</em>' attribute.
     * @see #getNullRange()
     * @generated
     */
    void setNullRange ( long value );

    /**
     * Returns the value of the '<em><b>Range</b></em>' attribute.
     * The default value is <code>"60"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The time range in seconds for which this average will be calculated.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Range</em>' attribute.
     * @see #setRange(long)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getMovingAverageModule_Range()
     * @model default="60" required="true"
     * @generated
     */
    long getRange ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.MovingAverageModule#getRange <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Range</em>' attribute.
     * @see #getRange()
     * @generated
     */
    void setRange ( long value );

    /**
     * Returns the value of the '<em><b>Trigger</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The update time period in seconds.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Trigger</em>' attribute.
     * @see #setTrigger(long)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getMovingAverageModule_Trigger()
     * @model default="1" required="true"
     * @generated
     */
    long getTrigger ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.MovingAverageModule#getTrigger <em>Trigger</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Trigger</em>' attribute.
     * @see #getTrigger()
     * @generated
     */
    void setTrigger ( long value );

    /**
     * Returns the value of the '<em><b>Trigger Only</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Whether value changes or only timed triggers will update the value.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Trigger Only</em>' attribute.
     * @see #setTriggerOnly(boolean)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getMovingAverageModule_TriggerOnly()
     * @model default="false" required="true"
     * @generated
     */
    boolean isTriggerOnly ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.MovingAverageModule#isTriggerOnly <em>Trigger Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Trigger Only</em>' attribute.
     * @see #isTriggerOnly()
     * @generated
     */
    void setTriggerOnly ( boolean value );
} // MovingAverageModule
