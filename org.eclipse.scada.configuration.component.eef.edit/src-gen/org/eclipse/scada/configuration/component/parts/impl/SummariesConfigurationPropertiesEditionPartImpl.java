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
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class SummariesConfigurationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SummariesConfigurationPropertiesEditionPart {

	protected Text itemThreshold;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SummariesConfigurationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence summariesConfigurationStep = new BindingCompositionSequence(propertiesEditionComponent);
		summariesConfigurationStep
			.addStep(ComponentViewsRepository.SummariesConfiguration.Properties.class)
			.addStep(ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold);
		
		
		composer = new PartComposer(summariesConfigurationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.SummariesConfiguration.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold) {
					return createItemThresholdText(parent);
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
		propertiesGroup.setText(ComponentMessages.SummariesConfigurationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createItemThresholdText(Composite parent) {
		createDescription(parent, ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold, ComponentMessages.SummariesConfigurationPropertiesEditionPart_ItemThresholdLabel);
		itemThreshold = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData itemThresholdData = new GridData(GridData.FILL_HORIZONTAL);
		itemThreshold.setLayoutData(itemThresholdData);
		itemThreshold.addFocusListener(new FocusAdapter() {

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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SummariesConfigurationPropertiesEditionPartImpl.this, ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, itemThreshold.getText()));
			}

		});
		itemThreshold.addKeyListener(new KeyAdapter() {

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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SummariesConfigurationPropertiesEditionPartImpl.this, ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, itemThreshold.getText()));
				}
			}

		});
		EditingUtils.setID(itemThreshold, ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold);
		EditingUtils.setEEFtype(itemThreshold, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
