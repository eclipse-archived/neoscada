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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.NamedDocumentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Pool Proxy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getLocal
 * <em>Local</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getRemote
 * <em>Remote</em>}</li>
 * <li>{@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getSize
 * <em>Size</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventPoolProxy()
 * @model
 * @generated
 */
public interface EventPoolProxy extends NamedDocumentable
{
    /**
     * Returns the value of the '<em><b>Local</b></em>' reference list.
     * The list contents are of type
     * {@link org.eclipse.scada.configuration.world.osgi.EventPool}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Local</em>' reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventPoolProxy_Local()
     * @model
     * @generated
     */
    EList<EventPool> getLocal ();

    /**
     * Returns the value of the '<em><b>Remote</b></em>' reference list.
     * The list contents are of type
     * {@link org.eclipse.scada.configuration.world.osgi.EventPool}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Remote</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Remote</em>' reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventPoolProxy_Remote()
     * @model
     * @generated
     */
    EList<EventPool> getRemote ();

    /**
     * Returns the value of the '<em><b>Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Size</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Size</em>' attribute.
     * @see #setSize(int)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventPoolProxy_Size()
     * @model required="true"
     * @generated
     */
    int getSize ();

    /**
     * Sets the value of the '
     * {@link org.eclipse.scada.configuration.world.osgi.EventPoolProxy#getSize
     * <em>Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Size</em>' attribute.
     * @see #getSize()
     * @generated
     */
    void setSize ( int value );

} // EventPoolProxy
