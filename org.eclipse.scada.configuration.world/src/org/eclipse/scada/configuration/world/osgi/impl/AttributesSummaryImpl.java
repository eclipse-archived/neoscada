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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.world.osgi.AttributesSummary;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attributes Summary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AttributesSummaryImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.AttributesSummaryImpl#getOutputPrefix <em>Output Prefix</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributesSummaryImpl extends ItemFeatureEntryImpl implements AttributesSummary
{
    /**
     * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttributes()
     * @generated
     * @ordered
     */
    protected EList<String> attributes;

    /**
     * The default value of the '{@link #getOutputPrefix() <em>Output Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputPrefix()
     * @generated
     * @ordered
     */
    protected static final String OUTPUT_PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOutputPrefix() <em>Output Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputPrefix()
     * @generated
     * @ordered
     */
    protected String outputPrefix = OUTPUT_PREFIX_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AttributesSummaryImpl ()
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
        return OsgiPackage.Literals.ATTRIBUTES_SUMMARY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getAttributes ()
    {
        if ( attributes == null )
        {
            attributes = new EDataTypeUniqueEList<String> ( String.class, this, OsgiPackage.ATTRIBUTES_SUMMARY__ATTRIBUTES );
        }
        return attributes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOutputPrefix ()
    {
        return outputPrefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputPrefix ( String newOutputPrefix )
    {
        String oldOutputPrefix = outputPrefix;
        outputPrefix = newOutputPrefix;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ATTRIBUTES_SUMMARY__OUTPUT_PREFIX, oldOutputPrefix, outputPrefix ) );
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
            case OsgiPackage.ATTRIBUTES_SUMMARY__ATTRIBUTES:
                return getAttributes ();
            case OsgiPackage.ATTRIBUTES_SUMMARY__OUTPUT_PREFIX:
                return getOutputPrefix ();
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
            case OsgiPackage.ATTRIBUTES_SUMMARY__ATTRIBUTES:
                getAttributes ().clear ();
                getAttributes ().addAll ( (Collection<? extends String>)newValue );
                return;
            case OsgiPackage.ATTRIBUTES_SUMMARY__OUTPUT_PREFIX:
                setOutputPrefix ( (String)newValue );
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
            case OsgiPackage.ATTRIBUTES_SUMMARY__ATTRIBUTES:
                getAttributes ().clear ();
                return;
            case OsgiPackage.ATTRIBUTES_SUMMARY__OUTPUT_PREFIX:
                setOutputPrefix ( OUTPUT_PREFIX_EDEFAULT );
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
            case OsgiPackage.ATTRIBUTES_SUMMARY__ATTRIBUTES:
                return attributes != null && !attributes.isEmpty ();
            case OsgiPackage.ATTRIBUTES_SUMMARY__OUTPUT_PREFIX:
                return OUTPUT_PREFIX_EDEFAULT == null ? outputPrefix != null : !OUTPUT_PREFIX_EDEFAULT.equals ( outputPrefix );
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
        result.append ( " (attributes: " ); //$NON-NLS-1$
        result.append ( attributes );
        result.append ( ", outputPrefix: " ); //$NON-NLS-1$
        result.append ( outputPrefix );
        result.append ( ')' );
        return result.toString ();
    }

} //AttributesSummaryImpl
