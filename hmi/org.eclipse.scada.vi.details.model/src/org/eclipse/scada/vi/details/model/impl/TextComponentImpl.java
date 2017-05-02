/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.TextComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.TextComponentImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.TextComponentImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.TextComponentImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.TextComponentImpl#isDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.TextComponentImpl#getTextHeight <em>Text Height</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.TextComponentImpl#getTextMap <em>Text Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextComponentImpl extends ReadableComponentImpl implements TextComponent
{
    /**
     * The default value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescriptor()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescriptor() <em>Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescriptor()
     * @generated
     * @ordered
     */
    protected String descriptor = DESCRIPTOR_EDEFAULT;

    /**
     * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected static final int WIDTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected int width = WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected static final int HEIGHT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected int height = HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #isDate() <em>Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDate()
     * @generated
     * @ordered
     */
    protected static final boolean DATE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDate() <em>Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDate()
     * @generated
     * @ordered
     */
    protected boolean date = DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getTextHeight() <em>Text Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextHeight()
     * @generated
     * @ordered
     */
    protected static final int TEXT_HEIGHT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getTextHeight() <em>Text Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextHeight()
     * @generated
     * @ordered
     */
    protected int textHeight = TEXT_HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #getTextMap() <em>Text Map</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextMap()
     * @generated
     * @ordered
     */
    protected static final String TEXT_MAP_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTextMap() <em>Text Map</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTextMap()
     * @generated
     * @ordered
     */
    protected String textMap = TEXT_MAP_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TextComponentImpl ()
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
        return DetailViewPackage.Literals.TEXT_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescriptor ()
    {
        return descriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescriptor ( String newDescriptor )
    {
        String oldDescriptor = descriptor;
        descriptor = newDescriptor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.TEXT_COMPONENT__DESCRIPTOR, oldDescriptor, descriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getWidth ()
    {
        return width;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWidth ( int newWidth )
    {
        int oldWidth = width;
        width = newWidth;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.TEXT_COMPONENT__WIDTH, oldWidth, width ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getHeight ()
    {
        return height;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHeight ( int newHeight )
    {
        int oldHeight = height;
        height = newHeight;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.TEXT_COMPONENT__HEIGHT, oldHeight, height ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDate ()
    {
        return date;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDate ( boolean newDate )
    {
        boolean oldDate = date;
        date = newDate;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.TEXT_COMPONENT__DATE, oldDate, date ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTextHeight ()
    {
        return textHeight;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTextHeight ( int newTextHeight )
    {
        int oldTextHeight = textHeight;
        textHeight = newTextHeight;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.TEXT_COMPONENT__TEXT_HEIGHT, oldTextHeight, textHeight ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTextMap ()
    {
        return textMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTextMap ( String newTextMap )
    {
        String oldTextMap = textMap;
        textMap = newTextMap;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.TEXT_COMPONENT__TEXT_MAP, oldTextMap, textMap ) );
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
            case DetailViewPackage.TEXT_COMPONENT__DESCRIPTOR:
                return getDescriptor ();
            case DetailViewPackage.TEXT_COMPONENT__WIDTH:
                return getWidth ();
            case DetailViewPackage.TEXT_COMPONENT__HEIGHT:
                return getHeight ();
            case DetailViewPackage.TEXT_COMPONENT__DATE:
                return isDate ();
            case DetailViewPackage.TEXT_COMPONENT__TEXT_HEIGHT:
                return getTextHeight ();
            case DetailViewPackage.TEXT_COMPONENT__TEXT_MAP:
                return getTextMap ();
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
            case DetailViewPackage.TEXT_COMPONENT__DESCRIPTOR:
                setDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.TEXT_COMPONENT__WIDTH:
                setWidth ( (Integer)newValue );
                return;
            case DetailViewPackage.TEXT_COMPONENT__HEIGHT:
                setHeight ( (Integer)newValue );
                return;
            case DetailViewPackage.TEXT_COMPONENT__DATE:
                setDate ( (Boolean)newValue );
                return;
            case DetailViewPackage.TEXT_COMPONENT__TEXT_HEIGHT:
                setTextHeight ( (Integer)newValue );
                return;
            case DetailViewPackage.TEXT_COMPONENT__TEXT_MAP:
                setTextMap ( (String)newValue );
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
            case DetailViewPackage.TEXT_COMPONENT__DESCRIPTOR:
                setDescriptor ( DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.TEXT_COMPONENT__WIDTH:
                setWidth ( WIDTH_EDEFAULT );
                return;
            case DetailViewPackage.TEXT_COMPONENT__HEIGHT:
                setHeight ( HEIGHT_EDEFAULT );
                return;
            case DetailViewPackage.TEXT_COMPONENT__DATE:
                setDate ( DATE_EDEFAULT );
                return;
            case DetailViewPackage.TEXT_COMPONENT__TEXT_HEIGHT:
                setTextHeight ( TEXT_HEIGHT_EDEFAULT );
                return;
            case DetailViewPackage.TEXT_COMPONENT__TEXT_MAP:
                setTextMap ( TEXT_MAP_EDEFAULT );
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
            case DetailViewPackage.TEXT_COMPONENT__DESCRIPTOR:
                return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals ( descriptor );
            case DetailViewPackage.TEXT_COMPONENT__WIDTH:
                return width != WIDTH_EDEFAULT;
            case DetailViewPackage.TEXT_COMPONENT__HEIGHT:
                return height != HEIGHT_EDEFAULT;
            case DetailViewPackage.TEXT_COMPONENT__DATE:
                return date != DATE_EDEFAULT;
            case DetailViewPackage.TEXT_COMPONENT__TEXT_HEIGHT:
                return textHeight != TEXT_HEIGHT_EDEFAULT;
            case DetailViewPackage.TEXT_COMPONENT__TEXT_MAP:
                return TEXT_MAP_EDEFAULT == null ? textMap != null : !TEXT_MAP_EDEFAULT.equals ( textMap );
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
        result.append ( " (descriptor: " ); //$NON-NLS-1$
        result.append ( descriptor );
        result.append ( ", width: " ); //$NON-NLS-1$
        result.append ( width );
        result.append ( ", height: " ); //$NON-NLS-1$
        result.append ( height );
        result.append ( ", date: " ); //$NON-NLS-1$
        result.append ( date );
        result.append ( ", textHeight: " ); //$NON-NLS-1$
        result.append ( textHeight );
        result.append ( ", textMap: " ); //$NON-NLS-1$
        result.append ( textMap );
        result.append ( ')' );
        return result.toString ();
    }

} //TextComponentImpl
