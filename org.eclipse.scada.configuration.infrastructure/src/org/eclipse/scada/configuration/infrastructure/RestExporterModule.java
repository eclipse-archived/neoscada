/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.infrastructure;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rest Exporter Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.RestExporterModule#getContextId <em>Context Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getRestExporterModule()
 * @model
 * @generated
 */
public interface RestExporterModule extends Module
{
    /**
     * Returns the value of the '<em><b>Context Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context Id</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context Id</em>' attribute.
     * @see #setContextId(String)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getRestExporterModule_ContextId()
     * @model required="true"
     * @generated
     */
    String getContextId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.RestExporterModule#getContextId <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Id</em>' attribute.
     * @see #getContextId()
     * @generated
     */
    void setContextId ( String value );

} // RestExporterModule
