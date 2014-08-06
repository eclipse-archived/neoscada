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
package org.eclipse.scada.configuration.world.setup;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operating System Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getOperatingSystemDescriptor()
 * @model
 * @generated
 */
public interface OperatingSystemDescriptor extends EObject
{
    /**
     * Returns the value of the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' reference.
     * @see #setParent(OperatingSystemDescriptor)
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getOperatingSystemDescriptor_Parent()
     * @model
     * @generated
     */
    OperatingSystemDescriptor getParent ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getParent <em>Parent</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' reference.
     * @see #getParent()
     * @generated
     */
    void setParent ( OperatingSystemDescriptor value );

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getOperatingSystemDescriptor_Properties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getProperties ();

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getOperatingSystemDescriptor_Id()
     * @model id="true" required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Label</em>' attribute.
     * @see #setLabel(String)
     * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getOperatingSystemDescriptor_Label()
     * @model
     * @generated
     */
    String getLabel ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor#getLabel <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Label</em>' attribute.
     * @see #getLabel()
     * @generated
     */
    void setLabel ( String value );

} // OperatingSystemDescriptor
