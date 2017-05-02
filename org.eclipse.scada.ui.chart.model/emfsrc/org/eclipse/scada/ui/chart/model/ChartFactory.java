/**
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution
 */
package org.eclipse.scada.ui.chart.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.ui.chart.model.ChartPackage
 * @generated
 */
public interface ChartFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ChartFactory eINSTANCE = org.eclipse.scada.ui.chart.model.impl.ChartFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Chart</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Chart</em>'.
     * @generated
     */
    Chart createChart ();

    /**
     * Returns a new object of class '<em>XAxis</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>XAxis</em>'.
     * @generated
     */
    XAxis createXAxis ();

    /**
     * Returns a new object of class '<em>YAxis</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>YAxis</em>'.
     * @generated
     */
    YAxis createYAxis ();

    /**
     * Returns a new object of class '<em>Data Item Series</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Item Series</em>'.
     * @generated
     */
    DataItemSeries createDataItemSeries ();

    /**
     * Returns a new object of class '<em>Archive Series</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Archive Series</em>'.
     * @generated
     */
    ArchiveSeries createArchiveSeries ();

    /**
     * Returns a new object of class '<em>Uri Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Uri Item</em>'.
     * @generated
     */
    UriItem createUriItem ();

    /**
     * Returns a new object of class '<em>Id Item</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Id Item</em>'.
     * @generated
     */
    IdItem createIdItem ();

    /**
     * Returns a new object of class '<em>Archive Channel</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Archive Channel</em>'.
     * @generated
     */
    ArchiveChannel createArchiveChannel ();

    /**
     * Returns a new object of class '<em>Line Properties</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Line Properties</em>'.
     * @generated
     */
    LineProperties createLineProperties ();

    /**
     * Returns a new object of class '<em>Script Series</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script Series</em>'.
     * @generated
     */
    ScriptSeries createScriptSeries ();

    /**
     * Returns a new object of class '<em>Current Time Controller</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Current Time Controller</em>'.
     * @generated
     */
    CurrentTimeController createCurrentTimeController ();

    /**
     * Returns a new object of class '<em>Profile</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Profile</em>'.
     * @generated
     */
    Profile createProfile ();

    /**
     * Returns a new object of class '<em>Time Shift Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Time Shift Action</em>'.
     * @generated
     */
    TimeShiftAction createTimeShiftAction ();

    /**
     * Returns a new object of class '<em>Time Now Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Time Now Action</em>'.
     * @generated
     */
    TimeNowAction createTimeNowAction ();

    /**
     * Returns a new object of class '<em>Scale Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Scale Action</em>'.
     * @generated
     */
    ScaleAction createScaleAction ();

    /**
     * Returns a new object of class '<em>Separator Controller</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Separator Controller</em>'.
     * @generated
     */
    SeparatorController createSeparatorController ();

    /**
     * Returns a new object of class '<em>Mouse Controller</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Mouse Controller</em>'.
     * @generated
     */
    MouseController createMouseController ();

    /**
     * Returns a new object of class '<em>Reset Controller</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Reset Controller</em>'.
     * @generated
     */
    ResetController createResetController ();

    /**
     * Returns a new object of class '<em>Composite Archive Quality Series</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Composite Archive Quality Series</em>'.
     * @generated
     */
    CompositeArchiveQualitySeries createCompositeArchiveQualitySeries ();

    /**
     * Returns a new object of class '<em>Legend Controller</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Legend Controller</em>'.
     * @generated
     */
    LegendController createLegendController ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ChartPackage getChartPackage ();

} //ChartFactory
