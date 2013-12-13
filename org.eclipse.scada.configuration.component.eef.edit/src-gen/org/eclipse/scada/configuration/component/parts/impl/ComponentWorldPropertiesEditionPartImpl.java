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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart;
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
public class ComponentWorldPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ComponentWorldPropertiesEditionPart {

	protected ReferencesTable itemInterceptors;
	protected List<ViewerFilter> itemInterceptorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> itemInterceptorsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable configurations;
	protected List<ViewerFilter> configurationsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> configurationsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable services;
	protected List<ViewerFilter> servicesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> servicesFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer infrastructure;
	protected EObjectFlatComboViewer defaultCustomizationPipeline;
	protected EObjectFlatComboViewer defaultArchiveSelector;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ComponentWorldPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence componentWorldStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = componentWorldStep.addStep(ComponentViewsRepository.ComponentWorld.Properties.class);
		propertiesStep.addStep(ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors);
		propertiesStep.addStep(ComponentViewsRepository.ComponentWorld.Properties.configurations);
		propertiesStep.addStep(ComponentViewsRepository.ComponentWorld.Properties.services);
		propertiesStep.addStep(ComponentViewsRepository.ComponentWorld.Properties.infrastructure);
		propertiesStep.addStep(ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline);
		propertiesStep.addStep(ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector);
		
		
		composer = new PartComposer(componentWorldStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.ComponentWorld.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors) {
					return createItemInterceptorsAdvancedTableComposition(parent);
				}
				if (key == ComponentViewsRepository.ComponentWorld.Properties.configurations) {
					return createConfigurationsAdvancedTableComposition(parent);
				}
				if (key == ComponentViewsRepository.ComponentWorld.Properties.services) {
					return createServicesAdvancedTableComposition(parent);
				}
				if (key == ComponentViewsRepository.ComponentWorld.Properties.infrastructure) {
					return createInfrastructureFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline) {
					return createDefaultCustomizationPipelineFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector) {
					return createDefaultArchiveSelectorFlatComboViewer(parent);
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
		propertiesGroup.setText(ComponentMessages.ComponentWorldPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createItemInterceptorsAdvancedTableComposition(Composite parent) {
		this.itemInterceptors = new ReferencesTable(getDescription(ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors, ComponentMessages.ComponentWorldPropertiesEditionPart_ItemInterceptorsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				itemInterceptors.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				itemInterceptors.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				itemInterceptors.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				itemInterceptors.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.itemInterceptorsFilters) {
			this.itemInterceptors.addFilter(filter);
		}
		this.itemInterceptors.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors, ComponentViewsRepository.SWT_KIND));
		this.itemInterceptors.createControls(parent);
		this.itemInterceptors.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData itemInterceptorsData = new GridData(GridData.FILL_HORIZONTAL);
		itemInterceptorsData.horizontalSpan = 3;
		this.itemInterceptors.setLayoutData(itemInterceptorsData);
		this.itemInterceptors.setLowerBound(0);
		this.itemInterceptors.setUpperBound(-1);
		itemInterceptors.setID(ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors);
		itemInterceptors.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createItemInterceptorsAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createConfigurationsAdvancedTableComposition(Composite parent) {
		this.configurations = new ReferencesTable(getDescription(ComponentViewsRepository.ComponentWorld.Properties.configurations, ComponentMessages.ComponentWorldPropertiesEditionPart_ConfigurationsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.configurations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				configurations.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.configurations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				configurations.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.configurations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				configurations.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.configurations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				configurations.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.configurationsFilters) {
			this.configurations.addFilter(filter);
		}
		this.configurations.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.ComponentWorld.Properties.configurations, ComponentViewsRepository.SWT_KIND));
		this.configurations.createControls(parent);
		this.configurations.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.configurations, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData configurationsData = new GridData(GridData.FILL_HORIZONTAL);
		configurationsData.horizontalSpan = 3;
		this.configurations.setLayoutData(configurationsData);
		this.configurations.setLowerBound(0);
		this.configurations.setUpperBound(-1);
		configurations.setID(ComponentViewsRepository.ComponentWorld.Properties.configurations);
		configurations.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createConfigurationsAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createServicesAdvancedTableComposition(Composite parent) {
		this.services = new ReferencesTable(getDescription(ComponentViewsRepository.ComponentWorld.Properties.services, ComponentMessages.ComponentWorldPropertiesEditionPart_ServicesLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.services, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				services.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.services, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				services.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.services, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				services.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.services, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				services.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.servicesFilters) {
			this.services.addFilter(filter);
		}
		this.services.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.ComponentWorld.Properties.services, ComponentViewsRepository.SWT_KIND));
		this.services.createControls(parent);
		this.services.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.services, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData servicesData = new GridData(GridData.FILL_HORIZONTAL);
		servicesData.horizontalSpan = 3;
		this.services.setLayoutData(servicesData);
		this.services.setLowerBound(0);
		this.services.setUpperBound(-1);
		services.setID(ComponentViewsRepository.ComponentWorld.Properties.services);
		services.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createServicesAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createInfrastructureFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.ComponentWorld.Properties.infrastructure, ComponentMessages.ComponentWorldPropertiesEditionPart_InfrastructureLabel);
		infrastructure = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.ComponentWorld.Properties.infrastructure, ComponentViewsRepository.SWT_KIND));
		infrastructure.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		infrastructure.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.infrastructure, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getInfrastructure()));
			}

		});
		GridData infrastructureData = new GridData(GridData.FILL_HORIZONTAL);
		infrastructure.setLayoutData(infrastructureData);
		infrastructure.setID(ComponentViewsRepository.ComponentWorld.Properties.infrastructure);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.ComponentWorld.Properties.infrastructure, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createInfrastructureFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createDefaultCustomizationPipelineFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline, ComponentMessages.ComponentWorldPropertiesEditionPart_DefaultCustomizationPipelineLabel);
		defaultCustomizationPipeline = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline, ComponentViewsRepository.SWT_KIND));
		defaultCustomizationPipeline.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		defaultCustomizationPipeline.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getDefaultCustomizationPipeline()));
			}

		});
		GridData defaultCustomizationPipelineData = new GridData(GridData.FILL_HORIZONTAL);
		defaultCustomizationPipeline.setLayoutData(defaultCustomizationPipelineData);
		defaultCustomizationPipeline.setID(ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDefaultCustomizationPipelineFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createDefaultArchiveSelectorFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector, ComponentMessages.ComponentWorldPropertiesEditionPart_DefaultArchiveSelectorLabel);
		defaultArchiveSelector = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector, ComponentViewsRepository.SWT_KIND));
		defaultArchiveSelector.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		defaultArchiveSelector.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentWorldPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getDefaultArchiveSelector()));
			}

		});
		GridData defaultArchiveSelectorData = new GridData(GridData.FILL_HORIZONTAL);
		defaultArchiveSelector.setLayoutData(defaultArchiveSelectorData);
		defaultArchiveSelector.setID(ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createDefaultArchiveSelectorFlatComboViewer

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
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#initItemInterceptors(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initItemInterceptors(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		itemInterceptors.setContentProvider(contentProvider);
		itemInterceptors.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors);
		if (eefElementEditorReadOnlyState && itemInterceptors.isEnabled()) {
			itemInterceptors.setEnabled(false);
			itemInterceptors.setToolTipText(ComponentMessages.ComponentWorld_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !itemInterceptors.isEnabled()) {
			itemInterceptors.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#updateItemInterceptors()
	 * 
	 */
	public void updateItemInterceptors() {
	itemInterceptors.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addFilterItemInterceptors(ViewerFilter filter)
	 * 
	 */
	public void addFilterToItemInterceptors(ViewerFilter filter) {
		itemInterceptorsFilters.add(filter);
		if (this.itemInterceptors != null) {
			this.itemInterceptors.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addBusinessFilterItemInterceptors(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToItemInterceptors(ViewerFilter filter) {
		itemInterceptorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#isContainedInItemInterceptorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInItemInterceptorsTable(EObject element) {
		return ((ReferencesTableSettings)itemInterceptors.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#initConfigurations(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initConfigurations(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		configurations.setContentProvider(contentProvider);
		configurations.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentWorld.Properties.configurations);
		if (eefElementEditorReadOnlyState && configurations.isEnabled()) {
			configurations.setEnabled(false);
			configurations.setToolTipText(ComponentMessages.ComponentWorld_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !configurations.isEnabled()) {
			configurations.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#updateConfigurations()
	 * 
	 */
	public void updateConfigurations() {
	configurations.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addFilterConfigurations(ViewerFilter filter)
	 * 
	 */
	public void addFilterToConfigurations(ViewerFilter filter) {
		configurationsFilters.add(filter);
		if (this.configurations != null) {
			this.configurations.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addBusinessFilterConfigurations(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToConfigurations(ViewerFilter filter) {
		configurationsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#isContainedInConfigurationsTable(EObject element)
	 * 
	 */
	public boolean isContainedInConfigurationsTable(EObject element) {
		return ((ReferencesTableSettings)configurations.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#initServices(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initServices(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		services.setContentProvider(contentProvider);
		services.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentWorld.Properties.services);
		if (eefElementEditorReadOnlyState && services.isEnabled()) {
			services.setEnabled(false);
			services.setToolTipText(ComponentMessages.ComponentWorld_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !services.isEnabled()) {
			services.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#updateServices()
	 * 
	 */
	public void updateServices() {
	services.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addFilterServices(ViewerFilter filter)
	 * 
	 */
	public void addFilterToServices(ViewerFilter filter) {
		servicesFilters.add(filter);
		if (this.services != null) {
			this.services.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addBusinessFilterServices(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToServices(ViewerFilter filter) {
		servicesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#isContainedInServicesTable(EObject element)
	 * 
	 */
	public boolean isContainedInServicesTable(EObject element) {
		return ((ReferencesTableSettings)services.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#getInfrastructure()
	 * 
	 */
	public EObject getInfrastructure() {
		if (infrastructure.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) infrastructure.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#initInfrastructure(EObjectFlatComboSettings)
	 */
	public void initInfrastructure(EObjectFlatComboSettings settings) {
		infrastructure.setInput(settings);
		if (current != null) {
			infrastructure.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentWorld.Properties.infrastructure);
		if (eefElementEditorReadOnlyState && infrastructure.isEnabled()) {
			infrastructure.setEnabled(false);
			infrastructure.setToolTipText(ComponentMessages.ComponentWorld_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !infrastructure.isEnabled()) {
			infrastructure.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#setInfrastructure(EObject newValue)
	 * 
	 */
	public void setInfrastructure(EObject newValue) {
		if (newValue != null) {
			infrastructure.setSelection(new StructuredSelection(newValue));
		} else {
			infrastructure.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentWorld.Properties.infrastructure);
		if (eefElementEditorReadOnlyState && infrastructure.isEnabled()) {
			infrastructure.setEnabled(false);
			infrastructure.setToolTipText(ComponentMessages.ComponentWorld_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !infrastructure.isEnabled()) {
			infrastructure.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#setInfrastructureButtonMode(ButtonsModeEnum newValue)
	 */
	public void setInfrastructureButtonMode(ButtonsModeEnum newValue) {
		infrastructure.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addFilterInfrastructure(ViewerFilter filter)
	 * 
	 */
	public void addFilterToInfrastructure(ViewerFilter filter) {
		infrastructure.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addBusinessFilterInfrastructure(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToInfrastructure(ViewerFilter filter) {
		infrastructure.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#getDefaultCustomizationPipeline()
	 * 
	 */
	public EObject getDefaultCustomizationPipeline() {
		if (defaultCustomizationPipeline.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) defaultCustomizationPipeline.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#initDefaultCustomizationPipeline(EObjectFlatComboSettings)
	 */
	public void initDefaultCustomizationPipeline(EObjectFlatComboSettings settings) {
		defaultCustomizationPipeline.setInput(settings);
		if (current != null) {
			defaultCustomizationPipeline.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline);
		if (eefElementEditorReadOnlyState && defaultCustomizationPipeline.isEnabled()) {
			defaultCustomizationPipeline.setEnabled(false);
			defaultCustomizationPipeline.setToolTipText(ComponentMessages.ComponentWorld_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !defaultCustomizationPipeline.isEnabled()) {
			defaultCustomizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#setDefaultCustomizationPipeline(EObject newValue)
	 * 
	 */
	public void setDefaultCustomizationPipeline(EObject newValue) {
		if (newValue != null) {
			defaultCustomizationPipeline.setSelection(new StructuredSelection(newValue));
		} else {
			defaultCustomizationPipeline.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline);
		if (eefElementEditorReadOnlyState && defaultCustomizationPipeline.isEnabled()) {
			defaultCustomizationPipeline.setEnabled(false);
			defaultCustomizationPipeline.setToolTipText(ComponentMessages.ComponentWorld_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !defaultCustomizationPipeline.isEnabled()) {
			defaultCustomizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#setDefaultCustomizationPipelineButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDefaultCustomizationPipelineButtonMode(ButtonsModeEnum newValue) {
		defaultCustomizationPipeline.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addFilterDefaultCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDefaultCustomizationPipeline(ViewerFilter filter) {
		defaultCustomizationPipeline.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addBusinessFilterDefaultCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDefaultCustomizationPipeline(ViewerFilter filter) {
		defaultCustomizationPipeline.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#getDefaultArchiveSelector()
	 * 
	 */
	public EObject getDefaultArchiveSelector() {
		if (defaultArchiveSelector.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) defaultArchiveSelector.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#initDefaultArchiveSelector(EObjectFlatComboSettings)
	 */
	public void initDefaultArchiveSelector(EObjectFlatComboSettings settings) {
		defaultArchiveSelector.setInput(settings);
		if (current != null) {
			defaultArchiveSelector.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector);
		if (eefElementEditorReadOnlyState && defaultArchiveSelector.isEnabled()) {
			defaultArchiveSelector.setEnabled(false);
			defaultArchiveSelector.setToolTipText(ComponentMessages.ComponentWorld_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !defaultArchiveSelector.isEnabled()) {
			defaultArchiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#setDefaultArchiveSelector(EObject newValue)
	 * 
	 */
	public void setDefaultArchiveSelector(EObject newValue) {
		if (newValue != null) {
			defaultArchiveSelector.setSelection(new StructuredSelection(newValue));
		} else {
			defaultArchiveSelector.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector);
		if (eefElementEditorReadOnlyState && defaultArchiveSelector.isEnabled()) {
			defaultArchiveSelector.setEnabled(false);
			defaultArchiveSelector.setToolTipText(ComponentMessages.ComponentWorld_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !defaultArchiveSelector.isEnabled()) {
			defaultArchiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#setDefaultArchiveSelectorButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDefaultArchiveSelectorButtonMode(ButtonsModeEnum newValue) {
		defaultArchiveSelector.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addFilterDefaultArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDefaultArchiveSelector(ViewerFilter filter) {
		defaultArchiveSelector.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart#addBusinessFilterDefaultArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDefaultArchiveSelector(ViewerFilter filter) {
		defaultArchiveSelector.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.ComponentWorld_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
