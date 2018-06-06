/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.tests;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.emf.ecore.util.Diagnostician;

import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.scada.vi.model.Symbol;
import org.eclipse.scada.vi.model.VisualInterfaceFactory;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * A sample utility for the '<em><b>model</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class VisualInterfaceExample
{
    /**
     * <!-- begin-user-doc -->
     * Load all the argument file paths or URIs as instances of the model.
     * <!-- end-user-doc -->
     * @param args the file paths or URIs.
     * @generated
     */
    public static void main ( String[] args )
    {
        // Create a resource set to hold the resources.
        //
        ResourceSet resourceSet = new ResourceSetImpl ();

        // Register the appropriate resource factory to handle the content type.
        //
        resourceSet.getResourceFactoryRegistry ().getContentTypeToFactoryMap ().put ( VisualInterfacePackage.eCONTENT_TYPE, new XMIResourceFactoryImpl () );

        // Register the appropriate content handler for all file extensions and any element from the package's namespace.
        //
        resourceSet.getURIConverter ().getContentHandlers ().add ( new RootXMLContentHandlerImpl ( VisualInterfacePackage.eCONTENT_TYPE, null, null, VisualInterfacePackage.eNS_URI, null ) );

        // Register the package to ensure it is available during loading.
        //
        resourceSet.getPackageRegistry ().put ( VisualInterfacePackage.eNS_URI, VisualInterfacePackage.eINSTANCE );

        // If there are no arguments, emit an appropriate usage message.
        //
        if ( args.length == 0 )
        {
            System.out.println ( "Enter a list of file paths or URIs that have content like this:" ); //$NON-NLS-1$
            try
            {
                Resource resource = resourceSet.createResource ( URI.createURI ( "http:///My.vi" ), VisualInterfacePackage.eCONTENT_TYPE ); //$NON-NLS-1$
                Symbol root = VisualInterfaceFactory.eINSTANCE.createSymbol ();
                resource.getContents ().add ( root );
                resource.save ( System.out, null );
            }
            catch ( IOException exception )
            {
                exception.printStackTrace ();
            }
        }
        else
        {
            // Iterate over all the arguments.
            //
            for ( int i = 0; i < args.length; ++i )
            {
                // Construct the URI for the instance file.
                // The argument is treated as a file path only if it denotes an existing file.
                // Otherwise, it's directly treated as a URL.
                //
                File file = new File ( args[i] );
                URI uri = file.isFile () ? URI.createFileURI ( file.getAbsolutePath () ) : URI.createURI ( args[i] );

                try
                {
                    // Demand load resource for this file.
                    //
                    Resource resource = resourceSet.getResource ( uri, true );
                    System.out.println ( "Loaded " + uri ); //$NON-NLS-1$

                    // Validate the contents of the loaded resource.
                    //
                    for ( EObject eObject : resource.getContents () )
                    {
                        Diagnostic diagnostic = Diagnostician.INSTANCE.validate ( eObject );
                        if ( diagnostic.getSeverity () != Diagnostic.OK )
                        {
                            printDiagnostic ( diagnostic, "" ); //$NON-NLS-1$
                        }
                    }
                }
                catch ( RuntimeException exception )
                {
                    System.out.println ( "Problem loading " + uri ); //$NON-NLS-1$
                    exception.printStackTrace ();
                }
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * Prints diagnostics with indentation.
     * <!-- end-user-doc -->
     * @param diagnostic the diagnostic to print.
     * @param indent the indentation for printing.
     * @generated
     */
    protected static void printDiagnostic ( Diagnostic diagnostic, String indent )
    {
        System.out.print ( indent );
        System.out.println ( diagnostic.getMessage () );
        for ( Diagnostic child : diagnostic.getChildren () )
        {
            printDiagnostic ( child, indent + "  " ); //$NON-NLS-1$
        }
    }

} //VisualInterfaceExample
