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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.component.CalculationComponent;
import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.InputDefinition;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Calculation Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationComponentImpl#getInputs <em>Inputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CalculationComponentImpl extends DataComponentImpl implements CalculationComponent
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
            outputs = new EObjectContainmentEList<OutputDefinition> ( OutputDefinition.class, this, ComponentPackage.CALCULATION_COMPONENT__OUTPUTS );
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
            inputs = new EObjectContainmentEList<InputDefinition> ( InputDefinition.class, this, ComponentPackage.CALCULATION_COMPONENT__INPUTS );
        }
        return inputs;
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
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case ComponentPackage.CALCULATION_COMPONENT__SHORT_DESCRIPTION:
                return getShortDescription ();
            case ComponentPackage.CALCULATION_COMPONENT__NAME:
                return getName ();
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
        if ( baseClass == Documentable.class )
        {
            switch ( derivedFeatureID )
            {
                case ComponentPackage.CALCULATION_COMPONENT__SHORT_DESCRIPTION:
                    return WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION;
                case ComponentPackage.CALCULATION_COMPONENT__NAME:
                    return WorldPackage.DOCUMENTABLE__NAME;
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
        if ( baseClass == Documentable.class )
        {
            switch ( baseFeatureID )
            {
                case WorldPackage.DOCUMENTABLE__SHORT_DESCRIPTION:
                    return ComponentPackage.CALCULATION_COMPONENT__SHORT_DESCRIPTION;
                case WorldPackage.DOCUMENTABLE__NAME:
                    return ComponentPackage.CALCULATION_COMPONENT__NAME;
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
