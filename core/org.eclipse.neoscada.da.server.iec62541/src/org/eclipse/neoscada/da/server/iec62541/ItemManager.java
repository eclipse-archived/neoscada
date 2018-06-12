package org.eclipse.neoscada.da.server.iec62541;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemManager
{
    private static final Logger logger = LoggerFactory.getLogger ( ItemManager.class );

    public static class NodeInfo
    {
        public NodeInfo ( final NodeId nodeId, final long handle )
        {
            this.nodeId = nodeId;
            this.handle = handle;
        }

        private final NodeId nodeId;

        private final long handle;

        public NodeId getNodeId ()
        {
            return this.nodeId;
        }

        public long getHandle ()
        {
            return this.handle;
        }
    }

    private final ConcurrentMap<String, NodeInfo> nodeIds = new ConcurrentSkipListMap<> ();

    private final AtomicLong handleGenerator = new AtomicLong ( 0 );

    public NodeInfo registerItem ( final String id, final NodeId nodeId )
    {
        final NodeInfo nodeInfo = new NodeInfo ( nodeId, this.handleGenerator.incrementAndGet () );
        final NodeInfo existing = this.nodeIds.putIfAbsent ( id, nodeInfo );
        logger.debug ( "registerItem ( {}, {} ) => existed = {}, handle = {}", new Object[] { id, nodeId, existing != null, nodeInfo.getHandle () } );
        return existing == null ? nodeInfo : existing;
    }

    public void dispose ()
    {
        logger.debug ( "dispose ()" );
        this.nodeIds.clear ();
    }

    public Optional<NodeId> getNodeId ( final String id )
    {
        return Optional.ofNullable ( this.nodeIds.get ( id ) ).map ( t -> t.nodeId );
    }

    public Optional<Long> getHandle ( final String id )
    {
        return Optional.ofNullable ( this.nodeIds.get ( id ) ).map ( t -> t.handle );
    }

    public Optional<NodeInfo> getNodeInfo ( final String id )
    {
        return Optional.ofNullable ( this.nodeIds.get ( id ) );
    }
}
