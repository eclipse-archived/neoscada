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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.infrastructure.Driver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ExternalValueImpl#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ExternalValueImpl#getSourceName <em>Source Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ExternalValueImpl#isReadable <em>Readable</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ExternalValueImpl#isWritable <em>Writable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExternalValueImpl extends SingleValueImpl implements ExternalValue
{
    /**
     * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnection()
     * @generated
     * @ordered
     */
    protected Driver connection;

    /**
     * The default value of the '{@link #getSourceName() <em>Source Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceName()
     * @generated
     * @ordered
     */
    protected static final String SOURCE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSourceName() <em>Source Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceName()
     * @generated
     * @ordered
     */
    protected String sourceName = SOURCE_NAME_EDEFAULT;

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
    protected ExternalValueImpl ()
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
        return ComponentPackage.Literals.EXTERNAL_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Driver getConnection ()
    {
        if ( connection != null && connection.eIsProxy () )
        {
            InternalEObject oldConnection = (InternalEObject)connection;
            connection = (Driver)eResolveProxy ( oldConnection );
            if ( connection != oldConnection )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.EXTERNAL_VALUE__CONNECTION, oldConnection, connection ) );
            }
        }
        return connection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Driver basicGetConnection ()
    {
        return connection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConnection ( Driver newConnection )
    {
        Driver oldConnection = connection;
        connection = newConnection;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.EXTERNAL_VALUE__CONNECTION, oldConnection, connection ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSourceName ()
    {
        return sourceName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceName ( String newSourceName )
    {
        String oldSourceName = sourceName;
        sourceName = newSourceName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.EXTERNAL_VALUE__SOURCE_NAME, oldSourceName, sourceName ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.EXTERNAL_VALUE__READABLE, oldReadable, readable ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.EXTERNAL_VALUE__WRITABLE, oldWritable, writable ) );
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
            case ComponentPackage.EXTERNAL_VALUE__CONNECTION:
                if ( resolve )
                    return getConnection ();
                return basicGetConnection ();
            case ComponentPackage.EXTERNAL_VALUE__SOURCE_NAME:
                return getSourceName ();
            case ComponentPackage.EXTERNAL_VALUE__READABLE:
                return isReadable ();
            case ComponentPackage.EXTERNAL_VALUE__WRITABLE:
                return isWritable ();
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
            case ComponentPackage.EXTERNAL_VALUE__CONNECTION:
                setConnection ( (Driver)newValue );
                return;
            case ComponentPackage.EXTERNAL_VALUE__SOURCE_NAME:
                setSourceName ( (String)newValue );
                return;
            case ComponentPackage.EXTERNAL_VALUE__READABLE:
                setReadable ( (Boolean)newValue );
                return;
            case ComponentPackage.EXTERNAL_VALUE__WRITABLE:
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
            case ComponentPackage.EXTERNAL_VALUE__CONNECTION:
                setConnection ( (Driver)null );
                return;
            case ComponentPackage.EXTERNAL_VALUE__SOURCE_NAME:
                setSourceName ( SOURCE_NAME_EDEFAULT );
                return;
            case ComponentPackage.EXTERNAL_VALUE__READABLE:
                setReadable ( READABLE_EDEFAULT );
                return;
            case ComponentPackage.EXTERNAL_VALUE__WRITABLE:
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
            case ComponentPackage.EXTERNAL_VALUE__CONNECTION:
                return connection != null;
            case ComponentPackage.EXTERNAL_VALUE__SOURCE_NAME:
                return SOURCE_NAME_EDEFAULT == null ? sourceName != null : !SOURCE_NAME_EDEFAULT.equals ( sourceName );
            case ComponentPackage.EXTERNAL_VALUE__READABLE:
                return readable != READABLE_EDEFAULT;
            case ComponentPackage.EXTERNAL_VALUE__WRITABLE:
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
        result.append ( " (sourceName: " ); //$NON-NLS-1$
        result.append ( sourceName );
        result.append ( ", readable: " ); //$NON-NLS-1$
        result.append ( readable );
        result.append ( ", writable: " ); //$NON-NLS-1$
        result.append ( writable );
        result.append ( ')' );
        return result.toString ();
    }

} //ExternalValueImpl
