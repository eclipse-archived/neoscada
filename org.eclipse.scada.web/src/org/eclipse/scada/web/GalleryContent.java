/**
 */
package org.eclipse.scada.web;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gallery Content</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.web.GalleryContent#getGallery <em>Gallery</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.web.WebPackage#getGalleryContent()
 * @model
 * @generated
 */
public interface GalleryContent extends Content {
	/**
	 * Returns the value of the '<em><b>Gallery</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gallery</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gallery</em>' reference.
	 * @see #setGallery(Gallery)
	 * @see org.eclipse.scada.web.WebPackage#getGalleryContent_Gallery()
	 * @model required="true"
	 * @generated
	 */
	Gallery getGallery();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.web.GalleryContent#getGallery <em>Gallery</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gallery</em>' reference.
	 * @see #getGallery()
	 * @generated
	 */
	void setGallery(Gallery value);

} // GalleryContent
