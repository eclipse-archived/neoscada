----------------------------------------------------------------------------------
-- Copyright (c) 2013, 2014 Jürgen Rose and others.
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the Eclipse Public License v1.0
-- which accompanies this distribution, and is available at
-- http://www.eclipse.org/legal/epl-v10.html
--
-- Contributors:
--     Jürgen Rose - initial API and implementation
--     IBH SYSTEMS GmbH - some enhancements
----------------------------------------------------------------------------------

-- as database owner/super user
-- DROP EXTENSION plpgsql
CREATE LANGUAGE plpgsql;
-- DROP EXTENSION hstore
CREATE EXTENSION hstore;
-- DROP EXTENSION pg_trgm
CREATE EXTENSION pg_trgm;
-- DROP EXTENSION fuzzystrmatch
CREATE EXTENSION fuzzystrmatch;

-- DROP TABLE es_ae_events_hstore;
CREATE TABLE es_ae_events_hstore
(
  id                           UUID NOT NULL,
  instance_id                  VARCHAR(32),
  source_timestamp             TIMESTAMP,
  entry_timestamp              TIMESTAMP,
  data                         hstore,
  CONSTRAINT pk_es_ae_events_hstore PRIMARY KEY (id)
);

-- DROP TABLE es_ae_rep;
CREATE TABLE es_ae_rep
(
  ID                           CHAR(36) NOT NULL,
  ENTRY_TIMESTAMP              TIMESTAMP,
  NODE_ID                      VARCHAR(32),
  DATA                         TEXT,
  CONSTRAINT pk_es_ae_rep PRIMARY KEY (id)
);


-- DROP FUNCTION es_ae_create_index(text, text);
CREATE OR REPLACE FUNCTION es_ae_create_index(property text, rettype text)
  RETURNS boolean AS
$BODY$
DECLARE
    idx_name TEXT;
    sql_idx TEXT;
    indexexists BOOLEAN;
    result BOOLEAN;
