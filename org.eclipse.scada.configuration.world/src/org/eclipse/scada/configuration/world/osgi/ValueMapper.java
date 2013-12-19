/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Mapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ValueMapper#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ValueMapper#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ValueMapper#getDataMapper <em>Data Mapper</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueMapper()
 * @model
 * @generated
 */
public interface ValueMapper extends ItemFeatureEntry
{
    /**
     * Returns the value of the '<em><b>Source Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Attribute</em>' attribute.
     * @see #setSourceAttribute(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueMapper_SourceAttribute()
     * @model
     * @generated
     */
    String getSourceAttribute ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ValueMapper#getSourceAttribute <em>Source Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Attribute</em>' attribute.
     * @see #getSourceAttribute()
     * @generated
     */
    void setSourceAttribute ( String value );

    /**
     * Returns the value of the '<em><b>Target Attribute</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Attribute</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Attribute</em>' attribute.
     * @see #setTargetAttribute(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueMapper_TargetAttribute()
     * @model
     * @generated
     */
    String getTargetAttribute ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ValueMapper#getTargetAttribute <em>Target Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Attribute</em>' attribute.
     * @see #getTargetAttribute()
     * @generated
     */
    void setTargetAttribute ( String value );

    /**
     * Returns the value of the '<em><b>Data Mapper</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Mapper</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Mapper</em>' reference.
     * @see #setDataMapper(DataMapper)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueMapper_DataMapper()
     * @model required="true"
     * @generated
     */
    DataMapper getDataMapper ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ValueMapper#getDataMapper <em>Data Mapper</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Mapper</em>' reference.
     * @see #getDataMapper()
     * @generated
     */
    void setDataMapper ( DataMapper value );

} // ValueMapper
