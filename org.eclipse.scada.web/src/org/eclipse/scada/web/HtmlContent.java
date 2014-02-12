/**
 */
package org.eclipse.scada.web;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Html Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.HtmlContent#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.web.WebPackage#getHtmlContent()
 * @model
 * @generated
 */
public interface HtmlContent extends Content {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(String)
	 * @see org.eclipse.scada.web.WebPackage#getHtmlContent_Data()
	 * @model required="true"
	 *        extendedMetaData="kind='element'"
	 * @generated
	 */
	String getData();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.HtmlContent#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(String value);

} // HtmlContent
