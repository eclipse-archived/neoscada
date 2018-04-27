/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.neoscada.configuration.iec60870;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.script.Script;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '
 * <em><b>Exporter Item Interceptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getScript <em>Script</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getProtocolOptions <em>Protocol Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getDataModuleOptions <em>Data Module Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getHiveProperties <em>Hive Properties</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getSpontaneousBufferWindow <em>Spontaneous Buffer Window</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getCyclicPeriod <em>Cyclic Period</em>}</li>
 * </ul>
 *
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getExporterItemInterceptor()
 * @model
 * @generated
 */
public interface ExporterItemInterceptor extends ItemInterceptor
{
    /**
     * Returns the value of the '<em><b>Script</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script</em>' containment reference.
     * @see #setScript(Script)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getExporterItemInterceptor_Script()
     * @model containment="true" required="true"
     * @generated
     */
    Script getScript ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getScript <em>Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' containment reference.
     * @see #getScript()
     * @generated
     */
    void setScript ( Script value );

    /**
     * Returns the value of the '<em><b>Protocol Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol Options</em>' containment reference
     * isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol Options</em>' containment reference.
     * @see #setProtocolOptions(ProtocolOptions)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getExporterItemInterceptor_ProtocolOptions()
     * @model containment="true"
     * @generated
     */
    ProtocolOptions getProtocolOptions ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getProtocolOptions <em>Protocol Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol Options</em>' containment reference.
     * @see #getProtocolOptions()
     * @generated
     */
    void setProtocolOptions ( ProtocolOptions value );

    /**
     * Returns the value of the '<em><b>Data Module Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Module Options</em>' containment
     * reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Module Options</em>' containment reference.
     * @see #setDataModuleOptions(DataModuleOptions)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getExporterItemInterceptor_DataModuleOptions()
     * @model containment="true"
     * @generated
     */
    DataModuleOptions getDataModuleOptions ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getDataModuleOptions <em>Data Module Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Module Options</em>' containment reference.
     * @see #getDataModuleOptions()
     * @generated
     */
    void setDataModuleOptions ( DataModuleOptions value );

    /**
     * Returns the value of the '<em><b>Port</b></em>' attribute.
     * The default value is <code>"2404"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Port</em>' attribute.
     * @see #setPort(short)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getExporterItemInterceptor_Port()
     * @model default="2404" required="true"
     * @generated
     */
    short getPort ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getPort <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port</em>' attribute.
     * @see #getPort()
     * @generated
     */
    void setPort ( short value );

    /**
     * Returns the value of the '<em><b>Hive Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hive Properties</em>' containment reference
     * list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hive Properties</em>' containment reference list.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getExporterItemInterceptor_HiveProperties()
     * @model containment="true"
     * @generated
     */
    EList<PropertyEntry> getHiveProperties ();

    /**
     * Returns the value of the '<em><b>Spontaneous Buffer Window</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Spontaneous Buffer Window</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Number of milliseconds used to buffer spontaneous events
     * <!-- end-model-doc -->
     * @return the value of the '<em>Spontaneous Buffer Window</em>' attribute.
     * @see #setSpontaneousBufferWindow(Long)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getExporterItemInterceptor_SpontaneousBufferWindow()
     * @model
     * @generated
     */
    Long getSpontaneousBufferWindow ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getSpontaneousBufferWindow <em>Spontaneous Buffer Window</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Spontaneous Buffer Window</em>' attribute.
     * @see #getSpontaneousBufferWindow()
     * @generated
     */
    void setSpontaneousBufferWindow ( Long value );

    /**
     * Returns the value of the '<em><b>Cyclic Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Number of milliseconds used to buffer spontaneous events
     * <!-- end-model-doc -->
     * @return the value of the '<em>Cyclic Period</em>' attribute.
     * @see #setCyclicPeriod(Long)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getExporterItemInterceptor_CyclicPeriod()
     * @model
     * @generated
     */
    Long getCyclicPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor#getCyclicPeriod <em>Cyclic Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cyclic Period</em>' attribute.
     * @see #getCyclicPeriod()
     * @generated
     */
    void setCyclicPeriod ( Long value );

} // ExporterItemInterceptor
