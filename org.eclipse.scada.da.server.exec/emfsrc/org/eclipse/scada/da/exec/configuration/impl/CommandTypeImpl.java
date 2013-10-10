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
package org.eclipse.scada.da.exec.configuration.impl;

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
import org.eclipse.scada.da.exec.configuration.CommandType;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.ExtractorType;
import org.eclipse.scada.da.exec.configuration.ProcessType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Command Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.CommandTypeImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.CommandTypeImpl#getExtractor <em>Extractor</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.CommandTypeImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CommandTypeImpl extends MinimalEObjectImpl.Container implements CommandType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getProcess() <em>Process</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProcess()
     * @generated
     * @ordered
     */
    protected ProcessType process;

    /**
     * The cached value of the '{@link #getExtractor() <em>Extractor</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtractor()
     * @generated
     * @ordered
     */
    protected EList<ExtractorType> extractor;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CommandTypeImpl ()
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
        return ConfigurationPackage.Literals.COMMAND_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProcessType getProcess ()
    {
        return process;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProcess ( ProcessType newProcess, NotificationChain msgs )
    {
        ProcessType oldProcess = process;
        process = newProcess;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.COMMAND_TYPE__PROCESS, oldProcess, newProcess );
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
    public void setProcess ( ProcessType newProcess )
    {
        if ( newProcess != process )
        {
            NotificationChain msgs = null;
            if ( process != null )
                msgs = ( (InternalEObject)process ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.COMMAND_TYPE__PROCESS, null, msgs );
            if ( newProcess != null )
                msgs = ( (InternalEObject)newProcess ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.COMMAND_TYPE__PROCESS, null, msgs );
            msgs = basicSetProcess ( newProcess, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.COMMAND_TYPE__PROCESS, newProcess, newProcess ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ExtractorType> getExtractor ()
    {
        if ( extractor == null )
        {
            extractor = new EObjectContainmentEList<ExtractorType> ( ExtractorType.class, this, ConfigurationPackage.COMMAND_TYPE__EXTRACTOR );
        }
        return extractor;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.COMMAND_TYPE__ID, oldId, id ) );
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
            case ConfigurationPackage.COMMAND_TYPE__PROCESS:
                return basicSetProcess ( null, msgs );
            case ConfigurationPackage.COMMAND_TYPE__EXTRACTOR:
                return ( (InternalEList<?>)getExtractor () ).basicRemove ( otherEnd, msgs );
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
            case ConfigurationPackage.COMMAND_TYPE__PROCESS:
                return getProcess ();
            case ConfigurationPackage.COMMAND_TYPE__EXTRACTOR:
                return getExtractor ();
            case ConfigurationPackage.COMMAND_TYPE__ID:
                return getId ();
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
            case ConfigurationPackage.COMMAND_TYPE__PROCESS:
                setProcess ( (ProcessType)newValue );
                return;
            case ConfigurationPackage.COMMAND_TYPE__EXTRACTOR:
                getExtractor ().clear ();
                getExtractor ().addAll ( (Collection<? extends ExtractorType>)newValue );
                return;
            case ConfigurationPackage.COMMAND_TYPE__ID:
                setId ( (String)newValue );
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
            case ConfigurationPackage.COMMAND_TYPE__PROCESS:
                setProcess ( (ProcessType)null );
                return;
            case ConfigurationPackage.COMMAND_TYPE__EXTRACTOR:
                getExtractor ().clear ();
                return;
            case ConfigurationPackage.COMMAND_TYPE__ID:
                setId ( ID_EDEFAULT );
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
            case ConfigurationPackage.COMMAND_TYPE__PROCESS:
                return process != null;
            case ConfigurationPackage.COMMAND_TYPE__EXTRACTOR:
                return extractor != null && !extractor.isEmpty ();
            case ConfigurationPackage.COMMAND_TYPE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
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
        result.append ( ')' );
        return result.toString ();
    }

} //CommandTypeImpl
