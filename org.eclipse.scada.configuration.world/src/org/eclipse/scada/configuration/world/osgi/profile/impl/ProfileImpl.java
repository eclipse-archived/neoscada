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
package org.eclipse.scada.configuration.world.osgi.profile.impl;

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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.osgi.profile.BundleStartLevel;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfilePackage;
import org.eclipse.scada.configuration.world.osgi.profile.StartBundle;
import org.eclipse.scada.configuration.world.osgi.profile.SubProfile;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Profile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getInstallationUnits <em>Installation Units</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getJvmArguments <em>Jvm Arguments</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getSetbsl <em>Setbsl</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getProfile <em>Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.profile.impl.ProfileImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProfileImpl extends MinimalEObjectImpl.Container implements
        Profile
{
    /**
     * The cached value of the '{@link #getInstallationUnits() <em>Installation Units</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInstallationUnits()
     * @generated
     * @ordered
     */
    protected EList<String> installationUnits;

    /**
     * The cached value of the '{@link #getJvmArguments() <em>Jvm Arguments</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJvmArguments()
     * @generated
     * @ordered
     */
    protected EList<String> jvmArguments;

    /**
     * The cached value of the '{@link #getStart() <em>Start</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStart()
     * @generated
     * @ordered
     */
    protected EList<StartBundle> start;

    /**
     * The cached value of the '{@link #getSetbsl() <em>Setbsl</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSetbsl()
     * @generated
     * @ordered
     */
    protected EList<BundleStartLevel> setbsl;

    /**
     * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperty()
     * @generated
     * @ordered
     */
    protected EList<SystemProperty> property;

    /**
     * The cached value of the '{@link #getNotes() <em>Notes</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNotes()
     * @generated
     * @ordered
     */
    protected EList<String> notes;

    /**
     * The cached value of the '{@link #getProfile() <em>Profile</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProfile()
     * @generated
     * @ordered
     */
    protected EList<SubProfile> profile;

    /**
     * The cached value of the '{@link #getIncludes() <em>Includes</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncludes()
     * @generated
     * @ordered
     */
    protected EList<Profile> includes;

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
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getArguments() <em>Arguments</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArguments()
     * @generated
     * @ordered
     */
    protected EList<String> arguments;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProfileImpl ()
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
        return ProfilePackage.Literals.PROFILE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SubProfile> getProfile ()
    {
        if ( profile == null )
        {
            profile = new EObjectContainmentEList.Resolving<SubProfile> ( SubProfile.class, this, ProfilePackage.PROFILE__PROFILE );
        }
        return profile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Profile> getIncludes ()
    {
        if ( includes == null )
        {
            includes = new EObjectResolvingEList<Profile> ( Profile.class, this, ProfilePackage.PROFILE__INCLUDES );
        }
        return includes;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProfilePackage.PROFILE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription ( String newDescription )
    {
        String oldDescription = description;
        description = newDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProfilePackage.PROFILE__DESCRIPTION, oldDescription, description ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getArguments ()
    {
        if ( arguments == null )
        {
            arguments = new EDataTypeUniqueEList<String> ( String.class, this, ProfilePackage.PROFILE__ARGUMENTS );
        }
        return arguments;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<StartBundle> getStart ()
    {
        if ( start == null )
        {
            start = new EObjectContainmentEList.Resolving<StartBundle> ( StartBundle.class, this, ProfilePackage.PROFILE__START );
        }
        return start;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<SystemProperty> getProperty ()
    {
        if ( property == null )
        {
            property = new EObjectContainmentEList.Resolving<SystemProperty> ( SystemProperty.class, this, ProfilePackage.PROFILE__PROPERTY );
        }
        return property;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<BundleStartLevel> getSetbsl ()
    {
        if ( setbsl == null )
        {
            setbsl = new EObjectContainmentEList.Resolving<BundleStartLevel> ( BundleStartLevel.class, this, ProfilePackage.PROFILE__SETBSL );
        }
        return setbsl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getNotes ()
    {
        if ( notes == null )
        {
            notes = new EDataTypeUniqueEList<String> ( String.class, this, ProfilePackage.PROFILE__NOTES );
        }
        return notes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getInstallationUnits ()
    {
        if ( installationUnits == null )
        {
            installationUnits = new EDataTypeUniqueEList<String> ( String.class, this, ProfilePackage.PROFILE__INSTALLATION_UNITS );
        }
        return installationUnits;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getJvmArguments ()
    {
        if ( jvmArguments == null )
        {
            jvmArguments = new EDataTypeUniqueEList<String> ( String.class, this, ProfilePackage.PROFILE__JVM_ARGUMENTS );
        }
        return jvmArguments;
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
            case ProfilePackage.PROFILE__START:
                return ( (InternalEList<?>)getStart () ).basicRemove ( otherEnd, msgs );
            case ProfilePackage.PROFILE__SETBSL:
                return ( (InternalEList<?>)getSetbsl () ).basicRemove ( otherEnd, msgs );
            case ProfilePackage.PROFILE__PROPERTY:
                return ( (InternalEList<?>)getProperty () ).basicRemove ( otherEnd, msgs );
            case ProfilePackage.PROFILE__PROFILE:
                return ( (InternalEList<?>)getProfile () ).basicRemove ( otherEnd, msgs );
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
            case ProfilePackage.PROFILE__INSTALLATION_UNITS:
                return getInstallationUnits ();
            case ProfilePackage.PROFILE__JVM_ARGUMENTS:
                return getJvmArguments ();
            case ProfilePackage.PROFILE__START:
                return getStart ();
            case ProfilePackage.PROFILE__SETBSL:
                return getSetbsl ();
            case ProfilePackage.PROFILE__PROPERTY:
                return getProperty ();
            case ProfilePackage.PROFILE__NOTES:
                return getNotes ();
            case ProfilePackage.PROFILE__PROFILE:
                return getProfile ();
            case ProfilePackage.PROFILE__INCLUDES:
                return getIncludes ();
            case ProfilePackage.PROFILE__NAME:
                return getName ();
            case ProfilePackage.PROFILE__DESCRIPTION:
                return getDescription ();
            case ProfilePackage.PROFILE__ARGUMENTS:
                return getArguments ();
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
            case ProfilePackage.PROFILE__INSTALLATION_UNITS:
                getInstallationUnits ().clear ();
                getInstallationUnits ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ProfilePackage.PROFILE__JVM_ARGUMENTS:
                getJvmArguments ().clear ();
                getJvmArguments ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ProfilePackage.PROFILE__START:
                getStart ().clear ();
                getStart ().addAll ( (Collection<? extends StartBundle>)newValue );
                return;
            case ProfilePackage.PROFILE__SETBSL:
                getSetbsl ().clear ();
                getSetbsl ().addAll ( (Collection<? extends BundleStartLevel>)newValue );
                return;
            case ProfilePackage.PROFILE__PROPERTY:
                getProperty ().clear ();
                getProperty ().addAll ( (Collection<? extends SystemProperty>)newValue );
                return;
            case ProfilePackage.PROFILE__NOTES:
                getNotes ().clear ();
                getNotes ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ProfilePackage.PROFILE__PROFILE:
                getProfile ().clear ();
                getProfile ().addAll ( (Collection<? extends SubProfile>)newValue );
                return;
            case ProfilePackage.PROFILE__INCLUDES:
                getIncludes ().clear ();
                getIncludes ().addAll ( (Collection<? extends Profile>)newValue );
                return;
            case ProfilePackage.PROFILE__NAME:
                setName ( (String)newValue );
                return;
            case ProfilePackage.PROFILE__DESCRIPTION:
                setDescription ( (String)newValue );
                return;
            case ProfilePackage.PROFILE__ARGUMENTS:
                getArguments ().clear ();
                getArguments ().addAll ( (Collection<? extends String>)newValue );
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
            case ProfilePackage.PROFILE__INSTALLATION_UNITS:
                getInstallationUnits ().clear ();
                return;
            case ProfilePackage.PROFILE__JVM_ARGUMENTS:
                getJvmArguments ().clear ();
                return;
            case ProfilePackage.PROFILE__START:
                getStart ().clear ();
                return;
            case ProfilePackage.PROFILE__SETBSL:
                getSetbsl ().clear ();
                return;
            case ProfilePackage.PROFILE__PROPERTY:
                getProperty ().clear ();
                return;
            case ProfilePackage.PROFILE__NOTES:
                getNotes ().clear ();
                return;
            case ProfilePackage.PROFILE__PROFILE:
                getProfile ().clear ();
                return;
            case ProfilePackage.PROFILE__INCLUDES:
                getIncludes ().clear ();
                return;
            case ProfilePackage.PROFILE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ProfilePackage.PROFILE__DESCRIPTION:
                setDescription ( DESCRIPTION_EDEFAULT );
                return;
            case ProfilePackage.PROFILE__ARGUMENTS:
                getArguments ().clear ();
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
            case ProfilePackage.PROFILE__INSTALLATION_UNITS:
                return installationUnits != null && !installationUnits.isEmpty ();
            case ProfilePackage.PROFILE__JVM_ARGUMENTS:
                return jvmArguments != null && !jvmArguments.isEmpty ();
            case ProfilePackage.PROFILE__START:
                return start != null && !start.isEmpty ();
            case ProfilePackage.PROFILE__SETBSL:
                return setbsl != null && !setbsl.isEmpty ();
            case ProfilePackage.PROFILE__PROPERTY:
                return property != null && !property.isEmpty ();
            case ProfilePackage.PROFILE__NOTES:
                return notes != null && !notes.isEmpty ();
            case ProfilePackage.PROFILE__PROFILE:
                return profile != null && !profile.isEmpty ();
            case ProfilePackage.PROFILE__INCLUDES:
                return includes != null && !includes.isEmpty ();
            case ProfilePackage.PROFILE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ProfilePackage.PROFILE__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals ( description );
            case ProfilePackage.PROFILE__ARGUMENTS:
                return arguments != null && !arguments.isEmpty ();
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
        result.append ( " (installationUnits: " ); //$NON-NLS-1$
        result.append ( installationUnits );
        result.append ( ", jvmArguments: " ); //$NON-NLS-1$
        result.append ( jvmArguments );
        result.append ( ", notes: " ); //$NON-NLS-1$
        result.append ( notes );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", description: " ); //$NON-NLS-1$
        result.append ( description );
        result.append ( ", arguments: " ); //$NON-NLS-1$
        result.append ( arguments );
        result.append ( ')' );
        return result.toString ();
    }

} //ProfileImpl
