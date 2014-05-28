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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.ItemDescriptor;
import org.eclipse.scada.base.extractor.extract.PlainTextExtractor;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plain Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl#getPrefix
 * <em>Prefix</em>}</li>
 * <li>
 * {@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl#getName
 * <em>Name</em>}</li>
 * <li>
 * {@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl#getDescription
 * <em>Description</em>}</li>
 * <li>
 * {@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl#isTrim
 * <em>Trim</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PlainTextImpl extends MinimalEObjectImpl.Container implements PlainText
{
    /**
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

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
     * The default value of the '{@link #getDescription() <em>Description</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #isTrim() <em>Trim</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isTrim()
     * @generated
     * @ordered
     */
    protected static final boolean TRIM_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isTrim() <em>Trim</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isTrim()
     * @generated
     * @ordered
     */
    protected boolean trim = TRIM_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PlainTextImpl ()
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
        return ParserPackage.Literals.PLAIN_TEXT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPrefix ()
    {
        return this.prefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPrefix ( final String newPrefix )
    {
        final String oldPrefix = this.prefix;
        this.prefix = newPrefix;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.PLAIN_TEXT__PREFIX, oldPrefix, this.prefix ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.PLAIN_TEXT__NAME, oldName, this.name ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getDescription ()
    {
        return this.description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDescription ( final String newDescription )
    {
        final String oldDescription = this.description;
        this.description = newDescription;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.PLAIN_TEXT__DESCRIPTION, oldDescription, this.description ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isTrim ()
    {
        return this.trim;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTrim ( final boolean newTrim )
    {
        final boolean oldTrim = this.trim;
        this.trim = newTrim;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.PLAIN_TEXT__TRIM, oldTrim, this.trim ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Extractor createExtractor ( final CreationContext creationContext )
    {
        final Map<String, Variant> attributes = new HashMap<> ();
        attributes.put ( "description", Variant.valueOf ( getDescription () ) );
        return new PlainTextExtractor ( new ItemDescriptor ( getName (), attributes ), isTrim () );
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
            case ParserPackage.PLAIN_TEXT__PREFIX:
                return getPrefix ();
            case ParserPackage.PLAIN_TEXT__NAME:
                return getName ();
            case ParserPackage.PLAIN_TEXT__DESCRIPTION:
                return getDescription ();
            case ParserPackage.PLAIN_TEXT__TRIM:
                return isTrim ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet ( final int featureID, final Object newValue )
    {
        switch ( featureID )
        {
            case ParserPackage.PLAIN_TEXT__PREFIX:
                setPrefix ( (String)newValue );
                return;
            case ParserPackage.PLAIN_TEXT__NAME:
                setName ( (String)newValue );
                return;
            case ParserPackage.PLAIN_TEXT__DESCRIPTION:
                setDescription ( (String)newValue );
                return;
            case ParserPackage.PLAIN_TEXT__TRIM:
                setTrim ( (Boolean)newValue );
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
            case ParserPackage.PLAIN_TEXT__PREFIX:
                setPrefix ( PREFIX_EDEFAULT );
                return;
            case ParserPackage.PLAIN_TEXT__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ParserPackage.PLAIN_TEXT__DESCRIPTION:
                setDescription ( DESCRIPTION_EDEFAULT );
                return;
            case ParserPackage.PLAIN_TEXT__TRIM:
                setTrim ( TRIM_EDEFAULT );
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
            case ParserPackage.PLAIN_TEXT__PREFIX:
                return PREFIX_EDEFAULT == null ? this.prefix != null : !PREFIX_EDEFAULT.equals ( this.prefix );
            case ParserPackage.PLAIN_TEXT__NAME:
                return NAME_EDEFAULT == null ? this.name != null : !NAME_EDEFAULT.equals ( this.name );
            case ParserPackage.PLAIN_TEXT__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? this.description != null : !DESCRIPTION_EDEFAULT.equals ( this.description );
            case ParserPackage.PLAIN_TEXT__TRIM:
                return this.trim != TRIM_EDEFAULT;
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
    public Object eInvoke ( final int operationID, final EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case ParserPackage.PLAIN_TEXT___CREATE_EXTRACTOR__CREATIONCONTEXT:
                return createExtractor ( (CreationContext)arguments.get ( 0 ) );
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (prefix: " ); //$NON-NLS-1$
        result.append ( this.prefix );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( this.name );
        result.append ( ", description: " ); //$NON-NLS-1$
        result.append ( this.description );
        result.append ( ", trim: " ); //$NON-NLS-1$
        result.append ( this.trim );
        result.append ( ')' );
        return result.toString ();
    }

} //PlainTextImpl
