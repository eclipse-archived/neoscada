-- DROP TABLE openscada_ca;

CREATE TABLE openscada_ca
(
  instance_id                  VARCHAR(255) NOT NULL,
  factory_id                   VARCHAR(255) NOT NULL,
  configuration_id             VARCHAR(255) NOT NULL,
  ca_key                       VARCHAR(512) NOT NULL,
  ca_value                     VARCHAR(4000),
  chunk_seq                    INTEGER NOT NULL,
  CONSTRAINT openscada_ca_pkey PRIMARY KEY (instance_id , factory_id , configuration_id , ca_key , chunk_seq )
);

CREATE INDEX openscada_ca_idx_1 ON openscada_ca (instance_id);
CREATE INDEX openscada_ca_idx_2 ON openscada_ca (instance_id, factory_id);
CREATE INDEX openscada_ca_idx_3 ON openscada_ca (instance_id, factory_id, configuration_id);
CREATE INDEX openscada_ca_idx_4 ON openscada_ca (instance_id, factory_id, configuration_id, ca_key);

-- ALTER TABLE openscada_ca OWNER TO openscada;
