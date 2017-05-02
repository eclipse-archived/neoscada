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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.Components;
import org.eclipse.scada.configuration.component.FormulaModule;
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.component.Script;
import org.eclipse.scada.configuration.component.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formula Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl#getKnownInputs <em>Known Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl#getKnownOutputs <em>Known Outputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl#getUpdate <em>Update</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl#getScriptEngine <em>Script Engine</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.FormulaModuleImpl#getInit <em>Init</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FormulaModuleImpl extends MinimalEObjectImpl.Container implements FormulaModule
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
     * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputs()
     * @generated
     * @ordered
     */
    protected EList<InputSpecification> inputs;

    /**
     * The cached value of the '{@link #getUpdate() <em>Update</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpdate()
     * @generated
     * @ordered
     */
    protected Script update;

    /**
     * The default value of the '{@link #getScriptEngine() <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptEngine()
     * @generated
     * @ordered
     */
    protected static final String SCRIPT_ENGINE_EDEFAULT = "JavaScript"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getScriptEngine() <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptEngine()
     * @generated
     * @ordered
     */
    protected String scriptEngine = SCRIPT_ENGINE_EDEFAULT;

    /**
     * The cached value of the '{@link #getInit() <em>Init</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInit()
     * @generated
     * @ordered
     */
    protected EList<Script> init;

    private EList<OutputSpecification> knownOutputs;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FormulaModuleImpl ()
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
        return ComponentPackage.Literals.FORMULA_MODULE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.FORMULA_MODULE__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.FORMULA_MODULE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<InputSpecification> getKnownInputs ()
    {
        return getInputs ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<InputSpecification> getInputs ()
    {
        if ( inputs == null )
        {
            inputs = new EObjectContainmentEList.Resolving<InputSpecification> ( InputSpecification.class, this, ComponentPackage.FORMULA_MODULE__INPUTS );
        }
        return inputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Script getUpdate ()
    {
        if ( update != null && update.eIsProxy () )
        {
            InternalEObject oldUpdate = (InternalEObject)update;
            update = (Script)eResolveProxy ( oldUpdate );
            if ( update != oldUpdate )
            {
                InternalEObject newUpdate = (InternalEObject)update;
                NotificationChain msgs = oldUpdate.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.FORMULA_MODULE__UPDATE, null, null );
                if ( newUpdate.eInternalContainer () == null )
                {
                    msgs = newUpdate.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.FORMULA_MODULE__UPDATE, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.FORMULA_MODULE__UPDATE, oldUpdate, update ) );
            }
        }
        return update;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script basicGetUpdate ()
    {
        return update;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUpdate ( Script newUpdate, NotificationChain msgs )
    {
        Script oldUpdate = update;
        update = newUpdate;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.FORMULA_MODULE__UPDATE, oldUpdate, newUpdate );
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
    @Override
    public void setUpdate ( Script newUpdate )
    {
        if ( newUpdate != update )
        {
            NotificationChain msgs = null;
            if ( update != null )
                msgs = ( (InternalEObject)update ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.FORMULA_MODULE__UPDATE, null, msgs );
            if ( newUpdate != null )
                msgs = ( (InternalEObject)newUpdate ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.FORMULA_MODULE__UPDATE, null, msgs );
            msgs = basicSetUpdate ( newUpdate, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.FORMULA_MODULE__UPDATE, newUpdate, newUpdate ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getScriptEngine ()
    {
        return scriptEngine;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setScriptEngine ( String newScriptEngine )
    {
        String oldScriptEngine = scriptEngine;
        scriptEngine = newScriptEngine;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.FORMULA_MODULE__SCRIPT_ENGINE, oldScriptEngine, scriptEngine ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Script> getInit ()
    {
        if ( init == null )
        {
            init = new EObjectContainmentEList.Resolving<Script> ( Script.class, this, ComponentPackage.FORMULA_MODULE__INIT );
        }
        return init;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void customENotify ( final Notification notification )
    {
        if ( notification.getFeature ().equals ( ComponentPackage.Literals.FORMULA_MODULE__INPUTS ) )
        {
            super.eNotify ( new org.eclipse.emf.ecore.impl.ENotificationImpl ( this, notification.getEventType (), ComponentPackage.CALCULATION_MODULE__KNOWN_INPUTS, notification.getOldValue (), notification.getNewValue () ) );
        }
        super.eNotify ( notification );
    }

    /**
     * @generated NOT
     */
    @Override
    public void eNotify ( final Notification notification )
    {
        customENotify ( notification );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public EList<OutputSpecification> getKnownOutputs ()
    {
        if ( this.knownOutputs == null )
        {
            final BasicEList<OutputSpecification> outputs = ECollections.newBasicEList ();
            outputs.add ( Components.createOutput ( "output", null ) );
            this.knownOutputs = ECollections.unmodifiableEList ( outputs );
        }
        return this.knownOutputs;
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
            case ComponentPackage.FORMULA_MODULE__INPUTS:
                return ( (InternalEList<?>)getInputs () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.FORMULA_MODULE__UPDATE:
                return basicSetUpdate ( null, msgs );
            case ComponentPackage.FORMULA_MODULE__INIT:
                return ( (InternalEList<?>)getInit () ).basicRemove ( otherEnd, msgs );
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
            case ComponentPackage.FORMULA_MODULE__SHORT_DESCRIPTION:
                return getShortDescription ();
            case ComponentPackage.FORMULA_MODULE__NAME:
                return getName ();
            case ComponentPackage.FORMULA_MODULE__KNOWN_INPUTS:
                return getKnownInputs ();
            case ComponentPackage.FORMULA_MODULE__KNOWN_OUTPUTS:
                return getKnownOutputs ();
            case ComponentPackage.FORMULA_MODULE__INPUTS:
                return getInputs ();
            case ComponentPackage.FORMULA_MODULE__UPDATE:
                if ( resolve )
                    return getUpdate ();
                return basicGetUpdate ();
            case ComponentPackage.FORMULA_MODULE__SCRIPT_ENGINE:
                return getScriptEngine ();
            case ComponentPackage.FORMULA_MODULE__INIT:
                return getInit ();
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
            case ComponentPackage.FORMULA_MODULE__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case ComponentPackage.FORMULA_MODULE__NAME:
                setName ( (String)newValue );
                return;
            case ComponentPackage.FORMULA_MODULE__INPUTS:
                getInputs ().clear ();
                getInputs ().addAll ( (Collection<? extends InputSpecification>)newValue );
                return;
            case ComponentPackage.FORMULA_MODULE__UPDATE:
                setUpdate ( (Script)newValue );
                return;
            case ComponentPackage.FORMULA_MODULE__SCRIPT_ENGINE:
                setScriptEngine ( (String)newValue );
                return;
            case ComponentPackage.FORMULA_MODULE__INIT:
                getInit ().clear ();
                getInit ().addAll ( (Collection<? extends Script>)newValue );
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
            case ComponentPackage.FORMULA_MODULE__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case ComponentPackage.FORMULA_MODULE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ComponentPackage.FORMULA_MODULE__INPUTS:
                getInputs ().clear ();
                return;
            case ComponentPackage.FORMULA_MODULE__UPDATE:
                setUpdate ( (Script)null );
                return;
            case ComponentPackage.FORMULA_MODULE__SCRIPT_ENGINE:
                setScriptEngine ( SCRIPT_ENGINE_EDEFAULT );
                return;
            case ComponentPackage.FORMULA_MODULE__INIT:
                getInit ().clear ();
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
            case ComponentPackage.FORMULA_MODULE__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case ComponentPackage.FORMULA_MODULE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ComponentPackage.FORMULA_MODULE__KNOWN_INPUTS:
                return !getKnownInputs ().isEmpty ();
            case ComponentPackage.FORMULA_MODULE__KNOWN_OUTPUTS:
                return !getKnownOutputs ().isEmpty ();
            case ComponentPackage.FORMULA_MODULE__INPUTS:
                return inputs != null && !inputs.isEmpty ();
            case ComponentPackage.FORMULA_MODULE__UPDATE:
                return update != null;
            case ComponentPackage.FORMULA_MODULE__SCRIPT_ENGINE:
                return SCRIPT_ENGINE_EDEFAULT == null ? scriptEngine != null : !SCRIPT_ENGINE_EDEFAULT.equals ( scriptEngine );
            case ComponentPackage.FORMULA_MODULE__INIT:
                return init != null && !init.isEmpty ();
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
        if ( baseClass == Service.class )
        {
            switch ( derivedFeatureID )
            {
                default:
                    return -1;
            }
        }
        if ( baseClass == CalculationModule.class )
        {
            switch ( derivedFeatureID )
            {
                case ComponentPackage.FORMULA_MODULE__KNOWN_INPUTS:
                    return ComponentPackage.CALCULATION_MODULE__KNOWN_INPUTS;
                case ComponentPackage.FORMULA_MODULE__KNOWN_OUTPUTS:
                    return ComponentPackage.CALCULATION_MODULE__KNOWN_OUTPUTS;
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
        if ( baseClass == Service.class )
        {
            switch ( baseFeatureID )
            {
                default:
                    return -1;
            }
        }
        if ( baseClass == CalculationModule.class )
        {
            switch ( baseFeatureID )
            {
                case ComponentPackage.CALCULATION_MODULE__KNOWN_INPUTS:
                    return ComponentPackage.FORMULA_MODULE__KNOWN_INPUTS;
                case ComponentPackage.CALCULATION_MODULE__KNOWN_OUTPUTS:
                    return ComponentPackage.FORMULA_MODULE__KNOWN_OUTPUTS;
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
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case ComponentPackage.FORMULA_MODULE___CUSTOM_ENOTIFY__NOTIFICATION:
                customENotify ( (Notification)arguments.get ( 0 ) );
                return null;
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( ", scriptEngine: " ); //$NON-NLS-1$
        result.append ( scriptEngine );
        result.append ( ')' );
        return result.toString ();
    }

} //FormulaModuleImpl
