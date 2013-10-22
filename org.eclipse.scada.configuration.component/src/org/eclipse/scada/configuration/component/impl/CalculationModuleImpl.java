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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.component.CalculationModule;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.OutputSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Calculation Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationModuleImpl#getKnownInputs <em>Known Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.CalculationModuleImpl#getKnownOutputs <em>Known Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CalculationModuleImpl extends MinimalEObjectImpl.Container implements CalculationModule
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CalculationModuleImpl ()
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
        return ComponentPackage.Literals.CALCULATION_MODULE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InputSpecification> getKnownInputs ()
    {
        // TODO: implement this method to return the 'Known Inputs' reference list
        // Ensure that you remove @generated or mark it @generated NOT
        // The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
        // so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
        throw new UnsupportedOperationException ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OutputSpecification> getKnownOutputs ()
    {
        // TODO: implement this method to return the 'Known Outputs' reference list
        // Ensure that you remove @generated or mark it @generated NOT
        // The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
        // so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
        throw new UnsupportedOperationException ();
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
            case ComponentPackage.CALCULATION_MODULE__KNOWN_INPUTS:
                return getKnownInputs ();
            case ComponentPackage.CALCULATION_MODULE__KNOWN_OUTPUTS:
                return getKnownOutputs ();
        }
        return super.eGet ( featureID, resolve, coreType );
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
            case ComponentPackage.CALCULATION_MODULE__KNOWN_INPUTS:
                return !getKnownInputs ().isEmpty ();
            case ComponentPackage.CALCULATION_MODULE__KNOWN_OUTPUTS:
                return !getKnownOutputs ().isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //CalculationModuleImpl
