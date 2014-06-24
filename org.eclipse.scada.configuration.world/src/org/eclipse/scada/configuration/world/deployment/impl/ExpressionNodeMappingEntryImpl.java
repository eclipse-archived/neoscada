/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.deployment.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Expression Node Mapping Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.ExpressionNodeMappingEntryImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.ExpressionNodeMappingEntryImpl#getReplacement <em>Replacement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionNodeMappingEntryImpl extends
        MinimalEObjectImpl.Container implements ExpressionNodeMappingEntry
{
    /**
     * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected static final Pattern PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected Pattern pattern = PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #getReplacement() <em>Replacement</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplacement()
     * @generated
     * @ordered
     */
    protected static final String REPLACEMENT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getReplacement() <em>Replacement</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReplacement()
     * @generated
     * @ordered
     */
    protected String replacement = REPLACEMENT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExpressionNodeMappingEntryImpl ()
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
        return DeploymentPackage.Literals.EXPRESSION_NODE_MAPPING_ENTRY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Pattern getPattern ()
    {
        return pattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPattern ( Pattern newPattern )
    {
        Pattern oldPattern = pattern;
        pattern = newPattern;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__PATTERN, oldPattern, pattern ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getReplacement ()
    {
        return replacement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setReplacement ( String newReplacement )
    {
        String oldReplacement = replacement;
        replacement = newReplacement;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__REPLACEMENT, oldReplacement, replacement ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public String map ( final String from )
    {
        if ( from == null )
        {
            return null;
        }

        final Matcher m = getPattern ().matcher ( from );
        if ( m.matches () )
        {
            return m.replaceAll ( this.replacement );
        }
        else
        {
            return null;
        }
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
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__PATTERN:
                return getPattern ();
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__REPLACEMENT:
                return getReplacement ();
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
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__PATTERN:
                setPattern ( (Pattern)newValue );
                return;
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__REPLACEMENT:
                setReplacement ( (String)newValue );
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
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__PATTERN:
                setPattern ( PATTERN_EDEFAULT );
                return;
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__REPLACEMENT:
                setReplacement ( REPLACEMENT_EDEFAULT );
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
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__PATTERN:
                return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals ( pattern );
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY__REPLACEMENT:
                return REPLACEMENT_EDEFAULT == null ? replacement != null : !REPLACEMENT_EDEFAULT.equals ( replacement );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments )
            throws InvocationTargetException
    {
        switch ( operationID )
        {
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY___MAP__STRING:
                return map ( (String)arguments.get ( 0 ) );
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (pattern: " ); //$NON-NLS-1$
        result.append ( pattern );
        result.append ( ", replacement: " ); //$NON-NLS-1$
        result.append ( replacement );
        result.append ( ')' );
        return result.toString ();
    }

} //ExpressionNodeMappingEntryImpl
