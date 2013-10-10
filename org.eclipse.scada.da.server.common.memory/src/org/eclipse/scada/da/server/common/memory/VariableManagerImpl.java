/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - refactor for generic memory devices
 *******************************************************************************/
package org.eclipse.scada.da.server.common.memory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.scada.ca.ConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.eclipse.scada.utils.concurrent.NamedThreadFactory;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.eclipse.scada.da.server.common.DataItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class VariableManagerImpl implements VariableManager, ConfigurationFactory
{

    private final static Logger logger = LoggerFactory.getLogger ( VariableManagerImpl.class );

    private static enum TYPE
    {
        /**
         * A single bit
         */
        BIT,
        TRIBIT,
        /**
         * 8bit unsigned integer
         */
        BYTE,
        /**
         * 32bit floating point
         */
        FLOAT,
        /**
         * 16bit unsigned integer
         */
        WORD,
        /**
         * 32bit unsigned integer
         */
        DINT,
        /**
         * User defined type
         */
        UDT
    }

    private static class TypeEntry
    {
        private final String name;

        private final TYPE type;

        private String typeName;

        private final int[] index;

        private final TypeEntry[] attributes;

        public TypeEntry ( final String name, final String typeName, final int index )
        {
            this.name = name;
            this.type = TYPE.UDT;
            this.typeName = typeName;
            this.attributes = null;
            this.index = new int[] { index };
        }

        public TypeEntry ( final String name, final int[] index, final TypeEntry... attributes )
        {
            this.name = name;
            this.index = index.clone ();
            this.type = TYPE.TRIBIT;
            this.attributes = attributes;
        }

        public TypeEntry ( final String name, final int index, final int subIndex, final int options, final TypeEntry... attributes )
        {
            this.name = name;
            this.index = new int[] { index, subIndex, options };
            this.type = TYPE.BIT;
            this.attributes = attributes;
        }

        public TypeEntry ( final String name, final TYPE type, final int index, final int options, final TypeEntry... attributes )
        {
            this.name = name;
            this.index = new int[] { index, options };
            this.type = type;
            this.attributes = attributes;
        }

        public int[] getIndexes ()
        {
            return this.index;
        }

        public TypeEntry[] getAttributes ()
        {
            return this.attributes;
        }

        public int getIndex ()
        {
            return this.index[0];
        }

        public String getName ()
        {
            return this.name;
        }

        public int getSubIndex ()
        {
            return this.index[1];
        }

        public TYPE getType ()
        {
            return this.type;
        }

        public String getTypeName ()
        {
            return this.typeName;
        }

        @Override
        public String toString ()
        {
            switch ( this.type )
            {
                default:
                    return String.format ( "%s:%s", this.name, this.type );
            }
        }
    }

    private final Multimap<String, VariableListener> listeners = HashMultimap.create ();

    private final Multimap<String, String> typeDeps = HashMultimap.create ();

    private final Map<String, Collection<TypeEntry>> types = new HashMap<String, Collection<TypeEntry>> ();

    private final ExecutorService executor;

    private final ManageableObjectPool<DataItem> itemPool;

    public VariableManagerImpl ( final Executor executor, final ManageableObjectPool<DataItem> itemPool )
    {
        this.executor = Executors.newSingleThreadExecutor ( new NamedThreadFactory ( "VariableManager" ) );
        this.itemPool = itemPool;
    }

    public void dispose ()
    {
        this.executor.shutdown ();
    }

    @Override
    public synchronized void addVariableListener ( final String type, final VariableListener listener )
    {
        this.listeners.put ( type, listener );

        final Variable[] vars = createVariables ( type );

        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                listener.variableConfigurationChanged ( vars );
            }
        } );
    }

    @Override
    public synchronized void removeVariableListener ( final String type, final VariableListener listener )
    {
        this.listeners.remove ( type, listener );
    }

    @Override
    public synchronized void delete ( final UserInformation userInformation, final String configurationId ) throws Exception
    {
        this.types.remove ( configurationId );
        this.typeDeps.removeAll ( configurationId );
        handleTypeChange ( configurationId );
    }

    private void fireTypeChange ( final String type )
    {
        logger.debug ( "Fire type change: {}", type );

        for ( final VariableListener listener : this.listeners.get ( type ) )
        {
            /*
             * Create variables for each listener instance, so we need to do this
             * inside this thread and provide the executor with the result.
             */
            final Variable[] vars = createVariables ( type );
            this.executor.execute ( new Runnable () {

                @Override
                public void run ()
                {
                    logger.info ( "Apply type change: {}", type );
                    listener.variableConfigurationChanged ( vars );
                }
            } );
        }
    }

    @Override
    public synchronized void update ( final UserInformation userInformation, final String configurationId, final Map<String, String> properties ) throws Exception
    {
        logger.debug ( "Adding type: {}", configurationId );

        final Collection<TypeEntry> config = new ArrayList<> ( parseConfig ( properties ) );

        this.types.put ( configurationId, config );

        logger.debug ( "Generate deps:" );
        final Set<String> types = new HashSet<String> ();
        for ( final TypeEntry entry : config )
        {
            if ( entry.getType () == TYPE.UDT )
            {
                logger.debug ( "'{}' depends on '{}'", new Object[] { configurationId, entry.getTypeName () } );
                types.add ( entry.getTypeName () );
            }
        }
        this.typeDeps.putAll ( configurationId, types );

        handleTypeChange ( configurationId );
    }

    /**
     * Handle a type change and fire change events for all dependent types
     * 
     * @param configurationId
     */
    private void handleTypeChange ( final String configurationId )
    {
        logger.info ( "Handle type change: {}", configurationId );

        fireTypeChange ( configurationId );

        for ( final Map.Entry<String, Collection<String>> entry : this.typeDeps.asMap ().entrySet () )
        {
            logger.debug ( String.format ( "'%s' depends on '%s'", entry.getKey (), entry.getValue () ) );

            if ( entry.getValue ().contains ( configurationId ) )
            {
                logger.debug ( String.format ( "Trigger dependency - '%s' depends on '%s'", entry.getKey (), configurationId ) );
                handleTypeChange ( entry.getKey () );
            }
        }
    }

    private Variable[] createVariables ( final String type )
    {
        logger.debug ( "Creating variables for type: {}", type );

        final Collection<TypeEntry> entries = this.types.get ( type );
        if ( entries == null )
        {
            return new Variable[0];
        }
        else
        {
            final Collection<Variable> result = new ArrayList<Variable> ();
            for ( final TypeEntry entry : entries )
            {
                switch ( entry.getType () )
                {
                    case BIT:
                        result.add ( new BitVariable ( entry.getName (), entry.getIndex (), entry.getSubIndex (), this.executor, this.itemPool, createAttributes ( entry ) ) );
                        break;
                    case BYTE:
                        result.add ( new ByteVariable ( entry.getName (), entry.getIndex (), this.executor, this.itemPool, createAttributes ( entry ) ) );
                        break;
                    case FLOAT:
                        result.add ( new FloatVariable ( entry.getName (), entry.getIndex (), this.executor, this.itemPool, createAttributes ( entry ) ) );
                        break;
                    case WORD:
                        result.add ( new WordVariable ( entry.getName (), entry.getIndex (), this.executor, this.itemPool, createAttributes ( entry ) ) );
                        break;
                    case DINT:
                        result.add ( new DoubleIntegerVariable ( entry.getName (), entry.getIndex (), this.executor, this.itemPool, createAttributes ( entry ) ) );
                        break;
                    case UDT:
                        result.add ( new UdtVariable ( entry.getName (), entry.getIndex (), createVariables ( entry.getTypeName () ) ) );
                        break;
                }
            }
            return result.toArray ( new Variable[result.size ()] );
        }
    }

    private Attribute[] createAttributes ( final TypeEntry entry )
    {
        logger.debug ( "Creating attributes for {}", entry );

        final Collection<Attribute> result = new LinkedList<Attribute> ();

        for ( final TypeEntry attrEntry : entry.getAttributes () )
        {
            logger.debug ( "Creating attribute: {}", attrEntry );

            switch ( attrEntry.getType () )
            {
                case BIT:
                    result.add ( new BitAttribute ( attrEntry.getName (), attrEntry.getIndex (), attrEntry.getSubIndex (), attrEntry.getIndexes ()[2] != 0 ) );
                    break;
                case FLOAT:
                    result.add ( new FloatAttribute ( attrEntry.getName (), attrEntry.getIndex (), attrEntry.getIndexes ()[1] != 0 ) );
                    break;
                case TRIBIT:
                    final int[] index = attrEntry.getIndexes ();
                    result.add ( new TriBitAttribute ( attrEntry.getName (), index[0], index[1], index[2], index[3], index[4], index[5], index[6] != 0, index[7] != 0 ) );
                    break;
                case BYTE:
                    result.add ( new ByteAttribute ( attrEntry.getName (), attrEntry.getIndex (), attrEntry.getIndexes ()[1] != 0 ) );
                    break;
                case WORD:
                    result.add ( new WordAttribute ( attrEntry.getName (), attrEntry.getIndex (), attrEntry.getIndexes ()[1] != 0 ) );
                    break;
                case DINT:
                    result.add ( new DoubleIntegerAttribute ( attrEntry.getName (), attrEntry.getIndex (), attrEntry.getIndexes ()[1] != 0 ) );
                    break;
                default:
                    break;
            }
        }
        return result.toArray ( new Attribute[result.size ()] );
    }

    private Collection<TypeEntry> parseConfig ( final Map<String, String> properties )
    {
        final Collection<TypeEntry> result = new LinkedList<TypeEntry> ();

        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            final String key = entry.getKey ();
            if ( !key.startsWith ( "variable." ) )
            {
                continue;
            }

            final String varName = key.substring ( "variable.".length () );
            final String toks[] = entry.getValue ().split ( ":" );

            parseType ( properties, result, varName, toks[0], makeArgs ( toks, 1 ), false );
        }

        return result;
    }

    protected String[] makeArgs ( final String[] toks, final int start )
    {
        final String[] args = new String[toks.length - start];
        for ( int i = start; i < toks.length; i++ )
        {
            args[i - start] = toks[i];
        }
        return args;
    }

    protected void parseType ( final Map<String, String> properties, final Collection<TypeEntry> result, final String varName, final String typeName, final String[] args, final boolean attribute )
    {
        switch ( TYPE.valueOf ( typeName ) )
        {
            case BIT:
                result.add ( new TypeEntry ( varName, Integer.parseInt ( args[0] ), Integer.parseInt ( args[1] ), Integer.parseInt ( args[1] ), parseAttributes ( attribute, properties, varName ) ) );
                break;
            case BYTE:
                result.add ( new TypeEntry ( varName, TYPE.BYTE, Integer.parseInt ( args[0] ), Integer.parseInt ( args[1] ), parseAttributes ( attribute, properties, varName ) ) );
                break;
            case FLOAT:
                result.add ( new TypeEntry ( varName, TYPE.FLOAT, Integer.parseInt ( args[0] ), Integer.parseInt ( args[1] ), parseAttributes ( attribute, properties, varName ) ) );
                break;
            case WORD:
                result.add ( new TypeEntry ( varName, TYPE.WORD, Integer.parseInt ( args[0] ), Integer.parseInt ( args[1] ), parseAttributes ( attribute, properties, varName ) ) );
                break;
            case DINT:
                result.add ( new TypeEntry ( varName, TYPE.DINT, Integer.parseInt ( args[0] ), Integer.parseInt ( args[1] ), parseAttributes ( attribute, properties, varName ) ) );
                break;
            case UDT:
                if ( attribute )
                {
                    throw new IllegalArgumentException ( "Attribute must be of scalar type. UDTs are not allowed." );
                }
                else
                {
                    result.add ( new TypeEntry ( varName, args[0], Integer.parseInt ( args[1] ) ) );
                }
                break;
            case TRIBIT:
                result.add ( new TypeEntry ( varName, new int[] {//
                Integer.parseInt ( args[0] ), Integer.parseInt ( args[1] ),// read bit
                Integer.parseInt ( args[2] ), Integer.parseInt ( args[3] ),// write true bit
                Integer.parseInt ( args[4] ), Integer.parseInt ( args[5] ),// write false bit
                Integer.parseInt ( args[6] ), // invert
                Integer.parseInt ( args[7] ), // enableTimestamp
                } ) );
                break;
            default:
                throw new IllegalArgumentException ( String.format ( "Type %s is not supported at the moment", typeName ) );
        }
    }

    private TypeEntry[] parseAttributes ( final boolean attribute, final Map<String, String> properties, final String varName )
    {
        if ( attribute )
        { // we are currently parsing an attribute, so no sub-attributes are allowed
            return new TypeEntry[0];
        }

        final String attrVarName = "attribute." + varName + "."; //$NON-NLS-1$ //$NON-NLS-2$

        final Collection<TypeEntry> result = new LinkedList<TypeEntry> ();

        for ( final Map.Entry<String, String> entry : properties.entrySet () )
        {
            final String key = entry.getKey ();
            if ( !key.startsWith ( attrVarName ) )
            {
                continue;
            }

            final String attrName = key.substring ( attrVarName.length () );
            final String toks[] = entry.getValue ().split ( ":" ); //$NON-NLS-1$

            final String typeName = toks[0];
            final String[] args = makeArgs ( toks, 1 );

            parseType ( properties, result, attrName, typeName, args, true );
        }

        return result.toArray ( new TypeEntry[0] );
    }
}
