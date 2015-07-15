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
package org.eclipse.scada.configuration.world.osgi;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scale</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Scale#isActive <em>Active</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Scale#getFactor <em>Factor</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Scale#getOffset <em>Offset</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScale()
 * @model
 * @generated
 */
public interface Scale extends ItemFeatureEntry
{
    /**
     * Returns the value of the '<em><b>Active</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Active</em>' attribute.
     * @see #setActive(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScale_Active()
     * @model required="true"
     * @generated
     */
    boolean isActive ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.Scale#isActive <em>Active</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Active</em>' attribute.
     * @see #isActive()
     * @generated
     */
    void setActive ( boolean value );

    /**
     * Returns the value of the '<em><b>Factor</b></em>' attribute.
     * The default value is <code>"1.0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Factor</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Factor</em>' attribute.
     * @see #setFactor(Double)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScale_Factor()
     * @model default="1.0" required="true"
     * @generated
     */
    Double getFactor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.Scale#getFactor <em>Factor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Factor</em>' attribute.
     * @see #getFactor()
     * @generated
     */
    void setFactor ( Double value );

    /**
     * Returns the value of the '<em><b>Offset</b></em>' attribute.
     * The default value is <code>"0.0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Offset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Offset</em>' attribute.
     * @see #setOffset(Double)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getScale_Offset()
     * @model default="0.0" required="true"
     * @generated
     */
    Double getOffset ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.Scale#getOffset <em>Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Offset</em>' attribute.
     * @see #getOffset()
     * @generated
     */
    void setOffset ( Double value );

} // Scale
