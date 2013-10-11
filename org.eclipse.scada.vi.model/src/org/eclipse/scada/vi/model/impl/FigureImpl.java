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
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getForegroundColor <em>Foreground Color</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOnClick <em>On Click</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOnDoubleClick <em>On Double Click</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getCursor <em>Cursor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getBorder <em>Border</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getOpaque <em>Opaque</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.FigureImpl#getToolTip <em>Tool Tip</em>}</li>
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
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getForegroundColor()
     * @generated
     * @ordered
     */
    protected static final String FOREGROUND_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getForegroundColor()
     * @generated
     * @ordered
     */
    protected String foregroundColor = FOREGROUND_COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final String BACKGROUND_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected String backgroundColor = BACKGROUND_COLOR_EDEFAULT;

    /**
     * The cached value of the '{@link #getSize() <em>Size</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSize()
     * @generated
     * @ordered
     */
    protected Dimension size;

    /**
     * The default value of the '{@link #getOnClick() <em>On Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnClick()
     * @generated
     * @ordered
     */
    protected static final String ON_CLICK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnClick() <em>On Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnClick()
     * @generated
     * @ordered
     */
    protected String onClick = ON_CLICK_EDEFAULT;

    /**
     * The default value of the '{@link #getOnDoubleClick() <em>On Double Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnDoubleClick()
     * @generated
     * @ordered
     */
    protected static final String ON_DOUBLE_CLICK_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnDoubleClick() <em>On Double Click</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnDoubleClick()
     * @generated
     * @ordered
     */
    protected String onDoubleClick = ON_DOUBLE_CLICK_EDEFAULT;

    /**
     * The cached value of the '{@link #getCursor() <em>Cursor</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCursor()
     * @generated
     * @ordered
     */
    protected Cursor cursor;

    /**
     * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected static final boolean VISIBLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isVisible()
     * @generated
     * @ordered
     */
    protected boolean visible = VISIBLE_EDEFAULT;

    /**
     * The default value of the '{@link #getBorder() <em>Border</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBorder()
     * @generated
     * @ordered
     */
    protected static final String BORDER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBorder() <em>Border</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBorder()
     * @generated
     * @ordered
     */
    protected String border = BORDER_EDEFAULT;

    /**
     * The default value of the '{@link #getOpaque() <em>Opaque</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOpaque()
     * @generated
     * @ordered
     */
    protected static final Boolean OPAQUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOpaque() <em>Opaque</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOpaque()
     * @generated
     * @ordered
     */
    protected Boolean opaque = OPAQUE_EDEFAULT;

    /**
     * The default value of the '{@link #getToolTip() <em>Tool Tip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getToolTip()
     * @generated
     * @ordered
     */
    protected static final String TOOL_TIP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getToolTip() <em>Tool Tip</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getToolTip()
     * @generated
     * @ordered
     */
    protected String toolTip = TOOL_TIP_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FigureImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
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
     * @generated
     */
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getForegroundColor ()
    {
        return foregroundColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForegroundColor ( String newForegroundColor )
    {
        String oldForegroundColor = foregroundColor;
        foregroundColor = newForegroundColor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__FOREGROUND_COLOR, oldForegroundColor, foregroundColor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBackgroundColor ()
    {
        return backgroundColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBackgroundColor ( String newBackgroundColor )
    {
        String oldBackgroundColor = backgroundColor;
        backgroundColor = newBackgroundColor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Dimension getSize ()
    {
        return size;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSize ( Dimension newSize, NotificationChain msgs )
    {
        Dimension oldSize = size;
        size = newSize;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__SIZE, oldSize, newSize );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSize ( Dimension newSize )
    {
        if ( newSize != size )
        {
            NotificationChain msgs = null;
            if ( size != null )
                msgs = ( (InternalEObject)size ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.FIGURE__SIZE, null, msgs );
            if ( newSize != null )
                msgs = ( (InternalEObject)newSize ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.FIGURE__SIZE, null, msgs );
            msgs = basicSetSize ( newSize, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__SIZE, newSize, newSize ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOnClick ()
    {
        return onClick;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnClick ( String newOnClick )
    {
        String oldOnClick = onClick;
        onClick = newOnClick;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__ON_CLICK, oldOnClick, onClick ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOnDoubleClick ()
    {
        return onDoubleClick;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnDoubleClick ( String newOnDoubleClick )
    {
        String oldOnDoubleClick = onDoubleClick;
        onDoubleClick = newOnDoubleClick;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__ON_DOUBLE_CLICK, oldOnDoubleClick, onDoubleClick ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cursor getCursor ()
    {
        if ( cursor != null && cursor.eIsProxy () )
        {
            InternalEObject oldCursor = (InternalEObject)cursor;
            cursor = (Cursor)eResolveProxy ( oldCursor );
            if ( cursor != oldCursor )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, VisualInterfacePackage.FIGURE__CURSOR, oldCursor, cursor ) );
            }
        }
        return cursor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cursor basicGetCursor ()
    {
        return cursor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCursor ( Cursor newCursor )
    {
        Cursor oldCursor = cursor;
        cursor = newCursor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__CURSOR, oldCursor, cursor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isVisible ()
    {
        return visible;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVisible ( boolean newVisible )
    {
        boolean oldVisible = visible;
        visible = newVisible;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__VISIBLE, oldVisible, visible ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBorder ()
    {
        return border;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBorder ( String newBorder )
    {
        String oldBorder = border;
        border = newBorder;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__BORDER, oldBorder, border ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getOpaque ()
    {
        return opaque;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOpaque ( Boolean newOpaque )
    {
        Boolean oldOpaque = opaque;
        opaque = newOpaque;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__OPAQUE, oldOpaque, opaque ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getToolTip ()
    {
        return toolTip;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setToolTip ( String newToolTip )
    {
        String oldToolTip = toolTip;
        toolTip = newToolTip;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.FIGURE__TOOL_TIP, oldToolTip, toolTip ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
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
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
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
                    return getCursor ();
                return basicGetCursor ();
            case VisualInterfacePackage.FIGURE__VISIBLE:
                return isVisible ();
            case VisualInterfacePackage.FIGURE__BORDER:
                return getBorder ();
            case VisualInterfacePackage.FIGURE__OPAQUE:
                return getOpaque ();
            case VisualInterfacePackage.FIGURE__TOOL_TIP:
                return getToolTip ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
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
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
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
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.FIGURE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case VisualInterfacePackage.FIGURE__FOREGROUND_COLOR:
                return FOREGROUND_COLOR_EDEFAULT == null ? foregroundColor != null : !FOREGROUND_COLOR_EDEFAULT.equals ( foregroundColor );
            case VisualInterfacePackage.FIGURE__BACKGROUND_COLOR:
                return BACKGROUND_COLOR_EDEFAULT == null ? backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT.equals ( backgroundColor );
            case VisualInterfacePackage.FIGURE__SIZE:
                return size != null;
            case VisualInterfacePackage.FIGURE__ON_CLICK:
                return ON_CLICK_EDEFAULT == null ? onClick != null : !ON_CLICK_EDEFAULT.equals ( onClick );
            case VisualInterfacePackage.FIGURE__ON_DOUBLE_CLICK:
                return ON_DOUBLE_CLICK_EDEFAULT == null ? onDoubleClick != null : !ON_DOUBLE_CLICK_EDEFAULT.equals ( onDoubleClick );
            case VisualInterfacePackage.FIGURE__CURSOR:
                return cursor != null;
            case VisualInterfacePackage.FIGURE__VISIBLE:
                return visible != VISIBLE_EDEFAULT;
            case VisualInterfacePackage.FIGURE__BORDER:
                return BORDER_EDEFAULT == null ? border != null : !BORDER_EDEFAULT.equals ( border );
            case VisualInterfacePackage.FIGURE__OPAQUE:
                return OPAQUE_EDEFAULT == null ? opaque != null : !OPAQUE_EDEFAULT.equals ( opaque );
            case VisualInterfacePackage.FIGURE__TOOL_TIP:
                return TOOL_TIP_EDEFAULT == null ? toolTip != null : !TOOL_TIP_EDEFAULT.equals ( toolTip );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", foregroundColor: " ); //$NON-NLS-1$
        result.append ( foregroundColor );
        result.append ( ", backgroundColor: " ); //$NON-NLS-1$
        result.append ( backgroundColor );
        result.append ( ", onClick: " ); //$NON-NLS-1$
        result.append ( onClick );
        result.append ( ", onDoubleClick: " ); //$NON-NLS-1$
        result.append ( onDoubleClick );
        result.append ( ", visible: " ); //$NON-NLS-1$
        result.append ( visible );
        result.append ( ", border: " ); //$NON-NLS-1$
        result.append ( border );
        result.append ( ", opaque: " ); //$NON-NLS-1$
        result.append ( opaque );
        result.append ( ", toolTip: " ); //$NON-NLS-1$
        result.append ( toolTip );
        result.append ( ')' );
        return result.toString ();
    }

} //FigureImpl
