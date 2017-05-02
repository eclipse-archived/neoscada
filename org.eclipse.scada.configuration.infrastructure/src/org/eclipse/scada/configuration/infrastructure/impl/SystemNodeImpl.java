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
package org.eclipse.scada.configuration.infrastructure.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.SystemNode;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveSlave;
import org.eclipse.scada.configuration.world.Service;
import org.eclipse.scada.configuration.world.deployment.DeploymentMechanism;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl#getDeployment <em>Deployment</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl#getDrivers <em>Drivers</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl#getMasters <em>Masters</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl#getValueArchives <em>Value Archives</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl#getApplications <em>Applications</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.SystemNodeImpl#getValueSlaves <em>Value Slaves</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemNodeImpl extends NodeImpl implements SystemNode
{
    /**
     * The cached value of the '{@link #getDeployment() <em>Deployment</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeployment()
     * @generated
     * @ordered
     */
    protected EList<DeploymentMechanism> deployment;

    /**
     * The cached value of the '{@link #getDrivers() <em>Drivers</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDrivers()
     * @generated
     * @ordered
     */
    protected EList<Driver> drivers;

    /**
     * The cached value of the '{@link #getApplications() <em>Applications</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getApplications()
     * @generated
     * @ordered
     */
    protected FeatureMap applications;

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
     * The cached value of the '{@link #getValueSlaves() <em>Value Slaves</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueSlaves()
     * @generated
     * @ordered
     */
    protected EList<ValueArchiveSlave> valueSlaves;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SystemNodeImpl ()
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
        return InfrastructurePackage.Literals.SYSTEM_NODE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DeploymentMechanism> getDeployment ()
    {
        if ( deployment == null )
        {
            deployment = new EObjectContainmentEList.Resolving<DeploymentMechanism> ( DeploymentMechanism.class, this, InfrastructurePackage.SYSTEM_NODE__DEPLOYMENT );
        }
        return deployment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Driver> getDrivers ()
    {
        if ( drivers == null )
        {
            drivers = new EObjectContainmentWithInverseEList.Resolving<Driver> ( Driver.class, this, InfrastructurePackage.SYSTEM_NODE__DRIVERS, InfrastructurePackage.DRIVER__NODE );
        }
        return drivers;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MasterServer> getMasters ()
    {
        return getApplications ().list ( InfrastructurePackage.Literals.SYSTEM_NODE__MASTERS );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ValueArchiveServer> getValueArchives ()
    {
        return getApplications ().list ( InfrastructurePackage.Literals.SYSTEM_NODE__VALUE_ARCHIVES );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getApplications ()
    {
        if ( applications == null )
        {
            applications = new BasicFeatureMap ( this, InfrastructurePackage.SYSTEM_NODE__APPLICATIONS );
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
            services = new EObjectContainmentEList.Resolving<Service> ( Service.class, this, InfrastructurePackage.SYSTEM_NODE__SERVICES );
        }
        return services;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ValueArchiveSlave> getValueSlaves ()
    {
        if ( valueSlaves == null )
        {
            valueSlaves = new EObjectContainmentEList.Resolving<ValueArchiveSlave> ( ValueArchiveSlave.class, this, InfrastructurePackage.SYSTEM_NODE__VALUE_SLAVES );
        }
        return valueSlaves;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case InfrastructurePackage.SYSTEM_NODE__DRIVERS:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getDrivers () ).basicAdd ( otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
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
            case InfrastructurePackage.SYSTEM_NODE__DEPLOYMENT:
                return ( (InternalEList<?>)getDeployment () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.SYSTEM_NODE__DRIVERS:
                return ( (InternalEList<?>)getDrivers () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.SYSTEM_NODE__MASTERS:
                return ( (InternalEList<?>)getMasters () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.SYSTEM_NODE__VALUE_ARCHIVES:
                return ( (InternalEList<?>)getValueArchives () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.SYSTEM_NODE__APPLICATIONS:
                return ( (InternalEList<?>)getApplications () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.SYSTEM_NODE__SERVICES:
                return ( (InternalEList<?>)getServices () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.SYSTEM_NODE__VALUE_SLAVES:
                return ( (InternalEList<?>)getValueSlaves () ).basicRemove ( otherEnd, msgs );
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
            case InfrastructurePackage.SYSTEM_NODE__DEPLOYMENT:
                return getDeployment ();
            case InfrastructurePackage.SYSTEM_NODE__DRIVERS:
                return getDrivers ();
            case InfrastructurePackage.SYSTEM_NODE__MASTERS:
                return getMasters ();
            case InfrastructurePackage.SYSTEM_NODE__VALUE_ARCHIVES:
                return getValueArchives ();
            case InfrastructurePackage.SYSTEM_NODE__APPLICATIONS:
                if ( coreType )
                    return getApplications ();
                return ( (FeatureMap.Internal)getApplications () ).getWrapper ();
            case InfrastructurePackage.SYSTEM_NODE__SERVICES:
                return getServices ();
            case InfrastructurePackage.SYSTEM_NODE__VALUE_SLAVES:
                return getValueSlaves ();
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
            case InfrastructurePackage.SYSTEM_NODE__DEPLOYMENT:
                getDeployment ().clear ();
                getDeployment ().addAll ( (Collection<? extends DeploymentMechanism>)newValue );
                return;
            case InfrastructurePackage.SYSTEM_NODE__DRIVERS:
                getDrivers ().clear ();
                getDrivers ().addAll ( (Collection<? extends Driver>)newValue );
                return;
            case InfrastructurePackage.SYSTEM_NODE__MASTERS:
                getMasters ().clear ();
                getMasters ().addAll ( (Collection<? extends MasterServer>)newValue );
                return;
            case InfrastructurePackage.SYSTEM_NODE__VALUE_ARCHIVES:
                getValueArchives ().clear ();
                getValueArchives ().addAll ( (Collection<? extends ValueArchiveServer>)newValue );
                return;
            case InfrastructurePackage.SYSTEM_NODE__APPLICATIONS:
                ( (FeatureMap.Internal)getApplications () ).set ( newValue );
                return;
            case InfrastructurePackage.SYSTEM_NODE__SERVICES:
                getServices ().clear ();
                getServices ().addAll ( (Collection<? extends Service>)newValue );
                return;
            case InfrastructurePackage.SYSTEM_NODE__VALUE_SLAVES:
                getValueSlaves ().clear ();
                getValueSlaves ().addAll ( (Collection<? extends ValueArchiveSlave>)newValue );
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
            case InfrastructurePackage.SYSTEM_NODE__DEPLOYMENT:
                getDeployment ().clear ();
                return;
            case InfrastructurePackage.SYSTEM_NODE__DRIVERS:
                getDrivers ().clear ();
                return;
            case InfrastructurePackage.SYSTEM_NODE__MASTERS:
                getMasters ().clear ();
                return;
            case InfrastructurePackage.SYSTEM_NODE__VALUE_ARCHIVES:
                getValueArchives ().clear ();
                return;
            case InfrastructurePackage.SYSTEM_NODE__APPLICATIONS:
                getApplications ().clear ();
                return;
            case InfrastructurePackage.SYSTEM_NODE__SERVICES:
                getServices ().clear ();
                return;
            case InfrastructurePackage.SYSTEM_NODE__VALUE_SLAVES:
                getValueSlaves ().clear ();
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
            case InfrastructurePackage.SYSTEM_NODE__DEPLOYMENT:
                return deployment != null && !deployment.isEmpty ();
            case InfrastructurePackage.SYSTEM_NODE__DRIVERS:
                return drivers != null && !drivers.isEmpty ();
            case InfrastructurePackage.SYSTEM_NODE__MASTERS:
                return !getMasters ().isEmpty ();
            case InfrastructurePackage.SYSTEM_NODE__VALUE_ARCHIVES:
                return !getValueArchives ().isEmpty ();
            case InfrastructurePackage.SYSTEM_NODE__APPLICATIONS:
                return applications != null && !applications.isEmpty ();
            case InfrastructurePackage.SYSTEM_NODE__SERVICES:
                return services != null && !services.isEmpty ();
            case InfrastructurePackage.SYSTEM_NODE__VALUE_SLAVES:
                return valueSlaves != null && !valueSlaves.isEmpty ();
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
        result.append ( " (applications: " ); //$NON-NLS-1$
        result.append ( applications );
        result.append ( ')' );
        return result.toString ();
    }

} //SystemNodeImpl
