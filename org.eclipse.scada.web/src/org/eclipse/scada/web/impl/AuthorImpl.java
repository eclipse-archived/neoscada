/**
 */
package org.eclipse.scada.web.impl;

import java.net.URL;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.web.Author;
import org.eclipse.scada.web.WebPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.impl.AuthorImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.AuthorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.web.impl.AuthorImpl#getPlusLink <em>Plus Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuthorImpl extends MinimalEObjectImpl.Container implements Author {
	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;

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
	 * The default value of the '{@link #getPlusLink() <em>Plus Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlusLink()
	 * @generated
	 * @ordered
	 */
	protected static final URL PLUS_LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPlusLink() <em>Plus Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlusLink()
	 * @generated
	 * @ordered
	 */
	protected URL plusLink = PLUS_LINK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuthorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WebPackage.Literals.AUTHOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.AUTHOR__EMAIL, oldEmail, email));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.AUTHOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URL getPlusLink() {
		return plusLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlusLink(URL newPlusLink) {
		URL oldPlusLink = plusLink;
		plusLink = newPlusLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WebPackage.AUTHOR__PLUS_LINK, oldPlusLink, plusLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WebPackage.AUTHOR__EMAIL:
				return getEmail();
			case WebPackage.AUTHOR__NAME:
				return getName();
			case WebPackage.AUTHOR__PLUS_LINK:
				return getPlusLink();
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
			case WebPackage.AUTHOR__EMAIL:
				setEmail((String)newValue);
				return;
			case WebPackage.AUTHOR__NAME:
				setName((String)newValue);
				return;
			case WebPackage.AUTHOR__PLUS_LINK:
				setPlusLink((URL)newValue);
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
			case WebPackage.AUTHOR__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case WebPackage.AUTHOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WebPackage.AUTHOR__PLUS_LINK:
				setPlusLink(PLUS_LINK_EDEFAULT);
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
			case WebPackage.AUTHOR__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
			case WebPackage.AUTHOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WebPackage.AUTHOR__PLUS_LINK:
				return PLUS_LINK_EDEFAULT == null ? plusLink != null : !PLUS_LINK_EDEFAULT.equals(plusLink);
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
		result.append(" (email: ");
		result.append(email);
		result.append(", name: ");
		result.append(name);
		result.append(", plusLink: ");
		result.append(plusLink);
		result.append(')');
		return result.toString();
	}

} //AuthorImpl
