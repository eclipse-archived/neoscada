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
package org.eclipse.scada.configuration.world;

import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Handler Priority Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getOrder <em>Order</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getFactoryId <em>Factory Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getConfigurationFilter <em>Configuration Filter</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.WorldPackage#getHandlerPriorityRule()
 * @model
 * @generated
 */
public interface HandlerPriorityRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(int)
	 * @see org.eclipse.scada.configuration.world.WorldPackage#getHandlerPriorityRule_Order()
	 * @model required="true"
	 * @generated
	 */
	int getOrder();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

	/**
	 * Returns the value of the '<em><b>Factory Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factory Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factory Id</em>' attribute.
	 * @see #setFactoryId(String)
	 * @see org.eclipse.scada.configuration.world.WorldPackage#getHandlerPriorityRule_FactoryId()
	 * @model
	 * @generated
	 */
	String getFactoryId();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getFactoryId <em>Factory Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factory Id</em>' attribute.
	 * @see #getFactoryId()
	 * @generated
	 */
	void setFactoryId(String value);

	/**
	 * Returns the value of the '<em><b>Configuration Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Filter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Filter</em>' attribute.
	 * @see #setConfigurationFilter(Pattern)
	 * @see org.eclipse.scada.configuration.world.WorldPackage#getHandlerPriorityRule_ConfigurationFilter()
	 * @model dataType="org.eclipse.scada.configuration.world.Pattern"
	 * @generated
	 */
	Pattern getConfigurationFilter();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getConfigurationFilter <em>Configuration Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Filter</em>' attribute.
	 * @see #getConfigurationFilter()
	 * @generated
	 */
	void setConfigurationFilter(Pattern value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see org.eclipse.scada.configuration.world.WorldPackage#getHandlerPriorityRule_Priority()
	 * @model required="true"
	 * @generated
	 */
	int getPriority();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(int value);

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
	 * @see org.eclipse.scada.configuration.world.WorldPackage#getHandlerPriorityRule_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // HandlerPriorityRule
