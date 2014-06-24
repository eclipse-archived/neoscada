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

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.component.Script;
import org.eclipse.scada.configuration.component.ScriptModule;
import org.eclipse.scada.configuration.component.Service;
import org.eclipse.scada.configuration.component.TimerScript;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getKnownInputs <em>Known Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getKnownOutputs <em>Known Outputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getScriptEngine <em>Script Engine</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getInitScript <em>Init Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getUpdateScript <em>Update Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getWriteCommandScript <em>Write Command Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getTimerScript <em>Timer Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptModuleImpl extends MinimalEObjectImpl.Container implements ScriptModule
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
     * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputs()
     * @generated
     * @ordered
     */
    protected EList<OutputSpecification> outputs;

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
     * The cached value of the '{@link #getInitScript() <em>Init Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitScript()
     * @generated
     * @ordered
     */
    protected Script initScript;

    /**
     * The cached value of the '{@link #getUpdateScript() <em>Update Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUpdateScript()
     * @generated
     * @ordered
     */
    protected Script updateScript;

    /**
     * The cached value of the '{@link #getWriteCommandScript() <em>Write Command Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWriteCommandScript()
     * @generated
     * @ordered
     */
    protected Script writeCommandScript;

    /**
     * The cached value of the '{@link #getTimerScript() <em>Timer Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimerScript()
     * @generated
     * @ordered
     */
    protected TimerScript timerScript;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ScriptModuleImpl ()
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
        return ComponentPackage.Literals.SCRIPT_MODULE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__NAME, oldName, name ) );
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
            inputs = new EObjectContainmentEList.Resolving<InputSpecification> ( InputSpecification.class, this, ComponentPackage.SCRIPT_MODULE__INPUTS );
        }
        return inputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<OutputSpecification> getOutputs ()
    {
        if ( outputs == null )
        {
            outputs = new EObjectContainmentEList.Resolving<OutputSpecification> ( OutputSpecification.class, this, ComponentPackage.SCRIPT_MODULE__OUTPUTS );
        }
        return outputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getScriptEngine ()
    {
        return scriptEngine;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScriptEngine ( String newScriptEngine )
    {
        String oldScriptEngine = scriptEngine;
        scriptEngine = newScriptEngine;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__SCRIPT_ENGINE, oldScriptEngine, scriptEngine ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script getInitScript ()
    {
        if ( initScript != null && initScript.eIsProxy () )
        {
            InternalEObject oldInitScript = (InternalEObject)initScript;
            initScript = (Script)eResolveProxy ( oldInitScript );
            if ( initScript != oldInitScript )
            {
                InternalEObject newInitScript = (InternalEObject)initScript;
                NotificationChain msgs = oldInitScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, null, null );
                if ( newInitScript.eInternalContainer () == null )
                {
                    msgs = newInitScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, oldInitScript, initScript ) );
            }
        }
        return initScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script basicGetInitScript ()
    {
        return initScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInitScript ( Script newInitScript, NotificationChain msgs )
    {
        Script oldInitScript = initScript;
        initScript = newInitScript;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, oldInitScript, newInitScript );
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
    public void setInitScript ( Script newInitScript )
    {
        if ( newInitScript != initScript )
        {
            NotificationChain msgs = null;
            if ( initScript != null )
                msgs = ( (InternalEObject)initScript ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, null, msgs );
            if ( newInitScript != null )
                msgs = ( (InternalEObject)newInitScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, null, msgs );
            msgs = basicSetInitScript ( newInitScript, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, newInitScript, newInitScript ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script getUpdateScript ()
    {
        if ( updateScript != null && updateScript.eIsProxy () )
        {
            InternalEObject oldUpdateScript = (InternalEObject)updateScript;
            updateScript = (Script)eResolveProxy ( oldUpdateScript );
            if ( updateScript != oldUpdateScript )
            {
                InternalEObject newUpdateScript = (InternalEObject)updateScript;
                NotificationChain msgs = oldUpdateScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, null, null );
                if ( newUpdateScript.eInternalContainer () == null )
                {
                    msgs = newUpdateScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, oldUpdateScript, updateScript ) );
            }
        }
        return updateScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script basicGetUpdateScript ()
    {
        return updateScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUpdateScript ( Script newUpdateScript, NotificationChain msgs )
    {
        Script oldUpdateScript = updateScript;
        updateScript = newUpdateScript;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, oldUpdateScript, newUpdateScript );
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
    public void setUpdateScript ( Script newUpdateScript )
    {
        if ( newUpdateScript != updateScript )
        {
            NotificationChain msgs = null;
            if ( updateScript != null )
                msgs = ( (InternalEObject)updateScript ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, null, msgs );
            if ( newUpdateScript != null )
                msgs = ( (InternalEObject)newUpdateScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, null, msgs );
            msgs = basicSetUpdateScript ( newUpdateScript, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, newUpdateScript, newUpdateScript ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script getWriteCommandScript ()
    {
        if ( writeCommandScript != null && writeCommandScript.eIsProxy () )
        {
            InternalEObject oldWriteCommandScript = (InternalEObject)writeCommandScript;
            writeCommandScript = (Script)eResolveProxy ( oldWriteCommandScript );
            if ( writeCommandScript != oldWriteCommandScript )
            {
                InternalEObject newWriteCommandScript = (InternalEObject)writeCommandScript;
                NotificationChain msgs = oldWriteCommandScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, null, null );
                if ( newWriteCommandScript.eInternalContainer () == null )
                {
                    msgs = newWriteCommandScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, oldWriteCommandScript, writeCommandScript ) );
            }
        }
        return writeCommandScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script basicGetWriteCommandScript ()
    {
        return writeCommandScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetWriteCommandScript ( Script newWriteCommandScript, NotificationChain msgs )
    {
        Script oldWriteCommandScript = writeCommandScript;
        writeCommandScript = newWriteCommandScript;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, oldWriteCommandScript, newWriteCommandScript );
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
    public void setWriteCommandScript ( Script newWriteCommandScript )
    {
        if ( newWriteCommandScript != writeCommandScript )
        {
            NotificationChain msgs = null;
            if ( writeCommandScript != null )
                msgs = ( (InternalEObject)writeCommandScript ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, null, msgs );
            if ( newWriteCommandScript != null )
                msgs = ( (InternalEObject)newWriteCommandScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, null, msgs );
            msgs = basicSetWriteCommandScript ( newWriteCommandScript, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, newWriteCommandScript, newWriteCommandScript ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TimerScript getTimerScript ()
    {
        if ( timerScript != null && timerScript.eIsProxy () )
        {
            InternalEObject oldTimerScript = (InternalEObject)timerScript;
            timerScript = (TimerScript)eResolveProxy ( oldTimerScript );
            if ( timerScript != oldTimerScript )
            {
                InternalEObject newTimerScript = (InternalEObject)timerScript;
                NotificationChain msgs = oldTimerScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, null, null );
                if ( newTimerScript.eInternalContainer () == null )
                {
                    msgs = newTimerScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, oldTimerScript, timerScript ) );
            }
        }
        return timerScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TimerScript basicGetTimerScript ()
    {
        return timerScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTimerScript ( TimerScript newTimerScript, NotificationChain msgs )
    {
        TimerScript oldTimerScript = timerScript;
        timerScript = newTimerScript;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, oldTimerScript, newTimerScript );
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
    public void setTimerScript ( TimerScript newTimerScript )
    {
        if ( newTimerScript != timerScript )
        {
            NotificationChain msgs = null;
            if ( timerScript != null )
                msgs = ( (InternalEObject)timerScript ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, null, msgs );
            if ( newTimerScript != null )
                msgs = ( (InternalEObject)newTimerScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, null, msgs );
            msgs = basicSetTimerScript ( newTimerScript, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, newTimerScript, newTimerScript ) );
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
    public void customENotify ( final Notification notification )
    {
        if ( notification.getFeature ().equals ( ComponentPackage.Literals.SCRIPT_MODULE__INPUTS ) )
        {
            super.eNotify ( new org.eclipse.emf.ecore.impl.ENotificationImpl ( this, notification.getEventType (), ComponentPackage.CALCULATION_MODULE__KNOWN_INPUTS, notification.getOldValue (), notification.getNewValue () ) );
        }
        if ( notification.getFeature ().equals ( ComponentPackage.Literals.SCRIPT_MODULE__OUTPUTS ) )
        {
            super.eNotify ( new org.eclipse.emf.ecore.impl.ENotificationImpl ( this, notification.getEventType (), ComponentPackage.CALCULATION_MODULE__KNOWN_OUTPUTS, notification.getOldValue (), notification.getNewValue () ) );
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
     * @generated
     */
    @Override
    public EList<OutputSpecification> getKnownOutputs ()
    {
        return getOutputs ();
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
            case ComponentPackage.SCRIPT_MODULE__INPUTS:
                return ( (InternalEList<?>)getInputs () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.SCRIPT_MODULE__OUTPUTS:
                return ( (InternalEList<?>)getOutputs () ).basicRemove ( otherEnd, msgs );
            case ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT:
                return basicSetInitScript ( null, msgs );
            case ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT:
                return basicSetUpdateScript ( null, msgs );
            case ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT:
                return basicSetWriteCommandScript ( null, msgs );
            case ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT:
                return basicSetTimerScript ( null, msgs );
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
            case ComponentPackage.SCRIPT_MODULE__SHORT_DESCRIPTION:
                return getShortDescription ();
            case ComponentPackage.SCRIPT_MODULE__NAME:
                return getName ();
            case ComponentPackage.SCRIPT_MODULE__KNOWN_INPUTS:
                return getKnownInputs ();
            case ComponentPackage.SCRIPT_MODULE__KNOWN_OUTPUTS:
                return getKnownOutputs ();
            case ComponentPackage.SCRIPT_MODULE__INPUTS:
                return getInputs ();
            case ComponentPackage.SCRIPT_MODULE__OUTPUTS:
                return getOutputs ();
            case ComponentPackage.SCRIPT_MODULE__SCRIPT_ENGINE:
                return getScriptEngine ();
            case ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT:
                if ( resolve )
                    return getInitScript ();
                return basicGetInitScript ();
            case ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT:
                if ( resolve )
                    return getUpdateScript ();
                return basicGetUpdateScript ();
            case ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT:
                if ( resolve )
                    return getWriteCommandScript ();
                return basicGetWriteCommandScript ();
            case ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT:
                if ( resolve )
                    return getTimerScript ();
                return basicGetTimerScript ();
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
            case ComponentPackage.SCRIPT_MODULE__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case ComponentPackage.SCRIPT_MODULE__NAME:
                setName ( (String)newValue );
                return;
            case ComponentPackage.SCRIPT_MODULE__INPUTS:
                getInputs ().clear ();
                getInputs ().addAll ( (Collection<? extends InputSpecification>)newValue );
                return;
            case ComponentPackage.SCRIPT_MODULE__OUTPUTS:
                getOutputs ().clear ();
                getOutputs ().addAll ( (Collection<? extends OutputSpecification>)newValue );
                return;
            case ComponentPackage.SCRIPT_MODULE__SCRIPT_ENGINE:
                setScriptEngine ( (String)newValue );
                return;
            case ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT:
                setInitScript ( (Script)newValue );
                return;
            case ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT:
                setUpdateScript ( (Script)newValue );
                return;
            case ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT:
                setWriteCommandScript ( (Script)newValue );
                return;
            case ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT:
                setTimerScript ( (TimerScript)newValue );
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
            case ComponentPackage.SCRIPT_MODULE__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case ComponentPackage.SCRIPT_MODULE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ComponentPackage.SCRIPT_MODULE__INPUTS:
                getInputs ().clear ();
                return;
            case ComponentPackage.SCRIPT_MODULE__OUTPUTS:
                getOutputs ().clear ();
                return;
            case ComponentPackage.SCRIPT_MODULE__SCRIPT_ENGINE:
                setScriptEngine ( SCRIPT_ENGINE_EDEFAULT );
                return;
            case ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT:
                setInitScript ( (Script)null );
                return;
            case ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT:
                setUpdateScript ( (Script)null );
                return;
            case ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT:
                setWriteCommandScript ( (Script)null );
                return;
            case ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT:
                setTimerScript ( (TimerScript)null );
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
            case ComponentPackage.SCRIPT_MODULE__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case ComponentPackage.SCRIPT_MODULE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ComponentPackage.SCRIPT_MODULE__KNOWN_INPUTS:
                return !getKnownInputs ().isEmpty ();
            case ComponentPackage.SCRIPT_MODULE__KNOWN_OUTPUTS:
                return !getKnownOutputs ().isEmpty ();
            case ComponentPackage.SCRIPT_MODULE__INPUTS:
                return inputs != null && !inputs.isEmpty ();
            case ComponentPackage.SCRIPT_MODULE__OUTPUTS:
                return outputs != null && !outputs.isEmpty ();
            case ComponentPackage.SCRIPT_MODULE__SCRIPT_ENGINE:
                return SCRIPT_ENGINE_EDEFAULT == null ? scriptEngine != null : !SCRIPT_ENGINE_EDEFAULT.equals ( scriptEngine );
            case ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT:
                return initScript != null;
            case ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT:
                return updateScript != null;
            case ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT:
                return writeCommandScript != null;
            case ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT:
                return timerScript != null;
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
                case ComponentPackage.SCRIPT_MODULE__KNOWN_INPUTS:
                    return ComponentPackage.CALCULATION_MODULE__KNOWN_INPUTS;
                case ComponentPackage.SCRIPT_MODULE__KNOWN_OUTPUTS:
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
                    return ComponentPackage.SCRIPT_MODULE__KNOWN_INPUTS;
                case ComponentPackage.CALCULATION_MODULE__KNOWN_OUTPUTS:
                    return ComponentPackage.SCRIPT_MODULE__KNOWN_OUTPUTS;
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
            case ComponentPackage.SCRIPT_MODULE___CUSTOM_ENOTIFY__NOTIFICATION:
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

} //ScriptModuleImpl
