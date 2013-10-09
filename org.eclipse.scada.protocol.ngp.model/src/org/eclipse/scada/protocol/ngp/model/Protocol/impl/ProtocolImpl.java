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
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getMessages
 * <em>Messages</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getStructures
 * <em>Structures</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getPackagePrefix
 * <em>Package Prefix</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getIncludedProtocols
 * <em>Included Protocols</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getLicenseHeader
 * <em>License Header</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getEnums
 * <em>Enums</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getInterfaces
 * <em>Interfaces</em>}</li>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl#getVersion
 * <em>Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProtocolImpl extends DocumentedElementImpl implements Protocol
{
    /**
     * The cached value of the '{@link #getMessages() <em>Messages</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getMessages()
     * @generated
     * @ordered
     */
    protected EList<Message> messages;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getStructures() <em>Structures</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getStructures()
     * @generated
     * @ordered
     */
    protected EList<Structure> structures;

    /**
     * The default value of the '{@link #getPackagePrefix()
     * <em>Package Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPackagePrefix()
     * @generated
     * @ordered
     */
    protected static final String PACKAGE_PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPackagePrefix()
     * <em>Package Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPackagePrefix()
     * @generated
     * @ordered
     */
    protected String packagePrefix = PACKAGE_PREFIX_EDEFAULT;

    /**
     * The cached value of the '{@link #getIncludedProtocols()
     * <em>Included Protocols</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getIncludedProtocols()
     * @generated
     * @ordered
     */
    protected EList<Protocol> includedProtocols;

    /**
     * The default value of the '{@link #getLicenseHeader()
     * <em>License Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getLicenseHeader()
     * @generated
     * @ordered
     */
    protected static final String LICENSE_HEADER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLicenseHeader()
     * <em>License Header</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getLicenseHeader()
     * @generated
     * @ordered
     */
    protected String licenseHeader = LICENSE_HEADER_EDEFAULT;

    /**
     * The cached value of the '{@link #getEnums() <em>Enums</em>}' containment
     * reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getEnums()
     * @generated
     * @ordered
     */
    protected EList<org.eclipse.scada.protocol.ngp.model.Protocol.Enum> enums;

    /**
     * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getInterfaces()
     * @generated
     * @ordered
     */
    protected EList<Interface> interfaces;

    /**
     * The default value of the '{@link #getVersion() <em>Version</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final short VERSION_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected short version = VERSION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProtocolImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
     * 
     * @generated
     */
    @Override
    public EList<Message> getMessages ()
    {
        if ( this.messages == null )
        {
            this.messages = new EObjectContainmentWithInverseEList.Resolving<Message> ( Message.class, this, ProtocolPackage.PROTOCOL__MESSAGES, ProtocolPackage.MESSAGE__PROTOCOL );
        }
        return this.messages;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName ()
    {
        return this.name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setName ( final String newName )
    {
        final String oldName = this.name;
        this.name = newName;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.PROTOCOL__NAME, oldName, this.name ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Protocol> getIncludedProtocols ()
    {
        if ( this.includedProtocols == null )
        {
            this.includedProtocols = new EObjectResolvingEList<Protocol> ( Protocol.class, this, ProtocolPackage.PROTOCOL__INCLUDED_PROTOCOLS );
        }
        return this.includedProtocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getLicenseHeader ()
    {
        return this.licenseHeader;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLicenseHeader ( final String newLicenseHeader )
    {
        final String oldLicenseHeader = this.licenseHeader;
        this.licenseHeader = newLicenseHeader;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.PROTOCOL__LICENSE_HEADER, oldLicenseHeader, this.licenseHeader ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<org.eclipse.scada.protocol.ngp.model.Protocol.Enum> getEnums ()
    {
        if ( this.enums == null )
        {
            this.enums = new EObjectContainmentWithInverseEList.Resolving<org.eclipse.scada.protocol.ngp.model.Protocol.Enum> ( org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, this, ProtocolPackage.PROTOCOL__ENUMS, ProtocolPackage.ENUM__PROTOCOL );
        }
        return this.enums;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Interface> getInterfaces ()
    {
        if ( this.interfaces == null )
        {
            this.interfaces = new EObjectContainmentWithInverseEList.Resolving<Interface> ( Interface.class, this, ProtocolPackage.PROTOCOL__INTERFACES, ProtocolPackage.INTERFACE__PROTOCOL );
        }
        return this.interfaces;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public short getVersion ()
    {
        return this.version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setVersion ( final short newVersion )
    {
        final short oldVersion = this.version;
        this.version = newVersion;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.PROTOCOL__VERSION, oldVersion, this.version ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<Structure> getStructures ()
    {
        if ( this.structures == null )
        {
            this.structures = new EObjectContainmentWithInverseEList.Resolving<Structure> ( Structure.class, this, ProtocolPackage.PROTOCOL__STRUCTURES, ProtocolPackage.STRUCTURE__PROTOCOL );
        }
        return this.structures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPackagePrefix ()
    {
        return this.packagePrefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPackagePrefix ( final String newPackagePrefix )
    {
        final String oldPackagePrefix = this.packagePrefix;
        this.packagePrefix = newPackagePrefix;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.PROTOCOL__PACKAGE_PREFIX, oldPackagePrefix, this.packagePrefix ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public NotificationChain eInverseAdd ( final InternalEObject otherEnd, final int featureID, final NotificationChain msgs )
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
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( final InternalEObject otherEnd, final int featureID, final NotificationChain msgs )
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
     * 
     * @generated
     */
    @Override
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
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
     * 
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( final int featureID, final Object newValue )
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
     * 
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
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
     * 
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case ProtocolPackage.PROTOCOL__MESSAGES:
                return this.messages != null && !this.messages.isEmpty ();
            case ProtocolPackage.PROTOCOL__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals ( this.name );
            case ProtocolPackage.PROTOCOL__STRUCTURES:
                return this.structures != null && !this.structures.isEmpty ();
            case ProtocolPackage.PROTOCOL__PACKAGE_PREFIX:
                return PACKAGE_PREFIX_EDEFAULT == null ? this.packagePrefix != null : !PACKAGE_PREFIX_EDEFAULT.equals ( this.packagePrefix );
            case ProtocolPackage.PROTOCOL__INCLUDED_PROTOCOLS:
                return this.includedProtocols != null && !this.includedProtocols.isEmpty ();
            case ProtocolPackage.PROTOCOL__LICENSE_HEADER:
                return LICENSE_HEADER_EDEFAULT == null ? this.licenseHeader != null : !LICENSE_HEADER_EDEFAULT.equals ( this.licenseHeader );
            case ProtocolPackage.PROTOCOL__ENUMS:
                return this.enums != null && !this.enums.isEmpty ();
            case ProtocolPackage.PROTOCOL__INTERFACES:
                return this.interfaces != null && !this.interfaces.isEmpty ();
            case ProtocolPackage.PROTOCOL__VERSION:
                return this.version != VERSION_EDEFAULT;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
        {
            return super.toString ();
        }

        final StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (name: " );
        result.append ( this.name );
        result.append ( ", packagePrefix: " );
        result.append ( this.packagePrefix );
        result.append ( ", licenseHeader: " );
        result.append ( this.licenseHeader );
        result.append ( ", version: " );
        result.append ( this.version );
        result.append ( ')' );
        return result.toString ();
    }

} //ProtocolImpl
