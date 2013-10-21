/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.Protocol.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.protocol.ngp.model.Protocol.Interface;
import org.eclipse.scada.protocol.ngp.model.Protocol.Message;
import org.eclipse.scada.protocol.ngp.model.Protocol.Protocol;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;
import org.eclipse.scada.protocol.ngp.model.Protocol.Structure;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getStructures <em>Structures</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getPackagePrefix <em>Package Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getIncludedProtocols <em>Included Protocols</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getLicenseHeader <em>License Header</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getEnums <em>Enums</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProtocolImpl extends DocumentedElementImpl implements Protocol
{
    /**
     * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessages()
     * @generated
     * @ordered
     */
    protected EList<Message> messages;

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
     * The cached value of the '{@link #getStructures() <em>Structures</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStructures()
     * @generated
     * @ordered
     */
    protected EList<Structure> structures;

    /**
     * The default value of the '{@link #getPackagePrefix() <em>Package Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPackagePrefix()
     * @generated
     * @ordered
     */
    protected static final String PACKAGE_PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPackagePrefix() <em>Package Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPackagePrefix()
     * @generated
     * @ordered
     */
    protected String packagePrefix = PACKAGE_PREFIX_EDEFAULT;

    /**
     * The cached value of the '{@link #getIncludedProtocols() <em>Included Protocols</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIncludedProtocols()
     * @generated
     * @ordered
     */
    protected EList<Protocol> includedProtocols;

    /**
     * The default value of the '{@link #getLicenseHeader() <em>License Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLicenseHeader()
     * @generated
     * @ordered
     */
    protected static final String LICENSE_HEADER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLicenseHeader() <em>License Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLicenseHeader()
     * @generated
     * @ordered
     */
    protected String licenseHeader = LICENSE_HEADER_EDEFAULT;

    /**
     * The cached value of the '{@link #getEnums() <em>Enums</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnums()
     * @generated
     * @ordered
     */
    protected EList<org.eclipse.scada.protocol.ngp.model.Protocol.Enum> enums;

    /**
     * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInterfaces()
     * @generated
     * @ordered
     */
    protected EList<Interface> interfaces;

    /**
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final short VERSION_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected short version = VERSION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProtocolImpl ()
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
        return ProtocolPackage.Literals.PROTOCOL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Message> getMessages ()
    {
        if ( messages == null )
        {
            messages = new EObjectContainmentWithInverseEList.Resolving<Message> ( Message.class, this, ProtocolPackage.PROTOCOL__MESSAGES, ProtocolPackage.MESSAGE__PROTOCOL );
        }
        return messages;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.PROTOCOL__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Protocol> getIncludedProtocols ()
    {
        if ( includedProtocols == null )
        {
            includedProtocols = new EObjectResolvingEList<Protocol> ( Protocol.class, this, ProtocolPackage.PROTOCOL__INCLUDED_PROTOCOLS );
        }
        return includedProtocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getLicenseHeader ()
    {
        return licenseHeader;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setLicenseHeader ( String newLicenseHeader )
    {
        String oldLicenseHeader = licenseHeader;
        licenseHeader = newLicenseHeader;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.PROTOCOL__LICENSE_HEADER, oldLicenseHeader, licenseHeader ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<org.eclipse.scada.protocol.ngp.model.Protocol.Enum> getEnums ()
    {
        if ( enums == null )
        {
            enums = new EObjectContainmentWithInverseEList.Resolving<org.eclipse.scada.protocol.ngp.model.Protocol.Enum> ( org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, this, ProtocolPackage.PROTOCOL__ENUMS, ProtocolPackage.ENUM__PROTOCOL );
        }
        return enums;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Interface> getInterfaces ()
    {
        if ( interfaces == null )
        {
            interfaces = new EObjectContainmentWithInverseEList.Resolving<Interface> ( Interface.class, this, ProtocolPackage.PROTOCOL__INTERFACES, ProtocolPackage.INTERFACE__PROTOCOL );
        }
        return interfaces;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public short getVersion ()
    {
        return version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setVersion ( short newVersion )
    {
        short oldVersion = version;
        version = newVersion;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.PROTOCOL__VERSION, oldVersion, version ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Structure> getStructures ()
    {
        if ( structures == null )
        {
            structures = new EObjectContainmentWithInverseEList.Resolving<Structure> ( Structure.class, this, ProtocolPackage.PROTOCOL__STRUCTURES, ProtocolPackage.STRUCTURE__PROTOCOL );
        }
        return structures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPackagePrefix ()
    {
        return packagePrefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPackagePrefix ( String newPackagePrefix )
    {
        String oldPackagePrefix = packagePrefix;
        packagePrefix = newPackagePrefix;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.PROTOCOL__PACKAGE_PREFIX, oldPackagePrefix, packagePrefix ) );
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
            case ProtocolPackage.PROTOCOL__MESSAGES:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getMessages () ).basicAdd ( otherEnd, msgs );
            case ProtocolPackage.PROTOCOL__STRUCTURES:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getStructures () ).basicAdd ( otherEnd, msgs );
            case ProtocolPackage.PROTOCOL__ENUMS:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getEnums () ).basicAdd ( otherEnd, msgs );
            case ProtocolPackage.PROTOCOL__INTERFACES:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getInterfaces () ).basicAdd ( otherEnd, msgs );
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
            case ProtocolPackage.PROTOCOL__MESSAGES:
                return ( (InternalEList<?>)getMessages () ).basicRemove ( otherEnd, msgs );
            case ProtocolPackage.PROTOCOL__STRUCTURES:
                return ( (InternalEList<?>)getStructures () ).basicRemove ( otherEnd, msgs );
            case ProtocolPackage.PROTOCOL__ENUMS:
                return ( (InternalEList<?>)getEnums () ).basicRemove ( otherEnd, msgs );
            case ProtocolPackage.PROTOCOL__INTERFACES:
                return ( (InternalEList<?>)getInterfaces () ).basicRemove ( otherEnd, msgs );
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
            case ProtocolPackage.PROTOCOL__MESSAGES:
                return getMessages ();
            case ProtocolPackage.PROTOCOL__NAME:
                return getName ();
            case ProtocolPackage.PROTOCOL__STRUCTURES:
                return getStructures ();
            case ProtocolPackage.PROTOCOL__PACKAGE_PREFIX:
                return getPackagePrefix ();
            case ProtocolPackage.PROTOCOL__INCLUDED_PROTOCOLS:
                return getIncludedProtocols ();
            case ProtocolPackage.PROTOCOL__LICENSE_HEADER:
                return getLicenseHeader ();
            case ProtocolPackage.PROTOCOL__ENUMS:
                return getEnums ();
            case ProtocolPackage.PROTOCOL__INTERFACES:
                return getInterfaces ();
            case ProtocolPackage.PROTOCOL__VERSION:
                return getVersion ();
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
            case ProtocolPackage.PROTOCOL__MESSAGES:
                getMessages ().clear ();
                getMessages ().addAll ( (Collection<? extends Message>)newValue );
                return;
            case ProtocolPackage.PROTOCOL__NAME:
                setName ( (String)newValue );
                return;
            case ProtocolPackage.PROTOCOL__STRUCTURES:
                getStructures ().clear ();
                getStructures ().addAll ( (Collection<? extends Structure>)newValue );
                return;
            case ProtocolPackage.PROTOCOL__PACKAGE_PREFIX:
                setPackagePrefix ( (String)newValue );
                return;
            case ProtocolPackage.PROTOCOL__INCLUDED_PROTOCOLS:
                getIncludedProtocols ().clear ();
                getIncludedProtocols ().addAll ( (Collection<? extends Protocol>)newValue );
                return;
            case ProtocolPackage.PROTOCOL__LICENSE_HEADER:
                setLicenseHeader ( (String)newValue );
                return;
            case ProtocolPackage.PROTOCOL__ENUMS:
                getEnums ().clear ();
                getEnums ().addAll ( (Collection<? extends org.eclipse.scada.protocol.ngp.model.Protocol.Enum>)newValue );
                return;
            case ProtocolPackage.PROTOCOL__INTERFACES:
                getInterfaces ().clear ();
                getInterfaces ().addAll ( (Collection<? extends Interface>)newValue );
                return;
            case ProtocolPackage.PROTOCOL__VERSION:
                setVersion ( (Short)newValue );
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
            case ProtocolPackage.PROTOCOL__MESSAGES:
                getMessages ().clear ();
                return;
            case ProtocolPackage.PROTOCOL__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ProtocolPackage.PROTOCOL__STRUCTURES:
                getStructures ().clear ();
                return;
            case ProtocolPackage.PROTOCOL__PACKAGE_PREFIX:
                setPackagePrefix ( PACKAGE_PREFIX_EDEFAULT );
                return;
            case ProtocolPackage.PROTOCOL__INCLUDED_PROTOCOLS:
                getIncludedProtocols ().clear ();
                return;
            case ProtocolPackage.PROTOCOL__LICENSE_HEADER:
                setLicenseHeader ( LICENSE_HEADER_EDEFAULT );
                return;
            case ProtocolPackage.PROTOCOL__ENUMS:
                getEnums ().clear ();
                return;
            case ProtocolPackage.PROTOCOL__INTERFACES:
                getInterfaces ().clear ();
                return;
            case ProtocolPackage.PROTOCOL__VERSION:
                setVersion ( VERSION_EDEFAULT );
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
            case ProtocolPackage.PROTOCOL__MESSAGES:
                return messages != null && !messages.isEmpty ();
            case ProtocolPackage.PROTOCOL__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ProtocolPackage.PROTOCOL__STRUCTURES:
                return structures != null && !structures.isEmpty ();
            case ProtocolPackage.PROTOCOL__PACKAGE_PREFIX:
                return PACKAGE_PREFIX_EDEFAULT == null ? packagePrefix != null : !PACKAGE_PREFIX_EDEFAULT.equals ( packagePrefix );
            case ProtocolPackage.PROTOCOL__INCLUDED_PROTOCOLS:
                return includedProtocols != null && !includedProtocols.isEmpty ();
            case ProtocolPackage.PROTOCOL__LICENSE_HEADER:
                return LICENSE_HEADER_EDEFAULT == null ? licenseHeader != null : !LICENSE_HEADER_EDEFAULT.equals ( licenseHeader );
            case ProtocolPackage.PROTOCOL__ENUMS:
                return enums != null && !enums.isEmpty ();
            case ProtocolPackage.PROTOCOL__INTERFACES:
                return interfaces != null && !interfaces.isEmpty ();
            case ProtocolPackage.PROTOCOL__VERSION:
                return version != VERSION_EDEFAULT;
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", packagePrefix: " ); //$NON-NLS-1$
        result.append ( packagePrefix );
        result.append ( ", licenseHeader: " ); //$NON-NLS-1$
        result.append ( licenseHeader );
        result.append ( ", version: " ); //$NON-NLS-1$
        result.append ( version );
        result.append ( ')' );
        return result.toString ();
    }

} //ProtocolImpl
