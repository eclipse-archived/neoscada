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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.component.BufferedValue;
import org.eclipse.scada.configuration.component.ChangeCounter;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.world.osgi.ChangeType;
import org.eclipse.scada.configuration.world.osgi.ErrorHandling;
import org.eclipse.scada.core.Variant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Counter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ChangeCounterImpl#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ChangeCounterImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ChangeCounterImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ChangeCounterImpl#getOnError <em>On Error</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChangeCounterImpl extends SingleValueImpl implements ChangeCounter
{
    /**
     * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuffer()
     * @generated
     * @ordered
     */
    protected BufferedValue buffer;

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final ChangeType TYPE_EDEFAULT = ChangeType.DELTA;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected ChangeType type = TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected EList<Variant> values;

    /**
     * The default value of the '{@link #getOnError() <em>On Error</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnError()
     * @generated
     * @ordered
     */
    protected static final ErrorHandling ON_ERROR_EDEFAULT = ErrorHandling.IGNORE;

    /**
     * The cached value of the '{@link #getOnError() <em>On Error</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnError()
     * @generated
     * @ordered
     */
    protected ErrorHandling onError = ON_ERROR_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChangeCounterImpl ()
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
        return ComponentPackage.Literals.CHANGE_COUNTER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BufferedValue getBuffer ()
    {
        if ( buffer != null && buffer.eIsProxy () )
        {
            InternalEObject oldBuffer = (InternalEObject)buffer;
            buffer = (BufferedValue)eResolveProxy ( oldBuffer );
            if ( buffer != oldBuffer )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.CHANGE_COUNTER__BUFFER, oldBuffer, buffer ) );
            }
        }
        return buffer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BufferedValue basicGetBuffer ()
    {
        return buffer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBuffer ( BufferedValue newBuffer )
    {
        BufferedValue oldBuffer = buffer;
        buffer = newBuffer;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CHANGE_COUNTER__BUFFER, oldBuffer, buffer ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChangeType getType ()
    {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType ( ChangeType newType )
    {
        ChangeType oldType = type;
        type = newType == null ? TYPE_EDEFAULT : newType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CHANGE_COUNTER__TYPE, oldType, type ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Variant> getValues ()
    {
        if ( values == null )
        {
            values = new EDataTypeUniqueEList<Variant> ( Variant.class, this, ComponentPackage.CHANGE_COUNTER__VALUES );
        }
        return values;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ErrorHandling getOnError ()
    {
        return onError;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnError ( ErrorHandling newOnError )
    {
        ErrorHandling oldOnError = onError;
        onError = newOnError == null ? ON_ERROR_EDEFAULT : newOnError;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.CHANGE_COUNTER__ON_ERROR, oldOnError, onError ) );
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
            case ComponentPackage.CHANGE_COUNTER__BUFFER:
                if ( resolve )
                    return getBuffer ();
                return basicGetBuffer ();
            case ComponentPackage.CHANGE_COUNTER__TYPE:
                return getType ();
            case ComponentPackage.CHANGE_COUNTER__VALUES:
                return getValues ();
            case ComponentPackage.CHANGE_COUNTER__ON_ERROR:
                return getOnError ();
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
            case ComponentPackage.CHANGE_COUNTER__BUFFER:
                setBuffer ( (BufferedValue)newValue );
                return;
            case ComponentPackage.CHANGE_COUNTER__TYPE:
                setType ( (ChangeType)newValue );
                return;
            case ComponentPackage.CHANGE_COUNTER__VALUES:
                getValues ().clear ();
                getValues ().addAll ( (Collection<? extends Variant>)newValue );
                return;
            case ComponentPackage.CHANGE_COUNTER__ON_ERROR:
                setOnError ( (ErrorHandling)newValue );
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
            case ComponentPackage.CHANGE_COUNTER__BUFFER:
                setBuffer ( (BufferedValue)null );
                return;
            case ComponentPackage.CHANGE_COUNTER__TYPE:
                setType ( TYPE_EDEFAULT );
                return;
            case ComponentPackage.CHANGE_COUNTER__VALUES:
                getValues ().clear ();
                return;
            case ComponentPackage.CHANGE_COUNTER__ON_ERROR:
                setOnError ( ON_ERROR_EDEFAULT );
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
            case ComponentPackage.CHANGE_COUNTER__BUFFER:
                return buffer != null;
            case ComponentPackage.CHANGE_COUNTER__TYPE:
                return type != TYPE_EDEFAULT;
            case ComponentPackage.CHANGE_COUNTER__VALUES:
                return values != null && !values.isEmpty ();
            case ComponentPackage.CHANGE_COUNTER__ON_ERROR:
                return onError != ON_ERROR_EDEFAULT;
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
        result.append ( " (type: " ); //$NON-NLS-1$
        result.append ( type );
        result.append ( ", values: " ); //$NON-NLS-1$
        result.append ( values );
        result.append ( ", onError: " ); //$NON-NLS-1$
        result.append ( onError );
        result.append ( ')' );
        return result.toString ();
    }

} //ChangeCounterImpl
