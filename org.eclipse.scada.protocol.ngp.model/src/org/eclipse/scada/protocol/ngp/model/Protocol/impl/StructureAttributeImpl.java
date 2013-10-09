/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.Protocol.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;
import org.eclipse.scada.protocol.ngp.model.Protocol.Structure;
import org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureAttributeImpl#getStructure
 * <em>Structure</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StructureAttributeImpl extends AttributeImpl implements StructureAttribute
{
    /**
     * The cached value of the '{@link #getStructure() <em>Structure</em>}'
     * reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getStructure()
     * @generated
     * @ordered
     */
    protected Structure structure;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected StructureAttributeImpl ()
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
        return ProtocolPackage.Literals.STRUCTURE_ATTRIBUTE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Structure getStructure ()
    {
        if ( this.structure != null && this.structure.eIsProxy () )
        {
            final InternalEObject oldStructure = (InternalEObject)this.structure;
            this.structure = (Structure)eResolveProxy ( oldStructure );
            if ( this.structure != oldStructure )
            {
                if ( eNotificationRequired () )
                {
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ProtocolPackage.STRUCTURE_ATTRIBUTE__STRUCTURE, oldStructure, this.structure ) );
                }
            }
        }
        return this.structure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public Structure basicGetStructure ()
    {
        return this.structure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setStructure ( final Structure newStructure )
    {
        final Structure oldStructure = this.structure;
        this.structure = newStructure;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ProtocolPackage.STRUCTURE_ATTRIBUTE__STRUCTURE, oldStructure, this.structure ) );
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
            case ProtocolPackage.STRUCTURE_ATTRIBUTE__STRUCTURE:
                if ( resolve )
                {
                    return getStructure ();
                }
                return basicGetStructure ();
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
            case ProtocolPackage.STRUCTURE_ATTRIBUTE__STRUCTURE:
                setStructure ( (Structure)newValue );
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
            case ProtocolPackage.STRUCTURE_ATTRIBUTE__STRUCTURE:
                setStructure ( (Structure)null );
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
            case ProtocolPackage.STRUCTURE_ATTRIBUTE__STRUCTURE:
                return this.structure != null;
        }
        return super.eIsSet ( featureID );
    }

} //StructureAttributeImpl
