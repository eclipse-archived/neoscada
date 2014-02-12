/**
 */
package org.eclipse.scada.web;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Release Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.ReleaseSection#getRelease <em>Release</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.web.WebPackage#getReleaseSection()
 * @model
 * @generated
 */
public interface ReleaseSection extends Content {
	/**
	 * Returns the value of the '<em><b>Release</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Release</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Release</em>' reference.
	 * @see #setRelease(Release)
	 * @see org.eclipse.scada.web.WebPackage#getReleaseSection_Release()
	 * @model keys="buildId"
	 * @generated
	 */
	Release getRelease();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.ReleaseSection#getRelease <em>Release</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release</em>' reference.
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(Release value);

} // ReleaseSection
