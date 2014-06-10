/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.deployment.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Simple Node Mapping Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.SimpleNodeMappingEntryImpl#getFromHostName <em>From Host Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.SimpleNodeMappingEntryImpl#getToHostName <em>To Host Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleNodeMappingEntryImpl extends MinimalEObjectImpl.Container
        implements SimpleNodeMappingEntry
{
    /**
     * The default value of the '{@link #getFromHostName() <em>From Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFromHostName()
     * @generated
     * @ordered
     */
    protected static final String FROM_HOST_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFromHostName() <em>From Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFromHostName()
     * @generated
     * @ordered
     */
    protected String fromHostName = FROM_HOST_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getToHostName() <em>To Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getToHostName()
     * @generated
     * @ordered
     */
    protected static final String TO_HOST_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getToHostName() <em>To Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getToHostName()
     * @generated
     * @ordered
     */
    protected String toHostName = TO_HOST_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SimpleNodeMappingEntryImpl ()
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
        return DeploymentPackage.Literals.SIMPLE_NODE_MAPPING_ENTRY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getFromHostName ()
    {
        return fromHostName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setFromHostName ( String newFromHostName )
    {
        String oldFromHostName = fromHostName;
        fromHostName = newFromHostName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME, oldFromHostName, fromHostName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getToHostName ()
    {
        return toHostName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setToHostName ( String newToHostName )
    {
        String oldToHostName = toHostName;
        toHostName = newToHostName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME, oldToHostName, toHostName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public String map ( final String from )
    {
        if ( from == null )
        {
            return null;
        }

        if ( from.equalsIgnoreCase ( getFromHostName () ) )
        {
            return getToHostName ();
        }
        return null;
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
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME:
                return getFromHostName ();
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME:
                return getToHostName ();
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
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME:
                setFromHostName ( (String)newValue );
                return;
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME:
                setToHostName ( (String)newValue );
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
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME:
                setFromHostName ( FROM_HOST_NAME_EDEFAULT );
                return;
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME:
                setToHostName ( TO_HOST_NAME_EDEFAULT );
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
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME:
                return FROM_HOST_NAME_EDEFAULT == null ? fromHostName != null : !FROM_HOST_NAME_EDEFAULT.equals ( fromHostName );
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME:
                return TO_HOST_NAME_EDEFAULT == null ? toHostName != null : !TO_HOST_NAME_EDEFAULT.equals ( toHostName );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments )
            throws InvocationTargetException
    {
        switch ( operationID )
        {
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY___MAP__STRING:
                return map ( (String)arguments.get ( 0 ) );
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (fromHostName: " ); //$NON-NLS-1$
        result.append ( fromHostName );
        result.append ( ", toHostName: " ); //$NON-NLS-1$
        result.append ( toHostName );
        result.append ( ')' );
        return result.toString ();
    }

} //SimpleNodeMappingEntryImpl
