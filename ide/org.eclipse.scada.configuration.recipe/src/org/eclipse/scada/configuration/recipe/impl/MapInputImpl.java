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
package org.eclipse.scada.configuration.recipe.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.recipe.MapInput;
import org.eclipse.scada.configuration.recipe.RecipePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Map Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.MapInputImpl#getLocalName <em>Local Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.MapInputImpl#getContextName <em>Context Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MapInputImpl extends MinimalEObjectImpl.Container implements MapInput
{
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
     * The default value of the '{@link #getContextName() <em>Context Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextName()
     * @generated
     * @ordered
     */
    protected static final String CONTEXT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getContextName() <em>Context Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getContextName()
     * @generated
     * @ordered
     */
    protected String contextName = CONTEXT_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MapInputImpl ()
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
        return RecipePackage.Literals.MAP_INPUT;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, RecipePackage.MAP_INPUT__LOCAL_NAME, oldLocalName, localName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getContextName ()
    {
        return contextName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContextName ( String newContextName )
    {
        String oldContextName = contextName;
        contextName = newContextName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, RecipePackage.MAP_INPUT__CONTEXT_NAME, oldContextName, contextName ) );
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
            case RecipePackage.MAP_INPUT__LOCAL_NAME:
                return getLocalName ();
            case RecipePackage.MAP_INPUT__CONTEXT_NAME:
                return getContextName ();
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
            case RecipePackage.MAP_INPUT__LOCAL_NAME:
                setLocalName ( (String)newValue );
                return;
            case RecipePackage.MAP_INPUT__CONTEXT_NAME:
                setContextName ( (String)newValue );
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
            case RecipePackage.MAP_INPUT__LOCAL_NAME:
                setLocalName ( LOCAL_NAME_EDEFAULT );
                return;
            case RecipePackage.MAP_INPUT__CONTEXT_NAME:
                setContextName ( CONTEXT_NAME_EDEFAULT );
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
            case RecipePackage.MAP_INPUT__LOCAL_NAME:
                return LOCAL_NAME_EDEFAULT == null ? localName != null : !LOCAL_NAME_EDEFAULT.equals ( localName );
            case RecipePackage.MAP_INPUT__CONTEXT_NAME:
                return CONTEXT_NAME_EDEFAULT == null ? contextName != null : !CONTEXT_NAME_EDEFAULT.equals ( contextName );
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
        result.append ( " (localName: " ); //$NON-NLS-1$
        result.append ( localName );
        result.append ( ", contextName: " ); //$NON-NLS-1$
        result.append ( contextName );
        result.append ( ')' );
        return result.toString ();
    }

} //MapInputImpl
