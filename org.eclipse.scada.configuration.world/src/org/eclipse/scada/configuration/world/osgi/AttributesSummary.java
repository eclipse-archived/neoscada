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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attributes Summary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AttributesSummary#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.AttributesSummary#getOutputPrefix <em>Output Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAttributesSummary()
 * @model
 * @generated
 */
public interface AttributesSummary extends ItemFeatureEntry
{
    /**
     * Returns the value of the '<em><b>Attributes</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The attribute groups to summarize.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Attributes</em>' attribute list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAttributesSummary_Attributes()
     * @model
     * @generated
     */
    EList<String> getAttributes ();

    /**
     * Returns the value of the '<em><b>Output Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Prefix</em>' attribute.
     * @see #setOutputPrefix(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getAttributesSummary_OutputPrefix()
     * @model required="true"
     * @generated
     */
    String getOutputPrefix ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.AttributesSummary#getOutputPrefix <em>Output Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Prefix</em>' attribute.
     * @see #getOutputPrefix()
     * @generated
     */
    void setOutputPrefix ( String value );

} // AttributesSummary
