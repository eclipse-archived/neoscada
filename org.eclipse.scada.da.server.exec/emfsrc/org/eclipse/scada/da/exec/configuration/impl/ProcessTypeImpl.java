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
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.EnvEntryType;
import org.eclipse.scada.da.exec.configuration.ProcessType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.ProcessTypeImpl#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.ProcessTypeImpl#getEnv <em>Env</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.ProcessTypeImpl#getExec <em>Exec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessTypeImpl extends MinimalEObjectImpl.Container implements ProcessType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getArgument() <em>Argument</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArgument()
     * @generated
     * @ordered
     */
    protected EList<String> argument;

    /**
     * The cached value of the '{@link #getEnv() <em>Env</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnv()
     * @generated
     * @ordered
     */
    protected EList<EnvEntryType> env;

    /**
     * The default value of the '{@link #getExec() <em>Exec</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExec()
     * @generated
     * @ordered
     */
    protected static final String EXEC_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExec() <em>Exec</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExec()
     * @generated
     * @ordered
     */
    protected String exec = EXEC_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProcessTypeImpl ()
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
        return ConfigurationPackage.Literals.PROCESS_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getArgument ()
    {
        if ( argument == null )
        {
            argument = new EDataTypeEList<String> ( String.class, this, ConfigurationPackage.PROCESS_TYPE__ARGUMENT );
        }
        return argument;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<EnvEntryType> getEnv ()
    {
        if ( env == null )
        {
            env = new EObjectContainmentEList<EnvEntryType> ( EnvEntryType.class, this, ConfigurationPackage.PROCESS_TYPE__ENV );
        }
        return env;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExec ()
    {
        return exec;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExec ( String newExec )
    {
        String oldExec = exec;
        exec = newExec;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.PROCESS_TYPE__EXEC, oldExec, exec ) );
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
            case ConfigurationPackage.PROCESS_TYPE__ENV:
                return ( (InternalEList<?>)getEnv () ).basicRemove ( otherEnd, msgs );
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
            case ConfigurationPackage.PROCESS_TYPE__ARGUMENT:
                return getArgument ();
            case ConfigurationPackage.PROCESS_TYPE__ENV:
                return getEnv ();
            case ConfigurationPackage.PROCESS_TYPE__EXEC:
                return getExec ();
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
            case ConfigurationPackage.PROCESS_TYPE__ARGUMENT:
                getArgument ().clear ();
                getArgument ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ConfigurationPackage.PROCESS_TYPE__ENV:
                getEnv ().clear ();
                getEnv ().addAll ( (Collection<? extends EnvEntryType>)newValue );
                return;
            case ConfigurationPackage.PROCESS_TYPE__EXEC:
                setExec ( (String)newValue );
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
            case ConfigurationPackage.PROCESS_TYPE__ARGUMENT:
                getArgument ().clear ();
                return;
            case ConfigurationPackage.PROCESS_TYPE__ENV:
                getEnv ().clear ();
                return;
            case ConfigurationPackage.PROCESS_TYPE__EXEC:
                setExec ( EXEC_EDEFAULT );
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
            case ConfigurationPackage.PROCESS_TYPE__ARGUMENT:
                return argument != null && !argument.isEmpty ();
            case ConfigurationPackage.PROCESS_TYPE__ENV:
                return env != null && !env.isEmpty ();
            case ConfigurationPackage.PROCESS_TYPE__EXEC:
                return EXEC_EDEFAULT == null ? exec != null : !EXEC_EDEFAULT.equals ( exec );
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
        result.append ( " (argument: " ); //$NON-NLS-1$
        result.append ( argument );
        result.append ( ", exec: " ); //$NON-NLS-1$
        result.append ( exec );
        result.append ( ')' );
        return result.toString ();
    }

} //ProcessTypeImpl
