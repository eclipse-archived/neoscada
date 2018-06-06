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

import org.eclipse.scada.vi.model.BorderChild;
import org.eclipse.scada.vi.model.BorderContainer;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Border Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.BorderContainerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.BorderContainerImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.BorderContainerImpl#getVerticalSpacing <em>Vertical Spacing</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.BorderContainerImpl#getHorizontalSpacing <em>Horizontal Spacing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BorderContainerImpl extends EObjectImpl implements BorderContainer
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
     * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChildren()
     * @generated
     * @ordered
     */
    protected EList<BorderChild> children;

    /**
     * The default value of the '{@link #getVerticalSpacing() <em>Vertical Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVerticalSpacing()
     * @generated
     * @ordered
     */
    protected static final int VERTICAL_SPACING_EDEFAULT = 0;

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
     * The default value of the '{@link #getHorizontalSpacing() <em>Horizontal Spacing</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHorizontalSpacing()
     * @generated
     * @ordered
     */
    protected static final int HORIZONTAL_SPACING_EDEFAULT = 0;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BorderContainerImpl ()
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
        return VisualInterfacePackage.Literals.BORDER_CONTAINER;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.BORDER_CONTAINER__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<BorderChild> getChildren ()
    {
        if ( children == null )
        {
            children = new EObjectContainmentEList<BorderChild> ( BorderChild.class, this, VisualInterfacePackage.BORDER_CONTAINER__CHILDREN );
        }
        return children;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.BORDER_CONTAINER__VERTICAL_SPACING, oldVerticalSpacing, verticalSpacing ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.BORDER_CONTAINER__HORIZONTAL_SPACING, oldHorizontalSpacing, horizontalSpacing ) );
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
            case VisualInterfacePackage.BORDER_CONTAINER__CHILDREN:
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
            case VisualInterfacePackage.BORDER_CONTAINER__NAME:
                return getName ();
            case VisualInterfacePackage.BORDER_CONTAINER__CHILDREN:
                return getChildren ();
            case VisualInterfacePackage.BORDER_CONTAINER__VERTICAL_SPACING:
                return getVerticalSpacing ();
            case VisualInterfacePackage.BORDER_CONTAINER__HORIZONTAL_SPACING:
                return getHorizontalSpacing ();
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
            case VisualInterfacePackage.BORDER_CONTAINER__NAME:
                setName ( (String)newValue );
                return;
            case VisualInterfacePackage.BORDER_CONTAINER__CHILDREN:
                getChildren ().clear ();
                getChildren ().addAll ( (Collection<? extends BorderChild>)newValue );
                return;
            case VisualInterfacePackage.BORDER_CONTAINER__VERTICAL_SPACING:
                setVerticalSpacing ( (Integer)newValue );
                return;
            case VisualInterfacePackage.BORDER_CONTAINER__HORIZONTAL_SPACING:
                setHorizontalSpacing ( (Integer)newValue );
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
            case VisualInterfacePackage.BORDER_CONTAINER__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case VisualInterfacePackage.BORDER_CONTAINER__CHILDREN:
                getChildren ().clear ();
                return;
            case VisualInterfacePackage.BORDER_CONTAINER__VERTICAL_SPACING:
                setVerticalSpacing ( VERTICAL_SPACING_EDEFAULT );
                return;
            case VisualInterfacePackage.BORDER_CONTAINER__HORIZONTAL_SPACING:
                setHorizontalSpacing ( HORIZONTAL_SPACING_EDEFAULT );
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
            case VisualInterfacePackage.BORDER_CONTAINER__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case VisualInterfacePackage.BORDER_CONTAINER__CHILDREN:
                return children != null && !children.isEmpty ();
            case VisualInterfacePackage.BORDER_CONTAINER__VERTICAL_SPACING:
                return verticalSpacing != VERTICAL_SPACING_EDEFAULT;
            case VisualInterfacePackage.BORDER_CONTAINER__HORIZONTAL_SPACING:
                return horizontalSpacing != HORIZONTAL_SPACING_EDEFAULT;
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
        result.append ( ", verticalSpacing: " ); //$NON-NLS-1$
        result.append ( verticalSpacing );
        result.append ( ", horizontalSpacing: " ); //$NON-NLS-1$
        result.append ( horizontalSpacing );
        result.append ( ')' );
        return result.toString ();
    }

} //BorderContainerImpl
