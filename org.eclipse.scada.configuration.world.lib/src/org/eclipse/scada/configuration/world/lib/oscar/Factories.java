/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.oscar;

public interface Factories
{

    public static final String FACTORY_MASTER_HANDLER_MARKER = "org.eclipse.scada.da.master.common.marker"; //$NON-NLS-1$

    public static final String FACTORY_MASTER_HANDLER_BLOCK = "org.eclipse.scada.da.master.common.block"; //$NON-NLS-1$

    public static final String FACTORY_AE_MONITOR_REMOTE_ATTR = "ae.monitor.da.remote.booleanAttributeAlarm"; //$NON-NLS-1$

    public static final String FACTORY_AE_MONITOR_REMOTE_BOOLEAN = "ae.monitor.da.remote.booleanValueAlarm"; //$NON-NLS-1$

    public static final String FACTORY_AE_MONITOR_BIT = "org.eclipse.scada.ae.monitor.bit"; //$NON-NLS-1$

    public static final String FACTORY_MASTER_HANDLER_LOGGER = "org.eclipse.scada.ae.event.logger"; //$NON-NLS-1$

    public static final String FACTORY_MASTER_HANDLER_NEGATE = "org.eclipse.scada.da.negate.input"; //$NON-NLS-1$

    public static final String FACTORY_MASTER_HANDLER_ROUND = "org.eclipse.scada.da.round"; //$NON-NLS-1$

    public static final String FACTORY_MASTER_HANDLER_SCALE = "org.eclipse.scada.da.scale.input"; //$NON-NLS-1$

    public static final String FACTORY_MASTER_HANDLER_MANUAL = "org.eclipse.scada.da.manual"; //$NON-NLS-1$

    public static final String FACTORY_MASTER_HANDLER_VALUE_MAPPER = "org.eclipse.scada.da.master.mapper"; //$NON-NLS-1$

    public static final String FACTORY_AE_MONITOR_LEVEL = "org.eclipse.scada.ae.monitor.level"; //$NON-NLS-1$

    public static final String FACTORY_AE_MONITOR_LIST = "org.eclipse.scada.ae.monitor.list"; //$NON-NLS-1$

    public static final String FACTORY_AE_MONITOR_SCRIPT = "org.eclipse.scada.ae.monitor.script"; //$NON-NLS-1$

    public static final String FACTORY_AE_MONITOR_PROXY_QUERY = "org.eclipse.scada.ae.server.monitor.proxy"; //$NON-NLS-1$

    public static final String FACTORY_AE_EVENT_PROXY_QUERY = "org.eclipse.scada.ae.server.event.proxy"; //$NON-NLS-1$

    public static final String FACTORY_DA_SOURCE = "da.datasource.dataitem"; //$NON-NLS-1$

    public static final String FACTORY_DA_SUM_SOURCE = "org.eclipse.scada.da.datasource.sum"; //$NON-NLS-1$

    public static final String FACTORY_DA_CONST_SOURCE = "org.eclipse.scada.da.datasource.constant"; //$NON-NLS-1$

    public static final String FACTORY_DA_DS_SOURCE = "org.eclipse.scada.da.datasource.ds"; //$NON-NLS-1$

    public static final String FACTORY_DA_MEMORY_SOURCE = "org.eclipse.scada.da.datasource.memory"; //$NON-NLS-1$

    public static final String FACTORY_DA_PROXY_SOURCE = "da.datasource.proxy"; //$NON-NLS-1$

    public static final String FACTORY_DA_MASTER_HANDLER_SUM = "da.master.handler.sum"; //$NON-NLS-1$

    public static final String FACTORY_SIMPLE_DATA_MAPPER = "org.eclipse.scada.da.mapper.osgi.configuredMapper"; //$NON-NLS-1$

    public static final String FACTORY_JDBC_DATA_MAPPER = "org.eclipse.scada.da.mapper.osgi.jdbcMapper"; //$NON-NLS-1$

    public static final String FACTORY_EXTERNAL_EVENT_FILTER = "org.eclipse.scada.ae.server.http.eventFilter"; //$NON-NLS-1$

    public static final String FACTORY_DA_SCRIPT_SOURCE = "org.eclipse.scada.da.datasource.script"; //$NON-NLS-1$

    public static final String FACTORY_DA_FORMULA_SOURCE = "org.eclipse.scada.da.datasource.formula"; //$NON-NLS-1$

    public static final String FACTORY_DA_MOVING_AVERAGE = "org.eclipse.scada.da.datasource.movingaverage"; //$NON-NLS-1$

    public static final String FACTORY_DA_AVERAGE = "org.eclipse.scada.da.datasource.average"; //$NON-NLS-1$

    public static final String FACTORY_DA_CHANGE_COUNTER = "org.eclipse.scada.da.datasource.changecounter"; //$NON-NLS-1$

    public static final String FACTORY_DA_GLOBAL_SUMMARY_SOURCE = "org.eclipse.scada.da.server.osgi.summary.attribute"; //$NON-NLS-1$

    public static final String FACTORY_AE_AKN_PROXY = "org.eclipse.scada.ae.server.akn.proxy"; //$NON-NLS-1$

    public static final String FACTORY_AE_PULL_EVENTS = "org.eclipse.scada.ae.slave.pull"; //$NON-NLS-1$

    public static final String FACTORY_HD_ITEM = "historical.item.factory"; //$NON-NLS-1$

    public static final String FACTORY_SEC_JDBC = "org.eclipse.scada.sec.provider.jdbc.authenticator"; //$NON-NLS-1$

    public static final String FACTORY_DA_EXPORTER = "da.dataitem.datasource"; //$NON-NLS-1$

    public static final String FACTORY_AE_SERVER_INFO = "ae.server.info";

    public static final String FACTORY_AE_EVENT_POOL = "org.eclipse.scada.ae.server.common.event.pool";

    public static final String FACTORY_AE_MONITOR_POOL = "ae.monitor.query";

    public static final String FACTORY_AE_EXTERNAL = "ae.monitor.ae.event.external";

    public static final String FACTORY_DA_REST_EXPORTER = "org.eclipse.scada.da.server.exporter.rest.context";

}
