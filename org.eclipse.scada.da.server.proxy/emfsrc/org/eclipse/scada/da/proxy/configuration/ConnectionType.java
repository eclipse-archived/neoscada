/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.proxy.configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getFolder <em>Folder</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getConnectionType()
 * @model extendedMetaData="name='ConnectionType' kind='elementOnly'"
 * @generated
 */
public interface ConnectionType extends EObject
{

    /**
     * Returns the value of the '<em><b>Folder</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Folder</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Folder</em>' containment reference.
     * @see #setFolder(FolderType)
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getConnectionType_Folder()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='folder' namespace='##targetNamespace'"
     * @generated
     */
    FolderType getFolder ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getFolder <em>Folder</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Folder</em>' containment reference.
     * @see #getFolder()
     * @generated
     */
    void setFolder ( FolderType value );

    /**
     * Returns the value of the '<em><b>Class Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Class Name</em>' attribute.
     * @see #setClassName(String)
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getConnectionType_ClassName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='className'"
     * @generated
     */
    String getClassName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getClassName <em>Class Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Class Name</em>' attribute.
     * @see #getClassName()
     * @generated
     */
    void setClassName ( String value );

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
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getConnectionType_Id()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Prefix</em>' attribute.
     * @see #setPrefix(String)
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getConnectionType_Prefix()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='prefix'"
     * @generated
     */
    String getPrefix ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getPrefix <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Prefix</em>' attribute.
     * @see #getPrefix()
     * @generated
     */
    void setPrefix ( String value );

    /**
     * Returns the value of the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uri</em>' attribute.
     * @see #setUri(String)
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#getConnectionType_Uri()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='uri'"
     * @generated
     */
    String getUri ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.proxy.configuration.ConnectionType#getUri <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uri</em>' attribute.
     * @see #getUri()
     * @generated
     */
    void setUri ( String value );

} // ConnectionType
