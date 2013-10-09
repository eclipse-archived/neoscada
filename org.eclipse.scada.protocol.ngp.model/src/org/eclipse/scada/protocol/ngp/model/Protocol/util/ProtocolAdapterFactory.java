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
package org.eclipse.scada.protocol.ngp.model.Protocol.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.protocol.ngp.model.Protocol.Attribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure;
import org.eclipse.scada.protocol.ngp.model.Protocol.BooleanAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement;
import org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.FloatAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.IntegerAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Interface;
import org.eclipse.scada.protocol.ngp.model.Protocol.LongAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Message;
import org.eclipse.scada.protocol.ngp.model.Protocol.PropertiesAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Protocol;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;
import org.eclipse.scada.protocol.ngp.model.Protocol.StringAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Structure;
import org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.VariantAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.VariantMapAttribute;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage
 * @generated
 */
public class ProtocolAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ProtocolPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProtocolAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ProtocolPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the
     * model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( final Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProtocolSwitch<Adapter> modelSwitch = new ProtocolSwitch<Adapter> () {
        @Override
        public Adapter caseMessage ( final Message object )
        {
            return createMessageAdapter ();
        }

        @Override
        public Adapter caseAttribute ( final Attribute object )
        {
            return createAttributeAdapter ();
        }

        @Override
        public Adapter caseProtocol ( final Protocol object )
        {
            return createProtocolAdapter ();
        }

        @Override
        public Adapter caseStructure ( final Structure object )
        {
            return createStructureAdapter ();
        }

        @Override
        public Adapter caseStringAttribute ( final StringAttribute object )
        {
            return createStringAttributeAdapter ();
        }

        @Override
        public Adapter caseBooleanAttribute ( final BooleanAttribute object )
        {
            return createBooleanAttributeAdapter ();
        }

        @Override
        public Adapter caseStructureAttribute ( final StructureAttribute object )
        {
            return createStructureAttributeAdapter ();
        }

        @Override
        public Adapter caseVariantAttribute ( final VariantAttribute object )
        {
            return createVariantAttributeAdapter ();
        }

        @Override
        public Adapter caseIntegerAttribute ( final IntegerAttribute object )
        {
            return createIntegerAttributeAdapter ();
        }

        @Override
        public Adapter caseLongAttribute ( final LongAttribute object )
        {
            return createLongAttributeAdapter ();
        }

        @Override
        public Adapter caseFloatAttribute ( final FloatAttribute object )
        {
            return createFloatAttributeAdapter ();
        }

        @Override
        public Adapter caseVariantMapAttribute ( final VariantMapAttribute object )
        {
            return createVariantMapAttributeAdapter ();
        }

        @Override
        public Adapter casePropertiesAttribute ( final PropertiesAttribute object )
        {
            return createPropertiesAttributeAdapter ();
        }

        @Override
        public Adapter caseEnum ( final org.eclipse.scada.protocol.ngp.model.Protocol.Enum object )
        {
            return createEnumAdapter ();
        }

        @Override
        public Adapter caseEnumAttribute ( final EnumAttribute object )
        {
            return createEnumAttributeAdapter ();
        }

        @Override
        public Adapter caseInterface ( final Interface object )
        {
            return createInterfaceAdapter ();
        }

        @Override
        public Adapter caseAttributeStructure ( final AttributeStructure object )
        {
            return createAttributeStructureAdapter ();
        }

        @Override
        public Adapter caseDocumentedElement ( final DocumentedElement object )
        {
            return createDocumentedElementAdapter ();
        }

        @Override
        public Adapter defaultCase ( final EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( final Notifier target )
    {
        return this.modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Message
     * <em>Message</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Message
     * @generated
     */
    public Adapter createMessageAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute
     * <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Attribute
     * @generated
     */
    public Adapter createAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol
     * <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol
     * @generated
     */
    public Adapter createProtocolAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Structure
     * <em>Structure</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Structure
     * @generated
     */
    public Adapter createStructureAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.StringAttribute
     * <em>String Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.StringAttribute
     * @generated
     */
    public Adapter createStringAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.BooleanAttribute
     * <em>Boolean Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.BooleanAttribute
     * @generated
     */
    public Adapter createBooleanAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute
     * <em>Structure Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute
     * @generated
     */
    public Adapter createStructureAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.VariantAttribute
     * <em>Variant Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.VariantAttribute
     * @generated
     */
    public Adapter createVariantAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.IntegerAttribute
     * <em>Integer Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.IntegerAttribute
     * @generated
     */
    public Adapter createIntegerAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.LongAttribute
     * <em>Long Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.LongAttribute
     * @generated
     */
    public Adapter createLongAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.FloatAttribute
     * <em>Float Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.FloatAttribute
     * @generated
     */
    public Adapter createFloatAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.VariantMapAttribute
     * <em>Variant Map Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.VariantMapAttribute
     * @generated
     */
    public Adapter createVariantMapAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.PropertiesAttribute
     * <em>Properties Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.PropertiesAttribute
     * @generated
     */
    public Adapter createPropertiesAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum <em>Enum</em>}
     * '.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Enum
     * @generated
     */
    public Adapter createEnumAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute
     * <em>Enum Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute
     * @generated
     */
    public Adapter createEnumAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Interface
     * <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Interface
     * @generated
     */
    public Adapter createInterfaceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure
     * <em>Attribute Structure</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure
     * @generated
     */
    public Adapter createAttributeStructureAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement
     * <em>Documented Element</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement
     * @generated
     */
    public Adapter createDocumentedElementAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //ProtocolAdapterFactory
