/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.pkg.deb.test;

import java.io.StringWriter;
import java.util.regex.Pattern;

import org.eclipse.scada.utils.pkg.deb.InvalidValueException;
import org.eclipse.scada.utils.pkg.deb.control.ControlField;
import org.eclipse.scada.utils.pkg.deb.control.ControlFieldDefinition;
import org.eclipse.scada.utils.pkg.deb.control.ControlFileWriter;
import org.eclipse.scada.utils.pkg.deb.control.FieldType;
import org.junit.Assert;
import org.junit.Test;

public class ControlFileWriterTest
{
    private static ControlFieldDefinition defPackage = new ControlFieldDefinition ( "Package", FieldType.SIMPLE, Pattern.compile ( "[a-z][a-z0-9\\+\\-\\.]{1,}" ) );

    private static ControlFieldDefinition defDescription = new ControlFieldDefinition ( "Description", FieldType.MULTILINE );

    private static ControlFieldDefinition defFolded = new ControlFieldDefinition ( "Folded", FieldType.FOLDED );

    @Test
    public void test1 () throws Exception
    {
        testField ( defPackage, "libc", "Package: libc\n" );
        testField ( defDescription, "Hello World", "Description: \n Hello World\n" );
        testField ( defDescription.createField ( "Hello World", "Foo Bar" ), "Description: Foo Bar\n Hello World\n" );
        testField ( defDescription.createField ( "Hello World\nline2", "Foo Bar" ), "Description: Foo Bar\n Hello World\n line2\n" );
        testField ( defDescription.createField ( "Hello World\n\nline2", "Foo Bar" ), "Description: Foo Bar\n Hello World\n .\n line2\n" );
    }

    @Test
    public void testFolded1 () throws Exception
    {
        testField ( defFolded, "0123456789", "Folded: 0123456789\n" );
        testField ( defFolded, "01234567890123456789012345678901234567890123456789012345678901234567890123456789", "Folded: 0123456789012345678901234567890123456789012345678901234567890123456789012345678\n 9\n" );
        testField ( defFolded, "0123456789012345678901234567890123456789012345678901234567890123456789012345678", "Folded: 0123456789012345678901234567890123456789012345678901234567890123456789012345678\n" );
    }

    @Test ( expected = InvalidValueException.class )
    public void testInvalidPackage1 ()
    {
        ControlFileWriterTest.defPackage.createField ( "" );
    }

    @Test ( expected = InvalidValueException.class )
    public void testInvalidPackage2 ()
    {
        ControlFileWriterTest.defPackage.createField ( "a" );
    }

    @Test ( expected = InvalidValueException.class )
    public void testInvalidPackage3 ()
    {
        ControlFileWriterTest.defPackage.createField ( "0000" );
    }

    @Test ( expected = InvalidValueException.class )
    public void testInvalidPackage4 ()
    {
        ControlFileWriterTest.defPackage.createField ( null );
    }

    @Test ( expected = InvalidValueException.class )
    public void fieldInvalid1 () throws Exception
    {
        new ControlFieldDefinition ( "Package:", FieldType.SIMPLE );
    }

    private void testField ( final ControlField field, final String expectedResult ) throws Exception
    {
        final StringWriter sw = new StringWriter ();
        try ( ControlFileWriter writer = new ControlFileWriter ( sw ) )
        {
            writer.writeField ( field );
        }
        final String result = sw.toString ();
        Assert.assertEquals ( "Field encoding", expectedResult, result );
    }

    private void testField ( final ControlFieldDefinition def, final String value, final String expectedResult ) throws Exception
    {
        testField ( def.createField ( value ), expectedResult );
    }
}
