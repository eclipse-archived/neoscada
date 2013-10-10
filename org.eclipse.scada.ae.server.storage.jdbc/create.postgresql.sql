-- DROP TABLE openscada_ae_events
-- DROP TABLE openscada_ae_events_attr

CREATE TABLE openscada_ae_events
(
  id                           CHAR(36) NOT NULL,
  source_timestamp             TIMESTAMP,
  entry_timestamp              TIMESTAMP,
  instance_id                  VARCHAR(32),
  monitor_type                 VARCHAR(32),
  event_type                   VARCHAR(32),
  value_type                   VARCHAR(32),
  value_string                 VARCHAR(4000),
  value_integer                BIGINT,
  value_double                 DOUBLE PRECISION,
  message                      VARCHAR(4000),
  message_code                 VARCHAR(255),
  priority                     SMALLINT,
  source                       VARCHAR(255),
  actor_name                   VARCHAR(128),
  actor_type                   VARCHAR(32),
  severity                     VARCHAR(32),
  replicated                   SMALLINT,
  CONSTRAINT openscada_ae_events_pkey PRIMARY KEY (id)
);

CREATE TABLE openscada_ae_events_attr
(
  id                           CHAR(36) NOT NULL,
  key                          VARCHAR(64) NOT NULL,
  value_type                   VARCHAR(32),
  value_string                 VARCHAR(4000),
  value_integer                BIGINT,
  value_double                 DOUBLE PRECISION,
  CONSTRAINT openscada_ae_events_attr_pkey PRIMARY KEY (id , key),
  CONSTRAINT openscada_ae_events_attr_id_fkey FOREIGN KEY (id)
      REFERENCES openscada_ae_events (id) ON DELETE CASCADE
);

CREATE INDEX openscada_ae_events_idx_1 ON openscada_ae_events (source_timestamp);
CREATE INDEX openscada_ae_events_idx_1d ON openscada_ae_events (source_timestamp DESC);
CREATE INDEX openscada_ae_events_idx_2 ON openscada_ae_events (entry_timestamp);
CREATE INDEX openscada_ae_events_idx_2d ON openscada_ae_events (entry_timestamp DESC);
CREATE INDEX openscada_ae_events_idx_3 ON openscada_ae_events (instance_id);
CREATE INDEX openscada_ae_events_idx_4 ON openscada_ae_events (monitor_type);
CREATE INDEX openscada_ae_events_idx_4l ON openscada_ae_events (lower(monitor_type));
CREATE INDEX openscada_ae_events_idx_5 ON openscada_ae_events (event_type);
CREATE INDEX openscada_ae_events_idx_5l ON openscada_ae_events (lower(event_type));
CREATE INDEX openscada_ae_events_idx_6 ON openscada_ae_events (value_type);
CREATE INDEX openscada_ae_events_idx_7 ON openscada_ae_events (value_string);
CREATE INDEX openscada_ae_events_idx_7l ON openscada_ae_events (lower(value_string));
CREATE INDEX openscada_ae_events_idx_8 ON openscada_ae_events (value_integer);
CREATE INDEX openscada_ae_events_idx_9 ON openscada_ae_events (value_double);
CREATE INDEX openscada_ae_events_idx_10 ON openscada_ae_events (message);
CREATE INDEX openscada_ae_events_idx_10l ON openscada_ae_events (lower(message));
CREATE INDEX openscada_ae_events_idx_11 ON openscada_ae_events (message_code);
CREATE INDEX openscada_ae_events_idx_11l ON openscada_ae_events (lower(message_code));
CREATE INDEX openscada_ae_events_idx_12 ON openscada_ae_events (priority);
CREATE INDEX openscada_ae_events_idx_13 ON openscada_ae_events (source);
CREATE INDEX openscada_ae_events_idx_13l ON openscada_ae_events (lower(source));
CREATE INDEX openscada_ae_events_idx_14 ON openscada_ae_events (actor_name);
CREATE INDEX openscada_ae_events_idx_14l ON openscada_ae_events (lower(actor_name));
CREATE INDEX openscada_ae_events_idx_15 ON openscada_ae_events (actor_type);
CREATE INDEX openscada_ae_events_idx_15l ON openscada_ae_events (lower(actor_type));
CREATE INDEX openscada_ae_events_idx_16 ON openscada_ae_events (severity);
CREATE INDEX openscada_ae_events_idx_16l ON openscada_ae_events (lower(severity));
CREATE INDEX openscada_ae_events_idx_17 ON openscada_ae_events (replicated);

CREATE INDEX openscada_ae_events_attr_idx_1 ON openscada_ae_events_attr (id, key);
CREATE INDEX openscada_ae_events_attr_idx_2 ON openscada_ae_events_attr (value_type);
CREATE INDEX openscada_ae_events_attr_idx_3 ON openscada_ae_events_attr (value_string);
CREATE INDEX openscada_ae_events_attr_idx_3l ON openscada_ae_events_attr (lower(value_string));
CREATE INDEX openscada_ae_events_attr_idx_4 ON openscada_ae_events_attr (value_integer);
CREATE INDEX openscada_ae_events_attr_idx_5 ON openscada_ae_events_attr (value_double);

-- ALTER TABLE openscada_ae_events OWNER TO openscada;
-- ALTER TABLE openscada_ae_events_attr OWNER TO openscada;

-- for replication table ( blob mode )

CREATE TABLE OPENSCADA_AE_REP
(
	ID                      CHAR(36) NOT NULL,
	ENTRY_TIMESTAMP         TIMESTAMP,
	NODE_ID                 VARCHAR(32),
	DATA                    BYTEA,

	CONSTRAINT OPENSCADA_AE_REP_PK PRIMARY KEY ( ID )	
);
