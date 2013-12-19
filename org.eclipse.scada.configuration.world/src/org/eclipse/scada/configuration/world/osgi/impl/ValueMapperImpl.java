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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.world.osgi.DataMapper;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.ValueMapper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Mapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueMapperImpl#getSourceAttribute <em>Source Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueMapperImpl#getTargetAttribute <em>Target Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ValueMapperImpl#getDataMapper <em>Data Mapper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueMapperImpl extends ItemFeatureEntryImpl implements
        ValueMapper
{
    /**
     * The default value of the '{@link #getSourceAttribute() <em>Source Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceAttribute()
     * @generated
     * @ordered
     */
    protected static final String SOURCE_ATTRIBUTE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSourceAttribute() <em>Source Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceAttribute()
     * @generated
     * @ordered
     */
    protected String sourceAttribute = SOURCE_ATTRIBUTE_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetAttribute() <em>Target Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetAttribute()
     * @generated
     * @ordered
     */
    protected static final String TARGET_ATTRIBUTE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTargetAttribute() <em>Target Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetAttribute()
     * @generated
     * @ordered
     */
    protected String targetAttribute = TARGET_ATTRIBUTE_EDEFAULT;

    /**
     * The cached value of the '{@link #getDataMapper() <em>Data Mapper</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataMapper()
     * @generated
     * @ordered
     */
    protected DataMapper dataMapper;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValueMapperImpl ()
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
        return OsgiPackage.Literals.VALUE_MAPPER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSourceAttribute ()
    {
        return sourceAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceAttribute ( String newSourceAttribute )
    {
        String oldSourceAttribute = sourceAttribute;
        sourceAttribute = newSourceAttribute;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.VALUE_MAPPER__SOURCE_ATTRIBUTE, oldSourceAttribute, sourceAttribute ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTargetAttribute ()
    {
        return targetAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetAttribute ( String newTargetAttribute )
    {
        String oldTargetAttribute = targetAttribute;
        targetAttribute = newTargetAttribute;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.VALUE_MAPPER__TARGET_ATTRIBUTE, oldTargetAttribute, targetAttribute ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapper getDataMapper ()
    {
        if ( dataMapper != null && dataMapper.eIsProxy () )
        {
            InternalEObject oldDataMapper = (InternalEObject)dataMapper;
            dataMapper = (DataMapper)eResolveProxy ( oldDataMapper );
            if ( dataMapper != oldDataMapper )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.VALUE_MAPPER__DATA_MAPPER, oldDataMapper, dataMapper ) );
            }
        }
        return dataMapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapper basicGetDataMapper ()
    {
        return dataMapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataMapper ( DataMapper newDataMapper )
    {
        DataMapper oldDataMapper = dataMapper;
        dataMapper = newDataMapper;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.VALUE_MAPPER__DATA_MAPPER, oldDataMapper, dataMapper ) );
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
            case OsgiPackage.VALUE_MAPPER__SOURCE_ATTRIBUTE:
                return getSourceAttribute ();
            case OsgiPackage.VALUE_MAPPER__TARGET_ATTRIBUTE:
                return getTargetAttribute ();
            case OsgiPackage.VALUE_MAPPER__DATA_MAPPER:
                if ( resolve )
                    return getDataMapper ();
                return basicGetDataMapper ();
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
            case OsgiPackage.VALUE_MAPPER__SOURCE_ATTRIBUTE:
                setSourceAttribute ( (String)newValue );
                return;
            case OsgiPackage.VALUE_MAPPER__TARGET_ATTRIBUTE:
                setTargetAttribute ( (String)newValue );
                return;
            case OsgiPackage.VALUE_MAPPER__DATA_MAPPER:
                setDataMapper ( (DataMapper)newValue );
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
            case OsgiPackage.VALUE_MAPPER__SOURCE_ATTRIBUTE:
                setSourceAttribute ( SOURCE_ATTRIBUTE_EDEFAULT );
                return;
            case OsgiPackage.VALUE_MAPPER__TARGET_ATTRIBUTE:
                setTargetAttribute ( TARGET_ATTRIBUTE_EDEFAULT );
                return;
            case OsgiPackage.VALUE_MAPPER__DATA_MAPPER:
                setDataMapper ( (DataMapper)null );
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
            case OsgiPackage.VALUE_MAPPER__SOURCE_ATTRIBUTE:
                return SOURCE_ATTRIBUTE_EDEFAULT == null ? sourceAttribute != null : !SOURCE_ATTRIBUTE_EDEFAULT.equals ( sourceAttribute );
            case OsgiPackage.VALUE_MAPPER__TARGET_ATTRIBUTE:
                return TARGET_ATTRIBUTE_EDEFAULT == null ? targetAttribute != null : !TARGET_ATTRIBUTE_EDEFAULT.equals ( targetAttribute );
            case OsgiPackage.VALUE_MAPPER__DATA_MAPPER:
                return dataMapper != null;
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
        result.append ( " (sourceAttribute: " ); //$NON-NLS-1$
        result.append ( sourceAttribute );
        result.append ( ", targetAttribute: " ); //$NON-NLS-1$
        result.append ( targetAttribute );
        result.append ( ')' );
        return result.toString ();
    }

} //ValueMapperImpl
