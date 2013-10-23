/**
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution
 */
package org.eclipse.scada.ui.chart.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.LineProperties;
import org.eclipse.scada.ui.chart.model.ScriptSeries;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.ui.chart.model.impl.ScriptSeriesImpl#getLineProperties
 * <em>Line Properties</em>}</li>
 * <li>{@link org.eclipse.scada.ui.chart.model.impl.ScriptSeriesImpl#getScript
 * <em>Script</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ScriptSeriesImpl extends DataSeriesImpl implements ScriptSeries
{
    /**
     * The cached value of the '{@link #getLineProperties()
     * <em>Line Properties</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getLineProperties()
     * @generated
     * @ordered
     */
    protected LineProperties lineProperties;

    /**
     * The default value of the '{@link #getScript() <em>Script</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getScript()
     * @generated
     * @ordered
     */
    protected static final String SCRIPT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getScript() <em>Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getScript()
     * @generated
     * @ordered
     */
    protected String script = SCRIPT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected ScriptSeriesImpl ()
    {
        super ();
        setLineProperties ( ChartFactory.eINSTANCE.createLineProperties () );
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
        return ChartPackage.Literals.SCRIPT_SERIES;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LineProperties getLineProperties ()
    {
        if ( this.lineProperties != null && this.lineProperties.eIsProxy () )
        {
            InternalEObject oldLineProperties = (InternalEObject)this.lineProperties;
            this.lineProperties = (LineProperties)eResolveProxy ( oldLineProperties );
            if ( this.lineProperties != oldLineProperties )
            {
                InternalEObject newLineProperties = (InternalEObject)this.lineProperties;
                NotificationChain msgs = oldLineProperties.eInverseRemove ( this,
                        EOPPOSITE_FEATURE_BASE
                                - ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
                        null, null );
                if ( newLineProperties.eInternalContainer () == null )
                {
                    msgs = newLineProperties
                            .eInverseAdd (
                                    this,
                                    EOPPOSITE_FEATURE_BASE
                                            - ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
                                    null, msgs );
                }
                if ( msgs != null )
                {
                    msgs.dispatch ();
                }
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE,
                            ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
                            oldLineProperties, this.lineProperties ) );
                }
            }
        }
        return this.lineProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public LineProperties basicGetLineProperties ()
    {
        return this.lineProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetLineProperties (
            final LineProperties newLineProperties, NotificationChain msgs )
    {
        LineProperties oldLineProperties = this.lineProperties;
        this.lineProperties = newLineProperties;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this,
                    Notification.SET,
                    ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
                    oldLineProperties, newLineProperties );
            if ( msgs == null )
            {
                msgs = notification;
            }
            else
            {
                msgs.add ( notification );
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setLineProperties ( final LineProperties newLineProperties )
    {
        if ( newLineProperties != this.lineProperties )
        {
            NotificationChain msgs = null;
            if ( this.lineProperties != null )
            {
                msgs = ( (InternalEObject)this.lineProperties ).eInverseRemove ( this,
                        EOPPOSITE_FEATURE_BASE
                                - ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
                        null, msgs );
            }
            if ( newLineProperties != null )
            {
                msgs = ( (InternalEObject)newLineProperties ).eInverseAdd ( this,
                        EOPPOSITE_FEATURE_BASE
                                - ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
                        null, msgs );
            }
            msgs = basicSetLineProperties ( newLineProperties, msgs );
            if ( msgs != null )
            {
                msgs.dispatch ();
            }
        }
        else if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET,
                    ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES,
                    newLineProperties, newLineProperties ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getScript ()
    {
        return this.script;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setScript ( final String newScript )
    {
        String oldScript = this.script;
        this.script = newScript;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET,
                    ChartPackage.SCRIPT_SERIES__SCRIPT, oldScript, this.script ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( final InternalEObject otherEnd,
            final int featureID, final NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
                return basicSetLineProperties ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
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
            case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
                if ( resolve )
                {
                    return getLineProperties ();
                }
                return basicGetLineProperties ();
            case ChartPackage.SCRIPT_SERIES__SCRIPT:
                return getScript ();
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
            case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
                setLineProperties ( (LineProperties)newValue );
                return;
            case ChartPackage.SCRIPT_SERIES__SCRIPT:
                setScript ( (String)newValue );
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
            case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
                setLineProperties ( (LineProperties)null );
                return;
            case ChartPackage.SCRIPT_SERIES__SCRIPT:
                setScript ( SCRIPT_EDEFAULT );
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
            case ChartPackage.SCRIPT_SERIES__LINE_PROPERTIES:
                return this.lineProperties != null;
            case ChartPackage.SCRIPT_SERIES__SCRIPT:
                return SCRIPT_EDEFAULT == null ? this.script != null : !SCRIPT_EDEFAULT
                        .equals ( this.script );
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
    public String toString ()
    {
        if ( eIsProxy () )
        {
            return super.toString ();
        }

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (script: " ); //$NON-NLS-1$
        result.append ( this.script );
        result.append ( ')' );
        return result.toString ();
    }

} //ScriptSeriesImpl
