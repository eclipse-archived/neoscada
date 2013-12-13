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
package org.eclipse.scada.configuration.component.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;

// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class CalculationComponentPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, CalculationComponentPropertiesEditionPart {

	protected Text shortDescription;
	protected Text name;
	protected EObjectFlatComboViewer level;
	protected EObjectFlatComboViewer customizationPipeline;
	protected EObjectFlatComboViewer archiveSelector;
	protected ReferencesTable masterOn;
	protected List<ViewerFilter> masterOnBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> masterOnFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer implementation;
	protected ReferencesTable outputs;
	protected List<ViewerFilter> outputsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> outputsFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable inputs;
	protected List<ViewerFilter> inputsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> inputsFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public CalculationComponentPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public CalculationComponentPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence calculationComponentStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = calculationComponentStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.class);
		propertiesStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.shortDescription);
		propertiesStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.name);
		propertiesStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.level);
		propertiesStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.customizationPipeline);
		propertiesStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.archiveSelector);
		propertiesStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.masterOn);
		propertiesStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.implementation);
		propertiesStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.outputs);
		propertiesStep.addStep(ComponentViewsRepository.CalculationComponent.Properties.inputs);
		
		
		composer = new PartComposer(calculationComponentStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.CalculationComponent.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.CalculationComponent.Properties.shortDescription) {
					return createShortDescriptionText(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.CalculationComponent.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.CalculationComponent.Properties.level) {
					return createLevelFlatComboViewer(parent, widgetFactory);
				}
				if (key == ComponentViewsRepository.CalculationComponent.Properties.customizationPipeline) {
					return createCustomizationPipelineFlatComboViewer(parent, widgetFactory);
				}
				if (key == ComponentViewsRepository.CalculationComponent.Properties.archiveSelector) {
					return createArchiveSelectorFlatComboViewer(parent, widgetFactory);
				}
				if (key == ComponentViewsRepository.CalculationComponent.Properties.masterOn) {
					return createMasterOnReferencesTable(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.CalculationComponent.Properties.implementation) {
					return createImplementationFlatComboViewer(parent, widgetFactory);
				}
				if (key == ComponentViewsRepository.CalculationComponent.Properties.outputs) {
					return createOutputsTableComposition(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.CalculationComponent.Properties.inputs) {
					return createInputsTableComposition(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(ComponentMessages.CalculationComponentPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createShortDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, ComponentViewsRepository.CalculationComponent.Properties.shortDescription, ComponentMessages.CalculationComponentPropertiesEditionPart_ShortDescriptionLabel);
		shortDescription = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		shortDescription.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData shortDescriptionData = new GridData(GridData.FILL_HORIZONTAL);
		shortDescription.setLayoutData(shortDescriptionData);
		shortDescription.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalculationComponentPropertiesEditionPartForm.this,
							ComponentViewsRepository.CalculationComponent.Properties.shortDescription,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, shortDescription.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalculationComponentPropertiesEditionPartForm.this,
									ComponentViewsRepository.CalculationComponent.Properties.shortDescription,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, shortDescription.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalculationComponentPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		shortDescription.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.shortDescription, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, shortDescription.getText()));
				}
			}
		});
		EditingUtils.setID(shortDescription, ComponentViewsRepository.CalculationComponent.Properties.shortDescription);
		EditingUtils.setEEFtype(shortDescription, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.CalculationComponent.Properties.shortDescription, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createShortDescriptionText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, ComponentViewsRepository.CalculationComponent.Properties.name, ComponentMessages.CalculationComponentPropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							CalculationComponentPropertiesEditionPartForm.this,
							ComponentViewsRepository.CalculationComponent.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalculationComponentPropertiesEditionPartForm.this,
									ComponentViewsRepository.CalculationComponent.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									CalculationComponentPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, ComponentViewsRepository.CalculationComponent.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.CalculationComponent.Properties.name, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createLevelFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, ComponentViewsRepository.CalculationComponent.Properties.level, ComponentMessages.CalculationComponentPropertiesEditionPart_LevelLabel);
		level = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.CalculationComponent.Properties.level, ComponentViewsRepository.FORM_KIND));
		widgetFactory.adapt(level);
		level.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData levelData = new GridData(GridData.FILL_HORIZONTAL);
		level.setLayoutData(levelData);
		level.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.level, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLevel()));
			}

		});
		level.setID(ComponentViewsRepository.CalculationComponent.Properties.level);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.CalculationComponent.Properties.level, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createLevelFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createCustomizationPipelineFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, ComponentViewsRepository.CalculationComponent.Properties.customizationPipeline, ComponentMessages.CalculationComponentPropertiesEditionPart_CustomizationPipelineLabel);
		customizationPipeline = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.CalculationComponent.Properties.customizationPipeline, ComponentViewsRepository.FORM_KIND));
		widgetFactory.adapt(customizationPipeline);
		customizationPipeline.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData customizationPipelineData = new GridData(GridData.FILL_HORIZONTAL);
		customizationPipeline.setLayoutData(customizationPipelineData);
		customizationPipeline.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.customizationPipeline, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCustomizationPipeline()));
			}

		});
		customizationPipeline.setID(ComponentViewsRepository.CalculationComponent.Properties.customizationPipeline);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.CalculationComponent.Properties.customizationPipeline, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createCustomizationPipelineFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createArchiveSelectorFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, ComponentViewsRepository.CalculationComponent.Properties.archiveSelector, ComponentMessages.CalculationComponentPropertiesEditionPart_ArchiveSelectorLabel);
		archiveSelector = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.CalculationComponent.Properties.archiveSelector, ComponentViewsRepository.FORM_KIND));
		widgetFactory.adapt(archiveSelector);
		archiveSelector.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData archiveSelectorData = new GridData(GridData.FILL_HORIZONTAL);
		archiveSelector.setLayoutData(archiveSelectorData);
		archiveSelector.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.archiveSelector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getArchiveSelector()));
			}

		});
		archiveSelector.setID(ComponentViewsRepository.CalculationComponent.Properties.archiveSelector);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.CalculationComponent.Properties.archiveSelector, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createArchiveSelectorFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createMasterOnReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.masterOn = new ReferencesTable(getDescription(ComponentViewsRepository.CalculationComponent.Properties.masterOn, ComponentMessages.CalculationComponentPropertiesEditionPart_MasterOnLabel), new ReferencesTableListener	() {
			public void handleAdd() { addMasterOn(); }
			public void handleEdit(EObject element) { editMasterOn(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveMasterOn(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromMasterOn(element); }
			public void navigateTo(EObject element) { }
		});
		this.masterOn.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.CalculationComponent.Properties.masterOn, ComponentViewsRepository.FORM_KIND));
		this.masterOn.createControls(parent, widgetFactory);
		this.masterOn.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.masterOn, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData masterOnData = new GridData(GridData.FILL_HORIZONTAL);
		masterOnData.horizontalSpan = 3;
		this.masterOn.setLayoutData(masterOnData);
		this.masterOn.disableMove();
		masterOn.setID(ComponentViewsRepository.CalculationComponent.Properties.masterOn);
		masterOn.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createMasterOnReferencesTable

		// End of user code
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.masterOn,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.masterOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		masterOn.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromMasterOn(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.masterOn, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createImplementationFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, ComponentViewsRepository.CalculationComponent.Properties.implementation, ComponentMessages.CalculationComponentPropertiesEditionPart_ImplementationLabel);
		implementation = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.CalculationComponent.Properties.implementation, ComponentViewsRepository.FORM_KIND));
		widgetFactory.adapt(implementation);
		implementation.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData implementationData = new GridData(GridData.FILL_HORIZONTAL);
		implementation.setLayoutData(implementationData);
		implementation.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.implementation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getImplementation()));
			}

		});
		implementation.setID(ComponentViewsRepository.CalculationComponent.Properties.implementation);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.CalculationComponent.Properties.implementation, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createImplementationFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createOutputsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.outputs = new ReferencesTable(getDescription(ComponentViewsRepository.CalculationComponent.Properties.outputs, ComponentMessages.CalculationComponentPropertiesEditionPart_OutputsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.outputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				outputs.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.outputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				outputs.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.outputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				outputs.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.outputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				outputs.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.outputsFilters) {
			this.outputs.addFilter(filter);
		}
		this.outputs.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.CalculationComponent.Properties.outputs, ComponentViewsRepository.FORM_KIND));
		this.outputs.createControls(parent, widgetFactory);
		this.outputs.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.outputs, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData outputsData = new GridData(GridData.FILL_HORIZONTAL);
		outputsData.horizontalSpan = 3;
		this.outputs.setLayoutData(outputsData);
		this.outputs.setLowerBound(0);
		this.outputs.setUpperBound(-1);
		outputs.setID(ComponentViewsRepository.CalculationComponent.Properties.outputs);
		outputs.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createOutputsTableComposition

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createInputsTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.inputs = new ReferencesTable(getDescription(ComponentViewsRepository.CalculationComponent.Properties.inputs, ComponentMessages.CalculationComponentPropertiesEditionPart_InputsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.inputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				inputs.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.inputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				inputs.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.inputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				inputs.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.inputs, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				inputs.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.inputsFilters) {
			this.inputs.addFilter(filter);
		}
		this.inputs.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.CalculationComponent.Properties.inputs, ComponentViewsRepository.FORM_KIND));
		this.inputs.createControls(parent, widgetFactory);
		this.inputs.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(CalculationComponentPropertiesEditionPartForm.this, ComponentViewsRepository.CalculationComponent.Properties.inputs, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData inputsData = new GridData(GridData.FILL_HORIZONTAL);
		inputsData.horizontalSpan = 3;
		this.inputs.setLayoutData(inputsData);
		this.inputs.setLowerBound(0);
		this.inputs.setUpperBound(-1);
		inputs.setID(ComponentViewsRepository.CalculationComponent.Properties.inputs);
		inputs.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createInputsTableComposition

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
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#getShortDescription()
	 * 
	 */
	public String getShortDescription() {
		return shortDescription.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setShortDescription(String newValue)
	 * 
	 */
	public void setShortDescription(String newValue) {
		if (newValue != null) {
			shortDescription.setText(newValue);
		} else {
			shortDescription.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.shortDescription);
		if (eefElementEditorReadOnlyState && shortDescription.isEnabled()) {
			shortDescription.setEnabled(false);
			shortDescription.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !shortDescription.isEnabled()) {
			shortDescription.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#getLevel()
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
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#initLevel(EObjectFlatComboSettings)
	 */
	public void initLevel(EObjectFlatComboSettings settings) {
		level.setInput(settings);
		if (current != null) {
			level.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.level);
		if (eefElementEditorReadOnlyState && level.isEnabled()) {
			level.setEnabled(false);
			level.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !level.isEnabled()) {
			level.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setLevel(EObject newValue)
	 * 
	 */
	public void setLevel(EObject newValue) {
		if (newValue != null) {
			level.setSelection(new StructuredSelection(newValue));
		} else {
			level.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.level);
		if (eefElementEditorReadOnlyState && level.isEnabled()) {
			level.setEnabled(false);
			level.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !level.isEnabled()) {
			level.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setLevelButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLevelButtonMode(ButtonsModeEnum newValue) {
		level.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addFilterLevel(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLevel(ViewerFilter filter) {
		level.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addBusinessFilterLevel(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLevel(ViewerFilter filter) {
		level.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#getCustomizationPipeline()
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
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#initCustomizationPipeline(EObjectFlatComboSettings)
	 */
	public void initCustomizationPipeline(EObjectFlatComboSettings settings) {
		customizationPipeline.setInput(settings);
		if (current != null) {
			customizationPipeline.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setCustomizationPipeline(EObject newValue)
	 * 
	 */
	public void setCustomizationPipeline(EObject newValue) {
		if (newValue != null) {
			customizationPipeline.setSelection(new StructuredSelection(newValue));
		} else {
			customizationPipeline.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setCustomizationPipelineButtonMode(ButtonsModeEnum newValue)
	 */
	public void setCustomizationPipelineButtonMode(ButtonsModeEnum newValue) {
		customizationPipeline.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addBusinessFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#getArchiveSelector()
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
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#initArchiveSelector(EObjectFlatComboSettings)
	 */
	public void initArchiveSelector(EObjectFlatComboSettings settings) {
		archiveSelector.setInput(settings);
		if (current != null) {
			archiveSelector.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setArchiveSelector(EObject newValue)
	 * 
	 */
	public void setArchiveSelector(EObject newValue) {
		if (newValue != null) {
			archiveSelector.setSelection(new StructuredSelection(newValue));
		} else {
			archiveSelector.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setArchiveSelectorButtonMode(ButtonsModeEnum newValue)
	 */
	public void setArchiveSelectorButtonMode(ButtonsModeEnum newValue) {
		archiveSelector.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addBusinessFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#initMasterOn(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initMasterOn(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		masterOn.setContentProvider(contentProvider);
		masterOn.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.masterOn);
		if (eefElementEditorReadOnlyState && masterOn.getTable().isEnabled()) {
			masterOn.setEnabled(false);
			masterOn.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !masterOn.getTable().isEnabled()) {
			masterOn.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#updateMasterOn()
	 * 
	 */
	public void updateMasterOn() {
	masterOn.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addFilterMasterOn(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMasterOn(ViewerFilter filter) {
		masterOnFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addBusinessFilterMasterOn(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMasterOn(ViewerFilter filter) {
		masterOnBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#isContainedInMasterOnTable(EObject element)
	 * 
	 */
	public boolean isContainedInMasterOnTable(EObject element) {
		return ((ReferencesTableSettings)masterOn.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#getImplementation()
	 * 
	 */
	public EObject getImplementation() {
		if (implementation.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) implementation.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#initImplementation(EObjectFlatComboSettings)
	 */
	public void initImplementation(EObjectFlatComboSettings settings) {
		implementation.setInput(settings);
		if (current != null) {
			implementation.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.implementation);
		if (eefElementEditorReadOnlyState && implementation.isEnabled()) {
			implementation.setEnabled(false);
			implementation.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !implementation.isEnabled()) {
			implementation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setImplementation(EObject newValue)
	 * 
	 */
	public void setImplementation(EObject newValue) {
		if (newValue != null) {
			implementation.setSelection(new StructuredSelection(newValue));
		} else {
			implementation.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.implementation);
		if (eefElementEditorReadOnlyState && implementation.isEnabled()) {
			implementation.setEnabled(false);
			implementation.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !implementation.isEnabled()) {
			implementation.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#setImplementationButtonMode(ButtonsModeEnum newValue)
	 */
	public void setImplementationButtonMode(ButtonsModeEnum newValue) {
		implementation.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addFilterImplementation(ViewerFilter filter)
	 * 
	 */
	public void addFilterToImplementation(ViewerFilter filter) {
		implementation.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addBusinessFilterImplementation(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToImplementation(ViewerFilter filter) {
		implementation.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#initOutputs(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOutputs(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		outputs.setContentProvider(contentProvider);
		outputs.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.outputs);
		if (eefElementEditorReadOnlyState && outputs.isEnabled()) {
			outputs.setEnabled(false);
			outputs.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !outputs.isEnabled()) {
			outputs.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#updateOutputs()
	 * 
	 */
	public void updateOutputs() {
	outputs.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addFilterOutputs(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOutputs(ViewerFilter filter) {
		outputsFilters.add(filter);
		if (this.outputs != null) {
			this.outputs.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addBusinessFilterOutputs(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOutputs(ViewerFilter filter) {
		outputsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#isContainedInOutputsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOutputsTable(EObject element) {
		return ((ReferencesTableSettings)outputs.getInput()).contains(element);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#initInputs(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initInputs(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		inputs.setContentProvider(contentProvider);
		inputs.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.CalculationComponent.Properties.inputs);
		if (eefElementEditorReadOnlyState && inputs.isEnabled()) {
			inputs.setEnabled(false);
			inputs.setToolTipText(ComponentMessages.CalculationComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !inputs.isEnabled()) {
			inputs.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#updateInputs()
	 * 
	 */
	public void updateInputs() {
	inputs.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addFilterInputs(ViewerFilter filter)
	 * 
	 */
	public void addFilterToInputs(ViewerFilter filter) {
		inputsFilters.add(filter);
		if (this.inputs != null) {
			this.inputs.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#addBusinessFilterInputs(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToInputs(ViewerFilter filter) {
		inputsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.CalculationComponentPropertiesEditionPart#isContainedInInputsTable(EObject element)
	 * 
	 */
	public boolean isContainedInInputsTable(EObject element) {
		return ((ReferencesTableSettings)inputs.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.CalculationComponent_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
