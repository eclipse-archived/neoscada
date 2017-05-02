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
import org.eclipse.scada.vi.details.model.CheckComponent;
import org.eclipse.scada.vi.details.model.DetailViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Check Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.CheckComponentImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.CheckComponentImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.CheckComponentImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.CheckComponentImpl#getReadDescriptor <em>Read Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckComponentImpl extends ComponentImpl implements CheckComponent
{
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
     * The default value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttribute()
     * @generated
     * @ordered
     */
    protected static final String ATTRIBUTE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAttribute()
     * @generated
     * @ordered
     */
    protected String attribute = ATTRIBUTE_EDEFAULT;

    /**
     * The default value of the '{@link #getReadDescriptor() <em>Read Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReadDescriptor()
     * @generated
     * @ordered
     */
    protected static final String READ_DESCRIPTOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getReadDescriptor() <em>Read Descriptor</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReadDescriptor()
     * @generated
     * @ordered
     */
    protected String readDescriptor = READ_DESCRIPTOR_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CheckComponentImpl ()
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
        return DetailViewPackage.Literals.CHECK_COMPONENT;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.CHECK_COMPONENT__FORMAT, oldFormat, format ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.CHECK_COMPONENT__DESCRIPTOR, oldDescriptor, descriptor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getAttribute ()
    {
        return attribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAttribute ( String newAttribute )
    {
        String oldAttribute = attribute;
        attribute = newAttribute;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.CHECK_COMPONENT__ATTRIBUTE, oldAttribute, attribute ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getReadDescriptor ()
    {
        return readDescriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReadDescriptor ( String newReadDescriptor )
    {
        String oldReadDescriptor = readDescriptor;
        readDescriptor = newReadDescriptor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.CHECK_COMPONENT__READ_DESCRIPTOR, oldReadDescriptor, readDescriptor ) );
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
            case DetailViewPackage.CHECK_COMPONENT__FORMAT:
                return getFormat ();
            case DetailViewPackage.CHECK_COMPONENT__DESCRIPTOR:
                return getDescriptor ();
            case DetailViewPackage.CHECK_COMPONENT__ATTRIBUTE:
                return getAttribute ();
            case DetailViewPackage.CHECK_COMPONENT__READ_DESCRIPTOR:
                return getReadDescriptor ();
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
            case DetailViewPackage.CHECK_COMPONENT__FORMAT:
                setFormat ( (String)newValue );
                return;
            case DetailViewPackage.CHECK_COMPONENT__DESCRIPTOR:
                setDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.CHECK_COMPONENT__ATTRIBUTE:
                setAttribute ( (String)newValue );
                return;
            case DetailViewPackage.CHECK_COMPONENT__READ_DESCRIPTOR:
                setReadDescriptor ( (String)newValue );
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
            case DetailViewPackage.CHECK_COMPONENT__FORMAT:
                setFormat ( FORMAT_EDEFAULT );
                return;
            case DetailViewPackage.CHECK_COMPONENT__DESCRIPTOR:
                setDescriptor ( DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.CHECK_COMPONENT__ATTRIBUTE:
                setAttribute ( ATTRIBUTE_EDEFAULT );
                return;
            case DetailViewPackage.CHECK_COMPONENT__READ_DESCRIPTOR:
                setReadDescriptor ( READ_DESCRIPTOR_EDEFAULT );
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
            case DetailViewPackage.CHECK_COMPONENT__FORMAT:
                return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals ( format );
            case DetailViewPackage.CHECK_COMPONENT__DESCRIPTOR:
                return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals ( descriptor );
            case DetailViewPackage.CHECK_COMPONENT__ATTRIBUTE:
                return ATTRIBUTE_EDEFAULT == null ? attribute != null : !ATTRIBUTE_EDEFAULT.equals ( attribute );
            case DetailViewPackage.CHECK_COMPONENT__READ_DESCRIPTOR:
                return READ_DESCRIPTOR_EDEFAULT == null ? readDescriptor != null : !READ_DESCRIPTOR_EDEFAULT.equals ( readDescriptor );
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
        result.append ( " (format: " ); //$NON-NLS-1$
        result.append ( format );
        result.append ( ", descriptor: " ); //$NON-NLS-1$
        result.append ( descriptor );
        result.append ( ", attribute: " ); //$NON-NLS-1$
        result.append ( attribute );
        result.append ( ", readDescriptor: " ); //$NON-NLS-1$
        result.append ( readDescriptor );
        result.append ( ')' );
        return result.toString ();
    }

} //CheckComponentImpl
