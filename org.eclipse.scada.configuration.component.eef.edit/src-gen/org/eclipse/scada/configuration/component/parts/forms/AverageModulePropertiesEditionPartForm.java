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
import org.eclipse.scada.configuration.component.parts.AverageModulePropertiesEditionPart;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
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
public class AverageModulePropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, AverageModulePropertiesEditionPart {

	protected Text validSourcesRequired;



	/**
	 * For {@link ISection} use only.
	 */
	public AverageModulePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AverageModulePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence averageModuleStep = new BindingCompositionSequence(propertiesEditionComponent);
		averageModuleStep
			.addStep(ComponentViewsRepository.AverageModule.Properties.class)
			.addStep(ComponentViewsRepository.AverageModule.Properties.validSourcesRequired);
		
		
		composer = new PartComposer(averageModuleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.AverageModule.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == ComponentViewsRepository.AverageModule.Properties.validSourcesRequired) {
					return createValidSourcesRequiredText(widgetFactory, parent);
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
		propertiesSection.setText(ComponentMessages.AverageModulePropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createValidSourcesRequiredText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, ComponentViewsRepository.AverageModule.Properties.validSourcesRequired, ComponentMessages.AverageModulePropertiesEditionPart_ValidSourcesRequiredLabel);
		validSourcesRequired = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		validSourcesRequired.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData validSourcesRequiredData = new GridData(GridData.FILL_HORIZONTAL);
		validSourcesRequired.setLayoutData(validSourcesRequiredData);
		validSourcesRequired.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							AverageModulePropertiesEditionPartForm.this,
							ComponentViewsRepository.AverageModule.Properties.validSourcesRequired,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, validSourcesRequired.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									AverageModulePropertiesEditionPartForm.this,
									ComponentViewsRepository.AverageModule.Properties.validSourcesRequired,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, validSourcesRequired.getText()));
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
									AverageModulePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		validSourcesRequired.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AverageModulePropertiesEditionPartForm.this, ComponentViewsRepository.AverageModule.Properties.validSourcesRequired, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, validSourcesRequired.getText()));
				}
			}
		});
		EditingUtils.setID(validSourcesRequired, ComponentViewsRepository.AverageModule.Properties.validSourcesRequired);
		EditingUtils.setEEFtype(validSourcesRequired, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.AverageModule.Properties.validSourcesRequired, ComponentViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createValidSourcesRequiredText

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
	 * @see org.eclipse.scada.configuration.component.parts.AverageModulePropertiesEditionPart#getValidSourcesRequired()
	 * 
	 */
	public String getValidSourcesRequired() {
		return validSourcesRequired.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.AverageModulePropertiesEditionPart#setValidSourcesRequired(String newValue)
	 * 
	 */
	public void setValidSourcesRequired(String newValue) {
		if (newValue != null) {
			validSourcesRequired.setText(newValue);
		} else {
			validSourcesRequired.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.AverageModule.Properties.validSourcesRequired);
		if (eefElementEditorReadOnlyState && validSourcesRequired.isEnabled()) {
			validSourcesRequired.setEnabled(false);
			validSourcesRequired.setToolTipText(ComponentMessages.AverageModule_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !validSourcesRequired.isEnabled()) {
			validSourcesRequired.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.AverageModule_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
