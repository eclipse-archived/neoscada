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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.scada.vi.model.Cursor;
import org.eclipse.scada.vi.model.Dimension;
import org.eclipse.scada.vi.model.Figure;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Figure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getForegroundColor <em>
 * Foreground Color</em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getBackgroundColor <em>
 * Background Color</em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getSize <em>Size</em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOnClick <em>On Click
 * </em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOnDoubleClick <em>On
 * Double Click</em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getCursor <em>Cursor
 * </em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#isVisible <em>Visible
 * </em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getBorder <em>Border
 * </em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOpaque <em>Opaque
 * </em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getToolTip <em>Tool Tip
 * </em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOnMouseIn <em>On
 * Mouse In</em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOnMouseOut <em>On
 * Mouse Out</em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOnMouseMove <em>On
 * Mouse Move</em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOnMouseHover <em>On
 * Mouse Hover</em>}</li>
 * <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOnMouseDrag <em>On
 * Mouse Drag</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class FigureImpl extends EObjectImpl implements Figure
{
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getForegroundColor()
     * <em>Foreground Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getForegroundColor()
     * @generated
     * @ordered
     */
    protected static final String FOREGROUND_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getForegroundColor()
     * <em>Foreground Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getForegroundColor()
     * @generated
     * @ordered
     */
    protected String foregroundColor = FOREGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getBackgroundColor()
     * <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final String BACKGROUND_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBackgroundColor()
     * <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected String backgroundColor = BACKGROUND_COLOR_EDEFAULT;

    /**
     * The cached value of the '{@link #getSize() <em>Size</em>}' containment
     * reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getSize()
     * @generated
     * @ordered
     */
    protected Dimension size;

    /**
     * The default value of the '{@link #getOnClick() <em>On Click</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnClick()
     * @generated
     * @ordered
     */
    protected static final String ON_CLICK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnClick() <em>On Click</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnClick()
     * @generated
     * @ordered
     */
    protected String onClick = ON_CLICK_EDEFAULT;

    /**
     * The default value of the '{@link #getOnDoubleClick()
     * <em>On Double Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnDoubleClick()
     * @generated
     * @ordered
     */
    protected static final String ON_DOUBLE_CLICK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnDoubleClick()
     * <em>On Double Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnDoubleClick()
     * @generated
     * @ordered
     */
    protected String onDoubleClick = ON_DOUBLE_CLICK_EDEFAULT;

    /**
     * The cached value of the '{@link #getCursor() <em>Cursor</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCursor()
     * @generated
     * @ordered
     */
    protected Cursor cursor;

    /**
     * The default value of the '{@link #isVisible() <em>Visible</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected static final boolean VISIBLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isVisible() <em>Visible</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected boolean visible = VISIBLE_EDEFAULT;

    /**
     * The default value of the '{@link #getBorder() <em>Border</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBorder()
     * @generated
     * @ordered
     */
    protected static final String BORDER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBorder() <em>Border</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getBorder()
     * @generated
     * @ordered
     */
    protected String border = BORDER_EDEFAULT;

    /**
     * The default value of the '{@link #getOpaque() <em>Opaque</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOpaque()
     * @generated
     * @ordered
     */
    protected static final Boolean OPAQUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOpaque() <em>Opaque</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOpaque()
     * @generated
     * @ordered
     */
    protected Boolean opaque = OPAQUE_EDEFAULT;

    /**
     * The default value of the '{@link #getToolTip() <em>Tool Tip</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getToolTip()
     * @generated
     * @ordered
     */
    protected static final String TOOL_TIP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getToolTip() <em>Tool Tip</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getToolTip()
     * @generated
     * @ordered
     */
    protected String toolTip = TOOL_TIP_EDEFAULT;

    /**
     * The default value of the '{@link #getOnMouseIn() <em>On Mouse In</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseIn()
     * @generated
     * @ordered
     */
    protected static final String ON_MOUSE_IN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnMouseIn() <em>On Mouse In</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseIn()
     * @generated
     * @ordered
     */
    protected String onMouseIn = ON_MOUSE_IN_EDEFAULT;

    /**
     * The default value of the '{@link #getOnMouseOut() <em>On Mouse Out</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseOut()
     * @generated
     * @ordered
     */
    protected static final String ON_MOUSE_OUT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnMouseOut() <em>On Mouse Out</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseOut()
     * @generated
     * @ordered
     */
    protected String onMouseOut = ON_MOUSE_OUT_EDEFAULT;

    /**
     * The default value of the '{@link #getOnMouseMove()
     * <em>On Mouse Move</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseMove()
     * @generated
     * @ordered
     */
    protected static final String ON_MOUSE_MOVE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnMouseMove() <em>On Mouse Move</em>}
     * ' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseMove()
     * @generated
     * @ordered
     */
    protected String onMouseMove = ON_MOUSE_MOVE_EDEFAULT;

    /**
     * The default value of the '{@link #getOnMouseHover()
     * <em>On Mouse Hover</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseHover()
     * @generated
     * @ordered
     */
    protected static final String ON_MOUSE_HOVER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnMouseHover()
     * <em>On Mouse Hover</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseHover()
     * @generated
     * @ordered
     */
    protected String onMouseHover = ON_MOUSE_HOVER_EDEFAULT;

    /**
     * The default value of the '{@link #getOnMouseDrag()
     * <em>On Mouse Drag</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseDrag()
     * @generated
     * @ordered
     */
    protected static final String ON_MOUSE_DRAG_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnMouseDrag() <em>On Mouse Drag</em>}
     * ' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getOnMouseDrag()
     * @generated
     * @ordered
     */
    protected String onMouseDrag = ON_MOUSE_DRAG_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected FigureImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return VisualInterfacePackage.Literals.FIGURE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName ()
    {
        return this.name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setName ( final String newName )
    {
        final String oldName = this.name;
        this.name = newName;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__NAME, oldName, this.name ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getForegroundColor ()
    {
        return this.foregroundColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setForegroundColor ( final String newForegroundColor )
    {
        final String oldForegroundColor = this.foregroundColor;
        this.foregroundColor = newForegroundColor;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__FOREGROUND_COLOR, oldForegroundColor, this.foregroundColor ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getBackgroundColor ()
    {
        return this.backgroundColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBackgroundColor ( final String newBackgroundColor )
    {
        final String oldBackgroundColor = this.backgroundColor;
        this.backgroundColor = newBackgroundColor;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__BACKGROUND_COLOR, oldBackgroundColor, this.backgroundColor ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Dimension getSize ()
    {
        return this.size;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSize ( final Dimension newSize, NotificationChain msgs )
    {
        final Dimension oldSize = this.size;
        this.size = newSize;
        if ( eNotificationRequired () )
        {
            final ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__SIZE, oldSize, newSize );
            if ( msgs == null )
            {
                msgs = notification;
            }
            else
            {
                msgs.add ( notification );
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSize ( final Dimension newSize )
    {
        if ( newSize != this.size )
        {
            NotificationChain msgs = null;
            if ( this.size != null )
            {
                msgs = ( (InternalEObject)this.size ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.FIGURE__SIZE, null, msgs );
            }
            if ( newSize != null )
            {
                msgs = ( (InternalEObject)newSize ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.FIGURE__SIZE, null, msgs );
            }
            msgs = basicSetSize ( newSize, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__SIZE, newSize, newSize ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getOnClick ()
    {
        return this.onClick;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOnClick ( final String newOnClick )
    {
        final String oldOnClick = this.onClick;
        this.onClick = newOnClick;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__ON_CLICK, oldOnClick, this.onClick ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getOnDoubleClick ()
    {
        return this.onDoubleClick;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOnDoubleClick ( final String newOnDoubleClick )
    {
        final String oldOnDoubleClick = this.onDoubleClick;
        this.onDoubleClick = newOnDoubleClick;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__ON_DOUBLE_CLICK, oldOnDoubleClick, this.onDoubleClick ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Cursor getCursor ()
    {
        if ( this.cursor != null && this.cursor.eIsProxy () )
        {
            final InternalEObject oldCursor = (InternalEObject)this.cursor;
            this.cursor = (Cursor)eResolveProxy ( oldCursor );
            if ( this.cursor != oldCursor )
            {
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, VisualInterfacePackage.FIGURE__CURSOR, oldCursor, this.cursor ) );
                }
            }
        }
        return this.cursor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Cursor basicGetCursor ()
    {
        return this.cursor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCursor ( final Cursor newCursor )
    {
        final Cursor oldCursor = this.cursor;
        this.cursor = newCursor;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__CURSOR, oldCursor, this.cursor ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isVisible ()
    {
        return this.visible;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setVisible ( final boolean newVisible )
    {
        final boolean oldVisible = this.visible;
        this.visible = newVisible;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__VISIBLE, oldVisible, this.visible ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getBorder ()
    {
        return this.border;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBorder ( final String newBorder )
    {
        final String oldBorder = this.border;
        this.border = newBorder;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__BORDER, oldBorder, this.border ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Boolean getOpaque ()
    {
        return this.opaque;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOpaque ( final Boolean newOpaque )
    {
        final Boolean oldOpaque = this.opaque;
        this.opaque = newOpaque;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__OPAQUE, oldOpaque, this.opaque ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getToolTip ()
    {
        return this.toolTip;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setToolTip ( final String newToolTip )
    {
        final String oldToolTip = this.toolTip;
        this.toolTip = newToolTip;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__TOOL_TIP, oldToolTip, this.toolTip ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getOnMouseIn ()
    {
        return this.onMouseIn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOnMouseIn ( final String newOnMouseIn )
    {
        final String oldOnMouseIn = this.onMouseIn;
        this.onMouseIn = newOnMouseIn;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__ON_MOUSE_IN, oldOnMouseIn, this.onMouseIn ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getOnMouseOut ()
    {
        return this.onMouseOut;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOnMouseOut ( final String newOnMouseOut )
    {
        final String oldOnMouseOut = this.onMouseOut;
        this.onMouseOut = newOnMouseOut;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__ON_MOUSE_OUT, oldOnMouseOut, this.onMouseOut ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getOnMouseMove ()
    {
        return this.onMouseMove;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOnMouseMove ( final String newOnMouseMove )
    {
        final String oldOnMouseMove = this.onMouseMove;
        this.onMouseMove = newOnMouseMove;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__ON_MOUSE_MOVE, oldOnMouseMove, this.onMouseMove ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getOnMouseHover ()
    {
        return this.onMouseHover;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOnMouseHover ( final String newOnMouseHover )
    {
        final String oldOnMouseHover = this.onMouseHover;
        this.onMouseHover = newOnMouseHover;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__ON_MOUSE_HOVER, oldOnMouseHover, this.onMouseHover ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getOnMouseDrag ()
    {
        return this.onMouseDrag;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setOnMouseDrag ( final String newOnMouseDrag )
    {
        final String oldOnMouseDrag = this.onMouseDrag;
        this.onMouseDrag = newOnMouseDrag;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__ON_MOUSE_DRAG, oldOnMouseDrag, this.onMouseDrag ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( final InternalEObject otherEnd, final int featureID, final NotificationChain msgs )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.FIGURE__SIZE:
                return basicSetSize ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.FIGURE__NAME:
                return getName ();
            case VisualInterfacePackage.FIGURE__FOREGROUND_COLOR:
                return getForegroundColor ();
            case VisualInterfacePackage.FIGURE__BACKGROUND_COLOR:
                return getBackgroundColor ();
            case VisualInterfacePackage.FIGURE__SIZE:
                return getSize ();
            case VisualInterfacePackage.FIGURE__ON_CLICK:
                return getOnClick ();
            case VisualInterfacePackage.FIGURE__ON_DOUBLE_CLICK:
                return getOnDoubleClick ();
            case VisualInterfacePackage.FIGURE__CURSOR:
                if ( resolve )
                {
                    return getCursor ();
                }
                return basicGetCursor ();
            case VisualInterfacePackage.FIGURE__VISIBLE:
                return isVisible ();
            case VisualInterfacePackage.FIGURE__BORDER:
                return getBorder ();
            case VisualInterfacePackage.FIGURE__OPAQUE:
                return getOpaque ();
            case VisualInterfacePackage.FIGURE__TOOL_TIP:
                return getToolTip ();
            case VisualInterfacePackage.FIGURE__ON_MOUSE_IN:
                return getOnMouseIn ();
            case VisualInterfacePackage.FIGURE__ON_MOUSE_OUT:
                return getOnMouseOut ();
            case VisualInterfacePackage.FIGURE__ON_MOUSE_MOVE:
                return getOnMouseMove ();
            case VisualInterfacePackage.FIGURE__ON_MOUSE_HOVER:
                return getOnMouseHover ();
            case VisualInterfacePackage.FIGURE__ON_MOUSE_DRAG:
                return getOnMouseDrag ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet ( final int featureID, final Object newValue )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.FIGURE__NAME:
                setName ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__FOREGROUND_COLOR:
                setForegroundColor ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__BACKGROUND_COLOR:
                setBackgroundColor ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__SIZE:
                setSize ( (Dimension)newValue );
                return;
            case VisualInterfacePackage.FIGURE__ON_CLICK:
                setOnClick ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__ON_DOUBLE_CLICK:
                setOnDoubleClick ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__CURSOR:
                setCursor ( (Cursor)newValue );
                return;
            case VisualInterfacePackage.FIGURE__VISIBLE:
                setVisible ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.FIGURE__BORDER:
                setBorder ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__OPAQUE:
                setOpaque ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.FIGURE__TOOL_TIP:
                setToolTip ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_IN:
                setOnMouseIn ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_OUT:
                setOnMouseOut ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_MOVE:
                setOnMouseMove ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_HOVER:
                setOnMouseHover ( (String)newValue );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_DRAG:
                setOnMouseDrag ( (String)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.FIGURE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__FOREGROUND_COLOR:
                setForegroundColor ( FOREGROUND_COLOR_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__BACKGROUND_COLOR:
                setBackgroundColor ( BACKGROUND_COLOR_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__SIZE:
                setSize ( (Dimension)null );
                return;
            case VisualInterfacePackage.FIGURE__ON_CLICK:
                setOnClick ( ON_CLICK_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__ON_DOUBLE_CLICK:
                setOnDoubleClick ( ON_DOUBLE_CLICK_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__CURSOR:
                setCursor ( (Cursor)null );
                return;
            case VisualInterfacePackage.FIGURE__VISIBLE:
                setVisible ( VISIBLE_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__BORDER:
                setBorder ( BORDER_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__OPAQUE:
                setOpaque ( OPAQUE_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__TOOL_TIP:
                setToolTip ( TOOL_TIP_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_IN:
                setOnMouseIn ( ON_MOUSE_IN_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_OUT:
                setOnMouseOut ( ON_MOUSE_OUT_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_MOVE:
                setOnMouseMove ( ON_MOUSE_MOVE_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_HOVER:
                setOnMouseHover ( ON_MOUSE_HOVER_EDEFAULT );
                return;
            case VisualInterfacePackage.FIGURE__ON_MOUSE_DRAG:
                setOnMouseDrag ( ON_MOUSE_DRAG_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.FIGURE__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals ( this.name );
            case VisualInterfacePackage.FIGURE__FOREGROUND_COLOR:
                return FOREGROUND_COLOR_EDEFAULT == null ? this.foregroundColor != null : !FOREGROUND_COLOR_EDEFAULT.equals ( this.foregroundColor );
            case VisualInterfacePackage.FIGURE__BACKGROUND_COLOR:
                return BACKGROUND_COLOR_EDEFAULT == null ? this.backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT.equals ( this.backgroundColor );
            case VisualInterfacePackage.FIGURE__SIZE:
                return this.size != null;
            case VisualInterfacePackage.FIGURE__ON_CLICK:
                return ON_CLICK_EDEFAULT == null ? this.onClick != null : !ON_CLICK_EDEFAULT.equals ( this.onClick );
            case VisualInterfacePackage.FIGURE__ON_DOUBLE_CLICK:
                return ON_DOUBLE_CLICK_EDEFAULT == null ? this.onDoubleClick != null : !ON_DOUBLE_CLICK_EDEFAULT.equals ( this.onDoubleClick );
            case VisualInterfacePackage.FIGURE__CURSOR:
                return this.cursor != null;
            case VisualInterfacePackage.FIGURE__VISIBLE:
                return this.visible != VISIBLE_EDEFAULT;
            case VisualInterfacePackage.FIGURE__BORDER:
                return BORDER_EDEFAULT == null ? this.border != null : !BORDER_EDEFAULT.equals ( this.border );
            case VisualInterfacePackage.FIGURE__OPAQUE:
                return OPAQUE_EDEFAULT == null ? this.opaque != null : !OPAQUE_EDEFAULT.equals ( this.opaque );
            case VisualInterfacePackage.FIGURE__TOOL_TIP:
                return TOOL_TIP_EDEFAULT == null ? this.toolTip != null : !TOOL_TIP_EDEFAULT.equals ( this.toolTip );
            case VisualInterfacePackage.FIGURE__ON_MOUSE_IN:
                return ON_MOUSE_IN_EDEFAULT == null ? this.onMouseIn != null : !ON_MOUSE_IN_EDEFAULT.equals ( this.onMouseIn );
            case VisualInterfacePackage.FIGURE__ON_MOUSE_OUT:
                return ON_MOUSE_OUT_EDEFAULT == null ? this.onMouseOut != null : !ON_MOUSE_OUT_EDEFAULT.equals ( this.onMouseOut );
            case VisualInterfacePackage.FIGURE__ON_MOUSE_MOVE:
                return ON_MOUSE_MOVE_EDEFAULT == null ? this.onMouseMove != null : !ON_MOUSE_MOVE_EDEFAULT.equals ( this.onMouseMove );
            case VisualInterfacePackage.FIGURE__ON_MOUSE_HOVER:
                return ON_MOUSE_HOVER_EDEFAULT == null ? this.onMouseHover != null : !ON_MOUSE_HOVER_EDEFAULT.equals ( this.onMouseHover );
            case VisualInterfacePackage.FIGURE__ON_MOUSE_DRAG:
                return ON_MOUSE_DRAG_EDEFAULT == null ? this.onMouseDrag != null : !ON_MOUSE_DRAG_EDEFAULT.equals ( this.onMouseDrag );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
        {
            return super.toString ();
        }

        final StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( this.name );
        result.append ( ", foregroundColor: " ); //$NON-NLS-1$
        result.append ( this.foregroundColor );
        result.append ( ", backgroundColor: " ); //$NON-NLS-1$
        result.append ( this.backgroundColor );
        result.append ( ", onClick: " ); //$NON-NLS-1$
        result.append ( this.onClick );
        result.append ( ", onDoubleClick: " ); //$NON-NLS-1$
        result.append ( this.onDoubleClick );
        result.append ( ", visible: " ); //$NON-NLS-1$
        result.append ( this.visible );
        result.append ( ", border: " ); //$NON-NLS-1$
        result.append ( this.border );
        result.append ( ", opaque: " ); //$NON-NLS-1$
        result.append ( this.opaque );
        result.append ( ", toolTip: " ); //$NON-NLS-1$
        result.append ( this.toolTip );
        result.append ( ", onMouseIn: " ); //$NON-NLS-1$
        result.append ( this.onMouseIn );
        result.append ( ", onMouseOut: " ); //$NON-NLS-1$
        result.append ( this.onMouseOut );
        result.append ( ", onMouseMove: " ); //$NON-NLS-1$
        result.append ( this.onMouseMove );
        result.append ( ", onMouseHover: " ); //$NON-NLS-1$
        result.append ( this.onMouseHover );
        result.append ( ", onMouseDrag: " ); //$NON-NLS-1$
        result.append ( this.onMouseDrag );
        result.append ( ')' );
        return result.toString ();
    }

} //FigureImpl
