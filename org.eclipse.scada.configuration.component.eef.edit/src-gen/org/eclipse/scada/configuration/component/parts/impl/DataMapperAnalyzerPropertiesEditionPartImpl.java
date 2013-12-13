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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart;
import org.eclipse.scada.configuration.component.providers.ComponentMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class DataMapperAnalyzerPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DataMapperAnalyzerPropertiesEditionPart {

	protected EObjectFlatComboViewer level;
	protected EObjectFlatComboViewer customizationPipeline;
	protected EObjectFlatComboViewer archiveSelector;
	protected ReferencesTable masterOn;
	protected List<ViewerFilter> masterOnBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> masterOnFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer dataMapper;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DataMapperAnalyzerPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence dataMapperAnalyzerStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dataMapperAnalyzerStep.addStep(ComponentViewsRepository.DataMapperAnalyzer.Properties.class);
		propertiesStep.addStep(ComponentViewsRepository.DataMapperAnalyzer.Properties.level);
		propertiesStep.addStep(ComponentViewsRepository.DataMapperAnalyzer.Properties.customizationPipeline);
		propertiesStep.addStep(ComponentViewsRepository.DataMapperAnalyzer.Properties.archiveSelector);
		propertiesStep.addStep(ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn);
		propertiesStep.addStep(ComponentViewsRepository.DataMapperAnalyzer.Properties.dataMapper);
		
		
		composer = new PartComposer(dataMapperAnalyzerStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.DataMapperAnalyzer.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ComponentViewsRepository.DataMapperAnalyzer.Properties.level) {
					return createLevelFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.DataMapperAnalyzer.Properties.customizationPipeline) {
					return createCustomizationPipelineFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.DataMapperAnalyzer.Properties.archiveSelector) {
					return createArchiveSelectorFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn) {
					return createMasterOnAdvancedReferencesTable(parent);
				}
				if (key == ComponentViewsRepository.DataMapperAnalyzer.Properties.dataMapper) {
					return createDataMapperFlatComboViewer(parent);
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
		propertiesGroup.setText(ComponentMessages.DataMapperAnalyzerPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, ComponentViewsRepository.DataMapperAnalyzer.Properties.level, ComponentMessages.DataMapperAnalyzerPropertiesEditionPart_LevelLabel);
		level = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.DataMapperAnalyzer.Properties.level, ComponentViewsRepository.SWT_KIND));
		level.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		level.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperAnalyzerPropertiesEditionPartImpl.this, ComponentViewsRepository.DataMapperAnalyzer.Properties.level, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getLevel()));
			}

		});
		GridData levelData = new GridData(GridData.FILL_HORIZONTAL);
		level.setLayoutData(levelData);
		level.setID(ComponentViewsRepository.DataMapperAnalyzer.Properties.level);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.DataMapperAnalyzer.Properties.level, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createLevelFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createCustomizationPipelineFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.DataMapperAnalyzer.Properties.customizationPipeline, ComponentMessages.DataMapperAnalyzerPropertiesEditionPart_CustomizationPipelineLabel);
		customizationPipeline = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.DataMapperAnalyzer.Properties.customizationPipeline, ComponentViewsRepository.SWT_KIND));
		customizationPipeline.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		customizationPipeline.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperAnalyzerPropertiesEditionPartImpl.this, ComponentViewsRepository.DataMapperAnalyzer.Properties.customizationPipeline, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getCustomizationPipeline()));
			}

		});
		GridData customizationPipelineData = new GridData(GridData.FILL_HORIZONTAL);
		customizationPipeline.setLayoutData(customizationPipelineData);
		customizationPipeline.setID(ComponentViewsRepository.DataMapperAnalyzer.Properties.customizationPipeline);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.DataMapperAnalyzer.Properties.customizationPipeline, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCustomizationPipelineFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createArchiveSelectorFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.DataMapperAnalyzer.Properties.archiveSelector, ComponentMessages.DataMapperAnalyzerPropertiesEditionPart_ArchiveSelectorLabel);
		archiveSelector = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.DataMapperAnalyzer.Properties.archiveSelector, ComponentViewsRepository.SWT_KIND));
		archiveSelector.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		archiveSelector.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperAnalyzerPropertiesEditionPartImpl.this, ComponentViewsRepository.DataMapperAnalyzer.Properties.archiveSelector, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getArchiveSelector()));
			}

		});
		GridData archiveSelectorData = new GridData(GridData.FILL_HORIZONTAL);
		archiveSelector.setLayoutData(archiveSelectorData);
		archiveSelector.setID(ComponentViewsRepository.DataMapperAnalyzer.Properties.archiveSelector);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.DataMapperAnalyzer.Properties.archiveSelector, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createArchiveSelectorFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createMasterOnAdvancedReferencesTable(Composite parent) {
		String label = getDescription(ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn, ComponentMessages.DataMapperAnalyzerPropertiesEditionPart_MasterOnLabel);		 
		this.masterOn = new ReferencesTable(label, new ReferencesTableListener() {
			public void handleAdd() { addMasterOn(); }
			public void handleEdit(EObject element) { editMasterOn(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveMasterOn(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromMasterOn(element); }
			public void navigateTo(EObject element) { }
		});
		this.masterOn.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn, ComponentViewsRepository.SWT_KIND));
		this.masterOn.createControls(parent);
		this.masterOn.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperAnalyzerPropertiesEditionPartImpl.this, ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData masterOnData = new GridData(GridData.FILL_HORIZONTAL);
		masterOnData.horizontalSpan = 3;
		this.masterOn.setLayoutData(masterOnData);
		this.masterOn.disableMove();
		masterOn.setID(ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperAnalyzerPropertiesEditionPartImpl.this, ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperAnalyzerPropertiesEditionPartImpl.this, ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		masterOn.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromMasterOn(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperAnalyzerPropertiesEditionPartImpl.this, ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createDataMapperFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.DataMapperAnalyzer.Properties.dataMapper, ComponentMessages.DataMapperAnalyzerPropertiesEditionPart_DataMapperLabel);
		dataMapper = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.DataMapperAnalyzer.Properties.dataMapper, ComponentViewsRepository.SWT_KIND));
		dataMapper.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		dataMapper.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataMapperAnalyzerPropertiesEditionPartImpl.this, ComponentViewsRepository.DataMapperAnalyzer.Properties.dataMapper, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getDataMapper()));
			}

		});
		GridData dataMapperData = new GridData(GridData.FILL_HORIZONTAL);
		dataMapper.setLayoutData(dataMapperData);
		dataMapper.setID(ComponentViewsRepository.DataMapperAnalyzer.Properties.dataMapper);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.DataMapperAnalyzer.Properties.dataMapper, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDataMapperFlatComboViewer

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
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#getLevel()
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
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#initLevel(EObjectFlatComboSettings)
	 */
	public void initLevel(EObjectFlatComboSettings settings) {
		level.setInput(settings);
		if (current != null) {
			level.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.DataMapperAnalyzer.Properties.level);
		if (eefElementEditorReadOnlyState && level.isEnabled()) {
			level.setEnabled(false);
			level.setToolTipText(ComponentMessages.DataMapperAnalyzer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !level.isEnabled()) {
			level.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#setLevel(EObject newValue)
	 * 
	 */
	public void setLevel(EObject newValue) {
		if (newValue != null) {
			level.setSelection(new StructuredSelection(newValue));
		} else {
			level.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.DataMapperAnalyzer.Properties.level);
		if (eefElementEditorReadOnlyState && level.isEnabled()) {
			level.setEnabled(false);
			level.setToolTipText(ComponentMessages.DataMapperAnalyzer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !level.isEnabled()) {
			level.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#setLevelButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLevelButtonMode(ButtonsModeEnum newValue) {
		level.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addFilterLevel(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLevel(ViewerFilter filter) {
		level.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addBusinessFilterLevel(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLevel(ViewerFilter filter) {
		level.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#getCustomizationPipeline()
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
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#initCustomizationPipeline(EObjectFlatComboSettings)
	 */
	public void initCustomizationPipeline(EObjectFlatComboSettings settings) {
		customizationPipeline.setInput(settings);
		if (current != null) {
			customizationPipeline.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.DataMapperAnalyzer.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.DataMapperAnalyzer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#setCustomizationPipeline(EObject newValue)
	 * 
	 */
	public void setCustomizationPipeline(EObject newValue) {
		if (newValue != null) {
			customizationPipeline.setSelection(new StructuredSelection(newValue));
		} else {
			customizationPipeline.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.DataMapperAnalyzer.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.DataMapperAnalyzer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#setCustomizationPipelineButtonMode(ButtonsModeEnum newValue)
	 */
	public void setCustomizationPipelineButtonMode(ButtonsModeEnum newValue) {
		customizationPipeline.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addBusinessFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#getArchiveSelector()
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
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#initArchiveSelector(EObjectFlatComboSettings)
	 */
	public void initArchiveSelector(EObjectFlatComboSettings settings) {
		archiveSelector.setInput(settings);
		if (current != null) {
			archiveSelector.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.DataMapperAnalyzer.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.DataMapperAnalyzer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#setArchiveSelector(EObject newValue)
	 * 
	 */
	public void setArchiveSelector(EObject newValue) {
		if (newValue != null) {
			archiveSelector.setSelection(new StructuredSelection(newValue));
		} else {
			archiveSelector.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.DataMapperAnalyzer.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.DataMapperAnalyzer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#setArchiveSelectorButtonMode(ButtonsModeEnum newValue)
	 */
	public void setArchiveSelectorButtonMode(ButtonsModeEnum newValue) {
		archiveSelector.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addBusinessFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#initMasterOn(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initMasterOn(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		masterOn.setContentProvider(contentProvider);
		masterOn.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.DataMapperAnalyzer.Properties.masterOn);
		if (eefElementEditorReadOnlyState && masterOn.getTable().isEnabled()) {
			masterOn.setEnabled(false);
			masterOn.setToolTipText(ComponentMessages.DataMapperAnalyzer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !masterOn.getTable().isEnabled()) {
			masterOn.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#updateMasterOn()
	 * 
	 */
	public void updateMasterOn() {
	masterOn.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addFilterMasterOn(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMasterOn(ViewerFilter filter) {
		masterOnFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addBusinessFilterMasterOn(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMasterOn(ViewerFilter filter) {
		masterOnBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#isContainedInMasterOnTable(EObject element)
	 * 
	 */
	public boolean isContainedInMasterOnTable(EObject element) {
		return ((ReferencesTableSettings)masterOn.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#getDataMapper()
	 * 
	 */
	public EObject getDataMapper() {
		if (dataMapper.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) dataMapper.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#initDataMapper(EObjectFlatComboSettings)
	 */
	public void initDataMapper(EObjectFlatComboSettings settings) {
		dataMapper.setInput(settings);
		if (current != null) {
			dataMapper.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.DataMapperAnalyzer.Properties.dataMapper);
		if (eefElementEditorReadOnlyState && dataMapper.isEnabled()) {
			dataMapper.setEnabled(false);
			dataMapper.setToolTipText(ComponentMessages.DataMapperAnalyzer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dataMapper.isEnabled()) {
			dataMapper.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#setDataMapper(EObject newValue)
	 * 
	 */
	public void setDataMapper(EObject newValue) {
		if (newValue != null) {
			dataMapper.setSelection(new StructuredSelection(newValue));
		} else {
			dataMapper.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.DataMapperAnalyzer.Properties.dataMapper);
		if (eefElementEditorReadOnlyState && dataMapper.isEnabled()) {
			dataMapper.setEnabled(false);
			dataMapper.setToolTipText(ComponentMessages.DataMapperAnalyzer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !dataMapper.isEnabled()) {
			dataMapper.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#setDataMapperButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDataMapperButtonMode(ButtonsModeEnum newValue) {
		dataMapper.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addFilterDataMapper(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDataMapper(ViewerFilter filter) {
		dataMapper.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.DataMapperAnalyzerPropertiesEditionPart#addBusinessFilterDataMapper(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDataMapper(ViewerFilter filter) {
		dataMapper.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.DataMapperAnalyzer_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
