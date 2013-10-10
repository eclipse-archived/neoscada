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
 * A representation of the model object '<em><b>Root Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.RootType#getProxy <em>Proxy</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.RootType#getSeparator <em>Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getRootType()
 * @model extendedMetaData="name='RootType' kind='elementOnly'"
 * @generated
 */
public interface RootType extends EObject
{

    /**
     * Returns the value of the '<em><b>Proxy</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.proxy.configuration.ProxyType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Proxy</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Proxy</em>' containment reference list.
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getRootType_Proxy()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='proxy' namespace='##targetNamespace'"
     * @generated
     */
    EList<ProxyType> getProxy ();

    /**
     * Returns the value of the '<em><b>Separator</b></em>' attribute.
     * The default value is <code>"."</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Separator</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Separator</em>' attribute.
     * @see #isSetSeparator()
     * @see #unsetSeparator()
     * @see #setSeparator(String)
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getRootType_Separator()
     * @model default="." unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='separator'"
     * @generated
     */
    String getSeparator ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.proxy.configuration.RootType#getSeparator <em>Separator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Separator</em>' attribute.
     * @see #isSetSeparator()
     * @see #unsetSeparator()
     * @see #getSeparator()
     * @generated
     */
    void setSeparator ( String value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.proxy.configuration.RootType#getSeparator <em>Separator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetSeparator()
     * @see #getSeparator()
     * @see #setSeparator(String)
     * @generated
     */
    void unsetSeparator ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.proxy.configuration.RootType#getSeparator <em>Separator</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Separator</em>' attribute is set.
     * @see #unsetSeparator()
     * @see #getSeparator()
     * @see #setSeparator(String)
     * @generated
     */
    boolean isSetSeparator ();

} // RootType
