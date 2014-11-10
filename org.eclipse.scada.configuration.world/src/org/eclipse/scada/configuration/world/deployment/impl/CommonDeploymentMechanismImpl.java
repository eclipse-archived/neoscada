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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.deployment.Author;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupModule;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Common Deployment Mechanism</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getChanges <em>Changes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getMaintainer <em>Maintainer</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getAdditionalDependencies <em>Additional Dependencies</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getStartupMechanism <em>Startup Mechanism</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#isMultiUserScreen <em>Multi User Screen</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#isAutomaticCreate <em>Automatic Create</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getRecreateBackups <em>Recreate Backups</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getSetup <em>Setup</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl#getAdditionalSetupModules <em>Additional Setup Modules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CommonDeploymentMechanismImpl extends MinimalEObjectImpl.Container implements CommonDeploymentMechanism
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
     * The cached value of the '{@link #getAdditionalDependencies() <em>Additional Dependencies</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAdditionalDependencies()
     * @generated
     * @ordered
     */
    protected EList<String> additionalDependencies;

    /**
     * The default value of the '{@link #getStartupMechanism() <em>Startup Mechanism</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStartupMechanism()
     * @generated
     * @ordered
     */
    protected static final StartupMechanism STARTUP_MECHANISM_EDEFAULT = StartupMechanism.DEFAULT;

    /**
     * The cached value of the '{@link #getStartupMechanism() <em>Startup Mechanism</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStartupMechanism()
     * @generated
     * @ordered
     */
    protected StartupMechanism startupMechanism = STARTUP_MECHANISM_EDEFAULT;

    /**
     * The default value of the '{@link #isMultiUserScreen() <em>Multi User Screen</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isMultiUserScreen()
     * @generated
     * @ordered
     */
    protected static final boolean MULTI_USER_SCREEN_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isMultiUserScreen() <em>Multi User Screen</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isMultiUserScreen()
     * @generated
     * @ordered
     */
    protected boolean multiUserScreen = MULTI_USER_SCREEN_EDEFAULT;

    /**
     * The cached value of the '{@link #getOperatingSystem() <em>Operating System</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperatingSystem()
     * @generated
     * @ordered
     */
    protected OperatingSystemDescriptor operatingSystem;

    /**
     * The default value of the '{@link #isAutomaticCreate() <em>Automatic Create</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAutomaticCreate()
     * @generated
     * @ordered
     */
    protected static final boolean AUTOMATIC_CREATE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isAutomaticCreate() <em>Automatic Create</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isAutomaticCreate()
     * @generated
     * @ordered
     */
    protected boolean automaticCreate = AUTOMATIC_CREATE_EDEFAULT;

    /**
     * The default value of the '{@link #getRecreateBackups() <em>Recreate Backups</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRecreateBackups()
     * @generated
     * @ordered
     */
    protected static final Integer RECREATE_BACKUPS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getRecreateBackups() <em>Recreate Backups</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRecreateBackups()
     * @generated
     * @ordered
     */
    protected Integer recreateBackups = RECREATE_BACKUPS_EDEFAULT;

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
     * The cached value of the '{@link #getAdditionalSetupModules() <em>Additional Setup Modules</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAdditionalSetupModules()
     * @generated
     * @ordered
     */
    protected EList<SetupModule> additionalSetupModules;

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
    public EList<String> getAdditionalDependencies ()
    {
        if ( additionalDependencies == null )
        {
            additionalDependencies = new EDataTypeUniqueEList<String> ( String.class, this, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES );
        }
        return additionalDependencies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StartupMechanism getStartupMechanism ()
    {
        return startupMechanism;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStartupMechanism ( StartupMechanism newStartupMechanism )
    {
        StartupMechanism oldStartupMechanism = startupMechanism;
        startupMechanism = newStartupMechanism == null ? STARTUP_MECHANISM_EDEFAULT : newStartupMechanism;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__STARTUP_MECHANISM, oldStartupMechanism, startupMechanism ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isMultiUserScreen ()
    {
        return multiUserScreen;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMultiUserScreen ( boolean newMultiUserScreen )
    {
        boolean oldMultiUserScreen = multiUserScreen;
        multiUserScreen = newMultiUserScreen;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MULTI_USER_SCREEN, oldMultiUserScreen, multiUserScreen ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperatingSystemDescriptor getOperatingSystem ()
    {
        if ( operatingSystem != null && operatingSystem.eIsProxy () )
        {
            InternalEObject oldOperatingSystem = (InternalEObject)operatingSystem;
            operatingSystem = (OperatingSystemDescriptor)eResolveProxy ( oldOperatingSystem );
            if ( operatingSystem != oldOperatingSystem )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__OPERATING_SYSTEM, oldOperatingSystem, operatingSystem ) );
            }
        }
        return operatingSystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperatingSystemDescriptor basicGetOperatingSystem ()
    {
        return operatingSystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperatingSystem ( OperatingSystemDescriptor newOperatingSystem )
    {
        OperatingSystemDescriptor oldOperatingSystem = operatingSystem;
        operatingSystem = newOperatingSystem;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__OPERATING_SYSTEM, oldOperatingSystem, operatingSystem ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isAutomaticCreate ()
    {
        return automaticCreate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAutomaticCreate ( boolean newAutomaticCreate )
    {
        boolean oldAutomaticCreate = automaticCreate;
        automaticCreate = newAutomaticCreate;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__AUTOMATIC_CREATE, oldAutomaticCreate, automaticCreate ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getRecreateBackups ()
    {
        return recreateBackups;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRecreateBackups ( Integer newRecreateBackups )
    {
        Integer oldRecreateBackups = recreateBackups;
        recreateBackups = newRecreateBackups;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__RECREATE_BACKUPS, oldRecreateBackups, recreateBackups ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__SETUP, oldSetup, setup ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__SETUP, oldSetup, setup ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SetupModule> getAdditionalSetupModules ()
    {
        if ( additionalSetupModules == null )
        {
            additionalSetupModules = new EObjectContainmentEList.Resolving<SetupModule> ( SetupModule.class, this, DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_SETUP_MODULES );
        }
        return additionalSetupModules;
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__CHANGES:
                return ( (InternalEList<?>)getChanges () ).basicRemove ( otherEnd, msgs );
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_SETUP_MODULES:
                return ( (InternalEList<?>)getAdditionalSetupModules () ).basicRemove ( otherEnd, msgs );
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES:
                return getAdditionalDependencies ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__STARTUP_MECHANISM:
                return getStartupMechanism ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MULTI_USER_SCREEN:
                return isMultiUserScreen ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__OPERATING_SYSTEM:
                if ( resolve )
                    return getOperatingSystem ();
                return basicGetOperatingSystem ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__AUTOMATIC_CREATE:
                return isAutomaticCreate ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__RECREATE_BACKUPS:
                return getRecreateBackups ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__SETUP:
                if ( resolve )
                    return getSetup ();
                return basicGetSetup ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_SETUP_MODULES:
                return getAdditionalSetupModules ();
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES:
                getAdditionalDependencies ().clear ();
                getAdditionalDependencies ().addAll ( (Collection<? extends String>)newValue );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__STARTUP_MECHANISM:
                setStartupMechanism ( (StartupMechanism)newValue );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MULTI_USER_SCREEN:
                setMultiUserScreen ( (Boolean)newValue );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__OPERATING_SYSTEM:
                setOperatingSystem ( (OperatingSystemDescriptor)newValue );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__AUTOMATIC_CREATE:
                setAutomaticCreate ( (Boolean)newValue );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__RECREATE_BACKUPS:
                setRecreateBackups ( (Integer)newValue );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__SETUP:
                setSetup ( (SetupModuleContainer)newValue );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_SETUP_MODULES:
                getAdditionalSetupModules ().clear ();
                getAdditionalSetupModules ().addAll ( (Collection<? extends SetupModule>)newValue );
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES:
                getAdditionalDependencies ().clear ();
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__STARTUP_MECHANISM:
                setStartupMechanism ( STARTUP_MECHANISM_EDEFAULT );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MULTI_USER_SCREEN:
                setMultiUserScreen ( MULTI_USER_SCREEN_EDEFAULT );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__OPERATING_SYSTEM:
                setOperatingSystem ( (OperatingSystemDescriptor)null );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__AUTOMATIC_CREATE:
                setAutomaticCreate ( AUTOMATIC_CREATE_EDEFAULT );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__RECREATE_BACKUPS:
                setRecreateBackups ( RECREATE_BACKUPS_EDEFAULT );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__SETUP:
                setSetup ( (SetupModuleContainer)null );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_SETUP_MODULES:
                getAdditionalSetupModules ().clear ();
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
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES:
                return additionalDependencies != null && !additionalDependencies.isEmpty ();
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__STARTUP_MECHANISM:
                return startupMechanism != STARTUP_MECHANISM_EDEFAULT;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MULTI_USER_SCREEN:
                return multiUserScreen != MULTI_USER_SCREEN_EDEFAULT;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__OPERATING_SYSTEM:
                return operatingSystem != null;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__AUTOMATIC_CREATE:
                return automaticCreate != AUTOMATIC_CREATE_EDEFAULT;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__RECREATE_BACKUPS:
                return RECREATE_BACKUPS_EDEFAULT == null ? recreateBackups != null : !RECREATE_BACKUPS_EDEFAULT.equals ( recreateBackups );
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__SETUP:
                return setup != null;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_SETUP_MODULES:
                return additionalSetupModules != null && !additionalSetupModules.isEmpty ();
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
        result.append ( " (additionalDependencies: " ); //$NON-NLS-1$
        result.append ( additionalDependencies );
        result.append ( ", startupMechanism: " ); //$NON-NLS-1$
        result.append ( startupMechanism );
        result.append ( ", multiUserScreen: " ); //$NON-NLS-1$
        result.append ( multiUserScreen );
        result.append ( ", automaticCreate: " ); //$NON-NLS-1$
        result.append ( automaticCreate );
        result.append ( ", recreateBackups: " ); //$NON-NLS-1$
        result.append ( recreateBackups );
        result.append ( ')' );
        return result.toString ();
    }

} //CommonDeploymentMechanismImpl
