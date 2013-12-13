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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class ComponentReferenceInputDefinitionPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ComponentReferenceInputDefinitionPropertiesEditionPart {

	protected Text name;
	protected EObjectFlatComboViewer component;
	protected Text localTag;
	protected Button editLocalTag;
	private EList localTagList;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ComponentReferenceInputDefinitionPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence componentReferenceInputDefinitionStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = componentReferenceInputDefinitionStep.addStep(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.class);
		propertiesStep.addStep(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.name);
		propertiesStep.addStep(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.component_);
		propertiesStep.addStep(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.localTag);
		
		
		composer = new PartComposer(componentReferenceInputDefinitionStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.name) {
					return createNameText(parent);
				}
				if (key == ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.component_) {
					return createComponentFlatComboViewer(parent);
				}
				if (key == ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.localTag) {
					return createLocalTagMultiValuedEditor(parent);
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
		propertiesGroup.setText(ComponentMessages.ComponentReferenceInputDefinitionPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		createDescription(parent, ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.name, ComponentMessages.ComponentReferenceInputDefinitionPropertiesEditionPart_NameLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentReferenceInputDefinitionPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentReferenceInputDefinitionPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.name, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * 
	 */
	protected Composite createComponentFlatComboViewer(Composite parent) {
		createDescription(parent, ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.component_, ComponentMessages.ComponentReferenceInputDefinitionPropertiesEditionPart_ComponentLabel);
		component = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.component_, ComponentViewsRepository.SWT_KIND));
		component.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		component.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentReferenceInputDefinitionPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.component_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getComponent()));
			}

		});
		GridData componentData = new GridData(GridData.FILL_HORIZONTAL);
		component.setLayoutData(componentData);
		component.setID(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.component_);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.component_, ComponentViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createComponentFlatComboViewer

		// End of user code
		return parent;
	}

	protected Composite createLocalTagMultiValuedEditor(Composite parent) {
		localTag = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData localTagData = new GridData(GridData.FILL_HORIZONTAL);
		localTagData.horizontalSpan = 2;
		localTag.setLayoutData(localTagData);
		EditingUtils.setID(localTag, ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.localTag);
		EditingUtils.setEEFtype(localTag, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editLocalTag = new Button(parent, SWT.NONE);
		editLocalTag.setText(getDescription(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.localTag, ComponentMessages.ComponentReferenceInputDefinitionPropertiesEditionPart_LocalTagLabel));
		GridData editLocalTagData = new GridData();
		editLocalTag.setLayoutData(editLocalTagData);
		editLocalTag.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						localTag.getShell(), "ComponentReferenceInputDefinition", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						localTagList, ComponentPackage.eINSTANCE.getComponentReferenceInputDefinition_LocalTag().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					localTagList = dialog.getResult();
					if (localTagList == null) {
						localTagList = new BasicEList();
					}
					localTag.setText(localTagList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComponentReferenceInputDefinitionPropertiesEditionPartImpl.this, ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.localTag, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(localTagList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editLocalTag, ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.localTag);
		EditingUtils.setEEFtype(editLocalTag, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createLocalTagMultiValuedEditor

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
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(ComponentMessages.ComponentReferenceInputDefinition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#getComponent()
	 * 
	 */
	public EObject getComponent() {
		if (component.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) component.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#initComponent(EObjectFlatComboSettings)
	 */
	public void initComponent(EObjectFlatComboSettings settings) {
		component.setInput(settings);
		if (current != null) {
			component.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.component_);
		if (eefElementEditorReadOnlyState && component.isEnabled()) {
			component.setEnabled(false);
			component.setToolTipText(ComponentMessages.ComponentReferenceInputDefinition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !component.isEnabled()) {
			component.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#setComponent(EObject newValue)
	 * 
	 */
	public void setComponent(EObject newValue) {
		if (newValue != null) {
			component.setSelection(new StructuredSelection(newValue));
		} else {
			component.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.component_);
		if (eefElementEditorReadOnlyState && component.isEnabled()) {
			component.setEnabled(false);
			component.setToolTipText(ComponentMessages.ComponentReferenceInputDefinition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !component.isEnabled()) {
			component.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#setComponentButtonMode(ButtonsModeEnum newValue)
	 */
	public void setComponentButtonMode(ButtonsModeEnum newValue) {
		component.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#addFilterComponent(ViewerFilter filter)
	 * 
	 */
	public void addFilterToComponent(ViewerFilter filter) {
		component.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#addBusinessFilterComponent(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToComponent(ViewerFilter filter) {
		component.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#getLocalTag()
	 * 
	 */
	public EList getLocalTag() {
		return localTagList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.scada.configuration.component.parts.ComponentReferenceInputDefinitionPropertiesEditionPart#setLocalTag(EList newValue)
	 * 
	 */
	public void setLocalTag(EList newValue) {
		localTagList = newValue;
		if (newValue != null) {
			localTag.setText(localTagList.toString());
		} else {
			localTag.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ComponentViewsRepository.ComponentReferenceInputDefinition.Properties.localTag);
		if (eefElementEditorReadOnlyState && localTag.isEnabled()) {
			localTag.setEnabled(false);
			localTag.setToolTipText(ComponentMessages.ComponentReferenceInputDefinition_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !localTag.isEnabled()) {
			localTag.setEnabled(true);
		}	
		
	}

	public void addToLocalTag(Object newValue) {
		localTagList.add(newValue);
		if (newValue != null) {
			localTag.setText(localTagList.toString());
		} else {
			localTag.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToLocalTag(Object newValue) {
		localTagList.remove(newValue);
		if (newValue != null) {
			localTag.setText(localTagList.toString());
		} else {
			localTag.setText(""); //$NON-NLS-1$
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ComponentMessages.ComponentReferenceInputDefinition_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
