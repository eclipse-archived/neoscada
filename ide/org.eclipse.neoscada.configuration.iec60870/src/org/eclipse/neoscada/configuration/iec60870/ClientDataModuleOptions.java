/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.neoscada.configuration.iec60870;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '
 * <em><b>Client Data Module Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions#isIgnoreBackgroundScan <em>Ignore Background Scan</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions#isDelayStart <em>Delay Start</em>}</li>
 * </ul>
 *
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getClientDataModuleOptions()
 * @model
 * @generated
 */
public interface ClientDataModuleOptions extends EObject
{
    /**
     * Returns the value of the '<em><b>Ignore Background Scan</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ignore Background Scan</em>' attribute isn't
     * clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ignore Background Scan</em>' attribute.
     * @see #setIgnoreBackgroundScan(boolean)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getClientDataModuleOptions_IgnoreBackgroundScan()
     * @model default="false" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='ignoreBackgroundScan'"
     * @generated
     */
    boolean isIgnoreBackgroundScan ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions#isIgnoreBackgroundScan <em>Ignore Background Scan</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ignore Background Scan</em>' attribute.
     * @see #isIgnoreBackgroundScan()
     * @generated
     */
    void setIgnoreBackgroundScan ( boolean value );

    /**
     * Returns the value of the '<em><b>Delay Start</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delay Start</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Delay Start</em>' attribute.
     * @see #setDelayStart(boolean)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getClientDataModuleOptions_DelayStart()
     * @model default="false" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='delayStart'"
     * @generated
     */
    boolean isDelayStart ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions#isDelayStart <em>Delay Start</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Delay Start</em>' attribute.
     * @see #isDelayStart()
     * @generated
     */
    void setDelayStart ( boolean value );

} // ClientDataModuleOptions
