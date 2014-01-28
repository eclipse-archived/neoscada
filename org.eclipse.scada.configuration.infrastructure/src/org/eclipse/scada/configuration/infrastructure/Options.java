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
package org.eclipse.scada.configuration.infrastructure;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.osgi.EventPool;
import org.eclipse.scada.configuration.world.osgi.MonitorPool;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseDaNgpPort <em>Base Da Ngp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseAeNgpPort <em>Base Ae Ngp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseCaNgpPort <em>Base Ca Ngp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseHdNgpPort <em>Base Hd Ngp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.Options#getMonitorPools <em>Monitor Pools</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.Options#getEventPools <em>Event Pools</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.Options#getDefaultUserService <em>Default User Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOptions()
 * @model
 * @generated
 */
public interface Options extends EObject
{
    /**
     * Returns the value of the '<em><b>Base Da Ngp Port</b></em>' attribute.
     * The default value is <code>"2100"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Base Da Ngp Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Base Da Ngp Port</em>' attribute.
     * @see #setBaseDaNgpPort(short)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOptions_BaseDaNgpPort()
     * @model default="2100" required="true"
     * @generated
     */
    short getBaseDaNgpPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseDaNgpPort <em>Base Da Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Da Ngp Port</em>' attribute.
     * @see #getBaseDaNgpPort()
     * @generated
     */
    void setBaseDaNgpPort ( short value );

    /**
     * Returns the value of the '<em><b>Base Ae Ngp Port</b></em>' attribute.
     * The default value is <code>"2200"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Base Ae Ngp Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Base Ae Ngp Port</em>' attribute.
     * @see #setBaseAeNgpPort(short)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOptions_BaseAeNgpPort()
     * @model default="2200" required="true"
     * @generated
     */
    short getBaseAeNgpPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseAeNgpPort <em>Base Ae Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Ae Ngp Port</em>' attribute.
     * @see #getBaseAeNgpPort()
     * @generated
     */
    void setBaseAeNgpPort ( short value );

    /**
     * Returns the value of the '<em><b>Base Ca Ngp Port</b></em>' attribute.
     * The default value is <code>"2400"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Base Ca Ngp Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Base Ca Ngp Port</em>' attribute.
     * @see #setBaseCaNgpPort(short)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOptions_BaseCaNgpPort()
     * @model default="2400" required="true"
     * @generated
     */
    short getBaseCaNgpPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseCaNgpPort <em>Base Ca Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Ca Ngp Port</em>' attribute.
     * @see #getBaseCaNgpPort()
     * @generated
     */
    void setBaseCaNgpPort ( short value );

    /**
     * Returns the value of the '<em><b>Base Hd Ngp Port</b></em>' attribute.
     * The default value is <code>"2300"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Base Hd Ngp Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Base Hd Ngp Port</em>' attribute.
     * @see #setBaseHdNgpPort(short)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOptions_BaseHdNgpPort()
     * @model default="2300" required="true"
     * @generated
     */
    short getBaseHdNgpPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.Options#getBaseHdNgpPort <em>Base Hd Ngp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Base Hd Ngp Port</em>' attribute.
     * @see #getBaseHdNgpPort()
     * @generated
     */
    void setBaseHdNgpPort ( short value );

    /**
     * Returns the value of the '<em><b>Monitor Pools</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.MonitorPool}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Monitor Pools</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Monitor Pools</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOptions_MonitorPools()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<MonitorPool> getMonitorPools ();

    /**
     * Returns the value of the '<em><b>Event Pools</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.EventPool}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Event Pools</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Event Pools</em>' containment reference list.
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOptions_EventPools()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<EventPool> getEventPools ();

    /**
     * Returns the value of the '<em><b>Default User Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default User Service</em>' containment
     * reference isn't clear, there really should be more of a description
     * here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default User Service</em>' containment reference.
     * @see #setDefaultUserService(UserService)
     * @see org.eclipse.scada.configuration.infrastructure.InfrastructurePackage#getOptions_DefaultUserService()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    UserService getDefaultUserService ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.infrastructure.Options#getDefaultUserService <em>Default User Service</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default User Service</em>' containment reference.
     * @see #getDefaultUserService()
     * @generated
     */
    void setDefaultUserService ( UserService value );

} // Options
