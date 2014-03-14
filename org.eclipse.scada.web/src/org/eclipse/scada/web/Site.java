/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.web;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Site</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.Site#getPages <em>Pages</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Site#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Site#getFooter <em>Footer</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Site#getNews <em>News</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Site#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Site#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Site#getVersions <em>Versions</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Site#getGalleries <em>Galleries</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Site#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.web.WebPackage#getSite()
 * @model
 * @generated
 */
public interface Site extends EObject {
	/**
	 * Returns the value of the '<em><b>Pages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.web.Page}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.scada.web.Page#getSite <em>Site</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pages</em>' containment reference list.
	 * @see org.eclipse.scada.web.WebPackage#getSite_Pages()
	 * @see org.eclipse.scada.web.Page#getSite
	 * @model opposite="site" containment="true"
	 * @generated
	 */
	EList<Page> getPages();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.scada.web.WebPackage#getSite_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Site#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Footer</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.web.FooterEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Footer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Footer</em>' containment reference list.
	 * @see org.eclipse.scada.web.WebPackage#getSite_Footer()
	 * @model containment="true"
	 * @generated
	 */
	EList<FooterEntry> getFooter();

	/**
	 * Returns the value of the '<em><b>News</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.web.NewsEntry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>News</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>News</em>' containment reference list.
	 * @see org.eclipse.scada.web.WebPackage#getSite_News()
	 * @model containment="true"
	 * @generated
	 */
	EList<NewsEntry> getNews();

	/**
	 * Returns the value of the '<em><b>Author</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.web.Author}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' containment reference list.
	 * @see org.eclipse.scada.web.WebPackage#getSite_Author()
	 * @model containment="true"
	 * @generated
	 */
	EList<Author> getAuthor();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.web.Link}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see org.eclipse.scada.web.WebPackage#getSite_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<Link> getLinks();

	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.web.Version}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Versions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Versions</em>' containment reference list.
	 * @see org.eclipse.scada.web.WebPackage#getSite_Versions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Version> getVersions();

	/**
	 * Returns the value of the '<em><b>Galleries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.web.Gallery}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Galleries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Galleries</em>' containment reference list.
	 * @see org.eclipse.scada.web.WebPackage#getSite_Galleries()
	 * @model containment="true"
	 * @generated
	 */
	EList<Gallery> getGalleries();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.scada.web.WebPackage#getSite_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Site#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Site
