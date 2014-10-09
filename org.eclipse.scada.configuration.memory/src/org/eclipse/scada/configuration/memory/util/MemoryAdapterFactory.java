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
package org.eclipse.scada.configuration.memory.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.memory.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.memory.MemoryPackage
 * @generated
 */
public class MemoryAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MemoryPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MemoryAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = MemoryPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
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
     * @generated
     */
    protected MemorySwitch<Adapter> modelSwitch = new MemorySwitch<Adapter> () {
        @Override
        public Adapter caseTypeDefinition ( TypeDefinition object )
        {
            return createTypeDefinitionAdapter ();
        }

        @Override
        public Adapter caseBitType ( BitType object )
        {
            return createBitTypeAdapter ();
        }

        @Override
        public Adapter caseType ( Type object )
        {
            return createTypeAdapter ();
        }

        @Override
        public Adapter caseVariable ( Variable object )
        {
            return createVariableAdapter ();
        }

        @Override
        public Adapter caseAttribute ( Attribute object )
        {
            return createAttributeAdapter ();
        }

        @Override
        public Adapter caseFloat32Type ( Float32Type object )
        {
            return createFloat32TypeAdapter ();
        }

        @Override
        public Adapter caseBaseScalarType ( BaseScalarType object )
        {
            return createBaseScalarTypeAdapter ();
        }

        @Override
        public Adapter caseUserDefinedType ( UserDefinedType object )
        {
            return createUserDefinedTypeAdapter ();
        }

        @Override
        public Adapter caseUnsignedInteger16Type ( UnsignedInteger16Type object )
        {
            return createUnsignedInteger16TypeAdapter ();
        }

        @Override
        public Adapter caseScalarType ( ScalarType object )
        {
            return createScalarTypeAdapter ();
        }

        @Override
        public Adapter caseUnsignedInteger32Type ( UnsignedInteger32Type object )
        {
            return createUnsignedInteger32TypeAdapter ();
        }

        @Override
        public Adapter caseUnsignedInteger8Type ( UnsignedInteger8Type object )
        {
            return createUnsignedInteger8TypeAdapter ();
        }

        @Override
        public Adapter caseTypeSystem ( TypeSystem object )
        {
            return createTypeSystemAdapter ();
        }

        @Override
        public Adapter caseOrderedType ( OrderedType object )
        {
            return createOrderedTypeAdapter ();
        }

        @Override
        public Adapter caseFloat64Type ( Float64Type object )
        {
            return createFloat64TypeAdapter ();
        }

        @Override
        public Adapter caseSignedInteger8Type ( SignedInteger8Type object )
        {
            return createSignedInteger8TypeAdapter ();
        }

        @Override
        public Adapter caseSignedInteger16Type ( SignedInteger16Type object )
        {
            return createSignedInteger16TypeAdapter ();
        }

        @Override
        public Adapter caseSignedInteger32Type ( SignedInteger32Type object )
        {
            return createSignedInteger32TypeAdapter ();
        }

        @Override
        public Adapter caseSignedInteger64Type ( SignedInteger64Type object )
        {
            return createSignedInteger64TypeAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.TypeDefinition <em>Type Definition</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.TypeDefinition
     * @generated
     */
    public Adapter createTypeDefinitionAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.UserDefinedType <em>User Defined Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.UserDefinedType
     * @generated
     */
    public Adapter createUserDefinedTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.UnsignedInteger16Type <em>Unsigned Integer16 Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.UnsignedInteger16Type
     * @generated
     */
    public Adapter createUnsignedInteger16TypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.ScalarType <em>Scalar Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.ScalarType
     * @generated
     */
    public Adapter createScalarTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.UnsignedInteger32Type <em>Unsigned Integer32 Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.UnsignedInteger32Type
     * @generated
     */
    public Adapter createUnsignedInteger32TypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.UnsignedInteger8Type <em>Unsigned Integer8 Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.UnsignedInteger8Type
     * @generated
     */
    public Adapter createUnsignedInteger8TypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.TypeSystem <em>Type System</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.TypeSystem
     * @generated
     */
    public Adapter createTypeSystemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.OrderedType <em>Ordered Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.OrderedType
     * @generated
     */
    public Adapter createOrderedTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.Float64Type <em>Float64 Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.Float64Type
     * @generated
     */
    public Adapter createFloat64TypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.SignedInteger8Type <em>Signed Integer8 Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.SignedInteger8Type
     * @generated
     */
    public Adapter createSignedInteger8TypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.SignedInteger16Type <em>Signed Integer16 Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.SignedInteger16Type
     * @generated
     */
    public Adapter createSignedInteger16TypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.SignedInteger32Type <em>Signed Integer32 Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.SignedInteger32Type
     * @generated
     */
    public Adapter createSignedInteger32TypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.SignedInteger64Type <em>Signed Integer64 Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.SignedInteger64Type
     * @generated
     */
    public Adapter createSignedInteger64TypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.BitType <em>Bit Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.BitType
     * @generated
     */
    public Adapter createBitTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.Type <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.Type
     * @generated
     */
    public Adapter createTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.Variable <em>Variable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.Variable
     * @generated
     */
    public Adapter createVariableAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.Attribute <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.Attribute
     * @generated
     */
    public Adapter createAttributeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.Float32Type <em>Float32 Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.Float32Type
     * @generated
     */
    public Adapter createFloat32TypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.memory.BaseScalarType <em>Base Scalar Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.memory.BaseScalarType
     * @generated
     */
    public Adapter createBaseScalarTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //MemoryAdapterFactory
