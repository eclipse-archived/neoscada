/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.proxy.configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proxy Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getWait <em>Wait</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getProxyType()
 * @model extendedMetaData="name='ProxyType' kind='elementOnly'"
 * @generated
 */
public interface ProxyType extends EObject
{

    /**
     * Returns the value of the '<em><b>Connection</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.proxy.configuration.ConnectionType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection</em>' containment reference list.
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getProxyType_Connection()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='connection' namespace='##targetNamespace'"
     * @generated
     */
    EList<ConnectionType> getConnection ();

    /**
     * Returns the value of the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Prefix</em>' attribute.
     * @see #setPrefix(String)
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getProxyType_Prefix()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='prefix'"
     * @generated
     */
    String getPrefix ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getPrefix <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix ( String value );

    /**
     * Returns the value of the '<em><b>Wait</b></em>' attribute.
     * The default value is <code>"0"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wait</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wait</em>' attribute.
     * @see #isSetWait()
     * @see #unsetWait()
     * @see #setWait(int)
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getProxyType_Wait()
     * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='wait'"
     * @generated
     */
    int getWait ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getWait <em>Wait</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Wait</em>' attribute.
     * @see #isSetWait()
     * @see #unsetWait()
     * @see #getWait()
     * @generated
     */
    void setWait ( int value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getWait <em>Wait</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetWait()
     * @see #getWait()
     * @see #setWait(int)
     * @generated
     */
    void unsetWait ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.proxy.configuration.ProxyType#getWait <em>Wait</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Wait</em>' attribute is set.
     * @see #unsetWait()
     * @see #getWait()
     * @see #setWait(int)
     * @generated
     */
    boolean isSetWait ();

} // ProxyType
