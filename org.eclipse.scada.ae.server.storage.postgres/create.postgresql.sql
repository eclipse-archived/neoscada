-- as database owner
CREATE LANGUAGE plpgsql;

-- DROP TABLE openscada_ae_events;
CREATE TABLE openscada_ae_events_json
(
  id                           UUID NOT NULL,
  instance_id                  VARCHAR(32),
  source_timestamp             TIMESTAMP,
  entry_timestamp              TIMESTAMP,
  data                         TEXT,
  CONSTRAINT pk_openscada_ae_events_json PRIMARY KEY (id)
);

-- DROP TABLE openscada_ae_rep;
CREATE TABLE openscada_ae_rep
(
  ID                           CHAR(36) NOT NULL,
  ENTRY_TIMESTAMP              TIMESTAMP,
  NODE_ID                      VARCHAR(32),
  DATA                         BYTEA,
  CONSTRAINT pk_openscada_ae_rep PRIMARY KEY (id)
);

-- DROP EXTENSION json_accessors
CREATE EXTENSION json_accessors;
-- DROP EXTENSION pg_trgm
CREATE EXTENSION pg_trgm;
-- DROP EXTENSION fuzzystrmatch
CREATE EXTENSION fuzzystrmatch;

-- DROP FUNCTION openscada_ae_extract_field(text, text);
CREATE OR REPLACE FUNCTION openscada_ae_extract_field(data text, attr text)
  RETURNS text AS
$BODY$
DECLARE
    o TEXT;
BEGIN
    IF data IS NULL THEN 
        RETURN NULL; 
    END IF;
    IF attr IS NULL THEN 
        RETURN NULL; 
    END IF;
    IF attr IN ('id', 'sourceTimestamp', 'entryTimestamp') THEN 
        RETURN json_get_text(data, attr); 
    ELSE
        SELECT json_get_object(data, 'attributes') INTO o;
        IF O IS NOT NULL THEN
            RETURN json_get_text(o, attr);
        END IF;
    END IF;
    RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;

