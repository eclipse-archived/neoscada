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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.MarkerConfigurationPropertiesEditionPart;
import org.eclipse.scada.configuration.component.providers.ComponentMessages;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
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
public class MarkerConfigurationPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, MarkerConfigurationPropertiesEditionPart {

	protected ReferencesTable markers;
	protected List<ViewerFilter> markersBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> markersFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public MarkerConfigurationPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MarkerConfigurationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence markerConfigurationStep = new BindingCompositionSequence(propertiesEditionComponent);
		markerConfigurationStep
			.addStep(ComponentViewsRepository.MarkerConfiguration.Properties.class)
			.addStep(ComponentViewsRepository.MarkerConfiguration.Properties.markers);
		
		
		composer = new PartComposer(markerConfigurationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.MarkerConfiguration.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.MarkerConfiguration.Properties.markers) {
					return createMarkersTableComposition(widgetFactory, parent);
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
		propertiesSection.setText(ComponentMessages.MarkerConfigurationPropertiesEditionPart_PropertiesGroupLabel);
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

	/**
	 * @param container
	 * 
	 */
	protected Composite createMarkersTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.markers = new ReferencesTable(getDescription(ComponentViewsRepository.MarkerConfiguration.Properties.markers, ComponentMessages.MarkerConfigurationPropertiesEditionPart_MarkersLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MarkerConfigurationPropertiesEditionPartForm.this, ComponentViewsRepository.MarkerConfiguration.Properties.markers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				markers.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MarkerConfigurationPropertiesEditionPartForm.this, ComponentViewsRepository.MarkerConfiguration.Properties.markers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				markers.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MarkerConfigurationPropertiesEditionPartForm.this, ComponentViewsRepository.MarkerConfiguration.Properties.markers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				markers.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MarkerConfigurationPropertiesEditionPartForm.this, ComponentViewsRepository.MarkerConfiguration.Properties.markers, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				markers.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.markersFilters) {
			this.markers.addFilter(filter);
		}
		this.markers.setHelpText(propertiesEditionComponent.getHelpContent(ComponentViewsRepository.MarkerConfiguration.Properties.markers, ComponentViewsRepository.FORM_KIND));
		this.markers.createControls(parent, widgetFactory);
		this.markers.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MarkerConfigurationPropertiesEditionPartForm.this, ComponentViewsRepository.MarkerConfiguration.Properties.markers, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData markersData = new GridData(GridData.FILL_HORIZONTAL);
		markersData.horizontalSpan = 3;
		this.markers.setLayoutData(markersData);
		this.markers.setLowerBound(0);
		this.markers.setUpperBound(-1);
		markers.setID(ComponentViewsRepository.MarkerConfiguration.Properties.markers);
		markers.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createMarkersTableComposition

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
	 * @see org.eclipse.scada.configuration.component.parts.MarkerConfigurationPropertiesEditionPart#initMarkers(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initMarkers(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		markers.setContentProvider(contentProvider);
		markers.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.MarkerConfiguration.Properties.markers);
		if (eefElementEditorReadOnlyState && markers.isEnabled()) {
			markers.setEnabled(false);
			markers.setToolTipText(ComponentMessages.MarkerConfiguration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !markers.isEnabled()) {
			markers.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.MarkerConfigurationPropertiesEditionPart#updateMarkers()
	 * 
	 */
	public void updateMarkers() {
	markers.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.MarkerConfigurationPropertiesEditionPart#addFilterMarkers(ViewerFilter filter)
	 * 
	 */
	public void addFilterToMarkers(ViewerFilter filter) {
		markersFilters.add(filter);
		if (this.markers != null) {
			this.markers.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.MarkerConfigurationPropertiesEditionPart#addBusinessFilterMarkers(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToMarkers(ViewerFilter filter) {
		markersBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.MarkerConfigurationPropertiesEditionPart#isContainedInMarkersTable(EObject element)
	 * 
	 */
	public boolean isContainedInMarkersTable(EObject element) {
		return ((ReferencesTableSettings)markers.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.MarkerConfiguration_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
