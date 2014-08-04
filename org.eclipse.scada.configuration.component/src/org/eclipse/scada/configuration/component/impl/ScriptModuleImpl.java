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
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getShortDescription
 * <em>Short Description</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getKnownInputs
 * <em>Known Inputs</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getKnownOutputs
 * <em>Known Outputs</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getInputs
 * <em>Inputs</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getOutputs
 * <em>Outputs</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getScriptEngine
 * <em>Script Engine</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getInitScript
 * <em>Init Script</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getUpdateScript
 * <em>Update Script</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getWriteCommandScript
 * <em>Write Command Script</em>}</li>
 * <li>
 * {@link org.eclipse.scada.configuration.component.impl.ScriptModuleImpl#getTimerScript
 * <em>Timer Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptModuleImpl extends MinimalEObjectImpl.Container implements ScriptModule
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
     * The cached value of the '{@link #getInputs() <em>Inputs</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getInputs()
     * @generated
     * @ordered
     */
    protected EList<InputSpecification> inputs;

    /**
     * The cached value of the '{@link #getOutputs() <em>Outputs</em>}'
     * containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getOutputs()
     * @generated
     * @ordered
     */
    protected EList<OutputSpecification> outputs;

    /**
     * The default value of the '{@link #getScriptEngine()
     * <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getScriptEngine()
     * @generated
     * @ordered
     */
    protected static final String SCRIPT_ENGINE_EDEFAULT = "JavaScript"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getScriptEngine()
     * <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getScriptEngine()
     * @generated
     * @ordered
     */
    protected String scriptEngine = SCRIPT_ENGINE_EDEFAULT;

    /**
     * The cached value of the '{@link #getInitScript() <em>Init Script</em>}'
     * containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getInitScript()
     * @generated
     * @ordered
     */
    protected Script initScript;

    /**
     * The cached value of the '{@link #getUpdateScript()
     * <em>Update Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getUpdateScript()
     * @generated
     * @ordered
     */
    protected Script updateScript;

    /**
     * The cached value of the '{@link #getWriteCommandScript()
     * <em>Write Command Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getWriteCommandScript()
     * @generated
     * @ordered
     */
    protected Script writeCommandScript;

    /**
     * The cached value of the '{@link #getTimerScript() <em>Timer Script</em>}'
     * containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getTimerScript()
     * @generated
     * @ordered
     */
    protected TimerScript timerScript;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected ScriptModuleImpl ()
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
        return ComponentPackage.Literals.SCRIPT_MODULE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__SHORT_DESCRIPTION, oldShortDescription, this.shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__NAME, oldName, this.name ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<InputSpecification> getInputs ()
    {
        if ( this.inputs == null )
        {
            this.inputs = new EObjectContainmentEList.Resolving<InputSpecification> ( InputSpecification.class, this, ComponentPackage.SCRIPT_MODULE__INPUTS );
        }
        return this.inputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<OutputSpecification> getOutputs ()
    {
        if ( this.outputs == null )
        {
            this.outputs = new EObjectContainmentEList.Resolving<OutputSpecification> ( OutputSpecification.class, this, ComponentPackage.SCRIPT_MODULE__OUTPUTS );
        }
        return this.outputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getScriptEngine ()
    {
        return this.scriptEngine;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setScriptEngine ( final String newScriptEngine )
    {
        final String oldScriptEngine = this.scriptEngine;
        this.scriptEngine = newScriptEngine;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__SCRIPT_ENGINE, oldScriptEngine, this.scriptEngine ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Script getInitScript ()
    {
        if ( this.initScript != null && this.initScript.eIsProxy () )
        {
            final InternalEObject oldInitScript = (InternalEObject)this.initScript;
            this.initScript = (Script)eResolveProxy ( oldInitScript );
            if ( this.initScript != oldInitScript )
            {
                final InternalEObject newInitScript = (InternalEObject)this.initScript;
                NotificationChain msgs = oldInitScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, null, null );
                if ( newInitScript.eInternalContainer () == null )
                {
                    msgs = newInitScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, null, msgs );
                }
                if ( msgs != null )
                {
                    msgs.dispatch ();
                }
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, oldInitScript, this.initScript ) );
                }
            }
        }
        return this.initScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Script basicGetInitScript ()
    {
        return this.initScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetInitScript ( final Script newInitScript, NotificationChain msgs )
    {
        final Script oldInitScript = this.initScript;
        this.initScript = newInitScript;
        if ( eNotificationRequired () )
        {
            final ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, oldInitScript, newInitScript );
            if ( msgs == null )
            {
                msgs = notification;
            }
            else
            {
                msgs.add ( notification );
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInitScript ( final Script newInitScript )
    {
        if ( newInitScript != this.initScript )
        {
            NotificationChain msgs = null;
            if ( this.initScript != null )
            {
                msgs = ( (InternalEObject)this.initScript ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, null, msgs );
            }
            if ( newInitScript != null )
            {
                msgs = ( (InternalEObject)newInitScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, null, msgs );
            }
            msgs = basicSetInitScript ( newInitScript, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT, newInitScript, newInitScript ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Script getUpdateScript ()
    {
        if ( this.updateScript != null && this.updateScript.eIsProxy () )
        {
            final InternalEObject oldUpdateScript = (InternalEObject)this.updateScript;
            this.updateScript = (Script)eResolveProxy ( oldUpdateScript );
            if ( this.updateScript != oldUpdateScript )
            {
                final InternalEObject newUpdateScript = (InternalEObject)this.updateScript;
                NotificationChain msgs = oldUpdateScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, null, null );
                if ( newUpdateScript.eInternalContainer () == null )
                {
                    msgs = newUpdateScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, null, msgs );
                }
                if ( msgs != null )
                {
                    msgs.dispatch ();
                }
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, oldUpdateScript, this.updateScript ) );
                }
            }
        }
        return this.updateScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Script basicGetUpdateScript ()
    {
        return this.updateScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetUpdateScript ( final Script newUpdateScript, NotificationChain msgs )
    {
        final Script oldUpdateScript = this.updateScript;
        this.updateScript = newUpdateScript;
        if ( eNotificationRequired () )
        {
            final ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, oldUpdateScript, newUpdateScript );
            if ( msgs == null )
            {
                msgs = notification;
            }
            else
            {
                msgs.add ( notification );
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setUpdateScript ( final Script newUpdateScript )
    {
        if ( newUpdateScript != this.updateScript )
        {
            NotificationChain msgs = null;
            if ( this.updateScript != null )
            {
                msgs = ( (InternalEObject)this.updateScript ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, null, msgs );
            }
            if ( newUpdateScript != null )
            {
                msgs = ( (InternalEObject)newUpdateScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, null, msgs );
            }
            msgs = basicSetUpdateScript ( newUpdateScript, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT, newUpdateScript, newUpdateScript ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Script getWriteCommandScript ()
    {
        if ( this.writeCommandScript != null && this.writeCommandScript.eIsProxy () )
        {
            final InternalEObject oldWriteCommandScript = (InternalEObject)this.writeCommandScript;
            this.writeCommandScript = (Script)eResolveProxy ( oldWriteCommandScript );
            if ( this.writeCommandScript != oldWriteCommandScript )
            {
                final InternalEObject newWriteCommandScript = (InternalEObject)this.writeCommandScript;
                NotificationChain msgs = oldWriteCommandScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, null, null );
                if ( newWriteCommandScript.eInternalContainer () == null )
                {
                    msgs = newWriteCommandScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, null, msgs );
                }
                if ( msgs != null )
                {
                    msgs.dispatch ();
                }
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, oldWriteCommandScript, this.writeCommandScript ) );
                }
            }
        }
        return this.writeCommandScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public Script basicGetWriteCommandScript ()
    {
        return this.writeCommandScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetWriteCommandScript ( final Script newWriteCommandScript, NotificationChain msgs )
    {
        final Script oldWriteCommandScript = this.writeCommandScript;
        this.writeCommandScript = newWriteCommandScript;
        if ( eNotificationRequired () )
        {
            final ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, oldWriteCommandScript, newWriteCommandScript );
            if ( msgs == null )
            {
                msgs = notification;
            }
            else
            {
                msgs.add ( notification );
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setWriteCommandScript ( final Script newWriteCommandScript )
    {
        if ( newWriteCommandScript != this.writeCommandScript )
        {
            NotificationChain msgs = null;
            if ( this.writeCommandScript != null )
            {
                msgs = ( (InternalEObject)this.writeCommandScript ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, null, msgs );
            }
            if ( newWriteCommandScript != null )
            {
                msgs = ( (InternalEObject)newWriteCommandScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, null, msgs );
            }
            msgs = basicSetWriteCommandScript ( newWriteCommandScript, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT, newWriteCommandScript, newWriteCommandScript ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public TimerScript getTimerScript ()
    {
        if ( this.timerScript != null && this.timerScript.eIsProxy () )
        {
            final InternalEObject oldTimerScript = (InternalEObject)this.timerScript;
            this.timerScript = (TimerScript)eResolveProxy ( oldTimerScript );
            if ( this.timerScript != oldTimerScript )
            {
                final InternalEObject newTimerScript = (InternalEObject)this.timerScript;
                NotificationChain msgs = oldTimerScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, null, null );
                if ( newTimerScript.eInternalContainer () == null )
                {
                    msgs = newTimerScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, null, msgs );
                }
                if ( msgs != null )
                {
                    msgs.dispatch ();
                }
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, oldTimerScript, this.timerScript ) );
                }
            }
        }
        return this.timerScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public TimerScript basicGetTimerScript ()
    {
        return this.timerScript;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetTimerScript ( final TimerScript newTimerScript, NotificationChain msgs )
    {
        final TimerScript oldTimerScript = this.timerScript;
        this.timerScript = newTimerScript;
        if ( eNotificationRequired () )
        {
            final ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, oldTimerScript, newTimerScript );
            if ( msgs == null )
            {
                msgs = notification;
            }
            else
            {
                msgs.add ( notification );
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setTimerScript ( final TimerScript newTimerScript )
    {
        if ( newTimerScript != this.timerScript )
        {
            NotificationChain msgs = null;
            if ( this.timerScript != null )
            {
                msgs = ( (InternalEObject)this.timerScript ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, null, msgs );
            }
            if ( newTimerScript != null )
            {
                msgs = ( (InternalEObject)newTimerScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, null, msgs );
            }
            msgs = basicSetTimerScript ( newTimerScript, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT, newTimerScript, newTimerScript ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
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
     *
     * @generated NOT
     */
    protected void customENotify ( final Notification notification )
    {
        if ( notification.getFeature ().equals ( ComponentPackage.Literals.SCRIPT_MODULE__INPUTS ) )
        {
            super.eNotify ( new org.eclipse.emf.ecore.impl.ENotificationImpl ( this, notification.getEventType (), ComponentPackage.SCRIPT_MODULE__KNOWN_INPUTS, notification.getOldValue (), notification.getNewValue (), notification.getPosition (), notification.wasSet () ) );
        }
        if ( notification.getFeature ().equals ( ComponentPackage.Literals.SCRIPT_MODULE__OUTPUTS ) )
        {
            super.eNotify ( new org.eclipse.emf.ecore.impl.ENotificationImpl ( this, notification.getEventType (), ComponentPackage.SCRIPT_MODULE__KNOWN_OUTPUTS, notification.getOldValue (), notification.getNewValue (), notification.getPosition (), notification.wasSet () ) );
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
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( final InternalEObject otherEnd, final int featureID, final NotificationChain msgs )
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
     *
     * @generated
     */
    @Override
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
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
                {
                    return getInitScript ();
                }
                return basicGetInitScript ();
            case ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT:
                if ( resolve )
                {
                    return getUpdateScript ();
                }
                return basicGetUpdateScript ();
            case ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT:
                if ( resolve )
                {
                    return getWriteCommandScript ();
                }
                return basicGetWriteCommandScript ();
            case ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT:
                if ( resolve )
                {
                    return getTimerScript ();
                }
                return basicGetTimerScript ();
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
     *
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
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
     *
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case ComponentPackage.SCRIPT_MODULE__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? this.shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( this.shortDescription );
            case ComponentPackage.SCRIPT_MODULE__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals ( this.name );
            case ComponentPackage.SCRIPT_MODULE__KNOWN_INPUTS:
                return !getKnownInputs ().isEmpty ();
            case ComponentPackage.SCRIPT_MODULE__KNOWN_OUTPUTS:
                return !getKnownOutputs ().isEmpty ();
            case ComponentPackage.SCRIPT_MODULE__INPUTS:
                return this.inputs != null && !this.inputs.isEmpty ();
            case ComponentPackage.SCRIPT_MODULE__OUTPUTS:
                return this.outputs != null && !this.outputs.isEmpty ();
            case ComponentPackage.SCRIPT_MODULE__SCRIPT_ENGINE:
                return SCRIPT_ENGINE_EDEFAULT == null ? this.scriptEngine != null : !SCRIPT_ENGINE_EDEFAULT.equals ( this.scriptEngine );
            case ComponentPackage.SCRIPT_MODULE__INIT_SCRIPT:
                return this.initScript != null;
            case ComponentPackage.SCRIPT_MODULE__UPDATE_SCRIPT:
                return this.updateScript != null;
            case ComponentPackage.SCRIPT_MODULE__WRITE_COMMAND_SCRIPT:
                return this.writeCommandScript != null;
            case ComponentPackage.SCRIPT_MODULE__TIMER_SCRIPT:
                return this.timerScript != null;
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
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID ( final int baseFeatureID, final Class<?> baseClass )
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
        result.append ( ", scriptEngine: " ); //$NON-NLS-1$
        result.append ( this.scriptEngine );
        result.append ( ')' );
        return result.toString ();
    }

} //ScriptModuleImpl
