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
package org.eclipse.scada.da.server.component.parser.factory.configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Url Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#isProbeCharacterSet <em>Probe Character Set</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#getCharset <em>Charset</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getUrlInput()
 * @model
 * @generated
 */
public interface UrlInput extends AbstractPeriodInput
{
    /**
     * Returns the value of the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Url</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Url</em>' attribute.
     * @see #setUrl(String)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getUrlInput_Url()
     * @model required="true"
     * @generated
     */
    String getUrl ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#getUrl <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Url</em>' attribute.
     * @see #getUrl()
     * @generated
     */
    void setUrl ( String value );

    /**
     * Returns the value of the '<em><b>Probe Character Set</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Probe Character Set</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Probe Character Set</em>' attribute.
     * @see #setProbeCharacterSet(boolean)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getUrlInput_ProbeCharacterSet()
     * @model default="true" required="true"
     * @generated
     */
    boolean isProbeCharacterSet ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#isProbeCharacterSet <em>Probe Character Set</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Probe Character Set</em>' attribute.
     * @see #isProbeCharacterSet()
     * @generated
     */
    void setProbeCharacterSet ( boolean value );

    /**
     * Returns the value of the '<em><b>Charset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Charset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Charset</em>' attribute.
     * @see #setCharset(String)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getUrlInput_Charset()
     * @model
     * @generated
     */
    String getCharset ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#getCharset <em>Charset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Charset</em>' attribute.
     * @see #getCharset()
     * @generated
     */
    void setCharset ( String value );

} // UrlInput
