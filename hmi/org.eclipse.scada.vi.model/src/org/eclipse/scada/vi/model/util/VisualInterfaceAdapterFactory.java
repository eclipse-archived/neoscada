/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.vi.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage
 * @generated
 */
public class VisualInterfaceAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static VisualInterfacePackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VisualInterfaceAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = VisualInterfacePackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
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
    protected VisualInterfaceSwitch<Adapter> modelSwitch = new VisualInterfaceSwitch<Adapter> () {
        @Override
        public Adapter caseSymbol ( Symbol object )
        {
            return createSymbolAdapter ();
        }

        @Override
        public Adapter casePrimitive ( Primitive object )
        {
            return createPrimitiveAdapter ();
        }

        @Override
        public Adapter caseContainer ( Container object )
        {
            return createContainerAdapter ();
        }

        @Override
        public Adapter caseShape ( Shape object )
        {
            return createShapeAdapter ();
        }

        @Override
        public Adapter caseRectangle ( Rectangle object )
        {
            return createRectangleAdapter ();
        }

        @Override
        public Adapter caseText ( Text object )
        {
            return createTextAdapter ();
        }

        @Override
        public Adapter caseChild ( Child object )
        {
            return createChildAdapter ();
        }

        @Override
        public Adapter caseXYChild ( XYChild object )
        {
            return createXYChildAdapter ();
        }

        @Override
        public Adapter caseXYContainer ( XYContainer object )
        {
            return createXYContainerAdapter ();
        }

        @Override
        public Adapter casePosition ( Position object )
        {
            return createPositionAdapter ();
        }

        @Override
        public Adapter caseLine ( Line object )
        {
            return createLineAdapter ();
        }

        @Override
        public Adapter caseFigure ( Figure object )
        {
            return createFigureAdapter ();
        }

        @Override
        public Adapter caseSymbolReference ( SymbolReference object )
        {
            return createSymbolReferenceAdapter ();
        }

        @Override
        public Adapter caseStringToStringMap ( Map.Entry<String, String> object )
        {
            return createStringToStringMapAdapter ();
        }

        @Override
        public Adapter caseDimension ( Dimension object )
        {
            return createDimensionAdapter ();
        }

        @Override
        public Adapter caseCursor ( Cursor object )
        {
            return createCursorAdapter ();
        }

        @Override
        public Adapter caseSystemCursor ( SystemCursor object )
        {
            return createSystemCursorAdapter ();
        }

        @Override
        public Adapter caseGridContainer ( GridContainer object )
        {
            return createGridContainerAdapter ();
        }

        @Override
        public Adapter caseBorderContainer ( BorderContainer object )
        {
            return createBorderContainerAdapter ();
        }

        @Override
        public Adapter caseBorderChild ( BorderChild object )
        {
            return createBorderChildAdapter ();
        }

        @Override
        public Adapter caseGridChild ( GridChild object )
        {
            return createGridChildAdapter ();
        }

        @Override
        public Adapter caseFigureContainer ( FigureContainer object )
        {
            return createFigureContainerAdapter ();
        }

        @Override
        public Adapter caseImage ( Image object )
        {
            return createImageAdapter ();
        }

        @Override
        public Adapter caseEllipse ( Ellipse object )
        {
            return createEllipseAdapter ();
        }

        @Override
        public Adapter caseArc ( Arc object )
        {
            return createArcAdapter ();
        }

        @Override
        public Adapter caseConnection ( Connection object )
        {
            return createConnectionAdapter ();
        }

        @Override
        public Adapter caseStackContainer ( StackContainer object )
        {
            return createStackContainerAdapter ();
        }

        @Override
        public Adapter casePolygon ( Polygon object )
        {
            return createPolygonAdapter ();
        }

        @Override
        public Adapter caseRoundedRectangle ( RoundedRectangle object )
        {
            return createRoundedRectangleAdapter ();
        }

        @Override
        public Adapter caseTimeTrigger ( TimeTrigger object )
        {
            return createTimeTriggerAdapter ();
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
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Symbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Symbol
     * @generated
     */
    public Adapter createSymbolAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Primitive <em>Primitive</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Primitive
     * @generated
     */
    public Adapter createPrimitiveAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Container <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Container
     * @generated
     */
    public Adapter createContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Shape <em>Shape</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Shape
     * @generated
     */
    public Adapter createShapeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Rectangle <em>Rectangle</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Rectangle
     * @generated
     */
    public Adapter createRectangleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Text <em>Text</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Text
     * @generated
     */
    public Adapter createTextAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Child <em>Child</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Child
     * @generated
     */
    public Adapter createChildAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.XYChild <em>XY Child</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.XYChild
     * @generated
     */
    public Adapter createXYChildAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.XYContainer <em>XY Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.XYContainer
     * @generated
     */
    public Adapter createXYContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Position <em>Position</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Position
     * @generated
     */
    public Adapter createPositionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Line <em>Line</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Line
     * @generated
     */
    public Adapter createLineAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Figure <em>Figure</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Figure
     * @generated
     */
    public Adapter createFigureAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.SymbolReference <em>Symbol Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.SymbolReference
     * @generated
     */
    public Adapter createSymbolReferenceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To String Map</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
    public Adapter createStringToStringMapAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Dimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Dimension
     * @generated
     */
    public Adapter createDimensionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Cursor <em>Cursor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Cursor
     * @generated
     */
    public Adapter createCursorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.SystemCursor <em>System Cursor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.SystemCursor
     * @generated
     */
    public Adapter createSystemCursorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.GridContainer <em>Grid Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.GridContainer
     * @generated
     */
    public Adapter createGridContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.BorderContainer <em>Border Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.BorderContainer
     * @generated
     */
    public Adapter createBorderContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.BorderChild <em>Border Child</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.BorderChild
     * @generated
     */
    public Adapter createBorderChildAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.GridChild <em>Grid Child</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.GridChild
     * @generated
     */
    public Adapter createGridChildAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.FigureContainer <em>Figure Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.FigureContainer
     * @generated
     */
    public Adapter createFigureContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Image <em>Image</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Image
     * @generated
     */
    public Adapter createImageAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Ellipse <em>Ellipse</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Ellipse
     * @generated
     */
    public Adapter createEllipseAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Arc <em>Arc</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Arc
     * @generated
     */
    public Adapter createArcAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Connection
     * @generated
     */
    public Adapter createConnectionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.StackContainer <em>Stack Container</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.StackContainer
     * @generated
     */
    public Adapter createStackContainerAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.Polygon <em>Polygon</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.Polygon
     * @generated
     */
    public Adapter createPolygonAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.RoundedRectangle <em>Rounded Rectangle</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.RoundedRectangle
     * @generated
     */
    public Adapter createRoundedRectangleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.vi.model.TimeTrigger <em>Time Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.vi.model.TimeTrigger
     * @generated
     */
    public Adapter createTimeTriggerAdapter ()
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

} //VisualInterfaceAdapterFactory
