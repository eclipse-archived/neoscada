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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.web.SocialInformation;
import org.eclipse.scada.web.WebPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Social Information</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.impl.SocialInformationImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SocialInformationImpl#getPlusUrl <em>Plus Url</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SocialInformationImpl#getFacebookUrl <em>Facebook Url</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.SocialInformationImpl#getTwitterUrl <em>Twitter Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SocialInformationImpl extends MinimalEObjectImpl.Container implements SocialInformation {
	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPlusUrl() <em>Plus Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlusUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String PLUS_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlusUrl() <em>Plus Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlusUrl()
	 * @generated
	 * @ordered
	 */
	protected String plusUrl = PLUS_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getFacebookUrl() <em>Facebook Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String FACEBOOK_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFacebookUrl() <em>Facebook Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacebookUrl()
	 * @generated
	 * @ordered
	 */
	protected String facebookUrl = FACEBOOK_URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTwitterUrl() <em>Twitter Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String TWITTER_URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTwitterUrl() <em>Twitter Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTwitterUrl()
	 * @generated
	 * @ordered
	 */
	protected String twitterUrl = TWITTER_URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SocialInformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WebPackage.Literals.SOCIAL_INFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.SOCIAL_INFORMATION__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlusUrl() {
		return plusUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlusUrl(String newPlusUrl) {
		String oldPlusUrl = plusUrl;
		plusUrl = newPlusUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.SOCIAL_INFORMATION__PLUS_URL, oldPlusUrl, plusUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFacebookUrl() {
		return facebookUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacebookUrl(String newFacebookUrl) {
		String oldFacebookUrl = facebookUrl;
		facebookUrl = newFacebookUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.SOCIAL_INFORMATION__FACEBOOK_URL, oldFacebookUrl, facebookUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTwitterUrl() {
		return twitterUrl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTwitterUrl(String newTwitterUrl) {
		String oldTwitterUrl = twitterUrl;
		twitterUrl = newTwitterUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.SOCIAL_INFORMATION__TWITTER_URL, oldTwitterUrl, twitterUrl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WebPackage.SOCIAL_INFORMATION__URL:
				return getUrl();
			case WebPackage.SOCIAL_INFORMATION__PLUS_URL:
				return getPlusUrl();
			case WebPackage.SOCIAL_INFORMATION__FACEBOOK_URL:
				return getFacebookUrl();
			case WebPackage.SOCIAL_INFORMATION__TWITTER_URL:
				return getTwitterUrl();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WebPackage.SOCIAL_INFORMATION__URL:
				setUrl((String)newValue);
				return;
			case WebPackage.SOCIAL_INFORMATION__PLUS_URL:
				setPlusUrl((String)newValue);
				return;
			case WebPackage.SOCIAL_INFORMATION__FACEBOOK_URL:
				setFacebookUrl((String)newValue);
				return;
			case WebPackage.SOCIAL_INFORMATION__TWITTER_URL:
				setTwitterUrl((String)newValue);
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
			case WebPackage.SOCIAL_INFORMATION__URL:
				setUrl(URL_EDEFAULT);
				return;
			case WebPackage.SOCIAL_INFORMATION__PLUS_URL:
				setPlusUrl(PLUS_URL_EDEFAULT);
				return;
			case WebPackage.SOCIAL_INFORMATION__FACEBOOK_URL:
				setFacebookUrl(FACEBOOK_URL_EDEFAULT);
				return;
			case WebPackage.SOCIAL_INFORMATION__TWITTER_URL:
				setTwitterUrl(TWITTER_URL_EDEFAULT);
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
			case WebPackage.SOCIAL_INFORMATION__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case WebPackage.SOCIAL_INFORMATION__PLUS_URL:
				return PLUS_URL_EDEFAULT == null ? plusUrl != null : !PLUS_URL_EDEFAULT.equals(plusUrl);
			case WebPackage.SOCIAL_INFORMATION__FACEBOOK_URL:
				return FACEBOOK_URL_EDEFAULT == null ? facebookUrl != null : !FACEBOOK_URL_EDEFAULT.equals(facebookUrl);
			case WebPackage.SOCIAL_INFORMATION__TWITTER_URL:
				return TWITTER_URL_EDEFAULT == null ? twitterUrl != null : !TWITTER_URL_EDEFAULT.equals(twitterUrl);
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
		result.append(" (url: ");
		result.append(url);
		result.append(", plusUrl: ");
		result.append(plusUrl);
		result.append(", facebookUrl: ");
		result.append(facebookUrl);
		result.append(", twitterUrl: ");
		result.append(twitterUrl);
		result.append(')');
		return result.toString();
	}

} //SocialInformationImpl
