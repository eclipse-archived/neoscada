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
import org.eclipse.scada.configuration.world.Node;
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
 * <li>
 * {@link org.eclipse.scada.configuration.world.deployment.impl.SimpleNodeMappingEntryImpl#getFromHostName
 * <em>From Host Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.world.deployment.impl.SimpleNodeMappingEntryImpl#getToHostName
 * <em>To Host Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SimpleNodeMappingEntryImpl extends MinimalEObjectImpl.Container implements SimpleNodeMappingEntry
{
    /**
     * The default value of the '{@link #getFromHostName()
     * <em>From Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getFromHostName()
     * @generated
     * @ordered
     */
    protected static final String FROM_HOST_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFromHostName()
     * <em>From Host Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getFromHostName()
     * @generated
     * @ordered
     */
    protected String fromHostName = FROM_HOST_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getToHostName() <em>To Host Name</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getToHostName()
     * @generated
     * @ordered
     */
    protected static final String TO_HOST_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getToHostName() <em>To Host Name</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getToHostName()
     * @generated
     * @ordered
     */
    protected String toHostName = TO_HOST_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SimpleNodeMappingEntryImpl ()
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
        return DeploymentPackage.Literals.SIMPLE_NODE_MAPPING_ENTRY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getFromHostName ()
    {
        return this.fromHostName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFromHostName ( final String newFromHostName )
    {
        final String oldFromHostName = this.fromHostName;
        this.fromHostName = newFromHostName;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME, oldFromHostName, this.fromHostName ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getToHostName ()
    {
        return this.toHostName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setToHostName ( final String newToHostName )
    {
        final String oldToHostName = this.toHostName;
        this.toHostName = newToHostName;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME, oldToHostName, this.toHostName ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public boolean mapNode ( final Node node )
    {
        if ( node == null )
        {
            return false;
        }
        if ( node.getHostName () == null )
        {
            return false;
        }
        if ( node.getHostName ().equalsIgnoreCase ( getFromHostName () ) )
        {
            node.setHostName ( getToHostName () );
            return true;
        }
        return false;
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
     * 
     * @generated
     */
    @Override
    public void eSet ( final int featureID, final Object newValue )
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
     * 
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
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
     * 
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME:
                return FROM_HOST_NAME_EDEFAULT == null ? this.fromHostName != null : !FROM_HOST_NAME_EDEFAULT.equals ( this.fromHostName );
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME:
                return TO_HOST_NAME_EDEFAULT == null ? this.toHostName != null : !TO_HOST_NAME_EDEFAULT.equals ( this.toHostName );
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
    public Object eInvoke ( final int operationID, final EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY___MAP_NODE__NODE:
                return mapNode ( (Node)arguments.get ( 0 ) );
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (fromHostName: " ); //$NON-NLS-1$
        result.append ( this.fromHostName );
        result.append ( ", toHostName: " ); //$NON-NLS-1$
        result.append ( this.toHostName );
        result.append ( ')' );
        return result.toString ();
    }

} //SimpleNodeMappingEntryImpl