-- DROP FUNCTION openscada_ae_create_index(text, text);
CREATE OR REPLACE FUNCTION openscada_ae_create_index(property text, rettype text)
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
        SELECT 'openscada_ae_events_json_' || property || '_' || rettype || '_idx' INTO idx_name;
        RAISE NOTICE 'try to create index %', idx_name;
        SELECT count(*) > 0 FROM pg_class WHERE relname = idx_name INTO indexexists;
        IF indexexists THEN
            RAISE NOTICE 'index % already exists', idx_name;
        ELSE
            SELECT 'CREATE INDEX ' || idx_name || ' ON openscada_ae_events_json USING btree (openscada_variant_to_' || rettype || '(openscada_ae_extract_field(data, ''' || property || ''')));' INTO sql_idx;
            RAISE NOTICE 'executing %', sql_idx;
            EXECUTE sql_idx;
            SELECT true INTO result;
        END IF;
    END IF;

    -- for strings we have to create two indexes, a normal btree and a gist index
    IF rettype = 'string' THEN
        -- btree
        SELECT 'openscada_ae_events_json_' || property || '_' || rettype || '_idx' INTO idx_name;
        RAISE NOTICE 'try to create index %', idx_name;
        SELECT count(*) > 0 FROM pg_class WHERE relname = idx_name INTO indexexists;
        IF indexexists THEN
            RAISE NOTICE 'index % already exists', idx_name;
        ELSE
            SELECT 'CREATE INDEX ' || idx_name || ' ON openscada_ae_events_json USING btree (lower(substring(openscada_variant_to_string(openscada_ae_extract_field(data, ''' || property || ''')), 1, 512)));' INTO sql_idx;
            RAISE NOTICE 'executing %', sql_idx;
            EXECUTE sql_idx;
            SELECT true INTO result;
        END IF;
        -- gist
        SELECT 'openscada_ae_events_json_' || property || '_' || rettype || '_g_idx' INTO idx_name;
        RAISE NOTICE 'try to create index %', idx_name;
        SELECT count(*) > 0 FROM pg_class WHERE relname = idx_name INTO indexexists;
        IF indexexists THEN
            RAISE NOTICE 'index % already exists', idx_name;
        ELSE
            SELECT 'CREATE INDEX ' || idx_name || ' ON openscada_ae_events_json USING gist ((lower(substring(openscada_variant_to_string(openscada_ae_extract_field(data, ''' || property || ''')), 1, 512))) gist_trgm_ops);' INTO sql_idx;
            RAISE NOTICE 'executing %', sql_idx;
            EXECUTE sql_idx;
            SELECT true INTO result;
        END IF;
    END IF;
    RETURN result;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE;

-- DROP FUNCTION openscada_variant_to_boolean(text);
CREATE OR REPLACE FUNCTION openscada_variant_to_boolean(attr text)
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

-- DROP FUNCTION openscada_variant_to_double(text);
CREATE OR REPLACE FUNCTION openscada_variant_to_double(attr text)
  RETURNS numeric AS
$BODY$
BEGIN
    IF attr IS NULL
    THEN
        RETURN NULL;
    END IF;
    IF substring(attr from 1 for 6) = 'INT32#' or substring(attr from 1 for 6) = 'INT64#' or substring(attr from 1 for 6) = 'FLOAT#' THEN
        RETURN substring(attr from 7)::NUMERIC;
    ELSE
        RETURN NULL;
    END IF;
EXCEPTION
    WHEN invalid_text_representation THEN RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;

-- DROP FUNCTION openscada_variant_to_long(text);
CREATE OR REPLACE FUNCTION openscada_variant_to_long(attr text)
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
    ELSE
        RETURN NULL;
    END IF;
EXCEPTION
    WHEN invalid_text_representation THEN RETURN NULL;
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;

-- DROP FUNCTION openscada_variant_to_string(text);
CREATE OR REPLACE FUNCTION openscada_variant_to_string(attr text)
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
    IF t = 'BOOL#' or t = 'INT32#' or t = 'INT64#' or t = 'FLOAT#' or t = 'STRING#' THEN
        RETURN substring(attr from p + 1);
    ELSIF t = 'NULL#' THEN
        RETURN NULL;
    ELSE
        RETURN attr;
    END IF;
END;
$BODY$
  LANGUAGE plpgsql IMMUTABLE;


CREATE INDEX openscada_ae_events_json_instance_id_idx ON openscada_ae_events_json (instance_id);
CREATE INDEX openscada_ae_events_json_source_timestamp_idx ON openscada_ae_events_json (source_timestamp);
CREATE INDEX openscada_ae_events_json_source_timestamp_d_idx ON openscada_ae_events_json (source_timestamp DESC);
CREATE INDEX openscada_ae_events_json_entry_timestamp_idx ON openscada_ae_events_json (entry_timestamp);
CREATE INDEX openscada_ae_events_json_entry_timestamp_d_idx ON openscada_ae_events_json (entry_timestamp DESC);

SELECT openscada_ae_create_index('monitorType', 'string');
SELECT openscada_ae_create_index('eventType', 'string');
SELECT openscada_ae_create_index('value', 'string');
SELECT openscada_ae_create_index('value', 'boolean');
SELECT openscada_ae_create_index('value', 'double');
SELECT openscada_ae_create_index('value', 'long');
SELECT openscada_ae_create_index('message', 'string');
SELECT openscada_ae_create_index('priority', 'long');
SELECT openscada_ae_create_index('source', 'string');
SELECT openscada_ae_create_index('actorName', 'string');
SELECT openscada_ae_create_index('actorType', 'string');
SELECT openscada_ae_create_index('severity', 'string');
SELECT openscada_ae_create_index('item', 'string');
SELECT openscada_ae_create_index('itemDescription', 'string');

