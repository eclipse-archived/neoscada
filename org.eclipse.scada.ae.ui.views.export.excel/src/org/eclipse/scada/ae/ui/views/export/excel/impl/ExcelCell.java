/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.export.excel.impl;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.eclipse.scada.ae.ui.views.export.excel.Cell;
import org.eclipse.scada.core.Variant;

public class ExcelCell implements Cell
{
    private final HSSFCell cell;

    private final HSSFCellStyle dateFormat;

    public ExcelCell ( final HSSFRow row, final int column, final HSSFCellStyle dateFormat )
    {
        this.cell = row.createCell ( column );

        this.dateFormat = dateFormat;
    }

    public HSSFCell getCell ()
    {
        return this.cell;
    }

    @Override
    public void setDataAsDate ( final Date date )
    {
        this.cell.setCellValue ( date );
        this.cell.setCellStyle ( this.dateFormat );
    }

    @Override
    public void setDataAsText ( final String text )
    {
        this.cell.setCellValue ( text );
    }

    @Override
    public void setDataAsVariant ( final Variant variant )
    {
        if ( variant == null )
        {
            return;
        }

        switch ( variant.getType () )
        {
            case INT32:
            case INT64:
            case DOUBLE:
                this.cell.setCellValue ( variant.asDouble ( 0.0 ) );
                break;
            case BOOLEAN:
                this.cell.setCellValue ( variant.asBoolean () );
                break;
            case NULL:
                break;
            case UNKNOWN:
            case STRING:
                this.cell.setCellValue ( variant.asString ( "" ) );//$NON-NLS-1$
                break;
        }
    }

}