----------------------------------------------------------------------------------
-- Copyright (c) 2013 Jürgen Rose and others.
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the Eclipse Public License v1.0
-- which accompanies this distribution, and is available at
-- http://www.eclipse.org/legal/epl-v10.html
--
-- Contributors:
--     Jürgen Rose - initial API and implementation
----------------------------------------------------------------------------------

-- DROP TABLE es_ae_events
-- DROP TABLE es_ae_events_attr

CREATE TABLE es_ae_events
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
  CONSTRAINT es_ae_events_pkey PRIMARY KEY (id)
);

CREATE TABLE es_ae_events_attr
(
  id                           CHAR(36) NOT NULL,
  key                          VARCHAR(64) NOT NULL,
  value_type                   VARCHAR(32),
  value_string                 VARCHAR(4000),
  value_integer                BIGINT,
  value_double                 DOUBLE PRECISION,
  CONSTRAINT es_ae_events_attr_pkey PRIMARY KEY (id , key),
  CONSTRAINT es_ae_events_attr_id_fkey FOREIGN KEY (id)
      REFERENCES es_ae_events (id) ON DELETE CASCADE
);

CREATE INDEX es_ae_events_idx_1 ON es_ae_events (source_timestamp);
CREATE INDEX es_ae_events_idx_1d ON es_ae_events (source_timestamp DESC);
CREATE INDEX es_ae_events_idx_2 ON es_ae_events (entry_timestamp);
CREATE INDEX es_ae_events_idx_2d ON es_ae_events (entry_timestamp DESC);
CREATE INDEX es_ae_events_idx_3 ON es_ae_events (instance_id);
CREATE INDEX es_ae_events_idx_4 ON es_ae_events (monitor_type);
CREATE INDEX es_ae_events_idx_4l ON es_ae_events (lower(monitor_type));
CREATE INDEX es_ae_events_idx_5 ON es_ae_events (event_type);
CREATE INDEX es_ae_events_idx_5l ON es_ae_events (lower(event_type));
CREATE INDEX es_ae_events_idx_6 ON es_ae_events (value_type);
CREATE INDEX es_ae_events_idx_7 ON es_ae_events (value_string);
CREATE INDEX es_ae_events_idx_7l ON es_ae_events (lower(value_string));
CREATE INDEX es_ae_events_idx_8 ON es_ae_events (value_integer);
CREATE INDEX es_ae_events_idx_9 ON es_ae_events (value_double);
CREATE INDEX es_ae_events_idx_10 ON es_ae_events (message);
CREATE INDEX es_ae_events_idx_10l ON es_ae_events (lower(message));
CREATE INDEX es_ae_events_idx_11 ON es_ae_events (message_code);
CREATE INDEX es_ae_events_idx_11l ON es_ae_events (lower(message_code));
CREATE INDEX es_ae_events_idx_12 ON es_ae_events (priority);
CREATE INDEX es_ae_events_idx_13 ON es_ae_events (source);
CREATE INDEX es_ae_events_idx_13l ON es_ae_events (lower(source));
CREATE INDEX es_ae_events_idx_14 ON es_ae_events (actor_name);
CREATE INDEX es_ae_events_idx_14l ON es_ae_events (lower(actor_name));
CREATE INDEX es_ae_events_idx_15 ON es_ae_events (actor_type);
CREATE INDEX es_ae_events_idx_15l ON es_ae_events (lower(actor_type));
CREATE INDEX es_ae_events_idx_16 ON es_ae_events (severity);
CREATE INDEX es_ae_events_idx_16l ON es_ae_events (lower(severity));
CREATE INDEX es_ae_events_idx_17 ON es_ae_events (replicated);

CREATE INDEX es_ae_events_attr_idx_1 ON es_ae_events_attr (id, key);
CREATE INDEX es_ae_events_attr_idx_2 ON es_ae_events_attr (value_type);
CREATE INDEX es_ae_events_attr_idx_3 ON es_ae_events_attr (value_string);
CREATE INDEX es_ae_events_attr_idx_3l ON es_ae_events_attr (lower(value_string));
CREATE INDEX es_ae_events_attr_idx_4 ON es_ae_events_attr (value_integer);
CREATE INDEX es_ae_events_attr_idx_5 ON es_ae_events_attr (value_double);

-- ALTER TABLE es_ae_events OWNER TO es;
-- ALTER TABLE es_ae_events_attr OWNER TO es;

-- for replication table ( blob mode )

CREATE TABLE ES_AE_REP
(
	ID                      CHAR(36) NOT NULL,
	ENTRY_TIMESTAMP         TIMESTAMP,
	NODE_ID                 VARCHAR(32),
	DATA                    BYTEA,

	CONSTRAINT ES_AE_REP_PK PRIMARY KEY ( ID )	
);
