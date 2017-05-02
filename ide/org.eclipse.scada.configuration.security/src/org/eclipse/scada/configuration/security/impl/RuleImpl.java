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
package org.eclipse.scada.configuration.security.impl;

import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.scada.configuration.security.Rule;
import org.eclipse.scada.configuration.security.Script;
import org.eclipse.scada.configuration.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.RuleImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.RuleImpl#getIdFilter <em>Id Filter</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.RuleImpl#getActionFilter <em>Action Filter</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.RuleImpl#getTypeFilter <em>Type Filter</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.RuleImpl#getFilterScript <em>Filter Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RuleImpl extends EObjectImpl implements Rule
{
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
     * The default value of the '{@link #getIdFilter() <em>Id Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIdFilter()
     * @generated
     * @ordered
     */
    protected static final Pattern ID_FILTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIdFilter() <em>Id Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIdFilter()
     * @generated
     * @ordered
     */
    protected Pattern idFilter = ID_FILTER_EDEFAULT;

    /**
     * The default value of the '{@link #getActionFilter() <em>Action Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActionFilter()
     * @generated
     * @ordered
     */
    protected static final Pattern ACTION_FILTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getActionFilter() <em>Action Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActionFilter()
     * @generated
     * @ordered
     */
    protected Pattern actionFilter = ACTION_FILTER_EDEFAULT;

    /**
     * The default value of the '{@link #getTypeFilter() <em>Type Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypeFilter()
     * @generated
     * @ordered
     */
    protected static final Pattern TYPE_FILTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTypeFilter() <em>Type Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTypeFilter()
     * @generated
     * @ordered
     */
    protected Pattern typeFilter = TYPE_FILTER_EDEFAULT;

    /**
     * The cached value of the '{@link #getFilterScript() <em>Filter Script</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilterScript()
     * @generated
     * @ordered
     */
    protected Script filterScript;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RuleImpl ()
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
        return SecurityPackage.Literals.RULE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, SecurityPackage.RULE__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern getIdFilter ()
    {
        return idFilter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIdFilter ( Pattern newIdFilter )
    {
        Pattern oldIdFilter = idFilter;
        idFilter = newIdFilter;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SecurityPackage.RULE__ID_FILTER, oldIdFilter, idFilter ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern getActionFilter ()
    {
        return actionFilter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setActionFilter ( Pattern newActionFilter )
    {
        Pattern oldActionFilter = actionFilter;
        actionFilter = newActionFilter;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SecurityPackage.RULE__ACTION_FILTER, oldActionFilter, actionFilter ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern getTypeFilter ()
    {
        return typeFilter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTypeFilter ( Pattern newTypeFilter )
    {
        Pattern oldTypeFilter = typeFilter;
        typeFilter = newTypeFilter;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SecurityPackage.RULE__TYPE_FILTER, oldTypeFilter, typeFilter ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script getFilterScript ()
    {
        if ( filterScript != null && filterScript.eIsProxy () )
        {
            InternalEObject oldFilterScript = (InternalEObject)filterScript;
            filterScript = (Script)eResolveProxy ( oldFilterScript );
            if ( filterScript != oldFilterScript )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, SecurityPackage.RULE__FILTER_SCRIPT, oldFilterScript, filterScript ) );
            }
        }
        return filterScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script basicGetFilterScript ()
    {
        return filterScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFilterScript ( Script newFilterScript )
    {
        Script oldFilterScript = filterScript;
        filterScript = newFilterScript;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SecurityPackage.RULE__FILTER_SCRIPT, oldFilterScript, filterScript ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getRuleType ()
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
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
            case SecurityPackage.RULE__ID:
                return getId ();
            case SecurityPackage.RULE__ID_FILTER:
                return getIdFilter ();
            case SecurityPackage.RULE__ACTION_FILTER:
                return getActionFilter ();
            case SecurityPackage.RULE__TYPE_FILTER:
                return getTypeFilter ();
            case SecurityPackage.RULE__FILTER_SCRIPT:
                if ( resolve )
                    return getFilterScript ();
                return basicGetFilterScript ();
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
            case SecurityPackage.RULE__ID:
                setId ( (String)newValue );
                return;
            case SecurityPackage.RULE__ID_FILTER:
                setIdFilter ( (Pattern)newValue );
                return;
            case SecurityPackage.RULE__ACTION_FILTER:
                setActionFilter ( (Pattern)newValue );
                return;
            case SecurityPackage.RULE__TYPE_FILTER:
                setTypeFilter ( (Pattern)newValue );
                return;
            case SecurityPackage.RULE__FILTER_SCRIPT:
                setFilterScript ( (Script)newValue );
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
            case SecurityPackage.RULE__ID:
                setId ( ID_EDEFAULT );
                return;
            case SecurityPackage.RULE__ID_FILTER:
                setIdFilter ( ID_FILTER_EDEFAULT );
                return;
            case SecurityPackage.RULE__ACTION_FILTER:
                setActionFilter ( ACTION_FILTER_EDEFAULT );
                return;
            case SecurityPackage.RULE__TYPE_FILTER:
                setTypeFilter ( TYPE_FILTER_EDEFAULT );
                return;
            case SecurityPackage.RULE__FILTER_SCRIPT:
                setFilterScript ( (Script)null );
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
            case SecurityPackage.RULE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case SecurityPackage.RULE__ID_FILTER:
                return ID_FILTER_EDEFAULT == null ? idFilter != null : !ID_FILTER_EDEFAULT.equals ( idFilter );
            case SecurityPackage.RULE__ACTION_FILTER:
                return ACTION_FILTER_EDEFAULT == null ? actionFilter != null : !ACTION_FILTER_EDEFAULT.equals ( actionFilter );
            case SecurityPackage.RULE__TYPE_FILTER:
                return TYPE_FILTER_EDEFAULT == null ? typeFilter != null : !TYPE_FILTER_EDEFAULT.equals ( typeFilter );
            case SecurityPackage.RULE__FILTER_SCRIPT:
                return filterScript != null;
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
        result.append ( ", idFilter: " ); //$NON-NLS-1$
        result.append ( idFilter );
        result.append ( ", actionFilter: " ); //$NON-NLS-1$
        result.append ( actionFilter );
        result.append ( ", typeFilter: " ); //$NON-NLS-1$
        result.append ( typeFilter );
        result.append ( ')' );
        return result.toString ();
    }

} //RuleImpl
