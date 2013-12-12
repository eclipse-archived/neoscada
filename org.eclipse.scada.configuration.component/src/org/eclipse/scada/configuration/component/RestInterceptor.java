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

import org.eclipse.scada.configuration.infrastructure.RestExporterModule;
import org.eclipse.scada.configuration.item.Selector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rest Interceptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.RestInterceptor#getSelector <em>Selector</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.RestInterceptor#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getRestInterceptor()
 * @model
 * @generated
 */
public interface RestInterceptor extends ItemInterceptor
{
    /**
     * Returns the value of the '<em><b>Selector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selector</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selector</em>' containment reference.
     * @see #setSelector(Selector)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getRestInterceptor_Selector()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Selector getSelector ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.RestInterceptor#getSelector <em>Selector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selector</em>' containment reference.
     * @see #getSelector()
     * @generated
     */
    void setSelector ( Selector value );

    /**
     * Returns the value of the '<em><b>Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Definition</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Definition</em>' reference.
     * @see #setDefinition(RestExporterModule)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getRestInterceptor_Definition()
     * @model required="true"
     * @generated
     */
    RestExporterModule getDefinition ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.RestInterceptor#getDefinition <em>Definition</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Definition</em>' reference.
     * @see #getDefinition()
     * @generated
     */
    void setDefinition ( RestExporterModule value );

} // RestInterceptor
