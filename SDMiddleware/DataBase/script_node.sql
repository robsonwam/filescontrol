
-- Create tables section -------------------------------------------------

-- Table Chunk

CREATE TABLE "chunk"(
 "id" Serial NOT NULL,
 "file_id" Integer NOT NULL,
 "stream" Bytea NOT NULL
)
WITHOUT OIDS
;

-- Add keys for table Chunk

ALTER TABLE "chunk" ADD CONSTRAINT "Key3" PRIMARY KEY ("id")
;






