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
package org.eclipse.scada.configuration.dave.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.dave.DaveBlockDefinition;
import org.eclipse.scada.configuration.dave.DaveDevice;
import org.eclipse.scada.configuration.dave.DavePackage;
import org.eclipse.scada.configuration.memory.TypeDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl#getBlock <em>Block</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl#getDevice <em>Device</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl#isEnableStatistics <em>Enable Statistics</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.dave.impl.DaveBlockDefinitionImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DaveBlockDefinitionImpl extends MinimalEObjectImpl.Container implements DaveBlockDefinition
{

    /**
     * The default value of the '{@link #getBlock() <em>Block</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlock()
     * @generated
     * @ordered
     */
    protected static final int BLOCK_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getBlock() <em>Block</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBlock()
     * @generated
     * @ordered
     */
    protected int block = BLOCK_EDEFAULT;

    /**
     * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOffset()
     * @generated
     * @ordered
     */
    protected static final int OFFSET_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOffset()
     * @generated
     * @ordered
     */
    protected int offset = OFFSET_EDEFAULT;

    /**
     * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected static final int PERIOD_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected int period = PERIOD_EDEFAULT;

    /**
     * The default value of the '{@link #isEnableStatistics() <em>Enable Statistics</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableStatistics()
     * @generated
     * @ordered
     */
    protected static final boolean ENABLE_STATISTICS_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEnableStatistics() <em>Enable Statistics</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEnableStatistics()
     * @generated
     * @ordered
     */
    protected boolean enableStatistics = ENABLE_STATISTICS_EDEFAULT;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected TypeDefinition type;

    /**
     * The default value of the '{@link #getArea() <em>Area</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getArea()
     * @generated NOT
     * @ordered
     */
    protected static final int AREA_EDEFAULT = 132;

    /**
     * The cached value of the '{@link #getArea() <em>Area</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArea()
     * @generated
     * @ordered
     */
    protected int area = AREA_EDEFAULT;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DaveBlockDefinitionImpl ()
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
        return DavePackage.Literals.DAVE_BLOCK_DEFINITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getBlock ()
    {
        return block;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setBlock ( int newBlock )
    {
        int oldBlock = block;
        block = newBlock;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_BLOCK_DEFINITION__BLOCK, oldBlock, block ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DaveDevice getDevice ()
    {
        if ( eContainerFeatureID () != DavePackage.DAVE_BLOCK_DEFINITION__DEVICE )
            return null;
        return (DaveDevice)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DaveDevice basicGetDevice ()
    {
        if ( eContainerFeatureID () != DavePackage.DAVE_BLOCK_DEFINITION__DEVICE )
            return null;
        return (DaveDevice)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDevice ( DaveDevice newDevice, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newDevice, DavePackage.DAVE_BLOCK_DEFINITION__DEVICE, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDevice ( DaveDevice newDevice )
    {
        if ( newDevice != eInternalContainer () || ( eContainerFeatureID () != DavePackage.DAVE_BLOCK_DEFINITION__DEVICE && newDevice != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newDevice ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newDevice != null )
                msgs = ( (InternalEObject)newDevice ).eInverseAdd ( this, DavePackage.DAVE_DEVICE__BLOCKS, DaveDevice.class, msgs );
            msgs = basicSetDevice ( newDevice, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_BLOCK_DEFINITION__DEVICE, newDevice, newDevice ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getOffset ()
    {
        return offset;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOffset ( int newOffset )
    {
        int oldOffset = offset;
        offset = newOffset;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_BLOCK_DEFINITION__OFFSET, oldOffset, offset ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getPeriod ()
    {
        return period;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPeriod ( int newPeriod )
    {
        int oldPeriod = period;
        period = newPeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_BLOCK_DEFINITION__PERIOD, oldPeriod, period ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isEnableStatistics ()
    {
        return enableStatistics;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEnableStatistics ( boolean newEnableStatistics )
    {
        boolean oldEnableStatistics = enableStatistics;
        enableStatistics = newEnableStatistics;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_BLOCK_DEFINITION__ENABLE_STATISTICS, oldEnableStatistics, enableStatistics ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TypeDefinition getType ()
    {
        if ( type != null && type.eIsProxy () )
        {
            InternalEObject oldType = (InternalEObject)type;
            type = (TypeDefinition)eResolveProxy ( oldType );
            if ( type != oldType )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DavePackage.DAVE_BLOCK_DEFINITION__TYPE, oldType, type ) );
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeDefinition basicGetType ()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setType ( TypeDefinition newType )
    {
        TypeDefinition oldType = type;
        type = newType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_BLOCK_DEFINITION__TYPE, oldType, type ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getArea ()
    {
        return area;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setArea ( int newArea )
    {
        int oldArea = area;
        area = newArea;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_BLOCK_DEFINITION__AREA, oldArea, area ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DavePackage.DAVE_BLOCK_DEFINITION__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case DavePackage.DAVE_BLOCK_DEFINITION__DEVICE:
                if ( eInternalContainer () != null )
                    msgs = eBasicRemoveFromContainer ( msgs );
                return basicSetDevice ( (DaveDevice)otherEnd, msgs );
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
            case DavePackage.DAVE_BLOCK_DEFINITION__DEVICE:
                return basicSetDevice ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature ( NotificationChain msgs )
    {
        switch ( eContainerFeatureID () )
        {
            case DavePackage.DAVE_BLOCK_DEFINITION__DEVICE:
                return eInternalContainer ().eInverseRemove ( this, DavePackage.DAVE_DEVICE__BLOCKS, DaveDevice.class, msgs );
        }
        return super.eBasicRemoveFromContainerFeature ( msgs );
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
            case DavePackage.DAVE_BLOCK_DEFINITION__BLOCK:
                return getBlock ();
            case DavePackage.DAVE_BLOCK_DEFINITION__DEVICE:
                if ( resolve )
                    return getDevice ();
                return basicGetDevice ();
            case DavePackage.DAVE_BLOCK_DEFINITION__OFFSET:
                return getOffset ();
            case DavePackage.DAVE_BLOCK_DEFINITION__PERIOD:
                return getPeriod ();
            case DavePackage.DAVE_BLOCK_DEFINITION__ENABLE_STATISTICS:
                return isEnableStatistics ();
            case DavePackage.DAVE_BLOCK_DEFINITION__TYPE:
                if ( resolve )
                    return getType ();
                return basicGetType ();
            case DavePackage.DAVE_BLOCK_DEFINITION__AREA:
                return getArea ();
            case DavePackage.DAVE_BLOCK_DEFINITION__NAME:
                return getName ();
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
            case DavePackage.DAVE_BLOCK_DEFINITION__BLOCK:
                setBlock ( (Integer)newValue );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__DEVICE:
                setDevice ( (DaveDevice)newValue );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__OFFSET:
                setOffset ( (Integer)newValue );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__PERIOD:
                setPeriod ( (Integer)newValue );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__ENABLE_STATISTICS:
                setEnableStatistics ( (Boolean)newValue );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__TYPE:
                setType ( (TypeDefinition)newValue );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__AREA:
                setArea ( (Integer)newValue );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__NAME:
                setName ( (String)newValue );
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
            case DavePackage.DAVE_BLOCK_DEFINITION__BLOCK:
                setBlock ( BLOCK_EDEFAULT );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__DEVICE:
                setDevice ( (DaveDevice)null );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__OFFSET:
                setOffset ( OFFSET_EDEFAULT );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__PERIOD:
                setPeriod ( PERIOD_EDEFAULT );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__ENABLE_STATISTICS:
                setEnableStatistics ( ENABLE_STATISTICS_EDEFAULT );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__TYPE:
                setType ( (TypeDefinition)null );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__AREA:
                setArea ( AREA_EDEFAULT );
                return;
            case DavePackage.DAVE_BLOCK_DEFINITION__NAME:
                setName ( NAME_EDEFAULT );
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
            case DavePackage.DAVE_BLOCK_DEFINITION__BLOCK:
                return block != BLOCK_EDEFAULT;
            case DavePackage.DAVE_BLOCK_DEFINITION__DEVICE:
                return basicGetDevice () != null;
            case DavePackage.DAVE_BLOCK_DEFINITION__OFFSET:
                return offset != OFFSET_EDEFAULT;
            case DavePackage.DAVE_BLOCK_DEFINITION__PERIOD:
                return period != PERIOD_EDEFAULT;
            case DavePackage.DAVE_BLOCK_DEFINITION__ENABLE_STATISTICS:
                return enableStatistics != ENABLE_STATISTICS_EDEFAULT;
            case DavePackage.DAVE_BLOCK_DEFINITION__TYPE:
                return type != null;
            case DavePackage.DAVE_BLOCK_DEFINITION__AREA:
                return area != AREA_EDEFAULT;
            case DavePackage.DAVE_BLOCK_DEFINITION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
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
        result.append ( " (block: " ); //$NON-NLS-1$
        result.append ( block );
        result.append ( ", offset: " ); //$NON-NLS-1$
        result.append ( offset );
        result.append ( ", period: " ); //$NON-NLS-1$
        result.append ( period );
        result.append ( ", enableStatistics: " ); //$NON-NLS-1$
        result.append ( enableStatistics );
        result.append ( ", area: " ); //$NON-NLS-1$
        result.append ( area );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ')' );
        return result.toString ();
    }

} //DaveBlockDefinitionImpl
