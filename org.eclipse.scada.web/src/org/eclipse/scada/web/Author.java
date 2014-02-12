/**
 */
package org.eclipse.scada.web;

import java.net.URL;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.Author#getEmail <em>Email</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Author#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Author#getPlusLink <em>Plus Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.web.WebPackage#getAuthor()
 * @model
 * @generated
 */
public interface Author extends EObject {
	/**
	 * Returns the value of the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Email</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Email</em>' attribute.
	 * @see #setEmail(String)
	 * @see org.eclipse.scada.web.WebPackage#getAuthor_Email()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getEmail();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Author#getEmail <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Email</em>' attribute.
	 * @see #getEmail()
	 * @generated
	 */
	void setEmail(String value);

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
	 * @see org.eclipse.scada.web.WebPackage#getAuthor_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Author#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Plus Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plus Link</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plus Link</em>' attribute.
	 * @see #setPlusLink(URL)
	 * @see org.eclipse.scada.web.WebPackage#getAuthor_PlusLink()
	 * @model dataType="org.eclipse.scada.web.URL"
	 * @generated
	 */
	URL getPlusLink();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Author#getPlusLink <em>Plus Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plus Link</em>' attribute.
	 * @see #getPlusLink()
	 * @generated
	 */
	void setPlusLink(URL value);

} // Author
