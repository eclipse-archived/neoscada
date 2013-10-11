/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.chart.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.vi.chart.model.ChartFactory
 * @model kind="package"
 * @generated
 */
public interface ChartPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "model";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/VisualInterface/Chart";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "chart";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ChartPackage eINSTANCE = org.eclipse.scada.vi.chart.model.impl.ChartPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.chart.model.impl.ChartViewImpl <em>View</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.chart.model.impl.ChartViewImpl
     * @see org.eclipse.scada.vi.chart.model.impl.ChartPackageImpl#getChartView()
     * @generated
     */
    int CHART_VIEW = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__NAME = VisualInterfacePackage.FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__FOREGROUND_COLOR = VisualInterfacePackage.FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__BACKGROUND_COLOR = VisualInterfacePackage.FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__SIZE = VisualInterfacePackage.FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__ON_CLICK = VisualInterfacePackage.FIGURE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__ON_DOUBLE_CLICK = VisualInterfacePackage.FIGURE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__CURSOR = VisualInterfacePackage.FIGURE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__VISIBLE = VisualInterfacePackage.FIGURE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__BORDER = VisualInterfacePackage.FIGURE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__OPAQUE = VisualInterfacePackage.FIGURE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__TOOL_TIP = VisualInterfacePackage.FIGURE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>Configuration Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW__CONFIGURATION_URI = VisualInterfacePackage.FIGURE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>View</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_VIEW_FEATURE_COUNT = VisualInterfacePackage.FIGURE_FEATURE_COUNT + 1;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.chart.model.ChartView <em>View</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>View</em>'.
     * @see org.eclipse.scada.vi.chart.model.ChartView
     * @generated
     */
    EClass getChartView ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.chart.model.ChartView#getConfigurationUri <em>Configuration Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Configuration Uri</em>'.
     * @see org.eclipse.scada.vi.chart.model.ChartView#getConfigurationUri()
     * @see #getChartView()
     * @generated
     */
    EAttribute getChartView_ConfigurationUri ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ChartFactory getChartFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.chart.model.impl.ChartViewImpl <em>View</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.chart.model.impl.ChartViewImpl
         * @see org.eclipse.scada.vi.chart.model.impl.ChartPackageImpl#getChartView()
         * @generated
         */
        EClass CHART_VIEW = eINSTANCE.getChartView ();

        /**
         * The meta object literal for the '<em><b>Configuration Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHART_VIEW__CONFIGURATION_URI = eINSTANCE.getChartView_ConfigurationUri ();

    }

} //ChartPackage
