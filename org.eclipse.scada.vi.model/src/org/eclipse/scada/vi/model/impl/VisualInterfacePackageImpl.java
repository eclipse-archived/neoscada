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
package org.eclipse.scada.vi.model.impl;

import static org.eclipse.scada.vi.model.VisualInterfacePackage.CONTAINER;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.vi.model.Alignment;
import org.eclipse.scada.vi.model.Arc;
import org.eclipse.scada.vi.model.BorderChild;
import org.eclipse.scada.vi.model.BorderContainer;
import org.eclipse.scada.vi.model.Child;
import org.eclipse.scada.vi.model.Connection;
import org.eclipse.scada.vi.model.Cursor;
import org.eclipse.scada.vi.model.Dimension;
import org.eclipse.scada.vi.model.Ellipse;
import org.eclipse.scada.vi.model.Figure;
import org.eclipse.scada.vi.model.FigureContainer;
import org.eclipse.scada.vi.model.GridAlignment;
import org.eclipse.scada.vi.model.GridChild;
import org.eclipse.scada.vi.model.GridContainer;
import org.eclipse.scada.vi.model.Image;
import org.eclipse.scada.vi.model.Line;
import org.eclipse.scada.vi.model.Orientation;
import org.eclipse.scada.vi.model.Position;
import org.eclipse.scada.vi.model.Primitive;
import org.eclipse.scada.vi.model.Rectangle;
import org.eclipse.scada.vi.model.Shape;
import org.eclipse.scada.vi.model.StackContainer;
import org.eclipse.scada.vi.model.Symbol;
import org.eclipse.scada.vi.model.SymbolReference;
import org.eclipse.scada.vi.model.SystemCursor;
import org.eclipse.scada.vi.model.SystemCursorType;
import org.eclipse.scada.vi.model.Text;
import org.eclipse.scada.vi.model.VisualInterfaceFactory;
import org.eclipse.scada.vi.model.VisualInterfacePackage;
import org.eclipse.scada.vi.model.XYChild;
import org.eclipse.scada.vi.model.XYContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class VisualInterfacePackageImpl extends EPackageImpl implements VisualInterfacePackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass symbolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass primitiveEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass containerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass shapeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass rectangleEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass textEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass childEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass xyChildEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass xyContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass positionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass lineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass figureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass symbolReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass stringToStringMapEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass dimensionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass cursorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass systemCursorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass gridContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass borderContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass borderChildEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass gridChildEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass figureContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass imageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass ellipseEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass arcEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass connectionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass stackContainerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum alignmentEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum orientationEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum systemCursorTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum gridAlignmentEEnum = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package
     * package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.vi.model.VisualInterfacePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private VisualInterfacePackageImpl ()
    {
        super ( eNS_URI, VisualInterfaceFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize
     * {@link VisualInterfacePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access
     * that field to obtain the package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static VisualInterfacePackage init ()
    {
        if ( isInited )
        {
            return (VisualInterfacePackage)EPackage.Registry.INSTANCE.getEPackage ( VisualInterfacePackage.eNS_URI );
        }

        // Obtain or create and register package
        final VisualInterfacePackageImpl theVisualInterfacePackage = (VisualInterfacePackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof VisualInterfacePackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new VisualInterfacePackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theVisualInterfacePackage.createPackageContents ();

        // Initialize created meta-data
        theVisualInterfacePackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theVisualInterfacePackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( VisualInterfacePackage.eNS_URI, theVisualInterfacePackage );
        return theVisualInterfacePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSymbol ()
    {
        return this.symbolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSymbol_Root ()
    {
        return (EReference)this.symbolEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSymbol_Properties ()
    {
        return (EReference)this.symbolEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSymbol_OnInit ()
    {
        return (EAttribute)this.symbolEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSymbol_OnDispose ()
    {
        return (EAttribute)this.symbolEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSymbol_OnUpdate ()
    {
        return (EAttribute)this.symbolEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSymbol_ScriptModules ()
    {
        return (EAttribute)this.symbolEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSymbol_Cursors ()
    {
        return (EReference)this.symbolEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSymbol_BackgroundColor ()
    {
        return (EAttribute)this.symbolEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSymbol_DesignSize ()
    {
        return (EReference)this.symbolEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSymbol_Connections ()
    {
        return (EReference)this.symbolEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPrimitive ()
    {
        return this.primitiveEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPrimitive_Name ()
    {
        return (EAttribute)this.primitiveEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getContainer ()
    {
        return this.containerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getShape ()
    {
        return this.shapeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getShape_LineWidth ()
    {
        return (EAttribute)this.shapeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getShape_Antialias ()
    {
        return (EAttribute)this.shapeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getShape_Alpha ()
    {
        return (EAttribute)this.shapeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getShape_Fill ()
    {
        return (EAttribute)this.shapeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getShape_Outline ()
    {
        return (EAttribute)this.shapeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getRectangle ()
    {
        return this.rectangleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getText ()
    {
        return this.textEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getText_Text ()
    {
        return (EAttribute)this.textEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getText_LabelAlignment ()
    {
        return (EAttribute)this.textEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getText_IconAlignment ()
    {
        return (EAttribute)this.textEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getText_TextAlignment ()
    {
        return (EAttribute)this.textEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getText_TextPlacement ()
    {
        return (EAttribute)this.textEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getText_FontName ()
    {
        return (EAttribute)this.textEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getText_FontSize ()
    {
        return (EAttribute)this.textEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getText_FontBold ()
    {
        return (EAttribute)this.textEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getText_FontItalic ()
    {
        return (EAttribute)this.textEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getChild ()
    {
        return this.childEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getChild_Element ()
    {
        return (EReference)this.childEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getChild_Name ()
    {
        return (EAttribute)this.childEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getXYChild ()
    {
        return this.xyChildEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getXYChild_Position ()
    {
        return (EReference)this.xyChildEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getXYChild_Dimension ()
    {
        return (EReference)this.xyChildEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getXYContainer ()
    {
        return this.xyContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getXYContainer_Children ()
    {
        return (EReference)this.xyContainerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPosition ()
    {
        return this.positionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPosition_X ()
    {
        return (EAttribute)this.positionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getPosition_Y ()
    {
        return (EAttribute)this.positionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getLine ()
    {
        return this.lineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getLine_Points ()
    {
        return (EReference)this.lineEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFigure ()
    {
        return this.figureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_ForegroundColor ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_BackgroundColor ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFigure_Size ()
    {
        return (EReference)this.figureEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_OnClick ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_OnDoubleClick ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFigure_Cursor ()
    {
        return (EReference)this.figureEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_Visible ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_Border ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_Opaque ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_ToolTip ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 9 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_OnMouseIn ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 10 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_OnMouseOut ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 11 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_OnMouseMove ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 12 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_OnMouseHover ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 13 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getFigure_OnMouseDrag ()
    {
        return (EAttribute)this.figureEClass.getEStructuralFeatures ().get ( 14 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSymbolReference ()
    {
        return this.symbolReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSymbolReference_Uri ()
    {
        return (EAttribute)this.symbolReferenceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSymbolReference_Zoom ()
    {
        return (EAttribute)this.symbolReferenceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getSymbolReference_Properties ()
    {
        return (EReference)this.symbolReferenceEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSymbolReference_OnCreateProperties ()
    {
        return (EAttribute)this.symbolReferenceEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getStringToStringMap ()
    {
        return this.stringToStringMapEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getStringToStringMap_Key ()
    {
        return (EAttribute)this.stringToStringMapEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getStringToStringMap_Value ()
    {
        return (EAttribute)this.stringToStringMapEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDimension ()
    {
        return this.dimensionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDimension_Width ()
    {
        return (EAttribute)this.dimensionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDimension_Height ()
    {
        return (EAttribute)this.dimensionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCursor ()
    {
        return this.cursorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getSystemCursor ()
    {
        return this.systemCursorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getSystemCursor_Type ()
    {
        return (EAttribute)this.systemCursorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getGridContainer ()
    {
        return this.gridContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridContainer_Columns ()
    {
        return (EAttribute)this.gridContainerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridContainer_EqualWidth ()
    {
        return (EAttribute)this.gridContainerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getGridContainer_Children ()
    {
        return (EReference)this.gridContainerEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridContainer_HorizontalSpacing ()
    {
        return (EAttribute)this.gridContainerEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridContainer_VerticalSpacing ()
    {
        return (EAttribute)this.gridContainerEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridContainer_MarginWidth ()
    {
        return (EAttribute)this.gridContainerEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridContainer_MarginHeight ()
    {
        return (EAttribute)this.gridContainerEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBorderContainer ()
    {
        return this.borderContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getBorderContainer_Children ()
    {
        return (EReference)this.borderContainerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBorderContainer_VerticalSpacing ()
    {
        return (EAttribute)this.borderContainerEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBorderContainer_HorizontalSpacing ()
    {
        return (EAttribute)this.borderContainerEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBorderChild ()
    {
        return this.borderChildEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBorderChild_Alignment ()
    {
        return (EAttribute)this.borderChildEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getGridChild ()
    {
        return this.gridChildEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridChild_HorizontalAlignment ()
    {
        return (EAttribute)this.gridChildEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridChild_VerticalAlignment ()
    {
        return (EAttribute)this.gridChildEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridChild_GrabHorizontalSpace ()
    {
        return (EAttribute)this.gridChildEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridChild_GrabVerticalSpace ()
    {
        return (EAttribute)this.gridChildEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridChild_SpanCols ()
    {
        return (EAttribute)this.gridChildEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridChild_SpanRows ()
    {
        return (EAttribute)this.gridChildEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridChild_WidthHint ()
    {
        return (EAttribute)this.gridChildEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getGridChild_HeightHint ()
    {
        return (EAttribute)this.gridChildEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFigureContainer ()
    {
        return this.figureContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getFigureContainer_Content ()
    {
        return (EReference)this.figureContainerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getImage ()
    {
        return this.imageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getImage_Uri ()
    {
        return (EAttribute)this.imageEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getImage_ImageAlignment ()
    {
        return (EAttribute)this.imageEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEllipse ()
    {
        return this.ellipseEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getArc ()
    {
        return this.arcEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getArc_Start ()
    {
        return (EAttribute)this.arcEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getArc_Length ()
    {
        return (EAttribute)this.arcEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getConnection ()
    {
        return this.connectionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConnection_Start ()
    {
        return (EReference)this.connectionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getConnection_End ()
    {
        return (EReference)this.connectionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getStackContainer ()
    {
        return this.stackContainerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getStackContainer_Children ()
    {
        return (EReference)this.stackContainerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getAlignment ()
    {
        return this.alignmentEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getOrientation ()
    {
        return this.orientationEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getSystemCursorType ()
    {
        return this.systemCursorTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getGridAlignment ()
    {
        return this.gridAlignmentEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public VisualInterfaceFactory getVisualInterfaceFactory ()
    {
        return (VisualInterfaceFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents ()
    {
        if ( this.isCreated )
        {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.symbolEClass = createEClass ( SYMBOL );
        createEReference ( this.symbolEClass, SYMBOL__ROOT );
        createEReference ( this.symbolEClass, SYMBOL__PROPERTIES );
        createEAttribute ( this.symbolEClass, SYMBOL__ON_INIT );
        createEAttribute ( this.symbolEClass, SYMBOL__ON_DISPOSE );
        createEAttribute ( this.symbolEClass, SYMBOL__ON_UPDATE );
        createEAttribute ( this.symbolEClass, SYMBOL__SCRIPT_MODULES );
        createEReference ( this.symbolEClass, SYMBOL__CURSORS );
        createEAttribute ( this.symbolEClass, SYMBOL__BACKGROUND_COLOR );
        createEReference ( this.symbolEClass, SYMBOL__DESIGN_SIZE );
        createEReference ( this.symbolEClass, SYMBOL__CONNECTIONS );

        this.primitiveEClass = createEClass ( PRIMITIVE );
        createEAttribute ( this.primitiveEClass, PRIMITIVE__NAME );

        this.containerEClass = createEClass ( CONTAINER );

        this.shapeEClass = createEClass ( SHAPE );
        createEAttribute ( this.shapeEClass, SHAPE__LINE_WIDTH );
        createEAttribute ( this.shapeEClass, SHAPE__ANTIALIAS );
        createEAttribute ( this.shapeEClass, SHAPE__ALPHA );
        createEAttribute ( this.shapeEClass, SHAPE__FILL );
        createEAttribute ( this.shapeEClass, SHAPE__OUTLINE );

        this.rectangleEClass = createEClass ( RECTANGLE );

        this.textEClass = createEClass ( TEXT );
        createEAttribute ( this.textEClass, TEXT__TEXT );
        createEAttribute ( this.textEClass, TEXT__LABEL_ALIGNMENT );
        createEAttribute ( this.textEClass, TEXT__ICON_ALIGNMENT );
        createEAttribute ( this.textEClass, TEXT__TEXT_ALIGNMENT );
        createEAttribute ( this.textEClass, TEXT__TEXT_PLACEMENT );
        createEAttribute ( this.textEClass, TEXT__FONT_NAME );
        createEAttribute ( this.textEClass, TEXT__FONT_SIZE );
        createEAttribute ( this.textEClass, TEXT__FONT_BOLD );
        createEAttribute ( this.textEClass, TEXT__FONT_ITALIC );

        this.childEClass = createEClass ( CHILD );
        createEReference ( this.childEClass, CHILD__ELEMENT );
        createEAttribute ( this.childEClass, CHILD__NAME );

        this.xyChildEClass = createEClass ( XY_CHILD );
        createEReference ( this.xyChildEClass, XY_CHILD__POSITION );
        createEReference ( this.xyChildEClass, XY_CHILD__DIMENSION );

        this.xyContainerEClass = createEClass ( XY_CONTAINER );
        createEReference ( this.xyContainerEClass, XY_CONTAINER__CHILDREN );

        this.positionEClass = createEClass ( POSITION );
        createEAttribute ( this.positionEClass, POSITION__X );
        createEAttribute ( this.positionEClass, POSITION__Y );

        this.lineEClass = createEClass ( LINE );
        createEReference ( this.lineEClass, LINE__POINTS );

        this.figureEClass = createEClass ( FIGURE );
        createEAttribute ( this.figureEClass, FIGURE__FOREGROUND_COLOR );
        createEAttribute ( this.figureEClass, FIGURE__BACKGROUND_COLOR );
        createEReference ( this.figureEClass, FIGURE__SIZE );
        createEAttribute ( this.figureEClass, FIGURE__ON_CLICK );
        createEAttribute ( this.figureEClass, FIGURE__ON_DOUBLE_CLICK );
        createEReference ( this.figureEClass, FIGURE__CURSOR );
        createEAttribute ( this.figureEClass, FIGURE__VISIBLE );
        createEAttribute ( this.figureEClass, FIGURE__BORDER );
        createEAttribute ( this.figureEClass, FIGURE__OPAQUE );
        createEAttribute ( this.figureEClass, FIGURE__TOOL_TIP );
        createEAttribute ( this.figureEClass, FIGURE__ON_MOUSE_IN );
        createEAttribute ( this.figureEClass, FIGURE__ON_MOUSE_OUT );
        createEAttribute ( this.figureEClass, FIGURE__ON_MOUSE_MOVE );
        createEAttribute ( this.figureEClass, FIGURE__ON_MOUSE_HOVER );
        createEAttribute ( this.figureEClass, FIGURE__ON_MOUSE_DRAG );

        this.symbolReferenceEClass = createEClass ( SYMBOL_REFERENCE );
        createEAttribute ( this.symbolReferenceEClass, SYMBOL_REFERENCE__URI );
        createEAttribute ( this.symbolReferenceEClass, SYMBOL_REFERENCE__ZOOM );
        createEReference ( this.symbolReferenceEClass, SYMBOL_REFERENCE__PROPERTIES );
        createEAttribute ( this.symbolReferenceEClass, SYMBOL_REFERENCE__ON_CREATE_PROPERTIES );

        this.stringToStringMapEClass = createEClass ( STRING_TO_STRING_MAP );
        createEAttribute ( this.stringToStringMapEClass, STRING_TO_STRING_MAP__KEY );
        createEAttribute ( this.stringToStringMapEClass, STRING_TO_STRING_MAP__VALUE );

        this.dimensionEClass = createEClass ( DIMENSION );
        createEAttribute ( this.dimensionEClass, DIMENSION__WIDTH );
        createEAttribute ( this.dimensionEClass, DIMENSION__HEIGHT );

        this.cursorEClass = createEClass ( CURSOR );

        this.systemCursorEClass = createEClass ( SYSTEM_CURSOR );
        createEAttribute ( this.systemCursorEClass, SYSTEM_CURSOR__TYPE );

        this.gridContainerEClass = createEClass ( GRID_CONTAINER );
        createEAttribute ( this.gridContainerEClass, GRID_CONTAINER__COLUMNS );
        createEAttribute ( this.gridContainerEClass, GRID_CONTAINER__EQUAL_WIDTH );
        createEReference ( this.gridContainerEClass, GRID_CONTAINER__CHILDREN );
        createEAttribute ( this.gridContainerEClass, GRID_CONTAINER__HORIZONTAL_SPACING );
        createEAttribute ( this.gridContainerEClass, GRID_CONTAINER__VERTICAL_SPACING );
        createEAttribute ( this.gridContainerEClass, GRID_CONTAINER__MARGIN_WIDTH );
        createEAttribute ( this.gridContainerEClass, GRID_CONTAINER__MARGIN_HEIGHT );

        this.borderContainerEClass = createEClass ( BORDER_CONTAINER );
        createEReference ( this.borderContainerEClass, BORDER_CONTAINER__CHILDREN );
        createEAttribute ( this.borderContainerEClass, BORDER_CONTAINER__VERTICAL_SPACING );
        createEAttribute ( this.borderContainerEClass, BORDER_CONTAINER__HORIZONTAL_SPACING );

        this.borderChildEClass = createEClass ( BORDER_CHILD );
        createEAttribute ( this.borderChildEClass, BORDER_CHILD__ALIGNMENT );

        this.gridChildEClass = createEClass ( GRID_CHILD );
        createEAttribute ( this.gridChildEClass, GRID_CHILD__HORIZONTAL_ALIGNMENT );
        createEAttribute ( this.gridChildEClass, GRID_CHILD__VERTICAL_ALIGNMENT );
        createEAttribute ( this.gridChildEClass, GRID_CHILD__GRAB_HORIZONTAL_SPACE );
        createEAttribute ( this.gridChildEClass, GRID_CHILD__GRAB_VERTICAL_SPACE );
        createEAttribute ( this.gridChildEClass, GRID_CHILD__SPAN_COLS );
        createEAttribute ( this.gridChildEClass, GRID_CHILD__SPAN_ROWS );
        createEAttribute ( this.gridChildEClass, GRID_CHILD__WIDTH_HINT );
        createEAttribute ( this.gridChildEClass, GRID_CHILD__HEIGHT_HINT );

        this.figureContainerEClass = createEClass ( FIGURE_CONTAINER );
        createEReference ( this.figureContainerEClass, FIGURE_CONTAINER__CONTENT );

        this.imageEClass = createEClass ( IMAGE );
        createEAttribute ( this.imageEClass, IMAGE__URI );
        createEAttribute ( this.imageEClass, IMAGE__IMAGE_ALIGNMENT );

        this.ellipseEClass = createEClass ( ELLIPSE );

        this.arcEClass = createEClass ( ARC );
        createEAttribute ( this.arcEClass, ARC__START );
        createEAttribute ( this.arcEClass, ARC__LENGTH );

        this.connectionEClass = createEClass ( CONNECTION );
        createEReference ( this.connectionEClass, CONNECTION__START );
        createEReference ( this.connectionEClass, CONNECTION__END );

        this.stackContainerEClass = createEClass ( STACK_CONTAINER );
        createEReference ( this.stackContainerEClass, STACK_CONTAINER__CHILDREN );

        // Create enums
        this.alignmentEEnum = createEEnum ( ALIGNMENT );
        this.orientationEEnum = createEEnum ( ORIENTATION );
        this.systemCursorTypeEEnum = createEEnum ( SYSTEM_CURSOR_TYPE );
        this.gridAlignmentEEnum = createEEnum ( GRID_ALIGNMENT );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( this.isInitialized )
        {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.containerEClass.getESuperTypes ().add ( getPrimitive () );
        this.shapeEClass.getESuperTypes ().add ( getFigure () );
        this.rectangleEClass.getESuperTypes ().add ( getShape () );
        this.textEClass.getESuperTypes ().add ( getFigure () );
        this.xyChildEClass.getESuperTypes ().add ( getChild () );
        this.xyContainerEClass.getESuperTypes ().add ( getContainer () );
        this.lineEClass.getESuperTypes ().add ( getShape () );
        this.figureEClass.getESuperTypes ().add ( getPrimitive () );
        this.symbolReferenceEClass.getESuperTypes ().add ( getPrimitive () );
        this.systemCursorEClass.getESuperTypes ().add ( getCursor () );
        this.gridContainerEClass.getESuperTypes ().add ( getContainer () );
        this.borderContainerEClass.getESuperTypes ().add ( getContainer () );
        this.borderChildEClass.getESuperTypes ().add ( getChild () );
        this.gridChildEClass.getESuperTypes ().add ( getChild () );
        this.figureContainerEClass.getESuperTypes ().add ( getFigure () );
        this.imageEClass.getESuperTypes ().add ( getFigure () );
        this.ellipseEClass.getESuperTypes ().add ( getShape () );
        this.arcEClass.getESuperTypes ().add ( getShape () );
        this.stackContainerEClass.getESuperTypes ().add ( getContainer () );

        // Initialize classes and features; add operations and parameters
        initEClass ( this.symbolEClass, Symbol.class, "Symbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getSymbol_Root (), getPrimitive (), null, "root", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSymbol_Properties (), getStringToStringMap (), null, "properties", null, 0, -1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSymbol_OnInit (), this.ecorePackage.getEString (), "onInit", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSymbol_OnDispose (), this.ecorePackage.getEString (), "onDispose", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSymbol_OnUpdate (), this.ecorePackage.getEString (), "onUpdate", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSymbol_ScriptModules (), this.ecorePackage.getEString (), "scriptModules", null, 0, -1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSymbol_Cursors (), getCursor (), null, "cursors", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSymbol_BackgroundColor (), this.ecorePackage.getEString (), "backgroundColor", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSymbol_DesignSize (), getDimension (), null, "designSize", null, 0, 1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSymbol_Connections (), getConnection (), null, "connections", null, 0, -1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.primitiveEClass, Primitive.class, "Primitive", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPrimitive_Name (), this.ecorePackage.getEString (), "name", null, 0, 1, Primitive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.containerEClass, org.eclipse.scada.vi.model.Container.class, "Container", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.shapeEClass, Shape.class, "Shape", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getShape_LineWidth (), this.ecorePackage.getEFloat (), "lineWidth", "1", 1, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getShape_Antialias (), this.ecorePackage.getEBooleanObject (), "antialias", null, 0, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getShape_Alpha (), this.ecorePackage.getEDoubleObject (), "alpha", null, 0, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getShape_Fill (), this.ecorePackage.getEBoolean (), "fill", "true", 1, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getShape_Outline (), this.ecorePackage.getEBoolean (), "outline", "true", 1, 1, Shape.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.rectangleEClass, Rectangle.class, "Rectangle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getText_Text (), this.ecorePackage.getEString (), "text", null, 1, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getText_LabelAlignment (), getAlignment (), "labelAlignment", "CENTER", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getText_IconAlignment (), getAlignment (), "iconAlignment", "CENTER", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getText_TextAlignment (), getAlignment (), "textAlignment", "CENTER", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getText_TextPlacement (), getOrientation (), "textPlacement", "EAST", 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getText_FontName (), this.ecorePackage.getEString (), "fontName", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getText_FontSize (), this.ecorePackage.getEInt (), "fontSize", null, 0, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getText_FontBold (), this.ecorePackage.getEBoolean (), "fontBold", "false", 1, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getText_FontItalic (), this.ecorePackage.getEBoolean (), "fontItalic", "false", 1, 1, Text.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.childEClass, Child.class, "Child", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getChild_Element (), getPrimitive (), null, "element", null, 0, 1, Child.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getChild_Name (), this.ecorePackage.getEString (), "name", null, 0, 1, Child.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.xyChildEClass, XYChild.class, "XYChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getXYChild_Position (), getPosition (), null, "position", null, 1, 1, XYChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getXYChild_Dimension (), getDimension (), null, "dimension", null, 0, 1, XYChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.xyContainerEClass, XYContainer.class, "XYContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getXYContainer_Children (), getXYChild (), null, "children", null, 0, -1, XYContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.positionEClass, Position.class, "Position", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPosition_X (), this.ecorePackage.getEDouble (), "x", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPosition_Y (), this.ecorePackage.getEDouble (), "y", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.lineEClass, Line.class, "Line", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getLine_Points (), getPosition (), null, "points", null, 0, -1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.figureEClass, Figure.class, "Figure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getFigure_ForegroundColor (), this.ecorePackage.getEString (), "foregroundColor", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_BackgroundColor (), this.ecorePackage.getEString (), "backgroundColor", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFigure_Size (), getDimension (), null, "size", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_OnClick (), this.ecorePackage.getEString (), "onClick", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_OnDoubleClick (), this.ecorePackage.getEString (), "onDoubleClick", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getFigure_Cursor (), getCursor (), null, "cursor", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_Visible (), this.ecorePackage.getEBoolean (), "visible", "true", 1, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getFigure_Border (), this.ecorePackage.getEString (), "border", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_Opaque (), this.ecorePackage.getEBooleanObject (), "opaque", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_ToolTip (), this.ecorePackage.getEString (), "toolTip", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_OnMouseIn (), this.ecorePackage.getEString (), "onMouseIn", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_OnMouseOut (), this.ecorePackage.getEString (), "onMouseOut", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_OnMouseMove (), this.ecorePackage.getEString (), "onMouseMove", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_OnMouseHover (), this.ecorePackage.getEString (), "onMouseHover", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFigure_OnMouseDrag (), this.ecorePackage.getEString (), "onMouseDrag", null, 0, 1, Figure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.symbolReferenceEClass, SymbolReference.class, "SymbolReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSymbolReference_Uri (), this.ecorePackage.getEString (), "uri", null, 1, 1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSymbolReference_Zoom (), this.ecorePackage.getEDoubleObject (), "zoom", null, 0, 1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSymbolReference_Properties (), getStringToStringMap (), null, "properties", null, 0, -1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSymbolReference_OnCreateProperties (), this.ecorePackage.getEString (), "onCreateProperties", null, 0, 1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.stringToStringMapEClass, Map.Entry.class, "StringToStringMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getStringToStringMap_Key (), this.ecorePackage.getEString (), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getStringToStringMap_Value (), this.ecorePackage.getEString (), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.dimensionEClass, Dimension.class, "Dimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDimension_Width (), this.ecorePackage.getEDouble (), "width", "0", 1, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getDimension_Height (), this.ecorePackage.getEDouble (), "height", "0", 1, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.cursorEClass, Cursor.class, "Cursor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.systemCursorEClass, SystemCursor.class, "SystemCursor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSystemCursor_Type (), getSystemCursorType (), "type", null, 1, 1, SystemCursor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.gridContainerEClass, GridContainer.class, "GridContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getGridContainer_Columns (), this.ecorePackage.getEInt (), "columns", "1", 0, 1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridContainer_EqualWidth (), this.ecorePackage.getEBoolean (), "equalWidth", "false", 0, 1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getGridContainer_Children (), getGridChild (), null, "children", null, 0, -1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getGridContainer_HorizontalSpacing (), this.ecorePackage.getEInt (), "horizontalSpacing", "5", 1, 1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridContainer_VerticalSpacing (), this.ecorePackage.getEInt (), "verticalSpacing", "5", 1, 1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridContainer_MarginWidth (), this.ecorePackage.getEInt (), "marginWidth", "5", 1, 1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridContainer_MarginHeight (), this.ecorePackage.getEInt (), "marginHeight", "5", 1, 1, GridContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.borderContainerEClass, BorderContainer.class, "BorderContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getBorderContainer_Children (), getBorderChild (), null, "children", null, 0, -1, BorderContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBorderContainer_VerticalSpacing (), this.ecorePackage.getEInt (), "verticalSpacing", "0", 1, 1, BorderContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getBorderContainer_HorizontalSpacing (), this.ecorePackage.getEInt (), "horizontalSpacing", "0", 1, 1, BorderContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.borderChildEClass, BorderChild.class, "BorderChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getBorderChild_Alignment (), getAlignment (), "alignment", "CENTER", 1, 1, BorderChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.gridChildEClass, GridChild.class, "GridChild", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getGridChild_HorizontalAlignment (), getGridAlignment (), "horizontalAlignment", "BEGINNING", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridChild_VerticalAlignment (), getGridAlignment (), "verticalAlignment", "BEGINNING", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridChild_GrabHorizontalSpace (), this.ecorePackage.getEBoolean (), "grabHorizontalSpace", "false", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridChild_GrabVerticalSpace (), this.ecorePackage.getEBoolean (), "grabVerticalSpace", "false", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridChild_SpanCols (), this.ecorePackage.getEInt (), "spanCols", "0", 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridChild_SpanRows (), this.ecorePackage.getEIntegerObject (), "spanRows", "0", 0, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getGridChild_WidthHint (), this.ecorePackage.getEIntegerObject (), "widthHint", null, 0, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getGridChild_HeightHint (), this.ecorePackage.getEIntegerObject (), "heightHint", null, 1, 1, GridChild.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.figureContainerEClass, FigureContainer.class, "FigureContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getFigureContainer_Content (), getPrimitive (), null, "content", null, 0, 1, FigureContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.imageEClass, Image.class, "Image", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getImage_Uri (), this.ecorePackage.getEString (), "uri", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getImage_ImageAlignment (), getAlignment (), "imageAlignment", "CENTER", 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( this.ellipseEClass, Ellipse.class, "Ellipse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.arcEClass, Arc.class, "Arc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getArc_Start (), this.ecorePackage.getEInt (), "start", null, 1, 1, Arc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getArc_Length (), this.ecorePackage.getEInt (), "length", null, 1, 1, Arc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getConnection_Start (), getPrimitive (), null, "start", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getConnection_End (), getPrimitive (), null, "end", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getConnection_End ().getEKeys ().add ( getPrimitive_Name () );

        initEClass ( this.stackContainerEClass, StackContainer.class, "StackContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getStackContainer_Children (), getPrimitive (), null, "children", null, 0, -1, StackContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( this.alignmentEEnum, Alignment.class, "Alignment" ); //$NON-NLS-1$
        addEEnumLiteral ( this.alignmentEEnum, Alignment.LEFT );
        addEEnumLiteral ( this.alignmentEEnum, Alignment.CENTER );
        addEEnumLiteral ( this.alignmentEEnum, Alignment.RIGHT );
        addEEnumLiteral ( this.alignmentEEnum, Alignment.TOP );
        addEEnumLiteral ( this.alignmentEEnum, Alignment.BOTTOM );

        initEEnum ( this.orientationEEnum, Orientation.class, "Orientation" ); //$NON-NLS-1$
        addEEnumLiteral ( this.orientationEEnum, Orientation.NORTH );
        addEEnumLiteral ( this.orientationEEnum, Orientation.SOUTH );
        addEEnumLiteral ( this.orientationEEnum, Orientation.EAST );
        addEEnumLiteral ( this.orientationEEnum, Orientation.WEST );

        initEEnum ( this.systemCursorTypeEEnum, SystemCursorType.class, "SystemCursorType" ); //$NON-NLS-1$
        addEEnumLiteral ( this.systemCursorTypeEEnum, SystemCursorType.ARROW );
        addEEnumLiteral ( this.systemCursorTypeEEnum, SystemCursorType.HAND );

        initEEnum ( this.gridAlignmentEEnum, GridAlignment.class, "GridAlignment" ); //$NON-NLS-1$
        addEEnumLiteral ( this.gridAlignmentEEnum, GridAlignment.CENTER );
        addEEnumLiteral ( this.gridAlignmentEEnum, GridAlignment.FILL );
        addEEnumLiteral ( this.gridAlignmentEEnum, GridAlignment.BEGINNING );
        addEEnumLiteral ( this.gridAlignmentEEnum, GridAlignment.END );

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
    }

    /**
     * Initializes the annotations for
     * <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        final String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$			
        addAnnotation ( getChild_Element (),
                source,
                new String[]
                { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
                "name", "element" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getXYChild_Position (),
                source,
                new String[]
                { "kind", "element" //$NON-NLS-1$ //$NON-NLS-2$
                } );
    }

} //VisualInterfacePackageImpl
