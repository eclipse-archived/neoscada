/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.SplitterExtractorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Splitter Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.SplitterExtractorTypeImpl#getSplitExpression <em>Split Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SplitterExtractorTypeImpl extends FieldExtractorTypeImpl implements SplitterExtractorType
{
    //$NON-NLS-1$

    /**
     * The default value of the '{@link #getSplitExpression() <em>Split Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSplitExpression()
     * @generated
     * @ordered
     */
    protected static final String SPLIT_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSplitExpression() <em>Split Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSplitExpression()
     * @generated
     * @ordered
     */
    protected String splitExpression = SPLIT_EXPRESSION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SplitterExtractorTypeImpl ()
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
        return ConfigurationPackage.Literals.SPLITTER_EXTRACTOR_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSplitExpression ()
    {
        return splitExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSplitExpression ( String newSplitExpression )
    {
        String oldSplitExpression = splitExpression;
        splitExpression = newSplitExpression;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.SPLITTER_EXTRACTOR_TYPE__SPLIT_EXPRESSION, oldSplitExpression, splitExpression ) );
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
            case ConfigurationPackage.SPLITTER_EXTRACTOR_TYPE__SPLIT_EXPRESSION:
                return getSplitExpression ();
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
            case ConfigurationPackage.SPLITTER_EXTRACTOR_TYPE__SPLIT_EXPRESSION:
                setSplitExpression ( (String)newValue );
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
            case ConfigurationPackage.SPLITTER_EXTRACTOR_TYPE__SPLIT_EXPRESSION:
                setSplitExpression ( SPLIT_EXPRESSION_EDEFAULT );
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
            case ConfigurationPackage.SPLITTER_EXTRACTOR_TYPE__SPLIT_EXPRESSION:
                return SPLIT_EXPRESSION_EDEFAULT == null ? splitExpression != null : !SPLIT_EXPRESSION_EDEFAULT.equals ( splitExpression );
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
        result.append ( " (splitExpression: " ); //$NON-NLS-1$
        result.append ( splitExpression );
        result.append ( ')' );
        return result.toString ();
    }

} //SplitterExtractorTypeImpl
