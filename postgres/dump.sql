-- Adminer 4.8.1 PostgreSQL 15.1 (Debian 15.1-1.pgdg110+1) dump

DROP TABLE IF EXISTS "client";
DROP SEQUENCE IF EXISTS client_id_seq;
CREATE SEQUENCE client_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."client" (
    "id" integer DEFAULT nextval('client_id_seq') NOT NULL,
    "name" text NOT NULL,
    "created_at" timestamp NOT NULL,
    "updated_at" timestamp DEFAULT now() NOT NULL,
    "photographer" integer NOT NULL,
    CONSTRAINT "client_photographer" UNIQUE ("photographer"),
    CONSTRAINT "client_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "client" ("id", "name", "created_at", "updated_at", "photographer") VALUES
(1,	'cliente de teste',	'2022-12-29 02:07:11.402624',	'2022-12-29 02:07:11.402624',	1);

DROP TABLE IF EXISTS "photo";
DROP SEQUENCE IF EXISTS photo_id_seq;
CREATE SEQUENCE photo_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."photo" (
    "id" integer DEFAULT nextval('photo_id_seq') NOT NULL,
    "file_name" text NOT NULL,
    "path" text NOT NULL,
    "watermark" boolean NOT NULL,
    "print" boolean NOT NULL,
    "downloaded" boolean NOT NULL,
    "created_at" timestamp DEFAULT now() NOT NULL,
    "tab" integer NOT NULL,
    CONSTRAINT "photo_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "photo_tab" UNIQUE ("tab")
) WITH (oids = false);


DROP TABLE IF EXISTS "photographer";
DROP SEQUENCE IF EXISTS photographer_id_seq;
CREATE SEQUENCE photographer_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."photographer" (
    "id" integer DEFAULT nextval('photographer_id_seq') NOT NULL,
    "name" text NOT NULL,
    "username" text NOT NULL,
    "email" text NOT NULL,
    "password" text NOT NULL,
    "subscription" integer,
    CONSTRAINT "photographer_pkey" PRIMARY KEY ("id"),
    CONSTRAINT "photographer_subscription" UNIQUE ("subscription")
) WITH (oids = false);

INSERT INTO "photographer" ("id", "name", "username", "email", "password", "subscription") VALUES
(1,	'nome de teste',	'teste',	'teste@teste.com',	'teste',	NULL);

DROP TABLE IF EXISTS "subscription";
DROP SEQUENCE IF EXISTS subscription_id_seq;
CREATE SEQUENCE subscription_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."subscription" (
    "id" integer DEFAULT nextval('subscription_id_seq') NOT NULL,
    "name" text NOT NULL,
    CONSTRAINT "subscription_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


DROP TABLE IF EXISTS "tab";
DROP SEQUENCE IF EXISTS tab_id_seq;
CREATE SEQUENCE tab_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1;

CREATE TABLE "public"."tab" (
    "id" integer DEFAULT nextval('tab_id_seq') NOT NULL,
    "name" text NOT NULL,
    "url" text,
    "locked" boolean NOT NULL,
    "password" text NOT NULL,
    "download_limit" integer,
    "watermark" boolean NOT NULL,
    "client" integer NOT NULL,
    CONSTRAINT "tab_client" UNIQUE ("client"),
    CONSTRAINT "tab_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


ALTER TABLE ONLY "public"."client" ADD CONSTRAINT "client_photographer_fkey" FOREIGN KEY (photographer) REFERENCES photographer(id) ON DELETE CASCADE NOT DEFERRABLE;

ALTER TABLE ONLY "public"."photo" ADD CONSTRAINT "photo_tab_fkey" FOREIGN KEY (tab) REFERENCES tab(id) ON DELETE CASCADE NOT DEFERRABLE;

ALTER TABLE ONLY "public"."photographer" ADD CONSTRAINT "photographer_subscription_fkey" FOREIGN KEY (subscription) REFERENCES subscription(id) ON DELETE SET NULL NOT DEFERRABLE;

ALTER TABLE ONLY "public"."tab" ADD CONSTRAINT "tab_client_fkey" FOREIGN KEY (client) REFERENCES client(id) ON DELETE CASCADE NOT DEFERRABLE;

-- 2022-12-29 02:07:56.571571+00