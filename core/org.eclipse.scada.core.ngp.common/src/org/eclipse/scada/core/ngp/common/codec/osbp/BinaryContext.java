/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ngp.common.codec.osbp;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.mina.core.buffer.IoBuffer;
import org.eclipse.scada.core.Variant;

public interface BinaryContext
{
    // info

    public String getProtocolIdPart ();

    // string

    public void encodeString ( IoBuffer buffer, byte fieldNumber, String data ) throws Exception;

    public String decodeString ( IoBuffer buffer ) throws Exception;

    public void encodeStringCollection ( IoBuffer buffer, byte fieldNumber, Collection<String> data ) throws Exception;

    public List<String> decodeStringList ( IoBuffer buffer ) throws Exception;

    public Set<String> decodeStringSet ( IoBuffer buffer ) throws Exception;

    // int

    public void encodeInt ( IoBuffer buffer, byte fieldNumber, Integer data ) throws Exception;

    public Integer decodeInt ( IoBuffer buffer ) throws Exception;

    public void encodePrimitiveInt ( IoBuffer buffer, byte fieldNumber, int data ) throws Exception;

    public int decodePrimitiveInt ( IoBuffer buffer ) throws Exception;

    public void encodeIntCollection ( IoBuffer buffer, byte fieldNumber, Collection<Integer> data ) throws Exception;

    public List<Integer> decodeIntList ( IoBuffer buffer ) throws Exception;

    public Set<Integer> decodeIntSet ( IoBuffer buffer ) throws Exception;

    // long

    public void encodeLong ( IoBuffer buffer, byte fieldNumber, Long data ) throws Exception;

    public Long decodeLong ( IoBuffer buffer ) throws Exception;

    public void encodePrimitiveLong ( IoBuffer buffer, byte fieldNumber, long data ) throws Exception;

    public long decodePrimitiveLong ( IoBuffer buffer ) throws Exception;

    public void encodeLongCollection ( IoBuffer buffer, byte fieldNumber, Collection<Long> data ) throws Exception;

    public List<Long> decodeLongList ( IoBuffer buffer ) throws Exception;

    public Set<Long> decodeLongSet ( IoBuffer buffer ) throws Exception;

    // boolean

    public void encodeBoolean ( IoBuffer buffer, byte fieldNumber, Boolean data ) throws Exception;

    public Boolean decodeBoolean ( IoBuffer buffer ) throws Exception;

    public void encodePrimitiveBoolean ( IoBuffer buffer, byte fieldNumber, boolean data ) throws Exception;

    public boolean decodePrimitiveBoolean ( IoBuffer buffer ) throws Exception;

    public void encodeBooleanCollection ( IoBuffer buffer, byte fieldNumber, Collection<Boolean> data ) throws Exception;

    public List<Boolean> decodeBooleanList ( IoBuffer buffer ) throws Exception;

    public Set<Boolean> decodeBooleanSet ( IoBuffer buffer ) throws Exception;

    // double

    public void encodeDouble ( IoBuffer buffer, byte fieldNumber, Double data ) throws Exception;

    public Double decodeDouble ( IoBuffer buffer ) throws Exception;

    public void encodePrimitiveDouble ( IoBuffer buffer, byte fieldNumber, double data ) throws Exception;

    public double decodePrimitiveDouble ( IoBuffer buffer ) throws Exception;

    public void encodeDoubleCollection ( IoBuffer buffer, byte fieldNumber, Collection<Double> data ) throws Exception;

    public List<Double> decodeDoubleList ( IoBuffer buffer ) throws Exception;

    public Set<Double> decodeDoubleSet ( IoBuffer buffer ) throws Exception;

    // variant

    public void encodeVariant ( IoBuffer buffer, byte fieldNumber, Variant data ) throws Exception;

    public Variant decodeVariant ( IoBuffer buffer ) throws Exception;

    public void encodeVariantCollection ( IoBuffer buffer, byte fieldNumber, Collection<Variant> data ) throws Exception;

    public List<Variant> decodeVariantList ( IoBuffer buffer ) throws Exception;

    public Set<Variant> decodeVariantSet ( IoBuffer buffer ) throws Exception;

    // variant map

    public void encodeVariantMap ( IoBuffer buffer, byte fieldNumber, Map<String, Variant> data ) throws Exception;

    public Map<String, Variant> decodeVariantMap ( IoBuffer buffer ) throws Exception;

    public void encodeVariantMapCollection ( IoBuffer buffer, byte fieldNumber, Collection<Map<String, Variant>> data ) throws Exception;

    public List<Map<String, Variant>> decodeVariantMapList ( IoBuffer buffer ) throws Exception;

    public Set<Map<String, Variant>> decodeVariantMapSet ( IoBuffer buffer ) throws Exception;

    // properties

    public void encodeProperties ( IoBuffer buffer, byte fieldNumber, Map<String, String> data ) throws Exception;

    public Map<String, String> decodeProperties ( IoBuffer buffer ) throws Exception;

    public void encodePropertiesCollection ( IoBuffer buffer, byte fieldNumber, Collection<Map<String, String>> data ) throws Exception;

    public List<Map<String, String>> decodePropertiesList ( IoBuffer buffer ) throws Exception;

    public Set<Map<String, String>> decodePropertiesSet ( IoBuffer buffer ) throws Exception;

    // enum

    public <E extends Enum<E>> void encodeEnum ( IoBuffer buffer, byte fieldNumber, E data ) throws Exception;

    public <E extends Enum<E>> E decodeEnum ( final IoBuffer buffer, Class<E> enumClazz ) throws Exception;

    public <E extends Enum<E>> void encodeEnumSet ( IoBuffer buffer, byte fieldNumber, Set<E> data ) throws Exception;

    public <E extends Enum<E>> void encodeEnumList ( IoBuffer buffer, byte fieldNumber, List<E> data ) throws Exception;

    public <E extends Enum<E>> List<E> decodeEnumList ( IoBuffer buffer, Class<E> enumClazz ) throws Exception;

    public <E extends Enum<E>> Set<E> decodeEnumSet ( IoBuffer buffer, Class<E> enumClazz ) throws Exception;

    // structure

    public void beginWriteStructure ( IoBuffer buffer, byte fieldNumber, boolean isNull ) throws Exception;

    public boolean beginReadStructure ( IoBuffer buffer, boolean allowNull ) throws Exception;

    public void beginWriteStructureList ( IoBuffer buffer, byte fieldNumber, Collection<?> values ) throws Exception;

    public Integer beginReadStructureList ( IoBuffer buffer, boolean allowNull ) throws Exception;
}
