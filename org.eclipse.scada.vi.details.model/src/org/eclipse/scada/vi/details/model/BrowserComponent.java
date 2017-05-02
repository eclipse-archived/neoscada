/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.details.model;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Browser Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.BrowserComponent#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.BrowserComponent#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.BrowserComponent#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.BrowserComponent#getReloadTimer <em>Reload Timer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBrowserComponent()
 * @model
 * @generated
 */
public interface BrowserComponent extends Component
{
    /**
     * Returns the value of the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Url</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Url</em>' attribute.
     * @see #setUrl(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBrowserComponent_Url()
     * @model required="true"
     * @generated
     */
    String getUrl ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BrowserComponent#getUrl <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Url</em>' attribute.
     * @see #getUrl()
     * @generated
     */
    void setUrl ( String value );

    /**
     * Returns the value of the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Width</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Width</em>' attribute.
     * @see #setWidth(Integer)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBrowserComponent_Width()
     * @model
     * @generated
     */
    Integer getWidth ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BrowserComponent#getWidth <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Width</em>' attribute.
     * @see #getWidth()
     * @generated
     */
    void setWidth ( Integer value );

    /**
     * Returns the value of the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Height</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Height</em>' attribute.
     * @see #setHeight(Integer)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBrowserComponent_Height()
     * @model
     * @generated
     */
    Integer getHeight ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BrowserComponent#getHeight <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Height</em>' attribute.
     * @see #getHeight()
     * @generated
     */
    void setHeight ( Integer value );

    /**
     * Returns the value of the '<em><b>Reload Timer</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Reload Timer</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Reload Timer</em>' attribute.
     * @see #setReloadTimer(Long)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getBrowserComponent_ReloadTimer()
     * @model
     * @generated
     */
    Long getReloadTimer ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.BrowserComponent#getReloadTimer <em>Reload Timer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Reload Timer</em>' attribute.
     * @see #getReloadTimer()
     * @generated
     */
    void setReloadTimer ( Long value );

} // BrowserComponent
