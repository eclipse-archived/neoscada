/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ComponentImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ComponentImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ComponentImpl#getCustomizationPipeline <em>Customization Pipeline</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ComponentImpl#getArchiveSelector <em>Archive Selector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentImpl extends MinimalEObjectImpl.Container implements Component
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
     * The cached value of the '{@link #getCustomizationPipeline() <em>Customization Pipeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomizationPipeline()
     * @generated
     * @ordered
     */
    protected CustomizationPipeline customizationPipeline;

    /**
     * The cached value of the '{@link #getArchiveSelector() <em>Archive Selector</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArchiveSelector()
     * @generated
     * @ordered
     */
    protected Selector archiveSelector;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComponentImpl ()
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
        return ComponentPackage.Literals.COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getShortDescription ()
    {
        return shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setShortDescription ( String newShortDescription )
    {
        String oldShortDescription = shortDescription;
        shortDescription = newShortDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.COMPONENT__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Level getLevel ()
    {
        if ( eContainerFeatureID () != ComponentPackage.COMPONENT__LEVEL )
            return null;
        return (Level)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Level basicGetLevel ()
    {
        if ( eContainerFeatureID () != ComponentPackage.COMPONENT__LEVEL )
            return null;
        return (Level)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLevel ( Level newLevel, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newLevel, ComponentPackage.COMPONENT__LEVEL, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setLevel ( Level newLevel )
    {
        if ( newLevel != eInternalContainer () || ( eContainerFeatureID () != ComponentPackage.COMPONENT__LEVEL && newLevel != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newLevel ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newLevel != null )
                msgs = ( (InternalEObject)newLevel ).eInverseAdd ( this, ComponentPackage.LEVEL__COMPONENTS, Level.class, msgs );
            msgs = basicSetLevel ( newLevel, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.COMPONENT__LEVEL, newLevel, newLevel ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public CustomizationPipeline getCustomizationPipeline ()
    {
        if ( customizationPipeline != null && customizationPipeline.eIsProxy () )
        {
            InternalEObject oldCustomizationPipeline = (InternalEObject)customizationPipeline;
            customizationPipeline = (CustomizationPipeline)eResolveProxy ( oldCustomizationPipeline );
            if ( customizationPipeline != oldCustomizationPipeline )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, customizationPipeline ) );
            }
        }
        return customizationPipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomizationPipeline basicGetCustomizationPipeline ()
    {
        return customizationPipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setCustomizationPipeline ( CustomizationPipeline newCustomizationPipeline )
    {
        CustomizationPipeline oldCustomizationPipeline = customizationPipeline;
        customizationPipeline = newCustomizationPipeline;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, customizationPipeline ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Selector getArchiveSelector ()
    {
        if ( archiveSelector != null && archiveSelector.eIsProxy () )
        {
            InternalEObject oldArchiveSelector = (InternalEObject)archiveSelector;
            archiveSelector = (Selector)eResolveProxy ( oldArchiveSelector );
            if ( archiveSelector != oldArchiveSelector )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.COMPONENT__ARCHIVE_SELECTOR, oldArchiveSelector, archiveSelector ) );
            }
        }
        return archiveSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Selector basicGetArchiveSelector ()
    {
        return archiveSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setArchiveSelector ( Selector newArchiveSelector )
    {
        Selector oldArchiveSelector = archiveSelector;
        archiveSelector = newArchiveSelector;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.COMPONENT__ARCHIVE_SELECTOR, oldArchiveSelector, archiveSelector ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ComponentPackage.COMPONENT__LEVEL:
                if ( eInternalContainer () != null )
                    msgs = eBasicRemoveFromContainer ( msgs );
                return basicSetLevel ( (Level)otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
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
            case ComponentPackage.COMPONENT__LEVEL:
                return basicSetLevel ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature ( NotificationChain msgs )
    {
        switch ( eContainerFeatureID () )
        {
            case ComponentPackage.COMPONENT__LEVEL:
                return eInternalContainer ().eInverseRemove ( this, ComponentPackage.LEVEL__COMPONENTS, Level.class, msgs );
        }
        return super.eBasicRemoveFromContainerFeature ( msgs );
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
            case ComponentPackage.COMPONENT__SHORT_DESCRIPTION:
                return getShortDescription ();
            case ComponentPackage.COMPONENT__LEVEL:
                if ( resolve )
                    return getLevel ();
                return basicGetLevel ();
            case ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE:
                if ( resolve )
                    return getCustomizationPipeline ();
                return basicGetCustomizationPipeline ();
            case ComponentPackage.COMPONENT__ARCHIVE_SELECTOR:
                if ( resolve )
                    return getArchiveSelector ();
                return basicGetArchiveSelector ();
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
            case ComponentPackage.COMPONENT__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case ComponentPackage.COMPONENT__LEVEL:
                setLevel ( (Level)newValue );
                return;
            case ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)newValue );
                return;
            case ComponentPackage.COMPONENT__ARCHIVE_SELECTOR:
                setArchiveSelector ( (Selector)newValue );
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
            case ComponentPackage.COMPONENT__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case ComponentPackage.COMPONENT__LEVEL:
                setLevel ( (Level)null );
                return;
            case ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)null );
                return;
            case ComponentPackage.COMPONENT__ARCHIVE_SELECTOR:
                setArchiveSelector ( (Selector)null );
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
            case ComponentPackage.COMPONENT__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case ComponentPackage.COMPONENT__LEVEL:
                return basicGetLevel () != null;
            case ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE:
                return customizationPipeline != null;
            case ComponentPackage.COMPONENT__ARCHIVE_SELECTOR:
                return archiveSelector != null;
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
        result.append ( ')' );
        return result.toString ();
    }

} //ComponentImpl
