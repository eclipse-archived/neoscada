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
import org.eclipse.scada.configuration.world.osgi.FormulaItemInbound;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.TypedItemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formula Item Inbound</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemInboundImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemInboundImpl#getInputFormula <em>Input Formula</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormulaItemInboundImpl extends MinimalEObjectImpl.Container implements FormulaItemInbound
{
    /**
     * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputs()
     * @generated
     * @ordered
     */
    protected EList<TypedItemReference> inputs;

    /**
     * The default value of the '{@link #getInputFormula() <em>Input Formula</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputFormula()
     * @generated
     * @ordered
     */
    protected static final String INPUT_FORMULA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInputFormula() <em>Input Formula</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputFormula()
     * @generated
     * @ordered
     */
    protected String inputFormula = INPUT_FORMULA_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FormulaItemInboundImpl ()
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
        return OsgiPackage.Literals.FORMULA_ITEM_INBOUND;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TypedItemReference> getInputs ()
    {
        if ( inputs == null )
        {
            inputs = new EObjectContainmentEList.Resolving<TypedItemReference> ( TypedItemReference.class, this, OsgiPackage.FORMULA_ITEM_INBOUND__INPUTS );
        }
        return inputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInputFormula ()
    {
        return inputFormula;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputFormula ( String newInputFormula )
    {
        String oldInputFormula = inputFormula;
        inputFormula = newInputFormula;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM_INBOUND__INPUT_FORMULA, oldInputFormula, inputFormula ) );
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
            case OsgiPackage.FORMULA_ITEM_INBOUND__INPUTS:
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
            case OsgiPackage.FORMULA_ITEM_INBOUND__INPUTS:
                return getInputs ();
            case OsgiPackage.FORMULA_ITEM_INBOUND__INPUT_FORMULA:
                return getInputFormula ();
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
            case OsgiPackage.FORMULA_ITEM_INBOUND__INPUTS:
                getInputs ().clear ();
                getInputs ().addAll ( (Collection<? extends TypedItemReference>)newValue );
                return;
            case OsgiPackage.FORMULA_ITEM_INBOUND__INPUT_FORMULA:
                setInputFormula ( (String)newValue );
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
            case OsgiPackage.FORMULA_ITEM_INBOUND__INPUTS:
                getInputs ().clear ();
                return;
            case OsgiPackage.FORMULA_ITEM_INBOUND__INPUT_FORMULA:
                setInputFormula ( INPUT_FORMULA_EDEFAULT );
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
            case OsgiPackage.FORMULA_ITEM_INBOUND__INPUTS:
                return inputs != null && !inputs.isEmpty ();
            case OsgiPackage.FORMULA_ITEM_INBOUND__INPUT_FORMULA:
                return INPUT_FORMULA_EDEFAULT == null ? inputFormula != null : !INPUT_FORMULA_EDEFAULT.equals ( inputFormula );
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
        result.append ( " (inputFormula: " ); //$NON-NLS-1$
        result.append ( inputFormula );
        result.append ( ')' );
        return result.toString ();
    }

} //FormulaItemInboundImpl
