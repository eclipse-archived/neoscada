/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.Components;
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.MovingAverageModule;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.MovingAverageReferenceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Moving Average Module</b></em>
 * '.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MovingAverageModuleImpl#getNullRange <em>Null Range</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MovingAverageModuleImpl#getRange <em>Range</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MovingAverageModuleImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MovingAverageModuleImpl#isTriggerOnly <em>Trigger Only</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MovingAverageModuleImpl extends CalculationModuleImpl implements MovingAverageModule
{
    /**
     * The default value of the '{@link #getNullRange() <em>Null Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNullRange()
     * @generated
     * @ordered
     */
    protected static final long NULL_RANGE_EDEFAULT = 30L;

    /**
     * The cached value of the '{@link #getNullRange() <em>Null Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNullRange()
     * @generated
     * @ordered
     */
    protected long nullRange = NULL_RANGE_EDEFAULT;

    /**
     * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRange()
     * @generated
     * @ordered
     */
    protected static final long RANGE_EDEFAULT = 60L;

    /**
     * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRange()
     * @generated
     * @ordered
     */
    protected long range = RANGE_EDEFAULT;

    /**
     * The default value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTrigger()
     * @generated
     * @ordered
     */
    protected static final long TRIGGER_EDEFAULT = 1L;

    /**
     * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTrigger()
     * @generated
     * @ordered
     */
    protected long trigger = TRIGGER_EDEFAULT;

    /**
     * The default value of the '{@link #isTriggerOnly() <em>Trigger Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTriggerOnly()
     * @generated
     * @ordered
     */
    protected static final boolean TRIGGER_ONLY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isTriggerOnly() <em>Trigger Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTriggerOnly()
     * @generated
     * @ordered
     */
    protected boolean triggerOnly = TRIGGER_ONLY_EDEFAULT;

    private EList<InputSpecification> knownInputs;

    private EList<OutputSpecification> knownOutputs;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MovingAverageModuleImpl ()
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
        return ComponentPackage.Literals.MOVING_AVERAGE_MODULE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public EList<InputSpecification> getKnownInputs ()
    {
        if ( this.knownInputs == null )
        {
            final BasicEList<InputSpecification> inputs = ECollections.newBasicEList ();
            inputs.add ( Components.createInput ( "input" ) );
            this.knownInputs = ECollections.unmodifiableEList ( inputs );
        }
        return this.knownInputs;
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
            for ( final MovingAverageReferenceType type : MovingAverageReferenceType.values () )
            {
                outputs.add ( Components.createOutput ( type.getLiteral (), DataType.FLOAT ) );
            }
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
    public long getNullRange ()
    {
        return nullRange;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setNullRange ( long newNullRange )
    {
        long oldNullRange = nullRange;
        nullRange = newNullRange;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MOVING_AVERAGE_MODULE__NULL_RANGE, oldNullRange, nullRange ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public long getRange ()
    {
        return range;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setRange ( long newRange )
    {
        long oldRange = range;
        range = newRange;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MOVING_AVERAGE_MODULE__RANGE, oldRange, range ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public long getTrigger ()
    {
        return trigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTrigger ( long newTrigger )
    {
        long oldTrigger = trigger;
        trigger = newTrigger;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER, oldTrigger, trigger ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isTriggerOnly ()
    {
        return triggerOnly;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTriggerOnly ( boolean newTriggerOnly )
    {
        boolean oldTriggerOnly = triggerOnly;
        triggerOnly = newTriggerOnly;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER_ONLY, oldTriggerOnly, triggerOnly ) );
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
            case ComponentPackage.MOVING_AVERAGE_MODULE__NULL_RANGE:
                return getNullRange ();
            case ComponentPackage.MOVING_AVERAGE_MODULE__RANGE:
                return getRange ();
            case ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER:
                return getTrigger ();
            case ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER_ONLY:
                return isTriggerOnly ();
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
            case ComponentPackage.MOVING_AVERAGE_MODULE__NULL_RANGE:
                setNullRange ( (Long)newValue );
                return;
            case ComponentPackage.MOVING_AVERAGE_MODULE__RANGE:
                setRange ( (Long)newValue );
                return;
            case ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER:
                setTrigger ( (Long)newValue );
                return;
            case ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER_ONLY:
                setTriggerOnly ( (Boolean)newValue );
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
            case ComponentPackage.MOVING_AVERAGE_MODULE__NULL_RANGE:
                setNullRange ( NULL_RANGE_EDEFAULT );
                return;
            case ComponentPackage.MOVING_AVERAGE_MODULE__RANGE:
                setRange ( RANGE_EDEFAULT );
                return;
            case ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER:
                setTrigger ( TRIGGER_EDEFAULT );
                return;
            case ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER_ONLY:
                setTriggerOnly ( TRIGGER_ONLY_EDEFAULT );
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
            case ComponentPackage.MOVING_AVERAGE_MODULE__NULL_RANGE:
                return nullRange != NULL_RANGE_EDEFAULT;
            case ComponentPackage.MOVING_AVERAGE_MODULE__RANGE:
                return range != RANGE_EDEFAULT;
            case ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER:
                return trigger != TRIGGER_EDEFAULT;
            case ComponentPackage.MOVING_AVERAGE_MODULE__TRIGGER_ONLY:
                return triggerOnly != TRIGGER_ONLY_EDEFAULT;
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
        result.append ( " (nullRange: " ); //$NON-NLS-1$
        result.append ( nullRange );
        result.append ( ", range: " ); //$NON-NLS-1$
        result.append ( range );
        result.append ( ", trigger: " ); //$NON-NLS-1$
        result.append ( trigger );
        result.append ( ", triggerOnly: " ); //$NON-NLS-1$
        result.append ( triggerOnly );
        result.append ( ')' );
        return result.toString ();
    }

} //MovingAverageModuleImpl
