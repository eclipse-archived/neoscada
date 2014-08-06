/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.deployment.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debian Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.DebianDeploymentMechanismImpl#getSetup <em>Setup</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DebianDeploymentMechanismImpl extends
        CommonDeploymentMechanismImpl implements DebianDeploymentMechanism
{
    /**
     * The cached value of the '{@link #getSetup() <em>Setup</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSetup()
     * @generated
     * @ordered
     */
    protected SetupModuleContainer setup;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DebianDeploymentMechanismImpl ()
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
        return DeploymentPackage.Literals.DEBIAN_DEPLOYMENT_MECHANISM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SetupModuleContainer getSetup ()
    {
        if ( setup != null && setup.eIsProxy () )
        {
            InternalEObject oldSetup = (InternalEObject)setup;
            setup = (SetupModuleContainer)eResolveProxy ( oldSetup );
            if ( setup != oldSetup )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__SETUP, oldSetup, setup ) );
            }
        }
        return setup;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SetupModuleContainer basicGetSetup ()
    {
        return setup;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSetup ( SetupModuleContainer newSetup )
    {
        SetupModuleContainer oldSetup = setup;
        setup = newSetup;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__SETUP, oldSetup, setup ) );
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
            case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__SETUP:
                if ( resolve )
                    return getSetup ();
                return basicGetSetup ();
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
            case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__SETUP:
                setSetup ( (SetupModuleContainer)newValue );
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
            case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__SETUP:
                setSetup ( (SetupModuleContainer)null );
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
            case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM__SETUP:
                return setup != null;
        }
        return super.eIsSet ( featureID );
    }

} //DebianDeploymentMechanismImpl
