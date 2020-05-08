--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- Name: Bilgiler; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Bilgiler" (
    "kullaniciAdi" character varying(40) NOT NULL,
    sifre character varying(40) NOT NULL
);


ALTER TABLE public."Bilgiler" OWNER TO postgres;

--
-- Data for Name: Bilgiler; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Bilgiler" VALUES ('serhat', 'erenel');


--
-- PostgreSQL database dump complete
--

