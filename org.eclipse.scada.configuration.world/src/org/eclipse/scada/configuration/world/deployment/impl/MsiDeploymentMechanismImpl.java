/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.deployment.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.world.deployment.Architecture;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.P2Platform;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Msi Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MsiDeploymentMechanismImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MsiDeploymentMechanismImpl#getUpgradeCode <em>Upgrade Code</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MsiDeploymentMechanismImpl#getManufacturer <em>Manufacturer</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MsiDeploymentMechanismImpl#getSharedPlatform <em>Shared Platform</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MsiDeploymentMechanismImpl#getLocalPlatform <em>Local Platform</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MsiDeploymentMechanismImpl#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MsiDeploymentMechanismImpl#isEnableFirewall <em>Enable Firewall</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.MsiDeploymentMechanismImpl#isEnableUserInterface <em>Enable User Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MsiDeploymentMechanismImpl extends MinimalEObjectImpl.Container implements MsiDeploymentMechanism
{
    /**
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final String VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected String version = VERSION_EDEFAULT;

    /**
     * The default value of the '{@link #getUpgradeCode() <em>Upgrade Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpgradeCode()
     * @generated
     * @ordered
     */
    protected static final String UPGRADE_CODE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUpgradeCode() <em>Upgrade Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpgradeCode()
     * @generated
     * @ordered
     */
    protected String upgradeCode = UPGRADE_CODE_EDEFAULT;

    /**
     * The default value of the '{@link #getManufacturer() <em>Manufacturer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getManufacturer()
     * @generated
     * @ordered
     */
    protected static final String MANUFACTURER_EDEFAULT = "Eclipse SCADA"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getManufacturer() <em>Manufacturer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getManufacturer()
     * @generated
     * @ordered
     */
    protected String manufacturer = MANUFACTURER_EDEFAULT;

    /**
     * The cached value of the '{@link #getSharedPlatform() <em>Shared Platform</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSharedPlatform()
     * @generated
     * @ordered
     */
    protected P2Platform sharedPlatform;

    /**
     * The cached value of the '{@link #getLocalPlatform() <em>Local Platform</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalPlatform()
     * @generated
     * @ordered
     */
    protected P2Platform localPlatform;

    /**
     * The default value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArchitecture()
     * @generated
     * @ordered
     */
    protected static final Architecture ARCHITECTURE_EDEFAULT = Architecture.I386;

    /**
     * The cached value of the '{@link #getArchitecture() <em>Architecture</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArchitecture()
     * @generated
     * @ordered
     */
    protected Architecture architecture = ARCHITECTURE_EDEFAULT;

    /**
     * The default value of the '{@link #isEnableFirewall() <em>Enable Firewall</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableFirewall()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLE_FIREWALL_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEnableFirewall() <em>Enable Firewall</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableFirewall()
     * @generated
     * @ordered
     */
    protected boolean enableFirewall = ENABLE_FIREWALL_EDEFAULT;

    /**
     * The default value of the '{@link #isEnableUserInterface() <em>Enable User Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableUserInterface()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLE_USER_INTERFACE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEnableUserInterface() <em>Enable User Interface</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableUserInterface()
     * @generated
     * @ordered
     */
    protected boolean enableUserInterface = ENABLE_USER_INTERFACE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MsiDeploymentMechanismImpl ()
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
        return DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getVersion ()
    {
        return version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVersion ( String newVersion )
    {
        String oldVersion = version;
        version = newVersion;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__VERSION, oldVersion, version ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUpgradeCode ()
    {
        return upgradeCode;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUpgradeCode ( String newUpgradeCode )
    {
        String oldUpgradeCode = upgradeCode;
        upgradeCode = newUpgradeCode;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__UPGRADE_CODE, oldUpgradeCode, upgradeCode ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getManufacturer ()
    {
        return manufacturer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setManufacturer ( String newManufacturer )
    {
        String oldManufacturer = manufacturer;
        manufacturer = newManufacturer;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__MANUFACTURER, oldManufacturer, manufacturer ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public P2Platform getSharedPlatform ()
    {
        if ( sharedPlatform != null && sharedPlatform.eIsProxy () )
        {
            InternalEObject oldSharedPlatform = (InternalEObject)sharedPlatform;
            sharedPlatform = (P2Platform)eResolveProxy ( oldSharedPlatform );
            if ( sharedPlatform != oldSharedPlatform )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__SHARED_PLATFORM, oldSharedPlatform, sharedPlatform ) );
            }
        }
        return sharedPlatform;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public P2Platform basicGetSharedPlatform ()
    {
        return sharedPlatform;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSharedPlatform ( P2Platform newSharedPlatform )
    {
        P2Platform oldSharedPlatform = sharedPlatform;
        sharedPlatform = newSharedPlatform;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__SHARED_PLATFORM, oldSharedPlatform, sharedPlatform ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public P2Platform getLocalPlatform ()
    {
        if ( localPlatform != null && localPlatform.eIsProxy () )
        {
            InternalEObject oldLocalPlatform = (InternalEObject)localPlatform;
            localPlatform = (P2Platform)eResolveProxy ( oldLocalPlatform );
            if ( localPlatform != oldLocalPlatform )
            {
                InternalEObject newLocalPlatform = (InternalEObject)localPlatform;
                NotificationChain msgs = oldLocalPlatform.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM, null, null );
                if ( newLocalPlatform.eInternalContainer () == null )
                {
                    msgs = newLocalPlatform.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM, oldLocalPlatform, localPlatform ) );
            }
        }
        return localPlatform;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public P2Platform basicGetLocalPlatform ()
    {
        return localPlatform;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLocalPlatform ( P2Platform newLocalPlatform, NotificationChain msgs )
    {
        P2Platform oldLocalPlatform = localPlatform;
        localPlatform = newLocalPlatform;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM, oldLocalPlatform, newLocalPlatform );
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
    public void setLocalPlatform ( P2Platform newLocalPlatform )
    {
        if ( newLocalPlatform != localPlatform )
        {
            NotificationChain msgs = null;
            if ( localPlatform != null )
                msgs = ( (InternalEObject)localPlatform ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM, null, msgs );
            if ( newLocalPlatform != null )
                msgs = ( (InternalEObject)newLocalPlatform ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM, null, msgs );
            msgs = basicSetLocalPlatform ( newLocalPlatform, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM, newLocalPlatform, newLocalPlatform ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Architecture getArchitecture ()
    {
        return architecture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setArchitecture ( Architecture newArchitecture )
    {
        Architecture oldArchitecture = architecture;
        architecture = newArchitecture == null ? ARCHITECTURE_EDEFAULT : newArchitecture;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ARCHITECTURE, oldArchitecture, architecture ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEnableFirewall ()
    {
        return enableFirewall;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnableFirewall ( boolean newEnableFirewall )
    {
        boolean oldEnableFirewall = enableFirewall;
        enableFirewall = newEnableFirewall;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_FIREWALL, oldEnableFirewall, enableFirewall ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEnableUserInterface ()
    {
        return enableUserInterface;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnableUserInterface ( boolean newEnableUserInterface )
    {
        boolean oldEnableUserInterface = enableUserInterface;
        enableUserInterface = newEnableUserInterface;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_USER_INTERFACE, oldEnableUserInterface, enableUserInterface ) );
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
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM:
                return basicSetLocalPlatform ( null, msgs );
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
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__VERSION:
                return getVersion ();
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__UPGRADE_CODE:
                return getUpgradeCode ();
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__MANUFACTURER:
                return getManufacturer ();
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__SHARED_PLATFORM:
                if ( resolve )
                    return getSharedPlatform ();
                return basicGetSharedPlatform ();
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM:
                if ( resolve )
                    return getLocalPlatform ();
                return basicGetLocalPlatform ();
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ARCHITECTURE:
                return getArchitecture ();
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_FIREWALL:
                return isEnableFirewall ();
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_USER_INTERFACE:
                return isEnableUserInterface ();
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
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__VERSION:
                setVersion ( (String)newValue );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__UPGRADE_CODE:
                setUpgradeCode ( (String)newValue );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__MANUFACTURER:
                setManufacturer ( (String)newValue );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__SHARED_PLATFORM:
                setSharedPlatform ( (P2Platform)newValue );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM:
                setLocalPlatform ( (P2Platform)newValue );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ARCHITECTURE:
                setArchitecture ( (Architecture)newValue );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_FIREWALL:
                setEnableFirewall ( (Boolean)newValue );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_USER_INTERFACE:
                setEnableUserInterface ( (Boolean)newValue );
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
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__VERSION:
                setVersion ( VERSION_EDEFAULT );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__UPGRADE_CODE:
                setUpgradeCode ( UPGRADE_CODE_EDEFAULT );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__MANUFACTURER:
                setManufacturer ( MANUFACTURER_EDEFAULT );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__SHARED_PLATFORM:
                setSharedPlatform ( (P2Platform)null );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM:
                setLocalPlatform ( (P2Platform)null );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ARCHITECTURE:
                setArchitecture ( ARCHITECTURE_EDEFAULT );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_FIREWALL:
                setEnableFirewall ( ENABLE_FIREWALL_EDEFAULT );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_USER_INTERFACE:
                setEnableUserInterface ( ENABLE_USER_INTERFACE_EDEFAULT );
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
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__VERSION:
                return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals ( version );
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__UPGRADE_CODE:
                return UPGRADE_CODE_EDEFAULT == null ? upgradeCode != null : !UPGRADE_CODE_EDEFAULT.equals ( upgradeCode );
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__MANUFACTURER:
                return MANUFACTURER_EDEFAULT == null ? manufacturer != null : !MANUFACTURER_EDEFAULT.equals ( manufacturer );
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__SHARED_PLATFORM:
                return sharedPlatform != null;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM:
                return localPlatform != null;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ARCHITECTURE:
                return architecture != ARCHITECTURE_EDEFAULT;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_FIREWALL:
                return enableFirewall != ENABLE_FIREWALL_EDEFAULT;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_USER_INTERFACE:
                return enableUserInterface != ENABLE_USER_INTERFACE_EDEFAULT;
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
        result.append ( " (version: " ); //$NON-NLS-1$
        result.append ( version );
        result.append ( ", upgradeCode: " ); //$NON-NLS-1$
        result.append ( upgradeCode );
        result.append ( ", manufacturer: " ); //$NON-NLS-1$
        result.append ( manufacturer );
        result.append ( ", architecture: " ); //$NON-NLS-1$
        result.append ( architecture );
        result.append ( ", enableFirewall: " ); //$NON-NLS-1$
        result.append ( enableFirewall );
        result.append ( ", enableUserInterface: " ); //$NON-NLS-1$
        result.append ( enableUserInterface );
        result.append ( ')' );
        return result.toString ();
    }

} //MsiDeploymentMechanismImpl
