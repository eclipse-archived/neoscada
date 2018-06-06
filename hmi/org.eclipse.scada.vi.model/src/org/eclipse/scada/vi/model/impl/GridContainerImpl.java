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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.vi.model.GridChild;
import org.eclipse.scada.vi.model.GridContainer;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Grid Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridContainerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridContainerImpl#getColumns <em>Columns</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridContainerImpl#isEqualWidth <em>Equal Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridContainerImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridContainerImpl#getHorizontalSpacing <em>Horizontal Spacing</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridContainerImpl#getVerticalSpacing <em>Vertical Spacing</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridContainerImpl#getMarginWidth <em>Margin Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.GridContainerImpl#getMarginHeight <em>Margin Height</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GridContainerImpl extends EObjectImpl implements GridContainer
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
     * The default value of the '{@link #getColumns() <em>Columns</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumns()
     * @generated
     * @ordered
     */
    protected static final int COLUMNS_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getColumns() <em>Columns</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColumns()
     * @generated
     * @ordered
     */
    protected int columns = COLUMNS_EDEFAULT;

    /**
     * The default value of the '{@link #isEqualWidth() <em>Equal Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEqualWidth()
     * @generated
     * @ordered
     */
    protected static final boolean EQUAL_WIDTH_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isEqualWidth() <em>Equal Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEqualWidth()
     * @generated
     * @ordered
     */
    protected boolean equalWidth = EQUAL_WIDTH_EDEFAULT;

    /**
     * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildren()
     * @generated
     * @ordered
     */
    protected EList<GridChild> children;

    /**
     * The default value of the '{@link #getHorizontalSpacing() <em>Horizontal Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHorizontalSpacing()
     * @generated
     * @ordered
     */
    protected static final int HORIZONTAL_SPACING_EDEFAULT = 5;

    /**
     * The cached value of the '{@link #getHorizontalSpacing() <em>Horizontal Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHorizontalSpacing()
     * @generated
     * @ordered
     */
    protected int horizontalSpacing = HORIZONTAL_SPACING_EDEFAULT;

    /**
     * The default value of the '{@link #getVerticalSpacing() <em>Vertical Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVerticalSpacing()
     * @generated
     * @ordered
     */
    protected static final int VERTICAL_SPACING_EDEFAULT = 5;

    /**
     * The cached value of the '{@link #getVerticalSpacing() <em>Vertical Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVerticalSpacing()
     * @generated
     * @ordered
     */
    protected int verticalSpacing = VERTICAL_SPACING_EDEFAULT;

    /**
     * The default value of the '{@link #getMarginWidth() <em>Margin Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMarginWidth()
     * @generated
     * @ordered
     */
    protected static final int MARGIN_WIDTH_EDEFAULT = 5;

    /**
     * The cached value of the '{@link #getMarginWidth() <em>Margin Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMarginWidth()
     * @generated
     * @ordered
     */
    protected int marginWidth = MARGIN_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getMarginHeight() <em>Margin Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMarginHeight()
     * @generated
     * @ordered
     */
    protected static final int MARGIN_HEIGHT_EDEFAULT = 5;

    /**
     * The cached value of the '{@link #getMarginHeight() <em>Margin Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMarginHeight()
     * @generated
     * @ordered
     */
    protected int marginHeight = MARGIN_HEIGHT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GridContainerImpl ()
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
        return VisualInterfacePackage.Literals.GRID_CONTAINER;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getColumns ()
    {
        return columns;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setColumns ( int newColumns )
    {
        int oldColumns = columns;
        columns = newColumns;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__COLUMNS, oldColumns, columns ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEqualWidth ()
    {
        return equalWidth;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEqualWidth ( boolean newEqualWidth )
    {
        boolean oldEqualWidth = equalWidth;
        equalWidth = newEqualWidth;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH, oldEqualWidth, equalWidth ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<GridChild> getChildren ()
    {
        if ( children == null )
        {
            children = new EObjectContainmentEList<GridChild> ( GridChild.class, this, VisualInterfacePackage.GRID_CONTAINER__CHILDREN );
        }
        return children;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getHorizontalSpacing ()
    {
        return horizontalSpacing;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHorizontalSpacing ( int newHorizontalSpacing )
    {
        int oldHorizontalSpacing = horizontalSpacing;
        horizontalSpacing = newHorizontalSpacing;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__HORIZONTAL_SPACING, oldHorizontalSpacing, horizontalSpacing ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getVerticalSpacing ()
    {
        return verticalSpacing;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVerticalSpacing ( int newVerticalSpacing )
    {
        int oldVerticalSpacing = verticalSpacing;
        verticalSpacing = newVerticalSpacing;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__VERTICAL_SPACING, oldVerticalSpacing, verticalSpacing ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getMarginWidth ()
    {
        return marginWidth;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMarginWidth ( int newMarginWidth )
    {
        int oldMarginWidth = marginWidth;
        marginWidth = newMarginWidth;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__MARGIN_WIDTH, oldMarginWidth, marginWidth ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getMarginHeight ()
    {
        return marginHeight;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMarginHeight ( int newMarginHeight )
    {
        int oldMarginHeight = marginHeight;
        marginHeight = newMarginHeight;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.GRID_CONTAINER__MARGIN_HEIGHT, oldMarginHeight, marginHeight ) );
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
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                return ( (InternalEList<?>)getChildren () ).basicRemove ( otherEnd, msgs );
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
            case VisualInterfacePackage.GRID_CONTAINER__NAME:
                return getName ();
            case VisualInterfacePackage.GRID_CONTAINER__COLUMNS:
                return getColumns ();
            case VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH:
                return isEqualWidth ();
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                return getChildren ();
            case VisualInterfacePackage.GRID_CONTAINER__HORIZONTAL_SPACING:
                return getHorizontalSpacing ();
            case VisualInterfacePackage.GRID_CONTAINER__VERTICAL_SPACING:
                return getVerticalSpacing ();
            case VisualInterfacePackage.GRID_CONTAINER__MARGIN_WIDTH:
                return getMarginWidth ();
            case VisualInterfacePackage.GRID_CONTAINER__MARGIN_HEIGHT:
                return getMarginHeight ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.GRID_CONTAINER__NAME:
                setName ( (String)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__COLUMNS:
                setColumns ( (Integer)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH:
                setEqualWidth ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                getChildren ().clear ();
                getChildren ().addAll ( (Collection<? extends GridChild>)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__HORIZONTAL_SPACING:
                setHorizontalSpacing ( (Integer)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__VERTICAL_SPACING:
                setVerticalSpacing ( (Integer)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__MARGIN_WIDTH:
                setMarginWidth ( (Integer)newValue );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__MARGIN_HEIGHT:
                setMarginHeight ( (Integer)newValue );
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
            case VisualInterfacePackage.GRID_CONTAINER__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__COLUMNS:
                setColumns ( COLUMNS_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH:
                setEqualWidth ( EQUAL_WIDTH_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                getChildren ().clear ();
                return;
            case VisualInterfacePackage.GRID_CONTAINER__HORIZONTAL_SPACING:
                setHorizontalSpacing ( HORIZONTAL_SPACING_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__VERTICAL_SPACING:
                setVerticalSpacing ( VERTICAL_SPACING_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__MARGIN_WIDTH:
                setMarginWidth ( MARGIN_WIDTH_EDEFAULT );
                return;
            case VisualInterfacePackage.GRID_CONTAINER__MARGIN_HEIGHT:
                setMarginHeight ( MARGIN_HEIGHT_EDEFAULT );
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
            case VisualInterfacePackage.GRID_CONTAINER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case VisualInterfacePackage.GRID_CONTAINER__COLUMNS:
                return columns != COLUMNS_EDEFAULT;
            case VisualInterfacePackage.GRID_CONTAINER__EQUAL_WIDTH:
                return equalWidth != EQUAL_WIDTH_EDEFAULT;
            case VisualInterfacePackage.GRID_CONTAINER__CHILDREN:
                return children != null && !children.isEmpty ();
            case VisualInterfacePackage.GRID_CONTAINER__HORIZONTAL_SPACING:
                return horizontalSpacing != HORIZONTAL_SPACING_EDEFAULT;
            case VisualInterfacePackage.GRID_CONTAINER__VERTICAL_SPACING:
                return verticalSpacing != VERTICAL_SPACING_EDEFAULT;
            case VisualInterfacePackage.GRID_CONTAINER__MARGIN_WIDTH:
                return marginWidth != MARGIN_WIDTH_EDEFAULT;
            case VisualInterfacePackage.GRID_CONTAINER__MARGIN_HEIGHT:
                return marginHeight != MARGIN_HEIGHT_EDEFAULT;
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
        result.append ( ", columns: " ); //$NON-NLS-1$
        result.append ( columns );
        result.append ( ", equalWidth: " ); //$NON-NLS-1$
        result.append ( equalWidth );
        result.append ( ", horizontalSpacing: " ); //$NON-NLS-1$
        result.append ( horizontalSpacing );
        result.append ( ", verticalSpacing: " ); //$NON-NLS-1$
        result.append ( verticalSpacing );
        result.append ( ", marginWidth: " ); //$NON-NLS-1$
        result.append ( marginWidth );
        result.append ( ", marginHeight: " ); //$NON-NLS-1$
        result.append ( marginHeight );
        result.append ( ')' );
        return result.toString ();
    }

} //GridContainerImpl
