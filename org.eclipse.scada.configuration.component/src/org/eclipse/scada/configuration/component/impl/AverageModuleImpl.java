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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.AverageModule;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.Components;
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.world.osgi.AverageReferenceType;
import org.eclipse.scada.configuration.world.osgi.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Average Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.AverageModuleImpl#getValidSourcesRequired <em>Valid Sources Required</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AverageModuleImpl extends CalculationModuleImpl implements AverageModule
{
    /**
     * The default value of the '{@link #getValidSourcesRequired() <em>Valid Sources Required</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValidSourcesRequired()
     * @generated
     * @ordered
     */
    protected static final String VALID_SOURCES_REQUIRED_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValidSourcesRequired() <em>Valid Sources Required</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValidSourcesRequired()
     * @generated
     * @ordered
     */
    protected String validSourcesRequired = VALID_SOURCES_REQUIRED_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AverageModuleImpl ()
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
        return ComponentPackage.Literals.AVERAGE_MODULE;
    }

    private EList<InputSpecification> knownInputs;

    private EList<OutputSpecification> knownOutputs;

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
            for ( final AverageReferenceType type : AverageReferenceType.values () )
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
    public String getValidSourcesRequired ()
    {
        return validSourcesRequired;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setValidSourcesRequired ( String newValidSourcesRequired )
    {
        String oldValidSourcesRequired = validSourcesRequired;
        validSourcesRequired = newValidSourcesRequired;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.AVERAGE_MODULE__VALID_SOURCES_REQUIRED, oldValidSourcesRequired, validSourcesRequired ) );
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
            case ComponentPackage.AVERAGE_MODULE__VALID_SOURCES_REQUIRED:
                return getValidSourcesRequired ();
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
            case ComponentPackage.AVERAGE_MODULE__VALID_SOURCES_REQUIRED:
                setValidSourcesRequired ( (String)newValue );
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
            case ComponentPackage.AVERAGE_MODULE__VALID_SOURCES_REQUIRED:
                setValidSourcesRequired ( VALID_SOURCES_REQUIRED_EDEFAULT );
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
            case ComponentPackage.AVERAGE_MODULE__VALID_SOURCES_REQUIRED:
                return VALID_SOURCES_REQUIRED_EDEFAULT == null ? validSourcesRequired != null : !VALID_SOURCES_REQUIRED_EDEFAULT.equals ( validSourcesRequired );
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
        result.append ( " (validSourcesRequired: " ); //$NON-NLS-1$
        result.append ( validSourcesRequired );
        result.append ( ')' );
        return result.toString ();
    }

} //AverageModuleImpl
