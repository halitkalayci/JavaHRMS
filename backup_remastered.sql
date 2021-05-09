--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-09 19:25:02

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

DROP DATABASE "HRMS";
--
-- TOC entry 3030 (class 1262 OID 17377)
-- Name: HRMS; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "HRMS" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';


ALTER DATABASE "HRMS" OWNER TO postgres;

\connect "HRMS"

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

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 17378)
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    "UserId" integer NOT NULL,
    "FirstName" character varying(50) NOT NULL,
    "LastName" character varying(50) NOT NULL,
    "NationalityId" character(11) NOT NULL,
    "BirthOfDate" date NOT NULL
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 17381)
-- Name: employers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employers (
    "UserId" integer NOT NULL,
    "CompanyName" character varying(100) NOT NULL,
    "Phone" character(12) NOT NULL,
    "VerifiedBysystem" boolean NOT NULL,
    "Website" character varying(100) NOT NULL
);


ALTER TABLE public.employers OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 17442)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 17384)
-- Name: jobpositions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jobpositions (
    "Id" integer NOT NULL,
    "PositionName" character varying NOT NULL
);


ALTER TABLE public.jobpositions OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 17390)
-- Name: jobpositions_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.jobpositions ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."jobpositions_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 204 (class 1259 OID 17392)
-- Name: systemusers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.systemusers (
    "UserId" integer NOT NULL,
    "Roles" character varying NOT NULL
);


ALTER TABLE public.systemusers OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 17398)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    "Id" integer NOT NULL,
    "Email" character varying(100) NOT NULL,
    "Password" character varying NOT NULL,
    "EmailVerified" boolean DEFAULT false NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 17405)
-- Name: users_Id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.users ALTER COLUMN "Id" ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."users_Id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3017 (class 0 OID 17378)
-- Dependencies: 200
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employees ("UserId", "FirstName", "LastName", "NationalityId", "BirthOfDate") VALUES (1, 'Halit Enes', 'KALAYCI', '12345678901', '2000-06-28');


--
-- TOC entry 3018 (class 0 OID 17381)
-- Dependencies: 201
-- Data for Name: employers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employers ("UserId", "CompanyName", "Phone", "VerifiedBysystem", "Website") VALUES (2, 'kodlamaio', '905123456789', false, 'www.kodlama.io');


--
-- TOC entry 3019 (class 0 OID 17384)
-- Dependencies: 202
-- Data for Name: jobpositions; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.jobpositions ("Id", "PositionName") OVERRIDING SYSTEM VALUE VALUES (1, 'Software Developer');


--
-- TOC entry 3021 (class 0 OID 17392)
-- Dependencies: 204
-- Data for Name: systemusers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.systemusers ("UserId", "Roles") VALUES (3, 'sysadmin');


--
-- TOC entry 3022 (class 0 OID 17398)
-- Dependencies: 205
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users ("Id", "Email", "Password", "EmailVerified") OVERRIDING SYSTEM VALUE VALUES (1, 'halitenes.kalayci@gmail.com', '1234', false);
INSERT INTO public.users ("Id", "Email", "Password", "EmailVerified") OVERRIDING SYSTEM VALUE VALUES (2, 'engindemirog@kodlama.io', '12345', false);
INSERT INTO public.users ("Id", "Email", "Password", "EmailVerified") OVERRIDING SYSTEM VALUE VALUES (3, 'denemesistem@gmail.com', '12345', true);


--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 207
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 203
-- Name: jobpositions_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."jobpositions_Id_seq"', 1, true);


--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 206
-- Name: users_Id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."users_Id_seq"', 3, true);


--
-- TOC entry 2881 (class 2606 OID 17408)
-- Name: users Email; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT "Email" UNIQUE ("Email");


--
-- TOC entry 2877 (class 2606 OID 17410)
-- Name: jobpositions Id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jobpositions
    ADD CONSTRAINT "Id" PRIMARY KEY ("Id");


--
-- TOC entry 2879 (class 2606 OID 17412)
-- Name: jobpositions PositionName; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jobpositions
    ADD CONSTRAINT "PositionName" UNIQUE ("PositionName");


--
-- TOC entry 2875 (class 2606 OID 17414)
-- Name: employees TCKN; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT "TCKN" UNIQUE ("NationalityId");


--
-- TOC entry 2883 (class 2606 OID 17416)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY ("Id");


--
-- TOC entry 2884 (class 2606 OID 17417)
-- Name: employees UserId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT "UserId" FOREIGN KEY ("UserId") REFERENCES public.users("Id");


--
-- TOC entry 2885 (class 2606 OID 17422)
-- Name: employers UserId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employers
    ADD CONSTRAINT "UserId" FOREIGN KEY ("UserId") REFERENCES public.users("Id");


--
-- TOC entry 2886 (class 2606 OID 17427)
-- Name: systemusers UserId; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.systemusers
    ADD CONSTRAINT "UserId" FOREIGN KEY ("UserId") REFERENCES public.users("Id");


-- Completed on 2021-05-09 19:25:02

--
-- PostgreSQL database dump complete
--

