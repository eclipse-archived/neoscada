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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.vi.model.GridAlignment;
import org.eclipse.scada.vi.model.GridChild;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grid Child</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridChildImpl#getHorizontalAlignment <em>Horizontal Alignment</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridChildImpl#getVerticalAlignment <em>Vertical Alignment</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridChildImpl#isGrabHorizontalSpace <em>Grab Horizontal Space</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridChildImpl#isGrabVerticalSpace <em>Grab Vertical Space</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridChildImpl#getSpanCols <em>Span Cols</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridChildImpl#getSpanRows <em>Span Rows</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridChildImpl#getWidthHint <em>Width Hint</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridChildImpl#getHeightHint <em>Height Hint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GridChildImpl extends ChildImpl implements GridChild
{
    /**
     * The default value of the '{@link #getHorizontalAlignment() <em>Horizontal Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHorizontalAlignment()
     * @generated
     * @ordered
     */
    protected static final GridAlignment HORIZONTAL_ALIGNMENT_EDEFAULT = GridAlignment.BEGINNING;

    /**
     * The cached value of the '{@link #getHorizontalAlignment() <em>Horizontal Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHorizontalAlignment()
     * @generated
     * @ordered
     */
    protected GridAlignment horizontalAlignment = HORIZONTAL_ALIGNMENT_EDEFAULT;

    /**
     * The default value of the '{@link #getVerticalAlignment() <em>Vertical Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVerticalAlignment()
     * @generated
     * @ordered
     */
    protected static final GridAlignment VERTICAL_ALIGNMENT_EDEFAULT = GridAlignment.BEGINNING;

    /**
     * The cached value of the '{@link #getVerticalAlignment() <em>Vertical Alignment</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVerticalAlignment()
     * @generated
     * @ordered
     */
    protected GridAlignment verticalAlignment = VERTICAL_ALIGNMENT_EDEFAULT;

    /**
     * The default value of the '{@link #isGrabHorizontalSpace() <em>Grab Horizontal Space</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGrabHorizontalSpace()
     * @generated
     * @ordered
     */
    protected static final boolean GRAB_HORIZONTAL_SPACE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isGrabHorizontalSpace() <em>Grab Horizontal Space</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGrabHorizontalSpace()
     * @generated
     * @ordered
     */
    protected boolean grabHorizontalSpace = GRAB_HORIZONTAL_SPACE_EDEFAULT;

    /**
     * The default value of the '{@link #isGrabVerticalSpace() <em>Grab Vertical Space</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGrabVerticalSpace()
     * @generated
     * @ordered
     */
    protected static final boolean GRAB_VERTICAL_SPACE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isGrabVerticalSpace() <em>Grab Vertical Space</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGrabVerticalSpace()
     * @generated
     * @ordered
     */
    protected boolean grabVerticalSpace = GRAB_VERTICAL_SPACE_EDEFAULT;

    /**
     * The default value of the '{@link #getSpanCols() <em>Span Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpanCols()
     * @generated
     * @ordered
     */
    protected static final int SPAN_COLS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getSpanCols() <em>Span Cols</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpanCols()
     * @generated
     * @ordered
     */
    protected int spanCols = SPAN_COLS_EDEFAULT;

    /**
     * The default value of the '{@link #getSpanRows() <em>Span Rows</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpanRows()
     * @generated
     * @ordered
     */
    protected static final Integer SPAN_ROWS_EDEFAULT = new Integer ( 0 );

    /**
     * The cached value of the '{@link #getSpanRows() <em>Span Rows</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpanRows()
     * @generated
     * @ordered
     */
    protected Integer spanRows = SPAN_ROWS_EDEFAULT;

    /**
     * The default value of the '{@link #getWidthHint() <em>Width Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidthHint()
     * @generated
     * @ordered
     */
    protected static final Integer WIDTH_HINT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWidthHint() <em>Width Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidthHint()
     * @generated
     * @ordered
     */
    protected Integer widthHint = WIDTH_HINT_EDEFAULT;

    /**
     * The default value of the '{@link #getHeightHint() <em>Height Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeightHint()
     * @generated
     * @ordered
     */
    protected static final Integer HEIGHT_HINT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHeightHint() <em>Height Hint</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeightHint()
     * @generated
     * @ordered
     */
    protected Integer heightHint = HEIGHT_HINT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GridChildImpl ()
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
        return VisualInterfacePackage.Literals.GRID_CHILD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GridAlignment getHorizontalAlignment ()
    {
        return horizontalAlignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHorizontalAlignment ( GridAlignment newHorizontalAlignment )
    {
        GridAlignment oldHorizontalAlignment = horizontalAlignment;
        horizontalAlignment = newHorizontalAlignment == null ? HORIZONTAL_ALIGNMENT_EDEFAULT : newHorizontalAlignment;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CHILD__HORIZONTAL_ALIGNMENT, oldHorizontalAlignment, horizontalAlignment ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GridAlignment getVerticalAlignment ()
    {
        return verticalAlignment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVerticalAlignment ( GridAlignment newVerticalAlignment )
    {
        GridAlignment oldVerticalAlignment = verticalAlignment;
        verticalAlignment = newVerticalAlignment == null ? VERTICAL_ALIGNMENT_EDEFAULT : newVerticalAlignment;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CHILD__VERTICAL_ALIGNMENT, oldVerticalAlignment, verticalAlignment ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isGrabHorizontalSpace ()
    {
        return grabHorizontalSpace;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGrabHorizontalSpace ( boolean newGrabHorizontalSpace )
    {
        boolean oldGrabHorizontalSpace = grabHorizontalSpace;
        grabHorizontalSpace = newGrabHorizontalSpace;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CHILD__GRAB_HORIZONTAL_SPACE, oldGrabHorizontalSpace, grabHorizontalSpace ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isGrabVerticalSpace ()
    {
        return grabVerticalSpace;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGrabVerticalSpace ( boolean newGrabVerticalSpace )
    {
        boolean oldGrabVerticalSpace = grabVerticalSpace;
        grabVerticalSpace = newGrabVerticalSpace;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CHILD__GRAB_VERTICAL_SPACE, oldGrabVerticalSpace, grabVerticalSpace ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getSpanCols ()
    {
        return spanCols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSpanCols ( int newSpanCols )
    {
        int oldSpanCols = spanCols;
        spanCols = newSpanCols;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CHILD__SPAN_COLS, oldSpanCols, spanCols ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getSpanRows ()
    {
        return spanRows;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSpanRows ( Integer newSpanRows )
    {
        Integer oldSpanRows = spanRows;
        spanRows = newSpanRows;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CHILD__SPAN_ROWS, oldSpanRows, spanRows ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getWidthHint ()
    {
        return widthHint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWidthHint ( Integer newWidthHint )
    {
        Integer oldWidthHint = widthHint;
        widthHint = newWidthHint;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CHILD__WIDTH_HINT, oldWidthHint, widthHint ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getHeightHint ()
    {
        return heightHint;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHeightHint ( Integer newHeightHint )
    {
        Integer oldHeightHint = heightHint;
        heightHint = newHeightHint;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CHILD__HEIGHT_HINT, oldHeightHint, heightHint ) );
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
            case VisualInterfacePackage.GRID_CHILD__HORIZONTAL_ALIGNMENT:
                return getHorizontalAlignment ();
            case VisualInterfacePackage.GRID_CHILD__VERTICAL_ALIGNMENT:
                return getVerticalAlignment ();
            case VisualInterfacePackage.GRID_CHILD__GRAB_HORIZONTAL_SPACE:
                return isGrabHorizontalSpace ();
            case VisualInterfacePackage.GRID_CHILD__GRAB_VERTICAL_SPACE:
                return isGrabVerticalSpace ();
            case VisualInterfacePackage.GRID_CHILD__SPAN_COLS:
                return getSpanCols ();
            case VisualInterfacePackage.GRID_CHILD__SPAN_ROWS:
                return getSpanRows ();
            case VisualInterfacePackage.GRID_CHILD__WIDTH_HINT:
                return getWidthHint ();
            case VisualInterfacePackage.GRID_CHILD__HEIGHT_HINT:
                return getHeightHint ();
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
            case VisualInterfacePackage.GRID_CHILD__HORIZONTAL_ALIGNMENT:
                setHorizontalAlignment ( (GridAlignment)newValue );
                return;
            case VisualInterfacePackage.GRID_CHILD__VERTICAL_ALIGNMENT:
                setVerticalAlignment ( (GridAlignment)newValue );
                return;
            case VisualInterfacePackage.GRID_CHILD__GRAB_HORIZONTAL_SPACE:
                setGrabHorizontalSpace ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.GRID_CHILD__GRAB_VERTICAL_SPACE:
                setGrabVerticalSpace ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.GRID_CHILD__SPAN_COLS:
                setSpanCols ( (Integer)newValue );
                return;
            case VisualInterfacePackage.GRID_CHILD__SPAN_ROWS:
                setSpanRows ( (Integer)newValue );
                return;
            case VisualInterfacePackage.GRID_CHILD__WIDTH_HINT:
                setWidthHint ( (Integer)newValue );
                return;
            case VisualInterfacePackage.GRID_CHILD__HEIGHT_HINT:
                setHeightHint ( (Integer)newValue );
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
            case VisualInterfacePackage.GRID_CHILD__HORIZONTAL_ALIGNMENT:
                setHorizontalAlignment ( HORIZONTAL_ALIGNMENT_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CHILD__VERTICAL_ALIGNMENT:
                setVerticalAlignment ( VERTICAL_ALIGNMENT_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CHILD__GRAB_HORIZONTAL_SPACE:
                setGrabHorizontalSpace ( GRAB_HORIZONTAL_SPACE_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CHILD__GRAB_VERTICAL_SPACE:
                setGrabVerticalSpace ( GRAB_VERTICAL_SPACE_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CHILD__SPAN_COLS:
                setSpanCols ( SPAN_COLS_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CHILD__SPAN_ROWS:
                setSpanRows ( SPAN_ROWS_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CHILD__WIDTH_HINT:
                setWidthHint ( WIDTH_HINT_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CHILD__HEIGHT_HINT:
                setHeightHint ( HEIGHT_HINT_EDEFAULT );
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
            case VisualInterfacePackage.GRID_CHILD__HORIZONTAL_ALIGNMENT:
                return horizontalAlignment != HORIZONTAL_ALIGNMENT_EDEFAULT;
            case VisualInterfacePackage.GRID_CHILD__VERTICAL_ALIGNMENT:
                return verticalAlignment != VERTICAL_ALIGNMENT_EDEFAULT;
            case VisualInterfacePackage.GRID_CHILD__GRAB_HORIZONTAL_SPACE:
                return grabHorizontalSpace != GRAB_HORIZONTAL_SPACE_EDEFAULT;
            case VisualInterfacePackage.GRID_CHILD__GRAB_VERTICAL_SPACE:
                return grabVerticalSpace != GRAB_VERTICAL_SPACE_EDEFAULT;
            case VisualInterfacePackage.GRID_CHILD__SPAN_COLS:
                return spanCols != SPAN_COLS_EDEFAULT;
            case VisualInterfacePackage.GRID_CHILD__SPAN_ROWS:
                return SPAN_ROWS_EDEFAULT == null ? spanRows != null : !SPAN_ROWS_EDEFAULT.equals ( spanRows );
            case VisualInterfacePackage.GRID_CHILD__WIDTH_HINT:
                return WIDTH_HINT_EDEFAULT == null ? widthHint != null : !WIDTH_HINT_EDEFAULT.equals ( widthHint );
            case VisualInterfacePackage.GRID_CHILD__HEIGHT_HINT:
                return HEIGHT_HINT_EDEFAULT == null ? heightHint != null : !HEIGHT_HINT_EDEFAULT.equals ( heightHint );
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
        result.append ( " (horizontalAlignment: " ); //$NON-NLS-1$
        result.append ( horizontalAlignment );
        result.append ( ", verticalAlignment: " ); //$NON-NLS-1$
        result.append ( verticalAlignment );
        result.append ( ", grabHorizontalSpace: " ); //$NON-NLS-1$
        result.append ( grabHorizontalSpace );
        result.append ( ", grabVerticalSpace: " ); //$NON-NLS-1$
        result.append ( grabVerticalSpace );
        result.append ( ", spanCols: " ); //$NON-NLS-1$
        result.append ( spanCols );
        result.append ( ", spanRows: " ); //$NON-NLS-1$
        result.append ( spanRows );
        result.append ( ", widthHint: " ); //$NON-NLS-1$
        result.append ( widthHint );
        result.append ( ", heightHint: " ); //$NON-NLS-1$
        result.append ( heightHint );
        result.append ( ')' );
        return result.toString ();
    }

} //GridChildImpl
