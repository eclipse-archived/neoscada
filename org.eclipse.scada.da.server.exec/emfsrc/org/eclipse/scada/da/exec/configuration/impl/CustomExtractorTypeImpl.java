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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.CustomExtractorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.CustomExtractorTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.CustomExtractorTypeImpl#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomExtractorTypeImpl extends ExtractorTypeImpl implements CustomExtractorType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getAny() <em>Any</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAny()
     * @generated
     * @ordered
     */
    protected FeatureMap any;

    /**
     * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClass_()
     * @generated
     * @ordered
     */
    protected static final String CLASS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClass_()
     * @generated
     * @ordered
     */
    protected String class_ = CLASS_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CustomExtractorTypeImpl ()
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
        return ConfigurationPackage.Literals.CUSTOM_EXTRACTOR_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FeatureMap getAny ()
    {
        if ( any == null )
        {
            any = new BasicFeatureMap ( this, ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__ANY );
        }
        return any;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getClass_ ()
    {
        return class_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setClass ( String newClass )
    {
        String oldClass = class_;
        class_ = newClass;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__CLASS, oldClass, class_ ) );
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
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__ANY:
                return ( (InternalEList<?>)getAny () ).basicRemove ( otherEnd, msgs );
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
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__ANY:
                if ( coreType )
                    return getAny ();
                return ( (FeatureMap.Internal)getAny () ).getWrapper ();
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__CLASS:
                return getClass_ ();
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
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__ANY:
                ( (FeatureMap.Internal)getAny () ).set ( newValue );
                return;
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__CLASS:
                setClass ( (String)newValue );
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
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__ANY:
                getAny ().clear ();
                return;
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__CLASS:
                setClass ( CLASS_EDEFAULT );
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
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__ANY:
                return any != null && !any.isEmpty ();
            case ConfigurationPackage.CUSTOM_EXTRACTOR_TYPE__CLASS:
                return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals ( class_ );
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
        result.append ( " (any: " ); //$NON-NLS-1$
        result.append ( any );
        result.append ( ", class: " ); //$NON-NLS-1$
        result.append ( class_ );
        result.append ( ')' );
        return result.toString ();
    }

} //CustomExtractorTypeImpl
