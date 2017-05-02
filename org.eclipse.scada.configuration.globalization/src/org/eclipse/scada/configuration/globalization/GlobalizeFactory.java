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
package org.eclipse.scada.configuration.globalization;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.globalization.GlobalizePackage
 * @generated
 */
public interface GlobalizeFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    GlobalizeFactory eINSTANCE = org.eclipse.scada.configuration.globalization.impl.GlobalizeFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Globalization</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Globalization</em>'.
     * @generated
     */
    Globalization createGlobalization ();

    /**
     * Returns a new object of class '<em>Local</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Local</em>'.
     * @generated
     */
    Local createLocal ();

    /**
     * Returns a new object of class '<em>Include</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Include</em>'.
     * @generated
     */
    Include createInclude ();

    /**
     * Returns a new object of class '<em>Exclude</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exclude</em>'.
     * @generated
     */
    Exclude createExclude ();

    /**
     * Returns a new object of class '<em>Global</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Global</em>'.
     * @generated
     */
    Global createGlobal ();

    /**
     * Returns a new object of class '<em>Event Pool Import</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Event Pool Import</em>'.
     * @generated
     */
    EventPoolImport createEventPoolImport ();

    /**
     * Returns a new object of class '<em>Monitor Pool Import</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Monitor Pool Import</em>'.
     * @generated
     */
    MonitorPoolImport createMonitorPoolImport ();

    /**
     * Returns a new object of class '<em>Authorative</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Authorative</em>'.
     * @generated
     */
    Authorative createAuthorative ();

    /**
     * Returns a new object of class '<em>Item Name Filter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Item Name Filter</em>'.
     * @generated
     */
    ItemNameFilter createItemNameFilter ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    GlobalizePackage getGlobalizePackage ();

} //GlobalizeFactory
