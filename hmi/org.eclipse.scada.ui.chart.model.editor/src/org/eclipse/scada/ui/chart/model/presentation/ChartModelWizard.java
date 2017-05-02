/**
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution
 */
package org.eclipse.scada.ui.chart.model.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.provider.ChartEditPlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * This is a simple wizard for creating a new model file.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ChartModelWizard extends Wizard implements INewWizard
{
    /**
     * The supported extensions for created files.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<String> FILE_EXTENSIONS = Collections
            .unmodifiableList ( Arrays
                    .asList ( ChartEditorPlugin.INSTANCE
                            .getString ( "_UI_ChartEditorFilenameExtensions" ).split ( "\\s*,\\s*" ) ) ); //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * A formatted list of supported file extensions, suitable for display.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String FORMATTED_FILE_EXTENSIONS = ChartEditorPlugin.INSTANCE
            .getString ( "_UI_ChartEditorFilenameExtensions" ).replaceAll ( "\\s*,\\s*", ", " ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

    /**
     * This caches an instance of the model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ChartPackage chartPackage = ChartPackage.eINSTANCE;

    /**
     * This caches an instance of the model factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ChartFactory chartFactory = this.chartPackage.getChartFactory ();

    /**
     * This is the file creation page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ChartModelWizardNewFileCreationPage newFileCreationPage;

    /**
     * This is the initial object creation page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ChartModelWizardInitialObjectCreationPage initialObjectCreationPage;

    /**
     * Remember the selection during initialization for populating the default
     * container.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IStructuredSelection selection;

    /**
     * Remember the workbench during initialization.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected IWorkbench workbench;

    /**
     * Caches the names of the types that can be created as the root object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected List<String> initialObjectNames;

    /**
     * This just records the information.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        this.workbench = workbench;
        this.selection = selection;
        setWindowTitle ( ChartEditorPlugin.INSTANCE.getString ( "_UI_Wizard_label" ) ); //$NON-NLS-1$
        setDefaultPageImageDescriptor ( ExtendedImageRegistry.INSTANCE
                .getImageDescriptor ( ChartEditorPlugin.INSTANCE
                        .getImage ( "full/wizban/NewChart" ) ) ); //$NON-NLS-1$
    }

    /**
     * Returns the names of the types that can be created as the root object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected Collection<String> getInitialObjectNames ()
    {
        if ( this.initialObjectNames == null )
        {
            this.initialObjectNames = new ArrayList<String> ();
            this.initialObjectNames.add ( ChartPackage.Literals.CHART.getName () );
            Collections.sort ( this.initialObjectNames, CommonPlugin.INSTANCE.getComparator () );
        }
        return this.initialObjectNames;
    }

    /**
     * Create a new model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EObject createInitialModel ()
    {
        final EClass eClass = (EClass)this.chartPackage
                .getEClassifier ( this.initialObjectCreationPage
                        .getInitialObjectName () );
        final EObject rootObject = this.chartFactory.create ( eClass );
        return rootObject;
    }

    /**
     * Do the work after everything is specified.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean performFinish ()
    {
        try
        {
            // Remember the file.
            //
            final IFile modelFile = getModelFile ();

            // Do the work within an operation.
            //
            final WorkspaceModifyOperation operation = new WorkspaceModifyOperation () {
                @Override
                protected void execute ( final IProgressMonitor progressMonitor )
                {
                    try
                    {
                        // Create a resource set
                        //
                        final ResourceSet resourceSet = new ResourceSetImpl ();

                        // Get the URI of the model file.
                        //
                        final URI fileURI = URI.createPlatformResourceURI ( modelFile
                                .getFullPath ().toString (), true );

                        // Create a resource for this file.
                        //
                        final Resource resource = resourceSet.createResource ( fileURI );

                        // Add the initial model object to the contents.
                        //
                        final EObject rootObject = createInitialModel ();
                        if ( rootObject != null )
                        {
                            resource.getContents ().add ( rootObject );
                        }

                        // Save the contents of the resource to the file system.
                        //
                        final Map<Object, Object> options = new HashMap<Object, Object> ();
                        options.put ( XMLResource.OPTION_ENCODING,
                                ChartModelWizard.this.initialObjectCreationPage.getEncoding () );
                        resource.save ( options );
                    }
                    catch ( final Exception exception )
                    {
                        ChartEditorPlugin.INSTANCE.log ( exception );
                    }
                    finally
                    {
                        progressMonitor.done ();
                    }
                }
            };

            getContainer ().run ( false, false, operation );

            // Select the new file resource in the current view.
            //
            final IWorkbenchWindow workbenchWindow = this.workbench
                    .getActiveWorkbenchWindow ();
            final IWorkbenchPage page = workbenchWindow.getActivePage ();
            final IWorkbenchPart activePart = page.getActivePart ();
            if ( activePart instanceof ISetSelectionTarget )
            {
                final ISelection targetSelection = new StructuredSelection (
                        modelFile );
                getShell ().getDisplay ().asyncExec ( new Runnable () {
                    @Override
                    public void run ()
                    {
                        ( (ISetSelectionTarget)activePart )
                                .selectReveal ( targetSelection );
                    }
                } );
            }

            // Open an editor on the new file.
            //
            try
            {
                page.openEditor (
                        new FileEditorInput ( modelFile ),
                        this.workbench
                                .getEditorRegistry ()
                                .getDefaultEditor (
                                        modelFile.getFullPath ().toString () )
                                .getId () );
            }
            catch ( final PartInitException exception )
            {
                MessageDialog
                        .openError (
                                workbenchWindow.getShell (),
                                ChartEditorPlugin.INSTANCE
                                        .getString ( "_UI_OpenEditorError_label" ), exception.getMessage () ); //$NON-NLS-1$
                return false;
            }

            return true;
        }
        catch ( final Exception exception )
        {
            ChartEditorPlugin.INSTANCE.log ( exception );
            return false;
        }
    }

    /**
     * This is the one page of the wizard.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public class ChartModelWizardNewFileCreationPage extends
            WizardNewFileCreationPage
    {
        /**
         * Pass in the selection.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public ChartModelWizardNewFileCreationPage ( final String pageId,
                final IStructuredSelection selection )
        {
            super ( pageId, selection );
        }

        /**
         * The framework calls this to see if the file is correct.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        protected boolean validatePage ()
        {
            if ( super.validatePage () )
            {
                final String extension = new Path ( getFileName () ).getFileExtension ();
                if ( extension == null || !FILE_EXTENSIONS.contains ( extension ) )
                {
                    final String key = FILE_EXTENSIONS.size () > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension"; //$NON-NLS-1$ //$NON-NLS-2$
                    setErrorMessage ( ChartEditorPlugin.INSTANCE.getString ( key,
                            new Object[] { FORMATTED_FILE_EXTENSIONS } ) );
                    return false;
                }
                return true;
            }
            return false;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public IFile getModelFile ()
        {
            return ResourcesPlugin.getWorkspace ().getRoot ()
                    .getFile ( getContainerFullPath ().append ( getFileName () ) );
        }
    }

    /**
     * This is the page where the type of object to create is selected.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public class ChartModelWizardInitialObjectCreationPage extends WizardPage
    {
        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected Combo initialObjectField;

        /**
         * @generated
         *            <!-- begin-user-doc -->
         *            <!-- end-user-doc -->
         */
        protected List<String> encodings;

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected Combo encodingField;

        /**
         * Pass in the selection.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public ChartModelWizardInitialObjectCreationPage ( final String pageId )
        {
            super ( pageId );
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        public void createControl ( final Composite parent )
        {
            final Composite composite = new Composite ( parent, SWT.NONE );
            {
                final GridLayout layout = new GridLayout ();
                layout.numColumns = 1;
                layout.verticalSpacing = 12;
                composite.setLayout ( layout );

                final GridData data = new GridData ();
                data.verticalAlignment = GridData.FILL;
                data.grabExcessVerticalSpace = true;
                data.horizontalAlignment = GridData.FILL;
                composite.setLayoutData ( data );
            }

            final Label containerLabel = new Label ( composite, SWT.LEFT );
            {
                containerLabel.setText ( ChartEditorPlugin.INSTANCE
                        .getString ( "_UI_ModelObject" ) ); //$NON-NLS-1$

                final GridData data = new GridData ();
                data.horizontalAlignment = GridData.FILL;
                containerLabel.setLayoutData ( data );
            }

            this.initialObjectField = new Combo ( composite, SWT.BORDER );
            {
                final GridData data = new GridData ();
                data.horizontalAlignment = GridData.FILL;
                data.grabExcessHorizontalSpace = true;
                this.initialObjectField.setLayoutData ( data );
            }

            for ( final String objectName : getInitialObjectNames () )
            {
                this.initialObjectField.add ( getLabel ( objectName ) );
            }

            if ( this.initialObjectField.getItemCount () == 1 )
            {
                this.initialObjectField.select ( 0 );
            }
            this.initialObjectField.addModifyListener ( this.validator );

            final Label encodingLabel = new Label ( composite, SWT.LEFT );
            {
                encodingLabel.setText ( ChartEditorPlugin.INSTANCE
                        .getString ( "_UI_XMLEncoding" ) ); //$NON-NLS-1$

                final GridData data = new GridData ();
                data.horizontalAlignment = GridData.FILL;
                encodingLabel.setLayoutData ( data );
            }
            this.encodingField = new Combo ( composite, SWT.BORDER );
            {
                final GridData data = new GridData ();
                data.horizontalAlignment = GridData.FILL;
                data.grabExcessHorizontalSpace = true;
                this.encodingField.setLayoutData ( data );
            }

            for ( final String encoding : getEncodings () )
            {
                this.encodingField.add ( encoding );
            }

            this.encodingField.select ( 0 );
            this.encodingField.addModifyListener ( this.validator );

            setPageComplete ( validatePage () );
            setControl ( composite );
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected ModifyListener validator = new ModifyListener () {
            @Override
            public void modifyText ( final ModifyEvent e )
            {
                setPageComplete ( validatePage () );
            }
        };

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected boolean validatePage ()
        {
            return getInitialObjectName () != null
                    && getEncodings ().contains ( this.encodingField.getText () );
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        @Override
        public void setVisible ( final boolean visible )
        {
            super.setVisible ( visible );
            if ( visible )
            {
                if ( this.initialObjectField.getItemCount () == 1 )
                {
                    this.initialObjectField.clearSelection ();
                    this.encodingField.setFocus ();
                }
                else
                {
                    this.encodingField.clearSelection ();
                    this.initialObjectField.setFocus ();
                }
            }
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public String getInitialObjectName ()
        {
            final String label = this.initialObjectField.getText ();

            for ( final String name : getInitialObjectNames () )
            {
                if ( getLabel ( name ).equals ( label ) )
                {
                    return name;
                }
            }
            return null;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        public String getEncoding ()
        {
            return this.encodingField.getText ();
        }

        /**
         * Returns the label for the specified type name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected String getLabel ( final String typeName )
        {
            try
            {
                return ChartEditPlugin.INSTANCE
                        .getString ( "_UI_" + typeName + "_type" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
            catch ( final MissingResourceException mre )
            {
                ChartEditorPlugin.INSTANCE.log ( mre );
            }
            return typeName;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        protected Collection<String> getEncodings ()
        {
            if ( this.encodings == null )
            {
                this.encodings = new ArrayList<String> ();
                for ( final StringTokenizer stringTokenizer = new StringTokenizer (
                        ChartEditorPlugin.INSTANCE
                                .getString ( "_UI_XMLEncodingChoices" ) ); stringTokenizer.hasMoreTokens (); ) //$NON-NLS-1$
                {
                    this.encodings.add ( stringTokenizer.nextToken () );
                }
            }
            return this.encodings;
        }
    }

    /**
     * The framework calls this to create the contents of the wizard.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void addPages ()
    {
        // Create a page, set the title, and the initial model file name.
        //
        this.newFileCreationPage = new ChartModelWizardNewFileCreationPage ( "Whatever", this.selection ); //$NON-NLS-1$
        this.newFileCreationPage.setTitle ( ChartEditorPlugin.INSTANCE
                .getString ( "_UI_ChartModelWizard_label" ) ); //$NON-NLS-1$
        this.newFileCreationPage.setDescription ( ChartEditorPlugin.INSTANCE
                .getString ( "_UI_ChartModelWizard_description" ) ); //$NON-NLS-1$
        this.newFileCreationPage
                .setFileName ( ChartEditorPlugin.INSTANCE
                        .getString ( "_UI_ChartEditorFilenameDefaultBase" ) + "." + FILE_EXTENSIONS.get ( 0 ) ); //$NON-NLS-1$ //$NON-NLS-2$
        addPage ( this.newFileCreationPage );

        // Try and get the resource selection to determine a current directory for the file dialog.
        //
        if ( this.selection != null && !this.selection.isEmpty () )
        {
            // Get the resource...
            //
            final Object selectedElement = this.selection.iterator ().next ();
            if ( selectedElement instanceof IResource )
            {
                // Get the resource parent, if its a file.
                //
                IResource selectedResource = (IResource)selectedElement;
                if ( selectedResource.getType () == IResource.FILE )
                {
                    selectedResource = selectedResource.getParent ();
                }

                // This gives us a directory...
                //
                if ( selectedResource instanceof IFolder
                        || selectedResource instanceof IProject )
                {
                    // Set this for the container.
                    //
                    this.newFileCreationPage.setContainerFullPath ( selectedResource
                            .getFullPath () );

                    // Make up a unique new name here.
                    //
                    final String defaultModelBaseFilename = ChartEditorPlugin.INSTANCE
                            .getString ( "_UI_ChartEditorFilenameDefaultBase" ); //$NON-NLS-1$
                    final String defaultModelFilenameExtension = FILE_EXTENSIONS
                            .get ( 0 );
                    String modelFilename = defaultModelBaseFilename
                            + "." + defaultModelFilenameExtension; //$NON-NLS-1$
                    for ( int i = 1; ( (IContainer)selectedResource )
                            .findMember ( modelFilename ) != null; ++i )
                    {
                        modelFilename = defaultModelBaseFilename + i
                                + "." + defaultModelFilenameExtension; //$NON-NLS-1$
                    }
                    this.newFileCreationPage.setFileName ( modelFilename );
                }
            }
        }
        this.initialObjectCreationPage = new ChartModelWizardInitialObjectCreationPage ( "Whatever2" ); //$NON-NLS-1$
        this.initialObjectCreationPage.setTitle ( ChartEditorPlugin.INSTANCE
                .getString ( "_UI_ChartModelWizard_label" ) ); //$NON-NLS-1$
        this.initialObjectCreationPage.setDescription ( ChartEditorPlugin.INSTANCE
                .getString ( "_UI_Wizard_initial_object_description" ) ); //$NON-NLS-1$
        addPage ( this.initialObjectCreationPage );
    }

    /**
     * Get the file from the page.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public IFile getModelFile ()
    {
        return this.newFileCreationPage.getModelFile ();
    }

}
