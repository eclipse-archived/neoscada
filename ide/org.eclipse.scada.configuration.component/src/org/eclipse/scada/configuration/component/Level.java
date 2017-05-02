/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Level</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.Level#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Level#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Level#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Level#getCustomizationPipeline <em>Customization Pipeline</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Level#getArchiveSelector <em>Archive Selector</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Level#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Level#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getLevel()
 * @model
 * @generated
 */
public interface Level extends Container
{
    /**
     * Returns the value of the '<em><b>Components</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.Component}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.component.Component#getLevel <em>Level</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Components</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getLevel_Components()
     * @see org.eclipse.scada.configuration.component.Component#getLevel
     * @model opposite="level" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Component> getComponents ();

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
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getLevel_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.Level#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getLevel_Description()
     * @model
     * @generated
     */
    String getDescription ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.Level#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription ( String value );

    /**
     * Returns the value of the '<em><b>Levels</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.Level}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.component.Level#getParent <em>Parent</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Levels</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Levels</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getLevel_Levels()
     * @see org.eclipse.scada.configuration.component.Level#getParent
     * @model opposite="parent" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Level> getLevels ();

    /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.component.Level#getLevels <em>Levels</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(Level)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getLevel_Parent()
     * @see org.eclipse.scada.configuration.component.Level#getLevels
     * @model opposite="levels" transient="false"
     * @generated
     */
    Level getParent ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.Level#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
    void setParent ( Level value );

    /**
     * Returns the value of the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Customization Pipeline</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Customization Pipeline</em>' reference.
     * @see #setCustomizationPipeline(CustomizationPipeline)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getLevel_CustomizationPipeline()
     * @model
     * @generated
     */
    CustomizationPipeline getCustomizationPipeline ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.Level#getCustomizationPipeline <em>Customization Pipeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Customization Pipeline</em>' reference.
     * @see #getCustomizationPipeline()
     * @generated
     */
    void setCustomizationPipeline ( CustomizationPipeline value );

    /**
     * Returns the value of the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Archive Selector</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Archive Selector</em>' reference.
     * @see #setArchiveSelector(Selector)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getLevel_ArchiveSelector()
     * @model
     * @generated
     */
    Selector getArchiveSelector ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.Level#getArchiveSelector <em>Archive Selector</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Archive Selector</em>' reference.
     * @see #getArchiveSelector()
     * @generated
     */
    void setArchiveSelector ( Selector value );

} // Level
