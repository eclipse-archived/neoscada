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
package org.eclipse.scada.configuration.security;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CA</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.security.CA#getCertificateUrl <em>Certificate Url</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.CA#getCrlUrl <em>Crl Url</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.security.SecurityPackage#getCA()
 * @model
 * @generated
 */
public interface CA extends EObject
{
    /**
     * Returns the value of the '<em><b>Certificate Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Certificate Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Certificate Url</em>' attribute.
     * @see #setCertificateUrl(String)
     * @see org.eclipse.scada.configuration.security.SecurityPackage#getCA_CertificateUrl()
     * @model required="true"
     * @generated
     */
    String getCertificateUrl ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.security.CA#getCertificateUrl <em>Certificate Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Certificate Url</em>' attribute.
     * @see #getCertificateUrl()
     * @generated
     */
    void setCertificateUrl ( String value );

    /**
     * Returns the value of the '<em><b>Crl Url</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Crl Url</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Crl Url</em>' attribute list.
     * @see org.eclipse.scada.configuration.security.SecurityPackage#getCA_CrlUrl()
     * @model
     * @generated
     */
    EList<String> getCrlUrl ();

} // CA
