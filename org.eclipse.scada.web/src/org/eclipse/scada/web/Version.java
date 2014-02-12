/**
 */
package org.eclipse.scada.web;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.Version#getReleases <em>Releases</em>}</li>
 *   <li>{@link org.eclipse.scada.web.Version#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.web.WebPackage#getVersion()
 * @model
 * @generated
 */
public interface Version extends EObject {
	/**
	 * Returns the value of the '<em><b>Releases</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.web.Release}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.scada.web.Release#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Releases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Releases</em>' containment reference list.
	 * @see org.eclipse.scada.web.WebPackage#getVersion_Releases()
	 * @see org.eclipse.scada.web.Release#getVersion
	 * @model opposite="version" containment="true"
	 * @generated
	 */
	EList<Release> getReleases();

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
	 * @see org.eclipse.scada.web.WebPackage#getVersion_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.Version#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Version
