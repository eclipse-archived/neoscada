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
package org.eclipse.scada.configuration.world.deployment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.deployment.Author;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Common Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getMaintainer <em>Maintainer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CommonDeploymentMechanismImpl extends
        MinimalEObjectImpl.Container implements CommonDeploymentMechanism
{
    /**
     * The cached value of the '{@link #getChanges() <em>Changes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getChanges()
     * @generated
     * @ordered
     */
    protected EList<ChangeEntry> changes;

    /**
     * The cached value of the '{@link #getMaintainer() <em>Maintainer</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaintainer()
     * @generated
     * @ordered
     */
    protected Author maintainer;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CommonDeploymentMechanismImpl ()
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
        return DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ChangeEntry> getChanges ()
    {
        if ( changes == null )
        {
            changes = new EObjectContainmentEList.Resolving<ChangeEntry> ( ChangeEntry.class, this, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__CHANGES );
        }
        return changes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Author getMaintainer ()
    {
        if ( maintainer != null && maintainer.eIsProxy () )
        {
            InternalEObject oldMaintainer = (InternalEObject)maintainer;
            maintainer = (Author)eResolveProxy ( oldMaintainer );
            if ( maintainer != oldMaintainer )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MAINTAINER, oldMaintainer, maintainer ) );
            }
        }
        return maintainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Author basicGetMaintainer ()
    {
        return maintainer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaintainer ( Author newMaintainer )
    {
        Author oldMaintainer = maintainer;
        maintainer = newMaintainer;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MAINTAINER, oldMaintainer, maintainer ) );
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__CHANGES:
                return ( (InternalEList<?>)getChanges () ).basicRemove ( otherEnd, msgs );
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__CHANGES:
                return getChanges ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MAINTAINER:
                if ( resolve )
                    return getMaintainer ();
                return basicGetMaintainer ();
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__CHANGES:
                getChanges ().clear ();
                getChanges ().addAll ( (Collection<? extends ChangeEntry>)newValue );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MAINTAINER:
                setMaintainer ( (Author)newValue );
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__CHANGES:
                getChanges ().clear ();
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MAINTAINER:
                setMaintainer ( (Author)null );
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__CHANGES:
                return changes != null && !changes.isEmpty ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MAINTAINER:
                return maintainer != null;
        }
        return super.eIsSet ( featureID );
    }

} //CommonDeploymentMechanismImpl
