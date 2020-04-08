-- Table: public.accomodation

-- DROP TABLE public.accomodation;

CREATE TABLE public.accomodation
(
    id integer NOT NULL,
    type character varying(32) COLLATE pg_catalog."default" NOT NULL,
    bed_type character varying(32) COLLATE pg_catalog."default" NOT NULL,
    max_guests integer NOT NULL,
    description character varying(512) COLLATE pg_catalog."default",
    CONSTRAINT accomodation_pkey PRIMARY KEY (id),
    CONSTRAINT accomodation_type_key UNIQUE (type)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.accomodation
    OWNER to postgres;