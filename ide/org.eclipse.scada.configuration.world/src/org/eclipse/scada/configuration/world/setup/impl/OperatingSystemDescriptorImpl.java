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
package org.eclipse.scada.configuration.world.setup.impl;

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

import org.eclipse.scada.configuration.world.PropertyEntry;

import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operating System Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.impl.OperatingSystemDescriptorImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.impl.OperatingSystemDescriptorImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.impl.OperatingSystemDescriptorImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.impl.OperatingSystemDescriptorImpl#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperatingSystemDescriptorImpl extends MinimalEObjectImpl.Container implements OperatingSystemDescriptor
{
    /**
     * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParent()
     * @generated
     * @ordered
     */
    protected OperatingSystemDescriptor parent;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> properties;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OperatingSystemDescriptorImpl ()
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
        return SetupPackage.Literals.OPERATING_SYSTEM_DESCRIPTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperatingSystemDescriptor getParent ()
    {
        if ( parent != null && parent.eIsProxy () )
        {
            InternalEObject oldParent = (InternalEObject)parent;
            parent = (OperatingSystemDescriptor)eResolveProxy ( oldParent );
            if ( parent != oldParent )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PARENT, oldParent, parent ) );
            }
        }
        return parent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperatingSystemDescriptor basicGetParent ()
    {
        return parent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParent ( OperatingSystemDescriptor newParent )
    {
        OperatingSystemDescriptor oldParent = parent;
        parent = newParent;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PARENT, oldParent, parent ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PROPERTIES );
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLabel ()
    {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel ( String newLabel )
    {
        String oldLabel = label;
        label = newLabel;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__LABEL, oldLabel, label ) );
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
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PROPERTIES:
                return ( (InternalEList<?>)getProperties () ).basicRemove ( otherEnd, msgs );
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
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PARENT:
                if ( resolve )
                    return getParent ();
                return basicGetParent ();
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PROPERTIES:
                return getProperties ();
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__ID:
                return getId ();
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__LABEL:
                return getLabel ();
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
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PARENT:
                setParent ( (OperatingSystemDescriptor)newValue );
                return;
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PROPERTIES:
                getProperties ().clear ();
                getProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__ID:
                setId ( (String)newValue );
                return;
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__LABEL:
                setLabel ( (String)newValue );
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
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PARENT:
                setParent ( (OperatingSystemDescriptor)null );
                return;
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PROPERTIES:
                getProperties ().clear ();
                return;
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__ID:
                setId ( ID_EDEFAULT );
                return;
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__LABEL:
                setLabel ( LABEL_EDEFAULT );
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
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PARENT:
                return parent != null;
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__PROPERTIES:
                return properties != null && !properties.isEmpty ();
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case SetupPackage.OPERATING_SYSTEM_DESCRIPTOR__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals ( label );
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
        result.append ( " (id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ", label: " ); //$NON-NLS-1$
        result.append ( label );
        result.append ( ')' );
        return result.toString ();
    }

} //OperatingSystemDescriptorImpl
