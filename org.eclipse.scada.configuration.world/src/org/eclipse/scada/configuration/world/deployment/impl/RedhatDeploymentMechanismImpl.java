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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Redhat Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.RedhatDeploymentMechanismImpl#getLicense <em>License</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RedhatDeploymentMechanismImpl extends CommonDeploymentMechanismImpl implements RedhatDeploymentMechanism
{
    /**
     * The default value of the '{@link #getLicense() <em>License</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLicense()
     * @generated
     * @ordered
     */
    protected static final String LICENSE_EDEFAULT = "other"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getLicense() <em>License</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLicense()
     * @generated
     * @ordered
     */
    protected String license = LICENSE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RedhatDeploymentMechanismImpl ()
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
        return DeploymentPackage.Literals.REDHAT_DEPLOYMENT_MECHANISM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getLicense ()
    {
        return license;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setLicense ( String newLicense )
    {
        String oldLicense = license;
        license = newLicense;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.REDHAT_DEPLOYMENT_MECHANISM__LICENSE, oldLicense, license ) );
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
            case DeploymentPackage.REDHAT_DEPLOYMENT_MECHANISM__LICENSE:
                return getLicense ();
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
            case DeploymentPackage.REDHAT_DEPLOYMENT_MECHANISM__LICENSE:
                setLicense ( (String)newValue );
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
            case DeploymentPackage.REDHAT_DEPLOYMENT_MECHANISM__LICENSE:
                setLicense ( LICENSE_EDEFAULT );
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
            case DeploymentPackage.REDHAT_DEPLOYMENT_MECHANISM__LICENSE:
                return LICENSE_EDEFAULT == null ? license != null : !LICENSE_EDEFAULT.equals ( license );
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
        result.append ( " (license: " ); //$NON-NLS-1$
        result.append ( license );
        result.append ( ')' );
        return result.toString ();
    }

} //RedhatDeploymentMechanismImpl
