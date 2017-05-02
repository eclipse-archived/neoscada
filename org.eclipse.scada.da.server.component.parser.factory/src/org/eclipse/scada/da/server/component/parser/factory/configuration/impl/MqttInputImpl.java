/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.base.extractor.input.Input;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mqtt Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.MqttInputImpl#getServerUri <em>Server Uri</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.MqttInputImpl#getClientId <em>Client Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.MqttInputImpl#getTopic <em>Topic</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.MqttInputImpl#getQos <em>Qos</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MqttInputImpl extends AbstractInputImpl implements MqttInput
{
    /**
     * The default value of the '{@link #getServerUri() <em>Server Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServerUri()
     * @generated
     * @ordered
     */
    protected static final String SERVER_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getServerUri() <em>Server Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServerUri()
     * @generated
     * @ordered
     */
    protected String serverUri = SERVER_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getClientId() <em>Client Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClientId()
     * @generated
     * @ordered
     */
    protected static final String CLIENT_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getClientId() <em>Client Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClientId()
     * @generated
     * @ordered
     */
    protected String clientId = CLIENT_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getTopic() <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTopic()
     * @generated
     * @ordered
     */
    protected static final String TOPIC_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTopic() <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTopic()
     * @generated
     * @ordered
     */
    protected String topic = TOPIC_EDEFAULT;

    /**
     * The default value of the '{@link #getQos() <em>Qos</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQos()
     * @generated
     * @ordered
     */
    protected static final int QOS_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getQos() <em>Qos</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQos()
     * @generated
     * @ordered
     */
    protected int qos = QOS_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MqttInputImpl ()
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
        return ParserPackage.Literals.MQTT_INPUT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getServerUri ()
    {
        return serverUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setServerUri ( String newServerUri )
    {
        String oldServerUri = serverUri;
        serverUri = newServerUri;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.MQTT_INPUT__SERVER_URI, oldServerUri, serverUri ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getClientId ()
    {
        return clientId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setClientId ( String newClientId )
    {
        String oldClientId = clientId;
        clientId = newClientId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.MQTT_INPUT__CLIENT_ID, oldClientId, clientId ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getTopic ()
    {
        return topic;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTopic ( String newTopic )
    {
        String oldTopic = topic;
        topic = newTopic;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.MQTT_INPUT__TOPIC, oldTopic, topic ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getQos ()
    {
        return qos;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setQos ( int newQos )
    {
        int oldQos = qos;
        qos = newQos;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.MQTT_INPUT__QOS, oldQos, qos ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Input createInput ( final CreationContext creationContext )
    {
        final Input result = new org.eclipse.scada.base.extractor.mqtt.input.MqttInput ( creationContext.getExecutor (), this.serverUri, this.clientId, this.topic, this.qos );
        applyTransformers ( result, creationContext );
        return result;
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
            case ParserPackage.MQTT_INPUT__SERVER_URI:
                return getServerUri ();
            case ParserPackage.MQTT_INPUT__CLIENT_ID:
                return getClientId ();
            case ParserPackage.MQTT_INPUT__TOPIC:
                return getTopic ();
            case ParserPackage.MQTT_INPUT__QOS:
                return getQos ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ParserPackage.MQTT_INPUT__SERVER_URI:
                setServerUri ( (String)newValue );
                return;
            case ParserPackage.MQTT_INPUT__CLIENT_ID:
                setClientId ( (String)newValue );
                return;
            case ParserPackage.MQTT_INPUT__TOPIC:
                setTopic ( (String)newValue );
                return;
            case ParserPackage.MQTT_INPUT__QOS:
                setQos ( (Integer)newValue );
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
            case ParserPackage.MQTT_INPUT__SERVER_URI:
                setServerUri ( SERVER_URI_EDEFAULT );
                return;
            case ParserPackage.MQTT_INPUT__CLIENT_ID:
                setClientId ( CLIENT_ID_EDEFAULT );
                return;
            case ParserPackage.MQTT_INPUT__TOPIC:
                setTopic ( TOPIC_EDEFAULT );
                return;
            case ParserPackage.MQTT_INPUT__QOS:
                setQos ( QOS_EDEFAULT );
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
            case ParserPackage.MQTT_INPUT__SERVER_URI:
                return SERVER_URI_EDEFAULT == null ? serverUri != null : !SERVER_URI_EDEFAULT.equals ( serverUri );
            case ParserPackage.MQTT_INPUT__CLIENT_ID:
                return CLIENT_ID_EDEFAULT == null ? clientId != null : !CLIENT_ID_EDEFAULT.equals ( clientId );
            case ParserPackage.MQTT_INPUT__TOPIC:
                return TOPIC_EDEFAULT == null ? topic != null : !TOPIC_EDEFAULT.equals ( topic );
            case ParserPackage.MQTT_INPUT__QOS:
                return qos != QOS_EDEFAULT;
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
        result.append ( " (serverUri: " ); //$NON-NLS-1$
        result.append ( serverUri );
        result.append ( ", clientId: " ); //$NON-NLS-1$
        result.append ( clientId );
        result.append ( ", topic: " ); //$NON-NLS-1$
        result.append ( topic );
        result.append ( ", qos: " ); //$NON-NLS-1$
        result.append ( qos );
        result.append ( ')' );
        return result.toString ();
    }

} //MqttInputImpl
