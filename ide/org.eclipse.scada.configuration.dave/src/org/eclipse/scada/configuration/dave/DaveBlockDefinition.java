/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.dave;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.memory.TypeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getBlock <em>Block</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getDevice <em>Device</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#isEnableStatistics <em>Enable Statistics</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveBlockDefinition()
 * @model
 * @generated
 */
public interface DaveBlockDefinition extends EObject
{
    /**
     * Returns the value of the '<em><b>Block</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Block</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Block</em>' attribute.
     * @see #setBlock(int)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveBlockDefinition_Block()
     * @model required="true"
     * @generated
     */
    int getBlock ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getBlock <em>Block</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Block</em>' attribute.
     * @see #getBlock()
     * @generated
     */
    void setBlock ( int value );

    /**
     * Returns the value of the '<em><b>Device</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.dave.DaveDevice#getBlocks <em>Blocks</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Device</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Device</em>' container reference.
     * @see #setDevice(DaveDevice)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveBlockDefinition_Device()
     * @see org.eclipse.scada.configuration.dave.DaveDevice#getBlocks
     * @model opposite="blocks" transient="false"
     * @generated
     */
    DaveDevice getDevice ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getDevice <em>Device</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Device</em>' container reference.
     * @see #getDevice()
     * @generated
     */
    void setDevice ( DaveDevice value );

    /**
     * Returns the value of the '<em><b>Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Offset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Offset</em>' attribute.
     * @see #setOffset(int)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveBlockDefinition_Offset()
     * @model required="true"
     * @generated
     */
    int getOffset ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getOffset <em>Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Offset</em>' attribute.
     * @see #getOffset()
     * @generated
     */
    void setOffset ( int value );

    /**
     * Returns the value of the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Period</em>' attribute.
     * @see #setPeriod(int)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveBlockDefinition_Period()
     * @model required="true"
     * @generated
     */
    int getPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getPeriod <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Period</em>' attribute.
     * @see #getPeriod()
     * @generated
     */
    void setPeriod ( int value );

    /**
     * Returns the value of the '<em><b>Enable Statistics</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enable Statistics</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enable Statistics</em>' attribute.
     * @see #setEnableStatistics(boolean)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveBlockDefinition_EnableStatistics()
     * @model default="true" required="true"
     * @generated
     */
    boolean isEnableStatistics ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#isEnableStatistics <em>Enable Statistics</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enable Statistics</em>' attribute.
     * @see #isEnableStatistics()
     * @generated
     */
    void setEnableStatistics ( boolean value );

    /**
     * Returns the value of the '<em><b>Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' reference.
     * @see #setType(TypeDefinition)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveBlockDefinition_Type()
     * @model required="true"
     * @generated
     */
    TypeDefinition getType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getType <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' reference.
     * @see #getType()
     * @generated
     */
    void setType ( TypeDefinition value );

    /**
     * Returns the value of the '<em><b>Area</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Area</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Area</em>' attribute.
     * @see #setArea(int)
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveBlockDefinition_Area()
     * @model required="true"
     * @generated
     */
    int getArea ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getArea <em>Area</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Area</em>' attribute.
     * @see #getArea()
     * @generated
     */
    void setArea ( int value );

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
     * @see org.eclipse.scada.configuration.dave.DavePackage#getDaveBlockDefinition_Name()
     * @model
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.dave.DaveBlockDefinition#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

} // DaveBlockDefinition
