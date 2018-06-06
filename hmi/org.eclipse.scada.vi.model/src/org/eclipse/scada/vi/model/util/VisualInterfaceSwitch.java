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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.scada.vi.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.vi.model.VisualInterfacePackage
 * @generated
 */
public class VisualInterfaceSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static VisualInterfacePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VisualInterfaceSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = VisualInterfacePackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch ( int classifierID, EObject theEObject )
    {
        switch ( classifierID )
        {
            case VisualInterfacePackage.SYMBOL:
            {
                Symbol symbol = (Symbol)theEObject;
                T result = caseSymbol ( symbol );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.PRIMITIVE:
            {
                Primitive primitive = (Primitive)theEObject;
                T result = casePrimitive ( primitive );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.CONTAINER:
            {
                Container container = (Container)theEObject;
                T result = caseContainer ( container );
                if ( result == null )
                    result = casePrimitive ( container );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.SHAPE:
            {
                Shape shape = (Shape)theEObject;
                T result = caseShape ( shape );
                if ( result == null )
                    result = caseFigure ( shape );
                if ( result == null )
                    result = casePrimitive ( shape );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.RECTANGLE:
            {
                Rectangle rectangle = (Rectangle)theEObject;
                T result = caseRectangle ( rectangle );
                if ( result == null )
                    result = caseShape ( rectangle );
                if ( result == null )
                    result = caseFigure ( rectangle );
                if ( result == null )
                    result = casePrimitive ( rectangle );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.TEXT:
            {
                Text text = (Text)theEObject;
                T result = caseText ( text );
                if ( result == null )
                    result = caseFigure ( text );
                if ( result == null )
                    result = casePrimitive ( text );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.CHILD:
            {
                Child child = (Child)theEObject;
                T result = caseChild ( child );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.XY_CHILD:
            {
                XYChild xyChild = (XYChild)theEObject;
                T result = caseXYChild ( xyChild );
                if ( result == null )
                    result = caseChild ( xyChild );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.XY_CONTAINER:
            {
                XYContainer xyContainer = (XYContainer)theEObject;
                T result = caseXYContainer ( xyContainer );
                if ( result == null )
                    result = caseContainer ( xyContainer );
                if ( result == null )
                    result = casePrimitive ( xyContainer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.POSITION:
            {
                Position position = (Position)theEObject;
                T result = casePosition ( position );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.LINE:
            {
                Line line = (Line)theEObject;
                T result = caseLine ( line );
                if ( result == null )
                    result = caseShape ( line );
                if ( result == null )
                    result = caseFigure ( line );
                if ( result == null )
                    result = casePrimitive ( line );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.FIGURE:
            {
                Figure figure = (Figure)theEObject;
                T result = caseFigure ( figure );
                if ( result == null )
                    result = casePrimitive ( figure );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.SYMBOL_REFERENCE:
            {
                SymbolReference symbolReference = (SymbolReference)theEObject;
                T result = caseSymbolReference ( symbolReference );
                if ( result == null )
                    result = casePrimitive ( symbolReference );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.STRING_TO_STRING_MAP:
            {
                @SuppressWarnings ( "unchecked" )
                Map.Entry<String, String> stringToStringMap = (Map.Entry<String, String>)theEObject;
                T result = caseStringToStringMap ( stringToStringMap );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.DIMENSION:
            {
                Dimension dimension = (Dimension)theEObject;
                T result = caseDimension ( dimension );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.CURSOR:
            {
                Cursor cursor = (Cursor)theEObject;
                T result = caseCursor ( cursor );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.SYSTEM_CURSOR:
            {
                SystemCursor systemCursor = (SystemCursor)theEObject;
                T result = caseSystemCursor ( systemCursor );
                if ( result == null )
                    result = caseCursor ( systemCursor );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.GRID_CONTAINER:
            {
                GridContainer gridContainer = (GridContainer)theEObject;
                T result = caseGridContainer ( gridContainer );
                if ( result == null )
                    result = caseContainer ( gridContainer );
                if ( result == null )
                    result = casePrimitive ( gridContainer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.BORDER_CONTAINER:
            {
                BorderContainer borderContainer = (BorderContainer)theEObject;
                T result = caseBorderContainer ( borderContainer );
                if ( result == null )
                    result = caseContainer ( borderContainer );
                if ( result == null )
                    result = casePrimitive ( borderContainer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.BORDER_CHILD:
            {
                BorderChild borderChild = (BorderChild)theEObject;
                T result = caseBorderChild ( borderChild );
                if ( result == null )
                    result = caseChild ( borderChild );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.GRID_CHILD:
            {
                GridChild gridChild = (GridChild)theEObject;
                T result = caseGridChild ( gridChild );
                if ( result == null )
                    result = caseChild ( gridChild );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.FIGURE_CONTAINER:
            {
                FigureContainer figureContainer = (FigureContainer)theEObject;
                T result = caseFigureContainer ( figureContainer );
                if ( result == null )
                    result = caseFigure ( figureContainer );
                if ( result == null )
                    result = casePrimitive ( figureContainer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.IMAGE:
            {
                Image image = (Image)theEObject;
                T result = caseImage ( image );
                if ( result == null )
                    result = caseFigure ( image );
                if ( result == null )
                    result = casePrimitive ( image );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.ELLIPSE:
            {
                Ellipse ellipse = (Ellipse)theEObject;
                T result = caseEllipse ( ellipse );
                if ( result == null )
                    result = caseShape ( ellipse );
                if ( result == null )
                    result = caseFigure ( ellipse );
                if ( result == null )
                    result = casePrimitive ( ellipse );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.ARC:
            {
                Arc arc = (Arc)theEObject;
                T result = caseArc ( arc );
                if ( result == null )
                    result = caseShape ( arc );
                if ( result == null )
                    result = caseFigure ( arc );
                if ( result == null )
                    result = casePrimitive ( arc );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.CONNECTION:
            {
                Connection connection = (Connection)theEObject;
                T result = caseConnection ( connection );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.STACK_CONTAINER:
            {
                StackContainer stackContainer = (StackContainer)theEObject;
                T result = caseStackContainer ( stackContainer );
                if ( result == null )
                    result = caseContainer ( stackContainer );
                if ( result == null )
                    result = casePrimitive ( stackContainer );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.POLYGON:
            {
                Polygon polygon = (Polygon)theEObject;
                T result = casePolygon ( polygon );
                if ( result == null )
                    result = caseShape ( polygon );
                if ( result == null )
                    result = caseFigure ( polygon );
                if ( result == null )
                    result = casePrimitive ( polygon );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.ROUNDED_RECTANGLE:
            {
                RoundedRectangle roundedRectangle = (RoundedRectangle)theEObject;
                T result = caseRoundedRectangle ( roundedRectangle );
                if ( result == null )
                    result = caseShape ( roundedRectangle );
                if ( result == null )
                    result = caseFigure ( roundedRectangle );
                if ( result == null )
                    result = casePrimitive ( roundedRectangle );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case VisualInterfacePackage.TIME_TRIGGER:
            {
                TimeTrigger timeTrigger = (TimeTrigger)theEObject;
                T result = caseTimeTrigger ( timeTrigger );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Symbol</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Symbol</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSymbol ( Symbol object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Primitive</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Primitive</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePrimitive ( Primitive object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseContainer ( Container object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Shape</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Shape</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseShape ( Shape object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Rectangle</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Rectangle</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRectangle ( Rectangle object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Text</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Text</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseText ( Text object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Child</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Child</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChild ( Child object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>XY Child</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>XY Child</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXYChild ( XYChild object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>XY Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>XY Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseXYContainer ( XYContainer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Position</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Position</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePosition ( Position object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Line</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Line</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLine ( Line object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Figure</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Figure</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFigure ( Figure object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Symbol Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Symbol Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSymbolReference ( SymbolReference object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String To String Map</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String To String Map</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStringToStringMap ( Map.Entry<String, String> object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Dimension</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Dimension</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDimension ( Dimension object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Cursor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Cursor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCursor ( Cursor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>System Cursor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>System Cursor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSystemCursor ( SystemCursor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Grid Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Grid Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGridContainer ( GridContainer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Border Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Border Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBorderContainer ( BorderContainer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Border Child</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Border Child</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBorderChild ( BorderChild object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Grid Child</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Grid Child</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGridChild ( GridChild object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Figure Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Figure Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFigureContainer ( FigureContainer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Image</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseImage ( Image object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ellipse</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ellipse</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEllipse ( Ellipse object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Arc</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Arc</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseArc ( Arc object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnection ( Connection object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Stack Container</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Stack Container</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStackContainer ( StackContainer object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Polygon</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Polygon</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePolygon ( Polygon object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Rounded Rectangle</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Rounded Rectangle</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRoundedRectangle ( RoundedRectangle object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Time Trigger</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Time Trigger</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTimeTrigger ( TimeTrigger object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( EObject object )
    {
        return null;
    }

} //VisualInterfaceSwitch
