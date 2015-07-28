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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.SingleValue;
import org.eclipse.scada.configuration.world.osgi.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SingleValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SingleValueImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SingleValueImpl#getCustomizationTags <em>Customization Tags</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SingleValueImpl#isReadable <em>Readable</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SingleValueImpl#isWritable <em>Writable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SingleValueImpl extends MasterComponentImpl implements SingleValue
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
     * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataType()
     * @generated
     * @ordered
     */
    protected static final DataType DATA_TYPE_EDEFAULT = DataType.VARIANT;

    /**
     * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataType()
     * @generated
     * @ordered
     */
    protected DataType dataType = DATA_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getCustomizationTags() <em>Customization Tags</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomizationTags()
     * @generated
     * @ordered
     */
    protected EList<String> customizationTags;

    /**
     * The default value of the '{@link #isReadable() <em>Readable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReadable()
     * @generated
     * @ordered
     */
    protected static final boolean READABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isReadable() <em>Readable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isReadable()
     * @generated
     * @ordered
     */
    protected boolean readable = READABLE_EDEFAULT;

    /**
     * The default value of the '{@link #isWritable() <em>Writable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isWritable()
     * @generated
     * @ordered
     */
    protected static final boolean WRITABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isWritable() <em>Writable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isWritable()
     * @generated
     * @ordered
     */
    protected boolean writable = WRITABLE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SingleValueImpl ()
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
        return ComponentPackage.Literals.SINGLE_VALUE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SINGLE_VALUE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataType getDataType ()
    {
        return dataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataType ( DataType newDataType )
    {
        DataType oldDataType = dataType;
        dataType = newDataType == null ? DATA_TYPE_EDEFAULT : newDataType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SINGLE_VALUE__DATA_TYPE, oldDataType, dataType ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getCustomizationTags ()
    {
        if ( customizationTags == null )
        {
            customizationTags = new EDataTypeUniqueEList<String> ( String.class, this, ComponentPackage.SINGLE_VALUE__CUSTOMIZATION_TAGS );
        }
        return customizationTags;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isReadable ()
    {
        return readable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReadable ( boolean newReadable )
    {
        boolean oldReadable = readable;
        readable = newReadable;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SINGLE_VALUE__READABLE, oldReadable, readable ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isWritable ()
    {
        return writable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWritable ( boolean newWritable )
    {
        boolean oldWritable = writable;
        writable = newWritable;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SINGLE_VALUE__WRITABLE, oldWritable, writable ) );
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
            case ComponentPackage.SINGLE_VALUE__NAME:
                return getName ();
            case ComponentPackage.SINGLE_VALUE__DATA_TYPE:
                return getDataType ();
            case ComponentPackage.SINGLE_VALUE__CUSTOMIZATION_TAGS:
                return getCustomizationTags ();
            case ComponentPackage.SINGLE_VALUE__READABLE:
                return isReadable ();
            case ComponentPackage.SINGLE_VALUE__WRITABLE:
                return isWritable ();
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
            case ComponentPackage.SINGLE_VALUE__NAME:
                setName ( (String)newValue );
                return;
            case ComponentPackage.SINGLE_VALUE__DATA_TYPE:
                setDataType ( (DataType)newValue );
                return;
            case ComponentPackage.SINGLE_VALUE__CUSTOMIZATION_TAGS:
                getCustomizationTags ().clear ();
                getCustomizationTags ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ComponentPackage.SINGLE_VALUE__READABLE:
                setReadable ( (Boolean)newValue );
                return;
            case ComponentPackage.SINGLE_VALUE__WRITABLE:
                setWritable ( (Boolean)newValue );
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
            case ComponentPackage.SINGLE_VALUE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ComponentPackage.SINGLE_VALUE__DATA_TYPE:
                setDataType ( DATA_TYPE_EDEFAULT );
                return;
            case ComponentPackage.SINGLE_VALUE__CUSTOMIZATION_TAGS:
                getCustomizationTags ().clear ();
                return;
            case ComponentPackage.SINGLE_VALUE__READABLE:
                setReadable ( READABLE_EDEFAULT );
                return;
            case ComponentPackage.SINGLE_VALUE__WRITABLE:
                setWritable ( WRITABLE_EDEFAULT );
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
            case ComponentPackage.SINGLE_VALUE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ComponentPackage.SINGLE_VALUE__DATA_TYPE:
                return dataType != DATA_TYPE_EDEFAULT;
            case ComponentPackage.SINGLE_VALUE__CUSTOMIZATION_TAGS:
                return customizationTags != null && !customizationTags.isEmpty ();
            case ComponentPackage.SINGLE_VALUE__READABLE:
                return readable != READABLE_EDEFAULT;
            case ComponentPackage.SINGLE_VALUE__WRITABLE:
                return writable != WRITABLE_EDEFAULT;
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
        result.append ( ", dataType: " ); //$NON-NLS-1$
        result.append ( dataType );
        result.append ( ", customizationTags: " ); //$NON-NLS-1$
        result.append ( customizationTags );
        result.append ( ", readable: " ); //$NON-NLS-1$
        result.append ( readable );
        result.append ( ", writable: " ); //$NON-NLS-1$
        result.append ( writable );
        result.append ( ')' );
        return result.toString ();
    }

} //SingleValueImpl
