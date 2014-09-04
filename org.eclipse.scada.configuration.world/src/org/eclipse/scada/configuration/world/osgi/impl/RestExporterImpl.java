/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.osgi.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.RestExporter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rest Exporter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.RestExporterImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.RestExporterImpl#getHiveProperties <em>Hive Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.RestExporterImpl#getContextId <em>Context Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RestExporterImpl extends MinimalEObjectImpl.Container implements RestExporter
{
    /**
     * The cached value of the '{@link #getItems() <em>Items</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItems()
     * @generated
     * @ordered
     */
    protected EList<Item> items;

    /**
     * The cached value of the '{@link #getHiveProperties() <em>Hive Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHiveProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> hiveProperties;

    /**
     * The default value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextId()
     * @generated
     * @ordered
     */
    protected static final String CONTEXT_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContextId() <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextId()
     * @generated
     * @ordered
     */
    protected String contextId = CONTEXT_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RestExporterImpl ()
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
        return OsgiPackage.Literals.REST_EXPORTER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Item> getItems ()
    {
        if ( items == null )
        {
            items = new EObjectResolvingEList<Item> ( Item.class, this, OsgiPackage.REST_EXPORTER__ITEMS );
        }
        return items;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getHiveProperties ()
    {
        if ( hiveProperties == null )
        {
            hiveProperties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, OsgiPackage.REST_EXPORTER__HIVE_PROPERTIES );
        }
        return hiveProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getContextId ()
    {
        return contextId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContextId ( String newContextId )
    {
        String oldContextId = contextId;
        contextId = newContextId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.REST_EXPORTER__CONTEXT_ID, oldContextId, contextId ) );
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
            case OsgiPackage.REST_EXPORTER__HIVE_PROPERTIES:
                return ( (InternalEList<?>)getHiveProperties () ).basicRemove ( otherEnd, msgs );
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
            case OsgiPackage.REST_EXPORTER__ITEMS:
                return getItems ();
            case OsgiPackage.REST_EXPORTER__HIVE_PROPERTIES:
                return getHiveProperties ();
            case OsgiPackage.REST_EXPORTER__CONTEXT_ID:
                return getContextId ();
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
            case OsgiPackage.REST_EXPORTER__ITEMS:
                getItems ().clear ();
                getItems ().addAll ( (Collection<? extends Item>)newValue );
                return;
            case OsgiPackage.REST_EXPORTER__HIVE_PROPERTIES:
                getHiveProperties ().clear ();
                getHiveProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case OsgiPackage.REST_EXPORTER__CONTEXT_ID:
                setContextId ( (String)newValue );
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
            case OsgiPackage.REST_EXPORTER__ITEMS:
                getItems ().clear ();
                return;
            case OsgiPackage.REST_EXPORTER__HIVE_PROPERTIES:
                getHiveProperties ().clear ();
                return;
            case OsgiPackage.REST_EXPORTER__CONTEXT_ID:
                setContextId ( CONTEXT_ID_EDEFAULT );
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
            case OsgiPackage.REST_EXPORTER__ITEMS:
                return items != null && !items.isEmpty ();
            case OsgiPackage.REST_EXPORTER__HIVE_PROPERTIES:
                return hiveProperties != null && !hiveProperties.isEmpty ();
            case OsgiPackage.REST_EXPORTER__CONTEXT_ID:
                return CONTEXT_ID_EDEFAULT == null ? contextId != null : !CONTEXT_ID_EDEFAULT.equals ( contextId );
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
        result.append ( " (contextId: " ); //$NON-NLS-1$
        result.append ( contextId );
        result.append ( ')' );
        return result.toString ();
    }

} //RestExporterImpl
