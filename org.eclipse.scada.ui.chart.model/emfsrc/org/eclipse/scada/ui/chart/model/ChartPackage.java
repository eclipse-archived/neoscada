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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.scada.ui.chart.model.ChartFactory
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
    String eNAME = "model"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/UI/Chart"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "chart"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ChartPackage eINSTANCE = org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl <em>Chart</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ChartImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getChart()
     * @generated
     */
    int CHART = 0;

    /**
     * The feature id for the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__TITLE = 0;

    /**
     * The feature id for the '<em><b>Show Current Time Ruler</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__SHOW_CURRENT_TIME_RULER = 1;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__BACKGROUND_COLOR = 2;

    /**
     * The feature id for the '<em><b>Bottom</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__BOTTOM = 3;

    /**
     * The feature id for the '<em><b>Top</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__TOP = 4;

    /**
     * The feature id for the '<em><b>Left</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__LEFT = 5;

    /**
     * The feature id for the '<em><b>Right</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__RIGHT = 6;

    /**
     * The feature id for the '<em><b>Selected YAxis</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__SELECTED_YAXIS = 7;

    /**
     * The feature id for the '<em><b>Selected XAxis</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__SELECTED_XAXIS = 8;

    /**
     * The feature id for the '<em><b>Inputs</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__INPUTS = 9;

    /**
     * The feature id for the '<em><b>Mutable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__MUTABLE = 10;

    /**
     * The feature id for the '<em><b>Controllers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__CONTROLLERS = 11;

    /**
     * The feature id for the '<em><b>Hoverable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__HOVERABLE = 12;

    /**
     * The feature id for the '<em><b>Profiles</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__PROFILES = 13;

    /**
     * The feature id for the '<em><b>Active Profile</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__ACTIVE_PROFILE = 14;

    /**
     * The feature id for the '<em><b>Profile Switcher Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART__PROFILE_SWITCHER_TYPE = 15;

    /**
     * The number of structural features of the '<em>Chart</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHART_FEATURE_COUNT = 16;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.AxisImpl <em>Axis</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.AxisImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getAxis()
     * @generated
     */
    int AXIS = 3;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AXIS__LABEL = 0;

    /**
     * The feature id for the '<em><b>Text Padding</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AXIS__TEXT_PADDING = 1;

    /**
     * The feature id for the '<em><b>Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AXIS__COLOR = 2;

    /**
     * The feature id for the '<em><b>Label Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AXIS__LABEL_VISIBLE = 3;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AXIS__FORMAT = 4;

    /**
     * The number of structural features of the '<em>Axis</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int AXIS_FEATURE_COUNT = 5;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.XAxisImpl <em>XAxis</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.XAxisImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getXAxis()
     * @generated
     */
    int XAXIS = 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS__LABEL = AXIS__LABEL;

    /**
     * The feature id for the '<em><b>Text Padding</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS__TEXT_PADDING = AXIS__TEXT_PADDING;

    /**
     * The feature id for the '<em><b>Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS__COLOR = AXIS__COLOR;

    /**
     * The feature id for the '<em><b>Label Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS__LABEL_VISIBLE = AXIS__LABEL_VISIBLE;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS__FORMAT = AXIS__FORMAT;

    /**
     * The feature id for the '<em><b>Minimum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS__MINIMUM = AXIS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS__MAXIMUM = AXIS_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>XAxis</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS_FEATURE_COUNT = AXIS_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.YAxisImpl <em>YAxis</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.YAxisImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getYAxis()
     * @generated
     */
    int YAXIS = 2;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int YAXIS__LABEL = AXIS__LABEL;

    /**
     * The feature id for the '<em><b>Text Padding</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int YAXIS__TEXT_PADDING = AXIS__TEXT_PADDING;

    /**
     * The feature id for the '<em><b>Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int YAXIS__COLOR = AXIS__COLOR;

    /**
     * The feature id for the '<em><b>Label Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int YAXIS__LABEL_VISIBLE = AXIS__LABEL_VISIBLE;

    /**
     * The feature id for the '<em><b>Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int YAXIS__FORMAT = AXIS__FORMAT;

    /**
     * The feature id for the '<em><b>Minimum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int YAXIS__MINIMUM = AXIS_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Maximum</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int YAXIS__MAXIMUM = AXIS_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>YAxis</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int YAXIS_FEATURE_COUNT = AXIS_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.DataSeriesImpl <em>Data Series</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.DataSeriesImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getDataSeries()
     * @generated
     */
    int DATA_SERIES = 4;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_SERIES__LABEL = 0;

    /**
     * The feature id for the '<em><b>X</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_SERIES__X = 1;

    /**
     * The feature id for the '<em><b>Y</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_SERIES__Y = 2;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_SERIES__VISIBLE = 3;

    /**
     * The number of structural features of the '<em>Data Series</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_SERIES_FEATURE_COUNT = 4;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ItemDataSeriesImpl <em>Item Data Series</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ItemDataSeriesImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getItemDataSeries()
     * @generated
     */
    int ITEM_DATA_SERIES = 10;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_DATA_SERIES__LABEL = DATA_SERIES__LABEL;

    /**
     * The feature id for the '<em><b>X</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_DATA_SERIES__X = DATA_SERIES__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_DATA_SERIES__Y = DATA_SERIES__Y;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_DATA_SERIES__VISIBLE = DATA_SERIES__VISIBLE;

    /**
     * The feature id for the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_DATA_SERIES__ITEM = DATA_SERIES_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Item Data Series</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_DATA_SERIES_FEATURE_COUNT = DATA_SERIES_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.DataItemSeriesImpl <em>Data Item Series</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.DataItemSeriesImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getDataItemSeries()
     * @generated
     */
    int DATA_ITEM_SERIES = 5;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ITEM_SERIES__LABEL = ITEM_DATA_SERIES__LABEL;

    /**
     * The feature id for the '<em><b>X</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ITEM_SERIES__X = ITEM_DATA_SERIES__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ITEM_SERIES__Y = ITEM_DATA_SERIES__Y;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ITEM_SERIES__VISIBLE = ITEM_DATA_SERIES__VISIBLE;

    /**
     * The feature id for the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ITEM_SERIES__ITEM = ITEM_DATA_SERIES__ITEM;

    /**
     * The feature id for the '<em><b>Line Properties</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ITEM_SERIES__LINE_PROPERTIES = ITEM_DATA_SERIES_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Data Item Series</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DATA_ITEM_SERIES_FEATURE_COUNT = ITEM_DATA_SERIES_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ArchiveSeriesImpl <em>Archive Series</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ArchiveSeriesImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getArchiveSeries()
     * @generated
     */
    int ARCHIVE_SERIES = 6;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_SERIES__LABEL = ITEM_DATA_SERIES__LABEL;

    /**
     * The feature id for the '<em><b>X</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_SERIES__X = ITEM_DATA_SERIES__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_SERIES__Y = ITEM_DATA_SERIES__Y;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_SERIES__VISIBLE = ITEM_DATA_SERIES__VISIBLE;

    /**
     * The feature id for the '<em><b>Item</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_SERIES__ITEM = ITEM_DATA_SERIES__ITEM;

    /**
     * The feature id for the '<em><b>Channels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_SERIES__CHANNELS = ITEM_DATA_SERIES_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Line Properties</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_SERIES__LINE_PROPERTIES = ITEM_DATA_SERIES_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Archive Series</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_SERIES_FEATURE_COUNT = ITEM_DATA_SERIES_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ItemImpl <em>Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ItemImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getItem()
     * @generated
     */
    int ITEM = 7;

    /**
     * The feature id for the '<em><b>Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM__ITEM_ID = 0;

    /**
     * The number of structural features of the '<em>Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ITEM_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.UriItemImpl <em>Uri Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.UriItemImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getUriItem()
     * @generated
     */
    int URI_ITEM = 8;

    /**
     * The feature id for the '<em><b>Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URI_ITEM__ITEM_ID = ITEM__ITEM_ID;

    /**
     * The feature id for the '<em><b>Connection Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URI_ITEM__CONNECTION_URI = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Uri Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URI_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.IdItemImpl <em>Id Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.IdItemImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getIdItem()
     * @generated
     */
    int ID_ITEM = 9;

    /**
     * The feature id for the '<em><b>Item Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ID_ITEM__ITEM_ID = ITEM__ITEM_ID;

    /**
     * The feature id for the '<em><b>Connection Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ID_ITEM__CONNECTION_ID = ITEM_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Id Item</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ID_ITEM_FEATURE_COUNT = ITEM_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ArchiveChannelImpl <em>Archive Channel</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ArchiveChannelImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getArchiveChannel()
     * @generated
     */
    int ARCHIVE_CHANNEL = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_CHANNEL__NAME = 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_CHANNEL__LABEL = 1;

    /**
     * The feature id for the '<em><b>Line Properties</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_CHANNEL__LINE_PROPERTIES = 2;

    /**
     * The number of structural features of the '<em>Archive Channel</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARCHIVE_CHANNEL_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.LinePropertiesImpl <em>Line Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.LinePropertiesImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getLineProperties()
     * @generated
     */
    int LINE_PROPERTIES = 12;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE_PROPERTIES__WIDTH = 0;

    /**
     * The feature id for the '<em><b>Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE_PROPERTIES__COLOR = 1;

    /**
     * The number of structural features of the '<em>Line Properties</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE_PROPERTIES_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ScriptSeriesImpl <em>Script Series</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ScriptSeriesImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getScriptSeries()
     * @generated
     */
    int SCRIPT_SERIES = 13;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SERIES__LABEL = DATA_SERIES__LABEL;

    /**
     * The feature id for the '<em><b>X</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SERIES__X = DATA_SERIES__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SERIES__Y = DATA_SERIES__Y;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SERIES__VISIBLE = DATA_SERIES__VISIBLE;

    /**
     * The feature id for the '<em><b>Line Properties</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SERIES__LINE_PROPERTIES = DATA_SERIES_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SERIES__SCRIPT = DATA_SERIES_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Script Series</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCRIPT_SERIES_FEATURE_COUNT = DATA_SERIES_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ControllerImpl <em>Controller</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ControllerImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getController()
     * @generated
     */
    int CONTROLLER = 14;

    /**
     * The number of structural features of the '<em>Controller</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTROLLER_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.XAxisControllerImpl <em>XAxis Controller</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.XAxisControllerImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getXAxisController()
     * @generated
     */
    int XAXIS_CONTROLLER = 19;

    /**
     * The feature id for the '<em><b>Axis</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS_CONTROLLER__AXIS = CONTROLLER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>XAxis Controller</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XAXIS_CONTROLLER_FEATURE_COUNT = CONTROLLER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.CurrentTimeControllerImpl <em>Current Time Controller</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.CurrentTimeControllerImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getCurrentTimeController()
     * @generated
     */
    int CURRENT_TIME_CONTROLLER = 15;

    /**
     * The feature id for the '<em><b>Axis</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_CONTROLLER__AXIS = XAXIS_CONTROLLER__AXIS;

    /**
     * The feature id for the '<em><b>Diff</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_CONTROLLER__DIFF = XAXIS_CONTROLLER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Align Date Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_CONTROLLER__ALIGN_DATE_FORMAT = XAXIS_CONTROLLER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Timespan</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_CONTROLLER__TIMESPAN = XAXIS_CONTROLLER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Current Time Controller</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURRENT_TIME_CONTROLLER_FEATURE_COUNT = XAXIS_CONTROLLER_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ProfileImpl <em>Profile</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ProfileImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getProfile()
     * @generated
     */
    int PROFILE = 16;

    /**
     * The feature id for the '<em><b>Controllers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__CONTROLLERS = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__ID = 1;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE__LABEL = 2;

    /**
     * The number of structural features of the '<em>Profile</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PROFILE_FEATURE_COUNT = 3;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.TimeShiftActionImpl <em>Time Shift Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.TimeShiftActionImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getTimeShiftAction()
     * @generated
     */
    int TIME_SHIFT_ACTION = 17;

    /**
     * The feature id for the '<em><b>Axis</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_SHIFT_ACTION__AXIS = XAXIS_CONTROLLER__AXIS;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_SHIFT_ACTION__LABEL = XAXIS_CONTROLLER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Diff</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_SHIFT_ACTION__DIFF = XAXIS_CONTROLLER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_SHIFT_ACTION__DESCRIPTION = XAXIS_CONTROLLER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Time Shift Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_SHIFT_ACTION_FEATURE_COUNT = XAXIS_CONTROLLER_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.TimeNowActionImpl <em>Time Now Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.TimeNowActionImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getTimeNowAction()
     * @generated
     */
    int TIME_NOW_ACTION = 18;

    /**
     * The feature id for the '<em><b>Axis</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_NOW_ACTION__AXIS = XAXIS_CONTROLLER__AXIS;

    /**
     * The number of structural features of the '<em>Time Now Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_NOW_ACTION_FEATURE_COUNT = XAXIS_CONTROLLER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ScaleActionImpl <em>Scale Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ScaleActionImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getScaleAction()
     * @generated
     */
    int SCALE_ACTION = 20;

    /**
     * The feature id for the '<em><b>Axis</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE_ACTION__AXIS = XAXIS_CONTROLLER__AXIS;

    /**
     * The feature id for the '<em><b>Timespan</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE_ACTION__TIMESPAN = XAXIS_CONTROLLER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE_ACTION__LABEL = XAXIS_CONTROLLER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE_ACTION__DESCRIPTION = XAXIS_CONTROLLER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Scale Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SCALE_ACTION_FEATURE_COUNT = XAXIS_CONTROLLER_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.SeparatorControllerImpl <em>Separator Controller</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.SeparatorControllerImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getSeparatorController()
     * @generated
     */
    int SEPARATOR_CONTROLLER = 21;

    /**
     * The number of structural features of the '<em>Separator Controller</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SEPARATOR_CONTROLLER_FEATURE_COUNT = CONTROLLER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.MouseControllerImpl <em>Mouse Controller</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.MouseControllerImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getMouseController()
     * @generated
     */
    int MOUSE_CONTROLLER = 22;

    /**
     * The number of structural features of the '<em>Mouse Controller</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MOUSE_CONTROLLER_FEATURE_COUNT = CONTROLLER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.ResetControllerImpl <em>Reset Controller</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.ResetControllerImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getResetController()
     * @generated
     */
    int RESET_CONTROLLER = 23;

    /**
     * The number of structural features of the '<em>Reset Controller</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESET_CONTROLLER_FEATURE_COUNT = CONTROLLER_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.CompositeArchiveQualitySeriesImpl <em>Composite Archive Quality Series</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.CompositeArchiveQualitySeriesImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getCompositeArchiveQualitySeries()
     * @generated
     */
    int COMPOSITE_ARCHIVE_QUALITY_SERIES = 24;

    /**
     * The feature id for the '<em><b>Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_ARCHIVE_QUALITY_SERIES__LABEL = DATA_SERIES__LABEL;

    /**
     * The feature id for the '<em><b>X</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_ARCHIVE_QUALITY_SERIES__X = DATA_SERIES__X;

    /**
     * The feature id for the '<em><b>Y</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_ARCHIVE_QUALITY_SERIES__Y = DATA_SERIES__Y;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_ARCHIVE_QUALITY_SERIES__VISIBLE = DATA_SERIES__VISIBLE;

    /**
     * The feature id for the '<em><b>Threshold</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_ARCHIVE_QUALITY_SERIES__THRESHOLD = DATA_SERIES_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Composite Archive Quality Series</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPOSITE_ARCHIVE_QUALITY_SERIES_FEATURE_COUNT = DATA_SERIES_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.impl.LegendControllerImpl <em>Legend Controller</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.impl.LegendControllerImpl
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getLegendController()
     * @generated
     */
    int LEGEND_CONTROLLER = 25;

    /**
     * The feature id for the '<em><b>Timestamp Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEGEND_CONTROLLER__TIMESTAMP_FORMAT = CONTROLLER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Legend Controller</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LEGEND_CONTROLLER_FEATURE_COUNT = CONTROLLER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.ui.chart.model.ProfileSwitcherType <em>Profile Switcher Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.ui.chart.model.ProfileSwitcherType
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getProfileSwitcherType()
     * @generated
     */
    int PROFILE_SWITCHER_TYPE = 26;

    /**
     * The meta object id for the '<em>RGB</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.swt.graphics.RGB
     * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getRGB()
     * @generated
     */
    int RGB = 27;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.Chart <em>Chart</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Chart</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart
     * @generated
     */
    EClass getChart ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Chart#getTitle <em>Title</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Title</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getTitle()
     * @see #getChart()
     * @generated
     */
    EAttribute getChart_Title ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Chart#isShowCurrentTimeRuler <em>Show Current Time Ruler</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Show Current Time Ruler</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#isShowCurrentTimeRuler()
     * @see #getChart()
     * @generated
     */
    EAttribute getChart_ShowCurrentTimeRuler ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Chart#getBackgroundColor <em>Background Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Background Color</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getBackgroundColor()
     * @see #getChart()
     * @generated
     */
    EAttribute getChart_BackgroundColor ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.ui.chart.model.Chart#getBottom <em>Bottom</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Bottom</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getBottom()
     * @see #getChart()
     * @generated
     */
    EReference getChart_Bottom ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.ui.chart.model.Chart#getTop <em>Top</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Top</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getTop()
     * @see #getChart()
     * @generated
     */
    EReference getChart_Top ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.ui.chart.model.Chart#getLeft <em>Left</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Left</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getLeft()
     * @see #getChart()
     * @generated
     */
    EReference getChart_Left ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.ui.chart.model.Chart#getRight <em>Right</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Right</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getRight()
     * @see #getChart()
     * @generated
     */
    EReference getChart_Right ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.ui.chart.model.Chart#getSelectedYAxis <em>Selected YAxis</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Selected YAxis</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getSelectedYAxis()
     * @see #getChart()
     * @generated
     */
    EReference getChart_SelectedYAxis ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.ui.chart.model.Chart#getSelectedXAxis <em>Selected XAxis</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Selected XAxis</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getSelectedXAxis()
     * @see #getChart()
     * @generated
     */
    EReference getChart_SelectedXAxis ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.ui.chart.model.Chart#getInputs <em>Inputs</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Inputs</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getInputs()
     * @see #getChart()
     * @generated
     */
    EReference getChart_Inputs ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Chart#isMutable <em>Mutable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Mutable</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#isMutable()
     * @see #getChart()
     * @generated
     */
    EAttribute getChart_Mutable ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.ui.chart.model.Chart#getControllers <em>Controllers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Controllers</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getControllers()
     * @see #getChart()
     * @generated
     */
    EReference getChart_Controllers ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Chart#isHoverable <em>Hoverable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Hoverable</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#isHoverable()
     * @see #getChart()
     * @generated
     */
    EAttribute getChart_Hoverable ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.ui.chart.model.Chart#getProfiles <em>Profiles</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Profiles</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getProfiles()
     * @see #getChart()
     * @generated
     */
    EReference getChart_Profiles ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.ui.chart.model.Chart#getActiveProfile <em>Active Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Active Profile</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getActiveProfile()
     * @see #getChart()
     * @generated
     */
    EReference getChart_ActiveProfile ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Chart#getProfileSwitcherType <em>Profile Switcher Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Profile Switcher Type</em>'.
     * @see org.eclipse.scada.ui.chart.model.Chart#getProfileSwitcherType()
     * @see #getChart()
     * @generated
     */
    EAttribute getChart_ProfileSwitcherType ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.XAxis <em>XAxis</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>XAxis</em>'.
     * @see org.eclipse.scada.ui.chart.model.XAxis
     * @generated
     */
    EClass getXAxis ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.XAxis#getMinimum <em>Minimum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Minimum</em>'.
     * @see org.eclipse.scada.ui.chart.model.XAxis#getMinimum()
     * @see #getXAxis()
     * @generated
     */
    EAttribute getXAxis_Minimum ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.XAxis#getMaximum <em>Maximum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Maximum</em>'.
     * @see org.eclipse.scada.ui.chart.model.XAxis#getMaximum()
     * @see #getXAxis()
     * @generated
     */
    EAttribute getXAxis_Maximum ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.YAxis <em>YAxis</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>YAxis</em>'.
     * @see org.eclipse.scada.ui.chart.model.YAxis
     * @generated
     */
    EClass getYAxis ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.YAxis#getMinimum <em>Minimum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Minimum</em>'.
     * @see org.eclipse.scada.ui.chart.model.YAxis#getMinimum()
     * @see #getYAxis()
     * @generated
     */
    EAttribute getYAxis_Minimum ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.YAxis#getMaximum <em>Maximum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Maximum</em>'.
     * @see org.eclipse.scada.ui.chart.model.YAxis#getMaximum()
     * @see #getYAxis()
     * @generated
     */
    EAttribute getYAxis_Maximum ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.Axis <em>Axis</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Axis</em>'.
     * @see org.eclipse.scada.ui.chart.model.Axis
     * @generated
     */
    EClass getAxis ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Axis#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.eclipse.scada.ui.chart.model.Axis#getLabel()
     * @see #getAxis()
     * @generated
     */
    EAttribute getAxis_Label ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Axis#getTextPadding <em>Text Padding</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text Padding</em>'.
     * @see org.eclipse.scada.ui.chart.model.Axis#getTextPadding()
     * @see #getAxis()
     * @generated
     */
    EAttribute getAxis_TextPadding ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Axis#getColor <em>Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Color</em>'.
     * @see org.eclipse.scada.ui.chart.model.Axis#getColor()
     * @see #getAxis()
     * @generated
     */
    EAttribute getAxis_Color ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Axis#isLabelVisible <em>Label Visible</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label Visible</em>'.
     * @see org.eclipse.scada.ui.chart.model.Axis#isLabelVisible()
     * @see #getAxis()
     * @generated
     */
    EAttribute getAxis_LabelVisible ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Axis#getFormat <em>Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Format</em>'.
     * @see org.eclipse.scada.ui.chart.model.Axis#getFormat()
     * @see #getAxis()
     * @generated
     */
    EAttribute getAxis_Format ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.DataSeries <em>Data Series</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Series</em>'.
     * @see org.eclipse.scada.ui.chart.model.DataSeries
     * @generated
     */
    EClass getDataSeries ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.DataSeries#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.eclipse.scada.ui.chart.model.DataSeries#getLabel()
     * @see #getDataSeries()
     * @generated
     */
    EAttribute getDataSeries_Label ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.ui.chart.model.DataSeries#getX <em>X</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>X</em>'.
     * @see org.eclipse.scada.ui.chart.model.DataSeries#getX()
     * @see #getDataSeries()
     * @generated
     */
    EReference getDataSeries_X ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.ui.chart.model.DataSeries#getY <em>Y</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Y</em>'.
     * @see org.eclipse.scada.ui.chart.model.DataSeries#getY()
     * @see #getDataSeries()
     * @generated
     */
    EReference getDataSeries_Y ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.DataSeries#isVisible <em>Visible</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visible</em>'.
     * @see org.eclipse.scada.ui.chart.model.DataSeries#isVisible()
     * @see #getDataSeries()
     * @generated
     */
    EAttribute getDataSeries_Visible ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.DataItemSeries <em>Data Item Series</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Data Item Series</em>'.
     * @see org.eclipse.scada.ui.chart.model.DataItemSeries
     * @generated
     */
    EClass getDataItemSeries ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.ui.chart.model.DataItemSeries#getLineProperties <em>Line Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Line Properties</em>'.
     * @see org.eclipse.scada.ui.chart.model.DataItemSeries#getLineProperties()
     * @see #getDataItemSeries()
     * @generated
     */
    EReference getDataItemSeries_LineProperties ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.ArchiveSeries <em>Archive Series</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Archive Series</em>'.
     * @see org.eclipse.scada.ui.chart.model.ArchiveSeries
     * @generated
     */
    EClass getArchiveSeries ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.ui.chart.model.ArchiveSeries#getChannels <em>Channels</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Channels</em>'.
     * @see org.eclipse.scada.ui.chart.model.ArchiveSeries#getChannels()
     * @see #getArchiveSeries()
     * @generated
     */
    EReference getArchiveSeries_Channels ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.ui.chart.model.ArchiveSeries#getLineProperties <em>Line Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Line Properties</em>'.
     * @see org.eclipse.scada.ui.chart.model.ArchiveSeries#getLineProperties()
     * @see #getArchiveSeries()
     * @generated
     */
    EReference getArchiveSeries_LineProperties ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item</em>'.
     * @see org.eclipse.scada.ui.chart.model.Item
     * @generated
     */
    EClass getItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Item#getItemId <em>Item Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Item Id</em>'.
     * @see org.eclipse.scada.ui.chart.model.Item#getItemId()
     * @see #getItem()
     * @generated
     */
    EAttribute getItem_ItemId ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.UriItem <em>Uri Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Uri Item</em>'.
     * @see org.eclipse.scada.ui.chart.model.UriItem
     * @generated
     */
    EClass getUriItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.UriItem#getConnectionUri <em>Connection Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Connection Uri</em>'.
     * @see org.eclipse.scada.ui.chart.model.UriItem#getConnectionUri()
     * @see #getUriItem()
     * @generated
     */
    EAttribute getUriItem_ConnectionUri ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.IdItem <em>Id Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Id Item</em>'.
     * @see org.eclipse.scada.ui.chart.model.IdItem
     * @generated
     */
    EClass getIdItem ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.IdItem#getConnectionId <em>Connection Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Connection Id</em>'.
     * @see org.eclipse.scada.ui.chart.model.IdItem#getConnectionId()
     * @see #getIdItem()
     * @generated
     */
    EAttribute getIdItem_ConnectionId ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.ItemDataSeries <em>Item Data Series</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Item Data Series</em>'.
     * @see org.eclipse.scada.ui.chart.model.ItemDataSeries
     * @generated
     */
    EClass getItemDataSeries ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.ui.chart.model.ItemDataSeries#getItem <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Item</em>'.
     * @see org.eclipse.scada.ui.chart.model.ItemDataSeries#getItem()
     * @see #getItemDataSeries()
     * @generated
     */
    EReference getItemDataSeries_Item ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.ArchiveChannel <em>Archive Channel</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Archive Channel</em>'.
     * @see org.eclipse.scada.ui.chart.model.ArchiveChannel
     * @generated
     */
    EClass getArchiveChannel ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.ArchiveChannel#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.ui.chart.model.ArchiveChannel#getName()
     * @see #getArchiveChannel()
     * @generated
     */
    EAttribute getArchiveChannel_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.ArchiveChannel#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.eclipse.scada.ui.chart.model.ArchiveChannel#getLabel()
     * @see #getArchiveChannel()
     * @generated
     */
    EAttribute getArchiveChannel_Label ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.ui.chart.model.ArchiveChannel#getLineProperties <em>Line Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Line Properties</em>'.
     * @see org.eclipse.scada.ui.chart.model.ArchiveChannel#getLineProperties()
     * @see #getArchiveChannel()
     * @generated
     */
    EReference getArchiveChannel_LineProperties ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.LineProperties <em>Line Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Line Properties</em>'.
     * @see org.eclipse.scada.ui.chart.model.LineProperties
     * @generated
     */
    EClass getLineProperties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.LineProperties#getWidth <em>Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Width</em>'.
     * @see org.eclipse.scada.ui.chart.model.LineProperties#getWidth()
     * @see #getLineProperties()
     * @generated
     */
    EAttribute getLineProperties_Width ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.LineProperties#getColor <em>Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Color</em>'.
     * @see org.eclipse.scada.ui.chart.model.LineProperties#getColor()
     * @see #getLineProperties()
     * @generated
     */
    EAttribute getLineProperties_Color ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.ScriptSeries <em>Script Series</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Script Series</em>'.
     * @see org.eclipse.scada.ui.chart.model.ScriptSeries
     * @generated
     */
    EClass getScriptSeries ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.ui.chart.model.ScriptSeries#getLineProperties <em>Line Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Line Properties</em>'.
     * @see org.eclipse.scada.ui.chart.model.ScriptSeries#getLineProperties()
     * @see #getScriptSeries()
     * @generated
     */
    EReference getScriptSeries_LineProperties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.ScriptSeries#getScript <em>Script</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Script</em>'.
     * @see org.eclipse.scada.ui.chart.model.ScriptSeries#getScript()
     * @see #getScriptSeries()
     * @generated
     */
    EAttribute getScriptSeries_Script ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.Controller <em>Controller</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Controller</em>'.
     * @see org.eclipse.scada.ui.chart.model.Controller
     * @generated
     */
    EClass getController ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.CurrentTimeController <em>Current Time Controller</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Current Time Controller</em>'.
     * @see org.eclipse.scada.ui.chart.model.CurrentTimeController
     * @generated
     */
    EClass getCurrentTimeController ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.CurrentTimeController#getDiff <em>Diff</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Diff</em>'.
     * @see org.eclipse.scada.ui.chart.model.CurrentTimeController#getDiff()
     * @see #getCurrentTimeController()
     * @generated
     */
    EAttribute getCurrentTimeController_Diff ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.CurrentTimeController#getAlignDateFormat <em>Align Date Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Align Date Format</em>'.
     * @see org.eclipse.scada.ui.chart.model.CurrentTimeController#getAlignDateFormat()
     * @see #getCurrentTimeController()
     * @generated
     */
    EAttribute getCurrentTimeController_AlignDateFormat ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.CurrentTimeController#getTimespan <em>Timespan</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timespan</em>'.
     * @see org.eclipse.scada.ui.chart.model.CurrentTimeController#getTimespan()
     * @see #getCurrentTimeController()
     * @generated
     */
    EAttribute getCurrentTimeController_Timespan ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.Profile <em>Profile</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Profile</em>'.
     * @see org.eclipse.scada.ui.chart.model.Profile
     * @generated
     */
    EClass getProfile ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.ui.chart.model.Profile#getControllers <em>Controllers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Controllers</em>'.
     * @see org.eclipse.scada.ui.chart.model.Profile#getControllers()
     * @see #getProfile()
     * @generated
     */
    EReference getProfile_Controllers ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Profile#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.ui.chart.model.Profile#getId()
     * @see #getProfile()
     * @generated
     */
    EAttribute getProfile_Id ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.Profile#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.eclipse.scada.ui.chart.model.Profile#getLabel()
     * @see #getProfile()
     * @generated
     */
    EAttribute getProfile_Label ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.TimeShiftAction <em>Time Shift Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Time Shift Action</em>'.
     * @see org.eclipse.scada.ui.chart.model.TimeShiftAction
     * @generated
     */
    EClass getTimeShiftAction ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.TimeShiftAction#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.eclipse.scada.ui.chart.model.TimeShiftAction#getLabel()
     * @see #getTimeShiftAction()
     * @generated
     */
    EAttribute getTimeShiftAction_Label ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.TimeShiftAction#getDiff <em>Diff</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Diff</em>'.
     * @see org.eclipse.scada.ui.chart.model.TimeShiftAction#getDiff()
     * @see #getTimeShiftAction()
     * @generated
     */
    EAttribute getTimeShiftAction_Diff ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.TimeShiftAction#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.scada.ui.chart.model.TimeShiftAction#getDescription()
     * @see #getTimeShiftAction()
     * @generated
     */
    EAttribute getTimeShiftAction_Description ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.TimeNowAction <em>Time Now Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Time Now Action</em>'.
     * @see org.eclipse.scada.ui.chart.model.TimeNowAction
     * @generated
     */
    EClass getTimeNowAction ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.XAxisController <em>XAxis Controller</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>XAxis Controller</em>'.
     * @see org.eclipse.scada.ui.chart.model.XAxisController
     * @generated
     */
    EClass getXAxisController ();

    /**
     * Returns the meta object for the reference list '{@link org.eclipse.scada.ui.chart.model.XAxisController#getAxis <em>Axis</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Axis</em>'.
     * @see org.eclipse.scada.ui.chart.model.XAxisController#getAxis()
     * @see #getXAxisController()
     * @generated
     */
    EReference getXAxisController_Axis ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.ScaleAction <em>Scale Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Scale Action</em>'.
     * @see org.eclipse.scada.ui.chart.model.ScaleAction
     * @generated
     */
    EClass getScaleAction ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.ScaleAction#getTimespan <em>Timespan</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timespan</em>'.
     * @see org.eclipse.scada.ui.chart.model.ScaleAction#getTimespan()
     * @see #getScaleAction()
     * @generated
     */
    EAttribute getScaleAction_Timespan ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.ScaleAction#getLabel <em>Label</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label</em>'.
     * @see org.eclipse.scada.ui.chart.model.ScaleAction#getLabel()
     * @see #getScaleAction()
     * @generated
     */
    EAttribute getScaleAction_Label ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.ScaleAction#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.scada.ui.chart.model.ScaleAction#getDescription()
     * @see #getScaleAction()
     * @generated
     */
    EAttribute getScaleAction_Description ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.SeparatorController <em>Separator Controller</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Separator Controller</em>'.
     * @see org.eclipse.scada.ui.chart.model.SeparatorController
     * @generated
     */
    EClass getSeparatorController ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.MouseController <em>Mouse Controller</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mouse Controller</em>'.
     * @see org.eclipse.scada.ui.chart.model.MouseController
     * @generated
     */
    EClass getMouseController ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.ResetController <em>Reset Controller</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Reset Controller</em>'.
     * @see org.eclipse.scada.ui.chart.model.ResetController
     * @generated
     */
    EClass getResetController ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries <em>Composite Archive Quality Series</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Composite Archive Quality Series</em>'.
     * @see org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries
     * @generated
     */
    EClass getCompositeArchiveQualitySeries ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries#getThreshold <em>Threshold</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Threshold</em>'.
     * @see org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries#getThreshold()
     * @see #getCompositeArchiveQualitySeries()
     * @generated
     */
    EAttribute getCompositeArchiveQualitySeries_Threshold ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.ui.chart.model.LegendController <em>Legend Controller</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Legend Controller</em>'.
     * @see org.eclipse.scada.ui.chart.model.LegendController
     * @generated
     */
    EClass getLegendController ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.ui.chart.model.LegendController#getTimestampFormat <em>Timestamp Format</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Timestamp Format</em>'.
     * @see org.eclipse.scada.ui.chart.model.LegendController#getTimestampFormat()
     * @see #getLegendController()
     * @generated
     */
    EAttribute getLegendController_TimestampFormat ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.ui.chart.model.ProfileSwitcherType <em>Profile Switcher Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Profile Switcher Type</em>'.
     * @see org.eclipse.scada.ui.chart.model.ProfileSwitcherType
     * @generated
     */
    EEnum getProfileSwitcherType ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.swt.graphics.RGB <em>RGB</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>RGB</em>'.
     * @see org.eclipse.swt.graphics.RGB
     * @model instanceClass="org.eclipse.swt.graphics.RGB"
     * @generated
     */
    EDataType getRGB ();

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
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl <em>Chart</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ChartImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getChart()
         * @generated
         */
        EClass CHART = eINSTANCE.getChart ();

        /**
         * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHART__TITLE = eINSTANCE.getChart_Title ();

        /**
         * The meta object literal for the '<em><b>Show Current Time Ruler</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHART__SHOW_CURRENT_TIME_RULER = eINSTANCE.getChart_ShowCurrentTimeRuler ();

        /**
         * The meta object literal for the '<em><b>Background Color</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHART__BACKGROUND_COLOR = eINSTANCE.getChart_BackgroundColor ();

        /**
         * The meta object literal for the '<em><b>Bottom</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__BOTTOM = eINSTANCE.getChart_Bottom ();

        /**
         * The meta object literal for the '<em><b>Top</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__TOP = eINSTANCE.getChart_Top ();

        /**
         * The meta object literal for the '<em><b>Left</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__LEFT = eINSTANCE.getChart_Left ();

        /**
         * The meta object literal for the '<em><b>Right</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__RIGHT = eINSTANCE.getChart_Right ();

        /**
         * The meta object literal for the '<em><b>Selected YAxis</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__SELECTED_YAXIS = eINSTANCE.getChart_SelectedYAxis ();

        /**
         * The meta object literal for the '<em><b>Selected XAxis</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__SELECTED_XAXIS = eINSTANCE.getChart_SelectedXAxis ();

        /**
         * The meta object literal for the '<em><b>Inputs</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__INPUTS = eINSTANCE.getChart_Inputs ();

        /**
         * The meta object literal for the '<em><b>Mutable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHART__MUTABLE = eINSTANCE.getChart_Mutable ();

        /**
         * The meta object literal for the '<em><b>Controllers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__CONTROLLERS = eINSTANCE.getChart_Controllers ();

        /**
         * The meta object literal for the '<em><b>Hoverable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHART__HOVERABLE = eINSTANCE.getChart_Hoverable ();

        /**
         * The meta object literal for the '<em><b>Profiles</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__PROFILES = eINSTANCE.getChart_Profiles ();

        /**
         * The meta object literal for the '<em><b>Active Profile</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHART__ACTIVE_PROFILE = eINSTANCE.getChart_ActiveProfile ();

        /**
         * The meta object literal for the '<em><b>Profile Switcher Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHART__PROFILE_SWITCHER_TYPE = eINSTANCE.getChart_ProfileSwitcherType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.XAxisImpl <em>XAxis</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.XAxisImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getXAxis()
         * @generated
         */
        EClass XAXIS = eINSTANCE.getXAxis ();

        /**
         * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute XAXIS__MINIMUM = eINSTANCE.getXAxis_Minimum ();

        /**
         * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute XAXIS__MAXIMUM = eINSTANCE.getXAxis_Maximum ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.YAxisImpl <em>YAxis</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.YAxisImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getYAxis()
         * @generated
         */
        EClass YAXIS = eINSTANCE.getYAxis ();

        /**
         * The meta object literal for the '<em><b>Minimum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute YAXIS__MINIMUM = eINSTANCE.getYAxis_Minimum ();

        /**
         * The meta object literal for the '<em><b>Maximum</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute YAXIS__MAXIMUM = eINSTANCE.getYAxis_Maximum ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.AxisImpl <em>Axis</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.AxisImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getAxis()
         * @generated
         */
        EClass AXIS = eINSTANCE.getAxis ();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AXIS__LABEL = eINSTANCE.getAxis_Label ();

        /**
         * The meta object literal for the '<em><b>Text Padding</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AXIS__TEXT_PADDING = eINSTANCE.getAxis_TextPadding ();

        /**
         * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AXIS__COLOR = eINSTANCE.getAxis_Color ();

        /**
         * The meta object literal for the '<em><b>Label Visible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AXIS__LABEL_VISIBLE = eINSTANCE.getAxis_LabelVisible ();

        /**
         * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute AXIS__FORMAT = eINSTANCE.getAxis_Format ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.DataSeriesImpl <em>Data Series</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.DataSeriesImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getDataSeries()
         * @generated
         */
        EClass DATA_SERIES = eINSTANCE.getDataSeries ();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_SERIES__LABEL = eINSTANCE.getDataSeries_Label ();

        /**
         * The meta object literal for the '<em><b>X</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_SERIES__X = eINSTANCE.getDataSeries_X ();

        /**
         * The meta object literal for the '<em><b>Y</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_SERIES__Y = eINSTANCE.getDataSeries_Y ();

        /**
         * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DATA_SERIES__VISIBLE = eINSTANCE.getDataSeries_Visible ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.DataItemSeriesImpl <em>Data Item Series</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.DataItemSeriesImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getDataItemSeries()
         * @generated
         */
        EClass DATA_ITEM_SERIES = eINSTANCE.getDataItemSeries ();

        /**
         * The meta object literal for the '<em><b>Line Properties</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DATA_ITEM_SERIES__LINE_PROPERTIES = eINSTANCE.getDataItemSeries_LineProperties ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ArchiveSeriesImpl <em>Archive Series</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ArchiveSeriesImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getArchiveSeries()
         * @generated
         */
        EClass ARCHIVE_SERIES = eINSTANCE.getArchiveSeries ();

        /**
         * The meta object literal for the '<em><b>Channels</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ARCHIVE_SERIES__CHANNELS = eINSTANCE.getArchiveSeries_Channels ();

        /**
         * The meta object literal for the '<em><b>Line Properties</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ARCHIVE_SERIES__LINE_PROPERTIES = eINSTANCE.getArchiveSeries_LineProperties ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ItemImpl <em>Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ItemImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getItem()
         * @generated
         */
        EClass ITEM = eINSTANCE.getItem ();

        /**
         * The meta object literal for the '<em><b>Item Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ITEM__ITEM_ID = eINSTANCE.getItem_ItemId ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.UriItemImpl <em>Uri Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.UriItemImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getUriItem()
         * @generated
         */
        EClass URI_ITEM = eINSTANCE.getUriItem ();

        /**
         * The meta object literal for the '<em><b>Connection Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute URI_ITEM__CONNECTION_URI = eINSTANCE.getUriItem_ConnectionUri ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.IdItemImpl <em>Id Item</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.IdItemImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getIdItem()
         * @generated
         */
        EClass ID_ITEM = eINSTANCE.getIdItem ();

        /**
         * The meta object literal for the '<em><b>Connection Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ID_ITEM__CONNECTION_ID = eINSTANCE.getIdItem_ConnectionId ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ItemDataSeriesImpl <em>Item Data Series</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ItemDataSeriesImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getItemDataSeries()
         * @generated
         */
        EClass ITEM_DATA_SERIES = eINSTANCE.getItemDataSeries ();

        /**
         * The meta object literal for the '<em><b>Item</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ITEM_DATA_SERIES__ITEM = eINSTANCE.getItemDataSeries_Item ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ArchiveChannelImpl <em>Archive Channel</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ArchiveChannelImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getArchiveChannel()
         * @generated
         */
        EClass ARCHIVE_CHANNEL = eINSTANCE.getArchiveChannel ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ARCHIVE_CHANNEL__NAME = eINSTANCE.getArchiveChannel_Name ();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ARCHIVE_CHANNEL__LABEL = eINSTANCE.getArchiveChannel_Label ();

        /**
         * The meta object literal for the '<em><b>Line Properties</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ARCHIVE_CHANNEL__LINE_PROPERTIES = eINSTANCE.getArchiveChannel_LineProperties ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.LinePropertiesImpl <em>Line Properties</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.LinePropertiesImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getLineProperties()
         * @generated
         */
        EClass LINE_PROPERTIES = eINSTANCE.getLineProperties ();

        /**
         * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINE_PROPERTIES__WIDTH = eINSTANCE.getLineProperties_Width ();

        /**
         * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LINE_PROPERTIES__COLOR = eINSTANCE.getLineProperties_Color ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ScriptSeriesImpl <em>Script Series</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ScriptSeriesImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getScriptSeries()
         * @generated
         */
        EClass SCRIPT_SERIES = eINSTANCE.getScriptSeries ();

        /**
         * The meta object literal for the '<em><b>Line Properties</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SCRIPT_SERIES__LINE_PROPERTIES = eINSTANCE.getScriptSeries_LineProperties ();

        /**
         * The meta object literal for the '<em><b>Script</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCRIPT_SERIES__SCRIPT = eINSTANCE.getScriptSeries_Script ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ControllerImpl <em>Controller</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ControllerImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getController()
         * @generated
         */
        EClass CONTROLLER = eINSTANCE.getController ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.CurrentTimeControllerImpl <em>Current Time Controller</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.CurrentTimeControllerImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getCurrentTimeController()
         * @generated
         */
        EClass CURRENT_TIME_CONTROLLER = eINSTANCE.getCurrentTimeController ();

        /**
         * The meta object literal for the '<em><b>Diff</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CURRENT_TIME_CONTROLLER__DIFF = eINSTANCE.getCurrentTimeController_Diff ();

        /**
         * The meta object literal for the '<em><b>Align Date Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CURRENT_TIME_CONTROLLER__ALIGN_DATE_FORMAT = eINSTANCE.getCurrentTimeController_AlignDateFormat ();

        /**
         * The meta object literal for the '<em><b>Timespan</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CURRENT_TIME_CONTROLLER__TIMESPAN = eINSTANCE.getCurrentTimeController_Timespan ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ProfileImpl <em>Profile</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ProfileImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getProfile()
         * @generated
         */
        EClass PROFILE = eINSTANCE.getProfile ();

        /**
         * The meta object literal for the '<em><b>Controllers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PROFILE__CONTROLLERS = eINSTANCE.getProfile_Controllers ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROFILE__ID = eINSTANCE.getProfile_Id ();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PROFILE__LABEL = eINSTANCE.getProfile_Label ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.TimeShiftActionImpl <em>Time Shift Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.TimeShiftActionImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getTimeShiftAction()
         * @generated
         */
        EClass TIME_SHIFT_ACTION = eINSTANCE.getTimeShiftAction ();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TIME_SHIFT_ACTION__LABEL = eINSTANCE.getTimeShiftAction_Label ();

        /**
         * The meta object literal for the '<em><b>Diff</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TIME_SHIFT_ACTION__DIFF = eINSTANCE.getTimeShiftAction_Diff ();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TIME_SHIFT_ACTION__DESCRIPTION = eINSTANCE.getTimeShiftAction_Description ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.TimeNowActionImpl <em>Time Now Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.TimeNowActionImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getTimeNowAction()
         * @generated
         */
        EClass TIME_NOW_ACTION = eINSTANCE.getTimeNowAction ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.XAxisControllerImpl <em>XAxis Controller</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.XAxisControllerImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getXAxisController()
         * @generated
         */
        EClass XAXIS_CONTROLLER = eINSTANCE.getXAxisController ();

        /**
         * The meta object literal for the '<em><b>Axis</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference XAXIS_CONTROLLER__AXIS = eINSTANCE.getXAxisController_Axis ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ScaleActionImpl <em>Scale Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ScaleActionImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getScaleAction()
         * @generated
         */
        EClass SCALE_ACTION = eINSTANCE.getScaleAction ();

        /**
         * The meta object literal for the '<em><b>Timespan</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALE_ACTION__TIMESPAN = eINSTANCE.getScaleAction_Timespan ();

        /**
         * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALE_ACTION__LABEL = eINSTANCE.getScaleAction_Label ();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SCALE_ACTION__DESCRIPTION = eINSTANCE.getScaleAction_Description ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.SeparatorControllerImpl <em>Separator Controller</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.SeparatorControllerImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getSeparatorController()
         * @generated
         */
        EClass SEPARATOR_CONTROLLER = eINSTANCE.getSeparatorController ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.MouseControllerImpl <em>Mouse Controller</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.MouseControllerImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getMouseController()
         * @generated
         */
        EClass MOUSE_CONTROLLER = eINSTANCE.getMouseController ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.ResetControllerImpl <em>Reset Controller</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.ResetControllerImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getResetController()
         * @generated
         */
        EClass RESET_CONTROLLER = eINSTANCE.getResetController ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.CompositeArchiveQualitySeriesImpl <em>Composite Archive Quality Series</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.CompositeArchiveQualitySeriesImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getCompositeArchiveQualitySeries()
         * @generated
         */
        EClass COMPOSITE_ARCHIVE_QUALITY_SERIES = eINSTANCE.getCompositeArchiveQualitySeries ();

        /**
         * The meta object literal for the '<em><b>Threshold</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPOSITE_ARCHIVE_QUALITY_SERIES__THRESHOLD = eINSTANCE.getCompositeArchiveQualitySeries_Threshold ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.impl.LegendControllerImpl <em>Legend Controller</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.impl.LegendControllerImpl
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getLegendController()
         * @generated
         */
        EClass LEGEND_CONTROLLER = eINSTANCE.getLegendController ();

        /**
         * The meta object literal for the '<em><b>Timestamp Format</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LEGEND_CONTROLLER__TIMESTAMP_FORMAT = eINSTANCE.getLegendController_TimestampFormat ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.ui.chart.model.ProfileSwitcherType <em>Profile Switcher Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.ui.chart.model.ProfileSwitcherType
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getProfileSwitcherType()
         * @generated
         */
        EEnum PROFILE_SWITCHER_TYPE = eINSTANCE.getProfileSwitcherType ();

        /**
         * The meta object literal for the '<em>RGB</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.swt.graphics.RGB
         * @see org.eclipse.scada.ui.chart.model.impl.ChartPackageImpl#getRGB()
         * @generated
         */
        EDataType RGB = eINSTANCE.getRGB ();

    }

} //ChartPackage
