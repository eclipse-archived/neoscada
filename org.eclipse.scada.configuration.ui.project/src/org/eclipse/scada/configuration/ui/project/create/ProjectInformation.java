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
package org.eclipse.scada.configuration.ui.project.create;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.scada.configuration.world.UsernamePasswordCredentials;
import org.eclipse.scada.configuration.world.WorldFactory;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;

public class ProjectInformation
{
    private IProject project;

    private IPath projectLocation;

    private final Map<String, List<String>> nodes = new HashMap<> ();

    private boolean globalize;

    private PersistentBackend configurationPersistentBackend = new ConfigurationFileBackend ();

    private PersistentBackend dataStorePersistentBackend = new DataStoreFileBackend ();

    private String defaultDriverPassword = "driver12";

    private UsernamePasswordCredentials defaultInterconnectCredentials;

    private DebianDeploymentMechanism debianDeploymentMechanism;

    public ProjectInformation ()
    {
        this.defaultInterconnectCredentials = WorldFactory.eINSTANCE.createUsernamePasswordCredentials ();
        this.defaultInterconnectCredentials.setUsername ( "interconnect" );
        this.defaultInterconnectCredentials.setPassword ( "interconnect12" );
    }

    public void setDebianDeploymentMechanism ( final DebianDeploymentMechanism debianDeploymentMechanism )
    {
        this.debianDeploymentMechanism = debianDeploymentMechanism;
    }

    public DebianDeploymentMechanism getDebianDeploymentMechanism ()
    {
        return this.debianDeploymentMechanism;
    }

    public String getDefaultDriverPassword ()
    {
        return this.defaultDriverPassword;
    }

    public void setDefaultDriverPassword ( final String defaultDriverPassword )
    {
        this.defaultDriverPassword = defaultDriverPassword;
    }

    public UsernamePasswordCredentials getDefaultInterconnectCredentials ()
    {
        return this.defaultInterconnectCredentials;
    }

    public void setDefaultInterconnectCredentials ( final UsernamePasswordCredentials defaultInterconnectCredentials )
    {
        this.defaultInterconnectCredentials = defaultInterconnectCredentials;
    }

    public PersistentBackend getConfigurationPersistentBackend ()
    {
        return this.configurationPersistentBackend;
    }

    public void setConfigurationPersistentBackend ( final PersistentBackend configurationPersistentBackend )
    {
        this.configurationPersistentBackend = configurationPersistentBackend;
    }

    public PersistentBackend getDataStorePersistentBackend ()
    {
        return this.dataStorePersistentBackend;
    }

    public void setDataStorePersistentBackend ( final PersistentBackend dataStorePersistentBackend )
    {
        this.dataStorePersistentBackend = dataStorePersistentBackend;
    }

    public boolean isGlobalize ()
    {
        return this.globalize;
    }

    public void setGlobalize ( final boolean globalize )
    {
        this.globalize = globalize;
    }

    public IPath getProjectLocation ()
    {
        return this.projectLocation;
    }

    public void setProjectLocation ( final IPath projectLocation )
    {
        this.projectLocation = projectLocation;
    }

    public IProject getProject ()
    {
        return this.project;
    }

    public void setProject ( final IProject project )
    {
        this.project = project;
    }

    public void addNode ( final String hostname, final List<String> hierarchy )
    {
        this.nodes.put ( hostname, hierarchy );
    }

    public Map<String, List<String>> getNodes ()
    {
        return this.nodes;
    }
}
