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
import org.eclipse.scada.vi.details.model.URLImageComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>URL Image Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.URLImageComponentImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.URLImageComponentImpl#getImageUrl <em>Image Url</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.URLImageComponentImpl#getFallbackImageUrl <em>Fallback Image Url</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.URLImageComponentImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.URLImageComponentImpl#getHeight <em>Height</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class URLImageComponentImpl extends ComponentImpl implements URLImageComponent
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
     * The default value of the '{@link #getImageUrl() <em>Image Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImageUrl()
     * @generated
     * @ordered
     */
    protected static final String IMAGE_URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImageUrl() <em>Image Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImageUrl()
     * @generated
     * @ordered
     */
    protected String imageUrl = IMAGE_URL_EDEFAULT;

    /**
     * The default value of the '{@link #getFallbackImageUrl() <em>Fallback Image Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFallbackImageUrl()
     * @generated
     * @ordered
     */
    protected static final String FALLBACK_IMAGE_URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFallbackImageUrl() <em>Fallback Image Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFallbackImageUrl()
     * @generated
     * @ordered
     */
    protected String fallbackImageUrl = FALLBACK_IMAGE_URL_EDEFAULT;

    /**
     * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected static final Integer WIDTH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected Integer width = WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected static final Integer HEIGHT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected Integer height = HEIGHT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected URLImageComponentImpl ()
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
        return DetailViewPackage.Literals.URL_IMAGE_COMPONENT;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.URL_IMAGE_COMPONENT__DESCRIPTOR, oldDescriptor, descriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getImageUrl ()
    {
        return imageUrl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImageUrl ( String newImageUrl )
    {
        String oldImageUrl = imageUrl;
        imageUrl = newImageUrl;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.URL_IMAGE_COMPONENT__IMAGE_URL, oldImageUrl, imageUrl ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFallbackImageUrl ()
    {
        return fallbackImageUrl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFallbackImageUrl ( String newFallbackImageUrl )
    {
        String oldFallbackImageUrl = fallbackImageUrl;
        fallbackImageUrl = newFallbackImageUrl;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.URL_IMAGE_COMPONENT__FALLBACK_IMAGE_URL, oldFallbackImageUrl, fallbackImageUrl ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getWidth ()
    {
        return width;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setWidth ( Integer newWidth )
    {
        Integer oldWidth = width;
        width = newWidth;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.URL_IMAGE_COMPONENT__WIDTH, oldWidth, width ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getHeight ()
    {
        return height;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHeight ( Integer newHeight )
    {
        Integer oldHeight = height;
        height = newHeight;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.URL_IMAGE_COMPONENT__HEIGHT, oldHeight, height ) );
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
            case DetailViewPackage.URL_IMAGE_COMPONENT__DESCRIPTOR:
                return getDescriptor ();
            case DetailViewPackage.URL_IMAGE_COMPONENT__IMAGE_URL:
                return getImageUrl ();
            case DetailViewPackage.URL_IMAGE_COMPONENT__FALLBACK_IMAGE_URL:
                return getFallbackImageUrl ();
            case DetailViewPackage.URL_IMAGE_COMPONENT__WIDTH:
                return getWidth ();
            case DetailViewPackage.URL_IMAGE_COMPONENT__HEIGHT:
                return getHeight ();
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
            case DetailViewPackage.URL_IMAGE_COMPONENT__DESCRIPTOR:
                setDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.URL_IMAGE_COMPONENT__IMAGE_URL:
                setImageUrl ( (String)newValue );
                return;
            case DetailViewPackage.URL_IMAGE_COMPONENT__FALLBACK_IMAGE_URL:
                setFallbackImageUrl ( (String)newValue );
                return;
            case DetailViewPackage.URL_IMAGE_COMPONENT__WIDTH:
                setWidth ( (Integer)newValue );
                return;
            case DetailViewPackage.URL_IMAGE_COMPONENT__HEIGHT:
                setHeight ( (Integer)newValue );
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
            case DetailViewPackage.URL_IMAGE_COMPONENT__DESCRIPTOR:
                setDescriptor ( DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.URL_IMAGE_COMPONENT__IMAGE_URL:
                setImageUrl ( IMAGE_URL_EDEFAULT );
                return;
            case DetailViewPackage.URL_IMAGE_COMPONENT__FALLBACK_IMAGE_URL:
                setFallbackImageUrl ( FALLBACK_IMAGE_URL_EDEFAULT );
                return;
            case DetailViewPackage.URL_IMAGE_COMPONENT__WIDTH:
                setWidth ( WIDTH_EDEFAULT );
                return;
            case DetailViewPackage.URL_IMAGE_COMPONENT__HEIGHT:
                setHeight ( HEIGHT_EDEFAULT );
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
            case DetailViewPackage.URL_IMAGE_COMPONENT__DESCRIPTOR:
                return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals ( descriptor );
            case DetailViewPackage.URL_IMAGE_COMPONENT__IMAGE_URL:
                return IMAGE_URL_EDEFAULT == null ? imageUrl != null : !IMAGE_URL_EDEFAULT.equals ( imageUrl );
            case DetailViewPackage.URL_IMAGE_COMPONENT__FALLBACK_IMAGE_URL:
                return FALLBACK_IMAGE_URL_EDEFAULT == null ? fallbackImageUrl != null : !FALLBACK_IMAGE_URL_EDEFAULT.equals ( fallbackImageUrl );
            case DetailViewPackage.URL_IMAGE_COMPONENT__WIDTH:
                return WIDTH_EDEFAULT == null ? width != null : !WIDTH_EDEFAULT.equals ( width );
            case DetailViewPackage.URL_IMAGE_COMPONENT__HEIGHT:
                return HEIGHT_EDEFAULT == null ? height != null : !HEIGHT_EDEFAULT.equals ( height );
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
        result.append ( ", imageUrl: " ); //$NON-NLS-1$
        result.append ( imageUrl );
        result.append ( ", fallbackImageUrl: " ); //$NON-NLS-1$
        result.append ( fallbackImageUrl );
        result.append ( ", width: " ); //$NON-NLS-1$
        result.append ( width );
        result.append ( ", height: " ); //$NON-NLS-1$
        result.append ( height );
        result.append ( ')' );
        return result.toString ();
    }

} //URLImageComponentImpl
