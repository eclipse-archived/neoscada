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
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class AverageModulePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AverageModulePropertiesEditionPart {

	protected Text validSourcesRequired;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AverageModulePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence averageModuleStep = new BindingCompositionSequence(propertiesEditionComponent);
		averageModuleStep
			.addStep(ComponentViewsRepository.AverageModule.Properties.class)
			.addStep(ComponentViewsRepository.AverageModule.Properties.validSourcesRequired);
		
		
		composer = new PartComposer(averageModuleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.AverageModule.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ComponentViewsRepository.AverageModule.Properties.validSourcesRequired) {
					return createValidSourcesRequiredText(parent);
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
		propertiesGroup.setText(ComponentMessages.AverageModulePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createValidSourcesRequiredText(Composite parent) {
		createDescription(parent, ComponentViewsRepository.AverageModule.Properties.validSourcesRequired, ComponentMessages.AverageModulePropertiesEditionPart_ValidSourcesRequiredLabel);
		validSourcesRequired = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData validSourcesRequiredData = new GridData(GridData.FILL_HORIZONTAL);
		validSourcesRequired.setLayoutData(validSourcesRequiredData);
		validSourcesRequired.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AverageModulePropertiesEditionPartImpl.this, ComponentViewsRepository.AverageModule.Properties.validSourcesRequired, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, validSourcesRequired.getText()));
			}

		});
		validSourcesRequired.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AverageModulePropertiesEditionPartImpl.this, ComponentViewsRepository.AverageModule.Properties.validSourcesRequired, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, validSourcesRequired.getText()));
				}
			}

		});
		EditingUtils.setID(validSourcesRequired, ComponentViewsRepository.AverageModule.Properties.validSourcesRequired);
		EditingUtils.setEEFtype(validSourcesRequired, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.AverageModule.Properties.validSourcesRequired, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
