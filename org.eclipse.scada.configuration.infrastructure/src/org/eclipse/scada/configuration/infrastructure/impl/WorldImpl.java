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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.infrastructure.Configurations;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.security.Configuration;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.PasswordCredentials;
import org.eclipse.scada.configuration.world.osgi.IndependentConfiguration;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getOptions <em>Options</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getDefaultSecurityConfiguration <em>Default Security Configuration</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getDefaultMasterHandlerPriorities <em>Default Master Handler Priorities</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getDefaultCredentials <em>Default Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getDefaultMasterCustomizationProfile <em>Default Master Customization Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getDefaultValueArchiveCustomizationProfile <em>Default Value Archive Customization Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getDefaultDriverPassword <em>Default Driver Password</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getApplicationConfigurations <em>Application Configurations</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getDefaultDriverAccessCredentials <em>Default Driver Access Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.WorldImpl#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorldImpl extends MinimalEObjectImpl.Container implements World
{
    /**
     * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNodes()
     * @generated
     * @ordered
     */
    protected EList<Node> nodes;

    /**
     * The cached value of the '{@link #getOptions() <em>Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOptions()
     * @generated
     * @ordered
     */
    protected Options options;

    /**
     * The cached value of the '{@link #getDefaultSecurityConfiguration() <em>Default Security Configuration</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultSecurityConfiguration()
     * @generated
     * @ordered
     */
    protected Configuration defaultSecurityConfiguration;

    /**
     * The cached value of the '{@link #getDefaultMasterHandlerPriorities() <em>Default Master Handler Priorities</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultMasterHandlerPriorities()
     * @generated
     * @ordered
     */
    protected MasterHandlerPriorities defaultMasterHandlerPriorities;

    /**
     * The cached value of the '{@link #getDefaultCredentials() <em>Default Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultCredentials()
     * @generated
     * @ordered
     */
    protected Credentials defaultCredentials;

    /**
     * The cached value of the '{@link #getDefaultMasterCustomizationProfile() <em>Default Master Customization Profile</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultMasterCustomizationProfile()
     * @generated
     * @ordered
     */
    protected Profile defaultMasterCustomizationProfile;

    /**
     * The cached value of the '{@link #getDefaultValueArchiveCustomizationProfile() <em>Default Value Archive Customization Profile</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValueArchiveCustomizationProfile()
     * @generated
     * @ordered
     */
    protected Profile defaultValueArchiveCustomizationProfile;

    /**
     * The cached value of the '{@link #getDefaultDriverPassword() <em>Default Driver Password</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultDriverPassword()
     * @generated
     * @ordered
     */
    protected PasswordCredentials defaultDriverPassword;

    /**
     * The cached value of the '{@link #getApplicationConfigurations() <em>Application Configurations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getApplicationConfigurations()
     * @generated
     * @ordered
     */
    protected EList<IndependentConfiguration> applicationConfigurations;

    /**
     * The cached value of the '{@link #getDefaultDriverAccessCredentials() <em>Default Driver Access Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultDriverAccessCredentials()
     * @generated
     * @ordered
     */
    protected Credentials defaultDriverAccessCredentials;

    /**
     * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurations()
     * @generated
     * @ordered
     */
    protected Configurations configurations;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WorldImpl ()
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
        return InfrastructurePackage.Literals.WORLD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Node> getNodes ()
    {
        if ( nodes == null )
        {
            nodes = new EObjectContainmentEList.Resolving<Node> ( Node.class, this, InfrastructurePackage.WORLD__NODES );
        }
        return nodes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Options getOptions ()
    {
        if ( options != null && options.eIsProxy () )
        {
            InternalEObject oldOptions = (InternalEObject)options;
            options = (Options)eResolveProxy ( oldOptions );
            if ( options != oldOptions )
            {
                InternalEObject newOptions = (InternalEObject)options;
                NotificationChain msgs = oldOptions.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__OPTIONS, null, null );
                if ( newOptions.eInternalContainer () == null )
                {
                    msgs = newOptions.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__OPTIONS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.WORLD__OPTIONS, oldOptions, options ) );
            }
        }
        return options;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Options basicGetOptions ()
    {
        return options;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOptions ( Options newOptions, NotificationChain msgs )
    {
        Options oldOptions = options;
        options = newOptions;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__OPTIONS, oldOptions, newOptions );
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
    public void setOptions ( Options newOptions )
    {
        if ( newOptions != options )
        {
            NotificationChain msgs = null;
            if ( options != null )
                msgs = ( (InternalEObject)options ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__OPTIONS, null, msgs );
            if ( newOptions != null )
                msgs = ( (InternalEObject)newOptions ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__OPTIONS, null, msgs );
            msgs = basicSetOptions ( newOptions, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__OPTIONS, newOptions, newOptions ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Configuration getDefaultSecurityConfiguration ()
    {
        if ( defaultSecurityConfiguration != null && defaultSecurityConfiguration.eIsProxy () )
        {
            InternalEObject oldDefaultSecurityConfiguration = (InternalEObject)defaultSecurityConfiguration;
            defaultSecurityConfiguration = (Configuration)eResolveProxy ( oldDefaultSecurityConfiguration );
            if ( defaultSecurityConfiguration != oldDefaultSecurityConfiguration )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.WORLD__DEFAULT_SECURITY_CONFIGURATION, oldDefaultSecurityConfiguration, defaultSecurityConfiguration ) );
            }
        }
        return defaultSecurityConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Configuration basicGetDefaultSecurityConfiguration ()
    {
        return defaultSecurityConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultSecurityConfiguration ( Configuration newDefaultSecurityConfiguration )
    {
        Configuration oldDefaultSecurityConfiguration = defaultSecurityConfiguration;
        defaultSecurityConfiguration = newDefaultSecurityConfiguration;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_SECURITY_CONFIGURATION, oldDefaultSecurityConfiguration, defaultSecurityConfiguration ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterHandlerPriorities getDefaultMasterHandlerPriorities ()
    {
        if ( defaultMasterHandlerPriorities != null && defaultMasterHandlerPriorities.eIsProxy () )
        {
            InternalEObject oldDefaultMasterHandlerPriorities = (InternalEObject)defaultMasterHandlerPriorities;
            defaultMasterHandlerPriorities = (MasterHandlerPriorities)eResolveProxy ( oldDefaultMasterHandlerPriorities );
            if ( defaultMasterHandlerPriorities != oldDefaultMasterHandlerPriorities )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES, oldDefaultMasterHandlerPriorities, defaultMasterHandlerPriorities ) );
            }
        }
        return defaultMasterHandlerPriorities;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterHandlerPriorities basicGetDefaultMasterHandlerPriorities ()
    {
        return defaultMasterHandlerPriorities;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultMasterHandlerPriorities ( MasterHandlerPriorities newDefaultMasterHandlerPriorities )
    {
        MasterHandlerPriorities oldDefaultMasterHandlerPriorities = defaultMasterHandlerPriorities;
        defaultMasterHandlerPriorities = newDefaultMasterHandlerPriorities;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES, oldDefaultMasterHandlerPriorities, defaultMasterHandlerPriorities ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials getDefaultCredentials ()
    {
        if ( defaultCredentials != null && defaultCredentials.eIsProxy () )
        {
            InternalEObject oldDefaultCredentials = (InternalEObject)defaultCredentials;
            defaultCredentials = (Credentials)eResolveProxy ( oldDefaultCredentials );
            if ( defaultCredentials != oldDefaultCredentials )
            {
                InternalEObject newDefaultCredentials = (InternalEObject)defaultCredentials;
                NotificationChain msgs = oldDefaultCredentials.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS, null, null );
                if ( newDefaultCredentials.eInternalContainer () == null )
                {
                    msgs = newDefaultCredentials.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS, oldDefaultCredentials, defaultCredentials ) );
            }
        }
        return defaultCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials basicGetDefaultCredentials ()
    {
        return defaultCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefaultCredentials ( Credentials newDefaultCredentials, NotificationChain msgs )
    {
        Credentials oldDefaultCredentials = defaultCredentials;
        defaultCredentials = newDefaultCredentials;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS, oldDefaultCredentials, newDefaultCredentials );
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
    public void setDefaultCredentials ( Credentials newDefaultCredentials )
    {
        if ( newDefaultCredentials != defaultCredentials )
        {
            NotificationChain msgs = null;
            if ( defaultCredentials != null )
                msgs = ( (InternalEObject)defaultCredentials ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS, null, msgs );
            if ( newDefaultCredentials != null )
                msgs = ( (InternalEObject)newDefaultCredentials ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS, null, msgs );
            msgs = basicSetDefaultCredentials ( newDefaultCredentials, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS, newDefaultCredentials, newDefaultCredentials ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Profile getDefaultMasterCustomizationProfile ()
    {
        if ( defaultMasterCustomizationProfile != null && defaultMasterCustomizationProfile.eIsProxy () )
        {
            InternalEObject oldDefaultMasterCustomizationProfile = (InternalEObject)defaultMasterCustomizationProfile;
            defaultMasterCustomizationProfile = (Profile)eResolveProxy ( oldDefaultMasterCustomizationProfile );
            if ( defaultMasterCustomizationProfile != oldDefaultMasterCustomizationProfile )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE, oldDefaultMasterCustomizationProfile, defaultMasterCustomizationProfile ) );
            }
        }
        return defaultMasterCustomizationProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Profile basicGetDefaultMasterCustomizationProfile ()
    {
        return defaultMasterCustomizationProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultMasterCustomizationProfile ( Profile newDefaultMasterCustomizationProfile )
    {
        Profile oldDefaultMasterCustomizationProfile = defaultMasterCustomizationProfile;
        defaultMasterCustomizationProfile = newDefaultMasterCustomizationProfile;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE, oldDefaultMasterCustomizationProfile, defaultMasterCustomizationProfile ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Profile getDefaultValueArchiveCustomizationProfile ()
    {
        if ( defaultValueArchiveCustomizationProfile != null && defaultValueArchiveCustomizationProfile.eIsProxy () )
        {
            InternalEObject oldDefaultValueArchiveCustomizationProfile = (InternalEObject)defaultValueArchiveCustomizationProfile;
            defaultValueArchiveCustomizationProfile = (Profile)eResolveProxy ( oldDefaultValueArchiveCustomizationProfile );
            if ( defaultValueArchiveCustomizationProfile != oldDefaultValueArchiveCustomizationProfile )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE, oldDefaultValueArchiveCustomizationProfile, defaultValueArchiveCustomizationProfile ) );
            }
        }
        return defaultValueArchiveCustomizationProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Profile basicGetDefaultValueArchiveCustomizationProfile ()
    {
        return defaultValueArchiveCustomizationProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultValueArchiveCustomizationProfile ( Profile newDefaultValueArchiveCustomizationProfile )
    {
        Profile oldDefaultValueArchiveCustomizationProfile = defaultValueArchiveCustomizationProfile;
        defaultValueArchiveCustomizationProfile = newDefaultValueArchiveCustomizationProfile;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE, oldDefaultValueArchiveCustomizationProfile, defaultValueArchiveCustomizationProfile ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PasswordCredentials getDefaultDriverPassword ()
    {
        if ( defaultDriverPassword != null && defaultDriverPassword.eIsProxy () )
        {
            InternalEObject oldDefaultDriverPassword = (InternalEObject)defaultDriverPassword;
            defaultDriverPassword = (PasswordCredentials)eResolveProxy ( oldDefaultDriverPassword );
            if ( defaultDriverPassword != oldDefaultDriverPassword )
            {
                InternalEObject newDefaultDriverPassword = (InternalEObject)defaultDriverPassword;
                NotificationChain msgs = oldDefaultDriverPassword.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD, null, null );
                if ( newDefaultDriverPassword.eInternalContainer () == null )
                {
                    msgs = newDefaultDriverPassword.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD, oldDefaultDriverPassword, defaultDriverPassword ) );
            }
        }
        return defaultDriverPassword;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PasswordCredentials basicGetDefaultDriverPassword ()
    {
        return defaultDriverPassword;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefaultDriverPassword ( PasswordCredentials newDefaultDriverPassword, NotificationChain msgs )
    {
        PasswordCredentials oldDefaultDriverPassword = defaultDriverPassword;
        defaultDriverPassword = newDefaultDriverPassword;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD, oldDefaultDriverPassword, newDefaultDriverPassword );
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
    public void setDefaultDriverPassword ( PasswordCredentials newDefaultDriverPassword )
    {
        if ( newDefaultDriverPassword != defaultDriverPassword )
        {
            NotificationChain msgs = null;
            if ( defaultDriverPassword != null )
                msgs = ( (InternalEObject)defaultDriverPassword ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD, null, msgs );
            if ( newDefaultDriverPassword != null )
                msgs = ( (InternalEObject)newDefaultDriverPassword ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD, null, msgs );
            msgs = basicSetDefaultDriverPassword ( newDefaultDriverPassword, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD, newDefaultDriverPassword, newDefaultDriverPassword ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IndependentConfiguration> getApplicationConfigurations ()
    {
        if ( applicationConfigurations == null )
        {
            applicationConfigurations = new EObjectContainmentEList.Resolving<IndependentConfiguration> ( IndependentConfiguration.class, this, InfrastructurePackage.WORLD__APPLICATION_CONFIGURATIONS );
        }
        return applicationConfigurations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials getDefaultDriverAccessCredentials ()
    {
        if ( defaultDriverAccessCredentials != null && defaultDriverAccessCredentials.eIsProxy () )
        {
            InternalEObject oldDefaultDriverAccessCredentials = (InternalEObject)defaultDriverAccessCredentials;
            defaultDriverAccessCredentials = (Credentials)eResolveProxy ( oldDefaultDriverAccessCredentials );
            if ( defaultDriverAccessCredentials != oldDefaultDriverAccessCredentials )
            {
                InternalEObject newDefaultDriverAccessCredentials = (InternalEObject)defaultDriverAccessCredentials;
                NotificationChain msgs = oldDefaultDriverAccessCredentials.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS, null, null );
                if ( newDefaultDriverAccessCredentials.eInternalContainer () == null )
                {
                    msgs = newDefaultDriverAccessCredentials.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS, oldDefaultDriverAccessCredentials, defaultDriverAccessCredentials ) );
            }
        }
        return defaultDriverAccessCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials basicGetDefaultDriverAccessCredentials ()
    {
        return defaultDriverAccessCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefaultDriverAccessCredentials ( Credentials newDefaultDriverAccessCredentials, NotificationChain msgs )
    {
        Credentials oldDefaultDriverAccessCredentials = defaultDriverAccessCredentials;
        defaultDriverAccessCredentials = newDefaultDriverAccessCredentials;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS, oldDefaultDriverAccessCredentials, newDefaultDriverAccessCredentials );
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
    public void setDefaultDriverAccessCredentials ( Credentials newDefaultDriverAccessCredentials )
    {
        if ( newDefaultDriverAccessCredentials != defaultDriverAccessCredentials )
        {
            NotificationChain msgs = null;
            if ( defaultDriverAccessCredentials != null )
                msgs = ( (InternalEObject)defaultDriverAccessCredentials ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS, null, msgs );
            if ( newDefaultDriverAccessCredentials != null )
                msgs = ( (InternalEObject)newDefaultDriverAccessCredentials ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS, null, msgs );
            msgs = basicSetDefaultDriverAccessCredentials ( newDefaultDriverAccessCredentials, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS, newDefaultDriverAccessCredentials, newDefaultDriverAccessCredentials ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Configurations getConfigurations ()
    {
        if ( configurations != null && configurations.eIsProxy () )
        {
            InternalEObject oldConfigurations = (InternalEObject)configurations;
            configurations = (Configurations)eResolveProxy ( oldConfigurations );
            if ( configurations != oldConfigurations )
            {
                InternalEObject newConfigurations = (InternalEObject)configurations;
                NotificationChain msgs = oldConfigurations.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__CONFIGURATIONS, null, null );
                if ( newConfigurations.eInternalContainer () == null )
                {
                    msgs = newConfigurations.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__CONFIGURATIONS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.WORLD__CONFIGURATIONS, oldConfigurations, configurations ) );
            }
        }
        return configurations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Configurations basicGetConfigurations ()
    {
        return configurations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetConfigurations ( Configurations newConfigurations, NotificationChain msgs )
    {
        Configurations oldConfigurations = configurations;
        configurations = newConfigurations;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__CONFIGURATIONS, oldConfigurations, newConfigurations );
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
    public void setConfigurations ( Configurations newConfigurations )
    {
        if ( newConfigurations != configurations )
        {
            NotificationChain msgs = null;
            if ( configurations != null )
                msgs = ( (InternalEObject)configurations ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__CONFIGURATIONS, null, msgs );
            if ( newConfigurations != null )
                msgs = ( (InternalEObject)newConfigurations ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.WORLD__CONFIGURATIONS, null, msgs );
            msgs = basicSetConfigurations ( newConfigurations, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.WORLD__CONFIGURATIONS, newConfigurations, newConfigurations ) );
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
            case InfrastructurePackage.WORLD__NODES:
                return ( (InternalEList<?>)getNodes () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.WORLD__OPTIONS:
                return basicSetOptions ( null, msgs );
            case InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS:
                return basicSetDefaultCredentials ( null, msgs );
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD:
                return basicSetDefaultDriverPassword ( null, msgs );
            case InfrastructurePackage.WORLD__APPLICATION_CONFIGURATIONS:
                return ( (InternalEList<?>)getApplicationConfigurations () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS:
                return basicSetDefaultDriverAccessCredentials ( null, msgs );
            case InfrastructurePackage.WORLD__CONFIGURATIONS:
                return basicSetConfigurations ( null, msgs );
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
            case InfrastructurePackage.WORLD__NODES:
                return getNodes ();
            case InfrastructurePackage.WORLD__OPTIONS:
                if ( resolve )
                    return getOptions ();
                return basicGetOptions ();
            case InfrastructurePackage.WORLD__DEFAULT_SECURITY_CONFIGURATION:
                if ( resolve )
                    return getDefaultSecurityConfiguration ();
                return basicGetDefaultSecurityConfiguration ();
            case InfrastructurePackage.WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES:
                if ( resolve )
                    return getDefaultMasterHandlerPriorities ();
                return basicGetDefaultMasterHandlerPriorities ();
            case InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS:
                if ( resolve )
                    return getDefaultCredentials ();
                return basicGetDefaultCredentials ();
            case InfrastructurePackage.WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE:
                if ( resolve )
                    return getDefaultMasterCustomizationProfile ();
                return basicGetDefaultMasterCustomizationProfile ();
            case InfrastructurePackage.WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE:
                if ( resolve )
                    return getDefaultValueArchiveCustomizationProfile ();
                return basicGetDefaultValueArchiveCustomizationProfile ();
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD:
                if ( resolve )
                    return getDefaultDriverPassword ();
                return basicGetDefaultDriverPassword ();
            case InfrastructurePackage.WORLD__APPLICATION_CONFIGURATIONS:
                return getApplicationConfigurations ();
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS:
                if ( resolve )
                    return getDefaultDriverAccessCredentials ();
                return basicGetDefaultDriverAccessCredentials ();
            case InfrastructurePackage.WORLD__CONFIGURATIONS:
                if ( resolve )
                    return getConfigurations ();
                return basicGetConfigurations ();
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
            case InfrastructurePackage.WORLD__NODES:
                getNodes ().clear ();
                getNodes ().addAll ( (Collection<? extends Node>)newValue );
                return;
            case InfrastructurePackage.WORLD__OPTIONS:
                setOptions ( (Options)newValue );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_SECURITY_CONFIGURATION:
                setDefaultSecurityConfiguration ( (Configuration)newValue );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES:
                setDefaultMasterHandlerPriorities ( (MasterHandlerPriorities)newValue );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS:
                setDefaultCredentials ( (Credentials)newValue );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE:
                setDefaultMasterCustomizationProfile ( (Profile)newValue );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE:
                setDefaultValueArchiveCustomizationProfile ( (Profile)newValue );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD:
                setDefaultDriverPassword ( (PasswordCredentials)newValue );
                return;
            case InfrastructurePackage.WORLD__APPLICATION_CONFIGURATIONS:
                getApplicationConfigurations ().clear ();
                getApplicationConfigurations ().addAll ( (Collection<? extends IndependentConfiguration>)newValue );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS:
                setDefaultDriverAccessCredentials ( (Credentials)newValue );
                return;
            case InfrastructurePackage.WORLD__CONFIGURATIONS:
                setConfigurations ( (Configurations)newValue );
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
            case InfrastructurePackage.WORLD__NODES:
                getNodes ().clear ();
                return;
            case InfrastructurePackage.WORLD__OPTIONS:
                setOptions ( (Options)null );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_SECURITY_CONFIGURATION:
                setDefaultSecurityConfiguration ( (Configuration)null );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES:
                setDefaultMasterHandlerPriorities ( (MasterHandlerPriorities)null );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS:
                setDefaultCredentials ( (Credentials)null );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE:
                setDefaultMasterCustomizationProfile ( (Profile)null );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE:
                setDefaultValueArchiveCustomizationProfile ( (Profile)null );
                return;
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD:
                setDefaultDriverPassword ( (PasswordCredentials)null );
                return;
            case InfrastructurePackage.WORLD__APPLICATION_CONFIGURATIONS:
                getApplicationConfigurations ().clear ();
                return;
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS:
                setDefaultDriverAccessCredentials ( (Credentials)null );
                return;
            case InfrastructurePackage.WORLD__CONFIGURATIONS:
                setConfigurations ( (Configurations)null );
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
            case InfrastructurePackage.WORLD__NODES:
                return nodes != null && !nodes.isEmpty ();
            case InfrastructurePackage.WORLD__OPTIONS:
                return options != null;
            case InfrastructurePackage.WORLD__DEFAULT_SECURITY_CONFIGURATION:
                return defaultSecurityConfiguration != null;
            case InfrastructurePackage.WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES:
                return defaultMasterHandlerPriorities != null;
            case InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS:
                return defaultCredentials != null;
            case InfrastructurePackage.WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE:
                return defaultMasterCustomizationProfile != null;
            case InfrastructurePackage.WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE:
                return defaultValueArchiveCustomizationProfile != null;
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD:
                return defaultDriverPassword != null;
            case InfrastructurePackage.WORLD__APPLICATION_CONFIGURATIONS:
                return applicationConfigurations != null && !applicationConfigurations.isEmpty ();
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS:
                return defaultDriverAccessCredentials != null;
            case InfrastructurePackage.WORLD__CONFIGURATIONS:
                return configurations != null;
        }
        return super.eIsSet ( featureID );
    }

} //WorldImpl
