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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.Controller;
import org.eclipse.scada.ui.chart.model.DataSeries;
import org.eclipse.scada.ui.chart.model.Profile;
import org.eclipse.scada.ui.chart.model.ProfileSwitcherType;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;
import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Chart</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#isShowCurrentTimeRuler <em>Show Current Time Ruler</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getBottom <em>Bottom</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getTop <em>Top</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getLeft <em>Left</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getRight <em>Right</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getSelectedYAxis <em>Selected YAxis</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getSelectedXAxis <em>Selected XAxis</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#isMutable <em>Mutable</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getControllers <em>Controllers</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#isHoverable <em>Hoverable</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getProfiles <em>Profiles</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getActiveProfile <em>Active Profile</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getProfileSwitcherType <em>Profile Switcher Type</em>}</li>
 *   <li>{@link org.eclipse.scada.ui.chart.model.impl.ChartImpl#getTimeRulerAxis <em>Time Ruler Axis</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChartImpl extends EObjectImpl implements Chart
{
    /**
     * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTitle()
     * @generated
     * @ordered
     */
    protected static final String TITLE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTitle()
     * @generated
     * @ordered
     */
    protected String title = TITLE_EDEFAULT;

    /**
     * The default value of the '{@link #isShowCurrentTimeRuler() <em>Show Current Time Ruler</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowCurrentTimeRuler()
     * @generated
     * @ordered
     */
    protected static final boolean SHOW_CURRENT_TIME_RULER_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isShowCurrentTimeRuler() <em>Show Current Time Ruler</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isShowCurrentTimeRuler()
     * @generated
     * @ordered
     */
    protected boolean showCurrentTimeRuler = SHOW_CURRENT_TIME_RULER_EDEFAULT;

    /**
     * The default value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final RGB BACKGROUND_COLOR_EDEFAULT = (RGB)ChartFactory.eINSTANCE.createFromString ( ChartPackage.eINSTANCE.getRGB (), "#FFFFFF" ); //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected RGB backgroundColor = BACKGROUND_COLOR_EDEFAULT;

    /**
     * The cached value of the '{@link #getBottom() <em>Bottom</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBottom()
     * @generated
     * @ordered
     */
    protected EList<XAxis> bottom;

    /**
     * The cached value of the '{@link #getTop() <em>Top</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTop()
     * @generated
     * @ordered
     */
    protected EList<XAxis> top;

    /**
     * The cached value of the '{@link #getLeft() <em>Left</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLeft()
     * @generated
     * @ordered
     */
    protected EList<YAxis> left;

    /**
     * The cached value of the '{@link #getRight() <em>Right</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRight()
     * @generated
     * @ordered
     */
    protected EList<YAxis> right;

    /**
     * The cached value of the '{@link #getSelectedYAxis() <em>Selected YAxis</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectedYAxis()
     * @generated
     * @ordered
     */
    protected EList<YAxis> selectedYAxis;

    /**
     * The cached value of the '{@link #getSelectedXAxis() <em>Selected XAxis</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectedXAxis()
     * @generated
     * @ordered
     */
    protected EList<XAxis> selectedXAxis;

    /**
     * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputs()
     * @generated
     * @ordered
     */
    protected EList<DataSeries> inputs;

    /**
     * The default value of the '{@link #isMutable() <em>Mutable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isMutable()
     * @generated
     * @ordered
     */
    protected static final boolean MUTABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isMutable() <em>Mutable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isMutable()
     * @generated
     * @ordered
     */
    protected boolean mutable = MUTABLE_EDEFAULT;

    /**
     * The cached value of the '{@link #getControllers() <em>Controllers</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getControllers()
     * @generated
     * @ordered
     */
    protected EList<Controller> controllers;

    /**
     * The default value of the '{@link #isHoverable() <em>Hoverable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isHoverable()
     * @generated
     * @ordered
     */
    protected static final boolean HOVERABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isHoverable() <em>Hoverable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isHoverable()
     * @generated
     * @ordered
     */
    protected boolean hoverable = HOVERABLE_EDEFAULT;

    /**
     * The cached value of the '{@link #getProfiles() <em>Profiles</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProfiles()
     * @generated
     * @ordered
     */
    protected EList<Profile> profiles;

    /**
     * The cached value of the '{@link #getActiveProfile() <em>Active Profile</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getActiveProfile()
     * @generated
     * @ordered
     */
    protected Profile activeProfile;

    /**
     * The default value of the '{@link #getProfileSwitcherType() <em>Profile Switcher Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProfileSwitcherType()
     * @generated
     * @ordered
     */
    protected static final ProfileSwitcherType PROFILE_SWITCHER_TYPE_EDEFAULT = ProfileSwitcherType.BUTTON;

    /**
     * The cached value of the '{@link #getProfileSwitcherType() <em>Profile Switcher Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProfileSwitcherType()
     * @generated
     * @ordered
     */
    protected ProfileSwitcherType profileSwitcherType = PROFILE_SWITCHER_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getTimeRulerAxis() <em>Time Ruler Axis</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeRulerAxis()
     * @generated
     * @ordered
     */
    protected XAxis timeRulerAxis;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ChartImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return ChartPackage.Literals.CHART;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getTitle ()
    {
        return title;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTitle ( String newTitle )
    {
        String oldTitle = title;
        title = newTitle;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__TITLE, oldTitle, title ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isShowCurrentTimeRuler ()
    {
        return showCurrentTimeRuler;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShowCurrentTimeRuler ( boolean newShowCurrentTimeRuler )
    {
        boolean oldShowCurrentTimeRuler = showCurrentTimeRuler;
        showCurrentTimeRuler = newShowCurrentTimeRuler;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__SHOW_CURRENT_TIME_RULER, oldShowCurrentTimeRuler, showCurrentTimeRuler ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RGB getBackgroundColor ()
    {
        return backgroundColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBackgroundColor ( RGB newBackgroundColor )
    {
        RGB oldBackgroundColor = backgroundColor;
        backgroundColor = newBackgroundColor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<XAxis> getBottom ()
    {
        if ( bottom == null )
        {
            bottom = new EObjectContainmentEList.Resolving<XAxis> ( XAxis.class, this, ChartPackage.CHART__BOTTOM );
        }
        return bottom;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<XAxis> getTop ()
    {
        if ( top == null )
        {
            top = new EObjectContainmentEList.Resolving<XAxis> ( XAxis.class, this, ChartPackage.CHART__TOP );
        }
        return top;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<YAxis> getLeft ()
    {
        if ( left == null )
        {
            left = new EObjectContainmentEList.Resolving<YAxis> ( YAxis.class, this, ChartPackage.CHART__LEFT );
        }
        return left;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<YAxis> getRight ()
    {
        if ( right == null )
        {
            right = new EObjectContainmentEList.Resolving<YAxis> ( YAxis.class, this, ChartPackage.CHART__RIGHT );
        }
        return right;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<YAxis> getSelectedYAxis ()
    {
        if ( selectedYAxis == null )
        {
            selectedYAxis = new EObjectResolvingEList<YAxis> ( YAxis.class, this, ChartPackage.CHART__SELECTED_YAXIS );
        }
        return selectedYAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<XAxis> getSelectedXAxis ()
    {
        if ( selectedXAxis == null )
        {
            selectedXAxis = new EObjectResolvingEList<XAxis> ( XAxis.class, this, ChartPackage.CHART__SELECTED_XAXIS );
        }
        return selectedXAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataSeries> getInputs ()
    {
        if ( inputs == null )
        {
            inputs = new EObjectContainmentEList.Resolving<DataSeries> ( DataSeries.class, this, ChartPackage.CHART__INPUTS );
        }
        return inputs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isMutable ()
    {
        return mutable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMutable ( boolean newMutable )
    {
        boolean oldMutable = mutable;
        mutable = newMutable;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__MUTABLE, oldMutable, mutable ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Controller> getControllers ()
    {
        if ( controllers == null )
        {
            controllers = new EObjectContainmentEList.Resolving<Controller> ( Controller.class, this, ChartPackage.CHART__CONTROLLERS );
        }
        return controllers;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isHoverable ()
    {
        return hoverable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setHoverable ( boolean newHoverable )
    {
        boolean oldHoverable = hoverable;
        hoverable = newHoverable;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__HOVERABLE, oldHoverable, hoverable ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Profile> getProfiles ()
    {
        if ( profiles == null )
        {
            profiles = new EObjectContainmentEList.Resolving<Profile> ( Profile.class, this, ChartPackage.CHART__PROFILES );
        }
        return profiles;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Profile getActiveProfile ()
    {
        if ( activeProfile != null && activeProfile.eIsProxy () )
        {
            InternalEObject oldActiveProfile = (InternalEObject)activeProfile;
            activeProfile = (Profile)eResolveProxy ( oldActiveProfile );
            if ( activeProfile != oldActiveProfile )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ChartPackage.CHART__ACTIVE_PROFILE, oldActiveProfile, activeProfile ) );
            }
        }
        return activeProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Profile basicGetActiveProfile ()
    {
        return activeProfile;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setActiveProfile ( Profile newActiveProfile )
    {
        Profile oldActiveProfile = activeProfile;
        activeProfile = newActiveProfile;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__ACTIVE_PROFILE, oldActiveProfile, activeProfile ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProfileSwitcherType getProfileSwitcherType ()
    {
        return profileSwitcherType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProfileSwitcherType (
            ProfileSwitcherType newProfileSwitcherType )
    {
        ProfileSwitcherType oldProfileSwitcherType = profileSwitcherType;
        profileSwitcherType = newProfileSwitcherType == null ? PROFILE_SWITCHER_TYPE_EDEFAULT : newProfileSwitcherType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__PROFILE_SWITCHER_TYPE, oldProfileSwitcherType, profileSwitcherType ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XAxis getTimeRulerAxis ()
    {
        if ( timeRulerAxis != null && timeRulerAxis.eIsProxy () )
        {
            InternalEObject oldTimeRulerAxis = (InternalEObject)timeRulerAxis;
            timeRulerAxis = (XAxis)eResolveProxy ( oldTimeRulerAxis );
            if ( timeRulerAxis != oldTimeRulerAxis )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ChartPackage.CHART__TIME_RULER_AXIS, oldTimeRulerAxis, timeRulerAxis ) );
            }
        }
        return timeRulerAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public XAxis basicGetTimeRulerAxis ()
    {
        return timeRulerAxis;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimeRulerAxis ( XAxis newTimeRulerAxis )
    {
        XAxis oldTimeRulerAxis = timeRulerAxis;
        timeRulerAxis = newTimeRulerAxis;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ChartPackage.CHART__TIME_RULER_AXIS, oldTimeRulerAxis, timeRulerAxis ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd,
            int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__BOTTOM:
                return ( (InternalEList<?>)getBottom () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__TOP:
                return ( (InternalEList<?>)getTop () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__LEFT:
                return ( (InternalEList<?>)getLeft () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__RIGHT:
                return ( (InternalEList<?>)getRight () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__INPUTS:
                return ( (InternalEList<?>)getInputs () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__CONTROLLERS:
                return ( (InternalEList<?>)getControllers () ).basicRemove ( otherEnd, msgs );
            case ChartPackage.CHART__PROFILES:
                return ( (InternalEList<?>)getProfiles () ).basicRemove ( otherEnd, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__TITLE:
                return getTitle ();
            case ChartPackage.CHART__SHOW_CURRENT_TIME_RULER:
                return isShowCurrentTimeRuler ();
            case ChartPackage.CHART__BACKGROUND_COLOR:
                return getBackgroundColor ();
            case ChartPackage.CHART__BOTTOM:
                return getBottom ();
            case ChartPackage.CHART__TOP:
                return getTop ();
            case ChartPackage.CHART__LEFT:
                return getLeft ();
            case ChartPackage.CHART__RIGHT:
                return getRight ();
            case ChartPackage.CHART__SELECTED_YAXIS:
                return getSelectedYAxis ();
            case ChartPackage.CHART__SELECTED_XAXIS:
                return getSelectedXAxis ();
            case ChartPackage.CHART__INPUTS:
                return getInputs ();
            case ChartPackage.CHART__MUTABLE:
                return isMutable ();
            case ChartPackage.CHART__CONTROLLERS:
                return getControllers ();
            case ChartPackage.CHART__HOVERABLE:
                return isHoverable ();
            case ChartPackage.CHART__PROFILES:
                return getProfiles ();
            case ChartPackage.CHART__ACTIVE_PROFILE:
                if ( resolve )
                    return getActiveProfile ();
                return basicGetActiveProfile ();
            case ChartPackage.CHART__PROFILE_SWITCHER_TYPE:
                return getProfileSwitcherType ();
            case ChartPackage.CHART__TIME_RULER_AXIS:
                if ( resolve )
                    return getTimeRulerAxis ();
                return basicGetTimeRulerAxis ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__TITLE:
                setTitle ( (String)newValue );
                return;
            case ChartPackage.CHART__SHOW_CURRENT_TIME_RULER:
                setShowCurrentTimeRuler ( (Boolean)newValue );
                return;
            case ChartPackage.CHART__BACKGROUND_COLOR:
                setBackgroundColor ( (RGB)newValue );
                return;
            case ChartPackage.CHART__BOTTOM:
                getBottom ().clear ();
                getBottom ().addAll ( (Collection<? extends XAxis>)newValue );
                return;
            case ChartPackage.CHART__TOP:
                getTop ().clear ();
                getTop ().addAll ( (Collection<? extends XAxis>)newValue );
                return;
            case ChartPackage.CHART__LEFT:
                getLeft ().clear ();
                getLeft ().addAll ( (Collection<? extends YAxis>)newValue );
                return;
            case ChartPackage.CHART__RIGHT:
                getRight ().clear ();
                getRight ().addAll ( (Collection<? extends YAxis>)newValue );
                return;
            case ChartPackage.CHART__SELECTED_YAXIS:
                getSelectedYAxis ().clear ();
                getSelectedYAxis ().addAll ( (Collection<? extends YAxis>)newValue );
                return;
            case ChartPackage.CHART__SELECTED_XAXIS:
                getSelectedXAxis ().clear ();
                getSelectedXAxis ().addAll ( (Collection<? extends XAxis>)newValue );
                return;
            case ChartPackage.CHART__INPUTS:
                getInputs ().clear ();
                getInputs ().addAll ( (Collection<? extends DataSeries>)newValue );
                return;
            case ChartPackage.CHART__MUTABLE:
                setMutable ( (Boolean)newValue );
                return;
            case ChartPackage.CHART__CONTROLLERS:
                getControllers ().clear ();
                getControllers ().addAll ( (Collection<? extends Controller>)newValue );
                return;
            case ChartPackage.CHART__HOVERABLE:
                setHoverable ( (Boolean)newValue );
                return;
            case ChartPackage.CHART__PROFILES:
                getProfiles ().clear ();
                getProfiles ().addAll ( (Collection<? extends Profile>)newValue );
                return;
            case ChartPackage.CHART__ACTIVE_PROFILE:
                setActiveProfile ( (Profile)newValue );
                return;
            case ChartPackage.CHART__PROFILE_SWITCHER_TYPE:
                setProfileSwitcherType ( (ProfileSwitcherType)newValue );
                return;
            case ChartPackage.CHART__TIME_RULER_AXIS:
                setTimeRulerAxis ( (XAxis)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__TITLE:
                setTitle ( TITLE_EDEFAULT );
                return;
            case ChartPackage.CHART__SHOW_CURRENT_TIME_RULER:
                setShowCurrentTimeRuler ( SHOW_CURRENT_TIME_RULER_EDEFAULT );
                return;
            case ChartPackage.CHART__BACKGROUND_COLOR:
                setBackgroundColor ( BACKGROUND_COLOR_EDEFAULT );
                return;
            case ChartPackage.CHART__BOTTOM:
                getBottom ().clear ();
                return;
            case ChartPackage.CHART__TOP:
                getTop ().clear ();
                return;
            case ChartPackage.CHART__LEFT:
                getLeft ().clear ();
                return;
            case ChartPackage.CHART__RIGHT:
                getRight ().clear ();
                return;
            case ChartPackage.CHART__SELECTED_YAXIS:
                getSelectedYAxis ().clear ();
                return;
            case ChartPackage.CHART__SELECTED_XAXIS:
                getSelectedXAxis ().clear ();
                return;
            case ChartPackage.CHART__INPUTS:
                getInputs ().clear ();
                return;
            case ChartPackage.CHART__MUTABLE:
                setMutable ( MUTABLE_EDEFAULT );
                return;
            case ChartPackage.CHART__CONTROLLERS:
                getControllers ().clear ();
                return;
            case ChartPackage.CHART__HOVERABLE:
                setHoverable ( HOVERABLE_EDEFAULT );
                return;
            case ChartPackage.CHART__PROFILES:
                getProfiles ().clear ();
                return;
            case ChartPackage.CHART__ACTIVE_PROFILE:
                setActiveProfile ( (Profile)null );
                return;
            case ChartPackage.CHART__PROFILE_SWITCHER_TYPE:
                setProfileSwitcherType ( PROFILE_SWITCHER_TYPE_EDEFAULT );
                return;
            case ChartPackage.CHART__TIME_RULER_AXIS:
                setTimeRulerAxis ( (XAxis)null );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case ChartPackage.CHART__TITLE:
                return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals ( title );
            case ChartPackage.CHART__SHOW_CURRENT_TIME_RULER:
                return showCurrentTimeRuler != SHOW_CURRENT_TIME_RULER_EDEFAULT;
            case ChartPackage.CHART__BACKGROUND_COLOR:
                return BACKGROUND_COLOR_EDEFAULT == null ? backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT.equals ( backgroundColor );
            case ChartPackage.CHART__BOTTOM:
                return bottom != null && !bottom.isEmpty ();
            case ChartPackage.CHART__TOP:
                return top != null && !top.isEmpty ();
            case ChartPackage.CHART__LEFT:
                return left != null && !left.isEmpty ();
            case ChartPackage.CHART__RIGHT:
                return right != null && !right.isEmpty ();
            case ChartPackage.CHART__SELECTED_YAXIS:
                return selectedYAxis != null && !selectedYAxis.isEmpty ();
            case ChartPackage.CHART__SELECTED_XAXIS:
                return selectedXAxis != null && !selectedXAxis.isEmpty ();
            case ChartPackage.CHART__INPUTS:
                return inputs != null && !inputs.isEmpty ();
            case ChartPackage.CHART__MUTABLE:
                return mutable != MUTABLE_EDEFAULT;
            case ChartPackage.CHART__CONTROLLERS:
                return controllers != null && !controllers.isEmpty ();
            case ChartPackage.CHART__HOVERABLE:
                return hoverable != HOVERABLE_EDEFAULT;
            case ChartPackage.CHART__PROFILES:
                return profiles != null && !profiles.isEmpty ();
            case ChartPackage.CHART__ACTIVE_PROFILE:
                return activeProfile != null;
            case ChartPackage.CHART__PROFILE_SWITCHER_TYPE:
                return profileSwitcherType != PROFILE_SWITCHER_TYPE_EDEFAULT;
            case ChartPackage.CHART__TIME_RULER_AXIS:
                return timeRulerAxis != null;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (title: " ); //$NON-NLS-1$
        result.append ( title );
        result.append ( ", showCurrentTimeRuler: " ); //$NON-NLS-1$
        result.append ( showCurrentTimeRuler );
        result.append ( ", backgroundColor: " ); //$NON-NLS-1$
        result.append ( backgroundColor );
        result.append ( ", mutable: " ); //$NON-NLS-1$
        result.append ( mutable );
        result.append ( ", hoverable: " ); //$NON-NLS-1$
        result.append ( hoverable );
        result.append ( ", profileSwitcherType: " ); //$NON-NLS-1$
        result.append ( profileSwitcherType );
        result.append ( ')' );
        return result.toString ();
    }

} //ChartImpl
