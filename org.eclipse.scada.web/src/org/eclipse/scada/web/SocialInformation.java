/**
 */
package org.eclipse.scada.web;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Social Information</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.SocialInformation#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.scada.web.SocialInformation#getPlusUrl <em>Plus Url</em>}</li>
 *   <li>{@link org.eclipse.scada.web.SocialInformation#getFacebookUrl <em>Facebook Url</em>}</li>
 *   <li>{@link org.eclipse.scada.web.SocialInformation#getTwitterUrl <em>Twitter Url</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.web.WebPackage#getSocialInformation()
 * @model
 * @generated
 */
public interface SocialInformation extends EObject {
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
	 * @see org.eclipse.scada.web.WebPackage#getSocialInformation_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.SocialInformation#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Plus Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plus Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plus Url</em>' attribute.
	 * @see #setPlusUrl(String)
	 * @see org.eclipse.scada.web.WebPackage#getSocialInformation_PlusUrl()
	 * @model
	 * @generated
	 */
	String getPlusUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.SocialInformation#getPlusUrl <em>Plus Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plus Url</em>' attribute.
	 * @see #getPlusUrl()
	 * @generated
	 */
	void setPlusUrl(String value);

	/**
	 * Returns the value of the '<em><b>Facebook Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facebook Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facebook Url</em>' attribute.
	 * @see #setFacebookUrl(String)
	 * @see org.eclipse.scada.web.WebPackage#getSocialInformation_FacebookUrl()
	 * @model
	 * @generated
	 */
	String getFacebookUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.SocialInformation#getFacebookUrl <em>Facebook Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facebook Url</em>' attribute.
	 * @see #getFacebookUrl()
	 * @generated
	 */
	void setFacebookUrl(String value);

	/**
	 * Returns the value of the '<em><b>Twitter Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Twitter Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Twitter Url</em>' attribute.
	 * @see #setTwitterUrl(String)
	 * @see org.eclipse.scada.web.WebPackage#getSocialInformation_TwitterUrl()
	 * @model
	 * @generated
	 */
	String getTwitterUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.SocialInformation#getTwitterUrl <em>Twitter Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Twitter Url</em>' attribute.
	 * @see #getTwitterUrl()
	 * @generated
	 */
	void setTwitterUrl(String value);

} // SocialInformation
