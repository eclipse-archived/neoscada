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
package org.eclipse.scada.configuration.component.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Globalize Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getShortDescription
 * <em>Short Description</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getLevel
 * <em>Level</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getCustomizationPipeline
 * <em>Customization Pipeline</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getArchiveSelector
 * <em>Archive Selector</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getComponents
 * <em>Components</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getSourceMaster
 * <em>Source Master</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GlobalizeComponentImpl extends MinimalEObjectImpl.Container implements GlobalizeComponent
{
    /**
     * The default value of the '{@link #getShortDescription()
     * <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getShortDescription()
     * <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getCustomizationPipeline()
     * <em>Customization Pipeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getCustomizationPipeline()
     * @generated
     * @ordered
     */
    protected CustomizationPipeline customizationPipeline;

    /**
     * The cached value of the '{@link #getArchiveSelector()
     * <em>Archive Selector</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getArchiveSelector()
     * @generated
     * @ordered
     */
    protected Selector archiveSelector;

    /**
     * The cached value of the '{@link #getComponents() <em>Components</em>}'
     * reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getComponents()
     * @generated
     * @ordered
     */
    protected EList<DataComponent> components;

    /**
     * The cached value of the '{@link #getSourceMaster()
     * <em>Source Master</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getSourceMaster()
     * @generated
     * @ordered
     */
    protected MasterImport sourceMaster;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected GlobalizeComponentImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return ComponentPackage.Literals.GLOBALIZE_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getShortDescription ()
    {
        return this.shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setShortDescription ( final String newShortDescription )
    {
        final String oldShortDescription = this.shortDescription;
        this.shortDescription = newShortDescription;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.GLOBALIZE_COMPONENT__SHORT_DESCRIPTION, oldShortDescription, this.shortDescription ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getName ()
    {
        return this.name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setName ( final String newName )
    {
        final String oldName = this.name;
        this.name = newName;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.GLOBALIZE_COMPONENT__NAME, oldName, this.name ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Level getLevel ()
    {
        if ( eContainerFeatureID () != ComponentPackage.GLOBALIZE_COMPONENT__LEVEL )
        {
            return null;
        }
        return (Level)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Level basicGetLevel ()
    {
        if ( eContainerFeatureID () != ComponentPackage.GLOBALIZE_COMPONENT__LEVEL )
        {
            return null;
        }
        return (Level)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetLevel ( final Level newLevel, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newLevel, ComponentPackage.GLOBALIZE_COMPONENT__LEVEL, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLevel ( final Level newLevel )
    {
        if ( newLevel != eInternalContainer () || eContainerFeatureID () != ComponentPackage.GLOBALIZE_COMPONENT__LEVEL && newLevel != null )
        {
            if ( EcoreUtil.isAncestor ( this, newLevel ) )
            {
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            }
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
            {
                msgs = eBasicRemoveFromContainer ( msgs );
            }
            if ( newLevel != null )
            {
                msgs = ( (InternalEObject)newLevel ).eInverseAdd ( this, ComponentPackage.LEVEL__COMPONENTS, Level.class, msgs );
            }
            msgs = basicSetLevel ( newLevel, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.GLOBALIZE_COMPONENT__LEVEL, newLevel, newLevel ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CustomizationPipeline getCustomizationPipeline ()
    {
        if ( this.customizationPipeline != null && this.customizationPipeline.eIsProxy () )
        {
            final InternalEObject oldCustomizationPipeline = (InternalEObject)this.customizationPipeline;
            this.customizationPipeline = (CustomizationPipeline)eResolveProxy ( oldCustomizationPipeline );
            if ( this.customizationPipeline != oldCustomizationPipeline )
            {
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.GLOBALIZE_COMPONENT__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, this.customizationPipeline ) );
                }
            }
        }
        return this.customizationPipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public CustomizationPipeline basicGetCustomizationPipeline ()
    {
        return this.customizationPipeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setCustomizationPipeline ( final CustomizationPipeline newCustomizationPipeline )
    {
        final CustomizationPipeline oldCustomizationPipeline = this.customizationPipeline;
        this.customizationPipeline = newCustomizationPipeline;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.GLOBALIZE_COMPONENT__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, this.customizationPipeline ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Selector getArchiveSelector ()
    {
        if ( this.archiveSelector != null && this.archiveSelector.eIsProxy () )
        {
            final InternalEObject oldArchiveSelector = (InternalEObject)this.archiveSelector;
            this.archiveSelector = (Selector)eResolveProxy ( oldArchiveSelector );
            if ( this.archiveSelector != oldArchiveSelector )
            {
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.GLOBALIZE_COMPONENT__ARCHIVE_SELECTOR, oldArchiveSelector, this.archiveSelector ) );
                }
            }
        }
        return this.archiveSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Selector basicGetArchiveSelector ()
    {
        return this.archiveSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setArchiveSelector ( final Selector newArchiveSelector )
    {
        final Selector oldArchiveSelector = this.archiveSelector;
        this.archiveSelector = newArchiveSelector;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.GLOBALIZE_COMPONENT__ARCHIVE_SELECTOR, oldArchiveSelector, this.archiveSelector ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<DataComponent> getComponents ()
    {
        if ( this.components == null )
        {
            this.components = new EObjectResolvingEList<DataComponent> ( DataComponent.class, this, ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS );
        }
        return this.components;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public MasterImport getSourceMaster ()
    {
        if ( this.sourceMaster != null && this.sourceMaster.eIsProxy () )
        {
            final InternalEObject oldSourceMaster = (InternalEObject)this.sourceMaster;
            this.sourceMaster = (MasterImport)eResolveProxy ( oldSourceMaster );
            if ( this.sourceMaster != oldSourceMaster )
            {
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER, oldSourceMaster, this.sourceMaster ) );
                }
            }
        }
        return this.sourceMaster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public MasterImport basicGetSourceMaster ()
    {
        return this.sourceMaster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSourceMaster ( final MasterImport newSourceMaster )
    {
        final MasterImport oldSourceMaster = this.sourceMaster;
        this.sourceMaster = newSourceMaster;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER, oldSourceMaster, this.sourceMaster ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public EList<MasterServer> getMasterOn ()
    {
        if ( getSourceMaster () != null && getSourceMaster ().getImportedMaster () != null )
        {
            return ECollections.singletonEList ( getSourceMaster ().getImportedMaster () );
        }
        else
        {
            return ECollections.emptyEList ();
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd ( final InternalEObject otherEnd, final int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ComponentPackage.GLOBALIZE_COMPONENT__LEVEL:
                if ( eInternalContainer () != null )
                {
                    msgs = eBasicRemoveFromContainer ( msgs );
                }
                return basicSetLevel ( (Level)otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( final InternalEObject otherEnd, final int featureID, final NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ComponentPackage.GLOBALIZE_COMPONENT__LEVEL:
                return basicSetLevel ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature ( final NotificationChain msgs )
    {
        switch ( eContainerFeatureID () )
        {
            case ComponentPackage.GLOBALIZE_COMPONENT__LEVEL:
                return eInternalContainer ().eInverseRemove ( this, ComponentPackage.LEVEL__COMPONENTS, Level.class, msgs );
        }
        return super.eBasicRemoveFromContainerFeature ( msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
    {
        switch ( featureID )
        {
            case ComponentPackage.GLOBALIZE_COMPONENT__SHORT_DESCRIPTION:
                return getShortDescription ();
            case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                return getName ();
            case ComponentPackage.GLOBALIZE_COMPONENT__LEVEL:
                if ( resolve )
                {
                    return getLevel ();
                }
                return basicGetLevel ();
            case ComponentPackage.GLOBALIZE_COMPONENT__CUSTOMIZATION_PIPELINE:
                if ( resolve )
                {
                    return getCustomizationPipeline ();
                }
                return basicGetCustomizationPipeline ();
            case ComponentPackage.GLOBALIZE_COMPONENT__ARCHIVE_SELECTOR:
                if ( resolve )
                {
                    return getArchiveSelector ();
                }
                return basicGetArchiveSelector ();
            case ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS:
                return getComponents ();
            case ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER:
                if ( resolve )
                {
                    return getSourceMaster ();
                }
                return basicGetSourceMaster ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( final int featureID, final Object newValue )
    {
        switch ( featureID )
        {
            case ComponentPackage.GLOBALIZE_COMPONENT__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                setName ( (String)newValue );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__LEVEL:
                setLevel ( (Level)newValue );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)newValue );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__ARCHIVE_SELECTOR:
                setArchiveSelector ( (Selector)newValue );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS:
                getComponents ().clear ();
                getComponents ().addAll ( (Collection<? extends DataComponent>)newValue );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER:
                setSourceMaster ( (MasterImport)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
    {
        switch ( featureID )
        {
            case ComponentPackage.GLOBALIZE_COMPONENT__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__LEVEL:
                setLevel ( (Level)null );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)null );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__ARCHIVE_SELECTOR:
                setArchiveSelector ( (Selector)null );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS:
                getComponents ().clear ();
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER:
                setSourceMaster ( (MasterImport)null );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case ComponentPackage.GLOBALIZE_COMPONENT__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? this.shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( this.shortDescription );
            case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals ( this.name );
            case ComponentPackage.GLOBALIZE_COMPONENT__LEVEL:
                return basicGetLevel () != null;
            case ComponentPackage.GLOBALIZE_COMPONENT__CUSTOMIZATION_PIPELINE:
                return this.customizationPipeline != null;
            case ComponentPackage.GLOBALIZE_COMPONENT__ARCHIVE_SELECTOR:
                return this.archiveSelector != null;
            case ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS:
                return this.components != null && !this.components.isEmpty ();
            case ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER:
                return this.sourceMaster != null;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID ( final int derivedFeatureID, final Class<?> baseClass )
    {
        if ( baseClass == Component.class )
        {
            switch ( derivedFeatureID )
            {
                case ComponentPackage.GLOBALIZE_COMPONENT__LEVEL:
                    return ComponentPackage.COMPONENT__LEVEL;
                case ComponentPackage.GLOBALIZE_COMPONENT__CUSTOMIZATION_PIPELINE:
                    return ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE;
                case ComponentPackage.GLOBALIZE_COMPONENT__ARCHIVE_SELECTOR:
                    return ComponentPackage.COMPONENT__ARCHIVE_SELECTOR;
                default:
                    return -1;
            }
        }
        if ( baseClass == DataComponent.class )
        {
            switch ( derivedFeatureID )
            {
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID ( derivedFeatureID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID ( final int baseFeatureID, final Class<?> baseClass )
    {
        if ( baseClass == Component.class )
        {
            switch ( baseFeatureID )
            {
                case ComponentPackage.COMPONENT__LEVEL:
                    return ComponentPackage.GLOBALIZE_COMPONENT__LEVEL;
                case ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE:
                    return ComponentPackage.GLOBALIZE_COMPONENT__CUSTOMIZATION_PIPELINE;
                case ComponentPackage.COMPONENT__ARCHIVE_SELECTOR:
                    return ComponentPackage.GLOBALIZE_COMPONENT__ARCHIVE_SELECTOR;
                default:
                    return -1;
            }
        }
        if ( baseClass == DataComponent.class )
        {
            switch ( baseFeatureID )
            {
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID ( baseFeatureID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int eDerivedOperationID ( final int baseOperationID, final Class<?> baseClass )
    {
        if ( baseClass == Component.class )
        {
            switch ( baseOperationID )
            {
                default:
                    return -1;
            }
        }
        if ( baseClass == DataComponent.class )
        {
            switch ( baseOperationID )
            {
                case ComponentPackage.DATA_COMPONENT___GET_MASTER_ON:
                    return ComponentPackage.GLOBALIZE_COMPONENT___GET_MASTER_ON;
                default:
                    return -1;
            }
        }
        return super.eDerivedOperationID ( baseOperationID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eInvoke ( final int operationID, final EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case ComponentPackage.GLOBALIZE_COMPONENT___GET_MASTER_ON:
                return getMasterOn ();
        }
        return super.eInvoke ( operationID, arguments );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
        {
            return super.toString ();
        }

        final StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (shortDescription: " ); //$NON-NLS-1$
        result.append ( this.shortDescription );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( this.name );
        result.append ( ')' );
        return result.toString ();
    }

} //GlobalizeComponentImpl
