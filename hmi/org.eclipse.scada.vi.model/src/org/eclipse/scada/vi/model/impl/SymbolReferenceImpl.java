/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.vi.model.SymbolReference;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbol Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolReferenceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolReferenceImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolReferenceImpl#getZoom <em>Zoom</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolReferenceImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolReferenceImpl#getOnCreateProperties <em>On Create Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SymbolReferenceImpl extends EObjectImpl implements SymbolReference
{
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
     * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected static final String URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected String uri = URI_EDEFAULT;

    /**
     * The default value of the '{@link #getZoom() <em>Zoom</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getZoom()
     * @generated
     * @ordered
     */
    protected static final Double ZOOM_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getZoom() <em>Zoom</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getZoom()
     * @generated
     * @ordered
     */
    protected Double zoom = ZOOM_EDEFAULT;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EMap<String, String> properties;

    /**
     * The default value of the '{@link #getOnCreateProperties() <em>On Create Properties</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnCreateProperties()
     * @generated
     * @ordered
     */
    protected static final String ON_CREATE_PROPERTIES_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnCreateProperties() <em>On Create Properties</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnCreateProperties()
     * @generated
     * @ordered
     */
    protected String onCreateProperties = ON_CREATE_PROPERTIES_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SymbolReferenceImpl ()
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
        return VisualInterfacePackage.Literals.SYMBOL_REFERENCE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL_REFERENCE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUri ()
    {
        return uri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUri ( String newUri )
    {
        String oldUri = uri;
        uri = newUri;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL_REFERENCE__URI, oldUri, uri ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Double getZoom ()
    {
        return zoom;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setZoom ( Double newZoom )
    {
        Double oldZoom = zoom;
        zoom = newZoom;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL_REFERENCE__ZOOM, oldZoom, zoom ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EcoreEMap<String, String> ( VisualInterfacePackage.Literals.STRING_TO_STRING_MAP, StringToStringMapImpl.class, this, VisualInterfacePackage.SYMBOL_REFERENCE__PROPERTIES );
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOnCreateProperties ()
    {
        return onCreateProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnCreateProperties ( String newOnCreateProperties )
    {
        String oldOnCreateProperties = onCreateProperties;
        onCreateProperties = newOnCreateProperties;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL_REFERENCE__ON_CREATE_PROPERTIES, oldOnCreateProperties, onCreateProperties ) );
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
            case VisualInterfacePackage.SYMBOL_REFERENCE__PROPERTIES:
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
            case VisualInterfacePackage.SYMBOL_REFERENCE__NAME:
                return getName ();
            case VisualInterfacePackage.SYMBOL_REFERENCE__URI:
                return getUri ();
            case VisualInterfacePackage.SYMBOL_REFERENCE__ZOOM:
                return getZoom ();
            case VisualInterfacePackage.SYMBOL_REFERENCE__PROPERTIES:
                if ( coreType )
                    return getProperties ();
                else
                    return getProperties ().map ();
            case VisualInterfacePackage.SYMBOL_REFERENCE__ON_CREATE_PROPERTIES:
                return getOnCreateProperties ();
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
            case VisualInterfacePackage.SYMBOL_REFERENCE__NAME:
                setName ( (String)newValue );
                return;
            case VisualInterfacePackage.SYMBOL_REFERENCE__URI:
                setUri ( (String)newValue );
                return;
            case VisualInterfacePackage.SYMBOL_REFERENCE__ZOOM:
                setZoom ( (Double)newValue );
                return;
            case VisualInterfacePackage.SYMBOL_REFERENCE__PROPERTIES:
                ( (EStructuralFeature.Setting)getProperties () ).set ( newValue );
                return;
            case VisualInterfacePackage.SYMBOL_REFERENCE__ON_CREATE_PROPERTIES:
                setOnCreateProperties ( (String)newValue );
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
            case VisualInterfacePackage.SYMBOL_REFERENCE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case VisualInterfacePackage.SYMBOL_REFERENCE__URI:
                setUri ( URI_EDEFAULT );
                return;
            case VisualInterfacePackage.SYMBOL_REFERENCE__ZOOM:
                setZoom ( ZOOM_EDEFAULT );
                return;
            case VisualInterfacePackage.SYMBOL_REFERENCE__PROPERTIES:
                getProperties ().clear ();
                return;
            case VisualInterfacePackage.SYMBOL_REFERENCE__ON_CREATE_PROPERTIES:
                setOnCreateProperties ( ON_CREATE_PROPERTIES_EDEFAULT );
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
            case VisualInterfacePackage.SYMBOL_REFERENCE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case VisualInterfacePackage.SYMBOL_REFERENCE__URI:
                return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals ( uri );
            case VisualInterfacePackage.SYMBOL_REFERENCE__ZOOM:
                return ZOOM_EDEFAULT == null ? zoom != null : !ZOOM_EDEFAULT.equals ( zoom );
            case VisualInterfacePackage.SYMBOL_REFERENCE__PROPERTIES:
                return properties != null && !properties.isEmpty ();
            case VisualInterfacePackage.SYMBOL_REFERENCE__ON_CREATE_PROPERTIES:
                return ON_CREATE_PROPERTIES_EDEFAULT == null ? onCreateProperties != null : !ON_CREATE_PROPERTIES_EDEFAULT.equals ( onCreateProperties );
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
        result.append ( ", uri: " ); //$NON-NLS-1$
        result.append ( uri );
        result.append ( ", zoom: " ); //$NON-NLS-1$
        result.append ( zoom );
        result.append ( ", onCreateProperties: " ); //$NON-NLS-1$
        result.append ( onCreateProperties );
        result.append ( ')' );
        return result.toString ();
    }

} //SymbolReferenceImpl
