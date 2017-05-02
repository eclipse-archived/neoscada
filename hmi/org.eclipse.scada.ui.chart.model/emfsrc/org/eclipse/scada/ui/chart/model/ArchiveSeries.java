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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Archive Series</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.ArchiveSeries#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.ArchiveSeries#getLineProperties <em>Line Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.ArchiveSeries#isIgnoreFuture <em>Ignore Future</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getArchiveSeries()
 * @model
 * @generated
 */
public interface ArchiveSeries extends ItemDataSeries
{
    /**
     * Returns the value of the '<em><b>Channels</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.ArchiveChannel}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Channels</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Channels</em>' containment reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getArchiveSeries_Channels()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ArchiveChannel> getChannels ();

    /**
     * Returns the value of the '<em><b>Line Properties</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Properties</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Line Properties</em>' containment reference.
     * @see #setLineProperties(LineProperties)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getArchiveSeries_LineProperties()
     * @model containment="true" resolveProxies="true" required="true"
     *        extendedMetaData="wildcards='' name='lineProperties'"
     * @generated
     */
    LineProperties getLineProperties ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.ArchiveSeries#getLineProperties <em>Line Properties</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Line Properties</em>' containment reference.
     * @see #getLineProperties()
     * @generated
     */
    void setLineProperties ( LineProperties value );

    /**
     * Returns the value of the '<em><b>Ignore Future</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ignore Future</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ignore Future</em>' attribute.
     * @see #setIgnoreFuture(boolean)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getArchiveSeries_IgnoreFuture()
     * @model default="false" required="true"
     * @generated
     */
    boolean isIgnoreFuture ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.ArchiveSeries#isIgnoreFuture <em>Ignore Future</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ignore Future</em>' attribute.
     * @see #isIgnoreFuture()
     * @generated
     */
    void setIgnoreFuture ( boolean value );

} // ArchiveSeries
