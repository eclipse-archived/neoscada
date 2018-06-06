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
package org.eclipse.scada.vi.model.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.scada.vi.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualInterfaceFactoryImpl extends EFactoryImpl implements VisualInterfaceFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static VisualInterfaceFactory init ()
    {
        try
        {
            VisualInterfaceFactory theVisualInterfaceFactory = (VisualInterfaceFactory)EPackage.Registry.INSTANCE.getEFactory ( VisualInterfacePackage.eNS_URI );
            if ( theVisualInterfaceFactory != null )
            {
                return theVisualInterfaceFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new VisualInterfaceFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VisualInterfaceFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case VisualInterfacePackage.SYMBOL:
                return createSymbol ();
            case VisualInterfacePackage.RECTANGLE:
                return createRectangle ();
            case VisualInterfacePackage.TEXT:
                return createText ();
            case VisualInterfacePackage.CHILD:
                return createChild ();
            case VisualInterfacePackage.XY_CHILD:
                return createXYChild ();
            case VisualInterfacePackage.XY_CONTAINER:
                return createXYContainer ();
            case VisualInterfacePackage.POSITION:
                return createPosition ();
            case VisualInterfacePackage.LINE:
                return createLine ();
            case VisualInterfacePackage.SYMBOL_REFERENCE:
                return createSymbolReference ();
            case VisualInterfacePackage.STRING_TO_STRING_MAP:
                return (EObject)createStringToStringMap ();
            case VisualInterfacePackage.DIMENSION:
                return createDimension ();
            case VisualInterfacePackage.SYSTEM_CURSOR:
                return createSystemCursor ();
            case VisualInterfacePackage.GRID_CONTAINER:
                return createGridContainer ();
            case VisualInterfacePackage.BORDER_CONTAINER:
                return createBorderContainer ();
            case VisualInterfacePackage.BORDER_CHILD:
                return createBorderChild ();
            case VisualInterfacePackage.GRID_CHILD:
                return createGridChild ();
            case VisualInterfacePackage.FIGURE_CONTAINER:
                return createFigureContainer ();
            case VisualInterfacePackage.IMAGE:
                return createImage ();
            case VisualInterfacePackage.ELLIPSE:
                return createEllipse ();
            case VisualInterfacePackage.ARC:
                return createArc ();
            case VisualInterfacePackage.CONNECTION:
                return createConnection ();
            case VisualInterfacePackage.STACK_CONTAINER:
                return createStackContainer ();
            case VisualInterfacePackage.POLYGON:
                return createPolygon ();
            case VisualInterfacePackage.ROUNDED_RECTANGLE:
                return createRoundedRectangle ();
            case VisualInterfacePackage.TIME_TRIGGER:
                return createTimeTrigger ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case VisualInterfacePackage.ALIGNMENT:
                return createAlignmentFromString ( eDataType, initialValue );
            case VisualInterfacePackage.ORIENTATION:
                return createOrientationFromString ( eDataType, initialValue );
            case VisualInterfacePackage.SYSTEM_CURSOR_TYPE:
                return createSystemCursorTypeFromString ( eDataType, initialValue );
            case VisualInterfacePackage.GRID_ALIGNMENT:
                return createGridAlignmentFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case VisualInterfacePackage.ALIGNMENT:
                return convertAlignmentToString ( eDataType, instanceValue );
            case VisualInterfacePackage.ORIENTATION:
                return convertOrientationToString ( eDataType, instanceValue );
            case VisualInterfacePackage.SYSTEM_CURSOR_TYPE:
                return convertSystemCursorTypeToString ( eDataType, instanceValue );
            case VisualInterfacePackage.GRID_ALIGNMENT:
                return convertGridAlignmentToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Symbol createSymbol ()
    {
        SymbolImpl symbol = new SymbolImpl ();
        return symbol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Rectangle createRectangle ()
    {
        RectangleImpl rectangle = new RectangleImpl ();
        return rectangle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Text createText ()
    {
        TextImpl text = new TextImpl ();
        return text;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Child createChild ()
    {
        ChildImpl child = new ChildImpl ();
        return child;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XYChild createXYChild ()
    {
        XYChildImpl xyChild = new XYChildImpl ();
        return xyChild;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XYContainer createXYContainer ()
    {
        XYContainerImpl xyContainer = new XYContainerImpl ();
        return xyContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Position createPosition ()
    {
        PositionImpl position = new PositionImpl ();
        return position;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Line createLine ()
    {
        LineImpl line = new LineImpl ();
        return line;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SymbolReference createSymbolReference ()
    {
        SymbolReferenceImpl symbolReference = new SymbolReferenceImpl ();
        return symbolReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Map.Entry<String, String> createStringToStringMap ()
    {
        StringToStringMapImpl stringToStringMap = new StringToStringMapImpl ();
        return stringToStringMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Dimension createDimension ()
    {
        DimensionImpl dimension = new DimensionImpl ();
        return dimension;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemCursor createSystemCursor ()
    {
        SystemCursorImpl systemCursor = new SystemCursorImpl ();
        return systemCursor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GridContainer createGridContainer ()
    {
        GridContainerImpl gridContainer = new GridContainerImpl ();
        return gridContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BorderContainer createBorderContainer ()
    {
        BorderContainerImpl borderContainer = new BorderContainerImpl ();
        return borderContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BorderChild createBorderChild ()
    {
        BorderChildImpl borderChild = new BorderChildImpl ();
        return borderChild;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GridChild createGridChild ()
    {
        GridChildImpl gridChild = new GridChildImpl ();
        return gridChild;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FigureContainer createFigureContainer ()
    {
        FigureContainerImpl figureContainer = new FigureContainerImpl ();
        return figureContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Image createImage ()
    {
        ImageImpl image = new ImageImpl ();
        return image;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Ellipse createEllipse ()
    {
        EllipseImpl ellipse = new EllipseImpl ();
        return ellipse;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Arc createArc ()
    {
        ArcImpl arc = new ArcImpl ();
        return arc;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Connection createConnection ()
    {
        ConnectionImpl connection = new ConnectionImpl ();
        return connection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StackContainer createStackContainer ()
    {
        StackContainerImpl stackContainer = new StackContainerImpl ();
        return stackContainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Polygon createPolygon ()
    {
        PolygonImpl polygon = new PolygonImpl ();
        return polygon;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RoundedRectangle createRoundedRectangle ()
    {
        RoundedRectangleImpl roundedRectangle = new RoundedRectangleImpl ();
        return roundedRectangle;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TimeTrigger createTimeTrigger ()
    {
        TimeTriggerImpl timeTrigger = new TimeTriggerImpl ();
        return timeTrigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Alignment createAlignmentFromString ( EDataType eDataType, String initialValue )
    {
        Alignment result = Alignment.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertAlignmentToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Orientation createOrientationFromString ( EDataType eDataType, String initialValue )
    {
        Orientation result = Orientation.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertOrientationToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemCursorType createSystemCursorTypeFromString ( EDataType eDataType, String initialValue )
    {
        SystemCursorType result = SystemCursorType.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertSystemCursorTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GridAlignment createGridAlignmentFromString ( EDataType eDataType, String initialValue )
    {
        GridAlignment result = GridAlignment.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertGridAlignmentToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VisualInterfacePackage getVisualInterfacePackage ()
    {
        return (VisualInterfacePackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static VisualInterfacePackage getPackage ()
    {
        return VisualInterfacePackage.eINSTANCE;
    }

} //VisualInterfaceFactoryImpl
