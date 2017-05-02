/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.world.osgi.ArchiveConfiguration;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Archive Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ArchiveConfigurationImpl#getFileSizeInMilliseconds <em>File Size In Milliseconds</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ArchiveConfigurationImpl#getNumberOfFiles <em>Number Of Files</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArchiveConfigurationImpl extends MinimalEObjectImpl.Container implements ArchiveConfiguration
{
    /**
     * The default value of the '{@link #getFileSizeInMilliseconds() <em>File Size In Milliseconds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFileSizeInMilliseconds()
     * @generated
     * @ordered
     */
    protected static final long FILE_SIZE_IN_MILLISECONDS_EDEFAULT = 3600000L;

    /**
     * The cached value of the '{@link #getFileSizeInMilliseconds() <em>File Size In Milliseconds</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFileSizeInMilliseconds()
     * @generated
     * @ordered
     */
    protected long fileSizeInMilliseconds = FILE_SIZE_IN_MILLISECONDS_EDEFAULT;

    /**
     * The default value of the '{@link #getNumberOfFiles() <em>Number Of Files</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNumberOfFiles()
     * @generated
     * @ordered
     */
    protected static final long NUMBER_OF_FILES_EDEFAULT = 2160L;

    /**
     * The cached value of the '{@link #getNumberOfFiles() <em>Number Of Files</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNumberOfFiles()
     * @generated
     * @ordered
     */
    protected long numberOfFiles = NUMBER_OF_FILES_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ArchiveConfigurationImpl ()
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
        return OsgiPackage.Literals.ARCHIVE_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getFileSizeInMilliseconds ()
    {
        return fileSizeInMilliseconds;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFileSizeInMilliseconds ( long newFileSizeInMilliseconds )
    {
        long oldFileSizeInMilliseconds = fileSizeInMilliseconds;
        fileSizeInMilliseconds = newFileSizeInMilliseconds;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ARCHIVE_CONFIGURATION__FILE_SIZE_IN_MILLISECONDS, oldFileSizeInMilliseconds, fileSizeInMilliseconds ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getNumberOfFiles ()
    {
        return numberOfFiles;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNumberOfFiles ( long newNumberOfFiles )
    {
        long oldNumberOfFiles = numberOfFiles;
        numberOfFiles = newNumberOfFiles;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ARCHIVE_CONFIGURATION__NUMBER_OF_FILES, oldNumberOfFiles, numberOfFiles ) );
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
            case OsgiPackage.ARCHIVE_CONFIGURATION__FILE_SIZE_IN_MILLISECONDS:
                return getFileSizeInMilliseconds ();
            case OsgiPackage.ARCHIVE_CONFIGURATION__NUMBER_OF_FILES:
                return getNumberOfFiles ();
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
            case OsgiPackage.ARCHIVE_CONFIGURATION__FILE_SIZE_IN_MILLISECONDS:
                setFileSizeInMilliseconds ( (Long)newValue );
                return;
            case OsgiPackage.ARCHIVE_CONFIGURATION__NUMBER_OF_FILES:
                setNumberOfFiles ( (Long)newValue );
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
            case OsgiPackage.ARCHIVE_CONFIGURATION__FILE_SIZE_IN_MILLISECONDS:
                setFileSizeInMilliseconds ( FILE_SIZE_IN_MILLISECONDS_EDEFAULT );
                return;
            case OsgiPackage.ARCHIVE_CONFIGURATION__NUMBER_OF_FILES:
                setNumberOfFiles ( NUMBER_OF_FILES_EDEFAULT );
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
            case OsgiPackage.ARCHIVE_CONFIGURATION__FILE_SIZE_IN_MILLISECONDS:
                return fileSizeInMilliseconds != FILE_SIZE_IN_MILLISECONDS_EDEFAULT;
            case OsgiPackage.ARCHIVE_CONFIGURATION__NUMBER_OF_FILES:
                return numberOfFiles != NUMBER_OF_FILES_EDEFAULT;
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
        result.append ( " (fileSizeInMilliseconds: " ); //$NON-NLS-1$
        result.append ( fileSizeInMilliseconds );
        result.append ( ", numberOfFiles: " ); //$NON-NLS-1$
        result.append ( numberOfFiles );
        result.append ( ')' );
        return result.toString ();
    }

} //ArchiveConfigurationImpl
