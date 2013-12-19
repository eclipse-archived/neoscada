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
package org.eclipse.scada.configuration.world.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.Service;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Application Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.ApplicationNodeImpl#getApplications <em>Applications</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.ApplicationNodeImpl#getServices <em>Services</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ApplicationNodeImpl extends NodeImpl implements ApplicationNode
{
    /**
     * The cached value of the '{@link #getApplications() <em>Applications</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getApplications()
     * @generated
     * @ordered
     */
    protected EList<Application> applications;

    /**
     * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServices()
     * @generated
     * @ordered
     */
    protected EList<Service> services;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ApplicationNodeImpl ()
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
        return WorldPackage.Literals.APPLICATION_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Application> getApplications ()
    {
        if ( applications == null )
        {
            applications = new EObjectContainmentEList.Resolving<Application> ( Application.class, this, WorldPackage.APPLICATION_NODE__APPLICATIONS );
        }
        return applications;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Service> getServices ()
    {
        if ( services == null )
        {
            services = new EObjectContainmentEList.Resolving<Service> ( Service.class, this, WorldPackage.APPLICATION_NODE__SERVICES );
        }
        return services;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd,
            int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case WorldPackage.APPLICATION_NODE__APPLICATIONS:
                return ( (InternalEList<?>)getApplications () ).basicRemove ( otherEnd, msgs );
            case WorldPackage.APPLICATION_NODE__SERVICES:
                return ( (InternalEList<?>)getServices () ).basicRemove ( otherEnd, msgs );
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
            case WorldPackage.APPLICATION_NODE__APPLICATIONS:
                return getApplications ();
            case WorldPackage.APPLICATION_NODE__SERVICES:
                return getServices ();
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
            case WorldPackage.APPLICATION_NODE__APPLICATIONS:
                getApplications ().clear ();
                getApplications ().addAll ( (Collection<? extends Application>)newValue );
                return;
            case WorldPackage.APPLICATION_NODE__SERVICES:
                getServices ().clear ();
                getServices ().addAll ( (Collection<? extends Service>)newValue );
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
            case WorldPackage.APPLICATION_NODE__APPLICATIONS:
                getApplications ().clear ();
                return;
            case WorldPackage.APPLICATION_NODE__SERVICES:
                getServices ().clear ();
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
            case WorldPackage.APPLICATION_NODE__APPLICATIONS:
                return applications != null && !applications.isEmpty ();
            case WorldPackage.APPLICATION_NODE__SERVICES:
                return services != null && !services.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //ApplicationNodeImpl
