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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.component.MasterAssigned;
import org.eclipse.scada.configuration.component.MasterComponent;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Calculation Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getCustomizationPipeline <em>Customization Pipeline</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getArchiveSelector <em>Archive Selector</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getMasterOn <em>Master On</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getInputs <em>Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CalculationComponentImpl extends MinimalEObjectImpl.Container implements CalculationComponent
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
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> properties;

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
     * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImplementation()
     * @generated
     * @ordered
     */
    protected CalculationModule implementation;

    /**
     * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputs()
     * @generated
     * @ordered
     */
    protected EList<OutputDefinition> outputs;

    /**
     * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputs()
     * @generated
     * @ordered
     */
    protected EList<InputDefinition> inputs;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CalculationComponentImpl ()
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
        return ComponentPackage.Literals.CALCULATION_COMPONENT;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CALCULATION_COMPONENT__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CALCULATION_COMPONENT__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Level getLevel ()
    {
        if ( eContainerFeatureID () != ComponentPackage.CALCULATION_COMPONENT__LEVEL )
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
        if ( eContainerFeatureID () != ComponentPackage.CALCULATION_COMPONENT__LEVEL )
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
        msgs = eBasicSetContainer ( (InternalEObject)newLevel, ComponentPackage.CALCULATION_COMPONENT__LEVEL, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLevel ( Level newLevel )
    {
        if ( newLevel != eInternalContainer () || ( eContainerFeatureID () != ComponentPackage.CALCULATION_COMPONENT__LEVEL && newLevel != null ) )
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CALCULATION_COMPONENT__LEVEL, newLevel, newLevel ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.CALCULATION_COMPONENT__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, customizationPipeline ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CALCULATION_COMPONENT__CUSTOMIZATION_PIPELINE, oldCustomizationPipeline, customizationPipeline ) );
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
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.CALCULATION_COMPONENT__ARCHIVE_SELECTOR, oldArchiveSelector, archiveSelector ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CALCULATION_COMPONENT__ARCHIVE_SELECTOR, oldArchiveSelector, archiveSelector ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, ComponentPackage.CALCULATION_COMPONENT__PROPERTIES );
        }
        return properties;
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
            masterOn = new EObjectResolvingEList<MasterServer> ( MasterServer.class, this, ComponentPackage.CALCULATION_COMPONENT__MASTER_ON );
        }
        return masterOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CalculationModule getImplementation ()
    {
        if ( implementation != null && implementation.eIsProxy () )
        {
            InternalEObject oldImplementation = (InternalEObject)implementation;
            implementation = (CalculationModule)eResolveProxy ( oldImplementation );
            if ( implementation != oldImplementation )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.CALCULATION_COMPONENT__IMPLEMENTATION, oldImplementation, implementation ) );
            }
        }
        return implementation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CalculationModule basicGetImplementation ()
    {
        return implementation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImplementation ( CalculationModule newImplementation )
    {
        CalculationModule oldImplementation = implementation;
        implementation = newImplementation;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CALCULATION_COMPONENT__IMPLEMENTATION, oldImplementation, implementation ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OutputDefinition> getOutputs ()
    {
        if ( outputs == null )
        {
            outputs = new EObjectContainmentEList.Resolving<OutputDefinition> ( OutputDefinition.class, this, ComponentPackage.CALCULATION_COMPONENT__OUTPUTS );
        }
        return outputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InputDefinition> getInputs ()
    {
        if ( inputs == null )
        {
            inputs = new EObjectContainmentEList.Resolving<InputDefinition> ( InputDefinition.class, this, ComponentPackage.CALCULATION_COMPONENT__INPUTS );
        }
        return inputs;
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
            case ComponentPackage.CALCULATION_COMPONENT__LEVEL:
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
            case ComponentPackage.CALCULATION_COMPONENT__LEVEL:
                return basicSetLevel ( null, msgs );
            case ComponentPackage.CALCULATION_COMPONENT__PROPERTIES:
                return ( (InternalEList<?>)getProperties () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.CALCULATION_COMPONENT__OUTPUTS:
                return ( (InternalEList<?>)getOutputs () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.CALCULATION_COMPONENT__INPUTS:
                return ( (InternalEList<?>)getInputs () ).basicRemove ( otherEnd, msgs );
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
            case ComponentPackage.CALCULATION_COMPONENT__LEVEL:
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
            case ComponentPackage.CALCULATION_COMPONENT__SHORT_DESCRIPTION:
                return getShortDescription ();
            case ComponentPackage.CALCULATION_COMPONENT__NAME:
                return getName ();
            case ComponentPackage.CALCULATION_COMPONENT__LEVEL:
                if ( resolve )
                    return getLevel ();
                return basicGetLevel ();
            case ComponentPackage.CALCULATION_COMPONENT__CUSTOMIZATION_PIPELINE:
                if ( resolve )
                    return getCustomizationPipeline ();
                return basicGetCustomizationPipeline ();
            case ComponentPackage.CALCULATION_COMPONENT__ARCHIVE_SELECTOR:
                if ( resolve )
                    return getArchiveSelector ();
                return basicGetArchiveSelector ();
            case ComponentPackage.CALCULATION_COMPONENT__PROPERTIES:
                return getProperties ();
            case ComponentPackage.CALCULATION_COMPONENT__MASTER_ON:
                return getMasterOn ();
            case ComponentPackage.CALCULATION_COMPONENT__IMPLEMENTATION:
                if ( resolve )
                    return getImplementation ();
                return basicGetImplementation ();
            case ComponentPackage.CALCULATION_COMPONENT__OUTPUTS:
                return getOutputs ();
            case ComponentPackage.CALCULATION_COMPONENT__INPUTS:
                return getInputs ();
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
            case ComponentPackage.CALCULATION_COMPONENT__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__NAME:
                setName ( (String)newValue );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__LEVEL:
                setLevel ( (Level)newValue );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)newValue );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__ARCHIVE_SELECTOR:
                setArchiveSelector ( (Selector)newValue );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__PROPERTIES:
                getProperties ().clear ();
                getProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__MASTER_ON:
                getMasterOn ().clear ();
                getMasterOn ().addAll ( (Collection<? extends MasterServer>)newValue );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__IMPLEMENTATION:
                setImplementation ( (CalculationModule)newValue );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__OUTPUTS:
                getOutputs ().clear ();
                getOutputs ().addAll ( (Collection<? extends OutputDefinition>)newValue );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__INPUTS:
                getInputs ().clear ();
                getInputs ().addAll ( (Collection<? extends InputDefinition>)newValue );
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
            case ComponentPackage.CALCULATION_COMPONENT__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__LEVEL:
                setLevel ( (Level)null );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__CUSTOMIZATION_PIPELINE:
                setCustomizationPipeline ( (CustomizationPipeline)null );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__ARCHIVE_SELECTOR:
                setArchiveSelector ( (Selector)null );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__PROPERTIES:
                getProperties ().clear ();
                return;
            case ComponentPackage.CALCULATION_COMPONENT__MASTER_ON:
                getMasterOn ().clear ();
                return;
            case ComponentPackage.CALCULATION_COMPONENT__IMPLEMENTATION:
                setImplementation ( (CalculationModule)null );
                return;
            case ComponentPackage.CALCULATION_COMPONENT__OUTPUTS:
                getOutputs ().clear ();
                return;
            case ComponentPackage.CALCULATION_COMPONENT__INPUTS:
                getInputs ().clear ();
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
            case ComponentPackage.CALCULATION_COMPONENT__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case ComponentPackage.CALCULATION_COMPONENT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ComponentPackage.CALCULATION_COMPONENT__LEVEL:
                return basicGetLevel () != null;
            case ComponentPackage.CALCULATION_COMPONENT__CUSTOMIZATION_PIPELINE:
                return customizationPipeline != null;
            case ComponentPackage.CALCULATION_COMPONENT__ARCHIVE_SELECTOR:
                return archiveSelector != null;
            case ComponentPackage.CALCULATION_COMPONENT__PROPERTIES:
                return properties != null && !properties.isEmpty ();
            case ComponentPackage.CALCULATION_COMPONENT__MASTER_ON:
                return masterOn != null && !masterOn.isEmpty ();
            case ComponentPackage.CALCULATION_COMPONENT__IMPLEMENTATION:
                return implementation != null;
            case ComponentPackage.CALCULATION_COMPONENT__OUTPUTS:
                return outputs != null && !outputs.isEmpty ();
            case ComponentPackage.CALCULATION_COMPONENT__INPUTS:
                return inputs != null && !inputs.isEmpty ();
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
                case ComponentPackage.CALCULATION_COMPONENT__LEVEL:
                    return ComponentPackage.COMPONENT__LEVEL;
                case ComponentPackage.CALCULATION_COMPONENT__CUSTOMIZATION_PIPELINE:
                    return ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE;
                case ComponentPackage.CALCULATION_COMPONENT__ARCHIVE_SELECTOR:
                    return ComponentPackage.COMPONENT__ARCHIVE_SELECTOR;
                case ComponentPackage.CALCULATION_COMPONENT__PROPERTIES:
                    return ComponentPackage.COMPONENT__PROPERTIES;
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
        if ( baseClass == MasterAssigned.class )
        {
            switch ( derivedFeatureID )
            {
                case ComponentPackage.CALCULATION_COMPONENT__MASTER_ON:
                    return ComponentPackage.MASTER_ASSIGNED__MASTER_ON;
                default:
                    return -1;
            }
        }
        if ( baseClass == MasterComponent.class )
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
                    return ComponentPackage.CALCULATION_COMPONENT__LEVEL;
                case ComponentPackage.COMPONENT__CUSTOMIZATION_PIPELINE:
                    return ComponentPackage.CALCULATION_COMPONENT__CUSTOMIZATION_PIPELINE;
                case ComponentPackage.COMPONENT__ARCHIVE_SELECTOR:
                    return ComponentPackage.CALCULATION_COMPONENT__ARCHIVE_SELECTOR;
                case ComponentPackage.COMPONENT__PROPERTIES:
                    return ComponentPackage.CALCULATION_COMPONENT__PROPERTIES;
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
        if ( baseClass == MasterAssigned.class )
        {
            switch ( baseFeatureID )
            {
                case ComponentPackage.MASTER_ASSIGNED__MASTER_ON:
                    return ComponentPackage.CALCULATION_COMPONENT__MASTER_ON;
                default:
                    return -1;
            }
        }
        if ( baseClass == MasterComponent.class )
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
        result.append ( ')' );
        return result.toString ();
    }

} //CalculationComponentImpl
