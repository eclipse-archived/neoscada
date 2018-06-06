/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.SymbolReference#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.SymbolReference#getZoom <em>Zoom</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.SymbolReference#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.SymbolReference#getOnCreateProperties <em>On Create Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getSymbolReference()
 * @model
 * @generated
 */
public interface SymbolReference extends Primitive
{
    /**
     * Returns the value of the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uri</em>' attribute.
     * @see #setUri(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getSymbolReference_Uri()
     * @model required="true"
     * @generated
     */
    String getUri ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.SymbolReference#getUri <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uri</em>' attribute.
     * @see #getUri()
     * @generated
     */
    void setUri ( String value );

    /**
     * Returns the value of the '<em><b>Zoom</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Zoom</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Zoom</em>' attribute.
     * @see #setZoom(Double)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getSymbolReference_Zoom()
     * @model
     * @generated
     */
    Double getZoom ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.SymbolReference#getZoom <em>Zoom</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Zoom</em>' attribute.
     * @see #getZoom()
     * @generated
     */
    void setZoom ( Double value );

    /**
     * Returns the value of the '<em><b>Properties</b></em>' map.
     * The key is of type {@link java.lang.String},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' map.
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getSymbolReference_Properties()
     * @model mapType="org.eclipse.scada.vi.model.StringToStringMap&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
     * @generated
     */
    EMap<String, String> getProperties ();

    /**
     * Returns the value of the '<em><b>On Create Properties</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>On Create Properties</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>On Create Properties</em>' attribute.
     * @see #setOnCreateProperties(String)
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#getSymbolReference_OnCreateProperties()
     * @model
     * @generated
     */
    String getOnCreateProperties ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.model.SymbolReference#getOnCreateProperties <em>On Create Properties</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>On Create Properties</em>' attribute.
     * @see #getOnCreateProperties()
     * @generated
     */
    void setOnCreateProperties ( String value );

} // SymbolReference
