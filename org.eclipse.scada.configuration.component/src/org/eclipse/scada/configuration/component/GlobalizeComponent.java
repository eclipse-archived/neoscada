/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.infrastructure.MasterImport;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Globalize Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.GlobalizeComponent#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.GlobalizeComponent#getSourceMaster <em>Source Master</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getGlobalizeComponent()
 * @model
 * @generated
 */
public interface GlobalizeComponent extends DataComponent
{
    /**
     * Returns the value of the '<em><b>Components</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.DataComponent}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Components</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Components</em>' reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getGlobalizeComponent_Components()
     * @model
     * @generated
     */
    EList<DataComponent> getComponents ();

    /**
     * Returns the value of the '<em><b>Source Master</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Master</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Master</em>' reference.
     * @see #setSourceMaster(MasterImport)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getGlobalizeComponent_SourceMaster()
     * @model required="true"
     * @generated
     */
    MasterImport getSourceMaster ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.GlobalizeComponent#getSourceMaster <em>Source Master</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Master</em>' reference.
     * @see #getSourceMaster()
     * @generated
     */
    void setSourceMaster ( MasterImport value );

} // GlobalizeComponent
