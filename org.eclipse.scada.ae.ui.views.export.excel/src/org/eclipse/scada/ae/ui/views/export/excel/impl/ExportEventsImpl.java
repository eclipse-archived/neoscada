/*******************************************************************************
 * Copyright (c) 2013, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - use new Adapter helper
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.export.excel.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.hpsf.CustomProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HeaderFooter;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.ui.views.export.excel.Activator;
import org.eclipse.scada.ae.ui.views.export.excel.Cell;
import org.eclipse.scada.ae.ui.views.export.excel.FileTarget;
import org.eclipse.scada.ae.ui.views.export.excel.config.DynamicField;
import org.eclipse.scada.ae.ui.views.export.excel.config.Field;
import org.eclipse.scada.ae.ui.views.export.excel.config.StaticField;
import org.eclipse.scada.utils.core.runtime.AdapterHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExportEventsImpl implements FileTarget
{

    private final static Logger logger = LoggerFactory.getLogger ( ExportEventsImpl.class );

    private IStructuredSelection selection;

    private File file;

    public ExportEventsImpl ()
    {
    }

    public void setSelection ( final IStructuredSelection selection )
    {
        this.selection = selection;
    }

    @Override
    public void setFile ( final File file )
    {
        this.file = file;
    }

    public void check ()
    {
        if ( this.file == null )
        {
            throw new IllegalStateException ( Messages.ExportImpl_ErrorMessage_NoFileSelected );
        }
        if ( this.selection == null )
        {
            throw new IllegalStateException ( Messages.ExportImpl_ErrorMessage_NoEventsSelected );
        }
    }

    public IStatus write ( final IProgressMonitor monitor )
    {
        if ( this.selection == null )
        {
            return Status.OK_STATUS;
        }

        if ( this.file.exists () )
        {
            if ( !this.file.delete () )
            {
                return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( Messages.ExportImpl_ErrorMessage_FailedToDeleteFile, this.file ) );
            }
        }

        final List<Event> events = new ArrayList<Event> ();

        final Iterator<?> i = this.selection.iterator ();

        while ( i.hasNext () )
        {
            final Event e = AdapterHelper.adapt ( i.next (), Event.class );
            if ( e != null )
            {
                events.add ( e );
            }
        }

        try
        {
            return storeExcel ( this.file, events, getFields ( events ), monitor );
        }
        catch ( final Exception e )
        {
            logger.warn ( Messages.ExportImpl_ErrorMessage_FailedToExport, e );
            return new Status ( IStatus.ERROR, Activator.PLUGIN_ID, Messages.ExportImpl_ErrorMessage_FailedToExport, e );
        }
    }

    private List<Field> getFields ( final Collection<Event> events )
    {
        final Set<Field> fields = new HashSet<Field> ();

        fields.add ( new StaticField ( "id" ) { //$NON-NLS-1$
            @Override
            public void render ( final Event event, final Cell cell )
            {
                cell.setDataAsText ( event.getId ().toString () );
            }
        } );
        fields.add ( new StaticField ( "sourceTimestamp" ) { //$NON-NLS-1$

            @Override
            public void render ( final Event event, final Cell cell )
            {
                cell.setDataAsDate ( event.getSourceTimestamp () );
            }
        } );
        fields.add ( new StaticField ( "entryTimestamp" ) { //$NON-NLS-1$
            @Override
            public void render ( final Event event, final Cell cell )
            {
                cell.setDataAsDate ( event.getEntryTimestamp () );
            }
        } );

        for ( final Event event : events )
        {
            for ( final String key : event.getAttributes ().keySet () )
            {
                fields.add ( new DynamicField ( key ) );
            }
        }

        return new ArrayList<Field> ( fields );
    }

    private IStatus storeExcel ( final File file, final List<Event> events, final List<Field> columns, final IProgressMonitor monitor ) throws IOException
    {
        final HSSFWorkbook workbook = new HSSFWorkbook ();

        final HSSFDataFormat dateFormat = workbook.createDataFormat ();
        final HSSFCellStyle dateCellStyle = workbook.createCellStyle ();
        dateCellStyle.setDataFormat ( dateFormat.getFormat ( "YYYY-MM-DD hh:mm:ss.000" ) );

        try
        {
            monitor.beginTask ( Messages.ExportImpl_Progress_ExportingEvents, events.size () + 3 + columns.size () );

            try
            {
                monitor.subTask ( Messages.ExportImpl_Progress_CreateWorkbook );
                monitor.worked ( 1 );

                final HSSFSheet sheet = createSheet ( events, workbook, columns );
                monitor.worked ( 1 );

                monitor.setTaskName ( Messages.ExportImpl_Progress_ExportEvents );

                for ( int i = 0; i < events.size (); i++ )
                {
                    final HSSFRow row = sheet.createRow ( i + 1 );

                    final Event e = events.get ( i );
                    for ( int j = 0; j < columns.size (); j++ )
                    {
                        final Field field = columns.get ( j );
                        final ExcelCell cell = new ExcelCell ( row, j, dateCellStyle );
                        field.render ( e, cell );
                    }
                    monitor.worked ( 1 );
                    if ( monitor.isCanceled () )
                    {
                        return Status.CANCEL_STATUS;
                    }
                }

                sheet.setRepeatingRows ( new CellRangeAddress ( 0, 1, -1, -1 ) );

                monitor.setTaskName ( "Auto sizing" );
                for ( int i = 0; i < columns.size (); i++ )
                {
                    monitor.subTask ( String.format ( "Auto sizing column: %s", columns.get ( i ).getHeader () ) );
                    sheet.autoSizeColumn ( i );
                    monitor.worked ( 1 );

                    if ( monitor.isCanceled () )
                    {
                        return Status.CANCEL_STATUS;
                    }
                }

            }
            finally
            {
                monitor.subTask ( Messages.ExportImpl_Progress_CloseFile );
                if ( workbook != null )
                {
                    makeDocInfo ( workbook );

                    final FileOutputStream stream = new FileOutputStream ( file );
                    workbook.write ( stream );
                    stream.close ();
                }
                monitor.worked ( 1 );
            }
        }
        finally
        {
            monitor.done ();
        }

        return Status.OK_STATUS;
    }

    private void makeDocInfo ( final HSSFWorkbook workbook )
    {
        workbook.createInformationProperties ();

        final DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation ();
        dsi.setCompany ( "Eclipse SCADA Project" );

        final CustomProperties cp = new CustomProperties ();
        cp.put ( "Eclipse SCADA Export Version", Activator.getDefault ().getBundle ().getVersion ().toString () );
        dsi.setCustomProperties ( cp );
    }

    private HSSFSheet createSheet ( final List<Event> events, final HSSFWorkbook workbook, final List<Field> columns )
    {
        final HSSFSheet sheet = workbook.createSheet ( Messages.ExportImpl_ExcelSheet_Name );

        final HSSFHeader header = sheet.getHeader ();
        header.setLeft ( Messages.ExportImpl_ExcelSheet_Header );
        header.setRight ( HeaderFooter.date () + " " + HeaderFooter.time () );//$NON-NLS-1$

        final HSSFFooter footer = sheet.getFooter ();
        footer.setLeft ( String.format ( Messages.ExportImpl_ExcelSheet_Footer_1, events.size () ) );

        footer.setRight ( Messages.ExportImpl_ExcelSheet_Footer_2 + HeaderFooter.page () + Messages.ExportImpl_ExcelSheet_Footer_3 + HeaderFooter.numPages () );

        makeHeader ( columns, sheet );

        final HSSFPrintSetup printSetup = sheet.getPrintSetup ();
        printSetup.setLandscape ( true );
        printSetup.setFitWidth ( (short)1 );
        printSetup.setFitHeight ( (short)0 );
        printSetup.setPaperSize ( PrintSetup.A4_PAPERSIZE );

        sheet.setAutoFilter ( new CellRangeAddress ( 0, 0, 0, columns.size () - 1 ) );
        sheet.createFreezePane ( 0, 1 );
        sheet.setFitToPage ( true );
        sheet.setAutobreaks ( true );

        printSetup.setFooterMargin ( 0.25 );

        sheet.setMargin ( Sheet.LeftMargin, 0.25 );
        sheet.setMargin ( Sheet.RightMargin, 0.25 );
        sheet.setMargin ( Sheet.TopMargin, 0.25 );
        sheet.setMargin ( Sheet.BottomMargin, 0.5 );

        return sheet;
    }

    private void makeHeader ( final List<Field> columns, final HSSFSheet sheet )
    {
        final Font font = sheet.getWorkbook ().createFont ();
        font.setFontName ( "Arial" );
        font.setBoldweight ( Font.BOLDWEIGHT_BOLD );
        font.setColor ( HSSFColor.WHITE.index );

        final CellStyle style = sheet.getWorkbook ().createCellStyle ();
        style.setFont ( font );
        style.setFillForegroundColor ( HSSFColor.BLACK.index );
        style.setFillPattern ( PatternFormatting.SOLID_FOREGROUND );

        final HSSFRow row = sheet.createRow ( 0 );

        for ( int i = 0; i < columns.size (); i++ )
        {
            final Field field = columns.get ( i );

            final HSSFCell cell = row.createCell ( i );
            cell.setCellValue ( field.getHeader () );
            cell.setCellStyle ( style );
        }
    }

    public File getFile ()
    {
        return this.file;
    }
}
