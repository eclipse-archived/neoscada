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
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.Component#getLevel <em>Level</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Component#getCustomizationPipeline <em>Customization Pipeline</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Component#getArchiveSelector <em>Archive Selector</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Component#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponent()
 * @model abstract="true"
 * @generated
 */
public interface Component extends Documentable
{
    /**
     * Returns the value of the '<em><b>Level</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.component.Level#getComponents <em>Components</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Level</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Level</em>' container reference.
     * @see #setLevel(Level)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponent_Level()
     * @see org.eclipse.scada.configuration.component.Level#getComponents
     * @model opposite="components" transient="false"
     * @generated
     */
    Level getLevel ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.Component#getLevel <em>Level</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Level</em>' container reference.
     * @see #getLevel()
     * @generated
     */
    void setLevel ( Level value );

    /**
     * Returns the value of the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Customization Pipeline</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Customization Pipeline</em>' reference.
     * @see #setCustomizationPipeline(CustomizationPipeline)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponent_CustomizationPipeline()
     * @model
     * @generated
     */
    CustomizationPipeline getCustomizationPipeline ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.Component#getCustomizationPipeline <em>Customization Pipeline</em>}' reference.
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
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponent_ArchiveSelector()
     * @model
     * @generated
     */
    Selector getArchiveSelector ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.Component#getArchiveSelector <em>Archive Selector</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Archive Selector</em>' reference.
     * @see #getArchiveSelector()
     * @generated
     */
    void setArchiveSelector ( Selector value );

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getComponent_Properties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getProperties ();

} // Component
