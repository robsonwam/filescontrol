/*
Created: 29/6/2010
Modified: 30/6/2010
Model: PostgreSQL 8.1
Database: PostgreSQL 8.1
*/



-- Create tables section -------------------------------------------------

-- Table FileSD

CREATE TABLE "FileSD"(
 "id" Serial NOT NULL,
 "name" Varchar NOT NULL,
 "arrayFile" Bytea NOT NULL
)
WITHOUT OIDS
;

-- Add keys for table FileSD

ALTER TABLE "FileSD" ADD CONSTRAINT "Key1" PRIMARY KEY ("id")
;

ALTER TABLE "FileSD" ADD CONSTRAINT "id" UNIQUE ("id")
;

-- Table Node

CREATE TABLE "Node"(
 "ip" Varchar NOT NULL,
 "port" Varchar NOT NULL
)
WITHOUT OIDS
;

-- Add keys for table Node

ALTER TABLE "Node" ADD CONSTRAINT "Key2" PRIMARY KEY ("ip","port")
;

-- Table Chunk

CREATE TABLE "Chunk"(
 "id" Serial NOT NULL,
 "fileID" Integer NOT NULL
)
WITHOUT OIDS
;

-- Add keys for table Chunk

ALTER TABLE "Chunk" ADD CONSTRAINT "Key3" PRIMARY KEY ("id","fileID")
;

-- Table Node_Chunk

CREATE TABLE "Node_Chunk"(
 "id" Integer NOT NULL,
 "fileID" Integer NOT NULL,
 "ip" Varchar NOT NULL,
 "port" Varchar NOT NULL
)
WITHOUT OIDS
;

-- Add keys for table Node_Chunk

ALTER TABLE "Node_Chunk" ADD CONSTRAINT "Key4" PRIMARY KEY ("id","fileID","ip","port")
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE "Chunk" ADD CONSTRAINT "Relationship3" FOREIGN KEY ("fileID") REFERENCES "FileSD" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Node_Chunk" ADD CONSTRAINT "Relationship4" FOREIGN KEY ("id", "fileID") REFERENCES "Chunk" ("id", "fileID") ON DELETE NO ACTION ON UPDATE NO ACTION
;

ALTER TABLE "Node_Chunk" ADD CONSTRAINT "Relationship5" FOREIGN KEY ("ip", "port") REFERENCES "Node" ("ip", "port") ON DELETE NO ACTION ON UPDATE NO ACTION
;






