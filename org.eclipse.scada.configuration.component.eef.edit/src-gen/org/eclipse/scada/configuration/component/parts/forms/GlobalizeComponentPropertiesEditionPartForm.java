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
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart;
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
public class GlobalizeComponentPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, GlobalizeComponentPropertiesEditionPart {

	protected Text shortDescription;
	protected Text name;
	protected EObjectFlatComboViewer level;
	protected EObjectFlatComboViewer customizationPipeline;
	protected EObjectFlatComboViewer archiveSelector;
	protected ReferencesTable components;
	protected List<ViewerFilter> componentsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> componentsFilters = new ArrayList<ViewerFilter>();
	protected EObjectFlatComboViewer sourceMaster;



	/**
	 * For {@link ISection} use only.
	 */
	public GlobalizeComponentPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public GlobalizeComponentPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence globalizeComponentStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = globalizeComponentStep.addStep(ComponentViewsRepository.GlobalizeComponent.Properties.class);
		propertiesStep.addStep(ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription);
		propertiesStep.addStep(ComponentViewsRepository.GlobalizeComponent.Properties.name);
		propertiesStep.addStep(ComponentViewsRepository.GlobalizeComponent.Properties.level);
		propertiesStep.addStep(ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline);
		propertiesStep.addStep(ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector);
		propertiesStep.addStep(ComponentViewsRepository.GlobalizeComponent.Properties.components);
		propertiesStep.addStep(ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster);
		
		
		composer = new PartComposer(globalizeComponentStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.GlobalizeComponent.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription) {
					return createShortDescriptionText(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.GlobalizeComponent.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.GlobalizeComponent.Properties.level) {
					return createLevelFlatComboViewer(parent, widgetFactory);
				}
				if (key == ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline) {
					return createCustomizationPipelineFlatComboViewer(parent, widgetFactory);
				}
				if (key == ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector) {
					return createArchiveSelectorFlatComboViewer(parent, widgetFactory);
				}
				if (key == ComponentViewsRepository.GlobalizeComponent.Properties.components) {
					return createComponentsReferencesTable(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster) {
					return createSourceMasterFlatComboViewer(parent, widgetFactory);
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
		propertiesSection.setText(ComponentMessages.GlobalizeComponentPropertiesEditionPart_PropertiesGroupLabel);
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
		createDescription(parent, ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription, ComponentMessages.GlobalizeComponentPropertiesEditionPart_ShortDescriptionLabel);
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
							GlobalizeComponentPropertiesEditionPartForm.this,
							ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, shortDescription.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									GlobalizeComponentPropertiesEditionPartForm.this,
									ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription,
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
									GlobalizeComponentPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, shortDescription.getText()));
				}
			}
		});
		EditingUtils.setID(shortDescription, ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription);
		EditingUtils.setEEFtype(shortDescription, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createShortDescriptionText

		// End of user code
		return parent;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, ComponentViewsRepository.GlobalizeComponent.Properties.name, ComponentMessages.GlobalizeComponentPropertiesEditionPart_NameLabel);
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
							GlobalizeComponentPropertiesEditionPartForm.this,
							ComponentViewsRepository.GlobalizeComponent.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									GlobalizeComponentPropertiesEditionPartForm.this,
									ComponentViewsRepository.GlobalizeComponent.Properties.name,
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
									GlobalizeComponentPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, ComponentViewsRepository.GlobalizeComponent.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.GlobalizeComponent.Properties.name, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		createDescription(parent, ComponentViewsRepository.GlobalizeComponent.Properties.level, ComponentMessages.GlobalizeComponentPropertiesEditionPart_LevelLabel);
		level = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.GlobalizeComponent.Properties.level, ComponentViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.level, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getLevel()));
			}

		});
		level.setID(ComponentViewsRepository.GlobalizeComponent.Properties.level);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.GlobalizeComponent.Properties.level, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		createDescription(parent, ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline, ComponentMessages.GlobalizeComponentPropertiesEditionPart_CustomizationPipelineLabel);
		customizationPipeline = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline, ComponentViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCustomizationPipeline()));
			}

		});
		customizationPipeline.setID(ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		createDescription(parent, ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector, ComponentMessages.GlobalizeComponentPropertiesEditionPart_ArchiveSelectorLabel);
		archiveSelector = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector, ComponentViewsRepository.FORM_KIND));
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getArchiveSelector()));
			}

		});
		archiveSelector.setID(ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createArchiveSelectorFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createComponentsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.components = new ReferencesTable(getDescription(ComponentViewsRepository.GlobalizeComponent.Properties.components, ComponentMessages.GlobalizeComponentPropertiesEditionPart_ComponentsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addComponents(); }
			public void handleEdit(EObject element) { editComponents(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveComponents(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromComponents(element); }
			public void navigateTo(EObject element) { }
		});
		this.components.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.GlobalizeComponent.Properties.components, ComponentViewsRepository.FORM_KIND));
		this.components.createControls(parent, widgetFactory);
		this.components.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.components, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData componentsData = new GridData(GridData.FILL_HORIZONTAL);
		componentsData.horizontalSpan = 3;
		this.components.setLayoutData(componentsData);
		this.components.disableMove();
		components.setID(ComponentViewsRepository.GlobalizeComponent.Properties.components);
		components.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createComponentsReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addComponents() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(components.getInput(), componentsFilters, componentsBusinessFilters,
		"components", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.components,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				components.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveComponents(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.components, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		components.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromComponents(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.components, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		components.refresh();
	}

	/**
	 * 
	 */
	protected void editComponents(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				components.refresh();
			}
		}
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createSourceMasterFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster, ComponentMessages.GlobalizeComponentPropertiesEditionPart_SourceMasterLabel);
		sourceMaster = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster, ComponentViewsRepository.FORM_KIND));
		widgetFactory.adapt(sourceMaster);
		sourceMaster.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData sourceMasterData = new GridData(GridData.FILL_HORIZONTAL);
		sourceMaster.setLayoutData(sourceMasterData);
		sourceMaster.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GlobalizeComponentPropertiesEditionPartForm.this, ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceMaster()));
			}

		});
		sourceMaster.setID(ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceMasterFlatComboViewer

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
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#getShortDescription()
	 * 
	 */
	public String getShortDescription() {
		return shortDescription.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setShortDescription(String newValue)
	 * 
	 */
	public void setShortDescription(String newValue) {
		if (newValue != null) {
			shortDescription.setText(newValue);
		} else {
			shortDescription.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription);
		if (eefElementEditorReadOnlyState && shortDescription.isEnabled()) {
			shortDescription.setEnabled(false);
			shortDescription.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !shortDescription.isEnabled()) {
			shortDescription.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#getLevel()
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
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#initLevel(EObjectFlatComboSettings)
	 */
	public void initLevel(EObjectFlatComboSettings settings) {
		level.setInput(settings);
		if (current != null) {
			level.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.level);
		if (eefElementEditorReadOnlyState && level.isEnabled()) {
			level.setEnabled(false);
			level.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !level.isEnabled()) {
			level.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setLevel(EObject newValue)
	 * 
	 */
	public void setLevel(EObject newValue) {
		if (newValue != null) {
			level.setSelection(new StructuredSelection(newValue));
		} else {
			level.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.level);
		if (eefElementEditorReadOnlyState && level.isEnabled()) {
			level.setEnabled(false);
			level.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !level.isEnabled()) {
			level.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setLevelButtonMode(ButtonsModeEnum newValue)
	 */
	public void setLevelButtonMode(ButtonsModeEnum newValue) {
		level.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addFilterLevel(ViewerFilter filter)
	 * 
	 */
	public void addFilterToLevel(ViewerFilter filter) {
		level.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addBusinessFilterLevel(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToLevel(ViewerFilter filter) {
		level.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#getCustomizationPipeline()
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
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#initCustomizationPipeline(EObjectFlatComboSettings)
	 */
	public void initCustomizationPipeline(EObjectFlatComboSettings settings) {
		customizationPipeline.setInput(settings);
		if (current != null) {
			customizationPipeline.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setCustomizationPipeline(EObject newValue)
	 * 
	 */
	public void setCustomizationPipeline(EObject newValue) {
		if (newValue != null) {
			customizationPipeline.setSelection(new StructuredSelection(newValue));
		} else {
			customizationPipeline.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline);
		if (eefElementEditorReadOnlyState && customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(false);
			customizationPipeline.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !customizationPipeline.isEnabled()) {
			customizationPipeline.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setCustomizationPipelineButtonMode(ButtonsModeEnum newValue)
	 */
	public void setCustomizationPipelineButtonMode(ButtonsModeEnum newValue) {
		customizationPipeline.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addBusinessFilterCustomizationPipeline(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToCustomizationPipeline(ViewerFilter filter) {
		customizationPipeline.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#getArchiveSelector()
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
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#initArchiveSelector(EObjectFlatComboSettings)
	 */
	public void initArchiveSelector(EObjectFlatComboSettings settings) {
		archiveSelector.setInput(settings);
		if (current != null) {
			archiveSelector.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setArchiveSelector(EObject newValue)
	 * 
	 */
	public void setArchiveSelector(EObject newValue) {
		if (newValue != null) {
			archiveSelector.setSelection(new StructuredSelection(newValue));
		} else {
			archiveSelector.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector);
		if (eefElementEditorReadOnlyState && archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(false);
			archiveSelector.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !archiveSelector.isEnabled()) {
			archiveSelector.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setArchiveSelectorButtonMode(ButtonsModeEnum newValue)
	 */
	public void setArchiveSelectorButtonMode(ButtonsModeEnum newValue) {
		archiveSelector.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addBusinessFilterArchiveSelector(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToArchiveSelector(ViewerFilter filter) {
		archiveSelector.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#initComponents(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initComponents(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		components.setContentProvider(contentProvider);
		components.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.components);
		if (eefElementEditorReadOnlyState && components.getTable().isEnabled()) {
			components.setEnabled(false);
			components.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !components.getTable().isEnabled()) {
			components.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#updateComponents()
	 * 
	 */
	public void updateComponents() {
	components.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addFilterComponents(ViewerFilter filter)
	 * 
	 */
	public void addFilterToComponents(ViewerFilter filter) {
		componentsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addBusinessFilterComponents(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToComponents(ViewerFilter filter) {
		componentsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#isContainedInComponentsTable(EObject element)
	 * 
	 */
	public boolean isContainedInComponentsTable(EObject element) {
		return ((ReferencesTableSettings)components.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#getSourceMaster()
	 * 
	 */
	public EObject getSourceMaster() {
		if (sourceMaster.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) sourceMaster.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#initSourceMaster(EObjectFlatComboSettings)
	 */
	public void initSourceMaster(EObjectFlatComboSettings settings) {
		sourceMaster.setInput(settings);
		if (current != null) {
			sourceMaster.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster);
		if (eefElementEditorReadOnlyState && sourceMaster.isEnabled()) {
			sourceMaster.setEnabled(false);
			sourceMaster.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceMaster.isEnabled()) {
			sourceMaster.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setSourceMaster(EObject newValue)
	 * 
	 */
	public void setSourceMaster(EObject newValue) {
		if (newValue != null) {
			sourceMaster.setSelection(new StructuredSelection(newValue));
		} else {
			sourceMaster.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster);
		if (eefElementEditorReadOnlyState && sourceMaster.isEnabled()) {
			sourceMaster.setEnabled(false);
			sourceMaster.setToolTipText(ComponentMessages.GlobalizeComponent_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceMaster.isEnabled()) {
			sourceMaster.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#setSourceMasterButtonMode(ButtonsModeEnum newValue)
	 */
	public void setSourceMasterButtonMode(ButtonsModeEnum newValue) {
		sourceMaster.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addFilterSourceMaster(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSourceMaster(ViewerFilter filter) {
		sourceMaster.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart#addBusinessFilterSourceMaster(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSourceMaster(ViewerFilter filter) {
		sourceMaster.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.GlobalizeComponent_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
