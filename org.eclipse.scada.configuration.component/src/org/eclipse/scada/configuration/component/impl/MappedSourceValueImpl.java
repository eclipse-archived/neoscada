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
package org.eclipse.scada.configuration.component.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.MappedSourceValue;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Source Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getMapper <em>Mapper</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getInput <em>Input</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappedSourceValueImpl extends DataComponentImpl implements MappedSourceValue
{
    /**
     * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

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
     * The cached value of the '{@link #getMapper() <em>Mapper</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMapper()
     * @generated
     * @ordered
     */
    protected DataMapperService mapper;

    /**
     * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInput()
     * @generated
     * @ordered
     */
    protected InputDefinition input;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MappedSourceValueImpl ()
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
        return ComponentPackage.Literals.MAPPED_SOURCE_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getShortDescription ()
    {
        return shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShortDescription ( String newShortDescription )
    {
        String oldShortDescription = shortDescription;
        shortDescription = newShortDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperService getMapper ()
    {
        if ( mapper != null && mapper.eIsProxy () )
        {
            InternalEObject oldMapper = (InternalEObject)mapper;
            mapper = (DataMapperService)eResolveProxy ( oldMapper );
            if ( mapper != oldMapper )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER, oldMapper, mapper ) );
            }
        }
        return mapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperService basicGetMapper ()
    {
        return mapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMapper ( DataMapperService newMapper )
    {
        DataMapperService oldMapper = mapper;
        mapper = newMapper;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER, oldMapper, mapper ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition getInput ()
    {
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInput ( InputDefinition newInput, NotificationChain msgs )
    {
        InputDefinition oldInput = input;
        input = newInput;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, oldInput, newInput );
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
    public void setInput ( InputDefinition newInput )
    {
        if ( newInput != input )
        {
            NotificationChain msgs = null;
            if ( input != null )
                msgs = ( (InternalEObject)input ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, msgs );
            if ( newInput != null )
                msgs = ( (InternalEObject)newInput ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, msgs );
            msgs = basicSetInput ( newInput, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, newInput, newInput ) );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                return basicSetInput ( null, msgs );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION:
                return getShortDescription ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__NAME:
                return getName ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                if ( resolve )
                    return getMapper ();
                return basicGetMapper ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                return getInput ();
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__NAME:
                setName ( (String)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                setMapper ( (DataMapperService)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                setInput ( (InputDefinition)newValue );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                setMapper ( (DataMapperService)null );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                setInput ( (InputDefinition)null );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case ComponentPackage.MAPPED_SOURCE_VALUE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                return mapper != null;
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                return input != null;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID ( int derivedFeatureID, Class<?> baseClass )
    {
        if ( baseClass == Documentable.class )
        {
            switch ( derivedFeatureID )
            {
                case ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION:
                    return WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;
                case ComponentPackage.MAPPED_SOURCE_VALUE__NAME:
                    return WorldPackage.DOCUMENTABLE__NAME;
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID ( derivedFeatureID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID ( int baseFeatureID, Class<?> baseClass )
    {
        if ( baseClass == Documentable.class )
        {
            switch ( baseFeatureID )
            {
                case WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION:
                    return ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION;
                case WorldPackage.DOCUMENTABLE__NAME:
                    return ComponentPackage.MAPPED_SOURCE_VALUE__NAME;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID ( baseFeatureID, baseClass );
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
        result.append ( " (shortDescription: " ); //$NON-NLS-1$
        result.append ( shortDescription );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ')' );
        return result.toString ();
    }

} //MappedSourceValueImpl
