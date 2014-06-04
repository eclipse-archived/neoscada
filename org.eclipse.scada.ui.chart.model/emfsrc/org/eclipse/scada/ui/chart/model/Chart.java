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
package org.eclipse.scada.ui.chart.model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Chart</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#isShowCurrentTimeRuler <em>Show Current Time Ruler</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getBottom <em>Bottom</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getTop <em>Top</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getRight <em>Right</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getSelectedYAxis <em>Selected YAxis</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getSelectedXAxis <em>Selected XAxis</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#isMutable <em>Mutable</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getControllers <em>Controllers</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#isHoverable <em>Hoverable</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getActiveProfile <em>Active Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getProfileSwitcherType <em>Profile Switcher Type</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.Chart#getTimeRulerAxis <em>Time Ruler Axis</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart()
 * @model
 * @generated
 */
public interface Chart extends EObject
{
    /**
     * Returns the value of the '<em><b>Title</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Title</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Title</em>' attribute.
     * @see #setTitle(String)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Title()
     * @model
     * @generated
     */
    String getTitle ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Chart#getTitle <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Title</em>' attribute.
     * @see #getTitle()
     * @generated
     */
    void setTitle ( String value );

    /**
     * Returns the value of the '<em><b>Show Current Time Ruler</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Show Current Time Ruler</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Show Current Time Ruler</em>' attribute.
     * @see #setShowCurrentTimeRuler(boolean)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_ShowCurrentTimeRuler()
     * @model default="true" required="true"
     * @generated
     */
    boolean isShowCurrentTimeRuler ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Chart#isShowCurrentTimeRuler <em>Show Current Time Ruler</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Show Current Time Ruler</em>' attribute.
     * @see #isShowCurrentTimeRuler()
     * @generated
     */
    void setShowCurrentTimeRuler ( boolean value );

    /**
     * Returns the value of the '<em><b>Background Color</b></em>' attribute.
     * The default value is <code>"#FFFFFF"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Background Color</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Background Color</em>' attribute.
     * @see #setBackgroundColor(RGB)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_BackgroundColor()
     * @model default="#FFFFFF" dataType="org.eclipse.scada.ui.chart.model.RGB" required="true"
     *        extendedMetaData="name='backgroundColor'"
     * @generated
     */
    RGB getBackgroundColor ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Chart#getBackgroundColor <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Background Color</em>' attribute.
     * @see #getBackgroundColor()
     * @generated
     */
    void setBackgroundColor ( RGB value );

    /**
     * Returns the value of the '<em><b>Bottom</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.XAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Bottom</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Bottom</em>' containment reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Bottom()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<XAxis> getBottom ();

    /**
     * Returns the value of the '<em><b>Top</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.XAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Top</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Top</em>' containment reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Top()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<XAxis> getTop ();

    /**
     * Returns the value of the '<em><b>Left</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.YAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Left</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Left</em>' containment reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Left()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<YAxis> getLeft ();

    /**
     * Returns the value of the '<em><b>Right</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.YAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Right</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Right</em>' containment reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Right()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<YAxis> getRight ();

    /**
     * Returns the value of the '<em><b>Selected YAxis</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.YAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selected YAxis</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selected YAxis</em>' reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_SelectedYAxis()
     * @model
     * @generated
     */
    EList<YAxis> getSelectedYAxis ();

    /**
     * Returns the value of the '<em><b>Selected XAxis</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.XAxis}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selected XAxis</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selected XAxis</em>' reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_SelectedXAxis()
     * @model
     * @generated
     */
    EList<XAxis> getSelectedXAxis ();

    /**
     * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.DataSeries}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inputs</em>' containment reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Inputs()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<DataSeries> getInputs ();

    /**
     * Returns the value of the '<em><b>Mutable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mutable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mutable</em>' attribute.
     * @see #setMutable(boolean)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Mutable()
     * @model default="true" required="true"
     * @generated
     */
    boolean isMutable ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Chart#isMutable <em>Mutable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mutable</em>' attribute.
     * @see #isMutable()
     * @generated
     */
    void setMutable ( boolean value );

    /**
     * Returns the value of the '<em><b>Controllers</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.Controller}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Controllers</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Controllers</em>' containment reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Controllers()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Controller> getControllers ();

    /**
     * Returns the value of the '<em><b>Hoverable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hoverable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hoverable</em>' attribute.
     * @see #setHoverable(boolean)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Hoverable()
     * @model default="true" required="true"
     * @generated
     */
    boolean isHoverable ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Chart#isHoverable <em>Hoverable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Hoverable</em>' attribute.
     * @see #isHoverable()
     * @generated
     */
    void setHoverable ( boolean value );

    /**
     * Returns the value of the '<em><b>Profiles</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.ui.chart.model.Profile}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Profiles</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Profiles</em>' containment reference list.
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_Profiles()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Profile> getProfiles ();

    /**
     * Returns the value of the '<em><b>Active Profile</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Active Profile</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Active Profile</em>' reference.
     * @see #setActiveProfile(Profile)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_ActiveProfile()
     * @model
     * @generated
     */
    Profile getActiveProfile ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Chart#getActiveProfile <em>Active Profile</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Active Profile</em>' reference.
     * @see #getActiveProfile()
     * @generated
     */
    void setActiveProfile ( Profile value );

    /**
     * Returns the value of the '<em><b>Profile Switcher Type</b></em>' attribute.
     * The default value is <code>"BUTTON"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.ui.chart.model.ProfileSwitcherType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Profile Switcher Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Profile Switcher Type</em>' attribute.
     * @see org.eclipse.scada.ui.chart.model.ProfileSwitcherType
     * @see #setProfileSwitcherType(ProfileSwitcherType)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_ProfileSwitcherType()
     * @model default="BUTTON" required="true"
     * @generated
     */
    ProfileSwitcherType getProfileSwitcherType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Chart#getProfileSwitcherType <em>Profile Switcher Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Profile Switcher Type</em>' attribute.
     * @see org.eclipse.scada.ui.chart.model.ProfileSwitcherType
     * @see #getProfileSwitcherType()
     * @generated
     */
    void setProfileSwitcherType ( ProfileSwitcherType value );

    /**
     * Returns the value of the '<em><b>Time Ruler Axis</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Time Ruler Axis</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Time Ruler Axis</em>' reference.
     * @see #setTimeRulerAxis(XAxis)
     * @see org.eclipse.scada.ui.chart.model.ChartPackage#getChart_TimeRulerAxis()
     * @model
     * @generated
     */
    XAxis getTimeRulerAxis ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.ui.chart.model.Chart#getTimeRulerAxis <em>Time Ruler Axis</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Time Ruler Axis</em>' reference.
     * @see #getTimeRulerAxis()
     * @generated
     */
    void setTimeRulerAxis ( XAxis value );

} // Chart
