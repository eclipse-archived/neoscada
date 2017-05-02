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
import org.eclipse.scada.vi.details.model.TextInputComponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Input Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.TextInputComponentImpl#getDescriptor <em>Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.TextInputComponentImpl#getReadDescriptor <em>Read Descriptor</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.TextInputComponentImpl#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextInputComponentImpl extends WriteableComponentImpl implements TextInputComponent
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TextInputComponentImpl ()
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
        return DetailViewPackage.Literals.TEXT_INPUT_COMPONENT;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.TEXT_INPUT_COMPONENT__DESCRIPTOR, oldDescriptor, descriptor ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.TEXT_INPUT_COMPONENT__READ_DESCRIPTOR, oldReadDescriptor, readDescriptor ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.TEXT_INPUT_COMPONENT__WIDTH, oldWidth, width ) );
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
            case DetailViewPackage.TEXT_INPUT_COMPONENT__DESCRIPTOR:
                return getDescriptor ();
            case DetailViewPackage.TEXT_INPUT_COMPONENT__READ_DESCRIPTOR:
                return getReadDescriptor ();
            case DetailViewPackage.TEXT_INPUT_COMPONENT__WIDTH:
                return getWidth ();
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
            case DetailViewPackage.TEXT_INPUT_COMPONENT__DESCRIPTOR:
                setDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.TEXT_INPUT_COMPONENT__READ_DESCRIPTOR:
                setReadDescriptor ( (String)newValue );
                return;
            case DetailViewPackage.TEXT_INPUT_COMPONENT__WIDTH:
                setWidth ( (Integer)newValue );
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
            case DetailViewPackage.TEXT_INPUT_COMPONENT__DESCRIPTOR:
                setDescriptor ( DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.TEXT_INPUT_COMPONENT__READ_DESCRIPTOR:
                setReadDescriptor ( READ_DESCRIPTOR_EDEFAULT );
                return;
            case DetailViewPackage.TEXT_INPUT_COMPONENT__WIDTH:
                setWidth ( WIDTH_EDEFAULT );
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
            case DetailViewPackage.TEXT_INPUT_COMPONENT__DESCRIPTOR:
                return DESCRIPTOR_EDEFAULT == null ? descriptor != null : !DESCRIPTOR_EDEFAULT.equals ( descriptor );
            case DetailViewPackage.TEXT_INPUT_COMPONENT__READ_DESCRIPTOR:
                return READ_DESCRIPTOR_EDEFAULT == null ? readDescriptor != null : !READ_DESCRIPTOR_EDEFAULT.equals ( readDescriptor );
            case DetailViewPackage.TEXT_INPUT_COMPONENT__WIDTH:
                return width != WIDTH_EDEFAULT;
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
        result.append ( ", readDescriptor: " ); //$NON-NLS-1$
        result.append ( readDescriptor );
        result.append ( ", width: " ); //$NON-NLS-1$
        result.append ( width );
        result.append ( ')' );
        return result.toString ();
    }

} //TextInputComponentImpl
