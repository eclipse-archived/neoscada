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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.component.MappedSourceValue;
import org.eclipse.scada.configuration.component.MasterComponent;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Source Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getCustomizationPipeline <em>Customization Pipeline</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getArchiveSelector <em>Archive Selector</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getMasterOn <em>Master On</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getMapper <em>Mapper</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MappedSourceValueImpl#getCustomizationTags <em>Customization Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappedSourceValueImpl extends MinimalEObjectImpl.Container implements MappedSourceValue
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
     * The cached value of the '{@link #getMasterOn() <em>Master On</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMasterOn()
     * @generated
     * @ordered
     */
    protected EList<MasterServer> masterOn;

    /**
     * The cached value of the '{@link #getMapper() <em>Mapper</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMapper()
     * @generated
     * @ordered
     */
    protected DataMapperService mapper;

    /**
     * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInput()
     * @generated
     * @ordered
     */
    protected InputDefinition input;

    /**
     * The cached value of the '{@link #getCustomizationTags() <em>Customization Tags</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCustomizationTags()
     * @generated
     * @ordered
     */
    protected EList<String> customizationTags;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MappedSourceValueImpl ()
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
        return ComponentPackage.Literals.MAPPED_SOURCE_VALUE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Level getLevel ()
    {
        if ( eContainerFeatureID () != ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL )
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
        if ( eContainerFeatureID () != ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL )
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
        msgs = eBasicSetContainer ( (InternalEObject)newLevel, ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLevel ( Level newLevel )
    {
        if ( newLevel != eInternalContainer () || ( eContainerFeatureID () != ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL && newLevel != null ) )
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL, newLevel, newLevel ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, customizationPipeline ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, customizationPipeline ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.MAPPED_SOURCE_VALUE__ARCHIVE_SELECTOR, oldArchiveSelector, archiveSelector ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__ARCHIVE_SELECTOR, oldArchiveSelector, archiveSelector ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MasterServer> getMasterOn ()
    {
        if ( masterOn == null )
        {
            masterOn = new EObjectResolvingEList<MasterServer> ( MasterServer.class, this, ComponentPackage.MAPPED_SOURCE_VALUE__MASTER_ON );
        }
        return masterOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperService getMapper ()
    {
        if ( mapper != null && mapper.eIsProxy () )
        {
            InternalEObject oldMapper = (InternalEObject)mapper;
            mapper = (DataMapperService)eResolveProxy ( oldMapper );
            if ( mapper != oldMapper )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER, oldMapper, mapper ) );
            }
        }
        return mapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperService basicGetMapper ()
    {
        return mapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMapper ( DataMapperService newMapper )
    {
        DataMapperService oldMapper = mapper;
        mapper = newMapper;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER, oldMapper, mapper ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition getInput ()
    {
        if ( input != null && input.eIsProxy () )
        {
            InternalEObject oldInput = (InternalEObject)input;
            input = (InputDefinition)eResolveProxy ( oldInput );
            if ( input != oldInput )
            {
                InternalEObject newInput = (InternalEObject)input;
                NotificationChain msgs = oldInput.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, null );
                if ( newInput.eInternalContainer () == null )
                {
                    msgs = newInput.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, oldInput, input ) );
            }
        }
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition basicGetInput ()
    {
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInput ( InputDefinition newInput, NotificationChain msgs )
    {
        InputDefinition oldInput = input;
        input = newInput;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, oldInput, newInput );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInput ( InputDefinition newInput )
    {
        if ( newInput != input )
        {
            NotificationChain msgs = null;
            if ( input != null )
                msgs = ( (InternalEObject)input ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, msgs );
            if ( newInput != null )
                msgs = ( (InternalEObject)newInput ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, null, msgs );
            msgs = basicSetInput ( newInput, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MAPPED_SOURCE_VALUE__INPUT, newInput, newInput ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getCustomizationTags ()
    {
        if ( customizationTags == null )
        {
            customizationTags = new EDataTypeUniqueEList<String> ( String.class, this, ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_TAGS );
        }
        return customizationTags;
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL:
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL:
                return basicSetLevel ( null, msgs );
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                return basicSetInput ( null, msgs );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL:
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION:
                return getShortDescription ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__NAME:
                return getName ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL:
                if ( resolve )
                    return getLevel ();
                return basicGetLevel ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_PIPELINE:
                if ( resolve )
                    return getCustomizationPipeline ();
                return basicGetCustomizationPipeline ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__ARCHIVE_SELECTOR:
                if ( resolve )
                    return getArchiveSelector ();
                return basicGetArchiveSelector ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__MASTER_ON:
                return getMasterOn ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                if ( resolve )
                    return getMapper ();
                return basicGetMapper ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                if ( resolve )
                    return getInput ();
                return basicGetInput ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_TAGS:
                return getCustomizationTags ();
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__NAME:
                setName ( (String)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL:
                setLevel ( (Level)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__ARCHIVE_SELECTOR:
                setArchiveSelector ( (Selector)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__MASTER_ON:
                getMasterOn ().clear ();
                getMasterOn ().addAll ( (Collection<? extends MasterServer>)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                setMapper ( (DataMapperService)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                setInput ( (InputDefinition)newValue );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_TAGS:
                getCustomizationTags ().clear ();
                getCustomizationTags ().addAll ( (Collection<? extends String>)newValue );
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL:
                setLevel ( (Level)null );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)null );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__ARCHIVE_SELECTOR:
                setArchiveSelector ( (Selector)null );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__MASTER_ON:
                getMasterOn ().clear ();
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                setMapper ( (DataMapperService)null );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                setInput ( (InputDefinition)null );
                return;
            case ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_TAGS:
                getCustomizationTags ().clear ();
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
            case ComponentPackage.MAPPED_SOURCE_VALUE__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case ComponentPackage.MAPPED_SOURCE_VALUE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL:
                return basicGetLevel () != null;
            case ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_PIPELINE:
                return customizationPipeline != null;
            case ComponentPackage.MAPPED_SOURCE_VALUE__ARCHIVE_SELECTOR:
                return archiveSelector != null;
            case ComponentPackage.MAPPED_SOURCE_VALUE__MASTER_ON:
                return masterOn != null && !masterOn.isEmpty ();
            case ComponentPackage.MAPPED_SOURCE_VALUE__MAPPER:
                return mapper != null;
            case ComponentPackage.MAPPED_SOURCE_VALUE__INPUT:
                return input != null;
            case ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_TAGS:
                return customizationTags != null && !customizationTags.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID ( int derivedFeatureID, Class<?> baseClass )
    {
        if ( baseClass == Component.class )
        {
            switch ( derivedFeatureID )
            {
                case ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL:
                    return ComponentPackage.COMPONENT__LEVEL;
                case ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_PIPELINE:
                    return ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE;
                case ComponentPackage.MAPPED_SOURCE_VALUE__ARCHIVE_SELECTOR:
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
        if ( baseClass == MasterComponent.class )
        {
            switch ( derivedFeatureID )
            {
                case ComponentPackage.MAPPED_SOURCE_VALUE__MASTER_ON:
                    return ComponentPackage.MASTER_COMPONENT__MASTER_ON;
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID ( derivedFeatureID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID ( int baseFeatureID, Class<?> baseClass )
    {
        if ( baseClass == Component.class )
        {
            switch ( baseFeatureID )
            {
                case ComponentPackage.COMPONENT__LEVEL:
                    return ComponentPackage.MAPPED_SOURCE_VALUE__LEVEL;
                case ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE:
                    return ComponentPackage.MAPPED_SOURCE_VALUE__CUSTOMIZATION_PIPELINE;
                case ComponentPackage.COMPONENT__ARCHIVE_SELECTOR:
                    return ComponentPackage.MAPPED_SOURCE_VALUE__ARCHIVE_SELECTOR;
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
        if ( baseClass == MasterComponent.class )
        {
            switch ( baseFeatureID )
            {
                case ComponentPackage.MASTER_COMPONENT__MASTER_ON:
                    return ComponentPackage.MAPPED_SOURCE_VALUE__MASTER_ON;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID ( baseFeatureID, baseClass );
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
        result.append ( ", customizationTags: " ); //$NON-NLS-1$
        result.append ( customizationTags );
        result.append ( ')' );
        return result.toString ();
    }

} //MappedSourceValueImpl
