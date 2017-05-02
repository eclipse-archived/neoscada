-- DROP TABLE eclipsescada_ds;

CREATE TABLE eclipsescada_ds
(
  instance_id                  VARCHAR(255) NOT NULL,
  node_id                      VARCHAR(512) NOT NULL,
  data                         VARCHAR(4000),
  sequence_nr                  INTEGER NOT NULL,
  CONSTRAINT eclipsescada_ds_pkey PRIMARY KEY (instance_id , node_id , sequence_nr )
);

CREATE INDEX eclipsescada_ds_idx_1 ON eclipsescada_ds (instance_id);
CREATE INDEX eclipsescada_ds_idx_2 ON eclipsescada_ds (node_id, instance_id);
CREATE INDEX eclipsescada_ds_idx_3 ON eclipsescada_ds (instance_id, sequence_nr);
CREATE INDEX eclipsescada_ds_idx_4 ON eclipsescada_ds (node_id, instance_id, sequence_nr);

-- ALTER TABLE eclipsescada_ds OWNER TO eclipsescada;
