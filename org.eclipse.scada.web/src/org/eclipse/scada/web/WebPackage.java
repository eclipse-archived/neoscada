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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.web.WebFactory
 * @model kind="package"
 * @generated
 */
public interface WebPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "web";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/eclipsescada";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "web";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WebPackage eINSTANCE = org.eclipse.scada.web.impl.WebPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.SiteImpl <em>Site</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.SiteImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getSite()
	 * @generated
	 */
	int SITE = 0;

	/**
	 * The feature id for the '<em><b>Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__PAGES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Footer</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__FOOTER = 2;

	/**
	 * The feature id for the '<em><b>News</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__NEWS = 3;

	/**
	 * The feature id for the '<em><b>Author</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__AUTHOR = 4;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__LINKS = 5;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__VERSIONS = 6;

	/**
	 * The feature id for the '<em><b>Galleries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__GALLERIES = 7;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__DESCRIPTION = 8;

	/**
	 * The number of structural features of the '<em>Site</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE_FEATURE_COUNT = 9;

	/**
	 * The number of operations of the '<em>Site</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.Container <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.Container
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.PageImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Site</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__SITE = 2;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.Content <em>Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.Content
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getContent()
	 * @generated
	 */
	int CONTENT = 2;

	/**
	 * The number of structural features of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.HtmlContentImpl <em>Html Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.HtmlContentImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getHtmlContent()
	 * @generated
	 */
	int HTML_CONTENT = 3;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTML_CONTENT__DATA = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Html Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTML_CONTENT_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Html Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HTML_CONTENT_OPERATION_COUNT = CONTENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.FooterEntryImpl <em>Footer Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.FooterEntryImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getFooterEntry()
	 * @generated
	 */
	int FOOTER_ENTRY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTER_ENTRY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTER_ENTRY__LINK = 1;

	/**
	 * The number of structural features of the '<em>Footer Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTER_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Footer Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOOTER_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__CONTENT = 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.NewsEntryImpl <em>News Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.NewsEntryImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getNewsEntry()
	 * @generated
	 */
	int NEWS_ENTRY = 5;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_ENTRY__CONTENT = CONTAINER__CONTENT;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_ENTRY__TITLE = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_ENTRY__DATE = CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_ENTRY__AUTHOR = CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_ENTRY__DESCRIPTION = CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>News Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_ENTRY_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>News Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_ENTRY_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.NewsFeedPageImpl <em>News Feed Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.NewsFeedPageImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getNewsFeedPage()
	 * @generated
	 */
	int NEWS_FEED_PAGE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_FEED_PAGE__ID = PAGE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_FEED_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Site</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_FEED_PAGE__SITE = PAGE__SITE;

	/**
	 * The number of structural features of the '<em>News Feed Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_FEED_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>News Feed Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEWS_FEED_PAGE_OPERATION_COUNT = PAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.ContentPageImpl <em>Content Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.ContentPageImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getContentPage()
	 * @generated
	 */
	int CONTENT_PAGE = 8;

	/**
	 * The feature id for the '<em><b>Content</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE__CONTENT = CONTAINER__CONTENT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE__ID = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE__NAME = CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Site</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE__SITE = CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Content Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Content Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.AuthorImpl <em>Author</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.AuthorImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getAuthor()
	 * @generated
	 */
	int AUTHOR = 9;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__EMAIL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NAME = 1;

	/**
	 * The feature id for the '<em><b>Plus Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__PLUS_LINK = 2;

	/**
	 * The number of structural features of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.ReleaseImpl <em>Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.ReleaseImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getRelease()
	 * @generated
	 */
	int RELEASE = 10;

	/**
	 * The feature id for the '<em><b>Build Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__BUILD_ID = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Release Notes Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__RELEASE_NOTES_LINK = 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__VERSION = 4;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__DATE = 5;

	/**
	 * The feature id for the '<em><b>Unqualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__UNQUALIFIED_NAME = 6;

	/**
	 * The feature id for the '<em><b>Alternate Msi Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__ALTERNATE_MSI_NAME = 7;

	/**
	 * The number of structural features of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.ReleaseSectionImpl <em>Release Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.ReleaseSectionImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getReleaseSection()
	 * @generated
	 */
	int RELEASE_SECTION = 11;

	/**
	 * The feature id for the '<em><b>Release</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_SECTION__RELEASE = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Release Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_SECTION_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Release Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_SECTION_OPERATION_COUNT = CONTENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.LinkImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 12;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__LABEL = 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.VersionImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 13;

	/**
	 * The feature id for the '<em><b>Releases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__RELEASES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__NAME = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__STATE = 2;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.GalleryImpl <em>Gallery</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.GalleryImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getGallery()
	 * @generated
	 */
	int GALLERY = 14;

	/**
	 * The feature id for the '<em><b>Images</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GALLERY__IMAGES = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GALLERY__LABEL = 1;

	/**
	 * The number of structural features of the '<em>Gallery</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GALLERY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Gallery</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GALLERY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.ImageImpl <em>Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.ImageImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getImage()
	 * @generated
	 */
	int IMAGE = 15;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__LABEL = 0;

	/**
	 * The feature id for the '<em><b>Src</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE__SRC = 1;

	/**
	 * The number of structural features of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.GalleryContentImpl <em>Gallery Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.GalleryContentImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getGalleryContent()
	 * @generated
	 */
	int GALLERY_CONTENT = 16;

	/**
	 * The feature id for the '<em><b>Gallery</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GALLERY_CONTENT__GALLERY = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gallery Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GALLERY_CONTENT_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Gallery Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GALLERY_CONTENT_OPERATION_COUNT = CONTENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.SocialBarImpl <em>Social Bar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.SocialBarImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getSocialBar()
	 * @generated
	 */
	int SOCIAL_BAR = 17;

	/**
	 * The feature id for the '<em><b>Information</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_BAR__INFORMATION = CONTENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Social Bar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_BAR_FEATURE_COUNT = CONTENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Social Bar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_BAR_OPERATION_COUNT = CONTENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.impl.SocialInformationImpl <em>Social Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.impl.SocialInformationImpl
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getSocialInformation()
	 * @generated
	 */
	int SOCIAL_INFORMATION = 18;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_INFORMATION__URL = 0;

	/**
	 * The feature id for the '<em><b>Plus Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_INFORMATION__PLUS_URL = 1;

	/**
	 * The feature id for the '<em><b>Facebook Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_INFORMATION__FACEBOOK_URL = 2;

	/**
	 * The feature id for the '<em><b>Twitter Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_INFORMATION__TWITTER_URL = 3;

	/**
	 * The number of structural features of the '<em>Social Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_INFORMATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Social Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOCIAL_INFORMATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.ReleaseType <em>Release Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.ReleaseType
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getReleaseType()
	 * @generated
	 */
	int RELEASE_TYPE = 19;


	/**
	 * The meta object id for the '{@link org.eclipse.scada.web.VersionState <em>Version State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.web.VersionState
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getVersionState()
	 * @generated
	 */
	int VERSION_STATE = 20;

	/**
	 * The meta object id for the '<em>URL</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.net.URL
	 * @see org.eclipse.scada.web.impl.WebPackageImpl#getURL()
	 * @generated
	 */
	int URL = 21;


	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Site <em>Site</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Site</em>'.
	 * @see org.eclipse.scada.web.Site
	 * @generated
	 */
	EClass getSite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Site#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pages</em>'.
	 * @see org.eclipse.scada.web.Site#getPages()
	 * @see #getSite()
	 * @generated
	 */
	EReference getSite_Pages();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Site#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.scada.web.Site#getName()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Site#getFooter <em>Footer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Footer</em>'.
	 * @see org.eclipse.scada.web.Site#getFooter()
	 * @see #getSite()
	 * @generated
	 */
	EReference getSite_Footer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Site#getNews <em>News</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>News</em>'.
	 * @see org.eclipse.scada.web.Site#getNews()
	 * @see #getSite()
	 * @generated
	 */
	EReference getSite_News();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Site#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Author</em>'.
	 * @see org.eclipse.scada.web.Site#getAuthor()
	 * @see #getSite()
	 * @generated
	 */
	EReference getSite_Author();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Site#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.eclipse.scada.web.Site#getLinks()
	 * @see #getSite()
	 * @generated
	 */
	EReference getSite_Links();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Site#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see org.eclipse.scada.web.Site#getVersions()
	 * @see #getSite()
	 * @generated
	 */
	EReference getSite_Versions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Site#getGalleries <em>Galleries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Galleries</em>'.
	 * @see org.eclipse.scada.web.Site#getGalleries()
	 * @see #getSite()
	 * @generated
	 */
	EReference getSite_Galleries();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Site#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.scada.web.Site#getDescription()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see org.eclipse.scada.web.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Page#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.scada.web.Page#getId()
	 * @see #getPage()
	 * @generated
	 */
	EAttribute getPage_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Page#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.scada.web.Page#getName()
	 * @see #getPage()
	 * @generated
	 */
	EAttribute getPage_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.scada.web.Page#getSite <em>Site</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Site</em>'.
	 * @see org.eclipse.scada.web.Page#getSite()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Site();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Content <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content</em>'.
	 * @see org.eclipse.scada.web.Content
	 * @generated
	 */
	EClass getContent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.HtmlContent <em>Html Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Html Content</em>'.
	 * @see org.eclipse.scada.web.HtmlContent
	 * @generated
	 */
	EClass getHtmlContent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.HtmlContent#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipse.scada.web.HtmlContent#getData()
	 * @see #getHtmlContent()
	 * @generated
	 */
	EAttribute getHtmlContent_Data();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.FooterEntry <em>Footer Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Footer Entry</em>'.
	 * @see org.eclipse.scada.web.FooterEntry
	 * @generated
	 */
	EClass getFooterEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.FooterEntry#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.scada.web.FooterEntry#getName()
	 * @see #getFooterEntry()
	 * @generated
	 */
	EAttribute getFooterEntry_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.FooterEntry#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link</em>'.
	 * @see org.eclipse.scada.web.FooterEntry#getLink()
	 * @see #getFooterEntry()
	 * @generated
	 */
	EAttribute getFooterEntry_Link();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.NewsEntry <em>News Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>News Entry</em>'.
	 * @see org.eclipse.scada.web.NewsEntry
	 * @generated
	 */
	EClass getNewsEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.NewsEntry#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.eclipse.scada.web.NewsEntry#getTitle()
	 * @see #getNewsEntry()
	 * @generated
	 */
	EAttribute getNewsEntry_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.NewsEntry#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.scada.web.NewsEntry#getDate()
	 * @see #getNewsEntry()
	 * @generated
	 */
	EAttribute getNewsEntry_Date();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.scada.web.NewsEntry#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Author</em>'.
	 * @see org.eclipse.scada.web.NewsEntry#getAuthor()
	 * @see #getNewsEntry()
	 * @generated
	 */
	EReference getNewsEntry_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.NewsEntry#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.scada.web.NewsEntry#getDescription()
	 * @see #getNewsEntry()
	 * @generated
	 */
	EAttribute getNewsEntry_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.eclipse.scada.web.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Container#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Content</em>'.
	 * @see org.eclipse.scada.web.Container#getContent()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Content();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.NewsFeedPage <em>News Feed Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>News Feed Page</em>'.
	 * @see org.eclipse.scada.web.NewsFeedPage
	 * @generated
	 */
	EClass getNewsFeedPage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.ContentPage <em>Content Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Page</em>'.
	 * @see org.eclipse.scada.web.ContentPage
	 * @generated
	 */
	EClass getContentPage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author</em>'.
	 * @see org.eclipse.scada.web.Author
	 * @generated
	 */
	EClass getAuthor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Author#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.eclipse.scada.web.Author#getEmail()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Email();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Author#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.scada.web.Author#getName()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Author#getPlusLink <em>Plus Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plus Link</em>'.
	 * @see org.eclipse.scada.web.Author#getPlusLink()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_PlusLink();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release</em>'.
	 * @see org.eclipse.scada.web.Release
	 * @generated
	 */
	EClass getRelease();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Release#getBuildId <em>Build Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Build Id</em>'.
	 * @see org.eclipse.scada.web.Release#getBuildId()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_BuildId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Release#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.scada.web.Release#getType()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Release#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.scada.web.Release#getName()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Release#getReleaseNotesLink <em>Release Notes Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release Notes Link</em>'.
	 * @see org.eclipse.scada.web.Release#getReleaseNotesLink()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_ReleaseNotesLink();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.scada.web.Release#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Version</em>'.
	 * @see org.eclipse.scada.web.Release#getVersion()
	 * @see #getRelease()
	 * @generated
	 */
	EReference getRelease_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Release#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.scada.web.Release#getDate()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Release#getUnqualifiedName <em>Unqualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unqualified Name</em>'.
	 * @see org.eclipse.scada.web.Release#getUnqualifiedName()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_UnqualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Release#getAlternateMsiName <em>Alternate Msi Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alternate Msi Name</em>'.
	 * @see org.eclipse.scada.web.Release#getAlternateMsiName()
	 * @see #getRelease()
	 * @generated
	 */
	EAttribute getRelease_AlternateMsiName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.ReleaseSection <em>Release Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release Section</em>'.
	 * @see org.eclipse.scada.web.ReleaseSection
	 * @generated
	 */
	EClass getReleaseSection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.scada.web.ReleaseSection#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Release</em>'.
	 * @see org.eclipse.scada.web.ReleaseSection#getRelease()
	 * @see #getReleaseSection()
	 * @generated
	 */
	EReference getReleaseSection_Release();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.eclipse.scada.web.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Link#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.eclipse.scada.web.Link#getTarget()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Link#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.scada.web.Link#getLabel()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.eclipse.scada.web.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Version#getReleases <em>Releases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Releases</em>'.
	 * @see org.eclipse.scada.web.Version#getReleases()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_Releases();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Version#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.scada.web.Version#getName()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Version#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.eclipse.scada.web.Version#getState()
	 * @see #getVersion()
	 * @generated
	 */
	EAttribute getVersion_State();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Gallery <em>Gallery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gallery</em>'.
	 * @see org.eclipse.scada.web.Gallery
	 * @generated
	 */
	EClass getGallery();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.web.Gallery#getImages <em>Images</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Images</em>'.
	 * @see org.eclipse.scada.web.Gallery#getImages()
	 * @see #getGallery()
	 * @generated
	 */
	EReference getGallery_Images();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Gallery#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.scada.web.Gallery#getLabel()
	 * @see #getGallery()
	 * @generated
	 */
	EAttribute getGallery_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image</em>'.
	 * @see org.eclipse.scada.web.Image
	 * @generated
	 */
	EClass getImage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Image#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.scada.web.Image#getLabel()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.Image#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Src</em>'.
	 * @see org.eclipse.scada.web.Image#getSrc()
	 * @see #getImage()
	 * @generated
	 */
	EAttribute getImage_Src();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.GalleryContent <em>Gallery Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gallery Content</em>'.
	 * @see org.eclipse.scada.web.GalleryContent
	 * @generated
	 */
	EClass getGalleryContent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.scada.web.GalleryContent#getGallery <em>Gallery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gallery</em>'.
	 * @see org.eclipse.scada.web.GalleryContent#getGallery()
	 * @see #getGalleryContent()
	 * @generated
	 */
	EReference getGalleryContent_Gallery();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.SocialBar <em>Social Bar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Social Bar</em>'.
	 * @see org.eclipse.scada.web.SocialBar
	 * @generated
	 */
	EClass getSocialBar();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.scada.web.SocialBar#getInformation <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Information</em>'.
	 * @see org.eclipse.scada.web.SocialBar#getInformation()
	 * @see #getSocialBar()
	 * @generated
	 */
	EReference getSocialBar_Information();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.web.SocialInformation <em>Social Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Social Information</em>'.
	 * @see org.eclipse.scada.web.SocialInformation
	 * @generated
	 */
	EClass getSocialInformation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.SocialInformation#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.eclipse.scada.web.SocialInformation#getUrl()
	 * @see #getSocialInformation()
	 * @generated
	 */
	EAttribute getSocialInformation_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.SocialInformation#getPlusUrl <em>Plus Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plus Url</em>'.
	 * @see org.eclipse.scada.web.SocialInformation#getPlusUrl()
	 * @see #getSocialInformation()
	 * @generated
	 */
	EAttribute getSocialInformation_PlusUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.SocialInformation#getFacebookUrl <em>Facebook Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Url</em>'.
	 * @see org.eclipse.scada.web.SocialInformation#getFacebookUrl()
	 * @see #getSocialInformation()
	 * @generated
	 */
	EAttribute getSocialInformation_FacebookUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.web.SocialInformation#getTwitterUrl <em>Twitter Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Twitter Url</em>'.
	 * @see org.eclipse.scada.web.SocialInformation#getTwitterUrl()
	 * @see #getSocialInformation()
	 * @generated
	 */
	EAttribute getSocialInformation_TwitterUrl();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.scada.web.ReleaseType <em>Release Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Release Type</em>'.
	 * @see org.eclipse.scada.web.ReleaseType
	 * @generated
	 */
	EEnum getReleaseType();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.scada.web.VersionState <em>Version State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Version State</em>'.
	 * @see org.eclipse.scada.web.VersionState
	 * @generated
	 */
	EEnum getVersionState();

	/**
	 * Returns the meta object for data type '{@link java.net.URL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URL</em>'.
	 * @see java.net.URL
	 * @model instanceClass="java.net.URL"
	 * @generated
	 */
	EDataType getURL();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WebFactory getWebFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.SiteImpl <em>Site</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.SiteImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getSite()
		 * @generated
		 */
		EClass SITE = eINSTANCE.getSite();

		/**
		 * The meta object literal for the '<em><b>Pages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SITE__PAGES = eINSTANCE.getSite_Pages();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__NAME = eINSTANCE.getSite_Name();

		/**
		 * The meta object literal for the '<em><b>Footer</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SITE__FOOTER = eINSTANCE.getSite_Footer();

		/**
		 * The meta object literal for the '<em><b>News</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SITE__NEWS = eINSTANCE.getSite_News();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SITE__AUTHOR = eINSTANCE.getSite_Author();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SITE__LINKS = eINSTANCE.getSite_Links();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SITE__VERSIONS = eINSTANCE.getSite_Versions();

		/**
		 * The meta object literal for the '<em><b>Galleries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SITE__GALLERIES = eINSTANCE.getSite_Galleries();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__DESCRIPTION = eINSTANCE.getSite_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.PageImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE__ID = eINSTANCE.getPage_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE__NAME = eINSTANCE.getPage_Name();

		/**
		 * The meta object literal for the '<em><b>Site</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__SITE = eINSTANCE.getPage_Site();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.Content <em>Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.Content
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getContent()
		 * @generated
		 */
		EClass CONTENT = eINSTANCE.getContent();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.HtmlContentImpl <em>Html Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.HtmlContentImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getHtmlContent()
		 * @generated
		 */
		EClass HTML_CONTENT = eINSTANCE.getHtmlContent();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HTML_CONTENT__DATA = eINSTANCE.getHtmlContent_Data();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.FooterEntryImpl <em>Footer Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.FooterEntryImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getFooterEntry()
		 * @generated
		 */
		EClass FOOTER_ENTRY = eINSTANCE.getFooterEntry();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOOTER_ENTRY__NAME = eINSTANCE.getFooterEntry_Name();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOOTER_ENTRY__LINK = eINSTANCE.getFooterEntry_Link();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.NewsEntryImpl <em>News Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.NewsEntryImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getNewsEntry()
		 * @generated
		 */
		EClass NEWS_ENTRY = eINSTANCE.getNewsEntry();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEWS_ENTRY__TITLE = eINSTANCE.getNewsEntry_Title();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEWS_ENTRY__DATE = eINSTANCE.getNewsEntry_Date();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEWS_ENTRY__AUTHOR = eINSTANCE.getNewsEntry_Author();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEWS_ENTRY__DESCRIPTION = eINSTANCE.getNewsEntry_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.Container <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.Container
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__CONTENT = eINSTANCE.getContainer_Content();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.NewsFeedPageImpl <em>News Feed Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.NewsFeedPageImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getNewsFeedPage()
		 * @generated
		 */
		EClass NEWS_FEED_PAGE = eINSTANCE.getNewsFeedPage();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.ContentPageImpl <em>Content Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.ContentPageImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getContentPage()
		 * @generated
		 */
		EClass CONTENT_PAGE = eINSTANCE.getContentPage();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.AuthorImpl <em>Author</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.AuthorImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getAuthor()
		 * @generated
		 */
		EClass AUTHOR = eINSTANCE.getAuthor();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__EMAIL = eINSTANCE.getAuthor_Email();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__NAME = eINSTANCE.getAuthor_Name();

		/**
		 * The meta object literal for the '<em><b>Plus Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__PLUS_LINK = eINSTANCE.getAuthor_PlusLink();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.ReleaseImpl <em>Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.ReleaseImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getRelease()
		 * @generated
		 */
		EClass RELEASE = eINSTANCE.getRelease();

		/**
		 * The meta object literal for the '<em><b>Build Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__BUILD_ID = eINSTANCE.getRelease_BuildId();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__TYPE = eINSTANCE.getRelease_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__NAME = eINSTANCE.getRelease_Name();

		/**
		 * The meta object literal for the '<em><b>Release Notes Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__RELEASE_NOTES_LINK = eINSTANCE.getRelease_ReleaseNotesLink();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELEASE__VERSION = eINSTANCE.getRelease_Version();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__DATE = eINSTANCE.getRelease_Date();

		/**
		 * The meta object literal for the '<em><b>Unqualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__UNQUALIFIED_NAME = eINSTANCE.getRelease_UnqualifiedName();

		/**
		 * The meta object literal for the '<em><b>Alternate Msi Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE__ALTERNATE_MSI_NAME = eINSTANCE.getRelease_AlternateMsiName();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.ReleaseSectionImpl <em>Release Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.ReleaseSectionImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getReleaseSection()
		 * @generated
		 */
		EClass RELEASE_SECTION = eINSTANCE.getReleaseSection();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELEASE_SECTION__RELEASE = eINSTANCE.getReleaseSection_Release();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.LinkImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__TARGET = eINSTANCE.getLink_Target();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__LABEL = eINSTANCE.getLink_Label();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.VersionImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Releases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__RELEASES = eINSTANCE.getVersion_Releases();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__NAME = eINSTANCE.getVersion_Name();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION__STATE = eINSTANCE.getVersion_State();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.GalleryImpl <em>Gallery</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.GalleryImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getGallery()
		 * @generated
		 */
		EClass GALLERY = eINSTANCE.getGallery();

		/**
		 * The meta object literal for the '<em><b>Images</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GALLERY__IMAGES = eINSTANCE.getGallery_Images();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GALLERY__LABEL = eINSTANCE.getGallery_Label();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.ImageImpl <em>Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.ImageImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getImage()
		 * @generated
		 */
		EClass IMAGE = eINSTANCE.getImage();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__LABEL = eINSTANCE.getImage_Label();

		/**
		 * The meta object literal for the '<em><b>Src</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAGE__SRC = eINSTANCE.getImage_Src();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.GalleryContentImpl <em>Gallery Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.GalleryContentImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getGalleryContent()
		 * @generated
		 */
		EClass GALLERY_CONTENT = eINSTANCE.getGalleryContent();

		/**
		 * The meta object literal for the '<em><b>Gallery</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GALLERY_CONTENT__GALLERY = eINSTANCE.getGalleryContent_Gallery();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.SocialBarImpl <em>Social Bar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.SocialBarImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getSocialBar()
		 * @generated
		 */
		EClass SOCIAL_BAR = eINSTANCE.getSocialBar();

		/**
		 * The meta object literal for the '<em><b>Information</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOCIAL_BAR__INFORMATION = eINSTANCE.getSocialBar_Information();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.impl.SocialInformationImpl <em>Social Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.impl.SocialInformationImpl
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getSocialInformation()
		 * @generated
		 */
		EClass SOCIAL_INFORMATION = eINSTANCE.getSocialInformation();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOCIAL_INFORMATION__URL = eINSTANCE.getSocialInformation_Url();

		/**
		 * The meta object literal for the '<em><b>Plus Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOCIAL_INFORMATION__PLUS_URL = eINSTANCE.getSocialInformation_PlusUrl();

		/**
		 * The meta object literal for the '<em><b>Facebook Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOCIAL_INFORMATION__FACEBOOK_URL = eINSTANCE.getSocialInformation_FacebookUrl();

		/**
		 * The meta object literal for the '<em><b>Twitter Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOCIAL_INFORMATION__TWITTER_URL = eINSTANCE.getSocialInformation_TwitterUrl();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.ReleaseType <em>Release Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.ReleaseType
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getReleaseType()
		 * @generated
		 */
		EEnum RELEASE_TYPE = eINSTANCE.getReleaseType();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.web.VersionState <em>Version State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.web.VersionState
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getVersionState()
		 * @generated
		 */
		EEnum VERSION_STATE = eINSTANCE.getVersionState();

		/**
		 * The meta object literal for the '<em>URL</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.net.URL
		 * @see org.eclipse.scada.web.impl.WebPackageImpl#getURL()
		 * @generated
		 */
		EDataType URL = eINSTANCE.getURL();

	}

} //WebPackage
