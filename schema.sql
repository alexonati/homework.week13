-- Database: siit10

-- DROP DATABASE siit10;

CREATE DATABASE siit10
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.accomodation

-- DROP TABLE public.accomodation;

CREATE TABLE public.accomodation
(
    id integer NOT NULL DEFAULT nextval('accomodation_id_seq'::regclass),
    type character varying(32) COLLATE pg_catalog."default" NOT NULL,
    bed_type character varying(32) COLLATE pg_catalog."default" NOT NULL,
    max_guests integer NOT NULL,
    description character varying(512) COLLATE pg_catalog."default",
    CONSTRAINT accomodation_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.accomodation
    OWNER to postgres;

-- Table: public.accomodation_fair_relation

-- DROP TABLE public.accomodation_fair_relation;

CREATE TABLE public.accomodation_fair_relation
(
    id integer NOT NULL DEFAULT nextval('accomodation_fair_relation_id_seq'::regclass),
    id_acomodation integer NOT NULL DEFAULT nextval('accomodation_fair_relation_id_acomodation_seq'::regclass),
    id_room_fair integer NOT NULL DEFAULT nextval('accomodation_fair_relation_id_room_fair_seq'::regclass),
    CONSTRAINT accomodation_fair_relation_pkey PRIMARY KEY (id),
    CONSTRAINT accomodation_fair_relation_id_acomodation_fkey FOREIGN KEY (id_acomodation)
        REFERENCES public.accomodation (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT accomodation_fair_relation_id_room_fair_fkey FOREIGN KEY (id_room_fair)
        REFERENCES public.room_fair (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.accomodation_fair_relation
    OWNER to postgres;

-- Table: public.room_fair

-- DROP TABLE public.room_fair;

CREATE TABLE public.room_fair
(
    id integer NOT NULL DEFAULT nextval('room_fair_id_seq'::regclass),
    season character varying COLLATE pg_catalog."default" NOT NULL,
    price numeric NOT NULL,
    CONSTRAINT room_fair_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.room_fair
    OWNER to postgres;