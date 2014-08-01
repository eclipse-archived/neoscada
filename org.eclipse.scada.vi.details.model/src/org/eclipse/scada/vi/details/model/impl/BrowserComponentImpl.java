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
package org.eclipse.scada.vi.details.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.vi.details.model.BrowserComponent;
import org.eclipse.scada.vi.details.model.DetailViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Browser Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.vi.details.model.impl.BrowserComponentImpl#getUrl
 * <em>Url</em>}</li>
 * <li>
 * {@link org.eclipse.scada.vi.details.model.impl.BrowserComponentImpl#getWidth
 * <em>Width</em>}</li>
 * <li>
 * {@link org.eclipse.scada.vi.details.model.impl.BrowserComponentImpl#getHeight
 * <em>Height</em>}</li>
 * <li>
 * {@link org.eclipse.scada.vi.details.model.impl.BrowserComponentImpl#getReloadTimer
 * <em>Reload Timer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BrowserComponentImpl extends ComponentImpl implements BrowserComponent
{
    /**
     * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected static final String URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected String url = URL_EDEFAULT;

    /**
     * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected static final Integer WIDTH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getWidth()
     * @generated
     * @ordered
     */
    protected Integer width = WIDTH_EDEFAULT;

    /**
     * The default value of the '{@link #getHeight() <em>Height</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected static final Integer HEIGHT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getHeight()
     * @generated
     * @ordered
     */
    protected Integer height = HEIGHT_EDEFAULT;

    /**
     * The default value of the '{@link #getReloadTimer() <em>Reload Timer</em>}
     * ' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getReloadTimer()
     * @generated
     * @ordered
     */
    protected static final Long RELOAD_TIMER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getReloadTimer() <em>Reload Timer</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getReloadTimer()
     * @generated
     * @ordered
     */
    protected Long reloadTimer = RELOAD_TIMER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected BrowserComponentImpl ()
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
        return DetailViewPackage.Literals.BROWSER_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getUrl ()
    {
        return this.url;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setUrl ( final String newUrl )
    {
        final String oldUrl = this.url;
        this.url = newUrl;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BROWSER_COMPONENT__URL, oldUrl, this.url ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Integer getWidth ()
    {
        return this.width;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setWidth ( final Integer newWidth )
    {
        final Integer oldWidth = this.width;
        this.width = newWidth;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BROWSER_COMPONENT__WIDTH, oldWidth, this.width ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Integer getHeight ()
    {
        return this.height;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setHeight ( final Integer newHeight )
    {
        final Integer oldHeight = this.height;
        this.height = newHeight;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BROWSER_COMPONENT__HEIGHT, oldHeight, this.height ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Long getReloadTimer ()
    {
        return this.reloadTimer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setReloadTimer ( final Long newReloadTimer )
    {
        final Long oldReloadTimer = this.reloadTimer;
        this.reloadTimer = newReloadTimer;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.BROWSER_COMPONENT__RELOAD_TIMER, oldReloadTimer, this.reloadTimer ) );
        }
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
            case DetailViewPackage.BROWSER_COMPONENT__URL:
                return getUrl ();
            case DetailViewPackage.BROWSER_COMPONENT__WIDTH:
                return getWidth ();
            case DetailViewPackage.BROWSER_COMPONENT__HEIGHT:
                return getHeight ();
            case DetailViewPackage.BROWSER_COMPONENT__RELOAD_TIMER:
                return getReloadTimer ();
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
            case DetailViewPackage.BROWSER_COMPONENT__URL:
                setUrl ( (String)newValue );
                return;
            case DetailViewPackage.BROWSER_COMPONENT__WIDTH:
                setWidth ( (Integer)newValue );
                return;
            case DetailViewPackage.BROWSER_COMPONENT__HEIGHT:
                setHeight ( (Integer)newValue );
                return;
            case DetailViewPackage.BROWSER_COMPONENT__RELOAD_TIMER:
                setReloadTimer ( (Long)newValue );
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
            case DetailViewPackage.BROWSER_COMPONENT__URL:
                setUrl ( URL_EDEFAULT );
                return;
            case DetailViewPackage.BROWSER_COMPONENT__WIDTH:
                setWidth ( WIDTH_EDEFAULT );
                return;
            case DetailViewPackage.BROWSER_COMPONENT__HEIGHT:
                setHeight ( HEIGHT_EDEFAULT );
                return;
            case DetailViewPackage.BROWSER_COMPONENT__RELOAD_TIMER:
                setReloadTimer ( RELOAD_TIMER_EDEFAULT );
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
            case DetailViewPackage.BROWSER_COMPONENT__URL:
                return URL_EDEFAULT == null ? this.url != null : !URL_EDEFAULT.equals ( this.url );
            case DetailViewPackage.BROWSER_COMPONENT__WIDTH:
                return WIDTH_EDEFAULT == null ? this.width != null : !WIDTH_EDEFAULT.equals ( this.width );
            case DetailViewPackage.BROWSER_COMPONENT__HEIGHT:
                return HEIGHT_EDEFAULT == null ? this.height != null : !HEIGHT_EDEFAULT.equals ( this.height );
            case DetailViewPackage.BROWSER_COMPONENT__RELOAD_TIMER:
                return RELOAD_TIMER_EDEFAULT == null ? this.reloadTimer != null : !RELOAD_TIMER_EDEFAULT.equals ( this.reloadTimer );
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

        final StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (url: " ); //$NON-NLS-1$
        result.append ( this.url );
        result.append ( ", width: " ); //$NON-NLS-1$
        result.append ( this.width );
        result.append ( ", height: " ); //$NON-NLS-1$
        result.append ( this.height );
        result.append ( ", reloadTimer: " ); //$NON-NLS-1$
        result.append ( this.reloadTimer );
        result.append ( ')' );
        return result.toString ();
    }

} //BrowserComponentImpl
