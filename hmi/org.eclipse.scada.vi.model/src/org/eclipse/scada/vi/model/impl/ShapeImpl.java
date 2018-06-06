/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.scada.vi.model.Shape;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shape</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.ShapeImpl#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.ShapeImpl#getAntialias <em>Antialias</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.ShapeImpl#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.ShapeImpl#isFill <em>Fill</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.ShapeImpl#isOutline <em>Outline</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ShapeImpl extends FigureImpl implements Shape
{
    /**
     * The default value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLineWidth()
     * @generated
     * @ordered
     */
    protected static final float LINE_WIDTH_EDEFAULT = 1.0F;

    /**
     * The cached value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLineWidth()
     * @generated
     * @ordered
     */
    protected float lineWidth = LINE_WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getAntialias() <em>Antialias</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAntialias()
     * @generated
     * @ordered
     */
    protected static final Boolean ANTIALIAS_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAntialias() <em>Antialias</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAntialias()
     * @generated
     * @ordered
     */
    protected Boolean antialias = ANTIALIAS_EDEFAULT;

    /**
     * The default value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlpha()
     * @generated
     * @ordered
     */
    protected static final Double ALPHA_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAlpha()
     * @generated
     * @ordered
     */
    protected Double alpha = ALPHA_EDEFAULT;

    /**
     * The default value of the '{@link #isFill() <em>Fill</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFill()
     * @generated
     * @ordered
     */
    protected static final boolean FILL_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isFill() <em>Fill</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFill()
     * @generated
     * @ordered
     */
    protected boolean fill = FILL_EDEFAULT;

    /**
     * The default value of the '{@link #isOutline() <em>Outline</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOutline()
     * @generated
     * @ordered
     */
    protected static final boolean OUTLINE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isOutline() <em>Outline</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isOutline()
     * @generated
     * @ordered
     */
    protected boolean outline = OUTLINE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ShapeImpl ()
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
        return VisualInterfacePackage.Literals.SHAPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public float getLineWidth ()
    {
        return lineWidth;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLineWidth ( float newLineWidth )
    {
        float oldLineWidth = lineWidth;
        lineWidth = newLineWidth;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SHAPE__LINE_WIDTH, oldLineWidth, lineWidth ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getAntialias ()
    {
        return antialias;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAntialias ( Boolean newAntialias )
    {
        Boolean oldAntialias = antialias;
        antialias = newAntialias;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SHAPE__ANTIALIAS, oldAntialias, antialias ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Double getAlpha ()
    {
        return alpha;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAlpha ( Double newAlpha )
    {
        Double oldAlpha = alpha;
        alpha = newAlpha;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SHAPE__ALPHA, oldAlpha, alpha ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isFill ()
    {
        return fill;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFill ( boolean newFill )
    {
        boolean oldFill = fill;
        fill = newFill;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SHAPE__FILL, oldFill, fill ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isOutline ()
    {
        return outline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutline ( boolean newOutline )
    {
        boolean oldOutline = outline;
        outline = newOutline;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SHAPE__OUTLINE, oldOutline, outline ) );
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
            case VisualInterfacePackage.SHAPE__LINE_WIDTH:
                return getLineWidth ();
            case VisualInterfacePackage.SHAPE__ANTIALIAS:
                return getAntialias ();
            case VisualInterfacePackage.SHAPE__ALPHA:
                return getAlpha ();
            case VisualInterfacePackage.SHAPE__FILL:
                return isFill ();
            case VisualInterfacePackage.SHAPE__OUTLINE:
                return isOutline ();
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
            case VisualInterfacePackage.SHAPE__LINE_WIDTH:
                setLineWidth ( (Float)newValue );
                return;
            case VisualInterfacePackage.SHAPE__ANTIALIAS:
                setAntialias ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.SHAPE__ALPHA:
                setAlpha ( (Double)newValue );
                return;
            case VisualInterfacePackage.SHAPE__FILL:
                setFill ( (Boolean)newValue );
                return;
            case VisualInterfacePackage.SHAPE__OUTLINE:
                setOutline ( (Boolean)newValue );
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
            case VisualInterfacePackage.SHAPE__LINE_WIDTH:
                setLineWidth ( LINE_WIDTH_EDEFAULT );
                return;
            case VisualInterfacePackage.SHAPE__ANTIALIAS:
                setAntialias ( ANTIALIAS_EDEFAULT );
                return;
            case VisualInterfacePackage.SHAPE__ALPHA:
                setAlpha ( ALPHA_EDEFAULT );
                return;
            case VisualInterfacePackage.SHAPE__FILL:
                setFill ( FILL_EDEFAULT );
                return;
            case VisualInterfacePackage.SHAPE__OUTLINE:
                setOutline ( OUTLINE_EDEFAULT );
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
            case VisualInterfacePackage.SHAPE__LINE_WIDTH:
                return lineWidth != LINE_WIDTH_EDEFAULT;
            case VisualInterfacePackage.SHAPE__ANTIALIAS:
                return ANTIALIAS_EDEFAULT == null ? antialias != null : !ANTIALIAS_EDEFAULT.equals ( antialias );
            case VisualInterfacePackage.SHAPE__ALPHA:
                return ALPHA_EDEFAULT == null ? alpha != null : !ALPHA_EDEFAULT.equals ( alpha );
            case VisualInterfacePackage.SHAPE__FILL:
                return fill != FILL_EDEFAULT;
            case VisualInterfacePackage.SHAPE__OUTLINE:
                return outline != OUTLINE_EDEFAULT;
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
        result.append ( " (lineWidth: " ); //$NON-NLS-1$
        result.append ( lineWidth );
        result.append ( ", antialias: " ); //$NON-NLS-1$
        result.append ( antialias );
        result.append ( ", alpha: " ); //$NON-NLS-1$
        result.append ( alpha );
        result.append ( ", fill: " ); //$NON-NLS-1$
        result.append ( fill );
        result.append ( ", outline: " ); //$NON-NLS-1$
        result.append ( outline );
        result.append ( ')' );
        return result.toString ();
    }

} //ShapeImpl
