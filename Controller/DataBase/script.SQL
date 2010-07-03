
-- Create tables section -------------------------------------------------

-- Table FileSD

CREATE TABLE "file_sd"(
 "id" Serial NOT NULL,
 "name" Varchar NOT NULL
)
WITHOUT OIDS
;

-- Add keys for table FileSD

ALTER TABLE "file_sd" ADD CONSTRAINT "Key1" PRIMARY KEY ("id")
;

ALTER TABLE "file_sd" ADD CONSTRAINT "id" UNIQUE ("id")
;

-- Table Node

CREATE TABLE "node"(
 "ip" Varchar NOT NULL,
 "port" Integer NOT NULL,
 "num_requisicoes" Integer NOT NULL
)
WITHOUT OIDS
;

-- Add keys for table Node

ALTER TABLE "node" ADD CONSTRAINT "Key2" PRIMARY KEY ("ip","port")
;

-- Table Chunk

CREATE TABLE "chunk"(
 "id" Serial NOT NULL,
 "file_id" Integer NOT NULL
)
WITHOUT OIDS
;

-- Add keys for table Chunk

ALTER TABLE "chunk" ADD CONSTRAINT "Key3" PRIMARY KEY ("id","file_id")
;

-- Table Node_Chunk

CREATE TABLE "node_chunk"(
 "id" Integer NOT NULL,
 "file_id" Integer NOT NULL,
 "ip" Varchar NOT NULL,
 "port" Integer NOT NULL
)
WITHOUT OIDS
;

-- Add keys for table Node_Chunk

ALTER TABLE "node_chunk" ADD CONSTRAINT "Key4" PRIMARY KEY ("id","file_id","ip","port")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "chunk" ADD CONSTRAINT "Relationship3" FOREIGN KEY ("file_id") REFERENCES "file_sd" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "node_chunk" ADD CONSTRAINT "Relationship4" FOREIGN KEY ("id", "file_id") REFERENCES "chunk" ("id", "file_id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "node_chunk" ADD CONSTRAINT "Relationship5" FOREIGN KEY ("ip", "port") REFERENCES "node" ("ip", "port") ON DELETE NO ACTION ON UPDATE NO ACTION
;






