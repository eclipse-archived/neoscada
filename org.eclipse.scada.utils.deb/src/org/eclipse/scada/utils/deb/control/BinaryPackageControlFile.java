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
package org.eclipse.scada.utils.deb.control;

/**
 * A control file for binary packages
 */
public class BinaryPackageControlFile extends GenericControlFile
{
    public interface Fields
    {
        public static ControlFieldDefinition PACKAGE = new ControlFieldDefinition ( "Package", FieldType.SIMPLE );

        public static ControlFieldDefinition VERSION = new ControlFieldDefinition ( "Version", FieldType.SIMPLE );

        public static ControlFieldDefinition ARCHITECTURE = new ControlFieldDefinition ( "Architecture", FieldType.SIMPLE );

        public static ControlFieldDefinition SECTION = new ControlFieldDefinition ( "Section", FieldType.SIMPLE );

        public static ControlFieldDefinition PRIORITY = new ControlFieldDefinition ( "Priority", FieldType.SIMPLE );

        public static ControlFieldDefinition ESSENTIAL = new ControlFieldDefinition ( "Essential", FieldType.SIMPLE );

        public static ControlFieldDefinition DESCRIPTION = new ControlFieldDefinition ( "Description", FieldType.MULTILINE );

        public static ControlFieldDefinition MAINTAINER = new ControlFieldDefinition ( "Maintainer", FieldType.SIMPLE );

        public static ControlFieldDefinition INSTALLED_SIZE = new ControlFieldDefinition ( "Installed-Size", FieldType.SIMPLE );
    }

    public void setPackage ( final String value )
    {
        set ( Fields.PACKAGE.createField ( value ) );
    }

    public String getPackage ()
    {
        return getValue ( Fields.PACKAGE );
    }

    public void setVersion ( final String value )
    {
        set ( Fields.VERSION.createField ( value ) );
    }

    public String getVersion ()
    {
        return getValue ( Fields.VERSION );
    }

    public String getArchitecture ()
    {
        return getValue ( Fields.ARCHITECTURE );
    }

    public void setArchitecture ( final String value )
    {
        set ( Fields.ARCHITECTURE.createField ( value ) );
    }

    public String getMaintainer ()
    {
        return getValue ( Fields.MAINTAINER );
    }

    public void setMaintainer ( final String value )
    {
        set ( Fields.MAINTAINER.createField ( value ) );
    }

    public void setDescription ( final String abstractLine, final String details )
    {
        set ( Fields.DESCRIPTION.createField ( details, abstractLine ) );
    }

    public void validate ()
    {
        validate ( this );
    }

    public static void validate ( final GenericControlFile controlFile )
    {
        hasField ( controlFile, Fields.PACKAGE );
        hasField ( controlFile, Fields.ARCHITECTURE );
        hasField ( controlFile, Fields.VERSION );
        hasField ( controlFile, Fields.MAINTAINER );
        hasField ( controlFile, Fields.DESCRIPTION );
    }

    private static void hasField ( final GenericControlFile controlFile, final ControlFieldDefinition definition )
    {
        final ControlField result = controlFile.get ( definition );
        if ( result == null )
        {
            throw new IllegalStateException ( String.format ( "Control file must have field '%s'", definition.getName () ) );
        }
    }

}
