/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentDanglingReference;
import org.eclipse.scada.configuration.component.ComponentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dangling Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ComponentDanglingReferenceImpl#getLocalTag <em>Local Tag</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ComponentDanglingReferenceImpl#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentDanglingReferenceImpl extends DanglingItemReferenceImpl implements ComponentDanglingReference
{
    /**
     * The cached value of the '{@link #getLocalTag() <em>Local Tag</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalTag()
     * @generated
     * @ordered
     */
    protected EList<String> localTag;

    /**
     * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComponent()
     * @generated
     * @ordered
     */
    protected Component component;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComponentDanglingReferenceImpl ()
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
        return ComponentPackage.Literals.COMPONENT_DANGLING_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getLocalTag ()
    {
        if ( localTag == null )
        {
            localTag = new EDataTypeUniqueEList<String> ( String.class, this, ComponentPackage.COMPONENT_DANGLING_REFERENCE__LOCAL_TAG );
        }
        return localTag;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Component getComponent ()
    {
        if ( component != null && component.eIsProxy () )
        {
            InternalEObject oldComponent = (InternalEObject)component;
            component = (Component)eResolveProxy ( oldComponent );
            if ( component != oldComponent )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.COMPONENT_DANGLING_REFERENCE__COMPONENT, oldComponent, component ) );
            }
        }
        return component;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Component basicGetComponent ()
    {
        return component;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setComponent ( Component newComponent )
    {
        Component oldComponent = component;
        component = newComponent;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.COMPONENT_DANGLING_REFERENCE__COMPONENT, oldComponent, component ) );
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
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE__LOCAL_TAG:
                return getLocalTag ();
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE__COMPONENT:
                if ( resolve )
                    return getComponent ();
                return basicGetComponent ();
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
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE__LOCAL_TAG:
                getLocalTag ().clear ();
                getLocalTag ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE__COMPONENT:
                setComponent ( (Component)newValue );
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
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE__LOCAL_TAG:
                getLocalTag ().clear ();
                return;
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE__COMPONENT:
                setComponent ( (Component)null );
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
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE__LOCAL_TAG:
                return localTag != null && !localTag.isEmpty ();
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE__COMPONENT:
                return component != null;
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
        result.append ( " (localTag: " ); //$NON-NLS-1$
        result.append ( localTag );
        result.append ( ')' );
        return result.toString ();
    }

} //ComponentDanglingReferenceImpl
