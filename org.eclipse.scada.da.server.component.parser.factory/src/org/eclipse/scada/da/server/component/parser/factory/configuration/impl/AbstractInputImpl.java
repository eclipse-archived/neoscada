/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.base.extractor.input.Input;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.TransformerDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.AbstractInputImpl#getTransformers <em>Transformers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractInputImpl extends MinimalEObjectImpl.Container implements AbstractInput
{
    /**
     * The cached value of the '{@link #getTransformers() <em>Transformers</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTransformers()
     * @generated
     * @ordered
     */
    protected EList<TransformerDefinition> transformers;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractInputImpl ()
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
        return ParserPackage.Literals.ABSTRACT_INPUT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TransformerDefinition> getTransformers ()
    {
        if ( transformers == null )
        {
            transformers = new EObjectContainmentEList.Resolving<TransformerDefinition> ( TransformerDefinition.class, this, ParserPackage.ABSTRACT_INPUT__TRANSFORMERS );
        }
        return transformers;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Input createInput ( CreationContext creationContext )
    {
        // TODO: implement this method
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException ();
    }

    protected Input applyTransformers ( final Input input, final CreationContext creationContext )
    {
        for ( final TransformerDefinition td : getTransformers () )
        {
            input.addTransformer ( td.createTransformer ( creationContext ) );
        }
        return input;
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
            case ParserPackage.ABSTRACT_INPUT__TRANSFORMERS:
                return ( (InternalEList<?>)getTransformers () ).basicRemove ( otherEnd, msgs );
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
            case ParserPackage.ABSTRACT_INPUT__TRANSFORMERS:
                return getTransformers ();
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
            case ParserPackage.ABSTRACT_INPUT__TRANSFORMERS:
                getTransformers ().clear ();
                getTransformers ().addAll ( (Collection<? extends TransformerDefinition>)newValue );
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
            case ParserPackage.ABSTRACT_INPUT__TRANSFORMERS:
                getTransformers ().clear ();
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
            case ParserPackage.ABSTRACT_INPUT__TRANSFORMERS:
                return transformers != null && !transformers.isEmpty ();
        }
        return super.eIsSet ( featureID );
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
            case ParserPackage.ABSTRACT_INPUT___CREATE_INPUT__CREATIONCONTEXT:
                return createInput ( (CreationContext)arguments.get ( 0 ) );
        }
        return super.eInvoke ( operationID, arguments );
    }

} //AbstractInputImpl
