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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.scada.ui.chart.model.Axis;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Axis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.AxisImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.AxisImpl#getTextPadding <em>Text Padding</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.AxisImpl#getColor <em>Color</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.AxisImpl#isLabelVisible <em>Label Visible</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.AxisImpl#getFormat <em>Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AxisImpl extends EObjectImpl implements Axis
{
    /**
     * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected static final String LABEL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLabel()
     * @generated
     * @ordered
     */
    protected String label = LABEL_EDEFAULT;

    /**
     * The default value of the '{@link #getTextPadding() <em>Text Padding</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextPadding()
     * @generated
     * @ordered
     */
    protected static final int TEXT_PADDING_EDEFAULT = 10;

    /**
     * The cached value of the '{@link #getTextPadding() <em>Text Padding</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextPadding()
     * @generated
     * @ordered
     */
    protected int textPadding = TEXT_PADDING_EDEFAULT;

    /**
     * The default value of the '{@link #getColor() <em>Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColor()
     * @generated
     * @ordered
     */
    protected static final RGB COLOR_EDEFAULT = (RGB)ChartFactory.eINSTANCE.createFromString ( ChartPackage.eINSTANCE.getRGB (), "#000000" ); //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getColor() <em>Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getColor()
     * @generated
     * @ordered
     */
    protected RGB color = COLOR_EDEFAULT;

    /**
     * The default value of the '{@link #isLabelVisible() <em>Label Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLabelVisible()
     * @generated
     * @ordered
     */
    protected static final boolean LABEL_VISIBLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isLabelVisible() <em>Label Visible</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLabelVisible()
     * @generated
     * @ordered
     */
    protected boolean labelVisible = LABEL_VISIBLE_EDEFAULT;

    /**
     * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFormat()
     * @generated
     * @ordered
     */
    protected static final String FORMAT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFormat()
     * @generated
     * @ordered
     */
    protected String format = FORMAT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AxisImpl ()
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
        return ChartPackage.Literals.AXIS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLabel ()
    {
        return label;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabel ( String newLabel )
    {
        String oldLabel = label;
        label = newLabel;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.AXIS__LABEL, oldLabel, label ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTextPadding ()
    {
        return textPadding;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTextPadding ( int newTextPadding )
    {
        int oldTextPadding = textPadding;
        textPadding = newTextPadding;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.AXIS__TEXT_PADDING, oldTextPadding, textPadding ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RGB getColor ()
    {
        return color;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setColor ( RGB newColor )
    {
        RGB oldColor = color;
        color = newColor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.AXIS__COLOR, oldColor, color ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isLabelVisible ()
    {
        return labelVisible;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLabelVisible ( boolean newLabelVisible )
    {
        boolean oldLabelVisible = labelVisible;
        labelVisible = newLabelVisible;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.AXIS__LABEL_VISIBLE, oldLabelVisible, labelVisible ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFormat ()
    {
        return format;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFormat ( String newFormat )
    {
        String oldFormat = format;
        format = newFormat;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.AXIS__FORMAT, oldFormat, format ) );
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
            case ChartPackage.AXIS__LABEL:
                return getLabel ();
            case ChartPackage.AXIS__TEXT_PADDING:
                return getTextPadding ();
            case ChartPackage.AXIS__COLOR:
                return getColor ();
            case ChartPackage.AXIS__LABEL_VISIBLE:
                return isLabelVisible ();
            case ChartPackage.AXIS__FORMAT:
                return getFormat ();
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
            case ChartPackage.AXIS__LABEL:
                setLabel ( (String)newValue );
                return;
            case ChartPackage.AXIS__TEXT_PADDING:
                setTextPadding ( (Integer)newValue );
                return;
            case ChartPackage.AXIS__COLOR:
                setColor ( (RGB)newValue );
                return;
            case ChartPackage.AXIS__LABEL_VISIBLE:
                setLabelVisible ( (Boolean)newValue );
                return;
            case ChartPackage.AXIS__FORMAT:
                setFormat ( (String)newValue );
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
            case ChartPackage.AXIS__LABEL:
                setLabel ( LABEL_EDEFAULT );
                return;
            case ChartPackage.AXIS__TEXT_PADDING:
                setTextPadding ( TEXT_PADDING_EDEFAULT );
                return;
            case ChartPackage.AXIS__COLOR:
                setColor ( COLOR_EDEFAULT );
                return;
            case ChartPackage.AXIS__LABEL_VISIBLE:
                setLabelVisible ( LABEL_VISIBLE_EDEFAULT );
                return;
            case ChartPackage.AXIS__FORMAT:
                setFormat ( FORMAT_EDEFAULT );
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
            case ChartPackage.AXIS__LABEL:
                return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals ( label );
            case ChartPackage.AXIS__TEXT_PADDING:
                return textPadding != TEXT_PADDING_EDEFAULT;
            case ChartPackage.AXIS__COLOR:
                return COLOR_EDEFAULT == null ? color != null : !COLOR_EDEFAULT.equals ( color );
            case ChartPackage.AXIS__LABEL_VISIBLE:
                return labelVisible != LABEL_VISIBLE_EDEFAULT;
            case ChartPackage.AXIS__FORMAT:
                return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals ( format );
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
        result.append ( " (label: " ); //$NON-NLS-1$
        result.append ( label );
        result.append ( ", textPadding: " ); //$NON-NLS-1$
        result.append ( textPadding );
        result.append ( ", color: " ); //$NON-NLS-1$
        result.append ( color );
        result.append ( ", labelVisible: " ); //$NON-NLS-1$
        result.append ( labelVisible );
        result.append ( ", format: " ); //$NON-NLS-1$
        result.append ( format );
        result.append ( ')' );
        return result.toString ();
    }

} //AxisImpl
