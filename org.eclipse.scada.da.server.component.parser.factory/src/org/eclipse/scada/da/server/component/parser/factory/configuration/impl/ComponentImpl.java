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
import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition;
import org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ComponentImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ComponentImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ComponentImpl#getExtractors <em>Extractors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends MinimalEObjectImpl.Container implements Component
{
    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInput()
     * @generated
     * @ordered
     */
    protected InputDefinition input;

    /**
     * The cached value of the '{@link #getExtractors() <em>Extractors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExtractors()
     * @generated
     * @ordered
     */
    protected EList<ExtractorDefinition> extractors;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComponentImpl ()
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
        return ParserPackage.Literals.COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.COMPONENT__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition getInput ()
    {
        if ( input != null && input.eIsProxy () )
        {
            InternalEObject oldInput = (InternalEObject)input;
            input = (InputDefinition)eResolveProxy ( oldInput );
            if ( input != oldInput )
            {
                InternalEObject newInput = (InternalEObject)input;
                NotificationChain msgs = oldInput.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.COMPONENT__INPUT, null, null );
                if ( newInput.eInternalContainer () == null )
                {
                    msgs = newInput.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.COMPONENT__INPUT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ParserPackage.COMPONENT__INPUT, oldInput, input ) );
            }
        }
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InputDefinition basicGetInput ()
    {
        return input;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInput ( InputDefinition newInput, NotificationChain msgs )
    {
        InputDefinition oldInput = input;
        input = newInput;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ParserPackage.COMPONENT__INPUT, oldInput, newInput );
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
    public void setInput ( InputDefinition newInput )
    {
        if ( newInput != input )
        {
            NotificationChain msgs = null;
            if ( input != null )
                msgs = ( (InternalEObject)input ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.COMPONENT__INPUT, null, msgs );
            if ( newInput != null )
                msgs = ( (InternalEObject)newInput ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.COMPONENT__INPUT, null, msgs );
            msgs = basicSetInput ( newInput, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.COMPONENT__INPUT, newInput, newInput ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ExtractorDefinition> getExtractors ()
    {
        if ( extractors == null )
        {
            extractors = new EObjectContainmentEList.Resolving<ExtractorDefinition> ( ExtractorDefinition.class, this, ParserPackage.COMPONENT__EXTRACTORS );
        }
        return extractors;
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
            case ParserPackage.COMPONENT__INPUT:
                return basicSetInput ( null, msgs );
            case ParserPackage.COMPONENT__EXTRACTORS:
                return ( (InternalEList<?>)getExtractors () ).basicRemove ( otherEnd, msgs );
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
            case ParserPackage.COMPONENT__ID:
                return getId ();
            case ParserPackage.COMPONENT__INPUT:
                if ( resolve )
                    return getInput ();
                return basicGetInput ();
            case ParserPackage.COMPONENT__EXTRACTORS:
                return getExtractors ();
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
            case ParserPackage.COMPONENT__ID:
                setId ( (String)newValue );
                return;
            case ParserPackage.COMPONENT__INPUT:
                setInput ( (InputDefinition)newValue );
                return;
            case ParserPackage.COMPONENT__EXTRACTORS:
                getExtractors ().clear ();
                getExtractors ().addAll ( (Collection<? extends ExtractorDefinition>)newValue );
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
            case ParserPackage.COMPONENT__ID:
                setId ( ID_EDEFAULT );
                return;
            case ParserPackage.COMPONENT__INPUT:
                setInput ( (InputDefinition)null );
                return;
            case ParserPackage.COMPONENT__EXTRACTORS:
                getExtractors ().clear ();
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
            case ParserPackage.COMPONENT__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case ParserPackage.COMPONENT__INPUT:
                return input != null;
            case ParserPackage.COMPONENT__EXTRACTORS:
                return extractors != null && !extractors.isEmpty ();
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
        result.append ( " (id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ')' );
        return result.toString ();
    }

} //ComponentImpl
