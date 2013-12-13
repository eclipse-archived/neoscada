/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart;
import org.eclipse.scada.configuration.component.providers.ComponentMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class PersistentValuePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PersistentValuePropertiesEditionPart {

	protected EObjectFlatComboViewer level;
	protected EObjectFlatComboViewer customizationPipeline;
	protected EObjectFlatComboViewer archiveSelector;
	protected ReferencesTable masterOn;
	protected List<ViewerFilter> masterOnBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> masterOnFilters = new ArrayList<ViewerFilter>();
	protected Text name;
	protected EMFComboViewer dataType;
	protected Text customizationTags;
	protected Button editCustomizationTags;
	private EList customizationTagsList;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PersistentValuePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence persistentValueStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = persistentValueStep.addStep(ComponentViewsRepository.PersistentValue.Properties.class);
		propertiesStep.addStep(ComponentViewsRepository.PersistentValue.Properties.level);
		propertiesStep.addStep(ComponentViewsRepository.PersistentValue.Properties.customizationPipeline);
		propertiesStep.addStep(ComponentViewsRepository.PersistentValue.Properties.archiveSelector);
		propertiesStep.addStep(ComponentViewsRepository.PersistentValue.Properties.masterOn);
		propertiesStep.addStep(ComponentViewsRepository.PersistentValue.Properties.name);
		propertiesStep.addStep(ComponentViewsRepository.PersistentValue.Properties.dataType);
		propertiesStep.addStep(ComponentViewsRepository.PersistentValue.Properties.customizationTags);
		
		
		composer = new PartComposer(persistentValueStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.PersistentValue.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ComponentViewsRepository.PersistentValue.Properties.level) {
					return createLevelFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.PersistentValue.Properties.customizationPipeline) {
					return createCustomizationPipelineFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.PersistentValue.Properties.archiveSelector) {
					return createArchiveSelectorFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.PersistentValue.Properties.masterOn) {
					return createMasterOnAdvancedReferencesTable(parent);
				}
				if (key == ComponentViewsRepository.PersistentValue.Properties.name) {
					return createNameText(parent);
				}
				if (key == ComponentViewsRepository.PersistentValue.Properties.dataType) {
					return createDataTypeEMFComboViewer(parent);
				}
				if (key == ComponentViewsRepository.PersistentValue.Properties.customizationTags) {
					return createCustomizationTagsMultiValuedEditor(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(ComponentMessages.PersistentValuePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createLevelFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.PersistentValue.Properties.level, ComponentMessages.PersistentValuePropertiesEditionPart_LevelLabel);
		level = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.PersistentValue.Properties.level, ComponentViewsRepository.SWT_KIND));
		level.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		level.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.level, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getLevel()));
			}

		});
		GridData levelData = new GridData(GridData.FILL_HORIZONTAL);
		level.setLayoutData(levelData);
		level.setID(ComponentViewsRepository.PersistentValue.Properties.level);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.PersistentValue.Properties.level, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLevelFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createCustomizationPipelineFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.PersistentValue.Properties.customizationPipeline, ComponentMessages.PersistentValuePropertiesEditionPart_CustomizationPipelineLabel);
		customizationPipeline = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.PersistentValue.Properties.customizationPipeline, ComponentViewsRepository.SWT_KIND));
		customizationPipeline.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		customizationPipeline.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.customizationPipeline, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getCustomizationPipeline()));
			}

		});
		GridData customizationPipelineData = new GridData(GridData.FILL_HORIZONTAL);
		customizationPipeline.setLayoutData(customizationPipelineData);
		customizationPipeline.setID(ComponentViewsRepository.PersistentValue.Properties.customizationPipeline);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.PersistentValue.Properties.customizationPipeline, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCustomizationPipelineFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createArchiveSelectorFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.PersistentValue.Properties.archiveSelector, ComponentMessages.PersistentValuePropertiesEditionPart_ArchiveSelectorLabel);
		archiveSelector = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.PersistentValue.Properties.archiveSelector, ComponentViewsRepository.SWT_KIND));
		archiveSelector.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		archiveSelector.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.archiveSelector, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getArchiveSelector()));
			}

		});
		GridData archiveSelectorData = new GridData(GridData.FILL_HORIZONTAL);
		archiveSelector.setLayoutData(archiveSelectorData);
		archiveSelector.setID(ComponentViewsRepository.PersistentValue.Properties.archiveSelector);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.PersistentValue.Properties.archiveSelector, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createArchiveSelectorFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createMasterOnAdvancedReferencesTable(Composite parent) {
		String label = getDescription(ComponentViewsRepository.PersistentValue.Properties.masterOn, ComponentMessages.PersistentValuePropertiesEditionPart_MasterOnLabel);		 
		this.masterOn = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addMasterOn(); }
			public void handleEdit(EObject element) { editMasterOn(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveMasterOn(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromMasterOn(element); }
			public void navigateTo(EObject element) { }
		});
		this.masterOn.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.PersistentValue.Properties.masterOn, ComponentViewsRepository.SWT_KIND));
		this.masterOn.createControls(parent);
		this.masterOn.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.masterOn, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData masterOnData = new GridData(GridData.FILL_HORIZONTAL);
		masterOnData.horizontalSpan = 3;
		this.masterOn.setLayoutData(masterOnData);
		this.masterOn.disableMove();
		masterOn.setID(ComponentViewsRepository.PersistentValue.Properties.masterOn);
		masterOn.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addMasterOn() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(masterOn.getInput(), masterOnFilters, masterOnBusinessFilters,
		"masterOn", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.masterOn,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				masterOn.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveMasterOn(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.masterOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		masterOn.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromMasterOn(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.masterOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		masterOn.refresh();
	}

	/**
	 * 
	 */
	protected void editMasterOn(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				masterOn.refresh();
			}
		}
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, ComponentViewsRepository.PersistentValue.Properties.name, ComponentMessages.PersistentValuePropertiesEditionPart_NameLabel);
		name = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, ComponentViewsRepository.PersistentValue.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.PersistentValue.Properties.name, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	
	protected Composite createDataTypeEMFComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.PersistentValue.Properties.dataType, ComponentMessages.PersistentValuePropertiesEditionPart_DataTypeLabel);
		dataType = new EMFComboViewer(parent);
		dataType.setContentProvider(new ArrayContentProvider());
		dataType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData dataTypeData = new GridData(GridData.FILL_HORIZONTAL);
		dataType.getCombo().setLayoutData(dataTypeData);
		dataType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.dataType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDataType()));
			}

		});
		dataType.setID(ComponentViewsRepository.PersistentValue.Properties.dataType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.PersistentValue.Properties.dataType, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDataTypeEMFComboViewer

		// End of user code
		return parent;
	}

	protected Composite createCustomizationTagsMultiValuedEditor(Composite parent) {
		customizationTags = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData customizationTagsData = new GridData(GridData.FILL_HORIZONTAL);
		customizationTagsData.horizontalSpan = 2;
		customizationTags.setLayoutData(customizationTagsData);
		EditingUtils.setID(customizationTags, ComponentViewsRepository.PersistentValue.Properties.customizationTags);
		EditingUtils.setEEFtype(customizationTags, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCustomizationTags = new Button(parent, SWT.NONE);
		editCustomizationTags.setText(getDescription(ComponentViewsRepository.PersistentValue.Properties.customizationTags, ComponentMessages.PersistentValuePropertiesEditionPart_CustomizationTagsLabel));
		GridData editCustomizationTagsData = new GridData();
		editCustomizationTags.setLayoutData(editCustomizationTagsData);
		editCustomizationTags.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						customizationTags.getShell(), "PersistentValue", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						customizationTagsList, ComponentPackage.eINSTANCE.getSingleValue_CustomizationTags().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					customizationTagsList = dialog.getResult();
					if (customizationTagsList == null) {
						customizationTagsList = new BasicEList();
					}
					customizationTags.setText(customizationTagsList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PersistentValuePropertiesEditionPartImpl.this, ComponentViewsRepository.PersistentValue.Properties.customizationTags, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(customizationTagsList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCustomizationTags, ComponentViewsRepository.PersistentValue.Properties.customizationTags);
		EditingUtils.setEEFtype(editCustomizationTags, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCustomizationTagsMultiValuedEditor

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#getLevel()
	 * 
	 */
	public EObject getLevel() {
		if (level.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) level.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#initLevel(EObjectFlatComboSettings)
	 */
	public void initLevel(EObjectFlatComboSettings settings) {
		level.setInput(settings);
		if (current != null) {
			level.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.level);
		if (eefElementEditorReadOnlyState && level.isEnabled()) {
			level.setEnabled(false);
			level.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !level.isEnabled()) {
			level.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#setLevel(EObject newValue)
	 * 
	 */
	public void setLevel(EObject newValue) {
		if (newValue != null) {
			level.setSelection(new StructuredSelection(newValue));
		} else {
			level.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.level);
		if (eefElementEditorReadOnlyState && level.isEnabled()) {
			level.setEnabled(false);
			level.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !level.isEnabled()) {
			level.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#setLevelButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLevelButtonMode(ButtonsModeEnum newValue) {
		level.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#addFilterLevel(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLevel(ViewerFilter filter) {
		level.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#addBusinessFilterLevel(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLevel(ViewerFilter filter) {
		level.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#getCustomizationPipeline()
	 * 
	 */
	public EObject getCustomizationPipeline() {
		if (customizationPipeline.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) customizationPipeline.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#initCustomizationPipeline(EObjectFlatComboSettings)
	 */
	public void initCustomizationPipeline(EObjectFlatComboSettings settings) {
		customizationPipeline.setInput(settings);
		if (current != null) {
			customizationPipeline.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#setCustomizationPipeline(EObject newValue)
	 * 
	 */
	public void setCustomizationPipeline(EObject newValue) {
		if (newValue != null) {
			customizationPipeline.setSelection(new StructuredSelection(newValue));
		} else {
			customizationPipeline.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#setCustomizationPipelineButtonMode(ButtonsModeEnum newValue)
	 */
	public void setCustomizationPipelineButtonMode(ButtonsModeEnum newValue) {
		customizationPipeline.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#addFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#addBusinessFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#getArchiveSelector()
	 * 
	 */
	public EObject getArchiveSelector() {
		if (archiveSelector.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) archiveSelector.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#initArchiveSelector(EObjectFlatComboSettings)
	 */
	public void initArchiveSelector(EObjectFlatComboSettings settings) {
		archiveSelector.setInput(settings);
		if (current != null) {
			archiveSelector.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#setArchiveSelector(EObject newValue)
	 * 
	 */
	public void setArchiveSelector(EObject newValue) {
		if (newValue != null) {
			archiveSelector.setSelection(new StructuredSelection(newValue));
		} else {
			archiveSelector.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#setArchiveSelectorButtonMode(ButtonsModeEnum newValue)
	 */
	public void setArchiveSelectorButtonMode(ButtonsModeEnum newValue) {
		archiveSelector.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#addFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#addBusinessFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#initMasterOn(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initMasterOn(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		masterOn.setContentProvider(contentProvider);
		masterOn.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.masterOn);
		if (eefElementEditorReadOnlyState && masterOn.getTable().isEnabled()) {
			masterOn.setEnabled(false);
			masterOn.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !masterOn.getTable().isEnabled()) {
			masterOn.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#updateMasterOn()
	 * 
	 */
	public void updateMasterOn() {
	masterOn.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#addFilterMasterOn(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMasterOn(ViewerFilter filter) {
		masterOnFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#addBusinessFilterMasterOn(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMasterOn(ViewerFilter filter) {
		masterOnBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#isContainedInMasterOnTable(EObject element)
	 * 
	 */
	public boolean isContainedInMasterOnTable(EObject element) {
		return ((ReferencesTableSettings)masterOn.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#getDataType()
	 * 
	 */
	public Enumerator getDataType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) dataType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#initDataType(Object input, Enumerator current)
	 */
	public void initDataType(Object input, Enumerator current) {
		dataType.setInput(input);
		dataType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.dataType);
		if (eefElementEditorReadOnlyState && dataType.isEnabled()) {
			dataType.setEnabled(false);
			dataType.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dataType.isEnabled()) {
			dataType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#setDataType(Enumerator newValue)
	 * 
	 */
	public void setDataType(Enumerator newValue) {
		dataType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.dataType);
		if (eefElementEditorReadOnlyState && dataType.isEnabled()) {
			dataType.setEnabled(false);
			dataType.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dataType.isEnabled()) {
			dataType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#getCustomizationTags()
	 * 
	 */
	public EList getCustomizationTags() {
		return customizationTagsList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.PersistentValuePropertiesEditionPart#setCustomizationTags(EList newValue)
	 * 
	 */
	public void setCustomizationTags(EList newValue) {
		customizationTagsList = newValue;
		if (newValue != null) {
			customizationTags.setText(customizationTagsList.toString());
		} else {
			customizationTags.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.PersistentValue.Properties.customizationTags);
		if (eefElementEditorReadOnlyState && customizationTags.isEnabled()) {
			customizationTags.setEnabled(false);
			customizationTags.setToolTipText(ComponentMessages.PersistentValue_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationTags.isEnabled()) {
			customizationTags.setEnabled(true);
		}	
		
	}

	public void addToCustomizationTags(Object newValue) {
		customizationTagsList.add(newValue);
		if (newValue != null) {
			customizationTags.setText(customizationTagsList.toString());
		} else {
			customizationTags.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToCustomizationTags(Object newValue) {
		customizationTagsList.remove(newValue);
		if (newValue != null) {
			customizationTags.setText(customizationTagsList.toString());
		} else {
			customizationTags.setText(""); //$NON-NLS-1$
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.PersistentValue_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
