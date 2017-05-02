/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Archive Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ArchiveConfiguration#getFileSizeInMilliseconds <em>File Size In Milliseconds</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ArchiveConfiguration#getNumberOfFiles <em>Number Of Files</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getArchiveConfiguration()
 * @model
 * @generated
 */
public interface ArchiveConfiguration extends EObject
{
    /**
     * Returns the value of the '<em><b>File Size In Milliseconds</b></em>' attribute.
     * The default value is <code>"3600000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Size In Milliseconds</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>File Size In Milliseconds</em>' attribute.
     * @see #setFileSizeInMilliseconds(long)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getArchiveConfiguration_FileSizeInMilliseconds()
     * @model default="3600000"
     * @generated
     */
    long getFileSizeInMilliseconds ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ArchiveConfiguration#getFileSizeInMilliseconds <em>File Size In Milliseconds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>File Size In Milliseconds</em>' attribute.
     * @see #getFileSizeInMilliseconds()
     * @generated
     */
    void setFileSizeInMilliseconds ( long value );

    /**
     * Returns the value of the '<em><b>Number Of Files</b></em>' attribute.
     * The default value is <code>"2160"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Number Of Files</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Number Of Files</em>' attribute.
     * @see #setNumberOfFiles(long)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getArchiveConfiguration_NumberOfFiles()
     * @model default="2160"
     *        extendedMetaData="name='numberOfFiles'"
     * @generated
     */
    long getNumberOfFiles ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ArchiveConfiguration#getNumberOfFiles <em>Number Of Files</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Number Of Files</em>' attribute.
     * @see #getNumberOfFiles()
     * @generated
     */
    void setNumberOfFiles ( long value );

} // ArchiveConfiguration
