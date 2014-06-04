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
package org.eclipse.scada.ui.chart.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.scada.ui.chart.model.ArchiveChannel;
import org.eclipse.scada.ui.chart.model.ArchiveSeries;
import org.eclipse.scada.ui.chart.model.Axis;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries;
import org.eclipse.scada.ui.chart.model.Controller;
import org.eclipse.scada.ui.chart.model.CurrentTimeController;
import org.eclipse.scada.ui.chart.model.DataItemSeries;
import org.eclipse.scada.ui.chart.model.DataSeries;
import org.eclipse.scada.ui.chart.model.IdItem;
import org.eclipse.scada.ui.chart.model.Item;
import org.eclipse.scada.ui.chart.model.ItemDataSeries;
import org.eclipse.scada.ui.chart.model.LegendController;
import org.eclipse.scada.ui.chart.model.LineProperties;
import org.eclipse.scada.ui.chart.model.MouseController;
import org.eclipse.scada.ui.chart.model.Profile;
import org.eclipse.scada.ui.chart.model.ProfileSwitcherType;
import org.eclipse.scada.ui.chart.model.ResetController;
import org.eclipse.scada.ui.chart.model.ScaleAction;
import org.eclipse.scada.ui.chart.model.ScriptSeries;
import org.eclipse.scada.ui.chart.model.SeparatorController;
import org.eclipse.scada.ui.chart.model.TimeNowAction;
import org.eclipse.scada.ui.chart.model.TimeShiftAction;
import org.eclipse.scada.ui.chart.model.UriItem;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.XAxisController;
import org.eclipse.scada.ui.chart.model.YAxis;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChartPackageImpl extends EPackageImpl implements ChartPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass chartEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass xAxisEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass yAxisEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass axisEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataSeriesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dataItemSeriesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass archiveSeriesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass uriItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass idItemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass itemDataSeriesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass archiveChannelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass linePropertiesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptSeriesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass controllerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass currentTimeControllerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass profileEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass timeShiftActionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass timeNowActionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass xAxisControllerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scaleActionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass separatorControllerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mouseControllerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resetControllerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass compositeArchiveQualitySeriesEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass legendControllerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum profileSwitcherTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType rgbEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ChartPackageImpl ()
    {
        super ( eNS_URI, ChartFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link ChartPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ChartPackage init ()
    {
        if ( isInited )
            return (ChartPackage)EPackage.Registry.INSTANCE.getEPackage ( ChartPackage.eNS_URI );

        // Obtain or create and register package
        ChartPackageImpl theChartPackage = (ChartPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ChartPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ChartPackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theChartPackage.createPackageContents ();

        // Initialize created meta-data
        theChartPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theChartPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ChartPackage.eNS_URI, theChartPackage );
        return theChartPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getChart ()
    {
        return chartEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChart_Title ()
    {
        return (EAttribute)chartEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChart_ShowCurrentTimeRuler ()
    {
        return (EAttribute)chartEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChart_BackgroundColor ()
    {
        return (EAttribute)chartEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_Bottom ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_Top ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_Left ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_Right ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_SelectedYAxis ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_SelectedXAxis ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_Inputs ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChart_Mutable ()
    {
        return (EAttribute)chartEClass.getEStructuralFeatures ().get ( 10 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_Controllers ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 11 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChart_Hoverable ()
    {
        return (EAttribute)chartEClass.getEStructuralFeatures ().get ( 12 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_Profiles ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 13 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_ActiveProfile ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 14 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChart_ProfileSwitcherType ()
    {
        return (EAttribute)chartEClass.getEStructuralFeatures ().get ( 15 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getChart_TimeRulerAxis ()
    {
        return (EReference)chartEClass.getEStructuralFeatures ().get ( 16 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getXAxis ()
    {
        return xAxisEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getXAxis_Minimum ()
    {
        return (EAttribute)xAxisEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getXAxis_Maximum ()
    {
        return (EAttribute)xAxisEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getYAxis ()
    {
        return yAxisEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getYAxis_Minimum ()
    {
        return (EAttribute)yAxisEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getYAxis_Maximum ()
    {
        return (EAttribute)yAxisEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAxis ()
    {
        return axisEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAxis_Label ()
    {
        return (EAttribute)axisEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAxis_TextPadding ()
    {
        return (EAttribute)axisEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAxis_Color ()
    {
        return (EAttribute)axisEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAxis_LabelVisible ()
    {
        return (EAttribute)axisEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAxis_Format ()
    {
        return (EAttribute)axisEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataSeries ()
    {
        return dataSeriesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDataSeries_Label ()
    {
        return (EAttribute)dataSeriesEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataSeries_X ()
    {
        return (EReference)dataSeriesEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataSeries_Y ()
    {
        return (EReference)dataSeriesEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDataSeries_Visible ()
    {
        return (EAttribute)dataSeriesEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDataItemSeries ()
    {
        return dataItemSeriesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDataItemSeries_LineProperties ()
    {
        return (EReference)dataItemSeriesEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getArchiveSeries ()
    {
        return archiveSeriesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getArchiveSeries_Channels ()
    {
        return (EReference)archiveSeriesEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getArchiveSeries_LineProperties ()
    {
        return (EReference)archiveSeriesEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getArchiveSeries_IgnoreFuture ()
    {
        return (EAttribute)archiveSeriesEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItem ()
    {
        return itemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getItem_ItemId ()
    {
        return (EAttribute)itemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUriItem ()
    {
        return uriItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUriItem_ConnectionUri ()
    {
        return (EAttribute)uriItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getIdItem ()
    {
        return idItemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIdItem_ConnectionId ()
    {
        return (EAttribute)idItemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getItemDataSeries ()
    {
        return itemDataSeriesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getItemDataSeries_Item ()
    {
        return (EReference)itemDataSeriesEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getArchiveChannel ()
    {
        return archiveChannelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getArchiveChannel_Name ()
    {
        return (EAttribute)archiveChannelEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getArchiveChannel_Label ()
    {
        return (EAttribute)archiveChannelEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getArchiveChannel_LineProperties ()
    {
        return (EReference)archiveChannelEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLineProperties ()
    {
        return linePropertiesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLineProperties_Width ()
    {
        return (EAttribute)linePropertiesEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLineProperties_Color ()
    {
        return (EAttribute)linePropertiesEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScriptSeries ()
    {
        return scriptSeriesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScriptSeries_LineProperties ()
    {
        return (EReference)scriptSeriesEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScriptSeries_Script ()
    {
        return (EAttribute)scriptSeriesEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getController ()
    {
        return controllerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCurrentTimeController ()
    {
        return currentTimeControllerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCurrentTimeController_Diff ()
    {
        return (EAttribute)currentTimeControllerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCurrentTimeController_AlignDateFormat ()
    {
        return (EAttribute)currentTimeControllerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCurrentTimeController_Timespan ()
    {
        return (EAttribute)currentTimeControllerEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProfile ()
    {
        return profileEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProfile_Controllers ()
    {
        return (EReference)profileEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProfile_Id ()
    {
        return (EAttribute)profileEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProfile_Label ()
    {
        return (EAttribute)profileEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTimeShiftAction ()
    {
        return timeShiftActionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTimeShiftAction_Label ()
    {
        return (EAttribute)timeShiftActionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTimeShiftAction_Diff ()
    {
        return (EAttribute)timeShiftActionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTimeShiftAction_Description ()
    {
        return (EAttribute)timeShiftActionEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTimeNowAction ()
    {
        return timeNowActionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getXAxisController ()
    {
        return xAxisControllerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getXAxisController_Axis ()
    {
        return (EReference)xAxisControllerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScaleAction ()
    {
        return scaleActionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScaleAction_Timespan ()
    {
        return (EAttribute)scaleActionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScaleAction_Label ()
    {
        return (EAttribute)scaleActionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScaleAction_Description ()
    {
        return (EAttribute)scaleActionEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSeparatorController ()
    {
        return separatorControllerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMouseController ()
    {
        return mouseControllerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getResetController ()
    {
        return resetControllerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCompositeArchiveQualitySeries ()
    {
        return compositeArchiveQualitySeriesEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCompositeArchiveQualitySeries_Threshold ()
    {
        return (EAttribute)compositeArchiveQualitySeriesEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLegendController ()
    {
        return legendControllerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getLegendController_TimestampFormat ()
    {
        return (EAttribute)legendControllerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getProfileSwitcherType ()
    {
        return profileSwitcherTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getRGB ()
    {
        return rgbEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChartFactory getChartFactory ()
    {
        return (ChartFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents ()
    {
        if ( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        chartEClass = createEClass ( CHART );
        createEAttribute ( chartEClass, CHART__TITLE );
        createEAttribute ( chartEClass, CHART__SHOW_CURRENT_TIME_RULER );
        createEAttribute ( chartEClass, CHART__BACKGROUND_COLOR );
        createEReference ( chartEClass, CHART__BOTTOM );
        createEReference ( chartEClass, CHART__TOP );
        createEReference ( chartEClass, CHART__LEFT );
        createEReference ( chartEClass, CHART__RIGHT );
        createEReference ( chartEClass, CHART__SELECTED_YAXIS );
        createEReference ( chartEClass, CHART__SELECTED_XAXIS );
        createEReference ( chartEClass, CHART__INPUTS );
        createEAttribute ( chartEClass, CHART__MUTABLE );
        createEReference ( chartEClass, CHART__CONTROLLERS );
        createEAttribute ( chartEClass, CHART__HOVERABLE );
        createEReference ( chartEClass, CHART__PROFILES );
        createEReference ( chartEClass, CHART__ACTIVE_PROFILE );
        createEAttribute ( chartEClass, CHART__PROFILE_SWITCHER_TYPE );
        createEReference ( chartEClass, CHART__TIME_RULER_AXIS );

        xAxisEClass = createEClass ( XAXIS );
        createEAttribute ( xAxisEClass, XAXIS__MINIMUM );
        createEAttribute ( xAxisEClass, XAXIS__MAXIMUM );

        yAxisEClass = createEClass ( YAXIS );
        createEAttribute ( yAxisEClass, YAXIS__MINIMUM );
        createEAttribute ( yAxisEClass, YAXIS__MAXIMUM );

        axisEClass = createEClass ( AXIS );
        createEAttribute ( axisEClass, AXIS__LABEL );
        createEAttribute ( axisEClass, AXIS__TEXT_PADDING );
        createEAttribute ( axisEClass, AXIS__COLOR );
        createEAttribute ( axisEClass, AXIS__LABEL_VISIBLE );
        createEAttribute ( axisEClass, AXIS__FORMAT );

        dataSeriesEClass = createEClass ( DATA_SERIES );
        createEAttribute ( dataSeriesEClass, DATA_SERIES__LABEL );
        createEReference ( dataSeriesEClass, DATA_SERIES__X );
        createEReference ( dataSeriesEClass, DATA_SERIES__Y );
        createEAttribute ( dataSeriesEClass, DATA_SERIES__VISIBLE );

        dataItemSeriesEClass = createEClass ( DATA_ITEM_SERIES );
        createEReference ( dataItemSeriesEClass, DATA_ITEM_SERIES__LINE_PROPERTIES );

        archiveSeriesEClass = createEClass ( ARCHIVE_SERIES );
        createEReference ( archiveSeriesEClass, ARCHIVE_SERIES__CHANNELS );
        createEReference ( archiveSeriesEClass, ARCHIVE_SERIES__LINE_PROPERTIES );
        createEAttribute ( archiveSeriesEClass, ARCHIVE_SERIES__IGNORE_FUTURE );

        itemEClass = createEClass ( ITEM );
        createEAttribute ( itemEClass, ITEM__ITEM_ID );

        uriItemEClass = createEClass ( URI_ITEM );
        createEAttribute ( uriItemEClass, URI_ITEM__CONNECTION_URI );

        idItemEClass = createEClass ( ID_ITEM );
        createEAttribute ( idItemEClass, ID_ITEM__CONNECTION_ID );

        itemDataSeriesEClass = createEClass ( ITEM_DATA_SERIES );
        createEReference ( itemDataSeriesEClass, ITEM_DATA_SERIES__ITEM );

        archiveChannelEClass = createEClass ( ARCHIVE_CHANNEL );
        createEAttribute ( archiveChannelEClass, ARCHIVE_CHANNEL__NAME );
        createEAttribute ( archiveChannelEClass, ARCHIVE_CHANNEL__LABEL );
        createEReference ( archiveChannelEClass, ARCHIVE_CHANNEL__LINE_PROPERTIES );

        linePropertiesEClass = createEClass ( LINE_PROPERTIES );
        createEAttribute ( linePropertiesEClass, LINE_PROPERTIES__WIDTH );
        createEAttribute ( linePropertiesEClass, LINE_PROPERTIES__COLOR );

        scriptSeriesEClass = createEClass ( SCRIPT_SERIES );
        createEReference ( scriptSeriesEClass, SCRIPT_SERIES__LINE_PROPERTIES );
        createEAttribute ( scriptSeriesEClass, SCRIPT_SERIES__SCRIPT );

        controllerEClass = createEClass ( CONTROLLER );

        currentTimeControllerEClass = createEClass ( CURRENT_TIME_CONTROLLER );
        createEAttribute ( currentTimeControllerEClass, CURRENT_TIME_CONTROLLER__DIFF );
        createEAttribute ( currentTimeControllerEClass, CURRENT_TIME_CONTROLLER__ALIGN_DATE_FORMAT );
        createEAttribute ( currentTimeControllerEClass, CURRENT_TIME_CONTROLLER__TIMESPAN );

        profileEClass = createEClass ( PROFILE );
        createEReference ( profileEClass, PROFILE__CONTROLLERS );
        createEAttribute ( profileEClass, PROFILE__ID );
        createEAttribute ( profileEClass, PROFILE__LABEL );

        timeShiftActionEClass = createEClass ( TIME_SHIFT_ACTION );
        createEAttribute ( timeShiftActionEClass, TIME_SHIFT_ACTION__LABEL );
        createEAttribute ( timeShiftActionEClass, TIME_SHIFT_ACTION__DIFF );
        createEAttribute ( timeShiftActionEClass, TIME_SHIFT_ACTION__DESCRIPTION );

        timeNowActionEClass = createEClass ( TIME_NOW_ACTION );

        xAxisControllerEClass = createEClass ( XAXIS_CONTROLLER );
        createEReference ( xAxisControllerEClass, XAXIS_CONTROLLER__AXIS );

        scaleActionEClass = createEClass ( SCALE_ACTION );
        createEAttribute ( scaleActionEClass, SCALE_ACTION__TIMESPAN );
        createEAttribute ( scaleActionEClass, SCALE_ACTION__LABEL );
        createEAttribute ( scaleActionEClass, SCALE_ACTION__DESCRIPTION );

        separatorControllerEClass = createEClass ( SEPARATOR_CONTROLLER );

        mouseControllerEClass = createEClass ( MOUSE_CONTROLLER );

        resetControllerEClass = createEClass ( RESET_CONTROLLER );

        compositeArchiveQualitySeriesEClass = createEClass ( COMPOSITE_ARCHIVE_QUALITY_SERIES );
        createEAttribute ( compositeArchiveQualitySeriesEClass, COMPOSITE_ARCHIVE_QUALITY_SERIES__THRESHOLD );

        legendControllerEClass = createEClass ( LEGEND_CONTROLLER );
        createEAttribute ( legendControllerEClass, LEGEND_CONTROLLER__TIMESTAMP_FORMAT );

        // Create enums
        profileSwitcherTypeEEnum = createEEnum ( PROFILE_SWITCHER_TYPE );

        // Create data types
        rgbEDataType = createEDataType ( RGB );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        xAxisEClass.getESuperTypes ().add ( this.getAxis () );
        yAxisEClass.getESuperTypes ().add ( this.getAxis () );
        dataItemSeriesEClass.getESuperTypes ().add ( this.getItemDataSeries () );
        archiveSeriesEClass.getESuperTypes ().add ( this.getItemDataSeries () );
        uriItemEClass.getESuperTypes ().add ( this.getItem () );
        idItemEClass.getESuperTypes ().add ( this.getItem () );
        itemDataSeriesEClass.getESuperTypes ().add ( this.getDataSeries () );
        scriptSeriesEClass.getESuperTypes ().add ( this.getDataSeries () );
        currentTimeControllerEClass.getESuperTypes ().add ( this.getXAxisController () );
        timeShiftActionEClass.getESuperTypes ().add ( this.getXAxisController () );
        timeNowActionEClass.getESuperTypes ().add ( this.getXAxisController () );
        xAxisControllerEClass.getESuperTypes ().add ( this.getController () );
        scaleActionEClass.getESuperTypes ().add ( this.getXAxisController () );
        separatorControllerEClass.getESuperTypes ().add ( this.getController () );
        mouseControllerEClass.getESuperTypes ().add ( this.getController () );
        resetControllerEClass.getESuperTypes ().add ( this.getController () );
        compositeArchiveQualitySeriesEClass.getESuperTypes ().add ( this.getDataSeries () );
        legendControllerEClass.getESuperTypes ().add ( this.getController () );

        // Initialize classes and features; add operations and parameters
        initEClass ( chartEClass, Chart.class, "Chart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getChart_Title (), ecorePackage.getEString (), "title", null, 0, 1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChart_ShowCurrentTimeRuler (), ecorePackage.getEBoolean (), "showCurrentTimeRuler", "true", 1, 1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getChart_BackgroundColor (), this.getRGB (), "backgroundColor", "#FFFFFF", 1, 1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getChart_Bottom (), this.getXAxis (), null, "bottom", null, 0, -1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getChart_Top (), this.getXAxis (), null, "top", null, 0, -1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getChart_Left (), this.getYAxis (), null, "left", null, 0, -1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getChart_Right (), this.getYAxis (), null, "right", null, 0, -1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getChart_SelectedYAxis (), this.getYAxis (), null, "selectedYAxis", null, 0, -1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getChart_SelectedXAxis (), this.getXAxis (), null, "selectedXAxis", null, 0, -1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getChart_Inputs (), this.getDataSeries (), null, "inputs", null, 0, -1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChart_Mutable (), ecorePackage.getEBoolean (), "mutable", "true", 1, 1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getChart_Controllers (), this.getController (), null, "controllers", null, 0, -1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChart_Hoverable (), ecorePackage.getEBoolean (), "hoverable", "true", 1, 1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getChart_Profiles (), this.getProfile (), null, "profiles", null, 0, -1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getChart_ActiveProfile (), this.getProfile (), null, "activeProfile", null, 0, 1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChart_ProfileSwitcherType (), this.getProfileSwitcherType (), "profileSwitcherType", "BUTTON", 1, 1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getChart_TimeRulerAxis (), this.getXAxis (), null, "timeRulerAxis", null, 0, 1, Chart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( xAxisEClass, XAxis.class, "XAxis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getXAxis_Minimum (), ecorePackage.getELong (), "minimum", "0", 1, 1, XAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getXAxis_Maximum (), ecorePackage.getELong (), "maximum", "1000", 1, 1, XAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( yAxisEClass, YAxis.class, "YAxis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getYAxis_Minimum (), ecorePackage.getEDouble (), "minimum", "-100.0", 1, 1, YAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getYAxis_Maximum (), ecorePackage.getEDouble (), "maximum", "100.0", 1, 1, YAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( axisEClass, Axis.class, "Axis", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAxis_Label (), ecorePackage.getEString (), "label", null, 0, 1, Axis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAxis_TextPadding (), ecorePackage.getEInt (), "textPadding", "10", 1, 1, Axis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAxis_Color (), this.getRGB (), "color", "#000000", 0, 1, Axis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAxis_LabelVisible (), ecorePackage.getEBoolean (), "labelVisible", "true", 1, 1, Axis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAxis_Format (), ecorePackage.getEString (), "format", null, 0, 1, Axis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( dataSeriesEClass, DataSeries.class, "DataSeries", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDataSeries_Label (), ecorePackage.getEString (), "label", null, 0, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDataSeries_X (), this.getXAxis (), null, "x", null, 1, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDataSeries_Y (), this.getYAxis (), null, "y", null, 1, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDataSeries_Visible (), ecorePackage.getEBoolean (), "visible", "true", 1, 1, DataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( dataItemSeriesEClass, DataItemSeries.class, "DataItemSeries", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDataItemSeries_LineProperties (), this.getLineProperties (), null, "lineProperties", null, 1, 1, DataItemSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( archiveSeriesEClass, ArchiveSeries.class, "ArchiveSeries", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getArchiveSeries_Channels (), this.getArchiveChannel (), null, "channels", null, 0, -1, ArchiveSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getArchiveSeries_LineProperties (), this.getLineProperties (), null, "lineProperties", null, 1, 1, ArchiveSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getArchiveSeries_IgnoreFuture (), ecorePackage.getEBoolean (), "ignoreFuture", "false", 1, 1, ArchiveSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( itemEClass, Item.class, "Item", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getItem_ItemId (), ecorePackage.getEString (), "itemId", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( uriItemEClass, UriItem.class, "UriItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getUriItem_ConnectionUri (), ecorePackage.getEString (), "connectionUri", null, 1, 1, UriItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( idItemEClass, IdItem.class, "IdItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getIdItem_ConnectionId (), ecorePackage.getEString (), "connectionId", null, 1, 1, IdItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( itemDataSeriesEClass, ItemDataSeries.class, "ItemDataSeries", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getItemDataSeries_Item (), this.getItem (), null, "item", null, 1, 1, ItemDataSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( archiveChannelEClass, ArchiveChannel.class, "ArchiveChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getArchiveChannel_Name (), ecorePackage.getEString (), "name", null, 1, 1, ArchiveChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getArchiveChannel_Label (), ecorePackage.getEString (), "label", null, 0, 1, ArchiveChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getArchiveChannel_LineProperties (), this.getLineProperties (), null, "lineProperties", null, 1, 1, ArchiveChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( linePropertiesEClass, LineProperties.class, "LineProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getLineProperties_Width (), ecorePackage.getEFloat (), "width", "1.0", 1, 1, LineProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getLineProperties_Color (), this.getRGB (), "color", "#000000", 1, 1, LineProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( scriptSeriesEClass, ScriptSeries.class, "ScriptSeries", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScriptSeries_LineProperties (), this.getLineProperties (), null, "lineProperties", null, 1, 1, ScriptSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScriptSeries_Script (), ecorePackage.getEString (), "script", null, 0, 1, ScriptSeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( controllerEClass, Controller.class, "Controller", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( currentTimeControllerEClass, CurrentTimeController.class, "CurrentTimeController", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCurrentTimeController_Diff (), ecorePackage.getELong (), "diff", "0", 1, 1, CurrentTimeController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getCurrentTimeController_AlignDateFormat (), ecorePackage.getEString (), "alignDateFormat", null, 0, 1, CurrentTimeController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCurrentTimeController_Timespan (), ecorePackage.getELongObject (), "timespan", null, 0, 1, CurrentTimeController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( profileEClass, Profile.class, "Profile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getProfile_Controllers (), this.getController (), null, "controllers", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProfile_Id (), ecorePackage.getEString (), "id", null, 1, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProfile_Label (), ecorePackage.getEString (), "label", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( timeShiftActionEClass, TimeShiftAction.class, "TimeShiftAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTimeShiftAction_Label (), ecorePackage.getEString (), "label", null, 1, 1, TimeShiftAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTimeShiftAction_Diff (), ecorePackage.getELong (), "diff", null, 1, 1, TimeShiftAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTimeShiftAction_Description (), ecorePackage.getEString (), "description", null, 0, 1, TimeShiftAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( timeNowActionEClass, TimeNowAction.class, "TimeNowAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( xAxisControllerEClass, XAxisController.class, "XAxisController", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getXAxisController_Axis (), this.getXAxis (), null, "axis", null, 0, -1, XAxisController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( scaleActionEClass, ScaleAction.class, "ScaleAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScaleAction_Timespan (), ecorePackage.getELong (), "timespan", null, 1, 1, ScaleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScaleAction_Label (), ecorePackage.getEString (), "label", null, 1, 1, ScaleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getScaleAction_Description (), ecorePackage.getEString (), "description", null, 0, 1, ScaleAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( separatorControllerEClass, SeparatorController.class, "SeparatorController", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( mouseControllerEClass, MouseController.class, "MouseController", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( resetControllerEClass, ResetController.class, "ResetController", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( compositeArchiveQualitySeriesEClass, CompositeArchiveQualitySeries.class, "CompositeArchiveQualitySeries", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCompositeArchiveQualitySeries_Threshold (), ecorePackage.getEDouble (), "threshold", "0.8", 1, 1, CompositeArchiveQualitySeries.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( legendControllerEClass, LegendController.class, "LegendController", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getLegendController_TimestampFormat (), ecorePackage.getEString (), "timestampFormat", null, 0, 1, LegendController.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( profileSwitcherTypeEEnum, ProfileSwitcherType.class, "ProfileSwitcherType" ); //$NON-NLS-1$
        addEEnumLiteral ( profileSwitcherTypeEEnum, ProfileSwitcherType.CHECK );
        addEEnumLiteral ( profileSwitcherTypeEEnum, ProfileSwitcherType.RADIO );
        addEEnumLiteral ( profileSwitcherTypeEEnum, ProfileSwitcherType.BUTTON );

        // Initialize data types
        initEDataType ( rgbEDataType, org.eclipse.swt.graphics.RGB.class, "RGB", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$		
        addAnnotation ( getChart_BackgroundColor (),
                source,
                new String[]
                {       "name", "backgroundColor" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getAxis_Label (),
                source,
                new String[]
                {       "name", "label" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getArchiveSeries_LineProperties (),
                source,
                new String[]
                {       "wildcards", "", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "lineProperties" //$NON-NLS-1$ //$NON-NLS-2$
                } );
    }

} //ChartPackageImpl
