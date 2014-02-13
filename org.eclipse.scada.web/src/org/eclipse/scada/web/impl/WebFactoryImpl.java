/**
 */
package org.eclipse.scada.web.impl;

import java.net.URL;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.scada.web.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WebFactoryImpl extends EFactoryImpl implements WebFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WebFactory init() {
		try {
			WebFactory theWebFactory = (WebFactory)EPackage.Registry.INSTANCE.getEFactory(WebPackage.eNS_URI);
			if (theWebFactory != null) {
				return theWebFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WebFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WebPackage.SITE: return createSite();
			case WebPackage.HTML_CONTENT: return createHtmlContent();
			case WebPackage.FOOTER_ENTRY: return createFooterEntry();
			case WebPackage.NEWS_ENTRY: return createNewsEntry();
			case WebPackage.NEWS_FEED_PAGE: return createNewsFeedPage();
			case WebPackage.CONTENT_PAGE: return createContentPage();
			case WebPackage.AUTHOR: return createAuthor();
			case WebPackage.RELEASE: return createRelease();
			case WebPackage.RELEASE_SECTION: return createReleaseSection();
			case WebPackage.LINK: return createLink();
			case WebPackage.VERSION: return createVersion();
			case WebPackage.GALLERY: return createGallery();
			case WebPackage.IMAGE: return createImage();
			case WebPackage.GALLERY_CONTENT: return createGalleryContent();
			case WebPackage.SOCIAL_BAR: return createSocialBar();
			case WebPackage.SOCIAL_INFORMATION: return createSocialInformation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case WebPackage.RELEASE_TYPE:
				return createReleaseTypeFromString(eDataType, initialValue);
			case WebPackage.URL:
				return createURLFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case WebPackage.RELEASE_TYPE:
				return convertReleaseTypeToString(eDataType, instanceValue);
			case WebPackage.URL:
				return convertURLToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Site createSite() {
		SiteImpl site = new SiteImpl();
		return site;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HtmlContent createHtmlContent() {
		HtmlContentImpl htmlContent = new HtmlContentImpl();
		return htmlContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FooterEntry createFooterEntry() {
		FooterEntryImpl footerEntry = new FooterEntryImpl();
		return footerEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewsEntry createNewsEntry() {
		NewsEntryImpl newsEntry = new NewsEntryImpl();
		return newsEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewsFeedPage createNewsFeedPage() {
		NewsFeedPageImpl newsFeedPage = new NewsFeedPageImpl();
		return newsFeedPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentPage createContentPage() {
		ContentPageImpl contentPage = new ContentPageImpl();
		return contentPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Author createAuthor() {
		AuthorImpl author = new AuthorImpl();
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Release createRelease() {
		ReleaseImpl release = new ReleaseImpl();
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseSection createReleaseSection() {
		ReleaseSectionImpl releaseSection = new ReleaseSectionImpl();
		return releaseSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link createLink() {
		LinkImpl link = new LinkImpl();
		return link;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gallery createGallery() {
		GalleryImpl gallery = new GalleryImpl();
		return gallery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Image createImage() {
		ImageImpl image = new ImageImpl();
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GalleryContent createGalleryContent() {
		GalleryContentImpl galleryContent = new GalleryContentImpl();
		return galleryContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SocialBar createSocialBar() {
		SocialBarImpl socialBar = new SocialBarImpl();
		return socialBar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SocialInformation createSocialInformation() {
		SocialInformationImpl socialInformation = new SocialInformationImpl();
		return socialInformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseType createReleaseTypeFromString(EDataType eDataType, String initialValue) {
		ReleaseType result = ReleaseType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReleaseTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URL createURLFromString(EDataType eDataType, String initialValue) {
		return (URL)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURLToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebPackage getWebPackage() {
		return (WebPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WebPackage getPackage() {
		return WebPackage.eINSTANCE;
	}

} //WebFactoryImpl
