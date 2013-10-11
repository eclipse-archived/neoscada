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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Current Time Controller</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.CurrentTimeController#getDiff <em>Diff</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.CurrentTimeController#getAlignDateFormat <em>Align Date Format</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.CurrentTimeController#getTimespan <em>Timespan</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getCurrentTimeController()
 * @model
 * @generated
 */
public interface CurrentTimeController extends XAxisController {
	/**
	 * Returns the value of the '<em><b>Diff</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diff</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diff</em>' attribute.
	 * @see #setDiff(long)
	 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getCurrentTimeController_Diff()
	 * @model default="0" required="true"
	 * @generated
	 */
	long getDiff();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.CurrentTimeController#getDiff <em>Diff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diff</em>' attribute.
	 * @see #getDiff()
	 * @generated
	 */
	void setDiff(long value);

	/**
	 * Returns the value of the '<em><b>Align Date Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A SimpleDateFormat which will be formatted and re-parsed in order to align the timestamp.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Align Date Format</em>' attribute.
	 * @see #setAlignDateFormat(String)
	 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getCurrentTimeController_AlignDateFormat()
	 * @model
	 * @generated
	 */
	String getAlignDateFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.CurrentTimeController#getAlignDateFormat <em>Align Date Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Align Date Format</em>' attribute.
	 * @see #getAlignDateFormat()
	 * @generated
	 */
	void setAlignDateFormat(String value);

	/**
	 * Returns the value of the '<em><b>Timespan</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timespan</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timespan</em>' attribute.
	 * @see #setTimespan(Long)
	 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getCurrentTimeController_Timespan()
	 * @model
	 * @generated
	 */
	Long getTimespan();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.CurrentTimeController#getTimespan <em>Timespan</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timespan</em>' attribute.
	 * @see #getTimespan()
	 * @generated
	 */
	void setTimespan(Long value);

} // CurrentTimeController
