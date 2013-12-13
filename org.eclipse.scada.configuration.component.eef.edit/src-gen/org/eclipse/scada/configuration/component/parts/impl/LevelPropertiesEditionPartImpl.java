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
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
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
import org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class LevelPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, LevelPropertiesEditionPart {

	protected ReferencesTable itemInterceptors;
	protected List<ViewerFilter> itemInterceptorsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> itemInterceptorsFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer parent_;
	protected EObjectFlatComboViewer customizationPipeline;
	protected EObjectFlatComboViewer archiveSelector;
	protected Text name;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public LevelPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence levelStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = levelStep.addStep(ComponentViewsRepository.Level.Properties.class);
		propertiesStep.addStep(ComponentViewsRepository.Level.Properties.itemInterceptors);
		propertiesStep.addStep(ComponentViewsRepository.Level.Properties.parent_);
		propertiesStep.addStep(ComponentViewsRepository.Level.Properties.customizationPipeline);
		propertiesStep.addStep(ComponentViewsRepository.Level.Properties.archiveSelector);
		propertiesStep.addStep(ComponentViewsRepository.Level.Properties.name);
		
		
		composer = new PartComposer(levelStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.Level.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ComponentViewsRepository.Level.Properties.itemInterceptors) {
					return createItemInterceptorsAdvancedTableComposition(parent);
				}
				if (key == ComponentViewsRepository.Level.Properties.parent_) {
					return createParent_FlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.Level.Properties.customizationPipeline) {
					return createCustomizationPipelineFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.Level.Properties.archiveSelector) {
					return createArchiveSelectorFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.Level.Properties.name) {
					return createNameText(parent);
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
		propertiesGroup.setText(ComponentMessages.LevelPropertiesEditionPart_PropertiesGroupLabel);
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
		this.itemInterceptors = new ReferencesTable(getDescription(ComponentViewsRepository.Level.Properties.itemInterceptors, ComponentMessages.LevelPropertiesEditionPart_ItemInterceptorsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.itemInterceptors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				itemInterceptors.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.itemInterceptors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				itemInterceptors.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.itemInterceptors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				itemInterceptors.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.itemInterceptors, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				itemInterceptors.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.itemInterceptorsFilters) {
			this.itemInterceptors.addFilter(filter);
		}
		this.itemInterceptors.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.Level.Properties.itemInterceptors, ComponentViewsRepository.SWT_KIND));
		this.itemInterceptors.createControls(parent);
		this.itemInterceptors.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.itemInterceptors, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData itemInterceptorsData = new GridData(GridData.FILL_HORIZONTAL);
		itemInterceptorsData.horizontalSpan = 3;
		this.itemInterceptors.setLayoutData(itemInterceptorsData);
		this.itemInterceptors.setLowerBound(0);
		this.itemInterceptors.setUpperBound(-1);
		itemInterceptors.setID(ComponentViewsRepository.Level.Properties.itemInterceptors);
		itemInterceptors.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createItemInterceptorsAdvancedTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createParent_FlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.Level.Properties.parent_, ComponentMessages.LevelPropertiesEditionPart_Parent_Label);
		parent_ = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.Level.Properties.parent_, ComponentViewsRepository.SWT_KIND));
		parent_.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		parent_.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.parent_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getParent_()));
			}

		});
		GridData parent_Data = new GridData(GridData.FILL_HORIZONTAL);
		parent_.setLayoutData(parent_Data);
		parent_.setID(ComponentViewsRepository.Level.Properties.parent_);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.Level.Properties.parent_, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createParent_FlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createCustomizationPipelineFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.Level.Properties.customizationPipeline, ComponentMessages.LevelPropertiesEditionPart_CustomizationPipelineLabel);
		customizationPipeline = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.Level.Properties.customizationPipeline, ComponentViewsRepository.SWT_KIND));
		customizationPipeline.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		customizationPipeline.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.customizationPipeline, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getCustomizationPipeline()));
			}

		});
		GridData customizationPipelineData = new GridData(GridData.FILL_HORIZONTAL);
		customizationPipeline.setLayoutData(customizationPipelineData);
		customizationPipeline.setID(ComponentViewsRepository.Level.Properties.customizationPipeline);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.Level.Properties.customizationPipeline, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createCustomizationPipelineFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createArchiveSelectorFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.Level.Properties.archiveSelector, ComponentMessages.LevelPropertiesEditionPart_ArchiveSelectorLabel);
		archiveSelector = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.Level.Properties.archiveSelector, ComponentViewsRepository.SWT_KIND));
		archiveSelector.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		archiveSelector.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.archiveSelector, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getArchiveSelector()));
			}

		});
		GridData archiveSelectorData = new GridData(GridData.FILL_HORIZONTAL);
		archiveSelector.setLayoutData(archiveSelectorData);
		archiveSelector.setID(ComponentViewsRepository.Level.Properties.archiveSelector);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.Level.Properties.archiveSelector, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createArchiveSelectorFlatComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, ComponentViewsRepository.Level.Properties.name, ComponentMessages.LevelPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(LevelPropertiesEditionPartImpl.this, ComponentViewsRepository.Level.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, ComponentViewsRepository.Level.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.Level.Properties.name, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

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
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#initItemInterceptors(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initItemInterceptors(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		itemInterceptors.setContentProvider(contentProvider);
		itemInterceptors.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.Level.Properties.itemInterceptors);
		if (eefElementEditorReadOnlyState && itemInterceptors.isEnabled()) {
			itemInterceptors.setEnabled(false);
			itemInterceptors.setToolTipText(ComponentMessages.Level_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !itemInterceptors.isEnabled()) {
			itemInterceptors.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#updateItemInterceptors()
	 * 
	 */
	public void updateItemInterceptors() {
	itemInterceptors.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#addFilterItemInterceptors(ViewerFilter filter)
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
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#addBusinessFilterItemInterceptors(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToItemInterceptors(ViewerFilter filter) {
		itemInterceptorsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#isContainedInItemInterceptorsTable(EObject element)
	 * 
	 */
	public boolean isContainedInItemInterceptorsTable(EObject element) {
		return ((ReferencesTableSettings)itemInterceptors.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#getParent_()
	 * 
	 */
	public EObject getParent_() {
		if (parent_.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) parent_.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#initParent_(EObjectFlatComboSettings)
	 */
	public void initParent_(EObjectFlatComboSettings settings) {
		parent_.setInput(settings);
		if (current != null) {
			parent_.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.Level.Properties.parent_);
		if (eefElementEditorReadOnlyState && parent_.isEnabled()) {
			parent_.setEnabled(false);
			parent_.setToolTipText(ComponentMessages.Level_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parent_.isEnabled()) {
			parent_.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#setParent_(EObject newValue)
	 * 
	 */
	public void setParent_(EObject newValue) {
		if (newValue != null) {
			parent_.setSelection(new StructuredSelection(newValue));
		} else {
			parent_.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.Level.Properties.parent_);
		if (eefElementEditorReadOnlyState && parent_.isEnabled()) {
			parent_.setEnabled(false);
			parent_.setToolTipText(ComponentMessages.Level_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !parent_.isEnabled()) {
			parent_.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#setParent_ButtonMode(ButtonsModeEnum newValue)
	 */
	public void setParent_ButtonMode(ButtonsModeEnum newValue) {
		parent_.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#addFilterParent_(ViewerFilter filter)
	 * 
	 */
	public void addFilterToParent_(ViewerFilter filter) {
		parent_.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#addBusinessFilterParent_(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToParent_(ViewerFilter filter) {
		parent_.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#getCustomizationPipeline()
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
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#initCustomizationPipeline(EObjectFlatComboSettings)
	 */
	public void initCustomizationPipeline(EObjectFlatComboSettings settings) {
		customizationPipeline.setInput(settings);
		if (current != null) {
			customizationPipeline.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.Level.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.Level_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#setCustomizationPipeline(EObject newValue)
	 * 
	 */
	public void setCustomizationPipeline(EObject newValue) {
		if (newValue != null) {
			customizationPipeline.setSelection(new StructuredSelection(newValue));
		} else {
			customizationPipeline.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.Level.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.Level_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#setCustomizationPipelineButtonMode(ButtonsModeEnum newValue)
	 */
	public void setCustomizationPipelineButtonMode(ButtonsModeEnum newValue) {
		customizationPipeline.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#addFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#addBusinessFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#getArchiveSelector()
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
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#initArchiveSelector(EObjectFlatComboSettings)
	 */
	public void initArchiveSelector(EObjectFlatComboSettings settings) {
		archiveSelector.setInput(settings);
		if (current != null) {
			archiveSelector.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.Level.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.Level_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#setArchiveSelector(EObject newValue)
	 * 
	 */
	public void setArchiveSelector(EObject newValue) {
		if (newValue != null) {
			archiveSelector.setSelection(new StructuredSelection(newValue));
		} else {
			archiveSelector.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.Level.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.Level_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#setArchiveSelectorButtonMode(ButtonsModeEnum newValue)
	 */
	public void setArchiveSelectorButtonMode(ButtonsModeEnum newValue) {
		archiveSelector.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#addFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#addBusinessFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.LevelPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.Level.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(ComponentMessages.Level_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.Level_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
