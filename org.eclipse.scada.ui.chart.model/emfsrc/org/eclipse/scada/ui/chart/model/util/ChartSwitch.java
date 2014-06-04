/**
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution, enhancements for legends
 */
package org.eclipse.scada.ui.chart.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.ui.chart.model.ArchiveChannel;
import org.eclipse.scada.ui.chart.model.ArchiveSeries;
import org.eclipse.scada.ui.chart.model.Axis;
import org.eclipse.scada.ui.chart.model.Chart;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.scada.ui.chart.model.ChartPackage
 * @generated
 */
public class ChartSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ChartPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ChartSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ChartPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( final EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code>
     *         call.
     * @generated
     */
    @Override
    protected T doSwitch ( final int classifierID, final EObject theEObject )
    {
        switch ( classifierID )
        {
            case ChartPackage.CHART:
            {
                final Chart chart = (Chart)theEObject;
                T result = caseChart ( chart );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.XAXIS:
            {
                final XAxis xAxis = (XAxis)theEObject;
                T result = caseXAxis ( xAxis );
                if ( result == null )
                {
                    result = caseAxis ( xAxis );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.YAXIS:
            {
                final YAxis yAxis = (YAxis)theEObject;
                T result = caseYAxis ( yAxis );
                if ( result == null )
                {
                    result = caseAxis ( yAxis );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.AXIS:
            {
                final Axis axis = (Axis)theEObject;
                T result = caseAxis ( axis );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.DATA_SERIES:
            {
                final DataSeries dataSeries = (DataSeries)theEObject;
                T result = caseDataSeries ( dataSeries );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.DATA_ITEM_SERIES:
            {
                final DataItemSeries dataItemSeries = (DataItemSeries)theEObject;
                T result = caseDataItemSeries ( dataItemSeries );
                if ( result == null )
                {
                    result = caseItemDataSeries ( dataItemSeries );
                }
                if ( result == null )
                {
                    result = caseDataSeries ( dataItemSeries );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.ARCHIVE_SERIES:
            {
                final ArchiveSeries archiveSeries = (ArchiveSeries)theEObject;
                T result = caseArchiveSeries ( archiveSeries );
                if ( result == null )
                {
                    result = caseItemDataSeries ( archiveSeries );
                }
                if ( result == null )
                {
                    result = caseDataSeries ( archiveSeries );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.ITEM:
            {
                final Item item = (Item)theEObject;
                T result = caseItem ( item );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.URI_ITEM:
            {
                final UriItem uriItem = (UriItem)theEObject;
                T result = caseUriItem ( uriItem );
                if ( result == null )
                {
                    result = caseItem ( uriItem );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.ID_ITEM:
            {
                final IdItem idItem = (IdItem)theEObject;
                T result = caseIdItem ( idItem );
                if ( result == null )
                {
                    result = caseItem ( idItem );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.ITEM_DATA_SERIES:
            {
                final ItemDataSeries itemDataSeries = (ItemDataSeries)theEObject;
                T result = caseItemDataSeries ( itemDataSeries );
                if ( result == null )
                {
                    result = caseDataSeries ( itemDataSeries );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.ARCHIVE_CHANNEL:
            {
                final ArchiveChannel archiveChannel = (ArchiveChannel)theEObject;
                T result = caseArchiveChannel ( archiveChannel );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.LINE_PROPERTIES:
            {
                final LineProperties lineProperties = (LineProperties)theEObject;
                T result = caseLineProperties ( lineProperties );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.SCRIPT_SERIES:
            {
                final ScriptSeries scriptSeries = (ScriptSeries)theEObject;
                T result = caseScriptSeries ( scriptSeries );
                if ( result == null )
                {
                    result = caseDataSeries ( scriptSeries );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.CONTROLLER:
            {
                final Controller controller = (Controller)theEObject;
                T result = caseController ( controller );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.CURRENT_TIME_CONTROLLER:
            {
                final CurrentTimeController currentTimeController = (CurrentTimeController)theEObject;
                T result = caseCurrentTimeController ( currentTimeController );
                if ( result == null )
                {
                    result = caseXAxisController ( currentTimeController );
                }
                if ( result == null )
                {
                    result = caseController ( currentTimeController );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.PROFILE:
            {
                final Profile profile = (Profile)theEObject;
                T result = caseProfile ( profile );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.TIME_SHIFT_ACTION:
            {
                final TimeShiftAction timeShiftAction = (TimeShiftAction)theEObject;
                T result = caseTimeShiftAction ( timeShiftAction );
                if ( result == null )
                {
                    result = caseXAxisController ( timeShiftAction );
                }
                if ( result == null )
                {
                    result = caseController ( timeShiftAction );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.TIME_NOW_ACTION:
            {
                final TimeNowAction timeNowAction = (TimeNowAction)theEObject;
                T result = caseTimeNowAction ( timeNowAction );
                if ( result == null )
                {
                    result = caseXAxisController ( timeNowAction );
                }
                if ( result == null )
                {
                    result = caseController ( timeNowAction );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.XAXIS_CONTROLLER:
            {
                final XAxisController xAxisController = (XAxisController)theEObject;
                T result = caseXAxisController ( xAxisController );
                if ( result == null )
                {
                    result = caseController ( xAxisController );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.SCALE_ACTION:
            {
                final ScaleAction scaleAction = (ScaleAction)theEObject;
                T result = caseScaleAction ( scaleAction );
                if ( result == null )
                {
                    result = caseXAxisController ( scaleAction );
                }
                if ( result == null )
                {
                    result = caseController ( scaleAction );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.SEPARATOR_CONTROLLER:
            {
                final SeparatorController separatorController = (SeparatorController)theEObject;
                T result = caseSeparatorController ( separatorController );
                if ( result == null )
                {
                    result = caseController ( separatorController );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.MOUSE_CONTROLLER:
            {
                final MouseController mouseController = (MouseController)theEObject;
                T result = caseMouseController ( mouseController );
                if ( result == null )
                {
                    result = caseController ( mouseController );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.RESET_CONTROLLER:
            {
                final ResetController resetController = (ResetController)theEObject;
                T result = caseResetController ( resetController );
                if ( result == null )
                {
                    result = caseController ( resetController );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.COMPOSITE_ARCHIVE_QUALITY_SERIES:
            {
                final CompositeArchiveQualitySeries compositeArchiveQualitySeries = (CompositeArchiveQualitySeries)theEObject;
                T result = caseCompositeArchiveQualitySeries ( compositeArchiveQualitySeries );
                if ( result == null )
                {
                    result = caseDataSeries ( compositeArchiveQualitySeries );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ChartPackage.LEGEND_CONTROLLER:
            {
                final LegendController legendController = (LegendController)theEObject;
                T result = caseLegendController ( legendController );
                if ( result == null )
                {
                    result = caseController ( legendController );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Chart</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Chart</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChart ( final Chart object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>XAxis</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>XAxis</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXAxis ( final XAxis object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>YAxis</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>YAxis</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseYAxis ( final YAxis object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Axis</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Axis</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAxis ( final Axis object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Data Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Data Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataSeries ( final DataSeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Data Item Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Data Item Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataItemSeries ( final DataItemSeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Archive Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Archive Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseArchiveSeries ( final ArchiveSeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItem ( final Item object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Uri Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Uri Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUriItem ( final UriItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Id Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Id Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdItem ( final IdItem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Item Data Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Item Data Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemDataSeries ( final ItemDataSeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Archive Channel</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Archive Channel</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseArchiveChannel ( final ArchiveChannel object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Line Properties</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Line Properties</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLineProperties ( final LineProperties object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Script Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Script Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScriptSeries ( final ScriptSeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Controller</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Controller</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseController ( final Controller object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Current Time Controller</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Current Time Controller</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCurrentTimeController ( final CurrentTimeController object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Profile</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Profile</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProfile ( final Profile object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Time Shift Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Time Shift Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTimeShiftAction ( final TimeShiftAction object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Time Now Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Time Now Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTimeNowAction ( final TimeNowAction object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>XAxis Controller</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>XAxis Controller</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXAxisController ( final XAxisController object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Scale Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Scale Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScaleAction ( final ScaleAction object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Separator Controller</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Separator Controller</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSeparatorController ( final SeparatorController object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Mouse Controller</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Mouse Controller</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMouseController ( final MouseController object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Reset Controller</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Reset Controller</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResetController ( final ResetController object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Composite Archive Quality Series</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Composite Archive Quality Series</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCompositeArchiveQualitySeries (
            final CompositeArchiveQualitySeries object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Legend Controller</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Legend Controller</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLegendController ( final LegendController object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( final EObject object )
    {
        return null;
    }

} //ChartSwitch
