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
package org.eclipse.scada.da.server.component.parser.factory.configuration.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.table.SplitTableExtractor;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ValueConverterDefinition;
import org.eclipse.scada.da.server.component.parser.factory.internal.Descriptors;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Split Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SplitTableImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SplitTableImpl#getLineSeparatorPattern <em>Line Separator Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SplitTableImpl#getFieldSeparatorPattern <em>Field Separator Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SplitTableImpl#getIdColumn <em>Id Column</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SplitTableImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SplitTableImpl#getValueConverter <em>Value Converter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SplitTableImpl extends MinimalEObjectImpl.Container implements SplitTable
{
    /**
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

    /**
     * The default value of the '{@link #getLineSeparatorPattern() <em>Line Separator Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLineSeparatorPattern()
     * @generated
     * @ordered
     */
    protected static final Pattern LINE_SEPARATOR_PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLineSeparatorPattern() <em>Line Separator Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLineSeparatorPattern()
     * @generated
     * @ordered
     */
    protected Pattern lineSeparatorPattern = LINE_SEPARATOR_PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #getFieldSeparatorPattern() <em>Field Separator Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFieldSeparatorPattern()
     * @generated
     * @ordered
     */
    protected static final Pattern FIELD_SEPARATOR_PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFieldSeparatorPattern() <em>Field Separator Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFieldSeparatorPattern()
     * @generated
     * @ordered
     */
    protected Pattern fieldSeparatorPattern = FIELD_SEPARATOR_PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #getIdColumn() <em>Id Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIdColumn()
     * @generated
     * @ordered
     */
    protected static final int ID_COLUMN_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getIdColumn() <em>Id Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIdColumn()
     * @generated
     * @ordered
     */
    protected int idColumn = ID_COLUMN_EDEFAULT;

    /**
     * The cached value of the '{@link #getFields() <em>Fields</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFields()
     * @generated
     * @ordered
     */
    protected EList<String> fields;

    /**
     * The cached value of the '{@link #getValueConverter() <em>Value Converter</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueConverter()
     * @generated
     * @ordered
     */
    protected ValueConverterDefinition valueConverter;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SplitTableImpl ()
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
        return ParserPackage.Literals.SPLIT_TABLE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPrefix ()
    {
        return prefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPrefix ( String newPrefix )
    {
        String oldPrefix = prefix;
        prefix = newPrefix;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SPLIT_TABLE__PREFIX, oldPrefix, prefix ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Pattern getLineSeparatorPattern ()
    {
        return lineSeparatorPattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setLineSeparatorPattern ( Pattern newLineSeparatorPattern )
    {
        Pattern oldLineSeparatorPattern = lineSeparatorPattern;
        lineSeparatorPattern = newLineSeparatorPattern;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SPLIT_TABLE__LINE_SEPARATOR_PATTERN, oldLineSeparatorPattern, lineSeparatorPattern ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Pattern getFieldSeparatorPattern ()
    {
        return fieldSeparatorPattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setFieldSeparatorPattern ( Pattern newFieldSeparatorPattern )
    {
        Pattern oldFieldSeparatorPattern = fieldSeparatorPattern;
        fieldSeparatorPattern = newFieldSeparatorPattern;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SPLIT_TABLE__FIELD_SEPARATOR_PATTERN, oldFieldSeparatorPattern, fieldSeparatorPattern ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getIdColumn ()
    {
        return idColumn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setIdColumn ( int newIdColumn )
    {
        int oldIdColumn = idColumn;
        idColumn = newIdColumn;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SPLIT_TABLE__ID_COLUMN, oldIdColumn, idColumn ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<String> getFields ()
    {
        if ( fields == null )
        {
            fields = new EDataTypeUniqueEList<String> ( String.class, this, ParserPackage.SPLIT_TABLE__FIELDS );
        }
        return fields;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ValueConverterDefinition getValueConverter ()
    {
        if ( valueConverter != null && valueConverter.eIsProxy () )
        {
            InternalEObject oldValueConverter = (InternalEObject)valueConverter;
            valueConverter = (ValueConverterDefinition)eResolveProxy ( oldValueConverter );
            if ( valueConverter != oldValueConverter )
            {
                InternalEObject newValueConverter = (InternalEObject)valueConverter;
                NotificationChain msgs = oldValueConverter.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.SPLIT_TABLE__VALUE_CONVERTER, null, null );
                if ( newValueConverter.eInternalContainer () == null )
                {
                    msgs = newValueConverter.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.SPLIT_TABLE__VALUE_CONVERTER, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ParserPackage.SPLIT_TABLE__VALUE_CONVERTER, oldValueConverter, valueConverter ) );
            }
        }
        return valueConverter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueConverterDefinition basicGetValueConverter ()
    {
        return valueConverter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetValueConverter ( ValueConverterDefinition newValueConverter, NotificationChain msgs )
    {
        ValueConverterDefinition oldValueConverter = valueConverter;
        valueConverter = newValueConverter;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ParserPackage.SPLIT_TABLE__VALUE_CONVERTER, oldValueConverter, newValueConverter );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setValueConverter ( ValueConverterDefinition newValueConverter )
    {
        if ( newValueConverter != valueConverter )
        {
            NotificationChain msgs = null;
            if ( valueConverter != null )
                msgs = ( (InternalEObject)valueConverter ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.SPLIT_TABLE__VALUE_CONVERTER, null, msgs );
            if ( newValueConverter != null )
                msgs = ( (InternalEObject)newValueConverter ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.SPLIT_TABLE__VALUE_CONVERTER, null, msgs );
            msgs = basicSetValueConverter ( newValueConverter, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SPLIT_TABLE__VALUE_CONVERTER, newValueConverter, newValueConverter ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Extractor createExtractor ( final CreationContext creationContext )
    {
        final EList<String> fields = getFields ();

        if ( fields == null || fields.isEmpty () )
        {
            return new SplitTableExtractor ( getLineSeparatorPattern ().pattern (), getFieldSeparatorPattern ().pattern (), getIdColumn () );
        }
        else
        {
            final String[] headers = getFields ().toArray ( new String[fields.size ()] );
            return new SplitTableExtractor ( getLineSeparatorPattern ().pattern (), getFieldSeparatorPattern ().pattern (), getIdColumn (), headers, Descriptors.createConverter ( this.valueConverter ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ParserPackage.SPLIT_TABLE__VALUE_CONVERTER:
                return basicSetValueConverter ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
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
            case ParserPackage.SPLIT_TABLE__PREFIX:
                return getPrefix ();
            case ParserPackage.SPLIT_TABLE__LINE_SEPARATOR_PATTERN:
                return getLineSeparatorPattern ();
            case ParserPackage.SPLIT_TABLE__FIELD_SEPARATOR_PATTERN:
                return getFieldSeparatorPattern ();
            case ParserPackage.SPLIT_TABLE__ID_COLUMN:
                return getIdColumn ();
            case ParserPackage.SPLIT_TABLE__FIELDS:
                return getFields ();
            case ParserPackage.SPLIT_TABLE__VALUE_CONVERTER:
                if ( resolve )
                    return getValueConverter ();
                return basicGetValueConverter ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ParserPackage.SPLIT_TABLE__PREFIX:
                setPrefix ( (String)newValue );
                return;
            case ParserPackage.SPLIT_TABLE__LINE_SEPARATOR_PATTERN:
                setLineSeparatorPattern ( (Pattern)newValue );
                return;
            case ParserPackage.SPLIT_TABLE__FIELD_SEPARATOR_PATTERN:
                setFieldSeparatorPattern ( (Pattern)newValue );
                return;
            case ParserPackage.SPLIT_TABLE__ID_COLUMN:
                setIdColumn ( (Integer)newValue );
                return;
            case ParserPackage.SPLIT_TABLE__FIELDS:
                getFields ().clear ();
                getFields ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ParserPackage.SPLIT_TABLE__VALUE_CONVERTER:
                setValueConverter ( (ValueConverterDefinition)newValue );
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
            case ParserPackage.SPLIT_TABLE__PREFIX:
                setPrefix ( PREFIX_EDEFAULT );
                return;
            case ParserPackage.SPLIT_TABLE__LINE_SEPARATOR_PATTERN:
                setLineSeparatorPattern ( LINE_SEPARATOR_PATTERN_EDEFAULT );
                return;
            case ParserPackage.SPLIT_TABLE__FIELD_SEPARATOR_PATTERN:
                setFieldSeparatorPattern ( FIELD_SEPARATOR_PATTERN_EDEFAULT );
                return;
            case ParserPackage.SPLIT_TABLE__ID_COLUMN:
                setIdColumn ( ID_COLUMN_EDEFAULT );
                return;
            case ParserPackage.SPLIT_TABLE__FIELDS:
                getFields ().clear ();
                return;
            case ParserPackage.SPLIT_TABLE__VALUE_CONVERTER:
                setValueConverter ( (ValueConverterDefinition)null );
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
            case ParserPackage.SPLIT_TABLE__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals ( prefix );
            case ParserPackage.SPLIT_TABLE__LINE_SEPARATOR_PATTERN:
                return LINE_SEPARATOR_PATTERN_EDEFAULT == null ? lineSeparatorPattern != null : !LINE_SEPARATOR_PATTERN_EDEFAULT.equals ( lineSeparatorPattern );
            case ParserPackage.SPLIT_TABLE__FIELD_SEPARATOR_PATTERN:
                return FIELD_SEPARATOR_PATTERN_EDEFAULT == null ? fieldSeparatorPattern != null : !FIELD_SEPARATOR_PATTERN_EDEFAULT.equals ( fieldSeparatorPattern );
            case ParserPackage.SPLIT_TABLE__ID_COLUMN:
                return idColumn != ID_COLUMN_EDEFAULT;
            case ParserPackage.SPLIT_TABLE__FIELDS:
                return fields != null && !fields.isEmpty ();
            case ParserPackage.SPLIT_TABLE__VALUE_CONVERTER:
                return valueConverter != null;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case ParserPackage.SPLIT_TABLE___CREATE_EXTRACTOR__CREATIONCONTEXT:
                return createExtractor ( (CreationContext)arguments.get ( 0 ) );
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (prefix: " ); //$NON-NLS-1$
        result.append ( prefix );
        result.append ( ", lineSeparatorPattern: " ); //$NON-NLS-1$
        result.append ( lineSeparatorPattern );
        result.append ( ", fieldSeparatorPattern: " ); //$NON-NLS-1$
        result.append ( fieldSeparatorPattern );
        result.append ( ", idColumn: " ); //$NON-NLS-1$
        result.append ( idColumn );
        result.append ( ", fields: " ); //$NON-NLS-1$
        result.append ( fields );
        result.append ( ')' );
        return result.toString ();
    }

} //SplitTableImpl
