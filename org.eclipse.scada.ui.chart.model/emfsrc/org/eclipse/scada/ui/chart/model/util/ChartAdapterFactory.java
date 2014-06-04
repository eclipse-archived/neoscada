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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.ui.chart.model.*;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.ui.chart.model.ChartPackage
 * @generated
 */
public class ChartAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ChartPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChartAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ChartPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the
     * model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChartSwitch<Adapter> modelSwitch = new ChartSwitch<Adapter> ()
    {
        @Override
        public Adapter caseChart ( Chart object )
        {
            return createChartAdapter ();
        }

        @Override
        public Adapter caseXAxis ( XAxis object )
        {
            return createXAxisAdapter ();
        }

        @Override
        public Adapter caseYAxis ( YAxis object )
        {
            return createYAxisAdapter ();
        }

        @Override
        public Adapter caseAxis ( Axis object )
        {
            return createAxisAdapter ();
        }

        @Override
        public Adapter caseDataSeries ( DataSeries object )
        {
            return createDataSeriesAdapter ();
        }

        @Override
        public Adapter caseDataItemSeries ( DataItemSeries object )
        {
            return createDataItemSeriesAdapter ();
        }

        @Override
        public Adapter caseArchiveSeries ( ArchiveSeries object )
        {
            return createArchiveSeriesAdapter ();
        }

        @Override
        public Adapter caseItem ( Item object )
        {
            return createItemAdapter ();
        }

        @Override
        public Adapter caseUriItem ( UriItem object )
        {
            return createUriItemAdapter ();
        }

        @Override
        public Adapter caseIdItem ( IdItem object )
        {
            return createIdItemAdapter ();
        }

        @Override
        public Adapter caseItemDataSeries ( ItemDataSeries object )
        {
            return createItemDataSeriesAdapter ();
        }

        @Override
        public Adapter caseArchiveChannel ( ArchiveChannel object )
        {
            return createArchiveChannelAdapter ();
        }

        @Override
        public Adapter caseLineProperties ( LineProperties object )
        {
            return createLinePropertiesAdapter ();
        }

        @Override
        public Adapter caseScriptSeries ( ScriptSeries object )
        {
            return createScriptSeriesAdapter ();
        }

        @Override
        public Adapter caseController ( Controller object )
        {
            return createControllerAdapter ();
        }

        @Override
        public Adapter caseCurrentTimeController ( CurrentTimeController object )
        {
            return createCurrentTimeControllerAdapter ();
        }

        @Override
        public Adapter caseProfile ( Profile object )
        {
            return createProfileAdapter ();
        }

        @Override
        public Adapter caseTimeShiftAction ( TimeShiftAction object )
        {
            return createTimeShiftActionAdapter ();
        }

        @Override
        public Adapter caseTimeNowAction ( TimeNowAction object )
        {
            return createTimeNowActionAdapter ();
        }

        @Override
        public Adapter caseXAxisController ( XAxisController object )
        {
            return createXAxisControllerAdapter ();
        }

        @Override
        public Adapter caseScaleAction ( ScaleAction object )
        {
            return createScaleActionAdapter ();
        }

        @Override
        public Adapter caseSeparatorController ( SeparatorController object )
        {
            return createSeparatorControllerAdapter ();
        }

        @Override
        public Adapter caseMouseController ( MouseController object )
        {
            return createMouseControllerAdapter ();
        }

        @Override
        public Adapter caseResetController ( ResetController object )
        {
            return createResetControllerAdapter ();
        }

        @Override
        public Adapter caseCompositeArchiveQualitySeries ( CompositeArchiveQualitySeries object )
        {
            return createCompositeArchiveQualitySeriesAdapter ();
        }

        @Override
        public Adapter caseLegendController ( LegendController object )
        {
            return createLegendControllerAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.Chart <em>Chart</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.Chart
     * @generated
     */
    public Adapter createChartAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.XAxis <em>XAxis</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.XAxis
     * @generated
     */
    public Adapter createXAxisAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.YAxis <em>YAxis</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.YAxis
     * @generated
     */
    public Adapter createYAxisAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.Axis <em>Axis</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.Axis
     * @generated
     */
    public Adapter createAxisAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.DataSeries <em>Data Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.DataSeries
     * @generated
     */
    public Adapter createDataSeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.DataItemSeries <em>Data Item Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.DataItemSeries
     * @generated
     */
    public Adapter createDataItemSeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.ArchiveSeries <em>Archive Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.ArchiveSeries
     * @generated
     */
    public Adapter createArchiveSeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.Item
     * @generated
     */
    public Adapter createItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.UriItem <em>Uri Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.UriItem
     * @generated
     */
    public Adapter createUriItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.IdItem <em>Id Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.IdItem
     * @generated
     */
    public Adapter createIdItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.ItemDataSeries <em>Item Data Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.ItemDataSeries
     * @generated
     */
    public Adapter createItemDataSeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.ArchiveChannel <em>Archive Channel</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.ArchiveChannel
     * @generated
     */
    public Adapter createArchiveChannelAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.LineProperties <em>Line Properties</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.LineProperties
     * @generated
     */
    public Adapter createLinePropertiesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.ScriptSeries <em>Script Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.ScriptSeries
     * @generated
     */
    public Adapter createScriptSeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.Controller <em>Controller</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.Controller
     * @generated
     */
    public Adapter createControllerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.CurrentTimeController <em>Current Time Controller</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.CurrentTimeController
     * @generated
     */
    public Adapter createCurrentTimeControllerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.Profile <em>Profile</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.Profile
     * @generated
     */
    public Adapter createProfileAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.TimeShiftAction <em>Time Shift Action</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.TimeShiftAction
     * @generated
     */
    public Adapter createTimeShiftActionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.TimeNowAction <em>Time Now Action</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.TimeNowAction
     * @generated
     */
    public Adapter createTimeNowActionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.XAxisController <em>XAxis Controller</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.XAxisController
     * @generated
     */
    public Adapter createXAxisControllerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.ScaleAction <em>Scale Action</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.ScaleAction
     * @generated
     */
    public Adapter createScaleActionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.SeparatorController <em>Separator Controller</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.SeparatorController
     * @generated
     */
    public Adapter createSeparatorControllerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.MouseController <em>Mouse Controller</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.MouseController
     * @generated
     */
    public Adapter createMouseControllerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.ResetController <em>Reset Controller</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.ResetController
     * @generated
     */
    public Adapter createResetControllerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries <em>Composite Archive Quality Series</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.CompositeArchiveQualitySeries
     * @generated
     */
    public Adapter createCompositeArchiveQualitySeriesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.ui.chart.model.LegendController <em>Legend Controller</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.ui.chart.model.LegendController
     * @generated
     */
    public Adapter createLegendControllerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //ChartAdapterFactory
