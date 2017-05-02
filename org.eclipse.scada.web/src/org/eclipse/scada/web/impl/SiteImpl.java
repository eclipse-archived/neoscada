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
package org.eclipse.scada.web.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.web.Author;
import org.eclipse.scada.web.FooterEntry;
import org.eclipse.scada.web.Gallery;
import org.eclipse.scada.web.Link;
import org.eclipse.scada.web.NewsEntry;
import org.eclipse.scada.web.Page;
import org.eclipse.scada.web.Site;
import org.eclipse.scada.web.Version;
import org.eclipse.scada.web.WebPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Site</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.impl.SiteImpl#getPages <em>Pages</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SiteImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SiteImpl#getFooter <em>Footer</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SiteImpl#getNews <em>News</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SiteImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SiteImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SiteImpl#getVersions <em>Versions</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SiteImpl#getGalleries <em>Galleries</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SiteImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SiteImpl extends MinimalEObjectImpl.Container implements Site {
	/**
	 * The cached value of the '{@link #getPages() <em>Pages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPages()
	 * @generated
	 * @ordered
	 */
	protected EList<Page> pages;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getFooter() <em>Footer</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFooter()
	 * @generated
	 * @ordered
	 */
	protected EList<FooterEntry> footer;

	/**
	 * The cached value of the '{@link #getNews() <em>News</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNews()
	 * @generated
	 * @ordered
	 */
	protected EList<NewsEntry> news;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected EList<Author> author;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersions()
	 * @generated
	 * @ordered
	 */
	protected EList<Version> versions;

	/**
	 * The cached value of the '{@link #getGalleries() <em>Galleries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGalleries()
	 * @generated
	 * @ordered
	 */
	protected EList<Gallery> galleries;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WebPackage.Literals.SITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Page> getPages() {
		if (pages == null) {
			pages = new EObjectContainmentWithInverseEList<Page>(Page.class, this, WebPackage.SITE__PAGES, WebPackage.PAGE__SITE);
		}
		return pages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.SITE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FooterEntry> getFooter() {
		if (footer == null) {
			footer = new EObjectContainmentEList<FooterEntry>(FooterEntry.class, this, WebPackage.SITE__FOOTER);
		}
		return footer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NewsEntry> getNews() {
		if (news == null) {
			news = new EObjectContainmentEList<NewsEntry>(NewsEntry.class, this, WebPackage.SITE__NEWS);
		}
		return news;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Author> getAuthor() {
		if (author == null) {
			author = new EObjectContainmentEList<Author>(Author.class, this, WebPackage.SITE__AUTHOR);
		}
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<Link>(Link.class, this, WebPackage.SITE__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Version> getVersions() {
		if (versions == null) {
			versions = new EObjectContainmentEList<Version>(Version.class, this, WebPackage.SITE__VERSIONS);
		}
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Gallery> getGalleries() {
		if (galleries == null) {
			galleries = new EObjectContainmentEList<Gallery>(Gallery.class, this, WebPackage.SITE__GALLERIES);
		}
		return galleries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.SITE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WebPackage.SITE__PAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPages()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WebPackage.SITE__PAGES:
				return ((InternalEList<?>)getPages()).basicRemove(otherEnd, msgs);
			case WebPackage.SITE__FOOTER:
				return ((InternalEList<?>)getFooter()).basicRemove(otherEnd, msgs);
			case WebPackage.SITE__NEWS:
				return ((InternalEList<?>)getNews()).basicRemove(otherEnd, msgs);
			case WebPackage.SITE__AUTHOR:
				return ((InternalEList<?>)getAuthor()).basicRemove(otherEnd, msgs);
			case WebPackage.SITE__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case WebPackage.SITE__VERSIONS:
				return ((InternalEList<?>)getVersions()).basicRemove(otherEnd, msgs);
			case WebPackage.SITE__GALLERIES:
				return ((InternalEList<?>)getGalleries()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WebPackage.SITE__PAGES:
				return getPages();
			case WebPackage.SITE__NAME:
				return getName();
			case WebPackage.SITE__FOOTER:
				return getFooter();
			case WebPackage.SITE__NEWS:
				return getNews();
			case WebPackage.SITE__AUTHOR:
				return getAuthor();
			case WebPackage.SITE__LINKS:
				return getLinks();
			case WebPackage.SITE__VERSIONS:
				return getVersions();
			case WebPackage.SITE__GALLERIES:
				return getGalleries();
			case WebPackage.SITE__DESCRIPTION:
				return getDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WebPackage.SITE__PAGES:
				getPages().clear();
				getPages().addAll((Collection<? extends Page>)newValue);
				return;
			case WebPackage.SITE__NAME:
				setName((String)newValue);
				return;
			case WebPackage.SITE__FOOTER:
				getFooter().clear();
				getFooter().addAll((Collection<? extends FooterEntry>)newValue);
				return;
			case WebPackage.SITE__NEWS:
				getNews().clear();
				getNews().addAll((Collection<? extends NewsEntry>)newValue);
				return;
			case WebPackage.SITE__AUTHOR:
				getAuthor().clear();
				getAuthor().addAll((Collection<? extends Author>)newValue);
				return;
			case WebPackage.SITE__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case WebPackage.SITE__VERSIONS:
				getVersions().clear();
				getVersions().addAll((Collection<? extends Version>)newValue);
				return;
			case WebPackage.SITE__GALLERIES:
				getGalleries().clear();
				getGalleries().addAll((Collection<? extends Gallery>)newValue);
				return;
			case WebPackage.SITE__DESCRIPTION:
				setDescription((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case WebPackage.SITE__PAGES:
				getPages().clear();
				return;
			case WebPackage.SITE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WebPackage.SITE__FOOTER:
				getFooter().clear();
				return;
			case WebPackage.SITE__NEWS:
				getNews().clear();
				return;
			case WebPackage.SITE__AUTHOR:
				getAuthor().clear();
				return;
			case WebPackage.SITE__LINKS:
				getLinks().clear();
				return;
			case WebPackage.SITE__VERSIONS:
				getVersions().clear();
				return;
			case WebPackage.SITE__GALLERIES:
				getGalleries().clear();
				return;
			case WebPackage.SITE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case WebPackage.SITE__PAGES:
				return pages != null && !pages.isEmpty();
			case WebPackage.SITE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WebPackage.SITE__FOOTER:
				return footer != null && !footer.isEmpty();
			case WebPackage.SITE__NEWS:
				return news != null && !news.isEmpty();
			case WebPackage.SITE__AUTHOR:
				return author != null && !author.isEmpty();
			case WebPackage.SITE__LINKS:
				return links != null && !links.isEmpty();
			case WebPackage.SITE__VERSIONS:
				return versions != null && !versions.isEmpty();
			case WebPackage.SITE__GALLERIES:
				return galleries != null && !galleries.isEmpty();
			case WebPackage.SITE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //SiteImpl
