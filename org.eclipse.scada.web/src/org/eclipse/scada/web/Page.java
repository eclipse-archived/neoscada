/**
 */
package org.eclipse.scada.web;

import org.eclipse.emf.ecore.EObject;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.Page#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Page#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Page#getSite <em>Site</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.web.WebPackage#getPage()
 * @model abstract="true"
 * @generated
 */
public interface Page extends EObject {

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.scada.web.WebPackage#getPage_Id()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Page#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see org.eclipse.scada.web.WebPackage#getPage_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Page#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Site</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.scada.web.Site#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Site</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Site</em>' container reference.
	 * @see #setSite(Site)
	 * @see org.eclipse.scada.web.WebPackage#getPage_Site()
	 * @see org.eclipse.scada.web.Site#getPages
	 * @model opposite="pages" transient="false"
	 * @generated
	 */
	Site getSite();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Page#getSite <em>Site</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Site</em>' container reference.
	 * @see #getSite()
	 * @generated
	 */
	void setSite(Site value);
} // Page
