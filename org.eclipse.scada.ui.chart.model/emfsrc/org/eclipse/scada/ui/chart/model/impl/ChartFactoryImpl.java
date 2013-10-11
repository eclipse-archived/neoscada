/**
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution
 */
package org.eclipse.scada.ui.chart.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.scada.ui.chart.model.*;

import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChartFactoryImpl extends EFactoryImpl implements ChartFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ChartFactory init() {
		try {
			ChartFactory theChartFactory = (ChartFactory) EPackage.Registry.INSTANCE
					.getEFactory(ChartPackage.eNS_URI);
			if (theChartFactory != null) {
				return theChartFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ChartFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChartFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ChartPackage.CHART:
			return createChart();
		case ChartPackage.XAXIS:
			return createXAxis();
		case ChartPackage.YAXIS:
			return createYAxis();
		case ChartPackage.DATA_ITEM_SERIES:
			return createDataItemSeries();
		case ChartPackage.ARCHIVE_SERIES:
			return createArchiveSeries();
		case ChartPackage.URI_ITEM:
			return createUriItem();
		case ChartPackage.ID_ITEM:
			return createIdItem();
		case ChartPackage.ARCHIVE_CHANNEL:
			return createArchiveChannel();
		case ChartPackage.LINE_PROPERTIES:
			return createLineProperties();
		case ChartPackage.SCRIPT_SERIES:
			return createScriptSeries();
		case ChartPackage.CURRENT_TIME_CONTROLLER:
			return createCurrentTimeController();
		case ChartPackage.PROFILE:
			return createProfile();
		case ChartPackage.TIME_SHIFT_ACTION:
			return createTimeShiftAction();
		case ChartPackage.TIME_NOW_ACTION:
			return createTimeNowAction();
		case ChartPackage.SCALE_ACTION:
			return createScaleAction();
		case ChartPackage.SEPARATOR_CONTROLLER:
			return createSeparatorController();
		case ChartPackage.MOUSE_CONTROLLER:
			return createMouseController();
		case ChartPackage.RESET_CONTROLLER:
			return createResetController();
		case ChartPackage.COMPOSITE_ARCHIVE_QUALITY_SERIES:
			return createCompositeArchiveQualitySeries();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case ChartPackage.PROFILE_SWITCHER_TYPE:
			return createProfileSwitcherTypeFromString(eDataType, initialValue);
		case ChartPackage.RGB:
			return createRGBFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case ChartPackage.PROFILE_SWITCHER_TYPE:
			return convertProfileSwitcherTypeToString(eDataType, instanceValue);
		case ChartPackage.RGB:
			return convertRGBToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Chart createChart() {
		ChartImpl chart = new ChartImpl();
		return chart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XAxis createXAxis() {
		XAxisImpl xAxis = new XAxisImpl();
		return xAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YAxis createYAxis() {
		YAxisImpl yAxis = new YAxisImpl();
		return yAxis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataItemSeries createDataItemSeries() {
		DataItemSeriesImpl dataItemSeries = new DataItemSeriesImpl();
		return dataItemSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchiveSeries createArchiveSeries() {
		ArchiveSeriesImpl archiveSeries = new ArchiveSeriesImpl();
		return archiveSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UriItem createUriItem() {
		UriItemImpl uriItem = new UriItemImpl();
		return uriItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdItem createIdItem() {
		IdItemImpl idItem = new IdItemImpl();
		return idItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchiveChannel createArchiveChannel() {
		ArchiveChannelImpl archiveChannel = new ArchiveChannelImpl();
		return archiveChannel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineProperties createLineProperties() {
		LinePropertiesImpl lineProperties = new LinePropertiesImpl();
		return lineProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScriptSeries createScriptSeries() {
		ScriptSeriesImpl scriptSeries = new ScriptSeriesImpl();
		return scriptSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CurrentTimeController createCurrentTimeController() {
		CurrentTimeControllerImpl currentTimeController = new CurrentTimeControllerImpl();
		return currentTimeController;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile createProfile() {
		ProfileImpl profile = new ProfileImpl();
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeShiftAction createTimeShiftAction() {
		TimeShiftActionImpl timeShiftAction = new TimeShiftActionImpl();
		return timeShiftAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeNowAction createTimeNowAction() {
		TimeNowActionImpl timeNowAction = new TimeNowActionImpl();
		return timeNowAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaleAction createScaleAction() {
		ScaleActionImpl scaleAction = new ScaleActionImpl();
		return scaleAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeparatorController createSeparatorController() {
		SeparatorControllerImpl separatorController = new SeparatorControllerImpl();
		return separatorController;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MouseController createMouseController() {
		MouseControllerImpl mouseController = new MouseControllerImpl();
		return mouseController;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResetController createResetController() {
		ResetControllerImpl resetController = new ResetControllerImpl();
		return resetController;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeArchiveQualitySeries createCompositeArchiveQualitySeries() {
		CompositeArchiveQualitySeriesImpl compositeArchiveQualitySeries = new CompositeArchiveQualitySeriesImpl();
		return compositeArchiveQualitySeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProfileSwitcherType createProfileSwitcherTypeFromString(
			EDataType eDataType, String initialValue) {
		ProfileSwitcherType result = ProfileSwitcherType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProfileSwitcherTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RGB createRGBFromString(EDataType eDataType, String initialValue) {
		return (RGB) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRGBToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChartPackage getChartPackage() {
		return (ChartPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ChartPackage getPackage() {
		return ChartPackage.eINSTANCE;
	}

} //ChartFactoryImpl
