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
package org.eclipse.scada.configuration.world.deployment.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.deployment.Author;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.ChangeEntryImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.ChangeEntryImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.ChangeEntryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.impl.ChangeEntryImpl#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ChangeEntryImpl extends MinimalEObjectImpl.Container implements ChangeEntry
{
    /**
     * The cached value of the '{@link #getAuthor() <em>Author</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthor()
     * @generated
     * @ordered
     */
    protected Author author;

    /**
     * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDate()
     * @generated
     * @ordered
     */
    protected static final Date DATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDate()
     * @generated
     * @ordered
     */
    protected Date date = DATE_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected static final String VERSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
    protected String version = VERSION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChangeEntryImpl ()
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
        return DeploymentPackage.Literals.CHANGE_ENTRY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Author getAuthor ()
    {
        if ( author != null && author.eIsProxy () )
        {
            InternalEObject oldAuthor = (InternalEObject)author;
            author = (Author)eResolveProxy ( oldAuthor );
            if ( author != oldAuthor )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, DeploymentPackage.CHANGE_ENTRY__AUTHOR, oldAuthor, author ) );
            }
        }
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Author basicGetAuthor ()
    {
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAuthor ( Author newAuthor )
    {
        Author oldAuthor = author;
        author = newAuthor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.CHANGE_ENTRY__AUTHOR, oldAuthor, author ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Date getDate ()
    {
        return date;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDate ( Date newDate )
    {
        Date oldDate = date;
        date = newDate;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.CHANGE_ENTRY__DATE, oldDate, date ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription ( String newDescription )
    {
        String oldDescription = description;
        description = newDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.CHANGE_ENTRY__DESCRIPTION, oldDescription, description ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getVersion ()
    {
        return version;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVersion ( String newVersion )
    {
        String oldVersion = version;
        version = newVersion;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DeploymentPackage.CHANGE_ENTRY__VERSION, oldVersion, version ) );
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
            case DeploymentPackage.CHANGE_ENTRY__AUTHOR:
                if ( resolve )
                    return getAuthor ();
                return basicGetAuthor ();
            case DeploymentPackage.CHANGE_ENTRY__DATE:
                return getDate ();
            case DeploymentPackage.CHANGE_ENTRY__DESCRIPTION:
                return getDescription ();
            case DeploymentPackage.CHANGE_ENTRY__VERSION:
                return getVersion ();
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
            case DeploymentPackage.CHANGE_ENTRY__AUTHOR:
                setAuthor ( (Author)newValue );
                return;
            case DeploymentPackage.CHANGE_ENTRY__DATE:
                setDate ( (Date)newValue );
                return;
            case DeploymentPackage.CHANGE_ENTRY__DESCRIPTION:
                setDescription ( (String)newValue );
                return;
            case DeploymentPackage.CHANGE_ENTRY__VERSION:
                setVersion ( (String)newValue );
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
            case DeploymentPackage.CHANGE_ENTRY__AUTHOR:
                setAuthor ( (Author)null );
                return;
            case DeploymentPackage.CHANGE_ENTRY__DATE:
                setDate ( DATE_EDEFAULT );
                return;
            case DeploymentPackage.CHANGE_ENTRY__DESCRIPTION:
                setDescription ( DESCRIPTION_EDEFAULT );
                return;
            case DeploymentPackage.CHANGE_ENTRY__VERSION:
                setVersion ( VERSION_EDEFAULT );
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
            case DeploymentPackage.CHANGE_ENTRY__AUTHOR:
                return author != null;
            case DeploymentPackage.CHANGE_ENTRY__DATE:
                return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT.equals ( date );
            case DeploymentPackage.CHANGE_ENTRY__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals ( description );
            case DeploymentPackage.CHANGE_ENTRY__VERSION:
                return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals ( version );
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
        result.append ( " (date: " ); //$NON-NLS-1$
        result.append ( date );
        result.append ( ", description: " ); //$NON-NLS-1$
        result.append ( description );
        result.append ( ", version: " ); //$NON-NLS-1$
        result.append ( version );
        result.append ( ')' );
        return result.toString ();
    }

} //ChangeEntryImpl
