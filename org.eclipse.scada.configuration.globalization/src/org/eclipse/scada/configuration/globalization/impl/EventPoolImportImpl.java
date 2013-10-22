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
package org.eclipse.scada.configuration.globalization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.globalization.EventPoolImport;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Pool Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.EventPoolImportImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.EventPoolImportImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.EventPoolImportImpl#getLocalName <em>Local Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.EventPoolImportImpl#isIncludeLocal <em>Include Local</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.EventPoolImportImpl#getPoolSize <em>Pool Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventPoolImportImpl extends MinimalEObjectImpl.Container implements EventPoolImport
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
     * The default value of the '{@link #getLocalName() <em>Local Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalName()
     * @generated
     * @ordered
     */
    protected static final String LOCAL_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLocalName() <em>Local Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalName()
     * @generated
     * @ordered
     */
    protected String localName = LOCAL_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #isIncludeLocal() <em>Include Local</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIncludeLocal()
     * @generated
     * @ordered
     */
    protected static final boolean INCLUDE_LOCAL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIncludeLocal() <em>Include Local</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIncludeLocal()
     * @generated
     * @ordered
     */
    protected boolean includeLocal = INCLUDE_LOCAL_EDEFAULT;

    /**
     * The default value of the '{@link #getPoolSize() <em>Pool Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPoolSize()
     * @generated
     * @ordered
     */
    protected static final int POOL_SIZE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPoolSize() <em>Pool Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPoolSize()
     * @generated
     * @ordered
     */
    protected int poolSize = POOL_SIZE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventPoolImportImpl ()
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
        return GlobalizePackage.Literals.EVENT_POOL_IMPORT;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.EVENT_POOL_IMPORT__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.EVENT_POOL_IMPORT__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLocalName ()
    {
        return localName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocalName ( String newLocalName )
    {
        String oldLocalName = localName;
        localName = newLocalName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.EVENT_POOL_IMPORT__LOCAL_NAME, oldLocalName, localName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIncludeLocal ()
    {
        return includeLocal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIncludeLocal ( boolean newIncludeLocal )
    {
        boolean oldIncludeLocal = includeLocal;
        includeLocal = newIncludeLocal;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.EVENT_POOL_IMPORT__INCLUDE_LOCAL, oldIncludeLocal, includeLocal ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPoolSize ()
    {
        return poolSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPoolSize ( int newPoolSize )
    {
        int oldPoolSize = poolSize;
        poolSize = newPoolSize;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.EVENT_POOL_IMPORT__POOL_SIZE, oldPoolSize, poolSize ) );
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
            case GlobalizePackage.EVENT_POOL_IMPORT__SHORT_DESCRIPTION:
                return getShortDescription ();
            case GlobalizePackage.EVENT_POOL_IMPORT__NAME:
                return getName ();
            case GlobalizePackage.EVENT_POOL_IMPORT__LOCAL_NAME:
                return getLocalName ();
            case GlobalizePackage.EVENT_POOL_IMPORT__INCLUDE_LOCAL:
                return isIncludeLocal ();
            case GlobalizePackage.EVENT_POOL_IMPORT__POOL_SIZE:
                return getPoolSize ();
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
            case GlobalizePackage.EVENT_POOL_IMPORT__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case GlobalizePackage.EVENT_POOL_IMPORT__NAME:
                setName ( (String)newValue );
                return;
            case GlobalizePackage.EVENT_POOL_IMPORT__LOCAL_NAME:
                setLocalName ( (String)newValue );
                return;
            case GlobalizePackage.EVENT_POOL_IMPORT__INCLUDE_LOCAL:
                setIncludeLocal ( (Boolean)newValue );
                return;
            case GlobalizePackage.EVENT_POOL_IMPORT__POOL_SIZE:
                setPoolSize ( (Integer)newValue );
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
            case GlobalizePackage.EVENT_POOL_IMPORT__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case GlobalizePackage.EVENT_POOL_IMPORT__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case GlobalizePackage.EVENT_POOL_IMPORT__LOCAL_NAME:
                setLocalName ( LOCAL_NAME_EDEFAULT );
                return;
            case GlobalizePackage.EVENT_POOL_IMPORT__INCLUDE_LOCAL:
                setIncludeLocal ( INCLUDE_LOCAL_EDEFAULT );
                return;
            case GlobalizePackage.EVENT_POOL_IMPORT__POOL_SIZE:
                setPoolSize ( POOL_SIZE_EDEFAULT );
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
            case GlobalizePackage.EVENT_POOL_IMPORT__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case GlobalizePackage.EVENT_POOL_IMPORT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case GlobalizePackage.EVENT_POOL_IMPORT__LOCAL_NAME:
                return LOCAL_NAME_EDEFAULT == null ? localName != null : !LOCAL_NAME_EDEFAULT.equals ( localName );
            case GlobalizePackage.EVENT_POOL_IMPORT__INCLUDE_LOCAL:
                return includeLocal != INCLUDE_LOCAL_EDEFAULT;
            case GlobalizePackage.EVENT_POOL_IMPORT__POOL_SIZE:
                return poolSize != POOL_SIZE_EDEFAULT;
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
        result.append ( " (shortDescription: " ); //$NON-NLS-1$
        result.append ( shortDescription );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", localName: " ); //$NON-NLS-1$
        result.append ( localName );
        result.append ( ", includeLocal: " ); //$NON-NLS-1$
        result.append ( includeLocal );
        result.append ( ", poolSize: " ); //$NON-NLS-1$
        result.append ( poolSize );
        result.append ( ')' );
        return result.toString ();
    }

} //EventPoolImportImpl
