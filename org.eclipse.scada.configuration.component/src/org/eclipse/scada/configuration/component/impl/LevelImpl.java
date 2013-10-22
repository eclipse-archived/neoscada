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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Level</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.LevelImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.LevelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.LevelImpl#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.LevelImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.LevelImpl#getCustomizationPipeline <em>Customization Pipeline</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.LevelImpl#getArchiveSelector <em>Archive Selector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LevelImpl extends MinimalEObjectImpl.Container implements Level
{
    /**
     * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComponents()
     * @generated
     * @ordered
     */
    protected EList<Component> components;

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
     * The cached value of the '{@link #getLevels() <em>Levels</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLevels()
     * @generated
     * @ordered
     */
    protected EList<Level> levels;

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
    protected LevelImpl ()
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
        return ComponentPackage.Literals.LEVEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Component> getComponents ()
    {
        if ( components == null )
        {
            components = new EObjectContainmentWithInverseEList<Component> ( Component.class, this, ComponentPackage.LEVEL__COMPONENTS, ComponentPackage.COMPONENT__LEVEL );
        }
        return components;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.LEVEL__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Level> getLevels ()
    {
        if ( levels == null )
        {
            levels = new EObjectContainmentWithInverseEList<Level> ( Level.class, this, ComponentPackage.LEVEL__LEVELS, ComponentPackage.LEVEL__PARENT );
        }
        return levels;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Level getParent ()
    {
        if ( eContainerFeatureID () != ComponentPackage.LEVEL__PARENT )
            return null;
        return (Level)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParent ( Level newParent, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newParent, ComponentPackage.LEVEL__PARENT, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParent ( Level newParent )
    {
        if ( newParent != eInternalContainer () || ( eContainerFeatureID () != ComponentPackage.LEVEL__PARENT && newParent != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newParent ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newParent != null )
                msgs = ( (InternalEObject)newParent ).eInverseAdd ( this, ComponentPackage.LEVEL__LEVELS, Level.class, msgs );
            msgs = basicSetParent ( newParent, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.LEVEL__PARENT, newParent, newParent ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CustomizationPipeline getCustomizationPipeline ()
    {
        if ( customizationPipeline != null && customizationPipeline.eIsProxy () )
        {
            InternalEObject oldCustomizationPipeline = (InternalEObject)customizationPipeline;
            customizationPipeline = (CustomizationPipeline)eResolveProxy ( oldCustomizationPipeline );
            if ( customizationPipeline != oldCustomizationPipeline )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.LEVEL__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, customizationPipeline ) );
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
    public void setCustomizationPipeline ( CustomizationPipeline newCustomizationPipeline )
    {
        CustomizationPipeline oldCustomizationPipeline = customizationPipeline;
        customizationPipeline = newCustomizationPipeline;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.LEVEL__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, customizationPipeline ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Selector getArchiveSelector ()
    {
        if ( archiveSelector != null && archiveSelector.eIsProxy () )
        {
            InternalEObject oldArchiveSelector = (InternalEObject)archiveSelector;
            archiveSelector = (Selector)eResolveProxy ( oldArchiveSelector );
            if ( archiveSelector != oldArchiveSelector )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.LEVEL__ARCHIVE_SELECTOR, oldArchiveSelector, archiveSelector ) );
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
    public void setArchiveSelector ( Selector newArchiveSelector )
    {
        Selector oldArchiveSelector = archiveSelector;
        archiveSelector = newArchiveSelector;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.LEVEL__ARCHIVE_SELECTOR, oldArchiveSelector, archiveSelector ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ComponentPackage.LEVEL__COMPONENTS:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getComponents () ).basicAdd ( otherEnd, msgs );
            case ComponentPackage.LEVEL__LEVELS:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getLevels () ).basicAdd ( otherEnd, msgs );
            case ComponentPackage.LEVEL__PARENT:
                if ( eInternalContainer () != null )
                    msgs = eBasicRemoveFromContainer ( msgs );
                return basicSetParent ( (Level)otherEnd, msgs );
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
            case ComponentPackage.LEVEL__COMPONENTS:
                return ( (InternalEList<?>)getComponents () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.LEVEL__LEVELS:
                return ( (InternalEList<?>)getLevels () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.LEVEL__PARENT:
                return basicSetParent ( null, msgs );
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
            case ComponentPackage.LEVEL__PARENT:
                return eInternalContainer ().eInverseRemove ( this, ComponentPackage.LEVEL__LEVELS, Level.class, msgs );
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
            case ComponentPackage.LEVEL__COMPONENTS:
                return getComponents ();
            case ComponentPackage.LEVEL__NAME:
                return getName ();
            case ComponentPackage.LEVEL__LEVELS:
                return getLevels ();
            case ComponentPackage.LEVEL__PARENT:
                return getParent ();
            case ComponentPackage.LEVEL__CUSTOMIZATION_PIPELINE:
                if ( resolve )
                    return getCustomizationPipeline ();
                return basicGetCustomizationPipeline ();
            case ComponentPackage.LEVEL__ARCHIVE_SELECTOR:
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
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ComponentPackage.LEVEL__COMPONENTS:
                getComponents ().clear ();
                getComponents ().addAll ( (Collection<? extends Component>)newValue );
                return;
            case ComponentPackage.LEVEL__NAME:
                setName ( (String)newValue );
                return;
            case ComponentPackage.LEVEL__LEVELS:
                getLevels ().clear ();
                getLevels ().addAll ( (Collection<? extends Level>)newValue );
                return;
            case ComponentPackage.LEVEL__PARENT:
                setParent ( (Level)newValue );
                return;
            case ComponentPackage.LEVEL__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)newValue );
                return;
            case ComponentPackage.LEVEL__ARCHIVE_SELECTOR:
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
            case ComponentPackage.LEVEL__COMPONENTS:
                getComponents ().clear ();
                return;
            case ComponentPackage.LEVEL__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ComponentPackage.LEVEL__LEVELS:
                getLevels ().clear ();
                return;
            case ComponentPackage.LEVEL__PARENT:
                setParent ( (Level)null );
                return;
            case ComponentPackage.LEVEL__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)null );
                return;
            case ComponentPackage.LEVEL__ARCHIVE_SELECTOR:
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
            case ComponentPackage.LEVEL__COMPONENTS:
                return components != null && !components.isEmpty ();
            case ComponentPackage.LEVEL__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ComponentPackage.LEVEL__LEVELS:
                return levels != null && !levels.isEmpty ();
            case ComponentPackage.LEVEL__PARENT:
                return getParent () != null;
            case ComponentPackage.LEVEL__CUSTOMIZATION_PIPELINE:
                return customizationPipeline != null;
            case ComponentPackage.LEVEL__ARCHIVE_SELECTOR:
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ')' );
        return result.toString ();
    }

} //LevelImpl
