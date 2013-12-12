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
package org.eclipse.scada.configuration.component.exec.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.exec.ExecComponentsPackage;
import org.eclipse.scada.configuration.component.exec.ExecJob;
import org.eclipse.scada.configuration.component.exec.util.ExecComponentsValidator;
import org.eclipse.scada.configuration.component.impl.MasterComponentImpl;
import org.eclipse.scada.configuration.infrastructure.CommonDriver;
import org.eclipse.scada.configuration.infrastructure.Driver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exec Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.impl.ExecJobImpl#getRunsOn <em>Runs On</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.impl.ExecJobImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecJobImpl extends MasterComponentImpl implements ExecJob
{
    private static final String DRIVER_TYPE_ID = "org.eclipse.scada.da.server.exec";

    /**
     * The cached value of the '{@link #getRunsOn() <em>Runs On</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRunsOn()
     * @generated
     * @ordered
     */
    protected Driver runsOn;

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
    protected ExecJobImpl ()
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
        return ExecComponentsPackage.Literals.EXEC_JOB;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ExecComponentsPackage.EXEC_JOB__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Driver getRunsOn ()
    {
        if ( runsOn != null && runsOn.eIsProxy () )
        {
            InternalEObject oldRunsOn = (InternalEObject)runsOn;
            runsOn = (Driver)eResolveProxy ( oldRunsOn );
            if ( runsOn != oldRunsOn )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ExecComponentsPackage.EXEC_JOB__RUNS_ON, oldRunsOn, runsOn ) );
            }
        }
        return runsOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Driver basicGetRunsOn ()
    {
        return runsOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRunsOn ( Driver newRunsOn )
    {
        Driver oldRunsOn = runsOn;
        runsOn = newRunsOn;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ExecComponentsPackage.EXEC_JOB__RUNS_ON, oldRunsOn, runsOn ) );
    }

    /**
     * <!-- begin-user-doc -->
     * The ExecJob must reference a driver of type {@link Driver} and driver
     * type id {@link #DRIVER_TYPE_ID} <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public boolean hasExecDriver ( final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        if ( this.runsOn == null )
        {
            if ( diagnostics != null )
            {
                final String message = String.format ( "Must reference to a driver that is of type '%s', but it dest not reference any driver.", DRIVER_TYPE_ID );
                diagnostics.add ( new BasicDiagnostic ( Diagnostic.ERROR, ExecComponentsValidator.DIAGNOSTIC_SOURCE, ExecComponentsValidator.EXEC_JOB__HAS_EXEC_DRIVER, message, new Object[] { this } ) );
            }
            return false;
        }

        if ( ! ( this.runsOn instanceof CommonDriver ) )
        {
            if ( diagnostics != null )
            {
                final String message = String.format ( "Must reference to a driver that is of class type '%s', but the referenced class type actually is '%s'", CommonDriver.class.getName (), this.runsOn.getClass ().getName () );
                diagnostics.add ( new BasicDiagnostic ( Diagnostic.ERROR, ExecComponentsValidator.DIAGNOSTIC_SOURCE, ExecComponentsValidator.EXEC_JOB__HAS_EXEC_DRIVER, message, new Object[] { this } ) );
            }
            return false;
        }

        if ( !DRIVER_TYPE_ID.equals ( ( (CommonDriver)this.runsOn ).getDriverTypeId () ) )
        {
            if ( diagnostics != null )
            {
                final String message = String.format ( "Must reference to a driver that is of type '%s', but the referenced type actually is '%s'", DRIVER_TYPE_ID, ( (CommonDriver)this.runsOn ).getDriverTypeId () );
                diagnostics.add ( new BasicDiagnostic ( Diagnostic.ERROR, ExecComponentsValidator.DIAGNOSTIC_SOURCE, ExecComponentsValidator.EXEC_JOB__HAS_EXEC_DRIVER, message, new Object[] { this } ) );
            }
            return false;
        }
        return true;
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
            case ExecComponentsPackage.EXEC_JOB__RUNS_ON:
                if ( resolve )
                    return getRunsOn ();
                return basicGetRunsOn ();
            case ExecComponentsPackage.EXEC_JOB__NAME:
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
            case ExecComponentsPackage.EXEC_JOB__RUNS_ON:
                setRunsOn ( (Driver)newValue );
                return;
            case ExecComponentsPackage.EXEC_JOB__NAME:
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
            case ExecComponentsPackage.EXEC_JOB__RUNS_ON:
                setRunsOn ( (Driver)null );
                return;
            case ExecComponentsPackage.EXEC_JOB__NAME:
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
            case ExecComponentsPackage.EXEC_JOB__RUNS_ON:
                return runsOn != null;
            case ExecComponentsPackage.EXEC_JOB__NAME:
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
    @SuppressWarnings ( "unchecked" )
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case ExecComponentsPackage.EXEC_JOB___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP:
                return hasExecDriver ( (DiagnosticChain)arguments.get ( 0 ), (Map<Object, Object>)arguments.get ( 1 ) );
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ')' );
        return result.toString ();
    }

} //ExecJobImpl
