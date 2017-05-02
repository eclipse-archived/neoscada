/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.da.server.exporter.ConfigurationType;
import org.eclipse.scada.da.server.exporter.DocumentRoot;
import org.eclipse.scada.da.server.exporter.ExporterPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.exporter.impl.DocumentRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.exporter.impl.DocumentRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.exporter.impl.DocumentRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.exporter.impl.DocumentRootImpl#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DocumentRootImpl extends MinimalEObjectImpl.Container implements DocumentRoot
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMixed()
     * @generated
     * @ordered
     */
    protected FeatureMap mixed;

    /**
     * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXMLNSPrefixMap()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xMLNSPrefixMap;

    /**
     * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getXSISchemaLocation()
     * @generated
     * @ordered
     */
    protected EMap<String, String> xSISchemaLocation;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DocumentRootImpl ()
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
        return ExporterPackage.Literals.DOCUMENT_ROOT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getMixed ()
    {
        if ( mixed == null )
        {
            mixed = new BasicFeatureMap ( this, ExporterPackage.DOCUMENT_ROOT__MIXED );
        }
        return mixed;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getXMLNSPrefixMap ()
    {
        if ( xMLNSPrefixMap == null )
        {
            xMLNSPrefixMap = new EcoreEMap<String, String> ( EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ExporterPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP );
        }
        return xMLNSPrefixMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getXSISchemaLocation ()
    {
        if ( xSISchemaLocation == null )
        {
            xSISchemaLocation = new EcoreEMap<String, String> ( EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ExporterPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION );
        }
        return xSISchemaLocation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationType getConfiguration ()
    {
        return (ConfigurationType)getMixed ().get ( ExporterPackage.Literals.DOCUMENT_ROOT__CONFIGURATION, true );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetConfiguration ( ConfigurationType newConfiguration, NotificationChain msgs )
    {
        return ( (FeatureMap.Internal)getMixed () ).basicAdd ( ExporterPackage.Literals.DOCUMENT_ROOT__CONFIGURATION, newConfiguration, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConfiguration ( ConfigurationType newConfiguration )
    {
        ( (FeatureMap.Internal)getMixed () ).set ( ExporterPackage.Literals.DOCUMENT_ROOT__CONFIGURATION, newConfiguration );
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
            case ExporterPackage.DOCUMENT_ROOT__MIXED:
                return ( (InternalEList<?>)getMixed () ).basicRemove ( otherEnd, msgs );
            case ExporterPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                return ( (InternalEList<?>)getXMLNSPrefixMap () ).basicRemove ( otherEnd, msgs );
            case ExporterPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                return ( (InternalEList<?>)getXSISchemaLocation () ).basicRemove ( otherEnd, msgs );
            case ExporterPackage.DOCUMENT_ROOT__CONFIGURATION:
                return basicSetConfiguration ( null, msgs );
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
            case ExporterPackage.DOCUMENT_ROOT__MIXED:
                if ( coreType )
                    return getMixed ();
                return ( (FeatureMap.Internal)getMixed () ).getWrapper ();
            case ExporterPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                if ( coreType )
                    return getXMLNSPrefixMap ();
                else
                    return getXMLNSPrefixMap ().map ();
            case ExporterPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                if ( coreType )
                    return getXSISchemaLocation ();
                else
                    return getXSISchemaLocation ().map ();
            case ExporterPackage.DOCUMENT_ROOT__CONFIGURATION:
                return getConfiguration ();
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
            case ExporterPackage.DOCUMENT_ROOT__MIXED:
                ( (FeatureMap.Internal)getMixed () ).set ( newValue );
                return;
            case ExporterPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                ( (EStructuralFeature.Setting)getXMLNSPrefixMap () ).set ( newValue );
                return;
            case ExporterPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                ( (EStructuralFeature.Setting)getXSISchemaLocation () ).set ( newValue );
                return;
            case ExporterPackage.DOCUMENT_ROOT__CONFIGURATION:
                setConfiguration ( (ConfigurationType)newValue );
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
            case ExporterPackage.DOCUMENT_ROOT__MIXED:
                getMixed ().clear ();
                return;
            case ExporterPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                getXMLNSPrefixMap ().clear ();
                return;
            case ExporterPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                getXSISchemaLocation ().clear ();
                return;
            case ExporterPackage.DOCUMENT_ROOT__CONFIGURATION:
                setConfiguration ( (ConfigurationType)null );
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
            case ExporterPackage.DOCUMENT_ROOT__MIXED:
                return mixed != null && !mixed.isEmpty ();
            case ExporterPackage.DOCUMENT_ROOT__XMLNS_PREFIX_MAP:
                return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty ();
            case ExporterPackage.DOCUMENT_ROOT__XSI_SCHEMA_LOCATION:
                return xSISchemaLocation != null && !xSISchemaLocation.isEmpty ();
            case ExporterPackage.DOCUMENT_ROOT__CONFIGURATION:
                return getConfiguration () != null;
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
        result.append ( " (mixed: " ); //$NON-NLS-1$
        result.append ( mixed );
        result.append ( ')' );
        return result.toString ();
    }

} //DocumentRootImpl
