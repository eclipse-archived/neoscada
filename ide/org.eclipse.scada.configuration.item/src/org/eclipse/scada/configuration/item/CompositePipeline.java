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
package org.eclipse.scada.configuration.item;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.item.CustomizationRequest;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.item.CompositePipeline#getSteps <em>Steps</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.item.CompositePipeline#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.item.CompositePipeline#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.item.ItemPackage#getCompositePipeline()
 * @model
 * @generated
 */
public interface CompositePipeline extends CustomizationPipeline
{
    /**
     * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.item.Step}.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.item.Step#getContainingPipeline <em>Containing Pipeline</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Steps</em>' containment reference list.
     * @see org.eclipse.scada.configuration.item.ItemPackage#getCompositePipeline_Steps()
     * @see org.eclipse.scada.configuration.item.Step#getContainingPipeline
     * @model opposite="containingPipeline" containment="true" resolveProxies="true"
     * @generated
     */
    EList<Step> getSteps ();

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
     * @see org.eclipse.scada.configuration.item.ItemPackage#getCompositePipeline_Id()
     * @model required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.item.CompositePipeline#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Parent</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parent</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' reference.
     * @see #setParent(CompositePipeline)
     * @see org.eclipse.scada.configuration.item.ItemPackage#getCompositePipeline_Parent()
     * @model
     * @generated
     */
    CompositePipeline getParent ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.item.CompositePipeline#getParent <em>Parent</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' reference.
     * @see #getParent()
     * @generated
     */
    void setParent ( CompositePipeline value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model requestDataType="org.eclipse.scada.configuration.item.CustomizationRequest"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for ( Step step : getSteps () ) {\n   step.execute ( request );\n}'"
     * @generated
     */
    void customize ( CustomizationRequest request );

} // CompositePipeline
