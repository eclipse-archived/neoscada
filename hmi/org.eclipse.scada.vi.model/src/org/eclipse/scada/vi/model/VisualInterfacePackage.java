/**
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add new mouse events
 */
package org.eclipse.scada.vi.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.vi.model.VisualInterfaceFactory
 * @model kind="package"
 * @generated
 */
public interface VisualInterfacePackage extends EPackage
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
    String eNS_URI = "http://eclipse.org/SCADA/VisualInterface"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "visualInterface"; //$NON-NLS-1$

    /**
     * The package content type ID.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eCONTENT_TYPE = "org.eclipse.scada.hmi.vi"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    VisualInterfacePackage eINSTANCE = org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.SymbolImpl <em>Symbol</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.SymbolImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getSymbol()
     * @generated
     */
    int SYMBOL = 0;

    /**
     * The feature id for the '<em><b>Root</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__ROOT = 0;

    /**
     * The feature id for the '<em><b>Properties</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__PROPERTIES = 1;

    /**
     * The feature id for the '<em><b>On Init</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__ON_INIT = 2;

    /**
     * The feature id for the '<em><b>On Dispose</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__ON_DISPOSE = 3;

    /**
     * The feature id for the '<em><b>On Update</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__ON_UPDATE = 4;

    /**
     * The feature id for the '<em><b>Script Modules</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__SCRIPT_MODULES = 5;

    /**
     * The feature id for the '<em><b>Cursors</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__CURSORS = 6;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__BACKGROUND_COLOR = 7;

    /**
     * The feature id for the '<em><b>Design Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__DESIGN_SIZE = 8;

    /**
     * The feature id for the '<em><b>Connections</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__CONNECTIONS = 9;

    /**
     * The feature id for the '<em><b>Background Image</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__BACKGROUND_IMAGE = 10;

    /**
     * The feature id for the '<em><b>Time Triggers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL__TIME_TRIGGERS = 11;

    /**
     * The number of structural features of the '<em>Symbol</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_FEATURE_COUNT = 12;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.Primitive <em>Primitive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.Primitive
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getPrimitive()
     * @generated
     */
    int PRIMITIVE = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE__NAME = 0;

    /**
     * The number of structural features of the '<em>Primitive</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PRIMITIVE_FEATURE_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.Container <em>Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.Container
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getContainer()
     * @generated
     */
    int CONTAINER = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER__NAME = PRIMITIVE__NAME;

    /**
     * The number of structural features of the '<em>Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONTAINER_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.FigureImpl <em>Figure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.FigureImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getFigure()
     * @generated
     */
    int FIGURE = 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__NAME = PRIMITIVE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__FOREGROUND_COLOR = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__BACKGROUND_COLOR = PRIMITIVE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__SIZE = PRIMITIVE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__ON_CLICK = PRIMITIVE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__ON_DOUBLE_CLICK = PRIMITIVE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__CURSOR = PRIMITIVE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__VISIBLE = PRIMITIVE_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__BORDER = PRIMITIVE_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__OPAQUE = PRIMITIVE_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__TOOL_TIP = PRIMITIVE_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__ON_MOUSE_IN = PRIMITIVE_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__ON_MOUSE_OUT = PRIMITIVE_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__ON_MOUSE_MOVE = PRIMITIVE_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__ON_MOUSE_HOVER = PRIMITIVE_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE__ON_MOUSE_DRAG = PRIMITIVE_FEATURE_COUNT + 14;

    /**
     * The number of structural features of the '<em>Figure</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 15;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.ShapeImpl <em>Shape</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.ShapeImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getShape()
     * @generated
     */
    int SHAPE = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__NAME = FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__FOREGROUND_COLOR = FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__BACKGROUND_COLOR = FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ON_CLICK = FIGURE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ON_DOUBLE_CLICK = FIGURE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__CURSOR = FIGURE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__VISIBLE = FIGURE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__BORDER = FIGURE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__OPAQUE = FIGURE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__TOOL_TIP = FIGURE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ON_MOUSE_IN = FIGURE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ON_MOUSE_OUT = FIGURE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ON_MOUSE_MOVE = FIGURE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ON_MOUSE_HOVER = FIGURE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ON_MOUSE_DRAG = FIGURE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__LINE_WIDTH = FIGURE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ANTIALIAS = FIGURE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__ALPHA = FIGURE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__FILL = FIGURE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE__OUTLINE = FIGURE_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Shape</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SHAPE_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 5;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.RectangleImpl <em>Rectangle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.RectangleImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getRectangle()
     * @generated
     */
    int RECTANGLE = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__TOOL_TIP = SHAPE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ON_MOUSE_IN = SHAPE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ON_MOUSE_OUT = SHAPE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ON_MOUSE_MOVE = SHAPE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ON_MOUSE_HOVER = SHAPE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ON_MOUSE_DRAG = SHAPE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE__OUTLINE = SHAPE__OUTLINE;

    /**
     * The number of structural features of the '<em>Rectangle</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RECTANGLE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.TextImpl <em>Text</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.TextImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getText()
     * @generated
     */
    int TEXT = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__NAME = FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FOREGROUND_COLOR = FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__BACKGROUND_COLOR = FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ON_CLICK = FIGURE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ON_DOUBLE_CLICK = FIGURE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__CURSOR = FIGURE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__VISIBLE = FIGURE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__BORDER = FIGURE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__OPAQUE = FIGURE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__TOOL_TIP = FIGURE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ON_MOUSE_IN = FIGURE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ON_MOUSE_OUT = FIGURE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ON_MOUSE_MOVE = FIGURE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ON_MOUSE_HOVER = FIGURE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ON_MOUSE_DRAG = FIGURE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Text</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__TEXT = FIGURE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Label Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__LABEL_ALIGNMENT = FIGURE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Icon Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ICON_ALIGNMENT = FIGURE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Text Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__TEXT_ALIGNMENT = FIGURE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Text Placement</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__TEXT_PLACEMENT = FIGURE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Font Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FONT_NAME = FIGURE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Font Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FONT_SIZE = FIGURE_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Font Bold</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FONT_BOLD = FIGURE_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Font Italic</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__FONT_ITALIC = FIGURE_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT__ALPHA = FIGURE_FEATURE_COUNT + 9;

    /**
     * The number of structural features of the '<em>Text</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TEXT_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 10;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.ChildImpl <em>Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.ChildImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getChild()
     * @generated
     */
    int CHILD = 6;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHILD__ELEMENT = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHILD__NAME = 1;

    /**
     * The number of structural features of the '<em>Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CHILD_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.XYChildImpl <em>XY Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.XYChildImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getXYChild()
     * @generated
     */
    int XY_CHILD = 7;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD__ELEMENT = CHILD__ELEMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD__NAME = CHILD__NAME;

    /**
     * The feature id for the '<em><b>Position</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD__POSITION = CHILD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dimension</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD__DIMENSION = CHILD_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>XY Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CHILD_FEATURE_COUNT = CHILD_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.XYContainerImpl <em>XY Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.XYContainerImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getXYContainer()
     * @generated
     */
    int XY_CONTAINER = 8;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CONTAINER__NAME = CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CONTAINER__CHILDREN = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>XY Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int XY_CONTAINER_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.PositionImpl <em>Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.PositionImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getPosition()
     * @generated
     */
    int POSITION = 9;

    /**
     * The feature id for the '<em><b>X</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSITION__X = 0;

    /**
     * The feature id for the '<em><b>Y</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSITION__Y = 1;

    /**
     * The number of structural features of the '<em>Position</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POSITION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.LineImpl <em>Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.LineImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getLine()
     * @generated
     */
    int LINE = 10;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__TOOL_TIP = SHAPE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ON_MOUSE_IN = SHAPE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ON_MOUSE_OUT = SHAPE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ON_MOUSE_MOVE = SHAPE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ON_MOUSE_HOVER = SHAPE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ON_MOUSE_DRAG = SHAPE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__OUTLINE = SHAPE__OUTLINE;

    /**
     * The feature id for the '<em><b>Points</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE__POINTS = SHAPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Line</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LINE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.SymbolReferenceImpl <em>Symbol Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.SymbolReferenceImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getSymbolReference()
     * @generated
     */
    int SYMBOL_REFERENCE = 12;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__NAME = PRIMITIVE__NAME;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__URI = PRIMITIVE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Zoom</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__ZOOM = PRIMITIVE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Properties</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__PROPERTIES = PRIMITIVE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>On Create Properties</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE__ON_CREATE_PROPERTIES = PRIMITIVE_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Symbol Reference</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYMBOL_REFERENCE_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 4;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.StringToStringMapImpl <em>String To String Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.StringToStringMapImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getStringToStringMap()
     * @generated
     */
    int STRING_TO_STRING_MAP = 13;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TO_STRING_MAP__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TO_STRING_MAP__VALUE = 1;

    /**
     * The number of structural features of the '<em>String To String Map</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STRING_TO_STRING_MAP_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.DimensionImpl <em>Dimension</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.DimensionImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getDimension()
     * @generated
     */
    int DIMENSION = 14;

    /**
     * The feature id for the '<em><b>Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIMENSION__WIDTH = 0;

    /**
     * The feature id for the '<em><b>Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIMENSION__HEIGHT = 1;

    /**
     * The number of structural features of the '<em>Dimension</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DIMENSION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.CursorImpl <em>Cursor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.CursorImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getCursor()
     * @generated
     */
    int CURSOR = 15;

    /**
     * The number of structural features of the '<em>Cursor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CURSOR_FEATURE_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.SystemCursorImpl <em>System Cursor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.SystemCursorImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getSystemCursor()
     * @generated
     */
    int SYSTEM_CURSOR = 16;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_CURSOR__TYPE = CURSOR_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>System Cursor</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_CURSOR_FEATURE_COUNT = CURSOR_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.GridContainerImpl <em>Grid Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.GridContainerImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getGridContainer()
     * @generated
     */
    int GRID_CONTAINER = 17;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__NAME = CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Columns</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__COLUMNS = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Equal Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__EQUAL_WIDTH = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__CHILDREN = CONTAINER_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Horizontal Spacing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__HORIZONTAL_SPACING = CONTAINER_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Vertical Spacing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__VERTICAL_SPACING = CONTAINER_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Margin Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__MARGIN_WIDTH = CONTAINER_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Margin Height</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER__MARGIN_HEIGHT = CONTAINER_FEATURE_COUNT + 6;

    /**
     * The number of structural features of the '<em>Grid Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CONTAINER_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 7;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.BorderContainerImpl <em>Border Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.BorderContainerImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getBorderContainer()
     * @generated
     */
    int BORDER_CONTAINER = 18;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER__NAME = CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER__CHILDREN = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Vertical Spacing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER__VERTICAL_SPACING = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Horizontal Spacing</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER__HORIZONTAL_SPACING = CONTAINER_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Border Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CONTAINER_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.BorderChildImpl <em>Border Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.BorderChildImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getBorderChild()
     * @generated
     */
    int BORDER_CHILD = 19;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CHILD__ELEMENT = CHILD__ELEMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CHILD__NAME = CHILD__NAME;

    /**
     * The feature id for the '<em><b>Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CHILD__ALIGNMENT = CHILD_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Border Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int BORDER_CHILD_FEATURE_COUNT = CHILD_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.GridChildImpl <em>Grid Child</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.GridChildImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getGridChild()
     * @generated
     */
    int GRID_CHILD = 20;

    /**
     * The feature id for the '<em><b>Element</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__ELEMENT = CHILD__ELEMENT;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__NAME = CHILD__NAME;

    /**
     * The feature id for the '<em><b>Horizontal Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__HORIZONTAL_ALIGNMENT = CHILD_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Vertical Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__VERTICAL_ALIGNMENT = CHILD_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Grab Horizontal Space</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__GRAB_HORIZONTAL_SPACE = CHILD_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Grab Vertical Space</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__GRAB_VERTICAL_SPACE = CHILD_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Span Cols</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__SPAN_COLS = CHILD_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Span Rows</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__SPAN_ROWS = CHILD_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Width Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__WIDTH_HINT = CHILD_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Height Hint</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD__HEIGHT_HINT = CHILD_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '<em>Grid Child</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int GRID_CHILD_FEATURE_COUNT = CHILD_FEATURE_COUNT + 8;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.FigureContainerImpl <em>Figure Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.FigureContainerImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getFigureContainer()
     * @generated
     */
    int FIGURE_CONTAINER = 21;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__NAME = FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__FOREGROUND_COLOR = FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__BACKGROUND_COLOR = FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__ON_CLICK = FIGURE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__ON_DOUBLE_CLICK = FIGURE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__CURSOR = FIGURE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__VISIBLE = FIGURE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__BORDER = FIGURE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__OPAQUE = FIGURE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__TOOL_TIP = FIGURE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__ON_MOUSE_IN = FIGURE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__ON_MOUSE_OUT = FIGURE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__ON_MOUSE_MOVE = FIGURE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__ON_MOUSE_HOVER = FIGURE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__ON_MOUSE_DRAG = FIGURE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Content</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER__CONTENT = FIGURE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Figure Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FIGURE_CONTAINER_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.ImageImpl <em>Image</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.ImageImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getImage()
     * @generated
     */
    int IMAGE = 22;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__NAME = FIGURE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__FOREGROUND_COLOR = FIGURE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__BACKGROUND_COLOR = FIGURE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__SIZE = FIGURE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__ON_CLICK = FIGURE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__ON_DOUBLE_CLICK = FIGURE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__CURSOR = FIGURE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__VISIBLE = FIGURE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__BORDER = FIGURE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__OPAQUE = FIGURE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__TOOL_TIP = FIGURE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__ON_MOUSE_IN = FIGURE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__ON_MOUSE_OUT = FIGURE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__ON_MOUSE_MOVE = FIGURE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__ON_MOUSE_HOVER = FIGURE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__ON_MOUSE_DRAG = FIGURE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__URI = FIGURE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Image Alignment</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE__IMAGE_ALIGNMENT = FIGURE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Image</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IMAGE_FEATURE_COUNT = FIGURE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.EllipseImpl <em>Ellipse</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.EllipseImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getEllipse()
     * @generated
     */
    int ELLIPSE = 23;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__TOOL_TIP = SHAPE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ON_MOUSE_IN = SHAPE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ON_MOUSE_OUT = SHAPE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ON_MOUSE_MOVE = SHAPE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ON_MOUSE_HOVER = SHAPE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ON_MOUSE_DRAG = SHAPE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE__OUTLINE = SHAPE__OUTLINE;

    /**
     * The number of structural features of the '<em>Ellipse</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ELLIPSE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.ArcImpl <em>Arc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.ArcImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getArc()
     * @generated
     */
    int ARC = 24;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__TOOL_TIP = SHAPE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ON_MOUSE_IN = SHAPE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ON_MOUSE_OUT = SHAPE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ON_MOUSE_MOVE = SHAPE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ON_MOUSE_HOVER = SHAPE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ON_MOUSE_DRAG = SHAPE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__OUTLINE = SHAPE__OUTLINE;

    /**
     * The feature id for the '<em><b>Start</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__START = SHAPE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC__LENGTH = SHAPE_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Arc</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ARC_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.ConnectionImpl <em>Connection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.ConnectionImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getConnection()
     * @generated
     */
    int CONNECTION = 25;

    /**
     * The feature id for the '<em><b>Start</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__START = 0;

    /**
     * The feature id for the '<em><b>End</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION__END = 1;

    /**
     * The number of structural features of the '<em>Connection</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CONNECTION_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.StackContainerImpl <em>Stack Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.StackContainerImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getStackContainer()
     * @generated
     */
    int STACK_CONTAINER = 26;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STACK_CONTAINER__NAME = CONTAINER__NAME;

    /**
     * The feature id for the '<em><b>Children</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STACK_CONTAINER__CHILDREN = CONTAINER_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Stack Container</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STACK_CONTAINER_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.PolygonImpl <em>Polygon</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.PolygonImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getPolygon()
     * @generated
     */
    int POLYGON = 27;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__TOOL_TIP = SHAPE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__ON_MOUSE_IN = SHAPE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__ON_MOUSE_OUT = SHAPE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__ON_MOUSE_MOVE = SHAPE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__ON_MOUSE_HOVER = SHAPE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__ON_MOUSE_DRAG = SHAPE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__OUTLINE = SHAPE__OUTLINE;

    /**
     * The feature id for the '<em><b>Points</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON__POINTS = SHAPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Polygon</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int POLYGON_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.RoundedRectangleImpl <em>Rounded Rectangle</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.RoundedRectangleImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getRoundedRectangle()
     * @generated
     */
    int ROUNDED_RECTANGLE = 28;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__NAME = SHAPE__NAME;

    /**
     * The feature id for the '<em><b>Foreground Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__FOREGROUND_COLOR = SHAPE__FOREGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Background Color</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__BACKGROUND_COLOR = SHAPE__BACKGROUND_COLOR;

    /**
     * The feature id for the '<em><b>Size</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__SIZE = SHAPE__SIZE;

    /**
     * The feature id for the '<em><b>On Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__ON_CLICK = SHAPE__ON_CLICK;

    /**
     * The feature id for the '<em><b>On Double Click</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__ON_DOUBLE_CLICK = SHAPE__ON_DOUBLE_CLICK;

    /**
     * The feature id for the '<em><b>Cursor</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__CURSOR = SHAPE__CURSOR;

    /**
     * The feature id for the '<em><b>Visible</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__VISIBLE = SHAPE__VISIBLE;

    /**
     * The feature id for the '<em><b>Border</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__BORDER = SHAPE__BORDER;

    /**
     * The feature id for the '<em><b>Opaque</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__OPAQUE = SHAPE__OPAQUE;

    /**
     * The feature id for the '<em><b>Tool Tip</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__TOOL_TIP = SHAPE__TOOL_TIP;

    /**
     * The feature id for the '<em><b>On Mouse In</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__ON_MOUSE_IN = SHAPE__ON_MOUSE_IN;

    /**
     * The feature id for the '<em><b>On Mouse Out</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__ON_MOUSE_OUT = SHAPE__ON_MOUSE_OUT;

    /**
     * The feature id for the '<em><b>On Mouse Move</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__ON_MOUSE_MOVE = SHAPE__ON_MOUSE_MOVE;

    /**
     * The feature id for the '<em><b>On Mouse Hover</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__ON_MOUSE_HOVER = SHAPE__ON_MOUSE_HOVER;

    /**
     * The feature id for the '<em><b>On Mouse Drag</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__ON_MOUSE_DRAG = SHAPE__ON_MOUSE_DRAG;

    /**
     * The feature id for the '<em><b>Line Width</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__LINE_WIDTH = SHAPE__LINE_WIDTH;

    /**
     * The feature id for the '<em><b>Antialias</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__ANTIALIAS = SHAPE__ANTIALIAS;

    /**
     * The feature id for the '<em><b>Alpha</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__ALPHA = SHAPE__ALPHA;

    /**
     * The feature id for the '<em><b>Fill</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__FILL = SHAPE__FILL;

    /**
     * The feature id for the '<em><b>Outline</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__OUTLINE = SHAPE__OUTLINE;

    /**
     * The feature id for the '<em><b>Corner</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE__CORNER = SHAPE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Rounded Rectangle</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROUNDED_RECTANGLE_FEATURE_COUNT = SHAPE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.impl.TimeTriggerImpl <em>Time Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.impl.TimeTriggerImpl
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getTimeTrigger()
     * @generated
     */
    int TIME_TRIGGER = 29;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_TRIGGER__PERIOD = 0;

    /**
     * The feature id for the '<em><b>On Trigger</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_TRIGGER__ON_TRIGGER = 1;

    /**
     * The number of structural features of the '<em>Time Trigger</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int TIME_TRIGGER_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.Alignment <em>Alignment</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.Alignment
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getAlignment()
     * @generated
     */
    int ALIGNMENT = 30;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.Orientation <em>Orientation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.Orientation
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getOrientation()
     * @generated
     */
    int ORIENTATION = 31;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.SystemCursorType <em>System Cursor Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.SystemCursorType
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getSystemCursorType()
     * @generated
     */
    int SYSTEM_CURSOR_TYPE = 32;

    /**
     * The meta object id for the '{@link org.eclipse.scada.vi.model.GridAlignment <em>Grid Alignment</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.vi.model.GridAlignment
     * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getGridAlignment()
     * @generated
     */
    int GRID_ALIGNMENT = 33;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Symbol <em>Symbol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Symbol</em>'.
     * @see org.eclipse.scada.vi.model.Symbol
     * @generated
     */
    EClass getSymbol ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.vi.model.Symbol#getRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Root</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getRoot()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_Root ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.vi.model.Symbol#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Properties</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getProperties()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_Properties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Symbol#getOnInit <em>On Init</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Init</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getOnInit()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_OnInit ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Symbol#getOnDispose <em>On Dispose</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Dispose</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getOnDispose()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_OnDispose ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Symbol#getOnUpdate <em>On Update</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Update</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getOnUpdate()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_OnUpdate ();

    /**
     * Returns the meta object for the attribute list '{@link org.eclipse.scada.vi.model.Symbol#getScriptModules <em>Script Modules</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Script Modules</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getScriptModules()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_ScriptModules ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.vi.model.Symbol#getCursors <em>Cursors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Cursors</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getCursors()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_Cursors ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Symbol#getBackgroundColor <em>Background Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Background Color</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getBackgroundColor()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_BackgroundColor ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.vi.model.Symbol#getDesignSize <em>Design Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Design Size</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getDesignSize()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_DesignSize ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.vi.model.Symbol#getConnections <em>Connections</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Connections</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getConnections()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_Connections ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Symbol#getBackgroundImage <em>Background Image</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Background Image</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getBackgroundImage()
     * @see #getSymbol()
     * @generated
     */
    EAttribute getSymbol_BackgroundImage ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.vi.model.Symbol#getTimeTriggers <em>Time Triggers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Time Triggers</em>'.
     * @see org.eclipse.scada.vi.model.Symbol#getTimeTriggers()
     * @see #getSymbol()
     * @generated
     */
    EReference getSymbol_TimeTriggers ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Primitive <em>Primitive</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Primitive</em>'.
     * @see org.eclipse.scada.vi.model.Primitive
     * @generated
     */
    EClass getPrimitive ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Primitive#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.vi.model.Primitive#getName()
     * @see #getPrimitive()
     * @generated
     */
    EAttribute getPrimitive_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Container <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Container</em>'.
     * @see org.eclipse.scada.vi.model.Container
     * @generated
     */
    EClass getContainer ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Shape <em>Shape</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Shape</em>'.
     * @see org.eclipse.scada.vi.model.Shape
     * @generated
     */
    EClass getShape ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Shape#getLineWidth <em>Line Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Line Width</em>'.
     * @see org.eclipse.scada.vi.model.Shape#getLineWidth()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_LineWidth ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Shape#getAntialias <em>Antialias</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Antialias</em>'.
     * @see org.eclipse.scada.vi.model.Shape#getAntialias()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Antialias ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Shape#getAlpha <em>Alpha</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Alpha</em>'.
     * @see org.eclipse.scada.vi.model.Shape#getAlpha()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Alpha ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Shape#isFill <em>Fill</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Fill</em>'.
     * @see org.eclipse.scada.vi.model.Shape#isFill()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Fill ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Shape#isOutline <em>Outline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Outline</em>'.
     * @see org.eclipse.scada.vi.model.Shape#isOutline()
     * @see #getShape()
     * @generated
     */
    EAttribute getShape_Outline ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Rectangle <em>Rectangle</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rectangle</em>'.
     * @see org.eclipse.scada.vi.model.Rectangle
     * @generated
     */
    EClass getRectangle ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Text <em>Text</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Text</em>'.
     * @see org.eclipse.scada.vi.model.Text
     * @generated
     */
    EClass getText ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#getText <em>Text</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text</em>'.
     * @see org.eclipse.scada.vi.model.Text#getText()
     * @see #getText()
     * @generated
     */
    EAttribute getText_Text ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#getLabelAlignment <em>Label Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Label Alignment</em>'.
     * @see org.eclipse.scada.vi.model.Text#getLabelAlignment()
     * @see #getText()
     * @generated
     */
    EAttribute getText_LabelAlignment ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#getIconAlignment <em>Icon Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Icon Alignment</em>'.
     * @see org.eclipse.scada.vi.model.Text#getIconAlignment()
     * @see #getText()
     * @generated
     */
    EAttribute getText_IconAlignment ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#getTextAlignment <em>Text Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text Alignment</em>'.
     * @see org.eclipse.scada.vi.model.Text#getTextAlignment()
     * @see #getText()
     * @generated
     */
    EAttribute getText_TextAlignment ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#getTextPlacement <em>Text Placement</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Text Placement</em>'.
     * @see org.eclipse.scada.vi.model.Text#getTextPlacement()
     * @see #getText()
     * @generated
     */
    EAttribute getText_TextPlacement ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#getFontName <em>Font Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Font Name</em>'.
     * @see org.eclipse.scada.vi.model.Text#getFontName()
     * @see #getText()
     * @generated
     */
    EAttribute getText_FontName ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#getFontSize <em>Font Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Font Size</em>'.
     * @see org.eclipse.scada.vi.model.Text#getFontSize()
     * @see #getText()
     * @generated
     */
    EAttribute getText_FontSize ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#isFontBold <em>Font Bold</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Font Bold</em>'.
     * @see org.eclipse.scada.vi.model.Text#isFontBold()
     * @see #getText()
     * @generated
     */
    EAttribute getText_FontBold ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#isFontItalic <em>Font Italic</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Font Italic</em>'.
     * @see org.eclipse.scada.vi.model.Text#isFontItalic()
     * @see #getText()
     * @generated
     */
    EAttribute getText_FontItalic ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Text#getAlpha <em>Alpha</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Alpha</em>'.
     * @see org.eclipse.scada.vi.model.Text#getAlpha()
     * @see #getText()
     * @generated
     */
    EAttribute getText_Alpha ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Child <em>Child</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Child</em>'.
     * @see org.eclipse.scada.vi.model.Child
     * @generated
     */
    EClass getChild ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.vi.model.Child#getElement <em>Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Element</em>'.
     * @see org.eclipse.scada.vi.model.Child#getElement()
     * @see #getChild()
     * @generated
     */
    EReference getChild_Element ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Child#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.vi.model.Child#getName()
     * @see #getChild()
     * @generated
     */
    EAttribute getChild_Name ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.XYChild <em>XY Child</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>XY Child</em>'.
     * @see org.eclipse.scada.vi.model.XYChild
     * @generated
     */
    EClass getXYChild ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.vi.model.XYChild#getPosition <em>Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Position</em>'.
     * @see org.eclipse.scada.vi.model.XYChild#getPosition()
     * @see #getXYChild()
     * @generated
     */
    EReference getXYChild_Position ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.vi.model.XYChild#getDimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Dimension</em>'.
     * @see org.eclipse.scada.vi.model.XYChild#getDimension()
     * @see #getXYChild()
     * @generated
     */
    EReference getXYChild_Dimension ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.XYContainer <em>XY Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>XY Container</em>'.
     * @see org.eclipse.scada.vi.model.XYContainer
     * @generated
     */
    EClass getXYContainer ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.vi.model.XYContainer#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see org.eclipse.scada.vi.model.XYContainer#getChildren()
     * @see #getXYContainer()
     * @generated
     */
    EReference getXYContainer_Children ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Position <em>Position</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Position</em>'.
     * @see org.eclipse.scada.vi.model.Position
     * @generated
     */
    EClass getPosition ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Position#getX <em>X</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>X</em>'.
     * @see org.eclipse.scada.vi.model.Position#getX()
     * @see #getPosition()
     * @generated
     */
    EAttribute getPosition_X ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Position#getY <em>Y</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Y</em>'.
     * @see org.eclipse.scada.vi.model.Position#getY()
     * @see #getPosition()
     * @generated
     */
    EAttribute getPosition_Y ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Line <em>Line</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Line</em>'.
     * @see org.eclipse.scada.vi.model.Line
     * @generated
     */
    EClass getLine ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.vi.model.Line#getPoints <em>Points</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Points</em>'.
     * @see org.eclipse.scada.vi.model.Line#getPoints()
     * @see #getLine()
     * @generated
     */
    EReference getLine_Points ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Figure <em>Figure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Figure</em>'.
     * @see org.eclipse.scada.vi.model.Figure
     * @generated
     */
    EClass getFigure ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getForegroundColor <em>Foreground Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Foreground Color</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getForegroundColor()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_ForegroundColor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getBackgroundColor <em>Background Color</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Background Color</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getBackgroundColor()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_BackgroundColor ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.vi.model.Figure#getSize <em>Size</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Size</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getSize()
     * @see #getFigure()
     * @generated
     */
    EReference getFigure_Size ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getOnClick <em>On Click</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Click</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getOnClick()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_OnClick ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getOnDoubleClick <em>On Double Click</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Double Click</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getOnDoubleClick()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_OnDoubleClick ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.vi.model.Figure#getCursor <em>Cursor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Cursor</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getCursor()
     * @see #getFigure()
     * @generated
     */
    EReference getFigure_Cursor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#isVisible <em>Visible</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Visible</em>'.
     * @see org.eclipse.scada.vi.model.Figure#isVisible()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_Visible ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getBorder <em>Border</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Border</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getBorder()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_Border ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getOpaque <em>Opaque</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Opaque</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getOpaque()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_Opaque ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getToolTip <em>Tool Tip</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Tool Tip</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getToolTip()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_ToolTip ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getOnMouseIn <em>On Mouse In</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Mouse In</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getOnMouseIn()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_OnMouseIn ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getOnMouseOut <em>On Mouse Out</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Mouse Out</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getOnMouseOut()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_OnMouseOut ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getOnMouseMove <em>On Mouse Move</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Mouse Move</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getOnMouseMove()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_OnMouseMove ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getOnMouseHover <em>On Mouse Hover</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Mouse Hover</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getOnMouseHover()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_OnMouseHover ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Figure#getOnMouseDrag <em>On Mouse Drag</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Mouse Drag</em>'.
     * @see org.eclipse.scada.vi.model.Figure#getOnMouseDrag()
     * @see #getFigure()
     * @generated
     */
    EAttribute getFigure_OnMouseDrag ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.SymbolReference <em>Symbol Reference</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Symbol Reference</em>'.
     * @see org.eclipse.scada.vi.model.SymbolReference
     * @generated
     */
    EClass getSymbolReference ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.SymbolReference#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.eclipse.scada.vi.model.SymbolReference#getUri()
     * @see #getSymbolReference()
     * @generated
     */
    EAttribute getSymbolReference_Uri ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.SymbolReference#getZoom <em>Zoom</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Zoom</em>'.
     * @see org.eclipse.scada.vi.model.SymbolReference#getZoom()
     * @see #getSymbolReference()
     * @generated
     */
    EAttribute getSymbolReference_Zoom ();

    /**
     * Returns the meta object for the map '{@link org.eclipse.scada.vi.model.SymbolReference#getProperties <em>Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Properties</em>'.
     * @see org.eclipse.scada.vi.model.SymbolReference#getProperties()
     * @see #getSymbolReference()
     * @generated
     */
    EReference getSymbolReference_Properties ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.SymbolReference#getOnCreateProperties <em>On Create Properties</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Create Properties</em>'.
     * @see org.eclipse.scada.vi.model.SymbolReference#getOnCreateProperties()
     * @see #getSymbolReference()
     * @generated
     */
    EAttribute getSymbolReference_OnCreateProperties ();

    /**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>String To String Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>String To String Map</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="org.eclipse.emf.ecore.EString" keyRequired="true"
     *        valueDataType="org.eclipse.emf.ecore.EString"
     * @generated
     */
    EClass getStringToStringMap ();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getStringToStringMap()
     * @generated
     */
    EAttribute getStringToStringMap_Key ();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getStringToStringMap()
     * @generated
     */
    EAttribute getStringToStringMap_Value ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Dimension <em>Dimension</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dimension</em>'.
     * @see org.eclipse.scada.vi.model.Dimension
     * @generated
     */
    EClass getDimension ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Dimension#getWidth <em>Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Width</em>'.
     * @see org.eclipse.scada.vi.model.Dimension#getWidth()
     * @see #getDimension()
     * @generated
     */
    EAttribute getDimension_Width ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Dimension#getHeight <em>Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Height</em>'.
     * @see org.eclipse.scada.vi.model.Dimension#getHeight()
     * @see #getDimension()
     * @generated
     */
    EAttribute getDimension_Height ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Cursor <em>Cursor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cursor</em>'.
     * @see org.eclipse.scada.vi.model.Cursor
     * @generated
     */
    EClass getCursor ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.SystemCursor <em>System Cursor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>System Cursor</em>'.
     * @see org.eclipse.scada.vi.model.SystemCursor
     * @generated
     */
    EClass getSystemCursor ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.SystemCursor#getType <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.scada.vi.model.SystemCursor#getType()
     * @see #getSystemCursor()
     * @generated
     */
    EAttribute getSystemCursor_Type ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.GridContainer <em>Grid Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Grid Container</em>'.
     * @see org.eclipse.scada.vi.model.GridContainer
     * @generated
     */
    EClass getGridContainer ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridContainer#getColumns <em>Columns</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Columns</em>'.
     * @see org.eclipse.scada.vi.model.GridContainer#getColumns()
     * @see #getGridContainer()
     * @generated
     */
    EAttribute getGridContainer_Columns ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridContainer#isEqualWidth <em>Equal Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Equal Width</em>'.
     * @see org.eclipse.scada.vi.model.GridContainer#isEqualWidth()
     * @see #getGridContainer()
     * @generated
     */
    EAttribute getGridContainer_EqualWidth ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.vi.model.GridContainer#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see org.eclipse.scada.vi.model.GridContainer#getChildren()
     * @see #getGridContainer()
     * @generated
     */
    EReference getGridContainer_Children ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridContainer#getHorizontalSpacing <em>Horizontal Spacing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Horizontal Spacing</em>'.
     * @see org.eclipse.scada.vi.model.GridContainer#getHorizontalSpacing()
     * @see #getGridContainer()
     * @generated
     */
    EAttribute getGridContainer_HorizontalSpacing ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridContainer#getVerticalSpacing <em>Vertical Spacing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Vertical Spacing</em>'.
     * @see org.eclipse.scada.vi.model.GridContainer#getVerticalSpacing()
     * @see #getGridContainer()
     * @generated
     */
    EAttribute getGridContainer_VerticalSpacing ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridContainer#getMarginWidth <em>Margin Width</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Margin Width</em>'.
     * @see org.eclipse.scada.vi.model.GridContainer#getMarginWidth()
     * @see #getGridContainer()
     * @generated
     */
    EAttribute getGridContainer_MarginWidth ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridContainer#getMarginHeight <em>Margin Height</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Margin Height</em>'.
     * @see org.eclipse.scada.vi.model.GridContainer#getMarginHeight()
     * @see #getGridContainer()
     * @generated
     */
    EAttribute getGridContainer_MarginHeight ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.BorderContainer <em>Border Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Border Container</em>'.
     * @see org.eclipse.scada.vi.model.BorderContainer
     * @generated
     */
    EClass getBorderContainer ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.vi.model.BorderContainer#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see org.eclipse.scada.vi.model.BorderContainer#getChildren()
     * @see #getBorderContainer()
     * @generated
     */
    EReference getBorderContainer_Children ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.BorderContainer#getVerticalSpacing <em>Vertical Spacing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Vertical Spacing</em>'.
     * @see org.eclipse.scada.vi.model.BorderContainer#getVerticalSpacing()
     * @see #getBorderContainer()
     * @generated
     */
    EAttribute getBorderContainer_VerticalSpacing ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.BorderContainer#getHorizontalSpacing <em>Horizontal Spacing</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Horizontal Spacing</em>'.
     * @see org.eclipse.scada.vi.model.BorderContainer#getHorizontalSpacing()
     * @see #getBorderContainer()
     * @generated
     */
    EAttribute getBorderContainer_HorizontalSpacing ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.BorderChild <em>Border Child</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Border Child</em>'.
     * @see org.eclipse.scada.vi.model.BorderChild
     * @generated
     */
    EClass getBorderChild ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.BorderChild#getAlignment <em>Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Alignment</em>'.
     * @see org.eclipse.scada.vi.model.BorderChild#getAlignment()
     * @see #getBorderChild()
     * @generated
     */
    EAttribute getBorderChild_Alignment ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.GridChild <em>Grid Child</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Grid Child</em>'.
     * @see org.eclipse.scada.vi.model.GridChild
     * @generated
     */
    EClass getGridChild ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridChild#getHorizontalAlignment <em>Horizontal Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Horizontal Alignment</em>'.
     * @see org.eclipse.scada.vi.model.GridChild#getHorizontalAlignment()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_HorizontalAlignment ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridChild#getVerticalAlignment <em>Vertical Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Vertical Alignment</em>'.
     * @see org.eclipse.scada.vi.model.GridChild#getVerticalAlignment()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_VerticalAlignment ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridChild#isGrabHorizontalSpace <em>Grab Horizontal Space</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Grab Horizontal Space</em>'.
     * @see org.eclipse.scada.vi.model.GridChild#isGrabHorizontalSpace()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_GrabHorizontalSpace ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridChild#isGrabVerticalSpace <em>Grab Vertical Space</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Grab Vertical Space</em>'.
     * @see org.eclipse.scada.vi.model.GridChild#isGrabVerticalSpace()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_GrabVerticalSpace ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridChild#getSpanCols <em>Span Cols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Span Cols</em>'.
     * @see org.eclipse.scada.vi.model.GridChild#getSpanCols()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_SpanCols ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridChild#getSpanRows <em>Span Rows</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Span Rows</em>'.
     * @see org.eclipse.scada.vi.model.GridChild#getSpanRows()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_SpanRows ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridChild#getWidthHint <em>Width Hint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Width Hint</em>'.
     * @see org.eclipse.scada.vi.model.GridChild#getWidthHint()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_WidthHint ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.GridChild#getHeightHint <em>Height Hint</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Height Hint</em>'.
     * @see org.eclipse.scada.vi.model.GridChild#getHeightHint()
     * @see #getGridChild()
     * @generated
     */
    EAttribute getGridChild_HeightHint ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.FigureContainer <em>Figure Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Figure Container</em>'.
     * @see org.eclipse.scada.vi.model.FigureContainer
     * @generated
     */
    EClass getFigureContainer ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.vi.model.FigureContainer#getContent <em>Content</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Content</em>'.
     * @see org.eclipse.scada.vi.model.FigureContainer#getContent()
     * @see #getFigureContainer()
     * @generated
     */
    EReference getFigureContainer_Content ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Image <em>Image</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Image</em>'.
     * @see org.eclipse.scada.vi.model.Image
     * @generated
     */
    EClass getImage ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Image#getUri <em>Uri</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Uri</em>'.
     * @see org.eclipse.scada.vi.model.Image#getUri()
     * @see #getImage()
     * @generated
     */
    EAttribute getImage_Uri ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Image#getImageAlignment <em>Image Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Image Alignment</em>'.
     * @see org.eclipse.scada.vi.model.Image#getImageAlignment()
     * @see #getImage()
     * @generated
     */
    EAttribute getImage_ImageAlignment ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Ellipse <em>Ellipse</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ellipse</em>'.
     * @see org.eclipse.scada.vi.model.Ellipse
     * @generated
     */
    EClass getEllipse ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Arc <em>Arc</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Arc</em>'.
     * @see org.eclipse.scada.vi.model.Arc
     * @generated
     */
    EClass getArc ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Arc#getStart <em>Start</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Start</em>'.
     * @see org.eclipse.scada.vi.model.Arc#getStart()
     * @see #getArc()
     * @generated
     */
    EAttribute getArc_Start ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.Arc#getLength <em>Length</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Length</em>'.
     * @see org.eclipse.scada.vi.model.Arc#getLength()
     * @see #getArc()
     * @generated
     */
    EAttribute getArc_Length ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Connection <em>Connection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Connection</em>'.
     * @see org.eclipse.scada.vi.model.Connection
     * @generated
     */
    EClass getConnection ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.vi.model.Connection#getStart <em>Start</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Start</em>'.
     * @see org.eclipse.scada.vi.model.Connection#getStart()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_Start ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.vi.model.Connection#getEnd <em>End</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>End</em>'.
     * @see org.eclipse.scada.vi.model.Connection#getEnd()
     * @see #getConnection()
     * @generated
     */
    EReference getConnection_End ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.StackContainer <em>Stack Container</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Stack Container</em>'.
     * @see org.eclipse.scada.vi.model.StackContainer
     * @generated
     */
    EClass getStackContainer ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.vi.model.StackContainer#getChildren <em>Children</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Children</em>'.
     * @see org.eclipse.scada.vi.model.StackContainer#getChildren()
     * @see #getStackContainer()
     * @generated
     */
    EReference getStackContainer_Children ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.Polygon <em>Polygon</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Polygon</em>'.
     * @see org.eclipse.scada.vi.model.Polygon
     * @generated
     */
    EClass getPolygon ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.vi.model.Polygon#getPoints <em>Points</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Points</em>'.
     * @see org.eclipse.scada.vi.model.Polygon#getPoints()
     * @see #getPolygon()
     * @generated
     */
    EReference getPolygon_Points ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.RoundedRectangle <em>Rounded Rectangle</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Rounded Rectangle</em>'.
     * @see org.eclipse.scada.vi.model.RoundedRectangle
     * @generated
     */
    EClass getRoundedRectangle ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.vi.model.RoundedRectangle#getCorner <em>Corner</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Corner</em>'.
     * @see org.eclipse.scada.vi.model.RoundedRectangle#getCorner()
     * @see #getRoundedRectangle()
     * @generated
     */
    EReference getRoundedRectangle_Corner ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.vi.model.TimeTrigger <em>Time Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Time Trigger</em>'.
     * @see org.eclipse.scada.vi.model.TimeTrigger
     * @generated
     */
    EClass getTimeTrigger ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.TimeTrigger#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.vi.model.TimeTrigger#getPeriod()
     * @see #getTimeTrigger()
     * @generated
     */
    EAttribute getTimeTrigger_Period ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.vi.model.TimeTrigger#getOnTrigger <em>On Trigger</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>On Trigger</em>'.
     * @see org.eclipse.scada.vi.model.TimeTrigger#getOnTrigger()
     * @see #getTimeTrigger()
     * @generated
     */
    EAttribute getTimeTrigger_OnTrigger ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.vi.model.Alignment <em>Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Alignment</em>'.
     * @see org.eclipse.scada.vi.model.Alignment
     * @generated
     */
    EEnum getAlignment ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.vi.model.Orientation <em>Orientation</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Orientation</em>'.
     * @see org.eclipse.scada.vi.model.Orientation
     * @generated
     */
    EEnum getOrientation ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.vi.model.SystemCursorType <em>System Cursor Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>System Cursor Type</em>'.
     * @see org.eclipse.scada.vi.model.SystemCursorType
     * @generated
     */
    EEnum getSystemCursorType ();

    /**
     * Returns the meta object for enum '{@link org.eclipse.scada.vi.model.GridAlignment <em>Grid Alignment</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Grid Alignment</em>'.
     * @see org.eclipse.scada.vi.model.GridAlignment
     * @generated
     */
    EEnum getGridAlignment ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    VisualInterfaceFactory getVisualInterfaceFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.SymbolImpl <em>Symbol</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.SymbolImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getSymbol()
         * @generated
         */
        EClass SYMBOL = eINSTANCE.getSymbol ();

        /**
         * The meta object literal for the '<em><b>Root</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__ROOT = eINSTANCE.getSymbol_Root ();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__PROPERTIES = eINSTANCE.getSymbol_Properties ();

        /**
         * The meta object literal for the '<em><b>On Init</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__ON_INIT = eINSTANCE.getSymbol_OnInit ();

        /**
         * The meta object literal for the '<em><b>On Dispose</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__ON_DISPOSE = eINSTANCE.getSymbol_OnDispose ();

        /**
         * The meta object literal for the '<em><b>On Update</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__ON_UPDATE = eINSTANCE.getSymbol_OnUpdate ();

        /**
         * The meta object literal for the '<em><b>Script Modules</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__SCRIPT_MODULES = eINSTANCE.getSymbol_ScriptModules ();

        /**
         * The meta object literal for the '<em><b>Cursors</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__CURSORS = eINSTANCE.getSymbol_Cursors ();

        /**
         * The meta object literal for the '<em><b>Background Color</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__BACKGROUND_COLOR = eINSTANCE.getSymbol_BackgroundColor ();

        /**
         * The meta object literal for the '<em><b>Design Size</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__DESIGN_SIZE = eINSTANCE.getSymbol_DesignSize ();

        /**
         * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__CONNECTIONS = eINSTANCE.getSymbol_Connections ();

        /**
         * The meta object literal for the '<em><b>Background Image</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL__BACKGROUND_IMAGE = eINSTANCE.getSymbol_BackgroundImage ();

        /**
         * The meta object literal for the '<em><b>Time Triggers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL__TIME_TRIGGERS = eINSTANCE.getSymbol_TimeTriggers ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.Primitive <em>Primitive</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.Primitive
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getPrimitive()
         * @generated
         */
        EClass PRIMITIVE = eINSTANCE.getPrimitive ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PRIMITIVE__NAME = eINSTANCE.getPrimitive_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.Container <em>Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.Container
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getContainer()
         * @generated
         */
        EClass CONTAINER = eINSTANCE.getContainer ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.ShapeImpl <em>Shape</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.ShapeImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getShape()
         * @generated
         */
        EClass SHAPE = eINSTANCE.getShape ();

        /**
         * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__LINE_WIDTH = eINSTANCE.getShape_LineWidth ();

        /**
         * The meta object literal for the '<em><b>Antialias</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__ANTIALIAS = eINSTANCE.getShape_Antialias ();

        /**
         * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__ALPHA = eINSTANCE.getShape_Alpha ();

        /**
         * The meta object literal for the '<em><b>Fill</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__FILL = eINSTANCE.getShape_Fill ();

        /**
         * The meta object literal for the '<em><b>Outline</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SHAPE__OUTLINE = eINSTANCE.getShape_Outline ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.RectangleImpl <em>Rectangle</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.RectangleImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getRectangle()
         * @generated
         */
        EClass RECTANGLE = eINSTANCE.getRectangle ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.TextImpl <em>Text</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.TextImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getText()
         * @generated
         */
        EClass TEXT = eINSTANCE.getText ();

        /**
         * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__TEXT = eINSTANCE.getText_Text ();

        /**
         * The meta object literal for the '<em><b>Label Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__LABEL_ALIGNMENT = eINSTANCE.getText_LabelAlignment ();

        /**
         * The meta object literal for the '<em><b>Icon Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__ICON_ALIGNMENT = eINSTANCE.getText_IconAlignment ();

        /**
         * The meta object literal for the '<em><b>Text Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__TEXT_ALIGNMENT = eINSTANCE.getText_TextAlignment ();

        /**
         * The meta object literal for the '<em><b>Text Placement</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__TEXT_PLACEMENT = eINSTANCE.getText_TextPlacement ();

        /**
         * The meta object literal for the '<em><b>Font Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__FONT_NAME = eINSTANCE.getText_FontName ();

        /**
         * The meta object literal for the '<em><b>Font Size</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__FONT_SIZE = eINSTANCE.getText_FontSize ();

        /**
         * The meta object literal for the '<em><b>Font Bold</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__FONT_BOLD = eINSTANCE.getText_FontBold ();

        /**
         * The meta object literal for the '<em><b>Font Italic</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__FONT_ITALIC = eINSTANCE.getText_FontItalic ();

        /**
         * The meta object literal for the '<em><b>Alpha</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TEXT__ALPHA = eINSTANCE.getText_Alpha ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.ChildImpl <em>Child</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.ChildImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getChild()
         * @generated
         */
        EClass CHILD = eINSTANCE.getChild ();

        /**
         * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CHILD__ELEMENT = eINSTANCE.getChild_Element ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute CHILD__NAME = eINSTANCE.getChild_Name ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.XYChildImpl <em>XY Child</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.XYChildImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getXYChild()
         * @generated
         */
        EClass XY_CHILD = eINSTANCE.getXYChild ();

        /**
         * The meta object literal for the '<em><b>Position</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference XY_CHILD__POSITION = eINSTANCE.getXYChild_Position ();

        /**
         * The meta object literal for the '<em><b>Dimension</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference XY_CHILD__DIMENSION = eINSTANCE.getXYChild_Dimension ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.XYContainerImpl <em>XY Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.XYContainerImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getXYContainer()
         * @generated
         */
        EClass XY_CONTAINER = eINSTANCE.getXYContainer ();

        /**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference XY_CONTAINER__CHILDREN = eINSTANCE.getXYContainer_Children ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.PositionImpl <em>Position</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.PositionImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getPosition()
         * @generated
         */
        EClass POSITION = eINSTANCE.getPosition ();

        /**
         * The meta object literal for the '<em><b>X</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSITION__X = eINSTANCE.getPosition_X ();

        /**
         * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute POSITION__Y = eINSTANCE.getPosition_Y ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.LineImpl <em>Line</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.LineImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getLine()
         * @generated
         */
        EClass LINE = eINSTANCE.getLine ();

        /**
         * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LINE__POINTS = eINSTANCE.getLine_Points ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.FigureImpl <em>Figure</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.FigureImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getFigure()
         * @generated
         */
        EClass FIGURE = eINSTANCE.getFigure ();

        /**
         * The meta object literal for the '<em><b>Foreground Color</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__FOREGROUND_COLOR = eINSTANCE.getFigure_ForegroundColor ();

        /**
         * The meta object literal for the '<em><b>Background Color</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__BACKGROUND_COLOR = eINSTANCE.getFigure_BackgroundColor ();

        /**
         * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIGURE__SIZE = eINSTANCE.getFigure_Size ();

        /**
         * The meta object literal for the '<em><b>On Click</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__ON_CLICK = eINSTANCE.getFigure_OnClick ();

        /**
         * The meta object literal for the '<em><b>On Double Click</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__ON_DOUBLE_CLICK = eINSTANCE.getFigure_OnDoubleClick ();

        /**
         * The meta object literal for the '<em><b>Cursor</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIGURE__CURSOR = eINSTANCE.getFigure_Cursor ();

        /**
         * The meta object literal for the '<em><b>Visible</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__VISIBLE = eINSTANCE.getFigure_Visible ();

        /**
         * The meta object literal for the '<em><b>Border</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__BORDER = eINSTANCE.getFigure_Border ();

        /**
         * The meta object literal for the '<em><b>Opaque</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__OPAQUE = eINSTANCE.getFigure_Opaque ();

        /**
         * The meta object literal for the '<em><b>Tool Tip</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__TOOL_TIP = eINSTANCE.getFigure_ToolTip ();

        /**
         * The meta object literal for the '<em><b>On Mouse In</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__ON_MOUSE_IN = eINSTANCE.getFigure_OnMouseIn ();

        /**
         * The meta object literal for the '<em><b>On Mouse Out</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__ON_MOUSE_OUT = eINSTANCE.getFigure_OnMouseOut ();

        /**
         * The meta object literal for the '<em><b>On Mouse Move</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__ON_MOUSE_MOVE = eINSTANCE.getFigure_OnMouseMove ();

        /**
         * The meta object literal for the '<em><b>On Mouse Hover</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__ON_MOUSE_HOVER = eINSTANCE.getFigure_OnMouseHover ();

        /**
         * The meta object literal for the '<em><b>On Mouse Drag</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FIGURE__ON_MOUSE_DRAG = eINSTANCE.getFigure_OnMouseDrag ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.SymbolReferenceImpl <em>Symbol Reference</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.SymbolReferenceImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getSymbolReference()
         * @generated
         */
        EClass SYMBOL_REFERENCE = eINSTANCE.getSymbolReference ();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL_REFERENCE__URI = eINSTANCE.getSymbolReference_Uri ();

        /**
         * The meta object literal for the '<em><b>Zoom</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL_REFERENCE__ZOOM = eINSTANCE.getSymbolReference_Zoom ();

        /**
         * The meta object literal for the '<em><b>Properties</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference SYMBOL_REFERENCE__PROPERTIES = eINSTANCE.getSymbolReference_Properties ();

        /**
         * The meta object literal for the '<em><b>On Create Properties</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYMBOL_REFERENCE__ON_CREATE_PROPERTIES = eINSTANCE.getSymbolReference_OnCreateProperties ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.StringToStringMapImpl <em>String To String Map</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.StringToStringMapImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getStringToStringMap()
         * @generated
         */
        EClass STRING_TO_STRING_MAP = eINSTANCE.getStringToStringMap ();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STRING_TO_STRING_MAP__KEY = eINSTANCE.getStringToStringMap_Key ();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STRING_TO_STRING_MAP__VALUE = eINSTANCE.getStringToStringMap_Value ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.DimensionImpl <em>Dimension</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.DimensionImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getDimension()
         * @generated
         */
        EClass DIMENSION = eINSTANCE.getDimension ();

        /**
         * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIMENSION__WIDTH = eINSTANCE.getDimension_Width ();

        /**
         * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DIMENSION__HEIGHT = eINSTANCE.getDimension_Height ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.CursorImpl <em>Cursor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.CursorImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getCursor()
         * @generated
         */
        EClass CURSOR = eINSTANCE.getCursor ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.SystemCursorImpl <em>System Cursor</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.SystemCursorImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getSystemCursor()
         * @generated
         */
        EClass SYSTEM_CURSOR = eINSTANCE.getSystemCursor ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute SYSTEM_CURSOR__TYPE = eINSTANCE.getSystemCursor_Type ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.GridContainerImpl <em>Grid Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.GridContainerImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getGridContainer()
         * @generated
         */
        EClass GRID_CONTAINER = eINSTANCE.getGridContainer ();

        /**
         * The meta object literal for the '<em><b>Columns</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CONTAINER__COLUMNS = eINSTANCE.getGridContainer_Columns ();

        /**
         * The meta object literal for the '<em><b>Equal Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CONTAINER__EQUAL_WIDTH = eINSTANCE.getGridContainer_EqualWidth ();

        /**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference GRID_CONTAINER__CHILDREN = eINSTANCE.getGridContainer_Children ();

        /**
         * The meta object literal for the '<em><b>Horizontal Spacing</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CONTAINER__HORIZONTAL_SPACING = eINSTANCE.getGridContainer_HorizontalSpacing ();

        /**
         * The meta object literal for the '<em><b>Vertical Spacing</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CONTAINER__VERTICAL_SPACING = eINSTANCE.getGridContainer_VerticalSpacing ();

        /**
         * The meta object literal for the '<em><b>Margin Width</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CONTAINER__MARGIN_WIDTH = eINSTANCE.getGridContainer_MarginWidth ();

        /**
         * The meta object literal for the '<em><b>Margin Height</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CONTAINER__MARGIN_HEIGHT = eINSTANCE.getGridContainer_MarginHeight ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.BorderContainerImpl <em>Border Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.BorderContainerImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getBorderContainer()
         * @generated
         */
        EClass BORDER_CONTAINER = eINSTANCE.getBorderContainer ();

        /**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference BORDER_CONTAINER__CHILDREN = eINSTANCE.getBorderContainer_Children ();

        /**
         * The meta object literal for the '<em><b>Vertical Spacing</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BORDER_CONTAINER__VERTICAL_SPACING = eINSTANCE.getBorderContainer_VerticalSpacing ();

        /**
         * The meta object literal for the '<em><b>Horizontal Spacing</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BORDER_CONTAINER__HORIZONTAL_SPACING = eINSTANCE.getBorderContainer_HorizontalSpacing ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.BorderChildImpl <em>Border Child</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.BorderChildImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getBorderChild()
         * @generated
         */
        EClass BORDER_CHILD = eINSTANCE.getBorderChild ();

        /**
         * The meta object literal for the '<em><b>Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute BORDER_CHILD__ALIGNMENT = eINSTANCE.getBorderChild_Alignment ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.GridChildImpl <em>Grid Child</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.GridChildImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getGridChild()
         * @generated
         */
        EClass GRID_CHILD = eINSTANCE.getGridChild ();

        /**
         * The meta object literal for the '<em><b>Horizontal Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__HORIZONTAL_ALIGNMENT = eINSTANCE.getGridChild_HorizontalAlignment ();

        /**
         * The meta object literal for the '<em><b>Vertical Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__VERTICAL_ALIGNMENT = eINSTANCE.getGridChild_VerticalAlignment ();

        /**
         * The meta object literal for the '<em><b>Grab Horizontal Space</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__GRAB_HORIZONTAL_SPACE = eINSTANCE.getGridChild_GrabHorizontalSpace ();

        /**
         * The meta object literal for the '<em><b>Grab Vertical Space</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__GRAB_VERTICAL_SPACE = eINSTANCE.getGridChild_GrabVerticalSpace ();

        /**
         * The meta object literal for the '<em><b>Span Cols</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__SPAN_COLS = eINSTANCE.getGridChild_SpanCols ();

        /**
         * The meta object literal for the '<em><b>Span Rows</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__SPAN_ROWS = eINSTANCE.getGridChild_SpanRows ();

        /**
         * The meta object literal for the '<em><b>Width Hint</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__WIDTH_HINT = eINSTANCE.getGridChild_WidthHint ();

        /**
         * The meta object literal for the '<em><b>Height Hint</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute GRID_CHILD__HEIGHT_HINT = eINSTANCE.getGridChild_HeightHint ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.FigureContainerImpl <em>Figure Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.FigureContainerImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getFigureContainer()
         * @generated
         */
        EClass FIGURE_CONTAINER = eINSTANCE.getFigureContainer ();

        /**
         * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference FIGURE_CONTAINER__CONTENT = eINSTANCE.getFigureContainer_Content ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.ImageImpl <em>Image</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.ImageImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getImage()
         * @generated
         */
        EClass IMAGE = eINSTANCE.getImage ();

        /**
         * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IMAGE__URI = eINSTANCE.getImage_Uri ();

        /**
         * The meta object literal for the '<em><b>Image Alignment</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IMAGE__IMAGE_ALIGNMENT = eINSTANCE.getImage_ImageAlignment ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.EllipseImpl <em>Ellipse</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.EllipseImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getEllipse()
         * @generated
         */
        EClass ELLIPSE = eINSTANCE.getEllipse ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.ArcImpl <em>Arc</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.ArcImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getArc()
         * @generated
         */
        EClass ARC = eINSTANCE.getArc ();

        /**
         * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ARC__START = eINSTANCE.getArc_Start ();

        /**
         * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ARC__LENGTH = eINSTANCE.getArc_Length ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.ConnectionImpl <em>Connection</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.ConnectionImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getConnection()
         * @generated
         */
        EClass CONNECTION = eINSTANCE.getConnection ();

        /**
         * The meta object literal for the '<em><b>Start</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION__START = eINSTANCE.getConnection_Start ();

        /**
         * The meta object literal for the '<em><b>End</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference CONNECTION__END = eINSTANCE.getConnection_End ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.StackContainerImpl <em>Stack Container</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.StackContainerImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getStackContainer()
         * @generated
         */
        EClass STACK_CONTAINER = eINSTANCE.getStackContainer ();

        /**
         * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STACK_CONTAINER__CHILDREN = eINSTANCE.getStackContainer_Children ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.PolygonImpl <em>Polygon</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.PolygonImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getPolygon()
         * @generated
         */
        EClass POLYGON = eINSTANCE.getPolygon ();

        /**
         * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference POLYGON__POINTS = eINSTANCE.getPolygon_Points ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.RoundedRectangleImpl <em>Rounded Rectangle</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.RoundedRectangleImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getRoundedRectangle()
         * @generated
         */
        EClass ROUNDED_RECTANGLE = eINSTANCE.getRoundedRectangle ();

        /**
         * The meta object literal for the '<em><b>Corner</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ROUNDED_RECTANGLE__CORNER = eINSTANCE.getRoundedRectangle_Corner ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.impl.TimeTriggerImpl <em>Time Trigger</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.impl.TimeTriggerImpl
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getTimeTrigger()
         * @generated
         */
        EClass TIME_TRIGGER = eINSTANCE.getTimeTrigger ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TIME_TRIGGER__PERIOD = eINSTANCE.getTimeTrigger_Period ();

        /**
         * The meta object literal for the '<em><b>On Trigger</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute TIME_TRIGGER__ON_TRIGGER = eINSTANCE.getTimeTrigger_OnTrigger ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.Alignment <em>Alignment</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.Alignment
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getAlignment()
         * @generated
         */
        EEnum ALIGNMENT = eINSTANCE.getAlignment ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.Orientation <em>Orientation</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.Orientation
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getOrientation()
         * @generated
         */
        EEnum ORIENTATION = eINSTANCE.getOrientation ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.SystemCursorType <em>System Cursor Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.SystemCursorType
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getSystemCursorType()
         * @generated
         */
        EEnum SYSTEM_CURSOR_TYPE = eINSTANCE.getSystemCursorType ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.vi.model.GridAlignment <em>Grid Alignment</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.vi.model.GridAlignment
         * @see org.eclipse.scada.vi.model.impl.VisualInterfacePackageImpl#getGridAlignment()
         * @generated
         */
        EEnum GRID_ALIGNMENT = eINSTANCE.getGridAlignment ();

    }

} //VisualInterfacePackage
