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
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.SummariesConfigurationPropertiesEditionPart;
import org.eclipse.scada.configuration.component.providers.ComponentMessages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
public class SummariesConfigurationPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, SummariesConfigurationPropertiesEditionPart {

	protected Text itemThreshold;



	/**
	 * For {@link ISection} use only.
	 */
	public SummariesConfigurationPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SummariesConfigurationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence summariesConfigurationStep = new BindingCompositionSequence(propertiesEditionComponent);
		summariesConfigurationStep
			.addStep(ComponentViewsRepository.SummariesConfiguration.Properties.class)
			.addStep(ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold);
		
		
		composer = new PartComposer(summariesConfigurationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.SummariesConfiguration.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold) {
					return createItemThresholdText(widgetFactory, parent);
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
		propertiesSection.setText(ComponentMessages.SummariesConfigurationPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createItemThresholdText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold, ComponentMessages.SummariesConfigurationPropertiesEditionPart_ItemThresholdLabel);
		itemThreshold = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		itemThreshold.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData itemThresholdData = new GridData(GridData.FILL_HORIZONTAL);
		itemThreshold.setLayoutData(itemThresholdData);
		itemThreshold.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							SummariesConfigurationPropertiesEditionPartForm.this,
							ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, itemThreshold.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									SummariesConfigurationPropertiesEditionPartForm.this,
									ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, itemThreshold.getText()));
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
									SummariesConfigurationPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		itemThreshold.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SummariesConfigurationPropertiesEditionPartForm.this, ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, itemThreshold.getText()));
				}
			}
		});
		EditingUtils.setID(itemThreshold, ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold);
		EditingUtils.setEEFtype(itemThreshold, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createItemThresholdText

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
	 * @see org.eclipse.scada.configuration.component.parts.SummariesConfigurationPropertiesEditionPart#getItemThreshold()
	 * 
	 */
	public String getItemThreshold() {
		return itemThreshold.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.SummariesConfigurationPropertiesEditionPart#setItemThreshold(String newValue)
	 * 
	 */
	public void setItemThreshold(String newValue) {
		if (newValue != null) {
			itemThreshold.setText(newValue);
		} else {
			itemThreshold.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold);
		if (eefElementEditorReadOnlyState && itemThreshold.isEnabled()) {
			itemThreshold.setEnabled(false);
			itemThreshold.setToolTipText(ComponentMessages.SummariesConfiguration_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !itemThreshold.isEnabled()) {
			itemThreshold.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.SummariesConfiguration_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
