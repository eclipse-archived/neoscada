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
package org.eclipse.scada.configuration.driver.parser.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.driver.parser.ParserComponentHost;
import org.eclipse.scada.configuration.driver.parser.ParserPackage;
import org.eclipse.scada.configuration.infrastructure.impl.AbstractEquinoxDriverImpl;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Host</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.parser.impl.ParserComponentHostImpl#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParserComponentHostImpl extends AbstractEquinoxDriverImpl implements ParserComponentHost
{
    /**
     * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComponents()
     * @generated
     * @ordered
     */
    protected EList<Component> components;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ParserComponentHostImpl ()
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
        return ParserPackage.Literals.PARSER_COMPONENT_HOST;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Component> getComponents ()
    {
        if ( components == null )
        {
            components = new EObjectContainmentEList.Resolving<Component> ( Component.class, this, ParserPackage.PARSER_COMPONENT_HOST__COMPONENTS );
        }
        return components;
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
            case ParserPackage.PARSER_COMPONENT_HOST__COMPONENTS:
                return ( (InternalEList<?>)getComponents () ).basicRemove ( otherEnd, msgs );
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
            case ParserPackage.PARSER_COMPONENT_HOST__COMPONENTS:
                return getComponents ();
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
            case ParserPackage.PARSER_COMPONENT_HOST__COMPONENTS:
                getComponents ().clear ();
                getComponents ().addAll ( (Collection<? extends Component>)newValue );
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
            case ParserPackage.PARSER_COMPONENT_HOST__COMPONENTS:
                getComponents ().clear ();
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
            case ParserPackage.PARSER_COMPONENT_HOST__COMPONENTS:
                return components != null && !components.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //ParserComponentHostImpl
