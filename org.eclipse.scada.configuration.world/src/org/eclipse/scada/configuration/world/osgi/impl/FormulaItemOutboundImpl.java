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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.TypedItemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formula Item Outbound</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemOutboundImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemOutboundImpl#getOutputFormula <em>Output Formula</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemOutboundImpl#getWriteValueVariableName <em>Write Value Variable Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormulaItemOutboundImpl extends MinimalEObjectImpl.Container
        implements FormulaItemOutbound
{
    /**
     * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutput()
     * @generated
     * @ordered
     */
    protected TypedItemReference output;

    /**
     * The default value of the '{@link #getOutputFormula() <em>Output Formula</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputFormula()
     * @generated
     * @ordered
     */
    protected static final String OUTPUT_FORMULA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOutputFormula() <em>Output Formula</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputFormula()
     * @generated
     * @ordered
     */
    protected String outputFormula = OUTPUT_FORMULA_EDEFAULT;

    /**
     * The default value of the '{@link #getWriteValueVariableName() <em>Write Value Variable Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWriteValueVariableName()
     * @generated
     * @ordered
     */
    protected static final String WRITE_VALUE_VARIABLE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWriteValueVariableName() <em>Write Value Variable Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWriteValueVariableName()
     * @generated
     * @ordered
     */
    protected String writeValueVariableName = WRITE_VALUE_VARIABLE_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FormulaItemOutboundImpl ()
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
        return OsgiPackage.Literals.FORMULA_ITEM_OUTBOUND;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypedItemReference getOutput ()
    {
        if ( output != null && output.eIsProxy () )
        {
            InternalEObject oldOutput = (InternalEObject)output;
            output = (TypedItemReference)eResolveProxy ( oldOutput );
            if ( output != oldOutput )
            {
                InternalEObject newOutput = (InternalEObject)output;
                NotificationChain msgs = oldOutput.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT, null, null );
                if ( newOutput.eInternalContainer () == null )
                {
                    msgs = newOutput.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT, oldOutput, output ) );
            }
        }
        return output;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypedItemReference basicGetOutput ()
    {
        return output;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOutput ( TypedItemReference newOutput,
            NotificationChain msgs )
    {
        TypedItemReference oldOutput = output;
        output = newOutput;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT, oldOutput, newOutput );
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
    public void setOutput ( TypedItemReference newOutput )
    {
        if ( newOutput != output )
        {
            NotificationChain msgs = null;
            if ( output != null )
                msgs = ( (InternalEObject)output ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT, null, msgs );
            if ( newOutput != null )
                msgs = ( (InternalEObject)newOutput ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT, null, msgs );
            msgs = basicSetOutput ( newOutput, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT, newOutput, newOutput ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOutputFormula ()
    {
        return outputFormula;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputFormula ( String newOutputFormula )
    {
        String oldOutputFormula = outputFormula;
        outputFormula = newOutputFormula;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT_FORMULA, oldOutputFormula, outputFormula ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getWriteValueVariableName ()
    {
        return writeValueVariableName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWriteValueVariableName ( String newWriteValueVariableName )
    {
        String oldWriteValueVariableName = writeValueVariableName;
        writeValueVariableName = newWriteValueVariableName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM_OUTBOUND__WRITE_VALUE_VARIABLE_NAME, oldWriteValueVariableName, writeValueVariableName ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd,
            int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT:
                return basicSetOutput ( null, msgs );
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
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT:
                if ( resolve )
                    return getOutput ();
                return basicGetOutput ();
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT_FORMULA:
                return getOutputFormula ();
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__WRITE_VALUE_VARIABLE_NAME:
                return getWriteValueVariableName ();
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
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT:
                setOutput ( (TypedItemReference)newValue );
                return;
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT_FORMULA:
                setOutputFormula ( (String)newValue );
                return;
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__WRITE_VALUE_VARIABLE_NAME:
                setWriteValueVariableName ( (String)newValue );
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
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT:
                setOutput ( (TypedItemReference)null );
                return;
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT_FORMULA:
                setOutputFormula ( OUTPUT_FORMULA_EDEFAULT );
                return;
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__WRITE_VALUE_VARIABLE_NAME:
                setWriteValueVariableName ( WRITE_VALUE_VARIABLE_NAME_EDEFAULT );
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
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT:
                return output != null;
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__OUTPUT_FORMULA:
                return OUTPUT_FORMULA_EDEFAULT == null ? outputFormula != null : !OUTPUT_FORMULA_EDEFAULT.equals ( outputFormula );
            case OsgiPackage.FORMULA_ITEM_OUTBOUND__WRITE_VALUE_VARIABLE_NAME:
                return WRITE_VALUE_VARIABLE_NAME_EDEFAULT == null ? writeValueVariableName != null : !WRITE_VALUE_VARIABLE_NAME_EDEFAULT.equals ( writeValueVariableName );
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
        result.append ( " (outputFormula: " ); //$NON-NLS-1$
        result.append ( outputFormula );
        result.append ( ", writeValueVariableName: " ); //$NON-NLS-1$
        result.append ( writeValueVariableName );
        result.append ( ')' );
        return result.toString ();
    }

} //FormulaItemOutboundImpl