BEGIN
    IF rettype NOT IN ('boolean', 'long', 'double', 'string') THEN
        RAISE NOTICE 'return type not recognized';
        RETURN false;
    END IF;
    SELECT false INTO result;

    -- for boolean/numbers this is straight forward
    IF rettype IN ('boolean', 'long', 'double') THEN
        SELECT 'es_ae_events_hstore_' || property || '_' || rettype || '_idx' INTO idx_name;
        RAISE NOTICE 'try to create index %', idx_name;
        SELECT count(*) > 0 FROM pg_class WHERE relname = idx_name INTO indexexists;
        IF indexexists THEN
            RAISE NOTICE 'index % already exists', idx_name;
        ELSE
            SELECT 'CREATE INDEX ' || idx_name || ' ON es_ae_events_hstore USING btree (es_variant_to_' || rettype || '(data -> ''' || property || '''));' INTO sql_idx;
            RAISE NOTICE 'executing %', sql_idx;
            EXECUTE sql_idx;
            SELECT true INTO result;
        END IF;
    END IF;

    -- for strings we have to create two indexes, a normal btree and a gist index
    IF rettype = 'string' THEN
        -- btree
        SELECT 'es_ae_events_hstore_' || property || '_' || rettype || '_idx' INTO idx_name;
        RAISE NOTICE 'try to create index %', idx_name;
        SELECT count(*) > 0 FROM pg_class WHERE relname = idx_name INTO indexexists;
        IF indexexists THEN
            RAISE NOTICE 'index % already exists', idx_name;
        ELSE
            SELECT 'CREATE INDEX ' || idx_name || ' ON es_ae_events_hstore USING btree (lower(substring(es_variant_to_string(data -> ''' || property || '''), 1, 512)));' INTO sql_idx;
            RAISE NOTICE 'executing %', sql_idx;
            EXECUTE sql_idx;
            SELECT true INTO result;
        END IF;
        -- gist
        SELECT 'es_ae_events_hstore_' || property || '_' || rettype || '_g_idx' INTO idx_name;
        RAISE NOTICE 'try to create index %', idx_name;
        SELECT count(*) > 0 FROM pg_class WHERE relname = idx_name INTO indexexists;
        IF indexexists THEN
            RAISE NOTICE 'index % already exists', idx_name;
        ELSE
            SELECT 'CREATE INDEX ' || idx_name || ' ON es_ae_events_hstore USING gist ((lower(substring(es_variant_to_string(data -> ''' || property || '''), 1, 512))) gist_trgm_ops);' INTO sql_idx;
            RAISE NOTICE 'executing %', sql_idx;
            EXECUTE sql_idx;
            SELECT true INTO result;
        END IF;
    END IF;
    RETURN result;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE;

-- DROP FUNCTION es_variant_to_boolean(text);
CREATE OR REPLACE FUNCTION es_variant_to_boolean(attr text)
  RETURNS boolean AS
$BODY$
BEGIN
    IF attr IS NULL
    THEN
        RETURN NULL;
    END IF;
    IF attr = 'BOOL#true' THEN
        RETURN true;
    ELSIF attr = 'BOOL#false' THEN
        RETURN false;
    ELSE
        RETURN NULL;
    END IF;
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;

-- DROP FUNCTION es_variant_to_double(text);
CREATE OR REPLACE FUNCTION es_variant_to_double(attr text)
  RETURNS numeric AS
$BODY$
BEGIN
    IF attr IS NULL
    THEN
        RETURN NULL;
    END IF;
    IF substring(attr from 1 for 6) = 'INT32#' or substring(attr from 1 for 6) = 'INT64#' or substring(attr from 1 for 6) = 'FLOAT#' THEN
        RETURN substring(attr from 7)::NUMERIC;
    ELSIF substring(attr from 1 for 7) = 'DOUBLE#' THEN
        RETURN substring(attr from 8)::NUMERIC;
    ELSE
        RETURN NULL;
    END IF;
EXCEPTION
    WHEN invalid_text_representation THEN RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;

-- DROP FUNCTION es_variant_to_long(text);
CREATE OR REPLACE FUNCTION es_variant_to_long(attr text)
  RETURNS bigint AS
$BODY$
BEGIN
    IF attr IS NULL
    THEN
        RETURN NULL;
    END IF;
    IF substring(attr from 1 for 6) = 'INT32#' or substring(attr from 1 for 6) = 'INT64#' THEN
        RETURN substring(attr from 7)::BIGINT;
    ELSIF substring(attr from 1 for 6) = 'FLOAT#' THEN
        RETURN trunc(substring(attr from 7)::NUMERIC)::BIGINT;
    ELSIF substring(attr from 1 for 7) = 'DOUBLE#' THEN
        RETURN trunc(substring(attr from 8)::NUMERIC)::BIGINT;
    ELSE
        RETURN NULL;
    END IF;
EXCEPTION
    WHEN invalid_text_representation THEN RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;

-- DROP FUNCTION es_variant_to_string(text);
CREATE OR REPLACE FUNCTION es_variant_to_string(attr text)
  RETURNS text AS
$BODY$
DECLARE
    p INT;
    t TEXT;
BEGIN
    IF attr IS NULL
    THEN
        RETURN NULL;
    END IF;
    SELECT position('#' in attr) INTO p;
    SELECT substring(attr from 1 for p) INTO t;
    IF t = 'BOOL#' or t = 'INT32#' or t = 'INT64#' or t = 'FLOAT#' or t = 'DOUBLE#' or t = 'STRING#' THEN
        RETURN substring(attr from p + 1);
    ELSIF t = 'NULL#' THEN
        RETURN NULL;
    ELSE
        RETURN attr;
    END IF;
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;


CREATE INDEX es_ae_events_hstore_instance_id_idx ON es_ae_events_hstore (instance_id);
CREATE INDEX es_ae_events_hstore_source_timestamp_idx ON es_ae_events_hstore (source_timestamp);
CREATE INDEX es_ae_events_hstore_source_timestamp_d_idx ON es_ae_events_hstore (source_timestamp DESC);
CREATE INDEX es_ae_events_hstore_entry_timestamp_idx ON es_ae_events_hstore (entry_timestamp);
CREATE INDEX es_ae_events_hstore_entry_timestamp_d_idx ON es_ae_events_hstore (entry_timestamp DESC);
CREATE INDEX es_ae_events_hstore_data_idx ON es_ae_events_hstore USING GIST (data);

SELECT es_ae_create_index('monitorType', 'string');
SELECT es_ae_create_index('eventType', 'string');
SELECT es_ae_create_index('value', 'string');
SELECT es_ae_create_index('value', 'boolean');
SELECT es_ae_create_index('value', 'double');
SELECT es_ae_create_index('value', 'long');
SELECT es_ae_create_index('message', 'string');
SELECT es_ae_create_index('priority', 'long');
SELECT es_ae_create_index('source', 'string');
SELECT es_ae_create_index('actorName', 'string');
SELECT es_ae_create_index('actorType', 'string');
SELECT es_ae_create_index('severity', 'string');
SELECT es_ae_create_index('item', 'string');
SELECT es_ae_create_index('itemDescription', 'string');

